package com.example.eventosacademicos.api.service;

import com.eventosacademicos.api.domain.palestrante.Palestrante;
import com.eventosacademicos.api.domain.evento.Evento;
import com.eventosacademicos.api.domain.evento.EventoSolicitarDTO;
import com.eventosacademicos.api.repositories.PalestranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalestranteService {

    @Autowired
    private PalestranteRepositorio palestranteRepositorio;

    public Palestrante createPalestrante(EventoSolicitarDTO data, Evento evento)
    {
        Palestrante palestrante = new Palestrante();
        palestrante.setNome(data.nome());
        palestrante.setEvent(event);

        return palestranteRepositorio.save(palestrante);
    }
}