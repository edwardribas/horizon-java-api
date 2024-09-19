package dev.eribas.horizon.service;

import dev.eribas.horizon.model.Space;
import dev.eribas.horizon.repository.SpaceRepository;
import dev.eribas.horizon.service.impl.SpaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SpaceService implements SpaceServiceImpl {

    @Autowired
    SpaceRepository spaceRepository;

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<Space> getById(String id) {
        return spaceRepository.findById(id);
    }

    public Mono<Space> insert(Space space) {
        return spaceRepository.insert(space);
    }

    public Mono<Space> update(Space space) {
        Query query = new Query(Criteria.where("_id").is(space.id));
        Update update = new Update().set("name", space.name);

        return reactiveMongoTemplate.updateFirst(query, update, Space.class)
                .flatMap(updateResult -> {
                    if (updateResult.getMatchedCount() == 0) return Mono.empty();
                    return reactiveMongoTemplate.findById(space.id, Space.class);
                });
    }

    public Mono<Void> deleteById(String id) {
        return spaceRepository.deleteById(id);
    }

    public Flux<Space> getAll() {
        return spaceRepository.findAll();
    }

}