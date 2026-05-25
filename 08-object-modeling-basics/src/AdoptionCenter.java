import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdoptionCenter {
    private final String name;
    private final List<Pet> pets;
    private final List<Adoption> adoptions;

    public AdoptionCenter(String name) {
        this.name = requireNonBlank(name, "name");
        this.pets = new ArrayList<>();
        this.adoptions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void registerPet(Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("pet cannot be null.");
        }
        pets.add(pet);
    }

    public List<Pet> getPets() {
        return new ArrayList<>(pets);
    }

    public List<Pet> getAvailablePets() {
        List<Pet> available = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.isAvailable()) {
                available.add(pet);
            }
        }
        return available;
    }

    public boolean adoptPetById(int petId, Adopter adopter) {
        Pet pet = findPetById(petId);
        if (pet == null || adopter == null) {
            return false;
        }
        if (!pet.isAvailable()) {
            return false;
        }

        pet.markAdopted();
        adoptions.add(new Adoption(pet, adopter, LocalDate.now()));
        return true;
    }

    public List<Adoption> getAdoptions() {
        return new ArrayList<>(adoptions);
    }

    private Pet findPetById(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    private static String requireNonBlank(String value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null.");
        }
        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank.");
        }
        return trimmed;
    }
}

