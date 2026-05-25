import java.util.List;
import java.util.Scanner;

public class AdoptionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdoptionCenter center = new AdoptionCenter("Peachtree Adoption Center");

        seed(center);

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("=== " + center.getName() + " ===");
            System.out.println("1) Register a pet");
            System.out.println("2) List available pets");
            System.out.println("3) Adopt a pet");
            System.out.println("4) View adoption log");
            System.out.println("0) Exit");

            int choice = ConsoleIO.readInt(scanner, "Choose: ", 0, 4);
            switch (choice) {
                case 1:
                    registerPet(scanner, center);
                    break;
                case 2:
                    listAvailable(center);
                    break;
                case 3:
                    adopt(scanner, center);
                    break;
                case 4:
                    showLog(center);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Unknown option.");
                    break;
            }
        }

        System.out.println("Goodbye.");
    }

    private static void seed(AdoptionCenter center) {
        center.registerPet(new Pet("Milo", Species.DOG, 3));
        center.registerPet(new Pet("Nori", Species.CAT, 2));
        center.registerPet(new Pet("Pip", Species.RABBIT, 1));
    }

    private static void registerPet(Scanner scanner, AdoptionCenter center) {
        System.out.println();
        String name = ConsoleIO.readNonBlank(scanner, "Pet name: ");
        Species species = ConsoleIO.readSpecies(scanner, "Species (dog/cat/rabbit/other): ");
        int age = ConsoleIO.readInt(scanner, "Age (0-30): ", 0, 30);

        Pet pet = new Pet(name, species, age);
        center.registerPet(pet);
        System.out.println("Registered: " + pet);
    }

    private static void listAvailable(AdoptionCenter center) {
        System.out.println();
        List<Pet> available = center.getAvailablePets();
        if (available.isEmpty()) {
            System.out.println("No pets available.");
            return;
        }
        System.out.println("Available pets:");
        for (Pet pet : available) {
            System.out.println("- " + pet);
        }
    }

    private static void adopt(Scanner scanner, AdoptionCenter center) {
        System.out.println();
        listAvailable(center);
        List<Pet> available = center.getAvailablePets();
        if (available.isEmpty()) {
            return;
        }

        int petId = ConsoleIO.readInt(scanner, "Enter pet id to adopt: ", 1, Integer.MAX_VALUE);
        String adopterName = ConsoleIO.readNonBlank(scanner, "Adopter name: ");

        boolean success = center.adoptPetById(petId, new Adopter(adopterName));
        if (success) {
            System.out.println("Adoption successful.");
        } else {
            System.out.println("Adoption failed (pet not found or not available).");
        }
    }

    private static void showLog(AdoptionCenter center) {
        System.out.println();
        List<Adoption> log = center.getAdoptions();
        if (log.isEmpty()) {
            System.out.println("No adoptions yet.");
            return;
        }
        System.out.println("Adoption log:");
        for (Adoption adoption : log) {
            System.out.println("- " + adoption);
        }
    }
}
