/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvti;
/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */


import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * OCL2JavaClass supports generation of the content of a JavaClassFile with a ststic INSTANCE to provide the polymorphic implementation
 * of an ExpressionInOCL.
 */
public class QVTiCodeGenerator extends JavaCodeGenerator
{
	protected final @NonNull QVTiAnalyzer cgAnalyzer;
	protected final @NonNull Transformation transformation;
	protected final @NonNull QVTiCG2JavaVisitor generator;
//	protected final @NonNull CGPackage cgPackage;

	public QVTiCodeGenerator(@NonNull MetaModelManager metaModelManager, @NonNull Transformation transformation, @NonNull String packageName, boolean useNullAnnotations) {
		super(metaModelManager);
		QVTiCG2StringVisitor.FACTORY.getClass();
		getOptions().setUseNullAnnotations(useNullAnnotations);
		cgAnalyzer = new QVTiAnalyzer(this);
		this.transformation = transformation;
//		this.genPackage = genPackage;
		this.generator = new QVTiCG2JavaVisitor(this, transformation, packageName, transformation.getName());
		/*this.cgPackage =*/ generator.generate();
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

	@Override
	public DependencyVisitor createDependencyVisitor() {
		return new QVTiDependencyVisitor(cgAnalyzer, getGlobalContext());
	}

	@Override
	public DependencyVisitor createDependencyVisitor(@NonNull JavaLocalContext localContext) {
		return new QVTiDependencyVisitor((QVTiLocalContext) localContext);
	}

	@Override
	public @NonNull FieldingAnalyzer createFieldingAnalyzer() {
		return new QVTiFieldingAnalyzer(cgAnalyzer);
	}

	@Override
	protected @NonNull QVTiGlobalContext createGlobalContext() {
		return new QVTiGlobalContext(this);
	}

	public @NonNull String generateClassFile() {
	//		QVTiCG2JavaClassVisitor generator = QVTiCG2JavaClassVisitor.generate(this, transformation, packageName, className);
			Set<String> allImports = generator.getAllImports();
			Map<String, String> long2ShortImportNames = ImportUtils.getLong2ShortImportNames(allImports);
			return ImportUtils.resolveImports(generator.toString(), long2ShortImportNames);
		}

	@Override
	public @NonNull QVTiAnalyzer getAnalyzer() {
		return cgAnalyzer;
	}

	@Override
	public @NonNull QVTiGlobalContext getGlobalContext() {
		return (QVTiGlobalContext) super.getGlobalContext();
	}
}
