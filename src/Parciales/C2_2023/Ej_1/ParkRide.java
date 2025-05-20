package Parciales.C2_2023.Ej_1;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ParkRide implements Iterable<ParkSlot> {
    private final String name;
    private LocalTime open, close;
    private final long slotMinutes;

    public ParkRide(String name, LocalTime open, LocalTime close, long slotMinutes) {
        if (close.isBefore(open)) throw new IllegalArgumentException("Close time cannot be before open");
        if (slotMinutes <= 0) throw new IllegalArgumentException("Slot minutes must be positive");
        this.name = name;
        this.open = open;
        this.close = close;
        this.slotMinutes = slotMinutes;
    }

    @Override
    public Iterator<ParkSlot> iterator() {
        return new Iterator<>() {
            private final LocalTime closeTime = close;
            private LocalTime index = open;
            @Override
            public boolean hasNext() {
                return index.isBefore(closeTime);
            }

            @Override
            public ParkSlot next() {
                if (!hasNext()) throw new NoSuchElementException();
                ParkSlot slot = new ParkSlot(name, index);
                index = index.plusMinutes(slotMinutes);
                return slot;
            }
        };
    }

    public void setCloseTime(LocalTime close) {
        if (close.isBefore(open)) throw new IllegalArgumentException("Close time cannot be before open");
        this.close = close;
    }

    public void setOpenTime(LocalTime open) {
        if (close.isBefore(open)) throw new IllegalArgumentException("Close time cannot be before open");
        this.open = open;
    }
}
