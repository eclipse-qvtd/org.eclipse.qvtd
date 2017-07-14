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
import org.eclipse.ocl.pivot.ids.NestedPackageId;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation2;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.FamiliesPackage;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.Family;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families.Member;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Families2PersonsFactory;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Families2PersonsPackage;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Member2Female;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Families2Persons.Member2Male;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Persons.Female;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Persons.Male;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Persons.PersonsFactory;
import org.eclipse.qvtd.doc.bigmde2016.tests.qvtc.Persons.PersonsPackage;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;

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
@SuppressWarnings("unused")
public class Families2Persons extends AbstractTransformer
{
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_org = IdManager.getRootPackageId("org");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_eclipse = PACKid_org.getNestedPackageId("eclipse");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families", null, FamiliesPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families2Persons = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families2Persons", null, Families2PersonsPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Persons", null, PersonsPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Family = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families.getClassId("Family", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Female = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons.getClassId("Female", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Male = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons.getClassId("Male", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Member = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families.getClassId("Member", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Member2Female = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families2Persons.getClassId("Member2Female", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Member2Male = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families2Persons.getClassId("Member2Male", 0);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_qvtd = PACKid_eclipse.getNestedPackageId("qvtd");
	public static final /*@NonInvalid*/ @NonNull String STR__32 = " ";
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_xtext = PACKid_qvtd.getNestedPackageId("xtext");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_qvtcore = PACKid_xtext.getNestedPackageId("qvtcore");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_tests = PACKid_qvtcore.getNestedPackageId("tests");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_families2persons = PACKid_tests.getNestedPackageId("families2persons");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Families2Persons = PACKid_families2persons.getClassId("Families2Persons", 0);

	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId = new @NonNull ClassId[]{
		CLSSid_Member                         // 0 => Member
	};

	/*
	 * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index
	 * may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes = new int @NonNull [] @NonNull [] {
		{0}                           // 0 : Member -> {Member}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_familyName = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_familyName newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_familyName(values);
		}
	};

	protected final @NonNull AbstractComputationConstructor FTOR_isFemale = new AbstractComputationConstructor(idResolver)
	{
		@Override
		public @NonNull FUN_isFemale newInstance(@Nullable Object @NonNull [] values) {
			return new FUN_isFemale(values);
		}
	};


	public Families2Persons(final @NonNull TransformationExecutor executor) {
		super(executor, new @NonNull String[] {"family", "person", "middle", "$primitive$"}, null, classIndex2classId, classIndex2allClassIndexes);
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_Member = models[0/*family*/].getConnection(0/*Families::Member*/);
		return MAP___root__(ji_Member) && invocationManager.flush();
	}

	/**
	 * ::familyName(member : Families::Member[1]) : String[1]
	 */
	protected class FUN_familyName extends AbstractComputation
	{
		protected final @NonNull Families2Persons self;
		protected /*@NonInvalid*/ @NonNull Member member;
		protected final /*@Thrown*/ @NonNull String instance;

		/**
		 *
		 * if member.familyFather.oclIsUndefined().not2()
		 * then member.familyFather.lastName
		 * else
		 *   if member.familyMother.oclIsUndefined().not2()
		 *   then member.familyMother.lastName
		 *   else
		 *     if member.familySon.oclIsUndefined().not2()
		 *     then member.familySon.lastName
		 *     else member.familyDaughter.lastName
		 *     endif
		 *   endif
		 * endif
		 */
		public FUN_familyName(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (Families2Persons)boundValues[0];
			this.member = (Member)boundValues[1];
			final /*@NonInvalid*/ @Nullable Family familyFather_0 = member.getFamilyFather();
			final /*@NonInvalid*/ boolean symbol_0 = familyFather_0 == null;
			final /*@NonInvalid*/ boolean not2 = BooleanNotOperation2.INSTANCE.evaluate(symbol_0).booleanValue();
			/*@Thrown*/ @NonNull String symbol_5;
			if (not2) {
				if (familyFather_0 == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull String lastName = familyFather_0.getLastName();
				symbol_5 = lastName;
			}
			else {
				final /*@NonInvalid*/ @Nullable Family familyMother_0 = member.getFamilyMother();
				final /*@NonInvalid*/ boolean symbol_1 = familyMother_0 == null;
				final /*@NonInvalid*/ boolean not2_0 = BooleanNotOperation2.INSTANCE.evaluate(symbol_1).booleanValue();
				/*@Thrown*/ @NonNull String symbol_4;
				if (not2_0) {
					if (familyMother_0 == null) {
						throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull String lastName_0 = familyMother_0.getLastName();
					symbol_4 = lastName_0;
				}
				else {
					final /*@NonInvalid*/ @Nullable Family familySon_0 = member.getFamilySon();
					final /*@NonInvalid*/ boolean symbol_2 = familySon_0 == null;
					final /*@NonInvalid*/ boolean not2_1 = BooleanNotOperation2.INSTANCE.evaluate(symbol_2).booleanValue();
					/*@Thrown*/ @NonNull String symbol_3;
					if (not2_1) {
						if (familySon_0 == null) {
							throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull String lastName_1 = familySon_0.getLastName();
						symbol_3 = lastName_1;
					}
					else {
						final /*@NonInvalid*/ @Nullable Family familyDaughter = member.getFamilyDaughter();
						if (familyDaughter == null) {
							throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull String lastName_2 = familyDaughter.getLastName();
						symbol_3 = lastName_2;
					}
					symbol_4 = symbol_3;
				}
				symbol_5 = symbol_4;
			}
			this.instance = symbol_5;
		}

		@Override
		public @Nullable Object getResult() {
			return instance;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @Nullable Object @NonNull [] thoseValues) {
			return this.self == thoseValues[0]
					&& idResolver.oclEquals(this.member, thoseValues[1]);
		}
	}

	/**
	 * ::isFemale(member : Families::Member[1]) : Boolean[1]
	 */
	protected class FUN_isFemale extends AbstractComputation
	{
		protected final @NonNull Families2Persons self;
		protected /*@NonInvalid*/ @NonNull Member member_0;
		protected final /*@NonInvalid*/ boolean symbol_3;

		/**
		 *
		 * if member.familyMother.oclIsUndefined().not2()
		 * then true
		 * else
		 *   if member.familyDaughter.oclIsUndefined().not2()
		 *   then true
		 *   else false
		 *   endif
		 * endif
		 */
		public FUN_isFemale(/*Nullable*/ Object @NonNull [] boundValues) {
			this.self = (Families2Persons)boundValues[0];
			this.member_0 = (Member)boundValues[1];
			final /*@NonInvalid*/ @Nullable Family familyMother = member_0.getFamilyMother();
			final /*@NonInvalid*/ boolean symbol_0 = familyMother == null;
			final /*@NonInvalid*/ boolean not2 = BooleanNotOperation2.INSTANCE.evaluate(symbol_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_3;
			if (not2) {
				symbol_3 = ValueUtil.TRUE_VALUE;
			}
			else {
				final /*@NonInvalid*/ @Nullable Family familyDaughter = member_0.getFamilyDaughter();
				final /*@NonInvalid*/ boolean symbol_1 = familyDaughter == null;
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
					&& idResolver.oclEquals(this.member_0, thoseValues[1]);
		}
	}

	/**
	 *
	 * map __root__ in Families2Persons {
	 *
	 *   append ji_Member  : Families::Member[1];
	 * install m_Member2Female_member_person_r0 {
	 * s consumes append ji_Member  : Families::Member[1];
	 * ;
	 * }
	 *   install m_Member2Male_member_person_r0 {
	 * s consumes append ji_Member  : Families::Member[1];
	 * ;
	 * }
	 */
	protected boolean MAP___root__(final @NonNull Connection ji_Member)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP___root__" + ", " + ji_Member);
		}
		// mapping statements
		for (@NonNull Member s_1 : ji_Member.typedIterable(Member.class)) {
			MAP_m_Member2Female_member_person_r0(s_1);
		}
		for (@NonNull Member s_2 : ji_Member.typedIterable(Member.class)) {
			MAP_m_Member2Male_member_person_r0(s_2);
		}
		final /*@Thrown*/ @Nullable Boolean __root__ = ValueUtil.TRUE_VALUE;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((__root__ ? "done "  : "fail ") + "MAP___root__");
		}
		return __root__;
	}

	/**
	 *
	 * map m_Member2Female_member_person_r0 in Families2Persons {
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
	protected boolean MAP_m_Member2Female_member_person_r0(final /*@NonInvalid*/ @NonNull Member s)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_Member2Female_member_person_r0" + ", " + s);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String firstName = s.getFirstName();
		final /*@NonInvalid*/ boolean isFemale = ((FUN_isFemale)FTOR_isFemale.getUniqueComputation(this, s)).symbol_3;
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (isFemale) {
			// creations
			final @SuppressWarnings("null")@NonNull Member2Female m2m = Families2PersonsFactory.eINSTANCE.createMember2Female();
			models[2/*middle*/].add(m2m, false);
			final @SuppressWarnings("null")@NonNull Female t = PersonsFactory.eINSTANCE.createFemale();
			models[1/*person*/].add(t, false);
			// mapping statements
			m2m.setMember(s);
			m2m.setPerson(t);
			final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(firstName, STR__32);
			final /*@NonInvalid*/ @NonNull String familyName = ((FUN_familyName)FTOR_familyName.getUniqueComputation(this, s)).instance;
			final /*@NonInvalid*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, familyName);
			t.setFullName(sum_0);
			final /*@Thrown*/ @Nullable Boolean m_Member2Female_member_person_r0 = ValueUtil.TRUE_VALUE;
			symbol_4 = m_Member2Female_member_person_r0;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_m_Member2Female_member_person_r0");
		}
		return symbol_4;
	}

	/**
	 *
	 * map m_Member2Male_member_person_r0 in Families2Persons {
	 *
	 *   guard:family s  : Families::Member[1];
	 * var firstName : String[1] := s.firstName;
	 * check this.isFemale(s)
	 *   .not2();
	 * new:middle m2m : Families2Persons::Member2Male[1];
	 * new:person t : Persons::Male[1];
	 * set m2m.member := s;
	 * set m2m.person := t;
	 * set t.fullName := firstName + ' ' +
	 *   this.familyName(s);
	 *
	 */
	protected boolean MAP_m_Member2Male_member_person_r0(final /*@NonInvalid*/ @NonNull Member s_0)  {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("invoke MAP_m_Member2Male_member_person_r0" + ", " + s_0);
		}
		@SuppressWarnings("null")
		final /*@NonInvalid*/ @NonNull String firstName = s_0.getFirstName();
		final /*@NonInvalid*/ boolean isFemale = ((FUN_isFemale)FTOR_isFemale.getUniqueComputation(this, s_0)).symbol_3;
		final /*@NonInvalid*/ boolean not2 = BooleanNotOperation2.INSTANCE.evaluate(isFemale).booleanValue();
		/*@Thrown*/ @Nullable Boolean symbol_4;
		if (not2) {
			// creations
			final @SuppressWarnings("null")@NonNull Member2Male m2m = Families2PersonsFactory.eINSTANCE.createMember2Male();
			models[2/*middle*/].add(m2m, false);
			final @SuppressWarnings("null")@NonNull Male t = PersonsFactory.eINSTANCE.createMale();
			models[1/*person*/].add(t, false);
			// mapping statements
			m2m.setMember(s_0);
			m2m.setPerson(t);
			final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(firstName, STR__32);
			final /*@NonInvalid*/ @NonNull String familyName = ((FUN_familyName)FTOR_familyName.getUniqueComputation(this, s_0)).instance;
			final /*@NonInvalid*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, familyName);
			t.setFullName(sum_0);
			final /*@Thrown*/ @Nullable Boolean m_Member2Male_member_person_r0 = ValueUtil.TRUE_VALUE;
			symbol_4 = m_Member2Male_member_person_r0;
		}
		else {
			symbol_4 = ValueUtil.FALSE_VALUE;
		}
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println((symbol_4 ? "done "  : "fail ") + "MAP_m_Member2Male_member_person_r0");
		}
		return symbol_4;
	}
}
