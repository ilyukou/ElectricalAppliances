package electricAppliance.model.electricAppliance.lighting;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TableLamp extends LightElectricAppliance {

    private static final Logger logger = LogManager.getLogger(TableLamp.class);
    private static final int MIN_HEIGHT = 0;

    private int height;

    public TableLamp(int power, String name, LightCapType lightCapType,
                     LightBulbsType lightBulbsType, int height) {
        super(power, name, lightCapType, lightBulbsType);
        logger.info("Create class by constructor");
        setHeight(height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {

        if (Validator.validate(height, MIN_HEIGHT, Integer::compareTo)) {
            this.height = height;
        } else {
            logger.error("Height must be greater than the minimum");
            throw new IllegalArgumentException("Height must be greater than the minimum");
        }
    }
}
