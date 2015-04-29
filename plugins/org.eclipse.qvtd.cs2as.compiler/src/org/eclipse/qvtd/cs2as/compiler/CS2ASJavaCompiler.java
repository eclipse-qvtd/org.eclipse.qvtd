package org.eclipse.qvtd.cs2as.compiler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.cs2as.runtime.CS2ASTransformation;
import org.eclipse.qvtd.cs2as.runtime.QVTiFacade;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public interface CS2ASJavaCompiler {

	public Class<? extends CS2ASTransformation> compileTransformation(@NonNull QVTiFacade qvt,
			@NonNull Transformation transformation,	@NonNull CS2ASJavaCompilerParameters params) throws Exception;
}
