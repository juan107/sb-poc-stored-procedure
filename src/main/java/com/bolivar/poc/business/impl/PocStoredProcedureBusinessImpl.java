package com.bolivar.poc.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.poc.business.PocStoredProcedureBusiness;
import com.bolivar.poc.dto.ProcedureParamsDTO;
import com.bolivar.poc.dto.ConsultaClienteResponseDTO;
import com.bolivar.poc.repository.PocStoredProcedureRepository;

@Service
public class PocStoredProcedureBusinessImpl implements PocStoredProcedureBusiness {
	
	@Autowired
	private PocStoredProcedureRepository pocStoredProcedureRepository;

	@Override
	public ConsultaClienteResponseDTO consultarCliente(String tipoDocumento, String numeroDocumento) {
		ProcedureParamsDTO resultParams = ProcedureParamsDTO.builder().tipoDocumento(tipoDocumento).
				numeroDocumento(numeroDocumento).build();
		pocStoredProcedureRepository.consultarCliente(resultParams);
		return ConsultaClienteResponseDTO.builder().apellidoCliente(resultParams.getApellidoCliente())
				.nombreCliente(resultParams.getNombreCliente()).build();
	}
}
