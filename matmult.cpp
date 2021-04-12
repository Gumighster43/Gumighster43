/*
 * Worked with Dylan to figure out user inputs
 * Helped by Nathan to try to figure out how to get random numbers to be generated into the matrices
 * Helped by Marissa to figure out how to measure and document the time
 * Used medium.com to help conceptualize the algorithm to multiply the matrices
 * Used stackoverflow.com to figure out my errors
 * Used cpp.sh to compile program
 *
 *This program is sequential and successfully multiplies two user-inputted matrices and prints the
 *end result along with the time it took to run the program.
 *
 *
 *
 */
//  matmult.cpp
//  COMP 481 Applied Parallel Algorithms
//  Created by Matthew Gu on 1/29/21.
//

#include <iostream>
#include <omp.h>
#include <stdlib.h>
#include <time.h>
#include <stdio.h>
#include <chrono>
using namespace std;

int main() {
    int  z, rA, cA, rB, cB;
    
    //This prompts the user to input the number of rows and columns for the 1st Matrix
    cout << "Enter the desired number of rows and columns for the 1st Matrix and include a space in between your inputted numbers";
    cin >> rA >> cA;
    printf("This is a %d x %d matrix for the First Matrix.\n", rA, cA);
    
    printf("\n \n");
    
    //This prompts the user to input the number of rows and columns for the 2nd Matrix
    cout << "Enter the desired number of rows and columns for 2nd Matrix and include a space in between your inputted numbers";
    cin >> rB >> cB;
    printf("This is a %d x %d matrix for Second Matrix.\n", rB, cB);
    
    //Initializes the two created matrices that will be multiplied and creates the resulting matrices
    int createMatrix[rA][cB];
    int matrixOne[rA][cA];
    int matrixTwo[rB][cB];
    
    //Start measuring the time for the calculation
    auto start = std::chrono::high_resolution_clock::now();

    //Initializes the Start and End time
    clock_t Start, End;
    Start = clock();
    
    //This sets the seed value
    srand(time(0));
    int randomNums;
    
    //Unsuccessful implemention of getting random numbers :(
    for (int z=1; z<=50; z++)
    {
        randomNums = rand() % 10 + 1;
    }
    
    //ensures that the matrices are properly assigned an equal number of rows and columns
    if (cA != rB)
    {
        printf("ERROR: The number of Columns in the 1st matrix must equal the number of rows in the 2nd matrix.\n");
    }
    else if (rA != cB)
    {
        printf("ERROR: The number of Rows in the 1st matrix must equal the number of Columns in the 2nd matrix.\n");
    }
    else if (cA == rB && rA == cB)
    {
    // Populate the first matrix
        {
         printf("\n Populating 1st Matrix:");

            for (int i = 0;  i < rA; i++)
            {
                for(int n = 0; n < cA; n++)
                {  srand(time(0));
                   matrixOne[i][n] = randomNums;
                   printf("|%d| ",randomNums);
                }
            }

    printf("\n \n");
    
    // Populate the second matrix
        printf("\n Populating 2nd Matrix:");
            for (int a = 0; a < rB; a++)
            {
                for(int b = 0; b < cB; b++)
                {
                    srand(time(0));
                   matrixTwo[a][b] = randomNums;
                   printf("|%d| ",randomNums);
                }
            }
  
    // Initialize the matrix to 0.
        for (int i =0; i < rA ; i++)
               {
               for( int b = 0; b < cB; b++)
               {
                   createMatrix[i][b]= 0;
               }
               }
        
      printf("\n \n");
        
        //To multiply the matrices, we need to iterate through the rows of the First Matrix and the columns of the Second Matrices and then the columns of the First Matrix
        //Got help from medium.com to conceptualize this algorithm
          printf("\n Solving Matrix One multiplied by Second Matrix...\n", rA, cB );
         for (int m = 0; m < rA; m++)
        {
            for (int n = 0; n < cB; n++)
        {
                for (int p = 0; p < cA; p++)
                {
                    createMatrix[m][n] += (matrixOne[m][p] * matrixTwo[p][n]);
                    printf("%d ", createMatrix[m][n]);
                }
            }
        }
                 
        //Print the resulting Matrices
        for (int r = 0; r < rA ; r++)
            {
                for (int c = 0; c < cB; c++)
                        {
                            printf("| %d |", createMatrix[r][c]);
                        }
                }
        
       }
      
        printf("\n \n");
        printf("\nResulting Time: \n");

        //print out the time
        // Stop measuring time and calculate the elapsed time
        //Helped by Marissa with this
        auto end = std::chrono::high_resolution_clock::now();
        auto elapsed = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start);
        End = clock();
        double tot = ((double)(End - Start)) / CLOCKS_PER_SEC;
        printf("%f seconds\n", tot);
        
    return 0;
               }
}
