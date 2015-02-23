/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg;

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
import org.eclipse.ocl.pivot.library.collection.CollectionIncludingAllOperation;
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
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://ocldependencyanalysis/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_qvtd_buid_cs_tests_s_example2_s_env = IdManager.getNsURIPackageId("http://qvtd.buid.cs.tests/example2/env", null, EnvironmentPackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_ClassCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("ClassCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Class_0 = PACKid_$metamodel$.getClassId("Class", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Environment = PACKid_http_c_s_s_qvtd_buid_cs_tests_s_example2_s_env.getClassId("Environment", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_NamedElement = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("NamedElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Package = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Package", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PackageCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("PackageCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PathElementCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("PathElementCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_PathNameCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("PathNameCS", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_Root = PACKid_http_c_s_s_ocldependencyanalysis_s_classes_s_1_0.getClassId("Root", 0);
    public static final @NonNull /*@NonInvalid*/ ClassId CLSSid_RootCS = PACKid_http_c_s_s_ocldependencyanalysis_s_classescs_s_1_0.getClassId("RootCS", 0);
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
     * ocl::OclElement::_env(child : OclElement) : env::Environment
     * 
     * parentEnv()
     */
    public @NonNull /*@NonInvalid*/ Environment _env(final @NonNull /*@NonInvalid*/ Object self_1, final @NonNull /*@NonInvalid*/ Object child) {
        final @NonNull /*@Thrown*/ Environment parentEnv = this.parentEnv(self_1);
        return parentEnv;
    }
    
    /**
     * ocl::OclElement::parentEnv() : env::Environment
     * 
     * 
     * let parent : OclElement = oclContainer()
     * in
     *   if parent = null
     *   then env::Environment{}
     *   else parent._env(self)
     *   endif
     */
    public @NonNull /*@NonInvalid*/ Environment parentEnv(final @NonNull /*@NonInvalid*/ Object self_0) {
        final @Nullable /*@Thrown*/ Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_0);
        final /*@Thrown*/ boolean eq = parent == null;
        @NonNull /*@Thrown*/ Environment symbol_1;
        if (eq) {
            final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
            final @NonNull /*@NonInvalid*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            symbol_1 = symbol_0;
        }
        else {
            if (parent == null) {
                throw new InvalidValueException("Null source for \'OclElement::_env(OclElement) : env::Environment\'");
            }
            final @NonNull /*@Thrown*/ Environment _env = this._env(parent, self_0);
            symbol_1 = _env;
        }
        return symbol_1;
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
    public @NonNull /*@NonInvalid*/ Package lookupPackage(final @NonNull /*@NonInvalid*/ Environment self_2, final @NonNull /*@NonInvalid*/ List<PathElementCS> pathSeq) {
        final @NonNull /*@NonInvalid*/ IdResolver idResolver = evaluator.getIdResolver();
        final @NonNull /*@NonInvalid*/ OrderedSetValue BOXED_pathSeq = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathSeq);
        final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathSeq);
        final /*@Thrown*/ boolean eq = size.equals(INT_1);
        @Nullable /*@Thrown*/ Package symbol_8;
        if (eq) {
            final @Nullable /*@Thrown*/ PathElementCS path = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathSeq);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
            final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements.evaluate(evaluator, ORD_CLSSid_NamedElement, self_2);
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
            final @NonNull /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements, TYP_classes_c_c_Package_0);
            @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Package);
            @Nullable Iterator<?> ITERATOR__1 = selectByKind.iterator();
            @NonNull /*@Thrown*/ OrderedSetValue select;
            while (true) {
                if (!ITERATOR__1.hasNext()) {
                    select = accumulator;
                    break;
                }
                @Nullable /*@NonInvalid*/ Package _1 = (Package)ITERATOR__1.next();
                /**
                 * _'=' : Boolean
                 */
                if (_1 == null) {
                    throw new InvalidValueException("Null source for \'classes::NamedElement::name\'");
                }
                final @Nullable /*@Thrown*/ String name = _1.getName();
                if (path == null) {
                    throw new InvalidValueException("Null source for \'classescs::NamedElementCS::name\'");
                }
                final @Nullable /*@Thrown*/ String name_0 = path.getName();
                final /*@Thrown*/ boolean eq_0 = (name != null) ? name.equals(name_0) : (name_0 == null);
                //
                if (eq_0 == ValueUtil.TRUE_VALUE) {
                    accumulator.add(_1);
                }
            }
            final @Nullable /*@Thrown*/ Package first = (Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(select);
            symbol_8 = first;
        }
        else {
            final @NonNull /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
            final @NonNull /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_pathSeq, INT_1, diff);
            final List<PathElementCS> UNBOXED_subOrderedSet = subOrderedSet.asEcoreObjects(idResolver, PathElementCS.class);
            assert UNBOXED_subOrderedSet != null;
            final @NonNull /*@Thrown*/ Package self_3 = this.lookupPackage(self_2, UNBOXED_subOrderedSet);
            final @Nullable /*@Thrown*/ Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_3);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_1 = idResolver.getClass(CLSSid_Package, null);
            final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, parent, TYP_classes_c_c_Package_1).booleanValue();
            @NonNull /*@Thrown*/ Environment symbol_7;
            if (oclIsKindOf) {
                final @Nullable /*@Thrown*/ Package self_4 = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent, TYP_classes_c_c_Package_1);
                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
                final @NonNull /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(PROPid_namedElements);
                final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements_2 = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
                final @NonNull /*@Thrown*/ Environment symbol_4 = (Environment)TYP_env_c_c_Environment_0.createInstance();
                if (self_4 == null) {
                    throw new InvalidValueException("Null source for \'classes::Package::ownedClasses\'");
                }
                final @NonNull /*@Thrown*/ Environment self_5 = this.parentEnv(self_4);
                final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
                final @NonNull /*@Thrown*/ Environment symbol_0 = (Environment)TYP_env_c_c_Environment_0.createInstance();
                CTORid_parentEnv.initValue(symbol_0, self_5);
                final @Nullable /*@Thrown*/ List<classes.Class> elements = self_4.getOwnedClasses();
                assert elements != null;
                final @NonNull /*@Thrown*/ Environment symbol_1 = (Environment)TYP_env_c_c_Environment_0.createInstance();
                final @NonNull /*@Thrown*/ List<NamedElement> namedElements_0 = (List<NamedElement>)IMPPROPid_namedElements_2.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_0);
                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_0);
                final @NonNull /*@Thrown*/ CollectionValue BOXED_elements = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements);
                final @NonNull /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_0, BOXED_elements);
                final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, NamedElement.class);
                assert UNBOXED_includingAll != null;
                CTORid_namedElements.initValue(symbol_1, UNBOXED_includingAll);
                final @NonNull /*@Thrown*/ List<NamedElement> namedElements_2 = (List<NamedElement>)IMPPROPid_namedElements_2.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_1);
                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_2 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_2);
                if (self_4 == null) {
                    throw new InvalidValueException("Null source for \'classes::Package::ownedPackages\'");
                }
                final @NonNull /*@Thrown*/ Environment self_6 = this.parentEnv(self_4);
                final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv_0 = idResolver.getProperty(PROPid_parentEnv);
                final @NonNull /*@Thrown*/ Environment symbol_2 = (Environment)TYP_env_c_c_Environment_0.createInstance();
                CTORid_parentEnv_0.initValue(symbol_2, self_6);
                final @Nullable /*@Thrown*/ List<Package> elements_0 = self_4.getOwnedPackages();
                assert elements_0 != null;
                final @NonNull /*@Thrown*/ Environment symbol_3 = (Environment)TYP_env_c_c_Environment_0.createInstance();
                final @NonNull /*@Thrown*/ List<NamedElement> namedElements_3 = (List<NamedElement>)IMPPROPid_namedElements_2.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_2);
                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_3 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_3);
                final @NonNull /*@Thrown*/ CollectionValue BOXED_elements_0 = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements_0);
                final @NonNull /*@Thrown*/ CollectionValue includingAll_0 = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_3, BOXED_elements_0);
                final List<NamedElement> UNBOXED_includingAll_0 = includingAll_0.asEcoreObjects(idResolver, NamedElement.class);
                assert UNBOXED_includingAll_0 != null;
                CTORid_namedElements.initValue(symbol_3, UNBOXED_includingAll_0);
                final @NonNull /*@Thrown*/ List<NamedElement> namedElements_5 = (List<NamedElement>)IMPPROPid_namedElements_2.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_3);
                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_5 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_5);
                final @NonNull /*@Thrown*/ CollectionValue includingAll_1 = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_2, BOXED_namedElements_5);
                final List<NamedElement> UNBOXED_includingAll_1 = includingAll_1.asEcoreObjects(idResolver, NamedElement.class);
                assert UNBOXED_includingAll_1 != null;
                CTORid_namedElements.initValue(symbol_4, UNBOXED_includingAll_1);
                symbol_7 = symbol_4;
            }
            else {
                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
                final @Nullable /*@Thrown*/ Root self_7 = (Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent, TYP_classes_c_c_Root_0);
                if (self_7 == null) {
                    throw new InvalidValueException("Null source for \'classes::Root::ownedPackages\'");
                }
                final @NonNull /*@Thrown*/ Environment self_8 = this.parentEnv(self_7);
                final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv_1 = idResolver.getProperty(PROPid_parentEnv);
                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_5 = idResolver.getClass(CLSSid_Environment, null);
                final @NonNull /*@Thrown*/ Environment symbol_5 = (Environment)TYP_env_c_c_Environment_5.createInstance();
                CTORid_parentEnv_1.initValue(symbol_5, self_8);
                final @Nullable /*@Thrown*/ List<Package> elements_1 = self_7.getOwnedPackages();
                assert elements_1 != null;
                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_6 = idResolver.getClass(CLSSid_Environment, null);
                final @NonNull /*@NonInvalid*/ Property CTORid_namedElements_2 = idResolver.getProperty(PROPid_namedElements);
                final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements_4 = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
                final @NonNull /*@Thrown*/ Environment symbol_6 = (Environment)TYP_env_c_c_Environment_6.createInstance();
                final @NonNull /*@Thrown*/ List<NamedElement> namedElements_7 = (List<NamedElement>)IMPPROPid_namedElements_4.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_5);
                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_7 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_7);
                final @NonNull /*@Thrown*/ CollectionValue BOXED_elements_1 = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements_1);
                final @NonNull /*@Thrown*/ CollectionValue includingAll_2 = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_7, BOXED_elements_1);
                final List<NamedElement> UNBOXED_includingAll_2 = includingAll_2.asEcoreObjects(idResolver, NamedElement.class);
                assert UNBOXED_includingAll_2 != null;
                CTORid_namedElements_2.initValue(symbol_6, UNBOXED_includingAll_2);
                symbol_7 = symbol_6;
            }
            final @Nullable /*@Thrown*/ PathElementCS path_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_pathSeq);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_3 = idResolver.getClass(CLSSid_Package, null);
            final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements_5 = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
            final @NonNull /*@Thrown*/ List<NamedElement> namedElements_9 = (List<NamedElement>)IMPPROPid_namedElements_5.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_7);
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_9 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_9);
            final @NonNull /*@Thrown*/ OrderedSetValue selectByKind_0 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements_9, TYP_classes_c_c_Package_3);
            @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Package);
            @Nullable Iterator<?> ITERATOR__1_0 = selectByKind_0.iterator();
            @NonNull /*@Thrown*/ OrderedSetValue select_0;
            while (true) {
                if (!ITERATOR__1_0.hasNext()) {
                    select_0 = accumulator_0;
                    break;
                }
                @Nullable /*@NonInvalid*/ Package _1_0 = (Package)ITERATOR__1_0.next();
                /**
                 * _'=' : Boolean
                 */
                if (_1_0 == null) {
                    throw new InvalidValueException("Null source for \'classes::NamedElement::name\'");
                }
                final @Nullable /*@Thrown*/ String name_1 = _1_0.getName();
                if (path_0 == null) {
                    throw new InvalidValueException("Null source for \'classescs::NamedElementCS::name\'");
                }
                final @Nullable /*@Thrown*/ String name_2 = path_0.getName();
                final /*@Thrown*/ boolean eq_1 = (name_1 != null) ? name_1.equals(name_2) : (name_2 == null);
                //
                if (eq_1 == ValueUtil.TRUE_VALUE) {
                    accumulator_0.add(_1_0);
                }
            }
            final @Nullable /*@Thrown*/ Package first_0 = (Package)OrderedCollectionFirstOperation.INSTANCE.evaluate(select_0);
            symbol_8 = first_0;
        }
        if (symbol_8 == null) {
            throw new InvalidValueException("Null body for \'env::Environment::lookupPackage(OrderedSet(classescs::PathElementCS)) : classes::Package\'");
        }
        return symbol_8;
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
        @Nullable /*@Thrown*/ classes.Class symbol_15;
        if (eq) {
            symbol_15 = null;
        }
        else {
            final @Nullable /*@Thrown*/ classes.Class self_3 = (classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, ast, TYP_classes_c_c_Class_0);
            final @Nullable /*@Thrown*/ Object parent = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_3);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            final @Nullable /*@Thrown*/ Package self_4 = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent, TYP_classes_c_c_Package_0);
            final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_0 = idResolver.getClass(CLSSid_Environment, null);
            final @NonNull /*@NonInvalid*/ Property CTORid_namedElements = idResolver.getProperty(PROPid_namedElements);
            final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements_1 = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
            final @NonNull /*@Thrown*/ Environment symbol_5 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            if (self_4 == null) {
                throw new InvalidValueException("Null source for \'classes::Package::ownedClasses\'");
            }
            final @NonNull /*@Thrown*/ Environment self_5 = this.parentEnv(self_4);
            final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv = idResolver.getProperty(PROPid_parentEnv);
            final @NonNull /*@Thrown*/ Environment symbol_1 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            CTORid_parentEnv.initValue(symbol_1, self_5);
            final @Nullable /*@Thrown*/ List<classes.Class> elements = self_4.getOwnedClasses();
            assert elements != null;
            final @NonNull /*@Thrown*/ Environment symbol_2 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            final @NonNull /*@Thrown*/ List<NamedElement> namedElements = (List<NamedElement>)IMPPROPid_namedElements_1.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_1);
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements);
            final @NonNull /*@Thrown*/ CollectionValue BOXED_elements = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements);
            final @NonNull /*@Thrown*/ CollectionValue includingAll = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements, BOXED_elements);
            final List<NamedElement> UNBOXED_includingAll = includingAll.asEcoreObjects(idResolver, NamedElement.class);
            assert UNBOXED_includingAll != null;
            CTORid_namedElements.initValue(symbol_2, UNBOXED_includingAll);
            final @NonNull /*@Thrown*/ List<NamedElement> namedElements_1 = (List<NamedElement>)IMPPROPid_namedElements_1.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_2);
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_1);
            if (self_4 == null) {
                throw new InvalidValueException("Null source for \'classes::Package::ownedPackages\'");
            }
            final @NonNull /*@Thrown*/ Environment self_6 = this.parentEnv(self_4);
            final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv_0 = idResolver.getProperty(PROPid_parentEnv);
            final @NonNull /*@Thrown*/ Environment symbol_3 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            CTORid_parentEnv_0.initValue(symbol_3, self_6);
            final @Nullable /*@Thrown*/ List<Package> elements_0 = self_4.getOwnedPackages();
            assert elements_0 != null;
            final @NonNull /*@Thrown*/ Environment symbol_4 = (Environment)TYP_env_c_c_Environment_0.createInstance();
            final @NonNull /*@Thrown*/ List<NamedElement> namedElements_2 = (List<NamedElement>)IMPPROPid_namedElements_1.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_3);
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_2 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_2);
            final @NonNull /*@Thrown*/ CollectionValue BOXED_elements_0 = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements_0);
            final @NonNull /*@Thrown*/ CollectionValue includingAll_0 = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_2, BOXED_elements_0);
            final List<NamedElement> UNBOXED_includingAll_0 = includingAll_0.asEcoreObjects(idResolver, NamedElement.class);
            assert UNBOXED_includingAll_0 != null;
            CTORid_namedElements.initValue(symbol_4, UNBOXED_includingAll_0);
            final @NonNull /*@Thrown*/ List<NamedElement> namedElements_4 = (List<NamedElement>)IMPPROPid_namedElements_1.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_4);
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_4 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_4);
            final @NonNull /*@Thrown*/ CollectionValue includingAll_1 = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_1, BOXED_namedElements_4);
            final List<NamedElement> UNBOXED_includingAll_1 = includingAll_1.asEcoreObjects(idResolver, NamedElement.class);
            assert UNBOXED_includingAll_1 != null;
            CTORid_namedElements.initValue(symbol_5, UNBOXED_includingAll_1);
            final @Nullable /*@Thrown*/ PathNameCS classPathName = classCS_1.getExtends();
            if (classPathName == null) {
                throw new InvalidValueException("Null source for \'classescs::PathNameCS::path\'");
            }
            final @Nullable /*@Thrown*/ List<PathElementCS> pathSeq_0 = classPathName.getPath();
            assert pathSeq_0 != null;
            final @NonNull /*@Thrown*/ OrderedSetValue BOXED_pathSeq_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, pathSeq_0);
            final @NonNull /*@Thrown*/ IntegerValue size = CollectionSizeOperation.INSTANCE.evaluate(BOXED_pathSeq_0);
            final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
            @Nullable /*@Thrown*/ classes.Class symbol_14;
            if (eq_0) {
                final @Nullable /*@Thrown*/ PathElementCS path = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_pathSeq_0);
                final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements_3 = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
                final @NonNull /*@Thrown*/ List<NamedElement> namedElements_6 = (List<NamedElement>)IMPPROPid_namedElements_3.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_5);
                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_6 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_6);
                final @NonNull /*@Thrown*/ OrderedSetValue selectByKind = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements_6, TYP_classes_c_c_Class_0);
                @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Class);
                @Nullable Iterator<?> ITERATOR__1 = selectByKind.iterator();
                @NonNull /*@Thrown*/ OrderedSetValue select;
                while (true) {
                    if (!ITERATOR__1.hasNext()) {
                        select = accumulator;
                        break;
                    }
                    @Nullable /*@NonInvalid*/ classes.Class _1 = (classes.Class)ITERATOR__1.next();
                    /**
                     * _'=' : Boolean
                     */
                    if (_1 == null) {
                        throw new InvalidValueException("Null source for \'classes::NamedElement::name\'");
                    }
                    final @Nullable /*@Thrown*/ String name = _1.getName();
                    if (path == null) {
                        throw new InvalidValueException("Null source for \'classescs::NamedElementCS::name\'");
                    }
                    final @Nullable /*@Thrown*/ String name_0 = path.getName();
                    final /*@Thrown*/ boolean eq_1 = (name != null) ? name.equals(name_0) : (name_0 == null);
                    //
                    if (eq_1 == ValueUtil.TRUE_VALUE) {
                        accumulator.add(_1);
                    }
                }
                final @Nullable /*@Thrown*/ classes.Class first = (classes.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(select);
                symbol_14 = first;
            }
            else {
                final @NonNull /*@Thrown*/ IntegerValue diff = (IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1);
                final @NonNull /*@Thrown*/ OrderedSetValue subOrderedSet = OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_pathSeq_0, INT_1, diff);
                final List<PathElementCS> UNBOXED_subOrderedSet = subOrderedSet.asEcoreObjects(idResolver, PathElementCS.class);
                assert UNBOXED_subOrderedSet != null;
                final @NonNull /*@Thrown*/ Package self_7 = this.lookupPackage(symbol_5, UNBOXED_subOrderedSet);
                final @Nullable /*@Thrown*/ Object parent_0 = ClassifierOclContainerOperation.INSTANCE.evaluate(evaluator, self_7);
                final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Package_1 = idResolver.getClass(CLSSid_Package, null);
                final /*@Thrown*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(evaluator, parent_0, TYP_classes_c_c_Package_1).booleanValue();
                @NonNull /*@Thrown*/ Environment symbol_13;
                if (oclIsKindOf) {
                    final @Nullable /*@Thrown*/ Package self_8 = (Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent_0, TYP_classes_c_c_Package_1);
                    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_5 = idResolver.getClass(CLSSid_Environment, null);
                    final @NonNull /*@NonInvalid*/ Property CTORid_namedElements_2 = idResolver.getProperty(PROPid_namedElements);
                    final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements_6 = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
                    final @NonNull /*@Thrown*/ Environment symbol_10 = (Environment)TYP_env_c_c_Environment_5.createInstance();
                    if (self_8 == null) {
                        throw new InvalidValueException("Null source for \'classes::Package::ownedClasses\'");
                    }
                    final @NonNull /*@Thrown*/ Environment self_9 = this.parentEnv(self_8);
                    final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv_1 = idResolver.getProperty(PROPid_parentEnv);
                    final @NonNull /*@Thrown*/ Environment symbol_6 = (Environment)TYP_env_c_c_Environment_5.createInstance();
                    CTORid_parentEnv_1.initValue(symbol_6, self_9);
                    final @Nullable /*@Thrown*/ List<classes.Class> elements_1 = self_8.getOwnedClasses();
                    assert elements_1 != null;
                    final @NonNull /*@Thrown*/ Environment symbol_7 = (Environment)TYP_env_c_c_Environment_5.createInstance();
                    final @NonNull /*@Thrown*/ List<NamedElement> namedElements_7 = (List<NamedElement>)IMPPROPid_namedElements_6.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_6);
                    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_7 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_7);
                    final @NonNull /*@Thrown*/ CollectionValue BOXED_elements_1 = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements_1);
                    final @NonNull /*@Thrown*/ CollectionValue includingAll_2 = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_7, BOXED_elements_1);
                    final List<NamedElement> UNBOXED_includingAll_2 = includingAll_2.asEcoreObjects(idResolver, NamedElement.class);
                    assert UNBOXED_includingAll_2 != null;
                    CTORid_namedElements_2.initValue(symbol_7, UNBOXED_includingAll_2);
                    final @NonNull /*@Thrown*/ List<NamedElement> namedElements_9 = (List<NamedElement>)IMPPROPid_namedElements_6.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_7);
                    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_9 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_9);
                    if (self_8 == null) {
                        throw new InvalidValueException("Null source for \'classes::Package::ownedPackages\'");
                    }
                    final @NonNull /*@Thrown*/ Environment self_10 = this.parentEnv(self_8);
                    final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv_2 = idResolver.getProperty(PROPid_parentEnv);
                    final @NonNull /*@Thrown*/ Environment symbol_8 = (Environment)TYP_env_c_c_Environment_5.createInstance();
                    CTORid_parentEnv_2.initValue(symbol_8, self_10);
                    final @Nullable /*@Thrown*/ List<Package> elements_2 = self_8.getOwnedPackages();
                    assert elements_2 != null;
                    final @NonNull /*@Thrown*/ Environment symbol_9 = (Environment)TYP_env_c_c_Environment_5.createInstance();
                    final @NonNull /*@Thrown*/ List<NamedElement> namedElements_10 = (List<NamedElement>)IMPPROPid_namedElements_6.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_8);
                    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_10 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_10);
                    final @NonNull /*@Thrown*/ CollectionValue BOXED_elements_2 = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements_2);
                    final @NonNull /*@Thrown*/ CollectionValue includingAll_3 = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_10, BOXED_elements_2);
                    final List<NamedElement> UNBOXED_includingAll_3 = includingAll_3.asEcoreObjects(idResolver, NamedElement.class);
                    assert UNBOXED_includingAll_3 != null;
                    CTORid_namedElements_2.initValue(symbol_9, UNBOXED_includingAll_3);
                    final @NonNull /*@Thrown*/ List<NamedElement> namedElements_12 = (List<NamedElement>)IMPPROPid_namedElements_6.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_9);
                    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_12 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_12);
                    final @NonNull /*@Thrown*/ CollectionValue includingAll_4 = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_9, BOXED_namedElements_12);
                    final List<NamedElement> UNBOXED_includingAll_4 = includingAll_4.asEcoreObjects(idResolver, NamedElement.class);
                    assert UNBOXED_includingAll_4 != null;
                    CTORid_namedElements_2.initValue(symbol_10, UNBOXED_includingAll_4);
                    symbol_13 = symbol_10;
                }
                else {
                    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
                    final @Nullable /*@Thrown*/ Root self_11 = (Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(evaluator, parent_0, TYP_classes_c_c_Root_0);
                    if (self_11 == null) {
                        throw new InvalidValueException("Null source for \'classes::Root::ownedPackages\'");
                    }
                    final @NonNull /*@Thrown*/ Environment self_12 = this.parentEnv(self_11);
                    final @NonNull /*@NonInvalid*/ Property CTORid_parentEnv_3 = idResolver.getProperty(PROPid_parentEnv);
                    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_10 = idResolver.getClass(CLSSid_Environment, null);
                    final @NonNull /*@Thrown*/ Environment symbol_11 = (Environment)TYP_env_c_c_Environment_10.createInstance();
                    CTORid_parentEnv_3.initValue(symbol_11, self_12);
                    final @Nullable /*@Thrown*/ List<Package> elements_3 = self_11.getOwnedPackages();
                    assert elements_3 != null;
                    final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_env_c_c_Environment_11 = idResolver.getClass(CLSSid_Environment, null);
                    final @NonNull /*@NonInvalid*/ Property CTORid_namedElements_5 = idResolver.getProperty(PROPid_namedElements);
                    final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements_8 = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
                    final @NonNull /*@Thrown*/ Environment symbol_12 = (Environment)TYP_env_c_c_Environment_11.createInstance();
                    final @NonNull /*@Thrown*/ List<NamedElement> namedElements_14 = (List<NamedElement>)IMPPROPid_namedElements_8.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_11);
                    final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_14 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_14);
                    final @NonNull /*@Thrown*/ CollectionValue BOXED_elements_3 = idResolver.createCollectionOfAll(COL_CLSSid_NamedElement, elements_3);
                    final @NonNull /*@Thrown*/ CollectionValue includingAll_5 = CollectionIncludingAllOperation.INSTANCE.evaluate(BOXED_namedElements_14, BOXED_elements_3);
                    final List<NamedElement> UNBOXED_includingAll_5 = includingAll_5.asEcoreObjects(idResolver, NamedElement.class);
                    assert UNBOXED_includingAll_5 != null;
                    CTORid_namedElements_5.initValue(symbol_12, UNBOXED_includingAll_5);
                    symbol_13 = symbol_12;
                }
                final @Nullable /*@Thrown*/ PathElementCS path_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_pathSeq_0);
                final @NonNull /*@NonInvalid*/ UnboxedExplicitNavigationProperty IMPPROPid_namedElements_9 = new UnboxedExplicitNavigationProperty(PROPid_namedElements);
                final @NonNull /*@Thrown*/ List<NamedElement> namedElements_16 = (List<NamedElement>)IMPPROPid_namedElements_9.evaluate(evaluator, ORD_CLSSid_NamedElement, symbol_13);
                final @NonNull /*@Thrown*/ OrderedSetValue BOXED_namedElements_16 = idResolver.createOrderedSetOfAll(ORD_CLSSid_NamedElement, namedElements_16);
                final @NonNull /*@Thrown*/ OrderedSetValue selectByKind_0 = (OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(evaluator, BOXED_namedElements_16, TYP_classes_c_c_Class_0);
                @NonNull /*@Thrown*/ OrderedSetValue.Accumulator accumulator_0 = ValueUtil.createOrderedSetAccumulatorValue(ORD_CLSSid_Class);
                @Nullable Iterator<?> ITERATOR__1_0 = selectByKind_0.iterator();
                @NonNull /*@Thrown*/ OrderedSetValue select_0;
                while (true) {
                    if (!ITERATOR__1_0.hasNext()) {
                        select_0 = accumulator_0;
                        break;
                    }
                    @Nullable /*@NonInvalid*/ classes.Class _1_0 = (classes.Class)ITERATOR__1_0.next();
                    /**
                     * _'=' : Boolean
                     */
                    if (_1_0 == null) {
                        throw new InvalidValueException("Null source for \'classes::NamedElement::name\'");
                    }
                    final @Nullable /*@Thrown*/ String name_1 = _1_0.getName();
                    if (path_0 == null) {
                        throw new InvalidValueException("Null source for \'classescs::NamedElementCS::name\'");
                    }
                    final @Nullable /*@Thrown*/ String name_2 = path_0.getName();
                    final /*@Thrown*/ boolean eq_2 = (name_1 != null) ? name_1.equals(name_2) : (name_2 == null);
                    //
                    if (eq_2 == ValueUtil.TRUE_VALUE) {
                        accumulator_0.add(_1_0);
                    }
                }
                final @Nullable /*@Thrown*/ classes.Class first_0 = (classes.Class)OrderedCollectionFirstOperation.INSTANCE.evaluate(select_0);
                symbol_14 = first_0;
            }
            symbol_15 = symbol_14;
        }
        oclAsType.setSuperClass(symbol_15);
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
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_PackageCS_2 = idResolver.getClass(CLSSid_PackageCS, null);
        final @NonNull /*@NonInvalid*/ org.eclipse.ocl.pivot.Class TYP_classescs_c_c_RootCS_1 = idResolver.getClass(CLSSid_RootCS, null);
        final @NonNull /*@Thrown*/ SetValue allInstances_5 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_ClassCS, TYP_classescs_c_c_ClassCS_2);
        final @NonNull /*@Thrown*/ SetValue allInstances_2 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_PackageCS, TYP_classescs_c_c_PackageCS_2);
        final @NonNull /*@Thrown*/ SetValue allInstances_1 = ClassifierAllInstancesOperation.INSTANCE.evaluate(evaluator, SET_CLSSid_RootCS, TYP_classescs_c_c_RootCS_1);
        final List<ClassCS> UNBOXED_allInstances_5 = allInstances_5.asEcoreObjects(idResolver, ClassCS.class);
        assert UNBOXED_allInstances_5 != null;
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
        for (PackageCS packageCS_5 : UNBOXED_allInstances_2) {
            if (packageCS_5 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS symbol_5 = (PackageCS)packageCS_5;
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
        for (PackageCS packageCS_6 : UNBOXED_allInstances_2) {
            if (packageCS_6 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS symbol_13 = (PackageCS)packageCS_6;
                uPackage_name(symbol_13);
            }
        }
        ;
        for (ClassCS classCS_5 : UNBOXED_allInstances_5) {
            if (classCS_5 != null) {
                final @NonNull /*@NonInvalid*/ ClassCS symbol_17 = (ClassCS)classCS_5;
                cClassCS_2_Class(symbol_17);
            }
        }
        ;
        for (PackageCS packageCS_7 : UNBOXED_allInstances_2) {
            if (packageCS_7 != null) {
                final @NonNull /*@NonInvalid*/ PackageCS symbol_21 = (PackageCS)packageCS_7;
                uPackage_ownedClasses(symbol_21);
            }
        }
        ;
        for (ClassCS classCS_6 : UNBOXED_allInstances_5) {
            if (classCS_6 != null) {
                final @NonNull /*@NonInvalid*/ ClassCS symbol_25 = (ClassCS)classCS_6;
                uClass_name(symbol_25);
            }
        }
        ;
        for (ClassCS classCS_7 : UNBOXED_allInstances_5) {
            if (classCS_7 != null) {
                final @NonNull /*@NonInvalid*/ ClassCS symbol_29 = (ClassCS)classCS_7;
                uClass_superClass(symbol_29);
            }
        }
        return true;
    }
}
