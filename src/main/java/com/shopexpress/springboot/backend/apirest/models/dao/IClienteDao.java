package com.shopexpress.springboot.backend.apirest.models.dao;

import com.shopexpress.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;


//no util para paginacion -> CrudRepository<Cliente,Long

//?Extiende de un servicio que facilita realizar CRUD -> nombre entidad y el tipo de dato del id
public interface IClienteDao extends CrudRepository<Cliente,Long> {}
//! implmentandolo tenemos un bean
