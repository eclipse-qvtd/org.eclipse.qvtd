/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.cs2as.tx.CS2ASTransformer;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;

public interface CS2ASJavaCompiler {

	public Class<? extends CS2ASTransformer> compileTransformation(@NonNull QVTimperative qvt,
			@NonNull Transformation transformation,	@NonNull CS2ASJavaCompilerParameters params) throws Exception;
}
