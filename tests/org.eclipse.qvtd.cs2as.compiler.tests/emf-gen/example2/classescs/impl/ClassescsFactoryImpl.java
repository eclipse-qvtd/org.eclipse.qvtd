/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example2.classescs.impl;

import example2.classescs.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import example2.classescs.ClassCS;
import example2.classescs.ClassescsFactory;
import example2.classescs.ClassescsPackage;
import example2.classescs.PackageCS;
import example2.classescs.PathElementCS;
import example2.classescs.PathNameCS;
import example2.classescs.RootCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassescsFactoryImpl extends EFactoryImpl implements ClassescsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassescsFactory init() {
		try {
			ClassescsFactory theClassescsFactory = (ClassescsFactory)EPackage.Registry.INSTANCE.getEFactory(ClassescsPackage.eNS_URI);
			if (theClassescsFactory != null) {
				return theClassescsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassescsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassescsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case 2: return createPackageCS();
			case 3: return createClassCS();
			case 4: return createPathNameCS();
			case 5: return createPathElementCS();
			case 6: return createRootCS();
			case 7: return createPropertyCS();
			case 8: return createOperationCS();
			case 9: return createNameExpCS();
			case 10: return createRoundedBracketClause();
			case 11: return createArgumentCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PackageCS createPackageCS() {
		PackageCSImpl packageCS = new PackageCSImpl();
		return packageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassCS createClassCS() {
		ClassCSImpl classCS = new ClassCSImpl();
		return classCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS createPathNameCS() {
		PathNameCSImpl pathNameCS = new PathNameCSImpl();
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathElementCS createPathElementCS() {
		PathElementCSImpl pathElementCS = new PathElementCSImpl();
		return pathElementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RootCS createRootCS() {
		RootCSImpl rootCS = new RootCSImpl();
		return rootCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyCS createPropertyCS() {
		PropertyCSImpl propertyCS = new PropertyCSImpl();
		return propertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationCS createOperationCS() {
		OperationCSImpl operationCS = new OperationCSImpl();
		return operationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NameExpCS createNameExpCS() {
		NameExpCSImpl nameExpCS = new NameExpCSImpl();
		return nameExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RoundedBracketClause createRoundedBracketClause() {
		RoundedBracketClauseImpl roundedBracketClause = new RoundedBracketClauseImpl();
		return roundedBracketClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArgumentCS createArgumentCS() {
		ArgumentCSImpl argumentCS = new ArgumentCSImpl();
		return argumentCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassescsPackage getClassescsPackage() {
		return (ClassescsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClassescsPackage getPackage() {
		return ClassescsPackage.eINSTANCE;
	}

} //ClassescsFactoryImpl
