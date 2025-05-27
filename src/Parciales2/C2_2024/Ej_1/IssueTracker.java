package Parciales2.C2_2024.Ej_1;

import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;
import java.util.SequencedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class IssueTracker {
    private final SequencedSet<Issue> issues = new TreeSet<>();

    public Issue addIssue(String title, MonthDay date, IssueType type) {
        Issue newIssue = new Issue(title, type, date);
        issues.add(newIssue);
        return newIssue;
    }

    public boolean removeIssue(Issue issue) {
        return issues.remove(issue);
    }

    private List<Issue> getIssues(Predicate<Issue> predicate) {
        List<Issue> toReturn = new ArrayList<>();
        issues.forEach(issue -> {
            if (predicate.test(issue)) toReturn.add(issue);
        });
        return toReturn;
    }

    public List<Issue> issues() {
        return getIssues(_ -> true);
    }

    public List<Issue> issues(IssueType type) {
        return getIssues(issue -> issue.getType().equals(type));
    }

    public Issue getLatestIssue(IssueType type) {
        return issues(type).getLast();
    }

    public Issue getOldestIssue(IssueType type) {
        return issues(type).getFirst();
    }
}
