/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;

/**
 * @generated
 */
public interface ClassDatumAnalysis extends Element
{
	/**
	 * Returns the value of the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null if this edge is part of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Datum</em>' reference.
	 * @see #setClassDatum(ClassDatum)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatumAnalysis_ClassDatum()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatumAnalysis!classDatum'"
	 * @generated
	 */
	ClassDatum getClassDatum();
	/**
	 * Returns the value of the '<em><b>Produced By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Produced By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Produced By</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatumAnalysis_ProducedBy()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatumAnalysis!producedBy'"
	 * @generated
	 */
	EList<Mapping> getProducedBy();
	/**
	 * Returns the value of the '<em><b>Required By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtcore.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required By</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatumAnalysis_RequiredBy()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatumAnalysis!requiredBy'"
	 * @generated
	 */
	EList<Mapping> getRequiredBy();
	/**
	 * Returns the value of the '<em><b>Schedule Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null if this edge is part of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Schedule Model</em>' reference.
	 * @see #setScheduleModel(ScheduleModel)
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatumAnalysis_ScheduleModel()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatumAnalysis!scheduleModel'"
	 * @generated
	 */
	ScheduleModel getScheduleModel();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis#getScheduleModel <em>Schedule Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schedule Model</em>' reference.
	 * @see #getScheduleModel()
	 * @generated
	 */
	void setScheduleModel(ScheduleModel value);
	/**
	 * Returns the value of the '<em><b>Super Class Datum Analyses</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class Datum Analyses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class Datum Analyses</em>' reference list.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatumAnalysis_SuperClassDatumAnalyses()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatumAnalysis!superClassDatumAnalyses'"
	 * @generated
	 */
	EList<ClassDatumAnalysis> getSuperClassDatumAnalyses();
	/**
	 * Returns the value of the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null if this edge is part of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Typed Model</em>' reference.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatumAnalysis_TypedModel()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatumAnalysis!typedModel'"
	 * @generated
	 */
	TypedModel getTypedModel();
	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis#getClassDatum <em>Class Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Datum</em>' reference.
	 * @see #getClassDatum()
	 * @generated
	 */
	void setClassDatum(ClassDatum value);

	/**
	 * Returns the value of the '<em><b>Complete Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete Class</em>' reference.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatumAnalysis_CompleteClass()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatumAnalysis!completeClass'"
	 * @generated
	 */
	CompleteClass getCompleteClass();
	/**
	 * Returns the value of the '<em><b>Domain Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null if this edge is part of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Usage</em>' reference.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatumAnalysis_DomainUsage()
	 * @model type="org.eclipse.qvtd.pivot.qvtschedule.DomainUsage" resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatumAnalysis!domainUsage'"
	 * @generated
	 */
	DomainUsage getDomainUsage();
	/**
	 * Returns the value of the '<em><b>Elemental Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Non-null if this edge is part of a bidirectional pair.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Elemental Class Datum</em>' reference.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getClassDatumAnalysis_ElementalClassDatum()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://www.eclipse.org/qvt/2017/QVTschedule!ClassDatumAnalysis!elementalClassDatum'"
	 * @generated
	 */
	ClassDatum getElementalClassDatum();

	void addConsumption(@NonNull MappingRegion consumer, @NonNull Node consumingNode);
	void addIntroduction(@NonNull Region introducer, @NonNull Node introducingNode);
	void addProduction(@NonNull MappingRegion producer, @NonNull Node producingNode);
	List<MappingRegion> getConsumingRegions();
}