package com.shopexpress.springboot.backend.apirest.models.dao;

import com.shopexpress.springboot.backend.apirest.models.entity.Cliente;
import com.shopexpress.springboot.backend.apirest.models.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//para crud normal-> CrudRepository<Cliente,Long
// para paginacion -> JpaRepository (iterable, page)
//! implmentandolo tenemos un bean
//?Extiende de un servicio que facilita realizar CRUD -> nombre entidad y el tipo de dato del id
public interface IClienteDao extends JpaRepository<Cliente,Long> {
    //consulta por el lazy →
    @Query("from Region")//mapar al metodo una consulta -> JPA
    public List<Region> findAllRegiones();
}

