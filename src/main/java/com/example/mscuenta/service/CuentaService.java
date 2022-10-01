package com.example.mscuenta.service;

import com.example.mscuenta.models.Cuenta;

import java.util.List;

public interface CuentaService {

    List<Cuenta> findAll();
    Cuenta findById(Long id);
    Cuenta findByNumeroCuenta(String numeroCuenta);
    Cuenta create(Cuenta cuenta);
    Cuenta update(Cuenta cuenta);
    void delete(Long id);

}
