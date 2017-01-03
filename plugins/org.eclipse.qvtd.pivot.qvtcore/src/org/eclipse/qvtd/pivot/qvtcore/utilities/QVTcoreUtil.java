/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;

public class QVTcoreUtil extends QVTbaseUtil
{
	protected static class PatternVariableComparator implements Comparator<@NonNull Variable>
	{
		private final @NonNull Map<@NonNull Variable, @Nullable List<@NonNull VariableDeclaration>> def2refs;

		protected PatternVariableComparator(@NonNull Map<@NonNull Variable, @Nullable List<@NonNull VariableDeclaration>> def2refs) {
			this.def2refs = def2refs;
		}

		@Override
		public int compare(@NonNull Variable o1, @NonNull Variable o2) {
			List<@NonNull VariableDeclaration> l1 = def2refs.get(o1);
			List<@NonNull VariableDeclaration> l2 = def2refs.get(o2);
			int s1 = l1 != null ? l1.size() : 0;
			int s2 = l2 != null ? l2.size() : 0;
			if (s1 != s2) {
				return s1 - s2;
			}
			String n1 = o1.getName();
			String n2 = o2.getName();
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static @Nullable TypedModel basicGetTypedModel(@Nullable Area area) {
		if (area instanceof CoreDomain) {
			return ((CoreDomain)area).getTypedModel();
		}
		else {
			return null;
		}
	}

	public static @NonNull Set<Mapping> getAllRefinedMappings(@NonNull Mapping mapping) {
		return getAllRefinedMappings(new HashSet<Mapping>(), mapping);
	}

	private static @NonNull Set<Mapping> getAllRefinedMappings(@NonNull Set<Mapping> allMappings, @NonNull Mapping mapping) {
		if (allMappings.add(mapping)) {
			for (@SuppressWarnings("null")@NonNull Mapping refinedMapping : mapping.getSpecification()) {
				getAllRefinedMappings(allMappings, refinedMapping);
			}
		}
		return allMappings;
	}

	public static @NonNull Area getArea(@NonNull Mapping mapping, @NonNull TypedModel typedModel) {
		for (Domain domain : mapping.getDomain()) {
			if (domain.getTypedModel() == typedModel) {
				return (CoreDomain)domain;
			}
		}
		return mapping;
	}

	public static @NonNull BottomPattern getBottomPattern(@NonNull Area area) {
		return ClassUtil.nonNullState(area.getBottomPattern());
	}

	public static @Nullable Area getContainingArea(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Area) {
				return (Area) eObject;
			}
		}
		return null;
	}

	public static @Nullable Mapping getContainingMapping(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Mapping) {
				return (Mapping) eObject;
			}
		}
		return null;
	}

	public static @Nullable CorePattern getContainingPattern(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof CorePattern) {
				return (CorePattern) eObject;
			}
		}
		return null;
	}

	public static @Nullable CoreDomain getDomain(@NonNull Mapping rule, @NonNull TypedModel typedModel) {
		return (CoreDomain)getDomain((Rule)rule, typedModel);
	}

	public static @NonNull GuardPattern getGuardPattern(@NonNull Area area) {
		return ClassUtil.nonNullState(area.getGuardPattern());
	}

	public static @NonNull List<@NonNull Assignment> getOwnedAssignments(@NonNull BottomPattern bottomPattern) {
		return ClassUtil.nullFree(bottomPattern.getAssignment());
	}

	public static @NonNull List<@NonNull RealizedVariable> getOwnedRealizedVariables(@NonNull BottomPattern bottomPattern) {
		return ClassUtil.nullFree(bottomPattern.getRealizedVariable());
	}

	public static @NonNull List<@NonNull Variable> getOwnedVariables(@NonNull CorePattern corePattern) {
		return ClassUtil.nullFree(corePattern.getVariable());
	}

	public static @NonNull Property getTargetProperty(@NonNull NavigationAssignment asNavigationAssignment) {
		if (asNavigationAssignment instanceof PropertyAssignment) {
			return ClassUtil.nonNullState(((PropertyAssignment)asNavigationAssignment).getTargetProperty());
		}
		else if (asNavigationAssignment instanceof OppositePropertyAssignment) {
			Property referredProperty = ClassUtil.nonNullState(((OppositePropertyAssignment)asNavigationAssignment).getTargetProperty());
			return ClassUtil.nonNullState(referredProperty.getOpposite());
		}
		throw new UnsupportedOperationException("Unsupported " + asNavigationAssignment.eClass().getName());
	}

	public static @NonNull Transformation loadTransformation(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
		try {
			return loadTransformation(CoreModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}

	public static @NonNull Resource loadTransformations(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
		try {
			return loadTransformations(CoreModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}

	/**
	 * Sort the pattern variables into a least referenced foirst then alphabetical order.
	 */
	public static void sortPatternVariables(@NonNull List<@NonNull Variable> variables) {
		if (variables.size() > 1) {
			final Map<@NonNull Variable, @Nullable List<@NonNull VariableDeclaration>> def2refs = new HashMap<@NonNull Variable, @Nullable List<@NonNull VariableDeclaration>>();
			//
			// Initialize the def2refs.keySet as a fast is-a-pattern-variable lookup.
			//
			for (@NonNull Variable variable : variables) {
				def2refs.put(variable, null);
			}
			//
			// Initialize the def2refs.values with the directly referenced pattern variables.
			//
			for (@NonNull Variable variable : variables) {
				List<@NonNull VariableDeclaration> refs = null;
				OCLExpression initExpression = variable.getOwnedInit();
				if (initExpression != null) {
					for (@NonNull EObject eObject : new TreeIterable(initExpression, true)) {
						if (eObject instanceof VariableExp) {
							VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
							assert referredVariable != null;
							if (def2refs.containsKey(referredVariable)) {
								if (refs == null) {
									refs = new ArrayList<@NonNull VariableDeclaration>();
									def2refs.put(variable, refs);
								}
								if (!refs.contains(referredVariable)) {
									refs.add(referredVariable);
								}
							}
						}
					}
				}
			}
			//
			// Recursively expand the def2refs.values to the closure of the directly referenced pattern variables.
			//
			boolean changed = true;
			while (changed) {
				changed = false;
				for (@NonNull Variable variable : def2refs.keySet()) {
					List<@NonNull VariableDeclaration> refs = def2refs.get(variable);
					if (refs != null) {
						for (int i = 0; i < refs.size(); i++) {
							VariableDeclaration ref = refs.get(i);
							List<@NonNull VariableDeclaration> refRefs = def2refs.get(ref);
							if (refRefs != null) {
								for (@NonNull VariableDeclaration refRef : refRefs) {
									if (!refs.contains(refRef)) {
										refs.add(refRef);
										changed = true;
									}
								}
							}
						}
					}
				}
			}
			//
			// Sort the variables fewest references first then alphabetically.
			//
			ClassUtil.sort(variables, new PatternVariableComparator(def2refs));
		}
	}
}