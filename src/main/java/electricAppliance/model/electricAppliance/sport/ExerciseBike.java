package electricAppliance.model.electricAppliance.sport;

import electricAppliance.Validator;

public class ExerciseBike extends SportElectricAppliance {
    private int maxSpeed;

    public ExerciseBike(int power, String name, int maxUserWeight,
                        int maxSpeed) {
        super(power, name, maxUserWeight);
        setMaxSpeed(maxSpeed);
    }


    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if(Validator.validate(maxSpeed,0,Integer::compareTo)){
            this.maxSpeed = maxSpeed;
        }else{
            throw new IllegalArgumentException();
        }
    }

}
