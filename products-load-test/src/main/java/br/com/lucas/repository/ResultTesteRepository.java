package br.com.lucas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lucas.models.ResultTeste;

public interface ResultTesteRepository extends MongoRepository<ResultTeste, String> {

	List<ResultTeste> findAllByIdExecution(String idExecution);

}
