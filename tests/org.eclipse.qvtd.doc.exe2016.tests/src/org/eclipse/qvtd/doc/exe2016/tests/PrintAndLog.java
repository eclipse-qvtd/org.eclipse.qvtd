package org.eclipse.qvtd.doc.exe2016.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintAndLog
{
	public static int[] getTestSizes() {
		int[] testSizes = new int[38];
		testSizes[0] = 5000;
		for (int i = 1; i < testSizes.length; i++) {
			testSizes[i] = (int)Math.round(Math.pow(10.0, (i+5)/6.0));
		}
		return testSizes;
	}

	private PrintWriter writer;

	public PrintAndLog(String testName) throws IOException {
		String testSuiteName = System.getProperty("testSuiteName", null);
		//		assert testSuiteName != null;
		if (testSuiteName != null) {
			File file = new File("results/" + testSuiteName + ".csv");
			file.getParentFile().mkdirs();
			writer = new PrintWriter(new FileWriter(file));
		}
	}

	public void dispose() throws IOException {
		if (writer != null) {
			writer.close();
		}
	}

	public PrintStream printf(String format, Object ... args) {
		if (writer != null) {
			writer.printf(format, args);
			writer.flush();
		}
		return System.out.printf(format, args);
	}
}