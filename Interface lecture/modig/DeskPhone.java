package modig;

public class DeskPhone implements ITelephone{

	private int myNumber;
	private boolean isRinging;
	
	public DeskPhone(int number) {
		this.myNumber = number;
	}
	
	@Override
	public void powerOn() {
		System.out.println("No action taken, deskphone does not have a power button");
		
	}

	@Override
	public void dial(int phoneNumber) {
		System.out.println("Now Ringing: " + phoneNumber + "on deskphone");
		
	}

	@Override
	public void answer() {
		if(isRinging) {
			System.out.println("Answering the desk phone");
			isRinging = false;
		}
		
	}

	@Override
	public boolean callPhone(int phoneNumber) {
		if(phoneNumber == myNumber) {
			isRinging = true;
			System.out.println("ring ring");
		} else {
			isRinging = false;
		}
		return isRinging;
	}

	@Override
	public boolean ringing() {
		return isRinging;
	}

}
