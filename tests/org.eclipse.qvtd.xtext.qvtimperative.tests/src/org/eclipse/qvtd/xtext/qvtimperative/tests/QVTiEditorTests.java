/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread.Resumable;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTiEditorTests extends LoadTestCase
{
	public void doLoad_Concrete(@NonNull URI inputURI, @NonNull String @Nullable [] messages, StatusCodes.@Nullable Severity severity) throws Exception {
		URI pivotURI = getTestURIWithExtension(inputURI, QVTimperativeUtil.QVTIAS_FILE_EXTENSION);
		QVTimperativeEnvironmentThreadFactory environmentThreadFactory = createQVTimperativeEnvironmentThreadFactory();
		if (severity != null) {
			environmentThreadFactory.setSeverity(severity);
		}
		Resumable<@NonNull Resource, ?> resumable = doLoad_Concrete(environmentThreadFactory, inputURI, pivotURI, messages, severity);
		resumable.syncResume();
	}

	@Override
	protected void setUp() throws Exception {
		XtextCompilerUtil.doQVTimperativeSetup();
		super.setUp();
	}
	public void testLoad_HSV2HSL_qvti() throws Exception {
		doLoad_Concrete(getModelsURI("HSV2HSL/HSV2HSL.qvti"), NO_MESSAGES, null);
	}

	public void testLoad_Classescs2Classes_qvti() throws Exception {
		doLoad_Concrete(getModelsURI("ClassesCS2AS/ClassesCS2AS.qvti"), NO_MESSAGES, null);
	}

	//	public void testLoad_ClassToRDBMSSchedule_qvti() throws IOException, InterruptedException {
	//		doLoad_Concrete("ClassToRDBMSSchedule.qvti");
	//	}
}
