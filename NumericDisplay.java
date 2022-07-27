
/**
 * NumericDisplay class.
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public class NumericDisplay extends BackgroundElement {
    private int value;
    private String prefix;
    
    /**
     * NumericDisplay constructor.
     * @param xPos int
     * @param yPos int
     * @param value value
     * @param prefix prefix
     */
    public NumericDisplay(int xPos, int yPos, int value, String prefix) {
        super(xPos, yPos);
        this.prefix = prefix;
        this.value = value;
    }
    
    /**
     * Sets the value.
     * @param value val
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Draw method.
     */
    public void draw() {

        StdDraw.text(this.location.getX(), this.location.getY(),
                prefix + value);
    }
}
