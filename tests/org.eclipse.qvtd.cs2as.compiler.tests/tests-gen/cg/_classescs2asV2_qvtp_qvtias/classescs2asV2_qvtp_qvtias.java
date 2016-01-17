/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._classescs2asV2_qvtp_qvtias;

import example2.classes.Argument;
import example2.classes.CallExp;
import example2.classes.ClassesFactory;
import example2.classes.ClassesPackage;
import example2.classes.Operation;
import example2.classes.OperationCallExp;
import example2.classes.Package;
import example2.classes.Parameter;
import example2.classes.PropertyCallExp;
import example2.classes.Root;
import example2.classes.lookup.util.ClassesLookupResult;
import example2.classes.lookup.util.ClassesLookupSolver;
import example2.classes.util.Visitable;
import example2.classescs.ArgumentCS;
import example2.classescs.ClassCS;
import example2.classescs.ClassescsPackage;
import example2.classescs.NameExpCS;
import example2.classescs.OperationCS;
import example2.classescs.PackageCS;
import example2.classescs.PathElementCS;
import example2.classescs.PathNameCS;
import example2.classescs.PropertyCS;
import example2.classescs.RootCS;
import example2.classescs.RoundedBracketClause;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractInvocation;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.collection.CollectionSizeOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionFirstOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedCollectionLastOperation;
import org.eclipse.ocl.pivot.library.collection.OrderedSetSubOrderedSetOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.numeric.NumericMinusOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsTypeOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SequenceValue;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.ocl.xtext.base.cs2as.tx.AbstractCS2ASTransformer;
import org.eclipse.qvtd.pivot.qvtimperative.library.model.RootObjectsOperation;

/**
 * The classescs2asV2_qvtp_qvtias transformation:
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
public class classescs2asV2_qvtp_qvtias extends AbstractCS2ASTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classes/1.0", null, ClassesPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example2/classescs/1.0", null, ClassescsPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Argument = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Argument", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ArgumentCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("ArgumentCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_CallExp = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("CallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_ClassCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("ClassCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class_0 = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_EObject = PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getClassId("EObject", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NameExpCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("NameExpCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_NamedElement = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("NamedElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Operation = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Operation", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("OperationCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OperationCallExp = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("OperationCallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Package = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Package", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PackageCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PackageCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Parameter = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Parameter", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PathElementCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathElementCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PathNameCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PathNameCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Property = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Property", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("PropertyCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_PropertyCallExp = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("PropertyCallExp", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Root = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Root", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RootCS = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("RootCS", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_RoundedBracketClause = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classescs_s_1_0.getClassId("RoundedBracketClause", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Visitable = PACKid_http_c_s_s_cs2as_s_tests_s_example2_s_classes_s_1_0.getClassId("Visitable", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_PRIMid_String = TypeId.ORDERED_SET.getSpecializedId(TypeId.STRING);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId COL_CLSSid_ArgumentCS = TypeId.COLLECTION.getSpecializedId(CLSSid_ArgumentCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId COL_CLSSid_ClassCS = TypeId.COLLECTION.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId COL_CLSSid_NameExpCS = TypeId.COLLECTION.getSpecializedId(CLSSid_NameExpCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId COL_CLSSid_OperationCS = TypeId.COLLECTION.getSpecializedId(CLSSid_OperationCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId COL_CLSSid_PackageCS = TypeId.COLLECTION.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId COL_CLSSid_PropertyCS = TypeId.COLLECTION.getSpecializedId(CLSSid_PropertyCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_Argument = TypeId.ORDERED_SET.getSpecializedId(CLSSid_Argument);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ArgumentCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ArgumentCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_ClassCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_NameExpCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_NameExpCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_OperationCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_OperationCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PackageCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PathElementCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PathElementCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId ORD_CLSSid_PropertyCS = TypeId.ORDERED_SET.getSpecializedId(CLSSid_PropertyCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull PropertyId PROPid_name = CLSSid_NamedElement.getPropertyId("name");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Argument = TypeId.SEQUENCE.getSpecializedId(CLSSid_Argument);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_CallExp = TypeId.SEQUENCE.getSpecializedId(CLSSid_CallExp);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Class = TypeId.SEQUENCE.getSpecializedId(CLSSid_Class_0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Operation = TypeId.SEQUENCE.getSpecializedId(CLSSid_Operation);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Package = TypeId.SEQUENCE.getSpecializedId(CLSSid_Package);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Parameter = TypeId.SEQUENCE.getSpecializedId(CLSSid_Parameter);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SEQ_CLSSid_Property = TypeId.SEQUENCE.getSpecializedId(CLSSid_Property);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ArgumentCS = TypeId.SET.getSpecializedId(CLSSid_ArgumentCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_ClassCS = TypeId.SET.getSpecializedId(CLSSid_ClassCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_NameExpCS = TypeId.SET.getSpecializedId(CLSSid_NameExpCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_OperationCS = TypeId.SET.getSpecializedId(CLSSid_OperationCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PackageCS = TypeId.SET.getSpecializedId(CLSSid_PackageCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_PropertyCS = TypeId.SET.getSpecializedId(CLSSid_PropertyCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RootCS = TypeId.SET.getSpecializedId(CLSSid_RootCS);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_RoundedBracketClause = TypeId.SET.getSpecializedId(CLSSid_RoundedBracketClause);
    
    
    protected final /*@NonNull*/ Constructor<MAP_uClass_superClass> CTOR_uClass_superClass;
    protected final /*@NonNull*/ Constructor<MAP_uOperationCallExp_referredOperation> CTOR_uOperationCallExp_referredOperation;
    protected final /*@NonNull*/ Constructor<MAP_uOperationCallExp_type> CTOR_uOperationCallExp_type;
    protected final /*@NonNull*/ Constructor<MAP_uPropertyCallExp_referredProperty> CTOR_uPropertyCallExp_referredProperty;
    protected final /*@NonNull*/ Constructor<MAP_uPropertyCallExp_type> CTOR_uPropertyCallExp_type;
    private final ClassesLookupSolver lookupSolver = new ClassesLookupSolver(executor);
    
    public classescs2asV2_qvtp_qvtias(final /*@NonNull*/ Executor executor) throws ReflectiveOperationException {
        super(executor, new /*@NonNull*/ String[] {"leftCS", "rightAS"}, null, null, null);
        CTOR_uClass_superClass = ClassUtil.nonNullState(MAP_uClass_superClass.class.getConstructor(classescs2asV2_qvtp_qvtias.class, Object[].class));
        CTOR_uOperationCallExp_referredOperation = ClassUtil.nonNullState(MAP_uOperationCallExp_referredOperation.class.getConstructor(classescs2asV2_qvtp_qvtias.class, Object[].class));
        CTOR_uOperationCallExp_type = ClassUtil.nonNullState(MAP_uOperationCallExp_type.class.getConstructor(classescs2asV2_qvtp_qvtias.class, Object[].class));
        CTOR_uPropertyCallExp_referredProperty = ClassUtil.nonNullState(MAP_uPropertyCallExp_referredProperty.class.getConstructor(classescs2asV2_qvtp_qvtias.class, Object[].class));
        CTOR_uPropertyCallExp_type = ClassUtil.nonNullState(MAP_uPropertyCallExp_type.class.getConstructor(classescs2asV2_qvtp_qvtias.class, Object[].class));
    }
    
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    /**
     * classes::Visitable::lookupPackage(segments : OrderedSet(classescs::PathElementCS)) : classes::Package[?]
     * 
     * 
     * if segments->size() = 1
     * then lookupPackage(segments->first())
     * else
     *   let
     *     qualifierSegments : OrderedSet(classescs::PathElementCS) = segments->subOrderedSet(1,
     *       segments->size() - 1)
     *   in
     *     let
     *       qualifier : ::Package[?] = lookupPackage(qualifierSegments)
     *     in qualifier?.lookupQualifiedPackage(segments->last())
     * endif
     */
    public /*@NonInvalid*/ Package lookupPackage(final /*@NonInvalid*/ example2.classes.util.@org.eclipse.jdt.annotation.NonNull Visitable self_0, final /*@NonInvalid*/ List<PathElementCS> segments) {
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments));
        final /*@NonInvalid*/ boolean eq = size.equals(INT_1);
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package symbol_1;
        if (eq) {
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments);
            if (aPathElementCS == null) {
                throw new InvalidValueException("Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
            ClassesLookupResult<Package> _lookupResult = lookupSolver._lookupPackage(self_0, name);
            Package _lookupPackage = null;
            if (_lookupResult.size() == 1) {
                _lookupPackage = _lookupResult.getSingleResult();
            } else {
                handleLookupError(aPathElementCS,name);
            };
            symbol_1 = _lookupPackage;
        }
        else {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments, INT_1, diff));
            final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
            assert UNBOXED_qualifierSegments != null;
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(self_0, UNBOXED_qualifierSegments);
            /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
            try {
                CAUGHT_qualifier = qualifier;
            }
            catch (Exception e) {
                CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package safe_lookupQualifiedPackage_source;
            if (symbol_0 == Boolean.TRUE) {
                safe_lookupQualifiedPackage_source = null;
            }
            else {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments);
                if (aPathElementCS_0 == null) {
                    throw new InvalidValueException("Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                ClassesLookupResult<Package> _lookupResult_0 = lookupSolver._lookupQualifiedPackage(qualifier, name_0);
                Package _lookupQualifiedPackage = null;
                if (_lookupResult_0.size() == 1) {
                    _lookupQualifiedPackage = _lookupResult_0.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS_0,name_0);
                };
                safe_lookupQualifiedPackage_source = _lookupQualifiedPackage;
            }
            symbol_1 = safe_lookupQualifiedPackage_source;
        }
        return symbol_1;
    }
    
    /**
     * 
     * map __root__ in classescs2asV2_qvtp_qvtias {
     * 
     *   where ( |)
     * {roots : Set(OclElement) = leftCS.rootObjects()
     *   ;
     * _'\u00ABchild-ArgumentCS\u00BB' : Set(classescs::ArgumentCS[*|1]) = roots->selectByKind(classescs::ArgumentCS)
     *   ;
     * _'\\u00ABjoin-ArgumentCS-0\\u00BB' : UniqueCollection(classescs::ArgumentCS[*|1]) = _'\u00ABchild-ArgumentCS\u00BB';
     * _'\u00ABchild-ClassCS\u00BB' : Set(classescs::ClassCS[*|1]) = roots->selectByKind(classescs::ClassCS)
     *   ;
     * _'\\u00ABjoin-ClassCS-0\\u00BB' : UniqueCollection(classescs::ClassCS[*|1]) = _'\u00ABchild-ClassCS\u00BB';
     * _'\u00ABchild-NameExpCS\u00BB' : Set(classescs::NameExpCS[*|1]) = roots->selectByKind(classescs::NameExpCS)
     *   ;
     * _'\\u00ABjoin-NameExpCS-0\\u00BB' : UniqueCollection(classescs::NameExpCS[*|1]) = _'\u00ABchild-NameExpCS\u00BB';
     * _'\\u00ABjoin-NameExpCS-1\\u00BB' : UniqueCollection(classescs::NameExpCS[*|1]) = _'\u00ABchild-NameExpCS\u00BB';
     * _'\u00ABchild-OperationCS\u00BB' : Set(classescs::OperationCS[*|1]) = roots->selectByKind(classescs::OperationCS)
     *   ;
     * _'\\u00ABjoin-OperationCS-0\\u00BB' : UniqueCollection(classescs::OperationCS[*|1]) = _'\u00ABchild-OperationCS\u00BB';
     * _'\u00ABchild-PackageCS\u00BB' : Set(classescs::PackageCS[*|1]) = roots->selectByKind(classescs::PackageCS)
     *   ;
     * _'\\u00ABjoin-PackageCS-0\\u00BB' : UniqueCollection(classescs::PackageCS[*|1]) = _'\u00ABchild-PackageCS\u00BB';
     * _'\\u00ABjoin-PackageCS-1\\u00BB' : UniqueCollection(classescs::PackageCS[*|1]) = _'\u00ABchild-PackageCS\u00BB';
     * _'\u00ABchild-PropertyCS\u00BB' : Set(classescs::PropertyCS[*|1]) = roots->selectByKind(classescs::PropertyCS)
     *   ;
     * _'\\u00ABjoin-PropertyCS-0\\u00BB' : UniqueCollection(classescs::PropertyCS[*|1]) = _'\u00ABchild-PropertyCS\u00BB';
     * _'\u00ABchild-RootCS\u00BB' : Set(classescs::RootCS[*|1]) = roots->selectByKind(classescs::RootCS)
     *   ;
     * _'\\u00ABjoin-RootCS-0\\u00BB' : Set(classescs::RootCS[*|1]) = _'\u00ABchild-RootCS\u00BB';
     * _'\u00ABchild-RoundedBracketClause\u00BB' : Set(classescs::RoundedBracketClause[*|1]) = roots->selectByKind(classescs::RoundedBracketClause)
     *   ;
     * _'\\u00ABjoin-RoundedBracketClause-0\\u00BB' : Set(classescs::RoundedBracketClause[*|1]) = _'\u00ABchild-RoundedBracketClause\u00BB';
     *  |}
     * for loop0 : classescs::RootCS in _'\\u00ABjoin-RootCS-0\\u00BB' {
     * 
     *     map _'classescs%RootCS%ownedPackages' {
     * _'\\u00ABjoin-PackageCS-0\\u00BB' := _'\\u00ABjoin-PackageCS-0\\u00BB';
     * _'\\u00ABjoin-PackageCS-1\\u00BB' := _'\\u00ABjoin-PackageCS-1\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in _'\\u00ABjoin-PackageCS-1\\u00BB' {
     * 
     *     map _'classescs%PackageCS%ownedPackages' {
     * _'\\u00ABjoin-PackageCS-0\\u00BB' := _'\\u00ABjoin-PackageCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in _'\\u00ABjoin-PackageCS-0\\u00BB' {
     * 
     *     map _'classescs%PackageCS%ownedClasses' {
     * _'\\u00ABjoin-ClassCS-0\\u00BB' := _'\\u00ABjoin-ClassCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in _'\\u00ABjoin-ClassCS-0\\u00BB' {
     * 
     *     map _'classescs%ClassCS%operations' {
     * _'\\u00ABjoin-OperationCS-0\\u00BB' := _'\\u00ABjoin-OperationCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in _'\\u00ABjoin-ClassCS-0\\u00BB' {
     * 
     *     map _'classescs%ClassCS%properties' {
     * _'\\u00ABjoin-PropertyCS-0\\u00BB' := _'\\u00ABjoin-PropertyCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::OperationCS in _'\\u00ABjoin-OperationCS-0\\u00BB' {
     * 
     *     map _'classescs%OperationCS%bodyExps' {
     * _'\\u00ABjoin-NameExpCS-0\\u00BB' := _'\\u00ABjoin-NameExpCS-0\\u00BB';
     * _'\\u00ABjoin-NameExpCS-1\\u00BB' := _'\\u00ABjoin-NameExpCS-1\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-1\\u00BB' {
     * 
     *     map _'classescs%NameExpCS%ownedNameExp' {
     * _'\\u00ABjoin-NameExpCS-0\\u00BB' := _'\\u00ABjoin-NameExpCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map _'classescs%NameExpCS%roundedBrackets' {
     * _'\\u00ABjoin-RoundedBracketClause-0\\u00BB' := _'\\u00ABjoin-RoundedBracketClause-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::RoundedBracketClause in _'\\u00ABjoin-RoundedBracketClause-0\\u00BB' {
     * 
     *     map _'classescs%RoundedBracketClause%args' {
     * _'\\u00ABjoin-ArgumentCS-0\\u00BB' := _'\\u00ABjoin-ArgumentCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := loop0;
     * }}
     *   for loop0 : classescs::ArgumentCS in _'\\u00ABjoin-ArgumentCS-0\\u00BB' {
     * 
     *     map cArgumentCS_2_Argument {
     * argumentCS := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in _'\\u00ABjoin-ClassCS-0\\u00BB' {
     * 
     *     map cClassCS_2_Class {
     * classCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map cNameExpCS_2_OperationCallExp {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map cNameExpCS_2_PropertyCallExp {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::OperationCS in _'\\u00ABjoin-OperationCS-0\\u00BB' {
     * 
     *     map cOperationCS_2_Operation {
     * operationCS := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in _'\\u00ABjoin-PackageCS-0\\u00BB' {
     * 
     *     map cPackageCS_2_Package {
     * packageCS := loop0;
     * }}
     *   for loop0 : classescs::PropertyCS in _'\\u00ABjoin-PropertyCS-0\\u00BB' {
     * 
     *     map cPropertyCS_2_Property {
     * propertyCS := loop0;
     * }}
     *   for loop0 : classescs::RootCS in _'\\u00ABjoin-RootCS-0\\u00BB' {
     * 
     *     map cRootCS_2_Root {
     * rootCS := loop0;
     * }}
     *   for loop0 : classescs::ArgumentCS in _'\\u00ABjoin-ArgumentCS-0\\u00BB' {
     * 
     *     map uArgument_name {
     * argumentCS := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in _'\\u00ABjoin-ClassCS-0\\u00BB' {
     * 
     *     map _'uClass_name\\nuClass_ownedOperations\\nuClass_ownedProperties' {
     * classCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map uOperationCallExp_ownedArguments {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map uOperationCallExp_ownedCallExp {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::OperationCS in _'\\u00ABjoin-OperationCS-0\\u00BB' {
     * 
     *     map _'uOperation_name\\nuOperation_ownedExpressions\\nuOperation_ownedParameters' {
     * operationCS := loop0;
     * }}
     *   for loop0 : classescs::PackageCS in _'\\u00ABjoin-PackageCS-0\\u00BB' {
     * 
     *     map _'uPackage_name\\nuPackage_ownedClasses\\nuPackage_ownedPackages' {
     * packageCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map uPropertyCallExp_ownedCallExp {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::PropertyCS in _'\\u00ABjoin-PropertyCS-0\\u00BB' {
     * 
     *     map uProperty_name {
     * propertyCS := loop0;
     * }}
     *   for loop0 : classescs::RootCS in _'\\u00ABjoin-RootCS-0\\u00BB' {
     * 
     *     map uRoot_ownedPackages {
     * rootCS := loop0;
     * }}
     *   for loop0 : classescs::ClassCS in _'\\u00ABjoin-ClassCS-0\\u00BB' {
     * 
     *     map uClass_superClass {
     * classCS := loop0;
     * }}
     *   for loop0 : classescs::OperationCS in _'\\u00ABjoin-OperationCS-0\\u00BB' {
     * 
     *     map uOperation_type {
     * operationCS := loop0;
     * }}
     *   for loop0 : classescs::PropertyCS in _'\\u00ABjoin-PropertyCS-0\\u00BB' {
     * 
     *     map uProperty_type {
     * propertyCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map uOperationCallExp_referredOperation {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map uOperationCallExp_type {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map uPropertyCallExp_referredProperty {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map uPropertyCallExp_type {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map uOperationCallExp_referredOperation {
     * nameExpCS := loop0;
     * }}
     *   for loop0 : classescs::NameExpCS in _'\\u00ABjoin-NameExpCS-0\\u00BB' {
     * 
     *     map uPropertyCallExp_referredProperty {
     * nameExpCS := loop0;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ArgumentCS_0 = idResolver.getClass(CLSSid_ArgumentCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ClassCS_0 = idResolver.getClass(CLSSid_ClassCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_NameExpCS_0 = idResolver.getClass(CLSSid_NameExpCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_OperationCS_0 = idResolver.getClass(CLSSid_OperationCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PackageCS_0 = idResolver.getClass(CLSSid_PackageCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PropertyCS_0 = idResolver.getClass(CLSSid_PropertyCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_RootCS_0 = idResolver.getClass(CLSSid_RootCS, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_RoundedBracketClause_0 = idResolver.getClass(CLSSid_RoundedBracketClause, null);
        // variable assignments
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue rootObjects = ClassUtil.nonNullState(RootObjectsOperation.INSTANCE.evaluate(executor, SET_CLSSid_OclElement, models[0/*leftCS*/]));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_ArgumentCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_0 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_ClassCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_1 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_NameExpCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_2 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_OperationCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_3 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_PackageCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_4 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_PropertyCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_5 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_RootCS_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_6 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_classescs_c_c_RoundedBracketClause_0));
        // connection variables
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_ArgumentCS_m_0_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_ArgumentCS);
        for (ArgumentCS iterator : ValueUtil.typedIterable(ArgumentCS.class, selectByKind)) {
            _92_u00ABjoin_m_ArgumentCS_m_0_92_u00BB_1.add(iterator);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_ClassCS);
        for (ClassCS iterator_0 : ValueUtil.typedIterable(ClassCS.class, selectByKind_0)) {
            _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1.add(iterator_0);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_NameExpCS);
        for (NameExpCS iterator_1 : ValueUtil.typedIterable(NameExpCS.class, selectByKind_1)) {
            _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3.add(iterator_1);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_NameExpCS_m_1_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_NameExpCS);
        for (NameExpCS iterator_2 : ValueUtil.typedIterable(NameExpCS.class, selectByKind_1)) {
            _92_u00ABjoin_m_NameExpCS_m_1_92_u00BB_1.add(iterator_2);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_OperationCS_m_0_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_OperationCS);
        for (OperationCS iterator_3 : ValueUtil.typedIterable(OperationCS.class, selectByKind_2)) {
            _92_u00ABjoin_m_OperationCS_m_0_92_u00BB_1.add(iterator_3);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_PackageCS);
        for (PackageCS iterator_4 : ValueUtil.typedIterable(PackageCS.class, selectByKind_3)) {
            _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3.add(iterator_4);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_1_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_PackageCS);
        for (PackageCS iterator_5 : ValueUtil.typedIterable(PackageCS.class, selectByKind_3)) {
            _92_u00ABjoin_m_PackageCS_m_1_92_u00BB_1.add(iterator_5);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PropertyCS_m_0_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_PropertyCS);
        for (PropertyCS iterator_6 : ValueUtil.typedIterable(PropertyCS.class, selectByKind_4)) {
            _92_u00ABjoin_m_PropertyCS_m_0_92_u00BB_1.add(iterator_6);
        }
        final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_RoundedBracketClause_m_0_92_u00BB_1 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_RoundedBracketClause);
        for (RoundedBracketClause iterator_7 : ValueUtil.typedIterable(RoundedBracketClause.class, selectByKind_6)) {
            _92_u00ABjoin_m_RoundedBracketClause_m_0_92_u00BB_1.add(iterator_7);
        }
        // mapping statements
        for (RootCS loop0 : ValueUtil.typedIterable(RootCS.class, selectByKind_5)) {
            if (loop0 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS symbol_0 = (RootCS)loop0;
                MAP_classescs_37RootCS_37ownedPackages(_92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3, _92_u00ABjoin_m_PackageCS_m_1_92_u00BB_1, symbol_0);
            }
        }
        for (PackageCS loop0_0 : ValueUtil.typedIterable(PackageCS.class, _92_u00ABjoin_m_PackageCS_m_1_92_u00BB_1)) {
            if (loop0_0 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_2 = (PackageCS)loop0_0;
                MAP_classescs_37PackageCS_37ownedPackages(_92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3, symbol_2);
            }
        }
        for (PackageCS loop0_1 : ValueUtil.typedIterable(PackageCS.class, _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3)) {
            if (loop0_1 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_4 = (PackageCS)loop0_1;
                MAP_classescs_37PackageCS_37ownedClasses(_92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1, symbol_4);
            }
        }
        for (ClassCS loop0_2 : ValueUtil.typedIterable(ClassCS.class, _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1)) {
            if (loop0_2 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_6 = (ClassCS)loop0_2;
                MAP_classescs_37ClassCS_37operations(_92_u00ABjoin_m_OperationCS_m_0_92_u00BB_1, symbol_6);
            }
        }
        for (ClassCS loop0_3 : ValueUtil.typedIterable(ClassCS.class, _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1)) {
            if (loop0_3 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_8 = (ClassCS)loop0_3;
                MAP_classescs_37ClassCS_37properties(_92_u00ABjoin_m_PropertyCS_m_0_92_u00BB_1, symbol_8);
            }
        }
        for (OperationCS loop0_4 : ValueUtil.typedIterable(OperationCS.class, _92_u00ABjoin_m_OperationCS_m_0_92_u00BB_1)) {
            if (loop0_4 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS symbol_10 = (OperationCS)loop0_4;
                MAP_classescs_37OperationCS_37bodyExps(_92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3, _92_u00ABjoin_m_NameExpCS_m_1_92_u00BB_1, symbol_10);
            }
        }
        for (NameExpCS loop0_5 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_1_92_u00BB_1)) {
            if (loop0_5 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_12 = (NameExpCS)loop0_5;
                MAP_classescs_37NameExpCS_37ownedNameExp(_92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3, symbol_12);
            }
        }
        for (NameExpCS loop0_6 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_6 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_14 = (NameExpCS)loop0_6;
                MAP_classescs_37NameExpCS_37roundedBrackets(_92_u00ABjoin_m_RoundedBracketClause_m_0_92_u00BB_1, symbol_14);
            }
        }
        for (RoundedBracketClause loop0_7 : ValueUtil.typedIterable(RoundedBracketClause.class, _92_u00ABjoin_m_RoundedBracketClause_m_0_92_u00BB_1)) {
            if (loop0_7 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RoundedBracketClause symbol_16 = (RoundedBracketClause)loop0_7;
                MAP_classescs_37RoundedBracketClause_37args(_92_u00ABjoin_m_ArgumentCS_m_0_92_u00BB_1, symbol_16);
            }
        }
        for (ArgumentCS loop0_8 : ValueUtil.typedIterable(ArgumentCS.class, _92_u00ABjoin_m_ArgumentCS_m_0_92_u00BB_1)) {
            if (loop0_8 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ArgumentCS symbol_18 = (ArgumentCS)loop0_8;
                if (symbol_18 != null) {
                    MAP_cArgumentCS_2_Argument(symbol_18);
                }
            }
        }
        for (ClassCS loop0_9 : ValueUtil.typedIterable(ClassCS.class, _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1)) {
            if (loop0_9 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_20 = (ClassCS)loop0_9;
                if (symbol_20 != null) {
                    MAP_cClassCS_2_Class(symbol_20);
                }
            }
        }
        for (NameExpCS loop0_10 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_10 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_22 = (NameExpCS)loop0_10;
                if (symbol_22 != null) {
                    MAP_cNameExpCS_2_OperationCallExp(symbol_22);
                }
            }
        }
        for (NameExpCS loop0_11 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_11 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_24 = (NameExpCS)loop0_11;
                if (symbol_24 != null) {
                    MAP_cNameExpCS_2_PropertyCallExp(symbol_24);
                }
            }
        }
        for (OperationCS loop0_12 : ValueUtil.typedIterable(OperationCS.class, _92_u00ABjoin_m_OperationCS_m_0_92_u00BB_1)) {
            if (loop0_12 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS symbol_26 = (OperationCS)loop0_12;
                if (symbol_26 != null) {
                    MAP_cOperationCS_2_Operation(symbol_26);
                }
            }
        }
        for (PackageCS loop0_13 : ValueUtil.typedIterable(PackageCS.class, _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3)) {
            if (loop0_13 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_28 = (PackageCS)loop0_13;
                if (symbol_28 != null) {
                    MAP_cPackageCS_2_Package(symbol_28);
                }
            }
        }
        for (PropertyCS loop0_14 : ValueUtil.typedIterable(PropertyCS.class, _92_u00ABjoin_m_PropertyCS_m_0_92_u00BB_1)) {
            if (loop0_14 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS symbol_30 = (PropertyCS)loop0_14;
                if (symbol_30 != null) {
                    MAP_cPropertyCS_2_Property(symbol_30);
                }
            }
        }
        for (RootCS loop0_15 : ValueUtil.typedIterable(RootCS.class, selectByKind_5)) {
            if (loop0_15 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS symbol_32 = (RootCS)loop0_15;
                if (symbol_32 != null) {
                    MAP_cRootCS_2_Root(symbol_32);
                }
            }
        }
        for (ArgumentCS loop0_16 : ValueUtil.typedIterable(ArgumentCS.class, _92_u00ABjoin_m_ArgumentCS_m_0_92_u00BB_1)) {
            if (loop0_16 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ArgumentCS symbol_34 = (ArgumentCS)loop0_16;
                if (symbol_34 != null) {
                    MAP_uArgument_name(symbol_34);
                }
            }
        }
        for (ClassCS loop0_17 : ValueUtil.typedIterable(ClassCS.class, _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1)) {
            if (loop0_17 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_36 = (ClassCS)loop0_17;
                if (symbol_36 != null) {
                    MAP_uClass_name_92nuClass_ownedOperations_92nuClass_ownedProperties(symbol_36);
                }
            }
        }
        for (NameExpCS loop0_18 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_18 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_38 = (NameExpCS)loop0_18;
                if (symbol_38 != null) {
                    MAP_uOperationCallExp_ownedArguments(symbol_38);
                }
            }
        }
        for (NameExpCS loop0_19 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_19 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_40 = (NameExpCS)loop0_19;
                if (symbol_40 != null) {
                    MAP_uOperationCallExp_ownedCallExp(symbol_40);
                }
            }
        }
        for (OperationCS loop0_20 : ValueUtil.typedIterable(OperationCS.class, _92_u00ABjoin_m_OperationCS_m_0_92_u00BB_1)) {
            if (loop0_20 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS symbol_42 = (OperationCS)loop0_20;
                if (symbol_42 != null) {
                    MAP_uOperation_name_92nuOperation_ownedExpressions_92nuOperation_ownedParameters(symbol_42);
                }
            }
        }
        for (PackageCS loop0_21 : ValueUtil.typedIterable(PackageCS.class, _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_3)) {
            if (loop0_21 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_44 = (PackageCS)loop0_21;
                if (symbol_44 != null) {
                    MAP_uPackage_name_92nuPackage_ownedClasses_92nuPackage_ownedPackages(symbol_44);
                }
            }
        }
        for (NameExpCS loop0_22 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_22 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_46 = (NameExpCS)loop0_22;
                if (symbol_46 != null) {
                    MAP_uPropertyCallExp_ownedCallExp(symbol_46);
                }
            }
        }
        for (PropertyCS loop0_23 : ValueUtil.typedIterable(PropertyCS.class, _92_u00ABjoin_m_PropertyCS_m_0_92_u00BB_1)) {
            if (loop0_23 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS symbol_48 = (PropertyCS)loop0_23;
                if (symbol_48 != null) {
                    MAP_uProperty_name(symbol_48);
                }
            }
        }
        for (RootCS loop0_24 : ValueUtil.typedIterable(RootCS.class, selectByKind_5)) {
            if (loop0_24 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS symbol_50 = (RootCS)loop0_24;
                if (symbol_50 != null) {
                    MAP_uRoot_ownedPackages(symbol_50);
                }
            }
        }
        for (ClassCS loop0_25 : ValueUtil.typedIterable(ClassCS.class, _92_u00ABjoin_m_ClassCS_m_0_92_u00BB_1)) {
            if (loop0_25 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS symbol_52 = (ClassCS)loop0_25;
                if (symbol_52 != null) {
                    invoke(CTOR_uClass_superClass, symbol_52);
                }
            }
        }
        for (OperationCS loop0_26 : ValueUtil.typedIterable(OperationCS.class, _92_u00ABjoin_m_OperationCS_m_0_92_u00BB_1)) {
            if (loop0_26 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS symbol_54 = (OperationCS)loop0_26;
                if (symbol_54 != null) {
                    MAP_uOperation_type(symbol_54);
                }
            }
        }
        for (PropertyCS loop0_27 : ValueUtil.typedIterable(PropertyCS.class, _92_u00ABjoin_m_PropertyCS_m_0_92_u00BB_1)) {
            if (loop0_27 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS symbol_56 = (PropertyCS)loop0_27;
                if (symbol_56 != null) {
                    MAP_uProperty_type(symbol_56);
                }
            }
        }
        for (NameExpCS loop0_28 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_28 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_58 = (NameExpCS)loop0_28;
                if (symbol_58 != null) {
                    invoke(CTOR_uOperationCallExp_referredOperation, symbol_58);
                }
            }
        }
        for (NameExpCS loop0_29 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_29 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_60 = (NameExpCS)loop0_29;
                if (symbol_60 != null) {
                    invoke(CTOR_uOperationCallExp_type, symbol_60);
                }
            }
        }
        for (NameExpCS loop0_30 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_30 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_62 = (NameExpCS)loop0_30;
                if (symbol_62 != null) {
                    invoke(CTOR_uPropertyCallExp_referredProperty, symbol_62);
                }
            }
        }
        for (NameExpCS loop0_31 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_31 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_64 = (NameExpCS)loop0_31;
                if (symbol_64 != null) {
                    invoke(CTOR_uPropertyCallExp_type, symbol_64);
                }
            }
        }
        for (NameExpCS loop0_32 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_32 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_66 = (NameExpCS)loop0_32;
                if (symbol_66 != null) {
                    invoke(CTOR_uOperationCallExp_referredOperation, symbol_66);
                }
            }
        }
        for (NameExpCS loop0_33 : ValueUtil.typedIterable(NameExpCS.class, _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_3)) {
            if (loop0_33 != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_68 = (NameExpCS)loop0_33;
                if (symbol_68 != null) {
                    invoke(CTOR_uPropertyCallExp_referredProperty, symbol_68);
                }
            }
        }
        return true;
    }
    
    /**
     * 
     * map cArgumentCS_2_Argument in classescs2asV2_qvtp_qvtias {
     * leftCS (argumentCS : classescs::ArgumentCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize argument : classes::Argument[1];
     *  |}
     * where ( |)
     * { |
     * argumentCS.ast := argument;
     * }
     * 
     */
    protected boolean MAP_cArgumentCS_2_Argument(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ArgumentCS argumentCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Argument argument = ClassesFactory.eINSTANCE.createArgument();
        assert argument != null;
        models[1/*rightAS*/].add(argument);
        // property assignments
        argumentCS.setAst(argument);
        return true;
    }
    
    /**
     * 
     * map cClassCS_2_Class in classescs2asV2_qvtp_qvtias {
     * leftCS (classCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize class : classes::Class[1];
     *  |}
     * where ( |)
     * { |
     * classCS.ast := class;
     * }
     * 
     */
    protected boolean MAP_cClassCS_2_Class(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS classCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_0 = ClassesFactory.eINSTANCE.createClass();
        assert symbol_0 != null;
        models[1/*rightAS*/].add(symbol_0);
        // property assignments
        classCS.setAst(symbol_0);
        return true;
    }
    
    /**
     * 
     * map cNameExpCS_2_OperationCallExp in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize operationCallExp : classes::OperationCallExp[1];
     *  |}
     * where ( |
     * nameExpCS.isOpCallExp())
     * { |
     * nameExpCS.ast := operationCallExp;
     * }
     * 
     */
    protected boolean MAP_cNameExpCS_2_OperationCallExp(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS) throws ReflectiveOperationException {
        // predicates
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets != null;
        if (ne != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable OperationCallExp operationCallExp = ClassesFactory.eINSTANCE.createOperationCallExp();
        assert operationCallExp != null;
        models[1/*rightAS*/].add(operationCallExp);
        // property assignments
        nameExpCS.setAst(operationCallExp);
        return true;
    }
    
    /**
     * 
     * map cNameExpCS_2_PropertyCallExp in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize propertyCallExp : classes::PropertyCallExp[1];
     *  |}
     * where ( |
     * nameExpCS.isPropCallExp()
     *   not nameExpCS.isOpCallExp())
     * { |
     * nameExpCS.ast := propertyCallExp;
     * }
     * 
     */
    protected boolean MAP_cNameExpCS_2_PropertyCallExp(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_0.getRoundedBrackets();
        final /*@Thrown*/ boolean eq = roundedBrackets == null;
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS_0.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets_0 != null;
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(ne);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable PropertyCallExp propertyCallExp = ClassesFactory.eINSTANCE.createPropertyCallExp();
        assert propertyCallExp != null;
        models[1/*rightAS*/].add(propertyCallExp);
        // property assignments
        nameExpCS_0.setAst(propertyCallExp);
        return true;
    }
    
    /**
     * 
     * map cOperationCS_2_Operation in classescs2asV2_qvtp_qvtias {
     * leftCS (operationCS : classescs::OperationCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize operation : classes::Operation[1];
     *  |}
     * where ( |)
     * { |
     * operationCS.ast := operation;
     * }
     * 
     */
    protected boolean MAP_cOperationCS_2_Operation(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS operationCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation operation = ClassesFactory.eINSTANCE.createOperation();
        assert operation != null;
        models[1/*rightAS*/].add(operation);
        // property assignments
        operationCS.setAst(operation);
        return true;
    }
    
    /**
     * 
     * map cPackageCS_2_Package in classescs2asV2_qvtp_qvtias {
     * leftCS (packageCS : classescs::PackageCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize package : classes::Package[1];
     *  |}
     * where ( |)
     * { |
     * packageCS.ast := package;
     * }
     * 
     */
    protected boolean MAP_cPackageCS_2_Package(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS packageCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package symbol_0 = ClassesFactory.eINSTANCE.createPackage();
        assert symbol_0 != null;
        models[1/*rightAS*/].add(symbol_0);
        // property assignments
        packageCS.setAst(symbol_0);
        return true;
    }
    
    /**
     * 
     * map cPropertyCS_2_Property in classescs2asV2_qvtp_qvtias {
     * leftCS (propertyCS : classescs::PropertyCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize property : classes::Property[1];
     *  |}
     * where ( |)
     * { |
     * propertyCS.ast := property;
     * }
     * 
     */
    protected boolean MAP_cPropertyCS_2_Property(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS propertyCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property property = ClassesFactory.eINSTANCE.createProperty();
        assert property != null;
        models[1/*rightAS*/].add(property);
        // property assignments
        propertyCS.setAst(property);
        return true;
    }
    
    /**
     * 
     * map cRootCS_2_Root in classescs2asV2_qvtp_qvtias {
     * leftCS (rootCS : classescs::RootCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * {realize root : classes::Root[1];
     *  |}
     * where ( |)
     * { |
     * rootCS.ast := root;
     * }
     * 
     */
    protected boolean MAP_cRootCS_2_Root(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS rootCS) throws ReflectiveOperationException {
        // predicates
        // creations
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Root root = ClassesFactory.eINSTANCE.createRoot();
        assert root != null;
        models[1/*rightAS*/].add(root);
        // property assignments
        rootCS.setAst(root);
        return true;
    }
    
    /**
     * 
     * map _'classescs%ClassCS%operations' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::ClassCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-OperationCS-0\\u00BB' : UniqueCollection(classescs::OperationCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::OperationCS) = _'\\u00ABparent\\u00BB'.operations->selectByKind(classescs::OperationCS)
     *   ;
     * _'\u00ABchild-OperationCS\u00BB' : OrderedSet(classescs::OperationCS[*|1]) = allChildren->selectByKind(classescs::OperationCS);
     *  |
     * _'\\u00ABjoin-OperationCS-0\\u00BB' += _'\u00ABchild-OperationCS\u00BB';
     * }
     * 
     */
    protected boolean MAP_classescs_37ClassCS_37operations(final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_OperationCS_m_0_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS _92_u00ABparent_92_u00BB) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_OperationCS_1 = idResolver.getClass(CLSSid_OperationCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<OperationCS> operations = _92_u00ABparent_92_u00BB.getOperations();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_operations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, operations);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_operations, TYP_classescs_c_c_OperationCS_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_OperationCS_1));
        // connection assignments
        for (OperationCS iterator : ValueUtil.typedIterable(OperationCS.class, selectByKind_0)) {
            if (iterator instanceof OperationCS) {
                _92_u00ABjoin_m_OperationCS_m_0_92_u00BB.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs%ClassCS%properties' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::ClassCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-PropertyCS-0\\u00BB' : UniqueCollection(classescs::PropertyCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::PropertyCS) = _'\\u00ABparent\\u00BB'.properties->selectByKind(classescs::PropertyCS)
     *   ;
     * _'\u00ABchild-PropertyCS\u00BB' : OrderedSet(classescs::PropertyCS[*|1]) = allChildren->selectByKind(classescs::PropertyCS);
     *  |
     * _'\\u00ABjoin-PropertyCS-0\\u00BB' += _'\u00ABchild-PropertyCS\u00BB';
     * }
     * 
     */
    protected boolean MAP_classescs_37ClassCS_37properties(final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PropertyCS_m_0_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS _92_u00ABparent_92_u00BB_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PropertyCS_1 = idResolver.getClass(CLSSid_PropertyCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PropertyCS> properties = _92_u00ABparent_92_u00BB_0.getProperties();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_properties = idResolver.createOrderedSetOfAll(ORD_CLSSid_PropertyCS, properties);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_properties, TYP_classescs_c_c_PropertyCS_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_PropertyCS_1));
        // connection assignments
        for (PropertyCS iterator : ValueUtil.typedIterable(PropertyCS.class, selectByKind_0)) {
            if (iterator instanceof PropertyCS) {
                _92_u00ABjoin_m_PropertyCS_m_0_92_u00BB.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs%NameExpCS%ownedNameExp' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::NameExpCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-NameExpCS-0\\u00BB' : UniqueCollection(classescs::NameExpCS[*|1]);
     *  |)
     * {allChildren : Set(classescs::NameExpCS[*|1]) = _'\\u00ABparent\\u00BB'.ownedNameExp.oclAsSet()
     *   ;
     * _'\u00ABchild-NameExpCS\u00BB' : Set(classescs::NameExpCS[*|1]) = allChildren->selectByKind(classescs::NameExpCS)
     *   ;
     *  |
     * _'\\u00ABjoin-NameExpCS-0\\u00BB' += _'\u00ABchild-NameExpCS\u00BB';
     * }
     * for aChild : classescs::NameExpCS in allChildren {
     * 
     *     map _'classescs%NameExpCS%ownedNameExp' {
     * _'\\u00ABjoin-NameExpCS-0\\u00BB' := _'\\u00ABjoin-NameExpCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := aChild;
     * }}
     */
    protected boolean MAP_classescs_37NameExpCS_37ownedNameExp(final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS _92_u00ABparent_92_u00BB_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_NameExpCS_0 = idResolver.getClass(CLSSid_NameExpCS, null);
        // variable assignments
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable NameExpCS ownedNameExp = _92_u00ABparent_92_u00BB_1.getOwnedNameExp();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = ClassUtil.nonNullState(OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_NameExpCS, ownedNameExp));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_classescs_c_c_NameExpCS_0));
        // connection assignments
        for (NameExpCS iterator : ValueUtil.typedIterable(NameExpCS.class, selectByKind)) {
            if (iterator instanceof NameExpCS) {
                _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB.add(iterator);
            }
        }
        // mapping statements
        for (NameExpCS aChild : ValueUtil.typedIterable(NameExpCS.class, oclAsSet)) {
            if (aChild != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS symbol_0 = (NameExpCS)aChild;
                MAP_classescs_37NameExpCS_37ownedNameExp(_92_u00ABjoin_m_NameExpCS_m_0_92_u00BB, symbol_0);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs%NameExpCS%roundedBrackets' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::NameExpCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-RoundedBracketClause-0\\u00BB' : Set(classescs::RoundedBracketClause[*|1]);
     *  |)
     * {allChildren : Set(classescs::RoundedBracketClause[*|1]) = _'\\u00ABparent\\u00BB'.roundedBrackets.oclAsSet()
     *   ;
     * _'\u00ABchild-RoundedBracketClause\u00BB' : Set(classescs::RoundedBracketClause[*|1]) = allChildren->selectByKind(classescs::RoundedBracketClause);
     *  |
     * _'\\u00ABjoin-RoundedBracketClause-0\\u00BB' += _'\u00ABchild-RoundedBracketClause\u00BB';
     * }
     * 
     */
    protected boolean MAP_classescs_37NameExpCS_37roundedBrackets(final SetValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_RoundedBracketClause_m_0_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS _92_u00ABparent_92_u00BB_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_RoundedBracketClause_0 = idResolver.getClass(CLSSid_RoundedBracketClause, null);
        // variable assignments
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = _92_u00ABparent_92_u00BB_2.getRoundedBrackets();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = ClassUtil.nonNullState(OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_RoundedBracketClause, roundedBrackets));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_classescs_c_c_RoundedBracketClause_0));
        // connection assignments
        for (RoundedBracketClause iterator : ValueUtil.typedIterable(RoundedBracketClause.class, selectByKind)) {
            if (iterator instanceof RoundedBracketClause) {
                _92_u00ABjoin_m_RoundedBracketClause_m_0_92_u00BB.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs%OperationCS%bodyExps' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::OperationCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-NameExpCS-1\\u00BB' : UniqueCollection(classescs::NameExpCS[*|1]);
     * _'\\u00ABjoin-NameExpCS-0\\u00BB' : UniqueCollection(classescs::NameExpCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::NameExpCS) = _'\\u00ABparent\\u00BB'.bodyExps->selectByKind(classescs::NameExpCS)
     *   ;
     * _'\u00ABchild-NameExpCS\u00BB' : OrderedSet(classescs::NameExpCS[*|1]) = allChildren->selectByKind(classescs::NameExpCS);
     *  |
     * _'\\u00ABjoin-NameExpCS-1\\u00BB' += _'\u00ABchild-NameExpCS\u00BB';
     * _'\\u00ABjoin-NameExpCS-0\\u00BB' += _'\u00ABchild-NameExpCS\u00BB';
     * }
     * 
     */
    protected boolean MAP_classescs_37OperationCS_37bodyExps(final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_0, final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_NameExpCS_m_1_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS _92_u00ABparent_92_u00BB_3) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_NameExpCS_1 = idResolver.getClass(CLSSid_NameExpCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<NameExpCS> bodyExps = _92_u00ABparent_92_u00BB_3.getBodyExps();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_bodyExps = idResolver.createOrderedSetOfAll(ORD_CLSSid_NameExpCS, bodyExps);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_bodyExps, TYP_classescs_c_c_NameExpCS_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_NameExpCS_1));
        // connection assignments
        for (NameExpCS iterator : ValueUtil.typedIterable(NameExpCS.class, selectByKind_0)) {
            if (iterator instanceof NameExpCS) {
                _92_u00ABjoin_m_NameExpCS_m_1_92_u00BB.add(iterator);
            }
        }
        for (NameExpCS iterator_0 : ValueUtil.typedIterable(NameExpCS.class, selectByKind_0)) {
            if (iterator_0 instanceof NameExpCS) {
                _92_u00ABjoin_m_NameExpCS_m_0_92_u00BB_0.add(iterator_0);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs%PackageCS%ownedClasses' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::PackageCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-ClassCS-0\\u00BB' : UniqueCollection(classescs::ClassCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::ClassCS) = _'\\u00ABparent\\u00BB'.ownedClasses->selectByKind(classescs::ClassCS)
     *   ;
     * _'\u00ABchild-ClassCS\u00BB' : OrderedSet(classescs::ClassCS[*|1]) = allChildren->selectByKind(classescs::ClassCS);
     *  |
     * _'\\u00ABjoin-ClassCS-0\\u00BB' += _'\u00ABchild-ClassCS\u00BB';
     * }
     * 
     */
    protected boolean MAP_classescs_37PackageCS_37ownedClasses(final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_ClassCS_m_0_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS _92_u00ABparent_92_u00BB_4) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ClassCS_1 = idResolver.getClass(CLSSid_ClassCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ClassCS> ownedClasses = _92_u00ABparent_92_u00BB_4.getOwnedClasses();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_ownedClasses, TYP_classescs_c_c_ClassCS_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_ClassCS_1));
        // connection assignments
        for (ClassCS iterator : ValueUtil.typedIterable(ClassCS.class, selectByKind_0)) {
            if (iterator instanceof ClassCS) {
                _92_u00ABjoin_m_ClassCS_m_0_92_u00BB.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs%PackageCS%ownedPackages' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::PackageCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-PackageCS-0\\u00BB' : UniqueCollection(classescs::PackageCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::PackageCS) = _'\\u00ABparent\\u00BB'.ownedPackages->selectByKind(classescs::PackageCS)
     *   ;
     * _'\u00ABchild-PackageCS\u00BB' : OrderedSet(classescs::PackageCS[*|1]) = allChildren->selectByKind(classescs::PackageCS)
     *   ;
     *  |
     * _'\\u00ABjoin-PackageCS-0\\u00BB' += _'\u00ABchild-PackageCS\u00BB';
     * }
     * for aChild : classescs::PackageCS in allChildren {
     * 
     *     map _'classescs%PackageCS%ownedPackages' {
     * _'\\u00ABjoin-PackageCS-0\\u00BB' := _'\\u00ABjoin-PackageCS-0\\u00BB';
     * _'\\u00ABparent\\u00BB' := aChild;
     * }}
     */
    protected boolean MAP_classescs_37PackageCS_37ownedPackages(final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_0_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS _92_u00ABparent_92_u00BB_5) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PackageCS_1 = idResolver.getClass(CLSSid_PackageCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = _92_u00ABparent_92_u00BB_5.getOwnedPackages();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_ownedPackages, TYP_classescs_c_c_PackageCS_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_PackageCS_1));
        // connection assignments
        for (PackageCS iterator : ValueUtil.typedIterable(PackageCS.class, selectByKind_0)) {
            if (iterator instanceof PackageCS) {
                _92_u00ABjoin_m_PackageCS_m_0_92_u00BB.add(iterator);
            }
        }
        // mapping statements
        for (PackageCS aChild : ValueUtil.typedIterable(PackageCS.class, selectByKind)) {
            if (aChild != null) {
                final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS symbol_0 = (PackageCS)aChild;
                MAP_classescs_37PackageCS_37ownedPackages(_92_u00ABjoin_m_PackageCS_m_0_92_u00BB, symbol_0);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs%RootCS%ownedPackages' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::RootCS[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-PackageCS-1\\u00BB' : UniqueCollection(classescs::PackageCS[*|1]);
     * _'\\u00ABjoin-PackageCS-0\\u00BB' : UniqueCollection(classescs::PackageCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::PackageCS) = _'\\u00ABparent\\u00BB'.ownedPackages->selectByKind(classescs::PackageCS)
     *   ;
     * _'\u00ABchild-PackageCS\u00BB' : OrderedSet(classescs::PackageCS[*|1]) = allChildren->selectByKind(classescs::PackageCS);
     *  |
     * _'\\u00ABjoin-PackageCS-1\\u00BB' += _'\u00ABchild-PackageCS\u00BB';
     * _'\\u00ABjoin-PackageCS-0\\u00BB' += _'\u00ABchild-PackageCS\u00BB';
     * }
     * 
     */
    protected boolean MAP_classescs_37RootCS_37ownedPackages(final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_0, final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_PackageCS_m_1_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS _92_u00ABparent_92_u00BB_6) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_PackageCS_1 = idResolver.getClass(CLSSid_PackageCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = _92_u00ABparent_92_u00BB_6.getOwnedPackages();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_ownedPackages, TYP_classescs_c_c_PackageCS_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_PackageCS_1));
        // connection assignments
        for (PackageCS iterator : ValueUtil.typedIterable(PackageCS.class, selectByKind_0)) {
            if (iterator instanceof PackageCS) {
                _92_u00ABjoin_m_PackageCS_m_1_92_u00BB.add(iterator);
            }
        }
        for (PackageCS iterator_0 : ValueUtil.typedIterable(PackageCS.class, selectByKind_0)) {
            if (iterator_0 instanceof PackageCS) {
                _92_u00ABjoin_m_PackageCS_m_0_92_u00BB_0.add(iterator_0);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'classescs%RoundedBracketClause%args' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (_'\\u00ABparent\\u00BB' : classescs::RoundedBracketClause[1];
     *  |)
     * { |}
     * where (_'\\u00ABjoin-ArgumentCS-0\\u00BB' : UniqueCollection(classescs::ArgumentCS[*|1]);
     *  |)
     * {allChildren : OrderedSet(classescs::ArgumentCS) = _'\\u00ABparent\\u00BB'.args->selectByKind(classescs::ArgumentCS)
     *   ;
     * _'\u00ABchild-ArgumentCS\u00BB' : OrderedSet(classescs::ArgumentCS[*|1]) = allChildren->selectByKind(classescs::ArgumentCS);
     *  |
     * _'\\u00ABjoin-ArgumentCS-0\\u00BB' += _'\u00ABchild-ArgumentCS\u00BB';
     * }
     * 
     */
    protected boolean MAP_classescs_37RoundedBracketClause_37args(final CollectionValue./*@NonNull*/ Accumulator _92_u00ABjoin_m_ArgumentCS_m_0_92_u00BB, final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RoundedBracketClause _92_u00ABparent_92_u00BB_7) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_ArgumentCS_1 = idResolver.getClass(CLSSid_ArgumentCS, null);
        // variable assignments
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ArgumentCS> args = _92_u00ABparent_92_u00BB_7.getArgs();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_args = idResolver.createOrderedSetOfAll(ORD_CLSSid_ArgumentCS, args);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_args, TYP_classescs_c_c_ArgumentCS_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue selectByKind_0 = ClassUtil.nonNullState((OrderedSetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_classescs_c_c_ArgumentCS_1));
        // connection assignments
        for (ArgumentCS iterator : ValueUtil.typedIterable(ArgumentCS.class, selectByKind_0)) {
            if (iterator instanceof ArgumentCS) {
                _92_u00ABjoin_m_ArgumentCS_m_0_92_u00BB.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map uArgument_name in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (argumentCS : classescs::ArgumentCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = argumentCS.ast;
     * name : String[?] = argumentCS.name;
     * aArgument : classes::Argument[1] = ast.oclAsType(classes::Argument);
     *  |
     * aArgument.name := name;
     * }
     * 
     */
    protected boolean MAP_uArgument_name(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ArgumentCS argumentCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Argument_0 = idResolver.getClass(CLSSid_Argument, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = argumentCS_0.getAst();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = argumentCS_0.getName();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Argument oclAsType = ClassUtil.nonNullState((Argument)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Argument_0));
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map _'uClass_name\\nuClass_ownedOperations\\nuClass_ownedProperties' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (classCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = classCS.ast;
     * name : String[?] = classCS.name;
     * operations : OrderedSet(classescs::OperationCS) = classCS.operations;
     * properties : OrderedSet(classescs::PropertyCS) = classCS.properties;
     * aClass : classes::Class[1] = ast.oclAsType(classes::Class)
     *   ;
     * _'\\u00ABcollect\\u00BB' : Sequence(classes::Operation) = operations->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Operation))
     *   ;
     * _'\\u00ABcollect\\u00BB1' : Sequence(classes::Property) = properties->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Property));
     *  |
     * aClass.name := name;
     * aClass.ownedOperations := _'\\u00ABcollect\\u00BB';
     * aClass.ownedProperties := _'\\u00ABcollect\\u00BB1';
     * }
     * 
     */
    protected boolean MAP_uClass_name_92nuClass_ownedOperations_92nuClass_ownedProperties(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS classCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = classCS_0.getAst();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = classCS_0.getName();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<OperationCS> operations = classCS_0.getOperations();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PropertyCS> properties = classCS_0.getProperties();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_operations = idResolver.createOrderedSetOfAll(ORD_CLSSid_OperationCS, operations);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Operation);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_operations.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable OperationCS _1 = (OperationCS)ITERATOR__1.next();
            /**
             * _'1_'.ast.oclAsType(classes::Operation)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
            if (_1 == null) {
                throwNull(classCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation oclAsType_0 = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Operation_0));
            //
            accumulator.add(oclAsType_0);
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_properties = idResolver.createOrderedSetOfAll(ORD_CLSSid_PropertyCS, properties);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Property);
        /*@Nullable*/ Iterator<?> ITERATOR__1_0 = BOXED_properties.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect_0 = accumulator_0;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PropertyCS _1_0 = (PropertyCS)ITERATOR__1_0.next();
            /**
             * _'1_'.ast.oclAsType(classes::Property)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
            if (_1_0 == null) {
                throwNull(classCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_1 = _1_0.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Property oclAsType_1 = ClassUtil.nonNullState((example2.classes.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_classes_c_c_Property_0));
            //
            accumulator_0.add(oclAsType_1);
        }
        // property assignments
        oclAsType.setName(name);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Operation> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Operation.class, collect);
        oclAsType.getOwnedOperations().addAll(ECORE_collect);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<example2.classes.Property> ECORE_collect_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(example2.classes.Property.class, collect_0);
        oclAsType.getOwnedProperties().addAll(ECORE_collect_0);
        return true;
    }
    
    /**
     * 
     * map uClass_superClass in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (classCS : classescs::ClassCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = classCS.ast;
     * extends : classescs::PathNameCS[?] = classCS.extends;
     * aClass : classes::Class[1] = ast.oclAsType(classes::Class);
     * _'=' : Boolean[1] = extends =
     *   null;
     * superClass : classes::Class[?] = if _'='
     *   then null
     *   else aClass.lookupClass(extends)
     *   endif;
     *  |
     * aClass.superClass := superClass;
     * }
     * 
     */
    protected class MAP_uClass_superClass extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull ClassCS classCS_1;
        
        @SuppressWarnings("null")
        public MAP_uClass_superClass(/*@NonNull*/ Object[] boundValues) {
            classCS_1 = (ClassCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
            // variable assignments
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = classCS_1.getAst();
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS symbol_0 = classCS_1.getExtends();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Class_0));
            final /*@Thrown*/ boolean symbol_1 = symbol_0 == null;
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_4;
            if (symbol_1) {
                symbol_4 = null;
            }
            else {
                if (symbol_0 == null) {
                    throwNull(classCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
                }
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = symbol_0.getPath();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
                final /*@Thrown*/ boolean eq = size.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_3;
                if (eq) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS == null) {
                        throwNull(classCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
                    ClassesLookupResult<example2.classes.Class> _lookupResult = lookupSolver._lookupClass(oclAsType, name);
                    example2.classes.Class _lookupClass = null;
                    if (_lookupResult.size() == 1) {
                        _lookupClass = _lookupResult.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS,name);
                    };
                    symbol_3 = _lookupClass;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
                    final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
                    assert UNBOXED_qualifierSegments != null;
                    final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = classescs2asV2_qvtp_qvtias.this.lookupPackage(oclAsType, UNBOXED_qualifierSegments);
                    /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
                    try {
                        CAUGHT_qualifier = qualifier;
                    }
                    catch (Exception e) {
                        CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ /*@NonNull*/ Object symbol_2 = CAUGHT_qualifier == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                    if (symbol_2 == Boolean.TRUE) {
                        safe_lookupQualifiedClass_source = null;
                    }
                    else {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                        if (aPathElementCS_0 == null) {
                            throwNull(classCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_0 = lookupSolver._lookupQualifiedClass(qualifier, name_0);
                        example2.classes.Class _lookupQualifiedClass = null;
                        if (_lookupResult_0.size() == 1) {
                            _lookupQualifiedClass = _lookupResult_0.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_0,name_0);
                        };
                        safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                    }
                    symbol_3 = safe_lookupQualifiedClass_source;
                }
                symbol_4 = symbol_3;
            }
            // property assignments
            oclAsType.setSuperClass(symbol_4);
            objectManager.assigned(oclAsType, ClassesPackage.Literals.CLASS__SUPER_CLASS, symbol_4);
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(classCS_1, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uOperationCallExp_ownedArguments in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * nameExpCS.isOpCallExp()
     *   )
     * {ast : ecore::EObject[?] = nameExpCS.ast;
     * roundedBrackets : classescs::RoundedBracketClause[?] = nameExpCS.roundedBrackets;
     * aOperationCallExp : classes::OperationCallExp[1] = ast.oclAsType(classes::OperationCallExp)
     *   ;
     * args : OrderedSet(classescs::ArgumentCS) = roundedBrackets.args;
     * _'\\u00ABcollect\\u00BB' : Sequence(classes::Argument) = args->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Argument));
     *  |
     * aOperationCallExp.ownedArguments := _'\\u00ABcollect\\u00BB';
     * }
     * 
     */
    protected boolean MAP_uOperationCallExp_ownedArguments(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_1.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets != null;
        if (ne != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_OperationCallExp_0 = idResolver.getClass(CLSSid_OperationCallExp, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_1.getAst();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS_1.getRoundedBrackets();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_OperationCallExp_0));
        if (roundedBrackets_0 == null) {
            throwNull(nameExpCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::RoundedBracketClause::args\'");
        }
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ArgumentCS> args = roundedBrackets_0.getArgs();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_args = idResolver.createOrderedSetOfAll(ORD_CLSSid_ArgumentCS, args);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Argument);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_args.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable ArgumentCS _1 = (ArgumentCS)ITERATOR__1.next();
            /**
             * _'1_'.ast.oclAsType(classes::Argument)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Argument_0 = idResolver.getClass(CLSSid_Argument, null);
            if (_1 == null) {
                throwNull(nameExpCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Argument oclAsType_0 = ClassUtil.nonNullState((Argument)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Argument_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Argument> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Argument.class, collect);
        oclAsType.getOwnedArguments().addAll(ECORE_collect);
        return true;
    }
    
    /**
     * 
     * map uOperationCallExp_ownedCallExp in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * nameExpCS.isOpCallExp()
     *   )
     * {ast : ecore::EObject[?] = nameExpCS.ast;
     * ownedNameExp : classescs::NameExpCS[?] = nameExpCS.ownedNameExp;
     * aOperationCallExp : classes::OperationCallExp[1] = ast.oclAsType(classes::OperationCallExp)
     *   ;
     * ast1 : ecore::EObject[?] = ownedNameExp.ast;
     * aCallExp : classes::CallExp[1] = ast1.oclAsType(classes::CallExp);
     *  |
     * aOperationCallExp.ownedCallExp := aCallExp;
     * }
     * 
     */
    protected boolean MAP_uOperationCallExp_ownedCallExp(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_2.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets != null;
        if (ne != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_OperationCallExp_0 = idResolver.getClass(CLSSid_OperationCallExp, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_2.getAst();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable NameExpCS ownedNameExp = nameExpCS_2.getOwnedNameExp();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_OperationCallExp_0));
        if (ownedNameExp == null) {
            throwNull(nameExpCS_2, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
        }
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = ownedNameExp.getAst();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_CallExp_0));
        // property assignments
        oclAsType.setOwnedCallExp(oclAsType_0);
        return true;
    }
    
    /**
     * 
     * map uOperationCallExp_referredOperation in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * nameExpCS.isOpCallExp()
     *   )
     * {ast : ecore::EObject[?] = nameExpCS.ast;
     * oclContainer : OclElement[?] = nameExpCS.oclContainer;
     * aOperationCallExp : classes::OperationCallExp[1] = ast.oclAsType(classes::OperationCallExp)
     *   ;
     * ownedArguments : OrderedSet(classes::Argument) = aOperationCallExp.ownedArguments;
     * _'oclIsKindOf\\\\nclassescs::NameExpCS' : Boolean[1] = oclContainer.oclIsKindOf(classescs::NameExpCS)
     *   ;
     * referredOperation : classes::Operation[?] = if _'oclIsKindOf\\\\nclassescs::NameExpCS'
     *   then
     *     aOperationCallExp.lookupOperationFrom(aOperationCallExp.owningSource.type, nameExpCS.name, ownedArguments)
     *   else
     *     aOperationCallExp.lookupOperation(nameExpCS.name, ownedArguments)
     *   endif;
     *  |
     * aOperationCallExp.referredOperation := referredOperation;
     * }
     * 
     */
    protected class MAP_uOperationCallExp_referredOperation extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_3;
        
        @SuppressWarnings("null")
        public MAP_uOperationCallExp_referredOperation(/*@NonNull*/ Object[] boundValues) {
            nameExpCS_3 = (NameExpCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_3.getRoundedBrackets();
            final /*@Thrown*/ boolean ne = roundedBrackets != null;
            if (ne != ValueUtil.TRUE_VALUE) {
                return false;
            }
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_OperationCallExp_0 = idResolver.getClass(CLSSid_OperationCallExp, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_NameExpCS_0 = idResolver.getClass(CLSSid_NameExpCS, null);
            // variable assignments
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_3.getAst();
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object oclContainer = nameExpCS_3.eContainer();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_OperationCallExp_0));
            final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Argument> ownedArguments = oclAsType.getOwnedArguments();
            final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_classescs_c_c_NameExpCS_0).booleanValue());
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation symbol_8;
            if (oclIsKindOf) {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS = nameExpCS_3.getName();
                final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable CallExp owningSource = oclAsType.getOwningSource();
                if (owningSource == null) {
                    throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classes/1.0\'::TypedElement::type\'");
                }
                objectManager.getting(owningSource, ClassesPackage.Literals.TYPED_ELEMENT__TYPE);
                final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class exporter = owningSource.getType();
                if (aPathNameCS == null) {
                    throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
                }
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = aPathNameCS.getPath();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
                final /*@Thrown*/ boolean eq = size.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation symbol_3;
                if (eq) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS == null) {
                        throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
                    ClassesLookupResult<Operation> _lookupResult = lookupSolver._lookupExportedOperation(exporter, oclAsType, name, (List<Argument>)ownedArguments);
                    Operation _lookupExportedOperation = null;
                    if (_lookupResult.size() == 1) {
                        _lookupExportedOperation = _lookupResult.getSingleResult();
                    } else {
                        handleLookupError(oclAsType,oclAsType);
                    };
                    symbol_3 = _lookupExportedOperation;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_1 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments));
                    final /*@Thrown*/ boolean eq_0 = size_1.equals(INT_1);
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
                    if (eq_0) {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
                        if (aPathElementCS_0 == null) {
                            throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_0 = lookupSolver._lookupClass(oclAsType, name_0);
                        example2.classes.Class _lookupClass = null;
                        if (_lookupResult_0.size() == 1) {
                            _lookupClass = _lookupResult_0.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_0,name_0);
                        };
                        symbol_1 = _lookupClass;
                    }
                    else {
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_0 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_1, INT_1));
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_0 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0));
                        final List<PathElementCS> UNBOXED_qualifierSegments_0 = qualifierSegments_0.asEcoreObjects(idResolver, PathElementCS.class);
                        assert UNBOXED_qualifierSegments_0 != null;
                        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = classescs2asV2_qvtp_qvtias.this.lookupPackage(oclAsType, UNBOXED_qualifierSegments_0);
                        /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
                        try {
                            CAUGHT_qualifier = qualifier;
                        }
                        catch (Exception e) {
                            CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                        }
                        final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
                        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                        if (symbol_0 == Boolean.TRUE) {
                            safe_lookupQualifiedClass_source = null;
                        }
                        else {
                            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
                            if (aPathElementCS_1 == null) {
                                throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_1 = aPathElementCS_1.getName();
                            ClassesLookupResult<example2.classes.Class> _lookupResult_1 = lookupSolver._lookupQualifiedClass(qualifier, name_1);
                            example2.classes.Class _lookupQualifiedClass = null;
                            if (_lookupResult_1.size() == 1) {
                                _lookupQualifiedClass = _lookupResult_1.getSingleResult();
                            } else {
                                handleLookupError(aPathElementCS_1,name_1);
                            };
                            safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                        }
                        symbol_1 = safe_lookupQualifiedClass_source;
                    }
                    /*@Caught*/ /*@Nullable*/ Object CAUGHT_symbol_1;
                    try {
                        CAUGHT_symbol_1 = symbol_1;
                    }
                    catch (Exception e) {
                        CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ /*@NonNull*/ Object symbol_2 = CAUGHT_symbol_1 == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation safe_lookupQualifiedOperation_source;
                    if (symbol_2 == Boolean.TRUE) {
                        safe_lookupQualifiedOperation_source = null;
                    }
                    else {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                        if (aPathElementCS_2 == null) {
                            throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_2 = aPathElementCS_2.getName();
                        ClassesLookupResult<Operation> _lookupResult_2 = lookupSolver._lookupQualifiedOperation(symbol_1, name_2, (List<Argument>)ownedArguments);
                        Operation _lookupQualifiedOperation = null;
                        if (_lookupResult_2.size() == 1) {
                            _lookupQualifiedOperation = _lookupResult_2.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_2,name_2);
                        };
                        safe_lookupQualifiedOperation_source = _lookupQualifiedOperation;
                    }
                    symbol_3 = safe_lookupQualifiedOperation_source;
                }
                symbol_8 = symbol_3;
            }
            else {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS_0 = nameExpCS_3.getName();
                if (aPathNameCS_0 == null) {
                    throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
                }
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_1 = aPathNameCS_0.getPath();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_1);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_3 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_1));
                final /*@Thrown*/ boolean eq_1 = size_3.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation symbol_7;
                if (eq_1) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_3 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_1);
                    if (aPathElementCS_3 == null) {
                        throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_3 = aPathElementCS_3.getName();
                    ClassesLookupResult<Operation> _lookupResult_3 = lookupSolver._lookupOperation(oclAsType, name_3, (List<Argument>)ownedArguments);
                    Operation _lookupOperation = null;
                    if (_lookupResult_3.size() == 1) {
                        _lookupOperation = _lookupResult_3.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_3,name_3);
                    };
                    symbol_7 = _lookupOperation;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_1 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_3, INT_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_1 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_1, INT_1, diff_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_5 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments_1));
                    final /*@Thrown*/ boolean eq_2 = size_5.equals(INT_1);
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_5;
                    if (eq_2) {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_4 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments_1);
                        if (aPathElementCS_4 == null) {
                            throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_4 = aPathElementCS_4.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_4 = lookupSolver._lookupClass(oclAsType, name_4);
                        example2.classes.Class _lookupClass_0 = null;
                        if (_lookupResult_4.size() == 1) {
                            _lookupClass_0 = _lookupResult_4.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_4,name_4);
                        };
                        symbol_5 = _lookupClass_0;
                    }
                    else {
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_2 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_5, INT_1));
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_2 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments_1, INT_1, diff_2));
                        final List<PathElementCS> UNBOXED_qualifierSegments_2 = qualifierSegments_2.asEcoreObjects(idResolver, PathElementCS.class);
                        assert UNBOXED_qualifierSegments_2 != null;
                        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier_0 = classescs2asV2_qvtp_qvtias.this.lookupPackage(oclAsType, UNBOXED_qualifierSegments_2);
                        /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier_0;
                        try {
                            CAUGHT_qualifier_0 = qualifier_0;
                        }
                        catch (Exception e) {
                            CAUGHT_qualifier_0 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@NonInvalid*/ /*@NonNull*/ Object symbol_4 = CAUGHT_qualifier_0 == null;
                        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source_0;
                        if (symbol_4 == Boolean.TRUE) {
                            safe_lookupQualifiedClass_source_0 = null;
                        }
                        else {
                            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_5 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments_1);
                            if (aPathElementCS_5 == null) {
                                throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_5 = aPathElementCS_5.getName();
                            ClassesLookupResult<example2.classes.Class> _lookupResult_5 = lookupSolver._lookupQualifiedClass(qualifier_0, name_5);
                            example2.classes.Class _lookupQualifiedClass_0 = null;
                            if (_lookupResult_5.size() == 1) {
                                _lookupQualifiedClass_0 = _lookupResult_5.getSingleResult();
                            } else {
                                handleLookupError(aPathElementCS_5,name_5);
                            };
                            safe_lookupQualifiedClass_source_0 = _lookupQualifiedClass_0;
                        }
                        symbol_5 = safe_lookupQualifiedClass_source_0;
                    }
                    /*@Caught*/ /*@Nullable*/ Object CAUGHT_symbol_5;
                    try {
                        CAUGHT_symbol_5 = symbol_5;
                    }
                    catch (Exception e) {
                        CAUGHT_symbol_5 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ /*@NonNull*/ Object symbol_6 = CAUGHT_symbol_5 == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation safe_lookupQualifiedOperation_source_0;
                    if (symbol_6 == Boolean.TRUE) {
                        safe_lookupQualifiedOperation_source_0 = null;
                    }
                    else {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_6 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_1);
                        if (aPathElementCS_6 == null) {
                            throwNull(nameExpCS_3, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_6 = aPathElementCS_6.getName();
                        ClassesLookupResult<Operation> _lookupResult_6 = lookupSolver._lookupQualifiedOperation(symbol_5, name_6, (List<Argument>)ownedArguments);
                        Operation _lookupQualifiedOperation_0 = null;
                        if (_lookupResult_6.size() == 1) {
                            _lookupQualifiedOperation_0 = _lookupResult_6.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_6,name_6);
                        };
                        safe_lookupQualifiedOperation_source_0 = _lookupQualifiedOperation_0;
                    }
                    symbol_7 = safe_lookupQualifiedOperation_source_0;
                }
                symbol_8 = symbol_7;
            }
            // property assignments
            oclAsType.setReferredOperation(symbol_8);
            objectManager.assigned(oclAsType, ClassesPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, symbol_8);
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(nameExpCS_3, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uOperationCallExp_type in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * nameExpCS.isOpCallExp()
     *   )
     * {ast : ecore::EObject[?] = nameExpCS.ast;
     * aOperationCallExp : classes::OperationCallExp[1] = ast.oclAsType(classes::OperationCallExp);
     * referredOperation : classes::Operation[?] = aOperationCallExp.referredOperation;
     * type : classes::Class[?] = referredOperation.type;
     *  |
     * aOperationCallExp.type := type;
     * }
     * 
     */
    protected class MAP_uOperationCallExp_type extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_4;
        
        @SuppressWarnings("null")
        public MAP_uOperationCallExp_type(/*@NonNull*/ Object[] boundValues) {
            nameExpCS_4 = (NameExpCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_4.getRoundedBrackets();
            final /*@Thrown*/ boolean ne = roundedBrackets != null;
            if (ne != ValueUtil.TRUE_VALUE) {
                return false;
            }
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_OperationCallExp_0 = idResolver.getClass(CLSSid_OperationCallExp, null);
            // variable assignments
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_4.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull OperationCallExp oclAsType = ClassUtil.nonNullState((OperationCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_OperationCallExp_0));
            objectManager.getting(oclAsType, ClassesPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION);
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Operation referredOperation = oclAsType.getReferredOperation();
            if (referredOperation == null) {
                throwNull(nameExpCS_4, "Null source for \'\'http://cs2as/tests/example2/classes/1.0\'::TypedElement::type\'");
            }
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class type = referredOperation.getType();
            // property assignments
            oclAsType.setType(type);
            objectManager.assigned(oclAsType, ClassesPackage.Literals.TYPED_ELEMENT__TYPE, type);
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(nameExpCS_4, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map _'uOperation_name\\nuOperation_ownedExpressions\\nuOperation_ownedParameters' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (operationCS : classescs::OperationCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = operationCS.ast;
     * name : String[?] = operationCS.name;
     * bodyExps : OrderedSet(classescs::NameExpCS) = operationCS.bodyExps;
     * params : OrderedSet(String) = operationCS.params;
     * aOperation : classes::Operation[1] = ast.oclAsType(classes::Operation)
     *   ;
     * _'\\u00ABcollect\\u00BB' : Sequence(classes::CallExp) = bodyExps->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::CallExp))
     *   ;
     * _'\\u00ABcollect\\u00BB1' : Sequence(classes::Parameter[*|1]) = params->collect(x |
     *     classes::Parameter{name = x
     *     });
     *  |
     * aOperation.name := name;
     * aOperation.ownedExpressions := _'\\u00ABcollect\\u00BB';
     * aOperation.ownedParameters := _'\\u00ABcollect\\u00BB1';
     * }
     * 
     */
    protected boolean MAP_uOperation_name_92nuOperation_ownedExpressions_92nuOperation_ownedParameters(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS operationCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = operationCS_0.getAst();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = operationCS_0.getName();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<NameExpCS> bodyExps = operationCS_0.getBodyExps();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<String> params = operationCS_0.getParams();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Operation_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_bodyExps = idResolver.createOrderedSetOfAll(ORD_CLSSid_NameExpCS, bodyExps);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_CallExp);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_bodyExps.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable NameExpCS _1 = (NameExpCS)ITERATOR__1.next();
            /**
             * _'1_'.ast.oclAsType(classes::CallExp)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
            if (_1 == null) {
                throwNull(operationCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_CallExp_0));
            //
            accumulator.add(oclAsType_0);
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_params = idResolver.createOrderedSetOfAll(ORD_PRIMid_String, params);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Parameter);
        /*@Nullable*/ Iterator<?> ITERATOR_x = BOXED_params.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect_0;
        while (true) {
            if (!ITERATOR_x.hasNext()) {
                collect_0 = accumulator_0;
                break;
            }
            /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable String x = (String)ITERATOR_x.next();
            /**
             * classes::Parameter{name = x}
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Property CTORid_name = idResolver.getProperty(PROPid_name);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Parameter_0 = idResolver.getClass(CLSSid_Parameter, null);
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Parameter symbol_1 = (Parameter)TYP_classes_c_c_Parameter_0.createInstance();
            CTORid_name.initValue(symbol_1, x);
            //
            accumulator_0.add(symbol_1);
        }
        // property assignments
        oclAsType.setName(name);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<CallExp> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(CallExp.class, collect);
        oclAsType.getOwnedExpressions().addAll(ECORE_collect);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Parameter> ECORE_collect_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Parameter.class, collect_0);
        oclAsType.getOwnedParameters().addAll(ECORE_collect_0);
        return true;
    }
    
    /**
     * 
     * map uOperation_type in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (operationCS : classescs::OperationCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = operationCS.ast;
     * resultRef : classescs::PathNameCS[?] = operationCS.resultRef;
     * aOperation : classes::Operation[1] = ast.oclAsType(classes::Operation)
     *   ;
     * type : classes::Class[?] = aOperation.lookupClass(resultRef);
     *  |
     * aOperation.type := type;
     * }
     * 
     */
    protected boolean MAP_uOperation_type(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull OperationCS operationCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Operation_0 = idResolver.getClass(CLSSid_Operation, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = operationCS_1.getAst();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS resultRef = operationCS_1.getResultRef();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Operation oclAsType = ClassUtil.nonNullState((Operation)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Operation_0));
        if (resultRef == null) {
            throwNull(operationCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
        }
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = resultRef.getPath();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
        final /*@Thrown*/ boolean eq = size.equals(INT_1);
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
        if (eq) {
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
            if (aPathElementCS == null) {
                throwNull(operationCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
            ClassesLookupResult<example2.classes.Class> _lookupResult = lookupSolver._lookupClass(oclAsType, name);
            example2.classes.Class _lookupClass = null;
            if (_lookupResult.size() == 1) {
                _lookupClass = _lookupResult.getSingleResult();
            } else {
                handleLookupError(aPathElementCS,name);
            };
            symbol_1 = _lookupClass;
        }
        else {
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
            final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
            assert UNBOXED_qualifierSegments != null;
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(oclAsType, UNBOXED_qualifierSegments);
            /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
            try {
                CAUGHT_qualifier = qualifier;
            }
            catch (Exception e) {
                CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
            if (symbol_0 == Boolean.TRUE) {
                safe_lookupQualifiedClass_source = null;
            }
            else {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                if (aPathElementCS_0 == null) {
                    throwNull(operationCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                ClassesLookupResult<example2.classes.Class> _lookupResult_0 = lookupSolver._lookupQualifiedClass(qualifier, name_0);
                example2.classes.Class _lookupQualifiedClass = null;
                if (_lookupResult_0.size() == 1) {
                    _lookupQualifiedClass = _lookupResult_0.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS_0,name_0);
                };
                safe_lookupQualifiedClass_source = _lookupQualifiedClass;
            }
            symbol_1 = safe_lookupQualifiedClass_source;
        }
        // property assignments
        oclAsType.setType(symbol_1);
        return true;
    }
    
    /**
     * 
     * map _'uPackage_name\\nuPackage_ownedClasses\\nuPackage_ownedPackages' in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (packageCS : classescs::PackageCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = packageCS.ast;
     * name : String[?] = packageCS.name;
     * ownedClasses : OrderedSet(classescs::ClassCS) = packageCS.ownedClasses;
     * ownedPackages : OrderedSet(classescs::PackageCS) = packageCS.ownedPackages;
     * aPackage : classes::Package[1] = ast.oclAsType(classes::Package)
     *   ;
     * _'\\u00ABcollect\\u00BB' : Sequence(classes::Class) = ownedClasses->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Class))
     *   ;
     * _'\\u00ABcollect\\u00BB1' : Sequence(classes::Package) = ownedPackages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Package));
     *  |
     * aPackage.name := name;
     * aPackage.ownedClasses := _'\\u00ABcollect\\u00BB';
     * aPackage.ownedPackages := _'\\u00ABcollect\\u00BB1';
     * }
     * 
     */
    protected boolean MAP_uPackage_name_92nuPackage_ownedClasses_92nuPackage_ownedPackages(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PackageCS packageCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = packageCS_0.getAst();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = packageCS_0.getName();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<ClassCS> ownedClasses = packageCS_0.getOwnedClasses();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = packageCS_0.getOwnedPackages();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Package_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedClasses = idResolver.createOrderedSetOfAll(ORD_CLSSid_ClassCS, ownedClasses);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Class);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedClasses.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable ClassCS _1 = (ClassCS)ITERATOR__1.next();
            /**
             * _'1_'.ast.oclAsType(classes::Class)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Class_0 = idResolver.getClass(CLSSid_Class_0, null);
            if (_1 == null) {
                throwNull(packageCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Class oclAsType_0 = ClassUtil.nonNullState((example2.classes.Class)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Class_0));
            //
            accumulator.add(oclAsType_0);
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator_0 = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        /*@Nullable*/ Iterator<?> ITERATOR__1_0 = BOXED_ownedPackages.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect_0;
        while (true) {
            if (!ITERATOR__1_0.hasNext()) {
                collect_0 = accumulator_0;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PackageCS _1_0 = (PackageCS)ITERATOR__1_0.next();
            /**
             * _'1_'.ast.oclAsType(classes::Package)
             */
            if (_1_0 == null) {
                throwNull(packageCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_1 = _1_0.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType_1 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_1, TYP_classes_c_c_Package_0));
            //
            accumulator_0.add(oclAsType_1);
        }
        // property assignments
        oclAsType.setName(name);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<example2.classes.Class> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(example2.classes.Class.class, collect);
        oclAsType.getOwnedClasses().addAll(ECORE_collect);
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE_collect_0 = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, collect_0);
        oclAsType.getOwnedPackages().addAll(ECORE_collect_0);
        return true;
    }
    
    /**
     * 
     * map uPropertyCallExp_ownedCallExp in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * not nameExpCS.isOpCallExp()
     *   nameExpCS.isPropCallExp()
     *   )
     * {ast : ecore::EObject[?] = nameExpCS.ast;
     * ownedNameExp : classescs::NameExpCS[?] = nameExpCS.ownedNameExp;
     * aPropertyCallExp : classes::PropertyCallExp[1] = ast.oclAsType(classes::PropertyCallExp);
     * _'=' : Boolean[1] = ownedNameExp =
     *   null;
     * ownedCallExp : classes::CallExp[?] = if _'='
     *   then null
     *   else ownedNameExp.ast.oclAsType(classes::CallExp)
     *   endif;
     *  |
     * aPropertyCallExp.ownedCallExp := ownedCallExp;
     * }
     * 
     */
    protected boolean MAP_uPropertyCallExp_ownedCallExp(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_5) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_5.getRoundedBrackets();
        final /*@Thrown*/ boolean eq = roundedBrackets == null;
        if (eq != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS_5.getRoundedBrackets();
        final /*@Thrown*/ boolean ne = roundedBrackets_0 != null;
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(ne);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_5.getAst();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable NameExpCS ownedNameExp = nameExpCS_5.getOwnedNameExp();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_PropertyCallExp_0));
        final /*@Thrown*/ boolean symbol_0 = ownedNameExp == null;
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable CallExp symbol_1;
        if (symbol_0) {
            symbol_1 = null;
        }
        else {
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_CallExp_0 = idResolver.getClass(CLSSid_CallExp, null);
            if (ownedNameExp == null) {
                throwNull(nameExpCS_5, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = ownedNameExp.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull CallExp oclAsType_0 = ClassUtil.nonNullState((CallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_CallExp_0));
            symbol_1 = oclAsType_0;
        }
        // property assignments
        oclAsType.setOwnedCallExp(symbol_1);
        return true;
    }
    
    /**
     * 
     * map uPropertyCallExp_referredProperty in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * nameExpCS.isPropCallExp()
     *   not nameExpCS.isOpCallExp()
     *   )
     * {ast : ecore::EObject[?] = nameExpCS.ast;
     * oclContainer : OclElement[?] = nameExpCS.oclContainer;
     * aPropertyCallExp : classes::PropertyCallExp[1] = ast.oclAsType(classes::PropertyCallExp)
     *   ;
     * _'oclIsKindOf\\\\nclassescs::NameExpCS' : Boolean[1] = oclContainer.oclIsKindOf(classescs::NameExpCS)
     *   ;
     * referredProperty : classes::Property[?] = if _'oclIsKindOf\\\\nclassescs::NameExpCS'
     *   then
     *     aPropertyCallExp.lookupPropertyFrom(aPropertyCallExp.owningSource.type, nameExpCS.name)
     *   else aPropertyCallExp.lookupProperty(nameExpCS.name)
     *   endif;
     *  |
     * aPropertyCallExp.referredProperty := referredProperty;
     * }
     * 
     */
    protected class MAP_uPropertyCallExp_referredProperty extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_6;
        
        @SuppressWarnings("null")
        public MAP_uPropertyCallExp_referredProperty(/*@NonNull*/ Object[] boundValues) {
            nameExpCS_6 = (NameExpCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_6.getRoundedBrackets();
            final /*@Thrown*/ boolean eq = roundedBrackets == null;
            if (eq != ValueUtil.TRUE_VALUE) {
                return false;
            }
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS_6.getRoundedBrackets();
            final /*@Thrown*/ boolean ne = roundedBrackets_0 != null;
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(ne);
            if (not != ValueUtil.TRUE_VALUE) {
                return false;
            }
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classescs_c_c_NameExpCS_0 = idResolver.getClass(CLSSid_NameExpCS, null);
            // variable assignments
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_6.getAst();
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Object oclContainer = nameExpCS_6.eContainer();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_PropertyCallExp_0));
            final /*@Thrown*/ boolean oclIsKindOf = ClassUtil.nonNullState(OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, oclContainer, TYP_classescs_c_c_NameExpCS_0).booleanValue());
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property symbol_8;
            if (oclIsKindOf) {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS = nameExpCS_6.getName();
                final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable CallExp owningSource = oclAsType.getOwningSource();
                if (owningSource == null) {
                    throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classes/1.0\'::TypedElement::type\'");
                }
                objectManager.getting(owningSource, ClassesPackage.Literals.TYPED_ELEMENT__TYPE);
                final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class exporter = owningSource.getType();
                if (aPathNameCS == null) {
                    throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
                }
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = aPathNameCS.getPath();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
                final /*@Thrown*/ boolean eq_0 = size.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property symbol_3;
                if (eq_0) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
                    if (aPathElementCS == null) {
                        throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
                    ClassesLookupResult<example2.classes.Property> _lookupResult = lookupSolver._lookupExportedProperty(exporter, oclAsType, name);
                    example2.classes.Property _lookupExportedProperty = null;
                    if (_lookupResult.size() == 1) {
                        _lookupExportedProperty = _lookupResult.getSingleResult();
                    } else {
                        handleLookupError(oclAsType,oclAsType);
                    };
                    symbol_3 = _lookupExportedProperty;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_1 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments));
                    final /*@Thrown*/ boolean eq_1 = size_1.equals(INT_1);
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
                    if (eq_1) {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments);
                        if (aPathElementCS_0 == null) {
                            throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_0 = lookupSolver._lookupClass(oclAsType, name_0);
                        example2.classes.Class _lookupClass = null;
                        if (_lookupResult_0.size() == 1) {
                            _lookupClass = _lookupResult_0.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_0,name_0);
                        };
                        symbol_1 = _lookupClass;
                    }
                    else {
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_0 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_1, INT_1));
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_0 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments, INT_1, diff_0));
                        final List<PathElementCS> UNBOXED_qualifierSegments_0 = qualifierSegments_0.asEcoreObjects(idResolver, PathElementCS.class);
                        assert UNBOXED_qualifierSegments_0 != null;
                        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = classescs2asV2_qvtp_qvtias.this.lookupPackage(oclAsType, UNBOXED_qualifierSegments_0);
                        /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
                        try {
                            CAUGHT_qualifier = qualifier;
                        }
                        catch (Exception e) {
                            CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
                        }
                        final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
                        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
                        if (symbol_0 == Boolean.TRUE) {
                            safe_lookupQualifiedClass_source = null;
                        }
                        else {
                            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_1 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments);
                            if (aPathElementCS_1 == null) {
                                throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_1 = aPathElementCS_1.getName();
                            ClassesLookupResult<example2.classes.Class> _lookupResult_1 = lookupSolver._lookupQualifiedClass(qualifier, name_1);
                            example2.classes.Class _lookupQualifiedClass = null;
                            if (_lookupResult_1.size() == 1) {
                                _lookupQualifiedClass = _lookupResult_1.getSingleResult();
                            } else {
                                handleLookupError(aPathElementCS_1,name_1);
                            };
                            safe_lookupQualifiedClass_source = _lookupQualifiedClass;
                        }
                        symbol_1 = safe_lookupQualifiedClass_source;
                    }
                    /*@Caught*/ /*@Nullable*/ Object CAUGHT_symbol_1;
                    try {
                        CAUGHT_symbol_1 = symbol_1;
                    }
                    catch (Exception e) {
                        CAUGHT_symbol_1 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ /*@NonNull*/ Object symbol_2 = CAUGHT_symbol_1 == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property safe_lookupQualifiedProperty_source;
                    if (symbol_2 == Boolean.TRUE) {
                        safe_lookupQualifiedProperty_source = null;
                    }
                    else {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_2 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                        if (aPathElementCS_2 == null) {
                            throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_2 = aPathElementCS_2.getName();
                        ClassesLookupResult<example2.classes.Property> _lookupResult_2 = lookupSolver._lookupQualifiedProperty(symbol_1, name_2);
                        example2.classes.Property _lookupQualifiedProperty = null;
                        if (_lookupResult_2.size() == 1) {
                            _lookupQualifiedProperty = _lookupResult_2.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_2,name_2);
                        };
                        safe_lookupQualifiedProperty_source = _lookupQualifiedProperty;
                    }
                    symbol_3 = safe_lookupQualifiedProperty_source;
                }
                symbol_8 = symbol_3;
            }
            else {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS aPathNameCS_0 = nameExpCS_6.getName();
                if (aPathNameCS_0 == null) {
                    throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
                }
                final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_1 = aPathNameCS_0.getPath();
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_1 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_1);
                final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_3 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_1));
                final /*@Thrown*/ boolean eq_2 = size_3.equals(INT_1);
                /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property symbol_7;
                if (eq_2) {
                    final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_3 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_1);
                    if (aPathElementCS_3 == null) {
                        throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                    }
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_3 = aPathElementCS_3.getName();
                    ClassesLookupResult<example2.classes.Property> _lookupResult_3 = lookupSolver._lookupProperty(oclAsType, name_3);
                    example2.classes.Property _lookupProperty = null;
                    if (_lookupResult_3.size() == 1) {
                        _lookupProperty = _lookupResult_3.getSingleResult();
                    } else {
                        handleLookupError(aPathElementCS_3,name_3);
                    };
                    symbol_7 = _lookupProperty;
                }
                else {
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_1 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_3, INT_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_1 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_1, INT_1, diff_1));
                    final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size_5 = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(qualifierSegments_1));
                    final /*@Thrown*/ boolean eq_3 = size_5.equals(INT_1);
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_5;
                    if (eq_3) {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_4 = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(qualifierSegments_1);
                        if (aPathElementCS_4 == null) {
                            throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_4 = aPathElementCS_4.getName();
                        ClassesLookupResult<example2.classes.Class> _lookupResult_4 = lookupSolver._lookupClass(oclAsType, name_4);
                        example2.classes.Class _lookupClass_0 = null;
                        if (_lookupResult_4.size() == 1) {
                            _lookupClass_0 = _lookupResult_4.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_4,name_4);
                        };
                        symbol_5 = _lookupClass_0;
                    }
                    else {
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff_2 = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size_5, INT_1));
                        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments_2 = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(qualifierSegments_1, INT_1, diff_2));
                        final List<PathElementCS> UNBOXED_qualifierSegments_2 = qualifierSegments_2.asEcoreObjects(idResolver, PathElementCS.class);
                        assert UNBOXED_qualifierSegments_2 != null;
                        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier_0 = classescs2asV2_qvtp_qvtias.this.lookupPackage(oclAsType, UNBOXED_qualifierSegments_2);
                        /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier_0;
                        try {
                            CAUGHT_qualifier_0 = qualifier_0;
                        }
                        catch (Exception e) {
                            CAUGHT_qualifier_0 = ValueUtil.createInvalidValue(e);
                        }
                        final /*@NonInvalid*/ /*@NonNull*/ Object symbol_4 = CAUGHT_qualifier_0 == null;
                        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source_0;
                        if (symbol_4 == Boolean.TRUE) {
                            safe_lookupQualifiedClass_source_0 = null;
                        }
                        else {
                            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_5 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(qualifierSegments_1);
                            if (aPathElementCS_5 == null) {
                                throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                            }
                            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_5 = aPathElementCS_5.getName();
                            ClassesLookupResult<example2.classes.Class> _lookupResult_5 = lookupSolver._lookupQualifiedClass(qualifier_0, name_5);
                            example2.classes.Class _lookupQualifiedClass_0 = null;
                            if (_lookupResult_5.size() == 1) {
                                _lookupQualifiedClass_0 = _lookupResult_5.getSingleResult();
                            } else {
                                handleLookupError(aPathElementCS_5,name_5);
                            };
                            safe_lookupQualifiedClass_source_0 = _lookupQualifiedClass_0;
                        }
                        symbol_5 = safe_lookupQualifiedClass_source_0;
                    }
                    /*@Caught*/ /*@Nullable*/ Object CAUGHT_symbol_5;
                    try {
                        CAUGHT_symbol_5 = symbol_5;
                    }
                    catch (Exception e) {
                        CAUGHT_symbol_5 = ValueUtil.createInvalidValue(e);
                    }
                    final /*@NonInvalid*/ /*@NonNull*/ Object symbol_6 = CAUGHT_symbol_5 == null;
                    /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property safe_lookupQualifiedProperty_source_0;
                    if (symbol_6 == Boolean.TRUE) {
                        safe_lookupQualifiedProperty_source_0 = null;
                    }
                    else {
                        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_6 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_1);
                        if (aPathElementCS_6 == null) {
                            throwNull(nameExpCS_6, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                        }
                        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_6 = aPathElementCS_6.getName();
                        ClassesLookupResult<example2.classes.Property> _lookupResult_6 = lookupSolver._lookupQualifiedProperty(symbol_5, name_6);
                        example2.classes.Property _lookupQualifiedProperty_0 = null;
                        if (_lookupResult_6.size() == 1) {
                            _lookupQualifiedProperty_0 = _lookupResult_6.getSingleResult();
                        } else {
                            handleLookupError(aPathElementCS_6,name_6);
                        };
                        safe_lookupQualifiedProperty_source_0 = _lookupQualifiedProperty_0;
                    }
                    symbol_7 = safe_lookupQualifiedProperty_source_0;
                }
                symbol_8 = symbol_7;
            }
            // property assignments
            oclAsType.setReferredProperty(symbol_8);
            objectManager.assigned(oclAsType, ClassesPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY, symbol_8);
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(nameExpCS_6, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uPropertyCallExp_type in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (nameExpCS : classescs::NameExpCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |
     * nameExpCS.isPropCallExp()
     *   not nameExpCS.isOpCallExp()
     *   )
     * {ast : ecore::EObject[?] = nameExpCS.ast;
     * aPropertyCallExp : classes::PropertyCallExp[1] = ast.oclAsType(classes::PropertyCallExp);
     * referredProperty : classes::Property[?] = aPropertyCallExp.referredProperty;
     * type : classes::Class[?] = referredProperty.type;
     *  |
     * aPropertyCallExp.type := type;
     * }
     * 
     */
    protected class MAP_uPropertyCallExp_type extends AbstractInvocation
    {
        protected final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull NameExpCS nameExpCS_7;
        
        @SuppressWarnings("null")
        public MAP_uPropertyCallExp_type(/*@NonNull*/ Object[] boundValues) {
            nameExpCS_7 = (NameExpCS)boundValues[0];
        }
        
        public boolean execute() throws ReflectiveOperationException {
            // predicates
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets = nameExpCS_7.getRoundedBrackets();
            final /*@Thrown*/ boolean eq = roundedBrackets == null;
            if (eq != ValueUtil.TRUE_VALUE) {
                return false;
            }
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable RoundedBracketClause roundedBrackets_0 = nameExpCS_7.getRoundedBrackets();
            final /*@Thrown*/ boolean ne = roundedBrackets_0 != null;
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(ne);
            if (not != ValueUtil.TRUE_VALUE) {
                return false;
            }
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_PropertyCallExp_0 = idResolver.getClass(CLSSid_PropertyCallExp, null);
            // variable assignments
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = nameExpCS_7.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull PropertyCallExp oclAsType = ClassUtil.nonNullState((PropertyCallExp)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_PropertyCallExp_0));
            objectManager.getting(oclAsType, ClassesPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY);
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Property referredProperty = oclAsType.getReferredProperty();
            if (referredProperty == null) {
                throwNull(nameExpCS_7, "Null source for \'\'http://cs2as/tests/example2/classes/1.0\'::TypedElement::type\'");
            }
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class type = referredProperty.getType();
            // property assignments
            oclAsType.setType(type);
            objectManager.assigned(oclAsType, ClassesPackage.Literals.TYPED_ELEMENT__TYPE, type);
            return true;
        }
        
        public boolean isEqual(/*@NonNull*/ IdResolver idResolver, /*@NonNull*/ Object[] thoseValues) {
            return idResolver.oclEquals(nameExpCS_7, thoseValues[0]);
        }
    }
    
    /**
     * 
     * map uProperty_name in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (propertyCS : classescs::PropertyCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = propertyCS.ast;
     * name : String[?] = propertyCS.name;
     * aProperty : classes::Property[1] = ast.oclAsType(classes::Property);
     *  |
     * aProperty.name := name;
     * }
     * 
     */
    protected boolean MAP_uProperty_name(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS propertyCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = propertyCS_0.getAst();
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = propertyCS_0.getName();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Property oclAsType = ClassUtil.nonNullState((example2.classes.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Property_0));
        // property assignments
        oclAsType.setName(name);
        return true;
    }
    
    /**
     * 
     * map uProperty_type in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (propertyCS : classescs::PropertyCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = propertyCS.ast;
     * typeRef : classescs::PathNameCS[?] = propertyCS.typeRef;
     * aProperty : classes::Property[1] = ast.oclAsType(classes::Property)
     *   ;
     * type : classes::Class[?] = aProperty.lookupClass(typeRef);
     *  |
     * aProperty.type := type;
     * }
     * 
     */
    protected boolean MAP_uProperty_type(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull PropertyCS propertyCS_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Property_0 = idResolver.getClass(CLSSid_Property, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = propertyCS_1.getAst();
        final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathNameCS typeRef = propertyCS_1.getTypeRef();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Property oclAsType = ClassUtil.nonNullState((example2.classes.Property)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Property_0));
        if (typeRef == null) {
            throwNull(propertyCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::PathNameCS::path\'");
        }
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PathElementCS> segments_0 = typeRef.getPath();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_segments_0 = idResolver.createOrderedSetOfAll(ORD_CLSSid_PathElementCS, segments_0);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue size = ClassUtil.nonNullState(CollectionSizeOperation.INSTANCE.evaluate(BOXED_segments_0));
        final /*@Thrown*/ boolean eq = size.equals(INT_1);
        /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class symbol_1;
        if (eq) {
            final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS = (PathElementCS)OrderedCollectionFirstOperation.INSTANCE.evaluate(BOXED_segments_0);
            if (aPathElementCS == null) {
                throwNull(propertyCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
            }
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name = aPathElementCS.getName();
            ClassesLookupResult<example2.classes.Class> _lookupResult = lookupSolver._lookupClass(oclAsType, name);
            example2.classes.Class _lookupClass = null;
            if (_lookupResult.size() == 1) {
                _lookupClass = _lookupResult.getSingleResult();
            } else {
                handleLookupError(aPathElementCS,name);
            };
            symbol_1 = _lookupClass;
        }
        else {
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull IntegerValue diff = ClassUtil.nonNullState((IntegerValue)NumericMinusOperation.INSTANCE.evaluate(size, INT_1));
            final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue qualifierSegments = ClassUtil.nonNullState(OrderedSetSubOrderedSetOperation.INSTANCE.evaluate(BOXED_segments_0, INT_1, diff));
            final List<PathElementCS> UNBOXED_qualifierSegments = qualifierSegments.asEcoreObjects(idResolver, PathElementCS.class);
            assert UNBOXED_qualifierSegments != null;
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Package qualifier = this.lookupPackage(oclAsType, UNBOXED_qualifierSegments);
            /*@Caught*/ /*@Nullable*/ Object CAUGHT_qualifier;
            try {
                CAUGHT_qualifier = qualifier;
            }
            catch (Exception e) {
                CAUGHT_qualifier = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ /*@NonNull*/ Object symbol_0 = CAUGHT_qualifier == null;
            /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.Nullable Class safe_lookupQualifiedClass_source;
            if (symbol_0 == Boolean.TRUE) {
                safe_lookupQualifiedClass_source = null;
            }
            else {
                final /*@Thrown*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PathElementCS aPathElementCS_0 = (PathElementCS)OrderedCollectionLastOperation.INSTANCE.evaluate(BOXED_segments_0);
                if (aPathElementCS_0 == null) {
                    throwNull(propertyCS_1, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::NamedElementCS::name\'");
                }
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String name_0 = aPathElementCS_0.getName();
                ClassesLookupResult<example2.classes.Class> _lookupResult_0 = lookupSolver._lookupQualifiedClass(qualifier, name_0);
                example2.classes.Class _lookupQualifiedClass = null;
                if (_lookupResult_0.size() == 1) {
                    _lookupQualifiedClass = _lookupResult_0.getSingleResult();
                } else {
                    handleLookupError(aPathElementCS_0,name_0);
                };
                safe_lookupQualifiedClass_source = _lookupQualifiedClass;
            }
            symbol_1 = safe_lookupQualifiedClass_source;
        }
        // property assignments
        oclAsType.setType(symbol_1);
        return true;
    }
    
    /**
     * 
     * map uRoot_ownedPackages in classescs2asV2_qvtp_qvtias {
     * 
     *   leftCS (rootCS : classescs::RootCS[?];
     *  |)
     * { |}
     * rightAS ( |)
     * { |}
     * where ( |)
     * {ast : ecore::EObject[?] = rootCS.ast;
     * ownedPackages : OrderedSet(classescs::PackageCS) = rootCS.ownedPackages;
     * aRoot : classes::Root[1] = ast.oclAsType(classes::Root)
     *   ;
     * _'\\u00ABcollect\\u00BB' : Sequence(classes::Package) = ownedPackages->collect(_'1_' |
     *     _'1_'.ast.oclAsType(classes::Package));
     *  |
     * aRoot.ownedPackages := _'\\u00ABcollect\\u00BB';
     * }
     * 
     */
    protected boolean MAP_uRoot_ownedPackages(final /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.NonNull RootCS rootCS_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Root_0 = idResolver.getClass(CLSSid_Root, null);
        // variable assignments
        final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast = rootCS_0.getAst();
        final /*@Thrown*/ java.util.@org.eclipse.jdt.annotation.NonNull List<PackageCS> ownedPackages = rootCS_0.getOwnedPackages();
        final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Root oclAsType = ClassUtil.nonNullState((Root)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast, TYP_classes_c_c_Root_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull OrderedSetValue BOXED_ownedPackages = idResolver.createOrderedSetOfAll(ORD_CLSSid_PackageCS, ownedPackages);
        /*@Thrown*/ SequenceValue.@org.eclipse.jdt.annotation.NonNull Accumulator accumulator = ValueUtil.createSequenceAccumulatorValue(SEQ_CLSSid_Package);
        /*@Nullable*/ Iterator<?> ITERATOR__1 = BOXED_ownedPackages.iterator();
        /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SequenceValue collect;
        while (true) {
            if (!ITERATOR__1.hasNext()) {
                collect = accumulator;
                break;
            }
            /*@NonInvalid*/ example2.classescs.@org.eclipse.jdt.annotation.Nullable PackageCS _1 = (PackageCS)ITERATOR__1.next();
            /**
             * _'1_'.ast.oclAsType(classes::Package)
             */
            final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_classes_c_c_Package_0 = idResolver.getClass(CLSSid_Package, null);
            if (_1 == null) {
                throwNull(rootCS_0, "Null source for \'\'http://cs2as/tests/example2/classescs/1.0\'::ElementCS::ast\'");
            }
            final /*@Thrown*/ org.eclipse.emf.ecore.@org.eclipse.jdt.annotation.Nullable EObject ast_0 = _1.getAst();
            final /*@Thrown*/ example2.classes.@org.eclipse.jdt.annotation.NonNull Package oclAsType_0 = ClassUtil.nonNullState((Package)OclAnyOclAsTypeOperation.INSTANCE.evaluate(executor, ast_0, TYP_classes_c_c_Package_0));
            //
            accumulator.add(oclAsType_0);
        }
        // property assignments
        final /*@NonInvalid*/ java.util.@org.eclipse.jdt.annotation.NonNull List<Package> ECORE_collect = ((IdResolver.IdResolverExtension)idResolver).ecoreValueOfAll(Package.class, collect);
        oclAsType.getOwnedPackages().addAll(ECORE_collect);
        return true;
    }
}
