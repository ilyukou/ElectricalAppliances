package electricAppliance.model.electricAppliance.kitchen;

import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MicrowaveTest {
    private Microwave microwave;

    @BeforeEach
    void setUp() {
        microwave = new Microwave(100,"LG",ElectricApplianceType.Kitchen,5,30);
    }

    @Test
    void setVolume_whenVolumeValidate() {
        microwave.setVolume(10);
        assertEquals(10,microwave.getVolume());
    }

    // What the best solution ?
    @Test
    void setVolume_whenVolumeUnValidate() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            microwave.setVolume(-10);
        });
    }

    @Test
    void setVolume_whenVolumeUnValidate1() {

        assertThrows(IllegalArgumentException.class,
                () -> microwave.setVolume(-10), Microwave.class +" size isn't validate");
    }
    @Test
    void setVolume_whenVolumeUnValidate2() {

        final String errorMessage = Microwave.class +" size isn't validate";

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> microwave.setVolume(-10));

        assertEquals(errorMessage,e.getMessage());
    }
}