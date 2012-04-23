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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeFilter;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.InvocationExpCSAttribution;
import org.eclipse.ocl.examples.xtext.essentialocl.attributes.OperationFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

public class RelationCallExpCSAttribution extends InvocationExpCSAttribution
{
	public static final RelationCallExpCSAttribution INSTANCE = new RelationCallExpCSAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
		return super.computeLookup(target, environmentView, scopeView);
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
