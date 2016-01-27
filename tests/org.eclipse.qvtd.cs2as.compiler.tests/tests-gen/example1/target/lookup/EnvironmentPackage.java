/**
 */
package example1.target.lookup;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see example1.target.lookup.EnvironmentFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import target='TargetMM1.ecore#/'"
 * @generated
 */
public interface EnvironmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "lookup";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example1/env/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lookup";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvironmentPackage eINSTANCE = example1.target.lookup.impl.EnvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link example1.target.lookup.Env4CG <em>Env4 CG</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.lookup.Env4CG
	 * @see example1.target.lookup.impl.EnvironmentPackageImpl#getEnv4CG()
	 * @generated
	 */
	int ENV4_CG = 1;

	/**
	 * The number of structural features of the '<em>Env4 CG</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENV4_CG_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Has Final Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENV4_CG___HAS_FINAL_RESULT = 0;

	/**
	 * The operation id for the '<em>Get Executor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENV4_CG___GET_EXECUTOR = 1;

	/**
	 * The number of operations of the '<em>Env4 CG</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENV4_CG_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link example1.target.lookup.impl.LookupEnvironmentImpl <em>Lookup Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.lookup.impl.LookupEnvironmentImpl
	 * @see example1.target.lookup.impl.EnvironmentPackageImpl#getLookupEnvironment()
	 * @generated
	 */
	int LOOKUP_ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Named Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT__NAMED_ELEMENTS = ENV4_CG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Env</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT__PARENT_ENV = ENV4_CG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lookup Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT_FEATURE_COUNT = ENV4_CG_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Has Final Result</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___HAS_FINAL_RESULT = ENV4_CG___HAS_FINAL_RESULT;

	/**
	 * The operation id for the '<em>Get Executor</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___GET_EXECUTOR = ENV4_CG___GET_EXECUTOR;

	/**
	 * The operation id for the '<em>Add Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___ADD_ELEMENTS__COLLECTION = ENV4_CG_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Add Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT = ENV4_CG_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Lookup Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT_OPERATION_COUNT = ENV4_CG_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.evaluation.Executor <em>Executor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.evaluation.Executor
	 * @see example1.target.lookup.impl.EnvironmentPackageImpl#getExecutor()
	 * @generated
	 */
	int EXECUTOR = 2;

	/**
	 * The number of structural features of the '<em>Executor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Executor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTOR_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link example1.target.lookup.LookupEnvironment <em>Lookup Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lookup Environment</em>'.
	 * @see example1.target.lookup.LookupEnvironment
	 * @generated
	 */
	EClass getLookupEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link example1.target.lookup.LookupEnvironment#getNamedElements <em>Named Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Named Elements</em>'.
	 * @see example1.target.lookup.LookupEnvironment#getNamedElements()
	 * @see #getLookupEnvironment()
	 * @generated
	 */
	EReference getLookupEnvironment_NamedElements();

	/**
	 * Returns the meta object for the reference '{@link example1.target.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Env</em>'.
	 * @see example1.target.lookup.LookupEnvironment#getParentEnv()
	 * @see #getLookupEnvironment()
	 * @generated
	 */
	EReference getLookupEnvironment_ParentEnv();

	/**
	 * Returns the meta object for the '{@link example1.target.lookup.LookupEnvironment#addElements(java.util.Collection) <em>Add Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Elements</em>' operation.
	 * @see example1.target.lookup.LookupEnvironment#addElements(java.util.Collection)
	 * @generated
	 */
	EOperation getLookupEnvironment__AddElements__Collection();

	/**
	 * Returns the meta object for the '{@link example1.target.lookup.LookupEnvironment#addElement(example1.target.NamedElement) <em>Add Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Element</em>' operation.
	 * @see example1.target.lookup.LookupEnvironment#addElement(example1.target.NamedElement)
	 * @generated
	 */
	EOperation getLookupEnvironment__AddElement__NamedElement();

	/**
	 * Returns the meta object for class '{@link example1.target.lookup.Env4CG <em>Env4 CG</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Env4 CG</em>'.
	 * @see example1.target.lookup.Env4CG
	 * @generated
	 */
	EClass getEnv4CG();

	/**
	 * Returns the meta object for the '{@link example1.target.lookup.Env4CG#hasFinalResult() <em>Has Final Result</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Final Result</em>' operation.
	 * @see example1.target.lookup.Env4CG#hasFinalResult()
	 * @generated
	 */
	EOperation getEnv4CG__HasFinalResult();

	/**
	 * Returns the meta object for the '{@link example1.target.lookup.Env4CG#getExecutor() <em>Get Executor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Executor</em>' operation.
	 * @see example1.target.lookup.Env4CG#getExecutor()
	 * @generated
	 */
	EOperation getEnv4CG__GetExecutor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.evaluation.Executor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executor</em>'.
	 * @see org.eclipse.ocl.pivot.evaluation.Executor
	 * @model instanceClass="org.eclipse.ocl.pivot.evaluation.Executor"
	 * @generated
	 */
	EClass getExecutor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnvironmentFactory getEnvironmentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link example1.target.lookup.impl.LookupEnvironmentImpl <em>Lookup Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.lookup.impl.LookupEnvironmentImpl
		 * @see example1.target.lookup.impl.EnvironmentPackageImpl#getLookupEnvironment()
		 * @generated
		 */
		EClass LOOKUP_ENVIRONMENT = eINSTANCE.getLookupEnvironment();

		/**
		 * The meta object literal for the '<em><b>Named Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP_ENVIRONMENT__NAMED_ELEMENTS = eINSTANCE.getLookupEnvironment_NamedElements();

		/**
		 * The meta object literal for the '<em><b>Parent Env</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP_ENVIRONMENT__PARENT_ENV = eINSTANCE.getLookupEnvironment_ParentEnv();

		/**
		 * The meta object literal for the '<em><b>Add Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOKUP_ENVIRONMENT___ADD_ELEMENTS__COLLECTION = eINSTANCE.getLookupEnvironment__AddElements__Collection();

		/**
		 * The meta object literal for the '<em><b>Add Element</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOKUP_ENVIRONMENT___ADD_ELEMENT__NAMEDELEMENT = eINSTANCE.getLookupEnvironment__AddElement__NamedElement();

		/**
		 * The meta object literal for the '{@link example1.target.lookup.Env4CG <em>Env4 CG</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.lookup.Env4CG
		 * @see example1.target.lookup.impl.EnvironmentPackageImpl#getEnv4CG()
		 * @generated
		 */
		EClass ENV4_CG = eINSTANCE.getEnv4CG();

		/**
		 * The meta object literal for the '<em><b>Has Final Result</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENV4_CG___HAS_FINAL_RESULT = eINSTANCE.getEnv4CG__HasFinalResult();

		/**
		 * The meta object literal for the '<em><b>Get Executor</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ENV4_CG___GET_EXECUTOR = eINSTANCE.getEnv4CG__GetExecutor();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.evaluation.Executor <em>Executor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.evaluation.Executor
		 * @see example1.target.lookup.impl.EnvironmentPackageImpl#getExecutor()
		 * @generated
		 */
		EClass EXECUTOR = eINSTANCE.getExecutor();

	}

} //EnvironmentPackage
