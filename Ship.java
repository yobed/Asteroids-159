import java.awt.event.KeyEvent;

/**
 * GameElement class.
 * 
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public class Ship extends GameElement {
    /**
     * Constructor for Ship.
     */
    public Ship() {
        super(new Pose(GameDriver.SCREEN_WIDTH / 2,
                GameDriver.SCREEN_HEIGHT / 2, Math.PI / 2), new Vector2D(0, 0),
                10.0);
    }

    /**
     * Turns the ship at desired angle.
     * 
     * @param angle angle
     */
    public void turn(double angle) {
        this.pose = this.pose.newHeading(this.pose.getHeading() + angle);
    }

    /**
     * Thrusts the ship.
     * 
     * @param acceleration acceleration
     */
    public void thrust(double acceleration) {

        this.velocity = this.velocity.newMagnitude(this.velocity.getMagnitude()
                + Math.pow(acceleration, 2));
        this.velocity = this.velocity.newHeading(this.pose.getHeading());
        this.pose = this.pose.move(velocity);
    }

    /**
     * Update method.
     */
    public void update() {
        // turning
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.turn(.1);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.turn(-.1);
        }

        // thrust
        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
            this.thrust(.1);
        } else {
            this.velocity = this.velocity.newMagnitude(
                    velocity.getMagnitude() * .99);
            this.pose = this.pose.move(this.velocity);
        }

        // wrapping
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
        GameUtils.drawPoseAsTriangle(this.pose, 10, 20);
    }

    /**
     * Gets the Pose of Ship.
     * @return pose
     */
    public Pose getShipPose() {
        return super.pose;
    }

}
