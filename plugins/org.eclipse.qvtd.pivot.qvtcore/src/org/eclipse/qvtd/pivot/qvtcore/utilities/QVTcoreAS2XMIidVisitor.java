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
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.util.AbstractQVTcoreAS2XMIidVisitor;

public class QVTcoreAS2XMIidVisitor extends AbstractQVTcoreAS2XMIidVisitor
{
	public QVTcoreAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
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
}
