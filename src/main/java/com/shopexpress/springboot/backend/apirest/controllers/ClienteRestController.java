package com.shopexpress.springboot.backend.apirest.controllers;

import com.shopexpress.springboot.backend.apirest.models.entity.Cliente;
import com.shopexpress.springboot.backend.apirest.models.services.IClienteService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"}) //inidcamos a que host le damso permiso se puede poner otras limitaciones
@RestController //! es un rest controllr no es un controllador normal
@RequestMapping("/api") // ruta url
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService; //autowired buscara el primer candidato
    //?mostrar clientes
    @GetMapping("/clientes")//indicar la ruta para el llmado del metodo para el endpoint
    public List<Cliente> index(){
        return clienteService.findAll(); //cuando se envia se obtiene como json
    }



    //?mostrar un  cliente
    @GetMapping("clientes/{id}") //indicando pamar
    @ResponseStatus(HttpStatus.OK) //* 200 asignado por defecto
    public Cliente show(@PathVariable Long id){ // tomar el param
        return clienteService.findById(id);
    }

    //?añadir cliente
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED) //*201
    public Cliente create(@RequestBody Cliente cliente){ //se le enbia la informacion json por el body
        return clienteService.save(cliente);
    }

    //?actualizar -> put -> update base data
    @PutMapping("clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED) //*201
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clienteActual = clienteService.findById(id); // obtenemos al cliente actual por medio del id,         //resetear valores
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setEmail(cliente.getEmail());
        return clienteService.save(clienteActual);        //metodo save -> para intser y update si el id es null o nada, pero cuando esta taclado al contexto de persistencia y parte tiene un id hara un merth
    }

    //?Eliminar un cliente

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //*204
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }

}
