package com.example.mscuenta.service;

import com.example.mscuenta.dto.ClienteDto;
import com.example.mscuenta.models.Cuenta;
import com.example.mscuenta.repo.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepository repository;

    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl = "http://localhost:8080/clientes";

    @Override
    public List<Cuenta> findAll() {
        return repository.findAll();
    }

    @Override
    public Cuenta findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cuenta findByNumeroCuenta(String numeroCuenta) {
        return repository.findByNumeroCuenta(numeroCuenta);
    }

    @Override
    public Cuenta create(Cuenta cuenta) {
        ResponseEntity<ClienteDto> response = restTemplate.getForEntity(resourceUrl + "/{id}",
                ClienteDto.class, cuenta.getIdCliente());
        cuenta.setCliente((response.getBody() != null) ? response.getBody().getNombre() : "");
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
