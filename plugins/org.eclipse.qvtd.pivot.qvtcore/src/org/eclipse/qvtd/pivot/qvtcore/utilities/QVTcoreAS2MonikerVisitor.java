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
package	org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.qvtd.pivot.qvtcore.util.AbstractQVTcoreAS2MonikerVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;

public class QVTcoreAS2MonikerVisitor extends AbstractQVTcoreAS2MonikerVisitor
{
	public QVTcoreAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}

	@Override
	public @Nullable Object visitAssignment(@NonNull Assignment object) {
		return null;
	}

	@Override
	public @Nullable Object visitBottomPattern(@NonNull BottomPattern asBottomPattern) {
		context.appendParent(asBottomPattern, MONIKER_SCOPE_SEPARATOR);
		context.append("bottom");
		return true;
	}

	@Override
	public @Nullable Object visitEnforcementOperation(@NonNull EnforcementOperation object) {
		return null;
	}

	@Override
	public @Nullable Object visitGuardPattern(@NonNull GuardPattern asGuardPattern) {
		context.appendParent(asGuardPattern, MONIKER_SCOPE_SEPARATOR);
		context.append("guard");
		return true;
	}
}
