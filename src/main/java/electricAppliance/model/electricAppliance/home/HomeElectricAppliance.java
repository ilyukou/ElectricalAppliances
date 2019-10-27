package electricAppliance.model.electricAppliance.home;


import electricAppliance.Validator;
import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class HomeElectricAppliance extends ElectricAppliance {

    private static final Logger logger = LogManager.getLogger(HomeElectricAppliance.class);

    private int soundLevel;

    public HomeElectricAppliance(int power, String name, ElectricApplianceType electricApplianceType,
                                 int soundLevel) {
        super(power, name, electricApplianceType);
        setSoundLevel(soundLevel);
    }



    public double getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(final int soundLevel) throws IllegalArgumentException{
        if(Validator.validate(soundLevel,0,Integer::compareTo)){
            this.soundLevel = soundLevel;
        }else {
            logger.error("int power : isn't validate");
            throw new IllegalArgumentException(ElectricAppliance.class +" power isn't validate");
        }
    }

    @Override
    public HomeElectricAppliance clone() {
        try {
            HomeElectricAppliance apartment = (HomeElectricAppliance)super.clone();
            return apartment;
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("Error while clone(). return null");
            return null;
        }

    }

}
