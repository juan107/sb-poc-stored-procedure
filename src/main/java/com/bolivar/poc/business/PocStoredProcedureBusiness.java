package com.bolivar.poc.business;

import com.bolivar.poc.dto.ConsultaClienteResponseDTO;

public interface PocStoredProcedureBusiness {
	
	ConsultaClienteResponseDTO consultarCliente(String tipoDocumento, String numeroDocumento);

}
