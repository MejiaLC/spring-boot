package com.taller.dos.commands.infrastructure.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSalesDto {

	@NotNull(message = "El campo states debe ser obligatorio")
	private String states;
}
