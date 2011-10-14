/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: BottomPatternOperations.java,v 1.1 2008/12/31 17:42:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.operations;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.RealizedVariable;

public class BottomPatternOperations extends AbstractQVTCoreOperations
{
	public static BottomPatternOperations INSTANCE = new BottomPatternOperations();

	/**
	 * Validates the RealizedVariableNamesAreUnique constraint of '<em>Bottom Pattern</em>'.
	 */
	public boolean checkRealizedVariableNamesAreUnique(BottomPattern bottomPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EList<RealizedVariable> myVariables = bottomPattern.getRealizedVariable();
		List<List<Variable>> conflicts = findVariableNameConflicts(bottomPattern, myVariables);
		if (conflicts.size() > 0) {
			for (List<Variable> conflict : conflicts) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(conflict.get(1), context) };
				appendWarning(diagnostics, conflict.get(0), QVTCoreMessages._UI_BottomPattern_RealizedVariableNameIsNotUnique, messageSubstitutions);
			}
			return false;
		}
		return true;
	}
}