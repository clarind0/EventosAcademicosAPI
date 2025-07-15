package com.eventosacademicos.api.domain.evento;

import java.util.Date;
import java.util.UUID;

public record EventResponseDTO(UUID id, String title, String description, Date date) {
}