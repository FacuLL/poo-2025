package Parciales2.C1_2024.Ej_2;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReimbursementTracker {
    private final Map<String, Client> clients = new HashMap<>();

    public void registerClient(String name, Integer max) {
        if (clients.containsKey(name)) throw new IllegalArgumentException("Client already registered");
        clients.put(name, new Client(max));
    }

    private Client getClient(String name) {
        if (!clients.containsKey(name)) throw new IllegalArgumentException("Client is not registered");
        return clients.get(name);
    }

    public void addReimbursement(String client, YearMonth date, Integer amount) {
        getClient(client).addReimbursement(date, amount);
    }

    public Set<Map.Entry<YearMonth, Integer>> getReimbursements(String client, YearMonth minDate, YearMonth maxDate) {
        return getClient(client).getReimbursement(minDate, maxDate);
    }

    public Integer getRemainingReimbursement(String client, YearMonth date) {
        return getClient(client).getRemainingReimbursement(date);
    }
}
