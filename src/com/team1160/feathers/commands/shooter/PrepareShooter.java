package com.team1160.feathers.commands.shooter;

import com.team1160.feathers.commands.CommandBase;

public class PrepareShooter extends CommandBase {

	protected boolean done = false;
	
	public PrepareShooter(){
		requires(shooter);
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		if(!shooter.isPrepped()){
			shooter.setSpeed(1);
		}
		shooter.prepare();
		done = true;
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
