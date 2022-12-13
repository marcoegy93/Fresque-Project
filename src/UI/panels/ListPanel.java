package UI.panels;

import appli.ImagePanelDrawUtil;
import fresco.containers.Image;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Set;

public class ListPanel extends JPanel {
    private final JList<String> listImage;


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
     * @return the index of the selected index
     */
    public int getSelectedIndex() {
        return listImage.getSelectedIndex();
    }

}
