package model.electricAppliance.kitchen;

import model.ElectricApplianceType;
import model.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Microwave extends KitchenElectricAppliance implements Cloneable{

    private static final Logger logger = LogManager.getLogger(Microwave.class);

    private int volume;

    public Microwave(int power, String name, ElectricApplianceType electricApplianceType,
                      int cookingTime, int volume) {
        super(power,name,electricApplianceType,cookingTime);
        logger.info("Create class by constructor");
        setVolume(volume);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(Validator.validate(volume,0,Integer::compareTo)){
            this.volume = volume;

        }else {
            logger.error("volume isn't validate");
            throw new IllegalArgumentException(Microwave.class +" size isn't validate");
        }
    }

    @Override
    protected Microwave clone() throws CloneNotSupportedException {
        return (Microwave) super.clone();
    }
}