package com.example.mscuenta.controller;

import com.example.mscuenta.models.Cuenta;
import com.example.mscuenta.service.CuentaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@WebMvcTest(CuentaController.class)
class CuentaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CuentaService service;

    @Test
    void findAllTest() throws Exception {

        Mockito.when(service.findAll()).thenReturn(getListCuentas());

        mockMvc.perform(MockMvcRequestBuilders.get("/cuentas").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].numeroCuenta").value("235634"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].numeroCuenta").value("425654"));

        Mockito.verify(service).findAll();

    }

    @Test
    void create() throws Exception {

        Mockito.when(service.create(Mockito.any()))
                .thenReturn(getCuenta(1L, "354645", "corriente", new BigDecimal(546)));

        mockMvc.perform(MockMvcRequestBuilders.post("/cuentas").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getCuenta(1L, "45464", "corriente", new BigDecimal(1000)))))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        Mockito.verify(service).create(Mockito.any());

    }


    private List<Cuenta> getListCuentas() {
        List<Cuenta> clienteList = new ArrayList<>();

        clienteList.add(getCuenta(1L, "235634", "corriente", new BigDecimal(4000)));
        clienteList.add(getCuenta(2L, "425654", "corriente", new BigDecimal(2000)));

        return clienteList;
    }

    private Cuenta getCuenta(Long id, String numeroCuenta, String tipoCuenta, BigDecimal saldoInicial) {
        Cuenta cuenta = new Cuenta();

        cuenta.setId(id);
        cuenta.setNumeroCuenta(numeroCuenta);
        cuenta.setTipoCuenta(tipoCuenta);
        cuenta.setSaldoInicial(saldoInicial);

        return cuenta;
    }

}