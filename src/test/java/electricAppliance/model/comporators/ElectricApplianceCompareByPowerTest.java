package electricAppliance.model.comporators;

import electricAppliance.model.ElectricAppliance;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ElectricApplianceCompareByPowerTest {

    private ElectricAppliance first = Mockito.mock(ElectricAppliance.class);
    private ElectricAppliance second = Mockito.mock(ElectricAppliance.class);

    private ElectricApplianceCompareByPower comparatorByPower = new ElectricApplianceCompareByPower();

    @Test
    void compare_whenFirstMoreThanSecond() {

        when(first.getPower()).thenReturn(10);
        when(second.getPower()).thenReturn(5);

        int res = comparatorByPower.compare(first, second);
        assertEquals(1, res);
    }

    @Test
    void compare_whenSecondMoreThanFirst() {
        when(first.getPower()).thenReturn(10);
        when(second.getPower()).thenReturn(5);

        int res = comparatorByPower.compare(second, first);
        assertEquals(-1, res);
    }

    @Test
    void compare_whenBothEqual() {
        when(first.getPower()).thenReturn(10);
        when(second.getPower()).thenReturn(10);

        int res = comparatorByPower.compare(first, second);
        assertEquals(0, res);
    }
}