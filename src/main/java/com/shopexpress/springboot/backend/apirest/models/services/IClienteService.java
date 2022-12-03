package com.shopexpress.springboot.backend.apirest.models.services;

import com.shopexpress.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//Service -> genra las firmas de metodo
public interface IClienteService {

    public List<Cliente> findAll();

    public Page<Cliente> findAll( Pageable pageable); //obtendra un bojeto pagieable de nuestra entity -> tiene mucha informacion del paginador

    public Cliente findById(Long id);
    public Cliente save(Cliente cliente);
    public void delete(Long id);

}
