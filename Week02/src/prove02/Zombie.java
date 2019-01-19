package prove02;

import java.awt.Color;
import java.util.Random;

/**
 * Zombie moves left to right, attacking creatures, inflicting 10 points of damage.
 * Zombie does not attack plants. Zombies are represented as blue squares.
 * <p>
 * @author  Dustin Christensen
 * @version 1.0
 * @since   2019-01-18
 * @see     Creature
 */

public class Zombie extends Creature implements Movable, Aggressor {

    /**
     * Setup for Zombie
     */
    Random _rand;
    int isLeft;

    /**
     * Create a Zombie
     */
    public Zombie() {
        _health = 3;
        setIsLeft(1);
    }

    /**
     * Getter for direction
     * @return isLeft Retrieves the direction of the Zombie
     */
    public int getIsLeft() {
        return this.isLeft;
    }

    /**
     * Setter for direction
     * @param goingLeft Takes and sets the direction of the Zombie
     */
    public void setIsLeft(int goingLeft) {
        this.isLeft = goingLeft;
    }

    public Boolean isAlive() {
        return _health > 0;
    }

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(0, 0, 255);
    }

    /**
     * If Zombie encounters a non-plant, then the Zombie will attack. If a plant is encountered
     * then the Zombie will leave it be.
     * @param target The {@link Creature} we have encountered
     */
    public void attack(Creature target) {

        // Zombies only eat non-plants. Inflict 10 points to all non-plant creatures
        if(target instanceof Animal) {
            target.takeDamage(10);
            _health++;
        }
    }
    /**
     * Move the Zombie left to right
     */
    public void move() {

        // Start off moving left then go right
        switch (getIsLeft()) {
            case 0:
                _location.x++;
                break;
            case 1:
                _location.x--;
                break;
            default:
                break;
        }

        // Change direction
        if (_location.x == 0) {
            setIsLeft(0);
        }
        if (_location.x == 76) {
            setIsLeft(1);
        }
    }
}
