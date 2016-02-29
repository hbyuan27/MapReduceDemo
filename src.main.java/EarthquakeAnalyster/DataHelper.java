package EarthquakeAnalyster;

import java.io.IOException;

import com.opencsv.CSVParser;

public class DataHelper {
	public static String[] parseLine(String input) {
		CSVParser parser = new CSVParser();
		String[] result = null;
		try {
			result = parser.parseLine(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String convertDateTime(String input) {
		return input.substring(0, 10);
	}

	public static String convertLocation(String input) {
		return input.substring(input.indexOf(",") + 2);
	}
}
