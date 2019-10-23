package model.apartment;

import model.ElectricAppliances;
import model.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private static final Logger logger = LogManager.getLogger(Room.class);

    private List<ElectricAppliances> electricAppliances = new ArrayList<>();
    private int numberOfSoket;

    public static Room build(List<ElectricAppliances> electricAppliances,
                             int numberOfSoket ) throws IllegalArgumentException{

        logger.info("Create " + Room.class);

        if(Validator.isNull(electricAppliances)){
            logger.warn(ElectricAppliances.class+" is null");
        }
        if(Validator.validate(numberOfSoket,0,10, Integer::compareTo)) {
               return new Room(electricAppliances,numberOfSoket);
        }
        logger.error("Rooms size isn't validate");
        throw new IllegalArgumentException(Room.class +" size isn't validate");
    }

    public void join(ElectricAppliances electricAppliances){
        if(getNumberOfSoket() > getElectricAppliances().size()){
            addElectricalAppliances(electricAppliances);
        }
    }


    private void addElectricalAppliances(ElectricAppliances electricAppliances){
        this.electricAppliances.add(electricAppliances);
    }

    private Room(List<ElectricAppliances> electricAppliances, int numberOfSoket) {
        this.electricAppliances = electricAppliances;
        this.numberOfSoket = numberOfSoket;
    }

    public List<ElectricAppliances> getElectricAppliances() throws NullPointerException {
        return electricAppliances;
    }

    public int getNumberOfSoket() {
        return numberOfSoket;
    }
}
