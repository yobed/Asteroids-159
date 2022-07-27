
/**
 * GameElement class.
 * 
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public abstract class GameElement implements Updatable, Drawable {
    protected Pose pose;
    protected Vector2D velocity;
    protected boolean destroyed;
    protected double collisionRadius;
    protected int counter = 0;

    /**
     * Constructor for gameElement.
     * 
     * @param pose pose
     * @param velocity velcoity
     * @param collisionRadius collisionRadius
     */
    public GameElement(Pose pose, Vector2D velocity, double collisionRadius) {
        this.pose = pose;
        this.velocity = velocity;
        this.collisionRadius = collisionRadius;

    }

    /**
     * Constructor for gameElement.
     * 
     * @param speed speed
     * @param collisionRadius collisionRadius
     */
    public GameElement(double speed, double collisionRadius) {
        this.collisionRadius = collisionRadius;
        this.pose = new Pose(
                GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_WIDTH,
                GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_HEIGHT,
                GameDriver.GENERATOR.nextDouble() * Math.PI);
        this.velocity = new Vector2D(this.pose.getHeading(), speed);
    }

    /**
     * Update method.
     */
    public void update() {
        counter++;
    }

    /**
     * Checks the collision.
     * 
     * @param other other
     * @return destroyed boolean
     */
    public boolean checkCollision(GameElement other) {
        // if x through x or y through y is equal to other x through x
        // or y through y
        double xDiff = this.pose.getX() - other.pose.getX();
        double yDiff = this.pose.getY() - other.pose.getY();
        double total = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));

        return total < (this.collisionRadius + other.collisionRadius);
    }

    /**
     * Sets the counter.
     * 
     * @param num num
     */
    public void setCounter(int num) {
        this.counter = num;
    }

    /**
     * Get counter.
     * 
     * @return counter
     */
    public int getCounter() {
        return this.counter;
    }

}
