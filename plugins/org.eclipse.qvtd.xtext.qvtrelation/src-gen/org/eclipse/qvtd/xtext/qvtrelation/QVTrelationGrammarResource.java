/*******************************************************************************
 * Copyright (c) 2015, 2023 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************
 * This code is 100% auto-generated
 * from: E:\GIT\org.eclipse.qvtd\releng..\..\plugins\org.eclipse.qvtd.xtext.qvtrelation\src-gen\org\eclipse\qvtd\xtext\qvtrelation\QVTrelation.xtextbin
 * by: org.eclipse.ocl.examples.build.xtend.generateGrammar.xtend
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtrelation;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.base.utilities.AbstractGrammarResource;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * QVTrelationGrammarResource provides a programmatically initialized org.eclipse.qvtd.xtext.qvtrelation.QVTrelation Grammar model avoiding
 * the speed limitations of the pre-Xtext 2.4 *.xmi models and the binary incompatibilities between differing *.xtextbin versions.
 * <p>
 * The grammar is immutable and is available as static INSTANCE and GRAMMAR fields.
 */
public class QVTrelationGrammarResource extends AbstractGrammarResource
{
	private static final @NonNull Grammar G_QVTrelation = createGrammar("org.eclipse.qvtd.xtext.qvtrelation.QVTrelation");
	private static final @NonNull Grammar G_QVTbase = createGrammar("org.eclipse.qvtd.xtext.qvtbase.QVTbase");
	private static final @NonNull Grammar G_EssentialOCL = createGrammar("org.eclipse.ocl.xtext.essentialocl.EssentialOCL");
	private static final @NonNull Grammar G_Base = createGrammar("org.eclipse.ocl.xtext.base.Base");

	/**
	 *	The shared immutable instance of the org.eclipse.qvtd.xtext.qvtrelation.QVTrelation Grammar resource.
	 */
	public static final @NonNull QVTrelationGrammarResource INSTANCE = new QVTrelationGrammarResource();

	/**
	 *	The shared immutable instance of the org.eclipse.qvtd.xtext.qvtrelation.QVTrelation Grammar model.
	 */
	public static final @NonNull Grammar GRAMMAR = (Grammar)INSTANCE.getContents().get(0);

	/**
	 *	The name of the language supported by this grammar.
	 */
	public static final @NonNull String LANGUAGE_NAME = "org.eclipse.qvtd.xtext.qvtrelation.QVTrelation";

	protected QVTrelationGrammarResource() {
		super(URI.createURI(LANGUAGE_NAME));
		List<EObject> contents = getContents();
		contents.add(_QVTrelation.initGrammar());
		contents.add(_QVTbase.initGrammar());
		contents.add(_EssentialOCL.initGrammar());
		contents.add(_Base.initGrammar());
	}

	/*
	 * This class should be bound to org.eclipse.xtext.service.GrammarProvider.
	 */
	@Singleton
	public static class GrammarProvider extends org.eclipse.xtext.service.GrammarProvider
	{
		@Inject
		public GrammarProvider(Provider<XtextResourceSet> resourceSetProvider) {
			super(LANGUAGE_NAME, resourceSetProvider);
		}

		@Override
		public Grammar getGrammar(Object requestor) {
			return QVTrelationGrammarResource.GRAMMAR;
		}
	}

	private static class _QVTrelation
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.eINSTANCE, null); // http://www.eclipse.org/qvt/2015/QVTrelationCS
		private static final @NonNull ReferencedMetamodel MM_base = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, "base"); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_essentialocl = createReferencedMetamodel(org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.eINSTANCE, "essentialocl"); // http://www.eclipse.org/ocl/2015/EssentialOCLCS
		private static final @NonNull ReferencedMetamodel MM_pivot = createReferencedMetamodel(org.eclipse.ocl.pivot.PivotPackage.eINSTANCE, "pivot"); // http://www.eclipse.org/ocl/2015/Pivot
		private static final @NonNull ReferencedMetamodel MM_qvtbase = createReferencedMetamodel(org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.eINSTANCE, "qvtbase"); // http://www.eclipse.org/qvt/2015/QVTbase
		private static final @NonNull ReferencedMetamodel MM_qvtbasecs = createReferencedMetamodel(org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage.eINSTANCE, "qvtbasecs"); // http://www.eclipse.org/ocl/2016/QVTbaseCS
		private static final @NonNull ReferencedMetamodel MM_qvtrelation = createReferencedMetamodel(org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage.eINSTANCE, "qvtrelation"); // http://www.eclipse.org/qvt/2015/QVTrelation

		private static final @NonNull ParserRule PR_CollectionTemplateCS = createParserRule("CollectionTemplateCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.COLLECTION_TEMPLATE_CS));
		private static final @NonNull ParserRule PR_DefaultValueCS = createParserRule("DefaultValueCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.DEFAULT_VALUE_CS));
		private static final @NonNull ParserRule PR_DomainCS = createParserRule("DomainCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.DOMAIN_CS));
		private static final @NonNull ParserRule PR_DomainPatternCS = createParserRule("DomainPatternCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.DOMAIN_PATTERN_CS));
		private static final @NonNull ParserRule PR_ElementTemplateCS = createParserRule("ElementTemplateCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.ELEMENT_TEMPLATE_CS));
		private static final @NonNull ParserRule PR_ExpCSOrTemplateCS = createParserRule("ExpCSOrTemplateCS", createTypeRef(MM_essentialocl, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_KeyDeclCS = createParserRule("KeyDeclCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.KEY_DECL_CS));
		private static final @NonNull ParserRule PR_ModelDeclCS = createParserRule("ModelDeclCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.MODEL_DECL_CS));
		private static final @NonNull ParserRule PR_ObjectTemplateCS = createParserRule("ObjectTemplateCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.OBJECT_TEMPLATE_CS));
		private static final @NonNull ParserRule PR_ParamDeclarationCS = createParserRule("ParamDeclarationCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.PARAM_DECLARATION_CS));
		private static final @NonNull ParserRule PR_PredicateCS = createParserRule("PredicateCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.PREDICATE_CS));
		private static final @NonNull ParserRule PR_PrimitiveTypeDomainCS = createParserRule("PrimitiveTypeDomainCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_CS));
		private static final @NonNull ParserRule PR_PrimitiveTypeDomainPatternCS = createParserRule("PrimitiveTypeDomainPatternCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.PRIMITIVE_TYPE_DOMAIN_PATTERN_CS));
		private static final @NonNull ParserRule PR_PropertyTemplateCS = createParserRule("PropertyTemplateCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.PROPERTY_TEMPLATE_CS));
		private static final @NonNull ParserRule PR_QVTrelationUnrestrictedName = createParserRule("QVTrelationUnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_QualifiedPackageCS = createParserRule("QualifiedPackageCS", createTypeRef(MM_qvtbasecs, org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS));
		private static final @NonNull ParserRule PR_QueryCS = createParserRule("QueryCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.QUERY_CS));
		private static final @NonNull ParserRule PR_RelationCS = createParserRule("RelationCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.RELATION_CS));
		private static final @NonNull ParserRule PR_ScopeNameCS = createParserRule("ScopeNameCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_TemplateCS = createParserRule("TemplateCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.TEMPLATE_CS));
		private static final @NonNull ParserRule PR_TopLevelCS = createParserRule("TopLevelCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.TOP_LEVEL_CS));
		private static final @NonNull ParserRule PR_TransformationCS = createParserRule("TransformationCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.TRANSFORMATION_CS));
		private static final @NonNull ParserRule PR_TypedRefCS = createParserRule("TypedRefCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypedTypeRefCS = createParserRule("TypedTypeRefCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_TYPE_REF_CS));
		private static final @NonNull ParserRule PR_UnitCS = createParserRule("UnitCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.IMPORT_CS));
		private static final @NonNull ParserRule PR_UnrestrictedName = createParserRule("UnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_VarDeclarationCS = createParserRule("VarDeclarationCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.VAR_DECLARATION_CS));
		private static final @NonNull ParserRule PR_VarDeclarationIdCS = createParserRule("VarDeclarationIdCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.VAR_DECLARATION_ID_CS));
		private static final @NonNull ParserRule PR_WhenCS = createParserRule("WhenCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.PATTERN_CS));
		private static final @NonNull ParserRule PR_WhereCS = createParserRule("WhereCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.PATTERN_CS));

		private static void initParserRules() {
			PR_CollectionTemplateCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("name", "=", createRuleCall(PR_UnrestrictedName))),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(_EssentialOCL.PR_CollectionTypeCS)),
					setCardinality("?", createGroup(
						createKeyword("{"),
						setCardinality("?", createGroup(
							createAssignment("ownedMemberIdentifiers", "+=", createAlternatives(
								createRuleCall(PR_TemplateCS),
								createRuleCall(PR_ElementTemplateCS))),
							setCardinality("*", createGroup(
								createKeyword(","),
								createAssignment("ownedMemberIdentifiers", "+=", createAlternatives(
									createRuleCall(PR_TemplateCS),
									createRuleCall(PR_ElementTemplateCS))))),
							createKeyword("++"),
							createAssignment("ownedRestIdentifier", "=", createRuleCall(PR_ElementTemplateCS)))),
						createKeyword("}")))));
			PR_DefaultValueCS.setAlternatives(
				createGroup(
					createAssignment("propertyId", "=", createCrossReference(
						createTypeRef(MM_qvtrelation, org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage.Literals.SHARED_VARIABLE), createRuleCall(PR_UnrestrictedName))),
					createKeyword("="),
					createAssignment("ownedInitExpression", "=", createRuleCall(_EssentialOCL.PR_ExpCS)),
					createKeyword(";")));
			PR_DomainCS.setAlternatives(
				createGroup(
					setCardinality("?", createAlternatives(
						createAssignment("isCheckonly", "?=", createKeyword("checkonly")),
						createAssignment("isEnforce", "?=", createKeyword("enforce")),
						createKeyword("replace"))),
					createKeyword("domain"),
					createAssignment("modelId", "=", createCrossReference(
						createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(PR_UnrestrictedName))),
					setCardinality("?", createGroup(
						createAssignment("ownedPatterns", "+=", createRuleCall(PR_DomainPatternCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedPatterns", "+=", createRuleCall(PR_DomainPatternCS)))))),
					setCardinality("?", createGroup(
						createKeyword("implementedby"),
						createAssignment("implementedBy", "=", createRuleCall(PR_UnrestrictedName)))),
					setCardinality("?", createGroup(
						createKeyword("default_values"),
						createKeyword("{"),
						setCardinality("+", createAssignment("ownedDefaultValues", "+=", createRuleCall(PR_DefaultValueCS))),
						createKeyword("}"))),
					createKeyword(";")));
			PR_DomainPatternCS.setAlternatives(
				createAssignment("ownedTemplate", "=", createRuleCall(PR_TemplateCS)));
			PR_ElementTemplateCS.setAlternatives(
				createAssignment("identifier", "=", createCrossReference(
					createTypeRef(MM_qvtrelation, org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage.Literals.SHARED_VARIABLE), createRuleCall(PR_UnrestrictedName))));
			PR_ExpCSOrTemplateCS.setAlternatives(
				createAlternatives(
					createRuleCall(_EssentialOCL.PR_ExpCS),
					createRuleCall(PR_TemplateCS)));
			PR_KeyDeclCS.setAlternatives(
				createGroup(
					createKeyword("key"),
					createAssignment("ownedPathName", "=", createRuleCall(_Base.PR_PathNameCS)),
					createKeyword("{"),
					createAlternatives(
						createAssignment("propertyIds", "+=", createCrossReference(
							createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY), createRuleCall(PR_UnrestrictedName))),
						createGroup(
							createKeyword("opposite"),
							createKeyword("("),
							createAssignment("ownedOppositePropertyIds", "+=", createRuleCall(_Base.PR_PathNameCS)),
							createKeyword(")"))),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAlternatives(
							createAssignment("propertyIds", "+=", createCrossReference(
								createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY), createRuleCall(PR_UnrestrictedName))),
							createGroup(
								createKeyword("opposite"),
								createKeyword("("),
								createAssignment("ownedOppositePropertyIds", "+=", createRuleCall(_Base.PR_PathNameCS)),
								createKeyword(")"))))),
					createKeyword("}"),
					createKeyword(";")));
			PR_ModelDeclCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					createKeyword(":"),
					createAlternatives(
						createAssignment("metamodelIds", "+=", createCrossReference(
							createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMESPACE), createRuleCall(PR_UnrestrictedName))),
						createGroup(
							createKeyword("{"),
							createAssignment("metamodelIds", "+=", createCrossReference(
								createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMESPACE), createRuleCall(PR_UnrestrictedName))),
							setCardinality("*", createGroup(
								createKeyword(","),
								createAssignment("metamodelIds", "+=", createCrossReference(
									createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMESPACE), createRuleCall(PR_UnrestrictedName))))),
							createKeyword("}"))),
					setCardinality("?", createGroup(
						createKeyword("dependsOn"),
						createAlternatives(
							createAssignment("dependsOn", "+=", createCrossReference(
								createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(PR_UnrestrictedName))),
							createGroup(
								createKeyword("{"),
								setCardinality("?", createGroup(
									createAssignment("dependsOn", "+=", createCrossReference(
										createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(PR_UnrestrictedName))),
									setCardinality("*", createGroup(
										createKeyword(","),
										createAssignment("dependsOn", "+=", createCrossReference(
											createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(PR_UnrestrictedName))))))),
								createKeyword("}"))))),
					setCardinality("?", createGroup(
						createKeyword("iterates"),
						createAlternatives(
							createAssignment("iterates", "+=", createCrossReference(
								createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(PR_UnrestrictedName))),
							createGroup(
								createKeyword("{"),
								setCardinality("?", createGroup(
									createAssignment("iterates", "+=", createCrossReference(
										createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(PR_UnrestrictedName))),
									setCardinality("*", createGroup(
										createKeyword(","),
										createAssignment("iterates", "+=", createCrossReference(
											createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(PR_UnrestrictedName))))))),
								createKeyword("}")))))));
			PR_ObjectTemplateCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("name", "=", createRuleCall(PR_UnrestrictedName))),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypedRefCS)),
					setCardinality("?", createGroup(
						createKeyword("{"),
						setCardinality("?", createGroup(
							createAssignment("ownedPropertyTemplates", "+=", createRuleCall(PR_PropertyTemplateCS)),
							setCardinality("*", createGroup(
								createKeyword(","),
								createAssignment("ownedPropertyTemplates", "+=", createRuleCall(PR_PropertyTemplateCS)))))),
						createKeyword("}")))));
			PR_ParamDeclarationCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(_EssentialOCL.PR_TypeExpCS))));
			PR_PredicateCS.setAlternatives(
				createGroup(
					createAssignment("ownedCondition", "=", createRuleCall(_EssentialOCL.PR_ExpCS)),
					createKeyword(";")));
			PR_PrimitiveTypeDomainCS.setAlternatives(
				createGroup(
					createKeyword("primitive"),
					createKeyword("domain"),
					createAssignment("ownedPatterns", "+=", createRuleCall(PR_PrimitiveTypeDomainPatternCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedPatterns", "+=", createRuleCall(PR_PrimitiveTypeDomainPatternCS)))),
					createKeyword(";")));
			PR_PrimitiveTypeDomainPatternCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(_EssentialOCL.PR_TypeExpCS))));
			PR_PropertyTemplateCS.setAlternatives(
				createGroup(
					createAlternatives(
						createAssignment("propertyId", "=", createCrossReference(
							createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY), createRuleCall(PR_UnrestrictedName))),
						createGroup(
							createKeyword("opposite"),
							createKeyword("("),
							createAssignment("ownedOppositePropertyId", "=", createRuleCall(_Base.PR_PathNameCS)),
							createKeyword(")"))),
					createKeyword("="),
					createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCSOrTemplateCS))));
			PR_QVTrelationUnrestrictedName.setAlternatives(
				createAlternatives(
					createKeyword("abstract"),
					createKeyword("checkonly"),
					createKeyword("default_values"),
					createKeyword("dependsOn"),
					createKeyword("domain"),
					createKeyword("enforce"),
					createKeyword("extends"),
					createKeyword("implementedby"),
					createKeyword("import"),
					createKeyword("input"),
					createKeyword("iterates"),
					createKeyword("library"),
					createKeyword("key"),
					createKeyword("opposite"),
					createKeyword("output"),
					createKeyword("overrides"),
					createKeyword("package"),
					createKeyword("primitive"),
					createKeyword("query"),
					createKeyword("relation"),
					createKeyword("replace"),
					createKeyword("target"),
					createKeyword("top"),
					createKeyword("transformation"),
					createKeyword("via"),
					createKeyword("when"),
					createKeyword("where")));
			PR_QualifiedPackageCS.setAlternatives(
				createGroup(
					createKeyword("package"),
					setCardinality("?", createAssignment("ownedPathName", "=", createRuleCall(PR_ScopeNameCS))),
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("nsPrefix", "=", createRuleCall(PR_UnrestrictedName)))),
					setCardinality("?", createGroup(
						createKeyword("="),
						createAssignment("nsURI", "=", createRuleCall(_Base.PR_URI)))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createAlternatives(
								createAssignment("ownedPackages", "+=", createRuleCall(PR_QualifiedPackageCS)),
								createAssignment("ownedClasses", "+=", createAlternatives(
									createRuleCall(_QVTbase.PR_ClassCS),
									createRuleCall(PR_TransformationCS))))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_QueryCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("isTransient", "?=", createKeyword("transient"))),
					createKeyword("query"),
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					createKeyword("("),
					setCardinality("?", createGroup(
						createAssignment("ownedParameters", "+=", createRuleCall(PR_ParamDeclarationCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParameters", "+=", createRuleCall(PR_ParamDeclarationCS)))))),
					createKeyword(")"),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(_EssentialOCL.PR_TypeExpCS)),
					createAlternatives(
						createKeyword(";"),
						createGroup(
							createKeyword("{"),
							createAssignment("ownedExpression", "=", createRuleCall(_EssentialOCL.PR_ExpCS)),
							createKeyword("}")),
						createGroup(
							createKeyword("implementedby"),
							createAssignment("implementation", "=", createCrossReference(
								createTypeRef(MM_qvtbasecs, org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage.Literals.JAVA_CLASS_CS), createRuleCall(_Base.TR_SINGLE_QUOTED_STRING))),
							createKeyword(";")))));
			PR_RelationCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("isTop", "?=", createKeyword("top"))),
					setCardinality("?", createAssignment("isAbstract", "?=", createKeyword("abstract"))),
					createKeyword("relation"),
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword("overrides"),
						createAssignment("overridden", "=", createCrossReference(
							createTypeRef(MM_qvtrelation, org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage.Literals.RELATION), createRuleCall(PR_UnrestrictedName))))),
					createKeyword("{"),
					setCardinality("*", createAssignment("ownedVarDeclarations", "+=", createRuleCall(PR_VarDeclarationCS))),
					setCardinality("+", createAlternatives(
						createAssignment("ownedDomains", "+=", createRuleCall(PR_DomainCS)),
						createAssignment("ownedDomains", "+=", createRuleCall(PR_PrimitiveTypeDomainCS)))),
					setCardinality("?", createAssignment("ownedWhen", "=", createRuleCall(PR_WhenCS))),
					setCardinality("?", createAssignment("ownedWhere", "=", createRuleCall(PR_WhereCS))),
					createKeyword("}")));
			PR_ScopeNameCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathElements", "+=", createRuleCall(_Base.PR_FirstPathElementCS)),
					createKeyword("::"),
					setCardinality("*", createGroup(
						createAssignment("ownedPathElements", "+=", createRuleCall(_Base.PR_NextPathElementCS)),
						createKeyword("::")))));
			PR_TemplateCS.setAlternatives(
				createGroup(
					createAlternatives(
						createRuleCall(PR_CollectionTemplateCS),
						createRuleCall(PR_ObjectTemplateCS)),
					setCardinality("?", createGroup(
						createKeyword("{"),
						createAssignment("ownedGuardExpression", "=", createRuleCall(_EssentialOCL.PR_ExpCS)),
						createKeyword("}")))));
			PR_TopLevelCS.setAlternatives(
				createGroup(
					setCardinality("*", createAssignment("ownedImports", "+=", createRuleCall(PR_UnitCS))),
					setCardinality("*", createAlternatives(
						createAssignment("ownedPackages", "+=", createRuleCall(PR_QualifiedPackageCS)),
						createAssignment("ownedTransformations", "+=", createRuleCall(PR_TransformationCS))))));
			PR_TransformationCS.setAlternatives(
				createGroup(
					createKeyword("transformation"),
					setCardinality("?", createAssignment("ownedPathName", "=", createRuleCall(PR_ScopeNameCS))),
					createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
					createKeyword("("),
					createAssignment("ownedModelDecls", "+=", createRuleCall(PR_ModelDeclCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedModelDecls", "+=", createRuleCall(PR_ModelDeclCS)))),
					createKeyword(")"),
					setCardinality("?", createGroup(
						createKeyword("extends"),
						createAssignment("extends", "+=", createCrossReference(
							createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TRANSFORMATION), createRuleCall(PR_UnrestrictedName))),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("extends", "+=", createCrossReference(
								createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TRANSFORMATION), createRuleCall(PR_UnrestrictedName))))))),
					createKeyword("{"),
					setCardinality("*", createAssignment("ownedTargets", "+=", createRuleCall(_QVTbase.PR_TargetCS))),
					setCardinality("*", createAssignment("ownedKeyDecls", "+=", createRuleCall(PR_KeyDeclCS))),
					setCardinality("*", createAlternatives(
						createAssignment("ownedRelations", "+=", createRuleCall(PR_RelationCS)),
						createAssignment("ownedQueries", "+=", createRuleCall(PR_QueryCS)),
						createAssignment("ownedProperties", "+=", createRuleCall(_QVTbase.PR_StructuralFeatureCS)))),
					createKeyword("}")));
			PR_TypedRefCS.setAlternatives(
				createAlternatives(
					createGroup(
						createRuleCall(_EssentialOCL.PR_PrimitiveTypeCS),
						setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS)))),
					createGroup(
						createRuleCall(_EssentialOCL.PR_CollectionTypeCS),
						setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS)))),
					createGroup(
						createRuleCall(PR_TypedTypeRefCS),
						setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS))))));
			PR_TypedTypeRefCS.setAlternatives(
				createAssignment("ownedPathName", "=", createRuleCall(_Base.PR_PathNameCS)));
			PR_UnitCS.setAlternatives(
				createGroup(
					createKeyword("import"),
					setCardinality("?", createGroup(
						createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)),
						createKeyword(":"))),
					createAssignment("ownedPathName", "=", createRuleCall(_EssentialOCL.PR_URIPathNameCS)),
					setCardinality("?", createGroup(
						createKeyword("::"),
						createAssignment("isAll", "?=", createKeyword("*")))),
					createKeyword(";")));
			PR_UnrestrictedName.setAlternatives(
				createAlternatives(
					createRuleCall(_EssentialOCL.PR_EssentialOCLUnrestrictedName),
					createRuleCall(_QVTbase.PR_QVTbaseUnrestrictedName),
					createRuleCall(PR_QVTrelationUnrestrictedName)));
			PR_VarDeclarationCS.setAlternatives(
				createGroup(
					createAssignment("ownedVarDeclarationIds", "+=", createRuleCall(PR_VarDeclarationIdCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedVarDeclarationIds", "+=", createRuleCall(PR_VarDeclarationIdCS)))),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(_EssentialOCL.PR_TypeExpCS)))),
					setCardinality("?", createGroup(
						createKeyword("="),
						createAssignment("ownedInitExpression", "=", createRuleCall(_EssentialOCL.PR_ExpCS)))),
					createKeyword(";")));
			PR_VarDeclarationIdCS.setAlternatives(
				createAssignment("name", "=", createRuleCall(PR_UnrestrictedName)));
			PR_WhenCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.PATTERN_CS)),
					createKeyword("when"),
					createKeyword("{"),
					setCardinality("*", createAssignment("ownedPredicates", "+=", createRuleCall(PR_PredicateCS))),
					createKeyword("}")));
			PR_WhereCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage.Literals.PATTERN_CS)),
					createKeyword("where"),
					createKeyword("{"),
					setCardinality("*", createAssignment("ownedPredicates", "+=", createRuleCall(PR_PredicateCS))),
					createKeyword("}")));
		}

		private static @NonNull Grammar initGrammar() {
			initParserRules();
			Grammar grammar = G_QVTrelation;
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_pivot);
				metamodelDeclarations.add(MM_base);
				metamodelDeclarations.add(MM_essentialocl);
				metamodelDeclarations.add(MM_qvtbase);
				metamodelDeclarations.add(MM_qvtbasecs);
				metamodelDeclarations.add(MM_qvtrelation);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_TopLevelCS);
				rules.add(PR_QualifiedPackageCS);
				rules.add(PR_CollectionTemplateCS);
				rules.add(PR_DefaultValueCS);
				rules.add(PR_DomainCS);
				rules.add(PR_DomainPatternCS);
				rules.add(PR_ElementTemplateCS);
				rules.add(PR_KeyDeclCS);
				rules.add(PR_ModelDeclCS);
				rules.add(PR_ObjectTemplateCS);
				rules.add(PR_ParamDeclarationCS);
				rules.add(PR_PredicateCS);
				rules.add(PR_PrimitiveTypeDomainCS);
				rules.add(PR_PrimitiveTypeDomainPatternCS);
				rules.add(PR_PropertyTemplateCS);
				rules.add(PR_QueryCS);
				rules.add(PR_RelationCS);
				rules.add(PR_ScopeNameCS);
				rules.add(PR_TemplateCS);
				rules.add(PR_TransformationCS);
				rules.add(PR_UnitCS);
				rules.add(PR_VarDeclarationCS);
				rules.add(PR_VarDeclarationIdCS);
				rules.add(PR_WhenCS);
				rules.add(PR_WhereCS);
				rules.add(PR_ExpCSOrTemplateCS);
				rules.add(PR_TypedTypeRefCS);
				rules.add(PR_TypedRefCS);
				rules.add(PR_QVTrelationUnrestrictedName);
				rules.add(PR_UnrestrictedName);
			}
			{
				List<Grammar> usedGrammars = grammar.getUsedGrammars();
				usedGrammars.add(G_QVTbase);
			}
			return grammar;
		}
	}

	private static class _QVTbase
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage.eINSTANCE, null); // http://www.eclipse.org/ocl/2016/QVTbaseCS
		private static final @NonNull ReferencedMetamodel MM_base = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, "base"); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_essentialocl = createReferencedMetamodel(org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.eINSTANCE, "essentialocl"); // http://www.eclipse.org/ocl/2015/EssentialOCLCS
		private static final @NonNull ReferencedMetamodel MM_pivot = createReferencedMetamodel(org.eclipse.ocl.pivot.PivotPackage.eINSTANCE, "pivot"); // http://www.eclipse.org/ocl/2015/Pivot
		private static final @NonNull ReferencedMetamodel MM_qvtbase = createReferencedMetamodel(org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.eINSTANCE, "qvtbase"); // http://www.eclipse.org/qvt/2015/QVTbase

		private static final @NonNull TerminalRule TR_UNQUOTED_STRING = createTerminalRule("UNQUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));

		private static void initTerminalRules() {
			TR_UNQUOTED_STRING.setAlternatives(
				createKeyword("\u00A3$%^\u00A3$%^"));
		}

		private static final @NonNull ParserRule PR_AttributeCS = createParserRule("AttributeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.ATTRIBUTE_CS));
		private static final @NonNull ParserRule PR_ClassCS = createParserRule("ClassCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.CLASS_CS));
		private static final @NonNull ParserRule PR_CompoundTargetElementCS = createParserRule("CompoundTargetElementCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage.Literals.COMPOUND_TARGET_ELEMENT_CS));
		private static final @NonNull ParserRule PR_DataTypeCS = createParserRule("DataTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.DATA_TYPE_CS));
		private static final @NonNull ParserRule PR_EnumerationCS = createParserRule("EnumerationCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.ENUMERATION_CS));
		private static final @NonNull ParserRule PR_EnumerationLiteralCS = createParserRule("EnumerationLiteralCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.ENUMERATION_LITERAL_CS));
		private static final @NonNull ParserRule PR_EnumerationLiteralName = createParserRule("EnumerationLiteralName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_OperationCS = createParserRule("OperationCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.OPERATION_CS));
		private static final @NonNull ParserRule PR_ParameterCS = createParserRule("ParameterCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PARAMETER_CS));
		private static final @NonNull ParserRule PR_QVTbaseUnrestrictedName = createParserRule("QVTbaseUnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ReferenceCS = createParserRule("ReferenceCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.REFERENCE_CS));
		private static final @NonNull ParserRule PR_SIGNED = createParserRule("SIGNED", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.EINT));
		private static final @NonNull ParserRule PR_SimpleTargetElementCS = createParserRule("SimpleTargetElementCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage.Literals.SIMPLE_TARGET_ELEMENT_CS));
		private static final @NonNull ParserRule PR_SpecificationCS = createParserRule("SpecificationCS", createTypeRef(MM_essentialocl, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_SPECIFICATION_CS));
		private static final @NonNull ParserRule PR_StructuralFeatureCS = createParserRule("StructuralFeatureCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.STRUCTURAL_FEATURE_CS));
		private static final @NonNull ParserRule PR_StructuredClassCS = createParserRule("StructuredClassCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.STRUCTURED_CLASS_CS));
		private static final @NonNull ParserRule PR_TargetCS = createParserRule("TargetCS", createTypeRef(MM, org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage.Literals.TARGET_CS));
		private static final @NonNull ParserRule PR_TypedMultiplicityRefCS = createParserRule("TypedMultiplicityRefCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypedRefCS = createParserRule("TypedRefCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));

		private static void initParserRules() {
			PR_AttributeCS.setAlternatives(
				createGroup(
					setCardinality("?", createAlternatives(
						createGroup(
							createAssignment("qualifiers", "+=", createKeyword("static")),
							setCardinality("?", createAssignment("qualifiers", "+=", createKeyword("definition")))),
						createGroup(
							createAssignment("qualifiers", "+=", createKeyword("definition")),
							setCardinality("?", createAssignment("qualifiers", "+=", createKeyword("static")))))),
					createKeyword("attribute"),
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS)))),
					setCardinality("?", createGroup(
						createKeyword("="),
						createAssignment("default", "=", createRuleCall(_Base.TR_SINGLE_QUOTED_STRING)))),
					setCardinality("?", createGroup(
						createKeyword("{"),
						setCardinality("+", createGroup(
							createAlternatives(
								createAssignment("qualifiers", "+=", createKeyword("derived")),
								createAssignment("qualifiers", "+=", createKeyword("!derived")),
								createAssignment("qualifiers", "+=", createKeyword("id")),
								createAssignment("qualifiers", "+=", createKeyword("!id")),
								createAssignment("qualifiers", "+=", createKeyword("ordered")),
								createAssignment("qualifiers", "+=", createKeyword("!ordered")),
								createAssignment("qualifiers", "+=", createKeyword("readonly")),
								createAssignment("qualifiers", "+=", createKeyword("!readonly")),
								createAssignment("qualifiers", "+=", createKeyword("transient")),
								createAssignment("qualifiers", "+=", createKeyword("!transient")),
								createAssignment("qualifiers", "+=", createKeyword("unique")),
								createAssignment("qualifiers", "+=", createKeyword("!unique")),
								createAssignment("qualifiers", "+=", createKeyword("unsettable")),
								createAssignment("qualifiers", "+=", createKeyword("!unsettable")),
								createAssignment("qualifiers", "+=", createKeyword("volatile")),
								createAssignment("qualifiers", "+=", createKeyword("!volatile"))),
							setCardinality("?", createKeyword(",")))),
						createKeyword("}"))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createAlternatives(
								createGroup(
									createKeyword("initial"),
									setCardinality("?", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
									createKeyword(":"),
									setCardinality("?", createAssignment("ownedDefaultExpressions", "+=", createRuleCall(PR_SpecificationCS))),
									createKeyword(";")),
								createGroup(
									createKeyword("derivation"),
									setCardinality("?", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
									createKeyword(":"),
									setCardinality("?", createAssignment("ownedDefaultExpressions", "+=", createRuleCall(PR_SpecificationCS))),
									createKeyword(";")))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_ClassCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_StructuredClassCS),
					createRuleCall(PR_DataTypeCS),
					createRuleCall(PR_EnumerationCS)));
			PR_CompoundTargetElementCS.setAlternatives(
				createGroup(
					createKeyword("{"),
					setCardinality("*", createAssignment("ownedTargetElements", "+=", createRuleCall(PR_SimpleTargetElementCS))),
					createKeyword("}"),
					setCardinality("?", createKeyword(";"))));
			PR_DataTypeCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("isPrimitive", "?=", createKeyword("primitive"))),
					createKeyword("datatype"),
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createAssignment("ownedSignature", "=", createRuleCall(_Base.PR_TemplateSignatureCS))),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("instanceClassName", "=", createRuleCall(_Base.TR_SINGLE_QUOTED_STRING)))),
					setCardinality("?", createGroup(
						createKeyword("{"),
						setCardinality("?", createAlternatives(
							createAssignment("isSerializable", "?=", createKeyword("serializable")),
							createKeyword("!serializable"))),
						createKeyword("}"))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							createKeyword("}")),
						createKeyword(";"))));
			PR_EnumerationCS.setAlternatives(
				createGroup(
					createKeyword("enum"),
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createAssignment("ownedSignature", "=", createRuleCall(_Base.PR_TemplateSignatureCS))),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("instanceClassName", "=", createRuleCall(_Base.TR_SINGLE_QUOTED_STRING)))),
					setCardinality("?", createGroup(
						createKeyword("{"),
						setCardinality("?", createAlternatives(
							createAssignment("isSerializable", "?=", createKeyword("serializable")),
							createKeyword("!serializable"))),
						createKeyword("}"))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createAssignment("ownedLiterals", "+=", createRuleCall(PR_EnumerationLiteralCS))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_EnumerationLiteralCS.setAlternatives(
				createGroup(
					createAlternatives(
						createGroup(
							createKeyword("literal"),
							createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName))),
						createAssignment("name", "=", createRuleCall(PR_EnumerationLiteralName))),
					setCardinality("?", createGroup(
						createKeyword("="),
						createAssignment("value", "=", createRuleCall(PR_SIGNED)))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							createKeyword("}")),
						createKeyword(";"))));
			PR_EnumerationLiteralName.setAlternatives(
				createRuleCall(_EssentialOCL.PR_EssentialOCLUnrestrictedName));
			PR_OperationCS.setAlternatives(
				createGroup(
					setCardinality("?", createAlternatives(
						createGroup(
							createAssignment("qualifiers", "+=", createKeyword("static")),
							setCardinality("?", createAssignment("qualifiers", "+=", createKeyword("definition")))),
						createGroup(
							createAssignment("qualifiers", "+=", createKeyword("definition")),
							setCardinality("?", createAssignment("qualifiers", "+=", createKeyword("static")))))),
					createKeyword("operation"),
					setCardinality("?", createAssignment("ownedSignature", "=", createRuleCall(_Base.PR_TemplateSignatureCS))),
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					createKeyword("("),
					setCardinality("?", createGroup(
						createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParameters", "+=", createRuleCall(PR_ParameterCS)))))),
					createKeyword(")"),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS)))),
					setCardinality("?", createGroup(
						createKeyword("throws"),
						createAssignment("ownedExceptions", "+=", createRuleCall(_QVTrelation.PR_TypedRefCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedExceptions", "+=", createRuleCall(_QVTrelation.PR_TypedRefCS)))))),
					setCardinality("?", createGroup(
						createKeyword("{"),
						setCardinality("+", createGroup(
							createAlternatives(
								createAssignment("qualifiers", "+=", createKeyword("derived")),
								createAssignment("qualifiers", "+=", createKeyword("!derived")),
								createAssignment("qualifiers", "+=", createKeyword("ordered")),
								createAssignment("qualifiers", "+=", createKeyword("!ordered")),
								createAssignment("qualifiers", "+=", createKeyword("unique")),
								createAssignment("qualifiers", "+=", createKeyword("!unique"))),
							setCardinality("?", createKeyword(",")))),
						createKeyword("}"))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createGroup(
								createKeyword("body"),
								setCardinality("?", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
								createKeyword(":"),
								setCardinality("?", createAssignment("ownedBodyExpressions", "+=", createRuleCall(PR_SpecificationCS))),
								createKeyword(";"))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_ParameterCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS)))),
					setCardinality("?", createGroup(
						createKeyword("{"),
						setCardinality("+", createGroup(
							createAlternatives(
								createAssignment("qualifiers", "+=", createKeyword("ordered")),
								createAssignment("qualifiers", "+=", createKeyword("!ordered")),
								createAssignment("qualifiers", "+=", createKeyword("unique")),
								createAssignment("qualifiers", "+=", createKeyword("!unique"))),
							setCardinality("?", createKeyword(",")))),
						createKeyword("}"))),
					setCardinality("?", createGroup(
						createKeyword("{"),
						createKeyword("}")))));
			PR_QVTbaseUnrestrictedName.setAlternatives(
				createAlternatives(
					createKeyword("abstract"),
					createKeyword("attribute"),
					createKeyword("body"),
					createKeyword("class"),
					createKeyword("composes"),
					createKeyword("datatype"),
					createKeyword("definition"),
					createKeyword("derived"),
					createKeyword("derivation"),
					createKeyword("enum"),
					createKeyword("extends"),
					createKeyword("id"),
					createKeyword("initial"),
					createKeyword("interface"),
					createKeyword("literal"),
					createKeyword("operation"),
					createKeyword("ordered"),
					createKeyword("primitive"),
					createKeyword("property"),
					createKeyword("readonly"),
					createKeyword("resolve"),
					createKeyword("serializable"),
					createKeyword("static"),
					createKeyword("throws"),
					createKeyword("transient"),
					createKeyword("unique"),
					createKeyword("unsettable"),
					createKeyword("volatile")));
			PR_ReferenceCS.setAlternatives(
				createGroup(
					setCardinality("?", createAlternatives(
						createGroup(
							createAssignment("qualifiers", "+=", createKeyword("static")),
							setCardinality("?", createAssignment("qualifiers", "+=", createKeyword("definition")))),
						createGroup(
							createAssignment("qualifiers", "+=", createKeyword("definition")),
							setCardinality("?", createAssignment("qualifiers", "+=", createKeyword("static")))))),
					createKeyword("property"),
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword("#"),
						createAssignment("referredOpposite", "=", createCrossReference(
							createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY), createRuleCall(_QVTrelation.PR_UnrestrictedName))))),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypedMultiplicityRefCS)))),
					setCardinality("?", createGroup(
						createKeyword("="),
						createAssignment("default", "=", createRuleCall(_Base.TR_SINGLE_QUOTED_STRING)))),
					setCardinality("?", createGroup(
						createKeyword("{"),
						setCardinality("+", createGroup(
							createAlternatives(
								createAssignment("qualifiers", "+=", createKeyword("composes")),
								createAssignment("qualifiers", "+=", createKeyword("!composes")),
								createAssignment("qualifiers", "+=", createKeyword("derived")),
								createAssignment("qualifiers", "+=", createKeyword("!derived")),
								createAssignment("qualifiers", "+=", createKeyword("ordered")),
								createAssignment("qualifiers", "+=", createKeyword("!ordered")),
								createAssignment("qualifiers", "+=", createKeyword("readonly")),
								createAssignment("qualifiers", "+=", createKeyword("!readonly")),
								createAssignment("qualifiers", "+=", createKeyword("resolve")),
								createAssignment("qualifiers", "+=", createKeyword("!resolve")),
								createAssignment("qualifiers", "+=", createKeyword("transient")),
								createAssignment("qualifiers", "+=", createKeyword("!transient")),
								createAssignment("qualifiers", "+=", createKeyword("unique")),
								createAssignment("qualifiers", "+=", createKeyword("!unique")),
								createAssignment("qualifiers", "+=", createKeyword("unsettable")),
								createAssignment("qualifiers", "+=", createKeyword("!unsettable")),
								createAssignment("qualifiers", "+=", createKeyword("volatile")),
								createAssignment("qualifiers", "+=", createKeyword("!volatile"))),
							setCardinality("?", createKeyword(",")))),
						createKeyword("}"))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createAlternatives(
								createGroup(
									createKeyword("initial"),
									setCardinality("?", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
									createKeyword(":"),
									setCardinality("?", createAssignment("ownedDefaultExpressions", "+=", createRuleCall(PR_SpecificationCS))),
									createKeyword(";")),
								createGroup(
									createKeyword("derivation"),
									setCardinality("?", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
									createKeyword(":"),
									setCardinality("?", createAssignment("ownedDefaultExpressions", "+=", createRuleCall(PR_SpecificationCS))),
									createKeyword(";")))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_SIGNED.setAlternatives(
				createGroup(
					setCardinality("?", createKeyword("-")),
					createRuleCall(_Base.TR_INT)));
			PR_SimpleTargetElementCS.setAlternatives(
				createGroup(
					createAlternatives(
						createAssignment("input", "?=", createKeyword("input")),
						createAssignment("output", "?=", createKeyword("output")),
						createAssignment("via", "?=", createKeyword("via"))),
					createAssignment("typedModel", "=", createCrossReference(
						createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(_QVTrelation.PR_UnrestrictedName))),
					setCardinality("?", createGroup(
						createKeyword("iterates"),
						createAlternatives(
							createAssignment("iterates", "+=", createCrossReference(
								createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(_QVTrelation.PR_UnrestrictedName))),
							createGroup(
								createKeyword("{"),
								setCardinality("?", createGroup(
									createAssignment("iterates", "+=", createCrossReference(
										createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(_QVTrelation.PR_UnrestrictedName))),
									setCardinality("*", createGroup(
										createKeyword(","),
										createAssignment("iterates", "+=", createCrossReference(
											createTypeRef(MM_qvtbase, org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage.Literals.TYPED_MODEL), createRuleCall(_QVTrelation.PR_UnrestrictedName))))))),
								createKeyword("}"))))),
					createKeyword(";")));
			PR_SpecificationCS.setAlternatives(
				createAlternatives(
					createAssignment("ownedExpression", "=", createRuleCall(_EssentialOCL.PR_ExpCS)),
					createAssignment("exprString", "=", createRuleCall(TR_UNQUOTED_STRING))));
			PR_StructuralFeatureCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_AttributeCS),
					createRuleCall(PR_ReferenceCS)));
			PR_StructuredClassCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("isAbstract", "?=", createKeyword("abstract"))),
					createKeyword("class"),
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createAssignment("ownedSignature", "=", createRuleCall(_Base.PR_TemplateSignatureCS))),
					setCardinality("?", createGroup(
						createKeyword("extends"),
						createAssignment("ownedSuperTypes", "+=", createRuleCall(_QVTrelation.PR_TypedRefCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedSuperTypes", "+=", createRuleCall(_QVTrelation.PR_TypedRefCS)))))),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("instanceClassName", "=", createRuleCall(_Base.TR_SINGLE_QUOTED_STRING)))),
					setCardinality("?", createGroup(
						createKeyword("{"),
						setCardinality("?", createAssignment("isInterface", "?=", createKeyword("interface"))),
						createKeyword("}"))),
					createAlternatives(
						createGroup(
							createKeyword("{"),
							setCardinality("*", createAlternatives(
								createAssignment("ownedOperations", "+=", createRuleCall(PR_OperationCS)),
								createAssignment("ownedProperties", "+=", createRuleCall(PR_StructuralFeatureCS)))),
							createKeyword("}")),
						createKeyword(";"))));
			PR_TargetCS.setAlternatives(
				createGroup(
					createKeyword("target"),
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					createKeyword("{"),
					setCardinality("*", createAssignment("ownedTargetElements", "+=", createAlternatives(
						createRuleCall(PR_SimpleTargetElementCS),
						createRuleCall(PR_CompoundTargetElementCS)))),
					createKeyword("}"),
					setCardinality("?", createKeyword(";"))));
			PR_TypedMultiplicityRefCS.setAlternatives(
				createGroup(
					createRuleCall(_QVTrelation.PR_TypedRefCS),
					setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS)))));
			PR_TypedRefCS.setAlternatives(
				createAlternatives(
					createRuleCall(_EssentialOCL.PR_TypeLiteralCS),
					createRuleCall(_QVTrelation.PR_TypedTypeRefCS)));
		}

		private static @NonNull Grammar initGrammar() {
			initTerminalRules();
			initParserRules();
			Grammar grammar = G_QVTbase;
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_pivot);
				metamodelDeclarations.add(MM_base);
				metamodelDeclarations.add(MM_essentialocl);
				metamodelDeclarations.add(MM_qvtbase);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_AttributeCS);
				rules.add(PR_ClassCS);
				rules.add(PR_CompoundTargetElementCS);
				rules.add(PR_DataTypeCS);
				rules.add(PR_EnumerationCS);
				rules.add(PR_EnumerationLiteralCS);
				rules.add(PR_OperationCS);
				rules.add(PR_ParameterCS);
				rules.add(PR_ReferenceCS);
				rules.add(PR_SimpleTargetElementCS);
				rules.add(PR_SpecificationCS);
				rules.add(PR_StructuredClassCS);
				rules.add(PR_TargetCS);
				rules.add(PR_TypedMultiplicityRefCS);
				rules.add(PR_TypedRefCS);
				rules.add(PR_StructuralFeatureCS);
				rules.add(PR_EnumerationLiteralName);
				rules.add(PR_QVTbaseUnrestrictedName);
				rules.add(PR_SIGNED);
				rules.add(TR_UNQUOTED_STRING);
			}
			{
				List<Grammar> usedGrammars = grammar.getUsedGrammars();
				usedGrammars.add(G_EssentialOCL);
			}
			return grammar;
		}
	}

	private static class _EssentialOCL
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.eINSTANCE, null); // http://www.eclipse.org/ocl/2015/EssentialOCLCS
		private static final @NonNull ReferencedMetamodel MM_base = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, "base"); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_pivot = createReferencedMetamodel(org.eclipse.ocl.pivot.PivotPackage.eINSTANCE, "pivot"); // http://www.eclipse.org/ocl/2015/Pivot

		private static final @NonNull ParserRule PR_BinaryOperatorName = createParserRule("BinaryOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_BooleanLiteralExpCS = createParserRule("BooleanLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.BOOLEAN_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_CoIteratorVariableCS = createParserRule("CoIteratorVariableCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.VARIABLE_CS));
		private static final @NonNull ParserRule PR_CollectionLiteralExpCS = createParserRule("CollectionLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_CollectionLiteralPartCS = createParserRule("CollectionLiteralPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_CollectionPatternCS = createParserRule("CollectionPatternCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_PATTERN_CS));
		private static final @NonNull ParserRule PR_CollectionTypeCS = createParserRule("CollectionTypeCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.COLLECTION_TYPE_CS));
		private static final @NonNull ParserRule PR_CollectionTypeIdentifier = createParserRule("CollectionTypeIdentifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_CurlyBracketedClauseCS = createParserRule("CurlyBracketedClauseCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS));
		private static final @NonNull ParserRule PR_ElseIfThenExpCS = createParserRule("ElseIfThenExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.IF_THEN_EXP_CS));
		private static final @NonNull ParserRule PR_EssentialOCLInfixOperatorName = createParserRule("EssentialOCLInfixOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLNavigationOperatorName = createParserRule("EssentialOCLNavigationOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLReservedKeyword = createParserRule("EssentialOCLReservedKeyword", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLUnaryOperatorName = createParserRule("EssentialOCLUnaryOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLUnreservedName = createParserRule("EssentialOCLUnreservedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_EssentialOCLUnrestrictedName = createParserRule("EssentialOCLUnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_ExpCS = createParserRule("ExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_IfExpCS = createParserRule("IfExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.IF_EXP_CS));
		private static final @NonNull ParserRule PR_InfixOperatorName = createParserRule("InfixOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_InvalidLiteralExpCS = createParserRule("InvalidLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_LambdaLiteralExpCS = createParserRule("LambdaLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.LAMBDA_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_LetExpCS = createParserRule("LetExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.LET_EXP_CS));
		private static final @NonNull ParserRule PR_LetVariableCS = createParserRule("LetVariableCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.LET_VARIABLE_CS));
		private static final @NonNull ParserRule PR_MapLiteralExpCS = createParserRule("MapLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.MAP_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_MapLiteralPartCS = createParserRule("MapLiteralPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.MAP_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_MapTypeCS = createParserRule("MapTypeCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.MAP_TYPE_CS));
		private static final @NonNull ParserRule PR_Model = createParserRule("Model", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.CONTEXT_CS));
		private static final @NonNull ParserRule PR_NameExpCS = createParserRule("NameExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAME_EXP_CS));
		private static final @NonNull ParserRule PR_NavigatingArgCS = createParserRule("NavigatingArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigatingArgExpCS = createParserRule("NavigatingArgExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_NavigatingBarArgCS = createParserRule("NavigatingBarArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigatingCommaArgCS = createParserRule("NavigatingCommaArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigatingSemiArgCS = createParserRule("NavigatingSemiArgCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NAVIGATING_ARG_CS));
		private static final @NonNull ParserRule PR_NavigationOperatorName = createParserRule("NavigationOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_NestedExpCS = createParserRule("NestedExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NESTED_EXP_CS));
		private static final @NonNull ParserRule PR_NullLiteralExpCS = createParserRule("NullLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_NumberLiteralExpCS = createParserRule("NumberLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NUMBER_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_PatternExpCS = createParserRule("PatternExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PATTERN_EXP_CS));
		private static final @NonNull ParserRule PR_PrefixedLetExpCS = createParserRule("PrefixedLetExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_PrefixedPrimaryExpCS = createParserRule("PrefixedPrimaryExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_PrimaryExpCS = createParserRule("PrimaryExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.EXP_CS));
		private static final @NonNull ParserRule PR_PrimitiveLiteralExpCS = createParserRule("PrimitiveLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PRIMITIVE_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_PrimitiveTypeCS = createParserRule("PrimitiveTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PRIMITIVE_TYPE_REF_CS));
		private static final @NonNull ParserRule PR_PrimitiveTypeIdentifier = createParserRule("PrimitiveTypeIdentifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_RoundBracketedClauseCS = createParserRule("RoundBracketedClauseCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS));
		private static final @NonNull ParserRule PR_SelfExpCS = createParserRule("SelfExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SELF_EXP_CS));
		private static final @NonNull ParserRule PR_ShadowPartCS = createParserRule("ShadowPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SHADOW_PART_CS));
		private static final @NonNull ParserRule PR_SimplePathNameCS = createParserRule("SimplePathNameCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_SquareBracketedClauseCS = createParserRule("SquareBracketedClauseCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SQUARE_BRACKETED_CLAUSE_CS));
		private static final @NonNull ParserRule PR_StringLiteralExpCS = createParserRule("StringLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.STRING_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_TupleLiteralExpCS = createParserRule("TupleLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TUPLE_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_TupleLiteralPartCS = createParserRule("TupleLiteralPartCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TUPLE_LITERAL_PART_CS));
		private static final @NonNull ParserRule PR_TuplePartCS = createParserRule("TuplePartCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TUPLE_PART_CS));
		private static final @NonNull ParserRule PR_TupleTypeCS = createParserRule("TupleTypeCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TUPLE_TYPE_CS));
		private static final @NonNull ParserRule PR_TypeExpCS = createParserRule("TypeExpCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeExpWithoutMultiplicityCS = createParserRule("TypeExpWithoutMultiplicityCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeLiteralCS = createParserRule("TypeLiteralCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeLiteralExpCS = createParserRule("TypeLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TYPE_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_TypeLiteralWithMultiplicityCS = createParserRule("TypeLiteralWithMultiplicityCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypeNameExpCS = createParserRule("TypeNameExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.TYPE_NAME_EXP_CS));
		private static final @NonNull ParserRule PR_URIFirstPathElementCS = createParserRule("URIFirstPathElementCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_URIPathNameCS = createParserRule("URIPathNameCS", createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_UnaryOperatorName = createParserRule("UnaryOperatorName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnlimitedNaturalLiteralExpCS = createParserRule("UnlimitedNaturalLiteralExpCS", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS));
		private static final @NonNull ParserRule PR_UnreservedName = createParserRule("UnreservedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnrestrictedName = createParserRule("UnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));

		private static void initParserRules() {
			PR_BinaryOperatorName.setAlternatives(
				createAlternatives(
					createRuleCall(PR_InfixOperatorName),
					createRuleCall(PR_NavigationOperatorName)));
			PR_BooleanLiteralExpCS.setAlternatives(
				createAlternatives(
					createAssignment("symbol", "=", createKeyword("true")),
					createAssignment("symbol", "=", createKeyword("false"))));
			PR_CoIteratorVariableCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS))))));
			PR_CollectionLiteralExpCS.setAlternatives(
				createGroup(
					createAssignment("ownedType", "=", createRuleCall(PR_CollectionTypeCS)),
					createKeyword("{"),
					setCardinality("?", createGroup(
						createAssignment("ownedParts", "+=", createRuleCall(PR_CollectionLiteralPartCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParts", "+=", createRuleCall(PR_CollectionLiteralPartCS)))))),
					createKeyword("}")));
			PR_CollectionLiteralPartCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCS)),
						setCardinality("?", createGroup(
							createKeyword(".."),
							createAssignment("ownedLastExpression", "=", createRuleCall(PR_ExpCS))))),
					createAssignment("ownedExpression", "=", createRuleCall(PR_PatternExpCS))));
			PR_CollectionPatternCS.setAlternatives(
				createGroup(
					createAssignment("ownedType", "=", createRuleCall(PR_CollectionTypeCS)),
					createKeyword("{"),
					setCardinality("?", createGroup(
						createAssignment("ownedParts", "+=", createRuleCall(PR_PatternExpCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParts", "+=", createRuleCall(PR_PatternExpCS)))),
						createGroup(
							createKeyword("++"),
							createAssignment("restVariableName", "=", createRuleCall(_Base.PR_Identifier))))),
					createKeyword("}")));
			PR_CollectionTypeCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(PR_CollectionTypeIdentifier)),
					setCardinality("?", createGroup(
						createKeyword("("),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpWithoutMultiplicityCS)),
						setCardinality("?", createAssignment("ownedCollectionMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS))),
						createKeyword(")")))));
			PR_CollectionTypeIdentifier.setAlternatives(
				createAlternatives(
					createKeyword("Set"),
					createKeyword("Bag"),
					createKeyword("Sequence"),
					createKeyword("Collection"),
					createKeyword("OrderedSet")));
			PR_CurlyBracketedClauseCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.CURLY_BRACKETED_CLAUSE_CS)),
					createKeyword("{"),
					setCardinality("?", createGroup(
						createAssignment("ownedParts", "+=", createRuleCall(PR_ShadowPartCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParts", "+=", createRuleCall(PR_ShadowPartCS)))))),
					createKeyword("}")));
			PR_ElseIfThenExpCS.setAlternatives(
				createGroup(
					createKeyword("elseif"),
					createAssignment("ownedCondition", "=", createRuleCall(PR_ExpCS)),
					createKeyword("then"),
					createAssignment("ownedThenExpression", "=", createRuleCall(PR_ExpCS))));
			PR_EssentialOCLInfixOperatorName.setAlternatives(
				createAlternatives(
					createKeyword("*"),
					createKeyword("/"),
					createKeyword("+"),
					createKeyword("-"),
					createKeyword(">"),
					createKeyword("<"),
					createKeyword(">="),
					createKeyword("<="),
					createKeyword("="),
					createKeyword("<>"),
					createKeyword("and"),
					createKeyword("and2"),
					createKeyword("implies"),
					createKeyword("implies2"),
					createKeyword("or"),
					createKeyword("or2"),
					createKeyword("xor"),
					createKeyword("xor2")));
			PR_EssentialOCLNavigationOperatorName.setAlternatives(
				createAlternatives(
					createKeyword("."),
					createKeyword("->"),
					createKeyword("?."),
					createKeyword("?->")));
			PR_EssentialOCLReservedKeyword.setAlternatives(
				createAlternatives(
					createKeyword("and"),
					createKeyword("and2"),
					createKeyword("else"),
					createKeyword("endif"),
					createKeyword("if"),
					createKeyword("implies"),
					createKeyword("implies2"),
					createKeyword("in"),
					createKeyword("let"),
					createKeyword("not"),
					createKeyword("not2"),
					createKeyword("or"),
					createKeyword("or2"),
					createKeyword("then"),
					createKeyword("with"),
					createKeyword("xor"),
					createKeyword("xor2")));
			PR_EssentialOCLUnaryOperatorName.setAlternatives(
				createAlternatives(
					createKeyword("-"),
					createKeyword("not"),
					createKeyword("not2")));
			PR_EssentialOCLUnreservedName.setAlternatives(
				createAlternatives(
					createRuleCall(_QVTrelation.PR_UnrestrictedName),
					createRuleCall(PR_CollectionTypeIdentifier),
					createRuleCall(PR_PrimitiveTypeIdentifier),
					createKeyword("Map"),
					createKeyword("Tuple")));
			PR_EssentialOCLUnrestrictedName.setAlternatives(
				createRuleCall(_Base.PR_Identifier));
			PR_ExpCS.setAlternatives(
				createAlternatives(
					createGroup(
						createRuleCall(PR_PrefixedPrimaryExpCS),
						setCardinality("?", createGroup(
							createAction("ownedLeft", "=", createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.INFIX_EXP_CS)),
							createAssignment("name", "=", createRuleCall(PR_BinaryOperatorName)),
							createAssignment("ownedRight", "=", createRuleCall(PR_ExpCS))))),
					createRuleCall(PR_PrefixedLetExpCS)));
			PR_IfExpCS.setAlternatives(
				createGroup(
					createKeyword("if"),
					createAssignment("ownedCondition", "=", createAlternatives(
						createRuleCall(PR_ExpCS),
						createRuleCall(PR_PatternExpCS))),
					createKeyword("then"),
					createAssignment("ownedThenExpression", "=", createRuleCall(PR_ExpCS)),
					setCardinality("*", createAssignment("ownedIfThenExpressions", "+=", createRuleCall(PR_ElseIfThenExpCS))),
					createKeyword("else"),
					createAssignment("ownedElseExpression", "=", createRuleCall(PR_ExpCS)),
					createKeyword("endif")));
			PR_InfixOperatorName.setAlternatives(
				createRuleCall(PR_EssentialOCLInfixOperatorName));
			PR_InvalidLiteralExpCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.INVALID_LITERAL_EXP_CS)),
					createKeyword("invalid")));
			PR_LambdaLiteralExpCS.setAlternatives(
				createGroup(
					createKeyword("Lambda"),
					createKeyword("{"),
					createAssignment("ownedExpressionCS", "=", createRuleCall(PR_ExpCS)),
					createKeyword("}")));
			PR_LetExpCS.setAlternatives(
				createGroup(
					createKeyword("let"),
					createAssignment("ownedVariables", "+=", createRuleCall(PR_LetVariableCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedVariables", "+=", createRuleCall(PR_LetVariableCS)))),
					createKeyword("in"),
					createAssignment("ownedInExpression", "=", createRuleCall(PR_ExpCS))));
			PR_LetVariableCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createAssignment("ownedRoundBracketedClause", "=", createRuleCall(PR_RoundBracketedClauseCS))),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))),
					createKeyword("="),
					createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))));
			PR_MapLiteralExpCS.setAlternatives(
				createGroup(
					createAssignment("ownedType", "=", createRuleCall(PR_MapTypeCS)),
					createKeyword("{"),
					setCardinality("?", createGroup(
						createAssignment("ownedParts", "+=", createRuleCall(PR_MapLiteralPartCS)),
						setCardinality("*", createGroup(
							createKeyword(","),
							createAssignment("ownedParts", "+=", createRuleCall(PR_MapLiteralPartCS)))))),
					createKeyword("}")));
			PR_MapLiteralPartCS.setAlternatives(
				createGroup(
					createAssignment("ownedKey", "=", createRuleCall(PR_ExpCS)),
					createAlternatives(
						createKeyword("with"),
						createKeyword("<-")),
					createAssignment("ownedValue", "=", createRuleCall(PR_ExpCS))));
			PR_MapTypeCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createKeyword("Map")),
					setCardinality("?", createGroup(
						createKeyword("("),
						createAssignment("ownedKeyType", "=", createRuleCall(PR_TypeExpCS)),
						createKeyword(","),
						createAssignment("ownedValueType", "=", createRuleCall(PR_TypeExpCS)),
						createKeyword(")")))));
			PR_Model.setAlternatives(
				createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCS)));
			PR_NameExpCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathName", "=", createRuleCall(_Base.PR_PathNameCS)),
					setCardinality("*", createAssignment("ownedSquareBracketedClauses", "+=", createRuleCall(PR_SquareBracketedClauseCS))),
					setCardinality("?", createAssignment("ownedRoundBracketedClause", "=", createRuleCall(PR_RoundBracketedClauseCS))),
					setCardinality("?", createAssignment("ownedCurlyBracketedClause", "=", createRuleCall(PR_CurlyBracketedClauseCS))),
					setCardinality("?", createGroup(
						createAssignment("isPre", "?=", createKeyword("@")),
						createKeyword("pre")))));
			PR_NavigatingArgCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)),
						setCardinality("?", createAlternatives(
							createGroup(
								createAlternatives(
									createKeyword("with"),
									createKeyword("<-")),
								createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)),
								setCardinality("?", createGroup(
									createKeyword("="),
									createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))),
							createGroup(
								createKeyword(":"),
								createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)),
								setCardinality("?", createGroup(
									createAlternatives(
										createKeyword("with"),
										createKeyword("<-")),
									createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)))),
								setCardinality("?", createGroup(
									createKeyword("="),
									createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))),
							createGroup(
								setCardinality("?", createGroup(
									createKeyword(":"),
									createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))),
								setCardinality("?", createGroup(
									createAlternatives(
										createKeyword("with"),
										createKeyword("<-")),
									createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)))),
								createKeyword("in"),
								createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS)))))),
					createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))));
			PR_NavigatingArgExpCS.setAlternatives(
				createRuleCall(PR_ExpCS));
			PR_NavigatingBarArgCS.setAlternatives(
				createGroup(
					createAssignment("prefix", "=", createKeyword("|")),
					createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)),
						setCardinality("?", createGroup(
							createKeyword("="),
							createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))))));
			PR_NavigatingCommaArgCS.setAlternatives(
				createGroup(
					createAssignment("prefix", "=", createKeyword(",")),
					createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)),
					setCardinality("?", createAlternatives(
						createGroup(
							createAlternatives(
								createKeyword("with"),
								createKeyword("<-")),
							createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)),
							setCardinality("?", createGroup(
								createKeyword("="),
								createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))),
						createGroup(
							createKeyword(":"),
							createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)),
							setCardinality("?", createGroup(
								createAlternatives(
									createKeyword("with"),
									createKeyword("<-")),
								createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)))),
							setCardinality("?", createGroup(
								createKeyword("="),
								createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))),
						createGroup(
							setCardinality("?", createGroup(
								createKeyword(":"),
								createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))),
							setCardinality("?", createGroup(
								createAlternatives(
									createKeyword("with"),
									createKeyword("<-")),
								createAssignment("ownedCoIterator", "=", createRuleCall(PR_CoIteratorVariableCS)))),
							createKeyword("in"),
							createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS)))))));
			PR_NavigatingSemiArgCS.setAlternatives(
				createGroup(
					createAssignment("prefix", "=", createKeyword(";")),
					createAssignment("ownedNameExpression", "=", createRuleCall(PR_NavigatingArgExpCS)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)),
						setCardinality("?", createGroup(
							createKeyword("="),
							createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))))))));
			PR_NavigationOperatorName.setAlternatives(
				createRuleCall(PR_EssentialOCLNavigationOperatorName));
			PR_NestedExpCS.setAlternatives(
				createGroup(
					createKeyword("("),
					createAssignment("ownedExpression", "=", createRuleCall(PR_ExpCS)),
					createKeyword(")")));
			PR_NullLiteralExpCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.NULL_LITERAL_EXP_CS)),
					createKeyword("null")));
			PR_NumberLiteralExpCS.setAlternatives(
				createAssignment("symbol", "=", createRuleCall(_Base.PR_NUMBER_LITERAL)));
			PR_PatternExpCS.setAlternatives(
				createGroup(
					setCardinality("?", createAssignment("patternVariableName", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName))),
					createKeyword(":"),
					createAssignment("ownedPatternType", "=", createRuleCall(PR_TypeExpCS))));
			PR_PrefixedLetExpCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PREFIX_EXP_CS)),
						createAssignment("name", "=", createRuleCall(PR_UnaryOperatorName)),
						createAssignment("ownedRight", "=", createRuleCall(PR_PrefixedLetExpCS))),
					createRuleCall(PR_LetExpCS)));
			PR_PrefixedPrimaryExpCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.PREFIX_EXP_CS)),
						createAssignment("name", "=", createRuleCall(PR_UnaryOperatorName)),
						createAssignment("ownedRight", "=", createRuleCall(PR_PrefixedPrimaryExpCS))),
					createRuleCall(PR_PrimaryExpCS)));
			PR_PrimaryExpCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_NestedExpCS),
					createRuleCall(PR_IfExpCS),
					createRuleCall(PR_SelfExpCS),
					createRuleCall(PR_PrimitiveLiteralExpCS),
					createRuleCall(PR_TupleLiteralExpCS),
					createRuleCall(PR_MapLiteralExpCS),
					createRuleCall(PR_CollectionLiteralExpCS),
					createRuleCall(PR_LambdaLiteralExpCS),
					createRuleCall(PR_TypeLiteralExpCS),
					createRuleCall(PR_NameExpCS)));
			PR_PrimitiveLiteralExpCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_NumberLiteralExpCS),
					createRuleCall(PR_StringLiteralExpCS),
					createRuleCall(PR_BooleanLiteralExpCS),
					createRuleCall(PR_UnlimitedNaturalLiteralExpCS),
					createRuleCall(PR_InvalidLiteralExpCS),
					createRuleCall(PR_NullLiteralExpCS)));
			PR_PrimitiveTypeCS.setAlternatives(
				createAssignment("name", "=", createRuleCall(PR_PrimitiveTypeIdentifier)));
			PR_PrimitiveTypeIdentifier.setAlternatives(
				createAlternatives(
					createKeyword("Boolean"),
					createKeyword("Integer"),
					createKeyword("Real"),
					createKeyword("String"),
					createKeyword("UnlimitedNatural"),
					createKeyword("OclAny"),
					createKeyword("OclInvalid"),
					createKeyword("OclVoid")));
			PR_RoundBracketedClauseCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.ROUND_BRACKETED_CLAUSE_CS)),
					createKeyword("("),
					setCardinality("?", createGroup(
						createAssignment("ownedArguments", "+=", createRuleCall(PR_NavigatingArgCS)),
						setCardinality("*", createAssignment("ownedArguments", "+=", createAlternatives(
							createRuleCall(PR_NavigatingCommaArgCS),
							createRuleCall(PR_NavigatingSemiArgCS),
							createRuleCall(PR_NavigatingBarArgCS)))))),
					createKeyword(")")));
			PR_SelfExpCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.SELF_EXP_CS)),
					createKeyword("self")));
			PR_ShadowPartCS.setAlternatives(
				createAlternatives(
					createGroup(
						createAssignment("referredProperty", "=", createCrossReference(
							createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.PROPERTY), createRuleCall(_QVTrelation.PR_UnrestrictedName))),
						createKeyword("="),
						createAssignment("ownedInitExpression", "=", createAlternatives(
							createRuleCall(PR_ExpCS),
							createRuleCall(PR_PatternExpCS)))),
					createAssignment("ownedInitExpression", "=", createRuleCall(PR_StringLiteralExpCS))));
			PR_SimplePathNameCS.setAlternatives(
				createAssignment("ownedPathElements", "+=", createRuleCall(_Base.PR_FirstPathElementCS)));
			PR_SquareBracketedClauseCS.setAlternatives(
				createGroup(
					createKeyword("["),
					createAssignment("ownedTerms", "+=", createRuleCall(PR_ExpCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedTerms", "+=", createRuleCall(PR_ExpCS)))),
					createKeyword("]")));
			PR_StringLiteralExpCS.setAlternatives(
				setCardinality("+", createAssignment("segments", "+=", createRuleCall(_Base.PR_StringLiteral))));
			PR_TupleLiteralExpCS.setAlternatives(
				createGroup(
					createKeyword("Tuple"),
					createKeyword("{"),
					createAssignment("ownedParts", "+=", createRuleCall(PR_TupleLiteralPartCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedParts", "+=", createRuleCall(PR_TupleLiteralPartCS)))),
					createKeyword("}")));
			PR_TupleLiteralPartCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword(":"),
						createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS)))),
					createKeyword("="),
					createAssignment("ownedInitExpression", "=", createRuleCall(PR_ExpCS))));
			PR_TuplePartCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					createKeyword(":"),
					createAssignment("ownedType", "=", createRuleCall(PR_TypeExpCS))));
			PR_TupleTypeCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createKeyword("Tuple")),
					setCardinality("?", createGroup(
						createKeyword("("),
						setCardinality("?", createGroup(
							createAssignment("ownedParts", "+=", createRuleCall(PR_TuplePartCS)),
							setCardinality("*", createGroup(
								createKeyword(","),
								createAssignment("ownedParts", "+=", createRuleCall(PR_TuplePartCS)))))),
						createKeyword(")")))));
			PR_TypeExpCS.setAlternatives(
				createGroup(
					createRuleCall(PR_TypeExpWithoutMultiplicityCS),
					setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS)))));
			PR_TypeExpWithoutMultiplicityCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_TypeNameExpCS),
					createRuleCall(PR_TypeLiteralCS),
					createRuleCall(PR_CollectionPatternCS)));
			PR_TypeLiteralCS.setAlternatives(
				createAlternatives(
					createRuleCall(PR_PrimitiveTypeCS),
					createRuleCall(PR_CollectionTypeCS),
					createRuleCall(PR_MapTypeCS),
					createRuleCall(PR_TupleTypeCS)));
			PR_TypeLiteralExpCS.setAlternatives(
				createAssignment("ownedType", "=", createRuleCall(PR_TypeLiteralWithMultiplicityCS)));
			PR_TypeLiteralWithMultiplicityCS.setAlternatives(
				createGroup(
					createRuleCall(PR_TypeLiteralCS),
					setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(_Base.PR_MultiplicityCS)))));
			PR_TypeNameExpCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathName", "=", createRuleCall(_Base.PR_PathNameCS)),
					setCardinality("?", createGroup(
						createAssignment("ownedCurlyBracketedClause", "=", createRuleCall(PR_CurlyBracketedClauseCS)),
						setCardinality("?", createGroup(
							createKeyword("{"),
							createAssignment("ownedPatternGuard", "=", createRuleCall(PR_ExpCS)),
							createKeyword("}")))))));
			PR_URIFirstPathElementCS.setAlternatives(
				createAlternatives(
					createAssignment("referredElement", "=", createCrossReference(
						createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(_QVTrelation.PR_UnrestrictedName))),
					createGroup(
						createAction(null, null, createTypeRef(MM_base, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_WITH_URICS)),
						createAssignment("referredElement", "=", createCrossReference(
							createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMESPACE), createRuleCall(_Base.PR_URI))))));
			PR_URIPathNameCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathElements", "+=", createRuleCall(PR_URIFirstPathElementCS)),
					setCardinality("*", createGroup(
						createKeyword("::"),
						createAssignment("ownedPathElements", "+=", createRuleCall(_Base.PR_NextPathElementCS))))));
			PR_UnaryOperatorName.setAlternatives(
				createRuleCall(PR_EssentialOCLUnaryOperatorName));
			PR_UnlimitedNaturalLiteralExpCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP_CS)),
					createKeyword("*")));
			PR_UnreservedName.setAlternatives(
				createRuleCall(PR_EssentialOCLUnreservedName));
			addAnnotation(PR_UnreservedName, "Override");
			PR_UnrestrictedName.setAlternatives(
				createRuleCall(PR_EssentialOCLUnrestrictedName));
			addAnnotation(PR_UnrestrictedName, "Override");
		}

		private static @NonNull Grammar initGrammar() {
			initParserRules();
			Grammar grammar = G_EssentialOCL;
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_pivot);
				metamodelDeclarations.add(MM_base);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_Model);
				rules.add(PR_EssentialOCLReservedKeyword);
				rules.add(PR_EssentialOCLUnaryOperatorName);
				rules.add(PR_EssentialOCLInfixOperatorName);
				rules.add(PR_EssentialOCLNavigationOperatorName);
				rules.add(PR_BinaryOperatorName);
				rules.add(PR_InfixOperatorName);
				rules.add(PR_NavigationOperatorName);
				rules.add(PR_UnaryOperatorName);
				rules.add(PR_EssentialOCLUnrestrictedName);
				rules.add(PR_UnrestrictedName);
				rules.add(PR_EssentialOCLUnreservedName);
				rules.add(PR_UnreservedName);
				rules.add(PR_URIPathNameCS);
				rules.add(PR_URIFirstPathElementCS);
				rules.add(PR_SimplePathNameCS);
				rules.add(PR_PrimitiveTypeIdentifier);
				rules.add(PR_PrimitiveTypeCS);
				rules.add(PR_CollectionTypeIdentifier);
				rules.add(PR_CollectionTypeCS);
				rules.add(PR_MapTypeCS);
				rules.add(PR_TupleTypeCS);
				rules.add(PR_TuplePartCS);
				rules.add(PR_CollectionLiteralExpCS);
				rules.add(PR_CollectionLiteralPartCS);
				rules.add(PR_CollectionPatternCS);
				rules.add(PR_ShadowPartCS);
				rules.add(PR_PatternExpCS);
				rules.add(PR_LambdaLiteralExpCS);
				rules.add(PR_MapLiteralExpCS);
				rules.add(PR_MapLiteralPartCS);
				rules.add(PR_PrimitiveLiteralExpCS);
				rules.add(PR_TupleLiteralExpCS);
				rules.add(PR_TupleLiteralPartCS);
				rules.add(PR_NumberLiteralExpCS);
				rules.add(PR_StringLiteralExpCS);
				rules.add(PR_BooleanLiteralExpCS);
				rules.add(PR_UnlimitedNaturalLiteralExpCS);
				rules.add(PR_InvalidLiteralExpCS);
				rules.add(PR_NullLiteralExpCS);
				rules.add(PR_TypeLiteralCS);
				rules.add(PR_TypeLiteralWithMultiplicityCS);
				rules.add(PR_TypeLiteralExpCS);
				rules.add(PR_TypeNameExpCS);
				rules.add(PR_TypeExpWithoutMultiplicityCS);
				rules.add(PR_TypeExpCS);
				rules.add(PR_ExpCS);
				rules.add(PR_PrefixedLetExpCS);
				rules.add(PR_PrefixedPrimaryExpCS);
				rules.add(PR_PrimaryExpCS);
				rules.add(PR_NameExpCS);
				rules.add(PR_CurlyBracketedClauseCS);
				rules.add(PR_RoundBracketedClauseCS);
				rules.add(PR_SquareBracketedClauseCS);
				rules.add(PR_NavigatingArgCS);
				rules.add(PR_NavigatingBarArgCS);
				rules.add(PR_NavigatingCommaArgCS);
				rules.add(PR_NavigatingSemiArgCS);
				rules.add(PR_NavigatingArgExpCS);
				rules.add(PR_CoIteratorVariableCS);
				rules.add(PR_IfExpCS);
				rules.add(PR_ElseIfThenExpCS);
				rules.add(PR_LetExpCS);
				rules.add(PR_LetVariableCS);
				rules.add(PR_NestedExpCS);
				rules.add(PR_SelfExpCS);
			}
			{
				List<Grammar> usedGrammars = grammar.getUsedGrammars();
				usedGrammars.add(G_Base);
			}
			return grammar;
		}
	}

	private static class _Base
	{
		private static final @NonNull ReferencedMetamodel MM = createReferencedMetamodel(org.eclipse.ocl.xtext.basecs.BaseCSPackage.eINSTANCE, null); // http://www.eclipse.org/ocl/2015/BaseCS
		private static final @NonNull ReferencedMetamodel MM_ecore = createReferencedMetamodel(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, "ecore"); // http://www.eclipse.org/emf/2002/Ecore
		private static final @NonNull ReferencedMetamodel MM_pivot = createReferencedMetamodel(org.eclipse.ocl.pivot.PivotPackage.eINSTANCE, "pivot"); // http://www.eclipse.org/ocl/2015/Pivot

		private static final @NonNull TerminalRule TR_ANY_OTHER = createTerminalRule("ANY_OTHER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_DOUBLE_QUOTED_STRING = createTerminalRule("DOUBLE_QUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ESCAPED_CHARACTER = createTerminalRule("ESCAPED_CHARACTER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ESCAPED_ID = createTerminalRule("ESCAPED_ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_INT = createTerminalRule("INT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_LETTER_CHARACTER = createTerminalRule("LETTER_CHARACTER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ML_COMMENT = createTerminalRule("ML_COMMENT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_ML_SINGLE_QUOTED_STRING = createTerminalRule("ML_SINGLE_QUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SIMPLE_ID = createTerminalRule("SIMPLE_ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SINGLE_QUOTED_STRING = createTerminalRule("SINGLE_QUOTED_STRING", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_SL_COMMENT = createTerminalRule("SL_COMMENT", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull TerminalRule TR_WS = createTerminalRule("WS", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));

		private static void initTerminalRules() {
			TR_ANY_OTHER.setAlternatives(
				createWildcard());
			TR_DOUBLE_QUOTED_STRING.setAlternatives(
				createGroup(
					createKeyword("\""),
					setCardinality("*", createAlternatives(
						createRuleCall(TR_ESCAPED_CHARACTER),
						createNegatedToken(createAlternatives(
							createKeyword("\\"),
							createKeyword("\""))))),
					createKeyword("\"")));
			TR_ESCAPED_CHARACTER.setFragment(true);
			TR_ESCAPED_CHARACTER.setAlternatives(
				createGroup(
					createKeyword("\\"),
					createAlternatives(
						createKeyword("b"),
						createKeyword("t"),
						createKeyword("n"),
						createKeyword("f"),
						createKeyword("r"),
						createKeyword("u"),
						createKeyword("\""),
						createKeyword("\'"),
						createKeyword("\\"))));
			TR_ESCAPED_ID.setAlternatives(
				createGroup(
					createKeyword("_"),
					createRuleCall(TR_SINGLE_QUOTED_STRING)));
			TR_INT.setAlternatives(
				setCardinality("+", createCharacterRange(createKeyword("0"), createKeyword("9"))));
			TR_LETTER_CHARACTER.setFragment(true);
			TR_LETTER_CHARACTER.setAlternatives(
				createAlternatives(
					createCharacterRange(createKeyword("a"), createKeyword("z")),
					createCharacterRange(createKeyword("A"), createKeyword("Z")),
					createKeyword("_")));
			TR_ML_COMMENT.setAlternatives(
				createGroup(
					createKeyword("/*"),
					createUntilToken(createKeyword("*/"))));
			TR_ML_SINGLE_QUOTED_STRING.setAlternatives(
				createGroup(
					createKeyword("/\'"),
					createUntilToken(createKeyword("\'/"))));
			TR_SIMPLE_ID.setAlternatives(
				createGroup(
					createRuleCall(TR_LETTER_CHARACTER),
					setCardinality("*", createAlternatives(
						createRuleCall(TR_LETTER_CHARACTER),
						createCharacterRange(createKeyword("0"), createKeyword("9"))))));
			TR_SINGLE_QUOTED_STRING.setAlternatives(
				createGroup(
					createKeyword("\'"),
					setCardinality("*", createAlternatives(
						createRuleCall(TR_ESCAPED_CHARACTER),
						createNegatedToken(createAlternatives(
							createKeyword("\\"),
							createKeyword("\'"))))),
					createKeyword("\'")));
			TR_SL_COMMENT.setAlternatives(
				createGroup(
					createKeyword("--"),
					setCardinality("*", createNegatedToken(createAlternatives(
						createKeyword("\n"),
						createKeyword("\r")))),
					setCardinality("?", createGroup(
						setCardinality("?", createKeyword("\r")),
						createKeyword("\n")))));
			TR_WS.setAlternatives(
				setCardinality("+", createAlternatives(
					createKeyword(" "),
					createKeyword("\t"),
					createKeyword("\r"),
					createKeyword("\n"))));
		}

		private static final @NonNull ParserRule PR_FirstPathElementCS = createParserRule("FirstPathElementCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_ID = createParserRule("ID", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_Identifier = createParserRule("Identifier", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_LOWER = createParserRule("LOWER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.EINT));
		private static final @NonNull ParserRule PR_MultiplicityBoundsCS = createParserRule("MultiplicityBoundsCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_BOUNDS_CS));
		private static final @NonNull ParserRule PR_MultiplicityCS = createParserRule("MultiplicityCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_CS));
		private static final @NonNull ParserRule PR_MultiplicityStringCS = createParserRule("MultiplicityStringCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.MULTIPLICITY_STRING_CS));
		private static final @NonNull ParserRule PR_NUMBER_LITERAL = createParserRule("NUMBER_LITERAL", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.BIG_NUMBER));
		private static final @NonNull ParserRule PR_NextPathElementCS = createParserRule("NextPathElementCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_ELEMENT_CS));
		private static final @NonNull ParserRule PR_PathNameCS = createParserRule("PathNameCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_StringLiteral = createParserRule("StringLiteral", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_TemplateBindingCS = createParserRule("TemplateBindingCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TEMPLATE_BINDING_CS));
		private static final @NonNull ParserRule PR_TemplateParameterSubstitutionCS = createParserRule("TemplateParameterSubstitutionCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TEMPLATE_PARAMETER_SUBSTITUTION_CS));
		private static final @NonNull ParserRule PR_TemplateSignatureCS = createParserRule("TemplateSignatureCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TEMPLATE_SIGNATURE_CS));
		private static final @NonNull ParserRule PR_TypeParameterCS = createParserRule("TypeParameterCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPE_PARAMETER_CS));
		private static final @NonNull ParserRule PR_TypeRefCS = createParserRule("TypeRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPE_REF_CS));
		private static final @NonNull ParserRule PR_TypedRefCS = createParserRule("TypedRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_REF_CS));
		private static final @NonNull ParserRule PR_TypedTypeRefCS = createParserRule("TypedTypeRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.TYPED_TYPE_REF_CS));
		private static final @NonNull ParserRule PR_UPPER = createParserRule("UPPER", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.EINT));
		private static final @NonNull ParserRule PR_URI = createParserRule("URI", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnreservedName = createParserRule("UnreservedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_UnreservedPathNameCS = createParserRule("UnreservedPathNameCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.PATH_NAME_CS));
		private static final @NonNull ParserRule PR_UnrestrictedName = createParserRule("UnrestrictedName", createTypeRef(MM_ecore, org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING));
		private static final @NonNull ParserRule PR_WildcardTypeRefCS = createParserRule("WildcardTypeRefCS", createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS));

		private static void initParserRules() {
			PR_FirstPathElementCS.setAlternatives(
				createAssignment("referredElement", "=", createCrossReference(
					createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(_QVTrelation.PR_UnrestrictedName))));
			PR_ID.setAlternatives(
				createAlternatives(
					createRuleCall(TR_SIMPLE_ID),
					createRuleCall(TR_ESCAPED_ID)));
			PR_Identifier.setAlternatives(
				createRuleCall(PR_ID));
			PR_LOWER.setAlternatives(
				createRuleCall(TR_INT));
			PR_MultiplicityBoundsCS.setAlternatives(
				createGroup(
					createAssignment("lowerBound", "=", createRuleCall(PR_LOWER)),
					setCardinality("?", createGroup(
						createKeyword(".."),
						createAssignment("upperBound", "=", createRuleCall(PR_UPPER))))));
			PR_MultiplicityCS.setAlternatives(
				createGroup(
					createKeyword("["),
					createAlternatives(
						createRuleCall(PR_MultiplicityBoundsCS),
						createRuleCall(PR_MultiplicityStringCS)),
					setCardinality("?", createAlternatives(
						createKeyword("|?"),
						createAssignment("isNullFree", "?=", createKeyword("|1")))),
					createKeyword("]")));
			PR_MultiplicityStringCS.setAlternatives(
				createAssignment("stringBounds", "=", createAlternatives(
					createKeyword("*"),
					createKeyword("+"),
					createKeyword("?"))));
			PR_NUMBER_LITERAL.setAlternatives(
				createRuleCall(TR_INT));
			PR_NextPathElementCS.setAlternatives(
				createAssignment("referredElement", "=", createCrossReference(
					createTypeRef(MM_pivot, org.eclipse.ocl.pivot.PivotPackage.Literals.NAMED_ELEMENT), createRuleCall(_EssentialOCL.PR_UnreservedName))));
			PR_PathNameCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathElements", "+=", createRuleCall(PR_FirstPathElementCS)),
					setCardinality("*", createGroup(
						createKeyword("::"),
						createAssignment("ownedPathElements", "+=", createRuleCall(PR_NextPathElementCS))))));
			PR_StringLiteral.setAlternatives(
				createRuleCall(TR_SINGLE_QUOTED_STRING));
			PR_TemplateBindingCS.setAlternatives(
				createGroup(
					createAssignment("ownedSubstitutions", "+=", createRuleCall(PR_TemplateParameterSubstitutionCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedSubstitutions", "+=", createRuleCall(PR_TemplateParameterSubstitutionCS)))),
					setCardinality("?", createAssignment("ownedMultiplicity", "=", createRuleCall(PR_MultiplicityCS)))));
			PR_TemplateParameterSubstitutionCS.setAlternatives(
				createAssignment("ownedActualParameter", "=", createRuleCall(PR_TypeRefCS)));
			PR_TemplateSignatureCS.setAlternatives(
				createGroup(
					createKeyword("("),
					createAssignment("ownedParameters", "+=", createRuleCall(PR_TypeParameterCS)),
					setCardinality("*", createGroup(
						createKeyword(","),
						createAssignment("ownedParameters", "+=", createRuleCall(PR_TypeParameterCS)))),
					createKeyword(")")));
			PR_TypeParameterCS.setAlternatives(
				createGroup(
					createAssignment("name", "=", createRuleCall(_QVTrelation.PR_UnrestrictedName)),
					setCardinality("?", createGroup(
						createKeyword("extends"),
						createAssignment("ownedExtends", "+=", createRuleCall(_QVTrelation.PR_TypedRefCS)),
						setCardinality("*", createGroup(
							createKeyword("&&"),
							createAssignment("ownedExtends", "+=", createRuleCall(_QVTrelation.PR_TypedRefCS))))))));
			PR_TypeRefCS.setAlternatives(
				createAlternatives(
					createRuleCall(_QVTrelation.PR_TypedRefCS),
					createRuleCall(PR_WildcardTypeRefCS)));
			PR_TypedRefCS.setAlternatives(
				createRuleCall(_QVTrelation.PR_TypedTypeRefCS));
			PR_TypedTypeRefCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathName", "=", createRuleCall(PR_PathNameCS)),
					setCardinality("?", createGroup(
						createKeyword("("),
						createAssignment("ownedBinding", "=", createRuleCall(PR_TemplateBindingCS)),
						createKeyword(")")))));
			PR_UPPER.setAlternatives(
				createAlternatives(
					createRuleCall(TR_INT),
					createKeyword("*")));
			PR_URI.setAlternatives(
				createRuleCall(TR_SINGLE_QUOTED_STRING));
			PR_UnreservedName.setAlternatives(
				createRuleCall(_QVTrelation.PR_UnrestrictedName));
			PR_UnreservedPathNameCS.setAlternatives(
				createGroup(
					createAssignment("ownedPathElements", "+=", createRuleCall(PR_NextPathElementCS)),
					setCardinality("*", createGroup(
						createKeyword("::"),
						createAssignment("ownedPathElements", "+=", createRuleCall(PR_NextPathElementCS))))));
			PR_UnrestrictedName.setAlternatives(
				createRuleCall(PR_Identifier));
			PR_WildcardTypeRefCS.setAlternatives(
				createGroup(
					createAction(null, null, createTypeRef(MM, org.eclipse.ocl.xtext.basecs.BaseCSPackage.Literals.WILDCARD_TYPE_REF_CS)),
					createKeyword("?"),
					setCardinality("?", createGroup(
						createKeyword("extends"),
						createAssignment("ownedExtends", "=", createRuleCall(_QVTrelation.PR_TypedRefCS))))));
		}

		private static @NonNull Grammar initGrammar() {
			initTerminalRules();
			initParserRules();
			Grammar grammar = G_Base;
			grammar.setDefinesHiddenTokens(true);
			{
				List<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
				metamodelDeclarations.add(MM_ecore);
				metamodelDeclarations.add(MM_pivot);
				metamodelDeclarations.add(MM);
			}
			{
				List<AbstractRule> rules = grammar.getRules();
				rules.add(PR_MultiplicityBoundsCS);
				rules.add(PR_MultiplicityCS);
				rules.add(PR_MultiplicityStringCS);
				rules.add(PR_PathNameCS);
				rules.add(PR_UnreservedPathNameCS);
				rules.add(PR_FirstPathElementCS);
				rules.add(PR_NextPathElementCS);
				rules.add(PR_TemplateBindingCS);
				rules.add(PR_TemplateParameterSubstitutionCS);
				rules.add(PR_TemplateSignatureCS);
				rules.add(PR_TypeParameterCS);
				rules.add(PR_TypeRefCS);
				rules.add(PR_TypedRefCS);
				rules.add(PR_TypedTypeRefCS);
				rules.add(PR_UnreservedName);
				rules.add(PR_UnrestrictedName);
				rules.add(PR_WildcardTypeRefCS);
				rules.add(PR_ID);
				rules.add(PR_Identifier);
				rules.add(PR_LOWER);
				rules.add(PR_NUMBER_LITERAL);
				rules.add(PR_StringLiteral);
				rules.add(PR_UPPER);
				rules.add(PR_URI);
				rules.add(TR_ESCAPED_CHARACTER);
				rules.add(TR_LETTER_CHARACTER);
				rules.add(TR_DOUBLE_QUOTED_STRING);
				rules.add(TR_SINGLE_QUOTED_STRING);
				rules.add(TR_ML_SINGLE_QUOTED_STRING);
				rules.add(TR_SIMPLE_ID);
				rules.add(TR_ESCAPED_ID);
				rules.add(TR_INT);
				rules.add(TR_ML_COMMENT);
				rules.add(TR_SL_COMMENT);
				rules.add(TR_WS);
				rules.add(TR_ANY_OTHER);
			}
			{
				List<AbstractRule> hiddenTokens = grammar.getHiddenTokens();
				hiddenTokens.add(TR_WS);
				hiddenTokens.add(TR_ML_COMMENT);
				hiddenTokens.add(TR_SL_COMMENT);
			}
			return grammar;
		}
	}
}
