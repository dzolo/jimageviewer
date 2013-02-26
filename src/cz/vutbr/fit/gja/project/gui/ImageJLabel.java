/*
 * FIT VUT - 2013 - GJA project 1 - Photo viewer
 * 
 * Ondrej Fibich <xfibic01@stud.fit.vutbr.cz>
 */
package cz.vutbr.fit.gja.project.gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Displays an image on itself.
 *
 * @author Ondrej Fibich
 */
public class ImageJLabel extends JLabel {
    
    /**
     * Parent frame
     */
    private MainJFrame parent;

    /**
     * Creates new image panel
     * 
     * @param parent 
     */
    public ImageJLabel(MainJFrame parent) {
        this.parent = parent;
    }
    
    /**
     * Sets image
     * 
     * @param img 
     */
    public void display(ImageIcon img) {
        setIcon(img);
    }

    /**
     * Zooms image in
     */
    public void zoomIn() {
        int w = (int) (getIcon().getIconWidth() * 1.5);
        int h = (int) (getIcon().getIconHeight() * 1.5);
        Image simg = parent.getImage().getData().getImage().getScaledInstance(
                w, h, Image.SCALE_FAST
        );
        setIcon(new ImageIcon(simg));
    }

    /**
     * Zooms image out
     */
    public void zoomOut() {
        int w = Math.max(1, (int) (getIcon().getIconWidth() / 1.5));
        int h = Math.max(1, (int) (getIcon().getIconHeight() / 1.5));
        Image simg = parent.getImage().getData().getImage().getScaledInstance(
                w, h, Image.SCALE_FAST
        );
        setIcon(new ImageIcon(simg));
    }

    /**
     * Checks if zoom in can be made
     * 
     * @return indicator
     */
    public boolean hasZoomIn() {
        double ow = parent.getImage().getData().getIconWidth();
        double oh = parent.getImage().getData().getIconHeight();
        return (getIcon().getIconWidth() / ow < 5 &&
                getIcon().getIconHeight() / oh < 5);
    }
    
    /**
     * Get scale of current zoom
     * 
     * @return double
     */
    public double getCurrentScale() {
        return (double) getIcon().getIconWidth() /
                parent.getImage().getData().getIconWidth();
    }

    /**
     * Checks if zoom out can be made
     * 
     * @return indicator
     */
    public boolean hasZoomOut() {
        double ow = parent.getImage().getData().getIconWidth();
        double oh = parent.getImage().getData().getIconHeight();
        return (getIcon().getIconWidth() / ow > 0.2 &&
                getIcon().getIconHeight() / oh > 0.2);
    }
    
}
