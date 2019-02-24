/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiEditorTests extends LoadTestCase
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTimperative.newInstance(getTestProjectManager(), null);
	}

	@Override
	public void doLoad_Concrete(@NonNull URI inputURI, @NonNull String @Nullable [] messages) throws Exception {
		OCL ocl = QVTimperative.newInstance(getTestProjectManager(), null);
		//		OCL ocl = OCL.newInstance(getProjectMap());
		URI pivotURI = getTestURIWithExtension(inputURI, "qvtias");
		doLoad_Concrete(ocl, inputURI, pivotURI, messages);
		ocl.dispose();
	}

	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		XtextCompilerUtil.doQVTimperativeSetup();
		super.setUp();
	}
	public void testLoad_HSV2HSL_qvti() throws Exception {
		doLoad_Concrete(getModelsURI("HSV2HSL/HSV2HSL.qvti"), NO_MESSAGES);
	}


	public void testLoad_Classescs2Classes_qvti() throws Exception {
		doLoad_Concrete(getModelsURI("ClassesCS2AS/ClassesCS2AS.qvti"), NO_MESSAGES);
	}

	//	public void testLoad_ClassToRDBMSSchedule_qvti() throws IOException, InterruptedException {
	//		doLoad_Concrete("ClassToRDBMSSchedule.qvti");
	//	}
}
