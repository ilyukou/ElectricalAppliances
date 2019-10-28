package electricAppliance.model.electricAppliance.sport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExerciseBikeTest {
    private ExerciseBike exerciseBike;

    @BeforeEach
    void setUp() {
        exerciseBike = new ExerciseBike(10, "Bike", 13, 11);
    }

    // test parent (SportElectricAppliance.class) setter
    @Test
    void setMaxUserWeight_whenMaxUserWeightValidate() {
        exerciseBike.setMaxUserWeight(100);
        assertEquals(100, exerciseBike.getMaxUserWeight());
    }

    @Test
    void setMaxUserWeight_whenMaxUserWeight_UnValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> exerciseBike.setMaxUserWeight(-100)
        );
    }

    @Test
    void setMaxSpeed_whenMaxSpeedValidate() {
        exerciseBike.setMaxSpeed(30);
        assertEquals(30, exerciseBike.getMaxSpeed());
    }

    @Test
    void setMaxSpeed_whenMaxSpeedUnValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> exerciseBike.setMaxSpeed(-30)
        );
    }
}