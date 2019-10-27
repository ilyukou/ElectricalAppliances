package electricAppliance.model.electricAppliance.kitchen;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Stove extends KitchenElectricAppliance implements Cloneable{

    private static final Logger logger = LogManager.getLogger(Stove.class);

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
        if(Validator.validate(numberOfBurners,0,4,Integer::compareTo)){
            this.numberOfBurners = numberOfBurners;
        }else {
            logger.error("number Of burners isn't validate");
            throw new IllegalArgumentException(Stove.class +" number Of burners isn't validate");
        }
    }

    @Override
    protected Stove clone() throws CloneNotSupportedException {
        return (Stove) super.clone();
    }
}
