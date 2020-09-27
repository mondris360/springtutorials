package com.spring.framework.master.LearningSpringFrameWork;

import com.spring.framework.master.LearningSpringFrameWork.sorting.algorithm.Binary_Search;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearningSpringFrameWorkApplicationBinarySearch {

	public static void main(String[] args) {
//		SpringApplication.run(LearningSpringFrameWorkApplication.class, args);
		// tight coupling
//		Binary_Search binarySearch =  new Binary_Search(new QuickSortAlgo());
		int[] elements =  {1,2,3,4,5};
		// get the Application context which contains all the beans
		ApplicationContext  applicationContext =  SpringApplication.run(LearningSpringFrameWorkApplicationBinarySearch.class, args);
		// get the required bean from thBinary_Searche application context
		Binary_Search binarySearchBean1 =  applicationContext.getBean(Binary_Search.class);
		Binary_Search binarySearchBean2 =  applicationContext.getBean(Binary_Search.class);
		Binary_Search binarySearchBean3 =  applicationContext.getBean(Binary_Search.class);
		System.out.println(binarySearchBean1);
		System.out.println(binarySearchBean2);
		System.out.println(binarySearchBean3);
//		int answer  =  binarySearchBean.sort(elements, 5);
//		System.out.println("Answer =  " +  answer);

	}

}
