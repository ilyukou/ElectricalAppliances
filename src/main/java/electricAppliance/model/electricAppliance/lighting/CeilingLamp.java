package electricAppliance.model.electricAppliance.lighting;

import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CeilingLamp extends LightElectricAppliance{
    private static final Logger logger = LogManager.getLogger(CeilingLamp.class);
    private int weight;

    public CeilingLamp(int power, String name, LightCapType lightCapType,
                       LightBulbsType lightBulbsType, int weight) {
        super(power, name, lightCapType, lightBulbsType);
        setWeight(weight);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(Validator.validate(weight,0,Integer::compareTo)){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Weight must be positive");
        }

    }
}
