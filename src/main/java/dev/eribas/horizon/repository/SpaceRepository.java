package dev.eribas.horizon.repository;

import dev.eribas.horizon.domain.Space;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SpaceRepository extends ReactiveMongoRepository<Space, String> {

    @Update("{ 'name': ?1 }")
    @Query("{ '_id': ObjectId(?0) }")
    Mono<Void> updateNameById(String id, String name);

}