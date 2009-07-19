package org.eclipse.qvt.declarative.test.all;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.qvt.declarative.test.editor.qvtrelation.QVTrBuilderTests;
import org.eclipse.qvt.declarative.test.editor.qvtrelation.QVTrEditorTests;
import org.eclipse.qvt.declarative.test.editor.qvtrelation.QVTrResourceTests;
import org.eclipse.qvt.declarative.test.emof.qvtbase.QVTBaseConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvtbase.QVTBaseValidationTest;
import org.eclipse.qvt.declarative.test.emof.qvtrelation.QVTRelationConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvtrelation.QVTRelationMapperTest;
import org.eclipse.qvt.declarative.test.emof.qvtrelation.QVTRelationValidationTest;
import org.eclipse.qvt.declarative.test.emof.qvttemplate.QVTTemplateConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvttemplate.QVTTemplateValidationTest;
import org.eclipse.qvt.declarative.test.parser.qvtrelation.QVTrParseTests;
import org.eclipse.qvt.declarative.test.parser.qvtrelation.QVTrUnparseTests;

public class AllQVTRelationTests
{
	public static void buildEditingSuite(TestSuite suite) {
		suite.addTestSuite(QVTrBuilderTests.class);
		suite.addTestSuite(QVTrEditorTests.class);
// FIXME		suite.addTestSuite(QVTrMultiEditorTests.class);
		suite.addTestSuite(QVTrResourceTests.class);
	}

	public static void buildSuite(TestSuite suite) {
		suite.addTestSuite(QVTBaseConsistencyTest.class);
		suite.addTestSuite(QVTBaseValidationTest.class);
		suite.addTestSuite(QVTTemplateConsistencyTest.class);
		suite.addTestSuite(QVTTemplateValidationTest.class);
		suite.addTestSuite(QVTRelationConsistencyTest.class);
		suite.addTestSuite(QVTRelationValidationTest.class);
		suite.addTestSuite(QVTRelationMapperTest.class);
		suite.addTestSuite(QVTrParseTests.class);
		suite.addTestSuite(QVTrUnparseTests.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All QVT Relation Tests");
		buildSuite(suite);
		return suite;
	}
}
