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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelBoxingAnalysisVisitor;

/**
 * An AbstractCS2ASCGBoxingAnalysisVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCS2ASCGBoxingAnalysisVisitor
	extends QVTiCGModelBoxingAnalysisVisitor
	implements CS2ASCGModelVisitor<@Nullable Object>
{
	protected AbstractCS2ASCGBoxingAnalysisVisitor(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	public @Nullable Object visitCGLookupCallExp(org.eclipse.qvtd.cs2as.compiler.cgmodel.@NonNull CGLookupCallExp object) {
		return visitCGOperationCallExp(object);
	}
}
