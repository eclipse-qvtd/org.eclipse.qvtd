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
package	org.eclipse.qvtd.pivot.qvttemplate.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.AS2Moniker;
import org.eclipse.qvtd.pivot.qvttemplate.util.AbstractQVTtemplateAS2MonikerVisitor;

public class QVTtemplateAS2MonikerVisitor extends AbstractQVTtemplateAS2MonikerVisitor
{
	public QVTtemplateAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}	
}
