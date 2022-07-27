
/**
 * AsteroidSize class.
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public enum AsteroidSize {
    SMALL(10, 200, .25), 
    MEDIUM(20, 100, .25), 
    LARGE(30, 50, .50);
    private int radius;
    private int points;
    private double probability;
    
    /**
     * Constructor for asteroid size.
     * @param radius radius
     * @param points points
     * @param probability probability
     */
    AsteroidSize(int radius, int points, double probability) {
        this.radius = radius;
        this.points = points;
        this.probability = probability;
    }
    
    /**
     * Returns the radius of the asteroid.
     * @return radius
     */
    public int getRadius() {
        return this.radius;
    }
    
    /**
     * Returns the point of asteroid.
     * @return points
     */
    public int getPoints() {
        return this.points;
    }
    
    /**
     * Random Size of AsteroidSize.
     * @return AsteroidSize
     */
    public static AsteroidSize randomSize() {
        AsteroidSize type = null;
        if (GameDriver.GENERATOR.nextDouble() < .50) {
            type = AsteroidSize.LARGE;
            type.probability = .50;
        } else if (GameDriver.GENERATOR.nextDouble() < .25) {
            type = AsteroidSize.MEDIUM;
            type.probability = .25;
        } else {
            type = AsteroidSize.SMALL;
            type.probability = .25;
        }
        return type;
    }

    /**
     * Returns probability of Asteroid.
     * @return probability
     */
    public double getProbability() {
        return probability;
    }
    
}

