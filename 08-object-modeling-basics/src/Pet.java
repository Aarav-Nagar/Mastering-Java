public class Pet {
    private static int nextId = 1;

    private final int id;
    private final String name;
    private final Species species;
    private final int age;
    private boolean available;

    public Pet(String name, Species species, int age) {
        this.id = nextId++;
        this.name = requireNonBlank(name, "name");
        if (species == null) {
            throw new IllegalArgumentException("species cannot be null.");
        }
        if (age < 0) {
            throw new IllegalArgumentException("age cannot be negative.");
        }
        this.species = species;
        this.age = age;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markAdopted() {
        available = false;
    }

    @Override
    public String toString() {
        String status = available ? "Available" : "Adopted";
        return "#" + id + " " + name + " (" + species + ", age " + age + ") - " + status;
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

