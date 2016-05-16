/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;

/**
 * AssignmentComparator supports sorting an assignment list into VariableAssignments first, least dependent first, alphabetical order.
 */
public class AssignmentComparator implements Comparator<@NonNull Assignment> 
{
	private final @NonNull List<@NonNull Assignment> assignments;
	private @Nullable Map<@NonNull Variable, @NonNull Set<@NonNull Variable>> variable2referencedVariables = null;

	public AssignmentComparator(@NonNull List<@NonNull Assignment> assignments) {
		this.assignments = assignments;
	}

	@Override
	public int compare(@NonNull Assignment o1, @NonNull Assignment o2) {
		if (o1 instanceof PropertyAssignment) {
			if (o2 instanceof PropertyAssignment) {
				Property p1 = ((PropertyAssignment)o1).getTargetProperty();
				Property p2 = ((PropertyAssignment)o2).getTargetProperty();
				String n1 = p1.getName();
				String n2 = p2.getName();
				int diff = ClassUtil.safeCompareTo(n1, n2);
				if (diff != 0) {
					return diff;
				}
				n1 = p1.toString();
				n2 = p2.toString();
				return ClassUtil.safeCompareTo(n1, n2);
			}
			else {
				return 1;
			}
		}
		else if (o1 instanceof VariableAssignment) {
			if (o2 instanceof PropertyAssignment) {
				return -1;
			}
			else if (o2 instanceof VariableAssignment) {
				Map<@NonNull Variable, @NonNull Set<@NonNull Variable>> variable2referencedVariables2 = variable2referencedVariables;
				if (variable2referencedVariables2 == null) {
					variable2referencedVariables2 = variable2referencedVariables = computeReferencedVariableClosure();
				}
				Variable v1 = ((VariableAssignment)o1).getTargetVariable();
				Variable v2 = ((VariableAssignment)o2).getTargetVariable();
				Set<@NonNull Variable> r1 = variable2referencedVariables2.get(v1);
				Set<@NonNull Variable> r2 = variable2referencedVariables2.get(v2);
				assert (r1 != null) && (r2 != null);
				int diff = r1.size() - r2.size();
				if (diff != 0) {
					return diff;
				}
				String n1 = v1.getName();
				String n2 = v2.getName();
				return ClassUtil.safeCompareTo(n1, n2);
			}
		}
		return 0;
	}

	private @NonNull Map<@NonNull Variable, @NonNull Set<@NonNull Variable>> computeReferencedVariableClosure() {
		Map<@NonNull Variable, @NonNull Set<@NonNull Variable>> variable2referencedVariables2;
		variable2referencedVariables2 = new HashMap<@NonNull Variable, @NonNull Set<@NonNull Variable>>();
		//
		//	Compute the direct references of each variable
		//
		for (@NonNull Assignment assignment : assignments) {
			if (assignment instanceof VariableAssignment) {
				VariableAssignment variableAssignment = (VariableAssignment)assignment;
				Variable variable = ClassUtil.nonNullState(variableAssignment.getTargetVariable());
				Set<@NonNull Variable> referencedVariables = new HashSet<@NonNull Variable>();
				for (EObject eObject : new TreeIterable(ClassUtil.nonNullState(variableAssignment.getValue()), true)) {
					if (eObject instanceof VariableExp) {
						VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
						if (referredVariable instanceof Variable) {
							referencedVariables.add((Variable)referredVariable);
						}
					}
					else if (eObject instanceof Variable) {
						referencedVariables.add((Variable)eObject);
					}
				}
				variable2referencedVariables2.put(variable, referencedVariables);
			}
		}
		//
		//	Aggregate the closure
		//
		while (true) {
			boolean more = false;
			for (@NonNull Variable variable : variable2referencedVariables2.keySet()) {
				Set<@NonNull Variable> referencedVariables = variable2referencedVariables2.get(variable);
				assert referencedVariables != null;
				for (@NonNull Variable referencedVariable : new ArrayList<@NonNull Variable>(referencedVariables)) {
					Set<@NonNull Variable> referencedReferencedVariables = variable2referencedVariables2.get(referencedVariable);
					if ((referencedReferencedVariables != null) && referencedVariables.addAll(referencedReferencedVariables)) {
						more = true;
					}
				}
			}
			if (!more) {
				break;
			}
		}
		return variable2referencedVariables2;
	}
}