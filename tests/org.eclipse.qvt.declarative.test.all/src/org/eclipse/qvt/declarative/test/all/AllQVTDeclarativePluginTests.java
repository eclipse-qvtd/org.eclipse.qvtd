package org.eclipse.qvt.declarative.test.all;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllQVTDeclarativePluginTests
{
	public static void buildSuite(TestSuite suite) {
		AllQVTDeclarativeTests.buildSuite(suite);
		AllQVTDeclarativeTests.buildEditingSuite(suite);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All QVT Declarative Plugin Tests");
		buildSuite(suite);
		return suite;
	}
}
