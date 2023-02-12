/*******************************************************************************
 * <copyright>
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler/model/cs2ascgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.cs2as.compiler.cgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer.ReturnState;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiFieldingAnalyzer;

/**
 * An AbstractCS2ASFieldingAnalysisVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCS2ASFieldingAnalysisVisitor
extends org.eclipse.qvtd.codegen.qvti.analyzer.QVTiFieldingAnalysisVisitor
implements CS2ASCGModelVisitor<@NonNull ReturnState>
{
	protected AbstractCS2ASFieldingAnalysisVisitor(@NonNull QVTiFieldingAnalyzer context, @NonNull ReturnState requiredReturn) {
		super(context, requiredReturn);
	}

	@Override
	public @NonNull ReturnState visitCGLookupCallExp(org.eclipse.qvtd.cs2as.compiler.cgmodel.@NonNull CGLookupCallExp object) {
		return visitCGOperationCallExp(object);
	}
}
