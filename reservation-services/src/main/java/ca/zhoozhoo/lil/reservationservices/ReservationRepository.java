package ca.zhoozhoo.lil.reservationservices;

import java.time.LocalDate;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface ReservationRepository extends ReactiveCrudRepository<Reservation, Long> {

    public Flux<Reservation> findAllByDate(LocalDate date);
}