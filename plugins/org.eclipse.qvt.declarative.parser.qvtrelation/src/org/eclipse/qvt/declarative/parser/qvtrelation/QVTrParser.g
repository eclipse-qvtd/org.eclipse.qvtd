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
%options import_terminals=QVTrLexer.gi
%options ast_type=CSTNode
%options programming_language=java
%options action=("*.java", "/.", "./")
%options ParseTable=lpg.runtime.ParseTable
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
import org.eclipse.ocl.parser.$prs_stream_class;
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
	$prs_parser_class /.BacktrackingParser./
	$prs_parser_exception /.NotBacktrackParseTableException./
	$prs_parser_throw /.throw new RuntimeException("****Error: Regenerate $prs_type.java with -BACKTRACK option")./
	$prs_parse_args /.error_repair_count./
    $environment_class /.ICSTFileEnvironment./
	$lex_stream_class /.QVTrLexer./
    $LPGParsersym_class /.QVTrParserSymbols./
	$copyright_contributions /.*   E.D.Willink - Extended API and implementation for QVTr
*./
%End

%Headers
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
%End

%Rules
--<topLevel> ::= ('import' <unit> ';' )* <transformation>*
	topLevelCS_0_ ::= $empty
		/.$BeginCode
					TopLevelCS result = QVTrCSTFactory.eINSTANCE.createTopLevelCS();
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	topLevelCS_0_ ::= topLevelCS_0_ import unitCS ';'
		/.$BeginCode
					TopLevelCS result = (TopLevelCS)$getSym(1);
					result.getImportClause().add((UnitCS)$getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./
	topLevelCS_0_ ::= topLevelCS_0_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_TOPLEVEL);
		  $EndCode
		./	
	topLevelCS_1_ ::= topLevelCS transformationCS
		/.$BeginCode
					TransformationCS transformationCS = (TransformationCS)$getSym(2);
					TopLevelCS result = (TopLevelCS)$getSym(1);
					result.getTransformation().add(transformationCS);
					setOffsets(result, result, transformationCS);
					$setResult(result);
		  $EndCode
		./
	topLevelCS_1_ ::= topLevelCS_1_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION);
		  $EndCode
		./	
	topLevelCS -> topLevelCS_0_
	topLevelCS -> topLevelCS_1_
		
--<unit> ::= <identifier> ('.' <identifier>)*
	unitCS ::= identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					UnitCS result = QVTrCSTFactory.eINSTANCE.createUnitCS();
					result.getIdentifier().add(identifierCS);
					setOffsets(result, identifierCS);
					$setResult(result);
		  $EndCode
		./
	unitCS ::= unitCS '.' identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					UnitCS result = (UnitCS)$getSym(1);
					result.getIdentifier().add(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndCode
		./
	
--<transformation> ::= 'transformation' <identifier> 
--                     '(' <modelDecl> (',' <modelDecl>)* ')' 
--                     ['extends' <identifier> (',' <identifier>)* ]
--                     '{' <keyDecl>* ( <relation> | <query> )* '}'
	transformationCS_0_ ::= transformation identifierCS '(' modelDeclCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(2);
					ModelDeclCS modelDeclCS = (ModelDeclCS)$getSym(4);
					TransformationCS result = QVTrCSTFactory.eINSTANCE.createTransformationCS();
					result.setIdentifier(identifierCS);
					result.getModelDecl().add(modelDeclCS);
					setOffsets(result, getIToken($getToken(1)), modelDeclCS);
					$setResult(result);
		  $EndCode
		./
	transformationCS_0_ ::= transformationCS_0_ ',' modelDeclCS
		/.$BeginCode
					ModelDeclCS modelDeclCS = (ModelDeclCS)$getSym(3);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.getModelDecl().add(modelDeclCS);
					setOffsets(result, result, modelDeclCS);
					$setResult(result);
		  $EndCode
		./
	transformationCS_0_ ::= transformationCS_0_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL);
		  $EndCode
		./	
	transformationCS_1_ ::= transformationCS_0_ ')'
		/.$BeginCode
					TransformationCS result = (TransformationCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	transformationCS_2_ -> transformationCS_1_
	transformationCS_2_ ::= transformationCS_1_ extends identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.setExtends(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndCode
		./
	transformationCS_3_ -> transformationCS_2_ '{'
	transformationCS_3_ ::= transformationCS_3_ keyDeclCS
		/.$BeginCode
					KeyDeclCS keyDeclCS = (KeyDeclCS)$getSym(2);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.getKeyDecl().add(keyDeclCS);
					setOffsets(result, result, keyDeclCS);
					$setResult(result);
		  $EndCode
		./
	transformationCS_4_ -> transformationCS_3_
	transformationCS_4_ ::= transformationCS_4_ queryCS
		/.$BeginCode
					QueryCS queryCS =(QueryCS)$getSym(2);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.getQuery().add(queryCS);
					setOffsets(result, result, queryCS);
					$setResult(result);
		  $EndCode
		./
	transformationCS_4_ ::= transformationCS_4_ relationCS
		/.$BeginCode
					RelationCS relationCS = (RelationCS)$getSym(2);
					TransformationCS result = (TransformationCS)$getSym(1);
					result.getRelation().add(relationCS);
					setOffsets(result, result, relationCS);
					$setResult(result);
		  $EndCode
		./
	transformationCS_4_ ::= transformationCS_4_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION_ELEMENT);
		  $EndCode
		./	
	transformationCS ::= transformationCS_4_ '}'
		/.$BeginCode
					TransformationCS result = (TransformationCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	
--<modelDecl> ::= <modelId> ':' <metaModelId>
--**<modelDecl> ::= <modelId> ':' '{' <metaModelId> (',' <metaModelId>)* '}'
	modelDeclCS_0_ ::= modelIdCS ':'
		/.$BeginCode
					IdentifierCS modelIdCS = (IdentifierCS)$getSym(1);
					ModelDeclCS result = QVTrCSTFactory.eINSTANCE.createModelDeclCS();
					result.setModelId(modelIdCS);
					setOffsets(result, modelIdCS, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	modelDeclCS_1_ -> modelDeclCS_0_ '{'
	modelDeclCS_1_ -> modelDeclCS_2_ ','
	modelDeclCS_2_ ::= modelDeclCS_1_ metaModelIdCS
		/.$NewCase ./
	modelDeclCS ::= modelDeclCS_0_ metaModelIdCS
		/.$BeginCode
					IdentifierCS metaModelIdCS = (IdentifierCS)$getSym(2);
					ModelDeclCS result = (ModelDeclCS)$getSym(1);
					result.getMetaModelId().add(metaModelIdCS);
					setOffsets(result, result, metaModelIdCS);
					$setResult(result);
		  $EndCode
		./
	modelDeclCS_2_ ::= modelDeclCS_1_ ERROR_TOKEN
		/.$NewCase ./
	modelDeclCS ::= modelDeclCS_0_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL_ELEMENT);
		  $EndCode
		./	
	modelDeclCS ::= modelDeclCS_2_ '}'
		/.$BeginCode
					ModelDeclCS result = (ModelDeclCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	
--<modelId> ::= <identifier>
	modelIdCS -> identifierCS
	
--<metaModelId> ::= <identifier>
	metaModelIdCS -> identifierCS

--<keyDecl> ::= 'key' <classId> '{' <propertyId> (, <propertyId>)* '}' ';'
	keyDeclCS_0_ ::= key classIdCS '{'
		/.$BeginCode
					PathNameCS classIdCS = (PathNameCS)$getSym(2);
					KeyDeclCS result = QVTrCSTFactory.eINSTANCE.createKeyDeclCS();
					result.setClassId(classIdCS);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	keyDeclCS_0_ -> keyDeclCS_1_ ','
	keyDeclCS_1_ ::= keyDeclCS_0_ propertyIdCS
		/.$BeginCode
					IdentifiedCS propertyIdCS = (IdentifiedCS)$getSym(2);
					KeyDeclCS result = (KeyDeclCS)$getSym(1);
					result.getPropertyId().add(propertyIdCS);
					setOffsets(result, result, propertyIdCS);
					$setResult(result);
		  $EndCode
		./
	keyDeclCS_1_ ::= keyDeclCS_0_ ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_KEYDECL_ELEMENT);
		  $EndCode
		./	
	keyDeclCS ::= keyDeclCS_1_ '}' ';'
		/.$BeginCode
					KeyDeclCS result = (KeyDeclCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	
--<classId> ::= <PathNameCS>
	classIdCS -> pathNameCS

--<propertyId> ::= <identifier>
	propertyIdCS ::= identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS);
					$setResult(result);
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
					IdentifierCS identifierCS = (IdentifierCS)$getSym(2);
					RelationCS result = QVTrCSTFactory.eINSTANCE.createRelationCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, getIToken($getToken(1)), identifierCS);
					$setResult(result);
		  $EndCode
		./
	relationCS_postName -> relationCS_withName
	relationCS_postName ::= top relationCS_withName
		/.$BeginCode
					RelationCS result = (RelationCS)$getSym(2);
					result.setTop(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndCode
		./
	relationCS_postOverrides -> relationCS_postName
	relationCS_postOverrides ::= relationCS_postName overrides identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					RelationCS result = (RelationCS)$getSym(1);
					result.setOverrides(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndCode
		./
	relationCS_postVariable -> relationCS_postOverrides '{'
	relationCS_postVariable ::= relationCS_postVariable varDeclarationCS
		/.$BeginCode
					VarDeclarationCS varDeclarationCS = (VarDeclarationCS)$getSym(2);
					RelationCS result = (RelationCS)$getSym(1);
					result.getVarDeclaration().add(varDeclarationCS);
					setOffsets(result, result, varDeclarationCS);
					$setResult(result);
		  $EndCode
		./
	relationCS_postDomain ::= relationCS_postVariable domainCS
		/.$NewCase ./
	relationCS_postDomain ::= relationCS_postDomain domainCS
		/.$BeginCode
					AbstractDomainCS domainCS = (AbstractDomainCS)$getSym(2);
					RelationCS result = (RelationCS)$getSym(1);
					result.getDomain().add(domainCS);
					setOffsets(result, result, domainCS);
					$setResult(result);
		  $EndCode
		./
	relationCS_postWhen -> relationCS_postDomain
	relationCS_postWhen ::= relationCS_postDomain whenCS
		/.$BeginCode
					RelationCS result = (RelationCS)$getSym(1);
					WhenCS whenCS = (WhenCS)$getSym(2);
					result.setWhen(whenCS);
					setOffsets(result, result, whenCS);
					$setResult(result);
		  $EndCode
		./
	relationCS_postWhere -> relationCS_postWhen
	relationCS_postWhere ::= relationCS_postWhen whereCS
		/.$BeginCode
					RelationCS result = (RelationCS)$getSym(1);
					WhereCS whereCS = (WhereCS)$getSym(2);
					result.setWhere(whereCS);
					setOffsets(result, result, whereCS);
					$setResult(result);
		  $EndCode
		./
	relationCS ::= relationCS_postWhere '}'
		/.$BeginCode
					RelationCS result = (RelationCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./

	whenCS_0 ::= when '{'
		/.$BeginCode
					WhenCS result = QVTrCSTFactory.eINSTANCE.createWhenCS();
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	whenCS_0 ::= when ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_WHEN);
		  $EndCode
		./	
	whenCS_1 -> whenCS_0
	whenCS_1 ::= whenCS_1 OclExpressionCS ';'
		/.$BeginCode
					WhenCS result = (WhenCS)$getSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(2);
					result.getExpr().add(OclExpressionCS);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	whenCS ::= whenCS_1 '}'
		/.$BeginCode
					WhenCS result = (WhenCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./


	whereCS_0 ::= where '{'
		/.$BeginCode
					WhereCS result = QVTrCSTFactory.eINSTANCE.createWhereCS();
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	whereCS_0 ::= where ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_WHERE);
		  $EndCode
		./	
	whereCS_1 -> whereCS_0
	whereCS_1 ::= whereCS_1 OclExpressionCS ';'
		/.$BeginCode
					WhereCS result = (WhereCS)$getSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(2);
					result.getExpr().add(OclExpressionCS);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	whereCS ::= whereCS_1 '}'
		/.$BeginCode
					WhereCS result = (WhereCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./


--<varDeclaration> ::= <identifier> (, <identifier>)* ':' <TypeCS> ';'
	varDeclarationCS_0 ::= identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					VarDeclarationCS result = QVTrCSTFactory.eINSTANCE.createVarDeclarationCS();
					result.getVarDeclarationId().add(identifierCS);
					setOffsets(result, identifierCS);
					$setResult(result);
		  $EndCode
		./
	varDeclarationCS_0 ::= varDeclarationCS_0 ',' identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					VarDeclarationCS result = (VarDeclarationCS)$getSym(1);
					result.getVarDeclarationId().add(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndCode
		./		
	varDeclarationCS ::= varDeclarationCS_0 ':' typeCS ';'
		/.$BeginCode
					VarDeclarationCS result = (VarDeclarationCS)$getSym(1);
					result.setType((TypeCS)$getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./
	
--<domain> ::= [<checkEnforceQualifier>] 'domain' <modelId> <template>
--             ['implementedby' <OperationCallExpCS>]
--             ['default_values' '{' (<assignmentExp>)+ '}']
--             ';'
--<checkEnforceQualifier> ::= 'checkonly' | 'enforce'
	domainCS_0_ ::= domain modelIdCS templateCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(2);
					TemplateCS templateCS = (TemplateCS)$getSym(3);
					DomainCS result = QVTrCSTFactory.eINSTANCE.createDomainCS();
					result.setModelId(identifierCS);
					result.setTemplate(templateCS);
					setOffsets(result, getIToken($getToken(1)), templateCS);
					$setResult(result);
		  $EndCode
		./
	domainCS_1_ -> domainCS_0_
	domainCS_1_ ::= checkonly domainCS_0_
		/.$BeginCode
					DomainCS result = (DomainCS)$getSym(2);
					result.setCheckonly(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndCode
		./
	domainCS_1_ ::= enforce domainCS_0_
		/.$BeginCode
					DomainCS result = (DomainCS)$getSym(2);
					result.setEnforce(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndCode
		./
	domainCS_1_ ::= replace domainCS_0_
		/.$BeginCode
					DomainCS result = (DomainCS)$getSym(2);
					result.setReplace(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndCode
		./
	domainCS_postImplementedby -> domainCS_1_
	domainCS_postImplementedby ::= domainCS_1_ implementedby OperationCallExpCS
		/.$BeginCode
					DomainCS result = (DomainCS)$getSym(1);
					OperationCallExpCS operationCallExpCS =(OperationCallExpCS)$getSym(3);
					result.setImplementedBy(operationCallExpCS);
					setOffsets(result, result, operationCallExpCS);
					$setResult(result);
		  $EndCode
		./
	domainCS_preDefaultValue -> domainCS_postImplementedby default_values '{'
	domainCS_preDefaultValue ::= domainCS_preDefaultValue defaultValueCS
		/.$BeginCode
					DomainCS result = (DomainCS)$getSym(1);
					DefaultValueCS defaultValueCS = (DefaultValueCS)$getSym(2);
					result.getDefaultValue().add(defaultValueCS);
					setOffsets(result, result, defaultValueCS);
					$setResult(result);
		  $EndCode
		./
	domainCS_postDefaultValues -> domainCS_postImplementedby
	domainCS_postDefaultValues ::= domainCS_preDefaultValue '}'
		/.$BeginCode
					DomainCS result = (DomainCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	domainCS ::= domainCS_postDefaultValues ';'
		/.$BeginCode
					DomainCS result = (DomainCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
		
--<primitiveTypeDomain> ::= 'primitive' 'domain' <identifier> ':' <TypeCS> ';'
	domainCS ::= primitive domain identifierCS ':' typeCS ';'
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					TypeCS typeCS = (TypeCS)$getSym(5);
					PrimitiveTypeDomainCS result = QVTrCSTFactory.eINSTANCE.createPrimitiveTypeDomainCS();
					result.setIdentifier(identifierCS);
					result.setType(typeCS);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndCode
		./

--<template> ::= (<objectTemplate> | <collectionTemplate>)
--   ['{' <OclExpressionCS> '}']
	templateCS_0_ -> objectTemplateCS
	templateCS_0_ -> collectionTemplateCS
	templateCS -> templateCS_0_
	templateCS ::= templateCS_0_ '{' OclExpressionCS '}'
		/.$BeginCode
					TemplateCS result = (TemplateCS)$getSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(3);
					result.setGuardExpression(OclExpressionCS);
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./

	notCollectionTypeCS -> tupleTypeCS
	notCollectionTypeCS -> pathNameCS
	notCollectionTypeCS -> primitiveTypeCS
--	notCollectionTypeCS ::= simpleNameCS				-- covers primitiveTypeCS
--		/.$BeginCode
--					CSTNode result = (CSTNode)$getSym(1);
--					if (!(result instanceof TypeCS)) {
--						PathNameCS pathNameCS = createPathNameCS((SimpleNameCS)result);
--						setOffsets(pathNameCS, result);
--						result = pathNameCS;
--					}
--					$setResult(result);
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
					IdentifierCS identifierCS = createIdentifierCS($getToken(1));
					TypeCS typeCS = (TypeCS)$getSym(3);
					ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
					result.setType(typeCS);
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS, getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./	
	objectTemplateCS_prePropertyTemplates ::= ':' pathNameCS '{' 
		/.$BeginCode
					ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
					result.setIdentifier(createUniqueIdentifierCS($getToken(1)));
					result.setType((TypeCS)$getSym(2));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./	
	objectTemplateCS_prePropertyTemplate -> objectTemplateCS_prePropertyTemplates
	objectTemplateCS_prePropertyTemplate -> objectTemplateCS_postPropertyTemplate ','
	objectTemplateCS_postPropertyTemplate ::= objectTemplateCS_prePropertyTemplate propertyTemplateCS 
		/.$BeginCode
					ObjectTemplateCS result = (ObjectTemplateCS)$getSym(1);
					PropertyTemplateCS propertyTemplateCS = (PropertyTemplateCS)$getSym(2);
					result.getPropertyTemplate().add(propertyTemplateCS);
					setOffsets(result, result, propertyTemplateCS);
					$setResult(result);
		  $EndCode
		./	
	objectTemplateCS ::= objectTemplateCS_prePropertyTemplates '}' 
		/.$NewCase./
	objectTemplateCS ::= objectTemplateCS_postPropertyTemplate '}' 
		/.$BeginCode
					ObjectTemplateCS result = (ObjectTemplateCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./

--<propertyTemplate> ::= <identifier> '=' <OclExpressionCS>
	propertyTemplateCS ::= propertyIdCS '=' OclExpressionCS
		/.$BeginCode
					IdentifiedCS propertyIdCS = (IdentifiedCS)$getSym(1);
					PropertyTemplateCS result = QVTrCSTFactory.eINSTANCE.createPropertyTemplateCS();
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(3);
					result.setPropertyId(propertyIdCS);
					result.setOclExpression(OclExpressionCS);
					setOffsets(result, propertyIdCS, OclExpressionCS);
					$setResult(result);
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
					CollectionTypeCS collectionTypeCS = (CollectionTypeCS)$getSym(2);
					CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
					result.setType(collectionTypeCS);
					result.setIdentifier(createUniqueIdentifierCS($getToken(1)));
					setOffsets(result, getIToken($getToken(1)), collectionTypeCS);
					$setResult(result);
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
					IdentifierCS identifierCS = createIdentifierCS($getToken(1));
					CollectionTypeCS collectionTypeCS = (CollectionTypeCS)$getSym(3);
					CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
					result.setType(collectionTypeCS);
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS, collectionTypeCS);
					$setResult(result);
		  $EndCode
		./	
	collectionTemplateCS_preMemberSelections -> collectionTemplateCS_1_ '{'
	collectionTemplateCS_preMemberSelection -> collectionTemplateCS_preMemberSelections
	collectionTemplateCS_preMemberSelection -> collectionTemplateCS_postMemberSelection ','
	collectionTemplateCS_postMemberSelection ::= collectionTemplateCS_preMemberSelection memberSelectorCS
		/.$BeginCode
					IdentifiedCS memberSelectorCS = (IdentifiedCS)$getSym(2);
					CollectionTemplateCS result = (CollectionTemplateCS)$getSym(1);
					result.getMemberIdentifier().add(memberSelectorCS);
					setOffsets(result, result, memberSelectorCS);
					$setResult(result);
		  $EndCode
		./	
	collectionTemplateCS ::= collectionTemplateCS_postMemberSelection PLUS_PLUS identifierCS '}'
		/.$BeginCode
					IdentifierCS restIdentifier = (IdentifierCS)$getSym(3);
					CollectionTemplateCS result = (CollectionTemplateCS)$getSym(1);
					result.setRestIdentifier(restIdentifier);
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./
	collectionTemplateCS ::= collectionTemplateCS_postMemberSelection ERROR_TOKEN '}'
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_REST);
					IdentifierCS restIdentifier = createUniqueIdentifierCS($getToken(2));
					CollectionTemplateCS result = (CollectionTemplateCS)$getSym(1);
					result.setRestIdentifier(restIdentifier);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	collectionTemplateCS ::= collectionTemplateCS_preMemberSelections '}'
		/.$BeginCode
					CollectionTemplateCS result = (CollectionTemplateCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
		
--<memberSelector> ::= (<identifier> | <template> | '_')
	memberSelectorCS ::= identifierCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS);
					$setResult(result);
		  $EndCode
		./	
	memberSelectorCS -> templateCS
	
--<assignmentExp> ::= <identifier> '=' <OclExpressionCS> ';'
	defaultValueCS ::= identifierCS '=' OclExpressionCS ';'
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					OCLExpressionCS OclExpressionCS = (OCLExpressionCS)$getSym(3);
					DefaultValueCS result = QVTrCSTFactory.eINSTANCE.createDefaultValueCS();
					result.setIdentifier(identifierCS);
					result.setInitialiser(OclExpressionCS);
					setOffsets(result, identifierCS, getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./	
		
--<query> ::= 'query' <PathNameCS> 
--            '(' [<paramDeclaration> (',' <paramDeclaration>)*] ')'
--      	  ':' <TypeCS>
--            (';' | '{' <OclExpressionCS> '}')
	queryCS_preParamDeclaration ::= query pathNameCS '('
		/.$BeginCode
					QueryCS result = QVTrCSTFactory.eINSTANCE.createQueryCS();
					result.setPathName((PathNameCS)$getSym(2));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	queryCS_preParamDeclaration -> queryCS_postParamDeclaration ','
	queryCS_postParamDeclaration ::= queryCS_preParamDeclaration paramDeclarationCS
		/.$BeginCode
					ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)$getSym(2);
					QueryCS result = (QueryCS)$getSym(1);
					result.getInputParamDeclaration().add(paramDeclarationCS);
					setOffsets(result, result, paramDeclarationCS);
					$setResult(result);
		  $EndCode
		./
	queryCS_postType ::= queryCS_postParamDeclaration ')' ':' typeCS
		/.$BeginCode
					TypeCS typeCS = (TypeCS)$getSym(4);
					QueryCS result = (QueryCS)$getSym(1);
					result.setType(typeCS);
					setOffsets(result, result, typeCS);
					$setResult(result);
		  $EndCode
		./
	queryCS ::= queryCS_postType ';'
		/.$BeginCode
					QueryCS result = (QueryCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	queryCS ::= queryCS_postType '{' OclExpressionCS '}'
		/.$BeginCode
					QueryCS result = (QueryCS)$getSym(1);
					result.setOclExpression((OCLExpressionCS)$getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./
	
--<paramDeclaration> ::= <identifier> ':' <TypeCS>	
	paramDeclarationCS ::= identifierCS ':' typeCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					TypeCS typeCS = (TypeCS)$getSym(3);
					ParamDeclarationCS result = QVTrCSTFactory.eINSTANCE.createParamDeclarationCS();
					result.setIdentifier(identifierCS);
					result.setType(typeCS);
					setOffsets(result, identifierCS, typeCS);
					$setResult(result);
		  $EndCode
		./
	paramDeclarationCS ::= identifierCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), QVTrParserErrors.INCOMPLETE_PARAM_DECLARATION);
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
					IdentifierCS result = createIdentifierCS($getToken(1));
					$setResult(result);
		  $EndCode
		./
%End
	