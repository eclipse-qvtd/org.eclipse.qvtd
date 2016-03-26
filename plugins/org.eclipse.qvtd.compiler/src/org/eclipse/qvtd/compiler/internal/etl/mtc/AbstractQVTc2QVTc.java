/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial research
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl.mtc;

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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.util.AbstractExtendingQVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;

/**
 * AbstractQVTc2QVTc provides shared functionality for steps in the QVTC/QVTu/QVTm chain. 
 */
public abstract class AbstractQVTc2QVTc
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
	 * The CreateVisitor performs the mostly 1:1 creation of the QVTp output tree from the QVTm input tree.
	 * 
	 * References are left unresolved. OCLExpressions are not copied. doXXX methods provide join points for derived implementations.
	 */
    protected static abstract class AbstractCreateVisitor<C extends AbstractQVTc2QVTc> extends AbstractExtendingQVTcoreVisitor<Element, C>
    {
		public AbstractCreateVisitor(@NonNull C context) {
			super(context);
		}

		protected <T extends Element> @Nullable T create(@Nullable T source) {
			if (source == null) {
				return null;
			}
	        @SuppressWarnings("unchecked") @Nullable T target = (T) source.accept(this);
	        return target;
		}

		protected <T extends Element> void createAll(/*@NonNull*/ Iterable<T> sources, /*@NonNull*/ List<? super T> targets) {
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
			BottomPattern bOut = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			context.addTrace(bIn, bOut);
			doAssignments(bIn, bOut);
			createAll(bIn.getPredicate(), bOut.getPredicate());
			doRealizedVariables(bIn, bOut);
			createAll(bIn.getVariable(), bOut.getVariable());
			createAll(bIn.getOwnedComments(), bOut.getOwnedComments());
	        return bOut;
	    }

		@Override
		public @Nullable Element visitComment(@NonNull Comment cIn) {
			@SuppressWarnings("null")@NonNull Comment cOut = PivotFactory.eINSTANCE.createComment();
			context.addTrace(cIn, cOut);
			cOut.setBody(cIn.getBody());
			createAll(cIn.getOwnedComments(), cOut.getOwnedComments());
			return cOut;
		}

		@Override
		public @NonNull CoreDomain visitCoreDomain(@NonNull CoreDomain dIn) {
			CoreDomain dOut = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
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
		    @NonNull CoreModel mOut = QVTcoreFactory.eINSTANCE.createCoreModel();
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
			@NonNull Function fOut = QVTbaseFactory.eINSTANCE.createFunction();
			context.addTrace(fIn, fOut);				// Global
			context.pushScope(fOut);
			fOut.setName(fIn.getName());
			fOut.setIsRequired(fIn.isIsRequired());
			fOut.setIsStatic(fIn.isIsStatic());
			fOut.setIsTypeof(fIn.isIsTypeof());
			createAll(fIn.getOwnedParameters(), fOut.getOwnedParameters());
			createAll(fIn.getOwnedComments(), fOut.getOwnedComments());
			context.popScope();
		    return fOut;
		}

		@Override
		public @NonNull FunctionParameter visitFunctionParameter(@NonNull FunctionParameter fpIn) {
			@NonNull FunctionParameter fpOut = QVTbaseFactory.eINSTANCE.createFunctionParameter();
			context.addTrace(fpIn, fpOut);
			fpOut.setName(fpIn.getName());
			fpOut.setIsRequired(fpIn.isIsRequired());
			fpOut.setIsTypeof(fpIn.isIsTypeof());
			createAll(fpIn.getOwnedComments(), fpOut.getOwnedComments());
			return fpOut;
		}

		@Override
		public @NonNull GuardPattern visitGuardPattern(@NonNull GuardPattern gIn) {
			GuardPattern gOut = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			context.addTrace(gIn, gOut);
			createAll(gIn.getPredicate(), gOut.getPredicate());
			createAll(gIn.getVariable(), gOut.getVariable());
			createAll(gIn.getOwnedComments(), gOut.getOwnedComments());
	        return gOut;
	    }

		@Override
		public @Nullable Element visitImport(@NonNull Import iIn) {
		    @SuppressWarnings("null")@NonNull Import iOut = PivotFactory.eINSTANCE.createImport();
		    context.addTrace(iIn, iOut);
		    iOut.setName(iIn.getName());
		    iOut.setImportedNamespace(iIn.getImportedNamespace());
			createAll(iIn.getOwnedComments(), iOut.getOwnedComments());
	        return iOut;
		}

		@Override
		public @Nullable Element visitMapping(@NonNull Mapping mIn) {
			@NonNull Mapping mOut = QVTcoreFactory.eINSTANCE.createMapping();
			context.pushScope(mOut);
			doMapping(mIn, mOut);
			context.popScope();
	        return mOut;
		}

		@Override
		public @Nullable Element visitPackage(@NonNull Package pIn) {
			if (PivotConstants.ORPHANAGE_URI.equals(pIn.getURI())) {
				return null;
			}
		    @SuppressWarnings("null")@NonNull Package pOut = PivotFactory.eINSTANCE.createPackage();
		    context.addTrace(pIn, pOut);
		    pOut.setName(pIn.getName());
		    pOut.setURI(pIn.getURI());
		    createAll(pIn.getOwnedClasses(), pOut.getOwnedClasses());
		    createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
		    return pOut;
		}

		@Override
		public @Nullable Element visitPredicate(@NonNull Predicate pIn) {
			@NonNull Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
	        context.addTrace(pIn, pOut);
	        // The condition expression is copied during update once replacement variables exist.
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
	        return pOut;
	    }

		@Override
		public @Nullable Element visitPropertyAssignment(@NonNull PropertyAssignment paIn) {
			PropertyAssignment paOut = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			context.addTrace(paIn, paOut);
			if (paIn.eIsSet(QVTcoreBasePackage.Literals.ASSIGNMENT__IS_DEFAULT)) {
				paOut.setIsDefault(paIn.isIsDefault());
			}
			paOut.setTargetProperty(paIn.getTargetProperty());
			createAll(paIn.getOwnedComments(), paOut.getOwnedComments());
	        return paOut;
		}

		@Override
		public @NonNull Variable visitRealizedVariable(@NonNull RealizedVariable rvIn) {
	        Variable rvOut = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
 	        context.addTrace(rvIn, rvOut);
			rvOut.setName(rvIn.getName());
			rvOut.setIsImplicit(rvIn.isIsImplicit());
			rvOut.setType(rvIn.getType());
			createAll(rvIn.getOwnedComments(), rvOut.getOwnedComments());
	        return rvOut;
	    }

		@Override
		public @NonNull Transformation visitTransformation(@NonNull Transformation tIn) {
			@NonNull Transformation tOut = QVTbaseFactory.eINSTANCE.createTransformation();
			context.addTrace(tIn, tOut);
		    tOut.setName(tIn.getName());
		    tOut.setOwnedContext(create(tIn.getOwnedContext()));
		    createAll(tIn.getOwnedOperations(), tOut.getOwnedOperations());
		    createAll(tIn.getModelParameter(), tOut.getModelParameter());
		    doRules(tIn, tOut);
			createAll(tIn.getOwnedComments(), tOut.getOwnedComments());
		    return tOut;
		}

		@Override
		public @NonNull TypedModel visitTypedModel(@NonNull TypedModel tmIn) {
			@NonNull TypedModel tmOut = QVTbaseFactory.eINSTANCE.createTypedModel();
			context.addTrace(tmIn, tmOut);
			String name = tmIn.getName();
			if (name == null) {
//				name = QVTimperativeUtil.MIDDLE_DOMAIN_NAME;
				context.setMiddleTypedModelTarget(tmOut);
			}
			tmOut.setName(name);
			tmOut.getUsedPackage().addAll(tmIn.getUsedPackage());
			createAll(tmIn.getOwnedComments(), tmOut.getOwnedComments());
		    return tmOut;
		}

		@Override
		public @NonNull Variable visitVariable(@NonNull Variable vIn) {
			@SuppressWarnings("null")@NonNull Variable vOut = PivotFactory.eINSTANCE.createVariable();
			context.addTrace(vIn, vOut);
			vOut.setName(vIn.getName());
			createAll(vIn.getOwnedComments(), vOut.getOwnedComments());
	        return vOut;
	    }

		@Override
		public @Nullable Element visitVariableAssignment(@NonNull VariableAssignment vaIn) {
			VariableAssignment vaOut = QVTcoreBaseFactory.eINSTANCE.createVariableAssignment();
			context.addTrace(vaIn, vaOut);
			vaOut.setIsDefault(vaIn.isIsDefault());
			createAll(vaIn.getOwnedComments(), vaOut.getOwnedComments());
	        return vaOut;
		}
    }

	/**
	 * The UpdateVisitor resolves the references and creates the OCLExpressions omitted by the CreateVisitor..
	 */
    protected static abstract class AbstractUpdateVisitor<C extends AbstractQVTc2QVTc> extends AbstractExtendingQVTcoreVisitor<Object, C>
    {
    	private Operation equalsOperation = null;

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
						System.out.println(variable + " : " + NameUtil.debugFullName(variable) + " not in output resource.");
						vResource = variable.eResource();
					}
				}
			}
		}

		protected Object convertToPredicate(@NonNull PropertyAssignment paIn, @NonNull Predicate pOut) {
			OCLExpression slotExpression = copy(paIn.getSlotExpression());
			Property targetProperty = paIn.getTargetProperty();
			assert (slotExpression != null) && (targetProperty != null);
			OCLExpression valueExpression = copy(paIn.getValue());
			PropertyCallExp propertyCallExp = PivotUtil.createPropertyCallExp(slotExpression, targetProperty);
			context.addTrace(paIn, propertyCallExp);
			propertyCallExp.eUnset(PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED);		// FIXME redundant compatibility
			Operation equalsOperation = getEqualsOperation();
			OperationCallExp operationCallExp = PivotUtil.createOperationCallExp(propertyCallExp, equalsOperation, valueExpression);
			context.addTrace(paIn, operationCallExp);
			operationCallExp.setName(equalsOperation.getName());		// FIXME redundant compatibility
			pOut.setConditionExpression(operationCallExp);
			checkOut(pOut);
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
	        updateAllChildren(bOut.getVariable());
			return null;
		}

		@Override
		public @Nullable Object visitCoreDomain(@NonNull CoreDomain dOut) {
			Element dIn = context.basicEquivalentSource(dOut);
			TypedModel tmOut;
			if (dIn instanceof CoreDomain) {
				tmOut = context.equivalentTarget(((CoreDomain)dIn).getTypedModel());
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
		public @Nullable Object visitGuardPattern(@NonNull GuardPattern gOut) {
	        updateAllChildren(gOut.getPredicate());
	        updateAllChildren(gOut.getVariable());
	        for (Variable vOut : gOut.getVariable()) {
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
		public @Nullable Object visitPackage(@NonNull Package pOut) {
			updateAllChildren(pOut.getOwnedClasses());
			return null;
		}

		@Override
		public @Nullable Object visitPredicate(@NonNull Predicate pOut) {
			Predicate pIn = context.equivalentSource(pOut);
			pOut.setConditionExpression(copy(pIn.getConditionExpression()));
			checkOut(pOut);
			return null;
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
			return null;
		}

		@Override
		public @Nullable Object visitVariable(@NonNull Variable vOut) {
	        Variable vIn = context.equivalentSource(vOut);
	        vOut.setName(vIn.getName());
	        vOut.setIsImplicit(vIn.isIsImplicit());
	        vOut.setIsRequired(vIn.isIsRequired());
	        vOut.setOwnedInit(copy(vIn.getOwnedInit()));
	        vOut.setType(vIn.getType());
	        vOut.setTypeValue(vIn.getTypeValue());
			return vIn;
		}

		@Override
		public @Nullable Element visitVariableAssignment(@NonNull VariableAssignment vaOut) {
			VariableAssignment vaIn = context.equivalentSource(vaOut);
			vaOut.setTargetVariable(context.equivalentTarget(vaIn.getTargetVariable()));
			vaOut.setValue(copy(vaIn.getValue()));
	        return vaIn;
		}
	}
		
    protected final @NonNull EnvironmentFactory environmentFactory;
    protected final @NonNull AbstractCreateVisitor<?> createVisitor;
    protected final @NonNull AbstractUpdateVisitor<?> updateVisitor;
	private TypedModel middleTypedModelTarget = null;

    /**
     * Forward traceability from a source object to its targets for the current mapping. Top level entries ourside a maping are indexed for the null mapping.
     */
    private final @NonNull Map<@Nullable NamedElement, @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>>> scope2source2targets = new HashMap<@Nullable NamedElement, @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>>>();

    private final @NonNull Stack<@NonNull NamedElement> scopeStack = new Stack<@NonNull NamedElement>();
    /**
     * Reverse traceability from a target object to its source.
     */
    private final @NonNull Map<@NonNull Element, @NonNull Element> target2source = new HashMap<@NonNull Element, @NonNull Element>();
    
    /**
     * Reverse traceability from a target object to its source.
     */
    private final @NonNull Map<@NonNull Element, @NonNull Element> debugCopy2source = new HashMap<@NonNull Element, @NonNull Element>();
    
    private @Nullable Resource debugSource = null;
    private @Nullable Resource debugTarget = null;
	
    /**
     * Create a new QVTc to QVTc transformation using an environmentFactory.
     *
     * It may be used once by invoking transform(). Repeated transform() calls are beyond the current design.
     */
    protected AbstractQVTc2QVTc(@NonNull EnvironmentFactory environmentFactory) {
        this.environmentFactory = environmentFactory;
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
    protected void addTrace(@NonNull Element source, @NonNull Element target) {
    	target2source.put(target, source);
    	//
    	NamedElement scope = scopeStack.peek();
    	Map<@NonNull Element, @NonNull List<@NonNull Element>> source2targets = scope2source2targets.get(scope);
    	if (source2targets == null) {
    		source2targets = new HashMap<@NonNull Element, @NonNull List<@NonNull Element>>();
    		scope2source2targets.put(scope, source2targets);
    	}
    	List<@NonNull Element> targets = source2targets.get(source);
    	if (targets == null) {
    		targets = new ArrayList<@NonNull Element>();
    		source2targets.put(source, targets);
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

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
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
    	//
    	//	Debug code to conform that every output object is traceable to some input object. 
    	//
	    for (TreeIterator<EObject> tit = target.getAllContents(); tit.hasNext(); ) {
	    	EObject eTarget = tit.next();
	    	EObject eSource = target2source.get(eTarget);
	    	EObject eCopied = debugCopy2source.get(eTarget);
	        if ((eSource == null) && (eCopied == null)) {
	    		System.out.println("No source for " + eTarget.eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget)) + ":" + eTarget + " / " + eTarget.eContainer().eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget.eContainer())));
	    	}
	    }
	    
	    // FIXME the following lines should go obsolete
        List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, target);
        if (missingOperationCallSources != null) {
        	System.err.println("Missing OperationCallExp sources  were fixed up for '" + target.getURI() + "'");
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
