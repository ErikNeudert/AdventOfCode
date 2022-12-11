package aoc2022.day1;

public class Elve implements Comparable<Elve> {

	int cals;

	public void addCalories(int cals) {
		this.cals += cals;
	}

	@Override
	public int compareTo(Elve o) {
		return o.cals - cals;
	}

}
