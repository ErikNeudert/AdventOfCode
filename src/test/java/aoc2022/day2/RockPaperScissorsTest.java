package aoc2022.day2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import aoc2022.InputUtil;

public class RockPaperScissorsTest extends InputUtil {

	@Test
	public void test1() {
		Part1Parser parser = new Part1Parser();
		List<String> lines = get("test1.txt");
		int score = lines.stream()
				.map(parser::parseRound)
				.mapToInt(Round::evaluate)
				.sum();
		assertEquals(15, score);
	}
	
	@Test
	public void day2_1() {
		Part1Parser parser = new Part1Parser();
		List<String> lines = get("input.txt");
		int score = lines.stream()
				.map(parser::parseRound)
				.mapToInt(Round::evaluate)
				.sum();
		assertEquals(13924, score);
	}
	
	@Test
	public void test2() {
		Part1Parser parser = new Part2Parser();
		List<String> lines = get("test1.txt");
		int score = lines.stream()
				.map(parser::parseRound)
				.mapToInt(Round::evaluate)
				.sum();
		assertEquals(12, score);
	}
	
	@Test
	public void day2_2() {
		Part1Parser parser = new Part2Parser();
		List<String> lines = get("input.txt");
		int score = lines.stream()
				.map(parser::parseRound)
				.mapToInt(Round::evaluate)
				.sum();
		assertEquals(13448, score);
	}
	

	static class Round {

		final Move opponent;
		final Move mine;

		public Round(Move opponent, Move mine) {
			this.opponent = opponent;
			this.mine = mine;
		}

		public int evaluate() {
			final int result;
			if (opponent == mine) {
				result = 3;
			} else if (mine.beats(opponent)) {
				result = 6;
			} else {
				result = 0;
			}

			return result + mine.scoreValue;
		}
	}

	public enum Move {

		ROCK(1), PAPER(2), SCISSORS(3);

		public final int scoreValue;

		private Move(int scoreValue) {
			this.scoreValue = scoreValue;
		}
		
		public boolean beats(Move opponent) {
			switch (opponent) {
				case ROCK:
					return this == PAPER;
				case PAPER:
					return this == SCISSORS;
				case SCISSORS:
					return this == ROCK;
			}
			throw new IllegalStateException();
		}
	}
}
