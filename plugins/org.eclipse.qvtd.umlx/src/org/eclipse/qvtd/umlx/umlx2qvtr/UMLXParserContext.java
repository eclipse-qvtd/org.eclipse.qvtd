/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.umlx2qvtr;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.ocl.xtext.base.attributes.PivotableElementCSAttribution;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.utilities.AbstractExtendedParserContext;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.essentialocl.cs2as.ImplicitSourceTypeIterator;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.xtext.qvtrelation.cs2as.QVTrelationCS2AS;
import org.eclipse.qvtd.xtext.qvtrelation.cs2as.QVTrelationCSLeft2RightVisitor;

/**
 * UMLXParserContext supervises parsing a textual OCL expression embedded within a UMLX model element
 * to yield an OCL expression tree for use within a corresponding QVTr model.
 *
 * The standard Essential OCL expression parser is overridden to use the QVTr parser and so to support
 * QVTr extensions such as RelationCallExp. THe QVTr parser is in turn overridden to support resolution of
 * name lookups and iterator implicit sources within the embedding QVTr model.
 */
class UMLXParserContext extends AbstractExtendedParserContext
{
	protected class ContextCSAttribution extends PivotableElementCSAttribution
	{
		@Override
		public @Nullable ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
			ScopeView computeLookup = super.computeLookup(target, environmentView, scopeView);
			//
			//	Last, last alternative. If nothing found get the UMLXParserContext to help out.
			//
			if (!environmentView.hasFinalResult()) {// && ((computeLookup == null) || (computeLookup.getTarget() == null))) {
				return UMLXParserContext.this.computeLookup(target, environmentView, scopeView);
			}
			return computeLookup;
		}
	}

	protected class UMLXCS2AS extends QVTrelationCS2AS
	{
		protected UMLXCS2AS(@NonNull BaseCSResource csResource, @NonNull ASResource asResource) {
			super(UMLXParserContext.this.environmentFactory, csResource, asResource);
		}

		@Override
		protected @NonNull QVTrelationCSLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2ASConversion converter) {
			return new UMLXCSLeft2RightVisitor(converter);
		}
	}

	protected class UMLXCSLeft2RightVisitor extends QVTrelationCSLeft2RightVisitor
	{
		protected UMLXCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
			super(context);
		}

		@Override
		protected ImplicitSourceTypeIterator createImplicitSourceTypeIterator(@NonNull ElementCS csElement) {
			return new ImplicitSourceTypeIterator(csElement)
			{
				@Override
				protected boolean doNext(@NonNull ElementCS csParent, @NonNull ElementCS csChild) {
					if (csParent instanceof ContextCS) {
						setNext(contextVariable);
						return DONE; // no more parents
					}
					else {
						return super.doNext(csParent, csChild);
					}
				}
			};
		}
	}

	protected final @NonNull EObject contextElement;
	protected final @NonNull Variable contextVariable;

	public UMLXParserContext(@NonNull EnvironmentFactory environmentFactory, @NonNull EObject contextElement) {
		super(environmentFactory, null); //ClassUtil.nonNullEMF(URI.createURI(EcoreUtil.generateUUID() + ".qvtr")));
		this.contextElement = contextElement;
		RelationalTransformation transformation = QVTrelationUtil.getContainingTransformation(contextElement);
		this.contextVariable = QVTbaseUtil.getContextVariable(environmentFactory.getStandardLibrary(), transformation);
		addAttribution(EssentialOCLCSPackage.Literals.CONTEXT_CS, new ContextCSAttribution());
	}

	private @Nullable ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		EObject pivot = contextElement;
		if ((pivot instanceof Element) && (pivot.eResource() != null) && !(pivot instanceof InvalidType)) {
			environmentView.computeLookups((Element) pivot, null); //PivotUtil.getPivot(Element.class, scopeView.getChild());
		}
		if (!environmentView.hasFinalResult()) {
			return scopeView.getParent();
		}
		return scopeView.getParent();
	}

	@Override
	public @Nullable CS2AS createCS2AS(@NonNull BaseCSResource csResource, @NonNull ASResource asResource) {
		return new UMLXCS2AS(csResource, asResource);
	}

	public @NonNull OCLExpression parseExpression(@NonNull EObject owner, @NonNull String expression) throws ParserException, IOException {
		CSResource resource = createBaseResource(expression);
		String childName = owner instanceof Nameable ? ((Nameable)owner).getName() : "<unknown>";
		EObject eContainer = owner.eContainer();
		String parentName = eContainer instanceof Nameable ? ((Nameable)eContainer).getName() : "<unknown>";
		PivotUtil.checkResourceErrors(StringUtil.bind(PivotMessagesInternal.ValidationConstraintIsInvalid_ERROR_, parentName, childName, expression.trim()), resource);
		ASResource asResource = resource.getASResource();
		assert asResource.getContents().size() == 1;
		ExpressionInOCL asExpression = (ExpressionInOCL) asResource.getContents().get(0);
		return PivotUtil.getOwnedBody(asExpression);
	}
}