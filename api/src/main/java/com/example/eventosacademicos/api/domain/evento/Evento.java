package com.eventosacademicos.api.domain.evento;

import com.eventostec.api.domain.address.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
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

    @OneToOne(mappedBy = "evento", cascade = CascadeType.ALL)
    private Palestrante palestrante;
}