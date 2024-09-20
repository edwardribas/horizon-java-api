package dev.eribas.horizon.service;

import dev.eribas.horizon.domain.Space;
import dev.eribas.horizon.request.UpdateSpaceRequest;
import dev.eribas.horizon.response.GetSpaceResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SpaceService {

    Mono<GetSpaceResponse> getSpace(String id);

    Mono<GetSpaceResponse> createSpace(String name);

    Mono<Void> updateSpace(UpdateSpaceRequest request);

    Mono<Void> deleteSpace(String id);

    Flux<GetSpaceResponse> getSpaces();

}