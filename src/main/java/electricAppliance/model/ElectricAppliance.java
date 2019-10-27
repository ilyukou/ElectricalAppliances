package electricAppliance.model;

import electricAppliance.Validator;
import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ElectricAppliance implements Cloneable {

    private static final Logger logger = LogManager.getLogger(ElectricAppliance.class);

    private int power;
    private String name;
    private ElectricApplianceType electricApplianceType;

    private final static int MIN_POWER = 0;

    public ElectricAppliance(int power, String name, ElectricApplianceType electricApplianceType) {
        logger.info("Create class by constructor");
        setElectricApplianceType(electricApplianceType);
        setName(name);
        setPower(power);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) throws IllegalArgumentException {
        if (Validator.validate(power, MIN_POWER, Integer::compareTo)) {
            this.power = power;
        } else {
            logger.error("int power isn't validate");
            throw new IllegalArgumentException(ElectricAppliance.class + " power isn't validate");
        }
    }

    public ElectricApplianceType getElectricApplianceType() {
        return electricApplianceType;
    }

    public void setElectricApplianceType(ElectricApplianceType electricApplianceType) {
        if (Validator.isNotNull(electricApplianceType)) {
            this.electricApplianceType = electricApplianceType;
        } else {
            logger.error(ElectricAppliance.class + " ElectricApplianceType isn't validate");
            throw new IllegalArgumentException(ElectricAppliance.class + " size isn't validate");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Validator.isNotEmpty(name)) {
            this.name = name;
        } else {
            logger.error("String name : is empty");
            throw new IllegalArgumentException(ElectricAppliance.class + " : String name - is empty");
        }
    }
}
