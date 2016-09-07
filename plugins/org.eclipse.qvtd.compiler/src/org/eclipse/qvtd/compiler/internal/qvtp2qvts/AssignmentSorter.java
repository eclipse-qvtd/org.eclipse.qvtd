/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;

/**
 * AssignmentSorter supports ordering the incoming Assignments so that they can be converted to QVTs form
 * directly; reads before assigns ensuring that computational chains are not polluted by GREENs as a
 * consequence of assignment of intermediate computations.
 */
public class AssignmentSorter
{
	public static final class ToStringComparator implements Comparator<@NonNull Object>
	{
		public static final @NonNull ToStringComparator INSTANCE = new ToStringComparator();

		@Override
		public int compare(@NonNull Object o1, @NonNull Object o2) {
			String s1 = o1.toString();
			String s2 = o2.toString();
			return ClassUtil.safeCompareTo(s1, s2);
		}
	}

	private static @Nullable Variable getTargetVariable(@NonNull NavigationAssignment navigationAssignment) {
		OCLExpression slotExpression = navigationAssignment.getSlotExpression();
		if (slotExpression instanceof VariableExp) {
			VariableExp variableExp = (VariableExp)slotExpression;
			Variable targetVariable = (Variable) variableExp.getReferredVariable();
			assert targetVariable != null;
			return targetVariable;
		}
		else {
			return null;		// FIXME Adolfo's folded middle uses complex casts lhs'
		}
	}

	/**
	 * Nested Map for each known NavigationAssignment from each RealizedVariable to its Property to the NavigationAssignment.
	 * 	FIXME Not RealizedVariable becuase of Adolfo's folded middle
	 */
	protected final @NonNull Map<@NonNull Variable, @NonNull Map<@NonNull Property, @NonNull NavigationAssignment>> realizedVariable2property2navigationAssignment = new HashMap<>();

	/**
	 * Nested Map for each known VariableAssignment from each Variable to the VariableAssignment.
	 */
	protected final @NonNull Map<@NonNull Variable, @NonNull VariableAssignment> variable2variableAssignment = new HashMap<>();

	/**
	 * FIXME List of too-complex assignments that OCL2QVTp produces; just tack them on at the end.
	 */
	protected final @NonNull List<@NonNull Assignment> otherAssignments = new ArrayList<>();

	/**
	 * Asd all assignments to the Set of assignments to be sorted.
	 */
	public void addAll(@NonNull Iterable<@NonNull Assignment> assignments) {
		for (@NonNull Assignment assignment : assignments) {
			if (assignment instanceof VariableAssignment) {
				VariableAssignment variableAssignment = (VariableAssignment) assignment;
				Variable targetVariable = variableAssignment.getTargetVariable();
				if (targetVariable != null) {
					VariableAssignment oldAssignment = variable2variableAssignment.put(targetVariable, variableAssignment);
					assert oldAssignment == null;
				}
			}
			else if (assignment instanceof NavigationAssignment) {
				NavigationAssignment navigationAssignment = (NavigationAssignment) assignment;
				Variable targetVariable = getTargetVariable(navigationAssignment);
				if (targetVariable != null) {
					Map<@NonNull Property, @NonNull NavigationAssignment> property2navigationAssignable = realizedVariable2property2navigationAssignment.get(targetVariable);
					if (property2navigationAssignable == null) {
						property2navigationAssignable = new HashMap<>();
						realizedVariable2property2navigationAssignment.put(targetVariable, property2navigationAssignable);
					}
					Property targetProperty = QVTcoreUtil.getTargetProperty(navigationAssignment);
					NavigationAssignment oldAssignment = property2navigationAssignable.put(targetProperty, navigationAssignment);
					assert oldAssignment == null;
				}
				else {
					otherAssignments.add(assignment);
				}
			}
			else {
				throw new IllegalStateException("Unknown Assignment class " + assignment.getClass().getName());
			}
		}
	}

	/**
	 * Return a Map from each target assignment to the source assignments that are used to compute the value of the target.
	 */
	protected @NonNull Map<@NonNull Assignment, Set<@NonNull Assignment>> gatherSourceAssignables(@NonNull Iterable<@NonNull Assignment> assignments) {
		Map<@NonNull Assignment, Set<@NonNull Assignment>> targetAssignment2sourceAssignments = new HashMap<>();
		for (@NonNull Assignment assignment : assignments) {
			Set<@NonNull Assignment> assignmentReferences = new HashSet<>();
			OCLExpression value = assignment.getValue();
			assert value != null;
			for (@NonNull EObject eObject : new TreeIterable(value, true)) {
				if (eObject instanceof NavigationCallExp) {
					NavigationCallExp navigationCallExp = (NavigationCallExp)eObject;
					OCLExpression sourceExpression = navigationCallExp.getOwnedSource();
					if (sourceExpression instanceof VariableExp) {
						VariableDeclaration referredVariable = ((VariableExp)sourceExpression).getReferredVariable();
						if (referredVariable instanceof RealizedVariable) {
							Map<@NonNull Property, @NonNull NavigationAssignment> property2navigationAssignment = realizedVariable2property2navigationAssignment.get(referredVariable);
							if (property2navigationAssignment != null) {
								Property property = PivotUtil.getReferredProperty(navigationCallExp);
								NavigationAssignment navigationAssignment = property2navigationAssignment.get(property);
								if (navigationAssignment != null) {
									assignmentReferences.add(navigationAssignment);
								}
							}
						}
					}
				}
				else if (eObject instanceof VariableExp) {
					VariableExp variableExp = (VariableExp)eObject;
					VariableDeclaration referredVariable = variableExp.getReferredVariable();
					VariableAssignment variableAssignment = variable2variableAssignment.get(referredVariable);
					if (variableAssignment != null) {
						assignmentReferences.add(variableAssignment);
					}
				}
			}
			targetAssignment2sourceAssignments.put(assignment, assignmentReferences);
		}
		return targetAssignment2sourceAssignments;
	}
	protected void gatherSourceAssignables(@NonNull Map<@NonNull Assignment, Set<@NonNull Assignment>> targetAssignment2sourceAssignments, @NonNull Iterable<@NonNull ? extends Assignment> assignments) {
		for (@NonNull Assignment assignment : assignments) {
			Set<@NonNull Assignment> assignmentReferences = new HashSet<>();
			OCLExpression value = assignment.getValue();
			assert value != null;
			for (@NonNull EObject eObject : new TreeIterable(value, true)) {
				if (eObject instanceof NavigationCallExp) {
					NavigationCallExp navigationCallExp = (NavigationCallExp)eObject;
					OCLExpression sourceExpression = navigationCallExp.getOwnedSource();
					if (sourceExpression instanceof VariableExp) {
						VariableDeclaration referredVariable = ((VariableExp)sourceExpression).getReferredVariable();
						if (referredVariable.eContainer() instanceof CorePattern) {
							Map<@NonNull Property, @NonNull NavigationAssignment> property2navigationAssignment = realizedVariable2property2navigationAssignment.get(referredVariable);
							if (property2navigationAssignment != null) {
								Property property = PivotUtil.getReferredProperty(navigationCallExp);
								NavigationAssignment navigationAssignment = property2navigationAssignment.get(property);
								if (navigationAssignment != null) {
									assignmentReferences.add(navigationAssignment);
								}
							}
						}
					}
				}
				else if (eObject instanceof VariableExp) {
					VariableExp variableExp = (VariableExp)eObject;
					VariableDeclaration referredVariable = variableExp.getReferredVariable();
					VariableAssignment variableAssignment = variable2variableAssignment.get(referredVariable);
					if (variableAssignment != null) {
						assignmentReferences.add(variableAssignment);
					}
				}
			}
			targetAssignment2sourceAssignments.put(assignment, assignmentReferences);
		}
	}

	/**
	 * Return the assignments in a less dependent-first stable order.
	 *
	 * Throws IllegalStateException if there is a cyclic dependency.
	 */
	public @NonNull Iterable<@NonNull Assignment> getSortedAssignments() {
		Map<@NonNull Assignment, Set<@NonNull Assignment>> targetAssignment2sourceAssignments = new HashMap<>();
		gatherSourceAssignables(targetAssignment2sourceAssignments, variable2variableAssignment.values());
		for (@NonNull Map<@NonNull Property, @NonNull NavigationAssignment> property2navigationAssignment : realizedVariable2property2navigationAssignment.values()) {
			gatherSourceAssignables(targetAssignment2sourceAssignments, property2navigationAssignment.values());
		}
		List<@NonNull Assignment> sortedAssignments = new ArrayList<>();
		Set<@NonNull Assignment> targetAssignments = new HashSet<>(targetAssignment2sourceAssignments.keySet());
		while (targetAssignments.size() > 0) {
			List<@NonNull Assignment> resolvedAssignments = new ArrayList<>();
			for (@NonNull Assignment targetAssignment : targetAssignments) {
				Set<@NonNull Assignment> sourceAssignments = targetAssignment2sourceAssignments.get(targetAssignment);
				assert sourceAssignments != null;
				Set<@NonNull Assignment> unresolvedAssignments = new HashSet<>(sourceAssignments);
				unresolvedAssignments.removeAll(sortedAssignments);
				if (unresolvedAssignments.isEmpty()) {
					resolvedAssignments.add(targetAssignment);
				}
			}
			if (resolvedAssignments.isEmpty()) {
				throw new IllegalStateException("Cyclic assignment dependency " + targetAssignments);
			}
			Collections.sort(resolvedAssignments, ToStringComparator.INSTANCE);
			sortedAssignments.addAll(resolvedAssignments);
			targetAssignments.removeAll(resolvedAssignments);
		}
		sortedAssignments.addAll(otherAssignments);
		return sortedAssignments;
	}
}
