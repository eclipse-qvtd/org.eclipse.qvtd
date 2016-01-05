/**
 */
package example4.kiamacs.util;

import example4.kiamacs.*;

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
 * @see example4.kiamacs.KiamacsPackage
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
			case KiamacsPackage.COMPOSITE_CS: {
				CompositeCS compositeCS = (CompositeCS)theEObject;
				T result = caseCompositeCS(compositeCS);
				if (result == null) result = caseNodeCS(compositeCS);
				if (result == null) result = caseBaseCS(compositeCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case KiamacsPackage.LEAF_CS: {
				LeafCS leafCS = (LeafCS)theEObject;
				T result = caseLeafCS(leafCS);
				if (result == null) result = caseNodeCS(leafCS);
				if (result == null) result = caseBaseCS(leafCS);
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
	 * Returns the result of interpreting the object as an instance of '<em>Composite CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeCS(CompositeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leaf CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leaf CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeafCS(LeafCS object) {
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
