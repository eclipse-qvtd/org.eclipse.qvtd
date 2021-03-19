/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.utilities.OCLThread.EnvironmentThreadFactory;
import org.eclipse.ocl.pivot.utilities.OCLThread.Resumable;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTcLoadTests extends LoadTestCase
{
	public void doLoad_Concrete(@NonNull URI inputURI, @NonNull String @Nullable [] messages, StatusCodes.@Nullable Severity severity) throws Exception {
		EnvironmentThreadFactory environmentThreadFactory = new QVTcoreEnvironmentThreadFactory(getTestProjectManager(), severity);
		URI pivotURI = getTestURIWithExtension(inputURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		Resumable<@NonNull Resource> resumable = doLoad_Concrete(environmentThreadFactory, inputURI, pivotURI, messages, severity);
		resumable.syncResume();;
	}

	@Override
	protected void setUp() throws Exception {
		XtextCompilerUtil.doQVTcoreSetup();
		super.setUp();
	}

	public void testQVTcLoad_expressions_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/expressions.qvtc"), NO_MESSAGES, null);
	}

	public void testQVTcLoad_mini_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/mini.qvtc"), NO_MESSAGES, null);
	}

	public void testQVTcLoad_uml2rdbms_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/uml2rdbms.qvtc"), NO_MESSAGES, null);
	}

	public void testQVTcLoad_uml2rdbms_qvti_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/uml2rdbms.qvti.qvtc"), NO_MESSAGES, null);
	}

	public void testQVTcLoad_uml2rdbms_qvtu_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/uml2rdbms.qvtu.qvtc"), NO_MESSAGES, null);
	}

	public void testQVTcLoad_HSV2HLS_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("misc/HSV2HLS.qvtc"), NO_MESSAGES, StatusCodes.Severity.ERROR);
	}

	public void testQVTcLoad_HSV2HLS2_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("hsv2hsl/HSV2HSL.qvtc"), NO_MESSAGES, StatusCodes.Severity.ERROR);
	}

	public void testQVTcLoad_Class2RDBMS_qvtc() throws Exception {
		doLoad_Concrete(getModelsURI("Class2RDBMS/Class2RDBMS.qvtc"), NO_MESSAGES, null);
	}

	/*
	 * Check that e.g. the Sample Ecore Model Editor can open the transitive qvtcas reference.
	 */
	public void testQVTcLoad_HSV2HSL_qvtias() throws Exception {
		XtextCompilerUtil.doQVTimperativeSetup();
		// hsv2hsl/HSV2HSL.qvtias is copied from the testQVTcCompiler_HSVToHSL_CG results with ../xxpaths stripped
		// hsv2hsl/HSV2HSL.qvtm.qvtcas is copied from the testQVTcCompiler_HSVToHSL_CG results
		ResourceSet resourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(resourceSet);
		URI uri = getModelsURI("hsv2hsl/HSV2HSL.qvtias");
		Resource resource = resourceSet.getResource(uri, true);
		assert resource != null;
		assertNoResourceErrors("Load", resource);
		EcoreUtil.resolveAll(resource);
		assertNoUnresolvedProxies("Resolve", resource);;
		assertNoValidationErrors("Validate", resource);;
	}

	/*
	 * Check that e.g. the Sample Ecore Model Editor can open a qvtsas reference.
	 */
	public void testQVTcLoad_HSV2HSL_qvtsas() throws Exception {
		XtextCompilerUtil.doQVTimperativeSetup();
		XtextCompilerUtil.doQVTscheduleSetup();
		// hsv2hsl/HSV2HSL.qvtsas is copied from the testQVTcCompiler_HSVToHSL_CG results with ../xxpaths stripped
		ResourceSet resourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(resourceSet);
		URI uri = getModelsURI("hsv2hsl/HSV2HSL.qvtsas");
		Resource resource = resourceSet.getResource(uri, true);
		assert resource != null;
		assertNoResourceErrors("Load", resource);
		EcoreUtil.resolveAll(resource);
		assertNoUnresolvedProxies("Resolve", resource);;
		assertNoValidationErrors("Validate", resource);;
	}
}
