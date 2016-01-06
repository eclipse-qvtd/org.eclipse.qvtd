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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;

/**
 * The Class QVTuToQVTm.
 * This class prunes the model to flatten the mappings and merge refinements
 */
public class QVTu2QVTm {

    Map<Variable, Variable> refinedVars = new HashMap<Variable, Variable>();
    private EnvironmentFactory environmentFactory;


    public QVTu2QVTm(EnvironmentFactory environmentFactory) {
        super();
        this.environmentFactory = environmentFactory;
    }

    public void execute(CoreModel model) {

        for (org.eclipse.ocl.pivot.Package p : model.getOwnedPackages()) {
            for (Class c : p.getOwnedClasses()) {
                if (c instanceof Transformation) {
                    normalize((Transformation) c);
                }
            }
        }

    }

    /**
     * @param var
     * @param area
     */
    private boolean findAndUseAssignment(Variable var, Area area) {
        for (Assignment a : area.getBottomPattern().getAssignment()) {
            if (a instanceof VariableAssignment) {
                if (((VariableAssignment) a).getTargetVariable().equals(var)) {
                    OperationCallExp exp = MtcUtil.assignmentToOclExp(a, environmentFactory);
                    var.setOwnedInit(exp.getOwnedArguments().get(0));
                    EcoreUtil.delete(a, true);
                    return true;
                }
            }
        }
        return false;
    }

    

    /**
     * Move everything from the nested mappings to the top one
     * @param m
     */
    private void flaten(Mapping m) {
        ArrayList<EObject> temp = new ArrayList<EObject>(m.getLocal());
        Iterator<EObject> it = temp.iterator();
        while (it.hasNext()) {
            Mapping local = (Mapping) it.next();
            for (Domain nd : local.getDomain()) {
                moveToRootDomain(m, (CoreDomain) nd);
            }
            moveToOtherArea(local, m);
            EcoreUtil.delete(local);
            // After all has been flatten all predicates, assignments and inits must
            // have their references fixed.
            for (Domain d : m.getDomain()) {
                MtcUtil.fixReferences((Area) d, refinedVars);
            }
            MtcUtil.fixReferences(m, refinedVars);
        }
    }

    private Set<Mapping> getAllRefinements(Mapping m) {
        Set<Mapping> refined = new HashSet<Mapping>(m.getRefinement());
        for (Mapping rm : m.getRefinement()) {
            refined.addAll(getAllRefinements(rm));
        }
        return refined;
    }

    private CoreDomain getRootDomain(Mapping m, Domain nd) {
        for (Domain d : m.getDomain()) {
            if (d.getTypedModel().getName().equals(nd.getTypedModel().getName()))
                return (CoreDomain) d;
        }
        return null;
    }

    private boolean hasVariables(Area a) {
        return !(a.getGuardPattern().getVariable().isEmpty() ||
                a.getBottomPattern().getVariable().isEmpty() ||
                a.getBottomPattern().getRealizedVariable().isEmpty());
    }

    /**
     * Delete the refined mapping if all of its refiners do not
     * @param r
     */
    private boolean isNotNeeded(Mapping m) {
        if (m.getSpecification().isEmpty())
            return false;
        for (Mapping refining : m.getSpecification()) {
            for (Domain rd : refining.getDomain()) {
                if (hasVariables((Area) rd))
                    return false;
            }
            if (hasVariables(m))
                return false;
        }
        return true;

    }

    private void mergeAreas(Area target, Area source) {
        for (Variable gv : source.getGuardPattern().getVariable()) {
            mergeVariable(gv, target.getGuardPattern());
        }
        for (Variable bv : source.getBottomPattern().getVariable()) {
            mergeVariable(bv, target.getGuardPattern());
        }
        for (RealizedVariable brv : source.getBottomPattern().getRealizedVariable()) {
            mergeRealizedVariable(brv, target.getBottomPattern());
        }
        // Copy all predicates and assignments, might generate duplicates?
        for (Predicate p : source.getGuardPattern().getPredicate()) {
            Predicate pOut = EcoreUtil.copy(p);
            target.getGuardPattern().getPredicate().add(pOut);
        }
        for (Predicate p : source.getBottomPattern().getPredicate()) {
            Predicate pOut = EcoreUtil.copy(p);
            target.getGuardPattern().getPredicate().add(pOut);
        }
        for (Assignment as : source.getBottomPattern().getAssignment()) {
            Assignment aOut = EcoreUtil.copy(as);
            target.getBottomPattern().getAssignment().add(aOut);
        }

    }

    /**
     * Find the matching domain or create one and them merge them.
     * @param refining
     * @param rd
     */
    private void mergeDomain(Mapping refining, Domain rd) {
        CoreDomain cd = null;
        for (Domain d : refining.getDomain()) {
            if (d.getTypedModel().equals(rd.getTypedModel())) {
                cd = (CoreDomain) d;
            }
        }
        if (cd == null) {
            // We need a new domain
            cd = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
            cd.setTypedModel(rd.getTypedModel());
            cd.setName(rd.getName());
            GuardPattern dgp = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
            cd.setGuardPattern(dgp);
            BottomPattern dbp = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
            cd.setBottomPattern(dbp);
            refining.getDomain().add(cd);
        }
        mergeAreas((Area)cd, (Area)rd);
    }

    /**
     * Merging requires that variables share the name. Variables with the
     * same name should have types in the same hierarchy. The refining variable
     * is assumed to have the less abstract type.
     * @param existing
     * @param guardPattern
     */
    private void mergeRealizedVariable(RealizedVariable existing, BottomPattern target) {
        // Find a var with the same name
        RealizedVariable match = null;
        for (RealizedVariable v : target.getRealizedVariable()) {
            if (v.getName().equals(existing.getName())) {
                match = v;
                break;
            }
        }
        if (match != null) {
            Class rvClass = (Class) existing.getType();
            Class matchClass = (Class)match.getType();
            assert matchClass.getSuperClasses().contains(rvClass) || matchClass.equals(rvClass);
        } else {
            // We need to copy the variable
            match = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
            match.setName(existing.getName());
            match.setIsImplicit(existing.isIsImplicit());
            if (match.getOwnedInit() != null) {
                match.setOwnedInit(EcoreUtil.copy(existing.getOwnedInit()));
            }
            match.setType(existing.getType());
            target.getRealizedVariable().add(match);

        }
        // References to existing must be fixed
        refinedVars.put(existing, match);
    }

    /**
     * Merge all the domains and patterns from the refined mappings into the
     * refining one.
     * Refined mappings are merged in "complexity" order, applying mappings
     * that refine the more number of mappings (or the less abstract). This
     * follows the idea that more abstract mappings will also use the more
     * abstract types for their variables and hence the merging of variables
     * by keeping the less abstract one works.
     * @param m
     */
    private void mergeRefinements(Mapping m) {
        // Recursively get all the mappings refined, so we only refine them once
        Set<Mapping> refined = getAllRefinements(m);
        List<Mapping> refinedOrdered = new ArrayList<Mapping>(refined);
        Collections.sort(refinedOrdered, new Comparator<Mapping>() {

            @Override
            public int compare(Mapping m1, Mapping m2) {
                final int BEFORE = -1;
                final int EQUAL = 0;
                final int AFTER = 1;

                if (m1 == m2) return EQUAL;

                if (m1.getRefinement().size() < m2.getRefinement().size()) return AFTER;
                if (m1.getRefinement().size() > m2.getRefinement().size()) return BEFORE;

                if (m1.getRefinement().contains(m2)) return BEFORE;
                if (m2.getRefinement().contains(m1)) return AFTER;

                return EQUAL;
            }
        });
        for (Mapping r : refinedOrdered) {
            for (Domain rd : r.getDomain()) {
                mergeDomain(m, rd);
            }
            mergeAreas(m, r);
        }
        // After all has been merged all predicates, assignments and inits must
        // have their references fixed.
        for (Domain d : m.getDomain()) {
        	MtcUtil.fixReferences((Area) d, refinedVars);
        }
        MtcUtil.fixReferences(m, refinedVars);

    }

    /**
     * Merging requires that variables share the name. Variables with the
     * same name should have types in the same hierarchy. The refining variable
     * is assumed to have the less abstract type.
     * @param existing
     * @param guardPattern
     */
    private void mergeVariable(Variable existing, GuardPattern target) {
        // Find a var with the same name
        Variable match = null;
        for (Variable v : target.getVariable()) {
            if (v.getName().equals(existing.getName())) {
                match = v;
                break;
            }
        }
        if (match != null) {
            Class vClass = (Class) existing.getType();
            Class matchClass = (Class)match.getType();
            if (matchClass.getSuperClasses().contains(vClass)) {
                refinedVars.put(existing, match);
            } else if (vClass.getSuperClasses().contains(matchClass)) {
                refinedVars.put(match, existing);
            } else {
                assert (matchClass).equals(vClass);
                refinedVars.put(existing, match);
            }
        } else {
            // We need to copy the variable
            match = PivotFactory.eINSTANCE.createVariable();
            match.setName(existing.getName());
            match.setIsImplicit(existing.isIsImplicit());
            if (match.getOwnedInit() != null) {
                match.setOwnedInit(EcoreUtil.copy(existing.getOwnedInit()));
            }
            match.setType(existing.getType());
            target.getVariable().add(match);
        }
        // REferences to rv must be fixed
        refinedVars.put(existing, match);

    }

    private void moveBottomPattern(BottomPattern source, BottomPattern target) {
        moveCorePattern(source, target);
        ArrayList<@NonNull EObject> temp = new ArrayList<@NonNull EObject>(ClassUtil.nullFree(source.getRealizedVariable()));
        Iterator<@NonNull EObject> it = temp.iterator();
        while (it.hasNext()) {
            EObject n = it.next();
            PivotUtilInternal.resetContainer(n);
            target.getRealizedVariable().add((RealizedVariable) n);
        }
        temp = new ArrayList<@NonNull EObject>(ClassUtil.nullFree(source.getAssignment()));
        it = temp.iterator();
        while (it.hasNext()) {
            EObject n = it.next();
            PivotUtilInternal.resetContainer(n);
            target.getAssignment().add((Assignment) n);
        }
    }

    private void moveCorePattern(CorePattern source, CorePattern target) {
        ArrayList<@NonNull EObject> temp = new ArrayList<@NonNull EObject>(ClassUtil.nullFree(source.getVariable()));
        Iterator<@NonNull EObject> it = temp.iterator();
        while (it.hasNext()) {
            Variable n = (Variable) it.next();
            PivotUtilInternal.resetContainer(n);
            target.getVariable().add(n);
        }
        temp = new ArrayList<@NonNull EObject>(ClassUtil.nullFree(source.getPredicate()));
        it = temp.iterator();
        while (it.hasNext()) {
            EObject p = it.next();
            PivotUtilInternal.resetContainer(p);
            target.getPredicate().add((Predicate) p);
        }
    }

    /**
     * @param source
     * @param target
     */
    private void moveToOtherArea(Area source, Area target) {
        moveCorePattern(source.getGuardPattern(), target.getGuardPattern());
        moveBottomPattern(source.getBottomPattern(), target.getBottomPattern());

    }

    /**
     * @param m
     * @param nd
     */
    private void moveToRootDomain(Mapping m, CoreDomain nd) {
        CoreDomain root_domain = getRootDomain(m, nd);
        assert root_domain != null;
        moveToOtherArea(nd, root_domain);
    }

    private void normalize(Transformation t) {

        // Flatten nested mappings
        for (Rule r : t.getRule()) {
            flaten((Mapping) r);
        }
        // Delete all not needed refined mappings
        Set<Mapping> forDeletion = new HashSet<Mapping>();
        for (Rule r : t.getRule()) {
            if (isNotNeeded((Mapping) r)) {
                forDeletion.add((Mapping) r);
            }

        }
        // Merge refinements, we only merge mappings that are not further refined
        List<Mapping> refining = new ArrayList<Mapping>();
        for (Rule r : t.getRule()) {
            Mapping m = (Mapping) r;
            if (!m.getRefinement().isEmpty() && m.getSpecification().isEmpty())
                refining.add(m);
        }
        // Sort them by # of refinings and if they are refined
        Collections.sort(refining, new Comparator<Mapping>() {

            @Override
            public int compare(Mapping m1, Mapping m2) {
                final int BEFORE = -1;
                final int EQUAL = 0;
                final int AFTER = 1;

                if (m1 == m2) return EQUAL;

                if (m1.getRefinement().size() < m2.getRefinement().size()) return BEFORE;
                if (m1.getRefinement().size() > m2.getRefinement().size()) return AFTER;

                if (m1.getRefinement().contains(m2)) return AFTER;
                if (m2.getRefinement().contains(m1)) return BEFORE;

                return EQUAL;
            }
        });
        for (Mapping m : refining) {
            mergeRefinements(m);
        }
        // Transform variable assignments to init expressions if possible
        for (Mapping m : forDeletion) {
            EcoreUtil.delete(m, true);
        }
        for (Rule r : t.getRule()) {
            for (Domain d : r.getDomain()) {
                reduceVarAssignments((Area) d);
            }
            reduceVarAssignments((Area) r);
        }

    }

    /**
     * Find any variable assignments, and if possible change them to variable
     * initializers.
     * @param r
     */
    private void reduceVarAssignments(Area area) {
        List<@NonNull Variable> move = new ArrayList<@NonNull Variable>();
        for (Variable gv : ClassUtil.nullFree(area.getGuardPattern().getVariable())) {
            if (findAndUseAssignment(gv, area)) {
                // If initialised, move it to the bottom
                move.add(gv);
            }
        }
        for (Variable v : move) {
            PivotUtilInternal.resetContainer(v);
            area.getBottomPattern().getVariable().add(v);
        }
        for (Variable bv : area.getBottomPattern().getVariable()) {
            findAndUseAssignment(bv, area);
        }

    }

}
