/**
 */
package example2.classes.lookup;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see example2.classes.lookup.EnvironmentFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import classes='Classes.ecore#/'"
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
	String eNS_URI = "http://cs2as/tests/example2/env/1.0";

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
	EnvironmentPackage eINSTANCE = example2.classes.lookup.impl.EnvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link example2.classes.lookup.Env4CG <em>Env4 CG</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example2.classes.lookup.Env4CG
	 * @see example2.classes.lookup.impl.EnvironmentPackageImpl#getEnv4CG()
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
	 * The meta object id for the '{@link example2.classes.lookup.impl.LookupEnvironmentImpl <em>Lookup Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example2.classes.lookup.impl.LookupEnvironmentImpl
	 * @see example2.classes.lookup.impl.EnvironmentPackageImpl#getLookupEnvironment()
	 * @generated
	 */
	int LOOKUP_ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT__ENTRIES = ENV4_CG_FEATURE_COUNT + 0;

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
	 * The operation id for the '<em>Add Element With Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___ADD_ELEMENT_WITH_NAME__STRING_NAMEDELEMENT = ENV4_CG_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Named Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT___GET_NAMED_ELEMENTS__STRING = ENV4_CG_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Lookup Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOKUP_ENVIRONMENT_OPERATION_COUNT = ENV4_CG_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link example2.classes.lookup.impl.EnvEntryImpl <em>Env Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example2.classes.lookup.impl.EnvEntryImpl
	 * @see example2.classes.lookup.impl.EnvironmentPackageImpl#getEnvEntry()
	 * @generated
	 */
	int ENV_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENV_ENTRY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Named Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENV_ENTRY__NAMED_ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Env</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENV_ENTRY__ENV = 2;

	/**
	 * The number of structural features of the '<em>Env Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENV_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Env Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENV_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.evaluation.Executor <em>Executor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.evaluation.Executor
	 * @see example2.classes.lookup.impl.EnvironmentPackageImpl#getExecutor()
	 * @generated
	 */
	int EXECUTOR = 3;

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
	 * Returns the meta object for class '{@link example2.classes.lookup.LookupEnvironment <em>Lookup Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lookup Environment</em>'.
	 * @see example2.classes.lookup.LookupEnvironment
	 * @generated
	 */
	EClass getLookupEnvironment();

	/**
	 * Returns the meta object for the containment reference list '{@link example2.classes.lookup.LookupEnvironment#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see example2.classes.lookup.LookupEnvironment#getEntries()
	 * @see #getLookupEnvironment()
	 * @generated
	 */
	EReference getLookupEnvironment_Entries();

	/**
	 * Returns the meta object for the reference '{@link example2.classes.lookup.LookupEnvironment#getParentEnv <em>Parent Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Env</em>'.
	 * @see example2.classes.lookup.LookupEnvironment#getParentEnv()
	 * @see #getLookupEnvironment()
	 * @generated
	 */
	EReference getLookupEnvironment_ParentEnv();

	/**
	 * Returns the meta object for the '{@link example2.classes.lookup.LookupEnvironment#addElements(java.util.Collection) <em>Add Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Elements</em>' operation.
	 * @see example2.classes.lookup.LookupEnvironment#addElements(java.util.Collection)
	 * @generated
	 */
	EOperation getLookupEnvironment__AddElements__Collection();

	/**
	 * Returns the meta object for the '{@link example2.classes.lookup.LookupEnvironment#addElement(example2.classes.NamedElement) <em>Add Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Element</em>' operation.
	 * @see example2.classes.lookup.LookupEnvironment#addElement(example2.classes.NamedElement)
	 * @generated
	 */
	EOperation getLookupEnvironment__AddElement__NamedElement();

	/**
	 * Returns the meta object for the '{@link example2.classes.lookup.LookupEnvironment#addElementWithName(java.lang.String, example2.classes.NamedElement) <em>Add Element With Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Add Element With Name</em>' operation.
	 * @see example2.classes.lookup.LookupEnvironment#addElementWithName(java.lang.String, example2.classes.NamedElement)
	 * @generated
	 */
	EOperation getLookupEnvironment__AddElementWithName__String_NamedElement();

	/**
	 * Returns the meta object for the '{@link example2.classes.lookup.LookupEnvironment#getNamedElements(java.lang.String) <em>Get Named Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Named Elements</em>' operation.
	 * @see example2.classes.lookup.LookupEnvironment#getNamedElements(java.lang.String)
	 * @generated
	 */
	EOperation getLookupEnvironment__GetNamedElements__String();

	/**
	 * Returns the meta object for class '{@link example2.classes.lookup.Env4CG <em>Env4 CG</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Env4 CG</em>'.
	 * @see example2.classes.lookup.Env4CG
	 * @generated
	 */
	EClass getEnv4CG();

	/**
	 * Returns the meta object for the '{@link example2.classes.lookup.Env4CG#hasFinalResult() <em>Has Final Result</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Has Final Result</em>' operation.
	 * @see example2.classes.lookup.Env4CG#hasFinalResult()
	 * @generated
	 */
	EOperation getEnv4CG__HasFinalResult();

	/**
	 * Returns the meta object for the '{@link example2.classes.lookup.Env4CG#getExecutor() <em>Get Executor</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Executor</em>' operation.
	 * @see example2.classes.lookup.Env4CG#getExecutor()
	 * @generated
	 */
	EOperation getEnv4CG__GetExecutor();

	/**
	 * Returns the meta object for class '{@link example2.classes.lookup.EnvEntry <em>Env Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Env Entry</em>'.
	 * @see example2.classes.lookup.EnvEntry
	 * @generated
	 */
	EClass getEnvEntry();

	/**
	 * Returns the meta object for the attribute '{@link example2.classes.lookup.EnvEntry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see example2.classes.lookup.EnvEntry#getName()
	 * @see #getEnvEntry()
	 * @generated
	 */
	EAttribute getEnvEntry_Name();

	/**
	 * Returns the meta object for the reference list '{@link example2.classes.lookup.EnvEntry#getNamedElements <em>Named Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Named Elements</em>'.
	 * @see example2.classes.lookup.EnvEntry#getNamedElements()
	 * @see #getEnvEntry()
	 * @generated
	 */
	EReference getEnvEntry_NamedElements();

	/**
	 * Returns the meta object for the container reference '{@link example2.classes.lookup.EnvEntry#getEnv <em>Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Env</em>'.
	 * @see example2.classes.lookup.EnvEntry#getEnv()
	 * @see #getEnvEntry()
	 * @generated
	 */
	EReference getEnvEntry_Env();

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
		 * The meta object literal for the '{@link example2.classes.lookup.impl.LookupEnvironmentImpl <em>Lookup Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example2.classes.lookup.impl.LookupEnvironmentImpl
		 * @see example2.classes.lookup.impl.EnvironmentPackageImpl#getLookupEnvironment()
		 * @generated
		 */
		EClass LOOKUP_ENVIRONMENT = eINSTANCE.getLookupEnvironment();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOKUP_ENVIRONMENT__ENTRIES = eINSTANCE.getLookupEnvironment_Entries();

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
		 * The meta object literal for the '<em><b>Add Element With Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOKUP_ENVIRONMENT___ADD_ELEMENT_WITH_NAME__STRING_NAMEDELEMENT = eINSTANCE.getLookupEnvironment__AddElementWithName__String_NamedElement();

		/**
		 * The meta object literal for the '<em><b>Get Named Elements</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation LOOKUP_ENVIRONMENT___GET_NAMED_ELEMENTS__STRING = eINSTANCE.getLookupEnvironment__GetNamedElements__String();

		/**
		 * The meta object literal for the '{@link example2.classes.lookup.Env4CG <em>Env4 CG</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example2.classes.lookup.Env4CG
		 * @see example2.classes.lookup.impl.EnvironmentPackageImpl#getEnv4CG()
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
		 * The meta object literal for the '{@link example2.classes.lookup.impl.EnvEntryImpl <em>Env Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example2.classes.lookup.impl.EnvEntryImpl
		 * @see example2.classes.lookup.impl.EnvironmentPackageImpl#getEnvEntry()
		 * @generated
		 */
		EClass ENV_ENTRY = eINSTANCE.getEnvEntry();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENV_ENTRY__NAME = eINSTANCE.getEnvEntry_Name();

		/**
		 * The meta object literal for the '<em><b>Named Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENV_ENTRY__NAMED_ELEMENTS = eINSTANCE.getEnvEntry_NamedElements();

		/**
		 * The meta object literal for the '<em><b>Env</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENV_ENTRY__ENV = eINSTANCE.getEnvEntry_Env();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.evaluation.Executor <em>Executor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.evaluation.Executor
		 * @see example2.classes.lookup.impl.EnvironmentPackageImpl#getExecutor()
		 * @generated
		 */
		EClass EXECUTOR = eINSTANCE.getExecutor();

	}

} //EnvironmentPackage
