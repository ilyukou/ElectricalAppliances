package electricAppliance.model.electricAppliance.lighting;

public class CeilingLamp extends LightElectricAppliance{
    private double weight;

    public CeilingLamp(int power, String name, LightCapType lightCapType,
                       LightBulbsType lightBulbsType, double weight) {
        super(power, name, lightCapType, lightBulbsType);
        setWeight(weight);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
