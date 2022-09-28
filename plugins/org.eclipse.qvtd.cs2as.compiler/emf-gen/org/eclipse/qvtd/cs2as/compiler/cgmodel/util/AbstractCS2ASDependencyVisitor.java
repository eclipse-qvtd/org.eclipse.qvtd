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
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;

/**
 * An AbstractCS2ASDependencyVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractCS2ASDependencyVisitor
	extends org.eclipse.qvtd.codegen.qvti.analyzer.QVTiDependencyVisitor
	implements CS2ASCGModelVisitor<Object>
{
	protected AbstractCS2ASDependencyVisitor(@NonNull QVTiCodeGenerator codeGenerator, @NonNull GlobalPlace globalPlace) {
		super(codeGenerator, globalPlace);
	}

	@Override
	public Object visitCGLookupCallExp(org.eclipse.qvtd.cs2as.compiler.cgmodel.@NonNull CGLookupCallExp object) {
		return visitCGOperationCallExp(object);
	}
}
