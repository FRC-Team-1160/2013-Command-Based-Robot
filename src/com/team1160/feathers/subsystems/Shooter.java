package com.team1160.feathers.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.team1160.feathers.api.Constants;

public class Shooter extends Subsystem {

	protected static Shooter instance;
	protected Jaguar wheel;
	protected Servo trigger;
	protected double shoot, prep;
	
	public static Shooter getInstance(){
		if(instance == null){
			Shooter.instance = new Shooter();
		}
		return Shooter.instance;	
	}
	
	protected Shooter(){
		wheel = new Jaguar(Constants.SHOOTER_JAG_CAR, Constants.SHOOTER_JAG_CHAN);
		trigger = new Servo(Constants.TRIGGER_CAR, Constants.TRIGGER_CHAN);
		shoot = 1;    // Place holder replace
		prep = 0;
	}
	
	// Will set the default command
	public void initDefaultCommand(){
		
	}
	
	//Sets the speed of the wheel
	public void setSpeed(double set){
		wheel.set(set);
	}
	
	//Loads a frisbee into the chamber
	public void shoot(){
		trigger.set(shoot);
	}
	
	//Pulls back 'trigger'
	public void prepare(){
		trigger.set(prep);
	}
	
	//Returns if the wheel was set to one
	public boolean isPrepped(){
		return wheel.get() == 1;
	}
	
}
