package modig;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	
	public int x,y , width = 25, height = 25;
	public int motionX, motionY;
	
	public Random random;
	
	private Pong pong;
	
	public Ball(Pong pong) {
		
		this.pong = pong;
		
		this.random = new Random();
		
		this.x = pong.width / 2 - this.width / 2;
		this.y = pong.height / 2 - this.height / 2;
				
		this.motionY = -2 + random.nextInt(4);
		if(motionY == 0) {
			motionY = 1;
		}
		
		if(random.nextBoolean()) {
			motionX = 1;
		}else {
			motionX = -1;
		}
	}
	
	public void update(Paddle p1, Paddle p2) {
		int speed = 5;

		this.x += motionX * speed;
		this.y += motionY * speed;

		if (this.y + height - motionY > pong.height || this.y + motionY < 0)
		{
			if (this.motionY < 0)
			{
				this.y = 0;
				this.motionY = random.nextInt(4);

				if (motionY == 0)
				{
					motionY = 1;
				}
			}
			else
			{
				this.motionY = -random.nextInt(4);
				this.y = pong.height - height;

				if (motionY == 0)
				{
					motionY = -1;
				}
			}
}
		this.x += motionX;
		this.y += motionY;
		if(motionY == 0) {
			motionY = 1;
		}
		
		if(checkCollision(p1) == 1) {
			this.motionX = 1;
			this.motionY = -2 + random.nextInt(4);
		} else if(checkCollision(p2) == 1) {
			this.motionX = -1;
			this.motionY = -2 + random.nextInt(4);
		}
		if(checkCollision(p1) == 2) {
			p1.score++;
		} else if(checkCollision(p2) == 2) {
			p2.score++;
		}
	}
	
	public int checkCollision(Paddle p) {
		if (this.x < p.x + p.width && this.x + width > p.x && this.y < p.y + p.height && this.y + height > p.y)
		{
			return 1; //bounce
		}
		else if ((p.x > x && p.paddleNumber == 1) || (p.x < x - width && p.paddleNumber == 2))
		{
			return 2; //score
		}

		return 0; //nothing
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, width, height);
		
	}
}
