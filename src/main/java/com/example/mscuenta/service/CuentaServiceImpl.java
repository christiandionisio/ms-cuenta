package com.example.mscuenta.service;

import com.example.mscuenta.models.Cuenta;
import com.example.mscuenta.repo.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepository repository;


    @Override
    public List<Cuenta> findAll() {
        return repository.findAll();
    }

    @Override
    public Cuenta findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cuenta create(Cuenta cuenta) {
        return repository.save(cuenta);
    }

    @Override
    public Cuenta update(Cuenta cuenta) {
        return repository.save(cuenta);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
