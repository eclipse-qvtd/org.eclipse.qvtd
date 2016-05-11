/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor.Registry;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.importer.ecore.EcoreImporter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreGeneratorAdapterFactory;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.util.DerivedConstants;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QVTrToQVTc
{
	public static final @NonNull TracingOption SYNTHESIS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtr2qvtc/synthesis");

	private class Issues {

		public void addError(QVTrToQVTc qvTrToQVTc, String message,
				Object object, Object object2, Throwable throwable,
				List<Object> data) {
			System.err.println(message);
		}

		public void addWarning(QVTrToQVTc qvTrToQVTc, String message,
				Object object, Object object2, Throwable throwable,
				List<Object> data) {
			System.out.println(message);
		}

		public void addError(QVTrToQVTc qvTrToQVTc, String string) {
			System.err.println(string);
		}

		public void addWarning(QVTrToQVTc qvTrToQVTc, String string) {
			System.out.println(string);
		}
		
	}
	
	protected final @NonNull EnvironmentFactory environmentFactory;	
	private final @NonNull Resource qvtrResource;
	private final @NonNull Resource qvtcResource;
	protected final @NonNull QVTcoreHelper helper;
	
	/**
	 * Optional configuration of the NsURI of the trace package.
	 */
	private @Nullable String traceNsURI = null;
	private final @NonNull Map<@NonNull Element, @NonNull Element> globalTarget2source = new HashMap<@NonNull Element, @NonNull Element>();
	private final @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>> globalSource2targets = new HashMap<@NonNull Element, @NonNull List<@NonNull Element>>();
	
	private final @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> tracePackages = new ArrayList<org.eclipse.ocl.pivot.@NonNull Package>();
//	private final @NonNull List<@NonNull Transformation> coreTransformations = new ArrayList<@NonNull Transformation>();
	private final @NonNull Map<@NonNull Relation, org.eclipse.ocl.pivot.@NonNull Class> relationToTraceClass = new HashMap<@NonNull Relation, org.eclipse.ocl.pivot.@NonNull Class>();
	// Un-navigable opposites
	//
	//	The Key that identifies each Class.
	// FIXME can there be two keys for the sane Class?
	//
	private final @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Key> class2key = new HashMap<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Key>();
	private final @NonNull Map<@NonNull Variable, @NonNull TemplateExp> variable2templateExp = new HashMap<@NonNull Variable, @NonNull TemplateExp>();
	private final @NonNull Map<@NonNull Relation, @NonNull List<@NonNull RelationCallExp>> relationCallExpsForRelation = new HashMap<@NonNull Relation, @NonNull List<@NonNull RelationCallExp>>();
	private final @NonNull Map<@NonNull RelationCallExp, @NonNull Relation> rInvocation2invokingRelation = new HashMap<@NonNull RelationCallExp, @NonNull Relation>();
	
	private @NonNull CoreModel coreModel;

	/**
	 * The core Transformation for each RelationalTransformation.
	 */
	private @NonNull Map<@NonNull RelationalTransformation, @NonNull Transformation> relationalTransformation2coreTransformation
			= new HashMap<@NonNull RelationalTransformation, @NonNull Transformation>();	

	/**
	 * The trace Package for each RelationalTransformation.
	 */
	private @NonNull Map<@NonNull RelationalTransformation, org.eclipse.ocl.pivot.@NonNull Package> relationalTransformation2tracePackage
			= new HashMap<@NonNull RelationalTransformation, org.eclipse.ocl.pivot.@NonNull Package>();	
	
	/**
	 * The lazily created named CoreDomain in each Rule.
	 */
	private @NonNull Map<@NonNull Rule, @NonNull Map<@NonNull String, @NonNull CoreDomain>> rule2name2coreDomain
			= new HashMap<@NonNull Rule, @NonNull Map<@NonNull String, @NonNull CoreDomain>>();	
	
	/**
	 * The lazily created named Trace Properties in each Trace Class.
	 */
	private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Map<@NonNull String, @NonNull Property>> traceClass2name2traceProperty
			= new HashMap<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Map<@NonNull String, @NonNull Property>>();	

	/**
	 * The lazily created named Core mappings for each transformation.
	 */
	private @NonNull Map<@NonNull Transformation, @NonNull Map<@NonNull String, @NonNull Mapping>> transformation2name2mapping
			= new HashMap<@NonNull Transformation, @NonNull Map<@NonNull String, @NonNull Mapping>>();
	
	public QVTrToQVTc(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull Resource qvtcResource) {	
		this.environmentFactory = environmentFactory;
		this.qvtrResource = qvtrResource;		
		this.qvtcResource = qvtcResource;
//		this.traceResource = traceResource;
		this.helper = new QVTcoreHelper(environmentFactory);
		this.coreModel = QVTcoreFactory.eINSTANCE.createCoreModel();
        
		// Create a cache of opposite relations and copy imports
		TreeIterator<EObject> it = qvtrResource.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Key) {
				Key key = (Key)eo;
				org.eclipse.ocl.pivot.Class identifies = key.getIdentifies();
				assert identifies != null;
				class2key.put(identifies, key);
			}
			// Populate bindsTo of DomainPattern
			if (eo instanceof Pattern) {
				Pattern p = (Pattern) eo;
				for (Predicate pred : p.getPredicate()) {
					OCLExpression conditionExpression = pred.getConditionExpression();
					assert conditionExpression != null;
					p.getBindsTo().addAll(getVarsOfExp(conditionExpression));
				}
				if (eo instanceof DomainPattern) {
					DomainPattern dp = (DomainPattern) eo;
					TemplateExp te = dp.getTemplateExpression();
					dp.getBindsTo().add(te.getBindsTo());
					if (te instanceof ObjectTemplateExp) {
						dp.getBindsTo().addAll(getNestedBindToVariable((ObjectTemplateExp) te));
					}
				}
			}
			if (eo instanceof TemplateExp) {
				TemplateExp te = (TemplateExp) eo;
				Variable bindsTo = te.getBindsTo();
				assert bindsTo != null;
				variable2templateExp.put(bindsTo, te);
			}
			if (eo instanceof RelationCallExp) {
				RelationCallExp ri = (RelationCallExp) eo; 
				Relation r = ri.getReferredRelation();
				assert r != null;
				Predicate p = (Predicate) ri.eContainer();
				Pattern pattern = p.getPattern();
				if (pattern.eContainer() instanceof Relation) {
					Relation ir = (Relation) pattern.eContainer();
					if (ir.getWhere() == pattern) {
						List<RelationCallExp> relationCallExps = relationCallExpsForRelation.get(r);
						if (relationCallExps != null) {
							relationCallExps.add(ri);
						} else {
							List<RelationCallExp> callExps = new ArrayList<RelationCallExp>();
							callExps.add(ri);
							relationCallExpsForRelation.put(r, callExps);
						}
						rInvocation2invokingRelation.put(ri, ir);
					}
				}
			}
			if (eo instanceof Import) {
				this.coreModel.getOwnedImports().add((Import) EcoreUtil.copy(eo));
			}
		}
	}
	
	public @NonNull Mapping createMapping() {
		Mapping coreMapping = QVTcoreFactory.eINSTANCE.createMapping();
		GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
		coreMapping.setGuardPattern(guardPattern);
		BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		coreMapping.setBottomPattern(bottomPattern);
		return coreMapping;
	}

	// Save the qvtc resource
	public void dispose() {
		// What about the trace model? we need to separate them
		//qvtcSource.getContents().addAll(traceData.getRootOutputELements());
	}

	public void execute() throws CompilerChainException {
		transformToTracePackages();
		transformToCoreTransformations();
	}

	/*public*/ @NonNull Transformation getCoreTransformation(@NonNull RelationalTransformation relationalTransformation) {
		return ClassUtil.nonNullState(relationalTransformation2coreTransformation.get(relationalTransformation));
	}
	
/*	public @NonNull DomainPattern getDomainPattern(@NonNull Domain d) {
		List<@NonNull DomainPattern> pattern = ClassUtil.nullFree(((RelationDomain) d).getPattern());
		assert pattern.size() == 1;
		DomainPattern domainPattern = pattern.get(0);
		assert domainPattern != null;
		return domainPattern;
	} */

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}
	
	/*public*/ @NonNull Relation getInvokingRelationForRelationCallExp(@NonNull RelationCallExp rInvocation) {	
		return ClassUtil.nonNullState(rInvocation2invokingRelation.get(rInvocation));
	}

	public @Nullable Key getKeyforType(@NonNull Type type) {
		return class2key.get(type);
	}
	
	// TODO bug 453863 // ?? this is suspect for more than 2 domains. // FIXME What is 'shared'? a) any two domains b) output/any-input c) all domains
	/**
	 * Return the variables that are used by more than one domain of the relation and so must be middle variables.
	 */
	public @NonNull Set<@NonNull Variable> getMiddleDomainVariables(@NonNull Relation rRelation) {	
		Set<@NonNull Variable> rDomainVariables = new HashSet<@NonNull Variable>();
		Set<@NonNull Variable> rMiddleDomainVariables = new HashSet<@NonNull Variable>();
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			for (@NonNull DomainPattern rDomainPattern : ClassUtil.nullFree(((RelationDomain)rDomain).getPattern())) {
				for (@NonNull Variable rVariable : ClassUtil.nullFree(rDomainPattern.getBindsTo())) {
					if (!rDomainVariables.add(rVariable)) {
						rMiddleDomainVariables.add(rVariable);				// Accumulate second (and higher) usages
					}
				}
			}
		}
		return rMiddleDomainVariables;
	}
	
	private @NonNull Set<@NonNull Variable> getNestedBindToVariable(@NonNull ObjectTemplateExp ote) {
		Set<@NonNull Variable> vars = new HashSet<@NonNull Variable>();
		for (PropertyTemplateItem p : ote.getPart()) {
			OCLExpression e = p.getValue();
			assert e != null;
			if (e instanceof ObjectTemplateExp) {
				Variable bindsTo = ((ObjectTemplateExp)e).getBindsTo();
				assert bindsTo != null;
				vars.add(bindsTo);
				vars.addAll(getNestedBindToVariable((ObjectTemplateExp) e));
			} else {
				vars.addAll(getVarsOfExp(e));
			}
		}
		return vars;
	}
	
	public Predicate getPredicateForRelationCallExp(RelationCallExp ri) {
		// TODO Auto-generated method stub
		return null;
	}

	public @NonNull String getProjectName(@NonNull URI traceURI) {
		URI trimFileExtension = traceURI.trimFileExtension();
		if (trimFileExtension.isPlatform()) {
			return trimFileExtension.segment(1);
		}
		else {
			return trimFileExtension.segment(0);
		}
	}
	
	/**
	 * @return the qvtcSource
	 */
	public Resource getQvtcSource() {
		return qvtcResource;
	}

	public @NonNull List<@NonNull RelationCallExp> getRelationCallExpsForRelation(@NonNull Relation r) {		
		return ClassUtil.nonNullState(relationCallExpsForRelation.get(r));
	}
	
	/* =============  Queries ============= */

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	/*public*/ @Nullable TemplateExp getTemplateExpression(@NonNull Variable dv) {		
		return variable2templateExp.get(dv);
	}
	
	/*public*/ org.eclipse.ocl.pivot.@NonNull Class getTraceClass(@NonNull Relation relation) {		
		return ClassUtil.nonNullState(relationToTraceClass.get(relation));
	}

	/*public*/ org.eclipse.ocl.pivot.@NonNull Package getTracePackage(@NonNull RelationalTransformation relationalTransformation) {
		return ClassUtil.nonNullState(relationalTransformation2tracePackage.get(relationalTransformation));
	}
	
	/*
	 * Get variables occurring in an OCL expression
	 */
	public @NonNull Set<@NonNull Variable> getVarsOfExp(@NonNull OCLExpression e) {		
		Set<@NonNull Variable> variables = new HashSet<@NonNull Variable>();
		for (EObject eObject : new TreeIterable(e, true)) {
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				if (referredVariable instanceof Variable) {
					variables.add((Variable)referredVariable);
				}
			}
			else if (eObject instanceof Variable) {
				variables.add((Variable)eObject);
			}
			else if (eObject instanceof TemplateExp) {
				Variable bindsTo = ((TemplateExp)eObject).getBindsTo();
				if (bindsTo != null) {
					variables.add(bindsTo);
				}
				if (eObject instanceof CollectionTemplateExp) {
					Variable rest = ((CollectionTemplateExp)eObject).getRest();
					if (rest != null) {
						variables.add(rest);
					}
				}
			}
		}
		return variables;
	}

	// Create the top rules, and search the input model for the appropriate types, when possible?
	public void prepare() {
		try {
			qvtrResource.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// EXIT!
		} finally {
//			if (qvtrModel.isLoaded()) {
				//RuleFactory factory = new RuleFactory();
				//rules = factory.createTopRules(this);
//				ruleFactories = new Rule.Factory[] {
//						RelationalTransformationToMappingTransformation.FACTORY,
//						RelationToTraceClass.FACTORY
//				};
//			}
		}
	}
	
	/*public*/ void putCoreTransformation(@NonNull RelationalTransformation relationTransformation, @NonNull Transformation coreTransformation) {		
		relationalTransformation2coreTransformation.put(relationTransformation, coreTransformation);
		putGlobalTrace(coreTransformation, relationTransformation);
	}
	
	/*private*/ void putGlobalTrace(@NonNull Element coreElement, @NonNull Element relationElement) {
//		if (relationElement != null) {
			Element oldRelationElement = globalTarget2source.put(coreElement, relationElement);
			assert oldRelationElement == null;
			List<@NonNull Element> targets = globalSource2targets.get(relationElement);
			if (targets == null) {
				targets = new ArrayList<@NonNull Element> ();
				globalSource2targets.put(relationElement, targets);
			}
			targets.add(coreElement);
//		}
	}

	/*public*/ void putRelationTrace(@NonNull Relation r, org.eclipse.ocl.pivot.@NonNull Class traceClass) {		
		relationToTraceClass.put(r, traceClass);
//		putTrace(traceClass, r);
	}
	
	/*public*/ void putTracePackage(@NonNull RelationalTransformation rt, org.eclipse.ocl.pivot.@NonNull Package tracePackage) {		
		relationalTransformation2tracePackage.put(rt, tracePackage);
//		putTrace(tracePackage, rt);
	}
	
	protected void reportDiagnostics(Issues issues, Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		if (severity != Diagnostic.OK) {
			List<Diagnostic> children = diagnostic.getChildren();
			if (children.size() > 0) {
				for (Diagnostic child : children) {
					severity = child.getSeverity();
					@SuppressWarnings("unchecked") List<Object> data = (List<Object>) child.getData();
					Throwable throwable = null;
					String message;
					if ((data.size() == 1) && (data.get(0) instanceof Throwable)) {
						throwable = (Throwable) data.get(0);
						data = null;
						message = child.getMessage();
					}
					else {
						message = child.toString();
					}
					if (severity == Diagnostic.ERROR) {
						issues.addError(this, message, null, null, throwable, data);
					}
					else if (severity == Diagnostic.WARNING) {
						issues.addWarning(this, message, null, null, throwable, data);
					}
				}
			}
			else {
				if (severity == Diagnostic.ERROR) {
					issues.addError(this, diagnostic.toString());
				}
				else if (severity == Diagnostic.WARNING) {
					issues.addWarning(this, diagnostic.toString());
				}
			}
		}
	}

	public void saveCore(@NonNull Resource asResource, @NonNull Map<?, ?> options) throws IOException {
        asResource.getContents().add(this.coreModel);
        // Copy imports
        
        for (org.eclipse.ocl.pivot.@NonNull Package asPackage : tracePackages) {
            Import asImport = helper.createImport(null, asPackage);
            coreModel.getOwnedImports().add(asImport);
        }
//		-- scan for dangling references if this is really wanted
//		for (EObject eObject : potentialOrphans) {
//			if (eObject.eContainer() == null) {
//				asResource.getContents().add(eObject);
//			}
//		}
		asResource.save(options);
	}

	public @NonNull GenModel saveGenModel(@NonNull Resource asResource, @NonNull URI traceURI, @NonNull URI genModelURI, @Nullable Map<@NonNull String, @Nullable String> genModelOptions, @NonNull Map<Object, Object> saveOptions2, @Nullable Collection<@NonNull ? extends GenPackage> usedGenPackages) throws IOException {
		URI trimFileExtension = traceURI.trimFileExtension();
		String projectName = getProjectName(traceURI);
		Resource genmodelResource = environmentFactory.getResourceSet().createResource(genModelURI);
		@SuppressWarnings("null")@NonNull GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.getForeignModel().add(traceURI.lastSegment());
		String copyrightText = genModelOptions != null ? genModelOptions.get(CompilerChain.GENMODEL_COPYRIGHT_TEXT) : null;
		if (copyrightText != null) {
			genModel.setCopyrightText(copyrightText);
		}
		if (usedGenPackages != null) {
			genModel.getUsedGenPackages().addAll(usedGenPackages);
		}
		genModel.setModelDirectory("/" + projectName + "/test-gen");
		genModel.setModelPluginID(projectName);
		genModel.setModelName(trimFileExtension.lastSegment());
		genModel.setBundleManifest(false);
		genModel.setUpdateClasspath(false);
		genModel.setImporterID(new EcoreImporter().getID());
		genModel.setComplianceLevel(GenJDKLevel.JDK80_LITERAL);
		genModel.setCopyrightFields(false);
		genModel.setOperationReflection(true);
		genModel.setImportOrganizing(true);
		genModel.setRootExtendsClass(MinimalEObjectImpl.Container.class.getName());
		genModel.setPluginKey("");
		genmodelResource.getContents().add(genModel);
		String basePrefix = genModelOptions != null ? genModelOptions.get(CompilerChain.GENMODEL_BASE_PREFIX) : null;
		List<GenPackage> genPackages = genModel.getGenPackages();
		for (EObject eObject : asResource.getContents()) {
			if (eObject instanceof Model) {
				Model asModel = (Model)eObject;
				for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(asModel.getOwnedPackages())) {
					GenPackage genPackage = genModel.createGenPackage();
					EPackage ePackage = (EPackage) asPackage.getESObject();
					genPackage.setEcorePackage(ePackage);
					genPackage.setPrefix(ePackage.getName());
					if (basePrefix != null) {
						genPackage.setBasePackage(basePrefix);
					}
					genPackages.add(genPackage);
				}
				Set<org.eclipse.ocl.pivot.@NonNull Package> asPackages = new HashSet<org.eclipse.ocl.pivot.@NonNull Package>();
				for (EObject element : new TreeIterable(asModel, false)) {
					if (element instanceof Property) {
						Property property = (Property)element;
						Type type = property.getType();
						while (type instanceof CollectionType) {
							type = ((CollectionType)type).getElementType();
						}
						if (type instanceof org.eclipse.ocl.pivot.Class) {
							 org.eclipse.ocl.pivot.Package asPackage = ((org.eclipse.ocl.pivot.Class)type).getOwningPackage();
							 if (asPackage != null) {
								 asPackages.add(asPackage);
							 }
						}
					}
				}
				for (@NonNull Import asImport : ClassUtil.nullFree(asModel.getOwnedImports())) {
					Namespace asNamespace = asImport.getImportedNamespace();
					if (asNamespace instanceof org.eclipse.ocl.pivot.Package) {
						org.eclipse.ocl.pivot.@NonNull Package asPackage = (org.eclipse.ocl.pivot.Package)asNamespace;
						asPackages.add(asPackage);
					}
				}
				List<org.eclipse.ocl.pivot.@NonNull Package> asPackageList = new ArrayList<org.eclipse.ocl.pivot.@NonNull Package>(asPackages);
				Collections.sort(asPackageList, NameUtil.NAMEABLE_COMPARATOR);
				for (org.eclipse.ocl.pivot.@NonNull Package asPackage : asPackageList) {
					EPackage ePackage = (EPackage) asPackage.getESObject();
					if (ePackage != null) {
						GenPackage genPackage = null;
						if (usedGenPackages != null) {
							for (@NonNull GenPackage usedGenPackage : usedGenPackages) {
								EPackage ecorePackage = usedGenPackage.getEcorePackage();
								if ((ecorePackage != null) && ClassUtil.safeEquals(ecorePackage.getNsURI(), ePackage.getNsURI())) {
									genPackage = usedGenPackage;
									break;
								}
							}		
						}
						if (genPackage == null) {
							genPackage = genModel.createGenPackage();
							genPackage.setEcorePackage(ePackage);
							genPackage.setPrefix(ePackage.getName());
							if (basePrefix != null) {
								genPackage.setBasePackage(basePrefix);
							}
							genPackages.add(genPackage);
						}
					}
				}
			}
		}
		genModel.reconcile();
		Map<Object, Object> saveOptions = new HashMap<Object, Object>(saveOptions2);
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveOptions.put(DerivedConstants.RESOURCE_OPTION_LINE_DELIMITER, "\n");
	    saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
	    saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);
		genmodelResource.save(saveOptions);
		return genModel;
	}

	public void generateModels(@NonNull GenModel genModel) {
		Registry generatorAdapterDescriptorRegistry = GeneratorAdapterFactory.Descriptor.Registry.INSTANCE;
		if (!generatorAdapterDescriptorRegistry.getDescriptors(GenModelPackage.eNS_URI).contains(GenModelGeneratorAdapterFactory.DESCRIPTOR)) {
			generatorAdapterDescriptorRegistry.addDescriptor(GenModelPackage.eNS_URI, GenModelGeneratorAdapterFactory.DESCRIPTOR);
		}
		if (!generatorAdapterDescriptorRegistry.getDescriptors(GenModelPackage.eNS_URI).contains(OCLinEcoreGeneratorAdapterFactory.DESCRIPTOR)) {
			generatorAdapterDescriptorRegistry.addDescriptor(GenModelPackage.eNS_URI, OCLinEcoreGeneratorAdapterFactory.DESCRIPTOR);
		}
//**		ResourceUtils.checkResourceSet(resourceSet);
		// genModel.setCanGenerate(true);
		// validate();

		
		
		genModel.setValidateModel(true); // The more checks the better
//		genModel.setCodeFormatting(true); // Normalize layout
		genModel.setForceOverwrite(false); // Don't overwrite read-only
											// files
		genModel.setCanGenerate(true);
		// genModel.setFacadeHelperClass(null); // Non-null gives JDT
		// default NPEs
//		genModel.setFacadeHelperClass(ASTFacadeHelper.class.getName()); // Bug 308069
		// genModel.setValidateModel(true);
//		genModel.setBundleManifest(false); // New manifests should be
//											// generated manually
//		genModel.setUpdateClasspath(false); // New class-paths should be
//											// generated manually
//		if (genModel.getComplianceLevel().compareTo(GenJDKLevel.JDK50_LITERAL) < 0) {
//			genModel.setComplianceLevel(GenJDKLevel.JDK50_LITERAL);
//		}
		// genModel.setRootExtendsClass("org.eclipse.emf.ecore.impl.MinimalEObjectImpl$Container");
		Diagnostic diagnostic = genModel.diagnose();
		reportDiagnostics(new Issues(), diagnostic);

		/*
		 * JavaModelManager.getJavaModelManager().initializePreferences();
		 * new
		 * JavaCorePreferenceInitializer().initializeDefaultPreferences();
		 * 
		 * GenJDKLevel genSDKcomplianceLevel =
		 * genModel.getComplianceLevel(); String complianceLevel =
		 * JavaCore.VERSION_1_5; switch (genSDKcomplianceLevel) { case
		 * JDK60_LITERAL: complianceLevel = JavaCore.VERSION_1_6; case
		 * JDK14_LITERAL: complianceLevel = JavaCore.VERSION_1_4; default:
		 * complianceLevel = JavaCore.VERSION_1_5; } // Hashtable<?,?>
		 * defaultOptions = JavaCore.getDefaultOptions(); //
		 * JavaCore.setComplianceOptions(complianceLevel, defaultOptions);
		 * // JavaCore.setOptions(defaultOptions);
		 */

//		Generator generator = new Generator();
//		generator.setInput(genModel);
		Generator generator = GenModelUtil.createGenerator(genModel);
		Monitor monitor = /*showProgress ? new LoggerMonitor(log) :*/ new BasicMonitor();
		diagnostic = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, monitor);
		reportDiagnostics(new Issues(), diagnostic);
	}


	public @NonNull Resource saveTrace(@NonNull Resource asResource, @NonNull URI traceURI, @NonNull URI genModelURI, @Nullable Map<@NonNull String, @Nullable String> traceOptions, @NonNull Map<?, ?> saveOptions) throws IOException {
        Model root = PivotFactory.eINSTANCE.createModel();
		root.setExternalURI(traceURI.toString());
        asResource.getContents().add(root);
		if ((traceNsURI != null) && (tracePackages.size() == 1)) {
			tracePackages.get(0).setURI(traceNsURI);
		}
        root.getOwnedPackages().addAll(tracePackages);
		AS2Ecore as2ecore = new AS2Ecore((EnvironmentFactoryInternal) environmentFactory, traceURI, null);
		XMLResource ecoreResource = as2ecore.convertResource(asResource, traceURI);
		ecoreResource.save(saveOptions);
		return ecoreResource;
	}

	public void setTraceNsURI(@Nullable String traceNsURI) {
		this.traceNsURI = traceNsURI;
	}

	public void transformToCoreTransformations() throws CompilerChainException {
		for (@NonNull EObject eObject : qvtrResource.getContents()) {
			if (eObject instanceof RelationModel) {
				RelationModel relationModel = (RelationModel)eObject;
				String externalURI = relationModel.getExternalURI();
				if (externalURI.endsWith(".qvtras")) {
					externalURI = externalURI.replace(".qvtras", ".qvtcas");
				}
				else if (externalURI.endsWith(".qvtr")) {
					externalURI = externalURI.replace(".qvtr", ".qvtcas");
				}
				coreModel.setExternalURI(externalURI);
				transformToCoreTransformations(ClassUtil.nullFree(coreModel.getOwnedPackages()), ClassUtil.nullFree(relationModel.getOwnedPackages()));
//				CompilerUtil.normalizeNameables(coreTransformations);
			}
		}
		List<@NonNull RelationalTransformation> relationalTransformations = new ArrayList<@NonNull RelationalTransformation>(relationalTransformation2coreTransformation.keySet());
		Collections.sort(relationalTransformations, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull RelationalTransformation relationalTransformation : relationalTransformations) {
			List<@NonNull Rule> rules = new ArrayList<@NonNull Rule>(ClassUtil.nullFree(relationalTransformation.getRule()));
			Collections.sort(rules, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull Rule rule : rules) {
				if (rule instanceof Relation) {
					Relation rRelation = (Relation)rule;
					if (rRelation.isIsTopLevel()) {
						QVTrToQVTc.SYNTHESIS.println("topLevel " + rRelation);
						TopLevelRelationToMappingForEnforcement topLevelRelationToMappingForEnforcement = new TopLevelRelationToMappingForEnforcement(this, rRelation);
						topLevelRelationToMappingForEnforcement.doTopLevelRelationToMappingForEnforcement();
					}
				}
			}
//		}
//		for (@NonNull RelationalTransformation relationalTransformation : relationalTransformations) {
//			List<@NonNull Rule> rules = new ArrayList<@NonNull Rule>(ClassUtil.nullFree(relationalTransformation.getRule()));
//			Collections.sort(rules, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull Rule rule : rules) {
				if (rule instanceof Relation) {
					Relation rRelation = (Relation)rule;
					if (!rRelation.isIsTopLevel()) {
						InvokedRelationToMappingForEnforcement invokedRelationToMappingForEnforcement = new InvokedRelationToMappingForEnforcement(this, rRelation);
						invokedRelationToMappingForEnforcement.doInvokedRelationToMappingForEnforcement();
					}
				}
			}
		}
/*		for (@NonNull Transformation coreTransformation : relationalTransformation2coreTransformation.values()) {
			List<DebugTraceBack> debugTraceBacks = coreTransformation.getOwnedDebugTraceBacks();
			for (@NonNull Element target : target2source.keySet()) {
				if (QVTbaseUtil.getContainingTransformation(target) == coreTransformation) {
					DebugTraceBack traceBack = QVTbaseFactory.eINSTANCE.createDebugTraceBack();
					traceBack.setTarget(target);
// FIXME true source URI					traceBack.getSources().add(target2source.get(target));
					debugTraceBacks.add(traceBack);
				}
			}
//			CompilerUtil.normalizeNameables(debugTraceBacks);
		} */
	}


	private void transformToCoreTransformations(@NonNull List<org.eclipse.ocl.pivot.@NonNull Package> corePackages, @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> relationPackages) {
		for (org.eclipse.ocl.pivot.@NonNull Package relationPackage : relationPackages) {
			String name = relationPackage.getName();
			assert name != null;
			org.eclipse.ocl.pivot.@NonNull Package corePackage = helper.createPackage(name, relationPackage.getNsPrefix(), relationPackage.getURI());
			corePackages.add(corePackage);
			for (org.eclipse.ocl.pivot.@NonNull Class relationClass : ClassUtil.nullFree(relationPackage.getOwnedClasses())) {
				if (relationClass instanceof RelationalTransformation) {
					RelationalTransformationToMappingTransformation relationalTransformationToMappingTransformation = new RelationalTransformationToMappingTransformation(this);
					Transformation coreTransformation = relationalTransformationToMappingTransformation.doRelationalTransformationToMappingTransformation((RelationalTransformation)relationClass);
					corePackage.getOwnedClasses().add(coreTransformation);
				}
			}
			transformToCoreTransformations(ClassUtil.nullFree(corePackage.getOwnedPackages()), ClassUtil.nullFree(relationPackage.getOwnedPackages()));
		}
	}

	public @NonNull List<@NonNull Package> transformToTracePackages() {
		for (@NonNull EObject eObject : qvtrResource.getContents()) {
			if (eObject instanceof RelationModel) {
				transformToTracePackages(tracePackages, ClassUtil.nullFree(((RelationModel)eObject).getOwnedPackages()));
				CompilerUtil.normalizeNameables(tracePackages);
			}
		}
		return tracePackages;
	}
	
	private void transformToTracePackages(@NonNull List<org.eclipse.ocl.pivot.@NonNull Package> tracePackages, @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> relationPackages) {
		for (org.eclipse.ocl.pivot.@NonNull Package relationPackage : relationPackages) {
			for (org.eclipse.ocl.pivot.@NonNull Class relationClass : ClassUtil.nullFree(relationPackage.getOwnedClasses())) {
				if (relationClass instanceof RelationalTransformation) {
					RelationalTransformationToTracePackage relationalTransformationToTracePackage = new RelationalTransformationToTracePackage(this);
					org.eclipse.ocl.pivot.Package tracePackage = relationalTransformationToTracePackage.doRelationalTransformationToTracePackage((RelationalTransformation)relationClass);
					tracePackages.add(tracePackage);
				}
			}
			transformToTracePackages(tracePackages, ClassUtil.nullFree(relationPackage.getOwnedPackages()));
		}
	}

	/**
	 * Lazily create the name CoreDomain for a coreRule.
	 */
	/*public*/ @NonNull CoreDomain whenCoreDomain(@NonNull Rule coreRule, @NonNull String name) {
		Map<@NonNull String, @NonNull CoreDomain> name2coreDomain = rule2name2coreDomain.get(coreRule);
		if (name2coreDomain == null) {
			name2coreDomain = new HashMap<@NonNull String, @NonNull CoreDomain>();
			rule2name2coreDomain.put(coreRule, name2coreDomain);
		}
		CoreDomain coreDomain = name2coreDomain.get(name);
		if (coreDomain == null) {
			coreDomain = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
			coreDomain.setName(name);
			coreDomain.setRule(coreRule);
			name2coreDomain.put(name, coreDomain);
//			putTrace(coreDomain, coreRule);
			GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			coreDomain.setGuardPattern(guardPattern);
//			putTrace(guardPattern, coreRule);
			BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			coreDomain.setBottomPattern(bottomPattern);
//			putTrace(bottomPattern, coreRule);
		}
		return coreDomain;
	}

	/**
	 * Lazily create the name Mapping for a coreTransformation.
	 */
	/*public*/ @NonNull Mapping whenMapping(@NonNull Relation relation, @NonNull String name) {
		RelationalTransformation rt = (RelationalTransformation) relation.getTransformation();
		assert rt != null;
		@NonNull Transformation coreTransformation = getCoreTransformation(rt);
		Map<@NonNull String, @NonNull Mapping> name2mapping = transformation2name2mapping.get(coreTransformation);
		if (name2mapping == null) {
			name2mapping = new HashMap<@NonNull String, @NonNull Mapping>();
			transformation2name2mapping.put(coreTransformation, name2mapping);
		}
		Mapping coreMapping = name2mapping.get(name);
		if (coreMapping == null) {
			coreMapping = createMapping();
			putGlobalTrace(coreMapping, relation);
			coreMapping.setName(name);
			coreMapping.setTransformation(coreTransformation);
			name2mapping.put(name, coreMapping);
		}
		return coreMapping;
	}
	
	/**
	 * Lazily create the name Property for a traceClass with a type.
	 */
	/*public*/ @NonNull Property whenTraceProperty(org.eclipse.ocl.pivot.@NonNull Class traceClass, @NonNull String name, @NonNull Type type, boolean isRequired) {
		Map<@NonNull String, @NonNull Property> name2traceProperty = traceClass2name2traceProperty.get(traceClass);
		if (name2traceProperty == null) {
			name2traceProperty = new HashMap<@NonNull String, @NonNull Property>();
			traceClass2name2traceProperty.put(traceClass, name2traceProperty);
		}
		Property traceProperty = name2traceProperty.get(name);
		if (traceProperty == null) {
			traceProperty = PivotFactory.eINSTANCE.createProperty();
			traceProperty.setName(name);
			traceProperty.setType(type);
			traceProperty.setIsRequired(isRequired);
			name2traceProperty.put(name, traceProperty);
			traceProperty.setOwningClass(traceClass);
			if (!(type instanceof DataType)) {
				Property oppositeProperty = PivotFactory.eINSTANCE.createProperty();
				oppositeProperty.setName(traceClass.getName());		// FIXME unique, mutable Class
				oppositeProperty.setType(traceClass);
				oppositeProperty.setIsRequired(true);
				oppositeProperty.setIsImplicit(true);
				oppositeProperty.setOwningClass((org.eclipse.ocl.pivot.@NonNull Class)type);
				traceProperty.setOpposite(oppositeProperty);
				oppositeProperty.setOpposite(traceProperty);
//				putTrace(oppositeProperty, type);
			}
//			putTrace(traceProperty, traceClass);
		}
		else {
			assert traceProperty.getType() == type;
		}
		return traceProperty;
	}
}
