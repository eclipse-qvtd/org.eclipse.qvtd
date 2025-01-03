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
package org.eclipse.qvtd.cs2as.compiler.internal;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.tools.JavaFileObject;

import org.apache.commons.logging.Log;
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
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.types.UnboxedDescriptor;
import org.eclipse.ocl.examples.codegen.utilities.CGModelResourceFactory;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.TypeId;
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
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompiler;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.util.CS2ASCGModelVisitor;
import org.eclipse.qvtd.cs2as.compiler.internal.utilities.CS2ASCGModelResourceFactory;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.internal.cs2as.AbstractCS2ASTransformer;
import org.eclipse.qvtd.runtime.internal.cs2as.CS2ASTransformer;


public class CS2ASJavaCompilerImpl implements CS2ASJavaCompiler {

	protected static class CS2ASJavaCodeGenerator extends QVTiCodeGenerator
	{
		private  @NonNull CS2ASJavaCompilerParameters params;

		protected CS2ASJavaCodeGenerator(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation iTransformation,
				@NonNull CS2ASJavaCompilerParameters params) {
			super(environmentFactory, iTransformation);
			this.params = params;
		}

		@Override
		protected @NonNull QVTiCG2JavaVisitor createCG2JavaVisitor(@NonNull CGPackage cgPackage, @Nullable List<@NonNull CGValuedElement> sortedGlobals) {
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

		@Override
		public @NonNull CGModelResourceFactory getCGResourceFactory() {
			return CS2ASCGModelResourceFactory.INSTANCE;
		}

		public @NonNull CS2ASJavaCompilerParameters getCGParameters() {
			return params;
		}
	}

	protected static class CS2ASCG2JavaVisitor extends QVTiCG2JavaVisitor implements CS2ASCGModelVisitor<Boolean>
	{
		private static final String LOOKUP_SOLVER_FIELD_NAME = "lookupSolver";

		protected CS2ASCG2JavaVisitor(@NonNull QVTiCodeGenerator codeGenerator, @NonNull CGPackage cgPackage, @Nullable List<@NonNull CGValuedElement> sortedGlobals) {
			super(codeGenerator, cgPackage, sortedGlobals);
		}

		@Override
		protected void appendGuardFailure(@NonNull CGGuardExp cgGuardExp) {
			CGMapping cgMapping = QVTiCGUtil.basicGetContainingCGMapping(cgGuardExp);
			if (cgMapping != null) {
				List<CGGuardVariable> freeVariables = cgMapping.getOwnedGuardVariables();
				if (freeVariables.size() > 0) {
					CGGuardVariable cgGuardVariable = freeVariables.get(0);
					js.append("throw throwNull(");
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

		@Override
		protected @NonNull Class<? extends AbstractTransformer> getAbstractTransformationExecutorClass() {
			return AbstractCS2ASTransformer.class;
		}

		@Override
		@Nullable
		public Boolean visitCGLookupCallExp(@NonNull CGLookupCallExp cgCall) {
			CS2ASJavaCompilerParameters params = ((CS2ASJavaCodeGenerator)getCodeGenerator()).getCGParameters();

			CGValuedElement cgSource = ClassUtil.nonNullState(cgCall.getSource()); // FIXME to skip env() call. Remove env() call
			TypeDescriptor typeDescriptor = context.getTypeDescriptor(cgCall);
			if (!js.appendLocalStatements(cgSource)) {
				return false;
			}


			List<@NonNull CGValuedElement> cgArguments = ClassUtil.nullFree(cgCall.getArguments());
			for (@NonNull CGValuedElement cgArgument : cgArguments) {
				CGValuedElement argument = getExpression(cgArgument);
				if (!js.appendLocalStatements(argument)) {
					return false;
				}
			}


			String resultClassName = params.getLookupResultClassName();
			String resultSymbol = getSymbolName(resultClassName + cgCall.hashCode(), "_lookupResult");

			js.appendClassReference(null, resultClassName);
			js.append("<");
			js.appendClassReference(null, context.getUnboxedDescriptor(ClassUtil.nonNullState(cgCall.getTypeId().getElementId())));
			js.append(">");
			js.append(" ");
			js.append(resultSymbol);
			js.append(" = ");
			js.append(LOOKUP_SOLVER_FIELD_NAME);
			js.append(".");
			js.append(cgCall.getName());
			//js.append(cgCall.getReferredOperation().getType().getName());
			js.append("(");
			js.appendReferenceTo(cgSource);
			List<Parameter> pParameters = cgCall.getReferredOperation().getOwnedParameters();
			int iMax = Math.min(pParameters.size(), cgArguments.size());

			for (int i = 0; i < iMax; i++) {
				js.append(", ");
				CGValuedElement cgArgument = cgArguments.get(i);
				Parameter pParameter = pParameters.get(i);
				CGTypeId cgTypeId = analyzer.getTypeId(pParameter.getTypeId());
				UnboxedDescriptor parameterTypeDescriptor = context.getUnboxedDescriptor(ClassUtil.nonNullState(cgTypeId.getElementId()));
				CGValuedElement argument = getExpression(cgArgument);
				js.appendReferenceTo(parameterTypeDescriptor, argument);
			}
			js.append(");\n");

			js.appendClassReference(null, typeDescriptor);
			js.append(" ");
			js.appendReferenceTo(cgCall);
			js.append( " = null;\n");
			js.append("if ("+resultSymbol+".size() == 1) {\n");
			js.pushIndentation(null);
			js.appendReferenceTo(cgCall);
			js.append(" = ");
			js.append(resultSymbol+".getSingleResult();\n");
			js.popIndentation();
			// TODO what about ambiguous error report ?
			js.append("} else {\n");
			js.pushIndentation(null);

			CGValuedElement lookupArg = cgArguments.get(0); // FIXMe improve handleLookupError
			CGValuedElement initialSource = initialSourceCG(lookupArg);
			if (shouldHandleError(initialSource)) {
				js.append("handleLookupError(");
				js.appendReferenceTo(initialSource);
				js.append(",");
				js.appendReferenceTo(lookupArg);
				js.append(");\n");
			}
			js.popIndentation();
			js.append("};\n");
			return true;
		}


		@Override
		protected void doMappingConstructorConstants(List<@NonNull CGMapping> cgMappings) {

			super.doMappingConstructorConstants(cgMappings);

			CS2ASJavaCompilerParameters params = ((CS2ASJavaCodeGenerator)getCodeGenerator()).getCGParameters();
			String lookupSolver = params.getLookupSolverClassName();

			if (!"".equals(lookupSolver)) {
				js.append("private final ");
				js.appendClassReference(null, lookupSolver);
				js.append(" ");
				js.append(LOOKUP_SOLVER_FIELD_NAME);
				js.append(" = new ");
				js.appendClassReference(null, lookupSolver);
				js.append("(");
				js.append(JavaConstants.EXECUTOR_NAME);
				js.append(");\n");
			}
		}

		/**
		 * @param cgValue
		 * @return helper to obtain the initial CGValuedElement corresponding to the source of the lookupCall argument
		 */
		private CGValuedElement initialSourceCG(CGValuedElement cgValue) {
			if (cgValue instanceof CGVariableExp) {
				/*CGValuedElement cgVarInit = ((CGVariableExp) cgValue).getReferredVariable().getInit();
				if (cgVarInit == null) {
					return cgValue;
				} else {
					return cgVarInit == cgValue ? cgVarInit : initialSourceCG(cgVarInit);
				}*/
				return cgValue;
			} else if (cgValue instanceof CGCallExp) {
				CGValuedElement cgSource = ((CGCallExp) cgValue).getSource();
				return initialSourceCG(cgSource);
			}
			return cgValue;
		}

		/**
		 * helper to decide if lookup error should be handled or not.
		 * For the time being, just the lookup arg source is the considered.
		 *
		 * FIXME FTB we exclude all String-typed lookup arguments to avoid the
		 * generation error. This incorrectly exclude valid String-based lookups
		 * where that string appears in the text. In that case, the containing object
		 * should be considered by further analysis of the CGValuedElement (See {@link #initialSourceCG(CGValuedElement)}
		 *
		 * @param cgValue
		 * @return  <code>true</code>, if lookup error should be handled.
		 */
		private boolean shouldHandleError(CGValuedElement cgValue) {
			TypeId stringTypeId = context.getEnvironmentFactory().getStandardLibrary().getStringType().getTypeId();
			ElementId valueTypeId = cgValue.getTypeId().getElementId();
			return ! stringTypeId.equals(valueTypeId);
		}
	}

	protected static class CS2ASAS2CGVisitor extends QVTiAS2CGVisitor {

		public CS2ASAS2CGVisitor(@NonNull QVTiAnalyzer analyzer, @NonNull QVTiGlobalContext globalContext) {
			super(analyzer, globalContext);
		}
	}

	protected static class CS2ASAnalysisVisitor extends QVTiAnalysisVisitor
	implements CS2ASCGModelVisitor<Object> {

		public CS2ASAnalysisVisitor(@NonNull QVTiAnalyzer analyzer) {
			super(analyzer);
		}

		@Override
		@Nullable
		public Object visitCGLookupCallExp(@NonNull CGLookupCallExp object) {
			return visitCGOperationCallExp(object);
		}
	}

	protected static class CS2ASBoxingAnalyser extends QVTiBoxingAnalyzer
	implements CS2ASCGModelVisitor<Object> {

		public CS2ASBoxingAnalyser(@NonNull QVTiAnalyzer analyzer) {
			super(analyzer);
		}

		@Override
		@Nullable
		public Object visitCGLookupCallExp(@NonNull CGLookupCallExp object) {
			super.visitCGOperationCallExp(object);
			CGValuedElement cgSource = object.getSource();
			rewriteAsGuarded(cgSource, isSafe(object), "source for '" + object.getReferredOperation() + "'");
			rewriteAsUnboxed(cgSource);
			List<CGValuedElement> cgArguments = object.getArguments();
			int iMax = cgArguments.size();
			for (int i = 0; i < iMax; i++) {	// Avoid CME from rewrite
				rewriteAsUnboxed(cgArguments.get(i));
			}
			return null;
		}
	}

	protected static class CS2ASFieldingAnalyser extends QVTiFieldingAnalyzer {

		protected static class CS2ASAnalysisVisitor extends QVTiFieldingAnalyzer.QVTiAnalysisVisitor
		implements CS2ASCGModelVisitor<Set<CGVariable>> {
			public CS2ASAnalysisVisitor(@NonNull QVTiFieldingAnalyzer context) {
				super(context);
			}

			@Override
			@Nullable
			public Set<CGVariable> visitCGLookupCallExp(@NonNull CGLookupCallExp object) {
				return visitCGOperationCallExp(object);
			}
		}

		protected static class CS2ASRewriteVisitor extends QVTiFieldingAnalyzer.QVTiRewriteVisitor
		implements CS2ASCGModelVisitor<Boolean> {
			public CS2ASRewriteVisitor(@NonNull QVTiAnalyzer context, @NonNull Set<@NonNull CGVariable> caughtVariable) {
				super(context, caughtVariable);
			}

			@Override
			@Nullable
			public Boolean visitCGLookupCallExp(@NonNull CGLookupCallExp object) {
				return visitCGOperationCallExp(object);
			}
		}



		public CS2ASFieldingAnalyser(@NonNull QVTiAnalyzer analyzer) {
			super(analyzer);
		}

		@Override
		protected @NonNull AnalysisVisitor createAnalysisVisitor() {
			return new CS2ASAnalysisVisitor(this);
		}

		@Override
		protected @NonNull RewriteVisitor createRewriteVisitor(@NonNull Set<@NonNull CGVariable> caughtVariables) {
			return new CS2ASRewriteVisitor((QVTiAnalyzer)analyzer, caughtVariables);
		}
	}


	protected static class CS2ASCG2JavaPreVisitor extends QVTiCG2JavaPreVisitor
	implements CS2ASCGModelVisitor<Object> {

		public CS2ASCG2JavaPreVisitor(@NonNull QVTiGlobalContext globalContext) {
			super(globalContext);
		}

		@Override
		@Nullable
		public Object visitCGLookupCallExp(@NonNull CGLookupCallExp object) {
			return visitCGOperationCallExp(object);
		}
	}

	protected static class CS2ASReferencesVisitor extends QVTiReferencesVisitor
	implements CS2ASCGModelVisitor<@NonNull List<@Nullable Object>> {

		protected static final @NonNull CS2ASReferencesVisitor INSTANCE = new CS2ASReferencesVisitor(new Object());

		public CS2ASReferencesVisitor(@Nullable Object context) {
			super(context);
		}

		@Override
		public @NonNull List<@Nullable Object> visitCGLookupCallExp(@NonNull CGLookupCallExp object) {
			return visitCGOperationCallExp(object);
		}
	}

	protected static class CS2ASDependencyVisitor extends QVTiDependencyVisitor
	implements CS2ASCGModelVisitor<Object> {

		public CS2ASDependencyVisitor(@NonNull QVTiAnalyzer analyzer, @NonNull QVTiGlobalContext globalContext, @NonNull GlobalPlace globalPlace) {
			super(analyzer, globalContext, globalPlace);
		}

		@Override
		@Nullable
		public Object visitCGLookupCallExp(@NonNull CGLookupCallExp object) {
			return visitCGOperationCallExp(object);
		}
	}

	private @Nullable Log log = null;

	// Copied from QVTiCompilerTest
	protected Class<? extends CS2ASTransformer> compileTransformation(@NonNull File explicitClassPath, @NonNull QVTiCodeGenerator cg, @Nullable JavaClasspath classpath, @Nullable ClassLoader classLoader) throws Exception {
		String qualifiedClassName = cg.getQualifiedName();
		String javaCodeSource = cg.generateClassFile();
		//		String problem = OCL2JavaFileObject.saveClass(String.valueOf(explicitClassPath), qualifiedClassName, javaCodeSource, classPathProjectNames);
		List<@NonNull JavaFileObject> compilationUnits = Collections.singletonList(new OCL2JavaFileObject(qualifiedClassName, javaCodeSource));
		// List<@NonNull String> classpathProjects = classPathProjectNames != null ? JavaFileUtil.createClassPathProjectList(cg.getEnvironmentFactory().getResourceSet().getURIConverter(), classpath) : null;
		String problem = JavaFileUtil.compileClasses(compilationUnits, qualifiedClassName, String.valueOf(explicitClassPath), classpath);
		if (problem != null) {
			throw new CompilerChainException(problem);
		}
		@SuppressWarnings("unchecked")
		Class<? extends CS2ASTransformer> txClass = (Class<? extends CS2ASTransformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName, classLoader);
		return txClass;
	}

	// Copied from QVTiCompilerTest
	@Override
	public @NonNull Class<? extends CS2ASTransformer> compileTransformation(@NonNull QVTimperative qvt,
			@NonNull ImperativeTransformation iTransformation,	@NonNull CS2ASJavaCompilerParameters params) throws Exception {

		QVTiCodeGenerator cg = new CS2ASJavaCodeGenerator(qvt.getEnvironmentFactory(), iTransformation, params)
		{
			@Override
			protected @NonNull String createClassFileContent() {
				String classFileContent = super.createClassFileContent();
				for (Map.Entry<@NonNull String, @NonNull String> entry : params.getPackageRenames().entrySet()) {
					String fromPackage = entry.getKey();
					String toPackage = entry.getValue();
					classFileContent = classFileContent.replace(fromPackage, toPackage);
				}
				return classFileContent;
			}
		};
		QVTiCodeGenOptions options = cg.getOptions();
		options.setUseNullAnnotations(true);
		options.setIsIncremental(params.isIncremental());
		options.setPackagePrefix(params.getPackagePrefix());
		try {
			cg.generateClassFile();
		}
		catch (Exception e) {
			CompilerUtil.throwExceptionWithProblems(cg, e);
		}
		Log log2 = log;
		if (log2 != null) {
			List<@NonNull Exception> problems = cg.getProblems();
			if (problems != null) {
				for (@NonNull Exception ex : problems) {
					log2.info("CG Problem " + ex.toString());
				}
			}
		}
		String savePath = params.getSavePath();
		cg.saveSourceFile(savePath);
		if (log2 != null) {
			log2.info("Saved " + savePath + cg.getQualifiedName());
		}
		File explicitClassPath = new File(new File(savePath).getParentFile(), JavaFileUtil.TEST_BIN_FOLDER_NAME);
		explicitClassPath.mkdir();
		return ClassUtil.nonNullState(compileTransformation(explicitClassPath, cg, params.getClasspath(), params.getClassLoader()));
	}

	public void setLog(@Nullable Log log) {
		this.log  = log;
	}
}
