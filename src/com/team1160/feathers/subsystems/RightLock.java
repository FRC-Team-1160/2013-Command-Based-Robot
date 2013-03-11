package com.team1160.feathers.subsystems;

import com.team1160.feathers.api.Constants;
import com.team1160.feathers.commands.pulleys.right.RightPulleyUnlock;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;



public class RightLock extends Subsystem{
    
    protected Servo lock;
    
    
    protected static RightLock instance;

    public static RightLock getInstance(){
        if(instance == null){
            instance = new RightLock();
        }
        return instance;
    }
    

    public void lock(boolean lock) {
        if (lock) {
            this.lock.set(Constants.P_RIGHT_LOCK_LOCKED);
        } else {
            this.lock.set(Constants.P_RIGHT_LOCK_OPEN);
        }
    }
    protected void initDefaultCommand() {
        setDefaultCommand(new RightPulleyUnlock());
    }
}
