package electricAppliance.model.electricAppliance.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultimediaSpeakersTest {
    private MultimediaSpeakers multimediaSpeakers;
    @BeforeEach
    void setUp() {
        multimediaSpeakers = new MultimediaSpeakers(100,"Buss", 100,2);
    }

    @Test
    void setNumberOfSpeakers_whenNumberIsValidate() {
        multimediaSpeakers.setNumberOfSpeakers(3);
        assertEquals(3,multimediaSpeakers.getNumberOfSpeakers());
    }

    @Test
    void setNumberOfSpeakers_whenNumberIsNotValidate() {

        Assertions.assertThrows(IllegalArgumentException.class , () -> {
            multimediaSpeakers.setNumberOfSpeakers(-3);
        });
    }
}