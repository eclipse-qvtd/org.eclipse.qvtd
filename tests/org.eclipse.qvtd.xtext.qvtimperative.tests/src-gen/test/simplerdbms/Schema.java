/**
 */
package test.simplerdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.simplerdbms.Schema#getTables <em>Tables</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.simplerdbms.SimplerdbmsPackage#getSchema()
 * @model
 * @generated
 */
public interface Schema extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link test.simplerdbms.Table}.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.Table#getSchema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see test.simplerdbms.SimplerdbmsPackage#getSchema_Tables()
	 * @see test.simplerdbms.Table#getSchema
	 * @model opposite="schema" containment="true"
	 * @generated
	 */
	EList<Table> getTables();

} // Schema
