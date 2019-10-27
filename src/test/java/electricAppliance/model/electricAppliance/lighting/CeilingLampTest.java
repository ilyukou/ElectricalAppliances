package electricAppliance.model.electricAppliance.lighting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeilingLampTest {
    private CeilingLamp ceilingLamp;

    @BeforeEach
    void setUp() {
        ceilingLamp = new CeilingLamp(100,"Li",LightCapType.E14,LightBulbsType.Halogen,2);
    }

    // test parent (LightElectricAppliance.class) setter
    @Test
    void setLightCapType_whenLightCapTypeIsNotNull() {
        ceilingLamp.setLightCapType(LightCapType.E14);
        assertEquals(LightCapType.E14,ceilingLamp.getLightCapType());
    }

    @Test
    void setLightCapType_whenLightCapTypeIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
           ceilingLamp.setLightCapType(null);
        });
    }

    @Test
    void setLightBulbsType_whenLightBulbsTypeIsNotNull() {
        ceilingLamp.setLightBulbsType(LightBulbsType.Halogen);
        assertEquals(LightBulbsType.Halogen,ceilingLamp.getLightBulbsType());
    }

    @Test
    void setLightBulbsType_whenLightBulbsTypeIsNull() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ceilingLamp.setLightBulbsType(null)
        );
    }

    @Test
    void setWeight_whenWeightIsValidate() {
        ceilingLamp.setWeight(10);
        assertEquals(10,ceilingLamp.getWeight());
    }

    @Test
    void setWeight_whenWeightIsNotValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> ceilingLamp.setWeight(-10)
        );
    }
}