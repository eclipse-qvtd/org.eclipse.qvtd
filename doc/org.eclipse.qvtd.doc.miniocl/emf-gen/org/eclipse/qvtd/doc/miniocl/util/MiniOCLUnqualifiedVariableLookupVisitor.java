/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.autogen.lookup.LookupUnqualifiedCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.doc.miniocl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.Parameter;
import org.eclipse.qvtd.doc.miniocl.lookup.EnvironmentPackage;
import org.eclipse.qvtd.doc.miniocl.lookup.LookupEnvironment;

public class MiniOCLUnqualifiedVariableLookupVisitor
	extends AbstractMiniOCLCommonLookupVisitor
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/1.0", null, MiniOCLPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0 = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/doc/MiniOCL/Lookup/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_java_c_s_s_org_eclipse_qvtd_doc_miniocl_util = IdManager.getRootPackageId("java://org.eclipse.qvtd.doc.miniocl.util");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ExpressionInOCL = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("ExpressionInOCL", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_Lookup_s_1_0.getClassId("LookupEnvironment", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_MiniOCLUnqualifiedVariableLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvtd_doc_miniocl_util.getClassId("MiniOCLUnqualifiedVariableLookupVisitor", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Operation", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Parameter = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Parameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Variable = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_doc_s_MiniOCL_s_1_0.getClassId("Variable", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Parameter = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Parameter);
    
    protected final /*@Thrown*/ org.eclipse.ocl.pivot.evaluation.@org.eclipse.jdt.annotation.NonNull Executor executor;
    protected final /*@Thrown*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver;
    protected /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object child;
    
    public MiniOCLUnqualifiedVariableLookupVisitor(@NonNull LookupEnvironment context) {
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
     * visitOperation(element : miniocl::Operation[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[1]
     */
    @Override
    public /*@NonInvalid*/ LookupEnvironment visitOperation(final /*@NonInvalid*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Operation element) {
        @SuppressWarnings("null")
        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull ExpressionInOCL ownedBodyExpression = element.getOwnedBodyExpression();
        @SuppressWarnings("null")
        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.@org.eclipse.jdt.annotation.NonNull Variable ownedSelfVar = ownedBodyExpression.getOwnedSelfVar();
        @SuppressWarnings("null")
        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment addElement = context.addElement(ownedSelfVar);
        @SuppressWarnings("null")
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Parameter> ownedParameters = element.getOwnedParameters();
        @SuppressWarnings("null")
        final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.NonNull LookupEnvironment inner = addElement.addElements(ownedParameters);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final /*@Thrown*/ org.eclipse.qvtd.doc.miniocl.lookup.@org.eclipse.jdt.annotation.Nullable LookupEnvironment parentEnv = this.parentEnv(element);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
}
