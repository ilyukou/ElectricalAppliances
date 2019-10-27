package electricAppliance.model.electricAppliance.kitchen;

import electricAppliance.Validator;
import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class KitchenElectricAppliance extends ElectricAppliance implements Cloneable {

    private static final Logger logger = LogManager.getLogger(KitchenElectricAppliance.class);
    private static final ElectricApplianceType ELECTRIC_APPLIANCE_TYPE = ElectricApplianceType.Kitchen;
    private static final int MIN_COOKING_TIME = 0;

    private int cookingTime;

    public KitchenElectricAppliance(int power, String name,
                                    int cookingTime) {
        super(power, name, ELECTRIC_APPLIANCE_TYPE);
        logger.info("Create class by constructor");
        setCookingTime(cookingTime);
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {

        if (Validator.validate(cookingTime, MIN_COOKING_TIME, Integer::compareTo)) {
            this.cookingTime = cookingTime;
        } else {
            logger.error("Cooking time must been more than minimum");
            throw new IllegalArgumentException("Cooking time must been more than minimum");
        }
    }
}
