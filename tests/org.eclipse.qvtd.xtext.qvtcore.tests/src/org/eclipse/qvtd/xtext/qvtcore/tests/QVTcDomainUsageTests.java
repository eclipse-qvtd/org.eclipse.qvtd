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
package org.eclipse.qvtd.xtext.qvtcore.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.analysis.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcEnvironmentFactory;

/**
 * Tests that demonstrate that the QVTcoreDomainUsageAnalysis analyzes everything.
 */
public class QVTcDomainUsageTests extends AbstractDomainUsageTests
{
	protected @NonNull MyQVT createQVT() {
		QVTcEnvironmentFactory myEnvironmentFactory = new QVTcEnvironmentFactory(getProjectMap(), null);
		return new MyQVT(myEnvironmentFactory, new QVTcoreDomainUsageAnalysis(myEnvironmentFactory));
	}

	@Override
	protected void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTcTestUtil.doQVTcoreSetup();
		super.setUp();
	}

	public void testQVTrDomainUsage_uml2rdbms_qvtu() throws Exception {
		MyQVT myQVT = createQVT();
		URI transformURI = getProjectFileURI("models/uml2rdbms.qvtu.qvtc");
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		myQVT.checkAnalysis(asTransformation, false);
		myQVT.dispose();
	}
}
