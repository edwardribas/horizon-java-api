package dev.eribas.horizon.service.impl;

import dev.eribas.horizon.domain.Space;
import dev.eribas.horizon.repository.SpaceRepository;
import dev.eribas.horizon.request.UpdateSpaceRequest;
import dev.eribas.horizon.response.GetSpaceResponse;
import dev.eribas.horizon.service.SpaceService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import dev.eribas.horizon.exception.SpaceNotFoundException;

import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;

    public Mono<GetSpaceResponse> getSpace(String id) {
        Mono<Space> fallback = Mono.error(SpaceNotFoundException::new);
        Function<Space, GetSpaceResponse> response = space -> new GetSpaceResponse(space.getId(), space.getName());

        return spaceRepository.findById(id).switchIfEmpty(fallback).map(response);
    }

    public Mono<GetSpaceResponse> createSpace(String name) {
        Space space = new Space(null, name);
        Function<Space, GetSpaceResponse> response = inserted -> new GetSpaceResponse(inserted.getId(), inserted.getName());

        return spaceRepository.insert(space).map(response);
    }

    public Mono<Void> updateSpace(UpdateSpaceRequest request) {
        return spaceRepository.updateNameById(request.getId(), request.getName());
    }

    public Mono<Void> deleteSpace(String id) {
        return spaceRepository.deleteById(id);
    }

    public Flux<GetSpaceResponse> getSpaces() {
        Function<Space, GetSpaceResponse> response = spaces -> new GetSpaceResponse(spaces.getId(), spaces.getName());

        return spaceRepository.findAll().map(response);
    }

}