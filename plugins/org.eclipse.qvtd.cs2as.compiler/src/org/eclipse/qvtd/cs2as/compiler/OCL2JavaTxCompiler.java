package org.eclipse.qvtd.cs2as.compiler;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.cs2as.runtime.CS2ASTransformation;

public interface OCL2JavaTxCompiler<P extends OCL2JavaTxCompilerParams> {
	
	public Class<? extends CS2ASTransformation> compileTransformation(@NonNull URI oclFileURI, @NonNull P params, @Nullable ResourceSet rset) throws Exception;
}
