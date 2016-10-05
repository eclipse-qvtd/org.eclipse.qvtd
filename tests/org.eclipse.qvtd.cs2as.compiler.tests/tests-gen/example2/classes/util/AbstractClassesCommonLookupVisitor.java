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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationCache;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal.ExecutorInternalExtension;

import example2.classes.lookup.LookupEnvironment;
import example2.classes.util.Visitable;

public abstract class AbstractClassesCommonLookupVisitor
	extends AbstractExtendingVisitor<@Nullable LookupEnvironment, @NonNull LookupEnvironment> {

	protected final @NonNull EvaluationCache evaluationCache;
	
	protected AbstractClassesCommonLookupVisitor(@NonNull LookupEnvironment context) {
		super(context);
		this.evaluationCache = ((ExecutorInternalExtension)context.getExecutor()).getEvaluationCache();
	}
	
	@Override
	public final LookupEnvironment visiting(@NonNull Visitable visitable) {
		return doVisiting(visitable);
	}
	
	
	abstract protected LookupEnvironment doVisiting(@NonNull Visitable visitable);
	
}
