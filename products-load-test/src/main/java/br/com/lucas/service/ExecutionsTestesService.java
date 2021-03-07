package br.com.lucas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucas.models.ExecutionsTestes;
import br.com.lucas.repository.ExecutionsTestesRepository;

@Service
public class ExecutionsTestesService {

	@Autowired
	private ExecutionsTestesRepository executionsTestesRepository;

	public ExecutionsTestes salvar(ExecutionsTestes executionsTestes) {
		return executionsTestesRepository.save(executionsTestes);
	}

	public ExecutionsTestes finById(String id) {
		return executionsTestesRepository.findById(id).orElse(new ExecutionsTestes());
	}

}
