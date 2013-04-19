package com.team1160.feathers.commands.groups.climbrungs.second;

import com.team1160.feathers.commands.CommandGroupBase;
import com.team1160.feathers.commands.waitForNext;

/*
 * Another class that does what it implies,
 * this function is responsible for the 
 * second and third rung climbs.
 */

public class ClimbSecond extends CommandGroupBase{
	public ClimbSecond(){
		addSequential(new PrepareMiddle());
		addSequential(new waitForNext());
		addSequential(new PrepareRightLeft());
		addSequential(new waitForNext());
		addSequential(new CliimbTheShit());
	}
}
