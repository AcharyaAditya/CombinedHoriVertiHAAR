/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadPackage;

import haarfilterall.features.Features;

/**
 *
 * @author xitiz
 */
public class RunnableThread implements Runnable {
    private Thread t;
    private int mWidth;
    private int mHeight;
    private int mFeatureNumber;
    private int[][] mIntegralValues;
    private String mThreadName;
    private  int[] mFeaturesValues = new int[43200];
    private Features features = new Features();

    public RunnableThread(int width, int height, int[][] integralValues,
            String threadName,int featureNumber){
        this.mWidth = width;
        this.mHeight = height;
        this.mIntegralValues = integralValues;
        this.mThreadName = threadName;
        this.mFeatureNumber = featureNumber;
    }
    
    
    
    @Override
    public void run() {
//        System.out.println("Creating thread : " + mThreadName);
        
        
        switch(mFeatureNumber){
            case 1:
                mFeaturesValues = features.FeatureA(mWidth, mHeight, mIntegralValues);
                break;
            
            case 2:
                mFeaturesValues = features.FeatureB(mWidth, mHeight, mIntegralValues);
                break;
                
            case 5:
                mFeaturesValues = features.FeatureE(mWidth, mWidth, mIntegralValues);
                break;
                
            default:
                break;
        }
    }
    
    public int[] start(){
        if (t == null){
            t = new Thread(this, mThreadName);
            t.start();
        }
        
        return mFeaturesValues;
    }
    
}
