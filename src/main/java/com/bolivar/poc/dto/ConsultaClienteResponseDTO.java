package com.bolivar.poc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ConsultaClienteResponseDTO {

	private String nombreCliente;
	private String apellidoCliente;
}
