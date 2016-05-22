/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;

/**
 * This dummy class is solely used to terminate a plugin extension and so avoid a warning.
 */
public final class NullLabelGenerator extends AbstractLabelGenerator<AllQVTcoreTests>
{
	public NullLabelGenerator() {
		super(AllQVTcoreTests.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull AllQVTcoreTests object) {
		throw new UnsupportedOperationException();
	}
}