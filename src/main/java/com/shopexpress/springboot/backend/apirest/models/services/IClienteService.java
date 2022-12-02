package com.shopexpress.springboot.backend.apirest.models.services;

import com.shopexpress.springboot.backend.apirest.models.entity.Cliente;

import java.util.List;

//Service -> genra las firmas de metodo
public interface IClienteService {

    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public Cliente save(Cliente cliente);
    public void delete(Long id);

}
