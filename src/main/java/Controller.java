import model.ElectricAppliance;
import model.ElectricApplianceType;
import model.apartment.Apartment;
import model.apartment.Room;
import model.electricAppliance.kitchen.Microwave;
import model.exception.NotEnoughFreeSockets;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public Apartment createApartment(){

        Microwave microwave = new Microwave(1000,"Lg", ElectricApplianceType.Kitchen,
                3,20);
        Microwave m1 = new Microwave(425,"Lg", ElectricApplianceType.Kitchen,
                3,20);
        Microwave m2 = new Microwave(1424,"Lg", ElectricApplianceType.Kitchen,
                3,20);

        List<ElectricAppliance> list = new ArrayList<>();

        list.add(microwave);
        list.add(microwave);
        list.add(m2);
        list.add(m1);
        list.add(microwave);

        List<Room> rooms = new ArrayList<>();

        try {
            rooms.add(new Room(list,6));
        } catch (NotEnoughFreeSockets notEnoughFreeSockets) {
            notEnoughFreeSockets.printStackTrace();
            throw new RuntimeException("Exception while create "+Apartment.class);
        }

        return new Apartment(rooms);
    }
}
