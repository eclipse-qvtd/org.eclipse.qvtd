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
 * $Id: TransformationItemProvider.java,v 1.1 2008/07/23 09:41:12 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.provider.EClassItemProvider;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;

/**
 * This is the item provider adapter for a {@link org.eclipse.qvt.declarative.ecore.QVTBase.Transformation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TransformationItemProvider
	extends EClassItemProvider
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
	public TransformationItemProvider(AdapterFactory adapterFactory) {
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

			addNsURIPropertyDescriptor(object);
			addNsPrefixPropertyDescriptor(object);
			addEFactoryInstancePropertyDescriptor(object);
			addExtendsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ns URI feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNsURIPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPackage_nsURI_feature"),
				 getString("_UI_EPackage_nsURI_description"),
				 EcorePackage.Literals.EPACKAGE__NS_URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Ns Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNsPrefixPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPackage_nsPrefix_feature"),
				 getString("_UI_EPackage_nsPrefix_description"),
				 EcorePackage.Literals.EPACKAGE__NS_PREFIX,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the EFactory Instance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEFactoryInstancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EPackage_eFactoryInstance_feature"),
				 getString("_UI_EPackage_eFactoryInstance_description"),
				 EcorePackage.Literals.EPACKAGE__EFACTORY_INSTANCE,
				 false,
				 false,
				 false,
				 null,
				 null,
				 new String[] {
					"org.eclipse.ui.views.properties.expert"
				 }));
	}

	/**
	 * This adds a property descriptor for the Extends feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExtendsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Transformation_extends_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Transformation_extends_feature", "_UI_Transformation_type"),
				 QVTBasePackage.Literals.TRANSFORMATION__EXTENDS,
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
			childrenFeatures.add(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
			childrenFeatures.add(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES);
			childrenFeatures.add(QVTBasePackage.Literals.TRANSFORMATION__OWNED_TAG);
			childrenFeatures.add(QVTBasePackage.Literals.TRANSFORMATION__MODEL_PARAMETER);
			childrenFeatures.add(QVTBasePackage.Literals.TRANSFORMATION__RULE);
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
	 * This returns Transformation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Transformation"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Transformation)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Transformation_type") :
			getString("_UI_Transformation_type") + " " + label;
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

		switch (notification.getFeatureID(Transformation.class)) {
			case QVTBasePackage.TRANSFORMATION__NS_URI:
			case QVTBasePackage.TRANSFORMATION__NS_PREFIX:
			case QVTBasePackage.TRANSFORMATION__EFACTORY_INSTANCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case QVTBasePackage.TRANSFORMATION__ECLASSIFIERS:
			case QVTBasePackage.TRANSFORMATION__ESUBPACKAGES:
			case QVTBasePackage.TRANSFORMATION__OWNED_TAG:
			case QVTBasePackage.TRANSFORMATION__MODEL_PARAMETER:
			case QVTBasePackage.TRANSFORMATION__RULE:
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
				(EcorePackage.Literals.ECLASS__EOPERATIONS,
				 QVTBaseFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 QVTBaseFactory.eINSTANCE.createTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 EcoreFactory.eINSTANCE.createEClass()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 EcoreFactory.eINSTANCE.createEDataType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 EcoreFactory.eINSTANCE.createEEnum()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createAnyType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createCollectionType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createBagType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createElementType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createInvalidType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createMessageType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createOrderedSetType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createSequenceType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createSetType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTupleType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createTypeType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS,
				 org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createVoidType()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				 QVTBaseFactory.eINSTANCE.createTransformation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES,
				 EcoreFactory.eINSTANCE.createEPackage()));

		newChildDescriptors.add
			(createChildParameter
				(QVTBasePackage.Literals.TRANSFORMATION__OWNED_TAG,
				 EcoreFactory.eINSTANCE.createEAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(QVTBasePackage.Literals.TRANSFORMATION__MODEL_PARAMETER,
				 QVTBaseFactory.eINSTANCE.createTypedModel()));
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
			childFeature == EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS ||
			childFeature == QVTBasePackage.Literals.TRANSFORMATION__OWNED_TAG ||
			childFeature == EcorePackage.Literals.EPACKAGE__ECLASSIFIERS ||
			childFeature == EcorePackage.Literals.EPACKAGE__ESUBPACKAGES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return QVTBaseEditPlugin.INSTANCE;
	}

}
