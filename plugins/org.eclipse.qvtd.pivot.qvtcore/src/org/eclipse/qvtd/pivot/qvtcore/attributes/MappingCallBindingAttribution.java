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
 *
 * $Id: PackageAttribution.java,v 1.4 2011/04/20 19:02:27 ewillink Exp $
 */
package org.eclipse.qvtd.pivot.qvtcore.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.scoping.EmptyAttribution;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.MappingCall;
import org.eclipse.qvtd.pivot.qvtcore.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;

public class MappingCallBindingAttribution extends EmptyAttribution
{
	public static final MappingCallBindingAttribution INSTANCE = new MappingCallBindingAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		MappingCallBinding mappingCallBinding = (MappingCallBinding)target;
		MappingCall mappingCall = mappingCallBinding.getMappingCall();
		if (mappingCall != null) {
			Mapping referredMapping = mappingCall.getReferredMapping();
			if (referredMapping != null) {
				Mapping mapping = mappingCall.getContext();
				Variable boundVariable = mappingCallBinding.getBoundVariable();
				Area area = QVTcoreUtil.getContainingArea(boundVariable);
				if (area instanceof Mapping) {
					QVTcoreEnvironmentUtil.addMiddleBottomVariables(environmentView, mapping);
				} else if (area instanceof Domain) {
					TypedModel typedModel = ((Domain) area).getTypedModel();
					QVTcoreEnvironmentUtil.addSideBottomVariables(environmentView, mapping, typedModel);
				}
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
