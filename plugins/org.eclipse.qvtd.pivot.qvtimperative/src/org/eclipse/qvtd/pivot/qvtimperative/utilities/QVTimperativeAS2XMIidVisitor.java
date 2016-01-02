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
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractQVTimperativeAS2XMIidVisitor;

public class QVTimperativeAS2XMIidVisitor extends AbstractQVTimperativeAS2XMIidVisitor
{
	protected QVTimperativeAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}

	private void appendParentStatements(EObject object) {
		EObject eContainer = object.eContainer();
		if (eContainer instanceof MappingStatement) {
			appendParentStatements(eContainer);
			EObject eContainer2 = eContainer.eContainer();
			int index = 0;
			if (eContainer2 != null) {
				Object eChild = eContainer2.eGet(eContainer.eContainingFeature());
				if (eContainer.eContainingFeature().isMany()) {
					index = ((List<?>)eChild).indexOf(eContainer);
				}
			}
			s.append(index);
			s.append(SCOPE_SEPARATOR);
		}
	}

	@Override
	public @Nullable Boolean visitMapping(@NonNull Mapping object) {
		s.append(MAPPING_PREFIX);
		appendParent(object);
		appendName(object.getName());
		return true;
	}

	@Override
	public @Nullable Boolean visitMappingCall(@NonNull MappingCall object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitMappingCallBinding(@NonNull MappingCallBinding object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitMappingStatement(@NonNull MappingStatement object) {
		return super.visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitVariable(@NonNull Variable object) {
		if (object.eContainer() instanceof MappingLoop) {
			Rule rule = QVTcoreBaseUtil.getContainingRule(object);
			if ((rule != null) && (rule.getName() != null)) {
				String name = object.getName();
				if (name != null) {
					s.append(ITERATION_PREFIX);
					appendParent(rule);
					appendNameOf(rule);
					s.append(SCOPE_SEPARATOR);
					appendParentStatements(object);
					appendName(name);
					return true;
				}
			}
			return null;
		}
		return super.visitVariable(object);
	}
}
