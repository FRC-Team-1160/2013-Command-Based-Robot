package com.team1160.feathers.commands.groups.prepare;

import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.UnlockPulley;
import com.team1160.feathers.commands.lock.LockCommand;
import com.team1160.feathers.commands.pulleyAngleLength;

import edu.wpi.first.wpilibj.command.WaitForChildren;

public class PrepareClimb extends CommandGroupBase{

	double abc;

    public PrepareClimb(){
    	
        abc  = 75;
        //addParallel(new UnlockPulley(leftLock, leftPulley));
        //addParallel(new UnlockPulley(rightLock, rightPulley));
        //addSequential(new WaitForChildren());
//        addParallel(new pulleyAngleLength(leftPulley , abc, 28, false));
//        addParallel(new pulleyAngleLength(rightPulley, abc, 28, false));
        addParallel(new LockCommand(leftLock, false));
        addParallel(new LockCommand(rightLock, false));
        addParallel(new pulleyAngleLength(leftPulley, 45, 28, false));
        addParallel(new pulleyAngleLength(rightPulley, 0.142, 28, true));
        addParallel(new pulleyAngleLength(middlePulley, 80, 25, false));
        
        //addParallel(new pulleyAngleLength(middlePulley, 80, 27, false));   
    }

	    
}