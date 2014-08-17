/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.AbstractAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.attributes.QVTimperativeEnvironmentUtil;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage;

public class MappingLoopCSAttribution extends AbstractAttribution
{
	public static final @NonNull MappingLoopCSAttribution INSTANCE = new MappingLoopCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		MappingLoopCS csMappingLoop = (MappingLoopCS)target;
		if (containmentFeature == QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS__IN_EXPRESSION) {
			EObject eContainer = csMappingLoop.eContainer();
			while ((eContainer != null) && !(eContainer instanceof MappingCS)) {
				eContainer = eContainer.eContainer();
			}
			if (eContainer instanceof MappingCS) {
				Mapping mapping = PivotUtil.getPivot(Mapping.class, (MappingCS)eContainer);
				if (mapping != null) {
					QVTimperativeEnvironmentUtil.addMiddleGuardVariables(environmentView, mapping);
					QVTimperativeEnvironmentUtil.addSideGuardVariables(environmentView, mapping, null);
					QVTimperativeEnvironmentUtil.addMiddleBottomVariables(environmentView, mapping);
					QVTimperativeEnvironmentUtil.addSideBottomVariables(environmentView, mapping, null);
					Transformation transformation = QVTimperativeUtil.getContainingTransformation(mapping);
					if (transformation != null) {
						for (TypedModel typedModel : transformation.getModelParameter()) {
							for (org.eclipse.ocl.examples.pivot.Package usedPackage : typedModel.getUsedPackage()) {
								if (usedPackage != null) {
									environmentView.addNamedElement(usedPackage);
									environmentView.addAllTypes(usedPackage);
								}
							}
						}
					}
				}
			}
		}
//		environmentView.addNamedElement(PivotUtil.getPivot(LoopVariable.class,csMappingLoop.getOwnedIterator()));
		return scopeView.getParent();
	}
}
