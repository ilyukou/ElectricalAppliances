package electricAppliance.model.electricAppliance.home;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultimediaSpeakers extends HomeElectricAppliance implements Cloneable {

    private static final Logger logger = LogManager.getLogger(MultimediaSpeakers.class);
    private final static int MIN_NUMBERS_OF_SPEAKERS = 1;

    private int numberOfSpeakers;

    public MultimediaSpeakers(int power, String name, int soundLevel,
                              int numberOfSpeakers) {
        super(power, name, soundLevel);
        setNumberOfSpeakers(numberOfSpeakers);
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(final int numberOfSpeakers) {
        if (Validator.validate(numberOfSpeakers, MIN_NUMBERS_OF_SPEAKERS, Integer::compareTo)) {
            this.numberOfSpeakers = numberOfSpeakers;
        } else {
            logger.error("Number of speakers must been more than minimum");
            throw new IllegalArgumentException("Number of speakers must been more than minimum");
        }

    }
}
