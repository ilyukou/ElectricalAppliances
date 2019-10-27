package electricAppliance.model.electricAppliance.home;


import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.electricAppliance.ElectricApplianceType;

public abstract class HomeElectricAppliance extends ElectricAppliance {
    private double soundLevel;

    public HomeElectricAppliance(int power, String name, ElectricApplianceType electricApplianceType,
                                 double soundLevel) {
        super(power, name, electricApplianceType);
        setSoundLevel(soundLevel);
    }



    public double getSoundLevel() {
        return soundLevel;
    }

    public void setSoundLevel(final double soundLevel) {
        if(soundLevel < 0){
            throw new IllegalArgumentException("Sound level might been positive");
        }
        this.soundLevel = soundLevel;
    }

}