package com.shopexpress.springboot.backend.apirest.models.services;

import com.shopexpress.springboot.backend.apirest.models.dao.IClienteDao;
import com.shopexpress.springboot.backend.apirest.models.entity.Cliente;
import com.shopexpress.springboot.backend.apirest.models.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Implementa las firmas de metodo de los services
@Service //marcamos como un compoennete de servicio
public class ClienteServiceImpl implements IClienteService { //implemntar las firmas


    @Autowired
    private IClienteDao clienteDao; //inyectar el dao, esta alojada en el contexto de spring inyectable en cualquier otro componente

    @Override
    @Transactional(readOnly = true) //permite hacer transacciones en la base de datos
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll(); //retorna un iterable
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        //retorna un optional -> para un mayor control get, orElse(sino hay entregamo un nul), orTrow, isPresent(boolean)
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente); //nos retorna la entidad guardada //tambien uytil para actualizar
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.delete(findById(id));//se le pasa el Cliente completo
    }

    @Override
    public List<Region> findAllRegiones() {
        return clienteDao.findAllRegiones();
    }
}
