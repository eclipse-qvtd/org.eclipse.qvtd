/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
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
 * $Id: RelationDomainAssignmentItemProvider.java,v 1.2 2008/09/09 21:00:44 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.provider.EModelElementItemProvider;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.ocl.ecore.EcoreFactory;

import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;

import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplateFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationDomainAssignmentItemProvider
	extends EModelElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationDomainAssignmentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addVariablePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Variable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVariablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationDomainAssignment_variable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationDomainAssignment_variable_feature", "_UI_RelationDomainAssignment_type"),
				 QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VARIABLE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns RelationDomainAssignment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RelationDomainAssignment"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_RelationDomainAssignment_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(RelationDomainAssignment.class)) {
			case QVTRelationPackage.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 QVTRelationFactory.eINSTANCE.createOppositePropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 QVTRelationFactory.eINSTANCE.createRelationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 QVTTemplateFactory.eINSTANCE.createObjectTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 QVTTemplateFactory.eINSTANCE.createCollectionTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP,
				 EcoreFactory.eINSTANCE.createVariableExp()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return QVTRelationEditPlugin.INSTANCE;
	}

}
