/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.minioclcs.xtext.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.doc.MiniOCLCSStandaloneSetup;
import org.eclipse.qvtd.doc.minioclcs.RootCS;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.junit.Before;
import org.junit.Test;

public class MiniOCLCSParsingTest extends LoadTestCase {

	@Before
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MiniOCLCSStandaloneSetup.doSetup();
	}

	protected RootCS parse(String fileName) {
		URI fileURI = getModelsURI(fileName);
		ResourceSet rSet = new ResourceSetImpl();
		ProjectManager.CLASS_PATH.initializeResourceSet(rSet);
		Resource resoure = rSet.getResource(fileURI, true);
		return (RootCS) resoure.getContents().get(0);
	}

	@Test
	public void testSimpleMiniOCL_PackagesDef() {
		RootCS result = parse("simple_packages.mocl");
		assertNotNull(result);
	}

	@Test
	public void testSimpleMiniOCL_Invariant() {
		RootCS result = parse("simple_invariants.mocl");
		assertNotNull(result);
	}
}
