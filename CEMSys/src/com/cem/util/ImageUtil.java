package com.cem.util;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageUtil {
	public static int[] getImageWidthAndHeight(InputStream image) throws IOException,FileNotFoundException{
		BufferedImage bf = ImageIO.read(image);
		return new int[]{bf.getWidth(),bf.getHeight()};
	}
}
