package lw01.unguided;

public class ProjectorRental extends Rental {
    private static final int PREMIUM_DAY_LIMIT = 3;
    private static final int PREMIUM_RATE = 60000;
    private static final int STANDARD_RATE = 45000;
    private static final int SETUP_FEE = 20000;

    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    public ProjectorRental(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        int premiumDays = Math.min(getDays(), PREMIUM_DAY_LIMIT);
        int extraDays = Math.max(getDays() - PREMIUM_DAY_LIMIT, 0);
        return premiumDays * PREMIUM_RATE + extraDays * STANDARD_RATE + SETUP_FEE;
    }

    @Override
    public String label() {
        return "Projector";
    }
}