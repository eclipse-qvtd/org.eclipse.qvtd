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
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.LookupException;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS;

public abstract class QVTcAreaEnvironment<AST extends EModelElement> extends QVTcEnvironment<IQVTcNodeEnvironment, QVTcMappingEnvironment<?>, AST, DomainCS> implements IQVTcEnvironment
{
	protected final String modelName;
	protected final TypedModel typedModel;
	private QVTcBottomPatternEnvironment bottomPatternEnvironment = null; 
	private QVTcGuardPatternEnvironment guardPatternEnvironment = null; 
	private Set<TypedModel> typedModelClosure = null;
	private Set<EPackage> usedPackageClosure = null;
	private Set<QVTcAreaEnvironment<?>> areaEnvironmentPartialClosure = null;
	private Set<QVTcPatternEnvironment<?>> bottomPatternEnvironmentClosure = null;
	private Set<QVTcPatternEnvironment<?>> guardPatternEnvironmentClosure = null;

	protected QVTcAreaEnvironment(QVTcMappingEnvironment<?> env, AST astNode, DomainCS domainCS, String modelName) {
		super(env, astNode, domainCS);
		this.modelName = modelName;
		if (!"".equals(modelName)) {
			Transformation transformation = getTransformation();
			TypedModel typedModel = transformation.getModelParameter(modelName);
			if (typedModel == null) {
				String message = "Domain identifier '" + formatString(modelName) + "' must refer to a direction";
				analyzerError(message, "DomainCS", domainCS.getIdentifier());
			}
			this.typedModel = typedModel;
		}
		else
			this.typedModel = null;
	}

	protected void addUsedPackages(TypedModel typedModel, Set<EPackage> usedPackageClosure, Set<TypedModel> dependsOnClosure) {
		if (typedModel != null) {
			usedPackageClosure.addAll(typedModel.getUsedPackage());
			if (dependsOnClosure.add(typedModel)) {
				for (TypedModel dependent : typedModel.getDependsOn())
					addUsedPackages(dependent, usedPackageClosure, dependsOnClosure);
			}
		}
	}
	
	protected abstract Set<QVTcAreaEnvironment<?>> computeAreaEnvironmentPartialClosure();

	protected Set<QVTcPatternEnvironment<?>> computeBottomPatternEnvironmentClosure() {
		Set<QVTcPatternEnvironment<?>> closure = new HashSet<QVTcPatternEnvironment<?>>();
		for (QVTcAreaEnvironment<?> contextEnvironment = this; contextEnvironment != null; contextEnvironment = contextEnvironment.getContextEnvironment()) {
			for (QVTcAreaEnvironment<?> areaEnvironment : contextEnvironment.getAreaEnvironmentPartialClosure()) {
				closure.add(areaEnvironment.getBottomPatternEnvironment());
				closure.add(areaEnvironment.getGuardPatternEnvironment());			
			}
		}
		return closure;
	}

	protected Set<QVTcPatternEnvironment<?>> computeGuardPatternEnvironmentClosure() {
		Set<QVTcPatternEnvironment<?>> closure = new HashSet<QVTcPatternEnvironment<?>>();
		for (QVTcAreaEnvironment<?> areaEnvironment : getAreaEnvironmentPartialClosure())
			closure.add(areaEnvironment.getGuardPatternEnvironment());			
		for (QVTcAreaEnvironment<?> contextEnvironment = getContextEnvironment(); contextEnvironment != null; contextEnvironment = contextEnvironment.getContextEnvironment()) {
			for (QVTcAreaEnvironment<?> areaEnvironment : contextEnvironment.getAreaEnvironmentPartialClosure()) {
				closure.add(areaEnvironment.getBottomPatternEnvironment());
				closure.add(areaEnvironment.getGuardPatternEnvironment());			
			}
		}
		return closure;
	}

	protected Set<TypedModel> computeTypedModelClosure() {
		Set<TypedModel> closure = new HashSet<TypedModel>();
		computeTypedModelClosure(closure, typedModel);
		return closure;
	}

	protected void computeTypedModelClosure(Set<TypedModel> closure, TypedModel typedModel) {
		if ((typedModel != null) && closure.add(typedModel))
			for (TypedModel dependant : typedModel.getDependsOn())
				computeTypedModelClosure(closure, dependant);
	}	

	protected Set<EPackage> computeUsedPackageClosure() {
		Set<EPackage> closure = new HashSet<EPackage>();
		Transformation transformation = getTransformation();
		closure.add(transformation);
		for (TypedModel typedModel : getTypedModelClosure())
			closure.addAll(typedModel.getUsedPackage());
		return closure;
	}	

	public QVTcBottomPatternEnvironment createBottomPatternEnvironment(PatternCS patternCS) {
		assert typedModelClosure == null : "Must not createBottomPatternEnvironment after computeTypedModelClosure";
		assert usedPackageClosure == null : "Must not createBottomPatternEnvironment after computeUsedPackageClosure";
		if (bottomPatternEnvironment != null)
			analyzerError("Repeated createBottomPatternEnvironment", "BottomPattern", patternCS);
		bottomPatternEnvironment = new QVTcBottomPatternEnvironment(this, patternCS);
		return bottomPatternEnvironment;
	}

	public QVTcGuardPatternEnvironment createGuardPatternEnvironment(PatternCS patternCS) {
		assert typedModelClosure == null : "Must not createGuardPatternEnvironment after computeTypedModelClosure";
		assert usedPackageClosure == null : "Must not createGuardPatternEnvironment after computeUsedPackageClosure";
		if (guardPatternEnvironment != null)
			analyzerError("Repeated createGuardPatternEnvironment", "BottomPattern", patternCS);
		guardPatternEnvironment = new QVTcGuardPatternEnvironment(this, patternCS);
		return guardPatternEnvironment;
	}

	public abstract Area getArea();
	
	/**
	 * Return the set of all areas that contribute definitions visible in this area
	 * from this mapping and its transitive refinements. (Does not include further
	 * contributions from contexts.)
	 */
	public Set<QVTcAreaEnvironment<?>> getAreaEnvironmentPartialClosure() {
		if (areaEnvironmentPartialClosure == null)		
			areaEnvironmentPartialClosure = computeAreaEnvironmentPartialClosure();
		return areaEnvironmentPartialClosure;
	}
	
	public QVTcBottomPatternEnvironment getBottomPatternEnvironment() {
		return bottomPatternEnvironment;
	}

	/**
	 * Return the set of all guard and bottom patterns that contribute to the bottom pattern of this area.
	 */
	public Set<QVTcPatternEnvironment<?>> getBottomPatternEnvironmentClosure() {
		if (bottomPatternEnvironmentClosure == null)		
			bottomPatternEnvironmentClosure = computeBottomPatternEnvironmentClosure();
		return bottomPatternEnvironmentClosure;
	}

	/**
	 * Return the corresponding area environment of the context mapping, or null if this is a root mapping area.
	 */
	public abstract QVTcAreaEnvironment<?> getContextEnvironment();
	
	public QVTcGuardPatternEnvironment getGuardPatternEnvironment() {
		return guardPatternEnvironment;
	}

	/**
	 * Return the set of all guard and bottom patterns that contribute to the guard pattern of this area.
	 */
	public Set<QVTcPatternEnvironment<?>> getGuardPatternEnvironmentClosure() {
		if (guardPatternEnvironmentClosure == null)		
			guardPatternEnvironmentClosure = computeGuardPatternEnvironmentClosure();
		return guardPatternEnvironmentClosure;
	}

	public abstract QVTcMappingEnvironment<?> getMappingEnvironment();

	public String getModelName() { return modelName; }

	public TypedModel getTypedModel() { return typedModel; }

	protected Set<TypedModel> getTypedModelClosure() {
		if (typedModelClosure == null)
			typedModelClosure = computeTypedModelClosure();
		return typedModelClosure;
	}

	protected Set<EPackage> getUsedPackageClosure() {
		if (usedPackageClosure == null)
			usedPackageClosure = computeUsedPackageClosure();
		return usedPackageClosure;
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		EClassifier eClassifier = tryLookupClassifier(getUsedPackageClosure(), names);
		if (eClassifier != null)
			return eClassifier;
		return null; //super.tryLookupClassifier(names);
	}
	
	@Override
	public String toString() {
		String parentString = getInternalParent() != null ? (getInternalParent().toString() + ".") : "";
		return parentString + getModelName();
	}
}
