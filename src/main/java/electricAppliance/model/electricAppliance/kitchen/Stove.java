package electricAppliance.model.electricAppliance.kitchen;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stove extends KitchenElectricAppliance implements Cloneable {

    private static final Logger logger = LogManager.getLogger(Stove.class);
    private static final int MIN_NUMBERS_OF_BURNERS = 1;
    private static final int MAX_NUMBERS_OF_BURNERS = 4;

    private int numberOfBurners;

    public Stove(int power, String name,
                 int cookingTime, int numberOfBurners) {
        super(power, name, cookingTime);
        logger.info("Create class by constructor");
        setNumberOfBurners(numberOfBurners);
    }

    public int getNumberOfBurners() {
        return numberOfBurners;
    }

    public void setNumberOfBurners(int numberOfBurners) {
        if (Validator.validate(numberOfBurners, MIN_NUMBERS_OF_BURNERS, MAX_NUMBERS_OF_BURNERS, Integer::compareTo)) {
            this.numberOfBurners = numberOfBurners;
        } else {
            logger.error("Number of burners must be greater than the minimum and less than maximum");
            throw new IllegalArgumentException("Number of burners must be greater than the " +
                    "minimum and less than maximum");
        }
    }
}
