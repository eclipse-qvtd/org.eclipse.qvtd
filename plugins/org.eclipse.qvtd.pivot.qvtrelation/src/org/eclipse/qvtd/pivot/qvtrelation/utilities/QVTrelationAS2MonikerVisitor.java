/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtrelation.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.qvtd.pivot.qvtrelation.util.AbstractQVTrelationAS2MonikerVisitor;

public class QVTrelationAS2MonikerVisitor extends AbstractQVTrelationAS2MonikerVisitor
{
	public QVTrelationAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}	
}
