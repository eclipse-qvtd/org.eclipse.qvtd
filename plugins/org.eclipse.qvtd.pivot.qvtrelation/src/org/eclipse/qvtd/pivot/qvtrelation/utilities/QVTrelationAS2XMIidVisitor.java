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
package	org.eclipse.qvtd.pivot.qvtrelation.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtrelation.util.AbstractQVTrelationAS2XMIidVisitor;

public class QVTrelationAS2XMIidVisitor extends AbstractQVTrelationAS2XMIidVisitor
{
	public QVTrelationAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}	
}
