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
%options table=java
%options fp=QVTrParser,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options backtrack
%options noserialize
%options package=org.eclipse.qvt.declarative.parser.qvtrelation
%options import_terminals=QVTrLexer.g
%options ast_type=CSTNode
%options programming_language=java
%options action=("*.java", "/.", "./")
%options ParseTable=lpg.lpgjavaruntime.ParseTable
%options include_directory=".;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser/backtracking"

$KeyWords
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
$End

$Terminals
	PLUS_PLUS     ::= '++'
$End

$Globals
/.
import org.eclipse.qvt.declarative.parser.qvt.cst.*;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.*;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.parser.$prs_stream_class;
import org.eclipse.ocl.parser.backtracking.OCLParserErrors;

./
$End

$Start
	topLevelCS
$End

$Include
	EssentialOCL.g
$End

$Include
	EssentialOCLErrors.g
$End

$Define
	$prs_parser_class /.BacktrackingParser./
	$prs_parser_exception /.NotBacktrackParseTableException./
	$prs_parser_throw /.throw new RuntimeException("****Error: Regenerate $prs_type.java with -BACKTRACK option")./
	$prs_parse_args /.error_repair_count./
    $environment_class /.ICSTFileEnvironment./
	$lex_stream_class /.QVTrLexer./
    $LPGParsersym_class /.QVTrParserSymbols./
	$copyright_contributions /.*   E.D.Willink - Extended API and implementation for QVTr
*./
$End

$Headers
	/.			
		protected IdentifierCS createIdentifierCS(int token) {
			IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
			result.setValue(getTokenText(token));
			setOffsets(result, getIToken(token));
			return result;
		}

		private int _uniqueNameCount = 0;

		protected IdentifierCS createUniqueIdentifierCS(int token) {
			IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
			result.setValue("_unique" + _uniqueNameCount++);
			setOffsets(result, getIToken(token));
			return result;
		}
	./
$End

$Rules
--<topLevel> ::= ('import' <unit> ';' )* <transformation>*
	topLevelCS_0_ ::= $empty
		/.$BeginJava
					TopLevelCS result = QVTrCSTFactory.eINSTANCE.createTopLevelCS();
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	topLevelCS_0_ ::= topLevelCS_0_ import unitCS ';'
		/.$BeginJava
					TopLevelCS result = (TopLevelCS)$getSym(1);
					result.getImportClause().add((UnitCS)$getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	topLevelCS_0_ ::= topLevelCS_0_ ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_TOPLEVEL);
		  $EndJava
		./	
	topLevelCS_1_ ::= topLevelCS transformationCS
		/.$BeginJava
					TransformationCS transformationCS = (TransformationCS)$getSym(2);
					TopLevelCS result = (TopLevelCS)$getSym(1);
					result.getTransformation().add(transformationCS);
					setOffsets(result, result, transformationCS);
					$setResult(result);
		  $EndJava
		./
	topLevelCS_1_ ::= topLevelCS_1_ ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION);
		  $EndJava
		./	
	topLevelCS -> topLevelCS_0_
	topLevelCS -> topLevelCS_1_
		
--<unit> ::= <identifier> ('.' <identifier>)*
	unitCS ::= identifierCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					UnitCS result = QVTrCSTFactory.eINSTANCE.createUnitCS();
					result.getIdentifier().add(identifierCS);
					setOffsets(result, identifierCS);
					$setResult(result);
		  $EndJava
		./
	unitCS ::= unitCS '.' identifierCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					UnitCS result = (UnitCS)$getSym(1);
					result.getIdentifier().add(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndJava
		./
	
--<transformation> ::= 'transformation' <identifier> 
--                     '(' <modelDecl> (',' <modelDecl>)* ')' 
--                     ['extends' <identifier> (',' <identifier>)* ]
--                     '{' <keyDecl>* ( <relation> | <query> )* '}'
	transformationCS_0_ ::= transformation identifierCS '(' modelDeclCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(2);
					ModelDeclCS modelDeclCS = (ModelDeclCS)$getSym(4);
					TransformationCS result = QVTrCSTFactory.eINSTANCE.createTransformationCS();
					result.setIdentifier(identifierCS);
					result.getModelDecl().add(modelDeclCS);
					setOffsets(result, getIToken($getToken(1)), modelDeclCS);
					$setResult(result);
		  $EndJava
		./
	transformationCS_0_ ::= transformationCS_0_ ',' modelDeclCS
		/.$BeginJava
					ModelDeclCS modelDeclCS = (ModelDeclCS)$getSym(3);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.getModelDecl().add(modelDeclCS);
					setOffsets(result, result, modelDeclCS);
					$setResult(result);
		  $EndJava
		./
	transformationCS_0_ ::= transformationCS_0_ ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL);
		  $EndJava
		./	
	transformationCS_1_ ::= transformationCS_0_ ')'
		/.$BeginJava
					TransformationCS result = (TransformationCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	transformationCS_2_ -> transformationCS_1_
	transformationCS_2_ ::= transformationCS_1_ extends identifierCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.setExtends(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndJava
		./
	transformationCS_3_ -> transformationCS_2_ '{'
	transformationCS_3_ ::= transformationCS_3_ keyDeclCS
		/.$BeginJava
					KeyDeclCS keyDeclCS = (KeyDeclCS)$getSym(2);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.getKeyDecl().add(keyDeclCS);
					setOffsets(result, result, keyDeclCS);
					$setResult(result);
		  $EndJava
		./
	transformationCS_4_ -> transformationCS_3_
	transformationCS_4_ ::= transformationCS_4_ queryCS
		/.$BeginJava
					QueryCS queryCS =(QueryCS)$getSym(2);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.getQuery().add(queryCS);
					setOffsets(result, result, queryCS);
					$setResult(result);
		  $EndJava
		./
	transformationCS_4_ ::= transformationCS_4_ relationCS
		/.$BeginJava
					RelationCS relationCS = (RelationCS)$getSym(2);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.getRelation().add(relationCS);
					setOffsets(result, result, relationCS);
					$setResult(result);
		  $EndJava
		./
	transformationCS_4_ ::= transformationCS_4_ ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION_ELEMENT);
		  $EndJava
		./	
	transformationCS ::= transformationCS_4_ '}'
		/.$BeginJava
					TransformationCS result = (TransformationCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	
--<modelDecl> ::= <modelId> ':' <metaModelId>
--**<modelDecl> ::= <modelId> ':' '{' <metaModelId> (',' <metaModelId>)* '}'
	modelDeclCS_0_ ::= modelIdCS ':'
		/.$BeginJava
					IdentifierCS modelIdCS = (IdentifierCS)$getSym(1);
					ModelDeclCS result = QVTrCSTFactory.eINSTANCE.createModelDeclCS();
					result.setModelId(modelIdCS);
					setOffsets(result, modelIdCS, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	modelDeclCS_1_ -> modelDeclCS_0_ '{'
	modelDeclCS_1_ -> modelDeclCS_2_ ','
	modelDeclCS_2_ ::= modelDeclCS_1_ metaModelIdCS
		/.$NewCase ./
	modelDeclCS ::= modelDeclCS_0_ metaModelIdCS
		/.$BeginJava
					IdentifierCS metaModelIdCS = (IdentifierCS)$getSym(2);
					ModelDeclCS result = (ModelDeclCS)$getSym(1);
					result.getMetaModelId().add(metaModelIdCS);
					setOffsets(result, result, metaModelIdCS);
					$setResult(result);
		  $EndJava
		./
	modelDeclCS_2_ ::= modelDeclCS_1_ ERROR_TOKEN
		/.$NewCase ./
	modelDeclCS ::= modelDeclCS_0_ ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL_ELEMENT);
		  $EndJava
		./	
	modelDeclCS ::= modelDeclCS_2_ '}'
		/.$BeginJava
					ModelDeclCS result = (ModelDeclCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	
--<modelId> ::= <identifier>
	modelIdCS -> identifierCS
	
--<metaModelId> ::= <identifier>
	metaModelIdCS -> identifierCS

--<keyDecl> ::= 'key' <classId> '{' <propertyId> (, <propertyId>)* '}' ';'
	keyDeclCS_0_ ::= key classIdCS '{'
		/.$BeginJava
					PathNameCS classIdCS = (PathNameCS)$getSym(2);
					KeyDeclCS result = QVTrCSTFactory.eINSTANCE.createKeyDeclCS();
					result.setClassId(classIdCS);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	keyDeclCS_0_ -> keyDeclCS_1_ ','
	keyDeclCS_1_ ::= keyDeclCS_0_ propertyIdCS
		/.$BeginJava
					IdentifiedCS propertyIdCS = (IdentifiedCS)$getSym(2);
					KeyDeclCS result = (KeyDeclCS)$getSym(1);
					result.getPropertyId().add(propertyIdCS);
					setOffsets(result, result, propertyIdCS);
					$setResult(result);
		  $EndJava
		./
	keyDeclCS_1_ ::= keyDeclCS_0_ ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_KEYDECL_ELEMENT);
		  $EndJava
		./	
	keyDeclCS ::= keyDeclCS_1_ '}' ';'
		/.$BeginJava
					KeyDeclCS result = (KeyDeclCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	
--<classId> ::= <PathNameCS>
	classIdCS -> pathNameCS

--<propertyId> ::= <identifier>
	propertyIdCS ::= identifierCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS);
					$setResult(result);
		  $EndJava
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
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(2);
					RelationCS result = QVTrCSTFactory.eINSTANCE.createRelationCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, getIToken($getToken(1)), identifierCS);
					$setResult(result);
		  $EndJava
		./
	relationCS_postName -> relationCS_withName
	relationCS_postName ::= top relationCS_withName
		/.$BeginJava
					RelationCS result = (RelationCS)$getSym(2);
					result.setTop(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndJava
		./
	relationCS_postOverrides -> relationCS_postName
	relationCS_postOverrides ::= relationCS_postName overrides identifierCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					RelationCS result = (RelationCS)$getSym(1);
					result.setOverrides(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndJava
		./
	relationCS_postVariable -> relationCS_postOverrides '{'
	relationCS_postVariable ::= relationCS_postVariable varDeclarationCS
		/.$BeginJava
					VarDeclarationCS varDeclarationCS = (VarDeclarationCS)$getSym(2);
					RelationCS result = (RelationCS)$getSym(1);
					result.getVarDeclaration().add(varDeclarationCS);
					setOffsets(result, result, varDeclarationCS);
					$setResult(result);
		  $EndJava
		./
	relationCS_postDomain ::= relationCS_postVariable domainCS
		/.$NewCase ./
	relationCS_postDomain ::= relationCS_postDomain domainCS
		/.$BeginJava
					AbstractDomainCS domainCS = (AbstractDomainCS)$getSym(2);
					RelationCS result = (RelationCS)$getSym(1);
					result.getDomain().add(domainCS);
					setOffsets(result, result, domainCS);
					$setResult(result);
		  $EndJava
		./
	relationCS_postWhen -> relationCS_postDomain
	relationCS_postWhen ::= relationCS_postDomain whenCS
		/.$BeginJava
					RelationCS result = (RelationCS)$getSym(1);
					WhenCS whenCS = (WhenCS)$getSym(2);
					result.setWhen(whenCS);
					setOffsets(result, result, whenCS);
					$setResult(result);
		  $EndJava
		./
	relationCS_postWhere -> relationCS_postWhen
	relationCS_postWhere ::= relationCS_postWhen whereCS
		/.$BeginJava
					RelationCS result = (RelationCS)$getSym(1);
					WhereCS whereCS = (WhereCS)$getSym(2);
					result.setWhere(whereCS);
					setOffsets(result, result, whereCS);
					$setResult(result);
		  $EndJava
		./
	relationCS ::= relationCS_postWhere '}'
		/.$BeginJava
					RelationCS result = (RelationCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./

	whenCS_0 ::= when '{'
		/.$BeginJava
					WhenCS result = QVTrCSTFactory.eINSTANCE.createWhenCS();
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	whenCS_0 ::= when ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_WHEN);
		  $EndJava
		./	
	whenCS_1 -> whenCS_0
	whenCS_1 ::= whenCS_1 OclExpressionCS ';'
		/.$BeginJava
					WhenCS result = (WhenCS)$getSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(2);
					result.getExpr().add(OclExpressionCS);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	whenCS ::= whenCS_1 '}'
		/.$BeginJava
					WhenCS result = (WhenCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./


	whereCS_0 ::= where '{'
		/.$BeginJava
					WhereCS result = QVTrCSTFactory.eINSTANCE.createWhereCS();
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	whereCS_0 ::= where ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_WHERE);
		  $EndJava
		./	
	whereCS_1 -> whereCS_0
	whereCS_1 ::= whereCS_1 OclExpressionCS ';'
		/.$BeginJava
					WhereCS result = (WhereCS)$getSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(2);
					result.getExpr().add(OclExpressionCS);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	whereCS ::= whereCS_1 '}'
		/.$BeginJava
					WhereCS result = (WhereCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./


--<varDeclaration> ::= <identifier> (, <identifier>)* ':' <TypeCS> ';'
	varDeclarationCS_0 ::= identifierCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					VarDeclarationCS result = QVTrCSTFactory.eINSTANCE.createVarDeclarationCS();
					result.getVarDeclarationId().add(identifierCS);
					setOffsets(result, identifierCS);
					$setResult(result);
		  $EndJava
		./
	varDeclarationCS_0 ::= varDeclarationCS_0 ',' identifierCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					VarDeclarationCS result = (VarDeclarationCS)$getSym(1);
					result.getVarDeclarationId().add(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndJava
		./		
	varDeclarationCS ::= varDeclarationCS_0 ':' typeCS ';'
		/.$BeginJava
					VarDeclarationCS result = (VarDeclarationCS)$getSym(1);
					result.setType((TypeCS)$getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	
--<domain> ::= [<checkEnforceQualifier>] 'domain' <modelId> <template>
--             ['implementedby' <OperationCallExpCS>]
--             ['default_values' '{' (<assignmentExp>)+ '}']
--             ';'
--<checkEnforceQualifier> ::= 'checkonly' | 'enforce'
	domainCS_0_ ::= domain modelIdCS templateCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(2);
					TemplateCS templateCS = (TemplateCS)$getSym(3);
					DomainCS result = QVTrCSTFactory.eINSTANCE.createDomainCS();
					result.setModelId(identifierCS);
					result.setTemplate(templateCS);
					setOffsets(result, getIToken($getToken(1)), templateCS);
					$setResult(result);
		  $EndJava
		./
	domainCS_1_ -> domainCS_0_
	domainCS_1_ ::= checkonly domainCS_0_
		/.$BeginJava
					DomainCS result = (DomainCS)$getSym(2);
					result.setCheckonly(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndJava
		./
	domainCS_1_ ::= enforce domainCS_0_
		/.$BeginJava
					DomainCS result = (DomainCS)$getSym(2);
					result.setEnforce(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndJava
		./
	domainCS_1_ ::= replace domainCS_0_
		/.$BeginJava
					DomainCS result = (DomainCS)$getSym(2);
					result.setReplace(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndJava
		./
	domainCS_postImplementedby -> domainCS_1_
	domainCS_postImplementedby ::= domainCS_1_ implementedby OperationCallExpCS
		/.$BeginJava
					DomainCS result = (DomainCS)$getSym(1);
					OperationCallExpCS operationCallExpCS =(OperationCallExpCS)$getSym(3);
					result.setImplementedBy(operationCallExpCS);
					setOffsets(result, result, operationCallExpCS);
					$setResult(result);
		  $EndJava
		./
	domainCS_preDefaultValue -> domainCS_postImplementedby default_values '{'
	domainCS_preDefaultValue ::= domainCS_preDefaultValue defaultValueCS
		/.$BeginJava
					DomainCS result = (DomainCS)$getSym(1);
					DefaultValueCS defaultValueCS = (DefaultValueCS)$getSym(2);
					result.getDefaultValue().add(defaultValueCS);
					setOffsets(result, result, defaultValueCS);
					$setResult(result);
		  $EndJava
		./
	domainCS_postDefaultValues -> domainCS_postImplementedby
	domainCS_postDefaultValues ::= domainCS_preDefaultValue '}'
		/.$BeginJava
					DomainCS result = (DomainCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	domainCS ::= domainCS_postDefaultValues ';'
		/.$BeginJava
					DomainCS result = (DomainCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
		
--<primitiveTypeDomain> ::= 'primitive' 'domain' <identifier> ':' <TypeCS> ';'
	domainCS ::= primitive domain identifierCS ':' typeCS ';'
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					TypeCS typeCS = (TypeCS)$getSym(5);
					PrimitiveTypeDomainCS result = QVTrCSTFactory.eINSTANCE.createPrimitiveTypeDomainCS();
					result.setIdentifier(identifierCS);
					result.setType(typeCS);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./

--<template> ::= (<objectTemplate> | <collectionTemplate>)
--   ['{' <OclExpressionCS> '}']
	templateCS_0_ -> objectTemplateCS
	templateCS_0_ -> collectionTemplateCS
	templateCS -> templateCS_0_
	templateCS ::= templateCS_0_ '{' OclExpressionCS '}'
		/.$BeginJava
					TemplateCS result = (TemplateCS)$getSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(3);
					result.setGuardExpression(OclExpressionCS);
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	notCollectionTypeCS -> tupleTypeCS
	notCollectionTypeCS -> pathNameCS
	notCollectionTypeCS -> primitiveTypeCS
--	notCollectionTypeCS ::= simpleNameCS				-- covers primitiveTypeCS
--		/.$BeginJava
--					CSTNode result = (CSTNode)$getSym(1);
--					if (!(result instanceof TypeCS)) {
--						PathNameCS pathNameCS = createPathNameCS((SimpleNameCS)result);
--						setOffsets(pathNameCS, result);
--						result = pathNameCS;
--					}
--					$setResult(result);
--		  $EndJava
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
		/.$BeginJava
					IdentifierCS identifierCS = createIdentifierCS($getToken(1));
					TypeCS typeCS = (TypeCS)$getSym(3);
					ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
					result.setType(typeCS);
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./	
	objectTemplateCS_prePropertyTemplates ::= ':' pathNameCS '{' 
		/.$BeginJava
					ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
					result.setIdentifier(createUniqueIdentifierCS($getToken(1)));
					result.setType((TypeCS)$getSym(2));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./	
	objectTemplateCS_prePropertyTemplate -> objectTemplateCS_prePropertyTemplates
	objectTemplateCS_prePropertyTemplate -> objectTemplateCS_postPropertyTemplate ','
	objectTemplateCS_postPropertyTemplate ::= objectTemplateCS_prePropertyTemplate propertyTemplateCS 
		/.$BeginJava
					ObjectTemplateCS result = (ObjectTemplateCS)$getSym(1);
					PropertyTemplateCS propertyTemplateCS = (PropertyTemplateCS)$getSym(2);
					result.getPropertyTemplate().add(propertyTemplateCS);
					setOffsets(result, result, propertyTemplateCS);
					$setResult(result);
		  $EndJava
		./	
	objectTemplateCS ::= objectTemplateCS_prePropertyTemplates '}' 
		/.$NewCase./
	objectTemplateCS ::= objectTemplateCS_postPropertyTemplate '}' 
		/.$BeginJava
					ObjectTemplateCS result = (ObjectTemplateCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./

--<propertyTemplate> ::= <identifier> '=' <OclExpressionCS>
	propertyTemplateCS ::= propertyIdCS '=' OclExpressionCS
		/.$BeginJava
					IdentifiedCS propertyIdCS = (IdentifiedCS)$getSym(1);
					PropertyTemplateCS result = QVTrCSTFactory.eINSTANCE.createPropertyTemplateCS();
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(3);
					result.setPropertyId(propertyIdCS);
					result.setOclExpression(OclExpressionCS);
					setOffsets(result, propertyIdCS, OclExpressionCS);
					$setResult(result);
		  $EndJava
		./
	
--<collectionTemplate> ::= [<identifier>] ':' <CollectionTypeIdentifierCS> '(' <TypeCS> ')'
--                         '{' [<memberSelection>] '}'
--<memberSelection> ::= (<identifier> | <template> | '_')
--			    (‘,’ (<identifier> | <template> | '_'))*
--                      '++'
--                      (<identifier> | '_')
	collectionTemplateCS_1_ ::=  ':' collectionTypeCS
		/.$BeginJava
					CollectionTypeCS collectionTypeCS = (CollectionTypeCS)$getSym(2);
					CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
					result.setType(collectionTypeCS);
					result.setIdentifier(createUniqueIdentifierCS($getToken(1)));
					setOffsets(result, getIToken($getToken(1)), collectionTypeCS);
					$setResult(result);
		  $EndJava
		./	
--	collectionTemplateCS_1_ ::= BooleanLiteralExpCS ':' collectionTypeCS
--		/.$NewCase./
--	collectionTemplateCS_1_ ::= InvalidLiteralExpCS ':' collectionTypeCS
--		/.$NewCase./
--	collectionTemplateCS_1_ ::= NullLiteralExpCS ':' collectionTypeCS
--		/.$NewCase./
	collectionTemplateCS_1_ ::= simpleNameCS ':' collectionTypeCS
		/.$BeginJava
					IdentifierCS identifierCS = createIdentifierCS($getToken(1));
					CollectionTypeCS collectionTypeCS = (CollectionTypeCS)$getSym(3);
					CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
					result.setType(collectionTypeCS);
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS, collectionTypeCS);
					$setResult(result);
		  $EndJava
		./	
	collectionTemplateCS_preMemberSelections -> collectionTemplateCS_1_ '{'
	collectionTemplateCS_preMemberSelection -> collectionTemplateCS_preMemberSelections
	collectionTemplateCS_preMemberSelection -> collectionTemplateCS_postMemberSelection ','
	collectionTemplateCS_postMemberSelection ::= collectionTemplateCS_preMemberSelection memberSelectorCS
		/.$BeginJava
					IdentifiedCS memberSelectorCS = (IdentifiedCS)$getSym(2);
					CollectionTemplateCS result = (CollectionTemplateCS)$getSym(1);
					result.getMemberIdentifier().add(memberSelectorCS);
					setOffsets(result, result, memberSelectorCS);
					$setResult(result);
		  $EndJava
		./	
	collectionTemplateCS ::= collectionTemplateCS_postMemberSelection PLUS_PLUS identifierCS '}'
		/.$BeginJava
					IdentifierCS restIdentifier = (IdentifierCS)$getSym(3);
					CollectionTemplateCS result = (CollectionTemplateCS)$getSym(1);
					result.setRestIdentifier(restIdentifier);
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	collectionTemplateCS ::= collectionTemplateCS_postMemberSelection ERROR_TOKEN '}'
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_REST);
					IdentifierCS restIdentifier = createUniqueIdentifierCS($getToken(2));
					CollectionTemplateCS result = (CollectionTemplateCS)$getSym(1);
					result.setRestIdentifier(restIdentifier);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	collectionTemplateCS ::= collectionTemplateCS_preMemberSelections '}'
		/.$BeginJava
					CollectionTemplateCS result = (CollectionTemplateCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
		
--<memberSelector> ::= (<identifier> | <template> | '_')
	memberSelectorCS ::= identifierCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS);
					$setResult(result);
		  $EndJava
		./	
	memberSelectorCS -> templateCS
	
--<assignmentExp> ::= <identifier> '=' <OclExpressionCS> ';'
	defaultValueCS ::= identifierCS '=' OclExpressionCS ';'
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(3);
					DefaultValueCS result = QVTrCSTFactory.eINSTANCE.createDefaultValueCS();
					result.setIdentifier(identifierCS);
					result.setInitialiser(OclExpressionCS);
					setOffsets(result, identifierCS, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./	
		
--<query> ::= 'query' <PathNameCS> 
--            '(' [<paramDeclaration> (',' <paramDeclaration>)*] ')'
--      	  ':' <TypeCS>
--            (';' | '{' <OclExpressionCS> '}')
	queryCS_preParamDeclaration ::= query pathNameCS '('
		/.$BeginJava
					QueryCS result = QVTrCSTFactory.eINSTANCE.createQueryCS();
					result.setPathName((PathNameCS)$getSym(2));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	queryCS_preParamDeclaration -> queryCS_postParamDeclaration ','
	queryCS_postParamDeclaration ::= queryCS_preParamDeclaration paramDeclarationCS
		/.$BeginJava
					ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)$getSym(2);
					QueryCS result = (QueryCS)$getSym(1);
					result.getInputParamDeclaration().add(paramDeclarationCS);
					setOffsets(result, result, paramDeclarationCS);
					$setResult(result);
		  $EndJava
		./
	queryCS_postType ::= queryCS_postParamDeclaration ')' ':' typeCS
		/.$BeginJava
					TypeCS typeCS = (TypeCS)$getSym(4);
					QueryCS result = (QueryCS)$getSym(1);
					result.setType(typeCS);
					setOffsets(result, result, typeCS);
					$setResult(result);
		  $EndJava
		./
	queryCS ::= queryCS_postType ';'
		/.$BeginJava
					QueryCS result = (QueryCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	queryCS ::= queryCS_postType '{' OclExpressionCS '}'
		/.$BeginJava
					QueryCS result = (QueryCS)$getSym(1);
					result.setOclExpression((OCLExpressionCS)$getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	
--<paramDeclaration> ::= <identifier> ':' <TypeCS>	
	paramDeclarationCS ::= identifierCS ':' typeCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					TypeCS typeCS = (TypeCS)$getSym(3);
					ParamDeclarationCS result = QVTrCSTFactory.eINSTANCE.createParamDeclarationCS();
					result.setIdentifier(identifierCS);
					result.setType(typeCS);
					setOffsets(result, identifierCS, typeCS);
					$setResult(result);
		  $EndJava
		./
	paramDeclarationCS ::= identifierCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_PARAM_DECLARATION);
		  $EndJava
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
		/.$BeginJava
					IdentifierCS result = createIdentifierCS($getToken(1));
					$setResult(result);
		  $EndJava
		./
$End
	