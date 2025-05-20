package Teoricas.Teorica9.SharedDrive3;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SharedDrive {
    private final SortedSet<SharedFile> files = new TreeSet<>();

    public SharedDrive addFile(String name, String workArea) {
        files.add(new SharedFile(name, workArea));
        return this;
    }

    public Iterable<SharedFile> getAllFiles() {
        return files;
    }

    public Iterable<SharedFile> getAllFilesReversed() {
        return files.reversed();
    }

    public static class SharedFile implements Comparable<SharedFile> {
        public String name;
        public String workArea;

        public SharedFile(String name, String workArea) {
            this.name = name;
            this.workArea = workArea;
        }

        @Override
        public int compareTo(SharedFile o) {
            int cmp = this.name.compareTo(o.name);
            if (cmp == 0) {
                cmp = this.workArea.compareTo(o.workArea);
            }
            return cmp;
        }
    }
}
