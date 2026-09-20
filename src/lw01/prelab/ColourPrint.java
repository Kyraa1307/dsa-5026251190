package lw01.prelab;

public class ColourPrint extends PrintJob {
    private static final int PREMIUM_PAGE_LIMIT = 10;
    private static final int PREMIUM_RATE = 1500;
    private static final int STANDARD_RATE = 1000;
    private static final int SETUP_FEE = 2000;
 
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }
 
    @Override
    public int calculateCharge() {
        int premiumPages = Math.min(getPages(), PREMIUM_PAGE_LIMIT);
        int extraPages = Math.max(getPages() - PREMIUM_PAGE_LIMIT, 0);
        return premiumPages * PREMIUM_RATE + extraPages * STANDARD_RATE + SETUP_FEE;
    }
 
    @Override
    public String label() {
        return "Colour";
    }
}
