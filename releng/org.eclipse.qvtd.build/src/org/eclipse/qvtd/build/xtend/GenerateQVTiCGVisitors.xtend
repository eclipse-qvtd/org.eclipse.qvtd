/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.xtend

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer.ReturnState
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.jdt.annotation.Nullable
import com.google.common.collect.Lists
import java.util.List
import org.eclipse.ocl.examples.build.xtend.GenerateVisitorsXtend
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement
import org.eclipse.ocl.examples.codegen.naming.NameManagerHelper

class GenerateQVTiCGVisitors extends GenerateVisitorsXtend
{
	override void generateVisitors(/*@NonNull*/ GenPackage genPackage) {
		var EPackage ePackage = genPackage.getEcorePackage();
		ePackage.generateAbstractExtendingVisitor();
		ePackage.generateAbstractNonNullExtendingVisitor();
		genPackage.generateVisitorInterface();
		/* ePackage.generateDecorableVisitorInterface("org.eclipse.ocl.xtext.base.util.BaseCSVisitor"); */
		ePackage.generateAbstractVisitor();
		ePackage.generateAbstractNullVisitor();
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable, CodeGenAnalyzer),
			"AbstractQVTiAnalysisVisitor", "org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor", "@Nullable Object", "@NonNull CodeGenAnalyzer analyzer", "analyzer");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable, CodeGenAnalyzer),
			"AbstractQVTiBoxingAnalysisVisitor", "org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer", "@Nullable Object", "@NonNull CodeGenAnalyzer analyzer", "analyzer");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(Iterable, NonNull, Nullable, JavaCodeGenerator, CGPackage, CGValuedElement),
			"AbstractQVTiCG2JavaVisitor", "org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor", "@NonNull Boolean", "@NonNull JavaCodeGenerator codeGenerator, @NonNull CGPackage cgPackage, @Nullable Iterable<@NonNull CGValuedElement> sortedGlobals", "codeGenerator, cgPackage, sortedGlobals");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable, JavaCodeGenerator),
			"AbstractQVTiCG2JavaNameVisitor", "org.eclipse.ocl.examples.codegen.java.CG2JavaNameVisitor", "@Nullable Object", "@NonNull JavaCodeGenerator codeGenerator", "codeGenerator");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable, JavaCodeGenerator),
			"AbstractQVTiCG2JavaPreVisitor", "org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor", "@Nullable Object", "@NonNull JavaCodeGenerator codeGenerator", "codeGenerator");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, NameManagerHelper),
			"AbstractQVTiCGNameHelperVisitor", "org.eclipse.ocl.examples.codegen.naming.NameManagerHelper.CGNameHelper", "@NonNull String", "@NonNull NameManagerHelper context", "context");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable),
			"AbstractQVTiCG2StringVisitor", "org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor", "@Nullable String", "", "");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, JavaCodeGenerator, GlobalPlace),
			"AbstractQVTiDependencyVisitor", "org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor", "Object", "@NonNull JavaCodeGenerator codeGenerator, @NonNull GlobalPlace globalPlace", "codeGenerator, globalPlace");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, FieldingAnalyzer, ReturnState),
			"AbstractQVTiFieldingAnalysisVisitor", "org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalysisVisitor", "@NonNull ReturnState", "@NonNull FieldingAnalyzer context, @NonNull ReturnState requiredReturn", "context, requiredReturn");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(List, NonNull, Nullable),
			"AbstractQVTiReferencesVisitor", "org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor", "@NonNull List<@Nullable Object>", "@Nullable Object context", "context");
	}
}
