package project.reto345.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.reto345.model.Client;
import project.reto345.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/All*")
    public List<Client> getClients(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id) {
        return clientService.getClient(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }
    @PutMapping("/update")
    public Client update(@RequestBody Client client) {
        return clientService.update(client);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return clientService.delete(id);
    }
}
