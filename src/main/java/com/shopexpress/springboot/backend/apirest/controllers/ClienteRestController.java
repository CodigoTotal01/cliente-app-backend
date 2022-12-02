package com.shopexpress.springboot.backend.apirest.controllers;

import com.shopexpress.springboot.backend.apirest.models.entity.Cliente;
import com.shopexpress.springboot.backend.apirest.models.services.IClienteService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> show(@PathVariable Long id){ // tomar el param        //!si ocurre error -> no se envia el cliente

        Cliente cliente  = null;

        Map<String, Object> response = new HashMap<>(); // implementacion de un mapa

        try {
            cliente  = clienteService.findById((id));
        }catch (DataAccessException e){
                response.put("mensaje", "Error al realizar la consulta a la base de datos");
                response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR); //responseentityy para entragar una respuesta meojor formateada
        }
        if(cliente == null){
            response.put("mensaje", "El cliente ID".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND); //responseentityy para entragar una respuesta meojor formateada
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK); //200 le indicamos el tipo de dato a retornar
    }

    //?añadir cliente
    @PostMapping("/clientes")
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result){  //interceptar las validaciones y también le pasamos los errores
        //se le envia la informacion json por el body

        Cliente clienteNew = null;
        Map<String, Object> response = new HashMap<>();

        //si tiene errores @valid
        if(result.hasErrors()){
            //convertir los mensajes de eerorres en una lista
            //! optimizar con programacion funcioanl
//            List<String> errors = new ArrayList<>();
//            for(FieldError err: result.getFieldErrors() ){
//                errors.add("El campo " +err.getField() + " -> "  + err.getDefaultMessage());
//            }

            List<String> errors  =result.getFieldErrors().stream().map(e ->"El campo " +e.getField() + " -> "  + e.getDefaultMessage()).collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            clienteNew = clienteService.save(cliente); //retorna el cliente
        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la insersion del usuario a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //puedes volver a usar el response map cundo todo sale bien
        response.put("mensaje", "El cliente fue ingresado con exito");
        response.put("cliente", clienteNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //?actualizar -> put -> update base data
    @PutMapping("clientes/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id){ //antes de los para,etros el binding resuilt
        Cliente clienteActual = clienteService.findById(id); // obtenemos al cliente actual por medio del id,         //resetear valores

        Cliente clienteUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors  =result.getFieldErrors().stream().map(e ->"El campo " +e.getField() + " -> "  + e.getDefaultMessage()).collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(clienteActual == null){
            response.put("mensaje", "El cliente ID".concat(id.toString().concat(" no se pudo actualizar")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND); //responseentityy para entragar una respuesta meojor formateada
        }

        try {
            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setEmail(cliente.getEmail());
            clienteActual.setCreateAt(new Date());
            clienteUpdate = clienteService.save(clienteActual);

        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la actualzizaccion del usuario a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente fue actualizado con exito");
        response.put("cliente", clienteUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);        //metodo save -> para intser y update si el id es null o nada, pero cuando esta taclado al contexto de persistencia y parte tiene un id hara un merth
    }

    //? Eliminar un cliente

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //*204
    public ResponseEntity<?> delete(@PathVariable Long id){


        Map<String, Object> response = new HashMap<>();
        try{
            clienteService.delete(id);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la eliminacion del usuario a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente fue eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);        //metodo

    }

}
