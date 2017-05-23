/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class MappingAttribution extends AbstractAttribution
{
	public static final @NonNull MappingAttribution INSTANCE = new MappingAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		if ((environmentView.accepts(QVTbasePackage.Literals.TRANSFORMATION)) && (target.eContainer() == null)) {
			environmentView.addRootPackages();
			return null;
		}
		Mapping mapping = (Mapping)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		/*		if ((containmentFeature == QVTimperativePackage.Literals.MAPPING__GUARD_PREDICATES)
				|| (containmentFeature == QVTimperativePackage.Literals.MAPPING__OWNED_PREDICATE_VARIABLES)
				|| (containmentFeature == QVTimperativePackage.Literals.MAPPING__OWNED_LOCAL_VARIABLES)) {
			EObject child = scopeView.getChild();
			for (Statement asStatement : mapping.getOwnedStatements()) {
				if (asStatement == child) {
					break;
				}
				if (asStatement instanceof VariableStatement) {
					environmentView.addNamedElement(asStatement);
				}
			}
			QVTimperativeEnvironmentUtil.addMiddleGuardVariables(environmentView, mapping);
			QVTimperativeEnvironmentUtil.addSideGuardVariables(environmentView, mapping, null);
			QVTimperativeEnvironmentUtil.addMiddleBottomVariables(environmentView, mapping);
			QVTimperativeEnvironmentUtil.addSideBottomVariables(environmentView, mapping, null);
			Transformation transformation = QVTimperativeUtil.getContainingTransformation(mapping);
			if (transformation != null) {
				for (TypedModel typedModel : transformation.getModelParameter()) {
					for (org.eclipse.ocl.pivot.Package usedPackage : typedModel.getUsedPackage()) {
						if (usedPackage != null) {
							environmentView.addNamedElement(usedPackage);
							environmentView.addAllTypes(usedPackage);
						}
					}
				}
			}

		}
		else*/ if (containmentFeature == QVTimperativePackage.Literals.MAPPING__OWNED_STATEMENTS) {
			EObject child = scopeView.getChild();
			for (Statement asStatement : mapping.getOwnedStatements()) {
				if (asStatement == child) {
					break;
				}
				if (asStatement instanceof VariableStatement) {
					environmentView.addNamedElement(asStatement);
				}
			}
			environmentView.addNamedElements(QVTimperativeUtil.getOwnedMappingParameters(mapping));
			ImperativeTransformation transformation = QVTimperativeUtil.basicGetContainingTransformation(mapping);
			if (transformation != null) {
				for (@NonNull ImperativeTypedModel typedModel : QVTimperativeUtil.getOwnedTypedModels(transformation)) {
					for (org.eclipse.ocl.pivot.Package usedPackage : typedModel.getUsedPackage()) {
						if (usedPackage != null) {
							environmentView.addNamedElement(usedPackage);
							environmentView.addAllTypes(usedPackage);
						}
					}
				}
			}
		}
		return scopeView.getParent();
	}
}
