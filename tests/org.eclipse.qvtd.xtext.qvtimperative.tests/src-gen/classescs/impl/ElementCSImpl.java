/**
 */
package classescs.impl;

import classes.Element;

import classescs.ClassescsPackage;
import classescs.ElementCS;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link classescs.impl.ElementCSImpl#getAst <em>Ast</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementCSImpl extends MinimalEObjectImpl.Container implements ElementCS {
	/**
	 * The cached value of the '{@link #getAst() <em>Ast</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAst()
	 * @generated
	 * @ordered
	 */
	protected Element ast;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassescsPackage.Literals.ELEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getAst() {
		if (ast != null && ast.eIsProxy()) {
			InternalEObject oldAst = (InternalEObject)ast;
			ast = (Element)eResolveProxy(oldAst);
			if (ast != oldAst) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassescsPackage.ELEMENT_CS__AST, oldAst, ast));
			}
		}
		return ast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetAst() {
		return ast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAst(Element newAst) {
		Element oldAst = ast;
		ast = newAst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassescsPackage.ELEMENT_CS__AST, oldAst, ast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassescsPackage.ELEMENT_CS__AST:
				if (resolve) return getAst();
				return basicGetAst();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassescsPackage.ELEMENT_CS__AST:
				setAst((Element)newValue);
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
			case ClassescsPackage.ELEMENT_CS__AST:
				setAst((Element)null);
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
			case ClassescsPackage.ELEMENT_CS__AST:
				return ast != null;
		}
		return super.eIsSet(featureID);
	}

} //ElementCSImpl
