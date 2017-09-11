/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterVariable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.util.AbstractExtendingQVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationHelper;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * AbstractQVTr2QVTr provides shared functionality for the early QVTr2QVTr steps in the QVTr2QVTc chain.
 */
public abstract class AbstractQVTr2QVTr extends QVTrelationHelper
{
	/**
	 * An ExpressionCopier deep copies a QVTtemplate/OCLExpression tree, exploiting the forward traceability of context to
	 * update references. Ambiguities should be resolved by performing the copy with respect to an appropriate
	 * stack of resolution scopes.
	 */
	@SuppressWarnings("serial")
	protected static class ExpressionCopier extends EcoreUtil.Copier
	{
		private final @NonNull AbstractQVTr2QVTr context;

		public ExpressionCopier(@NonNull AbstractQVTr2QVTr context) {
			this.context = context;
		}

		@Override
		public EObject get(Object oIn) {
			EObject eOut = super.get(oIn);
			if (eOut == null) {
				eOut = context.equivalentTarget((Element)oIn);
			}
			return eOut;
		}
	}

	/**
	 * The AbstractCreateVisitor performs the mostly 1:1 creation of the QVTr output tree from the QVTr input tree.
	 *
	 * References are left unresolved. QVTtemplates, OCLExpressions are not copied. doXXX methods provide join points for derived implementations.
	 */
	protected static abstract class AbstractCreateVisitor<@NonNull C extends AbstractQVTr2QVTr> extends AbstractExtendingQVTrelationVisitor<Element, C>
	{
		public AbstractCreateVisitor(@NonNull C context) {
			super(context);
		}

		public <T extends Element> @Nullable T create(@Nullable T source) {
			if (source == null) {
				return null;
			}
			@SuppressWarnings("unchecked") @Nullable T target = (T) source.accept(this);
			return target;
		}

		public <T extends Element> void createAll(/*@NonNull*/ Iterable<T> sources, /*@NonNull*/ List<? super T> targets) {
			for (@SuppressWarnings("null")@NonNull T source : sources) {
				@SuppressWarnings("unchecked") T target = (T) source.accept(this);
				if (target != null) {
					targets.add(target);
				}
			}
		}

		@Override
		public @Nullable Element visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		/*		@Override
		public Element visitCollectionTemplateExp(@NonNull CollectionTemplateExp cIn) {
			CollectionTemplateExp cOut = QVTtemplateFactory.eINSTANCE.createCollectionTemplateExp();
			context.addTrace(cIn, cOut);
			//			createAll(cIn.getMember(), cOut.getMember());
			createAll(cIn.getOwnedComments(), cOut.getOwnedComments());
			return cOut;
		} */

		@Override
		public @Nullable Element visitComment(@NonNull Comment cIn) {
			Comment cOut = PivotFactory.eINSTANCE.createComment();
			context.addTrace(cIn, cOut);
			cOut.setBody(cIn.getBody());
			createAll(cIn.getOwnedComments(), cOut.getOwnedComments());
			return cOut;
		}

		@Override
		public @NonNull DomainPattern visitDomainPattern(@NonNull DomainPattern pIn) {
			DomainPattern pOut = QVTrelationFactory.eINSTANCE.createDomainPattern();
			context.addTrace(pIn, pOut);
			createAll(pIn.getPredicate(), pOut.getPredicate());
			//			pOut.setTemplateExpression(create(pIn.getTemplateExpression()));
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
			return pOut;
		}

		@Override
		public @NonNull Function visitFunction(@NonNull Function fIn) {
			Function fOut = QVTbaseFactory.eINSTANCE.createFunction();
			context.addTrace(fIn, fOut);				// Global
			context.pushScope(fOut);
			fOut.setName(fIn.getName());
			fOut.setIsRequired(fIn.isIsRequired());
			fOut.setIsStatic(fIn.isIsStatic());
			fOut.setIsTransient(fIn.isIsTransient());
			fOut.setIsTypeof(fIn.isIsTypeof());
			fOut.setImplementationClass(fIn.getImplementationClass());
			createAll(fIn.getOwnedParameters(), fOut.getOwnedParameters());
			createAll(fIn.getOwnedComments(), fOut.getOwnedComments());
			context.popScope();
			return fOut;
		}

		@Override
		public @NonNull FunctionParameter visitFunctionParameter(@NonNull FunctionParameter fpIn) {
			FunctionParameter fpOut = QVTbaseFactory.eINSTANCE.createFunctionParameter();
			context.addTrace(fpIn, fpOut);
			fpOut.setName(fpIn.getName());
			fpOut.setIsRequired(fpIn.isIsRequired());
			fpOut.setIsTypeof(fpIn.isIsTypeof());
			createAll(fpIn.getOwnedComments(), fpOut.getOwnedComments());
			return fpOut;
		}

		@Override
		public @Nullable Element visitImport(@NonNull Import iIn) {
			Import iOut = context.createImport(iIn);
			createAll(iIn.getOwnedComments(), iOut.getOwnedComments());
			return iOut;
		}

		@Override
		public Element visitKey(@NonNull Key kIn) {
			Key kOut = QVTrelationFactory.eINSTANCE.createKey();
			context.addTrace(kIn, kOut);
			createAll(kIn.getOwnedComments(), kOut.getOwnedComments());
			return kOut;
		}

		/*		@Override
		public Element visitObjectTemplateExp(@NonNull ObjectTemplateExp oIn) {
			ObjectTemplateExp oOut = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
			context.addTrace(oIn, oOut);
			createAll(oIn.getPart(), oOut.getPart());
			createAll(oIn.getOwnedComments(), oOut.getOwnedComments());
			return oOut;
		} */

		@Override
		public @Nullable Element visitPackage(@NonNull Package pIn) {
			if (PivotConstants.ORPHANAGE_URI.equals(pIn.getURI())) {
				return null;
			}
			Package pOut = context.createPackage(pIn);
			createAll(pIn.getOwnedClasses(), pOut.getOwnedClasses());
			createAll(pIn.getOwnedPackages(), pOut.getOwnedPackages());
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
			return pOut;
		}

		@Override
		public @NonNull ParameterVariable visitParameterVariable(@NonNull ParameterVariable vIn) {
			ParameterVariable vOut = PivotFactory.eINSTANCE.createParameterVariable();
			context.addTrace(vIn, vOut);
			vOut.setName(vIn.getName());
			createAll(vIn.getOwnedComments(), vOut.getOwnedComments());
			return vOut;
		}

		@Override
		public @NonNull Pattern visitPattern(@NonNull Pattern pIn) {
			Pattern pOut = QVTbaseFactory.eINSTANCE.createPattern();
			context.addTrace(pIn, pOut);
			createAll(pIn.getPredicate(), pOut.getPredicate());
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
			return pOut;
		}

		@Override
		public @Nullable Element visitPredicate(@NonNull Predicate pIn) {
			Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
			context.addTrace(pIn, pOut);
			// The condition expression is copied during update once replacement variables exist.
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
			return pOut;
		}

		/*		@Override
		public Element visitPropertyTemplateItem(@NonNull PropertyTemplateItem pIn) {
			PropertyTemplateItem pOut = QVTtemplateFactory.eINSTANCE.createPropertyTemplateItem();
			context.addTrace(pIn, pOut);
			pOut.setIsOpposite(pIn.isIsOpposite());
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
			return pOut;
		} */

		@Override
		public @NonNull Relation visitRelation(@NonNull Relation rIn) {
			Relation rOut = QVTrelationFactory.eINSTANCE.createRelation();
			context.addTrace(rIn, rOut);
			context.pushScope(rOut);
			rOut.setName(rIn.getName());
			rOut.setIsAbstract(rIn.isIsAbstract());
			rOut.setIsTopLevel(rIn.isIsTopLevel());
			createAll(rIn.getVariable(), rOut.getVariable());
			createAll(rIn.getDomain(), rOut.getDomain());
			rOut.setWhen(create(rIn.getWhen()));
			rOut.setWhere(create(rIn.getWhere()));
			createAll(rIn.getOwnedComments(), rOut.getOwnedComments());
			context.popScope();
			return rOut;
		}

		@Override
		public @NonNull RelationDomain visitRelationDomain(@NonNull RelationDomain dIn) {
			RelationDomain dOut = QVTrelationFactory.eINSTANCE.createRelationDomain();
			context.addTrace(dIn, dOut);
			dOut.setIsCheckable(dIn.isIsCheckable());
			dOut.setIsEnforceable(dIn.isIsEnforceable());
			createAll(dIn.getPattern(), dOut.getPattern());
			createAll(dIn.getDefaultAssignment(), dOut.getDefaultAssignment());
			createAll(dIn.getOwnedComments(), dOut.getOwnedComments());
			return dOut;
		}

		@Override
		public Element visitRelationDomainAssignment(@NonNull RelationDomainAssignment aIn) {
			RelationDomainAssignment aOut = QVTrelationFactory.eINSTANCE.createRelationDomainAssignment();
			context.addTrace(aIn, aOut);
			return aOut;
		}

		@Override
		public @NonNull RelationModel visitRelationModel(@NonNull RelationModel mIn) {
			RelationModel mOut = QVTrelationFactory.eINSTANCE.createRelationModel();
			context.pushScope(mOut);
			context.addTrace(mIn, mOut);
			createAll(mIn.getOwnedImports(), mOut.getOwnedImports());
			createAll(mIn.getOwnedPackages(), mOut.getOwnedPackages());
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
			context.popScope();
			return mOut;
		}

		@Override
		public @NonNull RelationalTransformation visitRelationalTransformation(@NonNull RelationalTransformation tIn) {
			RelationalTransformation tOut = QVTrelationFactory.eINSTANCE.createRelationalTransformation();
			context.addTrace(tIn, tOut);
			tOut.setName(tIn.getName());
			tOut.setOwnedContext(create(tIn.getOwnedContext()));
			createAll(tIn.getOwnedKey(), tOut.getOwnedKey());
			createAll(tIn.getOwnedOperations(), tOut.getOwnedOperations());
			createAll(tIn.getModelParameter(), tOut.getModelParameter());
			createAll(tIn.getRule(), tOut.getRule());
			createAll(tIn.getOwnedComments(), tOut.getOwnedComments());
			return tOut;
		}

		@Override
		public @NonNull SharedVariable visitSharedVariable(@NonNull SharedVariable vIn) {
			SharedVariable vOut = QVTrelationFactory.eINSTANCE.createSharedVariable();
			context.addTrace(vIn, vOut);
			vOut.setName(vIn.getName());
			createAll(vIn.getOwnedComments(), vOut.getOwnedComments());
			return vOut;
		}

		@Override
		public @NonNull TemplateVariable visitTemplateVariable(@NonNull TemplateVariable vIn) {
			TemplateVariable vOut = QVTrelationFactory.eINSTANCE.createTemplateVariable();
			context.addTrace(vIn, vOut);
			vOut.setName(vIn.getName());
			createAll(vIn.getOwnedComments(), vOut.getOwnedComments());
			return vOut;
		}

		@Override
		public @NonNull TypedModel visitTypedModel(@NonNull TypedModel tmIn) {
			TypedModel tmOut = QVTbaseFactory.eINSTANCE.createTypedModel();
			context.addTrace(tmIn, tmOut);
			String name = tmIn.getName();
			//			if (name == null) {
			//				name = QVTcoreUtil.MIDDLE_DOMAIN_NAME;
			//				context.setMiddleTypedModelTarget(tmOut);
			//			}
			tmOut.setName(name);
			tmOut.getUsedPackage().addAll(tmIn.getUsedPackage());
			createAll(tmIn.getOwnedComments(), tmOut.getOwnedComments());
			return tmOut;
		}
	}

	/**
	 * The AbstractUpdateVisitor resolves the references and creates the QVTtemplates, OCLExpressions omitted by the CreateVisitor..
	 *
	 * doXXX methods provide join points for derived implementations.
	 */
	protected static abstract class AbstractUpdateVisitor<@NonNull C extends AbstractQVTr2QVTr> extends AbstractExtendingQVTrelationVisitor<Object, C>
	{
		//		private Operation equalsOperation = null;

		public AbstractUpdateVisitor(@NonNull C context) {
			super(context);
		}

		/**
		 * Verify that variable references from the containment tree of outElement are to outElement's Resource.
		 *
		 * This may not be valid for multi-package transformations, but it's a very helpful debug for straightforward single package transformations.
		 */
		protected void checkOut(@NonNull Element pOut) {
			Resource eResource = pOut.eResource();
			assert eResource != null;
			for (TreeIterator<EObject> tit = pOut.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof VariableExp) {
					VariableDeclaration variable = ((VariableExp)eObject).getReferredVariable();
					Resource vResource = variable.eResource();
					//					assert vResource == eResource;
					if (vResource != eResource) {
						System.err.println(variable + " : " + NameUtil.debugFullName(variable) + " not in output resource.");
						vResource = variable.eResource();
					}
				}
			}
		}

		/**
		 * Copy the eIn tree replacing all references by their souce2targets mapping.
		 */
		protected @Nullable <T extends Element> T copy(@Nullable T eIn) {
			if (eIn == null) {
				return null;
			}
			assert context != null;
			EcoreUtil.Copier copier = new ExpressionCopier(context);
			@SuppressWarnings("unchecked") T eOut = (T) copier.copy(eIn);
			copier.copyReferences();
			context.addDebugCopies(copier);
			return eOut;
		}

		protected <T extends Element> void copyAll(/*@NonNull*/ List<T> sources, /*@NonNull*/ List<T> targets) {
			for (@SuppressWarnings("null")@NonNull T source : sources) {
				@Nullable T target = copy(source);
				assert target != null;
				targets.add(target);
			}
		}

		public @Nullable OCLExpression createCastCopy(@Nullable OCLExpression eIn, @Nullable Type toType) {
			if ((eIn == null) || (toType == null)) {
				return null;
			}
			OCLExpression eOut = copy(eIn);
			if (eOut == null) {
				return null;
			}
			Type eType = eOut.getType();
			StandardLibrary standardLibrary = context.getEnvironmentFactory().getStandardLibrary();
			if (eType.conformsTo(standardLibrary, toType)) {
				return eOut;
			}
			assert (toType.conformsTo(standardLibrary, eType));
			return context.createOperationCallExp(eOut, "oclAsType", context.createTypeExp(toType));
		}

		protected void doOverrides(@NonNull Relation rIn, @NonNull Relation rOut) {
			updateAllReferences(rIn.getOverrides(), rOut.getOverrides());
		}

		/*		public @NonNull Operation getEqualsOperation() {
			if (equalsOperation != null) {
				return equalsOperation;
			}
			for (Operation op : context.environmentFactory.getStandardLibrary().getOclAnyType().getOwnedOperations()) {
				if (op.getName().equals("=")) {
					equalsOperation = op;
					return op;
				}
			}
			throw new IllegalStateException();
		} */

		protected <T extends Element> void updateAllChildren(/*@NonNull*/ List<T> targets) {
			for (@SuppressWarnings("null")@NonNull T target : targets) {
				target.accept(this);
			}
		}

		protected <T extends Element> void updateAllReferences(/*@NonNull*/ List<T> sources, /*@NonNull*/ List<T> targets) {
			for (@SuppressWarnings("null")@NonNull T source : sources) {
				targets.add(context.equivalentTarget(source));
			}
		}

		protected void updateChild(@Nullable Element target) {
			if (target != null) {
				target.accept(this);
			}
		}

		@Override
		public @Nullable Object visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		/*		@Override
		public Element visitCollectionTemplateExp(@NonNull CollectionTemplateExp cOut) {
			CollectionTemplateExp cIn = context.equivalentSource(cOut);
			cOut.setReferredCollectionType(cIn.getReferredCollectionType());
			cOut.setBindsTo(context.equivalentTarget(cIn.getBindsTo()));
			cOut.setType(context.equivalentTarget(cIn.getType()));
			copyAll(cIn.getMember(), cOut.getMember());
			if (cIn.getRest() != null) {
				cOut.setRest(context.equivalentTarget(cIn.getRest()));
			}
			cOut.setWhere(copy(cIn.getWhere()));
			return null;
		} */

		@Override
		public @Nullable Object visitDomainPattern(@NonNull DomainPattern pOut) {
			DomainPattern pIn = context.equivalentSource(pOut);
			//			updateChild(pOut.getTemplateExpression());
			pOut.setTemplateExpression(copy(pIn.getTemplateExpression()));
			updateAllChildren(pOut.getPredicate());
			updateAllReferences(pIn.getBindsTo(), pOut.getBindsTo());
			return null;
		}

		@Override
		public @Nullable Element visitFunction(@NonNull Function fOut) {
			context.pushScope(fOut);
			Function fIn = context.equivalentSource(fOut);
			fOut.setQueryExpression(copy(fIn.getQueryExpression()));
			fOut.setType(fIn.getType());
			//			fOut.setTypeValue(fIn.getTypeValue());
			updateAllChildren(fOut.getOwnedParameters());
			context.popScope();
			return null;
		}

		@Override
		public @Nullable Object visitFunctionParameter(@NonNull FunctionParameter fpOut) {
			FunctionParameter fpIn = context.equivalentSource(fpOut);
			fpOut.setType(fpIn.getType());
			fpOut.setTypeValue(fpIn.getTypeValue());
			return null;
		}

		@Override
		public @Nullable Object visitKey(@NonNull Key kOut) {
			Key kIn = context.equivalentSource(kOut);
			kOut.setIdentifies(context.equivalentTarget(kIn.getIdentifies()));
			updateAllReferences(kIn.getPart(), kOut.getPart());
			updateAllReferences(kIn.getOppositePart(), kOut.getOppositePart());
			return null;
		}

		/*		@Override
		public Element visitObjectTemplateExp(@NonNull ObjectTemplateExp oOut) {
			ObjectTemplateExp oIn = context.equivalentSource(oOut);
			oOut.setReferredClass(oIn.getReferredClass());
			oOut.setBindsTo(context.equivalentTarget(oIn.getBindsTo()));
			oOut.setType(context.equivalentTarget(oIn.getType()));
			updateAllChildren(oOut.getPart());
			oOut.setWhere(copy(oIn.getWhere()));
			return null;
		} */

		@Override
		public @Nullable Object visitPackage(@NonNull Package pOut) {
			updateAllChildren(pOut.getOwnedClasses());
			updateAllChildren(pOut.getOwnedPackages());
			return null;
		}

		@Override
		public @Nullable Object visitParameter(@NonNull Parameter pOut) {
			Parameter pIn = context.equivalentSource(pOut);
			pOut.setName(pIn.getName());
			pOut.setIsRequired(pIn.isIsRequired());
			Type tVar = pIn.getType();
			pOut.setType(tVar);
			pOut.setTypeValue(pIn.getTypeValue());
			return pIn;
		}

		@Override
		public @Nullable Object visitPattern(@NonNull Pattern pOut) {
			Pattern pIn = context.equivalentSource(pOut);
			updateAllChildren(pOut.getPredicate());
			updateAllReferences(pIn.getBindsTo(), pOut.getBindsTo());
			return null;
		}

		@Override
		public @Nullable Object visitPredicate(@NonNull Predicate pOut) {
			Element pIn = context.equivalentSource(pOut);
			pOut.setConditionExpression(copy(((Predicate)pIn).getConditionExpression()));
			checkOut(pOut);
			return null;
		}

		/*		@Override
		public Element visitPropertyTemplateItem(@NonNull PropertyTemplateItem pOut) {
			PropertyTemplateItem pIn = context.equivalentSource(pOut);
			pOut.setReferredProperty(pIn.getReferredProperty());
			pOut.getResolvedProperty();
			pOut.setValue(copy(pIn.getValue()));
			return null;
		} */

		@Override
		public @NonNull Relation visitRelation(@NonNull Relation rOut) {
			context.pushScope(rOut);
			Relation rIn = context.equivalentSource(rOut);
			//			updateChild(rOut.getGuardPattern());
			//			updateChild(rOut.getBottomPattern());
			updateAllChildren(rOut.getVariable());
			updateAllChildren(rOut.getDomain());
			updateChild(rOut.getWhen());
			updateChild(rOut.getWhere());
			doOverrides(rIn, rOut);
			context.popScope();
			return rIn;
		}

		@Override
		public @Nullable Object visitRelationDomain(@NonNull RelationDomain dOut) {
			RelationDomain dIn = context.equivalentSource(dOut);
			TypedModel tmOut = context.equivalentTarget(QVTrelationUtil.getTypedModel(dIn));
			dOut.setTypedModel(tmOut);
			updateAllChildren(dOut.getPattern());
			updateAllReferences(dIn.getRootVariable(), dOut.getRootVariable());
			updateAllChildren(dOut.getDefaultAssignment());
			return null;
		}

		@Override
		public Element visitRelationDomainAssignment(@NonNull RelationDomainAssignment aOut) {
			RelationDomainAssignment aIn = context.equivalentSource(aOut);
			aOut.setVariable(context.equivalentTarget(aIn.getVariable()));
			aOut.setValueExp(copy(aIn.getValueExp()));
			return null;
		}

		@Override
		public @NonNull RelationModel visitRelationModel(@NonNull RelationModel mOut) {
			RelationModel mIn = context.equivalentSource(mOut);
			context.pushScope(mOut);
			updateAllChildren(mOut.getOwnedPackages());
			context.popScope();
			return mIn;
		}

		@Override
		public @NonNull RelationalTransformation visitRelationalTransformation(@NonNull RelationalTransformation tOut) {
			RelationalTransformation tIn = context.equivalentSource(tOut);
			updateChild(tOut.getOwnedContext());
			updateAllChildren(tOut.getOwnedKey());
			updateAllChildren(tOut.getOwnedOperations());
			updateAllChildren(tOut.getModelParameter());
			updateAllChildren(tOut.getRule());
			updateAllReferences(tIn.getSuperClasses(), tOut.getSuperClasses());
			return tIn;
		}

		@Override
		public @Nullable Object visitTypedModel(@NonNull TypedModel tmOut) {
			TypedModel tmIn = context.equivalentSource(tmOut);
			updateAllReferences(tmIn.getDependsOn(), tmOut.getDependsOn());
			return null;
		}

		@Override
		public @Nullable Object visitVariable(@NonNull Variable vOut) {
			Variable vIn = context.equivalentSource(vOut);
			vOut.setName(vIn.getName());
			vOut.setIsImplicit(vIn.isIsImplicit());
			vOut.setIsRequired(vIn.isIsRequired());
			Type tIn = vIn.getType();
			Type tVar = tIn != null ? context.equivalentTarget(tIn) : null;
			vOut.setType(tVar);
			Type tvIn = vIn.getTypeValue();
			vOut.setTypeValue(tvIn != null ? context.equivalentTarget(tvIn) : null);
			vOut.setOwnedInit(createCastCopy(vIn.getOwnedInit(), tVar));
			return vIn;
		}
	}

	protected final @NonNull AbstractCreateVisitor<@NonNull ?> createVisitor;
	protected final @NonNull AbstractUpdateVisitor<@NonNull ?> updateVisitor;
	//	private TypedModel middleTypedModelTarget = null;

	/**
	 * Forward traceability from a source object to its targets for the current mapping. Top level entries ourside a maping are indexed for the null mapping.
	 */
	private final @NonNull Map<@Nullable NamedElement, @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>>> scope2source2targets = new HashMap<>();

	private final @NonNull Stack<@NonNull NamedElement> scopeStack = new Stack<>();
	/**
	 * Reverse traceability from a target object to its source.
	 */
	private final @NonNull Map<@NonNull Element, @NonNull Element> target2source = new HashMap<>();

	/**
	 * Reverse traceability from a target object to its source.
	 */
	private final @NonNull Map<@NonNull Element, @NonNull Element> debugCopy2source = new HashMap<>();

	private @Nullable ASResource debugSource = null;
	private @Nullable ASResource debugTarget = null;

	/**
	 * Create a new QVTc to QVTc transformation using an environmentFactory.
	 *
	 * It may be used once by invoking transform(). Repeated transform() calls are beyond the current design.
	 */
	protected AbstractQVTr2QVTr(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
		this.createVisitor = createCreateVisitor();
		this.updateVisitor = createUpdateVisitor();
	}

	public void addDebugCopies(@NonNull Map<EObject, EObject> copier) {
		for (EObject eSource : copier.keySet()) {
			EObject eTarget = copier.get(eSource);
			assert (eSource != null) && (eTarget != null);
			debugCopy2source.put((Element)eTarget, (Element)eSource);
		}
	}

	/**
	 * Create a new trace for the given list of generated objects for the given
	 * context.
	 *
	 * @param source the source of the trace
	 * @param generated the list of generated objects
	 * @param context the context in which the trace is valid
	 */
	public void addTrace(@NonNull Element source, @NonNull Element target) {
		addTrace(source,  target, false);
	}
	public void addTrace(@NonNull Element source, @NonNull Element target, boolean replaceTargets) {
		target2source.put(target, source);
		//
		NamedElement scope = scopeStack.peek();
		Map<@NonNull Element, @NonNull List<@NonNull Element>> source2targets = scope2source2targets.get(scope);
		if (source2targets == null) {
			source2targets = new HashMap<>();
			scope2source2targets.put(scope, source2targets);
		}
		List<@NonNull Element> targets = source2targets.get(source);
		if (targets == null) {
			targets = new ArrayList<>();
			source2targets.put(source, targets);
		}
		if (replaceTargets) {
			targets.clear();
		}
		assert !targets.contains(target);
		targets.add(target);
	}

	protected @Nullable Element basicEquivalentSource(@Nullable Element target) {
		if (target == null) {
			return null;
		}
		assert target.eResource() != debugSource : "source element used for basicEquivalentSource " + target;
		return target2source.get(target);
	}

	protected abstract @NonNull AbstractCreateVisitor<@NonNull ?> createCreateVisitor();

	protected @NonNull Import createImport(@NonNull Import iIn) {
		Import iOut = createImport(iIn.getName(), ClassUtil.nonNull(iIn.getImportedNamespace()));
		addTrace(iIn, iOut);
		return iOut;
	}

	protected org.eclipse.ocl.pivot.@NonNull Package createPackage(org.eclipse.ocl.pivot.@NonNull Package pIn) {
		org.eclipse.ocl.pivot.Package pOut = createPackage(ClassUtil.nonNull(pIn.getName()), pIn.getNsPrefix(), pIn.getURI());
		addTrace(pIn, pOut);
		return pOut;
	}

	protected @NonNull DomainPattern createTracedDomainPattern(@NonNull Element source, @NonNull TemplateExp asTemplateExp) {
		DomainPattern asDomainPattern = createDomainPattern(asTemplateExp);
		addTrace(source, asDomainPattern);
		return asDomainPattern;
	}

	protected @NonNull Import createTracedImport(@NonNull Element source, @Nullable String name, @NonNull Namespace namespace) {
		Import asImport = createImport(name, namespace);
		addTrace(source, asImport);
		return asImport;
	}

	protected @NonNull ObjectTemplateExp createTracedObjectTemplateExp(@NonNull Element source, @NonNull TemplateVariable asTemplateVariable, org.eclipse.ocl.pivot.@NonNull Class asClass, boolean isRequired) {
		ObjectTemplateExp asObjectTemplateExp = createObjectTemplateExp(asTemplateVariable, asClass, isRequired);
		addTrace(source, asObjectTemplateExp);
		return asObjectTemplateExp;
	}

	protected @NonNull OperationCallExp createTracedOperationCallExp(@NonNull Element source, @NonNull OCLExpression asSourceExpression, @NonNull String opName, @NonNull OCLExpression... asArguments) {
		OperationCallExp asOperationCallExp = createOperationCallExp(asSourceExpression, opName, asArguments);
		addTrace(source, asOperationCallExp);
		return asOperationCallExp;
	}

	protected @NonNull Pattern createTracedPattern(@NonNull Element source) {
		Pattern asPattern = createPattern();
		addTrace(source, asPattern);
		return asPattern;
	}

	protected @NonNull Predicate createTracedPredicate(@NonNull Element source, @NonNull OCLExpression asConditionExpression) {
		Predicate asPredicate = createPredicate(asConditionExpression);
		addTrace(source, asPredicate);
		return asPredicate;
	}

	protected @NonNull PropertyTemplateItem createTracedPropertyTemplateItem(@NonNull Element source, @NonNull Property asProperty, @NonNull OCLExpression asExpression) {
		PropertyTemplateItem asPropertyTemplateItem = createPropertyTemplateItem(asProperty, asExpression);
		addTrace(source, asPropertyTemplateItem);
		return asPropertyTemplateItem;
	}

	protected @NonNull RelationCallExp createTracedRelationCallExp(@NonNull Element source, @NonNull Relation asRelation, @NonNull List<? extends @NonNull OCLExpression> asArguments) {
		RelationCallExp asInvocation = createRelationCallExp(asRelation, asArguments);
		addTrace(source, asInvocation);
		return asInvocation;
	}

	protected @NonNull RelationDomain createTracedRelationDomain(@NonNull Element source, @NonNull TypedModel asTypedModel) {
		RelationDomain asRelationDomain = createRelationDomain(asTypedModel);
		addTrace(source, asRelationDomain);
		return asRelationDomain;
	}

	protected @NonNull TemplateVariable createTracedTemplateVariable(@NonNull Element source, @NonNull String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression asInitExpression) {
		TemplateVariable asTemplateVariable = createTemplateVariable(name, asType, isRequired, asInitExpression);
		addTrace(source, asTemplateVariable);
		return asTemplateVariable;
	}

	protected @NonNull TypedModel createTracedTypedModel(@NonNull Element source, @NonNull String name, @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> usedPackages) {
		TypedModel asTypedModel = createTypedModel(name, usedPackages);
		addTrace(source, asTypedModel);
		return asTypedModel;
	}

	protected @NonNull VariableExp createTracedVariableExp(@NonNull Element source, @NonNull VariableDeclaration asVariable) {
		VariableExp asVariableExp = createVariableExp(asVariable);
		addTrace(source, asVariableExp);
		return asVariableExp;
	}

	protected abstract @NonNull AbstractUpdateVisitor<@NonNull ?> createUpdateVisitor();

	protected @NonNull <T extends Element> T equivalentSource(@NonNull T target) {
		assert target.eResource() != debugSource : "source element used for equivalentSource " + target;
		@SuppressWarnings("unchecked") T source = (T) target2source.get(target);
		assert source != null;
		return source;
	}

	protected @NonNull <T extends Element> T equivalentTarget(/*@NonNull*/ T source) {
		assert source != null;
		assert source.eResource() != debugTarget : "target element used for equivalentTarget " + source;
		List<@NonNull Element> targets = null;
		for (int i = scopeStack.size(); (targets == null) && (--i >= 0); ) {
			NamedElement scope = scopeStack.get(i);
			Map<@NonNull Element, @NonNull List<@NonNull Element>> source2targets = scope2source2targets.get(scope);
			if (source2targets != null) {
				targets = source2targets.get(source);
			}
		}
		if (targets != null) {
			//		    assert targets.size() == 1;			-- multiple entries are allowed, the first/primary entry is used
			@SuppressWarnings("unchecked") T target = (T)targets.get(0);
			assert target != null;
			return target;
		}
		else {
			return source;
		}
	}

	//	protected @NonNull TypedModel getMiddleTypedModelTarget() {
	//		assert middleTypedModelTarget != null;
	//		return middleTypedModelTarget;
	//	}

	//    protected @NonNull NamedElement getScope() {
	//    	return scopeStack.peek();
	//    }

	public void popScope() {
		scopeStack.pop();
	}

	public void pushScope(@NonNull NamedElement scope) {
		assert !scopeStack.contains(scope);
		scopeStack.push(scope);
	}

	//	protected void setDebugSource(@NonNull ASResource debugSource) {
	//		this.debugSource =  debugSource;
	//	}

	//	protected void setMiddleTypedModelTarget(@NonNull TypedModel middleTypedModelTarget) {
	//		this.middleTypedModelTarget = middleTypedModelTarget;
	//	}

	public void transform(@NonNull ASResource source, @NonNull ASResource target) throws IOException {
		debugSource = source;
		debugTarget = target;
		//
		//	Do the transformation for each RelationModel. First a createVisitor descent of the input, then an updateVisitor descent of the output.
		//
		for (EObject eContent : source.getContents()) {
			if (eContent instanceof RelationModel) {
				RelationModel mIn = (RelationModel) eContent;
				transform(mIn, target.getContents());
			}
		}
		//
		//	Debug code to conform that every output object is traceable to some input object.
		//
		for (TreeIterator<EObject> tit = target.getAllContents(); tit.hasNext(); ) {
			EObject eTarget = tit.next();
			EObject eSource = target2source.get(eTarget);
			EObject eCopied = debugCopy2source.get(eTarget);
			if ((eSource == null) && (eCopied == null)) {
				System.err.println("No source for " + eTarget.eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget)) + ":" + eTarget + " / " + eTarget.eContainer().eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget.eContainer())));
			}
		}

		// F I X M E the following lines should go obsolete
		//		List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, target);
		//		if (missingOperationCallSources != null) {
		//			System.err.println("Missing OperationCallExp sources  were fixed up for '" + target.getURI() + "'");
		//		}
	}

	protected void transform(@NonNull RelationModel mIn, @NonNull List<@NonNull EObject> mOuts) throws IOException {
		try {
			RelationModel mOut = (RelationModel) mIn.accept(createVisitor);
			assert mOut != null;
			mOuts.add(mOut);
			mOut.accept(updateVisitor);
		}
		catch (WrappedException e) {
			Throwable t = e.getCause();
			if (t instanceof IOException) {
				throw (IOException)t;
			}
			throw e;
		}
	}
}
