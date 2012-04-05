/**
 * <copyright>
 * </copyright>
 *
 * $Id: TSubTemplateToTraceClassProps.java,v 1.1 2009/02/23 18:14:57 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TSub Template To Trace Class Props</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getC <em>C</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getTv <em>Tv</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getTp <em>Tp</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getPt <em>Pt</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getT <em>T</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getRc <em>Rc</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTSubTemplateToTraceClassProps()
 * @model
 * @generated
 */
public interface TSubTemplateToTraceClassProps extends EObject {
	/**
	 * Returns the value of the '<em><b>C</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>C</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C</em>' reference.
	 * @see #setC(EClass)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTSubTemplateToTraceClassProps_C()
	 * @model
	 * @generated
	 */
	EClass getC();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getC <em>C</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>C</em>' reference.
	 * @see #getC()
	 * @generated
	 */
	void setC(EClass value);

	/**
	 * Returns the value of the '<em><b>Tv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tv</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tv</em>' reference.
	 * @see #setTv(Variable)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTSubTemplateToTraceClassProps_Tv()
	 * @model
	 * @generated
	 */
	Variable getTv();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getTv <em>Tv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tv</em>' reference.
	 * @see #getTv()
	 * @generated
	 */
	void setTv(Variable value);

	/**
	 * Returns the value of the '<em><b>Tp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tp</em>' reference.
	 * @see #setTp(ObjectTemplateExp)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTSubTemplateToTraceClassProps_Tp()
	 * @model
	 * @generated
	 */
	ObjectTemplateExp getTp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getTp <em>Tp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tp</em>' reference.
	 * @see #getTp()
	 * @generated
	 */
	void setTp(ObjectTemplateExp value);

	/**
	 * Returns the value of the '<em><b>Pt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pt</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pt</em>' reference.
	 * @see #setPt(PropertyTemplateItem)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTSubTemplateToTraceClassProps_Pt()
	 * @model
	 * @generated
	 */
	PropertyTemplateItem getPt();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getPt <em>Pt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pt</em>' reference.
	 * @see #getPt()
	 * @generated
	 */
	void setPt(PropertyTemplateItem value);

	/**
	 * Returns the value of the '<em><b>T</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T</em>' reference.
	 * @see #setT(ObjectTemplateExp)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTSubTemplateToTraceClassProps_T()
	 * @model
	 * @generated
	 */
	ObjectTemplateExp getT();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getT <em>T</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T</em>' reference.
	 * @see #getT()
	 * @generated
	 */
	void setT(ObjectTemplateExp value);

	/**
	 * Returns the value of the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>A</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>A</em>' reference.
	 * @see #setA(EReference)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTSubTemplateToTraceClassProps_A()
	 * @model
	 * @generated
	 */
	EReference getA();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getA <em>A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>A</em>' reference.
	 * @see #getA()
	 * @generated
	 */
	void setA(EReference value);

	/**
	 * Returns the value of the '<em><b>Rc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rc</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rc</em>' reference.
	 * @see #setRc(EClass)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTSubTemplateToTraceClassProps_Rc()
	 * @model
	 * @generated
	 */
	EClass getRc();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getRc <em>Rc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rc</em>' reference.
	 * @see #getRc()
	 * @generated
	 */
	void setRc(EClass value);

} // TSubTemplateToTraceClassProps
