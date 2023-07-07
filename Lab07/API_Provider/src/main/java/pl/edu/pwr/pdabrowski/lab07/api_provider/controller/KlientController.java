package pl.edu.pwr.pdabrowski.lab07.api_provider.controller;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.pdabrowski.lab07.api_provider.service.KlientService;

@RestController
@RequiredArgsConstructor
public class KlientController {
    private final KlientService clientService;

    @ApiOperation("Pobranie wszystkich uzytkownikow")
    @GetMapping("/clients")
    public String getClients(){
        return clientService.getAllClients();
    }

    @ApiOperation("Pobranie uzytkownika o podanym id")
    @GetMapping("/clients/id")
    public String getSingleClientById(@RequestParam long id){
        return clientService.getSingleClient(id).toString();
    }
    @ApiOperation("Dodanie nowego uzytkownika")
    @PostMapping("/clients")
    public String addClient(@RequestParam String name, @RequestParam String lastName) throws Exception {
        clientService.addNewClient(name, lastName);
        return "Success";
    }
    @ApiOperation("Aktualizacja danych uzytkownika id")
    @PutMapping("/clients/update")
    public String updateClient(@RequestParam String name, @RequestParam String lastName, @RequestParam long id){
        return clientService.updateClientData(name,lastName, id);
    }
    @ApiOperation("Usuniecie o podanym id")
    @DeleteMapping("/clients")
    public String deleteClient(@RequestParam Long id){
        clientService.deleteClient(id);
        return "Succesfully deleted user with id: " + id;
    }
}
