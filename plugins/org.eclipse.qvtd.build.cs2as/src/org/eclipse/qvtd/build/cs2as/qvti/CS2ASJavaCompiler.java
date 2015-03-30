package org.eclipse.qvtd.build.cs2as.qvti;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaVisitor;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class CS2ASJavaCompiler {

	protected static class CS2ASJavaCodeGenerator extends QVTiCodeGenerator
	{
		protected CS2ASJavaCodeGenerator(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
			super(environmentFactory, transformation);
		}

		@Override
		protected @NonNull QVTiCG2JavaVisitor createCG2JavaVisitor(@NonNull CGPackage cgPackage, @Nullable List<CGValuedElement> sortedGlobals) {
			return new CS2ASCG2JavaVisitor(this, cgPackage, sortedGlobals);
		}
	}

	protected static class CS2ASCG2JavaVisitor extends QVTiCG2JavaVisitor
	{
		protected CS2ASCG2JavaVisitor(@NonNull QVTiCodeGenerator codeGenerator, @NonNull CGPackage cgPackage, @Nullable List<CGValuedElement> sortedGlobals) {
			super(codeGenerator, cgPackage, sortedGlobals);
		}

		@Override
		protected void appendGuardFailure(@NonNull CGGuardExp cgGuardExp) {
			CGMapping cgMapping = QVTiCGUtil.getContainingCGMapping(cgGuardExp);
			if (cgMapping != null) {
				List<CGGuardVariable> freeVariables = cgMapping.getFreeVariables();
				if (freeVariables.size() > 0) {
					CGGuardVariable cgGuardVariable = freeVariables.get(0);
					js.append("throwNull(");
					js.appendValueName(cgGuardVariable);
					js.append(", ");
					js.appendString("Null " + cgGuardExp.getMessage());
//					js.append(", ");
//					CGValuedElement element = cgGuardExp.getElement();
//					Object object = element != null ? element.getAst() : null;
//					element js.appendValueName(element);
//					js.append("null/ *" + (element != null ? element.eClass().getName() : "null") + "," + (object instanceof EObject ? ((EObject)object).eClass().getName() : "null") + "* /");
//					js.append(", ");
//					js.appendString(cgGuardExp.getFeature().getName());
					js.append(");\n");
					return;
				}
			}
//			CGUtil.createCGParameter(name, typeId)
			super.appendGuardFailure(cgGuardExp);
		}

		protected @NonNull Class<? extends AbstractTransformationExecutor> getAbstractTransformationExecutorClass() {
			return CS2ASTransformationExecutor.class;
		}
	}


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
				
		QVTiCodeGenerator cg = new CS2ASJavaCodeGenerator(qvt.getEnvironmentFactory(), transformation);
		QVTiCodeGenOptions options = cg.getOptions();
		options.setPackagePrefix(packagePrefix);
		cg.generateClassFile();
		if (savePath != null) {
			cg.saveSourceFile(savePath);
		}
		return compileTransformation(cg);
	}
}
