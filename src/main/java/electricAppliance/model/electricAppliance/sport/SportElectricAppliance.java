package electricAppliance.model.electricAppliance.sport;


import electricAppliance.Validator;
import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.electricAppliance.ElectricApplianceType;

public abstract class SportElectricAppliance extends ElectricAppliance {
    private int maxUserWeight;
    final static private ElectricApplianceType ELECTRIC_APPLIANCE_TYPE = ElectricApplianceType.Sport;
    public SportElectricAppliance(int power, String name,
                                  int maxUserWeight) {
        super(power, name, ELECTRIC_APPLIANCE_TYPE);
        setMaxUserWeight(maxUserWeight);
    }


    public int getMaxUserWeight() {
        return maxUserWeight;
    }

    public void setMaxUserWeight(int maxUserWeight) {
        if(Validator.validate(maxUserWeight,0,Integer::compareTo)){
            this.maxUserWeight = maxUserWeight;
        }else{
            throw new IllegalArgumentException();
        }

    }
}
