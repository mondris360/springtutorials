package com.spring.framework.master.LearningSpringFrameWork.sorting.algorithm;

import com.spring.framework.master.LearningSpringFrameWork.interfaces.SortingAlgorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BubleSortAlgo implements SortingAlgorithm {

    public int[] sort (int[] array) {
        System.out.println("binary sort");
         int[] sortedArray =  new int [array.length];
                 // bubble sort logic

         return sortedArray;
    }
}
