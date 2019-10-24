import model.ElectricAppliance;
import model.apartment.Apartment;
import model.comporators.ElectricApplianceComparatorByPower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        Apartment apartment = controller.createApartment();

        System.out.println(apartment.getPowerInRooms());
        System.out.println();
        apartment.getAllElectricAppliance().sort(new ElectricApplianceComparatorByPower());
        System.out.println();
    }
}
