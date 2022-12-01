/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterVariable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.BottomVariable;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardVariable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.AbstractExtendingQVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

/**
 * AbstractQVTc2QVTc provides shared functionality for steps in the QVTc/QVTu/QVTm chain.
 * <br>
 * For the upper levels a visitXXX supports an override to provide a non-uniform conversion.
 * For the lower levels, in particular an ExpressionInOCL, and EcoreUtil copier is used.
 * <br>
 * FIXME Some simplification/regularity could be provided by making the EcoreUtil shallow copy the default visit.
 */
public abstract class AbstractQVTc2QVTc extends QVTcoreHelper
{
	/**
	 * An ExpressionCopier deep copies an OCLExpression tree, exploiting the forward traceability of context to
	 * update references. Ambiguities should be resolved by performing the copy with respect to an appropriate
	 * stack of resolution scopes.
	 */
	@SuppressWarnings("serial")
	protected static class ExpressionCopier extends EcoreUtil.Copier
	{
		private final @NonNull AbstractQVTc2QVTc context;

		public ExpressionCopier(@NonNull AbstractQVTc2QVTc context) {
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
	 * The CreateVisitor performs the mostly 1:1 creation of the QVTm output tree from the QVTm input tree.
	 *
	 * References are left unresolved. OCLExpressions are not copied. doXXX methods provide join points for derived implementations.
	 */
	protected static abstract class AbstractCreateVisitor<@NonNull C extends AbstractQVTc2QVTc> extends AbstractExtendingQVTcoreVisitor<Element, C>
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

		protected void doAssignments(@NonNull BottomPattern bIn, @NonNull BottomPattern bOut) {
			createAll(bIn.getAssignment(), bOut.getAssignment());
		}

		protected void doLocalMappings(@NonNull Mapping mIn, @NonNull Mapping mOut) {
			createAll(mIn.getLocal(), mOut.getLocal());
		}

		protected void doMapping(@NonNull Mapping mIn, @NonNull Mapping mOut) {
			context.addTrace(mIn, mOut);
			mOut.setName(mIn.getName());
			mOut.setIsAbstract(mIn.isIsAbstract());
			mOut.setGuardPattern(create(mIn.getGuardPattern()));
			mOut.setBottomPattern(create(mIn.getBottomPattern()));
			createAll(mIn.getDomain(), mOut.getDomain());
			doLocalMappings(mIn, mOut);
			//			createAll(mIn.getSpecification(), mOut.getSpecification());
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
		}

		protected void doRealizedVariables(@NonNull BottomPattern bIn, @NonNull BottomPattern bOut) {
			createAll(bIn.getRealizedVariable(), bOut.getRealizedVariable());
		}

		protected void doRules(@NonNull Transformation tIn, @NonNull Transformation tOut) {
			createAll(tIn.getRule(), tOut.getRule());
		}

		//		public @NonNull EnvironmentFactory getEnvironmentFactory() {
		//			return context.getEnvironmentFactory();
		//		}

		@Override
		public @Nullable Element visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		@Override
		public @NonNull BottomPattern visitBottomPattern(@NonNull BottomPattern bIn) {
			BottomPattern bOut = QVTcoreFactory.eINSTANCE.createBottomPattern();
			context.addTrace(bIn, bOut);
			doAssignments(bIn, bOut);
			createAll(bIn.getPredicate(), bOut.getPredicate());
			doRealizedVariables(bIn, bOut);
			createAll(bIn.getOwnedVariables(), bOut.getOwnedVariables());
			createAll(bIn.getOwnedComments(), bOut.getOwnedComments());
			return bOut;
		}

		@Override
		public @NonNull BottomVariable visitBottomVariable(@NonNull BottomVariable vIn) {
			BottomVariable vOut = QVTcoreFactory.eINSTANCE.createBottomVariable();
			context.addTrace(vIn, vOut);
			vOut.setName(vIn.getName());
			createAll(vIn.getOwnedComments(), vOut.getOwnedComments());
			return vOut;
		}

		@Override
		public @Nullable Element visitComment(@NonNull Comment cIn) {
			Comment cOut = PivotFactory.eINSTANCE.createComment();
			context.addTrace(cIn, cOut);
			cOut.setBody(cIn.getBody());
			createAll(cIn.getOwnedComments(), cOut.getOwnedComments());
			return cOut;
		}

		@Override
		public @NonNull CoreDomain visitCoreDomain(@NonNull CoreDomain dIn) {
			CoreDomain dOut = QVTcoreFactory.eINSTANCE.createCoreDomain();
			context.addTrace(dIn, dOut);
			dOut.setIsCheckable(dIn.isIsCheckable());
			dOut.setIsEnforceable(dIn.isIsEnforceable());
			dOut.setGuardPattern(create(dIn.getGuardPattern()));
			dOut.setBottomPattern(create(dIn.getBottomPattern()));
			createAll(dIn.getOwnedComments(), dOut.getOwnedComments());
			return dOut;
		}

		@Override
		public @NonNull CoreModel visitCoreModel(@NonNull CoreModel mIn) {
			CoreModel mOut = QVTcoreFactory.eINSTANCE.createCoreModel();
			context.pushScope(mOut);
			context.addTrace(mIn, mOut);
			createAll(mIn.getOwnedImports(), mOut.getOwnedImports());
			createAll(mIn.getOwnedPackages(), mOut.getOwnedPackages());
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
			context.popScope();
			return mOut;
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
			//	fOut.setBodyExpression(create(fIn.getBodyExpression())); -- copied during reference pass
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
		public @NonNull GuardPattern visitGuardPattern(@NonNull GuardPattern gIn) {
			GuardPattern gOut = QVTcoreFactory.eINSTANCE.createGuardPattern();
			context.addTrace(gIn, gOut);
			createAll(gIn.getPredicate(), gOut.getPredicate());
			createAll(gIn.getOwnedVariables(), gOut.getOwnedVariables());
			createAll(gIn.getOwnedComments(), gOut.getOwnedComments());
			return gOut;
		}

		@Override
		public @NonNull GuardVariable visitGuardVariable(@NonNull GuardVariable vIn) {
			GuardVariable vOut = QVTcoreFactory.eINSTANCE.createGuardVariable();
			context.addTrace(vIn, vOut);
			vOut.setName(vIn.getName());
			createAll(vIn.getOwnedComments(), vOut.getOwnedComments());
			return vOut;
		}

		@Override
		public @Nullable Element visitImport(@NonNull Import iIn) {
			Import iOut = context.createImport(iIn);
			createAll(iIn.getOwnedComments(), iOut.getOwnedComments());
			return iOut;
		}

		@Override
		public @Nullable Element visitMapping(@NonNull Mapping mIn) {
			Mapping mOut = QVTcoreFactory.eINSTANCE.createMapping();
			context.pushScope(mOut);
			doMapping(mIn, mOut);
			context.popScope();
			return mOut;
		}

		@Override
		public final @Nullable Element visitNavigationAssignment(@NonNull NavigationAssignment object) {			// Override must be of derived classes
			return visiting(object);
		}

		@Override
		public @Nullable Element visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment paIn) {
			OppositePropertyAssignment paOut = QVTcoreFactory.eINSTANCE.createOppositePropertyAssignment();
			context.addTrace(paIn, paOut);
			if (paIn.eIsSet(QVTcorePackage.Literals.ASSIGNMENT__IS_DEFAULT)) {
				paOut.setIsDefault(paIn.isIsDefault());
			}
			if (paIn.eIsSet(QVTcorePackage.Literals.ASSIGNMENT__IS_PARTIAL)) {
				paOut.setIsPartial(paIn.isIsPartial());
			}
			paOut.setTargetProperty(paIn.getTargetProperty());
			createAll(paIn.getOwnedComments(), paOut.getOwnedComments());
			return paOut;
		}

		@Override
		public @Nullable Element visitPackage(@NonNull Package pIn) {
			if (Orphanage.isOrphanage(pIn)) {
				return null;
			}
			Package pOut = context.createPackage(pIn);
			createAll(pIn.getOwnedClasses(), pOut.getOwnedClasses());
			createAll(pIn.getOwnedPackages(), pOut.getOwnedPackages());
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
			return pOut;
		}

		@Override
		public @NonNull Parameter visitParameter(@NonNull Parameter vIn) {
			Parameter vOut = PivotFactory.eINSTANCE.createParameter();
			context.addTrace(vIn, vOut);
			vOut.setName(vIn.getName());
			createAll(vIn.getOwnedComments(), vOut.getOwnedComments());
			return vOut;
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
		public @Nullable Element visitPredicate(@NonNull Predicate pIn) {
			Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
			context.addTrace(pIn, pOut);
			// The condition expression is copied during update once replacement variables exist.
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
			return pOut;
		}

		@Override
		public @Nullable Element visitPropertyAssignment(@NonNull PropertyAssignment paIn) {
			PropertyAssignment paOut = QVTcoreFactory.eINSTANCE.createPropertyAssignment();
			context.addTrace(paIn, paOut);
			if (paIn.eIsSet(QVTcorePackage.Literals.ASSIGNMENT__IS_DEFAULT)) {
				paOut.setIsDefault(paIn.isIsDefault());
			}
			if (paIn.eIsSet(QVTcorePackage.Literals.ASSIGNMENT__IS_PARTIAL)) {
				paOut.setIsPartial(paIn.isIsPartial());
			}
			paOut.setTargetProperty(paIn.getTargetProperty());
			createAll(paIn.getOwnedComments(), paOut.getOwnedComments());
			return paOut;
		}

		@Override
		public @NonNull Variable visitRealizedVariable(@NonNull RealizedVariable rvIn) {
			Variable rvOut = QVTcoreFactory.eINSTANCE.createRealizedVariable();
			context.addTrace(rvIn, rvOut);
			rvOut.setName(rvIn.getName());
			rvOut.setIsImplicit(rvIn.isIsImplicit());
			rvOut.setType(rvIn.getType());
			createAll(rvIn.getOwnedComments(), rvOut.getOwnedComments());
			return rvOut;
		}

		@Override
		public @NonNull Transformation visitTransformation(@NonNull Transformation tIn) {
			Transformation tOut = QVTbaseFactory.eINSTANCE.createTransformation();
			context.addTrace(tIn, tOut);
			tOut.setName(tIn.getName());
			tOut.setOwnedContext(create(tIn.getOwnedContext()));
			createAll(tIn.getOwnedOperations(), tOut.getOwnedOperations());
			createAll(tIn.getModelParameter(), tOut.getModelParameter());
			if (QVTbaseUtil.basicGetPrimitiveTypedModel(tIn) == null) {
				tOut.getModelParameter().add(0, new QVTcoreHelper(context.getEnvironmentFactory()).createPrimitiveTypedModel());
			}
			doRules(tIn, tOut);
			createAll(tIn.getOwnedComments(), tOut.getOwnedComments());
			return tOut;
		}

		@Override
		public @NonNull TypedModel visitTypedModel(@NonNull TypedModel tmIn) {
			TypedModel tmOut = QVTbaseFactory.eINSTANCE.createTypedModel();
			context.addTrace(tmIn, tmOut);
			String name = tmIn.getName();
			if (name == null) {
				//				name = QVTcoreUtil.MIDDLE_DOMAIN_NAME;
				context.setMiddleTypedModelTarget(tmOut);
			}
			tmOut.setName(name);
			tmOut.getUsedPackage().addAll(tmIn.getUsedPackage());
			tmOut.setIsPrimitive(tmIn.isIsPrimitive());
			tmOut.setIsThis(tmIn.isIsThis());
			tmOut.setIsTrace(tmIn.isIsTrace() || (name == null));
			createAll(tmIn.getOwnedComments(), tmOut.getOwnedComments());
			return tmOut;
		}

		@Override
		public @Nullable Element visitVariableAssignment(@NonNull VariableAssignment vaIn) {
			VariableAssignment vaOut = QVTcoreFactory.eINSTANCE.createVariableAssignment();
			context.addTrace(vaIn, vaOut);
			vaOut.setIsDefault(vaIn.isIsDefault());
			createAll(vaIn.getOwnedComments(), vaOut.getOwnedComments());
			return vaOut;
		}
	}

	/**
	 * The UpdateVisitor resolves the references and creates the OCLExpressions omitted by the CreateVisitor..
	 */
	protected static abstract class AbstractUpdateVisitor<@NonNull C extends AbstractQVTc2QVTc> extends AbstractExtendingQVTcoreVisitor<Object, C>
	{
		private Operation equalsOperation = null;
		protected final @NonNull QVTcoreHelper helper;

		public AbstractUpdateVisitor(@NonNull C context) {
			super(context);
			helper = context;
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
						System.out.println(NameUtil.debugSimpleName(pOut) + " in " + eResource.getURI());			// XXX
						System.out.println(NameUtil.debugSimpleName(variable) + " in " + vResource.getURI());			// XXX
						QVTruntimeUtil.errPrintln(variable + " : " + NameUtil.debugFullName(variable) + " not in output resource.");
						vResource = variable.eResource();
					}
				}
			}
		}

		protected Object convertToPredicate(@NonNull NavigationAssignment paIn, @NonNull Predicate pOut) {
			OCLExpression slotExpression = copy(paIn.getSlotExpression());
			Property targetProperty = QVTcoreUtil.getTargetProperty(paIn);
			assert (slotExpression != null) && (targetProperty != null);
			OCLExpression valueExpression = copy(paIn.getValue());
			assert valueExpression != null;
			NavigationCallExp propertyCallExp = helper.createNavigationCallExp(slotExpression, targetProperty);
			context.addTrace(paIn, propertyCallExp);
			propertyCallExp.eUnset(PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED);		// FIXME redundant compatibility
			Operation equalsOperation = getEqualsOperation();
			OperationCallExp operationCallExp = helper.createOperationCallExp(propertyCallExp, equalsOperation, Collections.singletonList(valueExpression));
			context.addTrace(paIn, operationCallExp);
			operationCallExp.setName(equalsOperation.getName());		// FIXME redundant compatibility
			pOut.setConditionExpression(operationCallExp);
			checkOut(pOut);
			return null;
		}

		protected @Nullable Object convertToVariableAssignment(@NonNull NavigationAssignment paIn, @NonNull VariableAssignment vaOut) {
			OCLExpression veIn = paIn.getValue();
			assert veIn instanceof VariableExp;
			VariableDeclaration vIn = ((VariableExp)veIn).getReferredVariable();
			assert vIn instanceof Variable;
			Variable vOut = context.equivalentTarget((Variable)vIn);
			vaOut.setTargetVariable(vOut);
			OCLExpression slotExpression = copy(paIn.getSlotExpression());
			Property targetProperty = QVTcoreUtil.getTargetProperty(paIn);
			assert (slotExpression != null) && (targetProperty != null);
			NavigationCallExp propertyCallExp = helper.createNavigationCallExp(slotExpression, targetProperty);
			context.addTrace(paIn, propertyCallExp);
			propertyCallExp.eUnset(PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED);		// FIXME redundant compatibility
			vaOut.setValue(propertyCallExp);
			checkOut(vaOut);
			return null;
		}

		/**
		 * Copy the eIn tree replacing all references by their souce2targets mapping, using a non-null sibling to prefer a target
		 * in the same containing mapping.
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
			return helper.createOperationCallExp(eOut, "oclAsType", helper.createTypeExp(toType));
		}

		protected @NonNull Mapping doMapping(@NonNull Mapping mOut) {
			Mapping mIn = context.equivalentSource(mOut);
			updateChild(mOut.getGuardPattern());
			updateChild(mOut.getBottomPattern());
			updateAllChildren(mOut.getDomain());
			updateAllChildren(mOut.getLocal());
			updateAllReferences(mIn.getSpecification(), mOut.getSpecification());
			return mIn;
		}

		public @NonNull Operation getEqualsOperation() {
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
		}

		protected <T extends Element> void updateAllChildren(/*@NonNull*/ List<T> targets) {
			for (@SuppressWarnings("null")@NonNull T target : targets) {
				target.accept(this);
			}
		}

		protected <T extends Element> void updateAllReferences(/*@NonNull*/ List<T> sources, /*@NonNull*/ List<T> targets) {
			targets.clear();
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

		@Override
		public @Nullable Object visitBottomPattern(@NonNull BottomPattern bOut) {
			updateAllChildren(bOut.getAssignment());
			updateAllChildren(bOut.getPredicate());
			updateAllChildren(bOut.getRealizedVariable());
			updateAllChildren(bOut.getOwnedVariables());
			return null;
		}

		@Override
		public @Nullable Object visitCoreDomain(@NonNull CoreDomain dOut) {
			Element dIn = context.basicEquivalentSource(dOut);
			TypedModel tmOut;
			if (dIn instanceof CoreDomain) {
				tmOut = context.equivalentTarget(QVTcoreUtil.getTypedModel((CoreDomain)dIn));
			}
			else {
				tmOut = context.getMiddleTypedModelTarget();
			}
			dOut.setTypedModel(tmOut);
			dOut.setName(tmOut.getName());
			updateChild(dOut.getGuardPattern());
			updateChild(dOut.getBottomPattern());
			return null;
		}

		@Override
		public @Nullable Object visitCoreModel(@NonNull CoreModel mOut) {
			@SuppressWarnings("unused")
			CoreModel mIn = context.equivalentSource(mOut);
			context.pushScope(mOut);
			updateAllChildren(mOut.getOwnedPackages());
			context.popScope();
			return null;
		}

		@Override
		public @Nullable Element visitFunction(@NonNull Function fOut) {
			context.pushScope(fOut);
			Function fIn = context.equivalentSource(fOut);
			LanguageExpression xIn = fIn.getBodyExpression();
			LanguageExpression xOut = copy(xIn);
			fOut.setBodyExpression(xOut);
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
		public @Nullable Object visitGuardPattern(@NonNull GuardPattern gOut) {
			updateAllChildren(gOut.getPredicate());
			updateAllChildren(gOut.getOwnedVariables());
			for (VariableDeclaration vOut : gOut.getOwnedVariables()) {
				assert !(vOut instanceof RealizedVariable);
			}
			return null;
		}

		@Override
		public @NonNull Mapping visitMapping(@NonNull Mapping mOut) {
			context.pushScope(mOut);
			Mapping mIn = doMapping(mOut);
			context.popScope();
			return mIn;
		}

		@Override
		public final Object visitNavigationAssignment(@NonNull NavigationAssignment object) {			// Override must be of derived classes
			return visiting(object);
		}

		@Override
		public @Nullable Element visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment paOut) {
			OppositePropertyAssignment paIn = context.equivalentSource(paOut);
			paOut.setSlotExpression(copy(paIn.getSlotExpression()));
			paOut.setValue(copy(paIn.getValue()));
			checkOut(paOut);
			return paIn;
		}

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
			//			Type tVar = pIn.getType();
			//			pOut.setType(tVar);
			//			pOut.setTypeValue(pIn.getTypeValue());
			Type tIn = pIn.getType();
			Type tVar = tIn != null ? context.equivalentTarget(tIn) : null;
			pOut.setType(tVar);
			Type tvIn = pIn.getTypeValue();
			pOut.setTypeValue(tvIn != null ? context.equivalentTarget(tvIn) : null);
			return pIn;
		}

		@Override
		public @Nullable Object visitParameterVariable(@NonNull ParameterVariable pvOut) {
			ParameterVariable pvIn = (ParameterVariable)super.visitParameterVariable(pvOut);
			Parameter rpIn = pvIn.getRepresentedParameter();
			pvOut.setRepresentedParameter(rpIn != null ? context.equivalentTarget(rpIn) : null);
			return pvIn;
		}

		//
		//	Predicates that were PropertyAssignments need a comparison to be synthesized.
		//
		@Override
		public @Nullable Object visitPredicate(@NonNull Predicate pOut) {
			Element pIn = context.equivalentSource(pOut);
			if (pIn instanceof NavigationAssignment) {
				return convertToPredicate((NavigationAssignment)pIn, pOut);
			}
			else if (pIn instanceof Predicate) {
				pOut.setConditionExpression(copy(((Predicate)pIn).getConditionExpression()));
				checkOut(pOut);
				return null;
			}
			else {
				return visiting(pOut);
			}
		}

		@Override
		public @Nullable Element visitPropertyAssignment(@NonNull PropertyAssignment paOut) {
			PropertyAssignment paIn = context.equivalentSource(paOut);
			paOut.setSlotExpression(copy(paIn.getSlotExpression()));
			paOut.setValue(copy(paIn.getValue()));
			checkOut(paOut);
			return paIn;
		}

		@Override
		public @Nullable Object visitRealizedVariable(@NonNull RealizedVariable rvOut) {
			RealizedVariable rvIn = context.equivalentSource(rvOut);
			rvOut.setOwnedInit(copy(rvIn.getOwnedInit()));
			return rvIn;
		}

		@Override
		public @Nullable Transformation visitTransformation(@NonNull Transformation tOut) {
			Transformation tIn = context.equivalentSource(tOut);
			updateChild(tOut.getOwnedContext());
			updateAllChildren(tOut.getOwnedOperations());
			updateAllChildren(tOut.getModelParameter());
			updateAllChildren(tOut.getRule());
			updateAllReferences(tIn.getSuperClasses(), tOut.getSuperClasses());
			return null;
		}

		@Override
		public @Nullable Object visitTypedModel(@NonNull TypedModel tmOut) {
			TypedModel tmIn = context.equivalentSource(tmOut);
			updateAllReferences(tmIn.getDependsOn(), tmOut.getDependsOn());
			updateAllReferences(tmIn.getIterates(), tmOut.getIterates());
			updateAllReferences(tmIn.getUsedPackage(), tmOut.getUsedPackage());
			return null;
		}

		@Override
		public @Nullable Object visitVariable(@NonNull Variable vOut) {
			Variable vIn = context.equivalentSource(vOut);
			vOut.setName(vIn.getName());
			vOut.setIsImplicit(vIn.isIsImplicit());
			vOut.setIsRequired(vIn.isIsRequired());
			Type tIn = vIn.getType();
			Type tOut = tIn != null ? context.equivalentTarget(tIn) : null;
			vOut.setType(tOut);
			Type tvIn = vIn.getTypeValue();
			vOut.setTypeValue(tvIn != null ? context.equivalentTarget(tvIn) : null);
			vOut.setOwnedInit(createCastCopy(vIn.getOwnedInit(), tOut));
			//	Parameter rpIn = vIn.getRepresentedParameter();
			//	vOut.setRepresentedParameter(rpIn != null ? context.equivalentTarget(rpIn) : null);		// FIXME Migrate to just ParameterVariable
			return vIn;
		}

		@Override
		public @Nullable Object visitVariableAssignment(@NonNull VariableAssignment vaOut) {
			VariableAssignment vaIn = context.equivalentSource(vaOut);
			vaOut.setTargetVariable(context.equivalentTarget(vaIn.getTargetVariable()));
			vaOut.setValue(copy(vaIn.getValue()));
			return vaIn;
		}
	}

	protected final @NonNull AbstractCreateVisitor<@NonNull ?> createVisitor;
	protected final @NonNull AbstractUpdateVisitor<@NonNull ?> updateVisitor;
	private TypedModel middleTypedModelTarget = null;

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

	private @Nullable Resource debugSource = null;
	private @Nullable Resource debugTarget = null;

	/**
	 * Create a new QVTc to QVTc transformation using an environmentFactory.
	 *
	 * It may be used once by invoking transform(). Repeated transform() calls are beyond the current design.
	 */
	protected AbstractQVTc2QVTc(@NonNull EnvironmentFactory environmentFactory) {
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
		assert !targets.contains(target);
		targets.add(target);
	}


	//
	//	Debug code to confirm that the output references refer to output elements, not inputs.
	//
	protected boolean assertOutputIsSelfSufficient(@NonNull Resource targetResource, @NonNull Resource sourceResource) {
		assert targetResource != sourceResource;
		Map<EObject, Collection<Setting>> crossReferenceMap = EcoreUtil.CrossReferencer.find(targetResource.getContents());
		for (Map.Entry<EObject, Collection<Setting>> entry : crossReferenceMap.entrySet()) {
			Collection<Setting> settings = entry.getValue();
			EObject eTarget = entry.getKey();
			Resource eTargetResource = eTarget.eResource();
			if (eTargetResource == sourceResource) {
				for (Setting setting : settings) {
					EStructuralFeature eStructuralFeature = setting.getEStructuralFeature();
					EObject eSource = setting.getEObject();
					QVTruntimeUtil.errPrintln("source resource for " + eSource.eClass().getName() + "@" + Integer.toString(System.identityHashCode(eSource)) + "::" + eStructuralFeature.getName() + " : " + eTarget.eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget)));
				}
			}
			else if (eTargetResource != targetResource) {
				//	QVTruntimeUtil.errPrintln("Wrong2 resource for target " + eTarget.eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget)) + ":" + eTarget + " / " + eTarget.eContainer().eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget.eContainer())));
			}
		}
		return true;
	}

	//
	//	Debug code to confirm that every output object is traceable to some input object.
	//
	protected boolean assertOutputIsTraceable(@NonNull Resource target) {
		for (TreeIterator<EObject> tit = target.getAllContents(); tit.hasNext(); ) {
			EObject eTarget = tit.next();
			EObject eSource = target2source.get(eTarget);
			EObject eCopied = debugCopy2source.get(eTarget);
			if ((eSource == null) && (eCopied == null)) {
				QVTruntimeUtil.errPrintln("No source for " + eTarget.eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget)) + ":" + eTarget + " / " + eTarget.eContainer().eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget.eContainer())));
			}
		}
		return true;
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
		if (source instanceof ParameterVariable) {
			getClass();		// XXX
		}
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

	protected @NonNull TypedModel getMiddleTypedModelTarget() {
		assert middleTypedModelTarget != null;
		return middleTypedModelTarget;
	}

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

	protected void setDebugSource(@NonNull Resource debugSource) {
		this.debugSource =  debugSource;
	}

	protected void setMiddleTypedModelTarget(@NonNull TypedModel middleTypedModelTarget) {
		this.middleTypedModelTarget = middleTypedModelTarget;
	}

	public void transform(@NonNull Resource source, @NonNull Resource target) throws IOException {
		debugSource = source;
		debugTarget = target;
		//
		//	Do the transformation for each CoreModel. First a createVisitor descent of the input, then an updateVisitor descent of the output.
		//
		for (EObject eContent : source.getContents()) {
			if (eContent instanceof CoreModel) {
				CoreModel mIn = (CoreModel) eContent;
				transform(mIn, target.getContents());
			}
		}
		assert assertOutputIsSelfSufficient(target, source);
		assert assertOutputIsTraceable(target);

		// FIXME the following lines should go obsolete
		List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, target);
		if (missingOperationCallSources != null) {
			QVTruntimeUtil.errPrintln("Missing OperationCallExp sources were fixed up for '" + target.getURI() + "'");
		}
	}

	protected void transform(@NonNull CoreModel mIn, @NonNull List<@NonNull EObject> mOuts) throws IOException {
		try {
			CoreModel mOut = (CoreModel) mIn.accept(createVisitor);
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
