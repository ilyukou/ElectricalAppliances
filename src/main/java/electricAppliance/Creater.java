package electricAppliance;

import electricAppliance.model.Apartment;
import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.Room;
import electricAppliance.model.RoomType;
import electricAppliance.model.electricAppliance.ElectricApplianceType;
import electricAppliance.model.electricAppliance.home.MultimediaSpeakers;
import electricAppliance.model.electricAppliance.home.TV;
import electricAppliance.model.electricAppliance.kitchen.Microwave;
import electricAppliance.model.electricAppliance.kitchen.Stove;
import electricAppliance.model.electricAppliance.lighting.CeilingLamp;
import electricAppliance.model.electricAppliance.lighting.LightBulbsType;
import electricAppliance.model.electricAppliance.lighting.LightCapType;
import electricAppliance.model.electricAppliance.lighting.TableLamp;
import electricAppliance.model.electricAppliance.sport.ExerciseBike;
import electricAppliance.model.electricAppliance.sport.Treadmill;

import java.util.ArrayList;
import java.util.List;

public class Creater {
    public static Apartment createApartment() {

        // lighting
        TableLamp tableLamp = new TableLamp(60,"Light", LightCapType.E27, LightBulbsType.LED,30);

        CeilingLamp kitchenCeilingLamp = new CeilingLamp(120,"Celight",LightCapType.E14,
                LightBulbsType.Halogen,3);
        CeilingLamp homeCeilingLamp = new CeilingLamp(80,"Celight",LightCapType.E14,
                LightBulbsType.Halogen,3);
        CeilingLamp sportCeilingLamp = new CeilingLamp(150,"Celight",LightCapType.E14,
                LightBulbsType.Halogen,3);

        // kitchen
        Microwave microwave = new Microwave(1000,"Lg",
                3,20);
        Stove stove = new Stove(1500,"Samsung",
                60,4);
        List<ElectricAppliance> kitchenElectricApplianceList = new ArrayList<>();
        kitchenElectricApplianceList.add(tableLamp);
        kitchenElectricApplianceList.add(stove);
        kitchenElectricApplianceList.add(microwave);
        kitchenElectricApplianceList.add(kitchenCeilingLamp);

        // sport
        ExerciseBike exerciseBike = new ExerciseBike(400,"GymBike",150,40);
        Treadmill treadmill = new Treadmill(500,"TreadGym",150,25,
                100,150);
        List<ElectricAppliance> sportElectricApplianceList = new ArrayList<>();
        sportElectricApplianceList.add(exerciseBike);
        sportElectricApplianceList.add(treadmill);
        sportElectricApplianceList.add(sportCeilingLamp);
        sportElectricApplianceList.add(sportCeilingLamp);

        // home
        TV tv = new TV(300,"Atlant",ElectricApplianceType.Home,30,42);
        MultimediaSpeakers multimediaSpeakers = new MultimediaSpeakers(200,"Horizon",
                ElectricApplianceType.Home, 120,5);
        List<ElectricAppliance> homeElectricApplianceList = new ArrayList<>();
        homeElectricApplianceList.add(tableLamp);
        homeElectricApplianceList.add(homeCeilingLamp);
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
