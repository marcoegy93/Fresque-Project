package fresco.containers;

import fresco.containers.calculatePerimeterAndArea.ICalculatePerimeterAndArea;
import fresco.containers.geometricShapes.Line;
import fresco.containers.geometricShapes.utils.Point;
import fresco.containers.transformations.ITransformation;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Drawing implements ICalculatePerimeterAndArea,ITransformation {
    private Set<Image> images;

    public Drawing(){
        this.images = new LinkedHashSet<Image>();
    }

    public Drawing(Set<Image> images){
        this.images = images;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public void addImage(Image img){
        this.images.add(img);
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 0;
        for(Image i : images){
            perimeter+= i.calculatePerimeter();
        }
        return perimeter;
    }

    @Override
    public double calculateArea() {
        double area = 0;
        for(Image i : images){
            area+= i.calculateArea();
        }
        return area;
    }

    @Override
    public void translation(double x, double y) {
        for(Image i : images){
            i.translation(x,y);
        }
    }

    @Override
    public void homothetie(Point p, double ratio) {
        for(Image i : images){
            i.homothetie(p,ratio);
        }
    }

    @Override
    public void rotation(Point p, double angle) {
        for(Image i : images){
            i.rotation(p,angle);
        }
    }

    @Override
    public void centralSymetry(Point p) {
        for(Image i : images){
            i.centralSymetry(p);
        }
    }

    @Override
    public void axialSymetry(Line l) {
        for(Image i : images){
            i.axialSymetry(l);
        }
    }

    public Drawing copyDrawing(){
        return new Drawing(this.images);
    }

    public void imagesSort(){
        List<Image> list = new ArrayList<Image>(images);
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(i).calculateArea() < list.get(j).calculateArea()){
                    Image tmp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,tmp);
                }
            }
        }
        Set<Image> images = new LinkedHashSet<>(list);
        this.setImages(images);
    }
}
