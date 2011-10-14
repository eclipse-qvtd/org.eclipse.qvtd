/*******************************************************************************
 * Copyright (c) 2009 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof.utils;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvt.declarative.ecore.utils.CSTFormattingHelper;

public class TestFormattingHelper extends CSTFormattingHelper
{
    public static final TestFormattingHelper INSTANCE = new TestFormattingHelper();

	@Override
	public String formatResource(Resource resource) {
		String s = super.formatResource(resource);
		int i = s.lastIndexOf("/");
		return i >= 0 ? s.substring(i+1) : s;
	}
}
