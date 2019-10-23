package model.apartment;

import model.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Apartment {
    private static final Logger logger = LogManager.getLogger(Apartment.class);

    private List<Room> rooms;

    public static Apartment build(List<Room> rooms) throws IllegalArgumentException{
        logger.info("Create class "+Apartment.class);

        if(Validator.isNull(rooms)){
            logger.warn("Rooms is null");
        }
        if(Validator.validate(rooms.size(),1, Integer::compareTo)){
            return new Apartment(rooms);
        }

        logger.error(Room.class +" is null or rooms.size() == 0");

        throw new IllegalArgumentException(Room.class + " is null or rooms.size() == 0");
    }

    private Apartment(List<Room> rooms){
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
