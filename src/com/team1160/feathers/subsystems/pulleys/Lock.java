package com.team1160.feathers.subsystems.pulleys;

import com.team1160.feathers.sensors.LengthSensor;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Zach
 */
public abstract class Lock extends Subsystem {

    protected boolean lock;
    protected LengthSensor lengthsensor;
    protected Servo servo;
    protected double locked, unlocked;

    public abstract boolean setLock(boolean b);
//        this.lock = lock;
//        if (lock) {
//            servo.set(locked);
//        } else {
//        }
//    }

    public boolean getLockState() {
        return lock;
    }

    public double getServoVal() {
        return this.servo.get();
    }
}
