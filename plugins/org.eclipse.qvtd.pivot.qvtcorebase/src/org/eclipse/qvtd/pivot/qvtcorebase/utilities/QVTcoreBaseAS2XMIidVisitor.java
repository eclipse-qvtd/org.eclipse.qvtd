/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
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
import org.eclipse.ocl.examples.pivot.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractQVTcoreBaseAS2XMIidVisitor;

public class QVTcoreBaseAS2XMIidVisitor extends AbstractQVTcoreBaseAS2XMIidVisitor
{
	public QVTcoreBaseAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
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
}
