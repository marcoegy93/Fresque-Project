package UI.panels;

import appli.ImagePanelDrawUtil;
import fresco.containers.Image;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Set;

/**
 * UI Class that shows a List of the Images contained in a Drawing
 */
public class ListPanel extends JPanel {
    /**
     * The list of Images contained in a Drawing
     */
    private final JList<String> listImage;

    /**
     * The default constructor of a ListPanel
     * It creates a JList component containing all the images from the Drawing
     */
    public ListPanel() {
        DefaultListModel<String> l = new DefaultListModel<>();
        listImage = new JList<>(l);
        listImage.setPreferredSize(new Dimension(200, 200));
        listImage.setSelectedIndex(0);
        listImage.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                ImagePanelDrawUtil.setCurrentImage(listImage.getSelectedIndex());
            }
        });
        setNewDataOnList(ImagePanelDrawUtil.getImagePanel().getLinkedDrawing().getDrawing().getImages());
        add(listImage);
    }

    /**
     * Method that allows to set all the Images of a given Drawing in the JList
     *
     * @param Images
     */
    public void setNewDataOnList(Set<Image> Images) {
        String[] l = new String[Images.size()];
        int index = 0;
        for (Image image : Images) {
            l[index] = image.getName();
            index++;
        }
        listImage.setListData(l);
        listImage.setSelectedIndex(Images.size() - 1);
    }

    /**
     * Allows to get the index of the selected image in the list
     *
     * @return the index of the selected index
     */
    public int getSelectedIndex() {
        return listImage.getSelectedIndex();
    }
}
