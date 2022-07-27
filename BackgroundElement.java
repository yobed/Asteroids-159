
/**
 * BackgroundElement class.
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public abstract class BackgroundElement implements Drawable {
    protected Point location;
    
    /**
     * Constructs BackgroundElement.
     * @param xPosition xPos
     * @param yPosition yPos
     */
    public BackgroundElement(double xPosition, double yPosition) {
        this.location = new Point(xPosition, yPosition);
    }
    
    /**
     * Draw method.
     */
    public void draw() {
        
    }
}
