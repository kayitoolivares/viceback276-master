package com.leoolivares.viceback276.controller;

import com.leoolivares.viceback276.entity.Cliente;
import com.leoolivares.viceback276.service.IClienteService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    IClienteService service;

    @GetMapping(value = "/")
    ResponseEntity<?> get(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping(value = "/byID/{id}")
    ResponseEntity<?> getByID(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping(value = "/")
    ResponseEntity<?> getByID(@RequestBody Cliente cliente){
        return ResponseEntity.ok(service.save(cliente));
    }


    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
