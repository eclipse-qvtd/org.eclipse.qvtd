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
 * $Id: AssignmentItemProvider.java,v 1.1 2008/07/23 09:44:16 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.provider;


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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.ocl.ecore.EcoreFactory;

import org.eclipse.qvt.declarative.ecore.QVTCore.Assignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.qvt.declarative.ecore.QVTCore.Assignment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AssignmentItemProvider
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
	public AssignmentItemProvider(AdapterFactory adapterFactory) {
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

			addIsDefaultPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Is Default feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsDefaultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Assignment_isDefault_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Assignment_isDefault_feature", "_UI_Assignment_type"),
				 QVTCorePackage.Literals.ASSIGNMENT__IS_DEFAULT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(QVTCorePackage.Literals.ASSIGNMENT__VALUE);
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
	 * This returns Assignment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Assignment"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		Assignment assignment = (Assignment)object;
		return getString("_UI_Assignment_type") + " " + assignment.isIsDefault();
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

		switch (notification.getFeatureID(Assignment.class)) {
			case QVTCorePackage.ASSIGNMENT__IS_DEFAULT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case QVTCorePackage.ASSIGNMENT__VALUE:
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
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
				 EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTCorePackage.Literals.ASSIGNMENT__VALUE,
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
		return QVTCoreEditPlugin.INSTANCE;
	}

}
