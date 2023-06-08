package TH1_NoiBot;

import java.util.Arrays;

public class bubbleSort {

    public static void main(String[] args) {
        int temp;
        int[] list = { 2,3,2,5,6,1,-2,3,14,12};
        for (int i = 0; i < list.length -1 ; i++) {
            for (int j = 0; j < list.length -1 -i ; j++) {
              if  (list[j] > list[j+1]){
                 temp = list[j];
                 list[j]= list[j+1];
                 list[j+1]=temp;

              }


            }

        }
        System.out.println("Mang đã được sắp sếp : " + Arrays.toString(list));


    }


}
