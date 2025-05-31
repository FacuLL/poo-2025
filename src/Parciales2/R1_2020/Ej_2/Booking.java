package Parciales2.R1_2020.Ej_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Booking {
    private JobType type;
    private final Map<String, String[]> book = new HashMap<>();

    public Booking(JobType type) {
        this.type = type;
    }

    public void book(String patient, String date, int hour) {
        if (!type.canWork(hour)) throw new MedicalSystemException("Horario no disponible para el medico");
        book.putIfAbsent(date, new String[24]);
        String[] dateBook = book.get(date);
        if (dateBook[hour-1] != null) throw new MedicalSystemException("Turno ocupado");
        dateBook[hour - 1] = patient;
    }

    public List<String> getBooking(String date) {
        List<String> toReturn = new ArrayList<>();
        for (String patient : book.getOrDefault(date, new String[0])) {
            if (patient != null) toReturn.add(patient);
        }
        return toReturn;
    }
}
