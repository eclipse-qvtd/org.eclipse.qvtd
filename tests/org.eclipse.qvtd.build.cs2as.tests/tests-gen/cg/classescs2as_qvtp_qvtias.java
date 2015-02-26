/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
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
import org.eclipse.ocl.pivot.internal.library.UnboxedExplicitNavigationProperty;
import org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation;
import org.eclipse.ocl.pivot.library.classifier.ClassifierOclContainerOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsOrderedSetOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionAsSequenceOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionIsEmptyOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;

import classes.ClassesFactory;
import classes.ClassesPackage;
import classes.NamedElement;
import classes.Package;
import classes.Root;
import classescs.ClassCS;
import classescs.ClassescsPackage;
import classescs.PackageCS;
import classescs.PathElementCS;
import classescs.PathNameCS;
import classescs.RootCS;
import env.Environment;
import env.EnvironmentPackage;

/**
 * The classescs2as_qvtp_qvtias transformation:
 * <p>
 * Construct with an evaluator
 * <br>
 * Populate each input model with {@link addRootObjects(String,List)}
 * <br>
 * {@link run()}
 * <br>
 * Extract each output model with {@link getRootObjects(String)}
 */
@SuppressWarnings("nls")
public class classescs2as_qvtp_qvtias extends AbstractTransformationExecutor
{
    public static final @NonNull /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/env/1.0", null, EnvironmentPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ClassCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("ClassCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_env_s_1_0.getClassId("Environment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_NamedElement = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("NamedElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PackageCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PathElementCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathElementCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PathNameCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathNameCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Root = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_RootCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("RootCS", 0);
    public static final @NonNull /*@NonInvalid*/ IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId COL_CLSSid_NamedElement = TypeId.COLLECTION.getSpecializedId(CLSSid_NamedElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Class = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_NamedElement = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NamedElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Package = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS);
    public static final @NonNull /*@NonInvalid*/ PropertyId PROPid_namedElements = CLSSid_Environment.getPropertyId("namedElements");
    public static final @NonNull /*@NonInvalid*/ PropertyId PROPid_parentEnv = CLSSid_Environment.getPropertyId("parentEnv");
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_NamedElement = TypeId.SEQUENCE.getSpecializedId(CLSSid_NamedElement);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_ClassCS = TypeId.SET.getSpecializedId(CLSSid_ClassCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS);
    public static final @NonNull /*@NonInvalid*/ CollectionTypeId SET_CLSSid_RootCS = TypeId.SET.getSpecializedId(CLSSid_RootCS);
    
    
    /*
     * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
     */
    private static final @NonNull ClassId[] classIndex2classId = new ClassId[]{
        CLSSid_ClassCS,		// 0 => ClassCS
        CLSSid_PackageCS,		// 1 => PackageCS
        CLSSid_RootCS		// 2 => RootCS
    };
    /*
     * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
     * may contribute results to an allInstances() invocation.
     * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
     * instance of the derived classId contributes to derived and inherited ClassIndexes.
     */
    private final static @NonNull int[][] classIndex2allClassIndexes = new int[][] {
        {0},		// 0 : ClassCS -> {ClassCS}
        {1},		// 1 : PackageCS -> {PackageCS}
        {2}		// 2 : RootCS -> {RootCS}
    };
    
    public classescs2as_qvtp_qvtias(final @NonNull Evaluator evaluator) {
        super(evaluator, new String[] {"leftCS", "rightAS"}, null, classIndex2classId, classIndex2allClassIndexes);
    }
    
    public boolean run() {
        return __root__();
    }
    
    /**
     * classes::Package::parentEnv() : env::Environment
     * 
     * 
     * let parent : OclElement = oclContainer()
     * in
     *   if parent.oclIsKindOf(Package)
     *   then parent.oclAsType(Package)._env(self)
     *   else parent.oclAsType(Root)._env(self)
     *   endif
     */
    public @NonNull /*@NonInvalid*/ Environment parentEnv(final @NonNull /*@NonInvalid*/ Package self_2) {
        final @Nullable /*@Thrown*/ Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_2);
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, parent, TYP_classes_c_c_Package_0).booleanValue();
        @NonNull /*@Thrown*/ Environment symbol_3;
        if (oclIsKindOf) {
            final @Nullable /*@Thrown*/ Package oclAsType = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent, TYP_classes_c_c_Package_0);
            if (oclAsType == null) {
                throw new InvalidValueException("Null source for \'classes::Package::_env(OclElement) : env::Environment\'");
            }
            final @NonNull /*@Thrown*/ Environment _env = this._env(oclAsType, self_2);
            symbol_3 = _env;
        }
        else {
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
            final @Nullable /*@Thrown*/ Root self_7 = (Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent, TYP_classes_c_c_Root_0);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
            final @NonNull /*@NonInvalid*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_1 = idResolver.getClass(CLSSid_Environment, null);
            final @NonNull /*@Thrown*/ Environment symbol_1 = (Environment)TYP_env_c_c_Environment_1.createInstance();
            CTORid_parentEnv.initValue(symbol_1, symbol_0);
            if (self_7 == null) {
                throw new InvalidValueException("Null source for \'classes::Root::ownedPackages\'");
            }
            final @Nullable /*@Thrown*/ List<Package> elements = self_7.getOwnedPackages();
            assert elements != null;
            final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv_0 = idResolver.getProperty(PROPid_parentEnv);
            final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_parentEnv = new UnboxedExplicitNavigationProperty(PROPid_parentEnv);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_2 = idResolver.getClass(CLSSid_Environment, null);
            final @NonNull /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(PROPid_namedElements);
            final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
            final @NonNull /*@Thrown*/ Environment symbol_2 = (Environment)TYP_env_c_c_Environment_2.createInstance();
            final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_1);
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
            final @NonNull /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements);
            final @NonNull /*@Thrown*/ CollectionValue BOXED_elements = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements);
            final @NonNull /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence, BOXED_elements);
            final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, NamedElement.class);
            assert UNBOXED_includingAll != null;
            CTORid_namedElements.initValue(symbol_2, UNBOXED_includingAll);
            final @Nullable /*@Thrown*/ Environment parentEnv_0 = (Environment)IMPPROPid_parentEnv.evaluate(evaluator, CLSSid_Environment, symbol_1);
            CTORid_parentEnv_0.initValue(symbol_2, parentEnv_0);
            symbol_3 = symbol_2;
        }
        return symbol_3;
    }
    
    /**
     * classes::Package::_env_Package(child : OclElement) : env::Environment
     * 
     * parentEnv().nestedEnv().addElements(self.ownedPackages)
     */
    public @NonNull /*@NonInvalid*/ Environment _env_Package(final @NonNull /*@NonInvalid*/ Package self_1, final @NonNull /*@NonInvalid*/ Object child_0) {
        final @NonNull /*@Thrown*/ Environment self_7 = this.parentEnv(self_1);
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
        final @NonNull /*@Thrown*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
        CTORid_parentEnv.initValue(symbol_0, self_7);
        final @Nullable /*@Thrown*/ List<Package> elements = self_1.getOwnedPackages();
        assert elements != null;
        final @NonNull /*@NonInvalid*/ IdResolver idResolver_0 = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv_0 = idResolver_0.getProperty(PROPid_parentEnv);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_parentEnv = new UnboxedExplicitNavigationProperty(PROPid_parentEnv);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_1 = idResolver_0.getClass(CLSSid_Environment, null);
        final @NonNull /*@NonInvalid*/ Property CTORid_namedElements = idResolver_0.getProperty(PROPid_namedElements);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
        final @NonNull /*@Thrown*/ Environment symbol_1 = (Environment)TYP_env_c_c_Environment_1.createInstance();
        final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_0);
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver_0.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
        final @NonNull /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements);
        final @NonNull /*@Thrown*/ CollectionValue BOXED_elements = idResolver_0.createCollectionOfAll(COL_CLSSid_NamedElement, elements);
        final @NonNull /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence, BOXED_elements);
        final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver_0, NamedElement.class);
        assert UNBOXED_includingAll != null;
        CTORid_namedElements.initValue(symbol_1, UNBOXED_includingAll);
        final @Nullable /*@Thrown*/ Environment parentEnv_0 = (Environment)IMPPROPid_parentEnv.evaluate(evaluator, CLSSid_Environment, symbol_0);
        CTORid_parentEnv_0.initValue(symbol_1, parentEnv_0);
        return symbol_1;
    }
    
    /**
     * classes::Package::_env_Class(child : OclElement) : env::Environment
     * 
     * parentEnv().nestedEnv().addElements(self.ownedClasses)
     */
    public @NonNull /*@NonInvalid*/ Environment _env_Class(final @NonNull /*@NonInvalid*/ Package self_3, final @NonNull /*@NonInvalid*/ Object child_1) {
        final @NonNull /*@Thrown*/ Environment self_7 = this.parentEnv(self_3);
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
        final @NonNull /*@Thrown*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
        CTORid_parentEnv.initValue(symbol_0, self_7);
        final @Nullable /*@Thrown*/ List<classes.Class> elements = self_3.getOwnedClasses();
        assert elements != null;
        final @NonNull /*@NonInvalid*/ IdResolver idResolver_0 = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv_0 = idResolver_0.getProperty(PROPid_parentEnv);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_parentEnv = new UnboxedExplicitNavigationProperty(PROPid_parentEnv);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_1 = idResolver_0.getClass(CLSSid_Environment, null);
        final @NonNull /*@NonInvalid*/ Property CTORid_namedElements = idResolver_0.getProperty(PROPid_namedElements);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
        final @NonNull /*@Thrown*/ Environment symbol_1 = (Environment)TYP_env_c_c_Environment_1.createInstance();
        final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_0);
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver_0.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
        final @NonNull /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements);
        final @NonNull /*@Thrown*/ CollectionValue BOXED_elements = idResolver_0.createCollectionOfAll(COL_CLSSid_NamedElement, elements);
        final @NonNull /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence, BOXED_elements);
        final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver_0, NamedElement.class);
        assert UNBOXED_includingAll != null;
        CTORid_namedElements.initValue(symbol_1, UNBOXED_includingAll);
        final @Nullable /*@Thrown*/ Environment parentEnv_0 = (Environment)IMPPROPid_parentEnv.evaluate(evaluator, CLSSid_Environment, symbol_0);
        CTORid_parentEnv_0.initValue(symbol_1, parentEnv_0);
        return symbol_1;
    }
    
    /**
     * classes::Package::_env(child : OclElement) : env::Environment
     * 
     * 
     * let _env_Package : env::Environment = _env_Package(child)
     * in
     *   let _env_Class : env::Environment = _env_Class(child)
     *   in _env_Package.mergEnv(_env_Class)
     */
    public @NonNull /*@NonInvalid*/ Environment _env(final @NonNull /*@NonInvalid*/ Package self_0, final @NonNull /*@NonInvalid*/ Object child) {
        final @NonNull /*@Thrown*/ Environment _env_Package = this._env_Package(self_0, child);
        final @NonNull /*@Thrown*/ Environment _env_Class = this._env_Class(self_0, child);
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_parentEnv = new UnboxedExplicitNavigationProperty(PROPid_parentEnv);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
        final @NonNull /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(PROPid_namedElements);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements_0 = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
        final @NonNull /*@Thrown*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
        final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements_0.evaluate(evaluator, ORD_CLSSid_NamedElement, _env_Package);
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
        final @NonNull /*@Thrown*/ SequenceValue asSequence = CollectionAsSequenceOperation.INSTANCE.evaluate(BOXED_namedElements);
        final @NonNull /*@Thrown*/ List<NamedElement> namedElements_0 = (List<NamedElement>)IMPPROPid_namedElements_0.evaluate(evaluator, ORD_CLSSid_NamedElement, _env_Class);
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_0);
        final @NonNull /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(asSequence, BOXED_namedElements_0);
        final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, NamedElement.class);
        assert UNBOXED_includingAll != null;
        CTORid_namedElements.initValue(symbol_0, UNBOXED_includingAll);
        final @Nullable /*@Thrown*/ Environment parentEnv = (Environment)IMPPROPid_parentEnv.evaluate(evaluator, CLSSid_Environment, _env_Package);
        CTORid_parentEnv.initValue(symbol_0, parentEnv);
        return symbol_0;
    }
    
    /**
     * env::Environment::lookupClass(path : classescs::PathElementCS) : classes::Class
     * 
     * 
     * let
     *   foundClasses : OrderedSet(classes::Class) = namedElements->selectByKind(classes::Class)
     *   ->select(name = path.name)
     * in
     *   if foundClasses->isEmpty()
     *   then
     *     if parentEnv.oclIsUndefined()
     *     then null
     *     else parentEnv.lookupClass(path)
     *     endif
     *   else foundClasses->first()
     *   endif
     */
    public @NonNull /*@NonInvalid*/ classes.Class lookupClass(final @NonNull /*@NonInvalid*/ Environment self_4, final @NonNull /*@NonInvalid*/ PathElementCS path) {
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
        final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements.evaluate(evaluator, ORD_CLSSid_NamedElement, self_4);
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
        final @NonNull /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements, TYP_classes_c_c_Class_0);
        @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Class);
        @Nullable Iterator<?> ITERATOR__1 = selectByKind.iterator();
        @NonNull /*@Thrown*/ OrderedSetValue foundClasses;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                foundClasses = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ classes.Class _1 = (classes.Class)ITERATOR__1.next();
            /**
             * name = path.name
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'classes::NamedElement::name\'");
            }
            final @Nullable /*@Thrown*/ String name = _1.getName();
            final @Nullable /*@Thrown*/ String name_0 = path.getName();
            final /*@Thrown*/ boolean eq = (name != null) ? name.equals(name_0) : (name_0 == null);
            //
            if (eq == ValueUtil.TRUE_VALUE) {
                accumulator.add(_1);
            }
        }
        final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundClasses).booleanValue();
        @Nullable /*@Thrown*/ classes.Class symbol_2;
        if (isEmpty) {
            @Nullable /*@Caught*/ Object CAUGHT_parentEnv;
            try {
                final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_parentEnv = new UnboxedExplicitNavigationProperty(PROPid_parentEnv);
                final @Nullable /*@Thrown*/ Environment parentEnv = (Environment)IMPPROPid_parentEnv.evaluate(evaluator, CLSSid_Environment, self_4);
                CAUGHT_parentEnv = parentEnv;
            }
            catch (Exception e) {
                CAUGHT_parentEnv = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ boolean symbol_0 = (CAUGHT_parentEnv == null) || (CAUGHT_parentEnv instanceof InvalidValueException);
            @Nullable /*@Thrown*/ classes.Class symbol_1;
            if (symbol_0) {
                symbol_1 = null;
            }
            else {
                final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_parentEnv_0 = new UnboxedExplicitNavigationProperty(PROPid_parentEnv);
                final @Nullable /*@Thrown*/ Environment parentEnv_0 = (Environment)IMPPROPid_parentEnv_0.evaluate(evaluator, CLSSid_Environment, self_4);
                if (parentEnv_0 == null) {
                    throw new InvalidValueException("Null source for \'env::Environment::lookupClass(classescs::PathElementCS) : classes::Class\'");
                }
                final @NonNull /*@Thrown*/ classes.Class lookupClass = this.lookupClass(parentEnv_0, path);
                symbol_1 = lookupClass;
            }
            symbol_2 = symbol_1;
        }
        else {
            final @Nullable /*@Thrown*/ classes.Class first = (classes.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundClasses);
            symbol_2 = first;
        }
        if (symbol_2 == null) {
            throw new InvalidValueException("Null body for \'env::Environment::lookupClass(classescs::PathElementCS) : classes::Class\'");
        }
        return symbol_2;
    }
    
    /**
     * env::Environment::lookupPackage(path : classescs::PathElementCS) : classes::Package
     * 
     * 
     * let
     *   foundPackages : OrderedSet(classes::Package) = namedElements->selectByKind(classes::Package)
     *   ->select(name = path.name)
     * in
     *   if foundPackages->isEmpty()
     *   then
     *     if parentEnv.oclIsUndefined()
     *     then null
     *     else parentEnv.lookupPackage(path)
     *     endif
     *   else foundPackages->first()
     *   endif
     */
    public @NonNull /*@NonInvalid*/ Package lookupPackage(final @NonNull /*@NonInvalid*/ Environment self_6, final @NonNull /*@NonInvalid*/ PathElementCS path_0) {
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
        final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements.evaluate(evaluator, ORD_CLSSid_NamedElement, self_6);
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
        final @NonNull /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements, TYP_classes_c_c_Package_0);
        @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Package);
        @Nullable Iterator<?> ITERATOR__1 = selectByKind.iterator();
        @NonNull /*@Thrown*/ OrderedSetValue foundPackages;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                foundPackages = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ Package _1 = (Package)ITERATOR__1.next();
            /**
             * name = path.name
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'classes::NamedElement::name\'");
            }
            final @Nullable /*@Thrown*/ String name = _1.getName();
            final @Nullable /*@Thrown*/ String name_0 = path_0.getName();
            final /*@Thrown*/ boolean eq = (name != null) ? name.equals(name_0) : (name_0 == null);
            //
            if (eq == ValueUtil.TRUE_VALUE) {
                accumulator.add(_1);
            }
        }
        final /*@Thrown*/ boolean isEmpty = CollectionIsEmptyOperation.INSTANCE.evaluate(foundPackages).booleanValue();
        @Nullable /*@Thrown*/ Package symbol_2;
        if (isEmpty) {
            @Nullable /*@Caught*/ Object CAUGHT_parentEnv;
            try {
                final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_parentEnv = new UnboxedExplicitNavigationProperty(PROPid_parentEnv);
                final @Nullable /*@Thrown*/ Environment parentEnv = (Environment)IMPPROPid_parentEnv.evaluate(evaluator, CLSSid_Environment, self_6);
                CAUGHT_parentEnv = parentEnv;
            }
            catch (Exception e) {
                CAUGHT_parentEnv = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ boolean symbol_0 = (CAUGHT_parentEnv == null) || (CAUGHT_parentEnv instanceof InvalidValueException);
            @Nullable /*@Thrown*/ Package symbol_1;
            if (symbol_0) {
                symbol_1 = null;
            }
            else {
                final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_parentEnv_0 = new UnboxedExplicitNavigationProperty(PROPid_parentEnv);
                final @Nullable /*@Thrown*/ Environment parentEnv_0 = (Environment)IMPPROPid_parentEnv_0.evaluate(evaluator, CLSSid_Environment, self_6);
                if (parentEnv_0 == null) {
                    throw new InvalidValueException("Null source for \'env::Environment::lookupPackage(classescs::PathElementCS) : classes::Package\'");
                }
                final @NonNull /*@Thrown*/ Package lookupPackage = this.lookupPackage(parentEnv_0, path_0);
                symbol_1 = lookupPackage;
            }
            symbol_2 = symbol_1;
        }
        else {
            final @Nullable /*@Thrown*/ Package first = (Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(foundPackages);
            symbol_2 = first;
        }
        if (symbol_2 == null) {
            throw new InvalidValueException("Null body for \'env::Environment::lookupPackage(classescs::PathElementCS) : classes::Package\'");
        }
        return symbol_2;
    }
    
    /**
     * env::Environment::lookupPackage(pathSeq : OrderedSet(classescs::PathElementCS)) : classes::Package
     * 
     * 
     * if pathSeq->size() = 1
     * then lookupPackage(pathSeq->first())
     * else
     *   lookupPackage(
     *     pathSeq->subOrderedSet(1, pathSeq->size() - 1))
     *   .env()
     *   .lookupPackage(pathSeq->last())
     * endif
     */
    public @NonNull /*@NonInvalid*/ Package lookupPackage(final @NonNull /*@NonInvalid*/ Environment self_5, final @NonNull /*@NonInvalid*/ List<PathElementCS> pathSeq) {
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ OrderedSetValue BOXED_pathSeq_3 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathSeq);
        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathSeq_3);
        final /*@Thrown*/ boolean eq = size.equals(INT_1);
        @NonNull /*@Thrown*/ Package symbol_0;
        if (eq) {
            final @Nullable /*@Thrown*/ PathElementCS first = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathSeq_3);
            final @NonNull /*@Thrown*/ Package lookupPackage = this.lookupPackage(self_5, first);
            symbol_0 = lookupPackage;
        }
        else {
            final @NonNull /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
            final @NonNull /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_pathSeq_3, INT_1, diff);
            final List<PathElementCS> UNBOXED_subOrderedSet = subOrderedSet.asEcoreObjects(idResolver, PathElementCS.class);
            assert UNBOXED_subOrderedSet != null;
            final @NonNull /*@Thrown*/ Package self_7 = this.lookupPackage(self_5, UNBOXED_subOrderedSet);
            final @NonNull /*@Thrown*/ Environment _env = this._env(self_7, null);
            final @Nullable /*@Thrown*/ PathElementCS last = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_pathSeq_3);
            final @NonNull /*@Thrown*/ Package lookupPackage_0 = this.lookupPackage(_env, last);
            symbol_0 = lookupPackage_0;
        }
        return symbol_0;
    }
    
    /**
     * 
     * map cClassCS_2_Class in classescs2as_qvtp_qvtias) {
     * leftCS (classCS : classescs::ClassCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize class : classes::Class;
     *  |
     * }
     * where ( |
     * )
     * { |
     * classCS = class;
     * }
     * 
     * }
     */
    protected boolean cClassCS_2_Class(final @NonNull /*@NonInvalid*/ ClassCS classCS) {
        // predicates
        // creations
        final /*@Thrown*/ classes.Class symbol_0 = ClassesFactory.eINSTANCE.createClass();
        assert symbol_0 != null;
        modelObjects[1/*rightAS*/].add(symbol_0);
        // assignments
        classCS.setAst(symbol_0);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cPackageCS_2_Package in classescs2as_qvtp_qvtias) {
     * leftCS (packageCS : classescs::PackageCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize package : classes::Package;
     *  |
     * }
     * where ( |
     * )
     * { |
     * packageCS = package;
     * }
     * 
     * }
     */
    protected boolean cPackageCS_2_Package(final @NonNull /*@NonInvalid*/ PackageCS packageCS) {
        // predicates
        // creations
        final /*@Thrown*/ Package symbol_0 = ClassesFactory.eINSTANCE.createPackage();
        assert symbol_0 != null;
        modelObjects[1/*rightAS*/].add(symbol_0);
        // assignments
        packageCS.setAst(symbol_0);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map cRootCS_2_Root in classescs2as_qvtp_qvtias) {
     * leftCS (rootCS : classescs::RootCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * {realize root : classes::Root;
     *  |
     * }
     * where ( |
     * )
     * { |
     * rootCS = root;
     * }
     * 
     * }
     */
    protected boolean cRootCS_2_Root(final @NonNull /*@NonInvalid*/ RootCS rootCS) {
        // predicates
        // creations
        final /*@Thrown*/ Root root = ClassesFactory.eINSTANCE.createRoot();
        assert root != null;
        modelObjects[1/*rightAS*/].add(root);
        // assignments
        rootCS.setAst(root);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uClass_name in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (classCS : classescs::ClassCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * classCS.ast.oclAsType(classes::Class) = name;
     * }
     * 
     * }
     */
    protected boolean uClass_name(final @NonNull /*@NonInvalid*/ ClassCS classCS_0) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = classCS_0.getAst();
        final @Nullable /*@Thrown*/ classes.Class oclAsType = (classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Class_0);
        final @Nullable /*@Thrown*/ String name = classCS_0.getName();
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uClass_superClass in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (classCS : classescs::ClassCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * classCS.ast.oclAsType(classes::Class)
     *    = if extends = null
     *   then null
     *   else
     *     ast.oclAsType(classes::Class)
     *     .env()
     *     .lookupClass(extends)
     *   endif;
     * }
     * 
     * }
     */
    protected boolean uClass_superClass(final @NonNull /*@NonInvalid*/ ClassCS classCS_1) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
        final @Nullable /*@Thrown*/ EObject ast = classCS_1.getAst();
        // creations
        // assignments
        final @Nullable /*@Thrown*/ classes.Class oclAsType = (classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Class_0);
        final @Nullable /*@Thrown*/ PathNameCS symbol_0 = classCS_1.getExtends();
        final /*@Thrown*/ boolean eq = symbol_0 == null;
        @Nullable /*@Thrown*/ classes.Class symbol_2;
        if (eq) {
            symbol_2 = null;
        }
        else {
            final @Nullable /*@Thrown*/ classes.Class self_7 = (classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Class_0);
            final @Nullable /*@Thrown*/ Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_7);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            final @Nullable /*@Thrown*/ Package oclAsType_0 = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent, TYP_classes_c_c_Package_0);
            if (oclAsType_0 == null) {
                throw new InvalidValueException("Null source for \'classes::Package::_env(OclElement) : env::Environment\'");
            }
            final @NonNull /*@Thrown*/ Environment _env = this._env(oclAsType_0, self_7);
            final @Nullable /*@Thrown*/ PathNameCS classPathName = classCS_1.getExtends();
            if (classPathName == null) {
                throw new InvalidValueException("Null source for \'classescs::PathNameCS::path\'");
            }
            final @Nullable /*@Thrown*/ List<PathElementCS> pathSeq_0 = classPathName.getPath();
            assert pathSeq_0 != null;
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_pathSeq_0_3 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathSeq_0);
            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathSeq_0_3);
            final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
            @NonNull /*@Thrown*/ classes.Class symbol_1;
            if (eq_0) {
                final @Nullable /*@Thrown*/ PathElementCS first = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathSeq_0_3);
                final @NonNull /*@Thrown*/ classes.Class lookupClass = this.lookupClass(_env, first);
                symbol_1 = lookupClass;
            }
            else {
                final @NonNull /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                final @NonNull /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_pathSeq_0_3, INT_1, diff);
                final List<PathElementCS> UNBOXED_subOrderedSet = subOrderedSet.asEcoreObjects(idResolver, PathElementCS.class);
                assert UNBOXED_subOrderedSet != null;
                final @NonNull /*@Thrown*/ Package self_8 = this.lookupPackage(_env, UNBOXED_subOrderedSet);
                final @NonNull /*@Thrown*/ Environment _env_0 = this._env(self_8, null);
                final @Nullable /*@Thrown*/ PathElementCS last = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_pathSeq_0_3);
                final @NonNull /*@Thrown*/ classes.Class lookupClass_0 = this.lookupClass(_env_0, last);
                symbol_1 = lookupClass_0;
            }
            symbol_2 = symbol_1;
        }
        oclAsType.setSuperClass(symbol_2);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPackage_name in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (packageCS : classescs::PackageCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * packageCS.ast.oclAsType(classes::Package) = name;
     * }
     * 
     * }
     */
    protected boolean uPackage_name(final @NonNull /*@NonInvalid*/ PackageCS packageCS_0) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = packageCS_0.getAst();
        final @Nullable /*@Thrown*/ Package oclAsType = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Package_0);
        final @Nullable /*@Thrown*/ String name = packageCS_0.getName();
        oclAsType.setName(name);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPackage_ownedClasses in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (packageCS : classescs::PackageCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * packageCS.ast.oclAsType(classes::Package)
     *    = ownedClasses.ast.oclAsType(classes::Class)
     *   ->asOrderedSet();
     * }
     * 
     * }
     */
    protected boolean uPackage_ownedClasses(final @NonNull /*@NonInvalid*/ PackageCS packageCS_1) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = packageCS_1.getAst();
        final @Nullable /*@Thrown*/ Package oclAsType = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Package_0);
        final @Nullable /*@Thrown*/ List<ClassCS> ownedClasses = packageCS_1.getOwnedClasses();
        assert ownedClasses != null;
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedClasses.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ ClassCS _1 = (ClassCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Class)
             */
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class, null);
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'classescs::ElementCS::ast\'");
            }
            final @Nullable /*@Thrown*/ EObject ast_0 = _1.getAst();
            final @Nullable /*@Thrown*/ classes.Class oclAsType_0 = (classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_classes_c_c_Class_0);
            //
            accumulator.add(oclAsType_0);
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
        final List<classes.Class> UNBOXED_asOrderedSet = asOrderedSet.asEcoreObjects(idResolver, classes.Class.class);
        assert UNBOXED_asOrderedSet != null;
        oclAsType.getOwnedClasses().addAll(UNBOXED_asOrderedSet);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uPackage_ownedPackages in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (packageCS : classescs::PackageCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * packageCS.ast.oclAsType(classes::Package)
     *    = ownedPackages.ast.oclAsType(classes::Package)
     *   ->asOrderedSet();
     * }
     * 
     * }
     */
    protected boolean uPackage_ownedPackages(final @NonNull /*@NonInvalid*/ PackageCS packageCS_2) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = packageCS_2.getAst();
        final @Nullable /*@Thrown*/ Package oclAsType = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Package_0);
        final @Nullable /*@Thrown*/ List<PackageCS> ownedPackages = packageCS_2.getOwnedPackages();
        assert ownedPackages != null;
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedPackages.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ PackageCS _1 = (PackageCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Package)
             */
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'classescs::ElementCS::ast\'");
            }
            final @Nullable /*@Thrown*/ EObject ast_0 = _1.getAst();
            final @Nullable /*@Thrown*/ Package oclAsType_0 = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_classes_c_c_Package_0);
            //
            accumulator.add(oclAsType_0);
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
        final List<Package> UNBOXED_asOrderedSet = asOrderedSet.asEcoreObjects(idResolver, Package.class);
        assert UNBOXED_asOrderedSet != null;
        oclAsType.getOwnedPackages().addAll(UNBOXED_asOrderedSet);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map uRoot_ownedPackages in classescs2as_qvtp_qvtias) {
     * 
     *   leftCS (rootCS : classescs::RootCS;
     *  |
     * )
     * { |
     * }
     * rightAS ( |
     * )
     * { |
     * }
     * where ( |
     * )
     * { |
     * rootCS.ast.oclAsType(classes::Root)
     *    = ownedPackages.ast.oclAsType(classes::Package)
     *   ->asOrderedSet();
     * }
     * 
     * }
     */
    protected boolean uRoot_ownedPackages(final @NonNull /*@NonInvalid*/ RootCS rootCS_0) {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
        // creations
        // assignments
        final @Nullable /*@Thrown*/ EObject ast = rootCS_0.getAst();
        final @Nullable /*@Thrown*/ Root oclAsType = (Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Root_0);
        final @Nullable /*@Thrown*/ List<PackageCS> ownedPackages = rootCS_0.getOwnedPackages();
        assert ownedPackages != null;
        final @NonNull /*@Thrown*/ OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        @NonNull /*@Thrown*/ SequenceValue.Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        @Nullable Iterator<?> ITERATOR__1 = BOXED_ownedPackages.iterator();
        @NonNull /*@Thrown*/ SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            @Nullable /*@NonInvalid*/ PackageCS _1 = (PackageCS)ITERATOR__1.next();
            /**
             * ast.oclAsType(classes::Package)
             */
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            if (_1 == null) {
                throw new InvalidValueException("Null source for \'classescs::ElementCS::ast\'");
            }
            final @Nullable /*@Thrown*/ EObject ast_0 = _1.getAst();
            final @Nullable /*@Thrown*/ Package oclAsType_0 = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast_0, TYP_classes_c_c_Package_0);
            //
            accumulator.add(oclAsType_0);
        }
        final @NonNull /*@Thrown*/ OrderedSetValue asOrderedSet = CollectionAsOrderedSetOperation.INSTANCE.evaluate(collect);
        final List<Package> UNBOXED_asOrderedSet = asOrderedSet.asEcoreObjects(idResolver, Package.class);
        assert UNBOXED_asOrderedSet != null;
        oclAsType.getOwnedPackages().addAll(UNBOXED_asOrderedSet);
        // mapping statements
        return true;
    }
    
    /**
     * 
     * map __root__ in classescs2as_qvtp_qvtias) {
     * 
     *   where ( |
     * )
     * { |
     * }
     * for rootCS : classescs::RootCS in classescs::RootCS.allInstances()
     *    {
     * map cRootCS_2_Root {
     * rootCS := rootCS;
     * }}
     *   for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map cPackageCS_2_Package {
     * packageCS := packageCS;
     * }}
     *   for rootCS : classescs::RootCS in classescs::RootCS.allInstances()
     *    {
     * map uRoot_ownedPackages {
     * rootCS := rootCS;
     * }}
     *   for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map uPackage_name {
     * packageCS := packageCS;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map cClassCS_2_Class {
     * classCS := classCS;
     * }}
     *   for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map uPackage_ownedClasses {
     * packageCS := packageCS;
     * }}
     *   for packageCS : classescs::PackageCS in classescs::PackageCS.allInstances()
     *    {
     * map uPackage_ownedPackages {
     * packageCS := packageCS;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map uClass_name {
     * classCS := classCS;
     * }}
     *   for classCS : classescs::ClassCS in classescs::ClassCS.allInstances()
     *    {
     * map uClass_superClass {
     * classCS := classCS;
     * }}
     * }
     */
    protected boolean __root__() {
        // predicates
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_ClassCS_2 = idResolver.getClass(CLSSid_ClassCS, null);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_PackageCS_3 = idResolver.getClass(CLSSid_PackageCS, null);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_RootCS_1 = idResolver.getClass(CLSSid_RootCS, null);
        final @NonNull /*@Thrown*/ SetValue allInstances_6 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_ClassCS, TYP_classescs_c_c_ClassCS_2);
        final @NonNull /*@Thrown*/ SetValue allInstances_2 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_PackageCS, TYP_classescs_c_c_PackageCS_3);
        final @NonNull /*@Thrown*/ SetValue allInstances_1 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_RootCS, TYP_classescs_c_c_RootCS_1);
        final List<ClassCS> UNBOXED_allInstances_6 = allInstances_6.asEcoreObjects(idResolver, ClassCS.class);
        assert UNBOXED_allInstances_6 != null;
        final List<PackageCS> UNBOXED_allInstances_2 = allInstances_2.asEcoreObjects(idResolver, PackageCS.class);
        assert UNBOXED_allInstances_2 != null;
        final List<RootCS> UNBOXED_allInstances_1 = allInstances_1.asEcoreObjects(idResolver, RootCS.class);
        assert UNBOXED_allInstances_1 != null;
        // creations
        // assignments
        // mapping statements
        ;
        for (RootCS rootCS_3 : UNBOXED_allInstances_1) {
            if (rootCS_3 != null) {
                final @NonNull /*@NonInvalid*/ RootCS symbol_1 = (RootCS)rootCS_3;
                cRootCS_2_Root(symbol_1);
            }
        }
        ;
        for (PackageCS packageCS_7 : UNBOXED_allInstances_2) {
            if (packageCS_7 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS symbol_5 = (PackageCS)packageCS_7;
                cPackageCS_2_Package(symbol_5);
            }
        }
        ;
        for (RootCS rootCS_4 : UNBOXED_allInstances_1) {
            if (rootCS_4 != null) {
                final @NonNull /*@NonInvalid*/ RootCS symbol_9 = (RootCS)rootCS_4;
                uRoot_ownedPackages(symbol_9);
            }
        }
        ;
        for (PackageCS packageCS_8 : UNBOXED_allInstances_2) {
            if (packageCS_8 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS symbol_13 = (PackageCS)packageCS_8;
                uPackage_name(symbol_13);
            }
        }
        ;
        for (ClassCS classCS_5 : UNBOXED_allInstances_6) {
            if (classCS_5 != null) {
                final @NonNull /*@NonInvalid*/ ClassCS symbol_17 = (ClassCS)classCS_5;
                cClassCS_2_Class(symbol_17);
            }
        }
        ;
        for (PackageCS packageCS_9 : UNBOXED_allInstances_2) {
            if (packageCS_9 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS symbol_21 = (PackageCS)packageCS_9;
                uPackage_ownedClasses(symbol_21);
            }
        }
        ;
        for (PackageCS packageCS_10 : UNBOXED_allInstances_2) {
            if (packageCS_10 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS symbol_25 = (PackageCS)packageCS_10;
                uPackage_ownedPackages(symbol_25);
            }
        }
        ;
        for (ClassCS classCS_6 : UNBOXED_allInstances_6) {
            if (classCS_6 != null) {
                final @NonNull /*@NonInvalid*/ ClassCS symbol_29 = (ClassCS)classCS_6;
                uClass_name(symbol_29);
            }
        }
        ;
        for (ClassCS classCS_7 : UNBOXED_allInstances_6) {
            if (classCS_7 != null) {
                final @NonNull /*@NonInvalid*/ ClassCS symbol_33 = (ClassCS)classCS_7;
                uClass_superClass(symbol_33);
            }
        }
        return true;
    }
}
