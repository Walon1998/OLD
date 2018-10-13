import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class BienenGradingTest {

	@Test
	public void testFirstPart() throws IOException {
		List<String> input = Arrays.asList("Mayor uk 1200 1400", "Schmid ch 2800 10", "Mastoras gr 10 30",
				"Meyer de 400 300", "Meiero de 200 805", "Mueller ch 10 10", "Maier uk 15 5", "Tschang cn 1600 1200");
		String expectedPattern = "(.|\n)*schmid(.|\n)*2810(.|\n)*";
		Assert.assertTrue(this.runAnalyze(input).toLowerCase().matches(expectedPattern));

		input = Arrays.asList("Mayor uk 1200 1500", "Schmittchen ch 2990 10", "Meyer de 400 300", "Thompson de 100 900",
				"Maier uk 35 15");
		expectedPattern = "(.|\n)*schmittchen(.|\n)*3000(.|\n)*";
		Assert.assertTrue(this.runAnalyze(input).toLowerCase().matches(expectedPattern));
	}

	@Test
	public void testSecondPart() throws IOException {
		List<String> input = Arrays.asList("Mayor uk 1200 1400", "Schmid ch 2800 10", "Mastoras gr 10 30",
				"Meyer de 400 300", "Meiero de 200 805", "Mueller ch 10 10", "Maier uk 15 5", "Tschang cn 1600 1200");
		String expectedPattern = "(.|\n)*meiero(.|\n)*8[01](.|\n)*";
		Assert.assertTrue(this.runAnalyze(input).toLowerCase().matches(expectedPattern));

		input = Arrays.asList("Mayor uk 1200 1500", "Schmittchen ch 2990 10", "Meyer de 400 300", "Thompson de 100 901",
				"Maier uk 35 15");
		expectedPattern = "(.|\n)*thompson(.|\n)*9[01](.|\n)*";
		Assert.assertTrue(this.runAnalyze(input).toLowerCase().matches(expectedPattern));
	}

	@Test
	public void testThirdPart() throws IOException {
		List<String> input = Arrays.asList("Mayor uk 1200 1400", "Schmid ch 2800 10", "Mastoras gr 10 30",
				"Meyer de 400 300", "Meiero de 200 805", "Mueller ch 10 10", "Maier uk 15 5", "Tschang cn 1600 1200");
		String expectedPattern = "(.|\n)*uk(.|\n)*1405(.|\n)*";
		Assert.assertTrue(this.runAnalyze(input).toLowerCase().matches(expectedPattern));

		input = Arrays.asList("Mayor uk 1200 1500", "Schmittchen ch 2990 10", "Meyer de 400 300", "Thompson de 100 900",
				"Maier uk 35 15");
		expectedPattern = "(.|\n)*uk(.|\n)*1515(.|\n)*";
		Assert.assertTrue(this.runAnalyze(input).toLowerCase().matches(expectedPattern));
	}

	@Test
	public void testAllParts() throws IOException {
		List<String> input = Arrays.asList("Mayor uk 1200 1400", "Schmid ch 2800 10", "Mastoras gr 10 30",
				"Meyer de 400 300", "Meiero de 200 805", "Mueller ch 10 10", "Maier uk 15 5", "Tschang cn 1600 1200");
		List<String> patterns = Arrays.asList("schmid", "2810", "meiero", "8[01]", "uk", "1405");

		String output = this.runAnalyze(input);
		for (final String pattern : patterns) {
			Assert.assertTrue(output.toLowerCase().matches("(.|\n)*" + pattern + "(.|\n)*"));
		}

		input = Arrays.asList("Mayor uk 1200 1500", "Schmittchen ch 2990 10", "Meyer de 400 300", "Thompson de 100 901",
				"Maier uk 35 15");
		patterns = Arrays.asList("schmittchen", "3000", "thompson", "9[01]", "uk", "1515");

		output = this.runAnalyze(input);
		for (final String pattern : patterns) {
			Assert.assertTrue(output.toLowerCase().matches("(.|\n)*" + pattern + "(.|\n)*"));
		}
	}

	@Test
	public void testSingleEntry() throws IOException {
		final List<String> input = Arrays.asList("Wayne us 1000 2000");
		final List<String> patterns = Arrays.asList("wayne", "3000", /* "wayne", */ "6[67]", "us", "2000");

		final String output = this.runAnalyze(input);
		for (final String pattern : patterns) {
			Assert.assertTrue(output.toLowerCase().matches("(.|\n)*" + pattern + "(.|\n)*"));
		}
	}

	@Test
	public void testMean() throws IOException {
		List<String> input = Arrays.asList("Wayne us 10000 20000", "Bruce us 1000 2001");
		List<String> patterns = Arrays.asList("bruce", "30000", "6[67]", "us", "22001");

		String output = this.runAnalyze(input);
		for (final String pattern : patterns) {
			Assert.assertTrue(output.toLowerCase().matches("(.|\n)*" + pattern + "(.|\n)*"));
		}

		input = Arrays.asList("Bruce us 1000 2001", "Wayne us 10000 20000");
		patterns = Arrays.asList("bruce", "30000", "6[67]", "us", "22001");

		output = this.runAnalyze(input);
		for (final String pattern : patterns) {
			Assert.assertTrue(output.toLowerCase().matches("(.|\n)*" + pattern + "(.|\n)*"));
		}
	}

	@Test
	public void testCorrectFormat() throws IOException {
		List<String> input = Arrays.asList("Mayor uk 1200 1400", "Schmid ch 2800 10", "Mastoras gr 10 30",
				"Meyer de 400 300", "Meiero de 200 805", "Mueller ch 10 10", "Maier uk 15 5", "Tschang cn 1600 1200");
		String expectedPattern = "Schmid 2810\n" + "Meiero 8[01](\\.\\d+)?\n" + "uk 1405";
		Assert.assertTrue(this.runAnalyze(input).matches(expectedPattern));

		input = Arrays.asList("Mayor uk 1200 1500", "Schmittchen ch 2990 10", "Meyer de 400 300", "Thompson de 100 901",
				"Maier uk 35 15");
		expectedPattern = "Schmittchen 3000\n" + "Thompson 9[01](\\.\\d+)?\n" + "uk 1515";
		Assert.assertTrue(this.runAnalyze(input).matches(expectedPattern));
	}

	@Test
	public void testCorrectRounding() throws IOException {
		List<String> input = Arrays.asList("Mayor uk 1200 1400", "Schmid ch 2800 10", "Mastoras gr 10 30",
				"Meyer de 400 300", "Meiero de 200 805", "Mueller ch 10 10", "Maier uk 15 5", "Tschang cn 1600 1200");
		String expectedOutput = "Schmid 2810\n" + "Meiero 80\n" + "uk 1405";

		Assert.assertEquals(expectedOutput, this.runAnalyze(input));

		input = Arrays.asList("Mayor uk 1200 1500", "Schmittchen ch 2990 10", "Meyer de 400 300", "Thompson de 100 901",
				"Maier uk 35 15");
		expectedOutput = "Schmittchen 3000\n" + "Thompson 90\n" + "uk 1515";
		Assert.assertEquals(expectedOutput, this.runAnalyze(input));
	}

	private String runAnalyze(final List<String> input) throws IOException {
		final Path inputFile = Files.createTempFile("bienen-in", ".txt");
		final Path outputFile = Files.createTempFile("bienen-out", ".txt");
		try {
			Files.write(inputFile, input);
			Bienen.analyze(inputFile.toFile(), outputFile.toFile());
			return this.normalize(Files.readAllLines(outputFile));
		} finally {
			inputFile.toFile().deleteOnExit();
			outputFile.toFile().deleteOnExit();
		}
	}

	private String normalize(final List<String> output) {
		return output.stream().map(String::trim).filter(l -> !l.isEmpty()).map(l -> l.replaceAll("%$", ""))
				.collect(Collectors.joining("\n"));
	}
}