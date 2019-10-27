import electricAppliance.Creater;
import electricAppliance.model.Apartment;
import electricAppliance.model.ElectricAppliance;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException, CloneNotSupportedException {
        //testClone();
        sort();

        // create Apartment with Rooms and ElectricAppliance in them
        Apartment apartmentList = Creater.createApartment();

        System.out.println("Power in apartment "+apartmentList.getPowerInRooms());

        // Sorting List<ElectricAppliance> by power
        apartmentList.sortElectricApplianceByPower();

        // Searching ElectricAppliance by min and max power
        ElectricAppliance foundElectricAppliance = apartmentList
                .searchElectricApplianceByPower(apartmentList.getAllElectricAppliance(),10,1005);

        System.out.println("Found "+foundElectricAppliance.getName()+ " power "+foundElectricAppliance.getPower());

        System.out.println();

    }
    public static void testClone() throws CloneNotSupportedException {
        Apartment apartment = Creater.createApartment();
        System.out.println(apartment.getRooms().size());

        Apartment newApart = (Apartment) apartment.clone();


        apartment.addRooms(apartment.getRooms());
        System.out.println(apartment.getRooms().size());
        System.out.println(newApart.getRooms().size());


        System.out.println();
    }
    public static void sort(){
        Apartment apartment = Creater.createApartment();
        List<ElectricAppliance> sort = apartment.sortElectricApplianceByPower(apartment.getAllElectricAppliance());

        for (int i=1; i<sort.size(); i++){
            System.out.println(sort.get(i).getPower());
        }
        System.out.println();
    }
}
