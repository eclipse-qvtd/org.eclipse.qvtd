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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.model.QVTimperativeLibrary;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationToStringVisitor;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
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
			Resource atlResource = myQVT.loadInput("atl", testName + ".atl");
			assert atlResource != null;
			EList<@NonNull EObject> contents = atlResource.getContents();
			Resource atlXmiResource = atlResource.getResourceSet().createResource(atlResource.getURI().appendFileExtension("xmi"));
			atlXmiResource.getContents().addAll(contents);
			atlXmiResource.save(null);
			contents.addAll(atlXmiResource.getContents());
			try {
				Transformer executeTransformation = myQVT.executeTransformation();
				myQVT.saveOutput("qvtr", testName + "_CG.qvtras", testName + "_expected.qvtras");
			}
			catch (InvalidEvaluationException e) {
				myQVT.saveOutput("qvtr", testName + "_CG.qvtras", "");
				throw e;
			}
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
	public void testATLExample_Families2Persons_CG() throws Exception {
		AbstractTransformer.EXCEPTIONS.setState(true);
		AbstractTransformer.INVOCATIONS.setState(true);
		//		PivotStandaloneSetup.init();
		QVTimperativeLibrary.install();
		QVTrelationToStringVisitor.FACTORY.getClass();
		doATLExampleTest_CG("Families2Persons");
	}

	/*	@Test
	public void testATLExample_Families2PersonsMini_CG() throws Exception {
		AbstractTransformer.EXCEPTIONS.setState(true);
		AbstractTransformer.INVOCATIONS.setState(true);
		//		PivotStandaloneSetup.init();
		QVTimperativeLibrary.install();
		QVTrelationToStringVisitor.FACTORY.getClass();
		doATLExampleTest_CG("Families2PersonsMini");
	} */
}
