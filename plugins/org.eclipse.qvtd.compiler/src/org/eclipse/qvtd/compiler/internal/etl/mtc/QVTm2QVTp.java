/*******************************************************************************
 * Copyright (c) 2015 University of York and Others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl.mtc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * The Class QVTmToQVTip.
 */
public class QVTm2QVTp {

    /**
     * The Class TxTrace.
     */
    private class TxTrace {

        /** The targets. */
        List<EObject> targets;			// The output objects generated in a specific context

        /** The context. */
        EObject context;					// The output object for which this trace is relevant

        /**
         * Instantiates a new tx trace.
         *
         * @param targets the targets
         * @param context the context
         */
        public TxTrace(List<EObject> targets, EObject context) {
            super();
            this.targets = targets;
            this.context = context;
        }

    }

    /** The transformation trace. */
    private Map<EObject, List<TxTrace>> transformationTrace = new HashMap<EObject, List<TxTrace>>();

    private Configuration config;
    private EnvironmentFactory environmentFactory;

    /**
     * Instantiates a new QV tm to qv tip.
     *
     * @param confing the confing
     * @param environmentFactory the environment factory
     */
    public QVTm2QVTp(Configuration config, EnvironmentFactory environmentFactory) {
        super();
        this.config = config;
        this.environmentFactory = environmentFactory;
    }

    /**
     * Create a new trace for the given list of generated objects for the given
     * context.
     *
     * @param source the source of the trace
     * @param generated the list of generated objects
     * @param context the context in which the trace is valid
     */
    private void addTrace(EObject source, List<EObject> generated, EObject context) {
        TxTrace trace = new TxTrace(generated, context);
        if (transformationTrace.containsKey(source)) {
            transformationTrace.get(source).add(trace);
        } else {
            List<QVTm2QVTp.TxTrace> traces = new ArrayList<QVTm2QVTp.TxTrace>();
            traces.add(trace);
            transformationTrace.put(source, traces);
        }
    }

    /**
     * The create part of Assignment to Assignment. The assignment is copied
     * and references to variables are fixed later.
     *
     * If the mapping only has one domain and that domain is the direction,
     * assignments that set attributes of the realized variables (which are
     * transformed to variables) to other middle var (or their properties),
     * are transformed to predicates.
     * TODO This change should be done in QVTc to QVTu!!!
     * @param aIn the a in
     * @param context the context
     */
    private void assgToAssg_C(Assignment aIn, EObject context) {

        List<EObject> result = new ArrayList<EObject>();
        BottomPattern bp = (BottomPattern) aIn.eContainer();
        Area a = bp.getArea();
        if (a instanceof Mapping) {
            Mapping m = (Mapping) a;
            if (m.getDomain().size() == 1 &&
            		MtcUtil.isOutputDomain((Area) m.getDomain().get(0), config) &&
            		MtcUtil.isMiddleAssignment(aIn)) {
                Predicate pOUt = QVTbaseFactory.eINSTANCE.createPredicate();
                pOUt.setConditionExpression(MtcUtil.assignmentToOclExp(aIn, environmentFactory));
                result.add(pOUt);
            }
        }
        if (result.isEmpty()) {
            Assignment aOut = EcoreUtil.copy(aIn);
            result.add(aOut);
        }
        addTrace(aIn, result, context);
    }

    /**
     * Assignment update. Fix the references to the variables.
     *
     * @param aIn the a in
     * @param context the context
     */
    private void assgToAssg_U(Assignment aIn, EObject context) {
        Object eq = equivalent(aIn, context);
        if (eq instanceof Assignment) {
            Assignment aOut = (Assignment) eq;
            for (VariableExp varexp : MtcUtil.findVariableExps(aOut)) {
                fixVariableRefernces(varexp, context);
            }
            for (OperationCallExp opcallexp : MtcUtil.findOpCallExps(aOut)) {
                if (opcallexp.getReferredOperation() instanceof Function) {
                    Function fout = (Function) equivalent(opcallexp.getReferredOperation(), null);
                    opcallexp.setReferredOperation(fout);
                }
            }
            if (aIn instanceof VariableAssignment) {
                Variable varOut = (Variable) equivalent(((VariableAssignment) aIn).getTargetVariable(), context);
                ((VariableAssignment) aOut).setTargetVariable(varOut);
            }
        } else if (eq instanceof Predicate) {
            Predicate pOut = (Predicate) eq;
            for (VariableExp varexp : MtcUtil.findVariableExps(pOut)) {
                fixVariableRefernces(varexp, context);
            }
            for (OperationCallExp opcallexp : MtcUtil.findOpCallExps(pOut)) {
                if (opcallexp.getReferredOperation() instanceof Function) {
                    Function fout = (Function) equivalent(opcallexp.getReferredOperation(), null);
                    opcallexp.setReferredOperation(fout);
                }
            }
        }
    }

    /**
     * Dispatch method for target object creation. Only create if objects have
     * not been created in the same context before, i.e. create once per context
     *
     * @param source the source
     * @param context the context
     */
    private void create(EObject source, EObject context) {
        if (equivalents(source, context) == null ||
                equivalents(source, context).isEmpty()) {
            int classifierID = source.eClass().getClassifierID();
            if (source.eClass().getEPackage() == PivotPackage.eINSTANCE) {
                switch (classifierID) {
                    case PivotPackage.PACKAGE: {
                        packageToPackage_C((Package) source, context);
                        break;
                    }
                    case PivotPackage.VARIABLE: {
                        varToVar_C((Variable) source, context);
                        break;
                    }
                    default : {
                        throw new IllegalArgumentException("No create defined for " + source.eClass());
                    }
                }
            } else if (source.eClass().getEPackage() == QVTbasePackage.eINSTANCE) {
                switch (classifierID) {
                    case QVTbasePackage.TRANSFORMATION: {
                        transToTrans_C((Transformation) source, context);
                        break;
                    }
                    case QVTbasePackage.FUNCTION: {
                        funcToFunc_C((Function) source, context);
                        break;
                    }
                    case QVTbasePackage.TYPED_MODEL: {
                        tmToTm_C((TypedModel) source, context);
                        break;
                    }
                    case QVTbasePackage.PREDICATE: {
                        predToPred_C((Predicate) source, context);
                        break;
                    }
                    default : {
                        throw new IllegalArgumentException("No create defined for " + source.eClass());
                    }
                }
            } else if (source.eClass().getEPackage() == QVTcoreBasePackage.eINSTANCE) {
                switch (classifierID) {
                    case QVTcoreBasePackage.CORE_DOMAIN: {
                        domToDom_C((CoreDomain) source, context);
                        break;
                    }
                    case QVTcoreBasePackage.REALIZED_VARIABLE: {
                        rvarToRvar_C((RealizedVariable) source, context);
                        break;
                    }
                    case QVTcoreBasePackage.PROPERTY_ASSIGNMENT:
                    case QVTcoreBasePackage.VARIABLE_ASSIGNMENT: {
                        assgToAssg_C((Assignment) source, context);
                        break;
                    }
                    default : {
                        throw new IllegalArgumentException("No create defined for " + source.eClass());
                    }
                }
            } else if (source.eClass().getEPackage() == QVTcorePackage.eINSTANCE) {
                switch (classifierID) {
                    case QVTcorePackage.CORE_MODEL: {
                        modelToModel_C((CoreModel) source, context);
                        break;
                    }
                    case QVTcorePackage.MAPPING: {
                        mappingToMapping_C((Mapping) source, context);
                        break;
                    }
                    default : {
                        throw new IllegalArgumentException("No create defined for " + source.eClass());
                    }
                }
            }
        }
    }

    /**
     * Dom to dom_ c.
     *
     * @param dIn the d in
     * @param context the context
     */
    private void domToDom_C(CoreDomain dIn, EObject context) {
        CoreDomain dOut = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
        List<EObject> result = new ArrayList<EObject>();
        result.add(dOut);
        addTrace(dIn, result, context);
        for (Variable gv : dIn.getGuardPattern().getVariable()) {
            create(gv, dOut);
        }
        for (Variable bv : dIn.getBottomPattern().getVariable()) {
            create(bv, dOut);
        }
        for (Variable brv : dIn.getBottomPattern().getRealizedVariable()) {
            create(brv, dOut);
        }
        for (Predicate pred : dIn.getGuardPattern().getPredicate()) {
            create(pred, dOut);
        }
        for (Predicate pred : dIn.getBottomPattern().getPredicate()) {
            create(pred, dOut);
        }
        for (Assignment assg : dIn.getBottomPattern().getAssignment()) {
            create(assg, dOut);
        }
    }


    /**
     * Fills in the missing bits and pieces of the mapping and fixes any dangling
     * references to objects in the source model.
     *
     * @param dIn the d in
     * @param context the context
     */
    private void domToDom_U(CoreDomain dIn, EObject context) {
        CoreDomain dOut = (CoreDomain) equivalent(dIn, context);
        dOut.setName(dIn.getName());
        dOut.setIsCheckable(dIn.isIsCheckable());
        dOut.setIsEnforceable(dIn.isIsEnforceable());
        dOut.setTypedModel((TypedModel) equivalent(dIn.getTypedModel(), null));
        GuardPattern dgp = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
        dOut.setGuardPattern(dgp);
        BottomPattern dbp = QVTimperativeFactory.eINSTANCE.createImperativeBottomPattern();
        dOut.setBottomPattern(dbp);
        for (Variable gv : dIn.getGuardPattern().getVariable()) {
            Variable varOut = (Variable) equivalent(gv, dOut);
            update(gv, dOut);
            if (varOut.getOwnedInit() == null) {
                dgp.getVariable().add(varOut);
            } else {
                dbp.getVariable().add(varOut);		// Initialized variables go in the bottom pattern
            }
        }
        for (Variable bv : dIn.getBottomPattern().getVariable()) {
            Variable varOut = (Variable) equivalent(bv, dOut);
            update(bv, dOut);
            if (varOut.getOwnedInit() == null) {
                dgp.getVariable().add(varOut);
            } else {
                dbp.getVariable().add(varOut);		// Initialized variables go in the bottom pattern
            }
        }

        for (RealizedVariable brv : dIn.getBottomPattern().getRealizedVariable()) {
            RealizedVariable varOut = (RealizedVariable) equivalent(brv, dOut);
            dbp.getRealizedVariable().add(varOut);
            update(brv, dOut);
        }
        org.eclipse.qvtd.pivot.qvtimperative.Mapping mOut = (org.eclipse.qvtd.pivot.qvtimperative.Mapping) dOut.getRule();
        GuardPattern gp = mOut.getGuardPattern();
        for (Predicate pred : dIn.getGuardPattern().getPredicate()) {
            Predicate pOut = (Predicate) equivalent(pred, dOut);
            gp.getPredicate().add(pOut);
            update(pred, dOut);
        }
        for (Predicate pred : dIn.getBottomPattern().getPredicate()) {
            Predicate pOut = (Predicate) equivalent(pred, dOut);
            gp.getPredicate().add(pOut);
            update(pred, dOut);
        }
        BottomPattern bp = mOut.getBottomPattern();
        for (Assignment assg : dIn.getBottomPattern().getAssignment()) {
            Assignment aOut = (Assignment) equivalent(assg, dOut);
            bp.getAssignment().add(aOut);
            update(assg, dOut);
        }
    }

    /**
     * Equivalent.
     *
     * @param source the source
     * @param context the context
     * @return the object
     */
    private Object equivalent(EObject source, EObject context) {
        List<EObject> eqs = equivalents(source, context);
        if (eqs != null && eqs.size() > 0)
            return eqs.get(0);
        else
            return null;
    }

    /**
     * Equivalents.
     *
     * @param s the s
     * @param context the context
     * @return the list
     */
    private List<EObject> equivalents(EObject s, EObject context) {
        List<EObject> eqs = null;
        if (transformationTrace.containsKey(s)) {
            eqs = new ArrayList<EObject>();
            List<TxTrace> traces = transformationTrace.get(s);
            if (context == null) {
                for (TxTrace t : traces) {
                    eqs.addAll(t.targets);
                }
            } else {
                for (TxTrace t : traces) {
                    if (t.context.equals(context)) {
                        eqs.addAll(t.targets);
                        break;
                    }
                }
            }
        }
        return eqs;
    }

    /**
     * Fix variable refernces.
     *
     * @param varexp the varexp
     * @param context the context
     */
    private void fixVariableRefernces(VariableExp varexp, EObject context) {

        Variable varIn = (Variable) varexp.getReferredVariable();
        if (varIn.eContainer() instanceof CorePattern) {
            CorePattern cp = (CorePattern) varIn.eContainer();
            Variable varOut;
            if (cp.getArea() instanceof CoreDomain) {
                CoreDomain var_context = (CoreDomain) equivalent(cp.getArea(), context);
                varOut = (Variable) equivalent(varIn, var_context);
            } else {
                varOut = (Variable) equivalent(varIn, context);
            }
            varexp.setReferredVariable(varOut);
        }
    }

    /**
     * Func to func_ c.
     *
     * @param fIn the f in
     * @param context the context
     */
    private void funcToFunc_C(Function fIn, EObject context) {
        Function fOut = EcoreUtil.copy(fIn);
        List<EObject> result = new ArrayList<EObject>();
        result.add(fOut);
        addTrace(fIn, result, context);
    }


    /**
     * Copy all the contents of the mapping, creating an explicit domain
     * for the middle model and moving all predicates and assignments to the
     * mapping's patterns.
     *
     * @param mIn the m in
     * @param context the context
     */
    private void mappingToMapping_C(Mapping mIn, EObject context) {
        org.eclipse.qvtd.pivot.qvtimperative.Mapping mOut = QVTimperativeFactory.eINSTANCE.createMapping();
        List<EObject> result = new ArrayList<EObject>();
        result.add(mOut);
        addTrace(mIn, result, context);
        // Copy all the domains
        for (Domain d : mIn.getDomain()) {
            create(d, mOut);
        }
        for (Variable gv : mIn.getGuardPattern().getVariable()) {
            create(gv, mOut);
        }
        for (Variable bv : mIn.getBottomPattern().getVariable()) {
            create(bv, mOut);
        }
        for (Variable brv : mIn.getBottomPattern().getRealizedVariable()) {
            create(brv, mOut);
        }
        for (Predicate pred : mIn.getGuardPattern().getPredicate()) {
            create(pred, mOut);
        }
        for (Predicate pred : mIn.getBottomPattern().getPredicate()) {
            create(pred, mOut);
        }
        for (Assignment assg : mIn.getBottomPattern().getAssignment()) {
            create(assg, mOut);
        }
    }

    /**
     * Mapping to mapping_ u.
     *
     * @param mIn the m in
     * @param context the context
     */
    private void mappingToMapping_U(Mapping mIn, EObject context) {
        org.eclipse.qvtd.pivot.qvtimperative.Mapping mOut = (org.eclipse.qvtd.pivot.qvtimperative.Mapping) equivalent(mIn, context);
        mOut.setName(mIn.getName());
        GuardPattern gp = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
        mOut.setGuardPattern(gp);
        BottomPattern bp = QVTimperativeFactory.eINSTANCE.createImperativeBottomPattern();
        mOut.setBottomPattern(bp);
        for (Domain d : mIn.getDomain()) {
            CoreDomain dOut = (CoreDomain) equivalent(d, mOut);
            mOut.getDomain().add(dOut);
            update(d, mOut);
        }
        CoreDomain midDom = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
        mOut.getDomain().add(midDom);
        for (TypedModel tm : mIn.getTransformation().getModelParameter()) {
            TypedModel tmOut = (TypedModel) equivalent(tm, null);
            if (tmOut.getName().equals(QVTimperativeUtil.MIDDLE_DOMAIN_NAME)) {
                midDom.setTypedModel(tmOut);
                midDom.setName(tmOut.getName());
                break;
            }
        }
        midDom.setIsCheckable(false);
        midDom.setIsEnforceable(true);
        GuardPattern midgp = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
        midDom.setGuardPattern(midgp);
        BottomPattern midbp = QVTimperativeFactory.eINSTANCE.createImperativeBottomPattern();
        midDom.setBottomPattern(midbp);
        for (Variable gv : mIn.getGuardPattern().getVariable()) {
            Variable varOut = (Variable) equivalent(gv, mOut);
            update(gv, mOut);
            if (varOut.getOwnedInit() == null) {
                midgp.getVariable().add(varOut);
            } else {
                midbp.getVariable().add(varOut);		// Initialised variables go in the bottom pattern
            }
        }
        for (Variable bv : mIn.getBottomPattern().getVariable()) {
            Variable varOut = (Variable) equivalent(bv, mOut);
            update(bv, mOut);
            if (varOut.getOwnedInit() == null) {
                midgp.getVariable().add(varOut);
            } else {
                midbp.getVariable().add(varOut);		// Initialised variables go in the bottom pattern
            }
        }
        for (RealizedVariable brv : mIn.getBottomPattern().getRealizedVariable()) {
            if (mIn.getDomain().size() == 1 &&
            		MtcUtil.isOutputDomain((Area) mIn.getDomain().get(0), config)) {
                Variable varOut = (Variable) equivalent(brv, mOut);
                midgp.getVariable().add(varOut);
            } else {
                RealizedVariable varOut = (RealizedVariable) equivalent(brv, mOut);
                midbp.getRealizedVariable().add(varOut);
            }
            update(brv, mOut);
        }
        for (Predicate pred : mIn.getGuardPattern().getPredicate()) {
            Predicate pOut = (Predicate) equivalent(pred, mOut);
            gp.getPredicate().add(pOut);
            update(pred, mOut);
        }
        for (Predicate pred : mIn.getBottomPattern().getPredicate()) {
            Predicate pOut = (Predicate) equivalent(pred, mOut);
            gp.getPredicate().add(pOut);
            update(pred, mOut);
        }
        for (Assignment assg : mIn.getBottomPattern().getAssignment()) {
            if (mIn.getDomain().size() == 1 &&
            		MtcUtil.isOutputDomain((Area) mIn.getDomain().get(0), config) &&
            		MtcUtil.isMiddleAssignment(assg)) {
                Predicate pOut = (Predicate) equivalent(assg, mOut);
                gp.getPredicate().add(pOut);
            } else {
                Assignment aOut = (Assignment) equivalent(assg, mOut);
                bp.getAssignment().add(aOut);
            }
            update(assg, mOut);
        }



    }

    /**
     * Model to model_ c.
     *
     * @param mIn the m in
     * @param context the context
     */
    private void modelToModel_C(CoreModel mIn, EObject context) {
        ImperativeModel mOut = QVTimperativeFactory.eINSTANCE.createImperativeModel();
        List<EObject> result = new ArrayList<EObject>();
        result.add(mOut);
        addTrace(mIn, result, context);
        for (org.eclipse.ocl.pivot.Package p : mIn.getOwnedPackages()) {
            create(p, mOut);
        }
    }

    /**
     * Model to model_ u.
     *
     * @param mIn the m in
     * @param context the context
     */
    private void modelToModel_U(CoreModel mIn, EObject context) {
        ImperativeModel mOut = (ImperativeModel) equivalent(mIn, context);
        mOut.setExternalURI(mIn.getExternalURI().replace(".qvtm.qvtc", ".qvtp.qvti"));
        for (Import oi : mIn.getOwnedImports()) {
            mOut.getOwnedImports().add(EcoreUtil.copy(oi));
        }
        for (org.eclipse.ocl.pivot.Package p : mIn.getOwnedPackages()) {
            //List<? extends EObject> traces = new ArrayList<EObject>();
            Package pOut = ((Package) equivalent(p, mOut));
            if (pOut != null) {
                mOut.getOwnedPackages().add(pOut);
                update(p, context);
            }
        }
    }

    /**
     * Package to package_ c.
     *
     * @param pIn the in
     * @param context the context
     */
    private void packageToPackage_C(Package pIn, EObject context) {
        boolean guard = false;
        for (Class c : pIn.getOwnedClasses()) {
            if (c instanceof Transformation) {
                guard = true;
                break;
            }
        }
        if (!guard)
            return;
        Package pOut = PivotFactory.eINSTANCE.createPackage();
        List<EObject> result = new ArrayList<EObject>();
        result.add(pOut);
        addTrace(pIn, result, context);
        for (Class inC : pIn.getOwnedClasses()) {
            create(inC, pOut);
        }

    }

    /**
     * Package to package_ u.
     *
     * @param pIn the in
     * @param context the context
     */
    private void packageToPackage_U(Package pIn, EObject context) {
        Package pOut = (Package) equivalent(pIn, context);
        if (pOut == null) {
            return; 	// Nothing to populate
        }
        pOut.setName(pIn.getName());
        for (Class inC : pIn.getOwnedClasses()) {
            Class outC = (Class) equivalent(inC, pOut);
            if (outC != null) {
                pOut.getOwnedClasses().add(outC);
                update(inC, context);
            }
        }
    }

    /**
     * Create a copy of the predicate so OCL Expressions are copied.
     *
     * @param pIn the in
     * @param context the context
     */
    private void predToPred_C(Predicate pIn, EObject context) {
        Predicate pOut = EcoreUtil.copy(pIn);
        List<EObject> result = new ArrayList<EObject>();
        result.add(pOut);
        addTrace(pIn, result, context);
    }

    /**
     * Fix the variable references used in the predicate.
     *
     * @param pIn the in
     * @param context the context
     */
    private void predToPred_U(Predicate pIn, EObject context) {
        Predicate pOut = (Predicate) equivalent(pIn, context);
        for (VariableExp varexp : MtcUtil.findVariableExps(pOut)) {
            fixVariableRefernces(varexp, context);
        }
        for (OperationCallExp opcallexp : MtcUtil.findOpCallExps(pOut)) {
            if (opcallexp.getReferredOperation() instanceof Function) {
                Function fout = (Function) equivalent(opcallexp.getReferredOperation(), null);
                opcallexp.setReferredOperation(fout);
            }
        }
    }

    /**
     * Realized Variables.
     * If the mapping only has one domain and that domain is the direction,
     * realized variables must be transformed to variables.
     *
     * @param vIn the v in
     * @param context the context
     */
    private void rvarToRvar_C(RealizedVariable vIn, EObject context) {
        Variable rvOut = null;
        BottomPattern bp = (BottomPattern) vIn.eContainer();
        Area a = bp.getArea();
        if (a instanceof Mapping) {
            Mapping m = (Mapping) a;
            if (m.getDomain().size() == 1 &&
            		MtcUtil.isOutputDomain((Area) m.getDomain().get(0), config)) {
                rvOut = PivotFactory.eINSTANCE.createVariable();
            }
        }
        if (rvOut == null)
            rvOut = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
        List<EObject> result = new ArrayList<EObject>();
        result.add(rvOut);
        addTrace(vIn, result, context);
    }

    /**
     * RealizedVariable update.
     * Since some realized variables may become regular variables, use Variable
     * as the type of the equivalent.
     *
     * @param vIn the v in
     * @param context the context
     */
    private void rvarToRvar_U(RealizedVariable vIn, EObject context) {
        Variable rvOut = (Variable) equivalent(vIn, context);
        rvOut.setName(vIn.getName());
        rvOut.setIsImplicit(vIn.isIsImplicit());
        if (vIn.getOwnedInit() != null) {
            rvOut.setOwnedInit(EcoreUtil.copy(vIn.getOwnedInit()));
        }
        rvOut.setType(vIn.getType());
    }

    /**
     * Tm to tm_ c.
     *
     * @param tmIn the tm in
     * @param context the context
     */
    private void tmToTm_C(TypedModel tmIn, EObject context) {
        TypedModel tmOut = QVTbaseFactory.eINSTANCE.createTypedModel();
        List<EObject> result = new ArrayList<EObject>();
        result.add(tmOut);
        addTrace(tmIn, result, context);
    }


    /**
     * Tm to tm_ u.
     *
     * @param tmIn the tm in
     * @param context the context
     */
    private void tmToTm_U(TypedModel tmIn, EObject context) {
        TypedModel tmOut = (TypedModel) equivalent(tmIn, context);
        String name = tmIn.getName();
        if (name == null) {
            name = QVTimperativeUtil.MIDDLE_DOMAIN_NAME;
        }
        tmOut.setName(name);
        tmOut.getUsedPackage().addAll(tmIn.getUsedPackage());
        for (TypedModel tmD : tmIn.getDependsOn()) {
            tmOut.getDependsOn().add((TypedModel) equivalent(tmD, context));
        }

    }

    /**
     * Transform.
     *
     * @param source the source
     * @param target the target
     */
    public void transform(Resource source, Resource target) {
        for (EObject eContent : source.getContents()) {
            if (eContent instanceof CoreModel) {
                create(eContent, null);
                update(eContent, null);
                ImperativeModel out = (ImperativeModel) equivalent(eContent, null);
                target.getContents().add(out);
            }
        }
    }







    /**
     * Transformation create.
     *
     * @param tIn the t in
     * @param context the context
     */
    private void transToTrans_C(Transformation tIn, EObject context) {
        Transformation tOut = QVTbaseFactory.eINSTANCE.createTransformation();
        List<EObject> result = new ArrayList<EObject>();
        result.add(tOut);
        addTrace(tIn, result, context);
        for (Operation opIn :tIn.getOwnedOperations()) {
            create(opIn, tOut);
        }
        for (TypedModel tmIn : tIn.getModelParameter()) {
            create(tmIn, tOut);
        }
        for (Rule rIn : tIn.getRule()) {
            create(rIn, tOut);
        }
    }


    /**
     * Transformation update.
     *
     * @param tIn the t in
     * @param context the context
     */
    private void transToTrans_U(Transformation tIn, EObject context) {
        Transformation tOut = (Transformation) equivalent(tIn, context);
        tOut.setName(tIn.getName());
        for (Operation opIn :tIn.getOwnedOperations()) {
            tOut.getOwnedOperations().add((Operation) equivalent(opIn, tOut));
        }
        for (TypedModel tmIn : tIn.getModelParameter()) {
            tOut.getModelParameter().add((TypedModel) equivalent(tmIn, tOut));
            update(tmIn, tOut);
        }
        for (Rule rIn : tIn.getRule()) {
             Rule rOut = (Rule) equivalent(rIn, tOut);
             tOut.getRule().add(rOut);
             update(rIn, tOut);
        }
    }

    /**
     * Update.
     *
     * @param source the source
     * @param context the context
     */
    private void update(EObject source, EObject context) {
        int classifierID = source.eClass().getClassifierID();
        if (source.eClass().getEPackage() == PivotPackage.eINSTANCE) {
            switch (classifierID) {
                case PivotPackage.PACKAGE: {
                    packageToPackage_U((Package) source, context);
                    break;
                }
                case PivotPackage.VARIABLE: {
                    varToVar_U((Variable) source, context);
                    break;
                }
                default : {
                    throw new IllegalArgumentException("No update defined for " + source.eClass());
                }
            }

        } else if (source.eClass().getEPackage() == QVTbasePackage.eINSTANCE) {
            switch (classifierID) {
                case QVTbasePackage.TRANSFORMATION: {
                    transToTrans_U((Transformation) source, context);
                    break;
                }
                case QVTbasePackage.TYPED_MODEL: {
                    tmToTm_U((TypedModel) source, context);
                    break;
                }
                case QVTbasePackage.PREDICATE: {
                    predToPred_U((Predicate) source, context);
                    break;
                }
                default : {
                    throw new IllegalArgumentException("No update defined for " + source.eClass());
                }
            }
        } else if (source.eClass().getEPackage() == QVTcoreBasePackage.eINSTANCE) {
            switch (classifierID) {
                case QVTcoreBasePackage.CORE_DOMAIN: {
                    domToDom_U((CoreDomain) source, context);
                    break;
                }
                case QVTcoreBasePackage.REALIZED_VARIABLE: {
                    rvarToRvar_U((RealizedVariable) source, context);
                    break;
                }
                case QVTcoreBasePackage.PROPERTY_ASSIGNMENT:
                case QVTcoreBasePackage.VARIABLE_ASSIGNMENT: {
                    assgToAssg_U((Assignment) source, context);
                    break;
                }
                default : {
                    throw new IllegalArgumentException("No update defined for " + source.eClass());
                }
            }
        } else if (source.eClass().getEPackage() == QVTcorePackage.eINSTANCE) {
            switch (classifierID) {
                case QVTcorePackage.CORE_MODEL: {
                    modelToModel_U((CoreModel) source, context);
                    break;
                }
                case QVTcorePackage.MAPPING: {
                    mappingToMapping_U((Mapping) source, context);
                    break;
                }
                default : {
                    throw new IllegalArgumentException("No update defined for " + source.eClass());
                }
            }
        }

    }


    /**
     * Var to var_ c.
     *
     * @param vIn the v in
     * @param context the context
     */
    private void varToVar_C(Variable vIn, EObject context) {
        Variable vOut = PivotFactory.eINSTANCE.createVariable();
        List<EObject> result = new ArrayList<EObject>();
        result.add(vOut);
        addTrace(vIn, result, context);

    }

    /**
     * Var to var_ u.
     *
     * @param vIn the v in
     * @param context the context
     */
    private void varToVar_U(Variable vIn, EObject context) {
        Variable vOut = (Variable) equivalent(vIn, context);
        vOut.setName(vIn.getName());
        vOut.setIsImplicit(vIn.isIsImplicit());
        if (vIn.getOwnedInit() != null) {
            vOut.setOwnedInit(EcoreUtil.copy(vIn.getOwnedInit()));
            for (VariableExp ve : MtcUtil.findVariableExps(vOut.getOwnedInit())) {
                fixVariableRefernces(ve, context);
            }
        }
        vOut.setType(vIn.getType());
    }

}
