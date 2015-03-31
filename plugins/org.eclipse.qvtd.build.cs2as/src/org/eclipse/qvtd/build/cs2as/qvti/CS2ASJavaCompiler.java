package org.eclipse.qvtd.build.cs2as.qvti;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.build.cs2as.cgmodel.CGLookupCallExp;
import org.eclipse.qvtd.build.cs2as.cgmodel.CS2ASCGFactory;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaVisitor;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.java.QVTiGlobalContext;
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
		
		@Override
		protected @NonNull QVTiAS2CGVisitor createAS2CGVisitor(@NonNull QVTiAnalyzer analyzer,
				@NonNull QVTiGlobalContext gContext) {
			return new CS2ASAS2CGVisitor(analyzer, gContext);
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
		
		
		@Override
		public @Nullable Boolean visitCGValuedElement(CGValuedElement object) {
			// FIXME create visitor infrastructure			
			if (object instanceof CGLookupCallExp) {
				CGLookupCallExp cgCall = (CGLookupCallExp) object;
				CGValuedElement cgSource = cgCall.getSource(); // FIXME to skip env() call. Remove env() call
				TypeDescriptor typeDescriptor = context.getTypeDescriptor(object);
				if (!js.appendLocalStatements(cgSource)) {
					return false;
				}
				
				
				List<CGValuedElement> cgArguments = cgCall.getArguments();
				for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
					CGValuedElement argument = getExpression(cgArgument);
					if (!js.appendLocalStatements(argument)) {
						return false;
					}
				}

				
				js.appendClassReference("example2.env.Environment"); // FIXME
				js.append(" _lookupEnv");
				js.append(" = new ");
				js.append("org.eclipse.qvtd.build.cs2as.tests.models.example2.java.LookupEnvironment");// FIXME
				js.append("(evaluator,");
				List<Parameter> pParameters = cgCall.getReferredOperation().getOwnedParameters();
				int iMax = Math.min(pParameters.size(), cgArguments.size());
				for (int i = 0; i < iMax; i++) {
					if ((i > 0)) {
						js.append(", ");
					}
					CGValuedElement cgArgument = cgArguments.get(i);
					Parameter pParameter = pParameters.get(i);
					CGTypeId cgTypeId = analyzer.getTypeId(pParameter.getTypeId());
					TypeDescriptor parameterTypeDescriptor = context.getUnboxedDescriptor(ClassUtil.nonNullState(cgTypeId.getElementId()));
					CGValuedElement argument = getExpression(cgArgument);
					js.appendReferenceTo(parameterTypeDescriptor, argument);
				}
				js.append(");\n");
				
				js.appendClassReference("example2.classes.util.ClassesLookupVisitor"); // FIXME
				js.append(" _lookupVisitor");
				js.append(" = new ");
				js.append(" ClassesLookupVisitor(_lookupEnv);\n"); // FIXME

				
				
				js.appendClassReference(EList.class, false, "example2.classes.NamedElement"); // FIXME
				js.append(" _lookupResult");	// FIXME
				js.append(" = ");				
				js.appendReferenceTo(cgSource);
				js.append(".accept(_lookupVisitor).getNamedElements();\n");
				
				js.appendClassReference(typeDescriptor);
				js.append(" ");
				js.appendReferenceTo(cgCall);
				js.append( "= null;\n");
				js.append("if (_lookupResult.size() == 1) {\n");
				js.pushIndentation(null);
				js.appendReferenceTo(cgCall);
				js.append(" = (");
				js.appendClassReference(typeDescriptor);
				js.append(")");
				js.append(" _lookupResult.get(0);\n");
				js.popIndentation();
				// TODO what about ambigous error report ?
				js.append("} else {\n");
				js.pushIndentation(null);
				js.append("handleLookupError(");
				js.append("(");
				js.appendClassReference(EObject.class);
				js.append(")");
				js.appendReferenceTo(cgSource);
				js.append(",");
				js.appendReferenceTo(cgArguments.get(0)); // FIXMe improve handleLookupError
				js.append(");\n");
				js.popIndentation();
				js.append("};\n");
				return true;
			}
			return super.visitCGValuedElement(object);
		}
	}

	protected static class CS2ASAS2CGVisitor extends QVTiAS2CGVisitor {

		public CS2ASAS2CGVisitor(QVTiAnalyzer analyzer, QVTiGlobalContext globalContext) {
			super(analyzer, globalContext);
		}
		
		@Override
		public @NonNull CGValuedElement visitOperationCallExp(@NonNull OperationCallExp asOperationCallExp) {
			
			Operation asOperation = asOperationCallExp.getReferredOperation();
			if (isLookupOp(asOperation)) {
				CGLookupCallExp cgLookupCallExp = CS2ASCGFactory.eINSTANCE.createCGLookupCallExp();				
				setAst(cgLookupCallExp, asOperationCallExp);
				OCLExpression expSource = asOperationCallExp.getOwnedSource();
				CGValuedElement cgSource = expSource != null ? doVisit(CGValuedElement.class, expSource) : null;
				cgLookupCallExp.setSource(cgSource);
				for (OCLExpression arg :  asOperationCallExp.getOwnedArguments()) {
					CGValuedElement cgArg = doVisit(CGValuedElement.class, arg);
					cgLookupCallExp.getArguments().add(cgArg);
				}
				cgLookupCallExp.setReferredOperation(asOperation);
				return  cgLookupCallExp;
			}
			return super.visitOperationCallExp(asOperationCallExp);
		}
		
		protected boolean isLookupOp(Operation op) {
			
			String opName = op.getName();
			if (opName != null && opName.startsWith("_lookup"))	{// FIXME
				return true;
			}
			return false;
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
