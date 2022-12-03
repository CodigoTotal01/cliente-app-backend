package com.shopexpress.springboot.backend.apirest.models.dao;

import com.shopexpress.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


//para crud normal-> CrudRepository<Cliente,Long
// para paginacion -> JpaRepository (iterable, page)

//?Extiende de un servicio que facilita realizar CRUD -> nombre entidad y el tipo de dato del id
public interface IClienteDao extends JpaRepository<Cliente,Long> {}
//! implmentandolo tenemos un bean
