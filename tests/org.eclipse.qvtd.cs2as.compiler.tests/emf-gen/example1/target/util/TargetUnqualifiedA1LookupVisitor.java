/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.autogen.lookup.LookupUnqualifiedCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package example1.target.util;

import example1.target.A;
import example1.target.TargetPackage;
import example1.target.lookup.EnvironmentPackage;
import example1.target.lookup.LookupEnvironment;
import example1.target.util.AbstractTargetCommonLookupVisitor;
import example1.target.util.Visitable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractEvaluationOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

public class TargetUnqualifiedA1LookupVisitor
	extends AbstractTargetCommonLookupVisitor
{
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/env/1.0", null, EnvironmentPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/targetMM/1.0", null, TargetPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_java_c_s_s_example1_target_util = IdManager.getRootPackageId("java://example1.target.util");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_A = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0.getClassId("LookupEnvironment", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("TRoot", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TargetUnqualifiedA1LookupVisitor = PACKid_java_c_s_s_example1_target_util.getClassId("TargetUnqualifiedA1LookupVisitor", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_A = TypeId.ORDERED_SET.getSpecializedId(CLSSid_A);

	protected final /*@Thrown*/ org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor executor;
	protected final /*@Thrown*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver;
	protected /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child_0;

	public TargetUnqualifiedA1LookupVisitor(@NonNull LookupEnvironment context) {
		super(context);
		this.executor = ClassUtil.nonNull(context.getExecutor());
		this.idResolver = executor.getIdResolver();
	}

	@Override
	protected @Nullable LookupEnvironment doVisiting(@NonNull Visitable visitable) {
		return parentEnv((EObject)visitable);
	}

	/**
	 * Continue the search for matches in the parent of element.
	 */
	protected @Nullable LookupEnvironment parentEnv(@NonNull EObject element) {
		EObject parent = element.eContainer();
		if (parent instanceof Visitable) {
			this.child_0 = element;
			return ((Visitable)parent).accept(this);
		}
		else {
			return context;
		}
	}

	/**
	 * _'example1.target.util'::TargetUnqualifiedA1LookupVisitor::visitTRoot(element : target::TRoot[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[1]
	 */
	protected class CACHE_TargetUnqualifiedA1LookupVisitor_visitTRoot extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull TRoot element_0 = (/*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull TRoot)sourceAndArgumentValues[0];
			final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = TargetUnqualifiedA1LookupVisitor.this.parentEnv(element_0);
			if (parentEnv_0 == null) {
				throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::addElements(NE)(Collection(addElements.NE)) : lookup::LookupEnvironment[1]\'");
			}
			@SuppressWarnings("null")
			final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<A> ownedA = element_0.getOwnedA();
			@SuppressWarnings("null")
			final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = parentEnv_0.addElements(ownedA);
			return addElements;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull TRoot element_0) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{element_0});
		}
	}

	protected final @NonNull CACHE_TargetUnqualifiedA1LookupVisitor_visitTRoot INSTANCE_TargetUnqualifiedA1LookupVisitor_visitTRoot = new CACHE_TargetUnqualifiedA1LookupVisitor_visitTRoot();
}
