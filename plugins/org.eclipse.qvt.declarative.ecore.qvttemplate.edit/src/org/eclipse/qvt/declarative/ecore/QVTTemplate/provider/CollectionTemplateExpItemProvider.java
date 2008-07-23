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
 * $Id: CollectionTemplateExpItemProvider.java,v 1.1 2008/07/23 09:49:26 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.ocl.ecore.EcoreFactory;

import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplateFactory;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CollectionTemplateExpItemProvider
	extends TemplateExpItemProvider
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
	public CollectionTemplateExpItemProvider(AdapterFactory adapterFactory) {
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

			addReferredCollectionTypePropertyDescriptor(object);
			addRestPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Referred Collection Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReferredCollectionTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionTemplateExp_referredCollectionType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionTemplateExp_referredCollectionType_feature", "_UI_CollectionTemplateExp_type"),
				 QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rest feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRestPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CollectionTemplateExp_rest_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CollectionTemplateExp_rest_feature", "_UI_CollectionTemplateExp_type"),
				 QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REST,
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
			childrenFeatures.add(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER);
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
	 * This returns CollectionTemplateExp.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CollectionTemplateExp"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CollectionTemplateExp)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_CollectionTemplateExp_type") :
			getString("_UI_CollectionTemplateExp_type") + " " + label;
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

		switch (notification.getFeatureID(CollectionTemplateExp.class)) {
			case QVTTemplatePackage.COLLECTION_TEMPLATE_EXP__MEMBER:
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
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 QVTTemplateFactory.eINSTANCE.createObjectTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 QVTTemplateFactory.eINSTANCE.createCollectionTemplateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createAssociationClassCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createBooleanLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createCollectionLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createEnumLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createIfExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createIntegerLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createUnlimitedNaturalLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createInvalidLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createIterateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createIteratorExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createLetExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createMessageExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createNullLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createOperationCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createPropertyCallExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createRealLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createStateExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createStringLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createTupleLiteralExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createTypeExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createUnspecifiedValueExp()));

		newChildDescriptors.add
			(createChildParameter
				(QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER,
				 EcoreFactory.eINSTANCE.createVariableExp()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == QVTTemplatePackage.Literals.TEMPLATE_EXP__WHERE ||
			childFeature == QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
