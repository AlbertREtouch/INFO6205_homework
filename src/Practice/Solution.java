package Practice;

import java.util.List;

public class Solution {
    public void swap(List<List<Integer>> array, int a,int b){
        List<Integer> temp = array.get(a);
        array.set(a,array.get(b));
        array.set(b,temp);
    }
    public void quickSort(List<List<Integer>> array,int low ,int high){
        if (low == high){
            return;
        }
        int pivot = array.get(high).get(0);
        int left  = low;
        int right = high;
        int cur = left;
        while (left <= right) {
            if (array.get(cur).get(0) < pivot) {
                if (array.get(left).get(0) >= pivot){
                    swap(array,left,cur);
                }

                left++;
                cur++;
            }
            else if (array.get(cur).get(0) == pivot){
                cur++;
            }
            else {
                swap(array,right,cur);
                right--;
            }


        }
        quickSort(array,low,left);
        quickSort(array,high,right);

    }
}
