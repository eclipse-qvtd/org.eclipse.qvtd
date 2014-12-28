/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.utilities.CGModelResourceFactory;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.utilities.QVTiCGModelResourceFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * QVTiCodeGenerator supports generation of the content of a JavaClassFile to
 * execute a QVTi transformation.
 */
public class QVTiCodeGenerator extends JavaCodeGenerator
{	
	protected final @NonNull QVTiAnalyzer cgAnalyzer;
	protected final @NonNull Transformation transformation;
	private/* @LazyNonNull */String javaSourceCode = null;
	protected final @NonNull QVTiGlobalContext globalContext = new QVTiGlobalContext(this);

	public QVTiCodeGenerator(@NonNull MetamodelManager metamodelManager, @NonNull Transformation transformation) {
		super(metamodelManager);
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

	protected @NonNull CGPackage createCGPackage() {
		String packagePrefix = getOptions().getPackagePrefix();
		CGPackage cgPackage = CGModelFactory.eINSTANCE.createCGPackage();
		cgPackage.setName(packagePrefix);
		QVTiAS2CGVisitor pivot2CGVisitor = new QVTiAS2CGVisitor(cgAnalyzer,
			getGlobalContext());
		CGTransformation cgTransformation = (CGTransformation) ClassUtil
			.nonNullState(transformation.accept(pivot2CGVisitor));
		cgPackage.getClasses().add(cgTransformation);
		return cgPackage;
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
			CGPackage cgPackage = createCGPackage();
			optimize(cgPackage);
			List<CGValuedElement> sortedGlobals = prepareGlobals();
			QVTiCG2JavaVisitor generator = new QVTiCG2JavaVisitor(this, cgPackage, sortedGlobals);
			generator.safeVisit(cgPackage);
			Set<String> allImports = generator.getAllImports();
			Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
			javaSourceCode = javaSourceCode2 = ImportUtils.resolveImports(generator.toString(), long2ShortImportNames);
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
		String className = ClassUtil.nonNullState(transformation.getName());
		String packagePrefix = getOptions().getPackagePrefix();
		if (packagePrefix != null) {
			return packagePrefix + "." + className;
		} else {
			return className;
		}
	}

	public void saveSourceFile(@NonNull String savePath) throws IOException {
		String javaCodeSource = generateClassFile();
		String qualifiedName = getQualifiedName();
		String saveDir = savePath + qualifiedName.replace('.', '/');
		String fileName = saveDir + ".java";
		new File(saveDir).getParentFile().mkdirs();
		Writer writer = new FileWriter(fileName);
		writer.append(javaCodeSource);
		writer.close();
	}
}
