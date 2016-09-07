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
package	org.eclipse.qvtd.pivot.qvtcorebase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtcorebase.util.AbstractQVTcoreBaseAS2XMIidVisitor;

public class QVTcoreBaseAS2XMIidVisitor extends AbstractQVTcoreBaseAS2XMIidVisitor
{
	public QVTcoreBaseAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}
}
