/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haarfilterall;

import haarfilterall.features.Features;
import haarfilterall.util.IntegralImage;

/**
 *
 * @author user
 */
public class HaarFilterAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] values = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] intValues = new int[5][5];
        int[] twoHoriFea = new int[150];
        int[] twoVertFea = new int[150];
//        int[] threeHoriFea = new int[150];
//        int[] threeVertFea = new int[150];
//        int[] fourRectFea = new int[150];

        IntegralImage integralImage = new IntegralImage();
        intValues = integralImage.Integral(values);

        Features features = new Features();
        twoHoriFea = features.FeatureA(2, 1, intValues);
        twoVertFea = features.FeatureB(1, 2, intValues);

        for (int i = 1; i <= 40; i++) {
            System.out.println("Horizontal features = " + twoHoriFea[i]);
//            System.out.println("Vertical features = " + twoVertFea[i]);
        }
        for (int i = 1; i <= 40; i++) {
//            System.out.println("Horizontal features = " + twoHoriFea[i]);
            System.out.println("Vertical features = " + twoVertFea[i]);
        }

    }

}
