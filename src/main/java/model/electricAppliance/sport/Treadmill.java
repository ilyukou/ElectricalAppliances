package model.electricAppliance.sport;


import model.ElectricApplianceType;
import model.Validator;

public class Treadmill extends SportElectricAppliance {
    private int trackMaxSpeed;

    private int trackWidth;
    private int trackLength;

    public Treadmill(int power, String name, int maxUserWeight,
                     int trackMaxSpeed, int trackWidth, int trackLength) {
        super(power, name, maxUserWeight);
        setTrackWidth(trackWidth);
        setTrackLength(trackLength);
        setTrackMaxSpeed(trackMaxSpeed);
    }


    public int getTrackMaxSpeed() {
        return trackMaxSpeed;
    }

    public void setTrackMaxSpeed(int trackMaxSpeed) {
        if (Validator.validate(trackMaxSpeed,0,Integer::compareTo)) {
            this.trackMaxSpeed = trackMaxSpeed;
        }else {
            throw new IllegalArgumentException("Track max speed might have been positive");
        }
    }


    public int getTrackWidth() {
        return trackWidth;
    }

    public void setTrackWidth(int trackWidth) {
        if (Validator.validate(trackWidth,0,Integer::compareTo)) {
            this.trackWidth = trackLength;
        }else {
            throw new IllegalArgumentException("Track width might have been positive");
        }
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        if (Validator.validate(trackLength,0,Integer::compareTo)) {
            this.trackLength = trackLength;
        }else {
            throw new IllegalArgumentException("Track length might have been positive");
        }
    }
}
