package electricAppliance.model;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Apartment implements Cloneable {

    private static final Logger logger = LogManager.getLogger(Apartment.class);
    private static final Comparator<ElectricAppliance> COMPARATOR =
            Comparator.comparing(ElectricAppliance::getPower);
    private List<Room> rooms;

    public Apartment(List<Room> rooms){
        logger.info("Create class by constructor");
        setRooms(rooms);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) throws IllegalArgumentException {
        if (!Validator.isValidList(rooms)) {
            logger.error("List<Room> is null or size is 0");
            throw new IllegalArgumentException("List<Room> is null or size is 0");
        }
        this.rooms = rooms;
    }

    public void addRooms(List<Room> rooms) {
        if (!Validator.isValidList(rooms)) {
            logger.error("Exit from the addRooms() : List<Room> is null or size is 0");
            throw new IllegalArgumentException("Exit from the addRooms() : List<Room> is null or size is 0");
        } else {
            List<Room> r = getRooms();
            r.addAll(rooms);
            setRooms(r);
        }
    }

    public void addRoom(Room room){
        if (!Validator.isNotNull(room)) {
            logger.error("Exit from the addRoom() : Room  is null");
            throw new IllegalArgumentException("Exit from the addRoom() : Room  is null");
        } else {
            List<Room> r = getRooms();
            r.add(room);
            setRooms(r);
        }
    }


    public int getPowerInRooms() {
        int power = 0;
        for (Room room : getRooms()) {
            power += room.getPowerInSokets();
        }
        return power;
    }

    public List<ElectricAppliance> getAllElectricAppliance(){

        List<ElectricAppliance> list = new ArrayList<>();
        for (Room r : getRooms()){
            list.addAll(r.getElectricAppliances());
        }
        return list;
    }

    public ElectricAppliance searchElectricApplianceByPower(List<ElectricAppliance> list,
                                                            int min, int max){
        //return first found electric appliance with requested parameters

        ElectricAppliance foundElectricAppliance;

        for (ElectricAppliance electricAppliance : list){
            if(Validator.validate(electricAppliance.getPower(),min,max, Integer::compareTo)){
                return electricAppliance;
            }
        }
        logger.warn("Don't found ElectricAppliance with such parameters");
        return null;
    }

    public List<ElectricAppliance> sortElectricApplianceByPower(List<ElectricAppliance> list){

        logger.trace("Sorting start");

        list.sort(COMPARATOR);

        logger.trace("Sorting ended");

        return list;
    }


    @Override
    public Object clone() {
        try {
            Apartment apartment = (Apartment)super.clone();
            // Can i do this?
            List<Room> rooms = new ArrayList<>();
            rooms.addAll(getRooms());
            apartment.rooms = rooms;

            return apartment;
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("Error while clone(). return null");
            return null;
        }

    }
}
