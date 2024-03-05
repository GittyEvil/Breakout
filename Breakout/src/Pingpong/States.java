package Pingpong;

public enum States {
	paused,
	running,
	reset,
	highscore;
	
	private States status;
	
	public States getStatus() {
		return status;
		
	}
	
	public void setStatus(States newStatus) {
		status = newStatus;
	}
}
