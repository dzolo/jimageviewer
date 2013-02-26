/*
 * FIT VUT - 2013 - GJA project 1 - Photo viewer
 * 
 * Ondrej Fibich <xfibic01@stud.fit.vutbr.cz>
 */
package cz.vutbr.fit.gja.project.util;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 * Providing access to icons stored in the JAR archive.
 * 
 * Icons are cached to save memory. Icons are stored in package:
 * cz.vutbr.fit.gja.project.resource.image.icon
 * Patterns for naming them is "[id]_x[scale].png" or "[id].png".
 *
 * @author Ondrej Fibich
 */
public class Icons {
	
	/** Path for resources */
	private static final String ICO_PATH = "/cz/vutbr/fit/gja/project/resource/image/icon/";
	
	/** Icons allowed extension suffixes */
	private static final String[] ICO_EXT = {".png", ".gif", ".jpg"};
	
	/** Default scale of icon */
	private static final int DEFAULT_SCALE = 16;
	
	/** Cache for icons */
	private static Map<String, ImageIcon> chache = new HashMap<String, ImageIcon>();
	
	/**
	 * Gets an icon from resources with default scale. 
	 * 
	 * @param identificator Name of icon
	 * @return Icons image
	 */
	public static ImageIcon get(String identificator) throws NullPointerException {
		return get(identificator, DEFAULT_SCALE);
	}
	
	/**
	 * Gets an icon from resources.
	 * 
	 * @param id Name of icon (identificator)
	 * @param scale Scale of icon (e.g. 16, 32)
	 * @return Icons image
	 */
	public static ImageIcon get(String id, int scale) throws NullPointerException {
		// full id
		final String fullId = id + "#" + scale;
		// already in cache
		if (!chache.containsKey(fullId)) {
			// paths
			final String path_scaled = ICO_PATH + id + "_x" + scale;
			final String path = ICO_PATH + id;
			URL fp = null;
			// image exists?
			for (String ext : ICO_EXT) {
				if ((fp = Icons.class.getResource(path_scaled + ext)) != null ||
					(fp = Icons.class.getResource(path + ext)) != null) {
					break;
				}
			}
			// founded?
			if (fp == null) {
				final String m = "Icon '" + path + "' not founded.";
				throw new NullPointerException(m);
			}
			// create and add to chache
			chache.put(fullId, new ImageIcon(fp));
		}
		// retun icon
		return chache.get(fullId);
	}
}
