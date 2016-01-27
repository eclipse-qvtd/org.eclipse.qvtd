/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.VMVariable;
import org.eclipse.ocl.examples.xtext.tests.TestUIUtil;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.debug.core.QVTiDebugTarget;
import org.eclipse.qvtd.debug.evaluator.QVTiVMRootEvaluationEnvironment;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.debug.vm.QVTiVMVirtualMachine;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiDebuggerTests extends XtextTestCase
{
	protected static final @NonNull String PC_NAME = "$pc";

	private void checkPosition(@NonNull IThread vmThread, int lineNumber, int charStart, int charEnd) throws DebugException {
		IStackFrame topStackFrame = vmThread.getTopStackFrame();
		assertEquals("lineNumber", lineNumber, topStackFrame.getLineNumber());
		assertEquals("charStart", charStart, topStackFrame.getCharStart());
		assertEquals("charEnd", charEnd, topStackFrame.getCharEnd());
	}

	private void checkVariable(@NonNull IThread vmThread, @NonNull String name, @Nullable Object expectedValue) throws DebugException {
		IStackFrame topStackFrame = vmThread.getTopStackFrame();
		IVariable[] variables = topStackFrame.getVariables();
		if (variables != null){
			for (IVariable variable : variables) {
				if (name.equals(variable.getName()) && (variable instanceof VMVariable)) {
					Object valueObject = ((VMVariable)variable).getVmVar().valueObject;
					assertEquals(expectedValue, valueObject);
					return;
				}
			}
		}
		fail("Unknown variable '" + name + "'");
	}

	private void checkVariables(@NonNull IThread vmThread, String... names) throws DebugException {
		List<String> expectedNames = new ArrayList<String>();
		if (names != null){
			for (String name : names) {
				expectedNames.add(name);
			}
		}
		Collections.sort(expectedNames);
		IStackFrame topStackFrame = vmThread.getTopStackFrame();
		IVariable[] variables = topStackFrame.getVariables();
		List<String> actualNames = new ArrayList<String>();
		if (variables != null){
			for (IVariable variable : variables) {
				actualNames.add(variable.getName());
			}
		}
		Collections.sort(actualNames);
		assertEquals(expectedNames, actualNames);
	}

	protected ILaunchConfigurationWorkingCopy createLaunchConfiguration(@NonNull IProject iProject, @NonNull String launchName,
			@NonNull URI transformationURI, @NonNull Map<String,String> inKeys, @NonNull Map<String,String> outKeys) throws CoreException {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(QVTiLaunchConstants.LAUNCH_CONFIGURATION_TYPE_ID);
		ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(iProject, launchName);
		launchConfiguration.setAttribute(QVTiLaunchConstants.TX_KEY, transformationURI.toString());
		launchConfiguration.setAttribute(QVTiLaunchConstants.IN_KEY, inKeys);
		launchConfiguration.setAttribute(QVTiLaunchConstants.OUT_KEY, outKeys);
		return launchConfiguration;
	}

	@SuppressWarnings("null")
	@Override
	protected @NonNull String getProjectName() {
		return getClass().getPackage().getName().replace('.', '/');
	}

	public void testDebugger_Run_HSV2HLS() throws Exception {
		TestUIUtil.closeIntro();
		TestUIUtil.enableSwitchToDebugPerspectivePreference();
		//
		IProject iProject = TestUIUtil.createIProject("QVTiDebuggerRunTests");
		IFile txFile = TestUIUtil.copyIFile(iProject.getFile("HSV2HLS.qvti"), getProjectFileURI("HSV2HLS/HSV2HLS.qvti"), "UTF-8");
		TestUIUtil.copyIFile(iProject.getFile("HSVTree.ecore"), getProjectFileURI("HSV2HLS/HSVTree.ecore"), null);
		TestUIUtil.copyIFile(iProject.getFile("HLSTree.ecore"), getProjectFileURI("HSV2HLS/HLSTree.ecore"), null);
		TestUIUtil.copyIFile(iProject.getFile("HSV2HLS.ecore"), getProjectFileURI("HSV2HLS/HSV2HLS.ecore"), null);
		IFile inFile = TestUIUtil.copyIFile(iProject.getFile("HSVNode.xmi"), getProjectFileURI("HSV2HLS/HSVNode.xmi"), null);
		IFile outFile = iProject.getFile("HLSNode.xmi");
		IFile middleFile = iProject.getFile("HSV2HLSNode.xmi");
		@NonNull URI txURI = URI.createPlatformResourceURI(txFile.getFullPath().toString(), true);
		URI inURI = URI.createPlatformResourceURI(inFile.getFullPath().toString(), true);
		URI outURI = URI.createPlatformResourceURI(outFile.getFullPath().toString(), true);
		URI middleURI = URI.createPlatformResourceURI(middleFile.getFullPath().toString(), true);
		Map<String,String> inMap = new HashMap<String,String>();
		inMap.put("hsv", inURI.toString());
		Map<String,String> outMap = new HashMap<String,String>();
		outMap.put("hls", outURI.toString());
		outMap.put("middle", middleURI.toString());

		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(iProject, "HSV2HLS", txURI, inMap, outMap);
		launchConfiguration.doSave();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null);
		assert launch != null;
		TestUIUtil.waitForLaunchToTerminate(launch);
		for (int i = 0; i < 10; i++) {
			outFile.refreshLocal(IResource.DEPTH_ZERO, null);
			if (outFile.exists()) {
				break;
			}
			TestUIUtil.wait(1000);
		}
		ResourceSet expectedResourceSet = new ResourceSetImpl();
		Resource expectedResource = expectedResourceSet.getResource(getProjectFileURI("HSV2HLS/HLSNodeValidate.xmi"), true);
		assert expectedResource != null;
		ResourceSet actualResourceSet = new ResourceSetImpl();
		Resource actualResource = actualResourceSet.getResource(outURI, true);
		assert actualResource != null;
		TestUtil.assertSameModel(expectedResource, actualResource);
	}

	public void testDebugger_Debug_HSV2HLS() throws Exception {
		final @NonNull String inName = "hls";
		final @NonNull String outName = "hsv";
		final @NonNull String middleName = "middle";
		//
		TestUIUtil.closeIntro();
		TestUIUtil.enableSwitchToDebugPerspectivePreference();
		//
		IProject iProject = TestUIUtil.createIProject("QVTiDebuggerDebugTests");
		IFile txFile = TestUIUtil.copyIFile(iProject.getFile("HSV2HLS.qvti"), getProjectFileURI("HSV2HLS/HSV2HLS.qvti"), "UTF-8");
		TestUIUtil.copyIFile(iProject.getFile("HSVTree.ecore"), getProjectFileURI("HSV2HLS/HSVTree.ecore"), null);
		TestUIUtil.copyIFile(iProject.getFile("HLSTree.ecore"), getProjectFileURI("HSV2HLS/HLSTree.ecore"), null);
		TestUIUtil.copyIFile(iProject.getFile("HSV2HLS.ecore"), getProjectFileURI("HSV2HLS/HSV2HLS.ecore"), null);
		IFile inFile = TestUIUtil.copyIFile(iProject.getFile("HSVNode.xmi"), getProjectFileURI("HSV2HLS/HSVNode.xmi"), null);
		IFile outFile = iProject.getFile("HLSNode.xmi");
		IFile middleFile = iProject.getFile("HSV2HLSNode.xmi");
		@NonNull URI txURI = URI.createPlatformResourceURI(txFile.getFullPath().toString(), true);
		URI inURI = URI.createPlatformResourceURI(inFile.getFullPath().toString(), true);
		URI outURI = URI.createPlatformResourceURI(outFile.getFullPath().toString(), true);
		URI middleURI = URI.createPlatformResourceURI(middleFile.getFullPath().toString(), true);
		Map<String,String> inMap = new HashMap<String,String>();
		inMap.put(outName, inURI.toString());
		Map<String,String> outMap = new HashMap<String,String>();
		outMap.put(inName, outURI.toString());
		outMap.put(middleName, middleURI.toString());

		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(iProject, "HSV2HLS", txURI, inMap, outMap);
		launchConfiguration.doSave();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.DEBUG_MODE, null);
		assert launch != null;
		//
/*		Map<String, Object> attributes = launch.getLaunchConfiguration().getAttributes();
		ExpressionInOCL asExpressionInOCL = (ExpressionInOCL) attributes.get(QVTiLaunchConstants.EXPRESSION_OBJECT);
		OperationCallExp asOperationCallExp = (OperationCallExp) asExpressionInOCL.getOwnedBody();
		PropertyCallExp asPropertyCallExpCallExp = (PropertyCallExp) asOperationCallExp.getOwnedSource();
		VariableExp asVariableExp = (VariableExp) asPropertyCallExpCallExp.getOwnedSource();
		NullLiteralExp asNullLiteralExp = (NullLiteralExp) asOperationCallExp.getOwnedArguments().get(0); */
		//
		QVTiDebugTarget debugTarget = (QVTiDebugTarget) launch.getDebugTarget();
		QVTiVMVirtualMachine vm = (QVTiVMVirtualMachine) debugTarget.getVM();
		QVTiVMRootEvaluationEnvironment vmRootEvaluationEnvironment = (QVTiVMRootEvaluationEnvironment) vm.getEvaluationEnv();
		assert vmRootEvaluationEnvironment != null;
		Transformation asTransformation = vmRootEvaluationEnvironment.getDebuggableElement();
		TypedModel inTypedModel = asTransformation.getModelParameter(inName);
		TypedModel middleTypedModel = asTransformation.getModelParameter(middleName);
		TypedModel outTypedModel = asTransformation.getModelParameter(outName);
		Variable asTransformationVariable = asTransformation.getOwnedContext();
		Variable asInVariable = inTypedModel.getOwnedContext();
		Variable asMiddleVariable = middleTypedModel.getOwnedContext();
		Variable asOutVariable = outTypedModel.getOwnedContext();
		assert (asTransformationVariable != null) && (asInVariable != null) && (asMiddleVariable != null) && (asOutVariable != null);
		
		IThread vmThread = debugTarget.getThreads()[0];
		assert vmThread != null;
		TestUIUtil.waitForSuspended(vmThread);
		//
		checkPosition(vmThread, 8, 433, 447);
		checkVariables(vmThread, PC_NAME, "this", outName, inName, middleName);
		checkVariable(vmThread, PC_NAME, asTransformation);
		checkVariable(vmThread, "this", vmRootEvaluationEnvironment.getValueOf(asTransformationVariable));
		checkVariable(vmThread, outName, vmRootEvaluationEnvironment.getValueOf(asOutVariable));
		checkVariable(vmThread, inName, vmRootEvaluationEnvironment.getValueOf(asInVariable));
		checkVariable(vmThread, middleName, vmRootEvaluationEnvironment.getValueOf(asMiddleVariable));
		//
		vmThread.stepInto();
		TestUIUtil.waitForSuspended(vmThread);
		//
		checkPosition(vmThread, 21, 1053, 1061);
		checkVariables(vmThread, PC_NAME);
		checkVariable(vmThread, PC_NAME, NameUtil.getNameable(asTransformation.getRule(), QVTimperativeUtil.ROOT_MAPPING_NAME));
		//
		vmThread.stepReturn();
		TestUIUtil.waitForTerminated(vmThread);
		assertEquals(0, vm.getExitCode());
		//
		TestUIUtil.flushEvents();
		ResourceSet expectedResourceSet = new ResourceSetImpl();
		Resource expectedResource = expectedResourceSet.getResource(getProjectFileURI("HSV2HLS/HLSNodeValidate.xmi"), true);
		assert expectedResource != null;
		ResourceSet actualResourceSet = new ResourceSetImpl();
		Resource actualResource = actualResourceSet.getResource(outURI, true);
		assert actualResource != null;
		TestUtil.assertSameModel(expectedResource, actualResource);
	}
}
