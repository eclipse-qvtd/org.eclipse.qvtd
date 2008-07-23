/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.EMOF.util;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingExtension;
import org.eclipse.qvt.declarative.ecore.mappings.EClassMap;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

/**
 * An EAnnotationAdapter adapts an Ecore EAnnotation to a non-Ecore adapting behaviour.
 * <br>
 * By default an EAnnotation is mapped to an xmi:Extension.
 * <br>
 * However the EAnnotation.source may be used to select alternate mappings. Thus
 * <br>
 * An ANNOTATION_COMMENT_SOURCE value for the source denotes that the BODY detail contains
 * the body of an EMOF Comment.
 * <br>
 * An ANNOTATION_PROPERTY_SOURCE value for the source denotes that the BODY detail contains
 * the oppositeRoleName and that the corresponding EMOF Comment should have ANNOTATION_PROPERTY_SOURCE
 * as the body of a sub-comment.
 * <br>
 * An ANNOTATION_TAG_SOURCE value for the source denotes that the NAME and VALUE details contains
 * the  name and value of a corresponding EMOF Tag which should have ANNOTATION_TAG_SOURCE
 * as the body of a sub-comment.
 * <br>
 * Resolution of behaviour during loading is complicated by the delayed validity of the
 * sub-comment. A PostLoader may therefore be installed to assist in the conversion of the
 * EAnnotations representing the external EMOF and those that correspond to Ecore.
 * <bR.
 * Resolution of behaviour during saving is complicated by the need to convert only
 * those EAnnotations that are to be serialised as xmi:Extensionsto AnyType objects.
 */
class EAnnotationAdapter extends AdaptingExtension
{
	protected RedirectedAnnotationClassMap postLoader = null;	// Non-null while loading is in progress
	protected EAnnotationAdapter childComment = null;			// Non-null if there is a child comment adapter for the source
	protected EAnnotationAdapter parentComment = null;			// Non-null if this is a child comment adapter for the parent's source		
	private List<Object> ownedCommentsToSave = null;

	protected EAnnotationAdapter(MappingMetaDataRegistry mappingMetaDataRegistry, EAnnotationClassMap classMap, EAnnotation target) {
		super(mappingMetaDataRegistry, classMap, target);
	}

	private void configureChildComment() {
		if ((childComment == null) && (parentComment == null)) {
			final EAnnotation thisAnnotation = getTarget();
			if (!isXmiExtension() && !(thisAnnotation.eContainer() instanceof EAnnotation)) {
				childComment = new EAnnotationAdapter(mappingMetaDataRegistry, (EAnnotationClassMap) super.getClassMap(), thisAnnotation);
				childComment.parentComment = this;
			}
		}			
	}
	
	@Override
	public EClass eClass() {
		if (postLoader != null)
			return postLoader.getAdaptingEClass();
		else
			return super.eClass();
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		if (feature == EMOFPackage.Literals.COMMENT__BODY) {	// FIXME bodyMap
			if (parentComment != null)
				return getTarget().getSource();
			else
				return getTarget().getDetails().get(EMOFAnnotationMappingMetaData.DETAILS_BODY);
		}
		else if (feature == EMOFPackage.Literals.TAG__NAME) {
			if (parentComment != null)
				return getTarget().getSource();
			else
				return getTarget().getDetails().get(EMOFAnnotationMappingMetaData.DETAILS_NAME);
		}
		else if (feature == EMOFPackage.Literals.TAG__VALUE) {
			if (parentComment != null)
				return getTarget().getSource();
			else
				return getTarget().getDetails().get(EMOFAnnotationMappingMetaData.DETAILS_VALUE);
		}
		else if (feature == EMOFPackage.Literals.ELEMENT__OWNED_COMMENT) {
			if (ownedCommentsToSave != null)
				return ownedCommentsToSave;
			else {
				if (childComment == null)
					configureChildComment();
				if (parentComment != null)
					return new BasicInternalEList<EAnnotation>(EAnnotation.class); // FIXME share
			}
		}
		return super.eGet(feature, resolve);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		if (feature == EMOFPackage.Literals.COMMENT__BODY) {		// FIXME WIP annotatedElement etc
			if (parentComment == null)
				return getTarget().getDetails().containsKey(EMOFAnnotationMappingMetaData.DETAILS_BODY);
			else {
				String source = getTarget().getSource();
				if (source == null)
					return false;
				if (EMOFExtendedMetaData.EMOF_COMMENT_ANNOTATION_SOURCE.equals(source))
					return false;
				return true;
			}
		}
		else if (feature == EMOFPackage.Literals.TAG__NAME) {
			if (parentComment == null)
				return getTarget().getDetails().containsKey(EMOFAnnotationMappingMetaData.DETAILS_NAME);
			else {
				String source = getTarget().getSource();
				if (source == null)
					return false;
				if (EMOFAnnotationMappingMetaData.EMOF_TAG_ANNOTATION_SOURCE.equals(source))
					return false;
				return true;
			}
		}
		else if (feature == EMOFPackage.Literals.TAG__VALUE) {
			if (parentComment == null)
				return getTarget().getDetails().containsKey(EMOFAnnotationMappingMetaData.DETAILS_VALUE);
			else {
				String source = getTarget().getSource();
				if (source == null)
					return false;
				if (EMOFAnnotationMappingMetaData.EMOF_TAG_ANNOTATION_SOURCE.equals(source))
					return false;
				return true;
			}
		}
		else if (feature == EMOFPackage.Literals.ELEMENT__OWNED_COMMENT) {
			if (ownedCommentsToSave != null)		// FIXME WIP parentComment first
				return ownedCommentsToSave.size() > 0;
			else {
				if (childComment == null)
					configureChildComment();
				if (parentComment != null)
					return false;
			}
		}
		return super.eIsSet(feature);
	}
	
	@Override
	public void eSet(EStructuralFeature feature, Object adaptingValue) {
		if (feature == EMOFPackage.Literals.COMMENT__BODY) {
			if (parentComment != null)
				getTarget().setSource((String)adaptingValue);
			else
				getTarget().getDetails().put(EMOFAnnotationMappingMetaData.DETAILS_BODY, (String)adaptingValue);
		}
		else if (feature == EMOFPackage.Literals.TAG__NAME) {
			if (parentComment != null)
				getTarget().setSource((String)adaptingValue);
			else
				getTarget().getDetails().put(EMOFAnnotationMappingMetaData.DETAILS_NAME, (String)adaptingValue);
		}
		else if (feature == EMOFPackage.Literals.TAG__VALUE) {
			if (parentComment != null)
				getTarget().setSource((String)adaptingValue);
			else
				getTarget().getDetails().put(EMOFAnnotationMappingMetaData.DETAILS_VALUE, (String)adaptingValue);
		}
		else //if (feature == EMOFPackage.Literals.ELEMENT__OWNED_COMMENT)
			super.eSet(feature, adaptingValue);		// Never happens
	}

	@Override
	public EClassMap getClassMap() {
		if (postLoader != null)
			return postLoader;
		EAnnotationClassMap annotationClassMap = (EAnnotationClassMap)super.getClassMap();
		return annotationClassMap.getClassMap(getTarget());
	}

	@Override
	public EAnnotation getTarget() {
		return ((EAnnotation)target);
	}

	@Override
	public boolean isXmiExtension() {
		if (postLoader != null)
			return postLoader.isXmiExtension(this);
		EAnnotationClassMap annotationClassMap = (EAnnotationClassMap)super.getClassMap();
		return annotationClassMap.isXmiExtension(getTarget());
	}

	@Override
	public void postLoad() {
		super.postLoad();
		if (postLoader != null) {
			postLoader.postLoad(this);
			postLoader = null;
		}
	}

	@Override
	public void postSave() {
		ownedCommentsToSave = null;
		super.postSave();
	}

	// During a save, the childComment adapter must appear to be an ownedComment.
	@Override
	public void preSave() {
		configureChildComment();
		if (childComment != null) {		// A parent comment needs its child to appear as an ownedComment
			ownedCommentsToSave = new BasicInternalEList<Object>(AdaptingEObject.class);
			String source = getTarget().getSource();
			if (!EMOFExtendedMetaData.EMOF_COMMENT_ANNOTATION_SOURCE.equals(source)
			 && !EMOFAnnotationMappingMetaData.EMOF_TAG_ANNOTATION_SOURCE.equals(source))
				ownedCommentsToSave.add(childComment);
		}
		else if (parentComment != null) // A child comment needs nothing
			;
		else							// An ordinary annotation is an inherited extension
			super.preSave();		
	}

	@Override
	public String toString() {
		if (parentComment != null)
			return super.toString() + ".source";
		else
			return super.toString();
	}
}