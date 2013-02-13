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
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcore.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.xtext.base.attributes.PivotCSAttribution;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.attributes.QVTcoreEnvironmentUtil;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QVTcoreCSTPackage;

public class MappingCallBindingCSAttribution extends PivotCSAttribution
{
	public static final @NonNull MappingCallBindingCSAttribution INSTANCE = new MappingCallBindingCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		MappingCallBindingCS csMappingCallBinding = (MappingCallBindingCS)target;
		EStructuralFeature targetReference = environmentView.getReference();
		if (targetReference == QVTcoreCSTPackage.Literals.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE) {
			MappingCallCS mappingCall = csMappingCallBinding.getMappingCall();
			if (mappingCall != null) {
				Mapping mapping = mappingCall.getReferredMapping();
				QVTcoreEnvironmentUtil.addMiddleGuardVariables(environmentView, mapping);
				QVTcoreEnvironmentUtil.addSideGuardVariables(environmentView, mapping, null);
			}
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
