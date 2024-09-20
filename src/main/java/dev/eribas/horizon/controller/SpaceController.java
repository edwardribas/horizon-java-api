package dev.eribas.horizon.controller;

import dev.eribas.horizon.request.UpdateSpaceRequest;
import dev.eribas.horizon.response.GetSpaceResponse;
import dev.eribas.horizon.service.SpaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping(value = "space")
@Tag(name = "space")
@RequiredArgsConstructor
@RestController
public class SpaceController {

    private final SpaceService spaceService;

    @Operation(summary = "Retrieves a space by its ID.", method = "GET")
    @GetMapping(value = "/{id}")
    public Mono<GetSpaceResponse> getSpace(@PathVariable @NonNull String id) {
        return spaceService.getSpace(id);
    }

    @Operation(summary = "Creates a new space by passing its name.", method = "POST")
    @PostMapping
    public Mono<GetSpaceResponse> createSpace(@RequestBody @NonNull String name) {
        return spaceService.createSpace(name);
    }

    @Operation(summary = "Update a space by passing its ID and name.", method = "PUT")
    @PutMapping
    public Mono<Void> updateSpace(@RequestBody @NonNull UpdateSpaceRequest request) {
        return spaceService.updateSpace(request);
    }

    @Operation(summary = "Delete a space by passing its ID.", method = "DELETE")
    @DeleteMapping("/{id}")
    public Mono<Void> deleteSpace(@PathVariable @NonNull String id) {
        return spaceService.deleteSpace(id);
    }

    @Operation(summary = "Get all registered spaces.", method = "GET")
    @GetMapping()
    public Flux<GetSpaceResponse> getSpaces() {
        return spaceService.getSpaces();
    }
}