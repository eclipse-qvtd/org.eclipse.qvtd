/**
 */
package test.umltordbms.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import test.simplerdbms.Column;
import test.simplerdbms.Key;
import test.simplerdbms.Table;

import test.umltordbms.AssociationToForeignKey;
import test.umltordbms.ClassToTable;
import test.umltordbms.PackageToSchema;
import test.umltordbms.ToColumn;
import test.umltordbms.UmltordbmsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class To Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link test.umltordbms.impl.ClassToTableImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link test.umltordbms.impl.ClassToTableImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link test.umltordbms.impl.ClassToTableImpl#getAssociationsToForeignKeys <em>Associations To Foreign Keys</em>}</li>
 *   <li>{@link test.umltordbms.impl.ClassToTableImpl#getName <em>Name</em>}</li>
 *   <li>{@link test.umltordbms.impl.ClassToTableImpl#getUmlClass <em>Uml Class</em>}</li>
 *   <li>{@link test.umltordbms.impl.ClassToTableImpl#getTable <em>Table</em>}</li>
 *   <li>{@link test.umltordbms.impl.ClassToTableImpl#getPrimaryKey <em>Primary Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassToTableImpl extends FromAttributeOwnerImpl implements ClassToTable {
	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected Column column;

	/**
	 * The cached value of the '{@link #getAssociationsToForeignKeys() <em>Associations To Foreign Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationsToForeignKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<AssociationToForeignKey> associationsToForeignKeys;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUmlClass() <em>Uml Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlClass()
	 * @generated
	 * @ordered
	 */
	protected test.simpleuml.Class umlClass;

	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected Table table;

	/**
	 * The cached value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected Key primaryKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassToTableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmltordbmsPackage.Literals.CLASS_TO_TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column getColumn() {
		if (column != null && column.eIsProxy()) {
			InternalEObject oldColumn = (InternalEObject)column;
			column = (Column)eResolveProxy(oldColumn);
			if (column != oldColumn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmltordbmsPackage.CLASS_TO_TABLE__COLUMN, oldColumn, column));
			}
		}
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(Column newColumn) {
		Column oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.CLASS_TO_TABLE__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageToSchema getOwner() {
		if (eContainerFeatureID() != UmltordbmsPackage.CLASS_TO_TABLE__OWNER) return null;
		return (PackageToSchema)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(PackageToSchema newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, UmltordbmsPackage.CLASS_TO_TABLE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(PackageToSchema newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != UmltordbmsPackage.CLASS_TO_TABLE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, UmltordbmsPackage.PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES, PackageToSchema.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.CLASS_TO_TABLE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssociationToForeignKey> getAssociationsToForeignKeys() {
		if (associationsToForeignKeys == null) {
			associationsToForeignKeys = new EObjectContainmentWithInverseEList<AssociationToForeignKey>(AssociationToForeignKey.class, this, UmltordbmsPackage.CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS, UmltordbmsPackage.ASSOCIATION_TO_FOREIGN_KEY__OWNER);
		}
		return associationsToForeignKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.CLASS_TO_TABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public test.simpleuml.Class getUmlClass() {
		if (umlClass != null && umlClass.eIsProxy()) {
			InternalEObject oldUmlClass = (InternalEObject)umlClass;
			umlClass = (test.simpleuml.Class)eResolveProxy(oldUmlClass);
			if (umlClass != oldUmlClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmltordbmsPackage.CLASS_TO_TABLE__UML_CLASS, oldUmlClass, umlClass));
			}
		}
		return umlClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public test.simpleuml.Class basicGetUmlClass() {
		return umlClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlClass(test.simpleuml.Class newUmlClass) {
		test.simpleuml.Class oldUmlClass = umlClass;
		umlClass = newUmlClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.CLASS_TO_TABLE__UML_CLASS, oldUmlClass, umlClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table getTable() {
		if (table != null && table.eIsProxy()) {
			InternalEObject oldTable = (InternalEObject)table;
			table = (Table)eResolveProxy(oldTable);
			if (table != oldTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmltordbmsPackage.CLASS_TO_TABLE__TABLE, oldTable, table));
			}
		}
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetTable() {
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTable(Table newTable) {
		Table oldTable = table;
		table = newTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.CLASS_TO_TABLE__TABLE, oldTable, table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Key getPrimaryKey() {
		if (primaryKey != null && primaryKey.eIsProxy()) {
			InternalEObject oldPrimaryKey = (InternalEObject)primaryKey;
			primaryKey = (Key)eResolveProxy(oldPrimaryKey);
			if (primaryKey != oldPrimaryKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmltordbmsPackage.CLASS_TO_TABLE__PRIMARY_KEY, oldPrimaryKey, primaryKey));
			}
		}
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Key basicGetPrimaryKey() {
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryKey(Key newPrimaryKey) {
		Key oldPrimaryKey = primaryKey;
		primaryKey = newPrimaryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmltordbmsPackage.CLASS_TO_TABLE__PRIMARY_KEY, oldPrimaryKey, primaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmltordbmsPackage.CLASS_TO_TABLE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((PackageToSchema)otherEnd, msgs);
			case UmltordbmsPackage.CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationsToForeignKeys()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmltordbmsPackage.CLASS_TO_TABLE__OWNER:
				return basicSetOwner(null, msgs);
			case UmltordbmsPackage.CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS:
				return ((InternalEList<?>)getAssociationsToForeignKeys()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UmltordbmsPackage.CLASS_TO_TABLE__OWNER:
				return eInternalContainer().eInverseRemove(this, UmltordbmsPackage.PACKAGE_TO_SCHEMA__CLASSES_TO_TABLES, PackageToSchema.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmltordbmsPackage.CLASS_TO_TABLE__COLUMN:
				if (resolve) return getColumn();
				return basicGetColumn();
			case UmltordbmsPackage.CLASS_TO_TABLE__OWNER:
				return getOwner();
			case UmltordbmsPackage.CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS:
				return getAssociationsToForeignKeys();
			case UmltordbmsPackage.CLASS_TO_TABLE__NAME:
				return getName();
			case UmltordbmsPackage.CLASS_TO_TABLE__UML_CLASS:
				if (resolve) return getUmlClass();
				return basicGetUmlClass();
			case UmltordbmsPackage.CLASS_TO_TABLE__TABLE:
				if (resolve) return getTable();
				return basicGetTable();
			case UmltordbmsPackage.CLASS_TO_TABLE__PRIMARY_KEY:
				if (resolve) return getPrimaryKey();
				return basicGetPrimaryKey();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UmltordbmsPackage.CLASS_TO_TABLE__COLUMN:
				setColumn((Column)newValue);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__OWNER:
				setOwner((PackageToSchema)newValue);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS:
				getAssociationsToForeignKeys().clear();
				getAssociationsToForeignKeys().addAll((Collection<? extends AssociationToForeignKey>)newValue);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__NAME:
				setName((String)newValue);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__UML_CLASS:
				setUmlClass((test.simpleuml.Class)newValue);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__TABLE:
				setTable((Table)newValue);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__PRIMARY_KEY:
				setPrimaryKey((Key)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UmltordbmsPackage.CLASS_TO_TABLE__COLUMN:
				setColumn((Column)null);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__OWNER:
				setOwner((PackageToSchema)null);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS:
				getAssociationsToForeignKeys().clear();
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__UML_CLASS:
				setUmlClass((test.simpleuml.Class)null);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__TABLE:
				setTable((Table)null);
				return;
			case UmltordbmsPackage.CLASS_TO_TABLE__PRIMARY_KEY:
				setPrimaryKey((Key)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UmltordbmsPackage.CLASS_TO_TABLE__COLUMN:
				return column != null;
			case UmltordbmsPackage.CLASS_TO_TABLE__OWNER:
				return getOwner() != null;
			case UmltordbmsPackage.CLASS_TO_TABLE__ASSOCIATIONS_TO_FOREIGN_KEYS:
				return associationsToForeignKeys != null && !associationsToForeignKeys.isEmpty();
			case UmltordbmsPackage.CLASS_TO_TABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmltordbmsPackage.CLASS_TO_TABLE__UML_CLASS:
				return umlClass != null;
			case UmltordbmsPackage.CLASS_TO_TABLE__TABLE:
				return table != null;
			case UmltordbmsPackage.CLASS_TO_TABLE__PRIMARY_KEY:
				return primaryKey != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ToColumn.class) {
			switch (derivedFeatureID) {
				case UmltordbmsPackage.CLASS_TO_TABLE__COLUMN: return UmltordbmsPackage.TO_COLUMN__COLUMN;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ToColumn.class) {
			switch (baseFeatureID) {
				case UmltordbmsPackage.TO_COLUMN__COLUMN: return UmltordbmsPackage.CLASS_TO_TABLE__COLUMN;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ClassToTableImpl
