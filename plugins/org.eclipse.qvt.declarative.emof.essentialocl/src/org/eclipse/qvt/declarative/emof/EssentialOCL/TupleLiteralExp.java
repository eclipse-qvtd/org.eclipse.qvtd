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
 * $Id: TupleLiteralExp.java,v 1.1 2008/07/23 09:56:31 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.EssentialOCL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.EssentialOCL.TupleLiteralExp#getPart <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getTupleLiteralExp()
 * @model
 * @generated
 */
public interface TupleLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EssentialOCL.TupleLiteralPart}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.EssentialOCL.TupleLiteralPart#getTupleLiteralExp <em>Tuple Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage#getTupleLiteralExp_Part()
	 * @see org.eclipse.qvt.declarative.emof.EssentialOCL.TupleLiteralPart#getTupleLiteralExp
	 * @model opposite="tupleLiteralExp" containment="true" ordered="false"
	 * @generated
	 */
	EList<TupleLiteralPart> getPart();

} // TupleLiteralExp
