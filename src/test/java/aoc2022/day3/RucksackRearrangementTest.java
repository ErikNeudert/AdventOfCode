package aoc2022.day3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import aoc2022.InputUtil;

public class RucksackRearrangementTest extends InputUtil {

	@Test
	public void test1() {
		List<String> lines = get("test1.txt");
		int sum = lines.stream().map(Rucksack::new)
			.map(RucksackRearrangementTest::findCommonItem)
			.mapToInt(RucksackRearrangementTest::getItemPrio)
			.sum();
		assertEquals(157, sum);
	}
	
	@Test
	public void part1() {
		List<String> lines = get("input.txt");
		int sum = lines.stream().map(Rucksack::new)
			.map(RucksackRearrangementTest::findCommonItem)
			.mapToInt(RucksackRearrangementTest::getItemPrio)
			.sum();
		assertEquals(7903, sum);
	}
	
	@Test
	public void test2() {
		List<String> lines = get("test1.txt");
		Rucksack[] rucksacks = lines.stream().map(Rucksack::new).toArray(Rucksack[]::new);
		List<Group> groups = new ArrayList<>();
		for (int i = 0; i < rucksacks.length; i += 3) {
			Group g = new Group();
			g.members[0] = rucksacks[i + 0];
			g.members[1] = rucksacks[i + 1];
			g.members[2] = rucksacks[i + 2];
			groups.add(g);
		}
		
		int sum = groups.stream()
			.map(RucksackRearrangementTest::findGroupItem)
			.mapToInt(RucksackRearrangementTest::getItemPrio)
			.sum();
		assertEquals(70, sum);
	}
	
	@Test
	public void part2() {
		List<String> lines = get("input.txt");
		Rucksack[] rucksacks = lines.stream().map(Rucksack::new).toArray(Rucksack[]::new);
		List<Group> groups = new ArrayList<>();
		for (int i = 0; i < rucksacks.length; i += 3) {
			Group g = new Group();
			g.members[0] = rucksacks[i + 0];
			g.members[1] = rucksacks[i + 1];
			g.members[2] = rucksacks[i + 2];
			groups.add(g);
		}
		
		int sum = groups.stream()
			.map(RucksackRearrangementTest::findGroupItem)
			.mapToInt(RucksackRearrangementTest::getItemPrio)
			.sum();
		assertEquals(2548, sum);
	
	}
	
	static class Group {
		final Rucksack[] members = new Rucksack[3];
	}
	
	static class Rucksack {
		//has two compartments
		final String compartment1;
		final String compartment2;
		final String complete;
		
		public Rucksack(final String input) {
			int length = input.length();
			if (length % 2 != 0) {
				throw new IllegalStateException();
			}
			this.compartment1 = input.substring(0, length / 2);
			this.compartment2 = input.substring(length / 2);
			this.complete = input;
		}
		
		@Override
		public String toString() {
			return "Rucksack: " + compartment1 + " - " + compartment2;
		}
	}

	public static char findCommonItem(Rucksack ruck) {
		char[] c1 = ruck.compartment1.toCharArray();
		Arrays.sort(c1);
		
		char[] c2 = ruck.compartment2.toCharArray();
		for (char c : c2) {
			if (Arrays.binarySearch(c1, c) >= 0) {
				return c;
			}
		}
		
		throw new IllegalStateException("No common item? " + ruck);
	}

	private static int getItemPrio(char c) {
		if (c >= 'a' && c <= 'z') {
			return c - 'a' + 1;
		} else if (c >= 'A' && c <= 'Z') {
			return c - 'A' + 27;
		}
		
		throw new IllegalStateException();
	}

	private static char findGroupItem(Group group) {
		char[] c1 = group.members[0].complete.toCharArray();
		char[] c2 = group.members[1].complete.toCharArray();
		char[] c3 = group.members[2].complete.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		for (char c : c3) {
			if (Arrays.binarySearch(c1, c) >= 0 && Arrays.binarySearch(c2, c) >= 0) {
				return c;
			}
		}
		
		throw new IllegalStateException("No common item? " + group);
	}
}
