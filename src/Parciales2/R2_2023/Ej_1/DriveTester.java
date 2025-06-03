package Parciales2.R2_2023.Ej_1;

import java.time.LocalDate;

public class DriveTester {
    public static void main(String[] args) {
        GDrive drive = new GDrive();


// Se agrega el archivo "mineSweeper.c" en el área de trabajo "PI"
        drive.addFileToWorkArea("mineSweeper.c", "PI");
        drive.addFileToWorkArea("r1.doc", "PI");
        drive.addFileToWorkArea("r2.doc", "POO");
        drive.addFileToWorkArea("specialMap.java", "POO");


// Se registra un comentario para el archivo "r1.doc" del usuario "marce" el 27/11/2023
        drive.logEvent("r1.doc", "marce", LocalDate.of(2023, 11, 27), EventType.COMMENT);
        drive.logEvent("mineSweeper.c", "franco", LocalDate.of(2023, 11, 26), EventType.DOWNLOAD);
        drive.logEvent("r1.doc", "franco", LocalDate.of(2023, 11, 27), EventType.SUGGESTION);
        drive.logEvent("r2.doc", "marce", LocalDate.of(2023, 11, 28), EventType.COMMENT);
        drive.logEvent("r2.doc", "franco", LocalDate.of(2023, 11, 27), EventType.COMMENT);
        drive.logEvent("r2.doc", "franco", LocalDate.of(2023, 11, 27), EventType.COMMENT);
        drive.logEvent("r2.doc", "marce", LocalDate.of(2023, 11, 28), EventType.DOWNLOAD);


// Se obtienen todos los eventos de todos los archivos del área de trabajo "PI"
// en orden cronológico por fecha de evento y desempata por tipo de evento
// (donde primero aparecen los comentarios, luego las sugerencias y por último las descargas)
        for(Event event : drive.events("PI")) {
            System.out.println(event);
        }
// DOWNLOAD Event on file mineSweeper.c of user franco on 2023-11-26
// COMMENT Event on file r1.doc of user marce on 2023-11-27
// SUGGESTION Event on file r1.doc of user franco on 2023-11-27


// Obtiene el evento más antiguo del área de trabajo "PI". En caso de haber más de un evento
// con la misma fecha de edición, utiliza el mismo criterio de desemapte de events
        System.out.println(drive.earliestEvent("PI"));
// DOWNLOAD Event on file mineSweeper.c of user franco on 2023-11-26
// Obtiene el evento más reciente del área de trabajo "PI". En caso de haber más de un evento
// con la misma fecha de edición, utiliza el mismo criterio de desemapte de events
        System.out.println(drive.mostRecentEvent("PI"));
// SUGGESTION Event on file r1.doc of user franco on 2023-11-27


        for(Event event : drive.events("POO")) {
            System.out.println(event);
        }
// COMMENT Event on file r2.doc of user franco on 2023-11-27
// COMMENT Event on file r2.doc of user franco on 2023-11-27
// COMMENT Event on file r2.doc of user marce on 2023-11-28
// DOWNLOAD Event on file r2.doc of user marce on 2023-11-28


        System.out.println(drive.earliestEvent("POO"));
// COMMENT Event on file r2.doc of user franco on 2023-11-27
        System.out.println(drive.mostRecentEvent("POO"));
// DOWNLOAD Event on file r2.doc of user marce on 2023-11-28


// El archivo r2.doc ya existe en el área de trabajo POO
        try {
            drive.addFileToWorkArea("r2.doc", "POO");
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); // File already exists.
        }
        try {
            drive.addFileToWorkArea("r2.doc", "PI");
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); // File already exists.
        }


// No existe el área de trabajo de nombre "EDA"
        try {
            drive.earliestEvent("EDA");
        } catch (Exception ex) {
            System.out.println(ex.getClass()); // class java.util.NoSuchElementException
        }
        try {
            drive.mostRecentEvent("EDA");
        } catch (Exception ex) {
            System.out.println(ex.getClass()); // class java.util.NoSuchElementException
        }
        System.out.println(drive.events("EDA").isEmpty()); // true
    }
}
