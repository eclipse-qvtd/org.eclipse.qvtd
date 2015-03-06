/**
 */
package example2.env;

import org.eclipse.emf.ecore.EClass;
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
 * @see example2.env.EnvironmentFactory
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
	String eNAME = "env";

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
	String eNS_PREFIX = "env";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvironmentPackage eINSTANCE = example2.env.impl.EnvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link example2.env.Env4CG <em>Env4 CG</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example2.env.Env4CG
	 * @see example2.env.impl.EnvironmentPackageImpl#getEnv4CG()
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
	 * The meta object id for the '{@link example2.env.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example2.env.impl.EnvironmentImpl
	 * @see example2.env.impl.EnvironmentPackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Named Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__NAMED_ELEMENTS = ENV4_CG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Env</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__PARENT_ENV = ENV4_CG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = ENV4_CG_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.pivot.evaluation.Evaluator <em>Evaluator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.pivot.evaluation.Evaluator
	 * @see example2.env.impl.EnvironmentPackageImpl#getEvaluator()
	 * @generated
	 */
	int EVALUATOR = 2;

	/**
	 * The number of structural features of the '<em>Evaluator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATOR_FEATURE_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link example2.env.Environment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see example2.env.Environment
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for the reference list '{@link example2.env.Environment#getNamedElements <em>Named Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Named Elements</em>'.
	 * @see example2.env.Environment#getNamedElements()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_NamedElements();

	/**
	 * Returns the meta object for the reference '{@link example2.env.Environment#getParentEnv <em>Parent Env</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Env</em>'.
	 * @see example2.env.Environment#getParentEnv()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_ParentEnv();

	/**
	 * Returns the meta object for class '{@link example2.env.Env4CG <em>Env4 CG</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Env4 CG</em>'.
	 * @see example2.env.Env4CG
	 * @generated
	 */
	EClass getEnv4CG();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.pivot.evaluation.Evaluator <em>Evaluator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluator</em>'.
	 * @see org.eclipse.ocl.pivot.evaluation.Evaluator
	 * @model instanceClass="org.eclipse.ocl.pivot.evaluation.Evaluator"
	 * @generated
	 */
	EClass getEvaluator();

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
		 * The meta object literal for the '{@link example2.env.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example2.env.impl.EnvironmentImpl
		 * @see example2.env.impl.EnvironmentPackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '<em><b>Named Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__NAMED_ELEMENTS = eINSTANCE.getEnvironment_NamedElements();

		/**
		 * The meta object literal for the '<em><b>Parent Env</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT__PARENT_ENV = eINSTANCE.getEnvironment_ParentEnv();

		/**
		 * The meta object literal for the '{@link example2.env.Env4CG <em>Env4 CG</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example2.env.Env4CG
		 * @see example2.env.impl.EnvironmentPackageImpl#getEnv4CG()
		 * @generated
		 */
		EClass ENV4_CG = eINSTANCE.getEnv4CG();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.pivot.evaluation.Evaluator <em>Evaluator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.pivot.evaluation.Evaluator
		 * @see example2.env.impl.EnvironmentPackageImpl#getEvaluator()
		 * @generated
		 */
		EClass EVALUATOR = eINSTANCE.getEvaluator();

	}

} //EnvironmentPackage
