package electricAppliance.model.electricAppliance.home;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TV extends HomeElectricAppliance implements Cloneable {

    private static final Logger logger = LogManager.getLogger(TV.class);
    private static final int MIN_SCREEN_DIAGONAL = 0;

    private double screenDiagonal;

    public TV(int power, String name, int soundLevel,
              int screenDiagonal) {
        super(power, name, soundLevel);
        logger.info("Create class by constructor");
        setScreenDiagonal(screenDiagonal);
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(int screenDiagonal) {
        if (Validator.validate(screenDiagonal, MIN_SCREEN_DIAGONAL, Integer::compareTo)) {
            this.screenDiagonal = screenDiagonal;
        } else {
            logger.error("Screen diagonal must been more than minimum");
            throw new IllegalArgumentException("Screen diagonal must been positive");
        }

    }
}
