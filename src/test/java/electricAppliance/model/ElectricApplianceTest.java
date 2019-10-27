package electricAppliance.model;

import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ElectricApplianceTest {
    private ElectricAppliance electricAppliance = Mockito.mock(ElectricAppliance.class);

    @BeforeEach
    void setUp() {
        /*
        when(electricAppliance.getPower()).thenReturn(10);
        when(electricAppliance.getName()).thenReturn("A");
        when(electricAppliance.getElectricApplianceType()).thenReturn(ElectricApplianceType.Home);
*/
        Mockito.doCallRealMethod().when(electricAppliance).setName("Test");
        Mockito.doCallRealMethod().when(electricAppliance).getName();

        Mockito.doCallRealMethod().when(electricAppliance).setPower(10);
        Mockito.doCallRealMethod().when(electricAppliance).getPower();

        Mockito.doCallRealMethod().when(electricAppliance).setElectricApplianceType(ElectricApplianceType.Home);
        Mockito.doCallRealMethod().when(electricAppliance).getElectricApplianceType();
    }

    @Test
    void setPower() {
        electricAppliance.setElectricApplianceType(ElectricApplianceType.Home);

    }

    @Test
    void getElectricApplianceType() {
    }

    @Test
    void setElectricApplianceType() {
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void testClone() {
    }
}