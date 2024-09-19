package dev.eribas.horizon.controller;

import dev.eribas.horizon.model.Space;
import dev.eribas.horizon.service.SpaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "space", produces = { "application/json" })
@Tag(name = "space")
public class SpaceController {

    @Autowired
    SpaceService spaceService;

    @Operation(summary = "Retrieves a space by its ID.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "500"),
    })
    @GetMapping(value = "/{id}")
    public Mono<ResponseEntity<Space>> getById(@PathVariable String id) {
        return spaceService.getById(id)
                .map(ResponseEntity::ok)
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build()));
    }

    @Operation(summary = "Creates a new space by passing its name.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "500"),
    })
    @PostMapping
    public Mono<ResponseEntity<Space>> insert(@RequestBody Space space) {
        return spaceService.insert(space)
                .map(space1 -> ResponseEntity.created(URI.create("/space")).body(space1));
    }

    @Operation(summary = "Update a space by passing its ID and name.", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500"),
    })
    @PutMapping
    public Mono<ResponseEntity<Space>> update(@RequestBody Space space) {
        return spaceService.update(space).map(ResponseEntity::ok);
    }

    @Operation(summary = "Delete a space by passing its ID.", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500"),
    })
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return spaceService.deleteById(id).map(ResponseEntity::ok);
    }

    @Operation(summary = "Get all registered spaces.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500"),
    })
    @GetMapping()
    public Mono<ResponseEntity<List<Space>>> getAll() {
        return spaceService.getAll()
                .collectList()
                .map(ResponseEntity::ok);
    }

}