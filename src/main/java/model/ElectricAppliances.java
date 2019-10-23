package model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ElectricAppliances {

    private static final Logger logger = LogManager.getLogger(ElectricAppliances.class);

    private int power;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        // можно ли так делать, если нету build() ?
        if(Validator.validate(power,0,Integer::compareTo)){
            this.power = power;
        }
        logger.error(ElectricAppliances.class +" size isn't validate");
        throw new IllegalArgumentException(ElectricAppliances.class +" size isn't validate");

    }
}
