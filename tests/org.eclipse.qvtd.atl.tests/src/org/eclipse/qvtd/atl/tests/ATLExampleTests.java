/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.atl.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests that ATL-based examples work.
 */
public class ATLExampleTests extends TestCase
{
	protected void doATLExampleTest_CG(@NonNull String testName) throws Exception {
		ATLTestQVT myQVT = new ATLTestQVT(testName.toLowerCase());
		try {
			Class<?> txClass = Class.forName("org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr");		// FIXME Use direct reference once generation works redliably
			myQVT.createGeneratedExecutor((Class<? extends Transformer>)txClass);
			myQVT.loadInput("atl", testName + ".atl");
			myQVT.executeTransformation();
			myQVT.saveOutput("qvtr", testName + "_CG.qvtras", testName + "_expected.qvtras");
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
	public void testATLExample_Families2Persons_CG() throws Exception {
		AbstractTransformer.EXCEPTIONS.setState(true);
		AbstractTransformer.INVOCATIONS.setState(true);
		doATLExampleTest_CG("Families2Persons");
	}
}
