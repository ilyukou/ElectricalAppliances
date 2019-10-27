import electricAppliance.Creater;
import electricAppliance.model.Apartment;
import electricAppliance.model.ElectricAppliance;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //testClone();
        sort();

        // create Apartment with Rooms and ElectricAppliance in them
        Apartment apartmentList = Creater.createApartment();

        System.out.println("Power in apartment " + apartmentList.getPowerInRooms());

        // Sorting List<ElectricAppliance> by power
        List<ElectricAppliance> sorted = apartmentList
                .sortElectricApplianceByPower(apartmentList.getAllElectricAppliance());

        // Searching ElectricAppliance by min and max power
        ElectricAppliance foundElectricAppliance = apartmentList
                .searchElectricApplianceByPower(apartmentList.getAllElectricAppliance(), 10, 1005);

        System.out.println("Found " + foundElectricAppliance.getName() + " power " + foundElectricAppliance.getPower());

        System.out.println();

    }

    public static void sort() {
        Apartment apartment = Creater.createApartment();
        List<ElectricAppliance> sort = apartment.sortElectricApplianceByPower(apartment.getAllElectricAppliance());

        for (int i = 1; i < sort.size(); i++) {
            System.out.println("Sorted " + sort.get(i).getPower());
        }
        System.out.println();
    }
}
