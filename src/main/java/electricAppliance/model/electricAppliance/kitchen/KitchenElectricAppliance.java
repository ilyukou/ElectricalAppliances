package electricAppliance.model.electricAppliance.kitchen;

import electricAppliance.Validator;
import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class KitchenElectricAppliance extends ElectricAppliance implements Cloneable{

    private static final Logger logger = LogManager.getLogger(KitchenElectricAppliance.class);
    private static final ElectricApplianceType ELECTRIC_APPLIANCE_TYPE = ElectricApplianceType.Kitchen;
    private int cookingTime;

    public KitchenElectricAppliance(int power, String name,
                                    int cookingTime) {
        super(power, name, ELECTRIC_APPLIANCE_TYPE);
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
