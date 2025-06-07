package Parciales2.C1_2024.Ej_2;

import java.time.YearMonth;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Client {
    private final Integer max;
    private final SortedMap<YearMonth, Integer> reimbursement = new TreeMap<>();

    public Client(Integer max) {
        this.max = max;
    }

    public void addReimbursement(YearMonth date, Integer amount) {
        amount += reimbursement.getOrDefault(date, 0);
        if (amount > max) throw new IllegalArgumentException("Reimbursement surpasses month cap");
        reimbursement.put(date, amount);
    }

    public Set<Map.Entry<YearMonth, Integer>> getReimbursement(YearMonth minDate, YearMonth maxDate) {
        return reimbursement.subMap(minDate, maxDate).entrySet();
    }

    public Integer getRemainingReimbursement(YearMonth date) {
        return max - reimbursement.getOrDefault(date, 0);
    }
}
