package br.com.lucas.models.response;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Data
@Getter
@Setter
@Builder
public class StatsResponse {
	
	private Integer qtdTotalReq;
	private Integer qtdSucesso;
	private Integer qtdErros;
	private Long mediaLatenciaTotalReq;

}
