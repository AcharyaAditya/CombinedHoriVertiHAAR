/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haarfilterall;

import HistogramEqualization.impl.HistEq;
import HistogramEqualization.util.HistoNormalize;
import Parallel.ParallelRun;
import haarfilterall.features.Features;
import haarfilterall.util.IntegralImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Aditya Darshan Acharya
 */
public class HaarFilterAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        int[] twoHoriFea = new int[43200];
        int[] twoVertFea = new int[43200];
        int[] threeHoriFea = new int[27600];
//      int[] threeVertFea = new int[150];
        int[] fourRectFea = new int[43200];
        int[][] values = new int[24][24];
        int[][] intValues = new int[24][24];
        int[] iarray = new int[3];

        Features features = new Features();
        IntegralImage integralImage = new IntegralImage();

        BufferedImage img = null;
        img = ImageIO.read(new File("image\\test1.jpg"));

        HistEq histEq = new HistEq();                                           //call histogram equilization
        img = histEq.Change(img);                                               //retreive equilized image

        //HistoNormalize histoNormalize = new HistoNormalize();
        //img = histoNormalize.HistoNormal(img);
        //File f1 = new File("subhisto\\histotest001.png");                         //save the whole equalized image without subimaging
        //ImageIO.write(img, "png", f1);
        int count = 0;                                                          //for naming convention as well as keeping track of the number of sub images.

        for (int i = 0; i <= (img.getHeight() - 24); i++) {                     //For a 24x24 Pixel image define height such that the last image to be extracted has atleast 24 Pixels to work with
            for (int j = 0; j <= (img.getWidth() - 24); j++) {                  //*For a 24x24 Pixel image define width such that the last image to be extracted has atleast 24 Pixels to work with
                BufferedImage sub = img.getSubimage(j, i, 24, 24);              //sub image starting point defined by i and j & 24x4 is the needed size for the sub image.             
                count++;
                for (int k = 0; k < 24; k++) {
                    for (int l = 0; l < 24; l++) {
                        values[k][l] = sub.getRaster().getPixel(k, l, iarray)[0];
                    }
                }

                intValues = integralImage.Integral(values);

                //ParallelRun R1 = new ParallelRun("Filter1", 1, intValues);
                //R1.start();
                //ParallelRun R2 = new ParallelRun("Filter2", 2, intValues);
                //R2.start();
                //ParallelRun R3 = new ParallelRun("Filter1", 3, intValues);
                //R3.start();
                //ParallelRun R4 = new ParallelRun("Filter2", 4, intValues);
                //R4.start();
                twoHoriFea = features.FeatureA(2, 1, intValues);
                twoVertFea = features.FeatureB(1, 2, intValues);
                threeHoriFea = features.FeatureC(3, 1, intValues);
                fourRectFea = features.FeatureE(2, 2, intValues);

                // Hori Fearures + Verti Features 36432
                // Four Rect features = 17424               
            }
            //Normalize Histogram Portion Remaining!!
        }
        System.out.println("IMAGE NUMBER = " + count);
    }

}
