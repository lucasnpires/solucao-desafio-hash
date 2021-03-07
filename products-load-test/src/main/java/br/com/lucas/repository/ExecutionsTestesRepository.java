package br.com.lucas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.lucas.models.ExecutionsTestes;

public interface ExecutionsTestesRepository extends MongoRepository<ExecutionsTestes, String> {
}
