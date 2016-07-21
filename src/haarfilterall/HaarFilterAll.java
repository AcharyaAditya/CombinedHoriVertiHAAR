/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haarfilterall;

import HistogramEqualization.impl.HistEq;
import ThreadPackage.RunnableThread;
import haarfilterall.features.Features;
import haarfilterall.util.IntegralImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class HaarFilterAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int[] twoHoriFea = new int[43200];
        int[] twoVertFea = new int[43200];
//      int[] threeHoriFea = new int[150];
//      int[] threeVertFea = new int[150];
        int[] fourRectFea = new int[43200];
        int[][] values = new int[24][24];
        int[][] intValues = new int[24][24];
        int[] iarray = new int[3];

        Features features = new Features();
        IntegralImage integralImage = new IntegralImage();

        BufferedImage img = null;
        img = ImageIO.read(new File("image/test1.jpg"));

        HistEq histEq = new HistEq();                                           //call histogram equilization
        img = histEq.Change(img);                                               //retreive equilized image

//        File f1 = new File("subhisto\\histotest001.png");                         //save the whole equalized image without subimaging
//        ImageIO.write(img, "png", f1);
        int count = 0;                                                          //for naming convention as well as keeping track of the number of sub images.

        for (int i = 0; i <= (img.getHeight() - 24); i++) {                     //For a 24x24 Pixel image define height such that the last image to be extracted has atleast 24 Pixels to work with

            for (int j = 0; j <= (img.getWidth() - 24); j++) {                  //*For a 24x24 Pixel image define width such that the last image to be extracted has atleast 24 Pixels to work with

                BufferedImage sub = img.getSubimage(j, i, 24, 24);              //sub image starting point defined by i and j & 24x4 is the needed size for the sub image.             
                count++;
//                int[][] values = new int[24][24];
//                int[][] intValues = new int[24][24];

//                int numBands = img.getRaster().getNumBands();
//                int[] iarray = new int[numBands];

                for (int k = 0; k < 24; k++) {
                    for (int l = 0; l < 24; l++) {

                        values[k][l] = img.getRaster().getPixel(k, l, iarray)[0];
                    }
                }

//              IntegralImage integralImage = new IntegralImage();
                intValues = integralImage.Integral(values);

//                Features features = new Features();
//                features.FeatureA(2, 1, intValues);
//                features.FeatureB(1, 2, intValues);
//                features.FeatureE(2, 2, intValues);
//                RunnableThread R1 = new RunnableThread(2,1,intValues, "horizontal", 1);
//                twoHoriFea = R1.start();
//                
//                RunnableThread R2 = new RunnableThread(1,2,intValues, "Vertical",2);
//                twoVertFea = R2.start();
//                
//                RunnableThread R3 = new RunnableThread(2,2,intValues, "Four",5);
//                fourRectFea = R3.start();
                
                twoHoriFea = features.FeatureA(2, 1, intValues);
                twoVertFea = features.FeatureB(1, 2, intValues);
                fourRectFea = features.FeatureE(2, 2, intValues);
                
//        for (int i = 1; i <= 36432; i++) {
//            System.out.println("Horizontal features = " + twoHoriFea[i]);
////            System.out.println("Vertical features = " + twoVertFea[i]);
//        }
//        for (int i = 1; i <= 36432; i++) {
////            System.out.println("Horizontal features = " + twoHoriFea[i]);
//            System.out.println("Vertical features = " + twoVertFea[i]);
//        }
//        for (int i = 1; i <= 17424; i++) {
////            System.out.println("Horizontal features = " + twoHoriFea[i]);
//            System.out.println("R_features = " + fourRectFea[i]);
//        }
//                System.out.println("IMAGE NUMBER = " + count);
            }

//               
//                    HistoNormalize histoNormalize = new HistoNormalize();
//                    histoNormalize.HistoNormal(sub);
        }
        System.out.println("IMAGE NUMBER = " + count);
    }

}
