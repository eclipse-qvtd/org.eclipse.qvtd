/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.autogen.lookup.LookupUnqualifiedCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package example2.classes.util;

import example2.classes.ClassesPackage;
import example2.classes.Root;
import example2.classes.lookup.EnvironmentPackage;
import example2.classes.lookup.LookupEnvironment;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractEvaluationOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class ClassesUnqualifiedPackageLookupVisitor
	extends AbstractClassesCommonLookupVisitor
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/env/1.0", null, EnvironmentPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_java_c_s_s_example2_classes_util = IdManager.getRootPackageId("java://example2.classes.util");
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ClassesUnqualifiedPackageLookupVisitor = PACKid_java_c_s_s_example2_classes_util.getClassId("ClassesUnqualifiedPackageLookupVisitor", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0.getClassId("LookupEnvironment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Package = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Root = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);

	protected final /*@Thrown*/ @NonNull Executor executor;
	protected final /*@Thrown*/ @NonNull IdResolver idResolver;
	protected /*@Thrown*/ @Nullable Object child_0;

	public ClassesUnqualifiedPackageLookupVisitor(@NonNull LookupEnvironment context) {
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
	 * _'example2.classes.util'::ClassesUnqualifiedPackageLookupVisitor::visitPackage(element : classes::Package[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[1]
	 */
	protected class CACHE_ClassesUnqualifiedPackageLookupVisitor_visitPackage extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ example2.classes.@NonNull Package element_0 = (/*@NonInvalid*/ example2.classes.@NonNull Package)sourceAndArgumentValues[0];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<example2.classes.Package> ownedPackages = element_0.getOwnedPackages();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment inner = context.addElements(ownedPackages);
			final /*@NonInvalid*/ boolean hasFinalResult_0 = inner.hasFinalResult();
			/*@NonInvalid*/ @Nullable LookupEnvironment symbol_0;
			if (hasFinalResult_0) {
				symbol_0 = inner;
			}
			else {
				final /*@NonInvalid*/ @Nullable LookupEnvironment parentEnv_Package = ClassesUnqualifiedPackageLookupVisitor.this.parentEnv(element_0);
				symbol_0 = parentEnv_Package;
			}
			return symbol_0;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ example2.classes.@NonNull Package element_0) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{element_0});
		}
	}

	protected final @NonNull CACHE_ClassesUnqualifiedPackageLookupVisitor_visitPackage INSTANCE_ClassesUnqualifiedPackageLookupVisitor_visitPackage = new CACHE_ClassesUnqualifiedPackageLookupVisitor_visitPackage();

	/**
	 * _'example2.classes.util'::ClassesUnqualifiedPackageLookupVisitor::visitRoot(element : classes::Root[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[1]
	 */
	protected class CACHE_ClassesUnqualifiedPackageLookupVisitor_visitRoot extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull Root element_1 = (/*@NonInvalid*/ @NonNull Root)sourceAndArgumentValues[0];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<example2.classes.Package> ownedPackages = element_1.getOwnedPackages();
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull LookupEnvironment inner = context.addElements(ownedPackages);
			final /*@NonInvalid*/ boolean hasFinalResult_0 = inner.hasFinalResult();
			/*@NonInvalid*/ @Nullable LookupEnvironment symbol_0;
			if (hasFinalResult_0) {
				symbol_0 = inner;
			}
			else {
				final /*@NonInvalid*/ @Nullable LookupEnvironment parentEnv_Package = ClassesUnqualifiedPackageLookupVisitor.this.parentEnv(element_1);
				symbol_0 = parentEnv_Package;
			}
			return symbol_0;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull Root element_1) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{element_1});
		}
	}

	protected final @NonNull CACHE_ClassesUnqualifiedPackageLookupVisitor_visitRoot INSTANCE_ClassesUnqualifiedPackageLookupVisitor_visitRoot = new CACHE_ClassesUnqualifiedPackageLookupVisitor_visitRoot();
}
