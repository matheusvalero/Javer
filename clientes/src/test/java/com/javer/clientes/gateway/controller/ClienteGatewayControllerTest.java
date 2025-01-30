package com.javer.clientes.gateway.controller;

import com.javer.clientes.gateway.cliente.ClienteStorageClient;
import com.javer.clientes.gateway.model.Cliente;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteGatewayController.class)
public class ClienteGatewayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteStorageClient clienteStorageClient;

    @Test
    public void testGetClienteById() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("João");
        cliente.setTelefone(123456789L);
        cliente.setCorrentista(true);
        cliente.setScoreCredito(700.0f);
        cliente.setSaldoCc(1000.0f);

        Mockito.when(clienteStorageClient.getClienteById(1L)).thenReturn(cliente);

        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk());
    }
}