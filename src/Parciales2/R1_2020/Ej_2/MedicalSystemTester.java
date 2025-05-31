package Parciales2.R1_2020.Ej_2;

import java.util.List;

public class MedicalSystemTester {

    public static void main(String[] args) {
        MedicalSystem medicalSystem = new MedicalSystem();

        // Agrega al doctor PartTime de nombre Gonzalo
        medicalSystem.addDoctor("Gonzalo", JobType.PART_TIME);

        // Agrega a la doctora FullTime de nombre Juana
        medicalSystem.addDoctor("Juana", JobType.FULL_TIME);

        // Agrega al doctor Guardia de nombre Gustavo
        medicalSystem.addDoctor("Gustavo", JobType.GUARD);

        // Se reserva un turno para Maria con el doctor Gonzalo
        // para las 8hs del 01/07/2020
        medicalSystem.book("01/07/2020", "Gonzalo", "Maria", 8);
        medicalSystem.book("01/07/2020", "Gonzalo", "Mercedes", 9);
        medicalSystem.book("01/07/2020", "Gonzalo", "Mariana", 10);
        medicalSystem.book("01/07/2020", "Gonzalo", "Raul", 11);
        try {
            medicalSystem.book("01/07/2020", "Gonzalo", "Malena", 9);
        } catch (MedicalSystemException ex) {
            System.out.println(ex.getMessage()); // Imprime: Ya existe un turno a esa hora
        }
        try {
            medicalSystem.book("01/07/2020", "Gonzalo", "Pedro", 12);
        } catch (MedicalSystemException ex) {
            System.out.println(ex.getMessage()); // Imprime: Hora fuera del rango horario del médico
        }


        medicalSystem.book("02/07/2020", "Juana", "Santiago", 8);
        medicalSystem.book("02/07/2020", "Juana", "Agustina", 15);
        try {
            medicalSystem.book("02/07/2020", "Juana", "Pedro", 16);
        } catch (MedicalSystemException ex) {
            System.out.println(ex.getMessage()); // Imprime: Hora fuera del rango horario del médico
        }




        medicalSystem.book("03/07/2020", "Gustavo", "A", 2);
        medicalSystem.book("03/07/2020", "Gustavo", "B", 12);
        medicalSystem.book("03/07/2020", "Gustavo", "C", 23);
        try {
            medicalSystem.book("03/07/2020", "Gustavo", "D", 12);
        } catch (MedicalSystemException ex) {
            System.out.println(ex.getMessage()); // Imprime: Ya existe un turno a esa hora
        }


        // Obtiene los turnos de la doctora Juana para una fecha ordenado ascendente por hora
        List<String> bookings = medicalSystem.getBookings("02/07/2020", "Juana");
        System.out.println(bookings.size()); // Imprime: 2
        System.out.println(bookings.get(0)); // Imprime: "Santiago"
        System.out.println(bookings.get(1)); // Imprime: "Agustina"


        bookings = medicalSystem.getBookings("04/07/2020", "Gonzalo");
        System.out.println(bookings.isEmpty()); // Imprime: true


        try {
            medicalSystem.getBookings("03/07/2020", "Santiago");
        } catch (MedicalSystemException ex) {
            System.out.println(ex.getMessage()); // Imprime: El doctor indicado no existe
        }
    }

}


