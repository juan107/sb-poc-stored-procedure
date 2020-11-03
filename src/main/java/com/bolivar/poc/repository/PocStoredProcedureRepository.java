package com.bolivar.poc.repository;

import org.springframework.stereotype.Repository;

import com.bolivar.poc.dto.ProcedureParamsDTO;
import com.bolivar.poc.dto.ConsultaClienteResponseDTO;

@Repository
public interface PocStoredProcedureRepository {
	
	void consultarCliente(ProcedureParamsDTO consultaClienteRequestDTO);

}
