/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package example1.target.util;

import example1.env.Environment;
import example1.env.EnvironmentPackage;
import example1.target.A;
import example1.target.A1;
import example1.target.A2;
import example1.target.B;
import example1.target.C;
import example1.target.D;
import example1.target.TRoot;
import example1.target.TargetPackage;
import example1.target.util.AbstractExtendingVisitor;
import example1.target.util.Visitable;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionIndexOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;

public class AbstractTargetLookupVisitor
	extends AbstractExtendingVisitor<Environment, Environment>
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/env/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/targetMM/1.0", null, TargetPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_qvtd_build_cs2as_tests_lookup = IdManager.getRootPackageId("java://org.eclipse.qvtd.build.cs2as.tests.lookup");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_A = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_A1 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A1", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_A2 = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("A2", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AbstractTargetLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvtd_build_cs2as_tests_lookup.getClassId("AbstractTargetLookupVisitor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_B = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("B", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_C = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("C", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_D = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("D", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0.getClassId("Environment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Evaluator = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Evaluator", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_TRoot = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("TRoot", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_A = TypeId.ORDERED_SET.getSpecializedId(CLSSid_A);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_B = TypeId.ORDERED_SET.getSpecializedId(CLSSid_B);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_C = TypeId.ORDERED_SET.getSpecializedId(CLSSid_C);
    
    protected @Nullable /*@Thrown*/ Object child;
    protected final @NonNull /*@Thrown*/ Evaluator evaluator;
    protected final @NonNull /*@Thrown*/ IdResolver idResolver;
    
    public AbstractTargetLookupVisitor(@NonNull Environment context) {
        super(context);
        this.evaluator = context.getEvaluator();
        this.idResolver = evaluator.getIdResolver();
    }
    
    /**
     * Return the results of a lookup from the child of element.
     */
    public @Nullable Environment envForChild(@NonNull Visitable element, @Nullable Visitable child) {
        this.child = element;
        return element.accept(this);
    }
    
    /**
     * Continue the search for matches in the parent of element.
     */
    protected @Nullable Environment parentEnv(@NonNull EObject element) {
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
    public @Nullable Environment visiting(@NonNull Visitable visitable) {
        throw new UnsupportedOperationException("AbstractTargetLookupVisitor is not supported by \"" + getClass().getName() + "\"");
    }
    
    /**
     * visitA1(element : target::A1) : env::Environment[?]
     * 
     * 
     * let ownedBs : OrderedSet(target::B) = element.ownsB
     * in
     *   if child = null
     *   then
     *     let inner : env::Environment = context.addElements(ownedBs)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     let
     *       inner : env::Environment = context.addElements(
     *         ownedBs->select(x |
     *           ownedBs->indexOf(x) <
     *           ownedBs->indexOf(child)))
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitA1(final @NonNull /*@NonInvalid*/ A1 element) {
        final @Nullable /*@Thrown*/ List<B> ownedBs = element.getOwnsB();
        assert ownedBs != null;
        final /*@Thrown*/ boolean eq = child == null;
        @Nullable /*@Thrown*/ Environment symbol_2;
        if (eq) {
            final @NonNull /*@Thrown*/ Environment inner = context.addElements((EList)ownedBs);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element);
                symbol_0 = parentEnv;
            }
            symbol_2 = symbol_0;
        }
        else {
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedBs = idResolver.createOrderedSetOfAll(ORD_CLSSid_B, ownedBs);
            @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_B);
            @Nullable Iterator<?> ITERATOR_x = BOXED_ownedBs.iterator();
            @NonNull /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ B x = (B)ITERATOR_x.next();
                /**
                 * ownedBs->indexOf(x) < ownedBs->indexOf(child)
                 */
                final @NonNull /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedBs, x);
                final @NonNull /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedBs, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(evaluator, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final List<B> UNBOXED_select = select.asEcoreObjects(idResolver, B.class);
            assert UNBOXED_select != null;
            final @NonNull /*@Thrown*/ Environment inner_0 = context.addElements((EList)UNBOXED_select);
            final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
            @Nullable /*@Thrown*/ Environment symbol_1;
            if (hasFinalResult_0) {
                symbol_1 = inner_0;
            }
            else {
                final @Nullable /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element);
                symbol_1 = parentEnv_0;
            }
            symbol_2 = symbol_1;
        }
        return symbol_2;
    }
    
    /**
     * visitA2(element : target::A2) : env::Environment[?]
     * 
     * 
     * let ownedCs : OrderedSet(target::C) = element.ownsC
     * in
     *   if child = null
     *   then
     *     let inner : env::Environment = context.addElements(ownedCs)
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   else
     *     let
     *       inner : env::Environment = context.addElements(
     *         ownedCs->select(x |
     *           ownedCs->indexOf(x) <
     *           ownedCs->indexOf(child)))
     *     in
     *       if inner.hasFinalResult()
     *       then inner
     *       else this.parentEnv(element)
     *       endif
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitA2(final @NonNull /*@NonInvalid*/ A2 element_0) {
        final @Nullable /*@Thrown*/ List<C> ownedCs = element_0.getOwnsC();
        assert ownedCs != null;
        final /*@Thrown*/ boolean eq = child == null;
        @Nullable /*@Thrown*/ Environment symbol_2;
        if (eq) {
            final @NonNull /*@Thrown*/ Environment inner = context.addElements((EList)ownedCs);
            final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
            @Nullable /*@Thrown*/ Environment symbol_0;
            if (hasFinalResult) {
                symbol_0 = inner;
            }
            else {
                final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_0);
                symbol_0 = parentEnv;
            }
            symbol_2 = symbol_0;
        }
        else {
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedCs = idResolver.createOrderedSetOfAll(ORD_CLSSid_C, ownedCs);
            @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_C);
            @Nullable Iterator<?> ITERATOR_x = BOXED_ownedCs.iterator();
            @NonNull /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR_x.hasNext()) {
                    select = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ C x = (C)ITERATOR_x.next();
                /**
                 * ownedCs->indexOf(x) < ownedCs->indexOf(child)
                 */
                final @NonNull /*@Thrown*/ IntegerValue indexOf = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedCs, x);
                final @NonNull /*@Thrown*/ IntegerValue indexOf_0 = OrderedCollectionIndexOfOperation.INSTANCE.evaluate(BOXED_ownedCs, child);
                final /*@Thrown*/ boolean lt = OclComparableLessThanOperation.INSTANCE.evaluate(evaluator, indexOf, indexOf_0).booleanValue();
                //
                if (lt == ValueUtil.TRUE_VALUE) {
                    accumulator.add(x);
                }
            }
            final List<C> UNBOXED_select = select.asEcoreObjects(idResolver, C.class);
            assert UNBOXED_select != null;
            final @NonNull /*@Thrown*/ Environment inner_0 = context.addElements((EList)UNBOXED_select);
            final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
            @Nullable /*@Thrown*/ Environment symbol_1;
            if (hasFinalResult_0) {
                symbol_1 = inner_0;
            }
            else {
                final @Nullable /*@Thrown*/ Environment parentEnv_0 = this.parentEnv(element_0);
                symbol_1 = parentEnv_0;
            }
            symbol_2 = symbol_1;
        }
        return symbol_2;
    }
    
    /**
     * visitB(element : target::B) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitB(final @NonNull /*@NonInvalid*/ B element_1) {
        final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_1);
        return parentEnv;
    }
    
    /**
     * visitC(element : target::C) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitC(final @NonNull /*@NonInvalid*/ C element_2) {
        final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_2);
        return parentEnv;
    }
    
    /**
     * visitD(element : target::D) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitD(final @NonNull /*@NonInvalid*/ D element_3) {
        final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_3);
        return parentEnv;
    }
    
    /**
     * visitTRoot(element : target::TRoot) : env::Environment[?]
     * 
     * 
     * let inner : env::Environment = context.addElements(ownedA)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitTRoot(final @NonNull /*@NonInvalid*/ TRoot element_4) {
        final @Nullable /*@Thrown*/ List<A> ownedA = element_4.getOwnedA();
        assert ownedA != null;
        final @NonNull /*@Thrown*/ Environment inner = context.addElements((EList)ownedA);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ Environment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_4);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
}
