package ca.zhoozhoo.lil.reservationservices;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationWebServices {

    @Autowired
    protected ReservationRepository reservationRepository;

    @GetMapping
    Iterable<Reservation> getReservations(@RequestParam(name = "date", required = false) Date date) {
        if (date != null) {
            return reservationRepository.findAllByDate(date);
        }

        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") long id) {
        return reservationRepository.findById(id).get();
    }
}
