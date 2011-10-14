/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: ProblemImpl.java,v 1.2 2008/10/09 17:21:15 qglineur Exp $
 */
package org.eclipse.qvt.declarative.atlvm.problems.problems.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.qvt.declarative.atlvm.problems.problems.Problem;
import org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage;
import org.eclipse.qvt.declarative.atlvm.problems.problems.Severity;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Problem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl#getStartColumn <em>Start Column</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl#getEndLine <em>End Line</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl#getEndColumn <em>End Column</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.atlvm.problems.problems.impl.ProblemImpl#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProblemImpl extends EObjectImpl implements Problem {
	/**
	 * <!-- begin-user-doc -->
	 * The pattern used to handle the location derived property
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected static final Pattern locationPattern = Pattern.compile("(\\d+):(\\d+)-(\\d+):(\\d+)");
	
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected static final Integer START_LINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected Integer startLine = START_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartColumn() <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartColumn()
	 * @generated
	 * @ordered
	 */
	protected static final Integer START_COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartColumn() <em>Start Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartColumn()
	 * @generated
	 * @ordered
	 */
	protected Integer startColumn = START_COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected static final Integer END_LINE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected Integer endLine = END_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndColumn() <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndColumn()
	 * @generated
	 * @ordered
	 */
	protected static final Integer END_COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndColumn() <em>End Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndColumn()
	 * @generated
	 * @ordered
	 */
	protected Integer endColumn = END_COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final Severity SEVERITY_EDEFAULT = Severity.WARNING;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected Severity severity = SEVERITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProblemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProblemsPackage.Literals.PROBLEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProblemsPackage.PROBLEM__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartLine() {
		return startLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLine(Integer newStartLine) {
		Integer oldStartLine = startLine;
		startLine = newStartLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProblemsPackage.PROBLEM__START_LINE, oldStartLine, startLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStartColumn() {
		return startColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartColumn(Integer newStartColumn) {
		Integer oldStartColumn = startColumn;
		startColumn = newStartColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProblemsPackage.PROBLEM__START_COLUMN, oldStartColumn, startColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getEndLine() {
		return endLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndLine(Integer newEndLine) {
		Integer oldEndLine = endLine;
		endLine = newEndLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProblemsPackage.PROBLEM__END_LINE, oldEndLine, endLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getEndColumn() {
		return endColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndColumn(Integer newEndColumn) {
		Integer oldEndColumn = endColumn;
		endColumn = newEndColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProblemsPackage.PROBLEM__END_COLUMN, oldEndColumn, endColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getLocation() {
		StringBuffer location = new StringBuffer();
		location.append(startLine.toString());
		location.append(":");
		location.append(startColumn.toString());
		location.append("-");
		location.append(endLine.toString());
		location.append(":");
		location.append(endColumn.toString());
		return location.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLocation(String newLocation) {
		String oldLocation = this.getLocation();
		Matcher locationMatcher = locationPattern.matcher(newLocation);
		this.setStartColumn(Integer.parseInt(locationMatcher.group(1)));
		this.setStartColumn(Integer.parseInt(locationMatcher.group(2)));
		this.setEndLine(Integer.parseInt(locationMatcher.group(3)));
		this.setEndColumn(Integer.parseInt(locationMatcher.group(4)));
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProblemsPackage.PROBLEM__LOCATION, oldLocation, this.getLocation()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(Severity newSeverity) {
		Severity oldSeverity = severity;
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProblemsPackage.PROBLEM__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProblemsPackage.PROBLEM__DESCRIPTION:
				return getDescription();
			case ProblemsPackage.PROBLEM__START_LINE:
				return getStartLine();
			case ProblemsPackage.PROBLEM__START_COLUMN:
				return getStartColumn();
			case ProblemsPackage.PROBLEM__END_LINE:
				return getEndLine();
			case ProblemsPackage.PROBLEM__END_COLUMN:
				return getEndColumn();
			case ProblemsPackage.PROBLEM__LOCATION:
				return getLocation();
			case ProblemsPackage.PROBLEM__SEVERITY:
				return getSeverity();
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
			case ProblemsPackage.PROBLEM__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ProblemsPackage.PROBLEM__START_LINE:
				setStartLine((Integer)newValue);
				return;
			case ProblemsPackage.PROBLEM__START_COLUMN:
				setStartColumn((Integer)newValue);
				return;
			case ProblemsPackage.PROBLEM__END_LINE:
				setEndLine((Integer)newValue);
				return;
			case ProblemsPackage.PROBLEM__END_COLUMN:
				setEndColumn((Integer)newValue);
				return;
			case ProblemsPackage.PROBLEM__LOCATION:
				setLocation((String)newValue);
				return;
			case ProblemsPackage.PROBLEM__SEVERITY:
				setSeverity((Severity)newValue);
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
			case ProblemsPackage.PROBLEM__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ProblemsPackage.PROBLEM__START_LINE:
				setStartLine(START_LINE_EDEFAULT);
				return;
			case ProblemsPackage.PROBLEM__START_COLUMN:
				setStartColumn(START_COLUMN_EDEFAULT);
				return;
			case ProblemsPackage.PROBLEM__END_LINE:
				setEndLine(END_LINE_EDEFAULT);
				return;
			case ProblemsPackage.PROBLEM__END_COLUMN:
				setEndColumn(END_COLUMN_EDEFAULT);
				return;
			case ProblemsPackage.PROBLEM__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case ProblemsPackage.PROBLEM__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
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
			case ProblemsPackage.PROBLEM__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ProblemsPackage.PROBLEM__START_LINE:
				return START_LINE_EDEFAULT == null ? startLine != null : !START_LINE_EDEFAULT.equals(startLine);
			case ProblemsPackage.PROBLEM__START_COLUMN:
				return START_COLUMN_EDEFAULT == null ? startColumn != null : !START_COLUMN_EDEFAULT.equals(startColumn);
			case ProblemsPackage.PROBLEM__END_LINE:
				return END_LINE_EDEFAULT == null ? endLine != null : !END_LINE_EDEFAULT.equals(endLine);
			case ProblemsPackage.PROBLEM__END_COLUMN:
				return END_COLUMN_EDEFAULT == null ? endColumn != null : !END_COLUMN_EDEFAULT.equals(endColumn);
			case ProblemsPackage.PROBLEM__LOCATION:
				return LOCATION_EDEFAULT == null ? getLocation() != null : !LOCATION_EDEFAULT.equals(getLocation());
			case ProblemsPackage.PROBLEM__SEVERITY:
				return severity != SEVERITY_EDEFAULT;
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
		result.append(" (description: ");
		result.append(description);
		result.append(", startLine: ");
		result.append(startLine);
		result.append(", startColumn: ");
		result.append(startColumn);
		result.append(", endLine: ");
		result.append(endLine);
		result.append(", endColumn: ");
		result.append(endColumn);
		result.append(", severity: ");
		result.append(severity);
		result.append(')');
		return result.toString();
	}

} //ProblemImpl
