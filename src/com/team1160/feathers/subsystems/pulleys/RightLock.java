package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.SI;
import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.CommandBase;
import com.team1160.feathers.commands.lock.LockCommand;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;

public class RightLock extends Lock{
    
    
    
    protected static RightLock instance;
    protected RightPulley pulley;

    public static RightLock getInstance(){
        if(instance == null){
            instance = new RightLock();
        }
        return instance;
    }
    
    private RightLock(){
        lengthsensor = SI.getInstance().getRight();
        this.servo = new Servo(Constants.P_RIGHT_LOCK_CAR, Constants.P_RIGHT_LOCK_CHAN);       
        this.locked = Constants.P_RIGHT_LOCK_LOCKED;
        this.unlocked = Constants.P_RIGHT_LOCK_OPEN;
    }
    

    
    protected void initDefaultCommand() {
    	setDefaultCommand(new LockCommand(RightLock.getInstance(), null));
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
            //
            servo.set(unlocked);
            double startLength = lengthsensor.getLength();
            int count = 1;
            // Do this loop until the tape has extended .5 inches
            // currently stays in this loop until
            if(pulley == null){
                pulley = RightPulley.getInstance();
            }
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
                double abc = lengthsensor.getLength() - startLength;
                System.out.println("Retraction amount is: " + abc);
            }
        }
        // Publish the state
        return false;
    }
    

}