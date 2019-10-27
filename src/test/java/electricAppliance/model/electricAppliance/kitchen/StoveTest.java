package electricAppliance.model.electricAppliance.kitchen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoveTest {
    private Stove stove;

    @BeforeEach
    void setUp() {
        stove = new Stove(100,"LG",5,2);
    }


    @Test
    void setNumberOfBurners_whenNumbersValidate(){
        stove.setNumberOfBurners(3);
        assertEquals(3,stove.getNumberOfBurners());
    }

    @Test
    void setNumberOfBurners_whenBurnersNumbersMoreThanValidate(){
        Assertions.assertThrows(
                IllegalArgumentException.class ,
                () -> stove.setNumberOfBurners(5)
        );
    }
    @Test
    void setNumberOfBurners_whenBurnersNumbersLessThanValidate(){
        Assertions.assertThrows(
                IllegalArgumentException.class ,
                () -> stove.setNumberOfBurners(-1)
        );
    }
}