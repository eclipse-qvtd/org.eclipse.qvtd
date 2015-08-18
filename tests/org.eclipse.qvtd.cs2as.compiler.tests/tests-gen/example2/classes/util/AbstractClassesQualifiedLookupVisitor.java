/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package example2.classes.util;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;

import example2.classes.Class;
import example2.classes.ClassesPackage;
import example2.classes.Operation;
import example2.classes.Package;
import example2.classes.Property;
import example2.classes.lookup.EnvironmentPackage;
import example2.classes.lookup.LookupEnvironment;

public class AbstractClassesQualifiedLookupVisitor
	extends AbstractClassesCommonLookupVisitor
	implements Visitor<LookupEnvironment>
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/env/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_qvtd_cs2as_compiler_tests_lookup = IdManager.getRootPackageId("java://org.eclipse.qvtd.cs2as.compiler.tests.lookup");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_AbstractClassesUnqualifiedLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvtd_cs2as_compiler_tests_lookup.getClassId("AbstractClassesUnqualifiedLookupVisitor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Executor = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Executor", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0.getClassId("LookupEnvironment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Operation = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Operation", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Property = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Property", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Root = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Operation = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Operation);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Property = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Property);
    
    public AbstractClassesQualifiedLookupVisitor(@NonNull LookupEnvironment context) {
        super(context);
    }
    
    /**
     * visitClass(element : classes::Class[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[?]
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitClass(final @NonNull /*@NonInvalid*/ Class element_4) {
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Operation> ownedOperations = element_4.getOwnedOperations();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements((EList<Operation>)ownedOperations);
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Property> ownedProperties = element_4.getOwnedProperties();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements((EList<Property>)ownedProperties);
        return addElements_0;
    }
    
    /**
     * visitPackage(element : classes::Package[1]) : lookup::LookupEnvironment[?]
     * 
     * _'null' : lookup::LookupEnvironment[?]
     */
    @Override
    public @Nullable /*@NonInvalid*/ LookupEnvironment visitPackage(final @NonNull /*@NonInvalid*/ Package element_5) {
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Package> ownedPackages = element_5.getOwnedPackages();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements = context.addElements((EList<Package>)ownedPackages);
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ List<Class> ownedClasses = element_5.getOwnedClasses();
        @SuppressWarnings("null")
        final @NonNull /*@Thrown*/ LookupEnvironment addElements_0 = addElements.addElements((EList<Class>)ownedClasses);
        return addElements_0;
    }
}
