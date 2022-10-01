package com.example.mscuenta.controller;

import com.example.mscuenta.models.Cuenta;
import com.example.mscuenta.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService service;

    @GetMapping
    public ResponseEntity<List<Cuenta>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Cuenta> create(@RequestBody Cuenta cuenta) {

        Cuenta cuentaDB = service.create(cuenta);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cuentaDB.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Cuenta> update(@RequestBody Cuenta cuenta) {
        return (service.findById(cuenta.getId()) == null)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(service.update(cuenta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
