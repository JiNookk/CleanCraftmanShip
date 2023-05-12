public class Rental {
    private final Movie movie;
    public String title;
    public int days;

    public Rental(String title, int days) {
        this.days = days;
        this.movie = VideoRegistry.getMovie(title);
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public int getFee() {
        return movie.getFee(days, this);
    }

    public int getPoint() {
        return movie.getPoints(days, this);
    }
}
