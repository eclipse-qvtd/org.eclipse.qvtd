/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.importer.roseuml.builder;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.emf.importer.rose.RoseImporterPlugin;
import org.eclipse.emf.importer.rose.builder.RoseEcoreBuilder;
import org.eclipse.emf.importer.rose.builder.TableObject;
import org.eclipse.emf.importer.rose.parser.RoseNode;

/**
 * Traverses the RoseUML file and create Ecore object in memory.
 * <p>
 * The derived implementation
 * <br>observes the {ordered} constraint and sets ordered accordingly
 * <br>use comments/annotations for unnavigable opposite role names
 * <br>use the OCL lower case default role naming
 */
public class RoseUMLEcoreBuilder extends RoseEcoreBuilder
{
	public static final String OMITTED_REFERENCE_NAME = "omitted";
	protected Map<EReference, EReference> oneWayAssocs = new HashMap<EReference, EReference>();
	
    public RoseUMLEcoreBuilder(RoseUMLUtil roseUtil)
    {
        super(roseUtil);
    }

	protected RoseUMLUtil getRoseUtil() {
		return (RoseUMLUtil) roseUtil;
	}

	/**
	 * Mark any omitted reference name as missing, to avoid inherited fix up until we are
	 * ready to fix it up ourselves via validateReferenceName.
	 */
	protected void invalidateReferenceName(EReference ref) {
		String name = ref.getName();
		if ((name == null) || (name.length() <= 0))
			ref.setName(OMITTED_REFERENCE_NAME);
	}
    
	/**
	 * Override to setOrdered() according to "{ordered}" constraint.
	 */
    @Override
	protected void setEReferenceProperties(RoseNode roseNode, EReference eReference)
    {
		super.setEReferenceProperties(roseNode, eReference);
		boolean isOrdered = getRoseUtil().hasOrderedConstraint(roseNode);
        eReference.setOrdered(isOrdered);
		RoseNode assocNode = roseNode.getParent().getParent();
		Object eClass = assocNode.getNode();
		if (eClass instanceof EClass) {
			((EClass) eClass).getEStructuralFeatures().add(eReference);
			eStructuralFeatures.remove(eReference);
		}
    }

	@Override
	protected void setEReferenceIsContainment(EReference ref, RoseNode role1, RoseNode role2) {
		super.setEReferenceIsContainment(ref, role1, role2);
		if (ref.isContainment() || ref.isContainer()) {
		    ref.setResolveProxies(false);
			if (ref.getEOpposite() != null)
				ref.getEOpposite().setResolveProxies(false);
		}
		if (ref.getUpperBound() == 1)
		    ref.setOrdered(true);
	}

	/**
	 * Override to add reference naming resolution.
	 */
	@Override
	public void setETypeClassifier() {
		super.setETypeClassifier();
		for (EReference from : oneWayAssocs.keySet()) {
			EReference to = oneWayAssocs.get(from);
		    boolean nameIsDefault = validateReferenceName(from);
		    validateReferenceName(to);
			if (!nameIsDefault) {
		    	EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		    	eAnnotation.setSource(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
		    	eAnnotation.getDetails().put(EMOFExtendedMetaData.EMOF_COMMENT_BODY, from.getName());
		    	to.getEAnnotations().add(eAnnotation);
		    }
	    	to.setEOpposite(null);
		}
	}

	/**
	 * Set omitted reference name to the target type with a leading lower case letter.
	 * (OCL 06-05-01 7.5.3 Missing AssociationEnd names).
	 * 
	 * Returns true if the name is the default and so could be omitted.
	 */
	protected boolean validateReferenceName(EReference ref) {
		String typeName = CodeGenUtil.validJavaIdentifier(ref.getEType().getName());
		String defaultName = Character.toLowerCase(typeName.charAt(0)) + typeName.substring(1);
		String name = ref.getName();
		if (name == OMITTED_REFERENCE_NAME) {
			ref.setName(defaultName);
			return true;
		}
		return defaultName.equals(name);
	}

    /**
     * Override to reset eGenericType1, eGenericType2; a very cosmetic bug-fix.
     */
    @Override
	protected void visitAssociation(RoseNode roseNode, String roseNodeValue,
			String objectKey, String objectName, Object parent) {
    	eGenericType1 = null;
    	eGenericType2 = null;
		super.visitAssociation(roseNode, roseNodeValue, objectKey, objectName, parent);
	}
	
    /**
     * Override to create references for non-navigable roles too.
     */
    @Override
	protected void visitRole(RoseNode roseNode, String roseNodeValue,
			String objectKey, String objectName, Object parent) {
		super.visitRole(roseNode, roseNodeValue, objectKey, objectName, parent);
		RoseUMLUtil roseUtil = getRoseUtil();
//		if (roseUtil.getUseSemiOpposites()) {
			if (ref1 != null && ref2 != null && role1 != null && role2 != null)
			{
				invalidateReferenceName(ref1);
				invalidateReferenceName(ref2);
			    String ref1Quidu = role1.getRoseRefId();
			    if (ref1Quidu != null && !ref1Quidu.equals(""))
			    {
			        ref1Quidu = ref1Quidu.substring(1, ref1Quidu.length() - 1);
			    }
			    String ref2Quidu = role2.getRoseRefId();
			    if (ref2Quidu != null && !ref2Quidu.equals(""))
			    {
			        ref2Quidu = ref2Quidu.substring(1, ref2Quidu.length() - 1);
			    }
			    boolean ref1Navigable = role1.isNavigable();
			    boolean ref2Navigable = role2.isNavigable();
			    if (!ref1Navigable)
			    {
			    	assert ref2Navigable;
			        roseUtil.putRef(ref1, ref2Quidu);
			        TableObject obj = (TableObject)roseUtil.getQuid(ref1Quidu);
			        if (obj != null)
			        {
			            roseUtil.putType(eGenericType1 == null ? ref1 : eGenericType1, obj.getName());
			        }
			        else
			        {
			            warning(RoseImporterPlugin.INSTANCE.getString("_UI_UnresolvedTypeNameFor_message", new Object []{
			                role1.getRoseSupplier(),
			                ref1.getName() }));
			            roseUtil.putType(eGenericType1 == null ? ref1 : eGenericType1, "EObject");
			        }
			        oneWayAssocs.put(ref1, ref2);
			    }
			    if (!ref2Navigable)
			    {
			    	assert ref1Navigable;
			        roseUtil.putRef(ref2, ref1Quidu);
			        TableObject obj = (TableObject)roseUtil.getQuid(ref2Quidu);
			        if (obj != null)
			        {
			            roseUtil.putType(eGenericType2 == null ? ref2 : eGenericType2, obj.getName());
			        }
			        else
			        {
			            warning(RoseImporterPlugin.INSTANCE.getString("_UI_UnresolvedTypeNameFor_message", new Object []{
			                role2.getRoseSupplier(),
			                ref2.getName() }));
			            roseUtil.putType(eGenericType2 == null ? ref2 : eGenericType2, "EObject");
			        }
			        oneWayAssocs.put(ref2, ref1);
			    }
			}
//		}
	}
}
