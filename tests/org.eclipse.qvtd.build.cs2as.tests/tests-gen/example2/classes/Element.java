/**
 */
package example2.classes;

import org.eclipse.emf.ecore.EObject;

import example2.classes.util.Visitable;
import example2.classes.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see example2.classes.ClassesPackage#getElement()
 * @model abstract="true" superTypes="example2.classes.Visitable"
 * @generated
 */
public interface Element extends EObject, Visitable {

	/**
	 * Accept a visit from a visitor and return the result of a call to the derived type-specific visitXXX in the visitor.
	 * @generated
	 */
	// Generated from org.eclipse.ocl.examples.build/templates/model/Class/insert.javajetinc
	public <R> R accept(Visitor<R> visitor);
} // Element
