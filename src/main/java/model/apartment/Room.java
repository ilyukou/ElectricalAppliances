package model.apartment;

import model.ElectricAppliance;
import model.Validator;
import model.exception.NotEnoughFreeSockets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Room implements Cloneable{

    private static final Logger logger = LogManager.getLogger(Room.class);

    private List<ElectricAppliance> electricAppliances = new ArrayList<>();
    private int numberOfSoket;

    public Room(List<ElectricAppliance> electricAppliances, int numberOfSoket) throws NotEnoughFreeSockets{
        logger.info("Create class");
        setNumberOfSoket(numberOfSoket);
        setElectricAppliances(electricAppliances);

    }

    public boolean isFreeSocketsExist(){
        return getNumberOfSoket() > getElectricAppliances().size();
    }
    public boolean isEnoughSocketsForElectricAppliance(int numberOfSoket, int appliancesListSize){
        return numberOfSoket >= appliancesListSize;
    }



    public int getPowerInSokets(){

        int power = 0;
        for (ElectricAppliance electricAppliance : getElectricAppliances()){
            power+=electricAppliance.getPower();
        }
        return power;
    }

    private void addElectricalAppliances(ElectricAppliance electricAppliance) throws NotEnoughFreeSockets{
        if(!isFreeSocketsExist()){
            logger.error("Not enough free sockets");

            throw new NotEnoughFreeSockets("Number of sockets is "+ getNumberOfSoket() +
                    " . You using "+getElectricAppliances().size() +"ElectricAppliances in this Room");
        }
        if( (getElectricAppliances().size() + 1) == getNumberOfSoket()){
            logger.warn("You using all sockets in this room.");
        }
        this.electricAppliances.add(electricAppliance);
    }

    public List<ElectricAppliance> getElectricAppliances() throws NullPointerException {
        return electricAppliances;
    }

    public void setElectricAppliances(List<ElectricAppliance> electricAppliances) throws NotEnoughFreeSockets{
        if(!isEnoughSocketsForElectricAppliance(getNumberOfSoket(), electricAppliances.size())){
            logger.error("Not enough free sockets");

            throw new NotEnoughFreeSockets("Number of sockets is "+ getNumberOfSoket() +
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
    protected Object clone() throws CloneNotSupportedException {
        Room room =  (Room) super.clone();
        // Can i do this?
        List<ElectricAppliance> electricAppliance = new ArrayList<>();
        electricAppliance.addAll(getElectricAppliances());
        room.electricAppliances = electricAppliances;
        return room;
    }

}
