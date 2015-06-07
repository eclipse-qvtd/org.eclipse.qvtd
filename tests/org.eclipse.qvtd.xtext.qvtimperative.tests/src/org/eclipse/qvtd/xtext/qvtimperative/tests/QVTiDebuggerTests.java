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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.TestUIUtil;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiDebuggerTests extends XtextTestCase
{
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
		IProject iProject = TestUIUtil.createIProject("QVTiDebuggerTests");
//		IFile launchFile = TestUIUtil.copyIFile(iProject.getFile("HSV2HLS.launch"), getProjectFileURI("HSV2HLS/HSV2HLS.launch"), null);
		IFile txFile = TestUIUtil.copyIFile(iProject.getFile("HSV2HLS.qvti"), getProjectFileURI("HSV2HLS/HSV2HLS.qvti"), "UTF-8");
		TestUIUtil.copyIFile(iProject.getFile("HSVTree.ecore"), getProjectFileURI("HSV2HLS/HSVTree.ecore"), null);
		TestUIUtil.copyIFile(iProject.getFile("HLSTree.ecore"), getProjectFileURI("HSV2HLS/HLSTree.ecore"), null);
		TestUIUtil.copyIFile(iProject.getFile("HSV2HLS.ecore"), getProjectFileURI("HSV2HLS/HSV2HLS.ecore"), null);
		IFile inFile = TestUIUtil.copyIFile(iProject.getFile("HSVNode.xmi"), getProjectFileURI("HSV2HLS/HSVNode.xmi"), null);
		IFile outFile = iProject.getFile("HLSNode.xmi");
		IFile middleFile = iProject.getFile("HSV2HLSNode.xmi");
		@SuppressWarnings("null")@NonNull URI txURI = URI.createPlatformResourceURI(txFile.getFullPath().toString(), true);
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
		TestUIUtil.flushEvents();
//		outFile.refreshLocal(IResource.DEPTH_ZERO, null);
		ResourceSet expectedResourceSet = new ResourceSetImpl();
		Resource expectedResource = expectedResourceSet.getResource(getProjectFileURI("HSV2HLS/HLSNodeValidate.xmi"), true);
		assert expectedResource != null;
		ResourceSet actualResourceSet = new ResourceSetImpl();
		Resource actualResource = actualResourceSet.getResource(outURI, true);
		assert actualResource != null;
		TestUtil.assertSameModel(expectedResource, actualResource);
//		ocl.dispose();
	}
}
