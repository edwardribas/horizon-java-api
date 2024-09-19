package dev.eribas.horizon.service.impl;

import dev.eribas.horizon.model.Space;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SpaceServiceImpl {

    Mono<Space> getById(String id);

    Mono<Space> insert(Space space);

    Mono<Space> update(Space space);

    Mono<Void> deleteById(String id);

    Flux<Space> getAll();

}