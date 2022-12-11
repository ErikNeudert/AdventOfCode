package aoc2022.day2;

import aoc2022.day2.RockPaperScissorsTest.Move;
import aoc2022.day2.RockPaperScissorsTest.Round;

public class Part1Parser {

	public Round parseRound(String line) {
		String[] lineSplit = line.split(" ");
		String opponentPart = lineSplit[0];
		String minePart = lineSplit[1];
		Move opponent = parsePart1(opponentPart);
		Move mine = parsePart2(minePart, opponent);

		return new Round(opponent, mine);
	}

	/*
	 * @param opponent required for part2 
	 */
	protected Move parsePart2(String minePart, @SuppressWarnings("unused") Move opponent) {
		final Move mine;
		switch (minePart) {
			case "X":
				mine = Move.ROCK;
				break;
			case "Y":
				mine = Move.PAPER;
				break;
			case "Z":
				mine = Move.SCISSORS;
				break;
			default:
				throw new IllegalStateException();
		}
		return mine;
	}

	protected Move parsePart1(String opponentPart) {
		final Move opponent;
		switch (opponentPart) {
			case "A":
				opponent = Move.ROCK;
				break;
			case "B":
				opponent = Move.PAPER;
				break;
			case "C":
				opponent = Move.SCISSORS;
				break;
			default:
				throw new IllegalStateException();
		}
		return opponent;
	}
}
