package com.team1160.feathers.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Shoot extends CommandGroup {
	public Shoot(){
		addSequential(new PrepareShooter());
		addSequential(new MakeShot());
	}
}
