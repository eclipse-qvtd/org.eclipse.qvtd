/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtcore;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.pivot.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opposite Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getTargetProperty <em>Target Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getOppositePropertyAssignment()
 * @model
 * @generated
 */
public interface OppositePropertyAssignment extends NavigationAssignment {
	/**
	 * Returns the value of the '<em><b>Target Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Property</em>' reference.
	 * @see #setTargetProperty(Property)
	 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage#getOppositePropertyAssignment_TargetProperty()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='assignment'"
	 * @generated
	 */
	Property getTargetProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getTargetProperty <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Property</em>' reference.
	 * @see #getTargetProperty()
	 * @generated
	 */
	void setTargetProperty(Property value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='targetProperty.opposite\n\n'"
	 * @generated
	 */
	Property getReferredTargetProperty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForPartialValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tisPartial implies\n\t\tlet propertyType = getReferredTargetProperty().type.oclAsType(ocl::CollectionType).elementType in\n\t\tlet valueType = value.type in\n\t\tTuple{\n\t\t\tstatus : Boolean = valueType?.conformsTo(propertyType) or propertyType.conformsTo(valueType),\n\t\t\tmessage : String = \'OppositePropertyAssignment::CompatibleTypeForPartialValue: \' + valueType?.name + \' must conform to \' + propertyType.name + \' or vice-versa\'\n\t\t}.status\n\n'"
	 * @generated
	 */
	boolean validateCompatibleTypeForPartialValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CompatibleTypeForTotalValue'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tnot isPartial implies\n\t\tlet propertyType = getReferredTargetProperty().type in\n\t\tlet valueType = value.type in\n\t\tTuple{\n\t\t\tstatus : Boolean = valueType?.conformsTo(propertyType) or propertyType?.conformsTo(valueType),\n\t\t\tmessage : String = \'OppositePropertyAssignment::CompatibleTypeForTotalValue: \' + valueType?.name + \' must conform to \' + propertyType?.name + \' or vice-versa\'\n\t\t}.status\n\n'"
	 * @generated
	 */
	boolean validateCompatibleTypeForTotalValue(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OppositePropertyIsImplicit'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tgetReferredTargetProperty().isImplicit\n\n'"
	 * @generated
	 */
	boolean validateOppositePropertyIsImplicit(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='TargetPropetyIsSlotProperty'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\tslotExpression.type?.conformsTo(getReferredTargetProperty().owningClass)\n\n'"
	 * @generated
	 */
	boolean validateTargetPropetyIsSlotProperty(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OppositePropertyAssignment
