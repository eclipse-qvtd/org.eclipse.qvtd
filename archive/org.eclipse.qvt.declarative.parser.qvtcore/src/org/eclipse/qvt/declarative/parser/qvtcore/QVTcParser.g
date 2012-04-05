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
%options la=1
%options fp=QVTcParser,prefix=TK_
%options backtrack
%options noserialize
%options package=org.eclipse.qvt.declarative.parser.qvtcore
%options import_terminals=QVTcLexer.gi
%options ast_type=CSTNode
%options ParseTable=lpg.runtime.ParseTable
%options template=btParserTemplateF.gi
%options include_directory=".;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser;../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/parser/backtracking"

%KeyWords
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
%End

%Terminals
	COLON_EQUALS     ::= ':='
%End

%Globals
/.
import org.eclipse.qvt.declarative.parser.qvt.cst.*;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.*;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.parser.$super_parser_class;
import org.eclipse.ocl.parser.backtracking.OCLParserErrors;

./
%End

%Start
	TopLevelCS
%End

%Import
	EssentialOCL.gi
%End

%Import
	EssentialOCLErrors.gi
%End

%Define
    $environment_class /.ICSTFileEnvironment./
	$super_lexer_class /.QVTcLexer./
    $LPGParsersym_class /.QVTcParserSymbols./
	$copyright_contributions /.*   E.D.Willink - Extended API and implementation for QVTc
*./
%End

%Headers
	/.			
		protected IdentifierCS createIdentifierCS(SimpleNameCS simpleName) {
			IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
			result.setValue(simpleName.getValue());
			setOffsets(result, simpleName);
			return result;
		}

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
%End

%Rules
	TopLevelCS ::= $empty
		/.$BeginCode
					TopLevelCS result = QVTcCSTFactory.eINSTANCE.createTopLevelCS();
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	TopLevelCS ::= TopLevelCS MappingCS
		/.$BeginCode
					TopLevelCS result = (TopLevelCS)getRhsSym(1);
					MappingCS mappingCS = (MappingCS)getRhsSym(2);
					result.getMappings().add(mappingCS);
					setOffsets(result, result, mappingCS);
					setResult(result);
		  $EndCode
		./
	TopLevelCS ::= TopLevelCS TransformationCS
		/.$BeginCode
					TopLevelCS result = (TopLevelCS)getRhsSym(1);
					TransformationCS transformationCS = (TransformationCS)getRhsSym(2);
					result.getTransformations().add(transformationCS);
					setOffsets(result, result, transformationCS);
					setResult(result);
		  $EndCode
		./
	TopLevelCS ::= TopLevelCS QueryCS
		/.$BeginCode
					TopLevelCS result = (TopLevelCS)getRhsSym(1);
					QueryCS queryCS = (QueryCS)getRhsSym(2);
					result.getQueries().add(queryCS);
					setOffsets(result, result, queryCS);
					setResult(result);
		  $EndCode
		./
	
--Transformation ::=
--“transformation” TransformationName “{”
--( Direction“;” )*
--“}”
	TransformationCS_0_ ::= transformation TransformationNameCS '{'
		/.$BeginCode
					TransformationCS result = QVTcCSTFactory.eINSTANCE.createTransformationCS();
					result.setPathName((PathNameCS)getRhsSym(2));
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	TransformationCS_0_ ::= TransformationCS_0_ DirectionCS ';'
		/.$BeginCode
					TransformationCS result = (TransformationCS)getRhsSym(1);
					DirectionCS directionCS = (DirectionCS)getRhsSym(2);
					result.getDirections().add(directionCS);
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./	
	TransformationCS ::= TransformationCS_0_ '}'
		/.$BeginCode
					TransformationCS result = (TransformationCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./	
	
--Direction ::= DirectionName [“imports” PackageName(“,” PackageName)*]
--					[“uses” DirectionName(“,” DirectionName)*]
	DirectionCS_0_ ::= DirectionNameCS
		/.$BeginCode
					IdentifierCS directionNameCS = (IdentifierCS)getRhsSym(1);
					DirectionCS result = QVTcCSTFactory.eINSTANCE.createDirectionCS();
					result.setIdentifier(directionNameCS);
					setOffsets(result, directionNameCS);
					setResult(result);
		  $EndCode
		./
	DirectionCS_1_ -> DirectionCS_0_ imports
	DirectionCS_1_ -> DirectionCS_2_ ',' 
	DirectionCS_2_ ::= DirectionCS_1_ PackageNameCS
		/.$BeginCode
					DirectionCS result = (DirectionCS)getRhsSym(1);
					PathNameCS pathNameCS = (PathNameCS)getRhsSym(2);
					result.getImports().add(pathNameCS);
					setOffsets(result, result, pathNameCS);
					setResult(result);
		  $EndCode
		./	
	DirectionCS_3_ -> DirectionCS_0_ 
	DirectionCS_3_ -> DirectionCS_2_ 
	DirectionCS_4_ -> DirectionCS_3_ uses 
	DirectionCS_4_ -> DirectionCS_5_ ',' 
	DirectionCS_5_ ::= DirectionCS_4_ DirectionNameCS
		/.$BeginCode
					DirectionCS result = (DirectionCS)getRhsSym(1);
					IdentifierCS directionNameCS = (IdentifierCS)getRhsSym(2);
					result.getUses().add(directionNameCS);
					setOffsets(result, result, directionNameCS);
					setResult(result);
		  $EndCode
		./	
	DirectionCS -> DirectionCS_3_ 
	DirectionCS -> DirectionCS_5_ 
	
--Mapping ::= “map” MappingName [“in” TransformationName] [“refines” MappingName] “{”
--				( [“check”] [“enforce”] DirectionName “(”DomainGuardPattern“)” “{” DomainBottomPattern “}” )*
--				“where” “(” MiddleGuardPattern “)” “{” MiddleBottomPattern “}”
--					( ComposedMapping )* “}”
	MappingCS_1_ ::= map
		/.$BeginCode
					MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
//					IdentifierCS identifierCS = createUniqueIdentifierCS(getRhsTokenIndex(1));
//					result.setIdentifier(identifierCS);
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	MappingCS_1_ ::= map MappingNameCS
		/.$BeginCode
					MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
					result.setIdentifier(identifierCS);
					setOffsets(result, getRhsIToken(1), identifierCS);
					setResult(result);
		  $EndCode
		./	
	MappingCS_2_ -> MappingCS_1_
	MappingCS_2_ ::= MappingCS_1_ in TransformationNameCS
		/.$BeginCode
					MappingCS result = (MappingCS)getRhsSym(1);
					PathNameCS identifierCS = (PathNameCS)getRhsSym(3);
					result.setIn(identifierCS);
					setOffsets(result, result, identifierCS);
					setResult(result);
		  $EndCode
		./	
	MappingCS_3_ -> MappingCS_2_
	MappingCS_3_ ::= MappingCS_2_ refines MappingNameCS
		/.$BeginCode
					MappingCS result = (MappingCS)getRhsSym(1);
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
					result.getRefines().add(identifierCS);
					setOffsets(result, result, identifierCS);
					setResult(result);
		  $EndCode
		./	
	MappingCS_3_ ::= MappingCS_3_ ',' MappingNameCS
		/.$BeginCode
					MappingCS result = (MappingCS)getRhsSym(1);
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
					result.getRefines().add(identifierCS);
					setOffsets(result, result, identifierCS);
					setResult(result);
		  $EndCode
		./	
	MappingCS_4_ -> MappingCS_3_ '{'
	MappingCS_4_ ::= MappingCS_4_ DomainCS	
		/.$BeginCode
					MappingCS result = (MappingCS)getRhsSym(1);
					DomainCS domainCS = (DomainCS)getRhsSym(2);
					result.getDomains().add(domainCS);
					setOffsets(result, result, domainCS);
					setResult(result);
		  $EndCode
		./	
	MappingCS_8 ::= MappingCS_4_ where DomainCS_0_
		/.$BeginCode
					MappingCS result = (MappingCS)getRhsSym(1);
					IdentifierCS directionNameCS = QVTCSTFactory.eINSTANCE.createIdentifierCS();
					directionNameCS.setValue("");
					setOffsets(directionNameCS, getRhsIToken(2));
					DomainCS domainCS = (DomainCS)getRhsSym(3);
					domainCS.setIdentifier(directionNameCS);
					setOffsets(domainCS, directionNameCS, domainCS);
					result.setMiddle(domainCS);
					setOffsets(result, result, domainCS);
					setResult(result);
		  $EndCode
		./
	MappingCS_8 ::= MappingCS_4_ where DirectionNameCS DomainCS_0_
		/.$BeginCode
					MappingCS result = (MappingCS)getRhsSym(1);
					IdentifierCS directionNameCS = (IdentifierCS)getRhsSym(3);
					setOffsets(directionNameCS, getRhsIToken(2), directionNameCS);
					DomainCS domainCS = (DomainCS)getRhsSym(4);
					domainCS.setIdentifier(directionNameCS);
					setOffsets(domainCS, directionNameCS, domainCS);
					result.setMiddle(domainCS);
					setOffsets(result, result, domainCS);
					setResult(result);
		  $EndCode
		./
	MappingCS_8 ::= MappingCS_8 ComposedMappingCS
		/.$BeginCode
					MappingCS result = (MappingCS)getRhsSym(1);
					MappingCS composedMappingCS = (MappingCS)getRhsSym(2);
					result.getComposedMappings().add(composedMappingCS);
					setOffsets(result, result, composedMappingCS);
					setResult(result);
		  $EndCode
		./	
	MappingCS ::= MappingCS_8 '}'
		/.$BeginCode
					MappingCS result = (MappingCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./	
	
	DomainCS_0_ ::= '(' DomainGuardPatternCS ')' '{' DomainBottomPatternCS  '}'
		/.$BeginCode
					GuardPatternCS guardPatternCS = (GuardPatternCS)getRhsSym(2);
					BottomPatternCS bottomPatternCS = (BottomPatternCS)getRhsSym(5);
					DomainCS result = QVTcCSTFactory.eINSTANCE.createDomainCS();
					result.setGuardPattern(guardPatternCS);
					result.setBottomPattern(bottomPatternCS);
					setOffsets(result, getRhsIToken(1), getRhsIToken(6));
					setResult(result);
		  $EndCode
		./
	DomainCS_1_ ::= DirectionNameCS DomainCS_0_
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					DomainCS result = (DomainCS)getRhsSym(2);
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS, result);
					setResult(result);
		  $EndCode
		./
	DomainCS_2_ -> DomainCS_1_
	DomainCS_2_ ::= enforce DomainCS_1_
		/.$BeginCode
					DomainCS result = (DomainCS)getRhsSym(2);
					result.setEnforce(true);
					setOffsets(result, getRhsIToken(1), result);
					setResult(result);
		  $EndCode
		./
	DomainCS -> DomainCS_2_
	DomainCS ::= check DomainCS_2_
		/.$BeginCode
					DomainCS result = (DomainCS)getRhsSym(2);
					result.setCheck(true);
					setOffsets(result, getRhsIToken(1), result);
					setResult(result);
		  $EndCode
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
	GuardPatternCS_1_ ::= UnrealizedVariableCS
		/.$BeginCode
					GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
					UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)getRhsSym(1);
					result.getUnrealizedVariables().add(unrealizedVariableCS);
					setOffsets(result, unrealizedVariableCS);
					setResult(result);
		  $EndCode
		./	
	GuardPatternCS_1_ ::= GuardPatternCS_1_ ',' UnrealizedVariableCS
		/.$BeginCode
					GuardPatternCS result = (GuardPatternCS)getRhsSym(1);
					UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)getRhsSym(3);
					result.getUnrealizedVariables().add(unrealizedVariableCS);
					setOffsets(result, result, unrealizedVariableCS);
					setResult(result);
		  $EndCode
		./	
	GuardPatternCS_2_ -> GuardPatternCS_1_ '|'
	GuardPatternCS_2_ ::= ConstraintCS ';'
		/.$BeginCode
					GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
					OCLExpressionCS constraintCS = (OCLExpressionCS)getRhsSym(1);
					result.getConstraints().add(constraintCS);
					setOffsets(result, constraintCS);
					setResult(result);
		  $EndCode
		./	
	GuardPatternCS_2_ ::= GuardPatternCS_2_ ConstraintCS ';'
		/.$BeginCode
					GuardPatternCS result = (GuardPatternCS)getRhsSym(1);
					OCLExpressionCS constraintCS = (OCLExpressionCS)getRhsSym(2);
					result.getConstraints().add(constraintCS);
					setOffsets(result, result, constraintCS);
					setResult(result);
		  $EndCode
		./	
	GuardPatternCS -> GuardPatternCS_1_ 
	GuardPatternCS -> GuardPatternCS_2_ 
	GuardPatternCS ::= $empty
		/.$BeginCode
					GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
		
--BottomPattern ::= [ (Variable | RealizedVariable) (“,” ( Variable | RealizedVariable)* “|” ] ( Constraint “;” )*
	BottomPatternCS_1_ ::= UnrealizedVariableCS
		/.$BeginCode
					BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
					UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)getRhsSym(1);
					result.getUnrealizedVariables().add(unrealizedVariableCS);
					setOffsets(result, result, unrealizedVariableCS);
					setResult(result);
		  $EndCode
		./	
	BottomPatternCS_1_ ::= BottomPatternCS_1_ ',' UnrealizedVariableCS
		/.$BeginCode
					BottomPatternCS result = (BottomPatternCS)getRhsSym(1);
					UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)getRhsSym(3);
					result.getUnrealizedVariables().add(unrealizedVariableCS);
					setOffsets(result, result, unrealizedVariableCS);
					setResult(result);
		  $EndCode
		./	
	BottomPatternCS_1_ ::= RealizedVariableCS
		/.$BeginCode
					BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
					RealizedVariableCS realizedVariableCS = (RealizedVariableCS)getRhsSym(1);
					result.getRealizedVariables().add(realizedVariableCS);
					setOffsets(result, realizedVariableCS);
					setResult(result);
		  $EndCode
		./	
	BottomPatternCS_1_ ::= BottomPatternCS_1_ ',' RealizedVariableCS
		/.$BeginCode
					BottomPatternCS result = (BottomPatternCS)getRhsSym(1);
					RealizedVariableCS realizedVariableCS = (RealizedVariableCS)getRhsSym(3);
					result.getRealizedVariables().add(realizedVariableCS);
					setOffsets(result, realizedVariableCS);
					setResult(result);
		  $EndCode
		./	
	BottomPatternCS_2_ -> BottomPatternCS_1_ '|'
	BottomPatternCS_2_ ::= ConstraintCS ';'
		/.$BeginCode
					BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
					OCLExpressionCS constraintCS = (OCLExpressionCS)getRhsSym(1);
					result.getConstraints().add(constraintCS);
					setOffsets(result, constraintCS, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./	
	BottomPatternCS_2_ ::= EnforcementOperationCS
		/.$BeginCode
					BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
					EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)getRhsSym(1);
					result.getEnforcementOperations().add(enforcementOperationCS);
					setOffsets(result, enforcementOperationCS);
					setResult(result);
		  $EndCode
		./	
	BottomPatternCS_2_ ::= BottomPatternCS_2_ ConstraintCS ';'
		/.$BeginCode
					BottomPatternCS result = (BottomPatternCS)getRhsSym(1);
					OCLExpressionCS constraintCS = (OCLExpressionCS)getRhsSym(2);
					result.getConstraints().add(constraintCS);
					setOffsets(result, result, getRhsIToken(3));
					setResult(result);
		  $EndCode
		./	
	BottomPatternCS_2_ ::= BottomPatternCS_2_ EnforcementOperationCS
		/.$BeginCode
					BottomPatternCS result = (BottomPatternCS)getRhsSym(1);
					EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)getRhsSym(2);
					result.getEnforcementOperations().add(enforcementOperationCS);
					setOffsets(result, result, enforcementOperationCS);
					setResult(result);
		  $EndCode
		./	
	BottomPatternCS -> BottomPatternCS_1_ 
	BottomPatternCS -> BottomPatternCS_2_ 
	BottomPatternCS ::= $empty
		/.$BeginCode
					BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	
	EnforcementOperationCS_1_ ::= primaryExpCS
		/.$BeginCode
					OperationCallExpCS operationCallCS = (OperationCallExpCS)getRhsSym(1);
					EnforcementOperationCS result = QVTcCSTFactory.eINSTANCE.createEnforcementOperationCS();
					result.setOperationCall(operationCallCS);
					setOffsets(result, operationCallCS, operationCallCS);
					setResult(result);
		  $EndCode
		./	
	EnforcementOperationCS ::= creation EnforcementOperationCS_1_ ';'
		/.$BeginCode
					EnforcementOperationCS result = (EnforcementOperationCS)getRhsSym(2);
					result.setDeletion(false);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./	
	EnforcementOperationCS ::= deletion EnforcementOperationCS_1_ ';'
		/.$BeginCode
					EnforcementOperationCS result = (EnforcementOperationCS)getRhsSym(2);
					result.setDeletion(true);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./	
	
--Variable := VariableName “:” TypeDeclaration
	UnrealizedVariableCS ::= VariableNameCS ':' typeCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					TypeCS type = (TypeCS)getRhsSym(3);
					UnrealizedVariableCS result = QVTcCSTFactory.eINSTANCE.createUnrealizedVariableCS();
					result.setIdentifier(identifierCS);
					result.setType(type);
					setOffsets(result, identifierCS, type);
					setResult(result);
		  $EndCode
		./
		
--RealizedVariable := “realized” VariableName “:” TypeDeclaration
	RealizedVariableCS ::= realize VariableNameCS ':' typeCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
					TypeCS type = (TypeCS)getRhsSym(4);
					RealizedVariableCS result = QVTcCSTFactory.eINSTANCE.createRealizedVariableCS();
					result.setIdentifier(identifierCS);
					result.setType(type);
					setOffsets(result, getRhsIToken(1), type);
					setResult(result);
		  $EndCode
		./
		
--Constraint ::= Predicate | Assignment
	ConstraintCS -> PredicateCS
	ConstraintCS -> AssignmentCS
	
--Predicate ::= BooleanOCLExpr
	PredicateCS -> OclExpressionCS
	
--Assignement ::= [“default”] SlotOwnerOCLExpr“.”PropertyName “:=” ValueOCLExpr
	AssignmentCS_0_ ::= OclExpressionCS ':=' OclExpressionCS
		/.$BeginCode
					OCLExpressionCS target = (OCLExpressionCS)getRhsSym(1);
					OCLExpressionCS initialiser = (OCLExpressionCS)getRhsSym(3);
					AssignmentCS result = QVTcCSTFactory.eINSTANCE.createAssignmentCS();
					result.setTarget(target);
					result.setInitialiser(initialiser);
					setOffsets(result, target, initialiser);
					setResult(result);
		  $EndCode
		./
	AssignmentCS -> AssignmentCS_0_
	AssignmentCS ::= default AssignmentCS_0_
		/.$BeginCode
					AssignmentCS result = (AssignmentCS)getRhsSym(2);
					result.setDefault(true);
					setOffsets(result, getRhsIToken(1), result);
					setResult(result);
		  $EndCode
		./
		
	DirectionNameCS -> identifierCS
	DirectionNameCS -> ERROR_identifierCS
	MappingNameCS -> identifierCS
	MappingNameCS -> ERROR_identifierCS
	PackageNameCS -> pathNameCS
	QueryNameCS -> pathNameCS
	TransformationNameCS -> pathNameCS
	VariableNameCS -> identifierCS
--	VariableNameCS -> ERROR_identifierCS
		
--<query> ::= 'query' <PathNameCS> 
--            '(' [<paramDeclaration> (',' <paramDeclaration>)*] ')'
--      	  ':' <TypeCS>
--            (';' | '{' <OclExpressionCS> '}')
	QueryCS_preParamDeclaration ::= query QueryNameCS '('
		/.$BeginCode
					QueryCS result = QVTcCSTFactory.eINSTANCE.createQueryCS();
					result.setPathName((PathNameCS)getRhsSym(2));
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	QueryCS_preParamDeclaration -> QueryCS_postParamDeclaration ','
	QueryCS_postParamDeclaration ::= QueryCS_preParamDeclaration paramDeclarationCS
		/.$BeginCode
					ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)getRhsSym(2);
					QueryCS result = (QueryCS)getRhsSym(1);
					result.getInputParamDeclaration().add(paramDeclarationCS);
					setOffsets(result, result, paramDeclarationCS);
					setResult(result);
		  $EndCode
		./
	QueryCS_postType ::= QueryCS_postParamDeclaration ')' ':' typeCS
		/.$BeginCode
					TypeCS typeCS = (TypeCS)getRhsSym(4);
					QueryCS result = (QueryCS)getRhsSym(1);
					result.setType(typeCS);
					setOffsets(result, result, typeCS);
					setResult(result);
		  $EndCode
		./
	QueryCS ::= QueryCS_postType ';'
		/.$BeginCode
					QueryCS result = (QueryCS)getRhsSym(1);
					setOffsets(result, result, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	QueryCS ::= QueryCS_postType '{' OclExpressionCS '}'
		/.$BeginCode
					QueryCS result = (QueryCS)getRhsSym(1);
					result.setOclExpression((OCLExpressionCS)getRhsSym(3));
					setOffsets(result, result, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./
	
--<paramDeclaration> ::= <identifier> ':' <TypeCS>	
	paramDeclarationCS ::= ERROR_identifierCS ':' typeCS
		/.$NewCase./
	paramDeclarationCS ::= identifierCS ':' typeCS
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					TypeCS typeCS = (TypeCS)getRhsSym(3);
					ParamDeclarationCS result = QVTcCSTFactory.eINSTANCE.createParamDeclarationCS();
					result.setIdentifier(identifierCS);
					result.setType(typeCS);
					setOffsets(result, identifierCS, typeCS);
					setResult(result);
		  $EndCode
		./
	paramDeclarationCS ::= identifierCS ERROR_Colon
		/.$BeginCode
					IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
					ParamDeclarationCS result = QVTcCSTFactory.eINSTANCE.createParamDeclarationCS();
					result.setIdentifier(identifierCS);
					setOffsets(result, identifierCS, getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
		
	coreKeyword -> check
--	coreKeyword -> creation
--	coreKeyword -> default
--	coreKeyword -> deletion
	coreKeyword -> enforce
	coreKeyword -> imports
	coreKeyword -> map
	coreKeyword -> query
	coreKeyword -> realize
	coreKeyword -> refines
	coreKeyword -> transformation
	coreKeyword -> uses
	coreKeyword -> where

	reservedKeyword -> coreKeyword
	
	ERROR_identifierCS ::= ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(1), QVTcParserErrors.MISSING_IDENTIFIER);
					IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
					result.setValue(getRhsTokenText(1));
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	identifierCS ::= IDENTIFIER
		/.$BeginCode
					IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
					result.setValue(getRhsTokenText(1));
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	identifierCS ::= STRING_LITERAL
		/.$BeginCode
					IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
					String string = getRhsTokenText(1);
					result.setValue(string.substring(1, string.length()-1));
					setOffsets(result, getRhsIToken(1));
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
	