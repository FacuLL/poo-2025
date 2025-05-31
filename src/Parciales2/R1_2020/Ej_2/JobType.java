package Parciales2.R1_2020.Ej_2;

public enum JobType {
    PART_TIME() {
        @Override
        public boolean canWork(int hour) {
            return hour >= 8 && hour < 12;
        }
    },
    FULL_TIME() {
        @Override
        public boolean canWork(int hour) {
            return hour >= 8 && hour < 16;
        }
    },
    GUARD() {
        @Override
        public boolean canWork(int hour) {
            return true;
        }
    };

    abstract public boolean canWork(int hour);
}
