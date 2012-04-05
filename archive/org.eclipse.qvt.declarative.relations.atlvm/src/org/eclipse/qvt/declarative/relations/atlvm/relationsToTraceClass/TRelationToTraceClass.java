/**
 * <copyright>
 * </copyright>
 *
 * $Id: TRelationToTraceClass.java,v 1.2 2009/02/24 17:31:28 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;

import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRelation To Trace Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getA <em>A</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRc <em>Rc</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getC <em>C</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getP <em>P</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getTv <em>Tv</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getT <em>T</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRdp <em>Rdp</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRd <em>Rd</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getR <em>R</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRt <em>Rt</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass()
 * @model
 * @generated
 */
public interface TRelationToTraceClass extends EObject {
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
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_A()
	 * @model
	 * @generated
	 */
	EReference getA();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getA <em>A</em>}' reference.
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
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_Rc()
	 * @model
	 * @generated
	 */
	EClass getRc();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRc <em>Rc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rc</em>' reference.
	 * @see #getRc()
	 * @generated
	 */
	void setRc(EClass value);

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
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_C()
	 * @model
	 * @generated
	 */
	EClass getC();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getC <em>C</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>C</em>' reference.
	 * @see #getC()
	 * @generated
	 */
	void setC(EClass value);

	/**
	 * Returns the value of the '<em><b>P</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>P</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>P</em>' reference.
	 * @see #setP(EPackage)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_P()
	 * @model
	 * @generated
	 */
	EPackage getP();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getP <em>P</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>P</em>' reference.
	 * @see #getP()
	 * @generated
	 */
	void setP(EPackage value);

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
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_Tv()
	 * @model
	 * @generated
	 */
	Variable getTv();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getTv <em>Tv</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tv</em>' reference.
	 * @see #getTv()
	 * @generated
	 */
	void setTv(Variable value);

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
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_T()
	 * @model
	 * @generated
	 */
	ObjectTemplateExp getT();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getT <em>T</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T</em>' reference.
	 * @see #getT()
	 * @generated
	 */
	void setT(ObjectTemplateExp value);

	/**
	 * Returns the value of the '<em><b>Rdp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rdp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rdp</em>' reference.
	 * @see #setRdp(DomainPattern)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_Rdp()
	 * @model
	 * @generated
	 */
	DomainPattern getRdp();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRdp <em>Rdp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rdp</em>' reference.
	 * @see #getRdp()
	 * @generated
	 */
	void setRdp(DomainPattern value);

	/**
	 * Returns the value of the '<em><b>Rd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rd</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rd</em>' reference.
	 * @see #setRd(RelationDomain)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_Rd()
	 * @model
	 * @generated
	 */
	RelationDomain getRd();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRd <em>Rd</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rd</em>' reference.
	 * @see #getRd()
	 * @generated
	 */
	void setRd(RelationDomain value);

	/**
	 * Returns the value of the '<em><b>R</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>R</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>R</em>' reference.
	 * @see #setR(Relation)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_R()
	 * @model
	 * @generated
	 */
	Relation getR();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getR <em>R</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R</em>' reference.
	 * @see #getR()
	 * @generated
	 */
	void setR(Relation value);

	/**
	 * Returns the value of the '<em><b>Rt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rt</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rt</em>' reference.
	 * @see #setRt(RelationalTransformation)
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#getTRelationToTraceClass_Rt()
	 * @model
	 * @generated
	 */
	RelationalTransformation getRt();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRt <em>Rt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rt</em>' reference.
	 * @see #getRt()
	 * @generated
	 */
	void setRt(RelationalTransformation value);

} // TRelationToTraceClass
