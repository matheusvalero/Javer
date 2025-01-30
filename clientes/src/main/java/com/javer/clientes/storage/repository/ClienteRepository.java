package com.javer.clientes.storage.repository;

import com.javer.clientes.storage.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}