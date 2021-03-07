package br.com.lucas.service;

import java.util.Date;

import br.com.lucas.enums.StatusTesteEnum;
import br.com.lucas.models.ExecutionsTestes;
import br.com.lucas.models.ProductsResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitializeTesteThread implements Runnable {

	private Integer qtdExecucoes;

	private ProductService productService;
	private ExecutionsTestes executionsTestes;
	private ExecutionsTestesService executionsTestesService;

	public InitializeTesteThread(ProductService productService, ExecutionsTestes executionsTestes,
			ExecutionsTestesService executionsTestesService, Integer qtdExecucoes) {
		this.productService = productService;
		this.executionsTestes = executionsTestes;
		this.executionsTestesService = executionsTestesService;
		this.qtdExecucoes = qtdExecucoes;
	}

	@Override
	public void run() {
		for (int i = 0; i < qtdExecucoes; i++) {
			ProductsResponseDTO response = productService.getProducts(executionsTestes.getId());
			log.info(response.toString());
		}

		executionsTestes.setStatus(StatusTesteEnum.FINALIZADO.name());
		executionsTestes.setHoraFim(new Date());

		executionsTestesService.salvar(executionsTestes);
	}
}
