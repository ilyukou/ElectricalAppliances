package electricAppliance.model.electricAppliance.home;

import electricAppliance.model.electricAppliance.ElectricApplianceType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TV extends HomeElectricAppliance implements Cloneable{

    private static final Logger logger = LogManager.getLogger(TV.class);

    private double screenDiagonal;

    public TV(int power, String name, ElectricApplianceType electricApplianceType, int soundLevel,
              int screenDiagonal) {
        super(power, name, electricApplianceType, soundLevel);
        setScreenDiagonal(screenDiagonal);
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(int screenDiagonal) {
        if(screenDiagonal < 0){
            throw new IllegalArgumentException("Screen diagonal must been positive");
        }
        this.screenDiagonal = screenDiagonal;
    }
}
