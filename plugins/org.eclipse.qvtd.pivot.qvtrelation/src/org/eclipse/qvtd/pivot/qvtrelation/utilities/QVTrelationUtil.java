/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TraceHelper;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.EnvironmentStrategy;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateUtil;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;
import com.google.common.collect.Iterables;

public class QVTrelationUtil extends QVTtemplateUtil
{
	public static class Internal extends QVTtemplateUtil.Internal
	{
		public static @NonNull List<@NonNull Variable> getBindsToList(@NonNull DomainPattern rDomainPattern) {
			return ClassUtil.nullFree(rDomainPattern.getBindsTo());
		}

		public static @NonNull List<@NonNull OCLExpression> getOwnedArgumentsList(@NonNull RelationCallExp rInvocation) {
			return ClassUtil.nullFree(rInvocation.getArgument());
		}

		public static @NonNull List<@NonNull Domain> getOwnedDomainsList(@NonNull Relation rRelation) {
			return ClassUtil.nullFree(rRelation.getDomain());
		}

		public static @NonNull List<@NonNull Key> getOwnedKeysList(@NonNull RelationalTransformation rRelationalTransformation) {
			return ClassUtil.nullFree(rRelationalTransformation.getOwnedKey());
		}

		public static @NonNull List<@NonNull Property> getOwnedPartsList(@NonNull Key rKey) {
			return ClassUtil.nullFree(rKey.getPart());
		}

		public static @NonNull List<@NonNull Rule> getOwnedRelationsList(@NonNull RelationalTransformation rRelationalTransformation) {
			return ClassUtil.nullFree(rRelationalTransformation.getRule());
		}

		public static @NonNull List<@NonNull Variable> getOwnedVariablesList(@NonNull Relation rRelation) {
			return ClassUtil.nullFree(rRelation.getVariable());
		}
	}

	public static final class KeyComparator implements Comparator<@NonNull Key>
	{
		public static final @NonNull KeyComparator INSTANCE = new KeyComparator();

		@Override
		public int compare(@NonNull Key o1, @NonNull Key o2) {
			String n1 = getName(getIdentifies(o1));
			String n2 = getName(getIdentifies(o2));
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static final class RelationCallExpComparator implements Comparator<@NonNull RelationCallExp>
	{
		public static final @NonNull RelationCallExpComparator INSTANCE = new RelationCallExpComparator();

		@Override
		public int compare(@NonNull RelationCallExp o1, @NonNull RelationCallExp o2) {
			String n1 = getName(getReferredRelation(o1));
			String n2 = getName(getReferredRelation(o2));
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static final @NonNull String DUMMY_VARIABLE_NAME = "_";

	public static @Nullable RelationDomain basicGetContainingRelationDomain(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof RelationDomain) {
				return (RelationDomain) eObject;
			}
		}
		return null;
	}

	public static @Nullable Relation basicGetOverridden(@NonNull Relation relation) {
		return (Relation) relation.getOverridden();
	}

	public static @Nullable RelationDomain basicGetRelationDomain(@NonNull Relation qvtrRelation, @Nullable TypedModel typedModel) {
		for (@NonNull RelationDomain rRelationDomain : getOwnedDomains(qvtrRelation)) {
			if (rRelationDomain.getTypedModel() == typedModel) {
				return rRelationDomain;
			}
		}
		return null;
	}

	/*	public static @NonNull Iterable<@NonNull Relation> getAllOverrides(@NonNull Relation rRelation) {
		Set<@NonNull Relation> allOverrides = new HashSet<>();
		Collection<@NonNull Relation> moreOverrides = Collections.singletonList(rRelation);
		while (moreOverrides != null) {
			List<@NonNull Relation> yetMoreOverrides = null;
			for (@NonNull Relation aRelation : moreOverrides) {
				for (@NonNull Relation anOverride : getOverrides(aRelation)) {
					if (allOverrides.add(anOverride)) {
						if (yetMoreOverrides == null) {
							yetMoreOverrides = new ArrayList<>();
						}
						yetMoreOverrides.add(anOverride);
					}
				}
			}
			moreOverrides = yetMoreOverrides;
		}
		return allOverrides;
	} */

	public static @NonNull Relation getBaseRelation(@NonNull Relation relation) {
		Relation aRelation = relation;
		int i = 0;
		for (Rule aRule; (aRule = aRelation.getOverridden()) instanceof Relation; ) {
			aRelation = (Relation) aRule;
			if (i++ > 100) {	// More than a 100 is probably a cycle. Try again with an accurate cycle check
				Set<Relation> relations = new HashSet<>();
				aRelation = relation;
				relations.add(relation);
				while ((aRule = aRelation.getOverridden()) instanceof Relation) {
					aRelation = (Relation) aRule;
					if (!relations.add(aRelation)) {
						QVTruntimeUtil.errPrintln("Cyclic override of '" + relation + "' ignored.");
						return relation;
					}
				}
			}
		}
		return aRelation;
	}

	public static @NonNull Variable getBindsTo(@NonNull TemplateExp rTemplateExp) {
		return ClassUtil.nonNullState(rTemplateExp.getBindsTo());
	}

	public static @NonNull Predicate getContainingPredicate(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Predicate) {
				return (Predicate) eObject;
			}
		}
		throw new IllegalStateException();
	}

	public static @NonNull Relation getContainingRelation(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Relation) {
				return (Relation) eObject;
			}
		}
		throw new IllegalStateException();
	}

	public static @NonNull RelationalTransformation getContainingTransformation(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof RelationalTransformation) {
				return (RelationalTransformation) eObject;
			}
		}
		throw new IllegalStateException();
	}

	public static @NonNull Iterable<@NonNull RelationDomainAssignment> getDefaultAssignments(@NonNull RelationDomain rRelationDomain) {
		return ClassUtil.nullFree(rRelationDomain.getDefaultAssignment());
	}

	public static org.eclipse.ocl.pivot.@NonNull Class getIdentifies(@NonNull Key rKey) {
		return ClassUtil.nonNullState(rKey.getIdentifies());
	}

	public static @NonNull VariableDeclaration getOverriddenVariable(@NonNull Relation overriddenRelation, @NonNull VariableDeclaration overridingRootVariable) {
		RelationDomain overridingDomain = QVTrelationUtil.getRootVariableDomain(overridingRootVariable);
		List<@NonNull VariableDeclaration> rootVariables = QVTrelationUtil.getRootVariables(overridingDomain);
		int rootVariableIndex = rootVariables.indexOf(overridingRootVariable);
		assert rootVariableIndex >= 0;
		TypedModel typedModel = overridingDomain.getTypedModel();
		RelationDomain overriddenRelationDomain = QVTrelationUtil.getRelationDomain(overriddenRelation, typedModel);
		List<@NonNull VariableDeclaration> overriddenRootVariables = QVTrelationUtil.getRootVariables(overriddenRelationDomain);
		assert rootVariableIndex < overriddenRootVariables.size();
		return overriddenRootVariables.get(rootVariableIndex);
	}

	public static @NonNull Iterable<@NonNull Relation> getOverrides(@NonNull Relation rRelation) {
		return Iterables.filter(ClassUtil.nullFree(rRelation.getOverrides()), Relation.class);
	}

	public static @NonNull Iterable<@NonNull OCLExpression> getOwnedArguments(@NonNull RelationCallExp rInvocation) {
		return ClassUtil.nullFree(rInvocation.getArgument());
	}

	public static @NonNull Iterable<@NonNull RelationDomain> getOwnedDomains(@NonNull Relation rRelation) {
		return Iterables.filter(ClassUtil.nullFree(rRelation.getDomain()), RelationDomain.class);
	}

	public static @NonNull Iterable<@NonNull Key> getOwnedKey(@NonNull RelationalTransformation rTransformation) {
		return ClassUtil.nullFree(rTransformation.getOwnedKey());
	}

	public static @NonNull Iterable<@NonNull Property> getOwnedOppositeParts(@NonNull Key rKey) {	// FIXME merge into a getNormalizedParts
		return ClassUtil.nullFree(rKey.getOppositePart());
	}

	public static @NonNull Iterable<@NonNull Property> getOwnedParts(@NonNull Key rKey) {
		return ClassUtil.nullFree(rKey.getPart());
	}

	public static @NonNull Iterable<@NonNull DomainPattern> getOwnedPatterns(@NonNull RelationDomain rRelationDomain) {
		return ClassUtil.nullFree(rRelationDomain.getPattern());
	}

	public static @NonNull Iterable<@NonNull Relation> getOwnedRelations(@NonNull RelationalTransformation rTransformation) {
		return Iterables.filter(ClassUtil.nullFree(rTransformation.getRule()), Relation.class);
	}

	public static @NonNull TemplateExp getOwnedTemplateExpression(@NonNull DomainPattern rDomainPattern) {
		return ClassUtil.nonNullState(rDomainPattern.getTemplateExpression());
	}

	public static @NonNull OCLExpression getOwnedValue(@NonNull PropertyTemplateItem rPropertyTemplateItem) {
		return ClassUtil.nonNullState(rPropertyTemplateItem.getValue());
	}

	public static @NonNull Iterable<@NonNull Variable> getOwnedVariables(@NonNull Relation rRelation) {
		return ClassUtil.nullFree(rRelation.getVariable());
	}

	public static @NonNull ObjectTemplateExp getOwningObjectTemplateExp(@NonNull  PropertyTemplateItem rPropertyTemplateItem) {
		return ClassUtil.nonNullState(rPropertyTemplateItem.getObjContainer());
	}

	public static @NonNull Relation getReferredRelation(@NonNull RelationCallExp rInvocation) {
		return ClassUtil.nonNullState(rInvocation.getReferredRelation());
	}

	/**
	 * Return the domain of the argumentIndex'th argument of rInvocation
	 */
	public static @NonNull RelationDomain getRelationCallExpArgumentDomain(@NonNull RelationCallExp rInvocation, int argumentIndex) {
		Relation rRelation = rInvocation.getReferredRelation();
		assert rRelation != null;
		int iFirst = 0;
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			RelationDomain rRelationDomain = (RelationDomain)rDomain;
			int iNext = iFirst + rRelationDomain.getRootVariable().size();
			if (argumentIndex < iNext) {
				return rRelationDomain;
			}
			iFirst = iNext;
		}
		throw new IndexOutOfBoundsException(argumentIndex + " > " + iFirst + " for " + rRelation);
	}

	public static @NonNull RelationDomain getRelationDomain(@NonNull Relation qvtrRelation, @Nullable TypedModel typedModel) {
		for (@NonNull RelationDomain rRelationDomain : getOwnedDomains(qvtrRelation)) {
			if (rRelationDomain.getTypedModel() == typedModel) {
				return rRelationDomain;
			}
		}
		throw new IllegalArgumentException("No " + (typedModel != null ? typedModel.getName() : "null") + " domain in " + qvtrRelation.getName());
	}

	/**
	 * Return the domain of a given root variable.
	 * Throws an IllegalStateException if there is no such domain.
	 */
	public static @NonNull RelationDomain getRootVariableDomain(@NonNull VariableDeclaration rootVariable) {
		Relation relation = getContainingRelation(rootVariable);
		for (@NonNull Domain domain : ClassUtil.nullFree(relation.getDomain())) {
			RelationDomain relationDomain = (RelationDomain)domain;
			for (@NonNull DomainPattern domainPattern : ClassUtil.nullFree(relationDomain.getPattern())) {
				TemplateExp templateExpression = domainPattern.getTemplateExpression();
				if (rootVariable == templateExpression.getBindsTo()) {
					return relationDomain;
				}
			}
		}
		throw new IllegalStateException("No RelationDomain for " + rootVariable);
	}

	/**
	 * Return all the root variables of relation in RelationCallExp order.
	 */
	public static @NonNull List<@NonNull VariableDeclaration> getRootVariables(@NonNull Relation relation) {
		List<@NonNull VariableDeclaration> rootVariables = new ArrayList<>();
		for (@NonNull Domain domain : ClassUtil.nullFree(relation.getDomain())) {
			for (@NonNull DomainPattern domainPattern : ClassUtil.nullFree(((RelationDomain)domain).getPattern())) {
				TemplateExp templateExpression = domainPattern.getTemplateExpression();
				VariableDeclaration rootVariable = templateExpression.getBindsTo();
				assert rootVariable != null;
				rootVariables.add(rootVariable);
			}
		}
		return rootVariables;
	}

	/**
	 * Return all the root variables of relationDomain (in partial RelationCallExp order).
	 */
	public static @NonNull List<@NonNull VariableDeclaration> getRootVariables(@NonNull RelationDomain relationDomain) {
		List<@NonNull VariableDeclaration> rootVariables = new ArrayList<>();
		for (@NonNull DomainPattern domainPattern : ClassUtil.nullFree(relationDomain.getPattern())) {
			TemplateExp templateExpression = domainPattern.getTemplateExpression();
			VariableDeclaration rootVariable = templateExpression.getBindsTo();
			assert rootVariable != null;
			rootVariables.add(rootVariable);
		}
		return rootVariables;
	}

	public static @NonNull Variable getTraceVariable(@NonNull Relation relation) {
		return ClassUtil.nonNullState(NameUtil.getNameable(getOwnedVariables(relation), TRACE_CLASS_NAME));
	}

	public static @NonNull RelationalTransformation getTransformation(@NonNull Relation rRelation) {
		return (RelationalTransformation) ClassUtil.nonNullState(rRelation.getTransformation());
	}

	public static @NonNull OCLExpression getValueExp(@NonNull RelationDomainAssignment relationDomainAssignment) {
		return ClassUtil.nonNullState(relationDomainAssignment.getValueExp());
	}

	public static @NonNull VariableDeclaration getVariable(@NonNull RelationDomainAssignment relationDomainAssignment) {
		return ClassUtil.nonNullState(relationDomainAssignment.getVariable());
	}

	/**
	 * Return true if rRelation participates in a hierarchy of overriding/overridden relations.
	 */
	public static boolean hasOverrides(@NonNull Relation rRelation) {
		return (rRelation.getOverridden() != null) || !rRelation.getOverrides().isEmpty();
	}

	//	public static @NonNull Pattern getWhen(@NonNull Relation rRelation) {
	//		return ClassUtil.nonNullState(rRelation.getWhen());
	//	}

	//	public static @NonNull Pattern getWhere(@NonNull Relation rRelation) {
	//		return ClassUtil.nonNullState(rRelation.getWhere());
	//	}

	/**
	 * Return true if rRelation can be treated as abastract. i.e. if it is abastract and it has overrides.
	 * THis avoids a crash for non-overridden abstarct relation bugs;
	 */
	public static boolean isAbstract(@NonNull Relation rRelation) {
		return rRelation.isIsAbstract() && hasOverrides(rRelation);
	}

	/**
	 * Return true if variable must be non-null while executing a rule.
	 *
	 * This helper suppresses the may-be null that indicates that the rule invocation is optional. (See Bug 499432)
	 */
	public static boolean isRequired(@NonNull VariableDeclaration variable) {
		if (variable.isIsRequired()) {
			return true;
		}
		Rule rule = getContainingRule(variable);
		if (!(rule instanceof Relation)) {
			return false;
		}
		for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables((Relation) rule)) {
			if (rootVariable == variable) {
				return true;
			}
		}
		return false;
	}

	public static boolean isTraceClassVariable(@NonNull VariableDeclaration variable) {
		return TRACE_CLASS_NAME.equals(variable.getName()) && (variable instanceof SharedVariable) && ((SharedVariable)variable).isIsImplicit();
	}

	public static @NonNull RelationalTransformation loadTransformation(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		EnvironmentStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrelationEnvironmentStrategy.INSTANCE);
		try {
			return (RelationalTransformation) loadTransformation(RelationModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}

	public static @NonNull ASResource loadTransformations(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		EnvironmentStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrelationEnvironmentStrategy.INSTANCE);
		try {
			return loadTransformations(RelationModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}

	/**
	 * Rewrite asResource to replace ensure that each RelationalTransformation has a $trace$ TypedModel and each
	 * Relation has a $trace$ SharedVariable..
	 */
	public static boolean rewriteMissingTraceArtefacts(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource asResource) {
		QVTrelationHelper helper = null;
		TraceHelper traceHelper = null;
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof RelationalTransformation) {
				RelationalTransformation asTransformation = (RelationalTransformation)eObject;
				List<@NonNull TypedModel> modelParameters = Internal.getModelParameterList(asTransformation);
				TypedModel traceTypedModel = QVTbaseUtil.basicGetTraceTypedModel(modelParameters);
				if (traceTypedModel == null) {
					if (helper == null) {
						helper = new QVTrelationHelper(environmentFactory);
					}
					modelParameters.add(helper.createTraceTypedModel());
				}
				TypedModel primitiveTypedModel = QVTbaseUtil.basicGetPrimitiveTypedModel(modelParameters);
				if (primitiveTypedModel == null) {
					if (helper == null) {
						helper = new QVTrelationHelper(environmentFactory);
					}
					modelParameters.add(0, helper.createPrimitiveTypedModel());
				}
			}
			if (eObject instanceof Relation) {
				VariableDeclaration traceClassVariable = null;
				Relation asRelation = (Relation)eObject;
				for (@NonNull VariableDeclaration variable : getOwnedVariables(asRelation)) {
					if ((variable instanceof SharedVariable) && ((SharedVariable)variable).isIsImplicit()) {
						traceClassVariable = variable;
					}
				}
				if (traceClassVariable == null) {		// Legacy rescue
					traceClassVariable = NameUtil.getNameable(getOwnedVariables(asRelation), TRACE_CLASS_NAME);
				}
				if (traceClassVariable == null) {
					if (helper == null) {
						helper = new QVTrelationHelper(environmentFactory);
					}
					if (traceHelper == null) {
						traceHelper = new TraceHelper(environmentFactory);
					}
					asRelation.getVariable().add(helper.createTraceClassVariable(traceHelper));
				}
			}
		}
		return helper != null;
	}
}