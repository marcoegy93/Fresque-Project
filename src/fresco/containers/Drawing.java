package fresco.containers;

import fresco.containers.calculatePerimeterAndArea.ICalculatePerimeterAndArea;
import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;
import fresco.containers.transformations.ITransformation;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Class that represents a drawing, a composition of Images (@see fresco.containers.Image)
 */
public class Drawing implements ICalculatePerimeterAndArea, ITransformation {

    /**
     * The set (Collection) that represents a group of unique Image
     * The Collection cannot contain the same Image twice
     */
    private Set<Image> images;

    /**
     * Simple constructor of a drawing, which initializes the set
     */
    public Drawing() {
        this.images = new LinkedHashSet<Image>();
    }

    /**
     * Constructor of a drawing that copies the given Set
     * @param images the given Set to copy
     */
    public Drawing(Set<Image> images) {
        this.images = images;
    }

    /**
     * Getter that gets the Set of Image
     * @return the Set of Image
     */
    public Set<Image> getImages() {
        return images;
    }

    /**
     * Setter that sets the Set of Image with a given Set
     * @param images the given Set of Image
     */
    public void setImages(Set<Image> images) {
        this.images = images;
    }

    /**
     * Methods that adds an Image to the Set of Image
     * @param img the Image to add to the Set
     */
    public void addImage(Image img) {
        this.images.add(img);
    }

    /**
     * Methods that copies the current drawing
     * @return the copied drawing
     */
    public Drawing copyDrawing() {
        return new Drawing(this.images);
    }

    /**
     * Method that sorts the Image contained in the Set based on their area
     */
    public void imagesSort() {
        List<Image> list = new ArrayList<Image>(images);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).calculateArea() < list.get(j).calculateArea()) {
                    Image tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        Set<Image> images = new LinkedHashSet<>(list);
        this.setImages(images);
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        for (Image i : images) {
            perimeter += i.calculatePerimeter();
        }
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = 0;
        for (Image i : images) {
            area += i.calculateArea();
        }
        return area;
    }

    @Override
    public void translation(int x, int y) {
        for (Image i : images) {
            i.translation(x, y);
        }
    }

    @Override
    public void homothetie(Point p, int ratio) {
        for (Image i : images) {
            i.homothetie(p, ratio);
        }
    }

    @Override
    public void rotation(int angle) {
        for (Image i : images) {
            i.rotation(angle);
        }
    }

    @Override
    public void centralSymmetry(Point p) {
        for (Image i : images) {
            i.centralSymmetry(p);
        }
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        for (Image i : images) {
            i.axialSymmetry(width, height, s);
        }
    }
}
