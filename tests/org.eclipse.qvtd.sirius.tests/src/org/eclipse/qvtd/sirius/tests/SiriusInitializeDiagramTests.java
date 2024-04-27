/*******************************************************************************
 * Copyright (c) 2016, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.sirius.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestUIUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.sirius.InitializeDiagramJob;
import org.eclipse.qvtd.umlx.design.UMLXDesignActivator;
import org.eclipse.qvtd.xtext.qvtbase.tests.XtextTestCase;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.junit.Test;

/**
 * Tests that verify the Initialize Diagram menu action.
 */
public class SiriusInitializeDiagramTests extends XtextTestCase
{
/*	public void testComponentization() {
		FileExtensionRegistry.DEBUG_COMPONENTIZATION_ANALYSIS = true;
		FileExtensionRegistry.getInstance();
	} */

	@Test
	public void testInitializeDiagram_representation() throws Exception {
	//	Registry registry = EPackage.Registry.INSTANCE;
	//	registry.remove(HSV2HSLPackage.eNS_URI);
	//	registry.remove(HSVTreePackage.eNS_URI);
	//	registry.remove(HSLTreePackage.eNS_URI);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		TestFile txFile = getTestProject().copyFiles(getTestProjectManager(), null, getModelsURI("forward2reverse"), "Forward2Reverse.umlx", "DoublyLinkedList.ecore");
	//	TestFile inFile = getTestProject().copyFiles(getTestProjectManager(), getTestProject().getOutputFolder("samples"), getModelsURI("hsv2hsl/samples"), "SolarizedHSV.xmi");
	//	URI outURI = getTestURI("SolarizedHSL_Interpreted.xmi");
	//	TestFile refFile = getTestProject().copyFiles(getTestProjectManager(), getTestProject().getOutputFolder("samples"), getModelsURI("hsv2hsl/samples"), "SolarizedHSL_expected.xmi");
	//	MyQVT myQVT = createQVT("HSV2HSL", txFile.getURI());
		//		myQVT.loadEcoreFile(getTestFileURI("HSV2HSL.ecore"), HSV2HSLPackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getTestFileURI("HSVTree.ecore"), HSVTreePackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getTestFileURI("HSLTree.ecore"), HSLTreePackage.eINSTANCE);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		@NonNull URI sessionURI = txFile.getFileURI().trimSegments(1).appendSegment(ModelingProject.DEFAULT_REPRESENTATIONS_FILE_NAME);

		ViewpointRegistry viewpointRegistry = ViewpointRegistry.getInstance();
	//	Set<Viewpoint> viewpoints = viewpointRegistry.getViewpoints();
		Viewpoint viewpoint = viewpointRegistry.getViewpoint(UMLXDesignActivator.VIEWPOINT_URI);
		assertNotNull("No Viewpoint for " + UMLXDesignActivator.VIEWPOINT_URI, viewpoint);
		@NonNull RepresentationDescription representationDescription = null;
		for (RepresentationDescription rd : viewpoint.getOwnedRepresentations()) {
			if (UMLXDesignActivator.TRANSFORMATION_REPRESENTATION_DESCRIPTION_ID.equals(rd.getName())) {
				representationDescription = rd;
				break;
			}
		}
		assertNotNull("No RepresentationDescription for " + UMLXDesignActivator.TRANSFORMATION_REPRESENTATION_DESCRIPTION_ID, representationDescription);
		@NonNull URI representationFileURI = sessionURI;
		@NonNull String representationDiagramName = "NewTxDiagram";
		@NonNull List<@NonNull URI> modelObjectURIs = new ArrayList<>();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(txFile.getFileURI(), true);
		for (EObject eObject : resource.getContents()) {
			modelObjectURIs.add(EcoreUtil.getURI(eObject));		// XXX a TxDiagram
		}
		Job job = InitializeDiagramJob.scheduleNewWhenPossible(sessionURI, representationDescription, representationFileURI, representationDiagramName, modelObjectURIs);
		assertNotNull("No InitializeDiagramJob", job);
	/*	try {
			ImperativeTransformation iTransformation = myQVT.compileTransformation("hsl");
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("hsv", inFile.getURI());
			myQVT.executeTransformation();
			myQVT.addOutputURI("hsl", outURI);
			myQVT.saveModels(null);
			myQVT.checkOutput(outURI, refFile.getURI(), HSV2HSLNormalizer.INSTANCE);	// FIXME Bug 490497 remove normalizer
		}
		finally {
			myQVT.dispose();
		} */
		waitForJob(job);
		getClass();
	}

	public static void waitForJob(@NonNull Job job) throws InterruptedException {
		int i0 = 0;
		while ((job.getState() == Job.NONE) && (i0++ < 10)) {
			System.out.println(Thread.currentThread().getName() + " : " + job.getState() + " waiting for !NONE " + NameUtil.debugSimpleName(job));
			TestUIUtil.flushEvents();
			Thread.sleep(100);
		}
		int i1 = 0;
		while ((job.getState() == Job.WAITING) && (i1++ < 10)) {
			System.out.println(Thread.currentThread().getName() + " : " + job.getState() + " waiting for !WAITING " + NameUtil.debugSimpleName(job));
			TestUIUtil.flushEvents();
			Thread.sleep(100);
		}
		int i2 = 0;
		while ((job.getState() == Job.RUNNING) && (i2++ < 1000)) {
			System.out.println(Thread.currentThread().getName() + " : " + job.getState() + " waiting for !RUNNING " + NameUtil.debugSimpleName(job));
			TestUIUtil.flushEvents();
			Thread.sleep(100);
		}
	}
}
