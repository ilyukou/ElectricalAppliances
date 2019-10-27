package electricAppliance.model.electricAppliance.home;

import electricAppliance.Validator;
import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultimediaSpeakers extends HomeElectricAppliance implements Cloneable{

    private static final Logger logger = LogManager.getLogger(MultimediaSpeakers.class);

    private int numberOfSpeakers;

    public MultimediaSpeakers(int power, String name, ElectricApplianceType electricApplianceType, int soundLevel,
                              int numberOfSpeakers) {
        super(power, name, electricApplianceType, soundLevel);
        setNumberOfSpeakers(numberOfSpeakers);
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(final int numberOfSpeakers) {
        if(Validator.validate(numberOfSpeakers,0,Integer::compareTo)){
            this.numberOfSpeakers = numberOfSpeakers;

        }else {
            logger.error("Number of speakers might been positive");
            throw new IllegalArgumentException("Number of speakers might been positive");
        }

    }

    @Override
    public MultimediaSpeakers clone() {
        try {
            MultimediaSpeakers multimediaSpeakers = (MultimediaSpeakers)super.clone();
            return multimediaSpeakers;
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("Error while clone(). return null");
            return null;
        }

    }
}
