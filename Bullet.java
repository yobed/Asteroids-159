
/**
 * GameElement class.
 * 
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public class Bullet extends GameElement {

    /**
     * Constructor for bullet.
     * 
     * @param pose pose
     * @param velocity velocity
     */
    public Bullet(Pose pose, Vector2D velocity) {
        super(pose, velocity, 1.5);
    }

    /**
     * Update method.
     */
    public void update() {
        counter++;
        this.velocity = this.velocity.newMagnitude(20);
        this.pose = this.pose.move(this.velocity);

        // WRAPPING
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
     * Draw method.
     */
    public void draw() {
        StdDraw.filledCircle(this.pose.getX(), this.pose.getY(), 1.5);
    }

}
