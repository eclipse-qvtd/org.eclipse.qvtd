package org.eclipse.qvt.declarative.test.emof.all;

import org.eclipse.qvt.declarative.test.emof.emof.EMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.EssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvtbase.QVTBaseConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvtcore.QVTCoreConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvtrelation.QVTRelationConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvttemplate.QVTTemplateConsistencyTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllQVTDeclarativeConsistencyTests
{
	public static void buildSuite(TestSuite suite) {
		suite.addTestSuite(EMOFConsistencyTest.class);
		suite.addTestSuite(EssentialOCLConsistencyTest.class);
		suite.addTestSuite(QVTBaseConsistencyTest.class);
		suite.addTestSuite(QVTCoreConsistencyTest.class);
		suite.addTestSuite(QVTTemplateConsistencyTest.class);
		suite.addTestSuite(QVTRelationConsistencyTest.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All QVT Declarative Consistency Tests");
		buildSuite(suite);
		return suite;
	}
}
