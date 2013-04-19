package com.team1160.feathers.commands.shooter;

import com.team1160.feathers.commands.CommandBase;

public class MakeShot extends CommandBase {
	
	boolean done = false;
	
	public MakeShot(){
		requires(shooter);
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		shooter.shoot();
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		execute();
	}

	@Override
	protected boolean isFinished() {
		return done;
	}

}
