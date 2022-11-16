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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.calling.CachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ImmutableCachePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.OperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.PropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaNameVisitor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaImportNameManager;
import org.eclipse.ocl.examples.codegen.java.JavaLanguageSupport;
import org.eclipse.ocl.examples.codegen.naming.ClassNameManager;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameManagerHelper;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.naming.NestedNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGModelResourceFactory;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.library.ImplicitNonCompositionProperty;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.AbstractLanguageSupport;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiFieldingAnalyzer;
import org.eclipse.qvtd.codegen.qvti.calling.EmptyFunctionOperationCallingConvention;
import org.eclipse.qvtd.codegen.qvti.calling.ExternalFunctionOperationCallingConvention;
import org.eclipse.qvtd.codegen.qvti.calling.ExternalOperationOperationCallingConvention;
import org.eclipse.qvtd.codegen.qvti.calling.InternalFunctionOperationCallingConvention;
import org.eclipse.qvtd.codegen.qvti.calling.MiddlePropertyCallingConvention;
import org.eclipse.qvtd.codegen.qvti.calling.ShadowClassOperationCallingConvention;
import org.eclipse.qvtd.codegen.qvti.calling.ShadowDataTypeOperationCallingConvention;
import org.eclipse.qvtd.codegen.qvti.calling.TransformationCallingConvention;
import org.eclipse.qvtd.codegen.qvti.calling.TransientFunctionOperationCallingConvention;
import org.eclipse.qvtd.codegen.qvti.calling.FunctionOperationCallingConvention.CacheProperty;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiExecutableNameManager;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiGlobalNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
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
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

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
	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull Map<@NonNull ImperativeTransformation, @NonNull EntryPointsAnalysis> transformation2analysis = new HashMap<>();
	private /*@LazyNonNull*/ CGPackage cgPackage;
	private /*@LazyNonNull*/ String javaSourceCode = null;
	private /*@LazyNonNull*/ JavaLanguageSupport javaLanguageSupport = null;

	/**
	 * Optional additional qualified path for each class.
	 */
	private /*@LazyNonNull*/ Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull String> class2extraPrefix = null;
	private /*@LazyNonNull*/ Map<@NonNull String, @NonNull String> qualifiedClassName2requalifiedClassName = null;

	public QVTiCodeGenerator(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation asTransformation) {
		super(environmentFactory, null);			// FIXME Pass a genmodel
		QVTiCGModelCG2StringVisitor.FACTORY.getClass();
		this.asTransformation = asTransformation;
		this.analyzer = createCodeGenAnalyzer();
	}

	public @NonNull String addOppositeProperty(@NonNull Property pivotProperty) {
		assert !pivotProperty.isIsImplicit() && !pivotProperty.isIsComposite();
		if (oppositeProperty2oppositeCacheName == null) {
			oppositeProperty2oppositeCacheName = new HashMap<@NonNull Property, @NonNull String>();
		}
		if (!oppositeProperty2oppositeCacheName.containsKey(pivotProperty)) {
			oppositeProperty2oppositeCacheName.put(pivotProperty, globalNameManager.declareEagerName(null, "OPPOSITE_OF_" + pivotProperty.getOwningClass().getName() + "_" + pivotProperty.getName()).getResolvedName());
		}
		String name = oppositeProperty2oppositeCacheName.get(pivotProperty);
		assert name != null;
		return name;
	}

	private void addRequalification(org.eclipse.ocl.pivot.@NonNull Class asClass, @NonNull String extraPrefix) {
		Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull String> class2extraPrefix2 = class2extraPrefix;
		if (class2extraPrefix2 == null) {
			class2extraPrefix2 = class2extraPrefix = new HashMap<>();
		}
		class2extraPrefix2.put(asClass, extraPrefix);
		String qualifiedName = AbstractLanguageSupport.getQualifiedName(asClass);
		Map<@NonNull String, @NonNull String> qualifiedClassName2requalifiedClassName2 = qualifiedClassName2requalifiedClassName;
		if (qualifiedClassName2requalifiedClassName2 == null) {
			qualifiedClassName2requalifiedClassName2 = qualifiedClassName2requalifiedClassName = new HashMap<>();
		}
		qualifiedClassName2requalifiedClassName2.put(qualifiedName, extraPrefix + "." + qualifiedName);
	}

	private void appendSegmentName(@NonNull StringBuilder s, CGPackage cgPackage) {
		String pName = cgPackage.getName();
		if (pName != null && pName.length() > 0) {
			s.append(pName);
			s.append('.');
		}
	}

	@Override
	public @NonNull AS2CGVisitor createAS2CGVisitor(@NonNull CodeGenAnalyzer codeGenAnalyzer) {
		return new QVTiAS2CGVisitor((QVTiAnalyzer)codeGenAnalyzer);
	}

	@Override
	public @NonNull AnalysisVisitor createAnalysisVisitor() {
		return new QVTiCGModelAnalysisVisitor(analyzer);
	}

	@Override
	public @NonNull BoxingAnalyzer createBoxingAnalyzer() {
		return new QVTiCGModelBoxingAnalysisVisitor(analyzer);
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
		analyzer.setRootClass(asTransformation);				// Identify the host for synthesized nested classes
		CGTransformation cgTransformation = analyzer.createCGElement(CGTransformation.class, asTransformation);
		CGPackage cgPackage = (CGPackage) EcoreUtil.getRootContainer(cgTransformation);
		assert cgPackage != null;
		String packagePrefix = getOptions().getPackagePrefix();
		if (packagePrefix != null) {
			addRequalification(asTransformation, packagePrefix);
			org.eclipse.ocl.pivot.Package asCachePackage = AbstractLanguageSupport.basicGetCachePackage(asTransformation);
			if (asCachePackage != null) {
				for (org.eclipse.ocl.pivot.Class asCacheClass : PivotUtil.getOwnedClasses(asCachePackage))
					addRequalification(asCacheClass, packagePrefix);
			}
		}
		analyzer.analyzeExternalFeatures(cgTransformation);
		return cgPackage;
	}

	protected @NonNull CGPackage createCGPackage(org.eclipse.ocl.pivot.@NonNull Package asPackage) {

		// Target CG Package
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		String name = asPackage.getName();
		globalNameManager.declareEagerName(cgPackage, (name != null) && (name.length() > 0)? name : "_" + asTransformation.getName());

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
		globalNameManager.getOppositeIndex2PropertyIdName();
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
	protected @NonNull QVTiAnalyzer createCodeGenAnalyzer() {
		return new QVTiAnalyzer(this);
	}

	public @NonNull QVTiExecutableNameManager createExecutableNameManager(@NonNull ClassNameManager transformationNameManager, @NonNull ExecutableNameManager parentNameManager, @NonNull CGMappingLoop cgMappingLoop) {
		return new QVTiExecutableNameManager(transformationNameManager, parentNameManager, cgMappingLoop);
	}

	public @NonNull QVTiExecutableNameManager createMappingNameManager(@NonNull ClassNameManager transformationNameManager, @NonNull CGMapping cgMapping) {
		return new QVTiExecutableNameManager(transformationNameManager, transformationNameManager, cgMapping);
	}

	@Override
	public @NonNull QVTiExecutableNameManager createOperationNameManager(@NonNull ClassNameManager classNameManager, @NonNull CGOperation cgOperation) {
		return new QVTiExecutableNameManager(classNameManager, classNameManager, cgOperation);
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
		return new QVTiFieldingAnalyzer(analyzer);
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
		assert analyzer != null;			// Detects bad construction order
		return analyzer;
	}

	@Override
	public @NonNull ClassCallingConvention getCallingConvention(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		if (asClass instanceof Transformation) {
			return TransformationCallingConvention.INSTANCE;
		}
		return super.getCallingConvention(asClass);
	}

	@Override
	protected @NonNull OperationCallingConvention getCallingConventionInternal(@NonNull Operation asOperation, boolean isFinal) {
		if (asOperation instanceof Function) {
			Function asFunction = (Function)asOperation;
			LanguageExpression asBodyExpression = asOperation.getBodyExpression();
			if (asOperation.getImplementationClass() != null) {
				assert asBodyExpression == null;
				return ExternalFunctionOperationCallingConvention.INSTANCE;
			}
			else if (asBodyExpression != null) {
				ShadowExp asShadowExp = QVTimperativeUtil.basicGetShadowExp(asFunction);
				if (asShadowExp != null) {
					Type type = asShadowExp.getType();
					if (type instanceof DataType) {
						return ShadowDataTypeOperationCallingConvention.INSTANCE;
					}
					else {
						return ShadowClassOperationCallingConvention.INSTANCE;
					}
				}
				else {
					if (asFunction.isIsTransient()) {
						return TransientFunctionOperationCallingConvention.INSTANCE;
					}
					else {
						return InternalFunctionOperationCallingConvention.INSTANCE;
					}
				}
			}
			else {
				return EmptyFunctionOperationCallingConvention.INSTANCE;
			}
		}
		OperationCallingConvention callingConvention = super.getCallingConventionInternal(asOperation, isFinal);
		if (callingConvention == CachedOperationCallingConvention.INSTANCE) {
			return ExternalOperationOperationCallingConvention.INSTANCE;		// XXX promote to OCL
		}
		return callingConvention;
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

	@Override
	public @NonNull LanguageSupport getLanguageSupport() {
		JavaLanguageSupport javaLanguageSupport2 = javaLanguageSupport;
		if (javaLanguageSupport2 == null) {
			javaLanguageSupport = javaLanguageSupport2 = (JavaLanguageSupport)environmentFactory.getLanguageSupport("java");
			assert javaLanguageSupport2 != null;
		}
		return javaLanguageSupport2;
	}

	public @Nullable Map<@NonNull Property, @NonNull String> getOppositeProperties() {
		return oppositeProperty2oppositeCacheName;
	}

	@Override
	public @NonNull QVTiCodeGenOptions getOptions() {
		return (QVTiCodeGenOptions) super.getOptions();
	}

	public @NonNull String getQualifiedName() {
		return getRequalifiedClassName(asTransformation);
	}

	@Override
	public @NonNull String getRequalifiedClassName(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		String qualifiedName = super.getRequalifiedClassName(asClass);
		if (class2extraPrefix != null) {
			String extraPrefix = class2extraPrefix.get(asClass);
			if (extraPrefix != null) {
				return extraPrefix + "." + qualifiedName;
			}
		}
		return qualifiedName;
	}

	@Override
	public @NonNull String getRequalifiedClassName(@NonNull String qualifiedClassName) {
		if (qualifiedClassName2requalifiedClassName != null) {
			String requalifiedClassName = qualifiedClassName2requalifiedClassName.get(qualifiedClassName);
			if (requalifiedClassName != null) {
				return requalifiedClassName;
			}
		}
		return qualifiedClassName;
	}

	public @NonNull ImperativeTransformation getTransformation() {
		return asTransformation;
	}

	@Override
	protected void propagateChildNameResolution(@NonNull CGElement cgElement, @NonNull CGElement cgChild, @NonNull EReference eContainmentFeature, @Nullable NameResolution parentNameResolution) {
		if (false && eContainmentFeature == QVTiCGModelPackage.Literals.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE) {				// XXX
			CGPropertyAssignment cgPropertyAssignment = (CGPropertyAssignment)cgElement;
			NameResolution nameResolution = cgPropertyAssignment.basicGetNameResolution();
			if (nameResolution == null) {
				CGProperty cgProperty = QVTiCGUtil.getReferredProperty(cgPropertyAssignment);
				nameResolution = cgProperty.basicGetNameResolution();
				if (nameResolution == null) {		// Never happens
					NestedNameManager nestedNameManager = globalNameManager.useSelfNestedNameManager(cgProperty);
					nameResolution = nestedNameManager.getNameResolution(cgProperty);
				}
				//	nameResolution.addCGElement(cgPropertyAssignment);
				//	nameResolution.addCGElement((CGValuedElement)cgChild);
			}
			propagateNameResolution(cgChild, nameResolution);
		}
		else {
			super.propagateChildNameResolution(cgElement, cgChild, eContainmentFeature, parentNameResolution);
		}
	}

	public @NonNull File saveSourceFile(@NonNull String savePath) throws IOException {
		File saveRoot = new File(savePath);
		saveSourceFiles(ClassUtil.nonNullState(cgPackage), saveRoot);
		return saveRoot;
	}

	public void saveSourceFiles(@NonNull CGPackage cgPackage, @NonNull File saveRoot) throws IOException {
		for (CGPackage cgChildPackage : cgPackage.getPackages()) {
			if (cgChildPackage != null) {
				saveSourceFiles(cgChildPackage, saveRoot);
			}
		}
		for (CGClass cgClass : CGUtil.getClasses(cgPackage)) {
			String javaCodeSource = generateClassFile();
			org.eclipse.ocl.pivot.Class asClass = CGUtil.getAST(cgClass);
			String qualifiedName = getRequalifiedClassName(asClass);
			File folder = saveRoot;
			@NonNull String[] segments = qualifiedName.split("\\.");
			for (int i = 0; i < segments.length-1; i++) {			// Only generating one file so no point caching FILEs
				folder = new File(folder, segments[i]);
			}
			folder.mkdirs();
			Writer writer = new FileWriter(new File(folder, segments[segments.length-1] + ".java"));
			writer.append(javaCodeSource);
			writer.close();
		}
	}
}
