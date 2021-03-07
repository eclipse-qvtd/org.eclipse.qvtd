/*******************************************************************************
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.UnresolvedReferenceException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUIUtil;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.debug.launching.QVTrLaunchConstants;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.XtextTestCase;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTrDebuggerTests extends XtextTestCase
{
	protected ILaunchConfigurationWorkingCopy createLaunchConfiguration(@NonNull TestProject testProject, @NonNull String launchName,
			@NonNull TestFile txFile, @NonNull String direction, @NonNull Map<String,String> newInKeys, @NonNull Map<String,String> newOutKeys, boolean interpreted) throws CoreException {
		URI stem = txFile.getURI().trimFileExtension();
		URI stemStem = stem.trimSegments(1);
		Map<String,String> intermediateKeys = new HashMap<>();
		intermediateKeys.put(CompilerChain.QVTI_STEP, stem.appendFileExtension(QVTimperativeUtil.QVTIAS_FILE_EXTENSION).toString());
		if (!interpreted) {
			intermediateKeys.put(CompilerChain.GENMODEL_STEP, stem.appendFileExtension("genmodel").toString());
			intermediateKeys.put(CompilerChain.JAVA_STEP, stemStem.appendSegment("test-src").toString());
			intermediateKeys.put(CompilerChain.CLASS_STEP, stemStem.appendSegment("bin").toString());
		}
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(QVTrLaunchConstants.LAUNCH_CONFIGURATION_TYPE_ID);
		ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(testProject.getIProject(), launchName);
		launchConfiguration.setAttribute(QVTrLaunchConstants.TX_KEY, txFile.getURI().toString());
		launchConfiguration.setAttribute(QVTrLaunchConstants.DIRECTION_KEY, direction);
		launchConfiguration.setAttribute(QVTrLaunchConstants.DOT_GRAPHS_KEY, Boolean.TRUE);
		launchConfiguration.setAttribute(QVTrLaunchConstants.GENMODEL_KEY, stem.appendFileExtension("genmodel").toString());
		launchConfiguration.setAttribute(QVTrLaunchConstants.INTERMEDIATES_KEY, intermediateKeys);
		launchConfiguration.setAttribute(QVTrLaunchConstants.INTERPRETED_KEY, interpreted);
		launchConfiguration.setAttribute(QVTrLaunchConstants.NEW_IN_KEY, newInKeys);
		launchConfiguration.setAttribute(QVTrLaunchConstants.NEW_OUT_KEY, newOutKeys);
		launchConfiguration.setAttribute(QVTrLaunchConstants.PROJECT_KEY, testProject.getName());
		launchConfiguration.setAttribute(QVTrLaunchConstants.TRACE_EVALUATION_KEY, false);
		launchConfiguration.setAttribute(QVTrLaunchConstants.YED_GRAPHS_KEY, Boolean.TRUE);
		return launchConfiguration;
	}

	@Override
	protected @NonNull String getProjectName() {
		return ClassUtil.nonNullState(getClass().getPackage().getName().replace('.', '/'));
	}

	@Override
	protected @NonNull TestFileSystemHelper getTestFileSystemHelper() {
		return new QVTrelationTestFileSystemHelper()
		{
			@Override
			protected void appendBuildSpec(@NonNull Writer s) throws IOException {}

			@Override
			protected void appendNatures(@NonNull Writer s) throws IOException {}
		};
	}

	public void testDebugger_Run_Forward2Reverse() throws Exception {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			return;
		}
		final @NonNull String inName = "forward";
		final @NonNull String outName = "reverse";
		final @NonNull String middleName = "middle";
		TestUIUtil.closeIntro();
		//	TestUIUtil.enableSwitchToDebugPerspectivePreference();
		//
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		TestFile inFile = testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
		testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/DoublyLinkedList.ecore"));
		TestFile outFile = testProject.getOutputFile("ThreeElementReversedList.xmi");
		TestFile middleFile = testProject.getOutputFile("Forward2Reverse.xmi");
		Map<String,String> inMap = new HashMap<>();
		inMap.put(inName, inFile.getURI().toString());
		Map<String,String> outMap = new HashMap<>();
		outMap.put(outName, outFile.getURI().toString());
		outMap.put(middleName, middleFile.getURI().toString());
		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(testProject, "Forward2Reverse", txFile, "reverse", inMap, outMap, true);
		launchConfiguration.doSave();
		ocl.deactivate();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null, true);
		assert launch != null;
		List<@NonNull IStatus> allResults = TestUIUtil.waitForLaunchToTerminate(launch);
		assert allResults != null;
		assert allResults.size() == 1;
		assertEquals(IStatus.OK, allResults.get(0).getSeverity());
		for (int i = 0; i < 10; i++) {
			testProject.getIProject().refreshLocal(IResource.DEPTH_INFINITE, null);
			if (outFile.getFile().exists()) {
				break;
			}
			TestUIUtil.wait(1000);
		}
		ResourceSet expectedResourceSet = new ResourceSetImpl();
		ocl.getProjectManager().initializeResourceSet(expectedResourceSet);
		Resource expectedResource = expectedResourceSet.getResource(getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), true);
		assert expectedResource != null;
		ResourceSet actualResourceSet = new ResourceSetImpl();
		//		ocl.getProjectManager().initializeResourceSet(actualResourceSet);
		Resource actualResource = actualResourceSet.getResource(outFile.getURI(), true);
		assert actualResource != null;

		ModelNormalizer normalizer = Forward2ReverseNormalizer.INSTANCE;
		//	if (normalizer != null) {
		normalizer.normalize(expectedResource);
		normalizer.normalize(actualResource);
		//	}
		TestUtil.assertSameModel(expectedResource, actualResource);
		ocl.dispose();
	}

	/**
	 * Bad (corrupted idref) input file => UnresolvedReferenceException.
	 */
	public void testDebugger_Run_BadForward2Reverse() throws Exception {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			return;
		}
		final @NonNull String inName = "forward";
		final @NonNull String outName = "reverse";
		final @NonNull String middleName = "middle";
		TestUIUtil.closeIntro();
		//	TestUIUtil.enableSwitchToDebugPerspectivePreference();
		//
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		TestFile inFile = testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/samples/BadThreeElementList.xmi"));
		testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/DoublyLinkedList.ecore"));
		TestFile outFile = testProject.getOutputFile("ThreeElementReversedList.xmi");
		TestFile middleFile = testProject.getOutputFile("Forward2Reverse.xmi");
		Map<String,String> inMap = new HashMap<>();
		inMap.put(inName, inFile.getURI().toString());
		Map<String,String> outMap = new HashMap<>();
		outMap.put(outName, outFile.getURI().toString());
		outMap.put(middleName, middleFile.getURI().toString());
		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(testProject, "Forward2Reverse", txFile, "reverse", inMap, outMap, true);
		launchConfiguration.doSave();
		ocl.deactivate();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null, true);
		assert launch != null;
		List<@NonNull IStatus> allResults = TestUIUtil.waitForLaunchToTerminate(launch);
		assert allResults != null;
		assert allResults.size() == 1;
		assertEquals(IStatus.INFO, allResults.get(0).getSeverity());
		assertEquals(UnresolvedReferenceException.class, allResults.get(0).getException().getClass());
		ocl.dispose();
	}

	/**
	 * Missing (erroneously spelled) input file => ResourceException.
	 */
	@SuppressWarnings("restriction")
	public void testDebugger_Run_MissingForward2Reverse() throws Exception {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			return;
		}
		final @NonNull String inName = "forward";
		final @NonNull String outName = "reverse";
		final @NonNull String middleName = "middle";
		TestUIUtil.closeIntro();
		//	TestUIUtil.enableSwitchToDebugPerspectivePreference();
		//
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		TestFile inFile = testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
		testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/DoublyLinkedList.ecore"));
		TestFile outFile = testProject.getOutputFile("ThreeElementReversedList.xmi");
		TestFile middleFile = testProject.getOutputFile("Forward2Reverse.xmi");
		Map<String,String> inMap = new HashMap<>();
		inMap.put(inName, inFile.getURI().appendFileExtension("xmi").toString());
		Map<String,String> outMap = new HashMap<>();
		outMap.put(outName, outFile.getURI().toString());
		outMap.put(middleName, middleFile.getURI().toString());
		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(testProject, "Forward2Reverse", txFile, "reverse", inMap, outMap, true);
		launchConfiguration.doSave();
		ocl.deactivate();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null, true);
		assert launch != null;
		List<@NonNull IStatus> allResults = TestUIUtil.waitForLaunchToTerminate(launch);
		assert allResults != null;
		assert allResults.size() == 1;
		assertEquals(IStatus.INFO, allResults.get(0).getSeverity());
		assertEquals(org.eclipse.core.internal.resources.ResourceException.class, allResults.get(0).getException().getClass());
		ocl.dispose();
	}

	/**
	 * Missing (erroneously spelled) input file => ResourceException.
	 *
	 * See Bug 545181
	 *
	public void testDebugger_Run_StupidExtensionForward2Reverse() throws Exception {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			return;
		}
		final @NonNull String inName = "forward";
		final @NonNull String outName = "reverse";
		final @NonNull String middleName = "middle";
		TestUIUtil.closeIntro();
		//	TestUIUtil.enableSwitchToDebugPerspectivePreference();
		//
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		TestFile inFile = testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
		testProject.copyFile(uriConverter, null, getModelsURI("forward2reverse/DoublyLinkedList.ecore"));
		TestFile outFile = testProject.getOutputFile("ThreeElementReversedList.xmi");
		TestFile middleFile = testProject.getOutputFile("Forward2Reverse.xmi");
		Map<String,String> inMap = new HashMap<>();
		inMap.put(inName, txFile.getURI().toString());
		Map<String,String> outMap = new HashMap<>();
		outMap.put(outName, outFile.getURI().toString());
		outMap.put(middleName, middleFile.getURI().toString());
		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(testProject, "Forward2Reverse", txFile, "reverse", inMap, outMap, true);
		launchConfiguration.doSave();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null, true);
		assert launch != null;
		List<@NonNull IStatus> allResults = TestUIUtil.waitForLaunchToTerminate(launch);
		assert allResults != null;
		assert allResults.size() == 1;
		assertEquals(IStatus.INFO, allResults.get(0).getSeverity());
		assertEquals(ResourceException.class, allResults.get(0).getException().getClass());
		ocl.dispose();
	} */

	public void testDebugger_Run_hstm2fstm() throws Exception {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			return;
		}
		final @NonNull String inName = "hier";
		final @NonNull String outName = "flat";
		final @NonNull String middleName = "middle";
		TestUIUtil.closeIntro();
		//
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		TestFile inFile = testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
		testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/FlatStateMachine.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/HierarchicalStateMachine.ecore"));
		TestFile outFile = testProject.getOutputFile("FlatModel.xmi");
		TestFile middleFile = testProject.getOutputFile("HierarchicalStateMachine2FlatStateMachine.xmi");
		Map<String,String> inMap = new HashMap<>();
		inMap.put(inName, inFile.getURI().toString());
		Map<String,String> outMap = new HashMap<>();
		outMap.put(outName, outFile.getURI().toString());
		outMap.put(middleName, middleFile.getURI().toString());
		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(testProject, "HierarchicalStateMachine2FlatStateMachine", txFile, "flat", inMap, outMap, true);
		launchConfiguration.doSave();
		ocl.deactivate();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null, true);
		assert launch != null;
		TestUIUtil.waitForLaunchToTerminate(launch);
		for (int i = 0; i < 10; i++) {
			testProject.getIProject().refreshLocal(IResource.DEPTH_INFINITE, null);
			if (outFile.getFile().exists()) {
				break;
			}
			TestUIUtil.wait(1000);
		}
		ResourceSet expectedResourceSet = new ResourceSetImpl();
		ocl.getProjectManager().initializeResourceSet(expectedResourceSet);
		Resource expectedResource = expectedResourceSet.getResource(getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"), true);
		assert expectedResource != null;
		ResourceSet actualResourceSet = new ResourceSetImpl();
		Resource actualResource = actualResourceSet.getResource(outFile.getURI(), true);
		assert actualResource != null;

		ModelNormalizer normalizer = FlatStateMachineNormalizer.INSTANCE;
		//	if (normalizer != null) {
		normalizer.normalize(expectedResource);
		normalizer.normalize(actualResource);
		//	}
		TestUtil.assertSameModel(expectedResource, actualResource);

		ocl.dispose();
	}

	public void testDebugger_Run_hstm2fstm_CG() throws Exception {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			return;
		}
		final @NonNull String inName = "hier";
		final @NonNull String outName = "flat";
		final @NonNull String middleName = "middle";
		TestUIUtil.closeIntro();
		//
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		TestFile inFile = testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
		testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/FlatStateMachine.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/HierarchicalStateMachine.ecore"));
		TestFile outFile = testProject.getOutputFile("FlatModel.xmi");
		TestFile middleFile = testProject.getOutputFile("HierarchicalStateMachine2FlatStateMachine.xmi");
		Map<String,String> inMap = new HashMap<>();
		inMap.put(inName, inFile.getURI().toString());
		Map<String,String> outMap = new HashMap<>();
		outMap.put(outName, outFile.getURI().toString());
		outMap.put(middleName, middleFile.getURI().toString());
		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(testProject, "HierarchicalStateMachine2FlatStateMachine", txFile, "flat", inMap, outMap, false);
		launchConfiguration.doSave();
		ocl.deactivate();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null, true);
		assert launch != null;
		TestUIUtil.waitForLaunchToTerminate(launch);
		for (int i = 0; i < 10; i++) {
			testProject.getIProject().refreshLocal(IResource.DEPTH_INFINITE, null);
			if (outFile.getFile().exists()) {
				break;
			}
			TestUIUtil.wait(1000);
		}
		ResourceSet expectedResourceSet = new ResourceSetImpl();
		ocl.getProjectManager().initializeResourceSet(expectedResourceSet);
		Resource expectedResource = expectedResourceSet.getResource(getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"), true);
		assert expectedResource != null;
		ResourceSet actualResourceSet = new ResourceSetImpl();
		Resource actualResource = actualResourceSet.getResource(outFile.getURI(), true);
		assert actualResource != null;

		ModelNormalizer normalizer = FlatStateMachineNormalizer.INSTANCE;
		//	if (normalizer != null) {
		normalizer.normalize(expectedResource);
		normalizer.normalize(actualResource);
		//	}
		TestUtil.assertSameModel(expectedResource, actualResource);

		ocl.dispose();
		cleanup("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/hstm2fstm/FlatStateMachine",
			"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/hstm2fstm/HierarchicalStateMachine",
				"http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/xtext/qvtrelation/tests/hstm2fstm/HierarchicalStateMachine2FlatStateMachine");
	}
}
