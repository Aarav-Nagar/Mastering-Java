import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class WorkshopRegistry {
    private final Map<String, Integer> capacityByTrack;
    private final Map<String, Integer> reservedSeatsByTrack;

    public WorkshopRegistry(Map<String, Integer> capacityByTrack) {
        if (capacityByTrack == null || capacityByTrack.isEmpty()) {
            throw new IllegalArgumentException("capacityByTrack must not be empty");
        }

        this.capacityByTrack = new LinkedHashMap<String, Integer>();
        this.reservedSeatsByTrack = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : capacityByTrack.entrySet()) {
            String trackName = entry.getKey();
            Integer capacity = entry.getValue();
            if (trackName == null || trackName.trim().isEmpty()) {
                throw new IllegalArgumentException("Track names must be non-blank");
            }
            if (capacity == null || capacity.intValue() <= 0) {
                throw new IllegalArgumentException("Track capacity must be positive");
            }
            String safeTrackName = trackName.trim();
            this.capacityByTrack.put(safeTrackName, capacity.intValue());
            this.reservedSeatsByTrack.put(safeTrackName, 0);
        }
    }

    public void register(RegistrationRequest request) throws ValidationException {
        if (request == null) {
            throw new MissingFieldException("Registration request must be present.");
        }

        String trackName = request.getTrackName();
        if (!capacityByTrack.containsKey(trackName)) {
            throw new UnsupportedTrackException(trackName, getSupportedTracks());
        }

        int reservedSeats = reservedSeatsByTrack.get(trackName);
        int nextReservedSeats = reservedSeats + request.getSeatCount();
        int capacity = capacityByTrack.get(trackName);
        if (nextReservedSeats > capacity) {
            throw new RangeValidationException(
                "Reserved seats for " + trackName,
                nextReservedSeats,
                0,
                capacity
            );
        }

        reservedSeatsByTrack.put(trackName, nextReservedSeats);
    }

    public Set<String> getSupportedTracks() {
        return Collections.unmodifiableSet(capacityByTrack.keySet());
    }

    public int getReservedSeats(String trackName) {
        return reservedSeatsByTrack.get(trackName);
    }

    public int getCapacity(String trackName) {
        return capacityByTrack.get(trackName);
    }
}
