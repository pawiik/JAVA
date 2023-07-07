package pl.edu.pwr.pdabrowski.lab07.api_provider.service;

import org.springframework.stereotype.Service;
import pl.edu.pwr.pdabrowski.lab07.api_provider.ApiProviderApplication;
import pl.edu.pwr.pdabrowski.lab07.api_provider.model.Klient;

import java.util.List;

@Service
public class KlientService {

    public String getAllClients(){
        List<Klient> clients = ApiProviderApplication.hibernateUtil.listClients();
        return clients.toString();
    }

    public void addNewClient(String name, String lastName) throws Exception {
        ApiProviderApplication.hibernateUtil.saveClient(name, lastName);
    }

    public void deleteClient(long id){
        ApiProviderApplication.hibernateUtil.deleteClient(id);
    }

    public Klient getSingleClient(Long id){
       return ApiProviderApplication.hibernateUtil.getSingleClient(id);
    }
    public String updateClientData(String name, String lastName, long id){
        ApiProviderApplication.hibernateUtil.modifyClient(name, lastName, id);
        return "Succesfully updated client data";
    }
}
