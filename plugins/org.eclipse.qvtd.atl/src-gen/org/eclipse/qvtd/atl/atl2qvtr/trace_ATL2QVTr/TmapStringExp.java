/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap String Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getT0symbol <em>T0symbol</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapStringExp()
 * @model
 * @generated
 */
public interface TmapStringExp extends ImapOclExpression {
	/**
	 * Returns the value of the '<em><b>Dispatcher</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapStringExp <em>Domap String Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispatcher</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispatcher</em>' container reference.
	 * @see #setDispatcher(DmapOclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapStringExp_Dispatcher()
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapStringExp
	 * @model opposite="domapStringExp" required="true" transient="false"
	 * @generated
	 */
	DmapOclExpression getDispatcher();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getDispatcher <em>Dispatcher</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dispatcher</em>' container reference.
	 * @see #getDispatcher()
	 * @generated
	 */
	void setDispatcher(DmapOclExpression value);

	/**
	 * Returns the value of the '<em><b>T0symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T0symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T0symbol</em>' attribute.
	 * @see #setT0symbol(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapStringExp_T0symbol()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getT0symbol();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getT0symbol <em>T0symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T0symbol</em>' attribute.
	 * @see #getT0symbol()
	 * @generated
	 */
	void setT0symbol(String value);

} // TmapStringExp