package org.eclipse.qvtd.cs2as.compiler.internal;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalysisVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiBoxingAnalyzer;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiDependencyVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiFieldingAnalyzer;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiReferencesVisitor;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaPreVisitor;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaVisitor;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.java.QVTiGlobalContext;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompiler;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGFactory;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.util.CS2ASCGModelVisitor;
import org.eclipse.qvtd.cs2as.runtime.CS2ASTransformation;
import org.eclipse.qvtd.cs2as.runtime.CS2ASTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;


public class CS2ASJavaCompilerImpl implements CS2ASJavaCompiler {

	protected static class CS2ASJavaCodeGenerator extends QVTiCodeGenerator
	{
		private  @NonNull CS2ASJavaCompilerParameters params;
		
		protected CS2ASJavaCodeGenerator(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation,
				@NonNull CS2ASJavaCompilerParameters params) {
			super(environmentFactory, transformation);
			this.params = params;
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
		
		@Override
		public @NonNull AnalysisVisitor createAnalysisVisitor() {
			return new CS2ASAnalysisVisitor(cgAnalyzer);
		}
		
		@Override
		public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		
			return new CS2ASBoxingAnalyser(cgAnalyzer);
		}
		
		@Override
		public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
			return new CS2ASFieldingAnalyser(cgAnalyzer);
		}
		
		@Override
		public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
			return new CS2ASCG2JavaPreVisitor(getGlobalContext());
		}
		
		@Override
		public @NonNull ReferencesVisitor createReferencesVisitor() {
			return CS2ASReferencesVisitor.INSTANCE;
		}
		
		@Override
		public @NonNull DependencyVisitor createDependencyVisitor() {
			return new CS2ASDependencyVisitor(cgAnalyzer, getGlobalContext(),
					getGlobalPlace());
		}
		
		public @NonNull CS2ASJavaCompilerParameters getCGParameters() {
			return params;
		}
	}

	protected static class CS2ASCG2JavaVisitor extends QVTiCG2JavaVisitor implements CS2ASCGModelVisitor<Boolean>
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
		@Nullable
		public Boolean visitCGLookupCallExp(CGLookupCallExp cgCall) {
			CS2ASJavaCompilerParameters params = ((CS2ASJavaCodeGenerator)getCodeGenerator()).getCGParameters();
			
			CGValuedElement cgSource = cgCall.getSource(); // FIXME to skip env() call. Remove env() call
			TypeDescriptor typeDescriptor = context.getTypeDescriptor(cgCall);
			if (!js.appendLocalStatements(cgSource)) {
				return false;
			}
			
			
			List<CGValuedElement> cgArguments = cgCall.getArguments();
			for (@NonNull CGValuedElement cgArgument : cgArguments) {
				CGValuedElement argument = getExpression(cgArgument);
				if (!js.appendLocalStatements(argument)) {
					return false;
				}
			}
			
			String envClassName = params.getEnviromentClassName();
			String envClassSymbol = getSymbolName(envClassName + cgCall.hashCode(), "_lookupEnv");
			js.appendClassReference(envClassName);
			js.append(" ");
			js.append(envClassSymbol);
			js.append(" = new ");
			js.append(envClassName);
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
			
			String visitorClassName = params.getVisitorClassName();
			String visitorClassSymbol = getSymbolName(visitorClassName + cgCall.hashCode(), "_lookupVisitor");
			js.appendClassReference(visitorClassName);
			js.append(" ");
			js.append(visitorClassSymbol);
			js.append(" = new ");
			js.append(params.getVisitorClassName());
			js.append("(");
			js.append(envClassSymbol);
			js.append(");\n");
			
			// FIXME what if there is not common named element class name ?
			String namedElemClassName = params.getNamedElementClassName();
			String resultSymbol = getSymbolName(namedElemClassName + cgCall.hashCode(), "_lookupResult");
			js.appendClassReference(EList.class, false, namedElemClassName); 
			js.append(" ");
			js.append(resultSymbol);	
			js.append(" = ");				
			js.appendReferenceTo(cgSource);
			js.append(".accept(");
			js.append(visitorClassSymbol);
			js.append(").getNamedElements();\n");
			
			js.appendClassReference(typeDescriptor);
			js.append(" ");
			js.appendReferenceTo(cgCall);
			js.append( " = null;\n");
			js.append("if ("+resultSymbol+".size() == 1) {\n");
			js.pushIndentation(null);
			js.appendReferenceTo(cgCall);
			js.append(" = (");
			js.appendClassReference(typeDescriptor);
			js.append(")");
			js.append(resultSymbol+".get(0);\n");
			js.popIndentation();
			// TODO what about ambigous error report ?
			js.append("} else {\n");
			js.pushIndentation(null);
			
			CGValuedElement lookupArg = cgArguments.get(0); // FIXMe improve handleLookupError
			CGValuedElement initialSource = initialSourceCG(lookupArg);
			js.append("handleLookupError(");
			js.appendReferenceTo(initialSource); 
			js.append(",");
			js.appendReferenceTo(lookupArg);
			js.append(");\n");
			
			js.popIndentation();
			js.append("};\n");
			return true;
		}
		
		/**
		 * @param cgValue
		 * @return helper to obtain the initial CGValuedElement corresponding to the source of the lookupCall argument
		 */
		private CGValuedElement initialSourceCG(CGValuedElement cgValue) {
			if (cgValue instanceof CGVariableExp) {
				CGValuedElement cgVarInit = ((CGVariableExp) cgValue).getReferredVariable().getInit();
				if (cgVarInit == null) {
					return cgValue;
				} else {
					return cgVarInit == cgValue ? cgVarInit : initialSourceCG(cgVarInit);	
				}
				
			} else if (cgValue instanceof CGCallExp) {
				CGValuedElement cgSource = ((CGCallExp) cgValue).getSource();
				return initialSourceCG(cgSource);
			}
			return cgValue;
		}
	}

	protected static class CS2ASAS2CGVisitor extends QVTiAS2CGVisitor {

		public CS2ASAS2CGVisitor(QVTiAnalyzer analyzer, QVTiGlobalContext globalContext) {
			super(analyzer, globalContext);
		}
		
		@Override
		protected @NonNull CGValuedElement generateOperationCallExp(@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
			
			Operation asOperation = asOperationCallExp.getReferredOperation();
			if (isLookupOp(asOperation)) {
				CGLookupCallExp cgLookupCallExp = CS2ASCGFactory.eINSTANCE.createCGLookupCallExp();				
				setAst(cgLookupCallExp, asOperationCallExp);
				cgLookupCallExp.setSource(cgSource);
				for (OCLExpression arg :  asOperationCallExp.getOwnedArguments()) {
					CGValuedElement cgArg = doVisit(CGValuedElement.class, arg);
					cgLookupCallExp.getArguments().add(cgArg);
				}
				cgLookupCallExp.setReferredOperation(asOperation);
				return  cgLookupCallExp;
			}
			return super.generateOperationCallExp(cgSource, asOperationCallExp);
		}
		
		protected boolean isLookupOp(Operation op) {
			
			String opName = op.getName();
			if (opName != null && opName.startsWith("_lookup"))	{// FIXME
				return true;
			}
			return false;
		}
	}
	
	protected static class CS2ASAnalysisVisitor extends QVTiAnalysisVisitor 
		implements CS2ASCGModelVisitor<Object> {

		public CS2ASAnalysisVisitor(QVTiAnalyzer analyzer) {
			super(analyzer);
		}

		@Override
		@Nullable
		public Object visitCGLookupCallExp(CGLookupCallExp object) {
			return visitCGOperationCallExp(object);
		}
	}
	
	protected static class CS2ASBoxingAnalyser extends QVTiBoxingAnalyzer
		implements CS2ASCGModelVisitor<Object> {
		
		public CS2ASBoxingAnalyser(QVTiAnalyzer analyzer) {
			super(analyzer);
		}

		@Override
		@Nullable
		public Object visitCGLookupCallExp(CGLookupCallExp object) {
			return visitCGOperationCallExp(object);
		}
	}
	
	protected static class CS2ASFieldingAnalyser extends QVTiFieldingAnalyzer {
	
		protected static class CS2ASAnalysisVisitor extends QVTiFieldingAnalyzer.QVTiAnalysisVisitor
		implements CS2ASCGModelVisitor<Set<CGVariable>> {
			public CS2ASAnalysisVisitor(QVTiFieldingAnalyzer context) {
				super(context);
			}

			@Override
			@Nullable
			public Set<CGVariable> visitCGLookupCallExp(CGLookupCallExp object) {
				return visitCGOperationCallExp(object);
			}
		}
		
		protected static class CS2ASRewriteVisitor extends QVTiFieldingAnalyzer.QVTiRewriteVisitor
		implements CS2ASCGModelVisitor<Boolean> {
			public CS2ASRewriteVisitor(@NonNull QVTiAnalyzer context, @NonNull Set<CGVariable> caughtVariable) {
				super(context, caughtVariable);
			}

			@Override
			@Nullable
			public Boolean visitCGLookupCallExp(CGLookupCallExp object) {
				return visitCGOperationCallExp(object);
			}
		}
		
		
		
		public CS2ASFieldingAnalyser(QVTiAnalyzer analyzer) {
			super(analyzer);
		}
	
		@Override
		protected @NonNull AnalysisVisitor createAnalysisVisitor() {
			return new CS2ASAnalysisVisitor(this);
		}
		
		@Override
		protected @NonNull RewriteVisitor createRewriteVisitor(@NonNull Set<CGVariable> caughtVariables) {
			return new CS2ASRewriteVisitor((QVTiAnalyzer)analyzer, caughtVariables);
		}
	}

	
	protected static class CS2ASCG2JavaPreVisitor extends QVTiCG2JavaPreVisitor
		implements CS2ASCGModelVisitor<Object> {
		
		public CS2ASCG2JavaPreVisitor(QVTiGlobalContext globalContext) {
			super(globalContext);
		}

		@Override
		@Nullable
		public Object visitCGLookupCallExp(CGLookupCallExp object) {
			return visitCGOperationCallExp(object);
		}
	}
	
	protected static class CS2ASReferencesVisitor extends QVTiReferencesVisitor
		implements CS2ASCGModelVisitor<List<Object>> {
	
		protected static CS2ASReferencesVisitor INSTANCE = new CS2ASReferencesVisitor(new Object());
		
		public CS2ASReferencesVisitor(Object context) {
			super(context);
		}
	
		@Override
		@Nullable
		public List<Object> visitCGLookupCallExp(CGLookupCallExp object) {
			return visitCGOperationCallExp(object);
		}
	}
	
	protected static class CS2ASDependencyVisitor extends QVTiDependencyVisitor
		implements CS2ASCGModelVisitor<Object> {
	
		public CS2ASDependencyVisitor(QVTiAnalyzer analyzer, QVTiGlobalContext globalContext, GlobalPlace globalPlace) {
			super(analyzer, globalContext, globalPlace);
		}

		@Override
		@Nullable
		public Object visitCGLookupCallExp(CGLookupCallExp object) {
			return visitCGOperationCallExp(object);
		}
	}
	
	// Copied from QVTiCompilerTest
	@SuppressWarnings("unchecked")
	protected Class<? extends CS2ASTransformation> compileTransformation(@NonNull QVTiCodeGenerator cg) throws Exception {
		String qualifiedName = cg.getQualifiedName();
		String javaCodeSource = cg.generateClassFile();
		
		Class<?> txClass = OCL2JavaFileObject.loadClass(qualifiedName, javaCodeSource);
		return (Class<? extends CS2ASTransformation>) txClass;
		
	}
	
	
	// Copied from QVTiCompilerTest
	@Override
	public Class<? extends CS2ASTransformation> compileTransformation(@NonNull QVTimperative qvt,
			@NonNull Transformation transformation,	@NonNull CS2ASJavaCompilerParameters params) throws Exception {
				
		QVTiCodeGenerator cg = new CS2ASJavaCodeGenerator(qvt.getEnvironmentFactory(), transformation, params);
		QVTiCodeGenOptions options = cg.getOptions();
		options.setPackagePrefix(params.getPackageName());
		cg.generateClassFile();
		String savePath = params.getSavePath();
		if (savePath != null) {
			cg.saveSourceFile(savePath);
		}
		return compileTransformation(cg);
	}
}
