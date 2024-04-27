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

import org.eclipse.qvtd.sirius.ide.FileExtensionRegistry;
import org.eclipse.qvtd.xtext.qvtbase.tests.PivotTestCase;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class SiriusMenuTests extends PivotTestCase
{
	public void testComponentization() {
		FileExtensionRegistry.DEBUG_COMPONENTIZATION_ANALYSIS = true;
		FileExtensionRegistry.getInstance();
	}
}
