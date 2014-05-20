/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.scoping.EmptyAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class MappingCallBindingAttribution extends EmptyAttribution
{
	public static final MappingCallBindingAttribution INSTANCE = new MappingCallBindingAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		MappingCallBinding mappingCallBinding = (MappingCallBinding)target;
		MappingCall mappingCall = mappingCallBinding.getMappingCall();
		if (mappingCall != null) {		// FIXME Distingish referred.context mapping
			Mapping referredMapping = mappingCall.getReferredMapping();
			if (referredMapping != null) {
				Variable boundVariable = mappingCallBinding.getBoundVariable();
				Area area = QVTimperativeUtil.getContainingArea(boundVariable);
				if (area instanceof Mapping) {
					QVTimperativeEnvironmentUtil.addMiddleBottomVariables(environmentView, referredMapping);
				} else if (area instanceof Domain) {
					TypedModel typedModel = ((Domain) area).getTypedModel();
					QVTimperativeEnvironmentUtil.addSideBottomVariables(environmentView, referredMapping, typedModel);
				}
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
