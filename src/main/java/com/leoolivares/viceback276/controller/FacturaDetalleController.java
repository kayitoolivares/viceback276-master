package com.leoolivares.viceback276.controller;

import com.leoolivares.viceback276.entity.Facturadetalle;
import com.leoolivares.viceback276.entity.Producto;
import com.leoolivares.viceback276.service.IFacturaService;
import com.leoolivares.viceback276.service.IFacturadetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facturadetalle")
@CrossOrigin(origins = "*")
public class FacturaDetalleController {

    @Autowired
    IFacturadetalleService service;
    @GetMapping(value = "/")
    ResponseEntity<?> get(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping(value = "/byID/{id}")
    ResponseEntity<?> getByID(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping(value = "/")
    ResponseEntity<?> getByID(@RequestBody Facturadetalle facturadetalle){
        return ResponseEntity.ok(service.save(facturadetalle));
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
