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
import example1.target.B;
import example1.target.C;
import example1.target.TargetPackage;
import example1.target.lookup.EnvironmentPackage;
import example1.target.lookup.LookupEnvironment;
import example1.target.util.AbstractTargetCommonLookupVisitor;
import example1.target.util.Visitable;
import example1.target.util.Visitor;
import java.util.Iterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;

public class TargetUnqualifiedLookupVisitor
	extends AbstractTargetCommonLookupVisitor
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/env/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/targetMM/1.0", null, TargetPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_java_c_s_s_example1_target_util = IdManager.getRootPackageId("java://example1.target.util");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_A = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_A1 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A1", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_A2 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A2", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_B = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("B", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_C = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("C", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_D = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("D", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0.getClassId("LookupEnvironment", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("TRoot", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TargetUnqualifiedLookupVisitor = PACKid_java_c_s_s_example1_target_util.getClassId("TargetUnqualifiedLookupVisitor", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_A = TypeId.ORDERED_SET.getSpecializedId(CLSSid_A);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_B = TypeId.ORDERED_SET.getSpecializedId(CLSSid_B);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_C = TypeId.ORDERED_SET.getSpecializedId(CLSSid_C);
    
    protected final /*@Thrown*/ org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor executor;
    protected final /*@Thrown*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver;
    protected /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child;
    
    public TargetUnqualifiedLookupVisitor(@NonNull LookupEnvironment context) {
        super(context);
        this.executor = context.getExecutor();
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
            this.child = element;
            return ((Visitable)parent).accept(this);
        }
        else {
            return context;
        }
    }
    
    /**
     * visitA1(element : target::A1[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[1]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitA1(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull A1 element) {
        @SuppressWarnings("null")
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<B> ownsB = element.getOwnsB();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownsB = idResolver.createOrderedSetOfAll(ORD_CLSSid_B, ownsB);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownsB, child).booleanValue();
        /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_1;
        if (includes) {
            /*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_B);
            @Nullable Iterator<?> ITERATOR_x = BOXED_ownsB.iterator();
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.Nullable B x = (B)ITERATOR_x.next();
                /**
                 * _'<' : Boolean[1]
                 */
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsB, x);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsB, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<B> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(B.class, select);
            @SuppressWarnings("null")
            final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = context.addElements(ECORE_select);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = this.parentEnv(element);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitA2(element : target::A2[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[1]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitA2(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull A2 element_0) {
        @SuppressWarnings("null")
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<C> ownsC = element_0.getOwnsC();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownsC = idResolver.createOrderedSetOfAll(ORD_CLSSid_C, ownsC);
        final /*@Thrown*/ boolean includes = CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownsC, child).booleanValue();
        /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_1;
        if (includes) {
            /*@Thrown*/ OrderedSetValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_C);
            @Nullable Iterator<?> ITERATOR_x = BOXED_ownsC.iterator();
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.Nullable C x = (C)ITERATOR_x.next();
                /**
                 * _'<' : Boolean[1]
                 */
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsC, x);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsC, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<C> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(C.class, select);
            @SuppressWarnings("null")
            final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = context.addElements(ECORE_select);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_0);
                symbol_0 = parentEnv;
            }
            symbol_1 = symbol_0;
        }
        else {
            final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv_0 = this.parentEnv(element_0);
            symbol_1 = parentEnv_0;
        }
        return symbol_1;
    }
    
    /**
     * visitB(element : target::B[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[1]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitB(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull B element_1) {
        final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_1);
        return parentEnv;
    }
    
    /**
     * visitC(element : target::C[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[1]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitC(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull C element_2) {
        final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_2);
        return parentEnv;
    }
    
    /**
     * visitD(element : target::D[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[1]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitD(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull D element_3) {
        final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_3);
        return parentEnv;
    }
    
    /**
     * visitTRoot(element : target::TRoot[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[1]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitTRoot(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull TRoot element_4) {
        final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_4);
        if (parentEnv == null) {
            throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::addElements(NE)(Collection(addElements.NE)) : lookup::LookupEnvironment[1]\'");
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<A> ownedA = element_4.getOwnedA();
        @SuppressWarnings("null")
        final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = parentEnv.addElements(ownedA);
        return addElements;
    }
}
