/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.SpeculateStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractQVTimperativeAS2XMIidVisitor;

@SuppressWarnings("deprecation")
public class QVTimperativeAS2XMIidVisitor extends AbstractQVTimperativeAS2XMIidVisitor
{
	public static final @NonNull String MAPPING_PREFIX = "m."; //$NON-NLS-1$

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
	public @Nullable Boolean visitEntryPoint(@NonNull EntryPoint entryPoint) {
		return visitMapping(entryPoint);
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
	public @Nullable Boolean visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitMappingStatement(@NonNull MappingStatement object) {
		return super.visitMappingStatement(object);
	}

	@Override
	public @Nullable Boolean visitNewStatement(@NonNull NewStatement object) {
		//		if (object.eContainer() instanceof ImperativePattern) {
		Mapping rule = QVTimperativeUtil.getContainingMapping(object);
		if (rule.getName() != null) {
			String name = object.getName();
			if (name != null) {
				s.append(VARIABLE_PREFIX);
				appendParent(object);
				appendName(name);
				return true;
			}
		}
		//		}
		return super.visitNewStatement(object);
	}

	@Override
	public @Nullable Boolean visitNewStatementPart(@NonNull NewStatementPart object) {
		return visiting(object);
	}

	@Override
	public @Nullable Boolean visitSpeculateStatement(@NonNull SpeculateStatement object) {
		return visitStatement(object);
	}

	@Override
	public @Nullable Boolean visitVariable(@NonNull Variable object) {
		if (object.eContainer() instanceof MappingLoop) {
			Mapping rule = QVTimperativeUtil.basicGetContainingMapping(object);
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
