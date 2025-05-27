package Parciales2.C2_2024.Ej_1;

import java.time.MonthDay;

public class IssueTester {

    public static void main(String[] args) {
        // Ejemplo de uso de la clase java.time.MonthDay para el 30/03
        MonthDay monthDay = MonthDay.of(3, 30);
        System.out.println(monthDay); // --03-30
        System.out.println(monthDay.compareTo(MonthDay.of(3, 28))); // 2

        IssueTracker tracker = new IssueTracker();

        // Agrega una issue de tipo BUG con fecha 04/06 y el titulo "Cloud syncing..."
        Issue i1 = tracker.addIssue("Cloud syncing not working", MonthDay.of(6, 4), IssueType.BUG);


        Issue i2 = tracker.addIssue("Support Linux", MonthDay.of(11, 15), IssueType.WONTFIX);
        Issue i3 = tracker.addIssue("Login Failed", MonthDay.of(12, 30), IssueType.ENHANCEMENT);
        Issue i4 = tracker.addIssue("Syncing slow", MonthDay.of(6, 5), IssueType.BUG);
        Issue i5 = tracker.addIssue("Add About Screen", MonthDay.of(12, 30), IssueType.ENHANCEMENT);


        // Se obtienen todas las issues
        // listando primero las de tipo BUG, luego ENHANCEMENT y por último WONTFIX
        // y a igualdad de tipo listando las más recientes primero
        // y a igualdad de fecha respetando orden alfabético por nombre
        for(Issue issue : tracker.issues()) {
            System.out.println(issue);
        }
        // --06-05 BUG: Syncing slow (pending)
        // --06-04 BUG: Cloud syncing not working (pending)
        // --12-30 ENHANCEMENT: Add a About Screen (pending)
        // --12-30 ENHANCEMENT: Login Failed (pending)
        // --11-15 WONTFIX: Support Linux (pending)


        i1.resolve();


        // Se obtienen todas las issues que sean del tipo BUG
        // listando las más recientes primero
        // y a igualdad de fecha respetando orden alfabético por nombre
        for(Issue issue : tracker.issues(IssueType.BUG)) {
            System.out.println(issue);
        }
        // --06-05 BUG: Syncing slow (pending)
        // --06-04 BUG: Cloud syncing not working (resolved)


        // Obtiene la issue más antigua del tipo BUG
        // De existir más de una se obtiene la mayor alfabética
        System.out.println(tracker.getOldestIssue(IssueType.BUG));
        // --06-04 BUG: Cloud syncing not working (resolved)


        // Obtiene la issue más reciente del tipo BUG
        // De existir más de una se obtiene la menor alfabética
        System.out.println(tracker.getLatestIssue(IssueType.BUG));
        // --06-05 BUG: Syncing slow (pending)


        // Se remueve la issue i1
        System.out.println(tracker.removeIssue(i1)); // true


        System.out.println(tracker.getOldestIssue(IssueType.BUG));
        // --06-05 BUG: Syncing slow (pending)
        System.out.println(tracker.getLatestIssue(IssueType.BUG));
        // --06-05 BUG: Syncing slow (pending)


        System.out.println(tracker.removeIssue(i4)); // true
        System.out.println(tracker.issues(IssueType.BUG).isEmpty()); // true
        try { // Falla pues no hay issues de tipo BUG
            tracker.getOldestIssue(IssueType.BUG);
        } catch (Exception ex) {
            System.out.println(ex.getMessage()); // No issues with type BUG
        }
        System.out.println(tracker.removeIssue(i4)); // false
    }

}
