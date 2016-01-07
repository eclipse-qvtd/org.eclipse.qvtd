/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.codegen.java.JavaStream
 *
 * Do not edit it.
 ********************************************************************************/

package cg._F2P;

import build.test.families2persons.Families.FamiliesPackage;
import build.test.families2persons.Families.Family;
import build.test.families2persons.Families.Member;
import build.test.families2persons.Families2Persons.Families2PersonsFactory;
import build.test.families2persons.Families2Persons.Families2PersonsPackage;
import build.test.families2persons.Families2Persons.Member2Female;
import build.test.families2persons.Families2Persons.Member2Male;
import build.test.families2persons.Persons.Female;
import build.test.families2persons.Persons.Male;
import build.test.families2persons.Persons.PersonsFactory;
import build.test.families2persons.Persons.PersonsPackage;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.collection.CollectionSelectByKindOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclAsSetOperation;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.pivot.qvtimperative.library.model.RootObjectsOperation;

/**
 * The F2P transformation:
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
public class F2P extends AbstractTransformer
{
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTbaseLibrary", "qvtbaselib", null);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore_s_examples_s_Families = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTcore/examples/Families", null, FamiliesPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore_s_examples_s_Families2Persons = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTcore/examples/Families2Persons", null, Families2PersonsPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore_s_examples_s_Persons = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2015/QVTcore/examples/Persons", null, PersonsPackage.eINSTANCE);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Family = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore_s_examples_s_Families.getClassId("Family", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Female = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore_s_examples_s_Persons.getClassId("Female", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Male = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore_s_examples_s_Persons.getClassId("Male", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Member = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore_s_examples_s_Families.getClassId("Member", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Member2Female = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore_s_examples_s_Families2Persons.getClassId("Member2Female", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Member2Male = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTcore_s_examples_s_Families2Persons.getClassId("Member2Male", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Transformation = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Transformation", 0);
    public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR__32 = " ";
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Family = TypeId.SET.getSpecializedId(CLSSid_Family);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Member = TypeId.SET.getSpecializedId(CLSSid_Member);
    public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_OclElement = TypeId.SET.getSpecializedId(CLSSid_OclElement);
    
    
    
    public F2P(final @NonNull Executor executor) throws ReflectiveOperationException {
        super(executor, new @NonNull String[] {"family", "person", "middle"}, null, null, null);
    }
    
    public boolean run() throws ReflectiveOperationException {
        return MAP___root__() && invocationManager.flush();
    }
    
    protected @Nullable Boolean isFemale(final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Member member) {
        /*@Caught*/ @Nullable Object CAUGHT_familyMother;
        try {
            if (member == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTcore/examples/Families\'::Member::familyMother\'");
            }
            final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Family familyMother = member.getFamilyMother();
            CAUGHT_familyMother = familyMother;
        }
        catch (Exception e) {
            CAUGHT_familyMother = ValueUtil.createInvalidValue(e);
        }
        final /*@NonInvalid*/ boolean symbol_0 = (CAUGHT_familyMother == null) || (CAUGHT_familyMother instanceof InvalidValueException);
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(symbol_0);
        if (not == null) {
            throw new InvalidValueException("Null if condition");
        }
        /*@NonInvalid*/ boolean symbol_3;
        if (not) {
            symbol_3 = ValueUtil.TRUE_VALUE;
        }
        else {
            /*@Caught*/ @Nullable Object CAUGHT_familyDaughter;
            try {
                if (member == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTcore/examples/Families\'::Member::familyDaughter\'");
                }
                final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Family familyDaughter = member.getFamilyDaughter();
                CAUGHT_familyDaughter = familyDaughter;
            }
            catch (Exception e) {
                CAUGHT_familyDaughter = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ boolean symbol_1 = (CAUGHT_familyDaughter == null) || (CAUGHT_familyDaughter instanceof InvalidValueException);
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(symbol_1);
            if (not_0 == null) {
                throw new InvalidValueException("Null if condition");
            }
            /*@NonInvalid*/ boolean symbol_2;
            if (not_0) {
                symbol_2 = ValueUtil.TRUE_VALUE;
            }
            else {
                symbol_2 = ValueUtil.FALSE_VALUE;
            }
            symbol_3 = symbol_2;
        }
        return symbol_3;
    }
    
    protected @Nullable String familyName(final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Member member_0) {
        if (member_0 == null) {
            throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTcore/examples/Families\'::Member::familyFather\'");
        }
        /*@Caught*/ @Nullable Object CAUGHT_familyFather;
        try {
            final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Family familyFather = member_0.getFamilyFather();
            CAUGHT_familyFather = familyFather;
        }
        catch (Exception e) {
            CAUGHT_familyFather = ValueUtil.createInvalidValue(e);
        }
        final /*@NonInvalid*/ boolean symbol_0 = (CAUGHT_familyFather == null) || (CAUGHT_familyFather instanceof InvalidValueException);
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(symbol_0);
        if (not == null) {
            throw new InvalidValueException("Null if condition");
        }
        /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String symbol_5;
        if (not) {
            final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Family familyFather_0 = member_0.getFamilyFather();
            if (familyFather_0 == null) {
                throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTcore/examples/Families\'::Family::lastName\'");
            }
            @SuppressWarnings("null")
            final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String lastName = familyFather_0.getLastName();
            symbol_5 = lastName;
        }
        else {
            /*@Caught*/ @Nullable Object CAUGHT_familyMother;
            try {
                final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Family familyMother = member_0.getFamilyMother();
                CAUGHT_familyMother = familyMother;
            }
            catch (Exception e) {
                CAUGHT_familyMother = ValueUtil.createInvalidValue(e);
            }
            final /*@NonInvalid*/ boolean symbol_1 = (CAUGHT_familyMother == null) || (CAUGHT_familyMother instanceof InvalidValueException);
            final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_0 = BooleanNotOperation.INSTANCE.evaluate(symbol_1);
            if (not_0 == null) {
                throw new InvalidValueException("Null if condition");
            }
            /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String symbol_4;
            if (not_0) {
                final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Family familyMother_0 = member_0.getFamilyMother();
                if (familyMother_0 == null) {
                    throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTcore/examples/Families\'::Family::lastName\'");
                }
                @SuppressWarnings("null")
                final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String lastName_0 = familyMother_0.getLastName();
                symbol_4 = lastName_0;
            }
            else {
                /*@Caught*/ @Nullable Object CAUGHT_familySon;
                try {
                    final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Family familySon = member_0.getFamilySon();
                    CAUGHT_familySon = familySon;
                }
                catch (Exception e) {
                    CAUGHT_familySon = ValueUtil.createInvalidValue(e);
                }
                final /*@NonInvalid*/ boolean symbol_2 = (CAUGHT_familySon == null) || (CAUGHT_familySon instanceof InvalidValueException);
                final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not_1 = BooleanNotOperation.INSTANCE.evaluate(symbol_2);
                if (not_1 == null) {
                    throw new InvalidValueException("Null if condition");
                }
                /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String symbol_3;
                if (not_1) {
                    final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Family familySon_0 = member_0.getFamilySon();
                    if (familySon_0 == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTcore/examples/Families\'::Family::lastName\'");
                    }
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String lastName_1 = familySon_0.getLastName();
                    symbol_3 = lastName_1;
                }
                else {
                    final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.Nullable Family familyDaughter = member_0.getFamilyDaughter();
                    if (familyDaughter == null) {
                        throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvt/2015/QVTcore/examples/Families\'::Family::lastName\'");
                    }
                    @SuppressWarnings("null")
                    final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String lastName_2 = familyDaughter.getLastName();
                    symbol_3 = lastName_2;
                }
                symbol_4 = symbol_3;
            }
            symbol_5 = symbol_4;
        }
        return symbol_5;
    }
    
    /**
     * 
     * map _'Families%Family%daughters' in F2P {
     * 
     *   family (_'-parent-' : Families::Family[1];
     *  |)
     * { |}
     * where (_'-join-Member-0' : Set(Families::Member[*|1]);
     *  |)
     * {allChildren : Set(Families::Member) = _'-parent-'.daughters->selectByKind(Families::Member)
     *   ;
     * _'-child-Member-' : Set(Families::Member[*|1]) = allChildren->selectByKind(Families::Member);
     *  |
     * _'-join-Member-0' += _'-child-Member-';
     * }
     * 
     */
    protected boolean MAP_Families_37Family_37daughters(final SetValue.@NonNull Accumulator _m_join_m_Member_m_0, final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Family _m_parent_m) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_Families_c_c_Member_1 = idResolver.getClass(CLSSid_Member, null);
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ List<Member> daughters = _m_parent_m.getDaughters();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_daughters = idResolver.createSetOfAll(SET_CLSSid_Member, daughters);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_daughters, TYP_Families_c_c_Member_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_0 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_Families_c_c_Member_1));
        // connection assignments
        for (Member iterator : ValueUtil.typedIterable(Member.class, selectByKind_0)) {
            if (iterator instanceof Member) {
                _m_join_m_Member_m_0.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'Families%Family%father' in F2P {
     * 
     *   family (_'-parent-' : Families::Family[1];
     *  |)
     * { |}
     * where (_'-join-Member-0' : Set(Families::Member[*|1]);
     *  |)
     * {allChildren : Set(Families::Member[*|1]) = _'-parent-'.father.oclAsSet()
     *   ;
     * _'-child-Member-' : Set(Families::Member[*|1]) = allChildren->selectByKind(Families::Member);
     *  |
     * _'-join-Member-0' += _'-child-Member-';
     * }
     * 
     */
    protected boolean MAP_Families_37Family_37father(final SetValue.@NonNull Accumulator _m_join_m_Member_m_0_0, final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Family _m_parent_m_0) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_Families_c_c_Member_0 = idResolver.getClass(CLSSid_Member, null);
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Member father = _m_parent_m_0.getFather();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = ClassUtil.nonNullState(OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Member, father));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_Families_c_c_Member_0));
        // connection assignments
        for (Member iterator : ValueUtil.typedIterable(Member.class, selectByKind)) {
            if (iterator instanceof Member) {
                _m_join_m_Member_m_0_0.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'Families%Family%mother' in F2P {
     * 
     *   family (_'-parent-' : Families::Family[1];
     *  |)
     * { |}
     * where (_'-join-Member-0' : Set(Families::Member[*|1]);
     *  |)
     * {allChildren : Set(Families::Member[*|1]) = _'-parent-'.mother.oclAsSet()
     *   ;
     * _'-child-Member-' : Set(Families::Member[*|1]) = allChildren->selectByKind(Families::Member);
     *  |
     * _'-join-Member-0' += _'-child-Member-';
     * }
     * 
     */
    protected boolean MAP_Families_37Family_37mother(final SetValue.@NonNull Accumulator _m_join_m_Member_m_0_1, final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Family _m_parent_m_1) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_Families_c_c_Member_0 = idResolver.getClass(CLSSid_Member, null);
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Member mother = _m_parent_m_1.getMother();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue oclAsSet = ClassUtil.nonNullState(OclAnyOclAsSetOperation.INSTANCE.evaluate(executor, SET_CLSSid_Member, mother));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, oclAsSet, TYP_Families_c_c_Member_0));
        // connection assignments
        for (Member iterator : ValueUtil.typedIterable(Member.class, selectByKind)) {
            if (iterator instanceof Member) {
                _m_join_m_Member_m_0_1.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map _'Families%Family%sons' in F2P {
     * 
     *   family (_'-parent-' : Families::Family[1];
     *  |)
     * { |}
     * where (_'-join-Member-0' : Set(Families::Member[*|1]);
     *  |)
     * {allChildren : Set(Families::Member) = _'-parent-'.sons->selectByKind(Families::Member)
     *   ;
     * _'-child-Member-' : Set(Families::Member[*|1]) = allChildren->selectByKind(Families::Member);
     *  |
     * _'-join-Member-0' += _'-child-Member-';
     * }
     * 
     */
    protected boolean MAP_Families_37Family_37sons(final SetValue.@NonNull Accumulator _m_join_m_Member_m_0_2, final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Family _m_parent_m_2) throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_Families_c_c_Member_1 = idResolver.getClass(CLSSid_Member, null);
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ List<Member> sons = _m_parent_m_2.getSons();
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue BOXED_sons = idResolver.createSetOfAll(SET_CLSSid_Member, sons);
        final /*@Thrown*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, BOXED_sons, TYP_Families_c_c_Member_1));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_0 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, selectByKind, TYP_Families_c_c_Member_1));
        // connection assignments
        for (Member iterator : ValueUtil.typedIterable(Member.class, selectByKind_0)) {
            if (iterator instanceof Member) {
                _m_join_m_Member_m_0_2.add(iterator);
            }
        }
        return true;
    }
    
    /**
     * 
     * map Member2Female in F2P {
     * 
     *   family (s : Families::Member[?];
     *  |)
     * { |}
     * middle ( |)
     * {realize m2m : Families2Persons::Member2Female[1];
     *  |}
     * person ( |)
     * {realize t : Persons::Female[1];
     *  |}
     * where ( |
     * this.isFemale(s))
     * {firstName : String[1] = s.firstName;
     * _'+' : String[1] = firstName +
     *   ' ';
     * familyName1 : String[?] = this.familyName(s);
     * _'+1' : String[1] = _'+' + familyName1;
     *  |
     * t.fullName := _'+1';
     * m2m.member := s;
     * m2m.person := t;
     * }
     * 
     */
    protected boolean MAP_Member2Female(final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Member s) throws ReflectiveOperationException {
        // predicates
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean isFemale = isFemale(s);
        if (isFemale != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String firstName = s.getFirstName();
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(firstName, STR__32));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String familyName = familyName(s);
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum, familyName));
        // creations
        final /*@Thrown*/ build.test.families2persons.Families2Persons.@org.eclipse.jdt.annotation.Nullable Member2Female m2m = Families2PersonsFactory.eINSTANCE.createMember2Female();
        assert m2m != null;
        models[2/*middle*/].add(m2m);
        final /*@Thrown*/ build.test.families2persons.Persons.@org.eclipse.jdt.annotation.Nullable Female t = PersonsFactory.eINSTANCE.createFemale();
        assert t != null;
        models[1/*person*/].add(t);
        // property assignments
        t.setFullName(sum_0);
        m2m.setMember(s);
        m2m.setPerson(t);
        return true;
    }
    
    /**
     * 
     * map Member2Male in F2P {
     * 
     *   family (s : Families::Member[?];
     *  |)
     * { |}
     * middle ( |)
     * {realize m2m : Families2Persons::Member2Male[1];
     *  |}
     * person ( |)
     * {realize t : Persons::Male[1];
     *  |}
     * where ( |
     * not this.isFemale(s))
     * {firstName : String[1] = s.firstName;
     * _'+' : String[1] = firstName +
     *   ' ';
     * familyName1 : String[?] = this.familyName(s);
     * _'+1' : String[1] = _'+' + familyName1;
     *  |
     * t.fullName := _'+1';
     * m2m.member := s;
     * m2m.person := t;
     * }
     * 
     */
    protected boolean MAP_Member2Male(final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Member s_0) throws ReflectiveOperationException {
        // predicates
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean isFemale = isFemale(s_0);
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(isFemale);
        if (not != ValueUtil.TRUE_VALUE) {
            return false;
        }
        // variable assignments
        @SuppressWarnings("null")
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String firstName = s_0.getFirstName();
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(firstName, STR__32));
        final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable String familyName = familyName(s_0);
        final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = ClassUtil.nonNullState(StringConcatOperation.INSTANCE.evaluate(sum, familyName));
        // creations
        final /*@Thrown*/ build.test.families2persons.Families2Persons.@org.eclipse.jdt.annotation.Nullable Member2Male m2m = Families2PersonsFactory.eINSTANCE.createMember2Male();
        assert m2m != null;
        models[2/*middle*/].add(m2m);
        final /*@Thrown*/ build.test.families2persons.Persons.@org.eclipse.jdt.annotation.Nullable Male t = PersonsFactory.eINSTANCE.createMale();
        assert t != null;
        models[1/*person*/].add(t);
        // property assignments
        t.setFullName(sum_0);
        m2m.setMember(s_0);
        m2m.setPerson(t);
        return true;
    }
    
    /**
     * 
     * map __root__ in F2P {
     * 
     *   where ( |)
     * {roots : Set(OclElement) = family.rootObjects()
     *   ;
     * _'-child-Family-' : Set(Families::Family[*|1]) = roots->selectByKind(Families::Family)
     *   ;
     * _'-join-Family-0' : Set(Families::Family[*|1]) = _'-child-Family-';
     * _'-child-Member-' : Set(Families::Member[*|1]) = roots->selectByKind(Families::Member)
     *   ;
     * _'-join-Member-0' : Set(Families::Member[*|1]) = _'-child-Member-';
     *  |}
     * for loop0 : Families::Family in _'-join-Family-0' {
     * 
     *     map _'Families%Family%sons' {
     * _'-join-Member-0' := _'-join-Member-0';
     * _'-parent-' := loop0;
     * }}
     *   for loop0 : Families::Family in _'-join-Family-0' {
     * 
     *     map _'Families%Family%father' {
     * _'-join-Member-0' := _'-join-Member-0';
     * _'-parent-' := loop0;
     * }}
     *   for loop0 : Families::Family in _'-join-Family-0' {
     * 
     *     map _'Families%Family%mother' {
     * _'-join-Member-0' := _'-join-Member-0';
     * _'-parent-' := loop0;
     * }}
     *   for loop0 : Families::Family in _'-join-Family-0' {
     * 
     *     map _'Families%Family%daughters' {
     * _'-join-Member-0' := _'-join-Member-0';
     * _'-parent-' := loop0;
     * }}
     *   for loop0 : Families::Member in _'-join-Member-0' {
     * 
     *     map Member2Female {
     * s := loop0;
     * }}
     *   for loop0 : Families::Member in _'-join-Member-0' {
     * 
     *     map Member2Male {
     * s := loop0;
     * }}
     */
    protected boolean MAP___root__() throws ReflectiveOperationException {
        // predicates
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_Families_c_c_Family_0 = idResolver.getClass(CLSSid_Family, null);
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_Families_c_c_Member_0 = idResolver.getClass(CLSSid_Member, null);
        // variable assignments
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue rootObjects = ClassUtil.nonNullState(RootObjectsOperation.INSTANCE.evaluate(executor, SET_CLSSid_OclElement, models[0/*family*/]));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_Families_c_c_Family_0));
        final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue selectByKind_0 = ClassUtil.nonNullState((SetValue)CollectionSelectByKindOperation.INSTANCE.evaluate(executor, rootObjects, TYP_Families_c_c_Member_0));
        // connection variables
        final SetValue.@NonNull Accumulator _m_join_m_Member_m_0_7 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_Member);
        for (Member iterator : ValueUtil.typedIterable(Member.class, selectByKind_0)) {
            _m_join_m_Member_m_0_7.add(iterator);
        }
        // mapping statements
        for (Family loop0 : ValueUtil.typedIterable(Family.class, selectByKind)) {
            if (loop0 != null) {
                final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Family symbol_0 = (Family)loop0;
                MAP_Families_37Family_37sons(_m_join_m_Member_m_0_7, symbol_0);
            }
        }
        for (Family loop0_0 : ValueUtil.typedIterable(Family.class, selectByKind)) {
            if (loop0_0 != null) {
                final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Family symbol_2 = (Family)loop0_0;
                MAP_Families_37Family_37father(_m_join_m_Member_m_0_7, symbol_2);
            }
        }
        for (Family loop0_1 : ValueUtil.typedIterable(Family.class, selectByKind)) {
            if (loop0_1 != null) {
                final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Family symbol_4 = (Family)loop0_1;
                MAP_Families_37Family_37mother(_m_join_m_Member_m_0_7, symbol_4);
            }
        }
        for (Family loop0_2 : ValueUtil.typedIterable(Family.class, selectByKind)) {
            if (loop0_2 != null) {
                final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Family symbol_6 = (Family)loop0_2;
                MAP_Families_37Family_37daughters(_m_join_m_Member_m_0_7, symbol_6);
            }
        }
        for (Member loop0_3 : ValueUtil.typedIterable(Member.class, _m_join_m_Member_m_0_7)) {
            if (loop0_3 != null) {
                final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Member symbol_8 = (Member)loop0_3;
                if (symbol_8 != null) {
                    MAP_Member2Female(symbol_8);
                }
            }
        }
        for (Member loop0_4 : ValueUtil.typedIterable(Member.class, _m_join_m_Member_m_0_7)) {
            if (loop0_4 != null) {
                final /*@NonInvalid*/ build.test.families2persons.Families.@org.eclipse.jdt.annotation.NonNull Member symbol_10 = (Member)loop0_4;
                if (symbol_10 != null) {
                    MAP_Member2Male(symbol_10);
                }
            }
        }
        return true;
    }
}
