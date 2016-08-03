/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.autogen.lookup.LookupUnqualifiedCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.doc.miniocl.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorSingleIterationManager;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.library.LibraryIteration;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.BagValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.Operation;
import org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentPackage;
import org.eclipse.qvtd.doc.miniocl.lookup.LookupEnvironment;

public class MiniOCLUnqualifiedOperationLookupVisitor
	extends AbstractMiniOCLCommonLookupVisitor
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/1.0", null, MiniOCLPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_java_c_s_s_org_eclipse_qvtd_doc_miniocl_util = IdManager.getRootPackageId("java://org.eclipse.qvtd.doc.miniocl.util");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0.getClassId("LookupEnvironment", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_MiniOCLUnqualifiedOperationLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvtd_doc_miniocl_util.getClassId("MiniOCLUnqualifiedOperationLookupVisitor", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Operation", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId BAG_CLSSid_Operation = TypeId.BAG.getSpecializedId(CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Class = TypeId.SET.getSpecializedId(CLSSid_Class);
    
    protected final /*@Thrown*/ org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor executor;
    protected final /*@Thrown*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver;
    protected /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child;
    
    public MiniOCLUnqualifiedOperationLookupVisitor(@NonNull LookupEnvironment context) {
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
            this.child = element;
            return ((Visitable)parent).accept(this);
        }
        else {
            return context;
        }
    }
    
    /**
     * visitClass(element : miniocl::Class[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[1]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitClass(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Class element) {
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull StandardLibrary standardLibrary = idResolver.getStandardLibrary();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Class, element);
        final org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYPE_superClasses_0 = executor.getStaticTypeOf(oclAsSet);
        final LibraryIteration.@org.eclipse.jdt.annotation.NonNull LibraryIterationExtension IMPL_superClasses_0 = (LibraryIteration.LibraryIterationExtension)TYPE_superClasses_0.lookupImplementation(standardLibrary, OCLstdlibTables.Operations._Set__closure);
        final @NonNull Object ACC_superClasses_0 = IMPL_superClasses_0.createAccumulatorValue(executor, SET_CLSSid_Class, CLSSid_Class);
        /**
         * Implementation of the iterator body.
         */
        final @NonNull AbstractBinaryOperation BODY_superClasses_0 = new AbstractBinaryOperation()
        {
            /**
             * _'null' : miniocl::Class[?]
             */
            @Override
            public @Nullable Object evaluate(final @NonNull Executor executor, final @NonNull TypeId typeId, final @Nullable Object oclAsSet, final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object _1) {
                final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class symbol_0 = (org.eclipse.qvtd.doc.miniocl.Class)_1;
                if (symbol_0 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::Class::superClass\'");
                }
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class superClass = symbol_0.getSuperClass();
                return superClass;
            }
        };
        final @NonNull  ExecutorSingleIterationManager MGR_superClasses_0 = new ExecutorSingleIterationManager(executor, SET_CLSSid_Class, BODY_superClasses_0, oclAsSet, ACC_superClasses_0);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue superClasses = ClassUtil.nonNullState((SetValue)IMPL_superClasses_0.evaluateIteration(MGR_superClasses_0));
        @SuppressWarnings("null")
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ownedOperations = element.getOwnedOperations();
        @SuppressWarnings("null")
        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = context.addElements(ownedOperations);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_2;
        if (hasFinalResult) {
            symbol_2 = inner;
        }
        else {
            /*@Thrown*/ BagValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createBagAccumulatorValue(BAG_CLSSid_Operation);
            @Nullable Iterator<Object> ITERATOR__1_0 = superClasses.iterator();
            /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull BagValue collect;
            while (true) {
                if (!ITERATOR__1_0.hasNext()) {
                    collect = accumulator;
                    break;
                }
                /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.Nullable Class _1_0 = (org.eclipse.qvtd.doc.miniocl.Class)ITERATOR__1_0.next();
                /**
                 * _'null' : OrderedSet(miniocl::Operation)[*|1]
                 */
                if (_1_0 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/doc/MiniOCL/1.0\'::Class::ownedOperations\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ownedOperations_0 = _1_0.getOwnedOperations();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedOperations_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_Operation, ownedOperations_0);
                //
                for (Object value : BOXED_ownedOperations_0.flatten().getElements()) {
                    accumulator.add(value);
                }
            }
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, collect);
            @SuppressWarnings("null")
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner_0 = context.addElements(ECORE_collect);
            final /*@Thrown*/ boolean hasFinalResult_0 = inner_0.hasFinalResult();
            /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_1;
            if (hasFinalResult_0) {
                symbol_1 = inner_0;
            }
            else {
                final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element);
                symbol_1 = parentEnv;
            }
            symbol_2 = symbol_1;
        }
        return symbol_2;
    }
}
