/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package example2.classes.util;

import example2.classes.Class;
import example2.classes.ClassesPackage;
import example2.classes.Package;
import example2.classes.Root;
import example2.classes.util.AbstractExtendingVisitor;
import example2.classes.util.Visitable;
import example2.env.Environment;
import example2.env.EnvironmentPackage;
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

public class AbstractClassesLookupVisitor
	extends AbstractExtendingVisitor<Environment, Environment>
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/env/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_qvtd_cs2as_compiler_tests_lookup = IdManager.getRootPackageId("java://org.eclipse.qvtd.cs2as.compiler.tests.lookup");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AbstractClassesLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvtd_cs2as_compiler_tests_lookup.getClassId("AbstractClassesLookupVisitor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0.getClassId("Environment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Root = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    
    protected @Nullable /*@Thrown*/ Object child;
    protected final @NonNull /*@Thrown*/ Executor executor;
    protected final @NonNull /*@Thrown*/ IdResolver idResolver;
    
    public AbstractClassesLookupVisitor(@NonNull Environment context) {
        super(context);
        this.executor = context.getExecutor();
        this.idResolver = executor.getIdResolver();
    }
    
    /**
     * Return the results of a lookup from the child of element.
     */
    public @Nullable Environment envForChild(@NonNull Object element, @Nullable Object child) {
        this.child = element;
        return ((Visitable)element).accept(this);
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
        throw new UnsupportedOperationException("AbstractClassesLookupVisitor is not supported by \"" + getClass().getName() + "\"");
    }
    
    /**
     * visitClass(element : classes::Class[1]) : env::Environment[?]
     * 
     * this.parentEnv(element)
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitClass(final @NonNull /*@NonInvalid*/ Class element) {
        final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element);
        return parentEnv;
    }
    
    /**
     * visitPackage(element : classes::Package[1]) : env::Environment[?]
     * 
     * 
     * let
     *   inner : env::Environment[?] = context.addElements(element.ownedClasses)
     *   .addElements(element.ownedPackages)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitPackage(final @NonNull /*@NonInvalid*/ Package element_0) {
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Class> ownedClasses = element_0.getOwnedClasses();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Environment addElements = context.addElements((EList<Class>)ownedClasses);
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Package> ownedPackages = element_0.getOwnedPackages();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Environment inner = addElements.addElements((EList<Package>)ownedPackages);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ Environment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_0);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
    
    /**
     * visitRoot(element : classes::Root[1]) : env::Environment[?]
     * 
     * 
     * let
     *   inner : env::Environment[?] = context.addElements(element.ownedPackages)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public @Nullable /*@NonInvalid*/ Environment visitRoot(final @NonNull /*@NonInvalid*/ Root element_1) {
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Package> ownedPackages = element_1.getOwnedPackages();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ Environment inner = context.addElements((EList<Package>)ownedPackages);
        final /*@Thrown*/ boolean hasFinalResult = inner.hasFinalResult();
        @Nullable /*@Thrown*/ Environment symbol_0;
        if (hasFinalResult) {
            symbol_0 = inner;
        }
        else {
            final @Nullable /*@Thrown*/ Environment parentEnv = this.parentEnv(element_1);
            symbol_0 = parentEnv;
        }
        return symbol_0;
    }
}
