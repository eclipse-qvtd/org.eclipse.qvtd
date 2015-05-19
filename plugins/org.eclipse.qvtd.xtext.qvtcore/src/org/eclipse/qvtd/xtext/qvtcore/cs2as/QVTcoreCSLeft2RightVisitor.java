/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.qvtd.xtext.qvtcorecs.util.AbstractQVTcoreCSLeft2RightVisitor;

public class QVTcoreCSLeft2RightVisitor extends AbstractQVTcoreCSLeft2RightVisitor
{
	public QVTcoreCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}
}