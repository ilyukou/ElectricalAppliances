package electricAppliance.model.electricAppliance.kitchen;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Microwave extends KitchenElectricAppliance {

    private static final Logger logger = LogManager.getLogger(Microwave.class);
    private static final int MIN_VOLUME = 0;

    private int volume;

    public Microwave(int power, String name,
                     int cookingTime, int volume) {
        super(power, name, cookingTime);
        logger.info("Create class by constructor");
        setVolume(volume);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (Validator.validate(volume, MIN_VOLUME, Integer::compareTo)) {
            this.volume = volume;
        } else {
            logger.error("The volume must be greater than the minimum");
            throw new IllegalArgumentException("The volume must be greater than the minimum");
        }
    }

}
