/**
 * generated by Xtext 2.10.0
 */
package org.eclipse.qvtd.doc.minioclcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvtd.doc.minioclcs.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MinioclcsFactoryImpl extends EFactoryImpl implements MinioclcsFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static MinioclcsFactory init()
  {
		try {
			MinioclcsFactory theMinioclcsFactory = (MinioclcsFactory)EPackage.Registry.INSTANCE.getEFactory(MinioclcsPackage.eNS_URI);
			if (theMinioclcsFactory != null) {
				return theMinioclcsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MinioclcsFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MinioclcsFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
		switch (eClass.getClassifierID()) {
			case MinioclcsPackage.ROOT_CS: return createRootCS();
			case MinioclcsPackage.PACKAGE_CS: return createPackageCS();
			case MinioclcsPackage.CLASS_CS: return createClassCS();
			case MinioclcsPackage.PROPERTY_CS: return createPropertyCS();
			case MinioclcsPackage.OPERATION_CS: return createOperationCS();
			case MinioclcsPackage.PARAMETER_CS: return createParameterCS();
			case MinioclcsPackage.CONSTRAINTS_DEF_CS: return createConstraintsDefCS();
			case MinioclcsPackage.INVARIANT_CS: return createInvariantCS();
			case MinioclcsPackage.EXP_CS: return createExpCS();
			case MinioclcsPackage.LOGIC_EXP_CS: return createLogicExpCS();
			case MinioclcsPackage.CALL_EXP_CS: return createCallExpCS();
			case MinioclcsPackage.PRIMARY_EXP_CS: return createPrimaryExpCS();
			case MinioclcsPackage.NAME_EXP_CS: return createNameExpCS();
			case MinioclcsPackage.ROUNDED_BRACKET_CLAUSE_CS: return createRoundedBracketClauseCS();
			case MinioclcsPackage.LITERAL_EXP_CS: return createLiteralExpCS();
			case MinioclcsPackage.INT_LITERAL_EXP_CS: return createIntLiteralExpCS();
			case MinioclcsPackage.STRING_LITERAL_EXP_CS: return createStringLiteralExpCS();
			case MinioclcsPackage.BOOLEAN_LITERAL_EXP_CS: return createBooleanLiteralExpCS();
			case MinioclcsPackage.PATH_NAME_CS: return createPathNameCS();
			case MinioclcsPackage.PATH_ELEMENT_CS: return createPathElementCS();
			case MinioclcsPackage.BOOLEAN_EXP_CS: return createBooleanExpCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RootCS createRootCS()
  {
		RootCSImpl rootCS = new RootCSImpl();
		return rootCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PackageCS createPackageCS()
  {
		PackageCSImpl packageCS = new PackageCSImpl();
		return packageCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ClassCS createClassCS()
  {
		ClassCSImpl classCS = new ClassCSImpl();
		return classCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PropertyCS createPropertyCS()
  {
		PropertyCSImpl propertyCS = new PropertyCSImpl();
		return propertyCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public OperationCS createOperationCS()
  {
		OperationCSImpl operationCS = new OperationCSImpl();
		return operationCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ParameterCS createParameterCS()
  {
		ParameterCSImpl parameterCS = new ParameterCSImpl();
		return parameterCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConstraintsDefCS createConstraintsDefCS()
  {
		ConstraintsDefCSImpl constraintsDefCS = new ConstraintsDefCSImpl();
		return constraintsDefCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InvariantCS createInvariantCS()
  {
		InvariantCSImpl invariantCS = new InvariantCSImpl();
		return invariantCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ExpCS createExpCS()
  {
		ExpCSImpl expCS = new ExpCSImpl();
		return expCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LogicExpCS createLogicExpCS()
  {
		LogicExpCSImpl logicExpCS = new LogicExpCSImpl();
		return logicExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CallExpCS createCallExpCS()
  {
		CallExpCSImpl callExpCS = new CallExpCSImpl();
		return callExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PrimaryExpCS createPrimaryExpCS()
  {
		PrimaryExpCSImpl primaryExpCS = new PrimaryExpCSImpl();
		return primaryExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NameExpCS createNameExpCS()
  {
		NameExpCSImpl nameExpCS = new NameExpCSImpl();
		return nameExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RoundedBracketClauseCS createRoundedBracketClauseCS()
  {
		RoundedBracketClauseCSImpl roundedBracketClauseCS = new RoundedBracketClauseCSImpl();
		return roundedBracketClauseCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LiteralExpCS createLiteralExpCS()
  {
		LiteralExpCSImpl literalExpCS = new LiteralExpCSImpl();
		return literalExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IntLiteralExpCS createIntLiteralExpCS()
  {
		IntLiteralExpCSImpl intLiteralExpCS = new IntLiteralExpCSImpl();
		return intLiteralExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StringLiteralExpCS createStringLiteralExpCS()
  {
		StringLiteralExpCSImpl stringLiteralExpCS = new StringLiteralExpCSImpl();
		return stringLiteralExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BooleanLiteralExpCS createBooleanLiteralExpCS()
  {
		BooleanLiteralExpCSImpl booleanLiteralExpCS = new BooleanLiteralExpCSImpl();
		return booleanLiteralExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PathNameCS createPathNameCS()
  {
		PathNameCSImpl pathNameCS = new PathNameCSImpl();
		return pathNameCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PathElementCS createPathElementCS()
  {
		PathElementCSImpl pathElementCS = new PathElementCSImpl();
		return pathElementCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BooleanExpCS createBooleanExpCS()
  {
		BooleanExpCSImpl booleanExpCS = new BooleanExpCSImpl();
		return booleanExpCS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MinioclcsPackage getMinioclcsPackage()
  {
		return (MinioclcsPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static MinioclcsPackage getPackage()
  {
		return MinioclcsPackage.eINSTANCE;
	}

} //MinioclcsFactoryImpl
