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
package astm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delphi With Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.DelphiWithStatement#getWiths <em>Withs</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getDelphiWithStatement()
 * @model
 * @generated
 */
public interface DelphiWithStatement extends BlockStatement {
	/**
	 * Returns the value of the '<em><b>Withs</b></em>' reference list.
	 * The list contents are of type {@link astm.DefinitionObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Withs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Withs</em>' reference list.
	 * @see astm.AstmPackage#getDelphiWithStatement_Withs()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!DelphiWithStatement!withs'"
	 * @generated
	 */
	EList<DefinitionObject> getWiths();

} // DelphiWithStatement
