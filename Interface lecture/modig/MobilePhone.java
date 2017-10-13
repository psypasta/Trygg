package modig;

public class MobilePhone implements ITelephone{

	private int myNumber;
	private boolean isRinging;
	private boolean isOn = false;
	
	public MobilePhone(int number) {
		this.myNumber = number;
	}
	
	@Override
	public void powerOn() {
		isOn = true;
		System.out.println("Mobile phone powered on");
		
	}

	@Override
	public void dial(int phoneNumber) {
		if(isOn) {
			System.out.println("Now Ringing: " + phoneNumber + "on mobile");
		} else {
			System.out.println("Phone is switched off");
		}
	}

	@Override
	public void answer() {
		if(isRinging) {
			System.out.println("Answering the mobile phone");
			isRinging = false;
		}
		
	}

	@Override
	public boolean callPhone(int phoneNumber) {
		if(phoneNumber == myNumber && isOn) {
			isRinging = true;
			System.out.println("Mobile ring");
		} else {
			isRinging = false;
			System.out.println("Mobile phone turned off / number different");
		}
		return isRinging;
	}

	@Override
	public boolean ringing() {
		return isRinging;
	}

}
