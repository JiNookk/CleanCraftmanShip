public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public int getFee(int days, Rental rental) {
        return days * 100;
    }

    @Override
    public int getPoints(int days, Rental rental) {
        return 1;
    }
}
