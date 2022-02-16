/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.GlobalNameManager.NameVariant;
import org.eclipse.ocl.examples.codegen.analyzer.NameManagerHelper;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaImportNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGModelResourceFactory;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalysisVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiBoxingAnalyzer;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiCG2StringVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiDependencyVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiFieldingAnalyzer;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiReferencesVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGModelResourceFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * QVTiCodeGenerator supports generation of the content of a JavaClassFile to
 * execute a QVTi transformation.
 */
public class QVTiCodeGenerator extends JavaCodeGenerator
{
	protected static class QVTiCGNameHelper extends NameManagerHelper.CGNameHelper implements QVTiCGModelVisitor<@Nullable String>
	{			// FIXME Introduce AS-style indirection/delegation
		public QVTiCGNameHelper(@NonNull NameManagerHelper context) {
			super(context);
		}

		@Override
		public @Nullable String visitCGConnectionAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGConnectionAssignment object) {
			return "CONNECTION_" + context.getNameableHint(object.getConnectionVariable());		// XXX
		}

		@Override
		public @Nullable String visitCGConnectionVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGConnectionVariable object) {
			return visitCGGuardVariable(object);
		}

		@Override
		public @Nullable String visitCGEcoreContainerAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGEcoreContainerAssignment object) {
			return "XXX" + context.getNameableHint(object);		// XXX
		}

		@Override
		public @Nullable String visitCGEcorePropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGEcorePropertyAssignment object) {
			return "XXX" + context.getNameableHint(object);		// XXX
		}

		@Override
		public @Nullable String visitCGEcoreRealizedVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGEcoreRealizedVariable object) {
			return visitCGRealizedVariable(object);
		}

		@Override
		public @Nullable String visitCGFunction(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunction object) {
			return visitCGOperation(object);
		}

		@Override
		public @Nullable String visitCGFunctionCallExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunctionCallExp object) {
			return visitCGOperationCallExp(object);
		}

		@Override
		public @Nullable String visitCGFunctionParameter(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunctionParameter object) {
			return visitCGParameter(object);
		}

		@Override
		public @Nullable String visitCGGuardVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGGuardVariable object) {
			return visitCGParameter(object);
		}

		@Override
		public @Nullable String visitCGMapping(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMapping object) {
			return visitCGNamedElement(object);
		}

		@Override
		public @Nullable String visitCGMappingCall(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCall object) {
			return context.getNameableHint(QVTiCGUtil.getAST(object).getReferredMapping());
		}

		@Override
		public @Nullable String visitCGMappingCallBinding(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCallBinding object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable String visitCGMappingExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingExp object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable String visitCGMappingLoop(@NonNull CGMappingLoop object) {
			return "loop";
		}

		@Override
		public @Nullable String visitCGMiddlePropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMiddlePropertyAssignment object) {
			return visitCGEcorePropertyAssignment(object);
		}

		@Override
		public @Nullable String visitCGMiddlePropertyCallExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMiddlePropertyCallExp object) {
			return visitCGOppositePropertyCallExp(object);
		}

		@Override
		public @Nullable String visitCGPropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGPropertyAssignment object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable String visitCGRealizedVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGRealizedVariable object) {
			return visitCGVariable(object);
		}

		@Override
		public @Nullable String visitCGRealizedVariablePart(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGRealizedVariablePart object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable String visitCGSequence(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSequence object) {
			return "XXX-SEQ"; //visitCGValuedElement(object);
		}

		@Override
		public @Nullable String visitCGSpeculateExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculateExp object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable String visitCGSpeculatePart(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculatePart object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable String visitCGTransformation(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTransformation object) {
			return visitCGClass(object);
		}

		@Override
		public @Nullable String visitCGTypedModel(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTypedModel object) {
			return visitCGNamedElement(object);
		}
	}

	public static class QVTiNameManagerHelper extends NameManagerHelper
	{
		@Override
		protected @NonNull CGNameHelper createCGNameHelper() {
			return new QVTiCGNameHelper(this);
		}
	}

	protected final @NonNull ImperativeTransformation transformation;
	protected final @NonNull QVTiAnalyzer cgAnalyzer;
	protected final @NonNull QVTiGlobalContext globalContext;
	protected final @NonNull Map<@NonNull ImperativeTransformation, @NonNull EntryPointsAnalysis> transformation2analysis = new HashMap<>();
	private/* @LazyNonNull*/ CGPackage cgPackage;
	private/* @LazyNonNull*/ String javaSourceCode = null;
	protected final @NonNull NameVariant INSTANCE_NameVariant;

	public QVTiCodeGenerator(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation transformation) {
		super(environmentFactory, null);			// FIXME Pass a genmodel
		QVTiCG2StringVisitor.FACTORY.getClass();
		this.transformation = transformation;
		this.cgAnalyzer = new QVTiAnalyzer(this);
		this.globalContext = new QVTiGlobalContext(this);
		this.INSTANCE_NameVariant = globalNameManager.addNameVariantPrefix("INSTANCE_");
	}

	private void appendSegmentName(@NonNull StringBuilder s, CGPackage sPackage) {
		String pName = sPackage.getName();
		if (pName != null && pName.length() > 0) {
			s.append(pName);
			s.append('.');
		}
	}

	protected @NonNull QVTiAS2CGVisitor createAS2CGVisitor(@NonNull QVTiAnalyzer analyzer, @NonNull QVTiGlobalContext gContext) {
		return new QVTiAS2CGVisitor(analyzer, gContext);
	}

	@Override
	public @NonNull AnalysisVisitor createAnalysisVisitor() {
		return new QVTiAnalysisVisitor(cgAnalyzer);
	}

	@Override
	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new QVTiBoxingAnalyzer(cgAnalyzer);
	}

	@Override
	public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return new QVTiCG2JavaPreVisitor(getGlobalContext());
	}

	protected @NonNull QVTiCG2JavaVisitor createCG2JavaVisitor(@NonNull CGPackage cgPackage, @Nullable List<@NonNull CGValuedElement> sortedGlobals) {
		return new QVTiCG2JavaVisitor(this, cgPackage, sortedGlobals);
	}

	protected @NonNull CGPackage createCGPackage() {
		QVTiAS2CGVisitor pivot2CGVisitor = createAS2CGVisitor(cgAnalyzer, getGlobalContext());
		CGTransformation cgTransformation = (CGTransformation) ClassUtil.nonNullState(transformation.accept(pivot2CGVisitor));
		pivot2CGVisitor.freeze();
		CGPackage cgPackage = null;
		for (org.eclipse.ocl.pivot.Package asPackage = transformation.getOwningPackage(); asPackage != null; asPackage = asPackage.getOwningPackage()) {
			CGPackage cgPackage2 = createCGPackage(asPackage);
			if (cgTransformation != null) {
				cgPackage2.getClasses().add(cgTransformation);
				cgTransformation = null;
			}
			else {
				cgPackage2.getPackages().add(cgPackage);
			}
			cgPackage = cgPackage2;
		}
		String packagePrefix = getOptions().getPackagePrefix();
		if (packagePrefix != null) {
			String[] segments = packagePrefix.split("\\.");
			for (int i = segments.length; --i >= 0; ) {
				String segment = segments[i];
				CGPackage cgPackage2 = CGModelFactory.eINSTANCE.createCGPackage();
				cgPackage2.setName(segment);
				cgPackage2.getPackages().add(cgPackage);
				cgPackage = cgPackage2;
			}
		}
		assert cgPackage != null;
		return cgPackage;
	}

	protected @NonNull CGPackage createCGPackage(org.eclipse.ocl.pivot.@NonNull Package asPackage) {

		// Target CG Package
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		String name = asPackage.getName();
		cgPackage.setName((name != null) && (name.length() > 0)? name : "_" + transformation.getName());

		// Parent CG Package
		org.eclipse.ocl.pivot.Package asParentPackage = asPackage.getOwningPackage();
		if (asParentPackage != null) {
			CGPackage cgParentPackage = createCGPackage(asParentPackage);
			cgParentPackage.getPackages().add(cgPackage);
		}

		return cgPackage;
	}

	protected @NonNull String createClassFileContent() {
		String javaSourceCode2;
		CGPackage cgPackage2 = createCGPackage();
		cgPackage = cgPackage2;
		reserveGlobalNames();
		optimize(cgPackage2);
		List<@NonNull CGValuedElement> sortedGlobals = prepareGlobals();
		resolveNames(cgPackage);
		QVTiCG2JavaVisitor generator = createCG2JavaVisitor(cgPackage2, sortedGlobals);
		generator.safeVisit(cgPackage2);
		ImportNameManager importNameManager = generator.getImportNameManager();
		Map<@NonNull String, @Nullable String> long2ShortImportNames = importNameManager.getLong2ShortImportNames();
		javaSourceCode2 = ImportUtils.resolveImports(generator.toString(), long2ShortImportNames, false);
		return javaSourceCode2;
	}

	@Override
	public @NonNull CGModelResourceFactory getCGResourceFactory() {
		return QVTiCGModelResourceFactory.INSTANCE;
	}

	@Override
	public @NonNull DependencyVisitor createDependencyVisitor() {
		return new QVTiDependencyVisitor(cgAnalyzer, getGlobalContext(),
			getGlobalPlace());
	}

	@Override
	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new QVTiFieldingAnalyzer(cgAnalyzer);
	}

	@Override
	public @NonNull ImportNameManager createImportNameManager() {
		return new JavaImportNameManager() {
			{		// Ensure re-used inherited names are not confused
				reserveImportName(org.eclipse.qvtd.runtime.evaluation.AbstractTransformer.class);
				reserveImportName(org.eclipse.qvtd.runtime.evaluation.ExecutionVisitable.class);
				reserveImportName(org.eclipse.qvtd.runtime.evaluation.Transformer.class);
				reserveImportName(org.eclipse.qvtd.runtime.internal.evaluation.AbstractTransformerInternal.Incremental.class);
				reserveImportName(org.eclipse.qvtd.runtime.internal.evaluation.RuntimeModelsManager.Model.class);
			}
		};
	}

	@Override
	protected @NonNull NameManagerHelper createNameManagerHelper() {
		return new QVTiNameManagerHelper();
	}

	@Override
	protected @NonNull QVTiCodeGenOptions createOptions() {
		return new QVTiCodeGenOptions();
	}

	@Override
	public @NonNull ReferencesVisitor createReferencesVisitor() {
		return QVTiReferencesVisitor.INSTANCE;
	}

	public @NonNull String generateClassFile() {
		String javaSourceCode2 = javaSourceCode;
		if (javaSourceCode2 == null) {
			javaSourceCode = javaSourceCode2 = CGUtil.trimLines(CGUtil.compressJDTannotations(createClassFileContent()));
		}
		return javaSourceCode2;
	}

	@Override
	public @NonNull QVTiAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}

	public @NonNull EntryPointsAnalysis getEntryPointsAnalysis(@NonNull ImperativeTransformation transformation) {
		//		Map<Transformation, QVTiTransformationAnalysis> transformation2analysis = new HashMap<Transformation, QVTiTransformationAnalysis>();
		EntryPointsAnalysis entryPointsAnalysis = transformation2analysis.get(transformation);
		if (entryPointsAnalysis == null) {
			entryPointsAnalysis = new EntryPointsAnalysis(getEnvironmentFactory(), transformation);
			entryPointsAnalysis.analyzeTransformation();
			transformation2analysis.put(transformation, entryPointsAnalysis);
		}
		return entryPointsAnalysis;
	}

	@Override
	public @NonNull QVTiGlobalContext getGlobalContext() {
		return globalContext;
	}

	public @NonNull NameVariant getINSTANCE_NameVariant() {
		return INSTANCE_NameVariant;
	}

	@Override
	public @NonNull QVTiCodeGenOptions getOptions() {
		return (QVTiCodeGenOptions) super.getOptions();
	}

	public @NonNull String getQualifiedName() {
		StringBuilder s =  new StringBuilder();
		CGPackage cgPackage = this.cgPackage;
		appendSegmentName(s, cgPackage);
		while (cgPackage.getPackages().size() > 0) {
			cgPackage = cgPackage.getPackages().get(0);
			appendSegmentName(s, cgPackage);
		}
		s.append(QVTbaseUtil.getName(transformation));
		return s.toString();
	}

	public @NonNull ImperativeTransformation getTransformation() {
		return transformation;
	}

	protected void reserveGlobalNames() {
		globalContext.getOppositeIndex2propertyIdName();
		EntryPointsAnalysis entryPointsAnalysis = getEntryPointsAnalysis(transformation);
		int typedModelNumber = 0;
		for (@SuppressWarnings("unused") @NonNull TypedModel typedModel : QVTimperativeUtil.getModelParameters(entryPointsAnalysis.getTransformation())) {
			globalContext.getClassIndex2allClassIndexes(typedModelNumber);
			globalContext.getClassIndex2classId(typedModelNumber);
			typedModelNumber++;
		}
	}

	public @NonNull File saveSourceFile(@NonNull String savePath) throws IOException {
		File saveFile = new File(savePath);
		saveSourceFiles(ClassUtil.nonNullState(cgPackage), saveFile);
		return saveFile;
	}

	public void saveSourceFiles(@NonNull CGPackage cgPackage, @NonNull File parentFolder) throws IOException {
		File folder = new File(parentFolder, cgPackage.getName());
		for (CGPackage cgChildPackage : cgPackage.getPackages()) {
			if (cgChildPackage != null) {
				saveSourceFiles(cgChildPackage, folder);
			}
		}
		for (CGClass cgClass : cgPackage.getClasses()) {
			folder.mkdirs();
			String javaCodeSource = generateClassFile();
			Writer writer = new FileWriter(new File(folder, cgClass.getName() + ".java"));
			writer.append(javaCodeSource);
			writer.close();
		}
	}
}
