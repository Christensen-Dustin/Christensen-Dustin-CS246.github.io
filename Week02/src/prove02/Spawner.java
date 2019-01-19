package prove02;

/**
 * Spawns a new Creature after Creature has fed
 * <p>
 * @author  Dustin Christensen
 * @version 1.0
 * @since   2019-01-18
 * @see Creature
 */
public interface Spawner {

    /**
     * Spawns from the {@link Creature}.
     */
    public Creature spawnNewCreature();
}
