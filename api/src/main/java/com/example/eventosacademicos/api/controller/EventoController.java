package com.example.eventosacademicos.api.controller;

import com.example.eventosacademicos.api.domain.evento.Evento;
import com.example.eventosacademicos.api.domain.evento.EventoDetalhesDTO;
import com.example.eventosacademicos.api.domain.evento.EventoSolicitarDTO;
import com.example.eventosacademicos.api.domain.evento.EventoRespostaDTO;
import com.example.eventosacademicos.api.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/evento")
public class EventoController {


    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<Evento> create(@RequestParam("title") String title,
                                        @RequestParam(value = "description", required = false) String description,
                                        @RequestParam("date") Long date
    {
        EventoSolicitarDTO eventoSolicitarDTO = new EventoSolicitarDTO(title, description, date);
        Evento newEvento = this.eventoService.createEvento(eventoSolicitarDTO);
        return ResponseEntity.ok(newEvento);
    }

    @GetMapping("/{eventoId}")
    public ResponseEntity<EventoDetalhesDTO> getEventoDetalhes(@PathVariable UUID eventoId)
    {
        EventoDetalhesDTO eventoDetalhes = eventoService.getEventoDetalhes(eventoId);
        return ResponseEntity.ok(eventoDetalhes);
    }

    @GetMapping
    public ResponseEntity<List<EventoRespostaDTO>> getEventos(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
    {
        List<EventoRespostaDTO> allEventos = this.eventoService.getUpcomingEventos(page, size);
        return ResponseEntity.ok(allEventos);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<EventoRespostaDTO>> getFilteredEventos(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size,
                                                                    @RequestParam(required = false) String title,
                                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                                    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        List<EventoRespostaDTO> eventos = eventoService.getFilteredEventos(page, size, title, startDate, endDate);
        return ResponseEntity.ok(eventos);
    }
}
