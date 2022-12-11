package aoc2022;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputUtil {

	public static List<String> get(Class<?> clazz, String string) {
		try {
			return Files.readAllLines(Paths.get(clazz.getResource(string).toURI()));
		} catch (IOException | URISyntaxException e) {
			throw new IllegalStateException(e);
		}
	}

	protected List<String> get(String string) {
		return get(getClass(), string);
	}

}
