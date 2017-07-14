/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.autogen.lookup.LookupFilterGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package example2.classes.lookup.util;

import example2.classes.Argument;
import example2.classes.ClassesPackage;
import example2.classes.Operation;
import example2.classes.Parameter;
import example2.classes.lookup.util.AbstractClassesLookupFilter;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.evaluation.EvaluationCache;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractEvaluationOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionAtOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;

public class OperationFilter
	extends AbstractClassesLookupFilter<Operation>
{
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_java_c_s_s_example2_classes_lookup_util = IdManager.getRootPackageId("java://example2.classes.lookup.util");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Argument = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Argument", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Operation", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationFilter = PACKid_java_c_s_s_example2_classes_lookup_util.getClassId("OperationFilter", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Parameter = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Parameter", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Argument = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Argument);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);

	protected final @NonNull EvaluationCache evaluationCache;
	protected final /*@Thrown*/ org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor executor;
	protected final /*@Thrown*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver;
	protected final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Argument> args;

	public OperationFilter(@NonNull Executor executor,final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Argument> args) {
		super(Operation.class);
		this.args =  args;
		this.executor = executor;
		this.idResolver = executor.getIdResolver();
		this.evaluationCache = ((ExecutorInternal.ExecutorInternalExtension)executor).getEvaluationCache();
	}

	@Override
	protected Boolean _matches(final /*@NonInvalid*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation element_0) {
		return INSTANCE_OperationFilter__matches.evaluate(element_0);
	}

	/**
	 * _'example2.classes.lookup.util'::OperationFilter::_matches(element : classes::Operation[1]) : Boolean[?]
	 *
	 * _'null' : Boolean[?]
	 */
	public class CACHE_OperationFilter__matches extends AbstractEvaluationOperation
	{
		@Override
		public @Nullable Object basicEvaluate(@NonNull Executor executor, @NonNull TypedElement caller, @Nullable Object @NonNull [] sourceAndArgumentValues) {
			@SuppressWarnings("null") final /*@NonInvalid*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation element_0 = (/*@NonInvalid*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation)sourceAndArgumentValues[0];
			final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Argument> args = (List<Argument>)OperationFilter.this.args;
			@SuppressWarnings("null")
			final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Parameter> ownedParameters = element_0.getOwnedParameters();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull CollectionValue BOXED_args_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Argument, args);
			BOXED_args_0.cachedIterable();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull CollectionValue BOXED_ownedParameters = idResolver.createOrderedSetOfAll(ORD_CLSSid_Parameter, ownedParameters);
			BOXED_ownedParameters.cachedIterable();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_args_0);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_0 = CollectionSizeOperation.INSTANCE.evaluate(BOXED_ownedParameters);
			final /*@NonInvalid*/ boolean eq = size.equals(size_0);
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean and;
			if (eq) {
				/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITERATOR_x = BOXED_args_0.lazyIterator();
				/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean forAll;
				while (true) {
					if (!ITERATOR_x.hasNext()) {
						if (accumulator == ValueUtil.TRUE_VALUE) {
							forAll = ValueUtil.TRUE_VALUE;
						}
						else {
							throw (InvalidValueException)accumulator;
						}
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Argument x = (Argument)ITERATOR_x.next();
					/**
					 * _'=' : Boolean[1]
					 */
					/*@Caught*/ @NonNull Object CAUGHT_eq_0;
					try {
						final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = x.getName();
						final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_args_0, x);
						final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Parameter at = (Parameter)OrderedCollectionAtOperation.INSTANCE.evaluate(BOXED_ownedParameters, indexOf);
						if (at == null) {
							throw new InvalidValueException("Null source for \'\'http://cs2as/tests/example2/classes/1.0\'::NamedElement::name\'");
						}
						final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = at.getName();
						final /*@Thrown*/ boolean eq_0 = (name != null) ? name.equals(name_0) : (name_0 == null);
						CAUGHT_eq_0 = eq_0;
					}
					catch (Exception e) {
						CAUGHT_eq_0 = ValueUtil.createInvalidValue(e);
					}
					//
					if (CAUGHT_eq_0 == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
						forAll = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (CAUGHT_eq_0 == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else if (CAUGHT_eq_0 instanceof InvalidValueException) {		// Abnormal exception evaluation result
						accumulator = CAUGHT_eq_0;									// Cache an exception failure
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				and = forAll;
			}
			else {
				and = ValueUtil.FALSE_VALUE;
			}
			return and;
		}

		public Boolean evaluate(final /*@NonInvalid*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation element_0) {
			return (Boolean)evaluationCache.getCachedEvaluationResult(this, caller, new @Nullable Object[]{element_0});
		}
	}

	protected final @NonNull CACHE_OperationFilter__matches INSTANCE_OperationFilter__matches = new CACHE_OperationFilter__matches();
}
