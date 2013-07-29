package com.team1160.feathers.commands.groups.climbrungs.second;

import com.team1160.feathers.SI;
import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.DefensiveClimb;
import com.team1160.feathers.commands.MiddleFinish;
import com.team1160.feathers.commands.Stall;
import com.team1160.feathers.commands.pulleyAngleLength;

import edu.wpi.first.wpilibj.command.WaitCommand;

public class PrepareMiddle extends CommandGroupBase {
	public PrepareMiddle(){
		addSequential(new MiddleFinish(false));
		addSequential(new pulleyAngleLength(middlePulley, -63, 46, false));
		addSequential(new pulleyAngleLength(middlePulley, -77, 46, false));
		addSequential(new WaitCommand(3));
		addSequential(new pulleyAngleLength(middlePulley, -77, 44, false));
		addSequential(new DefensiveClimb(middlePulley, null, 26, false, .8));
		addSequential(new Stall());
	}
	
	public void initialize(){
		SI.nextCommand = false;
	}
	
}
