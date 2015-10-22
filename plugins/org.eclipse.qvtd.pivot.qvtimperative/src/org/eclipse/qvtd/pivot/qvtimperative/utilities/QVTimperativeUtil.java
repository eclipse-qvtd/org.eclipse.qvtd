/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;

public class QVTimperativeUtil extends QVTcoreBaseUtil
{
    /** The name of the root mapping */
	public static final @NonNull String ROOT_MAPPING_NAME = "__root__";

	public static final class MappingCallBindingComparator implements Comparator<MappingCallBinding>
	{
		public static final @NonNull MappingCallBindingComparator INSTANCE = new MappingCallBindingComparator();

		@Override
		public int compare(MappingCallBinding o1, MappingCallBinding o2) {
			Variable v1 = o1.getBoundVariable();
			Variable v2 = o2.getBoundVariable();
			String n1 = v1 != null ? v1.getName() : null;
			String n2 = v2 != null ? v2.getName() : null;
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static @Nullable Mapping getContainingMapping(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Mapping) {
				return (Mapping) eObject;
			}
		}
		return null;
	}

	/**
	 * Return a copy of asVariablePredicates sorted to avoid reverse references from the predicate expressions.
	 */
	public static @NonNull List<VariablePredicate> sortVariablePredicates(@NonNull Mapping asMapping, @NonNull List<VariablePredicate> asVariablePredicates) {
		Set<Variable> asGuardVariables = new HashSet<Variable>();
		asGuardVariables.addAll(asMapping.getGuardPattern().getVariable());
		for (Domain asDomain : asMapping.getDomain()) {
			asGuardVariables.addAll(((CoreDomain)asDomain).getGuardPattern().getVariable());
		}
		List<VariableDeclaration> pendingVariables = new ArrayList<VariableDeclaration>();
		Map<VariableDeclaration, VariablePredicate> variable2predicate = new HashMap<VariableDeclaration, VariablePredicate>();
		Map<VariableDeclaration, Set<VariablePredicate>> variable2predicates = new HashMap<VariableDeclaration, Set<VariablePredicate>>();
		Map<VariablePredicate, Set<VariableDeclaration>> predicate2variables = new HashMap<VariablePredicate, Set<VariableDeclaration>>();
		for (VariablePredicate asVariablePredicate : asVariablePredicates) {
			for (TreeIterator<EObject> tit = asVariablePredicate.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof VariableExp) {
					VariableDeclaration asVariable = ((VariableExp)eObject).getReferredVariable();
					if ((asVariable != null) && asGuardVariables.contains(asVariable)) {
						Set<VariablePredicate> predicates = variable2predicates.get(asVariable);
						if (predicates == null){
							predicates = new HashSet<VariablePredicate>();
							variable2predicates.put(asVariable, predicates);
						}
						predicates.add(asVariablePredicate);
						Set<VariableDeclaration> variables = predicate2variables.get(asVariablePredicate);
						if (variables == null){
							variables = new HashSet<VariableDeclaration>();
							predicate2variables.put(asVariablePredicate, variables);
						}
						variables.add(asVariable);
						pendingVariables.add(asVariablePredicate.getTargetVariable());
						variable2predicate.put(asVariablePredicate.getTargetVariable(), asVariablePredicate);
					}
				}
			}
		}
		int oldSize;
		List<VariablePredicate> asSortedVariablePredicates = new ArrayList<VariablePredicate>();
		Collections.sort(pendingVariables, NameUtil.NAMEABLE_COMPARATOR);		// Ensure deterministic order
		while (pendingVariables.size() > 0) {
			oldSize = asSortedVariablePredicates.size();
			for (VariableDeclaration asVariable : pendingVariables) {
				VariablePredicate asVariablePredicate1 = variable2predicate.get(asVariable);
				Set<VariableDeclaration> variables = predicate2variables.get(asVariablePredicate1);
				variables.retainAll(pendingVariables);
				if (variables.size() <= 0) {
					asSortedVariablePredicates.add(asVariablePredicate1);
					Set<VariablePredicate> predicates = variable2predicates.get(asVariable);
					if (predicates != null) {
						for (VariablePredicate asVariablePredicate2 : predicates) {
							predicate2variables.get(asVariablePredicate2).remove(asVariable);
						}
					}
					pendingVariables.remove(asVariable);
					predicate2variables.remove(asVariablePredicate1);
					break;
				}
			}
			if (asSortedVariablePredicates.size() == oldSize) {
				for (VariablePredicate asVariablePredicate : predicate2variables.keySet()) {
					asSortedVariablePredicates.add(asVariablePredicate);
				}
				break;			// FIXME error message for cycle 
			}
		}
		return asSortedVariablePredicates;
	}
}