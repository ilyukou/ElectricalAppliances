package electricAppliance.model.electricAppliance.home;


import electricAppliance.Validator;
import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class HomeElectricAppliance extends ElectricAppliance {

    private static final Logger logger = LogManager.getLogger(HomeElectricAppliance.class);
    private static final ElectricApplianceType ELECTRIC_APPLIANCE_TYPE = ElectricApplianceType.Home;
    private final static int MIN_SOUND_LEVEL = 0;

    private int soundLevel;

    public HomeElectricAppliance(int power, String name,
                                 int soundLevel) {
        super(power, name, ELECTRIC_APPLIANCE_TYPE);
        logger.info("Create class by constructor");
        setSoundLevel(soundLevel);
    }

    public double getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(final int soundLevel) throws IllegalArgumentException {
        if (Validator.validate(soundLevel, MIN_SOUND_LEVEL, Integer::compareTo)) {
            this.soundLevel = soundLevel;
        } else {
            logger.error("Sound level must been more than minimum");
            throw new IllegalArgumentException("Sound level must been more than minimum");
        }
    }
}
