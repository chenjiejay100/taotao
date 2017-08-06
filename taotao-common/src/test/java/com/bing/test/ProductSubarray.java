package com.bing.test;

/**
 * Created by bing on 2017/8/1.
 */
public class ProductSubarray {

    static int min(int x, int y) {
        return x < y ? x : y;
    }
    static int max(int x, int y) {
        return x > y ? x : y;
    }
    static int maxSubarrayProduct(int arr[]) {
        int n = arr.length;
        // max positive product ending at the current position
        int max_ending_here = 1;

        // min negative product ending at the current position
        int min_ending_here = 1;

        // Initialize overall max product
        int max_so_far = 1;
        for (int i = 0; i < n; i++) {
            /* If this element is positive, update max_ending_here.
                Update min_ending_here only if min_ending_here is
                negative */
            if (arr[i] > 0) {
                max_ending_here = max_ending_here * arr[i];
                min_ending_here = min(min_ending_here * arr[i], 1);
            }
            else if (arr[i] == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            } else {
                int temp = max_ending_here;
                max_ending_here = max(min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }

            // update max_so_far, if needed
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }

        return max_so_far;
    }

    public static void main(String[] args) {

        int arr[] = {3,-4,1,2,5};
        System.out.println("Maximum Sub array product is " +
                maxSubarrayProduct(arr));
    }
}