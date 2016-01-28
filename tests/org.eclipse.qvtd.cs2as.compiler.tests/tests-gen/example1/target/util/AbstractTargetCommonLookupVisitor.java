/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example1/TargetMM1.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example1.target.util;
import org.eclipse.jdt.annotation.NonNull;
import example1.target.lookup.LookupEnvironment;
import example1.target.util.Visitable;

public abstract class AbstractTargetCommonLookupVisitor
	extends AbstractExtendingVisitor<LookupEnvironment, LookupEnvironment> {

	protected AbstractTargetCommonLookupVisitor(LookupEnvironment context) {
		super(context);
	}
	
	@Override
	public final LookupEnvironment visiting(@NonNull Visitable visitable) {
		return doVisiting(visitable);
	}
	
	abstract protected LookupEnvironment doVisiting(@NonNull Visitable visitable);
}
