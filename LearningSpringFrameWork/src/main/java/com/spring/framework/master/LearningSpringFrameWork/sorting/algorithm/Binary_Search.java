package com.spring.framework.master.LearningSpringFrameWork.sorting.algorithm;

import com.spring.framework.master.LearningSpringFrameWork.interfaces.SortingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Binary_Search {
    @Autowired
    // use a bean with this qualifier name for dependency injection
    @Qualifier("quickSort")
    private SortingAlgorithm quickSortAlgo;

    public Binary_Search(SortingAlgorithm bubleSortAlgo) {
        this.quickSortAlgo = bubleSortAlgo;
    }


    public int sort(int[] array, int numberToFind){

        int[]sorted =  quickSortAlgo.sort(array);

            // binary search algo
        System.out.println(quickSortAlgo);
        return 10;
    }
}
