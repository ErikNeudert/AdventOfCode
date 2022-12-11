package aoc2022.day1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import aoc2022.InputUtil;

public class CalorieCounter {

	public static void main(String[] args) {
		List<String> lines = InputUtil.get(CalorieCounter.class, "input.txt");
		System.out.println(count(lines));
	}

	public static LinkedList<Elve> count(List<String> lines) {
		LinkedList<Elve> elves = new LinkedList<>();
		elves.add(new Elve());

		for (String line : lines) {
			if (line.isEmpty()) {
				elves.addFirst(new Elve());
			} else {
				int cals = Integer.parseInt(line);
				elves.peekFirst().addCalories(cals);
			}
		}

		Collections.sort(elves);
		return elves;
	}
}
