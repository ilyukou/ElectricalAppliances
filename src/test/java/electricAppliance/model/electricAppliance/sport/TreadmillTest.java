package electricAppliance.model.electricAppliance.sport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreadmillTest {
    private Treadmill treadmill;

    @BeforeEach
    void setUp() {
        treadmill = new Treadmill(1,"Tread",1,1,1,1);
    }

    @Test
    void setTrackMaxSpeed_whenTrackMaxSpeedValidate() {
        treadmill.setTrackMaxSpeed(10);
        assertEquals(10,treadmill.getTrackMaxSpeed());
    }

    @Test
    void setTrackMaxSpeed_whenTrackMaxSpeedUnValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> treadmill.setTrackMaxSpeed(-10)
        );
    }

    @Test
    void setTrackWidth_whenTrackWidthValidate() {
        treadmill.setTrackWidth(3);
        assertEquals(3,treadmill.getTrackWidth());
    }

    @Test
    void setTrackWidth_whenTrackWidthUnValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> treadmill.setTrackWidth(-14)
        );
    }

    @Test
    void setTrackLength_whenTrackWidthLength() {
        treadmill.setTrackLength(16);
        assertEquals(16,treadmill.getTrackLength());
    }

    @Test
    void setTrackLength_whenTrackWidthUnLength() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> treadmill.setTrackLength(-16)
        );
    }
}