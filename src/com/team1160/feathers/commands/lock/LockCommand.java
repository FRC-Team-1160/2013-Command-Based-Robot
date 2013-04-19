package com.team1160.feathers.commands.lock;

import com.team1160.feathers.commands.CommandBase;
import com.team1160.feathers.subsystems.pulleys.Lock;

/*
 * Simple command, takes a lock and sets it
 * to a state, if no state is given it toggles
 * the lock. Should be pretty straight forward
 */

public class LockCommand extends CommandBase {

	private Lock lock;
	private Boolean status;

        protected void initLockCommand(Lock lock, Boolean status){
            this.lock = lock;
            this.status = status;
            requires(lock);
        }
        
        
	public LockCommand(Lock lock, Boolean status){
            initLockCommand(lock, status);
        }
	
	public LockCommand(Lock lock, boolean status){
		Boolean newStatus = new Boolean(status);
                initLockCommand(lock, newStatus);
        }
	
	public LockCommand(Lock lock){
            initLockCommand(lock, new Boolean(!lock.getLockState()));
        }
	
	protected void initialize() {
		// Nothing to initialize
	}

	protected void execute() {
		if(this.status != null){
			this.lock.lock(status.booleanValue());
		}
	}

	protected boolean isFinished() {
		if(this.status == null) return false;
		return this.lock.getLockState() == this.status.booleanValue();
	}

	protected void end() {
		this.execute();
	}

	protected void interrupted() {
		this.execute();
	}
}
