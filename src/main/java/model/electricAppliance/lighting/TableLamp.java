package model.electricAppliance.lighting;

import model.ElectricApplianceType;

public class TableLamp extends LightElectricAppliance {
    private double height;

    public TableLamp(int power, String name, LightCapType lightCapType,
                     LightBulbsType lightBulbsType, double height) {
        super(power, name, lightCapType, lightBulbsType);
        setHeight(height);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
