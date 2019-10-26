package model.electricAppliance.home;

import model.ElectricApplianceType;

public class TV extends HomeElectricAppliance {
    private double screenDiagonal;

    public TV(int power, String name, ElectricApplianceType electricApplianceType, double soundLevel,
              double screenDiagonal) {
        super(power, name, electricApplianceType, soundLevel);
        setScreenDiagonal(screenDiagonal);
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        if(screenDiagonal < 0){
            throw new IllegalArgumentException("Screen diagonal must been positive");
        }
        this.screenDiagonal = screenDiagonal;
    }
}
