/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
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
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory.Strategy;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;
import com.google.common.collect.Iterables;

public class QVTcoreUtil extends QVTbaseUtil
{
	public static class Internal extends QVTbaseUtil.Internal
	{
		public static @NonNull List<@NonNull Assignment> getOwnedAssignmentsList(@NonNull BottomPattern mBottomPattern) {
			return ClassUtil.nullFree(mBottomPattern.getAssignment());
		}
	}

	protected static class PatternVariableComparator implements Comparator<@NonNull VariableDeclaration>
	{
		private final @NonNull Map<@NonNull VariableDeclaration, @Nullable List<@NonNull VariableDeclaration>> def2refs;

		protected PatternVariableComparator(@NonNull Map<@NonNull VariableDeclaration, @Nullable List<@NonNull VariableDeclaration>> def2refs) {
			this.def2refs = def2refs;
		}

		@Override
		public int compare(@NonNull VariableDeclaration o1, @NonNull VariableDeclaration o2) {
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

	public static @Nullable CoreDomain basicGetDomain(@NonNull Mapping rule, @NonNull TypedModel typedModel) {
		return (CoreDomain)basicGetDomain((Rule)rule, typedModel);
	}

	public static @Nullable Mapping basicGetOverridden(@NonNull Mapping asMapping) {
		return (Mapping) asMapping.getOverridden();
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

	public static @NonNull CoreDomain getDomain(@NonNull Mapping rule, @NonNull TypedModel typedModel) {
		return (CoreDomain)getDomain((Rule)rule, typedModel);
	}

	public static @NonNull GuardPattern getGuardPattern(@NonNull Area area) {
		return ClassUtil.nonNullState(area.getGuardPattern());
	}

	public static @NonNull Iterable<@NonNull Assignment> getOwnedAssignments(@NonNull BottomPattern bottomPattern) {
		return ClassUtil.nullFree(bottomPattern.getAssignment());
	}

	public static @NonNull Iterable<@NonNull CoreDomain> getOwnedDomains(@NonNull Mapping mapping) {
		return Iterables.filter(ClassUtil.nullFree(mapping.getDomain()), CoreDomain.class);
	}

	public static @NonNull Iterable<@NonNull RealizedVariable> getOwnedRealizedVariables(@NonNull BottomPattern bottomPattern) {
		return ClassUtil.nullFree(bottomPattern.getRealizedVariable());
	}

	public static @NonNull Iterable<@NonNull VariableDeclaration> getOwnedVariables(@NonNull CorePattern corePattern) {
		return ClassUtil.nullFree(corePattern.getOwnedVariables());
	}

	public static @NonNull OCLExpression getSlotExpression(@NonNull NavigationAssignment asNavigationAssignment) {
		return ClassUtil.nonNullState(asNavigationAssignment.getSlotExpression());
	}

	public static @NonNull Property getTargetProperty(@NonNull NavigationAssignment asNavigationAssignment) {
		if (asNavigationAssignment instanceof PropertyAssignment) {
			return ClassUtil.nonNullState(((PropertyAssignment)asNavigationAssignment).getTargetProperty());
		}
		else if (asNavigationAssignment instanceof OppositePropertyAssignment) {
			Property referredProperty = ClassUtil.nonNullState(((OppositePropertyAssignment)asNavigationAssignment).getTargetProperty());
			if (referredProperty.eIsProxy() ) {
				throw new IllegalStateException("Unresolved target property proxy '" + EcoreUtil.getURI(referredProperty) + "' at '" + EcoreUtil.getURI(asNavigationAssignment) + "'");
			}
			return ClassUtil.nonNullState(referredProperty.getOpposite());
		}
		throw new UnsupportedOperationException("Unsupported " + asNavigationAssignment.eClass().getName());
	}

	public static @NonNull VariableDeclaration getTargetVariable(@NonNull VariableAssignment variableAssignment) {
		return ClassUtil.nonNullState(variableAssignment.getTargetVariable());
	}

	public static @NonNull OCLExpression getValue(@NonNull Assignment asAssignment) {
		return ClassUtil.nonNullState(asAssignment.getValue());
	}

	public static @NonNull Transformation loadTransformation(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		Strategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
		try {
			return loadTransformation(CoreModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}

	public static @NonNull ASResource loadTransformations(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		Strategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
		try {
			ASResource asResource = loadTransformations(CoreModel.class, environmentFactory, transformationURI, keepDebug);
			List<@NonNull TypedModel> missingIsTraces = rewriteMissingTypedModelIsTrace(environmentFactory, asResource);
			if (missingIsTraces != null) {
				QVTruntimeUtil.errPrintln("TypedModel.isTrace fixed up for '" + transformationURI + "'");
			}
			return asResource;
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}

	/**
	 * Rewrite asResource to ensure null-named TypedModel s are isImplicit.
	 */
	public static @Nullable List<@NonNull TypedModel> rewriteMissingTypedModelIsTrace(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource asResource) {
		QVTcoreHelper helper = null;
		List<@NonNull TypedModel> missingImplicits = null;
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Transformation) {
				Transformation asTransformation = (Transformation)eObject;
				List<@NonNull TypedModel> modelParameters = Internal.getModelParameterList(asTransformation);
				TypedModel primitiveTypedModel = QVTbaseUtil.basicGetPrimitiveTypedModel(modelParameters);
				if (primitiveTypedModel == null) {
					if (helper == null) {
						helper = new QVTcoreHelper(environmentFactory);
					}
					modelParameters.add(0, helper.createPrimitiveTypedModel());
				}
			}
			else if (eObject instanceof TypedModel) {
				TypedModel typedModel = (TypedModel)eObject;
				if ((typedModel.getName() == null) && !typedModel.isIsTrace()) {
					if (missingImplicits == null) {
						missingImplicits = new ArrayList<>();
					}
					missingImplicits.add(typedModel);
					typedModel.setIsTrace(true);
				}
			}
		}
		return missingImplicits;
	}

	/**
	 * Sort the pattern variables into a least referenced first then alphabetical order.
	 */
	public static void sortPatternVariables(@NonNull List<@NonNull VariableDeclaration> variables) {
		if (variables.size() > 1) {
			final Map<@NonNull VariableDeclaration, @Nullable List<@NonNull VariableDeclaration>> def2refs = new HashMap<>();
			//
			// Initialize the def2refs.keySet as a fast is-a-pattern-variable lookup.
			//
			for (@NonNull VariableDeclaration variable : variables) {
				def2refs.put(variable, null);
			}
			//
			// Initialize the def2refs.values with the directly referenced pattern variables.
			//
			for (@NonNull VariableDeclaration variable : variables) {
				if (variable instanceof Variable) {
					List<@NonNull VariableDeclaration> refs = null;
					OCLExpression initExpression = ((Variable)variable).getOwnedInit();
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
			}
			//
			// Recursively expand the def2refs.values to the closure of the directly referenced pattern variables.
			//
			boolean changed = true;
			while (changed) {
				changed = false;
				for (@NonNull VariableDeclaration variable : def2refs.keySet()) {
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