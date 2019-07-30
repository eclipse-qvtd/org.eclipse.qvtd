/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.QVTrelationDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtcore.tests.AbstractDomainUsageTests;

/**
 * Tests that demonstrate that the QVTrelationDomainUsageAnalysis analyzes everything.
 */
public class QVTrDomainUsageTests extends AbstractDomainUsageTests
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTrelation.newInstance(getTestProjectManager(), null);
	}

	protected @NonNull MyQVT createQVT() throws Exception {
		QVTrEnvironmentFactory myEnvironmentFactory = new QVTrEnvironmentFactory(getTestProjectManager(), null);
		return new MyQVT(myEnvironmentFactory);
	}

	protected void doTest(@NonNull MyQVT myQVT, @NonNull URI transformURI) throws Exception {
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		QVTrelationDomainUsageAnalysis domainUsageAnalysis = new QVTrelationDomainUsageAnalysis(myQVT.getEnvironmentFactory(), asTransformation);
		myQVT.checkAnalysis(asTransformation, domainUsageAnalysis, false);
	}

	@Override
	protected void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		XtextCompilerUtil.doQVTrelationSetup();
		super.setUp();
	}

	public void testQVTrDomainUsage_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		MyQVT myQVT = createQVT();
		URI transformURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.hstm2fstm/model/HierarchicalStateMachine2FlatStateMachine.qvtr", true);
		doTest(myQVT, transformURI);
		myQVT.dispose();
	}

	public void testQVTrDomainUsage_Keys() throws Exception {
		MyQVT myQVT = createQVT();
		URI transformURI = getModelsURI("misc/Keys.qvtr");
		doTest(myQVT, transformURI);
		myQVT.dispose();
	}

	public void testQVTrDomainUsage_Rel2Core() throws Exception {
		MyQVT myQVT = createQVT();
		URI transformURI = getModelsURI("rel2core/RelToCore.qvtr");
		doTest(myQVT, transformURI);
		myQVT.dispose();
	}
}
