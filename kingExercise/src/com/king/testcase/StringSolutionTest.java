package com.king.testcase;

import static org.junit.Assert.*;
import com.king.stringExercise.StringSolution;
import org.junit.Test;

public class StringSolutionTest {

	@Test
	public void testLeetCode(){
		int[] indices = new int[]{4,5,6,7,0,2,1,3};
		assertEquals("leetcode", StringSolution.restoreString("codeleet",indices));

	}

	@Test
	public void testKing(){
		int[] indices = new int[]{2,1,3,0};
		assertEquals("King", StringSolution.restoreString("nigK",indices));

	}
}
