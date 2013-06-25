/**
 */
package test.simplerdbms;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link test.simplerdbms.ForeignKey#getRefersTo <em>Refers To</em>}</li>
 *   <li>{@link test.simplerdbms.ForeignKey#getColumn <em>Column</em>}</li>
 *   <li>{@link test.simplerdbms.ForeignKey#getOwner <em>Owner</em>}</li>
 *   <li>{@link test.simplerdbms.ForeignKey#getSchema <em>Schema</em>}</li>
 * </ul>
 * </p>
 *
 * @see test.simplerdbms.SimplerdbmsPackage#getForeignKey()
 * @model
 * @generated
 */
public interface ForeignKey extends RModelElement {
	/**
	 * Returns the value of the '<em><b>Refers To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refers To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refers To</em>' reference.
	 * @see #setRefersTo(Key)
	 * @see test.simplerdbms.SimplerdbmsPackage#getForeignKey_RefersTo()
	 * @model required="true"
	 * @generated
	 */
	Key getRefersTo();

	/**
	 * Sets the value of the '{@link test.simplerdbms.ForeignKey#getRefersTo <em>Refers To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refers To</em>' reference.
	 * @see #getRefersTo()
	 * @generated
	 */
	void setRefersTo(Key value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference list.
	 * The list contents are of type {@link test.simplerdbms.Column}.
	 * It is bidirectional and its opposite is '{@link test.simplerdbms.Column#getForeignKeys <em>Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference list.
	 * @see test.simplerdbms.SimplerdbmsPackage#getForeignKey_Column()
	 * @see test.simplerdbms.Column#getForeignKeys
	 * @model opposite="foreignKeys"
	 * @generated
	 */
	EList<Column> getColumn();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(Table)
	 * @see test.simplerdbms.SimplerdbmsPackage#getForeignKey_Owner()
	 * @model required="true"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link test.simplerdbms.ForeignKey#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Schema</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' reference.
	 * @see #setSchema(Schema)
	 * @see test.simplerdbms.SimplerdbmsPackage#getForeignKey_Schema()
	 * @model required="true"
	 * @generated
	 */
	Schema getSchema();

	/**
	 * Sets the value of the '{@link test.simplerdbms.ForeignKey#getSchema <em>Schema</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' reference.
	 * @see #getSchema()
	 * @generated
	 */
	void setSchema(Schema value);

} // ForeignKey
