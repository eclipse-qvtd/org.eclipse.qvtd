/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import java.util.Set;

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
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.utilities.CGModelResourceFactory;
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
import org.eclipse.qvtd.codegen.utilities.QVTiCGModelResourceFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;

/**
 * QVTiCodeGenerator supports generation of the content of a JavaClassFile to
 * execute a QVTi transformation.
 */
public class QVTiCodeGenerator extends JavaCodeGenerator
{	
	protected final @NonNull QVTiAnalyzer cgAnalyzer;
	protected final @NonNull Transformation transformation;
	private/* @LazyNonNull*/ CGPackage cgPackage;
	private/* @LazyNonNull*/ String javaSourceCode = null;
	protected final @NonNull QVTiGlobalContext globalContext = new QVTiGlobalContext(this);
	protected final @NonNull Map<Transformation, QVTiTransformationAnalysis> transformation2analysis = new HashMap<Transformation, QVTiTransformationAnalysis>();

	public QVTiCodeGenerator(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Transformation transformation) {
		super(environmentFactory);
		QVTiCG2StringVisitor.FACTORY.getClass();
		cgAnalyzer = new QVTiAnalyzer(this);
		this.transformation = transformation;
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

	protected @NonNull QVTiCG2JavaVisitor createCG2JavaVisitor(@NonNull CGPackage cgPackage, @Nullable List<CGValuedElement> sortedGlobals) {
		return new QVTiCG2JavaVisitor(this, cgPackage, sortedGlobals);
	}

	protected @NonNull CGPackage createCGPackage() {
		CGPackage cgPackage = createPrefixedCGPackage(ClassUtil.nonNullModel(transformation.getOwningPackage()), getOptions().getPackagePrefix());
		QVTiAS2CGVisitor pivot2CGVisitor = createAS2CGVisitor(cgAnalyzer, getGlobalContext());
		CGTransformation cgTransformation = (CGTransformation) ClassUtil.nonNullState(transformation.accept(pivot2CGVisitor));
		cgPackage.getClasses().add(cgTransformation);
		while (cgPackage.eContainer() != null) {
			cgPackage = (CGPackage)cgPackage.eContainer();
		}
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
	
	protected @NonNull CGPackage createPrefixedCGPackage(org.eclipse.ocl.pivot.@NonNull Package asPackage, String packagePrefix) {
		
		CGPackage cgPackage = createCGPackage(asPackage);
		// Prefix Packages		
		if (packagePrefix != null) {
			CGPackage lastSPackage = null;
			for (String segment : packagePrefix.split("\\.")) {
				CGPackage sPackage = CGModelFactory.eINSTANCE.createCGPackage();
				sPackage.setName(segment);
				if (lastSPackage != null) {
					lastSPackage.getPackages().add(sPackage);
				}
				lastSPackage = sPackage;
			}
			// We add the root created CG Package to the last prefix segment CG Package
			if (lastSPackage != null) {
				CGPackage cgParentPackage = cgPackage;
				while (cgParentPackage.eContainer() != null) {
					cgParentPackage = (CGPackage)cgParentPackage.eContainer();
				}
				lastSPackage.getPackages().add(cgParentPackage);
			}
		}
		return cgPackage;
	}

	protected @NonNull QVTiAS2CGVisitor createAS2CGVisitor(@NonNull QVTiAnalyzer analyzer, @NonNull QVTiGlobalContext gContext) {
		return new QVTiAS2CGVisitor(analyzer, gContext);
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
	protected @NonNull NameManager createNameManager() {
		return new NameManager() {
			@Override
			public @Nullable String getNameHint(@NonNull Object anObject) {
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
			CGPackage cgPackage2 = createCGPackage();
			cgPackage = cgPackage2;
			optimize(cgPackage2);
			List<CGValuedElement> sortedGlobals = prepareGlobals();
			QVTiCG2JavaVisitor generator = createCG2JavaVisitor(cgPackage2, sortedGlobals);
			generator.safeVisit(cgPackage2);
			Set<String> allImports = generator.getAllImports();
			Map<@NonNull String, @Nullable String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
			javaSourceCode = javaSourceCode2 = ImportUtils.resolveImports(generator.toString(), long2ShortImportNames, false);
		}
		return javaSourceCode2;
	}

	@Override
	public @NonNull QVTiAnalyzer getAnalyzer() {
		return cgAnalyzer;
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
		
		s.append(transformation.getName());
		return s.toString();
	}
	
	private void appendSegmentName(@NonNull StringBuilder s, CGPackage sPackage) {
		String pName = sPackage.getName();
		if (pName != null && pName.length() > 0) {
			s.append(pName);
			s.append('.');
		}
	}

	public @NonNull QVTiTransformationAnalysis getTransformationAnalysis(@NonNull Transformation transformation) {
//		Map<Transformation, QVTiTransformationAnalysis> transformation2analysis = new HashMap<Transformation, QVTiTransformationAnalysis>();
		QVTiTransformationAnalysis transformationAnalysis = transformation2analysis.get(transformation);
		if (transformationAnalysis == null) {
			transformationAnalysis = new QVTiTransformationAnalysis(getEnvironmentFactory());
			transformationAnalysis.analyzeTransformation(transformation);
			transformation2analysis.put(transformation, transformationAnalysis);
		}
		return transformationAnalysis;
	}

	public void saveSourceFile(@NonNull String savePath) throws IOException {
		saveSourceFiles(ClassUtil.nonNullState(cgPackage), new File(savePath));
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
