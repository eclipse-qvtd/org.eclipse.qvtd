/**
 */
package example1.env;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.pivot.evaluation.Evaluator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Env4 CG</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see example1.env.EnvironmentPackage#getEnv4CG()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Env4CG extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example1/env/1.0!Env4CG!hasFinalResult()'"
	 * @generated
	 */
	boolean hasFinalResult();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="example1.env.Evaluator"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example1/env/1.0!Env4CG!getEvaluator()'"
	 * @generated
	 */
	Evaluator getEvaluator();

} // Env4CG
