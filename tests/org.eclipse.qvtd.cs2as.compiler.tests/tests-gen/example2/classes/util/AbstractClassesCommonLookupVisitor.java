/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example2/Classes.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example2.classes.util;
import org.eclipse.jdt.annotation.NonNull;

import example2.classes.lookup.LookupEnvironment;

public abstract class AbstractClassesCommonLookupVisitor
	extends AbstractExtendingVisitor<LookupEnvironment, LookupEnvironment> {

	protected AbstractClassesCommonLookupVisitor(LookupEnvironment context) {
		super(context);
	}
	
	@Override
	public final LookupEnvironment visiting(@NonNull Visitable visitable) {
		return doVisiting(visitable);
	}
	
	
	abstract protected LookupEnvironment doVisiting(@NonNull Visitable visitable);
	
}
