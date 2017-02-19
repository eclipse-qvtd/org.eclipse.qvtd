/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.tx;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation2;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.SetValue;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.FamiliesPackage;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.Member;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Families2PersonsFactory;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Families2PersonsPackage;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Persons.PersonsFactory;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Persons.PersonsPackage;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;
import org.eclipse.qvtd.runtime.library.model.ModelObjectsOfKindOperation;

/**
 * The Families2Persons transformation:
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
public class Families2Persons extends AbstractTransformer
{
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_org = IdManager.getRootPackageId("org");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NestedPackageId PACKid_eclipse = PACKid_org.getNestedPackageId("eclipse");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary = IdManager.getNsURIPackageId("http://www.eclipse.org/qvt/2017/QVTbaseLibrary", "qvtbaselib", null);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families", null, FamiliesPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families2Persons = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families2Persons", null, Families2PersonsPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Persons", null, PersonsPackage.eINSTANCE);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Class = PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Family = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families.getClassId("Family", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Female = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons.getClassId("Female", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Male = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons.getClassId("Male", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Member = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families.getClassId("Member", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Member2Female = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families2Persons.getClassId("Member2Female", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Member2Male = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families2Persons.getClassId("Member2Male", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Model = PACKid_http_c_s_s_www_eclipse_org_s_qvt_s_2015_s_QVTbaseLibrary.getClassId("Model", 0);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NestedPackageId PACKid_qvtd = PACKid_eclipse.getNestedPackageId("qvtd");
	public static final /*@NonInvalid*/ java.lang.@org.eclipse.jdt.annotation.NonNull String STR__32 = " ";
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NestedPackageId PACKid_xtext = PACKid_qvtd.getNestedPackageId("xtext");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull CollectionTypeId SET_CLSSid_Member = TypeId.SET.getSpecializedId(CLSSid_Member);
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NestedPackageId PACKid_qvtcore = PACKid_xtext.getNestedPackageId("qvtcore");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NestedPackageId PACKid_tests = PACKid_qvtcore.getNestedPackageId("tests");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull NestedPackageId PACKid_families2persons = PACKid_tests.getNestedPackageId("families2persons");
	public static final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull ClassId CLSSid_Families2Persons = PACKid_families2persons.getClassId("Families2Persons", 0);

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId[] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_Member                   // 0 => Member
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0}                     // 0 : Member -> {Member}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_isFemale = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_isFemale newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_isFemale(values);
		}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_familyName = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_familyName newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_familyName(values);
		}
	};


	public Families2Persons(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"family", "person", "middle"}, null, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		return MAP___root__() && invocationManager.flush();
	}

	/**
	 * ::isFemale(member : Families::Member[1]) : Boolean[1]
	 */
	protected class FUN_isFemale extends AbstractComputation
	{
		protected final @NonNull Families2Persons self;
		protected /*@NonInvalid*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.NonNull Member member;
		protected final /*@NonInvalid*/ boolean symbol_3;

		/**
		 *
		 * if not2 member.familyMother.oclIsUndefined()
		 * then true
		 * else
		 *   if not2 member.familyDaughter.oclIsUndefined()
		 *   then true
		 *   else false
		 *   endif
		 * endif
		 */
		public FUN_isFemale(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (Families2Persons)boundValues[0];
			this.member = (Member)boundValues[1];
			/*@Caught*/ @Nullable Object CAUGHT_familyMother;
			try {
				final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.Nullable Family familyMother = member.getFamilyMother();
				CAUGHT_familyMother = familyMother;
			}
			catch (Exception e) {
				CAUGHT_familyMother = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean symbol_0 = (CAUGHT_familyMother == null) || (CAUGHT_familyMother instanceof InvalidValueException);
			final /*@NonInvalid*/ boolean not2 = BooleanNotOperation2.INSTANCE.evaluate(symbol_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_3;
			if (not2) {
				symbol_3 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_familyDaughter;
				try {
					final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.Nullable Family familyDaughter = member.getFamilyDaughter();
					CAUGHT_familyDaughter = familyDaughter;
				}
				catch (Exception e) {
					CAUGHT_familyDaughter = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean symbol_1 = (CAUGHT_familyDaughter == null) || (CAUGHT_familyDaughter instanceof InvalidValueException);
				final /*@NonInvalid*/ boolean not2_0 = BooleanNotOperation2.INSTANCE.evaluate(symbol_1).booleanValue();
				/*@NonInvalid*/ boolean symbol_2;
				if (not2_0) {
					symbol_2 = ValueUtil.TRUE_VALUE;
				}
				else {
					symbol_2 = ValueUtil.FALSE_VALUE;
				}
				symbol_3 = symbol_2;
			}
			this.symbol_3 = symbol_3;
		}

		@Override
		public @Nullable Object getResult() {
			return symbol_3;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
					&& idResolver.oclEquals(this.member, thoseValues[1]);
		}
	}

	/**
	 * ::familyName(member : Families::Member[1]) : String[1]
	 */
	protected class FUN_familyName extends AbstractComputation
	{
		protected final @NonNull Families2Persons self;
		protected /*@NonInvalid*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.NonNull Member member_0;
		protected final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String symbol_5;

		/**
		 *
		 * if not2 member.familyFather.oclIsUndefined()
		 * then member.familyFather.lastName
		 * else
		 *   if not2 member.familyMother.oclIsUndefined()
		 *   then member.familyMother.lastName
		 *   else
		 *     if not2 member.familySon.oclIsUndefined()
		 *     then member.familySon.lastName
		 *     else member.familyDaughter.lastName
		 *     endif
		 *   endif
		 * endif
		 */
		public FUN_familyName(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (Families2Persons)boundValues[0];
			this.member_0 = (Member)boundValues[1];
			/*@Caught*/ @Nullable Object CAUGHT_familyFather;
			try {
				final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.Nullable Family familyFather = member_0.getFamilyFather();
				CAUGHT_familyFather = familyFather;
			}
			catch (Exception e) {
				CAUGHT_familyFather = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean symbol_0 = (CAUGHT_familyFather == null) || (CAUGHT_familyFather instanceof InvalidValueException);
			final /*@NonInvalid*/ boolean not2 = BooleanNotOperation2.INSTANCE.evaluate(symbol_0).booleanValue();
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String symbol_5;
			if (not2) {
				final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.Nullable Family familyFather_0 = member_0.getFamilyFather();
				if (familyFather_0 == null) {
					throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String lastName = familyFather_0.getLastName();
				symbol_5 = lastName;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_familyMother;
				try {
					final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.Nullable Family familyMother = member_0.getFamilyMother();
					CAUGHT_familyMother = familyMother;
				}
				catch (Exception e) {
					CAUGHT_familyMother = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean symbol_1 = (CAUGHT_familyMother == null) || (CAUGHT_familyMother instanceof InvalidValueException);
				final /*@NonInvalid*/ boolean not2_0 = BooleanNotOperation2.INSTANCE.evaluate(symbol_1).booleanValue();
				/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String symbol_4;
				if (not2_0) {
					final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.Nullable Family familyMother_0 = member_0.getFamilyMother();
					if (familyMother_0 == null) {
						throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String lastName_0 = familyMother_0.getLastName();
					symbol_4 = lastName_0;
				}
				else {
					/*@Caught*/ @Nullable Object CAUGHT_familySon;
					try {
						final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.Nullable Family familySon = member_0.getFamilySon();
						CAUGHT_familySon = familySon;
					}
					catch (Exception e) {
						CAUGHT_familySon = ValueUtil.createInvalidValue(e);
					}
					final /*@NonInvalid*/ boolean symbol_2 = (CAUGHT_familySon == null) || (CAUGHT_familySon instanceof InvalidValueException);
					final /*@NonInvalid*/ boolean not2_1 = BooleanNotOperation2.INSTANCE.evaluate(symbol_2).booleanValue();
					/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String symbol_3;
					if (not2_1) {
						final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.Nullable Family familySon_0 = member_0.getFamilySon();
						if (familySon_0 == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String lastName_1 = familySon_0.getLastName();
						symbol_3 = lastName_1;
					}
					else {
						final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.Nullable Family familyDaughter = member_0.getFamilyDaughter();
						if (familyDaughter == null) {
							throw new InvalidValueException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String lastName_2 = familyDaughter.getLastName();
						symbol_3 = lastName_2;
					}
					symbol_4 = symbol_3;
				}
				symbol_5 = symbol_4;
			}
			this.symbol_5 = symbol_5;
		}

		@Override
		public @Nullable Object getResult() {
			return symbol_5;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
					&& idResolver.oclEquals(this.member_0, thoseValues[1]);
		}
	}

	/**
	 *
	 * map __root__ in Families2Persons {
	 *
	 *   var _'\u00ABMember\u00BB' : Set(Families::Member) := family.objectsOfKind(Families::Member)
	 *   ;
	 * ::ji_Member : Set(Families::Member)[*|1]for loop0 : Families::Member[1] in ji_Member {
	 *     call _'m_Member2Female_Member_Boolean.r0' {
	 * s iterates loop0 : Families::Member[1];
	 * }}
	 *   for loop0 : Families::Member[1] in ji_Member {
	 *     call _'m_Member2Male_Member_Boolean.r0' {
	 * s iterates loop0 : Families::Member[1];
	 * }}
	 */
	protected boolean MAP___root__()  {
		try {
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.ids.@org.eclipse.jdt.annotation.NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.@org.eclipse.jdt.annotation.NonNull Class TYP_Families_c_c_Member_0 = idResolver.getClass(CLSSid_Member, null);
			final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@org.eclipse.jdt.annotation.NonNull SetValue objectsOfKind = ModelObjectsOfKindOperation.INSTANCE.evaluate(executor, SET_CLSSid_Member, models[0/*family*/], TYP_Families_c_c_Member_0);
			// connection variables
			final SetValue.@NonNull Accumulator ji_Member = createUnenforcedSetAccumulatorValue(SET_CLSSid_Member);
			for (org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.NonNull Member iterator : ValueUtil.typedIterable(Member.class, objectsOfKind)) {
				ji_Member.add(iterator);
			}
			// mapping statements
			for (org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.NonNull Member loop0 : ValueUtil.typedIterable(Member.class, ji_Member)) {
				MAP_m_Member2Female_Member_Boolean_46r0(loop0);
			}
			for (org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.NonNull Member loop0_0 : ValueUtil.typedIterable(Member.class, ji_Member)) {
				MAP_m_Member2Male_Member_Boolean_46r0(loop0_0);
			}
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
			return __root__;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP___root__", e);
		}
	}

	/**
	 *
	 * map _'m_Member2Female_Member_Boolean.r0' in Families2Persons {
	 *
	 *   guard:family s  : Families::Member[1];
	 * var firstName : String[1] := s.firstName;
	 * check this.isFemale(s);
	 * new:middle m2m : Families2Persons::Member2Female[1];
	 * new:person t : Persons::Female[1];
	 * set m2m.member := s;
	 * set m2m.person := t;
	 * set t.fullName := firstName + ' ' +
	 *   this.familyName(s);
	 *
	 */
	protected boolean MAP_m_Member2Female_Member_Boolean_46r0(final /*@NonInvalid*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.NonNull Member s)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String firstName = s.getFirstName();
			final /*@Thrown*/ boolean isFemale = ((FUN_isFemale)FTOR_isFemale.getUniqueComputation(this, s)).symbol_3;
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_4;
			if (isFemale) {
				// creations
				final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.@org.eclipse.jdt.annotation.Nullable Member2Female m2m = Families2PersonsFactory.eINSTANCE.createMember2Female();
				assert m2m != null;
				models[2/*middle*/].add(m2m);
				final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Persons.@org.eclipse.jdt.annotation.Nullable Female t = PersonsFactory.eINSTANCE.createFemale();
				assert t != null;
				models[1/*person*/].add(t);
				// mapping statements
				m2m.setMember(s);
				m2m.setPerson(t);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(firstName, STR__32);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String familyName = ((FUN_familyName)FTOR_familyName.getUniqueComputation(this, s)).symbol_5;
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, familyName);
				t.setFullName(sum_0);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Member2Female_Member_Boolean_r0 = ValueUtil.TRUE_VALUE;
				symbol_4 = m_Member2Female_Member_Boolean_r0;
			}
			else {
				symbol_4 = ValueUtil.FALSE_VALUE;
			}
			return symbol_4;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Member2Female_Member_Boolean_46r0", e);
		}
	}

	/**
	 *
	 * map _'m_Member2Male_Member_Boolean.r0' in Families2Persons {
	 *
	 *   guard:family s  : Families::Member[1];
	 * var firstName : String[1] := s.firstName;
	 * check not2 this.isFemale(s);
	 * new:middle m2m : Families2Persons::Member2Male[1];
	 * new:person t : Persons::Male[1];
	 * set m2m.member := s;
	 * set m2m.person := t;
	 * set t.fullName := firstName + ' ' +
	 *   this.familyName(s);
	 *
	 */
	protected boolean MAP_m_Member2Male_Member_Boolean_46r0(final /*@NonInvalid*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.@org.eclipse.jdt.annotation.NonNull Member s_0)  {
		try {
			@SuppressWarnings("null")
			final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String firstName = s_0.getFirstName();
			final /*@Thrown*/ boolean isFemale = ((FUN_isFemale)FTOR_isFemale.getUniqueComputation(this, s_0)).symbol_3;
			final /*@Thrown*/ boolean not2 = BooleanNotOperation2.INSTANCE.evaluate(isFemale).booleanValue();
			/*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean symbol_4;
			if (not2) {
				// creations
				final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.@org.eclipse.jdt.annotation.Nullable Member2Male m2m = Families2PersonsFactory.eINSTANCE.createMember2Male();
				assert m2m != null;
				models[2/*middle*/].add(m2m);
				final /*@Thrown*/ org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Persons.@org.eclipse.jdt.annotation.Nullable Male t = PersonsFactory.eINSTANCE.createMale();
				assert t != null;
				models[1/*person*/].add(t);
				// mapping statements
				m2m.setMember(s_0);
				m2m.setPerson(t);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum = StringConcatOperation.INSTANCE.evaluate(firstName, STR__32);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String familyName = ((FUN_familyName)FTOR_familyName.getUniqueComputation(this, s_0)).symbol_5;
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, familyName);
				t.setFullName(sum_0);
				final /*@Thrown*/ java.lang.@org.eclipse.jdt.annotation.Nullable Boolean m_Member2Male_Member_Boolean_r0 = ValueUtil.TRUE_VALUE;
				symbol_4 = m_Member2Male_Member_Boolean_r0;
			}
			else {
				symbol_4 = ValueUtil.FALSE_VALUE;
			}
			return symbol_4;
		} catch (Throwable e) {
			return handleExecutionFailure("MAP_m_Member2Male_Member_Boolean_46r0", e);
		}
	}
}
