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
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;

/**
 * An AbstractCS2ASBoxingAnalysisVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCS2ASBoxingAnalysisVisitor
	extends org.eclipse.qvtd.codegen.qvti.analyzer.QVTiBoxingAnalyzer
	implements CS2ASCGModelVisitor<@Nullable Object>
{
	protected AbstractCS2ASBoxingAnalysisVisitor(@NonNull QVTiAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	public @Nullable Object visitCGLookupCallExp(org.eclipse.qvtd.cs2as.compiler.cgmodel.@NonNull CGLookupCallExp object) {
		return visitCGOperationCallExp(object);
	}
}
