package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.SI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.CommandBase;

import edu.wpi.first.wpilibj.Servo;
import com.team1160.feathers.commands.lock.LockCommand;
import edu.wpi.first.wpilibj.Timer;

public class LeftLock extends Lock {

    private static LeftLock instance;
    protected LeftPulley pulley;

    public static LeftLock getInstance() {
        if (instance == null) {
            instance = new LeftLock();
        }
        return instance;
    }

    private LeftLock() {
        lengthsensor = SI.getInstance().getLeft();
        servo = new Servo(Constants.P_LEFT_LOCK_CAR, Constants.P_LEFT_LOCK_CHAN);
        locked = Constants.P_LEFT_LOCK_LOCKED;
        unlocked = Constants.P_LEFT_LOCK_OPEN;
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new LockCommand(LeftLock.getInstance(), null));
    }

    public boolean setLock(boolean lock) {

        if (lock) {
            servo.set(locked);
            // publish the state. Used in setTapeLength ()
            return true;
        } else {

            double minimumTapeExtension = .4;
            int tapeRetractIterations = 5;
            double retractionVelocity = -.2;
            double waitTimePerIteration = .07;
            double extensionVelocity = .4;
            double waitTimePerAttemptedRetraction = .2;
            if(pulley == null){
                pulley = LeftPulley.getInstance();
            }
            servo.set(unlocked);
            double startLength = lengthsensor.getLength();
            int count = 1;
            // Do this loop until the tape has extended .5 inches
            // currently stays in this loop until
            while (lengthsensor.getLength() - minimumTapeExtension < startLength) {
                for (int i = 1; i < tapeRetractIterations; i++) {
                    pulley.setVelocity(retractionVelocity);
                    Timer.delay(waitTimePerIteration);
                    pulley.setVelocity(0);
                }
                startLength = pulley.getLength();
                // Try to extend the tape
                pulley.setVelocity(extensionVelocity);
                //should move more than half an inch in 1 second
                Timer.delay(waitTimePerAttemptedRetraction);
                pulley.setVelocity(0);
                Timer.delay(.3);
            }
        }
        // Publish the state
        return false;
    }
}
