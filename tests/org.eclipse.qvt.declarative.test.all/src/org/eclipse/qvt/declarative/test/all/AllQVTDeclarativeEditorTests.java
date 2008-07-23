package org.eclipse.qvt.declarative.test.all;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllQVTDeclarativeEditorTests
{
	public static void buildSuite(TestSuite suite) {
		AllQVTDeclarativeTests.buildEditingSuite(suite);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All QVT Declarative Editor Tests");
		buildSuite(suite);
		return suite;
	}
}
