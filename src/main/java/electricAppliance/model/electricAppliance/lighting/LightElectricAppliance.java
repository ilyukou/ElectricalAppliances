package electricAppliance.model.electricAppliance.lighting;

import electricAppliance.Validator;
import electricAppliance.model.ElectricAppliance;
import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class LightElectricAppliance extends ElectricAppliance {

    private static final Logger logger = LogManager.getLogger(LightElectricAppliance.class);

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
        if(Validator.isNotNull(lightCapType)){
            this.lightCapType = lightCapType;
        }else {
            logger.error("LightCapType is null");
            throw new IllegalArgumentException("LightCapType is null");
        }


    }

    public LightBulbsType getLightBulbsType() {
        return lightBulbsType;
    }

    public void setLightBulbsType(LightBulbsType lightBulbsType) {
        if(Validator.isNotNull(lightBulbsType)){
            this.lightBulbsType = lightBulbsType;
        }else {
            logger.error("LightBulbsType is null");
            throw new IllegalArgumentException("LightBulbsType is null");
        }
    }

}
