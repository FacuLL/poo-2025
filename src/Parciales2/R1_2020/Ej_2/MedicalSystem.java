package Parciales2.R1_2020.Ej_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalSystem {
    private final Map<String, Booking> medics = new HashMap<>();

    public void addDoctor(String medic, JobType type) {
        Booking last = medics.putIfAbsent(medic, new Booking(type));
        if (last != null) throw new MedicalSystemException("Medico existente");
    }

    public void book(String date, String medic, String patient, int hour) {
        Booking booking = medics.get(medic);
        if (booking == null) throw new MedicalSystemException("Medico inexistente");
        booking.book(patient, date, hour);
    }

    public List<String> getBookings(String date, String medic) {
        Booking booking = medics.get(medic);
        if (booking == null) throw new MedicalSystemException("Medico inexistente");
        return booking.getBooking(date);
    }


}
