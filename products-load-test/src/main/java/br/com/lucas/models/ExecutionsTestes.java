package br.com.lucas.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ExecutionsTestes")
public class ExecutionsTestes {
	
	@Id
	private String id;
	private String pathTeste;
	private Date horaInicio;
	private String status;
	private Date horaFim;
}
