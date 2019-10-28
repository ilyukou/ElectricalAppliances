package electricAppliance.model.electricAppliance.home;

import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultimediaSpeakersTest {

    private MultimediaSpeakers multimediaSpeakers;

    @BeforeEach
    void setUp() {
        multimediaSpeakers = new MultimediaSpeakers(100, "Buss", 100, 2);
    }

    @Test
    void setNumberOfSpeakers_whenNumberIsValidate() {
        multimediaSpeakers.setNumberOfSpeakers(3);
        assertEquals(3, multimediaSpeakers.getNumberOfSpeakers());
    }

    @Test
    void setNumberOfSpeakers_whenNumberIsNotValidate() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> multimediaSpeakers.setNumberOfSpeakers(-3)
        );
    }

    // test super parent (ElectricAppliance.class) setter
    @Test
    void setPower_whenPowerIsValidate() {
        multimediaSpeakers.setPower(12);
        assertEquals(12, multimediaSpeakers.getPower());
    }

    @Test
    void setPower_whenPowerIsUnValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> multimediaSpeakers.setPower(-10)
        );
    }

    @Test
    void setElectricApplianceType_whenElectricApplianceTypeIsValidate() {
        multimediaSpeakers.setElectricApplianceType(ElectricApplianceType.Home);
        assertEquals(ElectricApplianceType.Home, multimediaSpeakers.getElectricApplianceType());
    }

    @Test
    void setElectricApplianceType_whenElectricApplianceTypeIsUnValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> multimediaSpeakers.setElectricApplianceType(null)
        );
    }

    @Test
    void setName_whenNameIsValidate() {
        multimediaSpeakers.setName("TestName");
        assertEquals("TestName", multimediaSpeakers.getName());
    }

    @Test
    void setName_whenNameIsUnValidate() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> multimediaSpeakers.setName("")
        );
    }
}