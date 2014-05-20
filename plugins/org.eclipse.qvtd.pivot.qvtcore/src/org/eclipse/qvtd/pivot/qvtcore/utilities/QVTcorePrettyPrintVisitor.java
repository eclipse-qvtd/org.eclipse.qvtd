/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBasePrettyPrintVisitor;

public class QVTcorePrettyPrintVisitor extends QVTcoreBasePrettyPrintVisitor implements QVTcoreVisitor<Object>
{	
	public QVTcorePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	public Object visitCoreModel(@NonNull CoreModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitMapping(@NonNull Mapping object) {
		// TODO Auto-generated method stub
		return null;
	}
}
