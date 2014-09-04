package de.mpii.mph.cli;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import de.mpii.mph.SpotMinimalPerfectHash;

/**
 * Main App!
 * 
 */
public class GenerateMinimalPerfectHashCLI {
	public static void main(String[] args) throws ParseException, IOException {
		Options options = new Options();
		options.addOption("i", "input", true,
				"UTF-8 file with one 'name<TAB>id' pair per line");
		options.addOption("o", "output", true, "mph-dir");

		// options.addOption("t", "threshold", true,
		// "Threshold to use for truncating tokens to prefix");
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse(options, args);
		InputStream spotStream = Files.newInputStream(Paths.get(cmd.getOptionValue("i")));
		File outputDir = new File(cmd.getOptionValue("o"));
		if (!outputDir.exists()) {
			outputDir.mkdir();
		}
		File mphPath = new File(outputDir, SpotMinimalPerfectHash.STDNAME);
		File outputPath = new File(outputDir,
				SpotMinimalPerfectHash.STDSPOTNAME);

		System.out.println("mphPath = " + mphPath);
		System.out.println("outputPath = " + outputPath);

//		SpotMinimalPerfectHash mph = new SpotMinimalPerfectHash()
//				.generateHash(new SpotIterable(spotStream));
//		mph.dumpSpotsAndHash(new SpotIterable(spotStream), outputPath);
//		mph.dump(mphPath);

	}
	
}
