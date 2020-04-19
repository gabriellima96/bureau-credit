package site.gabriellima.bureau.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import site.gabriellima.bureau.models.Ben;

public interface BenRepository extends MongoRepository<Ben, String> {

}