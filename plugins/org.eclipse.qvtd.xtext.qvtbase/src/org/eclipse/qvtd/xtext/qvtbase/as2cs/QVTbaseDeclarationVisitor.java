/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.as2cs;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLDeclarationVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

public abstract class QVTbaseDeclarationVisitor extends EssentialOCLDeclarationVisitor implements QVTbaseVisitor<ElementCS>
{
	public QVTbaseDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	public @Nullable TypedRefCS createTypeRefCS(@NonNull TypedElement asTypedElement) {
		Type asType = asTypedElement.getType();
		TypedRefCS csTypeRef = createTypeRefCS(asType);
		if (csTypeRef != null) {
			if (asType instanceof CollectionType) {
				CollectionType asCollectionType = (CollectionType)asType;
				boolean isNullFree = asCollectionType.isIsNullFree();
				if (!isNullFree) {
					//					CollectionTypeCS csCollectionType = (CollectionTypeCS)csTypeRef;
					MultiplicityStringCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityStringCS();
					csMultiplicity.setIsNullFree(false);
					csMultiplicity.setStringBounds("*");
					if (csTypeRef instanceof CollectionTypeCS) {
						((CollectionTypeCS)csTypeRef).setOwnedCollectionMultiplicity(csMultiplicity);
					}
					else {
						csTypeRef.setOwnedMultiplicity(csMultiplicity);
					}
				}
			}
			else {
				if (asTypedElement.isIsRequired()) {
					MultiplicityBoundsCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityBoundsCS();
					csMultiplicity.setLowerBound(1);
					csTypeRef.setOwnedMultiplicity(csMultiplicity);
				}
				//			else {
				//				MultiplicityStringCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityStringCS();
				//				csMultiplicity.setStringBounds("1");
				//				csTypeRef.setOwnedMultiplicity(csMultiplicity);
				//			}
			}
		}
		return csTypeRef;
	}

	// FIXME Re-implemented to workaround Bug 496148
	public <@NonNull T extends TypedElementCS> T refreshTypedElement(@NonNull Class<T> csClass, /*@NonNull */EClass csEClass, @NonNull TypedElement asTypedElement) {
		T csTypedElement = context.refreshNamedElement(csClass, csEClass, asTypedElement);
		csTypedElement.setPivot(asTypedElement);
		TypedRefCS csTypeRef = createTypeRefCS(asTypedElement);
		csTypedElement.setOwnedType(csTypeRef);
		return csTypedElement;
	}

	@Override // FIXME Re-implemented to workaround Bug 496148
	public ElementCS visitOperation(@NonNull Operation object) {
		OperationCS csElement = refreshTypedElement(OperationCS.class, BaseCSPackage.Literals.OPERATION_CS, object);
		TemplateSignature ownedTemplateSignature = object.getOwnedSignature();
		csElement.setOwnedSignature(context.visitDeclaration(TemplateSignatureCS.class, ownedTemplateSignature));
		context.refreshList(csElement.getOwnedParameters(), context.visitDeclarations(ParameterCS.class, object.getOwnedParameters(), null));
		context.refreshList(csElement.getOwnedExceptions(), context.visitReferences(TypedRefCS.class, object.getRaisedExceptions(), null));
		//
		context.refreshList(csElement.getOwnedPreconditions(), context.visitDeclarations(ConstraintCS.class, object.getOwnedPreconditions(), null));
		List<LanguageExpression> bodyExpressions = object.getBodyExpression() != null ? Collections.singletonList(object.getBodyExpression()) : Collections.<LanguageExpression>emptyList();
		context.refreshList(csElement.getOwnedBodyExpressions(), context.visitDeclarations(SpecificationCS.class, bodyExpressions, null));
		context.refreshList(csElement.getOwnedPostconditions(), context.visitDeclarations(ConstraintCS.class, object.getOwnedPostconditions(), null));
		return csElement;
	}

	@Override
	public ElementCS visitParameter(@NonNull Parameter object) { // FIXME Re-implemented to workaround Bug 496148
		ParameterCS csElement = refreshTypedElement(ParameterCS.class, BaseCSPackage.Literals.PARAMETER_CS, object);
		return csElement;
	}
}
