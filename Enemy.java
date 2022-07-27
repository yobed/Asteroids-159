
/**
 * Enemy class.
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public abstract class Enemy extends GameElement {
    private int pointValue;
    
    /**
     * Constructs Enemy.
     * @param speed speed
     * @param collisionRadius radius
     * @param pointValue pointVal
     */
    public Enemy(double speed, double collisionRadius, int pointValue) {
        super(speed, collisionRadius);
        this.pointValue = pointValue;
    }
    
    /**
     * Returns the pointValue.
     * @return pointValue
     */
    public int getPointValue() {
        return this.pointValue;
    }
}
