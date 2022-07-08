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
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.analyzer.NameManagerHelper;
import org.eclipse.ocl.examples.codegen.analyzer.NestedNameManager;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.calling.ImmutableCachePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.OperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.PropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaNameVisitor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaImportNameManager;
import org.eclipse.ocl.examples.codegen.java.JavaLanguageSupport;
import org.eclipse.ocl.examples.codegen.utilities.CGModelResourceFactory;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.internal.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiFieldingAnalyzer;
import org.eclipse.qvtd.codegen.qvti.java.InternalFunctionOperationCallingConvention.CacheProperty;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelAnalysisVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelBoxingAnalysisVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2JavaNameVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2JavaPreVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2JavaVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2StringVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCGNameHelperVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelDependencyVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelReferencesVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGModelResourceFactory;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;

/**
 * QVTiCodeGenerator supports generation of the content of a JavaClassFile to
 * execute a QVTi transformation.
 */
public class QVTiCodeGenerator extends JavaCodeGenerator
{
	/**
	 * Map from an oppositeProperty that requites a cache to the global name of that cache.
	 */
	private /*@LazyNonNull*/ Map<@NonNull Property, @NonNull String> oppositeProperty2oppositeCacheName = null;

	public static class QVTiNameManagerHelper extends NameManagerHelper
	{
		@Override
		protected @NonNull CGNameHelper createCGNameHelper() {
			return new QVTiCGModelCGNameHelperVisitor(this);
		}
	}

	protected final @NonNull ImperativeTransformation asTransformation;
	protected final @NonNull QVTiAnalyzer cgAnalyzer;
	protected final @NonNull Map<@NonNull ImperativeTransformation, @NonNull EntryPointsAnalysis> transformation2analysis = new HashMap<>();
	private/* @LazyNonNull*/ CGPackage cgPackage;
	private/* @LazyNonNull*/ String javaSourceCode = null;

	public QVTiCodeGenerator(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation asTransformation) {
		super(environmentFactory, null);			// FIXME Pass a genmodel
		QVTiCGModelCG2StringVisitor.FACTORY.getClass();
		this.asTransformation = asTransformation;
		this.cgAnalyzer = new QVTiAnalyzer(this);
	}

	public @NonNull String addOppositeProperty(@NonNull Property pivotProperty) {
		assert !pivotProperty.isIsImplicit() && !pivotProperty.isIsComposite();
		if (oppositeProperty2oppositeCacheName == null) {
			oppositeProperty2oppositeCacheName = new HashMap<@NonNull Property, @NonNull String>();
		}
		if (!oppositeProperty2oppositeCacheName.containsKey(pivotProperty)) {
			oppositeProperty2oppositeCacheName.put(pivotProperty, globalNameManager.declareGlobalName(null, "OPPOSITE_OF_" + pivotProperty.getOwningClass().getName() + "_" + pivotProperty.getName()).getResolvedName());
		}
		String name = oppositeProperty2oppositeCacheName.get(pivotProperty);
		assert name != null;
		return name;
	}

	private void appendSegmentName(@NonNull StringBuilder s, CGPackage cgPackage) {
		String pName = cgPackage.getName();
		if (pName != null && pName.length() > 0) {
			s.append(pName);
			s.append('.');
		}
	}

	protected @NonNull QVTiAS2CGVisitor createAS2CGVisitor() {
		return new QVTiAS2CGVisitor(this);
	}

	@Override
	public @NonNull AnalysisVisitor createAnalysisVisitor() {
		return new QVTiCGModelAnalysisVisitor(cgAnalyzer);
	}

	@Override
	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new QVTiCGModelBoxingAnalysisVisitor(cgAnalyzer);
	}

	@Override
	public @NonNull CG2JavaNameVisitor createCG2JavaNameVisitor() {
		return new QVTiCGModelCG2JavaNameVisitor(this);
	}

	@Override
	public @NonNull CG2JavaPreVisitor createCG2JavaPreVisitor() {
		return new QVTiCGModelCG2JavaPreVisitor(this);
	}

	protected @NonNull QVTiCGModelCG2JavaVisitor createCG2JavaVisitor(@NonNull CGPackage cgPackage, @Nullable Iterable<@NonNull CGValuedElement> sortedGlobals) {
		return new QVTiCGModelCG2JavaVisitor(this, cgPackage, sortedGlobals);
	}

	protected @NonNull CGPackage createCGPackage() {
		QVTiAS2CGVisitor as2cgVisitor = createAS2CGVisitor();
		CGTransformation cgTransformation = (CGTransformation)ClassUtil.nonNullState(asTransformation.accept(as2cgVisitor));
		as2cgVisitor.freeze();
		//	for (org.eclipse.ocl.pivot.Package asPackage = asTransformation.getOwningPackage(); asPackage != null; asPackage = asPackage.getOwningPackage()) {
		org.eclipse.ocl.pivot.Package asPackage = asTransformation.getOwningPackage();
		CGPackage cgPackage2 = createCGPackage(asPackage);
		//	if (cgTransformation.eContainer() == null) {
		cgPackage2.getClasses().add(cgTransformation);
		//	}
		//	else {
		//		cgPackage2.getPackages().add(cgPackage);
		//	}
		CGPackage cgPackage = cgPackage2;
		while (cgPackage.getContainingPackage() != null) {
			cgPackage = cgPackage.getContainingPackage();
		}
		String packagePrefix = getOptions().getPackagePrefix();
		if (packagePrefix != null) {
			String[] segments = packagePrefix.split("\\.");
			for (int i = segments.length; --i >= 0; ) {
				String segment = segments[i];
				CGPackage cgPackage3 = CGModelFactory.eINSTANCE.createCGPackage();
				globalNameManager.declareGlobalName(cgPackage3, segment);
				cgPackage3.getPackages().add(cgPackage);
				cgPackage = cgPackage3;
			}
		}
		assert cgPackage != null;
		as2cgVisitor.pushClassNameManager(cgTransformation);
		cgAnalyzer.analyzeExternalFeatures(as2cgVisitor);
		as2cgVisitor.popClassNameManager();
		return cgPackage;
	}

	protected @NonNull CGPackage createCGPackage(org.eclipse.ocl.pivot.@NonNull Package asPackage) {

		// Target CG Package
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		String name = asPackage.getName();
		globalNameManager.declareGlobalName(cgPackage, (name != null) && (name.length() > 0)? name : "_" + asTransformation.getName());

		// Parent CG Package
		org.eclipse.ocl.pivot.Package asParentPackage = asPackage.getOwningPackage();
		if (asParentPackage != null) {
			CGPackage cgParentPackage = createCGPackage(asParentPackage);
			cgParentPackage.getPackages().add(cgPackage);
		}

		return cgPackage;
	}

	protected @NonNull String createClassFileContent() {
		QVTiGlobalNameManager globalNameManager = getGlobalNameManager();
		globalNameManager.getOppositeIndex2propertyIdName();
		EntryPointsAnalysis entryPointsAnalysis = getEntryPointsAnalysis(asTransformation);
		globalNameManager.reserveGlobalNames(entryPointsAnalysis);
		CGPackage cgPackage2 = createCGPackage();
		cgPackage = cgPackage2;
		optimize(cgPackage2);

		JavaLanguageSupport javaLanguageSupport = (JavaLanguageSupport)environmentFactory.getLanguageSupport("java");	// XXX Unify all calls
		assert javaLanguageSupport != null;
		Model nativeModel = javaLanguageSupport.basicGetNativeModel();
		if (nativeModel != null) {
			metamodelManager.installRoot(nativeModel);
		}
		Iterable<@NonNull CGValuedElement> sortedGlobals = pregenerate(cgPackage2);
		QVTiCGModelCG2JavaVisitor generator = createCG2JavaVisitor(cgPackage2, sortedGlobals);
		generator.safeVisit(cgPackage2);
		ImportNameManager importNameManager = generator.getImportNameManager();
		Map<@NonNull String, @Nullable String> long2ShortImportNames = importNameManager.getLong2ShortImportNames();
		String javaSourceCode = ImportUtils.resolveImports(generator.toString(), long2ShortImportNames, false);
		return javaSourceCode;
	}

	@Override
	protected @NonNull GlobalNameManager createGlobalNameManager() {
		return new QVTiGlobalNameManager(this, createNameManagerHelper());
	}

	@Override
	public @NonNull CGModelResourceFactory getCGResourceFactory() {
		return QVTiCGModelResourceFactory.INSTANCE;
	}

	@Override
	public @NonNull DependencyVisitor createDependencyVisitor() {
		return new QVTiCGModelDependencyVisitor(this, getGlobalPlace());
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
	public @NonNull NestedNameManager createNestedNameManager(@NonNull NameManager outerNameManager, @NonNull CGNamedElement cgScope) {
		return new QVTiNestedNameManager(this, outerNameManager, cgScope);
	}

	@Override
	protected @NonNull QVTiNameManagerHelper createNameManagerHelper() {
		return new QVTiNameManagerHelper();
	}

	@Override
	protected @NonNull QVTiCodeGenOptions createOptions() {
		return new QVTiCodeGenOptions();
	}

	@Override
	public @NonNull ReferencesVisitor createReferencesVisitor() {
		return QVTiCGModelReferencesVisitor.INSTANCE;
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

	@Override
	public @NonNull OperationCallingConvention getCallingConvention( @NonNull Operation asOperation, boolean isFinal) {
		if (asOperation instanceof Function) {
			Function asFunction = (Function)asOperation;
			LanguageExpression asBodyExpression = asOperation.getBodyExpression();
			if (asOperation.getImplementationClass() != null) {
				assert asBodyExpression == null;
				return ExternalFunctionOperationCallingConvention.INSTANCE;
			}
			else if (asBodyExpression != null) {
				ShadowExp asShadowExp = getShadowExp(asFunction);
				if (asShadowExp != null) {
					return ShadowFunctionOperationCallingConvention.INSTANCE;
				}
				else if (asFunction.isIsTransient()) {
					return TransientFunctionOperationCallingConvention.INSTANCE;
				}
				else {
					return InternalFunctionOperationCallingConvention.INSTANCE;
				}
			}
			else {
				return EmptyFunctionOperationCallingConvention.INSTANCE;
			}
		}
		return super.getCallingConvention(asOperation, isFinal);
	}

	@Override
	public @NonNull PropertyCallingConvention getCallingConvention(@NonNull Property asProperty) {
		LibraryProperty libraryProperty = metamodelManager.getImplementation(null, null, asProperty);
		//	Property asOppositeProperty = ClassUtil.nonNullModel(asOppositePropertyCallExp.getReferredProperty());
		Property asOppositeProperty2 = asProperty.getOpposite();
		if ((asOppositeProperty2 != null) && !asProperty.isIsComposite()) {
			if (libraryProperty instanceof ImplicitNonCompositionProperty) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature) asProperty.getESObject();
				assert eStructuralFeature == null;
				/*	if (eStructuralFeature != null) {
					try {
						getGenModelHelper().getGetAccessor(eStructuralFeature);
						return EcoreOppositePropertyCallingConvention.INSTANCE;
					} catch (GenModelException e) {
						addProblem(e);		// FIXME drop through to better default
					}
				} */
				return MiddlePropertyCallingConvention.INSTANCE;
			}
		}
		if (libraryProperty instanceof CacheProperty) {
			return ImmutableCachePropertyCallingConvention.INSTANCE;
		}
		return super.getCallingConvention(asProperty);
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
	public @NonNull QVTiGlobalNameManager getGlobalNameManager() {
		return (QVTiGlobalNameManager)globalNameManager;
	}

	public @Nullable Map<@NonNull Property, @NonNull String> getOppositeProperties() {
		return oppositeProperty2oppositeCacheName;
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
		s.append(QVTbaseUtil.getName(asTransformation));
		return s.toString();
	}

	public @Nullable ShadowExp getShadowExp(@NonNull Function asFunction) {
		LanguageExpression asBodyExpression = asFunction.getBodyExpression();
		if (asBodyExpression != null) {
			OCLExpression asElement = ((ExpressionInOCL)asBodyExpression).getOwnedBody();
			while (asElement instanceof LetExp) {				// Redundant since now using Function AS context
				asElement = ((LetExp)asElement).getOwnedIn();
			}
			if (asElement instanceof ShadowExp) {			// QVTr Key
				if (!(asElement.getType() instanceof DataType))
					return (ShadowExp)asElement;		// FIXME replace with clearer strategy
			}
		}
		return null;
	}

	public @NonNull ImperativeTransformation getTransformation() {
		return asTransformation;
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
