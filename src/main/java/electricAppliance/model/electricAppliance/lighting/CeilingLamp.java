package electricAppliance.model.electricAppliance.lighting;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CeilingLamp extends LightElectricAppliance {
    private static final Logger logger = LogManager.getLogger(CeilingLamp.class);
    private static final int MIN_WEIGHT = 0;

    private int weight;

    public CeilingLamp(int power, String name, LightCapType lightCapType,
                       LightBulbsType lightBulbsType, int weight) {
        super(power, name, lightCapType, lightBulbsType);
        logger.info("Create class by constructor");
        setWeight(weight);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (Validator.validate(weight, MIN_WEIGHT, Integer::compareTo)) {
            this.weight = weight;
        } else {
            logger.error("Weight must be greater than the minimum");
            throw new IllegalArgumentException("Weight must be greater than the minimum");
        }

    }
}
