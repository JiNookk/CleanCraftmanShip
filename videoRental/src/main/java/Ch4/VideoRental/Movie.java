package Ch4.VideoRental;

public abstract class Movie {
    private String title;

    protected Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public abstract int getFee(int days, Rental rental);

    public abstract int getPoints(int days, Rental rental);

    protected static int applyGracePeriod(int amount, int days, int grace) {
        if (days > grace)
            return amount + amount * (days - grace);
        return amount;
    }
}
