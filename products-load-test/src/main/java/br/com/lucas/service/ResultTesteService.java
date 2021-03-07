package br.com.lucas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.models.ResultTeste;
import br.com.lucas.models.response.StatsResponse;
import br.com.lucas.repository.ResultTesteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResultTesteService {

	@Autowired
	private ResultTesteRepository resultTesteRepository;

	public List<ResultTeste> findResultByExecution(String idExecution) {
		return resultTesteRepository.findAllByIdExecution(idExecution);
	}

	public StatsResponse stats(String idExecution) {

		Integer qtdSucesso = 0;
		Integer qtdErros = 0;
		Long somaDuracao = 0L;

		List<ResultTeste> listResultTeste = resultTesteRepository.findAllByIdExecution(idExecution);

		for (ResultTeste resultTeste : listResultTeste) {

			somaDuracao = somaDuracao + resultTeste.getDuracao();

			if (resultTeste.getResultStatus() == 200) {
				qtdSucesso = qtdSucesso + 1;
			} else if (resultTeste.getResultStatus() != 200) {
				qtdErros = qtdErros + 1;
			}
		}

		log.info("Total Duracao todas requisições: " + String.valueOf(somaDuracao));
		log.info("Média Duracao todas requisições: " + somaDuracao / listResultTeste.size());

		return StatsResponse.builder().qtdTotalReq(listResultTeste.size()).qtdSucesso(qtdSucesso).qtdErros(qtdErros)
				.mediaLatenciaTotalReq(somaDuracao / listResultTeste.size()).build();
	}

}
