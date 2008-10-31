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
-- The QVTc Parser
--

%options escape=$
%options la=2
%options table=java
%options fp=QVTcParser,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
%options package=org.eclipse.qvt.declarative.parser.qvtcore
--%options template=dtParserTemplateD.g
%options import_terminals=QVTcLexer.g
%options ast_type=CSTNode
%options programming_language=java
%options action=("*.java", "/.", "./")
%options ParseTable=lpg.lpgjavaruntime.ParseTable
%options include_directory=".;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser"

$KeyWords
	check
	creation
	default
	deletion
	enforce
	imports
	map
	query
	realize
	refines
	transformation
	uses
	where
	
	def
	endpackage
	inv
	post
	pre
$End

$Terminals
	COLON_EQUALS     ::= ':='
$End

$Globals
/.
import org.eclipse.qvt.declarative.parser.qvt.cst.*;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.*;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.parser.$prs_stream_class;

./
$End

$Start
	TopLevelCS
$End

$Include
	EssentialOCL.g
$End

$Define
    $environment_class /.ICSTFileEnvironment./
	$lex_stream_class /.QVTcLexer./
    $LPGParsersym_class /.QVTcParserSymbols./
	$copyright_contributions /.*   E.D.Willink - Extended API and implementation for QVTc
*./
$End

$Headers
	/.			
		private int _uniqueNameCount = 0;

		protected String createUniqueIdentifier() {
			return "_unique" + _uniqueNameCount++;
		}

		protected IdentifierCS createUniqueIdentifierCS(int token) {
			IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
			result.setValue(createUniqueIdentifier());
			setOffsets(result, getIToken(token));
			return result;
		}
	./
$End

$Rules
	TopLevelCS ::= $empty
		/.$BeginJava
					TopLevelCS result = QVTcCSTFactory.eINSTANCE.createTopLevelCS();
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	TopLevelCS ::= TopLevelCS MappingCS
		/.$BeginJava
					TopLevelCS result = (TopLevelCS)$getSym(1);
					MappingCS mappingCS = (MappingCS)$getSym(2);
					result.getMappings().add(mappingCS);
					setOffsets(result, result, mappingCS);
					$setResult(result);
		  $EndJava
		./
	TopLevelCS ::= TopLevelCS TransformationCS
		/.$BeginJava
					TopLevelCS result = (TopLevelCS)$getSym(1);
					TransformationCS transformationCS = (TransformationCS)$getSym(2);
					result.getTransformations().add(transformationCS);
					setOffsets(result, result, transformationCS);
					$setResult(result);
		  $EndJava
		./
	TopLevelCS ::= TopLevelCS QueryCS
		/.$BeginJava
					TopLevelCS result = (TopLevelCS)$getSym(1);
					QueryCS queryCS = (QueryCS)$getSym(2);
					result.getQueries().add(queryCS);
					setOffsets(result, result, queryCS);
					$setResult(result);
		  $EndJava
		./
	
--Transformation ::=
--“transformation” TransformationName “{”
--( Direction“;” )*
--“}”
	TransformationCS_0_ ::= transformation TransformationNameCS '{'
		/.$BeginJava
					TransformationCS result = QVTcCSTFactory.eINSTANCE.createTransformationCS();
					result.setPathName((PathNameCS)$getSym(2));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	TransformationCS_0_ ::= TransformationCS_0_ DirectionCS ';'
		/.$BeginJava
					TransformationCS result = (TransformationCS)$getSym(1);
					DirectionCS directionCS = (DirectionCS)$getSym(2);
					result.getDirections().add(directionCS);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./	
	TransformationCS ::= TransformationCS_0_ '}'
		/.$BeginJava
					TransformationCS result = (TransformationCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./	
	
--Direction ::= DirectionName [“imports” PackageName(“,” PackageName)*]
--					[“uses” DirectionName(“,” DirectionName)*]
	DirectionCS_0_ ::= DirectionNameCS
		/.$BeginJava
					IdentifierCS directionNameCS = (IdentifierCS)$getSym(1);
					DirectionCS result = QVTcCSTFactory.eINSTANCE.createDirectionCS();
					result.setIdentifier(directionNameCS);
					setOffsets(result, directionNameCS);
					$setResult(result);
		  $EndJava
		./
	DirectionCS_1_ -> DirectionCS_0_ imports
	DirectionCS_1_ -> DirectionCS_2_ ',' 
	DirectionCS_2_ ::= DirectionCS_1_ PackageNameCS
		/.$BeginJava
					DirectionCS result = (DirectionCS)$getSym(1);
					PathNameCS pathNameCS = (PathNameCS)$getSym(2);
					result.getImports().add(pathNameCS);
					setOffsets(result, result, pathNameCS);
					$setResult(result);
		  $EndJava
		./	
	DirectionCS_3_ -> DirectionCS_0_ 
	DirectionCS_3_ -> DirectionCS_2_ 
	DirectionCS_4_ -> DirectionCS_3_ uses 
	DirectionCS_4_ -> DirectionCS_5_ ',' 
	DirectionCS_5_ ::= DirectionCS_4_ DirectionNameCS
		/.$BeginJava
					DirectionCS result = (DirectionCS)$getSym(1);
					IdentifierCS directionNameCS = (IdentifierCS)$getSym(2);
					result.getUses().add(directionNameCS);
					setOffsets(result, result, directionNameCS);
					$setResult(result);
		  $EndJava
		./	
	DirectionCS -> DirectionCS_3_ 
	DirectionCS -> DirectionCS_5_ 
	
--Mapping ::= “map” MappingName [“in” TransformationName] [“refines” MappingName] “{”
--				( [“check”] [“enforce”] DirectionName “(”DomainGuardPattern“)” “{” DomainBottomPattern “}” )*
--				“where” “(” MiddleGuardPattern “)” “{” MiddleBottomPattern “}”
--					( ComposedMapping )* “}”
	MappingCS_1_ ::= map
		/.$BeginJava
					MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
//					IdentifierCS identifierCS = createUniqueIdentifierCS($getToken(1));
//					result.setIdentifier(identifierCS);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	MappingCS_1_ ::= map MappingNameCS
		/.$BeginJava
					MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
					IdentifierCS identifierCS = (IdentifierCS)$getSym(2);
					result.setIdentifier(identifierCS);
					setOffsets(result, getIToken($getToken(1)), identifierCS);
					$setResult(result);
		  $EndJava
		./	
	MappingCS_2_ -> MappingCS_1_
	MappingCS_2_ ::= MappingCS_1_ in TransformationNameCS
		/.$BeginJava
					MappingCS result = (MappingCS)$getSym(1);
					PathNameCS identifierCS = (PathNameCS)$getSym(3);
					result.setIn(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndJava
		./	
	MappingCS_3_ -> MappingCS_2_
	MappingCS_3_ ::= MappingCS_2_ refines MappingNameCS
		/.$BeginJava
					MappingCS result = (MappingCS)$getSym(1);
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					result.getRefines().add(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndJava
		./	
	MappingCS_3_ ::= MappingCS_3_ ',' MappingNameCS
		/.$BeginJava
					MappingCS result = (MappingCS)$getSym(1);
					IdentifierCS identifierCS = (IdentifierCS)$getSym(3);
					result.getRefines().add(identifierCS);
					setOffsets(result, result, identifierCS);
					$setResult(result);
		  $EndJava
		./	
	MappingCS_4_ -> MappingCS_3_ '{'
	MappingCS_4_ ::= MappingCS_4_ DomainCS	
		/.$BeginJava
					MappingCS result = (MappingCS)$getSym(1);
					DomainCS domainCS = (DomainCS)$getSym(2);
					result.getDomains().add(domainCS);
					setOffsets(result, result, domainCS);
					$setResult(result);
		  $EndJava
		./	
	MappingCS_8 ::= MappingCS_4_ where DomainCS_0_
		/.$BeginJava
					MappingCS result = (MappingCS)$getSym(1);
					IdentifierCS directionNameCS = QVTCSTFactory.eINSTANCE.createIdentifierCS();
					directionNameCS.setValue("");
					setOffsets(directionNameCS, getIToken($getToken(2)));
					DomainCS domainCS = (DomainCS)$getSym(3);
					domainCS.setIdentifier(directionNameCS);
					setOffsets(domainCS, directionNameCS, domainCS);
					result.setMiddle(domainCS);
					setOffsets(result, result, domainCS);
					$setResult(result);
		  $EndJava
		./
	MappingCS_8 ::= MappingCS_4_ where DirectionNameCS DomainCS_0_
		/.$BeginJava
					MappingCS result = (MappingCS)$getSym(1);
					IdentifierCS directionNameCS = (IdentifierCS)$getSym(3);
					setOffsets(directionNameCS, getIToken($getToken(2)), directionNameCS);
					DomainCS domainCS = (DomainCS)$getSym(4);
					domainCS.setIdentifier(directionNameCS);
					setOffsets(domainCS, directionNameCS, domainCS);
					result.setMiddle(domainCS);
					setOffsets(result, result, domainCS);
					$setResult(result);
		  $EndJava
		./
	MappingCS_8 ::= MappingCS_8 ComposedMappingCS
		/.$BeginJava
					MappingCS result = (MappingCS)$getSym(1);
					MappingCS composedMappingCS = (MappingCS)$getSym(2);
					result.getComposedMappings().add(composedMappingCS);
					setOffsets(result, result, composedMappingCS);
					$setResult(result);
		  $EndJava
		./	
	MappingCS ::= MappingCS_8 '}'
		/.$BeginJava
					MappingCS result = (MappingCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./	
	
	DomainCS_0_ ::= '(' DomainGuardPatternCS ')' '{' DomainBottomPatternCS  '}'
		/.$BeginJava
					GuardPatternCS guardPatternCS = (GuardPatternCS)$getSym(2);
					BottomPatternCS bottomPatternCS = (BottomPatternCS)$getSym(5);
					DomainCS result = QVTcCSTFactory.eINSTANCE.createDomainCS();
					result.setGuardPattern(guardPatternCS);
					result.setBottomPattern(bottomPatternCS);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	DomainCS_1_ ::= DirectionNameCS DomainCS_0_
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					DomainCS result = (DomainCS)$getSym(2);
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS, result);
					$setResult(result);
		  $EndJava
		./
	DomainCS_2_ -> DomainCS_1_
	DomainCS_2_ ::= enforce DomainCS_1_
		/.$BeginJava
					DomainCS result = (DomainCS)$getSym(2);
					result.setEnforce(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndJava
		./
	DomainCS -> DomainCS_2_
	DomainCS ::= check DomainCS_2_
		/.$BeginJava
					DomainCS result = (DomainCS)$getSym(2);
					result.setCheck(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndJava
		./
		
--ComposedMapping ::= Mapping
	ComposedMappingCS -> MappingCS
	
--DomainGuardPattern, MiddleGuardPattern ::= GuardPattern
	DomainGuardPatternCS -> GuardPatternCS
	MiddleGuardPatternCS -> GuardPatternCS
	
--DomainBottomPattern, MiddleBottomPattern ::= BottomPattern
	DomainBottomPatternCS -> BottomPatternCS
	MiddleBottomPatternCS -> BottomPatternCS
	
--GuardPattern ::= [Variable(“,”Variable )* “|” ] ( Constraint “;” )*
	GuardPatternCS_0_ ::= $empty
		/.$BeginJava
					GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	GuardPatternCS_0_ -> GuardPatternCS_1_ ','
	GuardPatternCS_1_ ::= GuardPatternCS_0_ UnrealizedVariableCS
		/.$BeginJava
					GuardPatternCS result = (GuardPatternCS)$getSym(1);
					UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)$getSym(2);
					result.getUnrealizedVariables().add(unrealizedVariableCS);
					setOffsets(result, result, unrealizedVariableCS);
					$setResult(result);
		  $EndJava
		./	
	GuardPatternCS_2_ ::= $empty
		/.$BeginJava
					GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	GuardPatternCS_2_ -> GuardPatternCS_1_ '|'
	GuardPatternCS_2_ ::= GuardPatternCS_2_ ConstraintCS ';'
		/.$BeginJava
					GuardPatternCS result = (GuardPatternCS)$getSym(1);
					OCLExpressionCS constraintCS = (OCLExpressionCS)$getSym(2);
					result.getConstraints().add(constraintCS);
					setOffsets(result, result, constraintCS);
					$setResult(result);
		  $EndJava
		./	
	GuardPatternCS -> GuardPatternCS_1_ 
	GuardPatternCS -> GuardPatternCS_2_ 
		
--BottomPattern ::= [ (Variable | RealizedVariable) (“,” ( Variable | RealizedVariable)* “|” ] ( Constraint “;” )*
	BottomPatternCS_0_ ::= $empty
		/.$BeginJava
					BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	BottomPatternCS_0_ -> BottomPatternCS_1_ ','
	BottomPatternCS_1_ ::= BottomPatternCS_0_ UnrealizedVariableCS
		/.$BeginJava
					BottomPatternCS result = (BottomPatternCS)$getSym(1);
					UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)$getSym(2);
					result.getUnrealizedVariables().add(unrealizedVariableCS);
					setOffsets(result, result, unrealizedVariableCS);
					$setResult(result);
		  $EndJava
		./	
	BottomPatternCS_1_ ::= BottomPatternCS_0_ RealizedVariableCS
		/.$BeginJava
					BottomPatternCS result = (BottomPatternCS)$getSym(1);
					RealizedVariableCS realizedVariableCS = (RealizedVariableCS)$getSym(2);
					result.getRealizedVariables().add(realizedVariableCS);
					setOffsets(result, result, realizedVariableCS);
					$setResult(result);
		  $EndJava
		./	
	BottomPatternCS_2_ ::= $empty
		/.$BeginJava
					BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	BottomPatternCS_2_ -> BottomPatternCS_1_ '|'
	BottomPatternCS_2_ ::= BottomPatternCS_2_ ConstraintCS ';'
		/.$BeginJava
					BottomPatternCS result = (BottomPatternCS)$getSym(1);
					OCLExpressionCS constraintCS = (OCLExpressionCS)$getSym(2);
					result.getConstraints().add(constraintCS);
					setOffsets(result, result, getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./	
	BottomPatternCS_2_ ::= BottomPatternCS_2_ EnforcementOperationCS
		/.$BeginJava
					BottomPatternCS result = (BottomPatternCS)$getSym(1);
					EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)$getSym(2);
					result.getEnforcementOperations().add(enforcementOperationCS);
					setOffsets(result, result, enforcementOperationCS);
					$setResult(result);
		  $EndJava
		./	
	BottomPatternCS -> BottomPatternCS_1_ 
	BottomPatternCS -> BottomPatternCS_2_ 
	
	EnforcementOperationCS_1_ ::= dotArrowExpCS
		/.$BeginJava
					OperationCallExpCS operationCallCS = (OperationCallExpCS)$getSym(1);
					EnforcementOperationCS result = QVTcCSTFactory.eINSTANCE.createEnforcementOperationCS();
					result.setOperationCall(operationCallCS);
					setOffsets(result, operationCallCS, operationCallCS);
					$setResult(result);
		  $EndJava
		./	
	EnforcementOperationCS ::= creation EnforcementOperationCS_1_ ';'
		/.$BeginJava
					EnforcementOperationCS result = (EnforcementOperationCS)$getSym(2);
					result.setDeletion(false);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./	
	EnforcementOperationCS ::= deletion EnforcementOperationCS_1_ ';'
		/.$BeginJava
					EnforcementOperationCS result = (EnforcementOperationCS)$getSym(2);
					result.setDeletion(true);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./	
	
--Variable := VariableName “:” TypeDeclaration
	UnrealizedVariableCS ::= VariableNameCS ':' typeCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(1);
					TypeCS type = (TypeCS)$getSym(3);
					UnrealizedVariableCS result = QVTcCSTFactory.eINSTANCE.createUnrealizedVariableCS();
					result.setIdentifier(identifierCS);
					result.setType(type);
					setOffsets(result, identifierCS, type);
					$setResult(result);
		  $EndJava
		./
		
--RealizedVariable := “realized” VariableName “:” TypeDeclaration
	RealizedVariableCS ::= realize VariableNameCS ':' typeCS
		/.$BeginJava
					IdentifierCS identifierCS = (IdentifierCS)$getSym(2);
					TypeCS type = (TypeCS)$getSym(4);
					RealizedVariableCS result = QVTcCSTFactory.eINSTANCE.createRealizedVariableCS();
					result.setIdentifier(identifierCS);
					result.setType(type);
					setOffsets(result, getIToken($getToken(1)), type);
					$setResult(result);
		  $EndJava
		./
		
--Constraint ::= Predicate | Assignment
	ConstraintCS -> PredicateCS
	ConstraintCS -> AssignmentCS
	
--Predicate ::= BooleanOCLExpr
	PredicateCS -> oclExpressionCS
	
--Assignement ::= [“default”] SlotOwnerOCLExpr“.”PropertyName “:=” ValueOCLExpr
	AssignmentCS_0_ ::= oclExpressionCS ':=' oclExpressionCS
		/.$BeginJava
					OCLExpressionCS target = (OCLExpressionCS)$getSym(1);
					OCLExpressionCS initialiser = (OCLExpressionCS)$getSym(3);
					AssignmentCS result = QVTcCSTFactory.eINSTANCE.createAssignmentCS();
					result.setTarget(target);
					result.setInitialiser(initialiser);
					setOffsets(result, target, initialiser);
					$setResult(result);
		  $EndJava
		./
	AssignmentCS -> AssignmentCS_0_
	AssignmentCS ::= default AssignmentCS_0_
		/.$BeginJava
					AssignmentCS result = (AssignmentCS)$getSym(2);
					result.setDefault(true);
					setOffsets(result, getIToken($getToken(1)), result);
					$setResult(result);
		  $EndJava
		./
		
	DirectionNameCS -> identifierCS
	MappingNameCS -> identifierCS
	PackageNameCS -> pathNameCS
	QueryNameCS -> pathNameCS
	TransformationNameCS -> pathNameCS
	VariableNameCS -> identifierCS
		
--<query> ::= 'query' <PathNameCS> 
--            '(' [<paramDeclaration> (',' <paramDeclaration>)*] ')'
--      	  ':' <TypeCS>
--            (';' | '{' <OclExpressionCS> '}')
	QueryCS_preParamDeclaration ::= query QueryNameCS '('
		/.$BeginJava
					QueryCS result = QVTcCSTFactory.eINSTANCE.createQueryCS();
					result.setPathName((PathNameCS)$getSym(2));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	QueryCS_preParamDeclaration -> QueryCS_postParamDeclaration ','
	QueryCS_postParamDeclaration ::= QueryCS_preParamDeclaration paramDeclarationCS
		/.$BeginJava
					ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)$getSym(2);
					QueryCS result = (QueryCS)$getSym(1);
					result.getInputParamDeclaration().add(paramDeclarationCS);
					setOffsets(result, result, paramDeclarationCS);
					$setResult(result);
		  $EndJava
		./
	QueryCS_postType ::= QueryCS_postParamDeclaration ')' ':' typeCS
		/.$BeginJava
					TypeCS typeCS = (TypeCS)$getSym(4);
					QueryCS result = (QueryCS)$getSym(1);
					result.setType(typeCS);
					setOffsets(result, result, typeCS);
					$setResult(result);
		  $EndJava
		./
	QueryCS ::= QueryCS_postType ';'
		/.$BeginJava
					QueryCS result = (QueryCS)$getSym(1);
					setOffsets(result, result, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	QueryCS ::= QueryCS_postType '{' oclExpressionCS '}'
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
					ParamDeclarationCS result = QVTcCSTFactory.eINSTANCE.createParamDeclarationCS();
					result.setIdentifier(identifierCS);
					result.setType(typeCS);
					setOffsets(result, identifierCS, typeCS);
					$setResult(result);
		  $EndJava
		./
		
	coreIdentifier -> check
	coreIdentifier -> creation
--	coreIdentifier -> default
	coreIdentifier -> deletion
	coreIdentifier -> enforce
	coreIdentifier -> imports
	coreIdentifier -> map
	coreIdentifier -> query
	coreIdentifier -> realize
	coreIdentifier -> refines
	coreIdentifier -> transformation
	coreIdentifier -> uses
	coreIdentifier -> where
	
	coreIdentifier -> def
	coreIdentifier -> endpackage
	coreIdentifier -> inv
	coreIdentifier -> post
	coreIdentifier -> pre
	
	pathNameCS ::= coreIdentifier
		/.$BeginJava
					int token = $getToken(1);
					PathNameCS result = createPathNameCS();
					result.getSequenceOfNames().add(getTokenText(token));
					setOffsets(result, getIToken(token));
					$setResult(result);
		  $EndJava
		./

--	simpleNameCS ::= default
	simpleNameCS ::= coreIdentifier
		/.$BeginJava
					int token = $getToken(1);
					SimpleNameCS result = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(token));
					setOffsets(result, getIToken(token));
					$setResult(result);
		  $EndJava
		./
	
	identifierCS ::= IDENTIFIER
		/.$BeginJava
					int token = $getToken(1);
					IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
					result.setValue(getTokenText(token));
					setOffsets(result, getIToken(token));
					$setResult(result);
		  $EndJava
		./
	identifierCS ::= STRING_LITERAL
		/.$BeginJava
					int token = $getToken(1);
					IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
					String string = getTokenText(token);
					result.setValue(string.substring(1, string.length()-1));
					setOffsets(result, getIToken(token));
					$setResult(result);
		  $EndJava
		./
$End
	