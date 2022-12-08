/**
 * Copyright (c) 2013 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     E.D.Willink - initial API and implementation
 */
package org.eclipse.qvtd.cs2as.build.xtend;

import com.google.common.collect.Lists;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.build.xtend.GenerateVisitorsXtend;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.naming.NameManagerHelper;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;

@SuppressWarnings("all")
public class GenerateCS2ASCGVisitors extends GenerateVisitorsXtend {
  @Override
  public void generateVisitors(final GenPackage genPackage) {
    EPackage ePackage = genPackage.getEcorePackage();
    this.generateAbstractExtendingVisitor(ePackage);
    this.generateAbstractNonNullExtendingVisitor(ePackage);
    this.generateVisitorInterface(genPackage);
    this.generateAbstractVisitor(ePackage);
    this.generateAbstractNullVisitor(ePackage);
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(NonNull.class, Nullable.class, QVTiAnalyzer.class), 
      "AbstractCS2ASAnalysisVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalysisVisitor", "@Nullable Object", "@NonNull QVTiAnalyzer analyzer", "analyzer");
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(NonNull.class, Nullable.class, QVTiAnalyzer.class), 
      "AbstractCS2ASBoxingAnalysisVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiBoxingAnalyzer", "@Nullable Object", "@NonNull QVTiAnalyzer analyzer", "analyzer");
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(Iterable.class, NonNull.class, Nullable.class, QVTiCodeGenerator.class, CGPackage.class, CGValuedElement.class), 
      "AbstractCS2ASCG2JavaVisitor", "org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaVisitor", "@NonNull Boolean", "@NonNull QVTiCodeGenerator codeGenerator, @NonNull CGPackage cgPackage, @Nullable Iterable<@NonNull CGValuedElement> sortedGlobals", "codeGenerator, cgPackage, sortedGlobals");
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(NonNull.class, Nullable.class, QVTiCodeGenerator.class), 
      "AbstractCS2ASCG2JavaNameVisitor", "org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaNameVisitor", "@Nullable Object", "@NonNull QVTiCodeGenerator codeGenerator", "codeGenerator");
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(NonNull.class, Nullable.class, QVTiCodeGenerator.class), 
      "AbstractCS2ASCG2JavaPreVisitor", "org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaPreVisitor", "@Nullable Object", "@NonNull QVTiCodeGenerator codeGenerator", "codeGenerator");
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(NonNull.class, NameManagerHelper.class), 
      "AbstractCS2ASCGNameHelperVisitor", "org.eclipse.qvtd.codegen.qvti.naming.QVTiCGNameHelperVisitor", "@NonNull String", "@NonNull NameManagerHelper context", "context");
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(NonNull.class, Nullable.class), 
      "AbstractCS2ASCG2StringVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiCG2StringVisitor", "@Nullable String", "", "");
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(NonNull.class, QVTiCodeGenerator.class, GlobalPlace.class), 
      "AbstractCS2ASDependencyVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiDependencyVisitor", "Object", "@NonNull QVTiCodeGenerator codeGenerator, @NonNull GlobalPlace globalPlace", "codeGenerator, globalPlace");
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(NonNull.class, FieldingAnalyzer.class, FieldingAnalyzer.ReturnState.class), 
      "AbstractCS2ASFieldingAnalysisVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiFieldingAnalysisVisitor", "@NonNull ReturnState", "@NonNull FieldingAnalyzer context, @NonNull ReturnState requiredReturn", "context, requiredReturn");
    this.generateAbstractGenericVisitor3(ePackage, Lists.<Class<?>>newArrayList(List.class, NonNull.class, Nullable.class), 
      "AbstractCS2ASReferencesVisitor", "org.eclipse.qvtd.codegen.qvti.analyzer.QVTiReferencesVisitor", "@NonNull List<@Nullable Object>", "@Nullable Object context", "context");
  }
}
