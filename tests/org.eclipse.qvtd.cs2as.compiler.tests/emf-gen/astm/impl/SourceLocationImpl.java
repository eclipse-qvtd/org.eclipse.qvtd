/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package astm.impl;

import astm.AstmPackage;
import astm.SourceFile;
import astm.SourceLocation;

import astm.util.Visitor;

import java.lang.Integer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link astm.impl.SourceLocationImpl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link astm.impl.SourceLocationImpl#getStartColumn <em>Start Column</em>}</li>
 *   <li>{@link astm.impl.SourceLocationImpl#getEndLine <em>End Line</em>}</li>
 *   <li>{@link astm.impl.SourceLocationImpl#getEndColumn <em>End Column</em>}</li>
 *   <li>{@link astm.impl.SourceLocationImpl#getInSourceFile <em>In Source File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceLocationImpl extends GASTMSourceObjectImpl implements SourceLocation {
	/**
	 * The default value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected static final int START_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected int startLine = START_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartColumn() <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int START_COLUMN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartColumn() <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartColumn()
	 * @generated
	 * @ordered
	 */
	protected int startColumn = START_COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected static final int END_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected int endLine = END_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndColumn() <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndColumn()
	 * @generated
	 * @ordered
	 */
	protected static final int END_COLUMN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndColumn() <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndColumn()
	 * @generated
	 * @ordered
	 */
	protected int endColumn = END_COLUMN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInSourceFile() <em>In Source File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSourceFile()
	 * @generated
	 * @ordered
	 */
	protected SourceFile inSourceFile;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstmPackage.Literals.SOURCE_LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartLine() {
		return startLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLine(int newStartLine) {
		int oldStartLine = startLine;
		startLine = newStartLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.SOURCE_LOCATION__START_LINE, oldStartLine, startLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartColumn() {
		return startColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartColumn(int newStartColumn) {
		int oldStartColumn = startColumn;
		startColumn = newStartColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.SOURCE_LOCATION__START_COLUMN, oldStartColumn, startColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndLine() {
		return endLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndLine(int newEndLine) {
		int oldEndLine = endLine;
		endLine = newEndLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.SOURCE_LOCATION__END_LINE, oldEndLine, endLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndColumn() {
		return endColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndColumn(int newEndColumn) {
		int oldEndColumn = endColumn;
		endColumn = newEndColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.SOURCE_LOCATION__END_COLUMN, oldEndColumn, endColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFile getInSourceFile() {
		return inSourceFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInSourceFile(SourceFile newInSourceFile, NotificationChain msgs) {
		SourceFile oldInSourceFile = inSourceFile;
		inSourceFile = newInSourceFile;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstmPackage.SOURCE_LOCATION__IN_SOURCE_FILE, oldInSourceFile, newInSourceFile);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSourceFile(SourceFile newInSourceFile) {
		if (newInSourceFile != inSourceFile) {
			NotificationChain msgs = null;
			if (inSourceFile != null)
				msgs = ((InternalEObject)inSourceFile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstmPackage.SOURCE_LOCATION__IN_SOURCE_FILE, null, msgs);
			if (newInSourceFile != null)
				msgs = ((InternalEObject)newInSourceFile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstmPackage.SOURCE_LOCATION__IN_SOURCE_FILE, null, msgs);
			msgs = basicSetInSourceFile(newInSourceFile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstmPackage.SOURCE_LOCATION__IN_SOURCE_FILE, newInSourceFile, newInSourceFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstmPackage.SOURCE_LOCATION__IN_SOURCE_FILE:
				return basicSetInSourceFile(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstmPackage.SOURCE_LOCATION__START_LINE:
				return getStartLine();
			case AstmPackage.SOURCE_LOCATION__START_COLUMN:
				return getStartColumn();
			case AstmPackage.SOURCE_LOCATION__END_LINE:
				return getEndLine();
			case AstmPackage.SOURCE_LOCATION__END_COLUMN:
				return getEndColumn();
			case AstmPackage.SOURCE_LOCATION__IN_SOURCE_FILE:
				return getInSourceFile();
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
			case AstmPackage.SOURCE_LOCATION__START_LINE:
				setStartLine((Integer)newValue);
				return;
			case AstmPackage.SOURCE_LOCATION__START_COLUMN:
				setStartColumn((Integer)newValue);
				return;
			case AstmPackage.SOURCE_LOCATION__END_LINE:
				setEndLine((Integer)newValue);
				return;
			case AstmPackage.SOURCE_LOCATION__END_COLUMN:
				setEndColumn((Integer)newValue);
				return;
			case AstmPackage.SOURCE_LOCATION__IN_SOURCE_FILE:
				setInSourceFile((SourceFile)newValue);
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
			case AstmPackage.SOURCE_LOCATION__START_LINE:
				setStartLine(START_LINE_EDEFAULT);
				return;
			case AstmPackage.SOURCE_LOCATION__START_COLUMN:
				setStartColumn(START_COLUMN_EDEFAULT);
				return;
			case AstmPackage.SOURCE_LOCATION__END_LINE:
				setEndLine(END_LINE_EDEFAULT);
				return;
			case AstmPackage.SOURCE_LOCATION__END_COLUMN:
				setEndColumn(END_COLUMN_EDEFAULT);
				return;
			case AstmPackage.SOURCE_LOCATION__IN_SOURCE_FILE:
				setInSourceFile((SourceFile)null);
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
			case AstmPackage.SOURCE_LOCATION__START_LINE:
				return startLine != START_LINE_EDEFAULT;
			case AstmPackage.SOURCE_LOCATION__START_COLUMN:
				return startColumn != START_COLUMN_EDEFAULT;
			case AstmPackage.SOURCE_LOCATION__END_LINE:
				return endLine != END_LINE_EDEFAULT;
			case AstmPackage.SOURCE_LOCATION__END_COLUMN:
				return endColumn != END_COLUMN_EDEFAULT;
			case AstmPackage.SOURCE_LOCATION__IN_SOURCE_FILE:
				return inSourceFile != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (startLine: ");
		result.append(startLine);
		result.append(", startColumn: ");
		result.append(startColumn);
		result.append(", endLine: ");
		result.append(endLine);
		result.append(", endColumn: ");
		result.append(endColumn);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitSourceLocation(this);
	}

} //SourceLocationImpl
