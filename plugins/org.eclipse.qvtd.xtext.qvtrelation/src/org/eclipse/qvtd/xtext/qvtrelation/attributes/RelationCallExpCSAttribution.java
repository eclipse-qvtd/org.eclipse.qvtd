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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainElement;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.PivotPackage;
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

public class RelationCallExpCSAttribution extends InvocationExpCSAttribution
{
	public static final RelationCallExpCSAttribution INSTANCE = new RelationCallExpCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		InvocationExpCS targetElement = (InvocationExpCS)target;
		OCLExpression pivot = PivotUtil.getPivot(OCLExpression.class, targetElement);
		if ((pivot instanceof CallExp) || (pivot == null)) {
			return super.computeLookup(target, environmentView, scopeView);
		}
		else {
			return scopeView.getParent();
		}
	}

	@Override
	public @NonNull ScopeFilter createInvocationFilter(@NonNull MetaModelManager metaModelManager, @NonNull InvocationExpCS targetElement, @Nullable Type type) {
		return new OperationFilter(metaModelManager, type, targetElement)
		{
			@Override
			public boolean matches(@NonNull EnvironmentView environmentView, @NonNull DomainElement eObject) {
				if (eObject instanceof Relation) {
					if (iterators > 0) {
						return false;
					}
					if (accumulators > 0) {
						return false;
					}
					return true;
				}
				else {
					return super.matches(environmentView, eObject);
				}
			}
			
		};
	}

	@Override
	protected boolean isRequiredType(@NonNull EnvironmentView environmentView) {
		EClassifier requiredType = environmentView.getRequiredType();
		if (!(requiredType instanceof EClass)) {
			return false;
		}
		if (PivotPackage.Literals.NAMED_ELEMENT.isSuperTypeOf((EClass)requiredType)) {
			return true;
		}
//		if (PivotPackage.Literals.OPERATION.isSuperTypeOf((EClass)requiredType)) {
//			return true;
//		}
//		if (QVTbasePackage.Literals.RULE.isSuperTypeOf((EClass)requiredType)) {
//			return true;
//		}
		return false;
	}
}
