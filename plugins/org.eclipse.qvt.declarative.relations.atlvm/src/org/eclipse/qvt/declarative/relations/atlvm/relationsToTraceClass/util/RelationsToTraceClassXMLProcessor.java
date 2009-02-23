/**
 * <copyright>
 * </copyright>
 *
 * $Id: RelationsToTraceClassXMLProcessor.java,v 1.1 2009/02/23 18:14:58 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationsToTraceClassXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationsToTraceClassXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		RelationsToTraceClassPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the RelationsToTraceClassResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new RelationsToTraceClassResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new RelationsToTraceClassResourceFactoryImpl());
		}
		return registrations;
	}

} //RelationsToTraceClassXMLProcessor
