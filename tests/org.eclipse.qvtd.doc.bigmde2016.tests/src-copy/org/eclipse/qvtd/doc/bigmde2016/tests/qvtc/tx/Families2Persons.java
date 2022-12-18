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
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NestedPackageId;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.library.string.StringConcatOperation;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
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
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.RuntimeModelsManager;

/**
 * The Families2Persons transformation:
 * <p>
 * Construct with an evaluator
 * <br>
 * Populate each input model with {@link addRootEObjects(String,List)}
 * <br>
 * {@link run()}
 * <br>
 * Extract each output model with {@link getRootEObjects(String)}
 */
@SuppressWarnings({"restriction","unused"})
public class Families2Persons extends AbstractTransformer
{
	protected final @NonNull Families2Persons rootObject = this;
	protected final RuntimeModelsManager.@NonNull Model MODEL_family;
	protected final RuntimeModelsManager.@NonNull Model MODEL_person;
	protected final RuntimeModelsManager.@NonNull Model MODEL_middle;

	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_org = IdManager.getRootPackageId("org");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families", null, FamiliesPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families2Persons = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families2Persons", null, Families2PersonsPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons = IdManager.getNsURIPackageId("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Persons", null, PersonsPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_eclipse = PACKid_org.getNestedPackageId("eclipse");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Family = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families.getClassId("Family", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Female = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons.getClassId("Female", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Male = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons.getClassId("Male", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Member = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families.getClassId("Member", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Member2Female = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families2Persons.getClassId("Member2Female", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Member2Male = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Families2Persons.getClassId("Member2Male", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Person = PACKid_http_c_s_s_www_eclipse_org_s_qvtd_s_xtext_s_qvtcore_s_tests_s_Upper2Lower_s_1_0_s_Persons.getClassId("Person", 0);
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ @NonNull IntegerValue INT_1 = ValueUtil.integerValueOf("1");
	public static final /*@NonInvalid*/ @NonNull String STR__32 = " ";
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_qvtd = PACKid_eclipse.getNestedPackageId("qvtd");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_xtext = PACKid_qvtd.getNestedPackageId("xtext");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_qvtcore = PACKid_xtext.getNestedPackageId("qvtcore");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_tests = PACKid_qvtcore.getNestedPackageId("tests");
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_families2persons = PACKid_tests.getNestedPackageId("families2persons");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Families2Persons = PACKid_families2persons.getClassId("Families2Persons", 0);
	public static final /*@NonInvalid*/ @NonNull NestedPackageId PACKid_Families2Persons = PACKid_families2persons.getNestedPackageId("Families2Persons");
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CACHE_Families2Persons_familyName = PACKid_Families2Persons.getClassId("CACHE_Families2Persons_familyName", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_CACHE_Families2Persons_isFemale = PACKid_Families2Persons.getClassId("CACHE_Families2Persons_isFemale", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ENTRY_Families2Persons_familyName = PACKid_Families2Persons.getClassId("ENTRY_Families2Persons_familyName", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_ENTRY_Families2Persons_isFemale = PACKid_Families2Persons.getClassId("ENTRY_Families2Persons_isFemale", 0);

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_r_Families2Persons__load__ = new AbstractInvocationConstructor(invocationManager, "MAP_r_Families2Persons__load__", false, lazyCreateInterval(0))
	{
		@Override
		public @NonNull MAP_MAP_r_Families2Persons__load__ newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_MAP_r_Families2Persons__load__(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mMember2Female = new AbstractInvocationConstructor(invocationManager, "MAP_mMember2Female", true, lazyCreateInterval(1))
	{
		@Override
		public @NonNull MAP_MAP_mMember2Female newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_MAP_mMember2Female(this, values);
		}
	};

	protected final @NonNull AbstractInvocationConstructor CTOR_MAP_mMember2Male = new AbstractInvocationConstructor(invocationManager, "MAP_mMember2Male", true, lazyCreateInterval(1))
	{
		@Override
		public @NonNull MAP_MAP_mMember2Male newInstance(@NonNull Object @NonNull [] values) {
			return new MAP_MAP_mMember2Male(this, values);
		}
	};


	/*
	 * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex for TypedModel 2.
	 */
	private static final @NonNull ClassId @NonNull [] classIndex2classId_2 = new @NonNull ClassId[]{
		CLSSid_Member                         // 0 => Member
	};

	/*
	 * Mapping from each TypedModel 2 ClassIndex to all the ClassIndexes
	 * to which an object of the outer index may contribute results to an allInstances() invocation.
	 * Non trivial inner arrays arise when one ClassId is a derivation of another and so an
	 * instance of the derived classId contributes to derived and inherited ClassIndexes.
	 */
	private final static int @NonNull [] @NonNull [] classIndex2allClassIndexes_2 = new int @NonNull [] @NonNull [] {
		{0}                           // 0 : Member -> {Member}
	};

	protected final /*@NonInvalid*/ Families2Persons.@NonNull CACHE_Families2Persons_familyName INSTANCE_CACHE_Families2Persons_familyName = new Families2Persons.CACHE_Families2Persons_familyName(executor, rootObject);
	protected final /*@NonInvalid*/ Families2Persons.@NonNull CACHE_Families2Persons_isFemale INSTANCE_CACHE_Families2Persons_isFemale = new Families2Persons.CACHE_Families2Persons_isFemale(executor, rootObject);

	public Families2Persons(final @NonNull TransformationExecutor executor) {
		super(executor, 5);
		initModel(0, "$primitive$");
		initModel(1, "$this$");
		MODEL_family = initModel(2, "family");
		MODEL_person = initModel(3, "person");
		MODEL_middle = initModel(4, "middle");
		MODEL_family.initClassIds(classIndex2classId_2, classIndex2allClassIndexes_2);
		initConnections();
	}

	@Override
	public boolean run(@NonNull String targetName) {
		return run();
	}

	@Override
	public boolean run() {
		final @NonNull Connection ji_Member = MODEL_family.getConnection(0/*Families::Member*/);
		CTOR_MAP_r_Families2Persons__load__.invoke(ji_Member);
		return invocationManager.flush();
	}
	/**
	 * The instance of CACHE_Families2Persons_familyName caches all known evaluations of
	 *
	 * familyName(member : Families::Member[1]) : String[1]
	 */
	protected class CACHE_Families2Persons_familyName extends AbstractComputationConstructor
	{
		public CACHE_Families2Persons_familyName(@NonNull Executor executor, @NonNull Object rootObject) {
			super(executor, rootObject);
		}

		public /*@Thrown*/ @NonNull String evaluate(final /*@NonInvalid*/ @NonNull Member member) {
			return ((ENTRY_Families2Persons_familyName)getUniqueComputation(rootObject, member)).cachedResult;
		}

		@Override
		public /*@Thrown*/ Families2Persons.@NonNull ENTRY_Families2Persons_familyName newInstance(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			return new Families2Persons.ENTRY_Families2Persons_familyName(executor, boxedValues);
		}
	}
	/**
	 * The instance of CACHE_Families2Persons_isFemale caches all known evaluations of
	 *
	 * isFemale(member : Families::Member[1]) : Boolean[1]
	 */
	protected class CACHE_Families2Persons_isFemale extends AbstractComputationConstructor
	{
		public CACHE_Families2Persons_isFemale(@NonNull Executor executor, @NonNull Object rootObject) {
			super(executor, rootObject);
		}

		public /*@Thrown*/ boolean evaluate(final /*@NonInvalid*/ @NonNull Member member) {
			return ((ENTRY_Families2Persons_isFemale)getUniqueComputation(rootObject, member)).cachedResult;
		}

		@Override
		public /*@Thrown*/ Families2Persons.@NonNull ENTRY_Families2Persons_isFemale newInstance(final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			return new Families2Persons.ENTRY_Families2Persons_isFemale(executor, boxedValues);
		}
	}
	/**
	 * Each ENTRY_Families2Persons_familyName instance caches a distinct evaluation of
	 *
	 * familyName(member : Families::Member[1]) : String[1]
	 */
	protected class ENTRY_Families2Persons_familyName extends AbstractComputation
	{
		protected final /*@NonInvalid*/ @NonNull Object contextObject;
		protected final /*@NonInvalid*/ @NonNull Member member;
		protected final /*@NonInvalid*/ @NonNull String cachedResult;

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
		protected ENTRY_Families2Persons_familyName(final /*@NonInvalid*/ @NonNull Executor executor, final /*@NonInvalid*/ @NonNull Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull Object contextObject = boxedValues[0];
			final /*@NonInvalid*/ @NonNull Member member = (Member)boxedValues[1];
			this.contextObject = contextObject;
			this.member = member;
			final /*@NonInvalid*/ @Nullable Family familyFather = member.getFamilyFather();
			final /*@NonInvalid*/ boolean IsUNDEF_familyFather = familyFather == null;
			final /*@NonInvalid*/ boolean not2;
			if (!IsUNDEF_familyFather) {
				not2 = true;
			}
			else {
				not2 = false;
			}
			/*@Thrown*/ @NonNull String IF_not2;
			if (not2) {
				if (familyFather == null) {
					throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
				}
				@SuppressWarnings("null")
				final /*@Thrown*/ @NonNull String lastName = familyFather.getLastName();
				IF_not2 = lastName;
			}
			else {
				final /*@NonInvalid*/ @Nullable Family familyMother = member.getFamilyMother();
				final /*@NonInvalid*/ boolean IsUNDEF_familyMother = familyMother == null;
				final /*@NonInvalid*/ boolean not2_0;
				if (!IsUNDEF_familyMother) {
					not2_0 = true;
				}
				else {
					not2_0 = false;
				}
				/*@Thrown*/ @NonNull String IF_not2_0;
				if (not2_0) {
					if (familyMother == null) {
						throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
					}
					@SuppressWarnings("null")
					final /*@Thrown*/ @NonNull String lastName_0 = familyMother.getLastName();
					IF_not2_0 = lastName_0;
				}
				else {
					final /*@NonInvalid*/ @Nullable Family familySon = member.getFamilySon();
					final /*@NonInvalid*/ boolean IsUNDEF_familySon = familySon == null;
					final /*@NonInvalid*/ boolean not2_1;
					if (!IsUNDEF_familySon) {
						not2_1 = true;
					}
					else {
						not2_1 = false;
					}
					/*@Thrown*/ @NonNull String IF_not2_1;
					if (not2_1) {
						if (familySon == null) {
							throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull String lastName_1 = familySon.getLastName();
						IF_not2_1 = lastName_1;
					}
					else {
						final /*@NonInvalid*/ @Nullable Family familyDaughter = member.getFamilyDaughter();
						if (familyDaughter == null) {
							throw new InvalidEvaluationException("Null source for \'\'http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families\'::Family::lastName\'");
						}
						@SuppressWarnings("null")
						final /*@Thrown*/ @NonNull String lastName_2 = familyDaughter.getLastName();
						IF_not2_1 = lastName_2;
					}
					IF_not2_0 = IF_not2_1;
				}
				IF_not2 = IF_not2_0;
			}
			this.cachedResult = IF_not2;
		}

		@Override
		public /*@Thrown*/ @NonNull String getResult() {
			return this.cachedResult;
		}

		/**
		 * Return true if the boxedValues exactly match OCL-wise the values from which this entry was constructed.
		 * If so, the cachedResult can be re-used and no further ENTRY needs construction.
		 */
		@Override
		public /*@Thrown*/ boolean isEqual(final /*@NonInvalid*/ @NonNull IdResolver idResolver, final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull Object INDEX_0_boxedValues = boxedValues[0];
			final /*@NonInvalid*/ @NonNull Member INDEX_1_boxedValues = (@NonNull Member)boxedValues[1];
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(INDEX_0_boxedValues, this.contextObject);
			final /*@NonInvalid*/ boolean and2;
			if (!IsEQ_) {
				and2 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(INDEX_1_boxedValues, this.member);
				and2 = IsEQ__0;
			}
			return and2;
		}
	}
	/**
	 * Each ENTRY_Families2Persons_isFemale instance caches a distinct evaluation of
	 *
	 * isFemale(member : Families::Member[1]) : Boolean[1]
	 */
	protected class ENTRY_Families2Persons_isFemale extends AbstractComputation
	{
		protected final /*@NonInvalid*/ @NonNull Object contextObject;
		protected final /*@NonInvalid*/ @NonNull Member member;
		protected final /*@NonInvalid*/ boolean cachedResult;

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
		protected ENTRY_Families2Persons_isFemale(final /*@NonInvalid*/ @NonNull Executor executor, final /*@NonInvalid*/ @NonNull Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull Object contextObject = boxedValues[0];
			final /*@NonInvalid*/ @NonNull Member member = (Member)boxedValues[1];
			this.contextObject = contextObject;
			this.member = member;
			final /*@NonInvalid*/ @Nullable Family familyMother = member.getFamilyMother();
			final /*@NonInvalid*/ boolean IsUNDEF_familyMother = familyMother == null;
			final /*@NonInvalid*/ boolean not2;
			if (!IsUNDEF_familyMother) {
				not2 = true;
			}
			else {
				not2 = false;
			}
			/*@NonInvalid*/ boolean IF_not2;
			if (not2) {
				IF_not2 = true;
			}
			else {
				final /*@NonInvalid*/ @Nullable Family familyDaughter = member.getFamilyDaughter();
				final /*@NonInvalid*/ boolean IsUNDEF_familyDaughter = familyDaughter == null;
				final /*@NonInvalid*/ boolean not2_0;
				if (!IsUNDEF_familyDaughter) {
					not2_0 = true;
				}
				else {
					not2_0 = false;
				}
				/*@NonInvalid*/ boolean IF_not2_0;
				if (not2_0) {
					IF_not2_0 = true;
				}
				else {
					IF_not2_0 = false;
				}
				IF_not2 = IF_not2_0;
			}
			this.cachedResult = IF_not2;
		}

		@Override
		public /*@Thrown*/ @NonNull Boolean getResult() {
			return this.cachedResult;
		}

		/**
		 * Return true if the boxedValues exactly match OCL-wise the values from which this entry was constructed.
		 * If so, the cachedResult can be re-used and no further ENTRY needs construction.
		 */
		@Override
		public /*@Thrown*/ boolean isEqual(final /*@NonInvalid*/ @NonNull IdResolver idResolver, final /*@NonInvalid*/ @Nullable Object @NonNull [] boxedValues) {
			final /*@NonInvalid*/ @NonNull Object INDEX_0_boxedValues = boxedValues[0];
			final /*@NonInvalid*/ @NonNull Member INDEX_1_boxedValues = (@NonNull Member)boxedValues[1];
			final /*@NonInvalid*/ boolean IsEQ_ = idResolver.oclEquals(INDEX_0_boxedValues, this.contextObject);
			final /*@NonInvalid*/ boolean and2;
			if (!IsEQ_) {
				and2 = false;
			}
			else {
				final /*@NonInvalid*/ boolean IsEQ__0 = idResolver.oclEquals(INDEX_1_boxedValues, this.member);
				and2 = IsEQ__0;
			}
			return and2;
		}
	}

	/**
	 *
	 * entry r_Families2Persons__load__input familyoutput person in Families2Persons {
	 *
	 *   append ji_Member  : Families::Member[1];
	 * install mMember2Female {
	 * s consumes append ji_Member  : Families::Member[1];
	 * ;
	 * }
	 *   install mMember2Male {
	 * s consumes append ji_Member  : Families::Member[1];
	 * ;
	 * }
	 */
	protected class MAP_MAP_r_Families2Persons__load__ extends AbstractInvocation
	{
		protected final @NonNull Connection ji_Member;

		public MAP_MAP_r_Families2Persons__load__(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			ji_Member = (Connection)boundValues[0];
		}

		@Override
		public boolean execute()  {
			// mapping statements
			CTOR_MAP_mMember2Female.addConsumedConnection(ji_Member);
			CTOR_MAP_mMember2Male.addConsumedConnection(ji_Member);
			final /*@Thrown*/ @Nullable Boolean r_Families2Persons__load__ = ValueUtil.TRUE_VALUE;
			return r_Families2Persons__load__;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(ji_Member, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:1 mMember2Female in Families2Persons {
	 *
	 *   guard:family s : Families::Member[1];
	 * var isFemale1 : Boolean[1] := this.isFemale(s)
	 *   ;
	 * check isFemale1;
	 * var firstName : String[1] := s.firstName;
	 * var familyName1 : String[1] := this.familyName(s);
	 * var _'+' : String[1] := firstName + ' ';
	 * var _'+1' : String[1] := _'+' + familyName1;
	 * new:middle m2m : Families2Persons::Member2Female[1];
	 * new:person t : Persons::Female[1];
	 * set t.fullName := _'+1';
	 * set m2m.member := s;
	 * set m2m.person := t;
	 *
	 */
	protected class MAP_MAP_mMember2Female extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull Member s;

		public MAP_MAP_mMember2Female(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			s = (@NonNull Member)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ boolean isFemale = INSTANCE_CACHE_Families2Persons_isFemale.evaluate(s);
			/*@Thrown*/ @Nullable Boolean IF_IF_isFemale;
			if (isFemale) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String firstName = s.getFirstName();
				final /*@NonInvalid*/ @NonNull String familyName = INSTANCE_CACHE_Families2Persons_familyName.evaluate(s);
				final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(firstName, STR__32);
				final /*@NonInvalid*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, familyName);
				// creations
				final @SuppressWarnings("null")@NonNull Member2Female m2m = Families2PersonsFactory.eINSTANCE.createMember2Female();
				MODEL_middle.add(m2m, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(m2m));
				}
				final @SuppressWarnings("null")@NonNull Female t = PersonsFactory.eINSTANCE.createFemale();
				MODEL_person.add(t, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(t));
				}
				// mapping statements
				t.setFullName(sum_0);
				m2m.setMember(s);
				m2m.setPerson(t);
				final /*@Thrown*/ @Nullable Boolean mMember2Female = ValueUtil.TRUE_VALUE;
				IF_IF_isFemale = mMember2Female;
			}
			else {
				IF_IF_isFemale = ValueUtil.FALSE_VALUE;
			}
			return IF_IF_isFemale;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(s, thoseValues[0]);
		}
	}

	/**
	 *
	 * strict map:1 mMember2Male in Families2Persons {
	 *
	 *   guard:family s : Families::Member[1];
	 * var isFemale1 : Boolean[1] := this.isFemale(s)
	 *   ;
	 * var not2 : Boolean[1] := not2 isFemale1;
	 * check not2;
	 * var firstName : String[1] := s.firstName;
	 * var familyName1 : String[1] := this.familyName(s);
	 * var _'+' : String[1] := firstName + ' ';
	 * var _'+1' : String[1] := _'+' + familyName1;
	 * new:middle m2m : Families2Persons::Member2Male[1];
	 * new:person t : Persons::Male[1];
	 * set t.fullName := _'+1';
	 * set m2m.member := s;
	 * set m2m.person := t;
	 *
	 */
	protected class MAP_MAP_mMember2Male extends AbstractInvocation
	{
		protected final /*@NonInvalid*/ @NonNull Member s;

		public MAP_MAP_mMember2Male(@NonNull InvocationConstructor constructor, @NonNull Object @NonNull [] boundValues) {
			super(constructor);
			s = (@NonNull Member)boundValues[0];
		}

		@Override
		public boolean execute()  {
			final /*@NonInvalid*/ boolean isFemale = INSTANCE_CACHE_Families2Persons_isFemale.evaluate(s);
			final /*@NonInvalid*/ boolean not2;
			if (!isFemale) {
				not2 = true;
			}
			else {
				not2 = false;
			}
			/*@Thrown*/ @Nullable Boolean IF_IF_not2;
			if (not2) {
				@SuppressWarnings("null")
				final /*@NonInvalid*/ @NonNull String firstName = s.getFirstName();
				final /*@NonInvalid*/ @NonNull String familyName = INSTANCE_CACHE_Families2Persons_familyName.evaluate(s);
				final /*@NonInvalid*/ @NonNull String sum = StringConcatOperation.INSTANCE.evaluate(firstName, STR__32);
				final /*@NonInvalid*/ @NonNull String sum_0 = StringConcatOperation.INSTANCE.evaluate(sum, familyName);
				// creations
				final @SuppressWarnings("null")@NonNull Member2Male m2m = Families2PersonsFactory.eINSTANCE.createMember2Male();
				MODEL_middle.add(m2m, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(m2m));
				}
				final @SuppressWarnings("null")@NonNull Male t = PersonsFactory.eINSTANCE.createMale();
				MODEL_person.add(t, false);
				if (debugCreations) {
					AbstractTransformer.CREATIONS.println("created " + toDebugString(t));
				}
				// mapping statements
				t.setFullName(sum_0);
				m2m.setMember(s);
				m2m.setPerson(t);
				final /*@Thrown*/ @Nullable Boolean mMember2Male = ValueUtil.TRUE_VALUE;
				IF_IF_not2 = mMember2Male;
			}
			else {
				IF_IF_not2 = ValueUtil.FALSE_VALUE;
			}
			return IF_IF_not2;
		}

		@Override
		public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
			return idResolver.oclEquals(s, thoseValues[0]);
		}
	}
}
