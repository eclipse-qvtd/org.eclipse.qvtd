/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.tests;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.OCLThread.EnvironmentThreadFactory;
import org.eclipse.ocl.pivot.utilities.OCLThread.Resumable;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcore;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT.QVTcTestThread;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Tests that check that an Ecore model can be serialized to OCLinEcore.
 */
public class QVTcSerializeTests extends LoadTestCase
{
	public @NonNull Resumable<@NonNull Resource>  doLoad_Concrete(@NonNull URI inputURI, @NonNull URI pivotURI, @NonNull String @Nullable [] messages, StatusCodes.@Nullable Severity severity) throws Exception {
		EnvironmentThreadFactory environmentThreadFactory = new EnvironmentThreadFactory()
		{
			@Override
			public @NonNull QVTcore createEnvironment() {
				ProjectManager projectManager = getTestProjectManager();
				QVTcore ocl = QVTcore.newInstance(projectManager, null);
				if (severity != null) {
					EnvironmentFactoryInternal environmentFactory = ocl.getEnvironmentFactory();
					environmentFactory.setSafeNavigationValidationSeverity(severity);
				}
				return ocl;
			}
		};
		return doLoad_Concrete(environmentThreadFactory, inputURI, pivotURI, messages, severity);
	}

	protected void doSerializeRoundTripFromAS(@NonNull URI pivotURI) throws Exception {
		doSerializeRoundTripFromAS(pivotURI, getURIWithExtension(pivotURI, "ref.qvtcas"));
	}
	protected void doSerializeRoundTripFromAS(@NonNull URI pivotURI, @NonNull URI referenceURI) throws Exception {
		URI serializedInputURI = getTestURIWithExtension(pivotURI, "serialized.qvtc");
		URI serializedPivotURI = getTestURIWithExtension(pivotURI, "serialized.qvtcas");
		ProjectManager projectManager = getTestProjectManager();
		QVTcore ocl1 = QVTcore.newInstance(projectManager);
		//	QVTcore ocl2 = QVTcore.newInstance(projectManager);
		Resource asResource1 = ocl1.getMetamodelManager().getASResourceSet().getResource(pivotURI, true);
		doSerialize(pivotURI, serializedInputURI, referenceURI, null, true, true, null);
		Resumable<@NonNull Resource> loadThread = doLoad_Concrete(serializedInputURI, serializedPivotURI, NO_MESSAGES, null);
		Resource asResource3 = loadThread.getResult();
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		assertSameModel(asResource1, asResource3);
		ocl1.dispose();
		loadThread.syncResume();
	}

	protected void doSerializeRoundTripFromCS(@NonNull URI inputURI) throws Exception {
		doSerializeRoundTripFromCS(inputURI, getURIWithExtension(inputURI, "ref.qvtcas"));
	}
	protected void doSerializeRoundTripFromCS(@NonNull URI inputURI, @NonNull URI referenceURI) throws Exception {
		URI pivotURI = getTestURIWithExtension(inputURI, QVTcoreUtil.QVTCAS_FILE_EXTENSION);
		URI serializedInputURI = getTestURIWithExtension(inputURI, "serialized.qvtc");
		URI serializedPivotURI = getTestURIWithExtension(inputURI, "serialized.qvtcas");
		//	ProjectManager projectManager = getTestProjectManager();
		//	QVTcore ocl1 = QVTcore.newInstance(projectManager);
		Resumable<@NonNull Resource> loadThread1 = doLoad_Concrete(inputURI, pivotURI, NO_MESSAGES, null);
		Resource asResource1 = loadThread1.getResult();
		//	ocl1.deactivate();
		doSerialize(pivotURI, serializedInputURI, referenceURI, null, true, true, null);
		//	QVTcore ocl2 = QVTcore.newInstance(projectManager);
		Resumable<@NonNull Resource> loadThread3 = doLoad_Concrete(serializedInputURI, serializedPivotURI, NO_MESSAGES, null);
		Resource asResource3 = loadThread3.getResult();
		((Model)asResource3.getContents().get(0)).setExternalURI(((Model)asResource1.getContents().get(0)).getExternalURI());
		TestsXMLUtil.resetTransients(asResource1);
		TestsXMLUtil.resetTransients(asResource3);
		assertSameModel(asResource1, asResource3);
		loadThread1.syncResume();
		loadThread3.syncResume();
	}

	public void doSerialize(@NonNull URI inputURI, @NonNull URI serializedInputURI, @NonNull URI referenceURI, @Nullable Map<String, Object> options, boolean doCompare, boolean validateSaved, @NonNull String @Nullable [] messages) throws Exception {
		QVTcTestThread<@NonNull Resource> serializeThread = new QVTcTestThread<@NonNull Resource>("QVTc-Serialize")
		{
			@Override
			protected QVTcore createOCL() throws ParserException {
				return QVTcore.newInstance(getTestProjectManager(), null);
			}

			@Override
			protected @NonNull Resource runWithModel(@NonNull ResourceSet resourceSet) throws Exception {
				//
				//	Load QVTiAS
				//
				ASResource asResource = AbstractTestQVT.loadQVTiAS(getOCL(), inputURI);
				assertNoResourceErrors("Normalisation failed", asResource);
				//			assertNoValidationErrors("Normalisation invalid", asResource);
				assertValidationDiagnostics("Pivot validation errors", asResource, messages);
				//
				//	Pivot to CS
				//
				//	ResourceSet resourceSet = ocl.getResourceSet();
				XtextResource xtextResource = AbstractTestQVT.as2cs(getOCL(), resourceSet, asResource, serializedInputURI, QVTcoreCSPackage.eCONTENT_TYPE);
				resourceSet.getResources().clear();
				return xtextResource;
			}
		};
		serializeThread.syncExec();
	}

	@Override
	public void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		XtextCompilerUtil.doQVTcoreSetup();
		super.setUp();
	}

	public void testQVTcSerialize_Class2RDBMS() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("Class2RDBMS/Class2RDBMS.qvtc"));
	}

	public void testQVTcSerialize_HSV2HSL() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("hsv2hsl/HSV2HSL.qvtc"));
	}

	public void testQVTcSerialize_platformResource_BaseCS2AS() throws Exception {
		doSerializeRoundTripFromCS(getModelsURI("platformResource/org.eclipse.ocl.xtext.base/model/BaseCS2AS.qvtm.qvtc"));
	}

	//	public void testQVTcSerialize_platformResource_Mini() throws Exception {
	//		doSerializeRoundTripFromCS("platformResource/org.eclipse.ocl.xtext.base/model/MiniBaseCS2AS.qvtm");
	//	}

	/* FIXME get better source
	public void testQVTcSerialize_Seq2Stm() throws Exception {
		doSerializeRoundTripFromAS("Seq2Stm/SeqToStm");
	} */
}
