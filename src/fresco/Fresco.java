package fresco;

import fresco.containers.Drawing;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Class that represents a Fresco (or a mural), a composition of Drawing (@see fresco.containers.Drawing)
 */
public class Fresco {

    /**
     * The set (Collection) that represents a group of unique Drawings
     * The Collection cannot contain the same Drawing twice
     */
    private final Set<Drawing> drawings;

    /**
     * The constructor of a Fresco which initializes the drawing
     */
    public Fresco() {
        this.drawings = new LinkedHashSet<Drawing>();
    }

    /**
     * Getter that gets the drawings
     *
     * @return the Set of Drawing
     */
    public Set<Drawing> getDrawings() {
        return drawings;
    }

    /**
     * Method that adds the given Drawing to the Set
     *
     * @param d the Drawing to add to the Set
     */
    public void addDrawing(Drawing d) {
        this.drawings.add(d);
    }
}
