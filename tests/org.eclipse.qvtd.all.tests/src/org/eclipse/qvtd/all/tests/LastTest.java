package org.eclipse.qvtd.all.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.calling.AbstractCallingConvention;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.junit.Test;

public class LastTest extends LoadTestCase
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTbase.newInstance(getTestProjectManager(), null);
	}

	// Workaround for non-functional @AfterClass
	@Test
	public void testLast() {
		AbstractCallingConvention.printAllUsages();
	}
}
