/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import java.io.IOException;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;

import com.google.inject.Guice;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiEditorTests extends LoadTestCase
{	
	public void doLoad_Concrete(@NonNull String inputName) throws IOException {
		OCL ocl = QVTimperative.newInstance(getProjectMap(), null);
//		OCL ocl = OCL.newInstance(getProjectMap());
		URI inputURI = getProjectFileURI(inputName);
		@SuppressWarnings("null")@NonNull URI pivotURI = inputURI.trimFileExtension().appendFileExtension("qvtias");
		doLoad_Concrete(ocl, inputURI, pivotURI);
		ocl.dispose();
	}

	/**
	 * Perform the appropriate initialization to support QVTimperative parsing and editing using Xtext.
	 * NB. This must be called before setUp() creates a GlobalStateMemento if the aggressive DEBUG_GC
	 * garbage collection is enabled.
	 */
	public static void doQVTimperativeSetup() {
    	if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
    		QVTimperativeStandaloneSetup.doSetup();
    	}
    	else {
    		Guice.createInjector(new org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeRuntimeModule());
    	}
	}	

	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		doQVTimperativeSetup();
		super.setUp();
	}
	public void testLoad_HSV2HLS_qvti() throws IOException, InterruptedException {
		doLoad_Concrete("HSV2HLS/HSV2HLS.qvti");
	}	
	
	
	public void testLoad_Classescs2Classes_qvti() throws IOException, InterruptedException {
		doLoad_Concrete("ClassesCS2AS/ClassesCS2AS.qvti");
	}

//	public void testLoad_ClassToRDBMSSchedule_qvti() throws IOException, InterruptedException {
//		doLoad_Concrete("ClassToRDBMSSchedule.qvti");
//	}	
}
