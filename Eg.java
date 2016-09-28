
package eg;
import java.util.*;
import java.io.*;


public class Eg{

    static double[] st;
     double[] array;
    double[] tempMergArr;
    int length;

//
     public void sort(double inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new double[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
    
    
    //
    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      
      int n=sc.nextInt();
      int k=sc.nextInt();
      double[] p=new double[n];
      double[] x=new double[n];
      double[] y=new double[n];
      
      
      for(int i=0;i<n;i++){
          p[i]=sc.nextDouble();
      }
       for(int i=0;i<n;i++){
          x[i]=sc.nextDouble();
      }
        for(int i=0;i<n;i++){
          y[i]=sc.nextDouble();
      }
        Eg obj=new Eg();
         st=new double[n];
        
        for(int i=0;i<n;i++){
            st[i]=((p[i]*x[i]) - ((1-p[i])*y[i]));
        }
        obj.sort(st);
       // System.out.println(obj.st[0]+" "+obj.st[1]+" "+obj.st[2]+" "+obj.st[3]);
        double res=0.00;
        for(int i=0;i<k;i++){
            res=Math.max(res,res+obj.array[n-i-1]);
            
        }
     
        System.out.format("%.2f", res);
    }
}