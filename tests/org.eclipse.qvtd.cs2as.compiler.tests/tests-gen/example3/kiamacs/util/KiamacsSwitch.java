/**
 */
package example3.kiamacs.util;

import example3.kiamacs.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see example3.kiamacs.KiamacsPackage
 * @generated
 */
public class KiamacsSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KiamacsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KiamacsSwitch() {
		if (modelPackage == null) {
			modelPackage = KiamacsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case KiamacsPackage.TOP_CS: {
				TopCS topCS = (TopCS)theEObject;
				T result = caseTopCS(topCS);
				if (result == null) result = caseBaseCS(topCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KiamacsPackage.NODE_CS: {
				NodeCS nodeCS = (NodeCS)theEObject;
				T result = caseNodeCS(nodeCS);
				if (result == null) result = caseBaseCS(nodeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KiamacsPackage.PLUS_CS: {
				PlusCS plusCS = (PlusCS)theEObject;
				T result = casePlusCS(plusCS);
				if (result == null) result = caseNodeCS(plusCS);
				if (result == null) result = caseBaseCS(plusCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KiamacsPackage.NUM_CS: {
				NumCS numCS = (NumCS)theEObject;
				T result = caseNumCS(numCS);
				if (result == null) result = caseNodeCS(numCS);
				if (result == null) result = caseBaseCS(numCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KiamacsPackage.BASE_CS: {
				BaseCS baseCS = (BaseCS)theEObject;
				T result = caseBaseCS(baseCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopCS(TopCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeCS(NodeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plus CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plus CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlusCS(PlusCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Num CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Num CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumCS(NumCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseCS(BaseCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //KiamacsSwitch
