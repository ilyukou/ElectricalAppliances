package electricAppliance.model;

import electricAppliance.Validator;
import electricAppliance.model.exception.NotEnoughFreeSocketsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Room  {

    private static final Logger logger = LogManager.getLogger(Room.class);

    private List<ElectricAppliance> electricAppliances = new ArrayList<>();
    private int numberOfSoket;
    private RoomType roomType;

    public Room(List<ElectricAppliance> electricAppliances, int numberOfSoket,
                RoomType roomType) throws NotEnoughFreeSocketsException {
        logger.info("Create class");
        setNumberOfSoket(numberOfSoket);
        setElectricAppliances(electricAppliances);
        setRoomType(roomType);
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        if(Validator.isNull(roomType)){
            throw new IllegalArgumentException("RoomType is null");
        }else {
            this.roomType = roomType;
        }
    }

    public boolean isFreeSocketsExist(){
        return getNumberOfSoket() > getElectricAppliances().size();
    }

    private boolean isEnoughSocketsForElectricAppliance(int numberOfSoket, int appliancesListSize){
        return numberOfSoket >= appliancesListSize;
    }



    public int getPowerInSokets(){

        int power = 0;
        for (ElectricAppliance electricAppliance : getElectricAppliances()){
            power+=electricAppliance.getPower();
        }
        return power;
    }

    public void addElectricalAppliances(ElectricAppliance electricAppliance) throws NotEnoughFreeSocketsException {
        if(!isFreeSocketsExist()){
            logger.error("Not enough free sockets");

            throw new NotEnoughFreeSocketsException("Number of sockets is "+ getNumberOfSoket() +
                    " . You using "+getElectricAppliances().size() +"ElectricAppliances in this Room");
        }
        if( (getElectricAppliances().size() + 1) == getNumberOfSoket()){
            logger.warn("You using all sockets in this room.");
        }
        //this.electricAppliances.add(electricAppliance);
        List<ElectricAppliance> electricAppliances = getElectricAppliances();
        electricAppliances.add(electricAppliance);
        setElectricAppliances(electricAppliances);
    }

    public List<ElectricAppliance> getElectricAppliances() throws NullPointerException {
        return electricAppliances;
    }

    public void setElectricAppliances(List<ElectricAppliance> electricAppliances) throws NotEnoughFreeSocketsException {
        if(!isEnoughSocketsForElectricAppliance(getNumberOfSoket(), electricAppliances.size())){
            logger.error("Not enough free sockets");

            throw new NotEnoughFreeSocketsException("Number of sockets is "+ getNumberOfSoket() +
                    " . You want using "+ electricAppliances.size() +" ElectricAppliances in this Room");
        }
        if(Validator.isNull(electricAppliances)){
            logger.warn(ElectricAppliance.class+" is null");
        }
        this.electricAppliances = electricAppliances;
    }

    public int getNumberOfSoket() {
        return numberOfSoket;
    }

    public void setNumberOfSoket(int numberOfSoket) {
        if(Validator.validate(numberOfSoket,0,10, Integer::compareTo)) {
            this.numberOfSoket = numberOfSoket;
        }else{
            logger.error("Rooms size isn't validate");
            throw new IllegalArgumentException(Room.class +" size isn't validate");
        }
    }

    @Override
    protected Object clone(){
        try {
            Room room =  (Room) super.clone();
            // Can i do this?
            List<ElectricAppliance> electricAppliance = new ArrayList<>();
            electricAppliance.addAll(getElectricAppliances());
            room.electricAppliances = electricAppliances;
            return room;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Error while cloning");
            return null;
        }
    }

}
