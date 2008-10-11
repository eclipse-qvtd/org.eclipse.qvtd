/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import java.util.Set;

import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCoreFactory;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS;

public class QVTcGuardPatternEnvironment extends QVTcPatternEnvironment<GuardPattern>
{
	public QVTcGuardPatternEnvironment(QVTcAreaEnvironment<?> domainEnvironment, PatternCS patternCS) {
		super(domainEnvironment, QVTCoreFactory.eINSTANCE.createGuardPattern(), patternCS);
		Area area = domainEnvironment.getArea();
		area.setGuardPattern(ast);
	}

	@Override
	public Set<QVTcPatternEnvironment<?>> getPatternEnvironmentClosure() {
		return getParentEnvironment().getGuardPatternEnvironmentClosure();
	}
	
	@Override
	public String toString() {
		String parentString = getInternalParent() != null ? (getInternalParent().toString() + ".") : "";
		return parentString + "guard";
	}
}
