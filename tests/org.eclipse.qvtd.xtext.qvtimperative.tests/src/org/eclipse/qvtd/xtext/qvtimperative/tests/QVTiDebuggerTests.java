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
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipse.debug.internal.ui.sourcelookup.SourceLookupFacility;
import org.eclipse.debug.internal.ui.viewers.model.TreeModelContentProvider;
import org.eclipse.debug.internal.ui.views.variables.VariablesView;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ocl.examples.debug.vm.VMVirtualMachine;
import org.eclipse.ocl.examples.debug.vm.core.VMVariable;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUIUtil;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.ui.model.BaseEditorCallback;
import org.eclipse.qvtd.debug.core.QVTiDebugTarget;
import org.eclipse.qvtd.debug.evaluator.QVTiVMRootEvaluationEnvironment;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.debug.vm.QVTiVMVirtualMachine;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.XtextTestCase;
import org.eclipse.qvtd.xtext.qvtimperative.ui.internal.QVTimperativeActivator;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.google.inject.Injector;

import test.hsl.HSLTree.HSLTreePackage;
import test.hsv.HSVTree.HSVTreePackage;
import test.middle.HSV2HSL.HSV2HSLPackage;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiDebuggerTests extends XtextTestCase
{
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

	protected ILaunchConfigurationWorkingCopy createLaunchConfiguration(@NonNull TestProject testProject, @NonNull String launchName,
			@NonNull TestFile txFile, @NonNull Map<String,String> newInKeys, @NonNull Map<String,String> newOutKeys) throws CoreException {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager.getLaunchConfigurationType(QVTiLaunchConstants.LAUNCH_CONFIGURATION_TYPE_ID);
		ILaunchConfigurationWorkingCopy launchConfiguration = launchConfigurationType.newInstance(testProject.getIProject(), launchName);
		launchConfiguration.setAttribute(QVTiLaunchConstants.TX_KEY, txFile.getURI().toString());
		//		launchConfiguration.setAttribute(QVTiLaunchConstants.OLD_IN_KEY, oldInKeys);
		launchConfiguration.setAttribute(QVTiLaunchConstants.NEW_IN_KEY, newInKeys);
		//		launchConfiguration.setAttribute(QVTiLaunchConstants.OLD_OUT_KEY, oldOutKeys);
		launchConfiguration.setAttribute(QVTiLaunchConstants.NEW_OUT_KEY, newOutKeys);
		launchConfiguration.setAttribute(QVTiLaunchConstants.INTERPRETED_KEY, true);
		launchConfiguration.setAttribute(QVTiLaunchConstants.TRACE_EVALUATION_KEY, false);
		return launchConfiguration;
	}

	@Override
	protected @NonNull String getProjectName() {
		return ClassUtil.nonNullState(getClass().getPackage().getName().replace('.', '/'));
	}

	public void testDebugger_Run_HSV2HSL() throws Exception {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			return;
		}
		final @NonNull String inName = "hsl";
		final @NonNull String outName = "hsv";
		final @NonNull String middleName = "middle";
		TestUIUtil.closeIntro();
		TestUIUtil.enableSwitchToDebugPerspectivePreference();
		//
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSV2HSL.qvti"));
		TestFile inFile = testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSVNode.xmi"));
		testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSVTree.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSLTree.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSV2HSL.ecore"));
		TestFile outFile = testProject.getOutputFile("HSLNode.xmi");
		TestFile middleFile = testProject.getOutputFile("HSV2HSLNode.xmi");
		Map<String,String> inMap = new HashMap<>();
		inMap.put(outName, inFile.getURI().toString());
		Map<String,String> outMap = new HashMap<>();
		outMap.put(inName, outFile.getURI().toString());
		outMap.put(middleName, middleFile.getURI().toString());
		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(testProject, "HSV2HSL", txFile, inMap, outMap);
		launchConfiguration.doSave();
		TestUIUtil.flushEvents();
		ILaunch launch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null);
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
		Resource expectedResource = expectedResourceSet.getResource(getModelsURI("HSV2HSL/HSLNodeValidate.xmi"), true);
		assert expectedResource != null;
		ResourceSet actualResourceSet = new ResourceSetImpl();
		//		ocl.getProjectManager().initializeResourceSet(actualResourceSet);
		Resource actualResource = actualResourceSet.getResource(outFile.getURI(), true);
		assert actualResource != null;
		TestUtil.assertSameModel(expectedResource, actualResource);
		ocl.dispose();
	}

	public void testDebugger_Debug_HSV2HSL() throws Exception {
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			return;
		}
		// Debugger is interpreted and the HSV2HSL.qvti uses *.ecore not compiled models
		assert !EPackage.Registry.INSTANCE.containsKey(HSVTreePackage.eNS_URI);
		assert !EPackage.Registry.INSTANCE.containsKey(HSLTreePackage.eNS_URI);
		assert !EPackage.Registry.INSTANCE.containsKey(HSV2HSLPackage.eNS_URI);
		//		VMVirtualMachine.PRE_VISIT.setState(true);
		//		VMVirtualMachine.POST_VISIT.setState(true);
		//		VMVirtualMachine.VM_EVENT.setState(true);
		//		VMVirtualMachine.VM_REQUEST.setState(true);
		//		VMVirtualMachine.VM_RESPONSE.setState(true);
		final @NonNull String inName = "hsl";
		final @NonNull String outName = "hsv";
		final @NonNull String middleName = "middle";
		//
		TestUIUtil.closeIntro();
		TestUIUtil.enableSwitchToDebugPerspectivePreference();
		//
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow initialWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		assert initialWorkbenchWindow != null;
		IWorkbenchPage initialPage = initialWorkbenchWindow.getActivePage();
		assert initialPage != null;
		IPartService initialPartService = initialWorkbenchWindow.getPartService();
		assert initialPartService != null;
		IWorkbenchPart initialPart = initialPartService.getActivePart();
		assert initialPart != null;
		//
		Injector injector = QVTimperativeActivator.getInstance().getInjector(QVTimperativeActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTIMPERATIVE_QVTIMPERATIVE);
		injector.getInstance(BaseEditorCallback.class).setDontAskForNatureAgain();
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSV2HSL.qvti"));
		TestFile inFile = testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSVNode.xmi"));
		testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSVTree.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSLTree.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("HSV2HSL/HSV2HSL.ecore"));
		TestFile outFile = testProject.getOutputFile("HSLNode.xmi");
		TestFile middleFile = testProject.getOutputFile("HSV2HSLNode.xmi");
		Map<String,String> inMap = new HashMap<>();
		inMap.put(outName, inFile.getURI().toString());
		Map<String,String> outMap = new HashMap<>();
		outMap.put(inName, outFile.getURI().toString());
		outMap.put(middleName, middleFile.getURI().toString());

		ILaunchConfigurationWorkingCopy launchConfiguration = createLaunchConfiguration(testProject, "HSV2HSL", txFile, inMap, outMap);
		launchConfiguration.doSave();
		ocl.deactivate();
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
		IThread vmThread = null;
		QVTiDebugTarget debugTarget = (QVTiDebugTarget) launch.getDebugTarget();
		QVTiVMVirtualMachine vm = (QVTiVMVirtualMachine) debugTarget.getVM();
		try {
			QVTiVMRootEvaluationEnvironment vmRootEvaluationEnvironment = (QVTiVMRootEvaluationEnvironment) vm.getEvaluationEnv();
			assert vmRootEvaluationEnvironment != null;
			ImperativeTransformation asTransformation = (ImperativeTransformation) vmRootEvaluationEnvironment.getDebuggableElement();
			TypedModel inTypedModel = QVTimperativeUtil.getModelParameter(asTransformation, inName);
			TypedModel middleTypedModel = QVTimperativeUtil.getModelParameter(asTransformation, middleName);
			TypedModel outTypedModel = QVTimperativeUtil.getModelParameter(asTransformation, outName);
			VariableDeclaration asTransformationVariable = asTransformation.getOwnedContext();
			VariableDeclaration asInVariable = inTypedModel.getOwnedContext();
			VariableDeclaration asMiddleVariable = middleTypedModel.getOwnedContext();
			VariableDeclaration asOutVariable = outTypedModel.getOwnedContext();
			assert (asTransformationVariable != null) && (asInVariable != null) && (asMiddleVariable != null) && (asOutVariable != null);

			vmThread = debugTarget.getThreads()[0];
			assert vmThread != null;
			TestUIUtil.waitForSuspended(vmThread);
			TestUIUtil.waitForNotStepping(vmThread);
			//
			checkPosition(vmThread, 8, 448, 455);		// Values with OCL BaseLocationInFileProvider fix for Bug 495979
			checkVariables(vmThread, VMVirtualMachine.PC_NAME, QVTbaseUtil.THIS_NAME, outName, inName, middleName);
			checkVariable(vmThread, VMVirtualMachine.PC_NAME, asTransformation);
			checkVariable(vmThread, QVTbaseUtil.THIS_NAME, vmRootEvaluationEnvironment.getValueOf(asTransformationVariable));
			checkVariable(vmThread, outName, vmRootEvaluationEnvironment.getValueOf(asOutVariable));
			checkVariable(vmThread, inName, vmRootEvaluationEnvironment.getValueOf(asInVariable));
			checkVariable(vmThread, middleName, vmRootEvaluationEnvironment.getValueOf(asMiddleVariable));
			//
			vmThread.stepInto();
			TestUIUtil.waitForSuspended(vmThread);
			//
			checkPosition(vmThread, 20, 1022, 1030);
			checkVariables(vmThread, VMVirtualMachine.PC_NAME, "nodes");
			checkVariable(vmThread, VMVirtualMachine.PC_NAME, QVTimperativeUtil.getDefaultEntryPoint(asTransformation));
			//
			vmThread.stepReturn();
			TestUIUtil.waitForTerminated(vmThread);
		}
		finally {
			try {
				launch.terminate();
				TestUIUtil.waitForLaunchToTerminate(launch, 10000);
				/* if (!hasTerminated) {
					IStackFrame topStackFrame = vmThread.getTopStackFrame();
					IVariable[] variables = topStackFrame.getVariables();
					if (variables != null){
						for (IVariable variable : variables) {
							if (VMVirtualMachine.EXCEPTION_NAME.equals(variable.getName()) && (variable instanceof VMVariable)) {
								Object valueObject = ((VMVariable)variable).getVmVar().valueObject;
								throw (Exception)valueObject;
							}
						}
					}
					TestCase.fail("Failed to terminate");
				} */
				assertEquals(0, vm.getExitCode());
				//
				TestUIUtil.flushEvents();
				ResourceSet expectedResourceSet = new ResourceSetImpl();
				ocl.getProjectManager().initializeResourceSet(expectedResourceSet);
				Resource expectedResource = expectedResourceSet.getResource(getModelsURI("HSV2HSL/HSLNodeValidate.xmi"), true);
				assert expectedResource != null;
				ResourceSet actualResourceSet = new ResourceSetImpl();
				//		ocl.getProjectManager().initializeResourceSet(expectedResourceSet);
				Resource actualResource = actualResourceSet.getResource(outFile.getURI(), true);
				assert actualResource != null;
				TestUtil.assertSameModel(expectedResource, actualResource);
			}
			finally {
				ILaunch[] launches = DebugPlugin.getDefault().getLaunchManager().getLaunches();
				TestUIUtil.removeTerminatedLaunches(launches);
				SourceLookupFacility.shutdown();
				initialPage.activate(initialPart);
				initialPage.closeAllEditors(false);
				IViewReference[] viewReferences = initialPage.getViewReferences();
				for (IViewReference viewReference : viewReferences) {
					IViewPart viewPart = viewReference.getView(false);
					if (viewPart instanceof VariablesView) {
						AbstractDebugView variablesView = (AbstractDebugView)viewPart;
						variablesView.getViewer().setInput(null);
						TreeViewer treeModelViewer = (TreeViewer)variablesView.getViewer();
						treeModelViewer.setContentProvider(new TreeModelContentProvider());
					}
				}
			}
		}
	}
}
