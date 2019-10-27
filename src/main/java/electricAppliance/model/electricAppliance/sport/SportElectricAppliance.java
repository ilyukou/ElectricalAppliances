package electricAppliance.model.electricAppliance.sport;


import electricAppliance.Validator;
import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class SportElectricAppliance extends ElectricAppliance {

    private static final Logger logger = LogManager.getLogger(SportElectricAppliance.class);
    private static final int MIN_USER_WEIGHT = 0;
    private static final ElectricApplianceType ELECTRIC_APPLIANCE_TYPE = ElectricApplianceType.Sport;

    private int maxUserWeight;

    public SportElectricAppliance(int power, String name,
                                  int maxUserWeight) {
        super(power, name, ELECTRIC_APPLIANCE_TYPE);
        logger.info("Create class by constructor");
        setMaxUserWeight(maxUserWeight);
    }


    public int getMaxUserWeight() {
        return maxUserWeight;
    }

    public void setMaxUserWeight(int maxUserWeight) {
        if (Validator.validate(maxUserWeight, MIN_USER_WEIGHT, Integer::compareTo)) {
            this.maxUserWeight = maxUserWeight;
        } else {
            logger.error("Max user weight must be greater than the minimum");
            throw new IllegalArgumentException("Max user weight must be greater than the minimum");
        }

    }
}
