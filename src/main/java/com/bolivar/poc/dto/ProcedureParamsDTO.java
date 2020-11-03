package com.bolivar.poc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProcedureParamsDTO {

	private String tipoDocumento;
	private String numeroDocumento;
	private String nombreCliente;
	private String apellidoCliente;
}
