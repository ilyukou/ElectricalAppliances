package electricAppliance.model.electricAppliance.home;

import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TVTest {

    private TV tv;

    @BeforeEach
    void setUp() {
        tv = new TV(100,"Lg", ElectricApplianceType.Home,1,1);
    }

    // test parent (HomeElectricAppliance.class) setter
    @Test
    void setSoundLevel_whenSoundLevelValidate() {
        tv.setSoundLevel(10);
        assertEquals(10,tv.getSoundLevel());
    }

    @Test
    void setSoundLevel_whenSoundLevelNotValidate() {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            tv.setSoundLevel(-10);
        });
    }

    @Test
    void setScreenDiagonal_whenScreenDiagonalValidate() {
        tv.setScreenDiagonal(100);
        assertEquals(100,tv.getScreenDiagonal());
    }

    @Test
    void setScreenDiagonal_whenScreenDiagonalNotValidate() {

        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            tv.setScreenDiagonal(-100);
        });
    }
}