package Parciales2.C2_2024.Ej_1;

import java.time.MonthDay;

public class Issue implements Comparable<Issue> {
    private String title;
    private IssueType type;
    private MonthDay date;
    private boolean solved = false;

    public Issue(String title, IssueType type, MonthDay date) {
        this.title = title;
        this.type = type;
        this.date = date;
    }

    public void resolve() {
        solved = true;
    }

    public IssueType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "--%s %s: %s (%s)".formatted(
                date.toString(),
                type.toString(),
                title,
                solved ? "resolved" : "pending"
        );
    }

    @Override
    public int compareTo(Issue o) {
        int cmp;
        if ((cmp = type.compareTo(o.type)) != 0) return cmp;
        if ((cmp = o.date.compareTo(date)) != 0) return cmp;
        if ((cmp = title.compareTo(o.title)) != 0) return cmp;
        return cmp;
    }
}
