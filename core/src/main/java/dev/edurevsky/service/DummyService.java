package dev.edurevsky.service;

import dev.edurevsky.entity.Dummy;
import dev.edurevsky.repository.DummyRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DummyService {

    private final DummyRepository dummyRepository;

    public DummyService(final DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    public Dummy findById(Long id) {
        return dummyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

    public Dummy save(Dummy dummy) {
        return dummyRepository.save(dummy);
    }
}
