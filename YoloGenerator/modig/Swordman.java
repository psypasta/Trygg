package modig;

public class Swordman extends Soldier {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		this.stamina = this.stamina - 10;
		
	}

	@Override
	public void block() {
		if(this.stamina < 50) {
			this.health = this.health - 10;
		}
		
	}

}
