package org.eclipse.qvtd.build.cs2as.qvti;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;

public class QVTi2JavaCompiler {

	// Copied from QVTiCompilerTest
	@SuppressWarnings("unchecked")
	protected Class<? extends AbstractTransformationExecutor> compileTransformation(@NonNull QVTiCodeGenerator cg) throws Exception {
		String qualifiedName = cg.getQualifiedName();
		String javaCodeSource = cg.generateClassFile();
		
		Class<?> txClass = OCL2JavaFileObject.loadClass(qualifiedName, javaCodeSource);
		return (Class<? extends AbstractTransformationExecutor>) txClass;
		
	}
	
	
	// Copied from QVTiCompilerTest
	public Class<? extends AbstractTransformationExecutor> compileTransformation(@NonNull QVTiFacade qvt,
			@NonNull Transformation transformation,	@Nullable String savePath, @NonNull String packagePrefix) throws Exception {
				
		QVTiCodeGenerator cg = new QVTiCodeGenerator(qvt.getEnvironmentFactory(), transformation);
		QVTiCodeGenOptions options = cg.getOptions();
		options.setPackagePrefix(packagePrefix);
		cg.generateClassFile();
		if (savePath != null) {
			cg.saveSourceFile(savePath);
		}
		return  compileTransformation(cg);
	}
}
