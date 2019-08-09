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
package org.eclipse.qvtd.xtext.qvtcore.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.qvtd.compiler.internal.usage.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcore;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;

/**
 * Tests that demonstrate that the QVTcoreDomainUsageAnalysis analyzes everything.
 */
public class QVTcDomainUsageTests extends AbstractDomainUsageTests
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTcore.newInstance(getTestProjectManager(), null);
	}

	protected @NonNull MyQVT createQVT() throws Exception {
		QVTcEnvironmentFactory myEnvironmentFactory = new QVTcEnvironmentFactory(getTestProjectManager(), null);
		return new MyQVT(myEnvironmentFactory);
	}

	protected void doTest(@NonNull MyQVT myQVT, @NonNull URI transformURI) throws Exception {
		Transformation asTransformation = loadTransformation(myQVT, transformURI);
		QVTcoreDomainUsageAnalysis domainUsageAnalysis = new QVTcoreDomainUsageAnalysis(myQVT.getEnvironmentFactory(), asTransformation);
		myQVT.checkAnalysis(asTransformation, domainUsageAnalysis, false);
	}

	@Override
	protected void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		XtextCompilerUtil.doQVTcoreSetup();
		super.setUp();
	}

	public void testQVTcDomainUsage_uml2rdbms_qvtu() throws Exception {
		MyQVT myQVT = createQVT();
		URI transformURI = getModelsURI("misc/uml2rdbms.qvtu.qvtc");
		doTest(myQVT, transformURI);
		myQVT.dispose();
	}
}
