
/**
 * NumericDisplay class.
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public class Star extends BackgroundElement {
    /**
     * Star constructor.
     */
    public Star() {
        super(GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_WIDTH, 
                GameDriver.GENERATOR.nextDouble() * GameDriver.SCREEN_HEIGHT);
    }
    
    /**
     * Draw method.
     */
    public void draw() {
        StdDraw.filledCircle(this.location.getX(), this.location.getY(), 1);
    }
}
