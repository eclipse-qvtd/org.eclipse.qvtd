/*******************************************************************************
 * Copyright (c) 2010, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.utilities;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;

public abstract class QVTbaseCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull URI getASURI(@NonNull URI csURI) {
		assert !PivotUtilInternal.isASURI(csURI);
		return PivotUtilInternal.appendASExtensionSuffix(csURI);
	}

	@Override
	public void setURI(URI uri) {
		assert uri != null;
		if (PivotUtilInternal.isASURI(uri)) {
			uri = PivotUtilInternal.trimASExtensionSuffix(uri);
			setDerived(true);
		}
		super.setURI(uri);
	}
}
