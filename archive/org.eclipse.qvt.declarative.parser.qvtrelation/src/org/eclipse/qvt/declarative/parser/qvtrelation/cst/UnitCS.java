/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UnitCS.java,v 1.1 2008/07/23 10:07:42 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getUnitCS()
 * @model
 * @generated
 */
public interface UnitCS extends CSTNode {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getUnitCS_Identifier()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IdentifierCS> getIdentifier();

} // UnitCS
