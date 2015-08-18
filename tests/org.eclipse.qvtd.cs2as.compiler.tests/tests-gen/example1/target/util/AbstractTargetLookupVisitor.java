/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package example1.target.util;

import example1.target.A;
import example1.target.A1;
import example1.target.A2;
import example1.target.B;
import example1.target.C;
import example1.target.D;
import example1.target.TRoot;
import example1.target.TargetPackage;
import example1.target.lookup.EnvironmentPackage;
import example1.target.lookup.LookupEnvironment;
import example1.target.util.AbstractExtendingVisitor;
import example1.target.util.Visitable;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;

public class AbstractTargetLookupVisitor
	extends AbstractExtendingVisitor<LookupEnvironment, LookupEnvironment>
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/env/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/targetMM/1.0", null, TargetPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_qvtd_cs2as_compiler_tests_lookup = IdManager.getRootPackageId("java://org.eclipse.qvtd.cs2as.compiler.tests.lookup");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_A = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_A1 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A1", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_A2 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A2", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AbstractTargetLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvtd_cs2as_compiler_tests_lookup.getClassId("AbstractTargetLookupVisitor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_B = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("B", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_C = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("C", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_D = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("D", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0.getClassId("LookupEnvironment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("TRoot", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_A = TypeId.ORDERED_SET.getSpecializedId(CLSSid_A);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_B = TypeId.ORDERED_SET.getSpecializedId(CLSSid_B);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_C = TypeId.ORDERED_SET.getSpecializedId(CLSSid_C);
    
    protected @Nullable /*@Thrown*/ Object child;
    protected final @NonNull /*@Thrown*/ Executor executor;
    protected final @NonNull /*@Thrown*/ IdResolver idResolver;
    
    public AbstractTargetLookupVisitor(@NonNull LookupEnvironment context) {
        super(context);
        this.executor = context.getExecutor();
        this.idResolver = executor.getIdResolver();
    }
    
    /**
     * Return the results of a lookup from the child of element.
     */
    public @Nullable LookupEnvironment envForChild(@NonNull Object element, @Nullable Object child) {
        this.child = element;
        return ((Visitable)element).accept(this);
    }
    
    /**
     * Continue the search for matches in the parent of element.
     */
    protected @Nullable LookupEnvironment parentEnv(@NonNull EObject element) {
        EObject parent = element.eContainer();
        if (parent instanceof Visitable) {
            this.child = element;
            return ((Visitable)parent).accept(this);
        }
        else {
            return context;
        }
    }
    
    @Override
    public @Nullable LookupEnvironment visiting(@NonNull Visitable visitable) {
        throw new UnsupportedOperationException("AbstractTargetLookupVisitor is not supported by \"" + getClass().getName() + "\"");
    }
    
    /**
     * visitA1(element : target::A1[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if ownsB->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[?] = context.addElements(
     *       ownsB->select(x |
     *         element.ownsB->indexOf(x) <
     *         element.ownsB->indexOf(child)))
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitA1(final @NonNull /*@NonInvalid*/ A1 element) {
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<B> ownsB = element.getOwnsB();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownsB = idResolver.createOrderedSetOfAll(ORD_CLSSid_B, ownsB);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownsB, child).booleanValue();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
        if (includes) {
            @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_B);
            @Nullable Iterator<?> ITERATOR_x = BOXED_ownsB.iterator();
            @NonNull /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ B x = (B)ITERATOR_x.next();
                /**
                 * element.ownsB->indexOf(x) < element.ownsB->indexOf(child)
                 */
                final @NonNull /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsB, x);
                final @NonNull /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsB, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final @NonNull /*@Thrown*/ List<B> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(B.class, select);
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElements((EList<B>)ECORE_select);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitA2(element : target::A2[1]) : lookup::LookupEnvironment[?]
     * 
     * 
     * if ownsC->includes(child)
     * then
     *   let
     *     inner : lookup::LookupEnvironment[?] = context.addElements(
     *       ownsC->select(x |
     *         element.ownsC->indexOf(x) <
     *         element.ownsC->indexOf(child)))
     *   in
     *     if inner.hasFinalResult()
     *     then inner
     *     else this.parentEnv(element)
     *     endif
     * else this.parentEnv(element)
     * endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitA2(final @NonNull /*@NonInvalid*/ A2 element_0) {
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<C> ownsC = element_0.getOwnsC();
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownsC = idResolver.createOrderedSetOfAll(ORD_CLSSid_C, ownsC);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownsC, child).booleanValue();
        @Nullable /*@Thrown*/ LookupEnvironment symbol_1;
        if (includes) {
            @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_C);
            @Nullable Iterator<?> ITERATOR_x = BOXED_ownsC.iterator();
            @NonNull /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ C x = (C)ITERATOR_x.next();
                /**
                 * element.ownsC->indexOf(x) < element.ownsC->indexOf(child)
                 */
                final @NonNull /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsC, x);
                final @NonNull /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsC, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final @NonNull /*@Thrown*/ List<C> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(C.class, select);
            @SuppressWarnings("null")
            final @NonNull /*@Thrown*/ LookupEnvironment inner = context.addElements((EList<C>)ECORE_select);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_0);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final @Nullable /*@Thrown*/ LookupEnvironment parentEnv_0 = this.parentEnv(element_0);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitB(element : target::B[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitB(final @NonNull /*@NonInvalid*/ B element_1) {
        final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_1);
        return parentEnv;
    }
    
    /**
     * visitC(element : target::C[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitC(final @NonNull /*@NonInvalid*/ C element_2) {
        final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_2);
        return parentEnv;
    }
    
    /**
     * visitD(element : target::D[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitD(final @NonNull /*@NonInvalid*/ D element_3) {
        final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_3);
        return parentEnv;
    }
    
    /**
     * visitTRoot(element : target::TRoot[1]) : lookup::LookupEnvironment[?]
     * 
     * this.parentEnv(element).addElements(ownedA)
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitTRoot(final @NonNull /*@NonInvalid*/ TRoot element_4) {
        final @Nullable /*@Thrown*/ LookupEnvironment parentEnv = this.parentEnv(element_4);
        if (parentEnv == null) {
            throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::addElements(NE)(OrderedSet(addElements.NE)) : lookup::LookupEnvironment[?]\'");
        }
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<A> ownedA = element_4.getOwnedA();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = parentEnv.addElements((EList<A>)ownedA);
        return addElements;
    }
}
