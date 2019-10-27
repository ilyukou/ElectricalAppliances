package electricAppliance.model.electricAppliance.sport;


import electricAppliance.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Treadmill extends SportElectricAppliance {

    private static final Logger logger = LogManager.getLogger(Treadmill.class);
    private static final int MIN_TRACK_SPEED = 0;
    private static final int MIN_TRACK_WIDTH = 0;
    private static final int MIN_TRACK_LENGTH = 0;

    private int trackMaxSpeed;
    private int trackWidth;
    private int trackLength;

    public Treadmill(int power, String name, int maxUserWeight,
                     int trackMaxSpeed, int trackWidth, int trackLength) {
        super(power, name, maxUserWeight);
        logger.info("Create class by constructor");
        setTrackWidth(trackWidth);
        setTrackLength(trackLength);
        setTrackMaxSpeed(trackMaxSpeed);
    }


    public int getTrackMaxSpeed() {
        return trackMaxSpeed;
    }

    public void setTrackMaxSpeed(int trackMaxSpeed) {
        if (Validator.validate(trackMaxSpeed, MIN_TRACK_SPEED, Integer::compareTo)) {
            this.trackMaxSpeed = trackMaxSpeed;
        } else {
            logger.error("Track max speed must be greater than the minimum");
            throw new IllegalArgumentException("Track max speed must be greater than the minimum");
        }
    }


    public int getTrackWidth() {
        return trackWidth;
    }

    public void setTrackWidth(int trackWidth) {
        if (Validator.validate(trackWidth, MIN_TRACK_WIDTH, Integer::compareTo)) {
            this.trackWidth = trackWidth;
        } else {
            logger.error("Track width must be greater than the minimum");
            throw new IllegalArgumentException("Track width must be greater than the minimum");
        }
    }

    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        if (Validator.validate(trackLength, MIN_TRACK_LENGTH, Integer::compareTo)) {
            this.trackLength = trackLength;
        } else {
            logger.info("Track length must be greater than the minimum");
            throw new IllegalArgumentException("Track length must be greater than the minimum");
        }
    }
}
