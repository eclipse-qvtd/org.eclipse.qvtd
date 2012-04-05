--/**
-- * Copyright (c) 2007,2008 E.D.Willink and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   E.D.Willink - Initial API and implementation
-- */
--
-- The QVTr Parser
--

%options escape=$
%options la=1
%options fp=QVTrParser,prefix=TK_
%options backtrack
%options noserialize
%options package=org.eclipse.qvt.declarative.parser.qvtrelation
%options import_terminals=QVTrLexer.gi
%options ast_type=CSTNode
%options ParseTable=lpg.runtime.ParseTable
%options template=btParserTemplateF.gi
%options include_directory=".;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser/backtracking"

%KeyWords
	checkonly
	default_values
	domain
	enforce
	extends
	implementedby
	import
	key
	overrides
	primitive
	query
	relation
	replace
	top
	transformation
	when
	where
%End

%Terminals
	PLUS_PLUS     ::= '++'
%End

%Globals
/.
import org.eclipse.qvt.declarative.parser.qvt.cst.*;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.*;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.parser.$super_parser_class;
import org.eclipse.ocl.parser.backtracking.OCLParserErrors;

./
%End

%Start
	topLevelCS
%End

%Import
	EssentialOCL.gi
%End

%Import
	EssentialOCLErrors.gi
%End

%Define
    $environment_class /.ICSTFileEnvironment./
	$super_lexer_class /.QVTrLexer./
    $LPGParsersym_class /.QVTrParserSymbols./
	$copyright_contributions /.*   E.D.Willink - Extended API and implementation for QVTr
*./
%End

%Headers
	/.			
		protected IdentifierCS createIdentifierCS(int argumentNumber) {
			IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
			result.setValue(getRhsTokenText(argumentNumber));
			setOffsets(result, getRhsIToken(argumentNumber));
			return result;
		}

		protected IdentifierCS createIdentifierCS(SimpleNameCS simpleName) {
			IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
			result.setValue(simpleName.getValue());
			setOffsets(result, simpleName);
			return result;
		}

		private int _uniqueNameCount = 0;

		protected IdentifierCS createUniqueIdentifierCS(int argumentNumber) {
			IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
			result.setValue("_unique" + _uniqueNameCount++);
			setOffsets(result, getRhsIToken(argumentNumber));
			return result;
		}
	./
%End

%Rules
--<topLevel> ::= ('import' <unit> ';' )* <transformation>*
	topLevelCS_0_ ::= $empty
		/.$BeginCode
					TopLevelCS result = QVTrCSTFactory.eINSTANCE.createTopLevelCS();
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	topLevelCS_0_ ::= topLevelCS_0_ import unitCS ';'
		/.$BeginCode
					TopLevelCS result = (TopLevelCS)getRhsSym(1);
					result.getImportClause().add((UnitCS)getRhsSym(3));
					setOffsets(result, result, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./
	topLevelCS_0_ ::= topLevelCS_0_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_TOPLEVEL);
		  $EndCode
		./	
	topLevelCS_1_ ::= topLevelCS transformationCS
		/.$BeginCode
					TransformationCS transformationCS = (TransformationCS)getRhsSym(2);
					TopLevelCS result = (TopLevelCS)getRhsSym(1);
					result.getTransformation().add(transformationCS);
					setOffsets(result, result, transformationCS);
					setResult(result);
		  $EndCode
		./
	topLevelCS_1_ ::= topLevelCS_1_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION);
		  $EndCode
		./	
	topLevelCS -> topLevelCS_0_
	topLevelCS -> topLevelCS_1_
		
--<unit> ::= <identifier> ('.' <identifier>)*
	unitCS ::= identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					UnitCS result = QVTrCSTFactory.eINSTANCE.createUnitCS();
					result.getIdentifier().add(identifierCS);
					setOffsets(result, identifierCS);
					setResult(result);
		  $EndCode
		./
	unitCS ::= unitCS '.' identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
					UnitCS result = (UnitCS)getRhsSym(1);
					result.getIdentifier().add(identifierCS);
					setOffsets(result, result, identifierCS);
					setResult(result);
		  $EndCode
		./
	
--<transformation> ::= 'transformation' <identifier> 
--                     '(' <modelDecl> (',' <modelDecl>)* ')' 
--                     ['extends' <identifier> (',' <identifier>)* ]
--                     '{' <keyDecl>* ( <relation> | <query> )* '}'
	transformationCS_0_ ::= transformation identifierCS '(' modelDeclCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
					ModelDeclCS modelDeclCS = (ModelDeclCS)getRhsSym(4);
					TransformationCS result = QVTrCSTFactory.eINSTANCE.createTransformationCS();
					result.setIdentifier(identifierCS);
					result.getModelDecl().add(modelDeclCS);
					setOffsets(result, getRhsIToken(1), modelDeclCS);
					setResult(result);
		  $EndCode
		./
	transformationCS_0_ ::= transformationCS_0_ ',' modelDeclCS
		/.$BeginCode
					ModelDeclCS modelDeclCS = (ModelDeclCS)getRhsSym(3);
					TransformationCS result = (TransformationCS)getRhsSym(1);
					result.getModelDecl().add(modelDeclCS);
					setOffsets(result, result, modelDeclCS);
					setResult(result);
		  $EndCode
		./
	transformationCS_0_ ::= transformationCS_0_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_MODELDECL);
		  $EndCode
		./	
	transformationCS_1_ ::= transformationCS_0_ ')'
		/.$BeginCode
					TransformationCS result = (TransformationCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	transformationCS_2_ -> transformationCS_1_
	transformationCS_2_ ::= transformationCS_1_ extends identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
					TransformationCS result = (TransformationCS)getRhsSym(1);
					result.setExtends(identifierCS);
					setOffsets(result, result, identifierCS);
					setResult(result);
		  $EndCode
		./
	transformationCS_3_ -> transformationCS_2_ '{'
	transformationCS_3_ ::= transformationCS_3_ keyDeclCS
		/.$BeginCode
					KeyDeclCS keyDeclCS = (KeyDeclCS)getRhsSym(2);
					TransformationCS result = (TransformationCS)getRhsSym(1);
					result.getKeyDecl().add(keyDeclCS);
					setOffsets(result, result, keyDeclCS);
					setResult(result);
		  $EndCode
		./
	transformationCS_4_ -> transformationCS_3_
	transformationCS_4_ ::= transformationCS_4_ queryCS
		/.$BeginCode
					QueryCS queryCS =(QueryCS)getRhsSym(2);
					TransformationCS result = (TransformationCS)getRhsSym(1);
					result.getQuery().add(queryCS);
					setOffsets(result, result, queryCS);
					setResult(result);
		  $EndCode
		./
	transformationCS_4_ ::= transformationCS_4_ relationCS
		/.$BeginCode
					RelationCS relationCS = (RelationCS)getRhsSym(2);
					TransformationCS result = (TransformationCS)getRhsSym(1);
					result.getRelation().add(relationCS);
					setOffsets(result, result, relationCS);
					setResult(result);
		  $EndCode
		./
	transformationCS_4_ ::= transformationCS_4_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION_ELEMENT);
		  $EndCode
		./	
	transformationCS ::= transformationCS_4_ '}'
		/.$BeginCode
					TransformationCS result = (TransformationCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	
--<modelDecl> ::= <modelId> ':' <metaModelId>
--**<modelDecl> ::= <modelId> ':' '{' <metaModelId> (',' <metaModelId>)* '}'
	modelDeclCS_0_ ::= modelIdCS ':'
		/.$BeginCode
					IdentifierCS modelIdCS = (IdentifierCS)getRhsSym(1);
					ModelDeclCS result = QVTrCSTFactory.eINSTANCE.createModelDeclCS();
					result.setModelId(modelIdCS);
					setOffsets(result, modelIdCS, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	modelDeclCS_1_ -> modelDeclCS_0_ '{'
	modelDeclCS_1_ -> modelDeclCS_2_ ','
	modelDeclCS_2_ ::= modelDeclCS_1_ metaModelIdCS
		/.$NewCase ./
	modelDeclCS ::= modelDeclCS_0_ metaModelIdCS
		/.$BeginCode
					IdentifierCS metaModelIdCS = (IdentifierCS)getRhsSym(2);
					ModelDeclCS result = (ModelDeclCS)getRhsSym(1);
					result.getMetaModelId().add(metaModelIdCS);
					setOffsets(result, result, metaModelIdCS);
					setResult(result);
		  $EndCode
		./
	modelDeclCS_2_ ::= modelDeclCS_1_ ERROR_TOKEN
		/.$NewCase ./
	modelDeclCS ::= modelDeclCS_0_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_MODELDECL_ELEMENT);
		  $EndCode
		./	
	modelDeclCS ::= modelDeclCS_2_ '}'
		/.$BeginCode
					ModelDeclCS result = (ModelDeclCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	
--<modelId> ::= <identifier>
	modelIdCS -> identifierCS
	
--<metaModelId> ::= <identifier>
	metaModelIdCS -> identifierCS

--<keyDecl> ::= 'key' <classId> '{' <propertyId> (, <propertyId>)* '}' ';'
	keyDeclCS_0_ ::= key classIdCS '{'
		/.$BeginCode
					PathNameCS classIdCS = (PathNameCS)getRhsSym(2);
					KeyDeclCS result = QVTrCSTFactory.eINSTANCE.createKeyDeclCS();
					result.setClassId(classIdCS);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	keyDeclCS_0_ -> keyDeclCS_1_ ','
	keyDeclCS_1_ ::= keyDeclCS_0_ propertyIdCS
		/.$BeginCode
					IdentifiedCS propertyIdCS = (IdentifiedCS)getRhsSym(2);
					KeyDeclCS result = (KeyDeclCS)getRhsSym(1);
					result.getPropertyId().add(propertyIdCS);
					setOffsets(result, result, propertyIdCS);
					setResult(result);
		  $EndCode
		./
	keyDeclCS_1_ ::= keyDeclCS_0_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_KEYDECL_ELEMENT);
		  $EndCode
		./	
	keyDeclCS ::= keyDeclCS_1_ '}' ';'
		/.$BeginCode
					KeyDeclCS result = (KeyDeclCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	
--<classId> ::= <PathNameCS>
	classIdCS -> pathNameCS

--<propertyId> ::= <identifier>
	propertyIdCS ::= identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS);
					setResult(result);
		  $EndCode
		./

--<relation> ::= ['top'] 'relation' <identifier>
--   			 ['overrides' <identifier>]
--               '{'
--               <varDeclaration>*
--               (<domain> | <primitiveTypeDomain>)+ 
--               [<when>] [<where>]
--               '}'
--<when> ::= 'when' '{' (<OclExpressionCS> ';')* '}'
--<where> ::= 'where' '{' (<OclExpressionCS> ';')* '}'
	relationCS_withName ::= relation identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
					RelationCS result = QVTrCSTFactory.eINSTANCE.createRelationCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, getRhsIToken(1), identifierCS);
					setResult(result);
		  $EndCode
		./
	relationCS_postName -> relationCS_withName
	relationCS_postName ::= top relationCS_withName
		/.$BeginCode
					RelationCS result = (RelationCS)getRhsSym(2);
					result.setTop(true);
					setOffsets(result, getRhsIToken(1), result);
					setResult(result);
		  $EndCode
		./
	relationCS_postOverrides -> relationCS_postName
	relationCS_postOverrides ::= relationCS_postName overrides identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
					RelationCS result = (RelationCS)getRhsSym(1);
					result.setOverrides(identifierCS);
					setOffsets(result, result, identifierCS);
					setResult(result);
		  $EndCode
		./
	relationCS_postVariable -> relationCS_postOverrides '{'
	relationCS_postVariable ::= relationCS_postVariable varDeclarationCS
		/.$BeginCode
					VarDeclarationCS varDeclarationCS = (VarDeclarationCS)getRhsSym(2);
					RelationCS result = (RelationCS)getRhsSym(1);
					result.getVarDeclaration().add(varDeclarationCS);
					setOffsets(result, result, varDeclarationCS);
					setResult(result);
		  $EndCode
		./
	relationCS_postDomain ::= relationCS_postVariable domainCS
		/.$NewCase ./
	relationCS_postDomain ::= relationCS_postDomain domainCS
		/.$BeginCode
					AbstractDomainCS domainCS = (AbstractDomainCS)getRhsSym(2);
					RelationCS result = (RelationCS)getRhsSym(1);
					result.getDomain().add(domainCS);
					setOffsets(result, result, domainCS);
					setResult(result);
		  $EndCode
		./
	relationCS_postWhen -> relationCS_postDomain
	relationCS_postWhen ::= relationCS_postDomain whenCS
		/.$BeginCode
					RelationCS result = (RelationCS)getRhsSym(1);
					WhenCS whenCS = (WhenCS)getRhsSym(2);
					result.setWhen(whenCS);
					setOffsets(result, result, whenCS);
					setResult(result);
		  $EndCode
		./
	relationCS_postWhere -> relationCS_postWhen
	relationCS_postWhere ::= relationCS_postWhen whereCS
		/.$BeginCode
					RelationCS result = (RelationCS)getRhsSym(1);
					WhereCS whereCS = (WhereCS)getRhsSym(2);
					result.setWhere(whereCS);
					setOffsets(result, result, whereCS);
					setResult(result);
		  $EndCode
		./
	relationCS ::= relationCS_postWhere '}'
		/.$BeginCode
					RelationCS result = (RelationCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./

	whenCS_0 ::= when '{'
		/.$BeginCode
					WhenCS result = QVTrCSTFactory.eINSTANCE.createWhenCS();
					setOffsets(result, getRhsIToken(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	whenCS_0 ::= when ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_WHEN);
		  $EndCode
		./	
	whenCS_1 -> whenCS_0
	whenCS_1 ::= whenCS_1 OclExpressionCS ';'
		/.$BeginCode
					WhenCS result = (WhenCS)getRhsSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(2);
					result.getExpr().add(OclExpressionCS);
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	whenCS ::= whenCS_1 '}'
		/.$BeginCode
					WhenCS result = (WhenCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./


	whereCS_0 ::= where '{'
		/.$BeginCode
					WhereCS result = QVTrCSTFactory.eINSTANCE.createWhereCS();
					setOffsets(result, getRhsIToken(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	whereCS_0 ::= where ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_WHERE);
		  $EndCode
		./	
	whereCS_1 -> whereCS_0
	whereCS_1 ::= whereCS_1 OclExpressionCS ';'
		/.$BeginCode
					WhereCS result = (WhereCS)getRhsSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(2);
					result.getExpr().add(OclExpressionCS);
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	whereCS ::= whereCS_1 '}'
		/.$BeginCode
					WhereCS result = (WhereCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./


--<varDeclaration> ::= <identifier> (, <identifier>)* ':' <TypeCS> ';'
	varDeclarationCS_0 ::= identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					VarDeclarationCS result = QVTrCSTFactory.eINSTANCE.createVarDeclarationCS();
					result.getVarDeclarationId().add(identifierCS);
					setOffsets(result, identifierCS);
					setResult(result);
		  $EndCode
		./
	varDeclarationCS_0 ::= varDeclarationCS_0 ',' identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
					VarDeclarationCS result = (VarDeclarationCS)getRhsSym(1);
					result.getVarDeclarationId().add(identifierCS);
					setOffsets(result, result, identifierCS);
					setResult(result);
		  $EndCode
		./		
	varDeclarationCS ::= varDeclarationCS_0 ':' typeCS ';'
		/.$BeginCode
					VarDeclarationCS result = (VarDeclarationCS)getRhsSym(1);
					result.setType((TypeCS)getRhsSym(3));
					setOffsets(result, result, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./
	
--<domain> ::= [<checkEnforceQualifier>] 'domain' <modelId> <template>
--             ['implementedby' <OperationCallExpCS>]
--             ['default_values' '{' (<assignmentExp>)+ '}']
--             ';'
--<checkEnforceQualifier> ::= 'checkonly' | 'enforce'
	domainCS_0_ ::= domain modelIdCS templateCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
					TemplateCS templateCS = (TemplateCS)getRhsSym(3);
					DomainCS result = QVTrCSTFactory.eINSTANCE.createDomainCS();
					result.setModelId(identifierCS);
					result.setTemplate(templateCS);
					setOffsets(result, getRhsIToken(1), templateCS);
					setResult(result);
		  $EndCode
		./
	domainCS_1_ -> domainCS_0_
	domainCS_1_ ::= checkonly domainCS_0_
		/.$BeginCode
					DomainCS result = (DomainCS)getRhsSym(2);
					result.setCheckonly(true);
					setOffsets(result, getRhsIToken(1), result);
					setResult(result);
		  $EndCode
		./
	domainCS_1_ ::= enforce domainCS_0_
		/.$BeginCode
					DomainCS result = (DomainCS)getRhsSym(2);
					result.setEnforce(true);
					setOffsets(result, getRhsIToken(1), result);
					setResult(result);
		  $EndCode
		./
	domainCS_1_ ::= replace domainCS_0_
		/.$BeginCode
					DomainCS result = (DomainCS)getRhsSym(2);
					result.setReplace(true);
					setOffsets(result, getRhsIToken(1), result);
					setResult(result);
		  $EndCode
		./
	domainCS_postImplementedby -> domainCS_1_
	domainCS_postImplementedby ::= domainCS_1_ implementedby OperationCallExpCS
		/.$BeginCode
					DomainCS result = (DomainCS)getRhsSym(1);
					OperationCallExpCS operationCallExpCS =(OperationCallExpCS)getRhsSym(3);
					result.setImplementedBy(operationCallExpCS);
					setOffsets(result, result, operationCallExpCS);
					setResult(result);
		  $EndCode
		./
	domainCS_preDefaultValue -> domainCS_postImplementedby default_values '{'
	domainCS_preDefaultValue ::= domainCS_preDefaultValue defaultValueCS
		/.$BeginCode
					DomainCS result = (DomainCS)getRhsSym(1);
					DefaultValueCS defaultValueCS = (DefaultValueCS)getRhsSym(2);
					result.getDefaultValue().add(defaultValueCS);
					setOffsets(result, result, defaultValueCS);
					setResult(result);
		  $EndCode
		./
	domainCS_postDefaultValues -> domainCS_postImplementedby
	domainCS_postDefaultValues ::= domainCS_preDefaultValue '}'
		/.$BeginCode
					DomainCS result = (DomainCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	domainCS ::= domainCS_postDefaultValues ';'
		/.$BeginCode
					DomainCS result = (DomainCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
		
--<primitiveTypeDomain> ::= 'primitive' 'domain' <identifier> ':' <TypeCS> ';'
	domainCS ::= primitive domain identifierCS ':' typeCS ';'
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
					TypeCS typeCS = (TypeCS)getRhsSym(5);
					PrimitiveTypeDomainCS result = QVTrCSTFactory.eINSTANCE.createPrimitiveTypeDomainCS();
					result.setIdentifier(identifierCS);
					result.setType(typeCS);
					setOffsets(result, getRhsIToken(1), getRhsIToken(6));
					setResult(result);
		  $EndCode
		./

--<template> ::= (<objectTemplate> | <collectionTemplate>)
--   ['{' <OclExpressionCS> '}']
	templateCS_0_ -> objectTemplateCS
	templateCS_0_ -> collectionTemplateCS
	templateCS -> templateCS_0_
	templateCS ::= templateCS_0_ '{' OclExpressionCS '}'
		/.$BeginCode
					TemplateCS result = (TemplateCS)getRhsSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(3);
					result.setGuardExpression(OclExpressionCS);
					setOffsets(result, result, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./

	notCollectionTypeCS -> tupleTypeCS
	notCollectionTypeCS -> pathNameCS
	notCollectionTypeCS -> primitiveTypeCS
--	notCollectionTypeCS ::= simpleNameCS				-- covers primitiveTypeCS
--		/.$BeginCode
--					CSTNode result = (CSTNode)getRhsSym(1);
--					if (!(result instanceof TypeCS)) {
--						PathNameCS pathNameCS = createPathNameCS((SimpleNameCS)result);
--						setOffsets(pathNameCS, result);
--						result = pathNameCS;
--					}
--					setResult(result);
--		  $EndCode
--		./
	
--<objectTemplate> ::= [<identifier>] ':' <pathNameCS> '{' [<propertyTemplateList>] '}'
--<propertyTemplateList> ::= <propertyTemplate> (',' <propertyTemplate>)*
--	objectTemplateCS_prePropertyTemplates ::= BooleanLiteralExpCS ':' notCollectionTypeCS '{'
--		/.$NewCase./
--	objectTemplateCS_prePropertyTemplates ::= InvalidLiteralExpCS ':' notCollectionTypeCS '{'
--		/.$NewCase./
--	objectTemplateCS_prePropertyTemplates ::= NullLiteralExpCS ':' notCollectionTypeCS '{'
--		/.$NewCase./
	objectTemplateCS_prePropertyTemplates ::= simpleNameCS ':' notCollectionTypeCS '{'
		/.$BeginCode
					IdentifierCS identifierCS = createIdentifierCS(1);
					TypeCS typeCS = (TypeCS)getRhsSym(3);
					ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
					result.setType(typeCS);
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./	
	objectTemplateCS_prePropertyTemplates ::= ':' pathNameCS '{' 
		/.$BeginCode
					ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
					result.setIdentifier(createUniqueIdentifierCS(1));
					result.setType((TypeCS)getRhsSym(2));
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./	
	objectTemplateCS_prePropertyTemplate -> objectTemplateCS_prePropertyTemplates
	objectTemplateCS_prePropertyTemplate -> objectTemplateCS_postPropertyTemplate ','
	objectTemplateCS_postPropertyTemplate ::= objectTemplateCS_prePropertyTemplate propertyTemplateCS 
		/.$BeginCode
					ObjectTemplateCS result = (ObjectTemplateCS)getRhsSym(1);
					PropertyTemplateCS propertyTemplateCS = (PropertyTemplateCS)getRhsSym(2);
					result.getPropertyTemplate().add(propertyTemplateCS);
					setOffsets(result, result, propertyTemplateCS);
					setResult(result);
		  $EndCode
		./	
	objectTemplateCS ::= objectTemplateCS_prePropertyTemplates '}' 
		/.$NewCase./
	objectTemplateCS ::= objectTemplateCS_postPropertyTemplate '}' 
		/.$BeginCode
					ObjectTemplateCS result = (ObjectTemplateCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./

--<propertyTemplate> ::= <identifier> '=' <OclExpressionCS>
	propertyTemplateCS ::= propertyIdCS '=' OclExpressionCS
		/.$BeginCode
					IdentifiedCS propertyIdCS = (IdentifiedCS)getRhsSym(1);
					PropertyTemplateCS result = QVTrCSTFactory.eINSTANCE.createPropertyTemplateCS();
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(3);
					result.setPropertyId(propertyIdCS);
					result.setOclExpression(OclExpressionCS);
					setOffsets(result, propertyIdCS, OclExpressionCS);
					setResult(result);
		  $EndCode
		./
	
--<collectionTemplate> ::= [<identifier>] ':' <CollectionTypeIdentifierCS> '(' <TypeCS> ')'
--                         '{' [<memberSelection>] '}'
--<memberSelection> ::= (<identifier> | <template> | '_')
--			    (‘,’ (<identifier> | <template> | '_'))*
--                      '++'
--                      (<identifier> | '_')
	collectionTemplateCS_1_ ::=  ':' collectionTypeCS
		/.$BeginCode
					CollectionTypeCS collectionTypeCS = (CollectionTypeCS)getRhsSym(2);
					CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
					result.setType(collectionTypeCS);
					result.setIdentifier(createUniqueIdentifierCS(1));
					setOffsets(result, getRhsIToken(1), collectionTypeCS);
					setResult(result);
		  $EndCode
		./	
--	collectionTemplateCS_1_ ::= BooleanLiteralExpCS ':' collectionTypeCS
--		/.$NewCase./
--	collectionTemplateCS_1_ ::= InvalidLiteralExpCS ':' collectionTypeCS
--		/.$NewCase./
--	collectionTemplateCS_1_ ::= NullLiteralExpCS ':' collectionTypeCS
--		/.$NewCase./
	collectionTemplateCS_1_ ::= simpleNameCS ':' collectionTypeCS
		/.$BeginCode
					IdentifierCS identifierCS = createIdentifierCS(1);
					CollectionTypeCS collectionTypeCS = (CollectionTypeCS)getRhsSym(3);
					CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
					result.setType(collectionTypeCS);
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS, collectionTypeCS);
					setResult(result);
		  $EndCode
		./	
	collectionTemplateCS_preMemberSelections -> collectionTemplateCS_1_ '{'
	collectionTemplateCS_preMemberSelection -> collectionTemplateCS_preMemberSelections
	collectionTemplateCS_preMemberSelection -> collectionTemplateCS_postMemberSelection ','
	collectionTemplateCS_postMemberSelection ::= collectionTemplateCS_preMemberSelection memberSelectorCS
		/.$BeginCode
					IdentifiedCS memberSelectorCS = (IdentifiedCS)getRhsSym(2);
					CollectionTemplateCS result = (CollectionTemplateCS)getRhsSym(1);
					result.getMemberIdentifier().add(memberSelectorCS);
					setOffsets(result, result, memberSelectorCS);
					setResult(result);
		  $EndCode
		./	
	collectionTemplateCS ::= collectionTemplateCS_postMemberSelection PLUS_PLUS identifierCS '}'
		/.$BeginCode
					IdentifierCS restIdentifier = (IdentifierCS)getRhsSym(3);
					CollectionTemplateCS result = (CollectionTemplateCS)getRhsSym(1);
					result.setRestIdentifier(restIdentifier);
					setOffsets(result, result, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./
	collectionTemplateCS ::= collectionTemplateCS_postMemberSelection ERROR_TOKEN '}'
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_REST);
					IdentifierCS restIdentifier = createUniqueIdentifierCS(2);
					CollectionTemplateCS result = (CollectionTemplateCS)getRhsSym(1);
					result.setRestIdentifier(restIdentifier);
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	collectionTemplateCS ::= collectionTemplateCS_preMemberSelections '}'
		/.$BeginCode
					CollectionTemplateCS result = (CollectionTemplateCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
		
--<memberSelector> ::= (<identifier> | <template> | '_')
	memberSelectorCS ::= identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS);
					setResult(result);
		  $EndCode
		./	
	memberSelectorCS -> templateCS
	
--<assignmentExp> ::= <identifier> '=' <OclExpressionCS> ';'
	defaultValueCS ::= identifierCS '=' OclExpressionCS ';'
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(3);
					DefaultValueCS result = QVTrCSTFactory.eINSTANCE.createDefaultValueCS();
					result.setIdentifier(identifierCS);
					result.setInitialiser(OclExpressionCS);
					setOffsets(result, identifierCS, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./	
		
--<query> ::= 'query' <PathNameCS> 
--            '(' [<paramDeclaration> (',' <paramDeclaration>)*] ')'
--      	  ':' <TypeCS>
--            (';' | '{' <OclExpressionCS> '}')
	queryCS_preParamDeclaration ::= query pathNameCS '('
		/.$BeginCode
					QueryCS result = QVTrCSTFactory.eINSTANCE.createQueryCS();
					result.setPathName((PathNameCS)getRhsSym(2));
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	queryCS_preParamDeclaration -> queryCS_postParamDeclaration ','
	queryCS_postParamDeclaration ::= queryCS_preParamDeclaration paramDeclarationCS
		/.$BeginCode
					ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)getRhsSym(2);
					QueryCS result = (QueryCS)getRhsSym(1);
					result.getInputParamDeclaration().add(paramDeclarationCS);
					setOffsets(result, result, paramDeclarationCS);
					setResult(result);
		  $EndCode
		./
	queryCS_postType ::= queryCS_postParamDeclaration ')' ':' typeCS
		/.$BeginCode
					TypeCS typeCS = (TypeCS)getRhsSym(4);
					QueryCS result = (QueryCS)getRhsSym(1);
					result.setType(typeCS);
					setOffsets(result, result, typeCS);
					setResult(result);
		  $EndCode
		./
	queryCS ::= queryCS_postType ';'
		/.$BeginCode
					QueryCS result = (QueryCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	queryCS ::= queryCS_postType '{' OclExpressionCS '}'
		/.$BeginCode
					QueryCS result = (QueryCS)getRhsSym(1);
					result.setOclExpression((OCLExpressionCS)getRhsSym(3));
					setOffsets(result, result, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./
	
--<paramDeclaration> ::= <identifier> ':' <TypeCS>	
	paramDeclarationCS ::= identifierCS ':' typeCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					TypeCS typeCS = (TypeCS)getRhsSym(3);
					ParamDeclarationCS result = QVTrCSTFactory.eINSTANCE.createParamDeclarationCS();
					result.setIdentifier(identifierCS);
					result.setType(typeCS);
					setOffsets(result, identifierCS, typeCS);
					setResult(result);
		  $EndCode
		./
	paramDeclarationCS ::= identifierCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_PARAM_DECLARATION);
		  $EndCode
		./	
		
--<OclExpressionCS> ::= <PropertyCallExpCS> 
--                    | <VariableExpCS>
--                    | <LiteralExpCS>
--                    | <LetExpCS>
--                    | <IfExpCS>
--                    | '(' <OclExpressionCS> ')'
--                    | <template>  
	notNameExpressionCS -> templateCS

	relationIdentifier -> checkonly
	relationIdentifier -> default_values
	relationIdentifier -> domain
	relationIdentifier -> enforce
	relationIdentifier -> extends
	relationIdentifier -> implementedby
	relationIdentifier -> import
	relationIdentifier -> key
	relationIdentifier -> overrides
	relationIdentifier -> primitive
	relationIdentifier -> query
	relationIdentifier -> relation
	relationIdentifier -> replace
	relationIdentifier -> top
	relationIdentifier -> transformation
	relationIdentifier -> when
	relationIdentifier -> where
--	relationIdentifier -> '_'	
	
	reservedKeyword -> relationIdentifier
	
	identifierCS ::= IDENTIFIER
		/.$NewCase ./
	identifierCS ::= relationIdentifier
		/.$NewCase ./
	identifierCS ::= self
		/.$BeginCode
					IdentifierCS result = createIdentifierCS(1);
					setResult(result);
		  $EndCode
		./
	identifierCS ::= QuotedSimpleNameCS
		/.$BeginCode
					IdentifierCS result = createIdentifierCS((SimpleNameCS)getRhsSym(1));
					setResult(result);
		  $EndCode
		./
%End
	