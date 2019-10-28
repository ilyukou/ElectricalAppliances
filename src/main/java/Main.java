import electricAppliance.Creater;
import electricAppliance.model.Apartment;
import electricAppliance.model.ElectricAppliance;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Sort the ElectricAppliance in the Apartment by power;
        sort();

        Apartment apartmentList = Creater.createApartment();

        // Searching ElectricAppliance by min and max power
        ElectricAppliance foundElectricAppliance = apartmentList
                .searchElectricApplianceByPower(apartmentList.getAllElectricAppliance(), 165, 201);
        System.out.println("Found ElectricAppliance : Name " + foundElectricAppliance.getName() + " Power "+foundElectricAppliance.getPower());


        // calculate power in Apartment
        System.out.println("Power in Apartment "+apartmentList.getPowerInApartment());

        // Number of rooms
        System.out.println("Number of rooms " +apartmentList.getRooms().size());

        // Number of ElectricAppliance
        System.out.println("Number of ElectricAppliance "+apartmentList.getAllElectricAppliance().size());

    }

    public static void sort() {
        Apartment apartment = Creater.createApartment();
        List<ElectricAppliance> list = apartment.getAllElectricAppliance();

        System.out.println("Unsorted List:");
        display(list);

        // Sorting
        apartment.sortElectricApplianceByPower(list);

        System.out.println("Sorted List:");
        display(list);
    }

    private static void display(List<ElectricAppliance> list){
        for (int i = 1; i < list.size(); i++) {
            System.out.println(i+". " + list.get(i).getPower());
        }
    }
}
