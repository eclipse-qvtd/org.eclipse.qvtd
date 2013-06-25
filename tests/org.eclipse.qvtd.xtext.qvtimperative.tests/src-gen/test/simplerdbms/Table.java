/**
 */
package test.simplerdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.simplerdbms.Table#getColumn <em>Column</em>}</li>
 *   <li>{@link test.simplerdbms.Table#getSchema <em>Schema</em>}</li>
 *   <li>{@link test.simplerdbms.Table#getTheKey <em>The Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.simplerdbms.SimplerdbmsPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference list.
	 * The list contents are of type {@link test.simplerdbms.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference list.
	 * @see test.simplerdbms.SimplerdbmsPackage#getTable_Column()
	 * @model
	 * @generated
	 */
	EList<Column> getColumn();

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.Schema#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' reference.
	 * @see #setSchema(Schema)
	 * @see test.simplerdbms.SimplerdbmsPackage#getTable_Schema()
	 * @see test.simplerdbms.Schema#getTables
	 * @model opposite="tables" required="true"
	 * @generated
	 */
	Schema getSchema();

	/**
	 * Sets the value of the '{@link test.simplerdbms.Table#getSchema <em>Schema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' reference.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(Schema value);

	/**
	 * Returns the value of the '<em><b>The Key</b></em>' reference list.
	 * The list contents are of type {@link test.simplerdbms.Key}.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.Key#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Key</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>The Key</em>' reference list.
	 * @see test.simplerdbms.SimplerdbmsPackage#getTable_TheKey()
	 * @see test.simplerdbms.Key#getOwner
	 * @model opposite="owner"
	 * @generated
	 */
	EList<Key> getTheKey();

} // Table
