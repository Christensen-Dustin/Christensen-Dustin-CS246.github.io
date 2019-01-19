package prove02;

import java.awt.*;
import java.util.Random;

/**
 * WhiteShark moves around consuming all. Will move in a straight line until it is aware
 * of other creatures. Represented by a light grey circle.
 * <p>
 * @author  Dustin Christensen
 * @version 1.0
 * @since 2019-01-18
 * @see     Creature
 */

public class WhiteShark extends Creature implements Movable, Aware, Aggressor {

    // Set up for the WhiteShark
    Random _rand;
    int direction;

    /**
     * Create a WhiteShark with 7 health points
     */
    public WhiteShark() {
        _rand = new Random();
        _health = 7;
        setDirection(_rand.nextInt(4));
    }

    public Boolean isAlive() {
        return _health > 0;
    }
    public Shape getShape() {
        return Shape.Circle;
    }
    public Color getColor() {
        return new Color(255, 204, 0);
    }
    public int getDirection() {
        return this.direction;
    }
    public void setDirection(int direct) {
        this.direction = direct;
    }

    /**
     * If WhiteShark encounters anything it will eat it.
     * @param target The {@link Creature} that is encounter
     */
    public void attack(Creature target) {
        if(target instanceof Animal) {
            target.takeDamage(21);
            _health+= 2;
        }
        if(target instanceof Zombie) {
            target.takeDamage(21);
        }
        if(target instanceof Wolf) {
            target.takeDamage(21);
            _health+= 3;
        }
        if(target instanceof Plant) {
            target.takeDamage(21);
            _health+= 1;
        }
    }

    /**
     * Move the WhiteShark around, initially in a random direction until aware.
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

        if(getDirection() == 2) {
            if(above instanceof Animal || above instanceof Plant
                    || above instanceof Zombie || above instanceof Wolf
                    || above instanceof WhiteShark) {
                setDirection(2);
            } else if (right instanceof Animal || right instanceof Plant
                    || right instanceof Zombie || right instanceof Wolf
                    || right instanceof WhiteShark) {
                setDirection(0);
            }else if (below instanceof Animal || below instanceof Plant
                    || below instanceof Zombie || below instanceof Wolf
                    || below instanceof WhiteShark) {
                setDirection(3);
            }else if (left instanceof Animal || left instanceof Plant
                    || left instanceof Zombie || left instanceof Wolf
                    || left instanceof WhiteShark) {
                setDirection(1);
            }
        }else if(getDirection() == 0) {
            if(right instanceof Animal || right instanceof Plant
                    || right instanceof Zombie || right instanceof Wolf
                    || right instanceof WhiteShark) {
                setDirection(0);
            }else if(below instanceof Animal || below instanceof Plant
                    || below instanceof Zombie || below instanceof Wolf
                    || below instanceof WhiteShark) {
                setDirection(3);
            }else if(left instanceof Animal || left instanceof Plant
                    || left instanceof Zombie || left instanceof Wolf
                    || left instanceof WhiteShark) {
                setDirection(1);
            }else if(above instanceof Animal || above instanceof Plant
                    || above instanceof Zombie || above instanceof Wolf
                    || above instanceof WhiteShark) {
                setDirection(2);
            }
        }else if(getDirection() == 3) {
            if(below instanceof Animal || below instanceof Plant
                    || below instanceof Zombie || below instanceof Wolf
                    || below instanceof WhiteShark) {
                setDirection(3);
            }else if(left instanceof Animal || left instanceof Plant
                    || left instanceof Zombie || left instanceof Wolf
                    || left instanceof WhiteShark) {
                setDirection(1);
            }else if(above instanceof Animal || above instanceof Plant
                    || above instanceof Zombie || above instanceof Wolf
                    || above instanceof WhiteShark) {
                setDirection(2);
            }else if(right instanceof Animal || right instanceof Plant
                    || right instanceof Zombie || right instanceof Wolf
                    || right instanceof WhiteShark) {
                setDirection(0);
            }
        }else if(getDirection() == 1) {
            if(left instanceof Animal || left instanceof Plant
                    || left instanceof Zombie || left instanceof Wolf
                    || left instanceof WhiteShark) {
                setDirection(1);
            }else if(above instanceof Animal || above instanceof Plant
                    || above instanceof Zombie || above instanceof Wolf
                    || above instanceof WhiteShark) {
                setDirection(2);
            }else if(right instanceof Animal || right instanceof Plant
                    || right instanceof Zombie || right instanceof Wolf
                    || right instanceof WhiteShark) {
                setDirection(0);
            }else if(below instanceof Animal || below instanceof Plant
                    || below instanceof Zombie || below instanceof Wolf
                    || below instanceof WhiteShark) {
                setDirection(3);
            }
        }
    }
}

