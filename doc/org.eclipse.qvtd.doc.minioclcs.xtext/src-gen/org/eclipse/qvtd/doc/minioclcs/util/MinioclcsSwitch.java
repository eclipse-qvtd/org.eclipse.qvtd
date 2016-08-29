/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc.minioclcs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.doc.minioclcs.*;

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
 * @see org.eclipse.qvtd.doc.minioclcs.MinioclcsPackage
 * @generated
 */
public class MinioclcsSwitch<@Nullable T> extends Switch<T>
{
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static MinioclcsPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MinioclcsSwitch()
  {
		if (modelPackage == null) {
			modelPackage = MinioclcsPackage.eINSTANCE;
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
  protected boolean isSwitchFor(EPackage ePackage)
  {
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
  protected T doSwitch(int classifierID, EObject theEObject)
  {
		switch (classifierID) {
			case MinioclcsPackage.ROOT_CS: {
				RootCS rootCS = (RootCS)theEObject;
				T result = caseRootCS(rootCS);
				if (result == null) result = caseCSTrace(rootCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.IMPORT_CS: {
				ImportCS importCS = (ImportCS)theEObject;
				T result = caseImportCS(importCS);
				if (result == null) result = caseCSTrace(importCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.PACKAGE_CS: {
				PackageCS packageCS = (PackageCS)theEObject;
				T result = casePackageCS(packageCS);
				if (result == null) result = caseCSTrace(packageCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.CLASS_CS: {
				ClassCS classCS = (ClassCS)theEObject;
				T result = caseClassCS(classCS);
				if (result == null) result = caseCSTrace(classCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.PROPERTY_CS: {
				PropertyCS propertyCS = (PropertyCS)theEObject;
				T result = casePropertyCS(propertyCS);
				if (result == null) result = caseCSTrace(propertyCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.MULTIPLICITY_CS: {
				MultiplicityCS multiplicityCS = (MultiplicityCS)theEObject;
				T result = caseMultiplicityCS(multiplicityCS);
				if (result == null) result = caseCSTrace(multiplicityCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.OPERATION_CS: {
				OperationCS operationCS = (OperationCS)theEObject;
				T result = caseOperationCS(operationCS);
				if (result == null) result = caseCSTrace(operationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.PARAMETER_CS: {
				ParameterCS parameterCS = (ParameterCS)theEObject;
				T result = caseParameterCS(parameterCS);
				if (result == null) result = caseCSTrace(parameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.CONSTRAINTS_DEF_CS: {
				ConstraintsDefCS constraintsDefCS = (ConstraintsDefCS)theEObject;
				T result = caseConstraintsDefCS(constraintsDefCS);
				if (result == null) result = caseCSTrace(constraintsDefCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.INVARIANT_CS: {
				InvariantCS invariantCS = (InvariantCS)theEObject;
				T result = caseInvariantCS(invariantCS);
				if (result == null) result = caseCSTrace(invariantCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.EXP_CS: {
				ExpCS expCS = (ExpCS)theEObject;
				T result = caseExpCS(expCS);
				if (result == null) result = caseCSTrace(expCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.EQUALITY_EXP_CS: {
				EqualityExpCS equalityExpCS = (EqualityExpCS)theEObject;
				T result = caseEqualityExpCS(equalityExpCS);
				if (result == null) result = caseExpCS(equalityExpCS);
				if (result == null) result = caseCSTrace(equalityExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.CALL_EXP_CS: {
				CallExpCS callExpCS = (CallExpCS)theEObject;
				T result = caseCallExpCS(callExpCS);
				if (result == null) result = caseEqualityExpCS(callExpCS);
				if (result == null) result = caseExpCS(callExpCS);
				if (result == null) result = caseCSTrace(callExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.PRIMARY_EXP_CS: {
				PrimaryExpCS primaryExpCS = (PrimaryExpCS)theEObject;
				T result = casePrimaryExpCS(primaryExpCS);
				if (result == null) result = caseCallExpCS(primaryExpCS);
				if (result == null) result = caseEqualityExpCS(primaryExpCS);
				if (result == null) result = caseExpCS(primaryExpCS);
				if (result == null) result = caseCSTrace(primaryExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.SELF_EXP_CS: {
				SelfExpCS selfExpCS = (SelfExpCS)theEObject;
				T result = caseSelfExpCS(selfExpCS);
				if (result == null) result = casePrimaryExpCS(selfExpCS);
				if (result == null) result = caseCallExpCS(selfExpCS);
				if (result == null) result = caseEqualityExpCS(selfExpCS);
				if (result == null) result = caseExpCS(selfExpCS);
				if (result == null) result = caseCSTrace(selfExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.NAVIGATION_EXP_CS: {
				NavigationExpCS navigationExpCS = (NavigationExpCS)theEObject;
				T result = caseNavigationExpCS(navigationExpCS);
				if (result == null) result = caseCSTrace(navigationExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.LOOP_EXP_CS: {
				LoopExpCS loopExpCS = (LoopExpCS)theEObject;
				T result = caseLoopExpCS(loopExpCS);
				if (result == null) result = caseNavigationExpCS(loopExpCS);
				if (result == null) result = caseCSTrace(loopExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.COLLECT_EXP_CS: {
				CollectExpCS collectExpCS = (CollectExpCS)theEObject;
				T result = caseCollectExpCS(collectExpCS);
				if (result == null) result = caseLoopExpCS(collectExpCS);
				if (result == null) result = caseNavigationExpCS(collectExpCS);
				if (result == null) result = caseCSTrace(collectExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.ITERATOR_VAR_CS: {
				IteratorVarCS iteratorVarCS = (IteratorVarCS)theEObject;
				T result = caseIteratorVarCS(iteratorVarCS);
				if (result == null) result = caseCSTrace(iteratorVarCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.ITERATE_EXP_CS: {
				IterateExpCS iterateExpCS = (IterateExpCS)theEObject;
				T result = caseIterateExpCS(iterateExpCS);
				if (result == null) result = caseLoopExpCS(iterateExpCS);
				if (result == null) result = caseNavigationExpCS(iterateExpCS);
				if (result == null) result = caseCSTrace(iterateExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.ACC_VAR_CS: {
				AccVarCS accVarCS = (AccVarCS)theEObject;
				T result = caseAccVarCS(accVarCS);
				if (result == null) result = caseCSTrace(accVarCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.NAME_EXP_CS: {
				NameExpCS nameExpCS = (NameExpCS)theEObject;
				T result = caseNameExpCS(nameExpCS);
				if (result == null) result = casePrimaryExpCS(nameExpCS);
				if (result == null) result = caseNavigationExpCS(nameExpCS);
				if (result == null) result = caseCallExpCS(nameExpCS);
				if (result == null) result = caseEqualityExpCS(nameExpCS);
				if (result == null) result = caseExpCS(nameExpCS);
				if (result == null) result = caseCSTrace(nameExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.ROUNDED_BRACKET_CLAUSE_CS: {
				RoundedBracketClauseCS roundedBracketClauseCS = (RoundedBracketClauseCS)theEObject;
				T result = caseRoundedBracketClauseCS(roundedBracketClauseCS);
				if (result == null) result = caseCSTrace(roundedBracketClauseCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.LITERAL_EXP_CS: {
				LiteralExpCS literalExpCS = (LiteralExpCS)theEObject;
				T result = caseLiteralExpCS(literalExpCS);
				if (result == null) result = casePrimaryExpCS(literalExpCS);
				if (result == null) result = caseCallExpCS(literalExpCS);
				if (result == null) result = caseEqualityExpCS(literalExpCS);
				if (result == null) result = caseExpCS(literalExpCS);
				if (result == null) result = caseCSTrace(literalExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.INT_LITERAL_EXP_CS: {
				IntLiteralExpCS intLiteralExpCS = (IntLiteralExpCS)theEObject;
				T result = caseIntLiteralExpCS(intLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(intLiteralExpCS);
				if (result == null) result = casePrimaryExpCS(intLiteralExpCS);
				if (result == null) result = caseCallExpCS(intLiteralExpCS);
				if (result == null) result = caseEqualityExpCS(intLiteralExpCS);
				if (result == null) result = caseExpCS(intLiteralExpCS);
				if (result == null) result = caseCSTrace(intLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.BOOLEAN_LITERAL_EXP_CS: {
				BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)theEObject;
				T result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(booleanLiteralExpCS);
				if (result == null) result = casePrimaryExpCS(booleanLiteralExpCS);
				if (result == null) result = caseCallExpCS(booleanLiteralExpCS);
				if (result == null) result = caseEqualityExpCS(booleanLiteralExpCS);
				if (result == null) result = caseExpCS(booleanLiteralExpCS);
				if (result == null) result = caseCSTrace(booleanLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.NULL_LITERAL_EXP_CS: {
				NullLiteralExpCS nullLiteralExpCS = (NullLiteralExpCS)theEObject;
				T result = caseNullLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(nullLiteralExpCS);
				if (result == null) result = casePrimaryExpCS(nullLiteralExpCS);
				if (result == null) result = caseCallExpCS(nullLiteralExpCS);
				if (result == null) result = caseEqualityExpCS(nullLiteralExpCS);
				if (result == null) result = caseExpCS(nullLiteralExpCS);
				if (result == null) result = caseCSTrace(nullLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.COLLECTION_LITERAL_EXP_CS: {
				CollectionLiteralExpCS collectionLiteralExpCS = (CollectionLiteralExpCS)theEObject;
				T result = caseCollectionLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = caseLiteralExpCS(collectionLiteralExpCS);
				if (result == null) result = casePrimaryExpCS(collectionLiteralExpCS);
				if (result == null) result = caseCallExpCS(collectionLiteralExpCS);
				if (result == null) result = caseEqualityExpCS(collectionLiteralExpCS);
				if (result == null) result = caseExpCS(collectionLiteralExpCS);
				if (result == null) result = caseCSTrace(collectionLiteralExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.COLLECTION_LITERAL_PART_CS: {
				CollectionLiteralPartCS collectionLiteralPartCS = (CollectionLiteralPartCS)theEObject;
				T result = caseCollectionLiteralPartCS(collectionLiteralPartCS);
				if (result == null) result = caseCSTrace(collectionLiteralPartCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.LET_EXP_CS: {
				LetExpCS letExpCS = (LetExpCS)theEObject;
				T result = caseLetExpCS(letExpCS);
				if (result == null) result = casePrimaryExpCS(letExpCS);
				if (result == null) result = caseCallExpCS(letExpCS);
				if (result == null) result = caseEqualityExpCS(letExpCS);
				if (result == null) result = caseExpCS(letExpCS);
				if (result == null) result = caseCSTrace(letExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.LET_VAR_CS: {
				LetVarCS letVarCS = (LetVarCS)theEObject;
				T result = caseLetVarCS(letVarCS);
				if (result == null) result = caseCSTrace(letVarCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.PATH_NAME_CS: {
				PathNameCS pathNameCS = (PathNameCS)theEObject;
				T result = casePathNameCS(pathNameCS);
				if (result == null) result = caseCSTrace(pathNameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.PATH_ELEMENT_CS: {
				PathElementCS pathElementCS = (PathElementCS)theEObject;
				T result = casePathElementCS(pathElementCS);
				if (result == null) result = caseCSTrace(pathElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.BOOLEAN_EXP_CS: {
				BooleanExpCS booleanExpCS = (BooleanExpCS)theEObject;
				T result = caseBooleanExpCS(booleanExpCS);
				if (result == null) result = caseBooleanLiteralExpCS(booleanExpCS);
				if (result == null) result = caseLiteralExpCS(booleanExpCS);
				if (result == null) result = casePrimaryExpCS(booleanExpCS);
				if (result == null) result = caseCallExpCS(booleanExpCS);
				if (result == null) result = caseEqualityExpCS(booleanExpCS);
				if (result == null) result = caseExpCS(booleanExpCS);
				if (result == null) result = caseCSTrace(booleanExpCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MinioclcsPackage.CS_TRACE: {
				CSTrace csTrace = (CSTrace)theEObject;
				T result = caseCSTrace(csTrace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRootCS(RootCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Import CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseImportCS(ImportCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePackageCS(PackageCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseClassCS(ClassCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Property CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePropertyCS(PropertyCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicity CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicity CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMultiplicityCS(MultiplicityCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Operation CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseOperationCS(OperationCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseParameterCS(ParameterCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Constraints Def CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraints Def CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseConstraintsDefCS(ConstraintsDefCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Invariant CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invariant CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInvariantCS(InvariantCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseExpCS(ExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Equality Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equality Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseEqualityExpCS(EqualityExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCallExpCS(CallExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Primary Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primary Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePrimaryExpCS(PrimaryExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSelfExpCS(SelfExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseNavigationExpCS(NavigationExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLoopExpCS(LoopExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Collect Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collect Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCollectExpCS(CollectExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Var CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Var CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIteratorVarCS(IteratorVarCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIterateExpCS(IterateExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Acc Var CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Acc Var CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAccVarCS(AccVarCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseNameExpCS(NameExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Rounded Bracket Clause CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rounded Bracket Clause CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRoundedBracketClauseCS(RoundedBracketClauseCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLiteralExpCS(LiteralExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Int Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIntLiteralExpCS(IntLiteralExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBooleanLiteralExpCS(BooleanLiteralExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseNullLiteralExpCS(NullLiteralExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCollectionLiteralExpCS(CollectionLiteralExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCollectionLiteralPartCS(CollectionLiteralPartCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLetExpCS(LetExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Let Var CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Var CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLetVarCS(LetVarCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePathNameCS(PathNameCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Path Element CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePathElementCS(PathElementCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Exp CS</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBooleanExpCS(BooleanExpCS object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>CS Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CS Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCSTrace(CSTrace object) {
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
  public T defaultCase(EObject object)
  {
		return null;
	}

} //MinioclcsSwitch
