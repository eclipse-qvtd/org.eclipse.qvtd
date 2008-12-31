/**
 * <copyright>
 * </copyright>
 *
 * $Id: TestQVTBaseXMLProcessor.java,v 1.1 2008/12/31 18:11:04 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.TestQVTBase.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBasePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TestQVTBaseXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestQVTBaseXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		TestQVTBasePackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the TestQVTBaseResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new TestQVTBaseResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new TestQVTBaseResourceFactoryImpl());
		}
		return registrations;
	}

} //TestQVTBaseXMLProcessor
