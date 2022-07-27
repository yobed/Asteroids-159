
/**
 * Asteroid class.
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public class Asteroid extends Enemy {
    private AsteroidSize size;
    
    /**
     * Constructs the asteroid.
     * @param size size
     */
    public Asteroid(AsteroidSize size) {
        super(1.0, size.getRadius(), size.getPoints());
        this.size = size;
    }
    
    /**
     * Updates the asteroid.
     */
    public void update() {
        this.pose = this.pose.move(this.velocity);
        if (this.pose.getX() > GameDriver.SCREEN_WIDTH) {
            this.pose = this.pose.newX(0);
        } else if (this.pose.getX() < 0) {
            this.pose = this.pose.newX(GameDriver.SCREEN_WIDTH);
        }
        if (this.pose.getY() > GameDriver.SCREEN_HEIGHT) {
            this.pose = this.pose.newY(0);
        } else if (this.pose.getY() < 0) {
            this.pose = this.pose.newY(GameDriver.SCREEN_HEIGHT);
        }
    }
    
    /**
     * Draws the asteroid.
     */
    public void draw() {
        StdDraw.circle(this.pose.getX(), this.pose.getY(), 
                this.size.getRadius());
    }
}
