import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalCalculatorTest {
    RentalCalculator rentalCalculator;

    @BeforeAll
    public static void loadRegistry() {
        VideoRegistry.addMovie("RegularMovie", VideoRegistry.VideoType.REGULAR);
        VideoRegistry.addMovie("ChildrenMovie", VideoRegistry.VideoType.CHILDREN);
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
        rentalCalculator.addRental("RegularMovie", 1);
        assertFeeAndPoints(150, 1);
    }

    @Test
    void RegularMovie_SecondDayFree() {
        rentalCalculator.addRental("RegularMovie", 2);
        assertFeeAndPoints(150, 1);
    }

    @Test
    void RegularMovie_ThirdDayFree() {
        rentalCalculator.addRental("RegularMovie", 3);
        assertFeeAndPoints(150, 1);
    }

    @Test
    void RegularMovie_FourDays() {
        rentalCalculator.addRental("RegularMovie", 4);
        assertFeeAndPoints(300, 2);
    }

    @Test
    void ChildrenMovie_OneDay() {
        rentalCalculator.addRental("ChildrenMovie", 1);
        assertFeeAndPoints(100, 1);
    }

    @Test
    void ChildrenMovie_FourDay() {
        rentalCalculator.addRental("ChildrenMovie", 4);
        assertFeeAndPoints(400, 1);
    }

    @Test
    void OneRegularOneChildren_FourDays() {
        rentalCalculator.addRental("RegularMovie", 4);
        rentalCalculator.addRental("ChildrenMovie", 4);

        assertFeeAndPoints(700, 3);
    }
}