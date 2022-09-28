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
package org.eclipse.qvtd.cs2as.build.xtend

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer.ReturnState
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.jdt.annotation.Nullable
import com.google.common.collect.Lists
import java.util.List
import org.eclipse.ocl.examples.build.xtend.GenerateVisitorsXtend
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement
import org.eclipse.ocl.examples.codegen.naming.NameManagerHelper
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator

class GenerateCS2ASCGVisitors extends GenerateVisitorsXtend
{
	override void generateVisitors(/*@NonNull*/ GenPackage genPackage) {
		var EPackage ePackage = genPackage.getEcorePackage();
		ePackage.generateAbstractExtendingVisitor();
		ePackage.generateAbstractNonNullExtendingVisitor();
		genPackage.generateVisitorInterface();
		/* ePackage.generateDecorableVisitorInterface("org.eclipse.ocl.xtext.base.util.BaseCSVisitor"); */
		ePackage.generateAbstractVisitor();
		ePackage.generateAbstractNullVisitor();
/* 			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(NonNull, Nullable, QVTiAnalyzer),
				"Analysis", "@Nullable Object", "@NonNull QVTiAnalyzer analyzer", "analyzer");
			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(NonNull, Nullable, QVTiAnalyzer),
				"BoxingAnalysis", "@Nullable Object", "@NonNull QVTiAnalyzer analyzer", "analyzer");
			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(Iterable, NonNull, Nullable, QVTiCodeGenerator, CGPackage, CGValuedElement),
				"CG2Java", "@NonNull Boolean", "@NonNull QVTiCodeGenerator codeGenerator, @NonNull CGPackage cgPackage, @Nullable Iterable<@NonNull CGValuedElement> sortedGlobals", "codeGenerator, cgPackage, sortedGlobals");
			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(NonNull, Nullable, QVTiCodeGenerator),
				"CG2JavaName", "@Nullable Object", "@NonNull QVTiCodeGenerator codeGenerator", "codeGenerator");
			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(NonNull, Nullable, QVTiCodeGenerator),
				"CG2JavaPre", "@Nullable Object", "@NonNull QVTiCodeGenerator codeGenerator", "codeGenerator");
			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(NonNull, NameManagerHelper),
				"CGNameHelper", "@NonNull String", "@NonNull NameManagerHelper context", "context");
			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(NonNull, Nullable),
				"CG2String", "@Nullable String", "", "");
			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(NonNull, QVTiCodeGenerator, GlobalPlace),
				"Dependency", "Object", "@NonNull QVTiCodeGenerator codeGenerator, @NonNull GlobalPlace globalPlace", "codeGenerator, globalPlace");
			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(NonNull, FieldingAnalyzer, ReturnState),
				"FieldingAnalysis", "@NonNull ReturnState", "@NonNull FieldingAnalyzer context, @NonNull ReturnState requiredReturn", "context, requiredReturn");
			ePackage.generateAbstractGenericVisitor2(Lists.newArrayList(List, NonNull, Nullable),
				"References", "@NonNull List<@Nullable Object>", "@Nullable Object context", "context"); */
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable, QVTiAnalyzer),
			"AbstractCS2ASAnalysisVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalysisVisitor", "@Nullable Object", "@NonNull QVTiAnalyzer analyzer", "analyzer");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable, QVTiAnalyzer),
			"AbstractCS2ASBoxingAnalysisVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiBoxingAnalyzer", "@Nullable Object", "@NonNull QVTiAnalyzer analyzer", "analyzer");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(Iterable, NonNull, Nullable, QVTiCodeGenerator, CGPackage, CGValuedElement),
			"AbstractCS2ASCG2JavaVisitor", "org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaVisitor", "@NonNull Boolean", "@NonNull QVTiCodeGenerator codeGenerator, @NonNull CGPackage cgPackage, @Nullable Iterable<@NonNull CGValuedElement> sortedGlobals", "codeGenerator, cgPackage, sortedGlobals");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable, QVTiCodeGenerator),
			"AbstractCS2ASCG2JavaNameVisitor", "org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaNameVisitor", "@Nullable Object", "@NonNull QVTiCodeGenerator codeGenerator", "codeGenerator");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable, QVTiCodeGenerator),
			"AbstractCS2ASCG2JavaPreVisitor", "org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaPreVisitor", "@Nullable Object", "@NonNull QVTiCodeGenerator codeGenerator", "codeGenerator");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, NameManagerHelper),
			"AbstractCS2ASCGNameHelperVisitor", "org.eclipse.qvtd.codegen.qvti.naming.QVTiCGNameHelperVisitor", "@NonNull String", "@NonNull NameManagerHelper context", "context");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, Nullable),
			"AbstractCS2ASCG2StringVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiCG2StringVisitor", "@Nullable String", "", "");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, QVTiCodeGenerator, GlobalPlace),
			"AbstractCS2ASDependencyVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiDependencyVisitor", "Object", "@NonNull QVTiCodeGenerator codeGenerator, @NonNull GlobalPlace globalPlace", "codeGenerator, globalPlace");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(NonNull, FieldingAnalyzer, ReturnState),
			"AbstractCS2ASFieldingAnalysisVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiFieldingAnalysisVisitor", "@NonNull ReturnState", "@NonNull FieldingAnalyzer context, @NonNull ReturnState requiredReturn", "context, requiredReturn");
		ePackage.generateAbstractGenericVisitor3(Lists.newArrayList(List, NonNull, Nullable),
			"AbstractCS2ASReferencesVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiReferencesVisitor", "@NonNull List<@Nullable Object>", "@Nullable Object context", "context");
	}
}
