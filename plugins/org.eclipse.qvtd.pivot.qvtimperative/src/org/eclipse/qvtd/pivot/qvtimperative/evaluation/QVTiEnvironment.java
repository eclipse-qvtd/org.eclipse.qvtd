/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironment;

public class QVTiEnvironment extends PivotEnvironment
{
	public QVTiEnvironment(@NonNull QVTiEnvironmentFactory factory, @Nullable Resource resource) {
		super(factory, resource);
	}

	public QVTiEnvironment(@NonNull QVTiEnvironment parent) {
		super(parent);
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getFactory() {
		return (QVTiEnvironmentFactory) super.getFactory();
	}
}
