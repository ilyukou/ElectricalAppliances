package electricAppliance.model.electricAppliance.lighting;

import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.electricAppliance.ElectricApplianceType;

public abstract class LightElectricAppliance extends ElectricAppliance {
    private static final ElectricApplianceType electricApplianceType = ElectricApplianceType.Light;
    private LightCapType lightCapType;
    private LightBulbsType lightBulbsType;

    public LightElectricAppliance(int power, String name, LightCapType lightCapType,
                                  LightBulbsType lightBulbsType) {
        super(power, name, electricApplianceType);
        setLightCapType(lightCapType);
        setLightBulbsType(lightBulbsType);
    }

    public LightCapType getLightCapType() {
        return lightCapType;
    }

    public void setLightCapType(LightCapType lightCapType) {
        this.lightCapType = lightCapType;
    }

    public LightBulbsType getLightBulbsType() {
        return lightBulbsType;
    }

    public void setLightBulbsType(LightBulbsType lightBulbsType) {
        this.lightBulbsType = lightBulbsType;
    }

}
