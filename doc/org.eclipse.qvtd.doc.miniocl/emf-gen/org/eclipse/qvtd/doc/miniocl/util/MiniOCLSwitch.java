/**
 */
package org.eclipse.qvtd.doc.miniocl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.doc.miniocl.CallExp;
import org.eclipse.qvtd.doc.miniocl.Constraint;
import org.eclipse.qvtd.doc.miniocl.Element;
import org.eclipse.qvtd.doc.miniocl.ExpressionInOCL;
import org.eclipse.qvtd.doc.miniocl.Feature;
import org.eclipse.qvtd.doc.miniocl.MiniOCLPackage;
import org.eclipse.qvtd.doc.miniocl.NamedElement;
import org.eclipse.qvtd.doc.miniocl.Namespace;
import org.eclipse.qvtd.doc.miniocl.OCLExpression;
import org.eclipse.qvtd.doc.miniocl.Operation;
import org.eclipse.qvtd.doc.miniocl.OperationCallExp;
import org.eclipse.qvtd.doc.miniocl.Parameter;
import org.eclipse.qvtd.doc.miniocl.Property;
import org.eclipse.qvtd.doc.miniocl.PropertyCallExp;
import org.eclipse.qvtd.doc.miniocl.Root;
import org.eclipse.qvtd.doc.miniocl.TypedElement;
import org.eclipse.qvtd.doc.miniocl.Variable;
import org.eclipse.qvtd.doc.miniocl.VariableExp;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLPackage
 * @generated
 */
public class MiniOCLSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MiniOCLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiniOCLSwitch() {
		if (modelPackage == null) {
			modelPackage = MiniOCLPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MiniOCLPackage.CALL_EXP: {
				CallExp callExp = (CallExp)theEObject;
				T result = caseCallExp(callExp);
				if (result == null) result = caseOCLExpression(callExp);
				if (result == null) result = caseTypedElement(callExp);
				if (result == null) result = caseElement(callExp);
				if (result == null) result = caseVisitable(callExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.CLASS: {
				org.eclipse.qvtd.doc.miniocl.Class class_ = (org.eclipse.qvtd.doc.miniocl.Class)theEObject;
				T result = caseClass(class_);
				if (result == null) result = caseNamedElement(class_);
				if (result == null) result = caseElement(class_);
				if (result == null) result = caseVisitable(class_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.ELEMENT: {
				Element element = (Element)theEObject;
				T result = caseElement(element);
				if (result == null) result = caseVisitable(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.FEATURE: {
				Feature feature = (Feature)theEObject;
				T result = caseFeature(feature);
				if (result == null) result = caseNamedElement(feature);
				if (result == null) result = caseTypedElement(feature);
				if (result == null) result = caseElement(feature);
				if (result == null) result = caseVisitable(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseElement(namedElement);
				if (result == null) result = caseVisitable(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.NAMESPACE: {
				Namespace namespace = (Namespace)theEObject;
				T result = caseNamespace(namespace);
				if (result == null) result = caseElement(namespace);
				if (result == null) result = caseVisitable(namespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.OCL_EXPRESSION: {
				OCLExpression oclExpression = (OCLExpression)theEObject;
				T result = caseOCLExpression(oclExpression);
				if (result == null) result = caseTypedElement(oclExpression);
				if (result == null) result = caseElement(oclExpression);
				if (result == null) result = caseVisitable(oclExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.OPERATION_CALL_EXP: {
				OperationCallExp operationCallExp = (OperationCallExp)theEObject;
				T result = caseOperationCallExp(operationCallExp);
				if (result == null) result = caseCallExp(operationCallExp);
				if (result == null) result = caseOCLExpression(operationCallExp);
				if (result == null) result = caseTypedElement(operationCallExp);
				if (result == null) result = caseElement(operationCallExp);
				if (result == null) result = caseVisitable(operationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseFeature(operation);
				if (result == null) result = caseNamedElement(operation);
				if (result == null) result = caseTypedElement(operation);
				if (result == null) result = caseElement(operation);
				if (result == null) result = caseVisitable(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.PACKAGE: {
				org.eclipse.qvtd.doc.miniocl.Package package_ = (org.eclipse.qvtd.doc.miniocl.Package)theEObject;
				T result = casePackage(package_);
				if (result == null) result = caseNamedElement(package_);
				if (result == null) result = caseNamespace(package_);
				if (result == null) result = caseElement(package_);
				if (result == null) result = caseVisitable(package_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseVariable(parameter);
				if (result == null) result = caseNamedElement(parameter);
				if (result == null) result = caseTypedElement(parameter);
				if (result == null) result = caseElement(parameter);
				if (result == null) result = caseVisitable(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseFeature(property);
				if (result == null) result = caseNamedElement(property);
				if (result == null) result = caseTypedElement(property);
				if (result == null) result = caseElement(property);
				if (result == null) result = caseVisitable(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.PROPERTY_CALL_EXP: {
				PropertyCallExp propertyCallExp = (PropertyCallExp)theEObject;
				T result = casePropertyCallExp(propertyCallExp);
				if (result == null) result = caseCallExp(propertyCallExp);
				if (result == null) result = caseOCLExpression(propertyCallExp);
				if (result == null) result = caseTypedElement(propertyCallExp);
				if (result == null) result = caseElement(propertyCallExp);
				if (result == null) result = caseVisitable(propertyCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.ROOT: {
				Root root = (Root)theEObject;
				T result = caseRoot(root);
				if (result == null) result = caseElement(root);
				if (result == null) result = caseVisitable(root);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = caseTypedElement(variable);
				if (result == null) result = caseElement(variable);
				if (result == null) result = caseVisitable(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.VARIABLE_EXP: {
				VariableExp variableExp = (VariableExp)theEObject;
				T result = caseVariableExp(variableExp);
				if (result == null) result = caseOCLExpression(variableExp);
				if (result == null) result = caseTypedElement(variableExp);
				if (result == null) result = caseElement(variableExp);
				if (result == null) result = caseVisitable(variableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.VISITABLE: {
				Visitable visitable = (Visitable)theEObject;
				T result = caseVisitable(visitable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.TYPED_ELEMENT: {
				TypedElement typedElement = (TypedElement)theEObject;
				T result = caseTypedElement(typedElement);
				if (result == null) result = caseElement(typedElement);
				if (result == null) result = caseVisitable(typedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.EXPRESSION_IN_OCL: {
				ExpressionInOCL expressionInOCL = (ExpressionInOCL)theEObject;
				T result = caseExpressionInOCL(expressionInOCL);
				if (result == null) result = caseElement(expressionInOCL);
				if (result == null) result = caseVisitable(expressionInOCL);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MiniOCLPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseNamedElement(constraint);
				if (result == null) result = caseElement(constraint);
				if (result == null) result = caseVisitable(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeature(Feature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression In OCL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionInOCL(ExpressionInOCL object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLExpression(OCLExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExp(CallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoot(Root object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackage(org.eclipse.qvtd.doc.miniocl.Package object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass(org.eclipse.qvtd.doc.miniocl.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyCallExp(PropertyCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableExp(VariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MiniOCLSwitch
