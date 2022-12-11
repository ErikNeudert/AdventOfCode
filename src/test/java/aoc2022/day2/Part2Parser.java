package aoc2022.day2;

import aoc2022.day2.RockPaperScissorsTest.Move;

public class Part2Parser extends Part1Parser {

	@Override
	protected Move parsePart2(String targetResult, Move opponent) {
		switch (targetResult) {
			case "X":
				//i lose
				switch (opponent) {
					case ROCK:
						return Move.SCISSORS;
					case PAPER:
						return Move.ROCK;
					case SCISSORS:
						return Move.PAPER;
				}
				break;
			case "Y":
				//draw
				return opponent;
			case "Z":
				//win
				switch (opponent) {
					case ROCK:
						return Move.PAPER;
					case PAPER:
						return Move.SCISSORS;
					case SCISSORS:
						return Move.ROCK;
				}
				break;
			default:
				throw new IllegalStateException();
		}
		throw new IllegalStateException();
	}
}
