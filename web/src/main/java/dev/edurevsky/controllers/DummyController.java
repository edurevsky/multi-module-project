package dev.edurevsky.controllers;

import dev.edurevsky.entity.Dummy;
import dev.edurevsky.service.DummyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    private final DummyService dummyService;

    public DummyController(final DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @PostMapping
    public ResponseEntity<Dummy> save(@RequestBody Dummy request) {
        var dummy = dummyService.save(request);
        return ResponseEntity.status(HttpStatus.OK).body(dummy);
    }

    @GetMapping("{id}")
    public ResponseEntity<Dummy> findById(@PathVariable("id") Long id) {
        var dummy = dummyService.findById(id);
        return ResponseEntity.ok(dummy);
    }
}
