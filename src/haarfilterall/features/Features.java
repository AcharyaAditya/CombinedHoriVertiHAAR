/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haarfilterall.features;

import haarfilterall.util.CalculateFeature;

/**
 *
 * @author user
 */
public class Features {

    public int[] FeatureA(int w, int h, int[][] intValues) {
        int imgH = 5;
        int imgW = 5;
        int count = 0;
        int tempFeature = 0;
        int[] featureValues = new int[150];
//        int[][] integralValues = new int[5][5];
        /**
         * Image area is a class to calculate the area of a certain window
         * generated by the i and j values in the following loop and sliding it
         * through each position of the array which will later be replaced by an
         * image to calculate its features
         */
        CalculateFeature calculateFeature = new CalculateFeature();

//        int w = 1, h = 2;
        for (int i = 1; i <= (imgW / w); i++) {
            for (int j = 1; j <= (imgH / h); j++) {
                for (int x = 1; x <= (imgW - i * w + 1); x++) {
                    for (int y = 1; y <= imgH - j * h + 1; y++) {
                        /**
                         * CalculateArea gives the area of the selected window
                         * with reference to the integral image and drastically
                         * reduces the computation time
                         */
                        if (x == 1 || y == 1) {

                        } else {
                            tempFeature = calculateFeature.CalculateSubtractionA(i, j, x, y, count, intValues);
//                        imageArea.CalculateArea(i, j, x, y, count);
                            count++;
                            featureValues[count] = tempFeature;

                        }
                    }
                }
                System.out.println("");
                System.out.println("COUNT= " + count);
            }
        }
        return featureValues;
    }

    public int[] FeatureB(int w, int h, int[][] intValues) {
        int imgH = 5;
        int imgW = 5;
        int count = 0;
        int tempFeature = 0;
        int[] featureValues = new int[150];
//        int[][] integralValues = new int[5][5];
        /**
         * Image area is a class to calculate the area of a certain window
         * generated by the i and j values in the following loop and sliding it
         * through each position of the array which will later be replaced by an
         * image to calculate its features
         */
        CalculateFeature calculateFeature = new CalculateFeature();

//        int w = 1, h = 2;
        for (int i = 1; i <= (imgH / h); i++) {
            for (int j = 1; j <= (imgW / w); j++) {
                for (int x = 1; x <= (imgH - i * h + 1); x++) {
                    for (int y = 1; y <= imgW - j * w + 1; y++) {
                        /**
                         * CalculateArea gives the area of the selected window
                         * with reference to the integral image and drastically
                         * reduces the computation time
                         */
                        if (x == 1 || y == 1) {
                        } else {
                            tempFeature = calculateFeature.CalculateSubtractionB(j, i, y, x, count, intValues);
//                        imageArea.CalculateArea(j, i, y, x, count);
                            count++;
                            featureValues[count] = tempFeature;

                        }
                    }
                }
                System.out.println("");
                System.out.println("COUNT= " + count);
            }
        }
        return featureValues;

    }
}
