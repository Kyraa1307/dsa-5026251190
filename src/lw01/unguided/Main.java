package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Rental[] rentals;

        try (Scanner scanner = new Scanner(Main.class.getResourceAsStream("rentals.txt"))) {
            int count = scanner.nextInt();
            rentals = new Rental[count];

            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                int units = scanner.nextInt();

                switch (type) {
                    case "LAPTOP":
                        rentals[i] = new LaptopRental(id, days, units);
                        break;
                    case "PROJECTOR":
                        rentals[i] = new ProjectorRental(id, days, units);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown rental type: " + type);
                }
            }
        }

        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }
    }
}