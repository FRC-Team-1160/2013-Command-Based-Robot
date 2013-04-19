package com.team1160.feathers.commands;

import com.team1160.feathers.SI;
import com.team1160.feathers.subsystems.pulleys.Pulley;

public class FourtyFive extends CommandBase{
    
    Pulley pulley;
    
    public FourtyFive(Pulley pulley){
        this.pulley = pulley;
    }

    protected void initialize() {
        SI.reset();
        pulley.setFourtyFive();
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
