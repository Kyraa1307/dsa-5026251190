package lw01.unguided;

public class LaptopRental extends Rental {
    private static final int RATE_PER_DAY = 40000;
    private static final int SETUP_FEE = 10000;

    public LaptopRental(String id, int days) {
        super(id, days);
    }

    public LaptopRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        return getDays() * RATE_PER_DAY + SETUP_FEE;
    }

    @Override
    public String label() {
        return "Laptop";
    }
}