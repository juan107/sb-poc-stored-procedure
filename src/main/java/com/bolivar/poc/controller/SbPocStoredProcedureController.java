package com.bolivar.poc.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bolivar.poc.business.PocStoredProcedureBusiness;
import com.bolivar.poc.dto.ConsultaClienteResponseDTO;


@RestController
public class SbPocStoredProcedureController {
	
	@Autowired
	private PocStoredProcedureBusiness pocStoredProcedureBusiness;
	
	@GetMapping(value = "/cliente/{tipoDocumento}/{numeroDocumento}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ConsultaClienteResponseDTO consultarCliente(
			@Validated @PathVariable String tipoDocumento, @PathVariable String numeroDocumento) throws IOException {
		return pocStoredProcedureBusiness.consultarCliente(tipoDocumento, numeroDocumento);
	}
}
