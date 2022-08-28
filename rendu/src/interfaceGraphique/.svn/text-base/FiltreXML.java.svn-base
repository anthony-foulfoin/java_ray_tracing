package interfaceGraphique;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbadie
 */
public class FiltreXML extends FileFilter {

    //Accept all directories and all gif, jpg, tiff, or png files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = TrouverExtension.getExtension(f);
        if (extension != null) {
            if (extension.equals(TrouverExtension.xml)){
                 return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Fichiers xml";
    }
}


