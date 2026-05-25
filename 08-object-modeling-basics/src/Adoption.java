import java.time.LocalDate;

public class Adoption {
    private final Pet pet;
    private final Adopter adopter;
    private final LocalDate date;

    public Adoption(Pet pet, Adopter adopter, LocalDate date) {
        if (pet == null) {
            throw new IllegalArgumentException("pet cannot be null.");
        }
        if (adopter == null) {
            throw new IllegalArgumentException("adopter cannot be null.");
        }
        if (date == null) {
            throw new IllegalArgumentException("date cannot be null.");
        }
        this.pet = pet;
        this.adopter = adopter;
        this.date = date;
    }

    public Pet getPet() {
        return pet;
    }

    public Adopter getAdopter() {
        return adopter;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + " - " + adopter.getName() + " adopted " + pet.getName() + " (" + pet.getSpecies() + ")";
    }
}

