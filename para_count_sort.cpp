//
//  count_sort.cpp
//  
//
//  Created by Matthew Gu on 2/15/21.
//

#include "para_count_sort.hpp"

#include <algorithm>
#include <iostream.h>
#include <stdio.h>
#include_next <stdlib.h>
#include <omp.h>
using namspace std;
 
    void CountSort (int *a, int n)
    {
                int *temp = new int[n];
            omp_set_num_threads(4);
            #pragma omp parallel for
        for (int i = 0; i < n; ++i)
        {
            int count;
            count = 0;
            printf("%d: %d\n", omp_get_thread_num (), i);
            #pragma omp parallel for
            for (int j = 0; j < n; ++j)
            {
                if (a[j] < a[i])
                    count++;
                else if (a[j] == a[i] && j < i)
                    count++;
            
            }
            
            temp[count] = a[i];
        }
        
        //copy(temp, temp+n, a);
        delete[] temp;
    }

    int main (int argc, char ** argv)
    {
        srand((unsigned) time(0));
        double start;
        double end;
        int n = 4096;
        int a[n];
    
        for(int i=0; i<n; i++)
    {
        //populate the array
        a[i] = rand() % 100;
    }
        
    //Get the initial time of the algorithm
    start = omp_get_wtime();
    CountSort(a,n);
        
    //Get the ending time of the algorithm
    end = omp_get_wtime();
    for (int i = 0; i < 8; ++i)
        printf("a[%d] = %d\n", i, a[i]);
        
    //Print the algorithm's run time
    printf("Time elaposed: %f seconds\n", end-start);
}
