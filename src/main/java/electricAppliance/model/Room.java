package electricAppliance.model;

import electricAppliance.Validator;
import electricAppliance.model.exception.NotEnoughFreeSocketsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private static final Logger logger = LogManager.getLogger(Room.class);

    private List<ElectricAppliance> electricAppliances = new ArrayList<>();
    private static final int MIN_NUMBERS_OF_SOCKETS = 1;
    private static final int MAX_NUMBERS_OF_SOCKETS = 10;

    private int numberOfSoket;
    private RoomType roomType;

    public Room(List<ElectricAppliance> electricAppliances, int numberOfSoket,
                RoomType roomType) throws NotEnoughFreeSocketsException {

        logger.info("Create class");
        setNumberOfSockets(numberOfSoket);
        setElectricAppliances(electricAppliances);
        setRoomType(roomType);
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        if (Validator.isNotNull(roomType)) {
            this.roomType = roomType;
        } else {
            logger.error("RoomType is null");
            throw new IllegalArgumentException("RoomType is null");
        }
    }

    public boolean isFreeSocketsExist() {
        return getNumberOfSockets() > getElectricAppliances().size();
    }

    public int getPowerInSokets() {
        int power = 0;
        for (ElectricAppliance electricAppliance : getElectricAppliances()) {
            power += electricAppliance.getPower();
        }
        return power;
    }

    public void addElectricalAppliances(ElectricAppliance electricAppliance) throws NotEnoughFreeSocketsException {
        if (!isFreeSocketsExist()) {
            logger.error("Number of sockets is " + getNumberOfSockets() +
                    " . You using " + getElectricAppliances().size() + "ElectricAppliances in this Room");

            throw new NotEnoughFreeSocketsException("Number of sockets is " + getNumberOfSockets() +
                    " . You using " + getElectricAppliances().size() + "ElectricAppliances in this Room");
        }
        if ((getElectricAppliances().size() + 1) == getNumberOfSockets()) {
            logger.warn("You using all sockets in this room.");
        }

        List<ElectricAppliance> electricAppliances = getElectricAppliances();
        electricAppliances.add(electricAppliance);
        setElectricAppliances(electricAppliances);
    }

    public List<ElectricAppliance> getElectricAppliances() throws NullPointerException {
        return electricAppliances;
    }

    public void setElectricAppliances(List<ElectricAppliance> electricAppliances) throws NotEnoughFreeSocketsException {

        if (Validator.isNull(electricAppliances)) {
            logger.error("List<ElectricAppliance> is null");
            throw new IllegalArgumentException("List<ElectricAppliance> is null");
        }

        if (!isEnoughSocketsForElectricAppliance(getNumberOfSockets(), electricAppliances.size())) {

            logger.error("Number of sockets is " + getNumberOfSockets() +
                    " . You want using " + electricAppliances.size() + " ElectricAppliances in this Room");
            throw new NotEnoughFreeSocketsException("Number of sockets is " + getNumberOfSockets() +
                    " . You want using " + electricAppliances.size() + " ElectricAppliances in this Room");
        }

        this.electricAppliances = electricAppliances;
    }

    public int getNumberOfSockets() {
        return numberOfSoket;
    }

    public void setNumberOfSockets(int numberOfSockets) {
        if (Validator.validate(numberOfSockets, MIN_NUMBERS_OF_SOCKETS, MAX_NUMBERS_OF_SOCKETS, Integer::compareTo)) {
            this.numberOfSoket = numberOfSockets;
        } else {
            logger.error("Number of sockets must be greater than the minimum and less than maximum");
            throw new IllegalArgumentException("Number of sockets must be greater than the " +
                    "minimum and less than maximum");
        }
    }

    private boolean isEnoughSocketsForElectricAppliance(int numberOfSockets, int appliancesListSize) {
        return numberOfSockets >= appliancesListSize;
    }
}
