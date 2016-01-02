/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtcorebase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractQVTcoreBaseAS2XMIidVisitor;

public class QVTcoreBaseAS2XMIidVisitor extends AbstractQVTcoreBaseAS2XMIidVisitor
{
	public static final @NonNull String MAPPING_PREFIX = "m."; //$NON-NLS-1$
	
	public QVTcoreBaseAS2XMIidVisitor(@NonNull AS2XMIid context) {
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
	public @Nullable Boolean visitRealizedVariable(@NonNull RealizedVariable object) {
		if (object.eContainer() instanceof CorePattern) {
			Rule rule = QVTcoreBaseUtil.getContainingRule(object);
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
		if (object.eContainer() instanceof CorePattern) {
			Rule rule = QVTcoreBaseUtil.getContainingRule(object);
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
