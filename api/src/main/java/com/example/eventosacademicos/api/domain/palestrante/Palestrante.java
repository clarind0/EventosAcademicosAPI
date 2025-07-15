package com.eventosacademicos.api.domain.palestrante;

import com.eventosacademicos.api.domain.evento.Evento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "palestrante")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Palestrante {
    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
}