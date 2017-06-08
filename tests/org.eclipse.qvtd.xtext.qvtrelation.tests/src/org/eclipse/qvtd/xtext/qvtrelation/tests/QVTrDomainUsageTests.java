/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.QVTrelationDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtcore.tests.AbstractDomainUsageTests;

/**
 * Tests that demonstrate that the QVTrelationDomainUsageAnalysis analyzes everything.
 */
public class QVTrDomainUsageTests extends AbstractDomainUsageTests
{
	protected @NonNull MyQVT createQVT() {
		QVTrEnvironmentFactory myEnvironmentFactory = new QVTrEnvironmentFactory(getProjectMap(), null);
		return new MyQVT(myEnvironmentFactory, new QVTrelationDomainUsageAnalysis(myEnvironmentFactory));
	}

	@Override
	protected void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTrTestUtil.doQVTrelationSetup();
		super.setUp();
	}

	public void testQVTrDomainUsage_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		MyQVT myQVT = createQVT();
		URI transformURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.hstm2fstm/bin/org/eclipse/qvtd/examples/qvtrelation/hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr", true);
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	}

	public void testQVTrDomainUsage_Keys() throws Exception {
		MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("models/Keys.qvtr");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	}

	public void testQVTrDomainUsage_Rel2Core() throws Exception {
		MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("rel2core/RelToCore.qvtr");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	}
}
