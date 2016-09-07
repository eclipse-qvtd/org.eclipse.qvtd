/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.util.AbstractQVTcoreAS2XMIidVisitor;

public class QVTcoreAS2XMIidVisitor extends AbstractQVTcoreAS2XMIidVisitor
{
	public static final @NonNull String MAPPING_PREFIX = "m."; //$NON-NLS-1$

	public QVTcoreAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}

	@Override
	protected void appendNameOf(@NonNull Object element) {
		if (element instanceof BottomPattern) {
			appendName("bottom");
		}
		else if (element instanceof GuardPattern) {
			appendName("guard");
		}
		else {
			super.appendNameOf(element);
		}
	}

	@Override
	public @Nullable Boolean visitAssignment(@NonNull Assignment object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitCoreDomain(@NonNull CoreDomain asCoreDomain) {
		return null;
	}

	@Override
	public @Nullable Boolean visitCorePattern(@NonNull CorePattern asCorePattern) {
		return null;
	}

	@Override
	public @Nullable Boolean visitEnforcementOperation(@NonNull EnforcementOperation object) {
		return false;
	}

	@Override
	public @Nullable Boolean visitMapping(@NonNull Mapping object) {
		String name = object.getName();
		if (name == null) {
			return null;
		}
		s.append(MAPPING_PREFIX);
		appendParent(object);
		appendName(name);
		return true;
	}

	@Override
	public @Nullable Boolean visitRealizedVariable(@NonNull RealizedVariable object) {
		if (object.eContainer() instanceof CorePattern) {
			Rule rule = QVTcoreUtil.getContainingRule(object);
			if((rule != null) && (rule.getName() != null)) {
				String name = object.getName();
				if (name != null) {
					s.append(VARIABLE_PREFIX);
					appendParent(object);
					appendName(name);
					return true;
				}
			}
		}
		return super.visitRealizedVariable(object);
	}

	@Override
	public @Nullable Boolean visitVariable(@NonNull Variable object) {
		EObject eContainer = object.eContainer();
		if (eContainer instanceof CorePattern) {
			Rule rule = QVTcoreUtil.getContainingRule(object);
			if((rule != null) && (rule.getName() != null)) {
				String name = object.getName();
				if (name != null) {
					s.append(VARIABLE_PREFIX);
					appendParent(object);
					appendName(name);
					return true;
				}
			}
		}
		return super.visitVariable(object);
	}
}
