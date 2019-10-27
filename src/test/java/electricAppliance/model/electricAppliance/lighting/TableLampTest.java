package electricAppliance.model.electricAppliance.lighting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TableLampTest {
    private TableLamp tableLamp;

    @BeforeEach
    void setUp() {
        tableLamp = new TableLamp(1,"Table",LightCapType.E14,LightBulbsType.Halogen,1);
    }

    @Test
    void setHeight_whenHeightIsValidate() {
        tableLamp.setHeight(10);
        assertEquals(10,tableLamp.getHeight());
    }

    @Test
    void setHeight_whenHeightIsNotValidate() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
           tableLamp.setHeight(-10);
        });
    }
}