package aoc2022.day1;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import aoc2022.InputUtil;

public class CalorieCounterTest extends InputUtil {

	@Test
	public void test1() {
		List<String> lines = get("test1.txt");
		LinkedList<Elve> elves = CalorieCounter.count(lines);
		int mostCals = elves.poll().cals;
		assertEquals(24000, mostCals);
	}
	
	@Test
	public void day1() {
		List<String> lines = get("input.txt");
		LinkedList<Elve> elves = CalorieCounter.count(lines);
		int mostCals = elves.poll().cals;
		System.out.println(mostCals);
	}

	
	@Test
	public void test2() {
		List<String> lines = get("test1.txt");
		LinkedList<Elve> elves = CalorieCounter.count(lines);
		int mostCals1 = elves.poll().cals;
		int mostCals2 = elves.poll().cals;
		int mostCals3 = elves.poll().cals;
		assertEquals(45000, mostCals1 + mostCals2 + mostCals3);
	}
	
	@Test
	public void day1_2() {
		List<String> lines = get("input.txt");
		LinkedList<Elve> elves = CalorieCounter.count(lines);
		int mostCals1 = elves.poll().cals;
		int mostCals2 = elves.poll().cals;
		int mostCals3 = elves.poll().cals;
		System.out.println(mostCals1 + mostCals2 + mostCals3);
	}
}
