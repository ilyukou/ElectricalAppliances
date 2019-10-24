package model.electricAppliance.kitchen;

import model.ElectricAppliance;
import model.ElectricApplianceType;
import model.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class KitchenElectricAppliance extends ElectricAppliance implements Cloneable{

    private static final Logger logger = LogManager.getLogger(KitchenElectricAppliance.class);

    private int cookingTime;

    public KitchenElectricAppliance(int power, String name, ElectricApplianceType electricApplianceType,
                                    int cookingTime) {
        super(power, name, electricApplianceType);
        setCookingTime(cookingTime);
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {

        if(Validator.validate(cookingTime,0,Integer::compareTo)){
            this.cookingTime = cookingTime;

        }else {
            logger.error("cookingTime isn't validate");
            throw new IllegalArgumentException(KitchenElectricAppliance.class +" size isn't validate");
        }
    }

    @Override
    protected KitchenElectricAppliance clone() throws CloneNotSupportedException {
        return (KitchenElectricAppliance) super.clone();
    }
}
