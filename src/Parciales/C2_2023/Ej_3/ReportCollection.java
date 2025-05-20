package Parciales.C2_2023.Ej_3;

public interface ReportCollection<R> {

    void add(R report);

    R get(int index);

    R[] reports();

}
