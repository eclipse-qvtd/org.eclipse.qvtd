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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSequenceOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;

import example2.classes.ClassesPackage;
import example2.classes.NamedElement;
import example2.classes.Package;
import example2.classes.Root;
import example2.env.Environment;
import example2.env.EnvironmentPackage;

public class AutoClassesLookupVisitor
	extends AbstractExtendingVisitor<Environment, Environment>
{
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/env/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_java_c_s_s_org_eclipse_qvtd_build_cs2as_tests_lookup = IdManager.getRootPackageId("java://org.eclipse.qvtd.build.cs2as.tests.lookup");
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_evaluation = IdManager.getRootPackageId("org.eclipse.ocl.pivot.evaluation");
    public static final /*@NonNull*/ /*@NonInvalid*/ RootPackageId PACKid_org_eclipse_ocl_pivot_ids = IdManager.getRootPackageId("org.eclipse.ocl.pivot.ids");
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_AutoClassesLookupVisitor = PACKid_java_c_s_s_org_eclipse_qvtd_build_cs2as_tests_lookup.getClassId("AutoClassesLookupVisitor", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0.getClassId("Environment", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Evaluator = PACKid_org_eclipse_ocl_pivot_evaluation.getClassId("Evaluator", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_IdResolver = PACKid_org_eclipse_ocl_pivot_ids.getClassId("IdResolver", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_NamedElement = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("NamedElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ ClassId CLSSid_Root = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId COL_CLSSid_NamedElement = TypeId.COLLECTION.getSpecializedId(CLSSid_NamedElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_NamedElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NamedElement);
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    public static final /*@NonNull*/ /*@NonInvalid*/ PropertyId PROPid_namedElements = CLSSid_Environment.getPropertyId("namedElements");
    public static final /*@NonNull*/ /*@NonInvalid*/ PropertyId PROPid_parentEnv = CLSSid_Environment.getPropertyId("parentEnv");
    public static final /*@NonNull*/ /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_NamedElement = TypeId.SEQUENCE.getSpecializedId(CLSSid_NamedElement);
    
    protected /*@Nullable*/ /*@Thrown*/ Object child;
    protected final /*@NonNull*/ /*@Thrown*/ Evaluator evaluator;
    protected final /*@NonNull*/ /*@Thrown*/ IdResolver idResolver;
    
    public AutoClassesLookupVisitor(/*@NonNull*/ Environment context) {
        super(context);
        this.evaluator = context.getEvaluator();
        this.idResolver = evaluator.getIdResolver();
    }
    
    /**
     * Return the results of a lookup from the child of element.
     */
    public /*@Nullable*/ Environment envForChild(/*@NonNull*/ Visitable element, /*@Nullable*/ Visitable child) {
        this.child = element;
        return element.accept(this);
    }
    
    /**
     * Continue the search for matches in the parent of element.
     */
    protected /*@Nullable*/ Environment parentEnv(/*@NonNull*/ EObject element) {
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
    public /*@Nullable*/ Environment visiting(/*@NonNull*/ Visitable visitable) {
        throw new UnsupportedOperationException("AutoClassesLookupVisitor is not supported by \"" + getClass().getName() + "\"");
    }
    
    /**
     * visitPackage(element : classes::Package) : env::Environment[?]
     * 
     * 
     * let
     *   inner : env::Environment = context.addElements(element.ownedClasses)
     *   .addElements(element.ownedPackages)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitPackage(final /*@NonNull*/ /*@NonInvalid*/ Package element) {
        final /*@Nullable*/ /*@Thrown*/ List<example2.classes.Class> elements = element.getOwnedClasses();
        assert elements != null;
        final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
        final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(PROPid_namedElements);
        final /*@NonNull*/ /*@Thrown*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
        final /*@Nullable*/ /*@Thrown*/ List<NamedElement> namedElements = context.getNamedElements();
        assert namedElements != null;
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
        final /*@NonNull*/ /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements);
        final /*@NonNull*/ /*@Thrown*/ CollectionValue BOXED_elements = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements);
        final /*@NonNull*/ /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence, BOXED_elements);
        final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, NamedElement.class);
        assert UNBOXED_includingAll != null;
        CTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = context.getParentEnv();
        CTORid_parentEnv.initValue(symbol_0, parentEnv);
        final /*@Nullable*/ /*@Thrown*/ List<Package> elements_0 = element.getOwnedPackages();
        assert elements_0 != null;
        final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_parentEnv_0 = idResolver.getProperty(PROPid_parentEnv);
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_1 = idResolver.getClass(CLSSid_Environment, null);
        final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_namedElements_0 = idResolver.getProperty(PROPid_namedElements);
        final /*@NonNull*/ /*@Thrown*/ Environment symbol_1 = (Environment)TYP_env_c_c_Environment_1.createInstance();
        final /*@Nullable*/ /*@Thrown*/ List<NamedElement> namedElements_1 = symbol_0.getNamedElements();
        assert namedElements_1 != null;
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_namedElements_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_1);
        final /*@NonNull*/ /*@Thrown*/ SequenceValue asSequence_0 = CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements_1);
        final /*@NonNull*/ /*@Thrown*/ CollectionValue BOXED_elements_0 = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements_0);
        final /*@NonNull*/ /*@Thrown*/ CollectionValue includingAll_0 = CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence_0, BOXED_elements_0);
        final List<NamedElement> UNBOXED_includingAll_0 = includingAll_0.asEcoreObjects(idResolver, NamedElement.class);
        assert UNBOXED_includingAll_0 != null;
        CTORid_namedElements_0.initValue(symbol_1, UNBOXED_includingAll_0);
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_1 = symbol_0.getParentEnv();
        CTORid_parentEnv_0.initValue(symbol_1, parentEnv_1);
        final /*@Thrown*/ boolean hasFinalResult = symbol_1.hasFinalResult();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_2;
        if (hasFinalResult) {
            symbol_2 = symbol_1;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_3 = this.parentEnv(element);
            symbol_2 = parentEnv_3;
        }
        return symbol_2;
    }
    
    /**
     * visitRoot(element : classes::Root) : env::Environment[?]
     * 
     * 
     * let
     *   inner : env::Environment = context.addElements(element.ownedPackages)
     * in
     *   if inner.hasFinalResult()
     *   then inner
     *   else this.parentEnv(element)
     *   endif
     */
    @Override
    public /*@Nullable*/ /*@NonInvalid*/ Environment visitRoot(final /*@NonNull*/ /*@NonInvalid*/ Root element_0) {
        final /*@Nullable*/ /*@Thrown*/ List<Package> elements = element_0.getOwnedPackages();
        assert elements != null;
        final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
        final /*@NonNull*/ /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
        final /*@NonNull*/ /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(PROPid_namedElements);
        final /*@NonNull*/ /*@Thrown*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
        final /*@Nullable*/ /*@Thrown*/ List<NamedElement> namedElements = context.getNamedElements();
        assert namedElements != null;
        final /*@NonNull*/ /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
        final /*@NonNull*/ /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements);
        final /*@NonNull*/ /*@Thrown*/ CollectionValue BOXED_elements = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements);
        final /*@NonNull*/ /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence, BOXED_elements);
        final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, NamedElement.class);
        assert UNBOXED_includingAll != null;
        CTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);
        final /*@Nullable*/ /*@Thrown*/ Environment parentEnv = context.getParentEnv();
        CTORid_parentEnv.initValue(symbol_0, parentEnv);
        final /*@Thrown*/ boolean hasFinalResult = symbol_0.hasFinalResult();
        /*@Nullable*/ /*@Thrown*/ Environment symbol_1;
        if (hasFinalResult) {
            symbol_1 = symbol_0;
        }
        else {
            final /*@Nullable*/ /*@Thrown*/ Environment parentEnv_1 = this.parentEnv(element_0);
            symbol_1 = parentEnv_1;
        }
        return symbol_1;
    }
}
