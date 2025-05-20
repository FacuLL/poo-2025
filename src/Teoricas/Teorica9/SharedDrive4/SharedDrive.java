package Teoricas.Teorica9.SharedDrive4;

import java.util.*;

public class SharedDrive {
    private final SortedMap<String, SortedSet<SharedFile>> files = new TreeMap<>();

    public SharedDrive addFile(String name, String workArea) {
        files.putIfAbsent(workArea, new TreeSet<>());
        Set<SharedFile> set = files.get(workArea);
        set.add(new SharedFile(name, workArea));
        return this;
    }

    public Set<SharedFile> getWorkAreaFiles(String workArea) {
        SortedSet<SharedFile> set = files.get(workArea);
        return set == null ? new TreeSet<>() : set;
    }

    public Set<String> getWorkAreas() {
        return files.sequencedKeySet().reversed();
    }

    public int filesCount(String workArea) {
        return files.get(workArea).size();
    }

    public static class SharedFile implements Comparable<SharedFile> {
        public String name;
        public String workArea;

        public SharedFile(String name, String workArea) {
            this.name = name;
            this.workArea = workArea;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof SharedFile file)) return false;
            return file.name.equals(name) && file.workArea.equals(workArea);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, workArea);
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
