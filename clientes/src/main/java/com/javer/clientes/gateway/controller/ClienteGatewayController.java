package com.javer.clientes.gateway.controller;

import com.javer.clientes.gateway.cliente.ClienteStorageClient;
import com.javer.clientes.gateway.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteGatewayController {

    @Autowired
    private ClienteStorageClient clienteStorageClient;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteStorageClient.getAllClientes();
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteStorageClient.getClienteById(id);
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteStorageClient.createCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteStorageClient.updateCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteStorageClient.deleteCliente(id);
    }

    @GetMapping("/{id}/score")
    public Float calculateScore(@PathVariable Long id) {
        Cliente cliente = clienteStorageClient.getClienteById(id);
        if (cliente != null) {
            return cliente.getSaldoCc() * 0.1f;
        }
        return null;
    }
}
