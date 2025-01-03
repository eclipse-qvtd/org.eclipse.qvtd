/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.autogen.lookup.LookupUnqualifiedCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package example1.target.util;

import example1.target.A1;
import example1.target.B;
import example1.target.TargetPackage;
import example1.target.lookup.EnvironmentPackage;
import example1.target.lookup.LookupEnvironment;
import java.util.Iterator;
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
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;

public class TargetUnqualifiedBLookupVisitor
	extends AbstractTargetCommonLookupVisitor
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/env/1.0", null, EnvironmentPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/targetMM/1.0", null, TargetPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_java_c_s_s_example1_target_util = IdManager.getRootPackageId("java://example1.target.util");
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_A1 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A1", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_B = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("B", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0.getClassId("LookupEnvironment", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_TargetUnqualifiedBLookupVisitor = PACKid_java_c_s_s_example1_target_util.getClassId("TargetUnqualifiedBLookupVisitor", 0);
	public static final /*@NonInvalid*/ @NonNull CollectionTypeId ORD_CLSSid_B = TypeId.ORDERED_SET.getSpecializedId(CLSSid_B);

	protected final /*@Thrown*/ @NonNull Executor executor;
	protected final /*@Thrown*/ @NonNull IdResolver idResolver;
	protected /*@Thrown*/ @Nullable Object child_0;

	public TargetUnqualifiedBLookupVisitor(@NonNull LookupEnvironment context) {
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
	 * _'example1.target.util'::TargetUnqualifiedBLookupVisitor::visitA1(element : target::A1[1]) : lookup::LookupEnvironment[?]
	 *
	 * _'null' : lookup::LookupEnvironment[1]
	 */
	protected class CACHE_TargetUnqualifiedBLookupVisitor_visitA1 extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ @NonNull A1 element_0 = (/*@NonInvalid*/ @NonNull A1)sourceAndArgumentValues[0];
			@SuppressWarnings("null")
			final /*@NonInvalid*/ @NonNull List<B> ownsB = element_0.getOwnsB();
			final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownsB = idResolver.createOrderedSetOfAll(ORD_CLSSid_B, ownsB);
			final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownsB, child_0).booleanValue();
			/*@Thrown*/ @Nullable LookupEnvironment symbol_1;
			if (includes) {
				/*@Thrown*/ OrderedSetValue.@NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_B);
				@NonNull Iterator<Object> ITERATOR_x = BOXED_ownsB.iterator();
				/*@Thrown*/ @NonNull OrderedSetValue select;
				while (true) {
					if (!ITERATOR_x.hasNext()) {
						select = accumulator;
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull B x = (@NonNull B)ITERATOR_x.next();
					/**
					 * _'<' : Boolean[1]
					 */
					final /*@NonInvalid*/ @Nullable IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsB, x);
					if (indexOf == null) {
						throw new InvalidValueException("Null \'\'OclComparable\'\' rather than \'\'OclVoid\'\' value required");
					}
					final /*@Thrown*/ @Nullable IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsB, child_0);
					if (indexOf_0 == null) {
						throw new InvalidValueException("Null \'\'OclSelf\'\' rather than \'\'OclVoid\'\' value required");
					}
					if (indexOf_0 instanceof InvalidValueException) {
						throw (InvalidValueException)indexOf_0;
					}
					final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
					//
					if (lt == ValueUtil.TRUE_VALUE) {
						accumulator.add(x);
					}
				}
				final /*@Thrown*/ @NonNull List<B> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(B.class, select);
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull LookupEnvironment inner = context.addElements(ECORE_select);
				final /*@Thrown*/ boolean hasFinalResult_0 = inner.hasFinalResult();
				/*@Thrown*/ @Nullable LookupEnvironment symbol_0;
				if (hasFinalResult_0) {
					symbol_0 = inner;
				}
				else {
					final /*@NonInvalid*/ @Nullable LookupEnvironment parentEnv_B = TargetUnqualifiedBLookupVisitor.this.parentEnv(element_0);
					symbol_0 = parentEnv_B;
				}
				symbol_1 = symbol_0;
			}
			else {
				final /*@NonInvalid*/ @Nullable LookupEnvironment parentEnv_B_0 = TargetUnqualifiedBLookupVisitor.this.parentEnv(element_0);
				symbol_1 = parentEnv_B_0;
			}
			return symbol_1;
		}

		public LookupEnvironment evaluate(final /*@NonInvalid*/ @NonNull A1 element_0) {
			return (LookupEnvironment)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{element_0});
		}
	}

	protected final @NonNull CACHE_TargetUnqualifiedBLookupVisitor_visitA1 INSTANCE_TargetUnqualifiedBLookupVisitor_visitA1 = new CACHE_TargetUnqualifiedBLookupVisitor_visitA1();
}
