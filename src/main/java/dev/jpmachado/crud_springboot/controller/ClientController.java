package dev.jpmachado.crud_springboot.controller;

import dev.jpmachado.crud_springboot.model.entity.Client;
import dev.jpmachado.crud_springboot.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping("clients")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("client/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findById(@PathVariable Integer id) {
        return clientService.findById(id);
    }

    @PostMapping("client")
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("client/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@PathVariable Integer id, @RequestBody Client client) {
        client.setId(id);
        return clientService.save(client);
    }

    @DeleteMapping("client/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Client client = clientService.findById(id);
        clientService.delete(client);
    }
}
