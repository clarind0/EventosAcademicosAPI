package com.example.eventosacademicos.api.domain.evento;

import java.util.Date;
import java.util.UUID;

public record EventoRespostaDTO(UUID id, String title, String description, Date date) {
}