package com.eventosacademicos.api.repositories;

import com.eventosacademicos.api.domain.palestrante.Palestrante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PalestranteRepositorio extends JpaRepository<Palestrante, UUID> {
}