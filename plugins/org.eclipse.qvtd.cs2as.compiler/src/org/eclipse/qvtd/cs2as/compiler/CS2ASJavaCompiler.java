/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.runtime.internal.cs2as.CS2ASTransformer;

public interface CS2ASJavaCompiler {

	public Class<? extends CS2ASTransformer> compileTransformation(@NonNull QVTimperativeEnvironmentFactory environmentFactory,
			@NonNull ImperativeTransformation iTransformation,	@NonNull CS2ASJavaCompilerParameters params) throws Exception;
}
