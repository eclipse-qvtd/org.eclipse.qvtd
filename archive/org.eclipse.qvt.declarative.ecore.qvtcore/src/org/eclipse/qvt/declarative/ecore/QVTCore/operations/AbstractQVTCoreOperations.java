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
 * $Id: AbstractQVTCoreOperations.java,v 1.1 2008/12/31 17:42:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.AbstractQVTBaseOperations;
import org.eclipse.qvt.declarative.ecore.QVTCore.CorePattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.util.QVTCoreValidator;

public class AbstractQVTCoreOperations extends AbstractQVTBaseOperations
{
	public static final String DIAGNOSTIC_SOURCE = QVTCoreValidator.INSTANCE.getDiagnosticSource();

	protected AbstractQVTCoreOperations() {
		super(QVTCoreValidator.INSTANCE);
	}
		
	/**
	 * @generated NOT
	 */
	protected List<List<Variable>> findVariableNameConflicts(CorePattern corePattern, EList<? extends Variable> myVariables) {
		List<List<Variable>> conflicts = Collections.emptyList();
		if (myVariables.size() > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			EList<Variable> allVariables = corePattern.getAllVariables();
			for (Variable variable : allVariables) {
				String key = variable.getName();
				Object entry = map.get(key);
				if (entry == null)
					map.put(key, variable);
				else {
					List<Variable> list = null;
					if (entry instanceof Variable) {
						list = new ArrayList<Variable>();
						list.add((Variable) entry);
						map.put(key, list);
						if (myVariables.contains(entry)) {
							if (conflicts.size() <= 0)
								conflicts = new ArrayList<List<Variable>>();
							conflicts.add(list);
						}
					}
					else {
						@SuppressWarnings("unchecked")
						List<Variable> castList = (List<Variable>) entry;
						list = castList;
					}
					if (myVariables.contains(variable)) {
						if (conflicts.size() <= 0)
							conflicts = new ArrayList<List<Variable>>();
						conflicts.add(list);
						list.add(0, variable);
					}
					else
						list.add(variable);
				}
			}
		}
		return conflicts;
	}
	
	@Override
	public QVTCoreValidator getValidator() {
		return (QVTCoreValidator) validator;
	}

}