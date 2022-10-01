package com.example.mscuenta.repo;

import com.example.mscuenta.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    Cuenta findByNumeroCuenta(String numeroCuenta);
}
