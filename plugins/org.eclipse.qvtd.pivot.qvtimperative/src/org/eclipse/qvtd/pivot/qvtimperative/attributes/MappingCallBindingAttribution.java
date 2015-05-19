/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.scoping.EmptyAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;

public class MappingCallBindingAttribution extends EmptyAttribution
{
	public static final MappingCallBindingAttribution INSTANCE = new MappingCallBindingAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		MappingCallBinding mappingCallBinding = (MappingCallBinding)target;
		MappingCall mappingCall = mappingCallBinding.getMappingCall();
		if (mappingCall != null) {
			EStructuralFeature targetReference = environmentView.getReference();
			if (targetReference.getEType() == PivotPackage.Literals.VARIABLE) {
				Mapping referredMapping = mappingCall.getReferredMapping();
				if (referredMapping != null) {
					QVTimperativeEnvironmentUtil.addMiddleGuardVariables(environmentView, referredMapping);
					QVTimperativeEnvironmentUtil.addSideGuardVariables(environmentView, referredMapping, null);
				}
			}
			else {		// FIXME Distinguish referred.context mapping
				EObject eContainer = mappingCall.eContainer();
				if (eContainer instanceof Mapping) {
					Mapping mapping = (Mapping)eContainer;
					QVTimperativeEnvironmentUtil.addMiddleGuardVariables(environmentView, mapping);
					QVTimperativeEnvironmentUtil.addSideGuardVariables(environmentView, mapping, null);
					QVTimperativeEnvironmentUtil.addMiddleBottomVariables(environmentView, mapping);
					QVTimperativeEnvironmentUtil.addSideBottomVariables(environmentView, mapping, null);
				}
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
