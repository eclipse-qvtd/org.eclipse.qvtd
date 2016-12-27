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
 * A representation of the model object '<em><b>GASTM Syntax Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link astm.GASTMSyntaxObject#getLocationInfo <em>Location Info</em>}</li>
 *   <li>{@link astm.GASTMSyntaxObject#getPreProcessorElements <em>Pre Processor Elements</em>}</li>
 *   <li>{@link astm.GASTMSyntaxObject#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see astm.AstmPackage#getGASTMSyntaxObject()
 * @model abstract="true"
 * @generated
 */
public interface GASTMSyntaxObject extends GASTMObject {
	/**
	 * Returns the value of the '<em><b>Location Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location Info</em>' containment reference.
	 * @see #setLocationInfo(SourceLocation)
	 * @see astm.AstmPackage#getGASTMSyntaxObject_LocationInfo()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!GASTMSyntaxObject!locationInfo'"
	 * @generated
	 */
	SourceLocation getLocationInfo();

	/**
	 * Sets the value of the '{@link astm.GASTMSyntaxObject#getLocationInfo <em>Location Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location Info</em>' containment reference.
	 * @see #getLocationInfo()
	 * @generated
	 */
	void setLocationInfo(SourceLocation value);

	/**
	 * Returns the value of the '<em><b>Pre Processor Elements</b></em>' containment reference list.
	 * The list contents are of type {@link astm.PreprocessorElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Processor Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Processor Elements</em>' containment reference list.
	 * @see astm.AstmPackage#getGASTMSyntaxObject_PreProcessorElements()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!GASTMSyntaxObject!preProcessorElements'"
	 * @generated
	 */
	EList<PreprocessorElement> getPreProcessorElements();

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link astm.AnnotationExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see astm.AstmPackage#getGASTMSyntaxObject_Annotations()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/delphi/AS/1.0!GASTMSyntaxObject!annotations'"
	 * @generated
	 */
	EList<AnnotationExpression> getAnnotations();

} // GASTMSyntaxObject
