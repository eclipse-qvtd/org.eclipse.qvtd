/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.usage;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.BottomVariable;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardVariable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;

/**
 * QVTcoreDomainUsageAnalysis provides shared functionality for the overall analysis and for nested operational analyses.
 */
public class QVTcoreDomainUsageAnalysis extends RootDomainUsageAnalysis implements QVTcoreVisitor<@NonNull DomainUsage>
{
	public static class QVTcoreDirectedDomainUsageAnalysis extends DirectedDomainUsageAnalysis
	{
		public QVTcoreDirectedDomainUsageAnalysis(@NonNull QVTcoreDomainUsageAnalysis domainUsageAnalysis, @NonNull TypedModelsConfiguration typedModelsConfiguration) {
			super(domainUsageAnalysis, typedModelsConfiguration);
		}

		@Override
		protected void analyzePropertyAssignments(@NonNull Transformation transformation) {
			for (@NonNull EObject eObject : new TreeIterable(transformation, true)) {
				if (eObject instanceof PropertyAssignment) {
					PropertyAssignment propertyAssignment = (PropertyAssignment)eObject;
					OCLExpression slotExpression = propertyAssignment.getSlotExpression();
					assert slotExpression != null;
					DomainUsage domainUsage = getUsage(PivotUtil.getType(slotExpression));
					if (!isOutput(domainUsage) && !domainUsage.isMiddle()) {
						Property targetProperty = ClassUtil.nonNullState(propertyAssignment.getTargetProperty());
						//					System.out.println("Dirty " + targetProperty + " for " + eObject);
						addDirtyProperty(targetProperty);
					}
				}
			}
			super.analyzePropertyAssignments(transformation);
		}
	}

	public QVTcoreDomainUsageAnalysis(@NonNull EnvironmentFactory environmentFactory, @NonNull ProblemHandler problemHandler, @NonNull Transformation transformation) {
		super(environmentFactory, problemHandler, transformation);
	}

	@Override
	public @NonNull DirectedDomainUsageAnalysis createDirectedDomainUsageAnalysis(@NonNull TypedModelsConfiguration typedModelsConfiguration) {
		return new QVTcoreDirectedDomainUsageAnalysis(this, typedModelsConfiguration);
	}

	protected @NonNull DomainUsage doNavigationAssignment(@NonNull Property property, @NonNull NavigationAssignment object) {
		DomainUsage slotUsage = visit(object.getSlotExpression());
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage knownSourceUsage = getRootAnalysis().property2containingClassUsage.get(property);
		if (knownSourceUsage != null) {
			DomainUsage knownTargetUsage = getRootAnalysis().getUsage(property);
			assert knownTargetUsage != null;
			intersection(knownSourceUsage, slotUsage);
			intersection(knownTargetUsage, valueUsage);
			return knownSourceUsage; //intersection(knownTargetUsage, valueUsage);
		}
		else {
			return slotUsage; //intersection(slotUsage, valueUsage);
		}
	}

	@Override				// FIXME BUG 487257 Revise this
	protected @NonNull DomainUsage getAllInstancesUsage(@NonNull OperationCallExp asCallExp, @NonNull DomainUsage sourceUsage) {
		if (asCallExp.getOwnedSource().getTypeValue() instanceof DataType) {
			return getPrimitiveUsage();
		}
		Area area = QVTcoreUtil.getContainingArea(asCallExp);
		if (area instanceof CoreDomain) {
			DomainUsage areaUsage = getUsage(area);
			return intersection(sourceUsage, areaUsage);
		}
		else if (area instanceof Mapping) {
			DomainUsage inputUsage = getNoneUsage();
			for (Domain domain : ((Mapping)area).getDomain()) {
				if (domain.isNotOutput()) {
					inputUsage = union(inputUsage, getUsage(domain));
				}
			}
			if (inputUsage != getNoneUsage()) {
				return intersection(sourceUsage, inputUsage);
			}
			else {				// At root so no domains, use input
				return sourceUsage; //intersection(sourceUsage, getInputUsage());
			}
		}
		else {
			return sourceUsage;
		}
	}

	protected void setBoundVariablesUsages(@NonNull Rule rule) {
		DomainUsage primitiveUsage = getRootAnalysis().getPrimitiveUsage();
		for (Domain domain : rule.getDomain()) {
			if (domain instanceof CoreDomain) {
				DomainUsage usage = visit(domain.getTypedModel());
				for (VariableDeclaration variable : ((CoreDomain)domain).getGuardPattern().getOwnedVariables()) {
					if (variable != null) {
						DomainUsage variableUsage = visit(variable.getType());
						if (variableUsage != primitiveUsage) {
							variableUsage = usage;
						}
						assert variableUsage != null;
						setUsage(variable, variableUsage);
					}
				}
			}
		}
		if (rule instanceof Mapping) {
			DomainUsage middleUsage = getRootAnalysis().getMiddleUsage();
			for (VariableDeclaration variable : ((Mapping)rule).getGuardPattern().getOwnedVariables()) {
				if (variable != null) {
					DomainUsage variableUsage = visit(variable.getType());
					if (variableUsage.isMiddle()) {
						assert variableUsage == middleUsage;
						variableUsage = middleUsage;
					}
					assert variableUsage != null;
					setUsage(variable, variableUsage);
				}
			}
		}
		if (rule instanceof Mapping) {
			for (Mapping local : ((Mapping)rule).getLocal()) {
				if (local != null) {
					setBoundVariablesUsages(local);
				}
			}
		}
	}

	@Override
	public @NonNull DomainUsage visitAssignment(@NonNull Assignment object) {
		return visitElement(object);
	}

	@Override
	public @NonNull DomainUsage visitBottomPattern(@NonNull BottomPattern object) {
		for (VariableDeclaration variable : object.getOwnedVariables()) {
			visit(variable);
		}
		for (RealizedVariable variable : object.getRealizedVariable()) {
			visit(variable);
		}
		for (Assignment assignment : object.getAssignment()) {
			visit(assignment);
		}
		for (Predicate predicate : object.getPredicate()) {
			visit(predicate);
		}
		return getDomainUsage(object);
	}

	@Override
	public @NonNull DomainUsage visitBottomVariable(@NonNull BottomVariable object) {
		return visitVariable(object);
	}

	@Override
	public @NonNull DomainUsage visitCoreDomain(@NonNull CoreDomain object) {
		DomainUsage usage = visit(object.getTypedModel());
		setUsage(object, usage);
		visit(object.getGuardPattern());
		visit(object.getBottomPattern());
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitCoreModel(@NonNull CoreModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @NonNull DomainUsage visitCorePattern(@NonNull CorePattern object) {
		return visitPattern(object);
	}

	@Override
	public @NonNull DomainUsage visitEnforcementOperation(@NonNull EnforcementOperation object) {
		return visitElement(object);
	}

	@Override
	public @NonNull DomainUsage visitGuardPattern(@NonNull GuardPattern object) {
		DomainUsage domainUsage = getDomainUsage(object);
		//		for (Variable variable : object.getVariable()) {			// In visitTransformation
		//			setUsage(variable, domainUsage);
		//		}
		for (Predicate predicate : object.getPredicate()) {
			visit(predicate);
		}
		return domainUsage;
	}

	@Override
	public @NonNull DomainUsage visitGuardVariable(@NonNull GuardVariable object) {
		return visitVariable(object);
	}

	@Override
	public @NonNull DomainUsage visitMapping(@NonNull Mapping object) {
		DomainUsage ruleUsage = visitRule(object);
		Mapping contextMapping = object.getContext();
		if (contextMapping != null) {
			DomainUsage contextUsage = getUsage(contextMapping);
			ruleUsage = union(ruleUsage, contextUsage);
			setUsage(object, ruleUsage);
		}
		visit(object.getGuardPattern());
		visit(object.getBottomPattern());
		for (Mapping local : object.getLocal()) {
			visit(local);
		}
		return ruleUsage;
	}

	@Override
	public @NonNull DomainUsage visitNavigationAssignment(@NonNull NavigationAssignment object) {
		Property property = QVTcoreUtil.getTargetProperty(object);
		//		if ("middleRoot.name := hsvRoot.name".equals(object.toString())) {
		//			property = object.getTargetProperty();
		//		}
		return doNavigationAssignment(property, object);
	}

	@Override
	public @NonNull DomainUsage visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @NonNull DomainUsage visitPropertyAssignment(@NonNull PropertyAssignment object) {
		return visitNavigationAssignment(object);
	}

	@Override
	public @NonNull DomainUsage visitRealizedVariable(@NonNull RealizedVariable object) {
		return getDomainUsage(object);
	}

	@Override
	public @NonNull DomainUsage visitTransformation(@NonNull Transformation object) {
		RootDomainUsageAnalysis rootAnalysis = getRootAnalysis();
		if (rootAnalysis != this) {
			return rootAnalysis.getThisUsage();
		}
		//		for (TypedModel typedModel : object.getModelParameter()) {			-- done in analyzeTransformation
		//			visit(typedModel);
		//		}
		//		System.out.println("  " + getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this)) + " : " + object);
		VariableDeclaration ownedContext = QVTbaseUtil.getContextVariable(getEnvironmentFactory().getStandardLibrary(), object);
		setUsage(ownedContext, getRootAnalysis().getThisUsage());
		//
		//	Ensure all operations are analyzed even if not used.
		//
		for (Operation operation : object.getOwnedOperations()) {
			if (operation != null) {
				getRootAnalysis().analyzeOperation(operation);
			}
		}
		//
		//	Define all bound variables so that they back propgate to resolve domain usage variables.
		//
		for (Rule rule : object.getRule()) {
			if (rule != null) {
				setBoundVariablesUsages(rule);
			}
		}
		//
		//	Analyze the rest of the tree.
		//
		for (Rule rule : object.getRule()) {
			visit(rule);
		}
		return getRootAnalysis().getThisUsage();
	}

	@Override
	public @NonNull DomainUsage visitVariable(@NonNull Variable object) {
		Area area = QVTcoreUtil.getContainingArea(object);
		DomainUsage typeUsage = area instanceof Domain ? visit(area) : visit(object.getType());
		OCLExpression ownedInit = object.getOwnedInit();
		if (ownedInit == null) {
			return typeUsage;
		}
		DomainUsage initUsage = visit(ownedInit);
		return intersection(typeUsage, initUsage);
	}

	@Override
	public @NonNull DomainUsage visitVariableAssignment(@NonNull VariableAssignment object) {
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage variableUsage = visit(object.getTargetVariable());
		return intersection(variableUsage, valueUsage);
	}
}
