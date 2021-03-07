package br.com.lucas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucas.enums.StatusTesteEnum;
import br.com.lucas.models.ExecutionsTestes;
import br.com.lucas.models.ResultTeste;
import br.com.lucas.models.response.StatsResponse;
import br.com.lucas.service.ExecutionsTestesService;
import br.com.lucas.service.InitializeTesteThread;
import br.com.lucas.service.ProductService;
import br.com.lucas.service.ResultTesteService;

@RestController
public class TestResource {

	@Autowired
	private ProductService productService;

	@Autowired
	private ExecutionsTestesService executionsTestesService;

	@Autowired
	private ResultTesteService resultTesteService;

	@PostMapping(value = "/test/init")
	private ResponseEntity<ExecutionsTestes> initTeste(@RequestParam("qtdExecucoes") Integer qtdExecucoes) {
		ExecutionsTestes executionsTestesSaved = executionsTestesService.salvar(ExecutionsTestes.builder()
				.pathTeste("/products").status(StatusTesteEnum.INICIADO.name()).horaInicio(new Date()).build());
		new Thread(new InitializeTesteThread(productService, executionsTestesSaved, executionsTestesService, qtdExecucoes)).start();
		return new ResponseEntity<>(executionsTestesSaved, HttpStatus.OK);
	}

	@GetMapping(value = "/execution")
	private ResponseEntity<ExecutionsTestes> findById(@RequestParam("id") String id) {
		ExecutionsTestes executionsTestes = executionsTestesService.finById(id);
		return new ResponseEntity<>(executionsTestes, HttpStatus.OK);

	}

	@GetMapping(value = "/results")
	private ResponseEntity<List<ResultTeste>> findResultByExecution(@RequestParam("idExecution") String idExecution) {
		return new ResponseEntity<>(resultTesteService.findResultByExecution(idExecution), HttpStatus.OK);

	}
	
	@GetMapping(value = "/stats")
	private ResponseEntity<StatsResponse> stats(@RequestParam("idExecution") String idExecution) {
		return new ResponseEntity<>(resultTesteService.stats(idExecution), HttpStatus.OK);

	}
}
