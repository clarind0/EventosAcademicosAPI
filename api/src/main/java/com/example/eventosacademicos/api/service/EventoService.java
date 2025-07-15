package com.eventosacademicos.api.service;

import com.eventosacademicos.api.domain.evento.Evento;
import com.eventosacademicos.api.domain.evento.EventoDetalhesDTO;
import com.eventosacademicos.api.domain.evento.EventoSolicitarDTO;
import com.eventosacademicos.api.domain.evento.EventoRespostaDTO;
import com.eventosacademicos.api.repositories.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventoService
{

    @Autowired
    private EventoRepositorio eventoRepositorio;

    @Autowired
    private PalestranteRepositorio palestranteRepositorio;

    public Evento createEvento(EventoSolicitarDTO data)
    {

        Evento newEvento = new Evento();
        newEvento.setTitle(data.title());
        newEvento.setDescription(data.description());
        newEvento.setDate(new Date(data.date()));

        eventoRepositorio.save(newEvento);


        return newEvento;

    }

    public EventoDetalhesDTO getEventoDetalhesDTO(UUID eventoId)
    {
        Evento evento = eventoRepositorio.findById(eventoId)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado"));


        return new EventoDetalhesDTO(
                evento.getId(),
                evento.getTitle(),
                evento.getDescription(),
                evento.getDate());


    }

    public List<EventoRespostaDTO> getUpcomingEventos(int page, int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        Page<Evento> eventosPage = this.eventRepository.findUpcomingEventos(new Date(), pageable);
        return eventosPage.map(event -> new EventoRespostaDTO(evento.getId(),
                        evento.getTitle(),
                        evento.getDescription(),
                        evento.getDate(),
                        )
                )
                .stream().toList();
    }

    public List<EventoRespostaDTO> getFilteredEventos(int page, int size, String title, Date startDate, Date endDate)
    {
        title = (title != null) ? title : "";
        startDate = (startDate != null) ? startDate : new Date(0);
        endDate = (endDate != null) ? endDate : new Date();

        Pageable pageable = PageRequest.of(page, size);

        Page<Evento> eventosPage = this.eventoRepositorio.findFilteredEventos( title, startDate, endDate, pageable);
        return eventosPage.map(evento -> new EventoRespostaDTO(evento.getId(),
                        evento.getTitle(),
                        evento.getDescription(),
                        evento.getDate(),
                        evento.getPalestrante()
                )
                .stream().toList();
    }

    }
}