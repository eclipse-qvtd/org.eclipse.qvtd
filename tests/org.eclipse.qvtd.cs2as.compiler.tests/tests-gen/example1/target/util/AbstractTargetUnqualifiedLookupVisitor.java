/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package example1.target.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludesOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;

import example1.target.A;
import example1.target.B;
import example1.target.C;
import example1.target.TargetPackage;
import example1.target.lookup.EnvironmentPackage;
import example1.target.lookup.LookupEnvironment;

public class AbstractTargetUnqualifiedLookupVisitor
	extends AbstractTargetCommonLookupVisitor
	implements Visitor<LookupEnvironment>
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/env/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/targetMM/1.0", null, TargetPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_java_c_s_s_org_eclipse_qvtd_cs2as_compiler_tests_lookup = IdManager.getRootPackageId("java://org.eclipse.qvtd.cs2as.compiler.tests.lookup");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_A = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_A1 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A1", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_A2 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A2", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_AbstractTargetUnqualifiedLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvtd_cs2as_compiler_tests_lookup.getClassId("AbstractTargetUnqualifiedLookupVisitor", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_B = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("B", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_C = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("C", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_D = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("D", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0.getClassId("LookupEnvironment", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_TRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("TRoot", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_A = TypeId.ORDERED_SET.getSpecializedId(CLSSid_A);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_B = TypeId.ORDERED_SET.getSpecializedId(CLSSid_B);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_C = TypeId.ORDERED_SET.getSpecializedId(CLSSid_C);
    
    protected /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child;
    
    public AbstractTargetUnqualifiedLookupVisitor(@NonNull LookupEnvironment context) {
        super(context);
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
        return parentEnv((EObject)visitable);
    }
    
    /**
     * visitA1(element : target::A1[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[?]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitA1(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull A1 element) {
        @SuppressWarnings("null")
        final /*@Thrown*/ List<B> ownsB = element.getOwnsB();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownsB = idResolver.createOrderedSetOfAll(ORD_CLSSid_B, ownsB);
        final /*@Thrown*/ boolean includes = ClassUtil.nonNullState(CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownsB, child).booleanValue());
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
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue indexOf = ClassUtil.nonNullState(OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsB, x));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue indexOf_0 = ClassUtil.nonNullState(OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsB, child));
                final /*@Thrown*/ boolean lt = ClassUtil.nonNullState(OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue());
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@Thrown*/ List<B> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(B.class, select);
            @SuppressWarnings("null")
            final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = context.addElements((EList<B>)ECORE_select);
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
     * _'null' : lookup::LookupEnvironment[?]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitA2(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull A2 element_0) {
        @SuppressWarnings("null")
        final /*@Thrown*/ List<C> ownsC = element_0.getOwnsC();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownsC = idResolver.createOrderedSetOfAll(ORD_CLSSid_C, ownsC);
        final /*@Thrown*/ boolean includes = ClassUtil.nonNullState(CollectionIncludesOperation.INSTANCE.evaluate(BOXED_ownsC, child).booleanValue());
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
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue indexOf = ClassUtil.nonNullState(OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsC, x));
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue indexOf_0 = ClassUtil.nonNullState(OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownsC, child));
                final /*@Thrown*/ boolean lt = ClassUtil.nonNullState(OclComparableLessThanOperation.INSTANCE.evaluate(executor, indexOf, indexOf_0).booleanValue());
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final /*@Thrown*/ List<C> ECORE_select = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(C.class, select);
            @SuppressWarnings("null")
            final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = context.addElements((EList<C>)ECORE_select);
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
     * _'null' : lookup::LookupEnvironment[?]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitTRoot(final /*@NonInvalid*/ example1.target.@org.eclipse.jdt.annotation.NonNull TRoot element_4) {
        final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element_4);
        if (parentEnv == null) {
            throw new InvalidValueException("Null source for \'lookup::LookupEnvironment::addElements(NE)(OrderedSet(addElements.NE)) : lookup::LookupEnvironment[?]\'");
        }
        @SuppressWarnings("null")
        final /*@Thrown*/ List<A> ownedA = element_4.getOwnedA();
        @SuppressWarnings("null")
        final /*@Thrown*/ example1.target.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElements = parentEnv.addElements((EList<A>)ownedA);
        return addElements;
    }
}
