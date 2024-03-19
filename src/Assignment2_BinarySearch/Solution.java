package Assignment2_BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


//    return target index
    public static int binarySearch(List<Integer> array,int target){
        int left = 0;
        int right = array.size()-1;
        while(left <= right){
            int mid = (left / 2 - right/2) + right;
//            System.out.println("mid"+array.get(mid));
            if (array.get(mid) == target){
                return mid;
            }
            if (target > array.get(mid)){
                left = mid + 1;
            }
            else{
//               target > array.get(mid)
                right = mid-1;
            }
        }
//        can not find the target
        return -1;

    }
//  Algorithm 1:Given a sorted array containing duplicates, count the number of occurrences of a given element
    public static int countOccurrences(List<Integer> array,int target){
        int idx = binarySearch(array,target);
        if(idx == -1){
            return 0;
        }
        int l = idx-1;
        int r = idx+1;
        int count = 1;
        int lastLoopCount = 0;
        while (true){

            if (l >= 0 && array.get(l) == target){
                count++;
                l--;
            }
            if (r < array.size() && array.get(r) ==target){
                count++;
                r++;
            }
//            If two pointer can not move further, break the loop
            if (lastLoopCount == count){
                break;
            }
            lastLoopCount = count;

        }
        return count;
    }
//  Algorithm 2:Find Element in Rotated Sorted Array
    public static int binarySearchForRotatedSortedArray(List<Integer> array,int target){
        int left = 0;
        int right = array.size()-1;
        while(left <= right){
            int mid = (left / 2 - right/2) + right;
            System.out.println("mid"+array.get(mid));
            if (array.get(mid) == target){
                return mid;
            }
            if(array.get(mid + 1) <= array.get(right)){
                System.out.println("右！");
                if (target >= array.get(mid+1) && target <= array.get(right)){
                    left = mid + 1;

                }
                else {
                    right = mid-1;
                }
                continue;
            }


            if(array.get(left) <= array.get(mid-1)){
                System.out.println("左！");
                if (target <= array.get(mid-1) && target >= array.get(left)){
                    right = mid-1;
                }
                else {
                    left = mid + 1;
                }
                continue;
            }
        }
//        can not find the target
        return -1;
    }



    public static void main(String[] args) {
        List<Integer> array1 = new ArrayList<>(Arrays.asList(2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15));
        List<Integer> array2 = new ArrayList<>(Arrays.asList(6, 7, 8, 2, 3, 4, 5));
        int res1 = countOccurrences(array1,15);
        int res2 = binarySearchForRotatedSortedArray(array2,6);
        System.out.println("res1:"+res1);
        System.out.println("res2:"+res2);
    }
}
