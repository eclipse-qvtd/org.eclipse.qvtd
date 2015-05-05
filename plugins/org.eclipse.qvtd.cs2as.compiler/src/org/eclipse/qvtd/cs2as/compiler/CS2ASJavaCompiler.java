package org.eclipse.qvtd.cs2as.compiler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.cs2as.runtime.CS2ASTransformation;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;

public interface CS2ASJavaCompiler {

	public Class<? extends CS2ASTransformation> compileTransformation(@NonNull QVTimperative qvt,
			@NonNull Transformation transformation,	@NonNull CS2ASJavaCompilerParameters params) throws Exception;
}
