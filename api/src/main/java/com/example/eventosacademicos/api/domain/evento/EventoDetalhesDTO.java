package com.eventosacademicos.api.domain.evento;

import com.eventosacademicos.api.domain.coupon.CouponRequestDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record EventoDetalhesDTO(
        UUID id,
        String title,
        String description,
        Date date,
        ) {
}