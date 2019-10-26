package model.electricAppliance.kitchen;

import model.ElectricApplianceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StoveTest {
    private Stove stove;

    @BeforeEach
    void setUp() {
        stove = new Stove(100,"LG", ElectricApplianceType.Kitchen,5,2);
    }


    @Test
    void setNumberOfBurners_whenNumbersValidate(){
        stove.setNumberOfBurners(3);
        assertEquals(3,stove.getNumberOfBurners());
    }

    @Test
    void setNumberOfBurners_whenBurnersNumbersMoreThanValidate(){
        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            stove.setNumberOfBurners(-1);
        });
    }

    /*
        MOCKITO SERVICE

    private Stove stove = Mockito.mock(Stove.class);

    @BeforeEach
    void setUp(){
        when(stove.getNumberOfBurners()).then();
    }
    */

}