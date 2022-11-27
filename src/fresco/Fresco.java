package fresco;

import fresco.containers.Drawing;

import java.util.LinkedHashSet;
import java.util.Set;

public class Fresco {
    private Set<Drawing> drawings;

    public Fresco(){
        this.drawings = new LinkedHashSet<Drawing>();
    }

    public Set<Drawing> getDrawings() {
        return drawings;
    }

    public void addDrawing(Drawing d){
        this.drawings.add(d);
    }
}
