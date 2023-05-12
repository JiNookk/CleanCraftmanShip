import Ch4.VideoRental.RentalCalculator;
import Ch4.VideoRental.VideoRegistry;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalCalculatorTest {
    RentalCalculator rentalCalculator;

    @BeforeAll
    public static void loadRegistry() {
        VideoRegistry.addMovie("Ch4.VideoRental.RegularMovie", VideoRegistry.VideoType.REGULAR);
        VideoRegistry.addMovie("Ch4.VideoRental.ChildrenMovie", VideoRegistry.VideoType.CHILDREN);
    }

    @BeforeEach
    void setup() {
        rentalCalculator = new RentalCalculator();
    }

    private void assertFeeAndPoints(int fee, int points) {
        assertEquals(fee, rentalCalculator.getRentalFee(), 0.001);
        assertEquals(points, rentalCalculator.getRenterPoints());
    }

    @Test
    void RegularMovie_OneDay() {
        rentalCalculator.addRental("Ch4.VideoRental.RegularMovie", 1);
        assertFeeAndPoints(150, 1);
    }

    @Test
    void RegularMovie_SecondDayFree() {
        rentalCalculator.addRental("Ch4.VideoRental.RegularMovie", 2);
        assertFeeAndPoints(150, 1);
    }

    @Test
    void RegularMovie_ThirdDayFree() {
        rentalCalculator.addRental("Ch4.VideoRental.RegularMovie", 3);
        assertFeeAndPoints(150, 1);
    }

    @Test
    void RegularMovie_FourDays() {
        rentalCalculator.addRental("Ch4.VideoRental.RegularMovie", 4);
        assertFeeAndPoints(300, 2);
    }

    @Test
    void ChildrenMovie_OneDay() {
        rentalCalculator.addRental("Ch4.VideoRental.ChildrenMovie", 1);
        assertFeeAndPoints(100, 1);
    }

    @Test
    void ChildrenMovie_FourDay() {
        rentalCalculator.addRental("Ch4.VideoRental.ChildrenMovie", 4);
        assertFeeAndPoints(400, 1);
    }

    @Test
    void OneRegularOneChildren_FourDays() {
        rentalCalculator.addRental("Ch4.VideoRental.RegularMovie", 4);
        rentalCalculator.addRental("Ch4.VideoRental.ChildrenMovie", 4);

        assertFeeAndPoints(700, 3);
    }
}