package com.example.eventosacademicos.api.domain.evento;

import com.eventosacademicos.api.domain.palestrante.Palestrante;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Table(name = "evento")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private Date date;

    @ManyToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Palestrante> palestrante;
}