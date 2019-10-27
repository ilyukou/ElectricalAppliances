package electricAppliance.model.electricAppliance.sport;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExerciseBike extends SportElectricAppliance {

    private static final Logger logger = LogManager.getLogger(ExerciseBike.class);
    private static final int MIN_MAX_SPEED = 0;

    private int maxSpeed;

    public ExerciseBike(int power, String name, int maxUserWeight,
                        int maxSpeed) {
        super(power, name, maxUserWeight);
        logger.info("Create class by constructor");
        setMaxSpeed(maxSpeed);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (Validator.validate(maxSpeed, MIN_MAX_SPEED, Integer::compareTo)) {
            this.maxSpeed = maxSpeed;
        } else {
            logger.error("Max speed must be greater than the minimum");
            throw new IllegalArgumentException("Max speed must be greater than the minimum");
        }
    }

}
