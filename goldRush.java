//ALGORITHM:

/*
   STEP1: Construct arrays for holding the input values x,y and the goldHidden.

   STEP2: Given the number of points N, construct a N*N Table and initialize
          each entry in the table with the smallest double value.

   STEP2: The diagonal of the constructed N*N matrix will give the maximum amount of gold that can be
            collected. Therefore we will build the table upto the diagonal element in each row.
            When we are the first element in the matrix we return the gold hidden at that point. This will
            serve as our base condition for DP. If we haven't reached the diagonal element in that row we calculate the gold at             the current point by subtracting the euclidean distance between this point and the previous point in the input and             adding the gold hidden at the current point, If we are at the diagonal element in the row, we get the maximum value             of all the elements in the row. This will be the maximum value of gold that charlie can collect in that row.

   STEP 3: The value of the last entry in the diagonal of the DP matrix will give the maximum gold value.

   RUNNING TIME ANALYSIS: The worst case time complexity of the algorithm will be O(n^2) since we run two loops for constructing the N*N matrix. Finding the euclidean distance and extracting the last element in the diagonal of the matrix are
   are simple arithmetic operations which take constant time.

   SPACE COMPLEXITY: The space complexity of the algorithm will be O(n^2) since we will create a N*N matrix table to store the    values of gold the person can make.
*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static double getDistance(int x1, int y1,int x2, int y2) {
		double eucledianDist = 0.0;
		double diffX = x1 - x2;
	    double diffY = y1 - y2;
	    eucledianDist = Math.sqrt(diffX*diffX + diffY*diffY);
	    return eucledianDist;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//initialize arrays with N since there are N points
		int N = sc.nextInt();
		int[] x = new int[N];
		int[] y = new int[N];
		int[] goldHidden = new int[N];

		//Read Values from STDIN
		for(int i=0; i< N ; i++)
		{
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			goldHidden[i] = sc.nextInt();
		}

		//Construct a N*N table to store values for each iteration
		double[][] DPTable = new double[N][N];
		double MaxGold = 0;

		//Initialize the DP matrix to the smallest double
		for(int i =0; i< x.length ; i++)
		{
			for(int j =0; j < y.length ; j++)
			{
				DPTable[i][j] = -2147483648;
			}
		}

		for(int i =0; i< x.length ; i++)
		{
			for(int j =0; j <= i ; j++)
			{
				//Base condition. Return the gold hidden at that place
				if(i ==0 && j ==0)
				{
					DPTable[i][j] = goldHidden[i];
				}

				else if(i == j)
					{
					// Get the maximum element in that row
					Double max = DPTable[i][0];

					     for(int col = 1; col < DPTable[i].length; col++)
					     {
					         if ( DPTable[i][col] > max )

					             max = DPTable[i][col];
					     }

						DPTable[i][j] = max;

					}

				else
					{
					    // Calculate the gold at that place by subtracting the euclidean distance
						// and adding the gold hidden at that place
						DPTable[i][j] = DPTable[j][j]
								- Solution.getDistance(x[i], y[i], x[j], y[j]) + goldHidden[i];
					}
				}
			}
		//The value of the last entry in the diagonal of the DP matrix will give the maximum gold value
		MaxGold =  DPTable[N-1][N-1];


		System.out.println(String.format("%.6f", MaxGold));

	}
}
