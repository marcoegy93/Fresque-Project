package fresco.containers;

import fresco.containers.calculatePerimeterAndArea.ICalculatePerimeterAndArea;
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
     *
     * @param images the given Set to copy
     */
    public Drawing(Set<Image> images) {
        this.images = images;
    }

    /**
     * Getter that gets the Set of Image
     *
     * @return the Set of Image
     */
    public Set<Image> getImages() {
        return images;
    }

    /**
     * Setter that sets the Set of Image with a given Set
     *
     * @param images the given Set of Image
     */
    public void setImages(Set<Image> images) {
        this.images = images;
    }

    /**
     * Methods that adds an Image to the Set of Image
     *
     * @param img the Image to add to the Set
     */
    public void addImage(Image img) {
        this.images.add(img);
        System.out.println("Une image a été ajoutée au dessin (Nom de l'image : " + img.getName() + ")");
    }

    /**
     * Methods that copies the current drawing
     *
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
        System.out.println("Voici l'ensemble des périmètres des images contenues dans le dessin : ");
        double perimeter = 0;
        for (Image i : images) {
            System.out.println("\t" + i.getName() + " : ");
            perimeter += i.calculatePerimeter();
        }
        System.out.println("Le périmètre du dessin vaut au total : " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateArea() {
        System.out.println("Voici l'ensemble des aires des images contenues dans le dessin : ");
        double area = 0;
        for (Image i : images) {
            System.out.println("\t" + i.getName() + " : ");
            area += i.calculateArea();
        }
        System.out.println("L'aire du dessin vaut au total : " + area);
        return area;
    }

    @Override
    public void translation(int x, int y) {
        System.out.println("L'ensemble des images contenues dans le dessin vont être translatées de " +
                x + " en x et de " + y + " en y : ");
        for (Image i : images) {
            System.out.println("\t" + i.getName() + " : ");
            i.translation(x, y);
        }
        System.out.println("L'ensemble des images contenues dans le dessin ont été translatées de " +
                x + " en x et de " + y + " en y : ");
    }

    @Override
    public void homothetie(Point p, int ratio) {
        System.out.println("L'ensemble des images contenues dans le dessin vont subir une homothétie de centre O(" +
                p.getX() + ","+ p.getY() + ") et de rapport " + ratio);
        for (Image i : images) {
            System.out.println("\t" + i.getName() + " : ");
            i.homothetie(p, ratio);
        }
        System.out.println("L'ensemble des images contenues dans le dessin ont subies une homothétie de centre O(" +
                p.getX() + ","+ p.getY() + ") et de rapport " + ratio);
    }

    @Override
    public void rotation(int angle) {
        System.out.println("L'ensemble des images contenues dans le dessin vont subir une rotation à " +
                angle + " degrés");
        for (Image i : images) {
            System.out.println("\t" + i.getName() + " : ");
            i.rotation(angle);
        }
        System.out.println("L'ensemble des images contenues dans le dessin ont subies une rotation à " +
                angle + " degrés");
    }

    @Override
    public void centralSymmetry(Point p) {
        System.out.println("L'ensemble des images contenues dans le dessin vont subir une symetrie centrale par rapport " +
                "au point O(" + p.getX() + ","+ p.getY() + ")");
        for (Image i : images) {
            System.out.println("\t" + i.getName() + " : ");
            i.centralSymmetry(p);
        }
        System.out.println("L'ensemble des images contenues dans le dessin ont subies une symetrie centrale par rapport " +
                "au point O(" + p.getX() + ","+ p.getY() + ")");
    }

    @Override
    public void axialSymmetry(int width, int height, String s) {
        System.out.println("L'ensemble des images contenues dans le dessin vont subir une symetrie axiale par rapport " +
                "à l'axe " + s);
        for (Image i : images) {
            System.out.println("\t" + i.getName() + " : ");
            i.axialSymmetry(width, height, s);
        }
        System.out.println("L'ensemble des images contenues dans le dessin ont subies une symetrie axiale par rapport " +
                "à l'axe " + s);
    }
}
