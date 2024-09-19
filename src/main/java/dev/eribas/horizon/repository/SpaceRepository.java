package dev.eribas.horizon.repository;

import dev.eribas.horizon.model.Space;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceRepository extends ReactiveMongoRepository<Space, String> {

}