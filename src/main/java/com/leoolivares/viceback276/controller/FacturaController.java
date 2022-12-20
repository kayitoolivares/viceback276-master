package com.leoolivares.viceback276.controller;

import com.leoolivares.viceback276.entity.Cliente;
import com.leoolivares.viceback276.entity.Factura;
import com.leoolivares.viceback276.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    IFacturaService service;

    @GetMapping(value = "/")
    ResponseEntity<?> get(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/byID/{id}")
    ResponseEntity<?> getByID(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping(value = "/byCliente/{id}")
    ResponseEntity<?> getByIDCliente(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getAllByCliente(id));
    }
    @GetMapping(value = "/byUsuario/{id}")
    ResponseEntity<?> getByIDUsuario(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getAllByUsuario(id));
    }

    @GetMapping(value = "/afectar/{id}")
    ResponseEntity<?> afectar(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.Afectar(id));
    }

    @PostMapping(value = "/")
    ResponseEntity<?> getByID(@RequestBody Factura factura){
        return ResponseEntity.ok(service.save(factura));
    }


    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.delete(id));
    }


}
