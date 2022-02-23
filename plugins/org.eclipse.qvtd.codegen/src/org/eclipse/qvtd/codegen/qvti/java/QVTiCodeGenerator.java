/*******************************************************************************
 * Copyright (c) 2013, 2022 Willink Transformations and others.
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
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.utilities.QVTiCGModelResourceFactory;
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
	protected final @NonNull ImperativeTransformation transformation;
	protected final @NonNull QVTiAnalyzer cgAnalyzer;
	protected final @NonNull QVTiGlobalContext globalContext;
	protected final @NonNull Map<@NonNull ImperativeTransformation, @NonNull EntryPointsAnalysis> transformation2analysis = new HashMap<>();
	private/* @LazyNonNull*/ CGPackage cgPackage;
	private/* @LazyNonNull*/ String javaSourceCode = null;

	public QVTiCodeGenerator(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation transformation) {
		super(environmentFactory);
		QVTiCG2StringVisitor.FACTORY.getClass();
		this.transformation = transformation;
		this.cgAnalyzer = new QVTiAnalyzer(this);
		this.globalContext = new QVTiGlobalContext(this);
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
		optimize(cgPackage2);
		List<@NonNull CGValuedElement> sortedGlobals = prepareGlobals();
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
	protected @NonNull NameManager createNameManager() {
		return new NameManager() {
			@Override
			public @Nullable String getNameHint(@NonNull Object anObject) {
				if (anObject instanceof CGSequence) {
					getClass();		// XXX
				}
				if (anObject instanceof CGEcorePropertyAssignment) {
					getClass();		// XXX
				}
				if (anObject instanceof CGValuedElement) {
					anObject = ((CGValuedElement)anObject).getNamedValue();
				}
				if (anObject instanceof CGMappingLoop) {
					return "loop";
				}
				return super.getNameHint(anObject);
			}

		};
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
