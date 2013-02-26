/*
 * FIT VUT - 2013 - GJA project 1 - Photo viewer
 * 
 * Ondrej Fibich <xfibic01@stud.fit.vutbr.cz>
 */
package cz.vutbr.fit.gja.project;

import cz.vutbr.fit.gja.project.gui.MainJFrame;
import java.io.File;
import javax.swing.SwingUtilities;

/**
 * Triggers the programs - opens window with an image given as argument or opens
 * a blank window if argument is not passed.
 *
 * @author Ondrej Fibich
 */
public class JPhotoView {

    /** File argument */
    private static File farg = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        /* Args */
        if (args.length == 1) {
            File f = new File(args[0]);
            if (f.canRead()) {
                farg = f;
            } else {
                System.err.println("Cannot read from file: " + args[0]);
            }
        } else if (args.length > 1) {
            System.out.println("Invalid count of arguments..");
        }
        /* Window */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainJFrame mainJFrame = new MainJFrame(farg);
                mainJFrame.setVisible(true);
            }
        });
    }
}
