package electricAppliance.model.electricAppliance.home;

import electricAppliance.model.electricAppliance.ElectricApplianceType;

public class MultimediaSpeakers extends HomeElectricAppliance{
    private int numberOfSpeakers;

    public MultimediaSpeakers(int power, String name, ElectricApplianceType electricApplianceType, double soundLevel,
                              int numberOfSpeakers) {
        super(power, name, electricApplianceType, soundLevel);
        setNumberOfSpeakers(numberOfSpeakers);
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(final int numberOfSpeakers) {
        if(numberOfSpeakers < 0){
            throw new IllegalArgumentException("Number of speakers might been positive");
        }
        this.numberOfSpeakers = numberOfSpeakers;
    }
}
