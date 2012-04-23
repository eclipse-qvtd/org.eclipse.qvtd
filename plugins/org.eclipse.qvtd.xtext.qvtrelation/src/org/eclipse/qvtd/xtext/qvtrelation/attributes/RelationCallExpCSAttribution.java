/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EnumCSAttribution.java,v 1.3 2011/04/25 09:50:02 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtrelation.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.InvocationExpCSAttribution;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.OperationFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;

public class RelationCallExpCSAttribution extends InvocationExpCSAttribution
{
	public static final RelationCallExpCSAttribution INSTANCE = new RelationCallExpCSAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
		InvocationExpCS targetElement = (InvocationExpCS)target;
		OclExpression pivot = PivotUtil.getPivot(OclExpression.class, targetElement);
		if (pivot instanceof CallExp) {
			return super.computeLookup(target, environmentView, scopeView);
		}
/*		EObject fromArgument = scopeView.getChild();
		if (fromArgument instanceof NavigatingArgCS) {
			if (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.EXPRESSION) {
				CallExp pivot = PivotUtil.getPivot(CallExp.class, targetElement);
				if (pivot instanceof LoopExp) {				// FIXME This is null for nested iteration
					for (Variable iterator : ((LoopExp)pivot).getIterator()) {
						if (iterator.isImplicit()) {
							environmentView.addElementsOfScope(iterator.getType(), scopeView);
						}
						else {
							environmentView.addNamedElement(iterator);
						}
						if (environmentView.hasFinalResult()) {
							return null;
						}
					}
					if (pivot instanceof IterateExp) {
						Variable result = ((IterateExp)pivot).getResult();
						if (result.isImplicit()) {
							environmentView.addElementsOfScope(result.getType(), scopeView);
						}
						else {
							environmentView.addNamedElement(result);
						}
						if (environmentView.hasFinalResult()) {
							return null;
						}
					}
				}
				else if (pivot == null) {
					OperatorCS csParent = targetElement.getParent();
					if (csParent instanceof NavigationOperatorCS) {
						NavigationOperatorCS csNavigationOperator = (NavigationOperatorCS)csParent;
						ExpCS csSource = csNavigationOperator.getSource();
						OclExpression source = PivotUtil.getPivot(OclExpression.class, csSource);
						if (source != null) {
							Type type = source.getType();
							if (csNavigationOperator.getName().equals(PivotConstants.COLLECTION_NAVIGATION_OPERATOR)) {
								if (type instanceof CollectionType) {		// collection->collection-operation(name...
									environmentView.addElementsOfScope(((CollectionType)type).getElementType(), scopeView);
								}
							}
						}
					}
				}
			}
			else if (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.ITERATOR) {			// Happens during save
				CallExp pivot = PivotUtil.getPivot(CallExp.class, targetElement);
				if (pivot instanceof LoopExp) {
					environmentView.addNamedElements(((LoopExp)pivot).getIterator());
				}
			}
			else if (((NavigatingArgCS)fromArgument).getRole() == NavigationRole.ACCUMULATOR) {
				CallExp pivot = PivotUtil.getPivot(CallExp.class, targetElement);
				if (pivot instanceof IterateExp) {
					environmentView.addNamedElement(((IterateExp)pivot).getResult());
				}
			}
			ScopeFilter filter = ContextCSAttribution.NoImplicitProperties.INSTANCE;
			try {
				environmentView.addFilter(filter);
				ElementCS parent = targetElement.getLogicalParent();
				BaseScopeView.computeLookups(environmentView, parent, target, PivotPackage.Literals.OPERATION_CALL_EXP__ARGUMENT, null);
				return null;
			}
			finally {
				environmentView.removeFilter(filter);
			}
		}
		else {
			ExpCS explicitSource = null;
			ElementCS scopeTarget = null;	// Note that parent is null during PreOrder namespace resolution
			if (target.eContainer() instanceof InfixExpCS) {
				OperatorCS csOperator = targetElement.getParent();
				if (csOperator != null) {
					ExpCS csSource = csOperator.getSource();
					if (csSource != target) {
						scopeTarget = csOperator;
						explicitSource = csSource;
					}
				}
			}
			if (scopeTarget == null) {
				scopeTarget = targetElement.getLogicalParent();
			}
			Type type = null;
			if (explicitSource != null) {
				OclExpression source = PivotUtil.getPivot(OclExpression.class, explicitSource);
				if (source != null) {
					type = source.getType();
				}
			}
			ScopeFilter filter = createInvocationFilter(environmentView.getMetaModelManager(), targetElement, type);
			try {
				environmentView.addFilter(filter);
				BaseScopeView.computeLookups(environmentView, scopeTarget, target, PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, null);
				return null;
			}
			finally {
				environmentView.removeFilter(filter);
			} */
			return scopeView.getParent();
		}

	@Override
	public ScopeFilter createInvocationFilter(MetaModelManager metaModelManager, InvocationExpCS targetElement, Type type) {
		return new OperationFilter(metaModelManager, type, targetElement)
		{

			@Override
			public boolean matches(EnvironmentView environmentView, Type forType, EObject eObject) {
				if (eObject instanceof Relation) {
					if (iterators > 0) {
						return false;
					}
					if (accumulators > 0) {
						return false;
					}
					// No overloading to validate
/*					Relation candidateRelation = (Relation)eObject;
					List<Domain> candidateDomains = candidateRelation.getDomain();
					if (expressions != candidateDomains.size()) {
						return false;
					}
					Map<TemplateParameter, ParameterableElement> bindings = getOperationBindings(candidateRelation);
					for (int i = 0; i < expressions; i++) {
						Parameter candidateParameter = candidateParameters.get(i);
						NavigatingArgCS csExpression = csArguments.get(i);
						OclExpression expression = PivotUtil.getPivot(OclExpression.class, csExpression);
						if (expression == null) {
							return false;
						}
						Type candidateType = metaModelManager.getTypeWithMultiplicity(candidateParameter);
						if (candidateType instanceof SelfType) {
							candidateType = candidateRelation.getOwningType();
						}
						Type expressionType = expression.getType();
						expressionType = PivotUtil.getBehavioralType(expressionType);			// FIXME make this a general facility
						if (!metaModelManager.conformsTo(expressionType, candidateType, bindings)) {
							return false;
						}
					}
					if (bindings != null) {
						installBindings(environmentView, forType, eObject, bindings);
					} */
					return true;
				}
				else {
					return super.matches(environmentView, forType, eObject);
				}
			}
			
		};
	}
}
