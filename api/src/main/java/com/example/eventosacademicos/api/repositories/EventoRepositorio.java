package com.eventosacademicos.api.repositories;

import com.eventosacademicos.api.domain.evento.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface EventoRepositorio extends JpaRepository<Evento, UUID> {
    @Query("SELECT e FROM event e LEFT JOIN FETCH e.palestrante a WHERE e.date >= :currentDate")
    public Page<Evento> findUpcomingEvents(@Param("currentDate") Date currentDate, Pageable pageable);

    @Query("Select e FROM Evento e LEFT JOIN e.palestrante a " +
            "WHERE (:title = '' OR e.title LIKE %:title%)" +
            "AND (:Date >= :startDate AND e.date <= :endDate"   )
    Page<Evento> findFilteredEvents(@Param("title") String title,
                                   @Param("startDate") Date startDate,
                                   @Param("endDate") Date endDate,
                                   Pageable pageable);
}
