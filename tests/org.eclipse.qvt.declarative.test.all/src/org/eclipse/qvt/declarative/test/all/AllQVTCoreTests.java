package org.eclipse.qvt.declarative.test.all;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.qvt.declarative.test.editor.qvtcore.QVTcResourceTests;
import org.eclipse.qvt.declarative.test.emof.qvtcore.QVTCoreConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvtcore.QVTCoreMapperTest;
import org.eclipse.qvt.declarative.test.parser.qvtcore.AnalyzerErrorTests;
import org.eclipse.qvt.declarative.test.parser.qvtcore.ParserErrorTests;
import org.eclipse.qvt.declarative.test.parser.qvtcore.QVTcParseTests;
import org.eclipse.qvt.declarative.test.parser.qvtcore.QVTcUnparseTests;

public class AllQVTCoreTests
{
	public static void buildEditingSuite(TestSuite suite) {
// FIXME		suite.addTestSuite(QVTcMultiEditorTests.class);
		suite.addTestSuite(QVTcResourceTests.class);
	}

	public static void buildSuite(TestSuite suite) {
		suite.addTestSuite(QVTCoreConsistencyTest.class);
		suite.addTestSuite(QVTCoreMapperTest.class);
		suite.addTestSuite(AnalyzerErrorTests.class);
//		suite.addTestSuite(LexerErrorTests.class);
		suite.addTestSuite(ParserErrorTests.class);
		suite.addTestSuite(QVTcParseTests.class);
		suite.addTestSuite(QVTcUnparseTests.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All QVT Core Tests");
		buildSuite(suite);
		return suite;
	}
}
