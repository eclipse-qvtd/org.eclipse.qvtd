/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: TestQVTBaseFactoryImpl.java,v 1.2 2008/12/31 18:14:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvt.declarative.test.TestQVTBase.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TestQVTBaseFactoryImpl extends EFactoryImpl implements TestQVTBaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TestQVTBaseFactory init() {
		try {
			TestQVTBaseFactory theTestQVTBaseFactory = (TestQVTBaseFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/1.0/TestQVTBase"); 
			if (theTestQVTBaseFactory != null) {
				return theTestQVTBaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TestQVTBaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestQVTBaseFactoryImpl() {
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
			case TestQVTBasePackage.TEST_DOMAIN: return createTestDomain();
			case TestQVTBasePackage.TEST_EXPRESSION: return createTestExpression();
			case TestQVTBasePackage.TEST_PATTERN: return createTestPattern();
			case TestQVTBasePackage.TEST_RULE: return createTestRule();
			case TestQVTBasePackage.TEST_TRANSFORMATION: return createTestTransformation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestDomain createTestDomain() {
		TestDomainImpl testDomain = new TestDomainImpl();
		return testDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestExpression createTestExpression() {
		TestExpressionImpl testExpression = new TestExpressionImpl();
		return testExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestPattern createTestPattern() {
		TestPatternImpl testPattern = new TestPatternImpl();
		return testPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRule createTestRule() {
		TestRuleImpl testRule = new TestRuleImpl();
		return testRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestTransformation createTestTransformation() {
		TestTransformationImpl testTransformation = new TestTransformationImpl();
		return testTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestQVTBasePackage getTestQVTBasePackage() {
		return (TestQVTBasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TestQVTBasePackage getPackage() {
		return TestQVTBasePackage.eINSTANCE;
	}

} //TestQVTBaseFactoryImpl
