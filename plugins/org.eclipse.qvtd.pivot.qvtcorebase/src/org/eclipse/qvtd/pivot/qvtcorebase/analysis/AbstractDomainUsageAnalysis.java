/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.TemplateableElement;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.manager.TemplateParameterSubstitutionVisitor;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractExtendingQVTcoreBaseVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;

/**
 * AbstractDomainUsageAnalysis provides shared functionality for the overall analysis and for nested operational analyses.
 */
public abstract class AbstractDomainUsageAnalysis extends AbstractExtendingQVTcoreBaseVisitor<DomainUsage, @NonNull EnvironmentFactoryInternal> implements DomainUsageAnalysis.Internal
{
	private DomainUsage selfUsage = null;
	protected final @NonNull Map<Element, DomainUsage> element2usage = new HashMap<Element, DomainUsage>();

	protected AbstractDomainUsageAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @Nullable DomainUsage basicGetUsage(@Nullable EObject element) {
		return element2usage.get(element);
	}
	
	protected @NonNull DomainUsage doPropertyAssignment(Property property, @NonNull PropertyAssignment object) {
		DomainUsage slotUsage = visit(object.getSlotExpression());
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage knownSourceUsage = getRootAnalysis().property2containingClassUsage.get(property);
		if (knownSourceUsage != null) {
			DomainUsage knownTargetUsage = getRootAnalysis().property2referredTypeUsage.get(property);
			assert knownTargetUsage != null;
			intersection(knownSourceUsage, slotUsage);
			intersection(knownTargetUsage, valueUsage);
			return knownSourceUsage; //intersection(knownTargetUsage, valueUsage);
		}
		else {
			return slotUsage; //intersection(slotUsage, valueUsage);
		}
	}
	
	protected @NonNull DomainUsage doPropertyCallExp(Property property, @NonNull NavigationCallExp object) {
		DomainUsage actualSourceUsage = visit(object.getOwnedSource());
		DomainUsage knownSourceUsage = getRootAnalysis().property2containingClassUsage.get(property);
		if (knownSourceUsage != null) {
			DomainUsage knownTargetUsage = getRootAnalysis().property2referredTypeUsage.get(property);
			assert knownTargetUsage != null;
//			return intersection(knownSourceUsage, actualSourceUsage);			// FIXME Why?
			return knownTargetUsage;
		}
		else {
			return actualSourceUsage;
		}
	}
	
	protected @NonNull DomainUsage getDomainUsage(@Nullable EObject object) {
		Domain domain = QVTcoreBaseUtil.getContainingDomain(object);
		if (domain !=  null) {
			return visit(domain.getTypedModel());
		}
		else {
			return getRootAnalysis().getMiddleUsage();
		}
	}

	public @NonNull Map<Element, DomainUsage> getElements2Usage() {
		return element2usage;
	}

	public @NonNull EnvironmentFactoryInternal getEnvironmentFactory() {
		return context;
	}

	protected abstract @NonNull RootDomainUsageAnalysis getRootAnalysis();

	@Override
	public @NonNull DomainUsage getUsage(@NonNull EObject element) {
		return ClassUtil.nonNullState(element2usage.get(element));
	}

	protected @NonNull DomainUsage intersection(@NonNull DomainUsage firstUsage, @NonNull DomainUsage secondUsage) {
		int firstMask = ((DomainUsage.Internal)firstUsage).getMask();
		int secondMask = ((DomainUsage.Internal)secondUsage).getMask();
		if (firstMask == secondMask) {
			if (firstUsage != secondUsage) {
				if (!firstUsage.isConstant()) {
					replace((DomainUsage.Internal) firstUsage, secondUsage);
					return secondUsage;
				}
				else if (!secondUsage.isConstant()) {
					replace((DomainUsage.Internal) secondUsage, firstUsage);
					return firstUsage;
				}
			}
			return firstUsage;
		}
		else {
			int intersectionMask = firstMask & secondMask;
			DomainUsage usage = getRootAnalysis().getValidUsage(intersectionMask);
			if (usage != null) {
				if ((usage != firstUsage) && !firstUsage.isConstant()) {
					replace((DomainUsage.Internal) firstUsage, usage);
				}
				if ((usage != secondUsage) && !secondUsage.isConstant()) {
					replace((DomainUsage.Internal) secondUsage, usage);
				}
				return usage;
			}
			else {
				usage = getRootAnalysis().createVariableUsage(intersectionMask);
				if (!firstUsage.isConstant()) {
					replace((DomainUsage.Internal) firstUsage, usage);
				}
				if (!secondUsage.isConstant()) {
					replace((DomainUsage.Internal) secondUsage, usage);
				}
				return usage;
			}
		}
	}

	protected void popSelfUsage(DomainUsage savedUsage) {
		selfUsage  = savedUsage;
	}
	
	protected DomainUsage pushSelfUsage(@NonNull DomainUsage usage) {
		DomainUsage oldUsage = selfUsage;
		int usageMask = ((DomainUsage.Internal)usage).getMask();
		DomainUsage constantUsage = getRootAnalysis().getValidUsage(usageMask);
		if (constantUsage == null) {
			usage = getRootAnalysis().createVariableUsage(usageMask);
		}
		selfUsage = usage;
		return oldUsage;
	}

	protected void replace(DomainUsage.@NonNull Internal oldUsage, @NonNull DomainUsage newUsage) {
		Iterable<Element> elements = oldUsage.getElements();
		if (elements != null) {
			for (@SuppressWarnings("null")@NonNull Element element : elements) {
				setUsage(element, newUsage);
			}
		}
	}

	protected void setBoundVariablesUsages(@NonNull Rule rule) {
		DomainUsage primitiveUsage = getRootAnalysis().getPrimitiveUsage();
		for (Domain domain : rule.getDomain()) {
			if (domain instanceof CoreDomain) {
				DomainUsage usage = visit(domain.getTypedModel());
				for (Variable variable : ((CoreDomain)domain).getGuardPattern().getVariable()) {
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
		if (rule instanceof AbstractMapping) {
			DomainUsage middleUsage = getRootAnalysis().getMiddleUsage();
			for (Variable variable : ((AbstractMapping)rule).getGuardPattern().getVariable()) {
				if (variable != null) {
					DomainUsage variableUsage = visit(variable.getType());
					if (variableUsage != primitiveUsage) {
						variableUsage = middleUsage;
					}
					assert variableUsage != null;
					setUsage(variable, variableUsage);
				}
			}
		}
	}
	
	protected void setUsage(@NonNull Element element, @NonNull DomainUsage newUsage) {
		element2usage.put(element, newUsage);
		((DomainUsage.Internal)newUsage).addUsedBy(element);
//		System.out.println("        setUsage " + getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this))
//		+ " : " + element.eClass().getName() + "@" + Integer.toHexString(System.identityHashCode(element))
//		+ " <= " + newUsage
//			);
	}

	@Override
	public String toString() {
		Map<String, DomainUsage> map = new HashMap<String, DomainUsage>(element2usage.size());
		List<String> keys = new ArrayList<String>(element2usage.size());
		for (Map.Entry<Element, DomainUsage> entry : element2usage.entrySet()) {
			Element element = entry.getKey();
			String key = element.eClass().getName() + " : " + element;
			map.put(key, entry.getValue());
			keys.add(key);
		}
		Collections.sort(keys);
		StringBuilder s = new StringBuilder();
		for (String key : keys) {
			DomainUsage usage = map.get(key);
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(key);
			s.append(" => ");
			s.append(usage);
		}
		return s.toString();
	}

	@Override
	public @NonNull DomainUsage visit(@Nullable Element element) {
		if (element == null) {
			return getRootAnalysis().getAnyUsage();
		}
		DomainUsage usage = element2usage.get(element);
		if (usage == null) {
			usage = element.accept(this);
			if (usage == null) {						// FIXME debugging
				usage = element.accept(this);
			}
			assert usage != null : "null usage for " + element.eClass().getName() + " " + element;
			setUsage(element, usage);
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
	}

	@Override
	public @Nullable DomainUsage visitBottomPattern(@NonNull BottomPattern object) {
		for (Variable variable : object.getVariable()) {
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
	public @Nullable DomainUsage visitClass(org.eclipse.ocl.pivot.@NonNull Class object) {
		DomainUsage usage = getRootAnalysis().class2usage.get(object);
		if (usage != null) {
			return usage;
		}
		else {
			return getRootAnalysis().getPrimitiveUsage();
		}
	}

	@Override
	public @Nullable DomainUsage visitCollectionItem(@NonNull CollectionItem object) {
		return visit(object.getOwnedItem());
	}

	@Override
	public @Nullable DomainUsage visitCollectionLiteralExp(@NonNull CollectionLiteralExp object) {
		DomainUsage usage = visit(((CollectionType)object.getType()).getElementType());
//		DomainUsage usage = getRootAnalysis().getAnyUsage();
		for (@SuppressWarnings("null")@NonNull CollectionLiteralPart part : object.getOwnedParts()) {
			usage = intersection(usage, visit(part));
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitCollectionRange(@NonNull CollectionRange object) {
		DomainUsage firstUsage = visit(object.getOwnedFirst());
		DomainUsage lastUsage = visit(object.getOwnedLast());
		return intersection(firstUsage, lastUsage);
	}

	@Override
	public @Nullable DomainUsage visitCollectionType(@NonNull CollectionType object) {
		return visit(object.getElementType());
	}
	@Override
	public @Nullable DomainUsage visitCoreDomain(@NonNull CoreDomain object) {
		DomainUsage usage = visit(object.getTypedModel());
		setUsage(object, usage);
		visit(object.getGuardPattern());
		visit(object.getBottomPattern());
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitExpressionInOCL(@NonNull ExpressionInOCL object) {
		OCLExpression ownedBody = object.getOwnedBody();
		if ((ownedBody == null) && (object.getBody() != null)) {
			try {
				ownedBody = context.getMetamodelManager().parseSpecification(object).getOwnedBody();		// FIXME why is this necessary
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Variable ownedContext = object.getOwnedContext();
		if ((ownedContext != null) && (selfUsage != null)) {
			setUsage(ownedContext, selfUsage);
		}
		else {
			visit(ownedContext);
		}
		for (Variable parameter : object.getOwnedParameters()) {
			visit(parameter);
		}
		visit(object.getOwnedResult());
		return visit(ownedBody);
	}

	@Override
	public @Nullable DomainUsage visitFunction(@NonNull Function object) {
		for (@SuppressWarnings("null")@NonNull Parameter parameter : object.getOwnedParameters()) {
			visit(parameter);
		}
		OCLExpression queryExpression = object.getQueryExpression();
		if (queryExpression != null) {
			return visit(queryExpression);
		}
		else {
			return visit(object.getType());
		}
	}

	@Override
	public @Nullable DomainUsage visitIfExp(@NonNull IfExp object) {
		@SuppressWarnings("unused") DomainUsage conditionUsage = visit(object.getOwnedCondition());
		DomainUsage thenUsage = visit(object.getOwnedThen());
		DomainUsage elseUsage = visit(object.getOwnedElse());
		return intersection(thenUsage, elseUsage);
	}

	@Override
	public @Nullable DomainUsage visitGuardPattern(@NonNull GuardPattern object) {
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
	public @Nullable DomainUsage visitIterateExp(@NonNull IterateExp object) {
		DomainUsage sourceUsage = visit(object.getOwnedSource());
		for (Variable iterator : object.getOwnedIterators()) {
			if (iterator != null) {
				setUsage(iterator, sourceUsage);
			}
		}
		visit(object.getOwnedResult());
		@SuppressWarnings("unused") DomainUsage bodyUsage = visit(object.getOwnedBody());
		TemplateParameterSubstitutionVisitor visitor = new TemplateParameterSubstitutionVisitor(context, object.getOwnedSource().getType(), null);
		object.accept(visitor);
		Iteration iteration = object.getReferredIteration();
		for (EObject eObject = iteration; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				TemplateSignature ownedSignature = ((TemplateableElement)eObject).getOwnedSignature();
				if (ownedSignature != null) {
					for (TemplateParameter templateParameter : ownedSignature.getOwnedParameters()) {
						if (templateParameter != null) {
							Type templateParameterType = visitor.get(templateParameter);
							DomainUsage templateParameterUsage = visit(templateParameterType);
							setUsage(templateParameter, templateParameterUsage);
						}
					}
				}
			}
		}
		return visit(iteration.getType());
	}

	@Override
	public @Nullable DomainUsage visitIteratorExp(@NonNull IteratorExp object) {
		DomainUsage sourceUsage = visit(object.getOwnedSource());
		for (Variable iterator : object.getOwnedIterators()) {
			if (iterator != null) {
				setUsage(iterator, sourceUsage);
			}
		}
		@SuppressWarnings("unused") DomainUsage bodyUsage = visit(object.getOwnedBody());
		TemplateParameterSubstitutionVisitor visitor = new TemplateParameterSubstitutionVisitor(context, object.getOwnedSource().getType(), null);
		object.accept(visitor);
		Iteration iteration = object.getReferredIteration();
		for (EObject eObject = iteration; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				TemplateSignature ownedSignature = ((TemplateableElement)eObject).getOwnedSignature();
				if (ownedSignature != null) {
					for (TemplateParameter templateParameter : ownedSignature.getOwnedParameters()) {
						if (templateParameter != null) {
							Type templateParameterType = visitor.get(templateParameter);
							DomainUsage templateParameterUsage = visit(templateParameterType);
							setUsage(templateParameter, templateParameterUsage);
						}
					}
				}
			}
		}
		return visit(iteration.getType());
	}

	@Override
	public @Nullable DomainUsage visitLetExp(@NonNull LetExp object) {
		visit(object.getOwnedVariable());
		return visit(object.getOwnedIn());
	}

	@Override
	public @Nullable DomainUsage visitLiteralExp(@NonNull LiteralExp object) {
		return getRootAnalysis().getPrimitiveUsage();
	}

	@Override
	public @Nullable DomainUsage visitMapLiteralExp(@NonNull MapLiteralExp object) {
		DomainUsage usage = getRootAnalysis().getAnyUsage();
		for (@SuppressWarnings("null")@NonNull MapLiteralPart part : object.getOwnedParts()) {
			usage = intersection(usage, visit(part));
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitMapLiteralPart(@NonNull MapLiteralPart object) {
		DomainUsage keyUsage = visit(object.getOwnedKey());
		DomainUsage valueUsage = visit(object.getOwnedValue());
		return intersection(keyUsage, valueUsage);
	}

	@Override
	public @Nullable DomainUsage visitNullLiteralExp(@NonNull NullLiteralExp object) {
		return getRootAnalysis().createVariableUsage(getRootAnalysis().getAnyMask());
	}

	@Override
	public @Nullable DomainUsage visitOperation(@NonNull Operation object) {
//		System.out.println("    " + getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this)) + " : " + object);
		DomainUsage savedUsage = pushSelfUsage(visit(object.getOwningClass()));
		try {
			for (@SuppressWarnings("null")@NonNull Parameter parameter : object.getOwnedParameters()) {
				visit(parameter);
			}
			LanguageExpression bodyExpression = object.getBodyExpression();
			if (bodyExpression == null) {
				return visit(object.getType());
			}
			PivotMetamodelManager metamodelManager = context.getMetamodelManager();
			try {
				ExpressionInOCL parseSpecification = metamodelManager.parseSpecification(bodyExpression);
				return visit(parseSpecification);
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return visit(object.getType());
			}
//			ownedBody = parseSpecification.getOwnedBody();		// FIXME why is this necessary
//			LanguageExpression bodyExpression = object.getBodyExpression();
		}
		finally {
			popSelfUsage(savedUsage);
		}
	}

	@Override
	public @Nullable DomainUsage visitOperationCallExp(@NonNull OperationCallExp object) {
		DomainUsage sourceUsage = visit(object.getOwnedSource());
		DomainUsage savedUsage = pushSelfUsage(sourceUsage);
		try {
			Operation operation = ClassUtil.nonNullState(object.getReferredOperation());
			RootDomainUsageAnalysis rootAnalysis = getRootAnalysis();
			OperationId operationId = operation.getOperationId();
			//
			//	Special case: usage of oclContainer()/oclContents() is unchanged from the usage of the source.
			//
			if ((operationId == rootAnalysis.getOclContainerId())
			 || (operationId == rootAnalysis.getOclContentsId())) {
				return sourceUsage;
			}
			//
			//	Special case: left/right of "="/"<>" have same usage. Result is primitive.
			//
			if ((operationId == getRootAnalysis().getOclAnyEqualsOperationId())
			 || (operationId == getRootAnalysis().getOclAnyNotEqualsOperationId())) {
				DomainUsage leftUsage = visit(object.getOwnedSource());
				DomainUsage rightUsage = visit(object.getOwnedArguments().get(0));
				intersection(leftUsage, rightUsage);
				return getRootAnalysis().getPrimitiveUsage();
			}
			TemplateParameter templateParameter = operation.getType().isTemplateParameter();
			if (templateParameter != null) {			// Handle e.g oclAsType()
				List<Parameter> ownedParameters = operation.getOwnedParameters();
				int iMax = Math.min(ownedParameters.size(), object.getOwnedArguments().size());
				for (int i = 0; i < iMax; i++) {
					Parameter parameter = ownedParameters.get(i);
					if (parameter.isIsTypeof() && (parameter.getType() == templateParameter)) {
						OCLExpression argument = object.getOwnedArguments().get(i);
						DomainUsage argumentUsage = visit(argument);
						return argumentUsage;
					}
				}
			}
			DomainUsageAnalysis analysis = rootAnalysis.getAnalysis(operation);
			Map<DomainUsage, DomainUsage> referred2specialized = new HashMap<DomainUsage, DomainUsage>();
			List<@NonNull Parameter> ownedParameters = ClassUtil.nullFree(operation.getOwnedParameters());
			int iMax = Math.min(ownedParameters.size(), object.getOwnedArguments().size());
			for (int i = 0; i < iMax; i++) {
				Parameter parameter = ownedParameters.get(i);
				OCLExpression argument = object.getOwnedArguments().get(i);
				DomainUsage referredParameterUsage = analysis.getUsage(parameter);
				DomainUsage specializedParameterUsage;
				if (referredParameterUsage.isConstant()) {
					specializedParameterUsage = referredParameterUsage;
				}
				else {
					specializedParameterUsage = referred2specialized.get(referredParameterUsage);
					if (specializedParameterUsage == null) {
//						specializedParameterUsage = new DomainUsageVariable(getRootAnalysis(), ((DomainUsage.Internal)referredParameterUsage).getMask());
						specializedParameterUsage = ((DomainUsage.Internal)referredParameterUsage).cloneVariable();
						referred2specialized.put(referredParameterUsage, specializedParameterUsage);
					}
				}
				DomainUsage argumentUsage = visit(argument);
				intersection(argumentUsage, specializedParameterUsage);
			}
			DomainUsage operationUsage = analysis.basicGetUsage(operation);
			if ((operationUsage != null) && !operationUsage.isConstant()) {
//				operationUsage = new DomainUsageVariable(getRootAnalysis(), ((DomainUsage.Internal)operationUsage).getMask());
				operationUsage = ((DomainUsage.Internal)operationUsage).cloneVariable();
			}
			DomainUsage operationCallUsage = visit(object.getType());
			return /*operationUsage != null ? intersection(operationUsage, operationCallUsage) :*/ operationCallUsage;
		}
		finally {
			popSelfUsage(savedUsage);
		}
	}

	@Override
	public @Nullable DomainUsage visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		Property property = object.getReferredProperty();
		Property oppositeProperty = property != null ? property.getOpposite() : null;
		return doPropertyCallExp(oppositeProperty, object);
	}

	@Override
	public @Nullable DomainUsage visitParameter(@NonNull Parameter object) {
//		Operation operation = object.getOwningOperation();
//		Map<Element, DomainUsage> map = analyzeOperation(operation);
//		return map.get(object);
		DomainUsage usage = visit(object.getType());
		return getRootAnalysis().getValidOrVariableUsage(usage);
	}
	
	@Override
	public @Nullable DomainUsage visitPredicate(@NonNull Predicate object) {
		return visit(object.getConditionExpression());
	}

	@Override
	public @Nullable DomainUsage visitPrimitiveType(@NonNull PrimitiveType object) {
		return getRootAnalysis().getPrimitiveUsage();
	}

	@Override
	public @Nullable DomainUsage visitPropertyAssignment(@NonNull PropertyAssignment object) {
		Property property = object.getTargetProperty();
//		if ("middleRoot.name := hsvRoot.name".equals(object.toString())) {
//			property = object.getTargetProperty();
//		}
		return doPropertyAssignment(property, object);
	}

	@Override
	public @Nullable DomainUsage visitPropertyCallExp(@NonNull PropertyCallExp object) {
		Property property = object.getReferredProperty();
		RootDomainUsageAnalysis rootAnalysis = getRootAnalysis();
		if ((property == rootAnalysis.getOclContainerProperty()) || (property == rootAnalysis.getOclContentsProperty())) {
			return visit(object.getOwnedSource());
		}
		else {
			return doPropertyCallExp(property, object);
		}
	}
	
	@Override
	public @Nullable DomainUsage visitRealizedVariable(@NonNull RealizedVariable object) {
		return getDomainUsage(object);
	}

	@Override
	public @Nullable DomainUsage visitRule(@NonNull Rule object) {
		for (Domain domain : object.getDomain()) {
			visit(domain);
		}
		return getRootAnalysis().getNoneUsage();
	}

	@Override
	public @Nullable DomainUsage visitSelfType(@NonNull SelfType object) {
		return selfUsage;
	}

	@Override
	public @Nullable DomainUsage visitShadowExp(@NonNull ShadowExp object) {
		DomainUsage usage = visit(object.getType());
		for (@SuppressWarnings("null")@NonNull ShadowPart part : object.getOwnedParts()) {
			/*usage = intersection(usage,*/ visit(part); //);
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitShadowPart(@NonNull ShadowPart object) {
		visit(object.getOwnedInit());
		return visit(object.getType());
	}

	@Override
	public @Nullable DomainUsage visitTemplateParameter(@NonNull TemplateParameter object) {
		RootDomainUsageAnalysis rootAnalysis = getRootAnalysis();
		int anyMask = rootAnalysis.getAnyMask();
		DomainUsage usage = rootAnalysis.getValidUsage(anyMask);
		if (usage == null) {
			usage = rootAnalysis.createVariableUsage(anyMask);
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitTransformation(@NonNull Transformation object) {
//		for (TypedModel typedModel : object.getModelParameter()) {			-- done in analyzeTransformation
//			visit(typedModel);
//		}
//		System.out.println("  " + getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this)) + " : " + object);
		Variable ownedContext = object.getOwnedContext();
		DomainUsage domainUsage = basicGetUsage(object);
		if ((ownedContext != null) && (domainUsage != null)) {
			setUsage(ownedContext, domainUsage);
		}
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
		return getRootAnalysis().getNoneUsage();
	}

	@Override
	public @Nullable DomainUsage visitTupleLiteralExp(@NonNull TupleLiteralExp object) {
		DomainUsage usage = getRootAnalysis().getAnyUsage();
		for (@SuppressWarnings("null")@NonNull TupleLiteralPart part : object.getOwnedParts()) {
			usage = intersection(usage, visit(part));				// FIXME need HYBRID
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitTupleLiteralPart(@NonNull TupleLiteralPart object) {
		return visit(object.getType());
	}

	@Override
	public @Nullable DomainUsage visitTupleType(@NonNull TupleType object) {
		DomainUsage usage = getRootAnalysis().getAnyUsage();
		for (@SuppressWarnings("null")@NonNull Property part : object.getOwnedProperties()) {
			usage = intersection(usage, visit(part.getType()));
		}
		return usage;
	}

	@Override
	public @Nullable DomainUsage visitType(@NonNull Type object) {
		return getRootAnalysis().getPrimitiveUsage();
	}
	
	@Override
	public @Nullable DomainUsage visitTypeExp(@NonNull TypeExp object) {
		return visit(object.getReferredType());
	}

	@Override
	public @Nullable DomainUsage visitTypedModel(@NonNull TypedModel object) {
		return element2usage.get(object);
	}
	
	@Override
	public @Nullable DomainUsage visitVariable(@NonNull Variable object) {
		OCLExpression ownedInit = object.getOwnedInit();
		if (ownedInit != null) {
			return visit(ownedInit);
		}
		Area area = QVTcoreBaseUtil.getContainingArea(object);
		if (area != null) {
			return visit(area);
		}
		else {
			return visit(object.getType());
		}
	}

	@Override
	public @Nullable DomainUsage visitVariableAssignment(@NonNull VariableAssignment object) {
		DomainUsage valueUsage = visit(object.getValue());
		DomainUsage variableUsage = visit(object.getTargetVariable());
		return intersection(variableUsage, valueUsage);
	}

	@Override
	public @Nullable DomainUsage visitVariableDeclaration(@NonNull VariableDeclaration object) {
		return visit(object.getType());
	}
	
	@Override
	public @Nullable DomainUsage visitVariableExp(@NonNull VariableExp object) {
		DomainUsage usage = element2usage.get(object.getReferredVariable());
		assert usage != null : object.getReferredVariable() + " usage not defined";
		return usage;
	}
}
