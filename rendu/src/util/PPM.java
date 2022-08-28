package util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.PixelGrabber;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PPM{

	/**
	 * Les dimensions de l'image
	 */
	private Dimension dim;
  
    /** 
     * Les pixels de l'image dans le format ARGB
     */
	private int[] data;
    
    /**
     * Constructeur de la classe a partir d'une image
     * @param image L'image que l'on souhaite convertir en PPM
     */
    public PPM(Image image) {
    	dim = new Dimension(-1, -1);
    	while (dim.width == -1) {
    	    dim.width = image.getWidth(null);
    	}
    	while (dim.height == -1) {
    	    dim.height = image.getHeight(null);
    	}
    	data = new int[dim.width*dim.height];
    	PixelGrabber pg = new PixelGrabber(image, 0, 0,
    					   dim.width, dim.height,
    					   data,
    					   0, dim.width);
    	try { pg.grabPixels(); } catch (Exception e) { e.printStackTrace(); }
    }

    /** 
     * 
     */
    public void write(String filename) throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		
		PrintStream ps = new PrintStream(fos);
	    ps.println("P3");
	    ps.println(dim.width + " " + dim.height);
	    ps.println(255);
	    for (int a = 0; a < dim.height; a++) {
			for (int b = 0; b < dim.width; b++) {
			    int offset = (dim.width * a) + b;
			    ps.print(((data[offset] >> 16) & 255) + " " +
				     ((data[offset] >>  8) & 255) + " " +
				     ((data[offset]      ) & 255) + " ");
			}
			ps.println();
	    }
	    ps.close();
	
		fos.flush();
		fos.close();
    }
}
