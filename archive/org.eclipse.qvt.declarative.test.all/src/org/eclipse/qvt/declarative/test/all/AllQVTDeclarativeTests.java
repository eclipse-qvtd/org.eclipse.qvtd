package org.eclipse.qvt.declarative.test.all;


import junit.framework.Test;
import junit.framework.TestSuite;

public class AllQVTDeclarativeTests
{
	public static void buildEditingSuite(TestSuite suite) {
		AllBaseTests.buildEditingSuite(suite);
		AllQVTCoreTests.buildEditingSuite(suite);
		AllQVTRelationTests.buildEditingSuite(suite);
	}

	public static void buildSuite(TestSuite suite) {
		AllBaseTests.buildSuite(suite);
		AllQVTCoreTests.buildSuite(suite);
		AllQVTRelationTests.buildSuite(suite);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All QVT Declarative Tests");
		buildSuite(suite);
		return suite;
	}
}
