/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.test.xtext.AbstractBuilderTests;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestFolder;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * Tests that the MultiValidationJob does some validating.
 */
public class QVTrBuilderTests extends AbstractBuilderTests
{


	@Override
	protected void setUp() throws Exception {
		AbstractBuilderTests.VALIDATION_TIMEOUT = 0;			// FIXME debugging
		super.setUp();
	}

	public void testBuilder_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		OCL ocl = OCL.newInstance(OCL.CLASS_PATH);
		URIConverter uriConverter = ocl.getResourceSet().getURIConverter();
		TestProject testProject = getTestProject();
		TestFolder testFolder = testProject.getOutputFolder("models/hstm2fstm");
		testProject.copyFile(uriConverter, testFolder, getTestBundleFileURI("/models/hstm2fstm/FlatStateMachine.ecore"));
		testProject.copyFile(uriConverter, testFolder, getTestBundleFileURI("/models/hstm2fstm/HierarchicalStateMachine.ecore"));
		TestFile testFile = testProject.copyFile(uriConverter, testFolder, getTestBundleFileURI("/models/hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IPath path = new Path("/models/hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr");
		IFile file = testProject.getIProject().getFile(path);
		doValidation(file, null, null); //Lists.newArrayList("The name 'My#Class' is not well formed"));
		ocl.dispose();
	}

	protected URI getTestBundleFileURI(@NonNull String filePath) {
		return URI.createPlatformResourceURI(getTestBundleName() + filePath, true);
	}
}
