import java.awt.Color;

import java.util.ArrayList;

/**
 * AsteroidsGame class.
 * This work complies with the JMU Honor Code. 
 * 
 * @author Patrick DeBoy
 * @version 4/9/2021
 */
public class AsteroidsGame implements Playable {
    private ArrayList<Drawable> drawElements;
    private ArrayList<GameElement> shipAndBullets;
    private ArrayList<Enemy> enemies;
    private int score;
    private int lives;
    private NumericDisplay scoreDisplay;
    private NumericDisplay livesDisplay;

    /**
     * AsteroidsGame constructor.
     * 
     */
    public AsteroidsGame() {
        
        // Display
        score = 0;
        lives = 3;
        scoreDisplay = new NumericDisplay(60, GameDriver.SCREEN_HEIGHT - 20,
                score, "Score: ");
        livesDisplay = new NumericDisplay(60, GameDriver.SCREEN_HEIGHT - 60,
                lives, "Lives: ");

        // drawable elements
        drawElements = new ArrayList<Drawable>();
        for (int i = 0; i < 100; i++) {
            drawElements.add(new Star());
        }

        // updatable elements
        shipAndBullets = new ArrayList<GameElement>();

        shipAndBullets.add(new Ship());

        enemies = new ArrayList<Enemy>();

        // asteroids
        for (int i = 0; i < 10; i++) {
            enemies.add(new Asteroid(AsteroidSize.randomSize()));
        }

    }

    /**
     * Update method.
     */
    public void update() {
        livesDisplay.setValue(lives);
        scoreDisplay.setValue(score);
        if (lives <= 0) {
            livesDisplay.setValue(lives);
            return;
        }
        if (enemies.size() == 0) {
            for (int i = 0; i < 10; i++) {
                enemies.add(new Asteroid(AsteroidSize.randomSize()));
            }
        }
        if (GameDriver.GENERATOR.nextDouble() < .002) {
            enemies.add(new Saucer());
        }

        for (int i = 0; i < shipAndBullets.size(); i++) {
            shipAndBullets.get(i).update();
        }

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update();
            if (enemies.get(i) instanceof Saucer) {
                // disappear
                if (enemies.get(i).pose.getX() > GameDriver.SCREEN_WIDTH
                        || enemies.get(i).pose.getY() > GameDriver.SCREEN_HEIGHT
                        || enemies.get(i).pose.getX() < 0
                        || enemies.get(i).pose.getY() < 0) {
                    enemies.remove(i);
                }
            }
        }
        // adding bullets
        if (StdDraw.hasNextKeyTyped() && StdDraw.nextKeyTyped() == ' ') {
            shipAndBullets.add(new Bullet(shipAndBullets.get(0).pose,
                    new Vector2D(shipAndBullets.get(0).pose.getHeading(), 20)));

        }
        // removing bullets
        for (int i = 0; i < shipAndBullets.size(); i++) {
            if (shipAndBullets.get(i) instanceof Bullet) {
                if (shipAndBullets.get(i).getCounter() == 20) {
                    shipAndBullets.remove(i);
                }
            }
        }

        // collision and points

        for (int j = 0; j < enemies.size(); j++) {
            for (int i = 0; i < shipAndBullets.size(); i++) {
                if (shipAndBullets.get(i).checkCollision(enemies.get(j))) {
                    if (shipAndBullets.get(i) instanceof Bullet) {
                        score += enemies.get(j).getPointValue();
                        enemies.remove(j);
                        shipAndBullets.remove(i);

                    } else {
                        if (shipAndBullets.get(i).checkCollision(enemies.get(j))
                                && shipAndBullets.get(i) instanceof Ship) {
                            StdDraw.pause(50);
                            lives--;
                            if (lives != 0) {
                                shipAndBullets.remove(i);
                                shipAndBullets.add(new Ship());
                                enemies.remove(j);

                            } else {
                                livesDisplay.setValue(0);
                            }

                        }

                    }

                }

            }
        }
    }

    /**
     * Draw method.
     */
    public void draw() {
        StdDraw.setPenColor(Color.WHITE);
        scoreDisplay.draw();
        livesDisplay.draw();
        for (int i = 0; i < drawElements.size(); i++) {
            drawElements.get(i).draw();
        }
        for (int i = 0; i < shipAndBullets.size(); i++) {
            shipAndBullets.get(i).draw();
        }

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw();
        }

    }
}
