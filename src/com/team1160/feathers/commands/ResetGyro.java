package com.team1160.feathers.commands;

import com.team1160.feathers.SI;

public class ResetGyro extends CommandBase{

    public ResetGyro(){
    }
    
    
    protected void initialize() {
        SI.getInstance().reset();
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
    
    
}
