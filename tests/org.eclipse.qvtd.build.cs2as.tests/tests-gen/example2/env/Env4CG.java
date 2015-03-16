/**
 */
package example2.env;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.evaluation.Evaluator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Env4 CG</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see example2.env.EnvironmentPackage#getEnv4CG()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Env4CG extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new <%java.lang.UnsupportedOperationException%>(\"Enviroment::hasFinalResult() has been created for CG purposes. Don\'t call this method\");'"
	 * @generated
	 */
	boolean hasFinalResult();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="example2.env.Evaluator"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new <%java.lang.UnsupportedOperationException%>(\"Enviroment::getEvaluator() has been created for CG purposes. Don\'t call this method\");'"
	 * @generated
	 */
	Evaluator getEvaluator();

} // Env4CG
