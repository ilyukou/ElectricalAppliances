package model.apartment;

import model.ElectricAppliance;
import model.Validator;
import model.comporators.ElectricApplianceComparatorByPower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Apartment implements Cloneable {

    private static final Logger logger = LogManager.getLogger(Apartment.class);

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

    public void addRoom(List<Room> rooms) {
        if (!Validator.isValidList(rooms)) {
            logger.error("Exit from the addRoom() : List<Room> is null or size is 0");
            // throw new E ????
        } else {
            List<Room> r = getRooms();
            r.addAll(rooms);
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
        for (Room room : getRooms()){
            for (ElectricAppliance electricAppliance : room.getElectricAppliances()){
                list.add(electricAppliance);
            }
        }
        return list;
    }

    public ElectricAppliance searchElectricApplianceByProperties(ElectricAppliance o1, ElectricAppliance o2){
        ElectricAppliance foundElectricAppliance;
        for (ElectricAppliance electricAppliance : getAllElectricAppliance()){
            if(Validator.validate(electricAppliance,o1,o2, new ElectricApplianceComparatorByPower())){
                return electricAppliance;
            }
        }
        return null;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Apartment apartment = (Apartment)super.clone();
        // Can i do this?
        List<Room> rooms = new ArrayList<>();
        rooms.addAll(getRooms());
        apartment.rooms = rooms;

        return apartment;
    }
}
