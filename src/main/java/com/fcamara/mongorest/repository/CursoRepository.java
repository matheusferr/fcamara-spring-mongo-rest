package com.fcamara.mongorest.repository;

import com.fcamara.mongorest.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {
    Optional<Curso> findByNome(String nome);
}
