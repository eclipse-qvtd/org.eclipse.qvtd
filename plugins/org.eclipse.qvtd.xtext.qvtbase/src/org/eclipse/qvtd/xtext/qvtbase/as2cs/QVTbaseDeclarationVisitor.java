/*******************************************************************************
 * Copyright (c) 2016, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.as2cs;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.TemplateSignature;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ConstraintCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.OperationCS;
import org.eclipse.ocl.xtext.basecs.ParameterCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.SpecificationCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLDeclarationVisitor;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.CompoundTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Target;
import org.eclipse.qvtd.pivot.qvtbase.TargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionBody;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;
import org.eclipse.qvtd.xtext.qvtbasecs.CompoundTargetElementCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS;
import org.eclipse.qvtd.xtext.qvtbasecs.TargetCS;
import org.eclipse.qvtd.xtext.qvtbasecs.TargetElementCS;

public abstract class QVTbaseDeclarationVisitor extends EssentialOCLDeclarationVisitor implements QVTbaseVisitor<ElementCS>
{
	public QVTbaseDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	public @Nullable TypedRefCS createTypeRefCS(@NonNull TypedElement asTypedElement) {	// FIXME Bug 496810 promote to OCL
		return createTypeRefCS(asTypedElement, null);
	}

	public @Nullable TypedRefCS createTypeRefCS(@NonNull TypedElement asTypedElement, @Nullable Boolean defaultIsRequired) {	// FIXME Bug 496810 promote to OCL
		boolean isRequired = asTypedElement.isIsRequired();
		Type asType = asTypedElement.getType();
		TypedRefCS csTypeRef = createTypeRefCS(asType);
		if ((csTypeRef != null) && ((defaultIsRequired == null) ||  (isRequired != defaultIsRequired.booleanValue()))) {
			if (!isRequired) {
				MultiplicityStringCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityStringCS();	// FIXME MultiplicityStringCS would be nicer but "1" is the default which confuses Xtext serialization
				csMultiplicity.setStringBounds("?");
				csTypeRef.setOwnedMultiplicity(csMultiplicity);
			}
			else {
				MultiplicityBoundsCS csMultiplicity = BaseCSFactory.eINSTANCE.createMultiplicityBoundsCS();	// FIXME MultiplicityStringCS would be nicer but "1" is the default which confuses Xtext serialization
				csMultiplicity.setLowerBound(1);
				csTypeRef.setOwnedMultiplicity(csMultiplicity);
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

	protected @NonNull ImportCS resolveImport(@NonNull Import asUnit) {
		String importURI = null;
		BaseCSResource csResource = context.getCSResource();
		Namespace asNamespace = asUnit.getImportedNamespace();
		EObject eObject = null;
		if (asNamespace instanceof Model) {
			importURI = ((Model)asNamespace).getExternalURI();
		}
		else {
			eObject = asNamespace.getESObject();
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage)eObject;
				Resource resource = ePackage.eResource();
				if (ClassUtil.isRegistered(resource)) {
					importURI = ePackage.getNsURI();
				}
			}
		}
		if ((importURI == null) && (csResource != null)) {
			URI fullURI = EcoreUtil.getURI(eObject != null ? eObject : asNamespace);
			URI csURI = csResource.getURI();
			URI deresolvedURI = URIUtil.deresolve(fullURI, csURI, true, true, false);
			importURI = deresolvedURI.toString();
		}
		ImportCS csImport = context.refreshElement(ImportCS.class, BaseCSPackage.Literals.IMPORT_CS, asUnit);
		csImport.setPivot(asUnit);
		csImport.setName(asUnit.getName());
		PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
		List<PathElementCS> csPath = csPathName.getOwnedPathElements();
		PathElementWithURICS csSimpleRef = BaseCSFactory.eINSTANCE.createPathElementWithURICS();
		csSimpleRef.setReferredElement(asNamespace);
		csSimpleRef.setUri(importURI);
		csPath.add(csSimpleRef);
		csImport.setOwnedPathName(csPathName);
		return csImport;
	}

	@Override
	public ElementCS visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitCompoundTargetElement(@NonNull CompoundTargetElement asCompoundTargetElement) {
		CompoundTargetElementCS csCompoundTargetElement = context.refreshElement(CompoundTargetElementCS.class, QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS, asCompoundTargetElement);
		context.refreshList(csCompoundTargetElement.getOwnedTargetElements(), context.visitDeclarations(SimpleTargetElementCS.class, asCompoundTargetElement.getOwnedTargetElements(), null));
		return csCompoundTargetElement;
	}

	@Override
	public ElementCS visitDomain(@NonNull Domain object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitFunction(@NonNull Function object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitFunctionBody(@NonNull FunctionBody object) {
		return super.visitExpressionInOCL(object);
	}

	@Override
	public ElementCS visitFunctionParameter(@NonNull FunctionParameter object) {
		return visiting(object);
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

	@Override
	public ElementCS visitPattern(@NonNull Pattern object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitPredicate(@NonNull Predicate object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitSimpleTargetElement(@NonNull SimpleTargetElement asSimpleTargetElement) {
		SimpleTargetElementCS csSimpleTargetElement = context.refreshElement(SimpleTargetElementCS.class, QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS, asSimpleTargetElement);
		PivotUtilInternal.refreshList(csSimpleTargetElement.getIterates(), asSimpleTargetElement.getIterates());
		csSimpleTargetElement.setTypedModel(asSimpleTargetElement.getTypedModel());
		switch (asSimpleTargetElement.getKind()) {
			case INPUT: csSimpleTargetElement.setInput(true); break;
			case OUTPUT: csSimpleTargetElement.setOutput(true); break;
			case VIA: csSimpleTargetElement.setVia(true); break;
		}
		return csSimpleTargetElement;
	}

	@Override
	public ElementCS visitTarget(@NonNull Target asTarget) {
		TargetCS csTarget = context.refreshNamedElement(TargetCS.class, QVTbaseCSPackage.Literals.TARGET_CS, asTarget, null);
		context.refreshList(csTarget.getOwnedTargetElements(), context.visitDeclarations(TargetElementCS.class, asTarget.getOwnedTargetElements(), null));
		return csTarget;
	}

	@Override
	public ElementCS visitTargetElement(@NonNull TargetElement object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitTransformation(@NonNull Transformation object) {
		return visiting(object);
	}
}
