package org.eclipse.qvtd.build.xtend

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.ocl.examples.build.xtend.GenerateVisitorsXtend

public class GenerateEvaluationStatusVisitors extends GenerateVisitorsXtend
{
	override void generateVisitors(/*@NonNull*/ GenPackage genPackage) {
		var EPackage ePackage = genPackage.getEcorePackage();
		ePackage.generateAbstractExtendingVisitor();
		ePackage.generateAbstractNonNullExtendingVisitor();
		genPackage.generateVisitorInterface();
		/* ePackage.generateDecorableVisitorInterface("org.eclipse.ocl.xtext.base.util.BaseCSVisitor"); */
		ePackage.generateAbstractVisitor();
//		ePackage.generateAbstractNullVisitor();
	}
}
