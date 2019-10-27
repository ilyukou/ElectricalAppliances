import electricAppliance.model.Apartment;
import electricAppliance.model.ElectricAppliance;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Creater creater = new Creater();

        // create Apartment with Rooms and ElectricAppliance in them
        Apartment apartmentList = creater.createApartment();

        System.out.println("Power in apartment "+apartmentList.getPowerInRooms());

        // Sorting List<ElectricAppliance> by power
        List<ElectricAppliance> sortElectricApplianceByPower =  apartmentList
                .sortElectricApplianceByPower(apartmentList.getAllElectricAppliance());

        // Searching ElectricAppliance by min and max power
        ElectricAppliance foundElectricAppliance = apartmentList
                .searchElectricApplianceByPower(apartmentList.getAllElectricAppliance(),10,1005);

        System.out.println("Found "+foundElectricAppliance.getName()+ " power "+foundElectricAppliance.getPower());

        System.out.println();

    }
}
