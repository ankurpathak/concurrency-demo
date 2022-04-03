package com.github.ankurpathak;


//FileReader inFile = new FileReader(System.getProperty("user.dir") + "/input.txt");
//   FileWriter outFile = new FileWriter(System.getProperty("user.dir") + "/output.txt");

// { Driver Code Starts
//Initial Template for Java

// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        FileReader inFile = new FileReader(System.getProperty("user.dir") + "/input.txt");
        BufferedReader br = new BufferedReader(inFile);

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int N = Integer.parseInt(element[0]);
            int arr[] = new int[N];
            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution89 obj = new Solution89();
            ArrayList<Integer> ans;
            ans = obj.maxProductSubsequence(arr, N);
            if (ans.get(0) == -1)
                System.out.println("Not Present");
            else {
                for (int i : ans)
                    System.out.print(i + " ");
                System.out.println();
            }

        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution89 {


    public static ArrayList<Integer> maxProductSubsequence(int arr[], int n) {
        //Complete the function
        int[] iseLeft = new int[n];
        int[] geRight = new int[n];

        int max = arr[n - 1];
        geRight[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (max > arr[i]) {
                geRight[i] = max;
            } else if (max < arr[i]) {
                geRight[i] = -1;
                max = arr[i];
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i] - 1)) {
                iseLeft[i] = arr[i] - 1;
            } else {
                iseLeft[i] = -1;
            }
            set.add(arr[i]);
        }


        long maxProduct = Integer.MIN_VALUE;
        int maxIdx = -1;
        ArrayList<Integer> collector = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (iseLeft[i] != -1 && geRight[i] != -1) {
                long product = 1L * iseLeft[i] * arr[i] * geRight[i];
                if (product > maxProduct) {
                    maxProduct = product;
                    maxIdx = i;
                }
            }
        }

        if (maxIdx != -1) {
            collector.addAll(Arrays.asList(iseLeft[maxIdx], arr[maxIdx], geRight[maxIdx]));
        } else {
            collector.add(-1);
        }
        return collector;
    }


}




