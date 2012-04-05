/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTFormattingHelper;

public class QVTcFormattingHelper extends QVTFormattingHelper
{	
	public QVTcFormattingHelper(IQVTcNodeEnvironment environment) {
		super(environment);
	}
		
	@Override
	public String formatName(Object object) {
		if (object instanceof BottomPattern)
			return "bottom";
		else if (object instanceof GuardPattern)
			return "guard";
		else
			return super.formatName(object);
	}

	@Override
	public String formatQualifiedName(Object object) {
		if (object instanceof BottomPattern)
            return formatQualifiedName(((BottomPattern)object).eContainer()) + "$bottom";
		else if (object instanceof GuardPattern)
            return formatQualifiedName(((GuardPattern)object).eContainer()) + "$guard";
		else
			return super.formatQualifiedName(object);
	}
}
