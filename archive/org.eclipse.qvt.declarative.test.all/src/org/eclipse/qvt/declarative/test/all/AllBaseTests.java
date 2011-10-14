package org.eclipse.qvt.declarative.test.all;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.qvt.declarative.test.editor.EcoreUpdaterTests;
import org.eclipse.qvt.declarative.test.emof.emof.EMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.EssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.mapping.EMOFMapperTest;
import org.eclipse.qvt.declarative.test.emof.mapping.EcoreMapperTest;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreComparatorTests;

public class AllBaseTests
{
	public static void buildEditingSuite(TestSuite suite) {
	}

	public static void buildSuite(TestSuite suite) {
		suite.addTestSuite(EcoreComparatorTests.class);
		suite.addTestSuite(EcoreUpdaterTests.class);
		suite.addTestSuite(EMOFMapperTest.class);
		suite.addTestSuite(EcoreMapperTest.class);
		suite.addTestSuite(EMOFConsistencyTest.class);
		suite.addTestSuite(EssentialOCLConsistencyTest.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All Base Tests");
		buildSuite(suite);
		return suite;
	}
}
