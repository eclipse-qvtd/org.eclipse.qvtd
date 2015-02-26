/**
 */
package classes;

import org.eclipse.emf.ecore.EObject;

import classes.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see classes.ClassesPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Accept a visit from a visitor and return the result of a call to the derived type-specific visitXXX in the visitor.
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build/templates/model/Class/insert.javajetinc
	public <R> R accept(Visitor<R> visitor);
} // Element
