import model.ElectricAppliance;
import model.ElectricApplianceType;
import model.apartment.Apartment;
import model.apartment.Room;
import model.apartment.RoomType;
import model.electricAppliance.home.MultimediaSpeakers;
import model.electricAppliance.home.TV;
import model.electricAppliance.kitchen.Microwave;
import model.electricAppliance.kitchen.Stove;
import model.electricAppliance.lighting.CeilingLamp;
import model.electricAppliance.lighting.LightBulbsType;
import model.electricAppliance.lighting.LightCapType;
import model.electricAppliance.lighting.TableLamp;
import model.electricAppliance.sport.ExerciseBike;
import model.electricAppliance.sport.Treadmill;

import java.util.ArrayList;
import java.util.List;

class Controller {
    Apartment createApartment() {

        // lighting
        TableLamp tableLamp = new TableLamp(60,"Light", LightCapType.E27, LightBulbsType.LED,30);
        CeilingLamp ceilingLamp = new CeilingLamp(150,"Celight",LightCapType.E14,
                LightBulbsType.Halogen,3);

        // kitchen
        Microwave microwave = new Microwave(1000,"Lg", ElectricApplianceType.Kitchen,
                3,20);
        Stove stove = new Stove(1500,"Samsung",ElectricApplianceType.Kitchen,
                60,4);
        List<ElectricAppliance> kitchenElectricApplianceList = new ArrayList<>();
        kitchenElectricApplianceList.add(tableLamp);
        kitchenElectricApplianceList.add(stove);
        kitchenElectricApplianceList.add(microwave);
        kitchenElectricApplianceList.add(ceilingLamp);

        // sport
        ExerciseBike exerciseBike = new ExerciseBike(400,"GymBike",150,40);
        Treadmill treadmill = new Treadmill(500,"TreadGym",150,25,
                100,150);
        List<ElectricAppliance> sportElectricApplianceList = new ArrayList<>();
        sportElectricApplianceList.add(exerciseBike);
        sportElectricApplianceList.add(treadmill);
        sportElectricApplianceList.add(ceilingLamp);
        sportElectricApplianceList.add(ceilingLamp);

        // home
        TV tv = new TV(300,"Atlant",ElectricApplianceType.Home,30,42);
        MultimediaSpeakers multimediaSpeakers = new MultimediaSpeakers(200,"Horizon",
                ElectricApplianceType.Home, 120,5);
        List<ElectricAppliance> homeElectricApplianceList = new ArrayList<>();
        homeElectricApplianceList.add(tableLamp);
        homeElectricApplianceList.add(ceilingLamp);
        homeElectricApplianceList.add(tv);
        homeElectricApplianceList.add(multimediaSpeakers);


        List<Room> rooms = new ArrayList<>();
        try {
            rooms.add(new Room(sportElectricApplianceList,6, RoomType.Sport));
            rooms.add(new Room(kitchenElectricApplianceList,7,RoomType.Kitchen));
            rooms.add(new Room(homeElectricApplianceList,7,RoomType.LivingRoom));
        }catch (Exception e){
            e.printStackTrace();
        }

        return new Apartment(rooms);
    }
}
