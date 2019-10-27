package electricAppliance.model.comporators;

import electricAppliance.model.ElectricAppliance;

import java.util.Comparator;

public class ElectricApplianceCompareByPower implements Comparator<ElectricAppliance> {

    @Override
    public int compare(ElectricAppliance o1, ElectricAppliance o2) {
        /*
         * Short version
         * return Integer.compare(o1.getPower(), o2.getPower();
         */

        if (o1.getPower() > o2.getPower()) {
            return 1;
        } else if (o1.getPower() < o2.getPower()) {
            return -1;
        } else {
            return 0;
        }

    }
}
