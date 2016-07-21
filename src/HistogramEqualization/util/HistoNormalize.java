/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HistogramEqualization.util;

import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class HistoNormalize {
    public BufferedImage HistoNormal(BufferedImage bi) throws IOException {

        int numBands = bi.getRaster().getNumBands();
        int[] iarray = new int[numBands];
        String content = "";
        int count = 0;
        for (int i = 0; i < bi.getHeight(); i++) {
            for (int j = 0; j < bi.getWidth(); j++) {

                float value = bi.getRaster().getPixel(i, j, iarray)[0];

                value = value / 255;
               
                count++;
            }
        }
        System.out.println(count);
        return bi;
    }
}
