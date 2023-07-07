package pl.edu.pwr.pdabrowski.lab07.api_provider.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.edu.pwr.pdabrowski.lab07.api_provider.model.*;

import java.util.Date;
import java.util.List;

public class HibernateUtil {

    private SessionFactory sessionFactory;


    public void setUp() throws Exception{

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try{
            this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            System.out.println("Sukces");
        }
        catch (Exception e){
            StandardServiceRegistryBuilder.destroy(registry);
            System.out.println("Fail");
        }
    }
    public List<Klient> listClients(){
        Session session = this.sessionFactory.openSession();
        List<Klient> klienci = session.createQuery("from Klient", Klient.class).list();
        return klienci;
    }

    protected List<Instalacja> listInstalations(){
        Session session = this.sessionFactory.openSession();
        List<Instalacja> instalations = session.createQuery("from Instalacja ", Instalacja.class).list();
        return instalations;
    }

    protected List<Cennik> listPrices(){
        Session session = this.sessionFactory.openSession();
        List<Cennik> prices = session.createQuery("from Cennik ", Cennik.class).list();
        return prices;
    }

    protected List<NaliczenieNaleznosci> listPayments(){
        Session session = this.sessionFactory.openSession();
        List<NaliczenieNaleznosci> payments = session.createQuery("from NaliczenieNaleznosci ", NaliczenieNaleznosci.class).list();
        return payments;
    }

    protected List<DokonanieWplaty> listDonePayments(){
        Session session = this.sessionFactory.openSession();
        List<DokonanieWplaty> donePayments = session.createQuery("from DokonanieWplaty ", DokonanieWplaty.class).list();
        return donePayments;
    }

    public void saveClient(String imie, String nazwisko)throws Exception{
        Klient klient = new Klient(imie, nazwisko);
        try (Session session = this.sessionFactory.openSession()){
            session.beginTransaction();

            session.persist(klient);

            session.getTransaction().commit();
        }
    }


    public void modifyClient(String imie, String nazwisko, Long id){
        Session session = sessionFactory.openSession();


        Klient client = session.get(Klient.class, id);

        client.setImie(imie);
        client.setNazwisko(nazwisko);

        Transaction tx = session.beginTransaction();
        session.update(client);
        tx.commit();

        session.close();
    }

    public void deleteClient(Long id){
        Session session = this.sessionFactory.openSession();
        Klient klient = session.get(Klient.class, id);

        Transaction tx = session.beginTransaction();
        session.delete(klient);

        tx.commit();
        session.close();
    }
    protected void saveInstalation(String adres, String typ, Klient klient)throws Exception{
        Instalacja instalacja = new Instalacja(adres, typ, klient);
        try (Session session = this.sessionFactory.openSession()){
            session.beginTransaction();

            session.persist(instalacja);

            session.getTransaction().commit();
        }
    }

    public Klient getSingleClient(Long id){
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();

            Klient client = session.get(Klient.class, id);

            session.close();
            return client;
        }
    }
}
