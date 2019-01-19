package prove02;

import java.awt.*;
import java.util.Random;

/**
 * Wolves move around searching for the nearby creature to attack. Will move in the direction
 * of the creature when aware of its presence. Does not attack plants or zombies. They are
 * represented by a grey square.
 * <p>
 * @author  Dustin Christensen
 * @version 1.0
 * @since   2019-01-18
 * @see     Creature
 */

public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner {

    // Setup for the Wolf
    Random _rand;
    int direction;
    boolean canSpawn;

    /**
     * Creates a wolf with 3 health points
     */
    public Wolf() {
        _rand = new Random();
        _health = 3;
        setDirection(_rand.nextInt(4));
        setCanSpawn(false);
    }

    public Wolf(Point location) {
        location.x = _location.x + 1;
        _rand = new Random();
        _health = 3;
        setDirection(_rand.nextInt(4));
        setCanSpawn(false);
    }

    public Boolean isAlive() {
        return _health > 0;
    }
    public Shape getShape() {
        return Shape.Square;
    }
    public Color getColor() {
        return new Color(153, 153, 153);
    }
    public int getDirection() {
        return this.direction;
    }
    public void setDirection(int direct) {
        this.direction = direct;
    }
    public Boolean getCanSpawn() {
        return this.canSpawn;
    }
    public void setCanSpawn(boolean _canSpawn) {
        this.canSpawn = _canSpawn;
    }

    /**
     *If the creature encountered is an animal it is eaten. All others are ignored.
     * @param target The {@link Creature} that is encountered
     */
    public void attack(Creature target) {
        // Wolves eat only animals. Inflict 5 points of damage and increases health by one.
        if(target instanceof Animal) {
            target.takeDamage(5);
            _health++;
            setCanSpawn(true);
        }
    }
    /**
     * Move the wolf around. Initially in a random direction until aware.
     */
    public void move() {

        // Choose a random direction each time move() is called.
        switch(direction) {
            case 0:
                _location.x++;
                break;
            case 1:
                _location.x--;
                break;
            case 2:
                _location.y++;
                break;
            case 3:
                _location.y--;
                break;
            default:
                break;
        }
    }

    /**
     * Sense the presense of animals
     */
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        for(int i = getDirection(); i < 4; i++) {

            // Change direction if animal is present
            if(i == 0) {
                if(above instanceof Animal) {
                    setDirection(2);
                    break;
                }
            }
            if(i == 1) {
                if(right instanceof Animal) {
                    setDirection(0);
                    break;
                }
            }
            if(i == 2) {
                if(below instanceof Animal) {
                    setDirection(3);
                    break;
                }
            }
            if(i == 3) {
                if(left instanceof Animal) {
                    setDirection(1);
                    break;
                }
                i = 0;
            }
        }
    }

    /**
     * Spawns the new wolf
     */
    public Creature spawnNewCreature() {

        Wolf newWolf = new Wolf();

        // newWolf.setLocation(_location.x++, _location.y);

        setCanSpawn(false);

        return newWolf;
    }
}
