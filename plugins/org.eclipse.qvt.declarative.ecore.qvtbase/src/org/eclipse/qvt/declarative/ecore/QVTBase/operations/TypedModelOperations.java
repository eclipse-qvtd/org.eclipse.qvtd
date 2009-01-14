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
 * $Id: TypedModelOperations.java,v 1.2 2009/01/14 21:01:33 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;

public class TypedModelOperations extends AbstractQVTBaseOperations
{
	public static TypedModelOperations INSTANCE = new TypedModelOperations();

	/**
	 * Validates the DependsOnIsAcyclic constraint of '<em>Typed Model</em>'.
	 */
	public boolean checkDependsOnIsAcyclic(TypedModel typedModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Set<TypedModel> allDependsOn = getAllDependsOn(typedModel);
		if (!allDependsOn.contains(typedModel))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(typedModel, context) };
		appendError(diagnostics, typedModel, QVTBaseMessages._UI_TypedModel_DependsOnContainsACycle, messageSubstitutions);
		return false;
	}

	public Set<TypedModel> computeAllDependsOn(List<TypedModel> typedModels, Set<TypedModel> allDependsOn) {
		for (TypedModel typedModel : typedModels) {
			if (allDependsOn.add(typedModel))
				computeAllDependsOn(typedModel.getDependsOn(), allDependsOn);		
		}
		return allDependsOn;
	}

	public Set<TypedModel> getAllDependsOn(TypedModel typedModel) {
		return computeAllDependsOn(typedModel.getDependsOn(), new HashSet<TypedModel>());
	}

	public Set<EPackage> getDeclaredPackages(TypedModel typedModel) {
		Set<EPackage> declaredPackages = new HashSet<EPackage>(typedModel.getUsedPackage());
		Set<TypedModel> allDependsOn = getAllDependsOn(typedModel);
		for (TypedModel dependsOn : allDependsOn)
			declaredPackages.addAll(dependsOn.getUsedPackage());
		return declaredPackages;
	}
}