
/**
 * Saucer class.
 * 
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public class Saucer extends Enemy {
    /**
     * Constructs the saucer.
     */
    public Saucer() {
        super(2.0, 10.0, 400);
    }

    /**
     * Updates the saucer.
     */
    public void update() {

        if (GameDriver.GENERATOR.nextDouble() < .05) {

            this.pose = this.pose.newHeading(
                    GameDriver.GENERATOR.nextDouble() * 360 * Math.PI / 180);
            this.velocity = this.velocity.newHeading(
                    GameDriver.GENERATOR.nextDouble() * 360 * Math.PI / 180);
            this.pose = this.pose.move(this.velocity);
        }
        this.pose = this.pose.move(this.velocity);

    }

    /**
     * Draws the saucer.
     */
    public void draw() {
        StdDraw.rectangle(this.pose.getX(), this.pose.getY(), 10, 5);
    }
}
