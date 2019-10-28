package electricAppliance.model.electricAppliance.kitchen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MicrowaveTest {
    private Microwave microwave;

    @BeforeEach
    void setUp() {
        microwave = new Microwave(100, "LG", 5, 30);
    }

    // test parent (KitchenElectricAppliance.class) setter

    @Test
    void setCookingTime_whenCookingTimeValidate() {
        microwave.setCookingTime(100);
        assertEquals(100, microwave.getCookingTime());
    }

    @Test
    void setCookingTime_whenCookingTimeUnValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> microwave.setCookingTime(-100)
        );
    }

    @Test
    void setVolume_whenVolumeValidate() {
        microwave.setVolume(10);
        assertEquals(10, microwave.getVolume());
    }

    @Test
    void setVolume_whenVolumeUnValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> microwave.setVolume(-10)
        );
    }
}