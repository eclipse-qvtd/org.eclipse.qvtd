/**
* Essential OCL Grammar
* <copyright>
*
* Copyright (c) 2005, 2009 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112
*   Borland - Bug 242880
*   E.D.Willink - Extended API and implementation for QVTc
*
* </copyright>
*
* $Id: QVTcParser.java,v 1.11 2009/10/21 07:48:38 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

import org.eclipse.qvt.declarative.parser.qvt.cst.*;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.*;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.parser.AbstractOCLParser;
import org.eclipse.ocl.parser.backtracking.OCLParserErrors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.BacktrackingParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotBacktrackParseTableException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.RuleAction;

public class QVTcParser extends AbstractOCLParser implements RuleAction
{
	protected static ParseTable prs = new QVTcParserprs();
	private BacktrackingParser dtParser;

	public QVTcParser(QVTcLexer lexer) {
		super(lexer);
	}

	public int getEOFTokenKind() { return QVTcParserprs.EOFT_SYMBOL; }

	public ICSTFileEnvironment getOCLEnvironment() {
		return getLexer().getOCLEnvironment();
	}
	
	@Override 
	public QVTcLexer getLexer() {
		return (QVTcLexer)super.getLexer();
	}

	public String getTokenKindName(int kind) { return QVTcParsersym.orderedTerminalSymbols[kind]; }			

	@Override
	public String[] orderedTerminalSymbols() { return QVTcParsersym.orderedTerminalSymbols; }
		
	@SuppressWarnings("nls")
	@Override
	public CSTNode parseTokensToCST(Monitor monitor, int error_repair_count) {
		ParseTable prsTable = new QVTcParserprs();

		try {
			dtParser = new BacktrackingParser(monitor, this, prsTable, this);
		}
		catch (NotBacktrackParseTableException e) {
            throw new RuntimeException("****Error: Regenerate QVTcParserprs.java with -BACKTRACK option");
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- QVTcParsersym.java. Regenerate QVTcParserprs.java");
		}

		try {
			return (CSTNode) dtParser.parse(error_repair_count);
		}
		catch (BadParseException e) {
			reset(e.error_token); // point to error token

			DiagnoseParser diagnoseParser = new DiagnoseParser(this, prsTable);
			diagnoseParser.diagnose(e.error_token);
		}

		return null;
	}

    /**
     * Initializes a concrete-syntax node's start and end offsets from the
     * current token in the parser stream.
     * 
     * @param cstNode a concrete-syntax node
     * 
     * @since 1.2
     */
	protected void setOffsets(CSTNode cstNode) {
		IToken firstToken = getIToken(dtParser.getToken(1));
		cstNode.setStartToken(firstToken);
		cstNode.setEndToken(firstToken);
		cstNode.setStartOffset(firstToken.getStartOffset());
		cstNode.setEndOffset(firstToken.getEndOffset()-1);
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

	@SuppressWarnings("unchecked")
	public void ruleAction(int ruleNumber)
	{
		switch (ruleNumber) {
		
 
			//
			// Rule 37:  binaryKeywordCS ::= binaryKeyword
			//
			case 37:
 
			//
			// Rule 38:  otherKeywordCS ::= otherKeyword
			//
			case 38:
 
			//
			// Rule 39:  unaryKeywordCS ::= unaryKeyword
			//
			case 39:
 
			//
			// Rule 40:  reservedPunctuationCS ::= reservedPunctuation
			//
			case 40: {
				
				SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 44:  iterateNameCS ::= iterateIdentifier
			//
			case 44:
 
			//
			// Rule 45:  iteratorNameCS ::= iteratorIdentifier
			//
			case 45:
 
			//
			// Rule 46:  simpleIdentifierCS ::= otherIdentifier
			//
			case 46: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 48:  simpleIdentifierCS ::= self
			//
			case 48: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 61:  pathNameCS ::= notReservedSimpleNameCS
			//
			case 61: {
				
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(1);
				PathNameCS result = createPathNameCS(simpleName);
				setOffsets(result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 63:  qualifiedPathNameCS ::= pathNameCS :: notReservedSimpleNameCS
			//
			case 63: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(3);
				result = extendPathNameCS(result, simpleName);
				setOffsets(result, result, simpleName);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 64:  primitiveTypeCS ::= Boolean
			//
			case 64: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 65:  primitiveTypeCS ::= Integer
			//
			case 65: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 66:  primitiveTypeCS ::= Real
			//
			case 66: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 67:  primitiveTypeCS ::= String
			//
			case 67: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 68:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 68: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 69:  primitiveTypeCS ::= OclAny
			//
			case 69: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 70:  primitiveTypeCS ::= OclInvalid
			//
			case 70: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 71:  primitiveTypeCS ::= OclVoid
			//
			case 71: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 72:  CollectionTypeIdentifierCS ::= Bag
			//
			case 72: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.BAG_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 73:  CollectionTypeIdentifierCS ::= Collection
			//
			case 73: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 74:  CollectionTypeIdentifierCS ::= OrderedSet
			//
			case 74: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 75:  CollectionTypeIdentifierCS ::= Sequence
			//
			case 75: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 76:  CollectionTypeIdentifierCS ::= Set
			//
			case 76: {
				
				SimpleNameCS result = createCollectionTypeCS(
							CollectionTypeIdentifierEnum.SET_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 77:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
			//
			case 77: {
				
				CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1);
				result.setTypeCS((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 78:  tupleTypeCS ::= Tuple ( variableDeclarationListCSopt )
			//
			case 78: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 79:  typeCS ::= notReservedSimpleNameCS
			//
			case 79: {
				
				CSTNode result = (CSTNode)dtParser.getSym(1);
				if (!(result instanceof TypeCS)) {
					PathNameCS pathNameCS = createPathNameCS((SimpleNameCS)result);
					setOffsets(pathNameCS, result);
					result = pathNameCS;
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 87:  typedVariableCS ::= BooleanLiteralExpCS : typeCS
			//
			case 87:
 
			//
			// Rule 88:  typedVariableCS ::= InvalidLiteralExpCS : typeCS
			//
			case 88:
 
			//
			// Rule 89:  typedVariableCS ::= NullLiteralExpCS : typeCS
			//
			case 89:
 
			//
			// Rule 90:  typedVariableCS ::= notLiteralNorReservedSimpleNameCS : typeCS
			//
			case 90: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				TypeCS type = (TypeCS)dtParser.getSym(3);
				VariableCS result = createVariableCS(name, type, null);
				setOffsets(result, name, type);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 91:  VariableDeclarationCS ::= variableNameCS
			//
			case 91: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createVariableCS(name, null, null);
				setOffsets(result, name);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 93:  VariableDeclarationCS ::= typedVariableCS = OclExpressionCS
			//
			case 93: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				result.setInitExpression(initExpression);
				setOffsets(result, result, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 94:  variableDeclarationListCS ::= VariableDeclarationCS
			//
			case 94: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 95:  variableDeclarationListCS ::= variableDeclarationListCS , VariableDeclarationCS
			//
			case 95: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 96:  variableDeclarationListCSopt ::= $Empty
			//
			case 96:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 98:  BooleanLiteralExpCS ::= false
			//
			case 98: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 99:  BooleanLiteralExpCS ::= true
			//
			case 99: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 100:  IntegerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 100: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 101:  InvalidLiteralExpCS ::= invalid
			//
			case 101: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 102:  NullLiteralExpCS ::= null
			//
			case 102: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 103:  RealLiteralExpCS ::= REAL_LITERAL
			//
			case 103: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 104:  StringLiteralExpCS ::= STRING_LITERAL
			//
			case 104: {
				
				IToken literalToken = getIToken(dtParser.getToken(1));
				StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
				result.setUnescapedStringSymbol(unescape(literalToken));
				setOffsets(result, literalToken);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 105:  UnlimitedNaturalLiteralExpCS ::= *
			//
			case 105: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 111:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
			//
			case 111: {
				
				CollectionTypeCS typeCS = (CollectionTypeCS)dtParser.getSym(1);
				CSTNode result = createCollectionLiteralExpCS(
						typeCS,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, typeCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 112:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
			//
			case 112: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 114:  CollectionLiteralPartCS ::= OclExpressionCS
			//
			case 114: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 115:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
			//
			case 115: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 116:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
			//
			case 116: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 117:  CollectionLiteralPartsCSopt ::= $Empty
			//
			case 117:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 119:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
			//
			case 119: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 120:  TupleLiteralPartCS ::= variableNameCS = OclExpressionCS
			//
			case 120: {
				
				SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				VariableCS result = createVariableCS(name, null, initExpression);
				setOffsets(result, name, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 121:  TupleLiteralPartCS ::= typedVariableCS = OclExpressionCS
			//
			case 121: {
				
				VariableCS result = (VariableCS)dtParser.getSym(1);
				OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
				result.setInitExpression(initExpression);
				setOffsets(result, result, initExpression);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 122:  TupleLiteralPartsCS ::= TupleLiteralPartCS
			//
			case 122: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 123:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , TupleLiteralPartCS
			//
			case 123: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 129:  OperationCallExpCS ::= primaryExpCS -> notIteratorNorReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 129: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CSTNode result = createArrowOperationCallExpCS(
						source,
						(SimpleNameCS)dtParser.getSym(3),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 130:  OperationCallExpCS ::= primaryExpCS . binaryKeywordCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 130:
 
			//
			// Rule 131:  OperationCallExpCS ::= primaryExpCS . unaryKeywordCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 131:
 
			//
			// Rule 132:  OperationCallExpCS ::= primaryExpCS . reservedPunctuationCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 132:
 
			//
			// Rule 133:  OperationCallExpCS ::= primaryExpCS . notReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 133: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CSTNode result = createDotOperationCallExpCS(
						source,
						null,
						(SimpleNameCS)dtParser.getSym(3),
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  OperationCallExpCS ::= literalSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 134:
 
			//
			// Rule 135:  OperationCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 135: {
				
				CSTNode result = createDotOperationCallExpCS(
						null,
						null,
						(SimpleNameCS)dtParser.getSym(1),
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 136:  OperationCallExpCS ::= qualifiedPathNameCS ( argumentsCSopt )
			//
			case 136: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				OperationCallExpCS result = createDotOperationCallExpCS(
						null,
						pathNameCS,
						simpleNameCS,
						null,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  OperationCallExpCS ::= primaryExpCS . qualifiedPathNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
			case 137: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				CallExpCS result = createDotOperationCallExpCS(
						source,
						pathNameCS,
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(4),
						(EList)dtParser.getSym(6)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  argumentsCS ::= OclExpressionCS
			//
			case 138: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  argumentsCS ::= argumentsCS , OclExpressionCS
			//
			case 139: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 140:  argumentsCSopt ::= $Empty
			//
			case 140:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 142:  isMarkedPreCSopt ::= $Empty
			//
			case 142: {
				
				dtParser.setSym1(null);
	  		  break;
			}
	 
			//
			// Rule 143:  PropertyCallExpCS ::= primaryExpCS . notReservedSimpleNameCS isMarkedPreCSopt
			//
			case 143: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(4);
				CSTNode result = createFeatureCallExpCS(
						source,
						null,
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, source, isMarkedPreCS);
				} else {
					setOffsets(result, source, simpleNameCS);
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 144:  PropertyCallExpCS ::= primaryExpCS . qualifiedPathNameCS isMarkedPreCSopt
			//
			case 144: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(4);
				CSTNode result = createFeatureCallExpCS(
						source,
						pathNameCS,
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, source, isMarkedPreCS);
				} else {
					setOffsets(result, source, simpleNameCS);
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 145:  PropertyCallExpCS ::= primaryExpCS . pathNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 145: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(7);
				CSTNode result = createFeatureCallExpCS(
						source,
						pathNameCS,
						simpleNameCS,
						(EList)dtParser.getSym(5),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, source, isMarkedPreCS);
				} else {
					setOffsets(result, source, getIToken(dtParser.getToken(6)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 146:  PropertyCallExpCS ::= qualifiedPathNameCS isMarkedPreCSopt
			//
			case 146: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createFeatureCallExpCS(
						null,
						pathNameCS,
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, pathNameCS, isMarkedPreCS);
				} else {
					setOffsets(result, pathNameCS, simpleNameCS);
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 147:  AssociationClassCallExpCS ::= notLiteralNorReservedSimpleNameCS isMarkedPreCSopt
			//
			case 147: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 148:  AssociationClassCallExpCS ::= notReservedSimpleNameCS [ argumentsCS ] isMarkedPreCSopt
			//
			case 148: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 152:  IterateExpCS ::= primaryExpCS -> iterateNameCS ( VariableDeclarationCS | OclExpressionCS )
			//
			case 152: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIterateExpCS(
						source,
						simpleNameCS,
						(VariableCS)dtParser.getSym(5),
						null,
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 153:  IterateExpCS ::= primaryExpCS -> iterateNameCS ( VariableDeclarationCS ; VariableDeclarationCS | OclExpressionCS )
			//
			case 153: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIterateExpCS(
						source,
						simpleNameCS,
						(VariableCS)dtParser.getSym(5),
						(VariableCS)dtParser.getSym(7),
						(OCLExpressionCS)dtParser.getSym(9)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(10)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 154:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( OclExpressionCS )
			//
			case 154: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						null,
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 155:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( VariableDeclarationCS | OclExpressionCS )
			//
			case 155: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						(VariableCS)dtParser.getSym(5),
						null,
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 156:  IteratorExpCS ::= primaryExpCS -> iteratorNameCS ( VariableDeclarationCS , VariableDeclarationCS | OclExpressionCS )
			//
			case 156: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						(VariableCS)dtParser.getSym(5),
						(VariableCS)dtParser.getSym(7),
						(OCLExpressionCS)dtParser.getSym(9)
					);
				setOffsets(result, source, getIToken(dtParser.getToken(10)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 161:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif
			//
			case 161: {
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						(OCLExpressionCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 162:  LetExpCS ::= let variableDeclarationListCS in OclExpressionCS
			//
			case 162: {
				
				OCLExpressionCS expr = (OCLExpressionCS)dtParser.getSym(4);
				CSTNode result = createLetExpCS(
						(EList)dtParser.getSym(2),
						expr
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), expr);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 167:  impliesExpCS ::= impliesExpCS implies xorExpCS
			//
			case 167:
 
			//
			// Rule 168:  impliesLetCS ::= impliesExpCS implies xorLetCS
			//
			case 168:
 
			//
			// Rule 171:  xorExpCS ::= xorExpCS xor orExpCS
			//
			case 171:
 
			//
			// Rule 172:  xorLetCS ::= xorExpCS xor orLetCS
			//
			case 172:
 
			//
			// Rule 175:  orExpCS ::= orExpCS or andExpCS
			//
			case 175:
 
			//
			// Rule 176:  orLetCS ::= orExpCS or andLetCS
			//
			case 176:
 
			//
			// Rule 179:  andExpCS ::= andExpCS and equalityExpCS
			//
			case 179:
 
			//
			// Rule 180:  andLetCS ::= andExpCS and equalityLetCS
			//
			case 180:
 
			//
			// Rule 183:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 183:
 
			//
			// Rule 184:  equalityLetCS ::= equalityExpCS = relationalLetCS
			//
			case 184:
 
			//
			// Rule 185:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 185:
 
			//
			// Rule 186:  equalityLetCS ::= equalityExpCS <> relationalLetCS
			//
			case 186:
 
			//
			// Rule 189:  relationalExpCS ::= relationalExpCS > additiveExpCS
			//
			case 189:
 
			//
			// Rule 190:  relationalLetCS ::= relationalExpCS > additiveLetCS
			//
			case 190:
 
			//
			// Rule 191:  relationalExpCS ::= relationalExpCS < additiveExpCS
			//
			case 191:
 
			//
			// Rule 192:  relationalLetCS ::= relationalExpCS < additiveLetCS
			//
			case 192:
 
			//
			// Rule 193:  relationalExpCS ::= relationalExpCS >= additiveExpCS
			//
			case 193:
 
			//
			// Rule 194:  relationalLetCS ::= relationalExpCS >= additiveLetCS
			//
			case 194:
 
			//
			// Rule 195:  relationalExpCS ::= relationalExpCS <= additiveExpCS
			//
			case 195:
 
			//
			// Rule 196:  relationalLetCS ::= relationalExpCS <= additiveLetCS
			//
			case 196:
 
			//
			// Rule 199:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 199:
 
			//
			// Rule 200:  additiveLetCS ::= additiveExpCS + multiplicativeLetCS
			//
			case 200:
 
			//
			// Rule 201:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 201:
 
			//
			// Rule 202:  additiveLetCS ::= additiveExpCS - multiplicativeLetCS
			//
			case 202:
 
			//
			// Rule 205:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 205:
 
			//
			// Rule 206:  multiplicativeLetCS ::= multiplicativeExpCS * unaryLetCS
			//
			case 206:
 
			//
			// Rule 207:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 207:
 
			//
			// Rule 208:  multiplicativeLetCS ::= multiplicativeExpCS / unaryLetCS
			//
			case 208: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(2))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				OCLExpressionCS left = (OCLExpressionCS)dtParser.getSym(1);
				OCLExpressionCS right = (OCLExpressionCS)dtParser.getSym(3);
				EList args = new BasicEList();
				args.add(right);
				CSTNode result = createOperationCallExpCS(
						left,
						simpleNameCS,
						args
					);
				setOffsets(result, left, right);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 211:  unaryExpCS ::= - unaryExpCS
			//
			case 211:
 
			//
			// Rule 212:  unaryLetCS ::= - unaryLetCS
			//
			case 212:
 
			//
			// Rule 213:  unaryExpCS ::= not unaryExpCS
			//
			case 213:
 
			//
			// Rule 214:  unaryLetCS ::= not unaryLetCS
			//
			case 214: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				OCLExpressionCS expr = (OCLExpressionCS)dtParser.getSym(2);
				CSTNode result = createOperationCallExpCS(
						expr,
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, simpleNameCS, expr);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 218:  primaryExpCS ::= ( OclExpressionCS )
			//
			case 218: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				if (result instanceof OperationCallExpCS) {
					((OperationCallExpCS)result).setIsAtomic(true);
				}
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 219:  ERROR_Colon ::= ERROR_TOKEN
			//
			case 219: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_COLON);
	  		  break;
			}
	 
			//
			// Rule 220:  ERROR_Empty ::= ERROR_TOKEN
			//
			case 220: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.EXTRA_TOKENS);
	  		  break;
			}
	 
			//
			// Rule 221:  ERROR_SimpleNameCS ::= ERROR_TOKEN
			//
			case 221: {
				
				int token = dtParser.getToken(1);
				String tokenText = getTokenText(token);
				reportErrorTokenMessage(token, OCLParserErrors.MISSING_SIMPLE_NAME);
				SimpleNameCS result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						tokenText
					);
				setOffsets(result, getIToken(token));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 223:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS ERROR_TOKEN
			//
			case 223: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RPAREN);
				CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1); 
				result.setTypeCS((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 224:  TupleLiteralExpCS ::= Tuple ERROR_TOKEN
			//
			case 224: {
				
				reportErrorTokenMessage(dtParser.getToken(7), OCLParserErrors.MISSING_LBRACE);
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 225:  TupleLiteralPartsCS ::= ERROR_TOKEN
			//
			case 225: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_VARIABLES);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 226:  AssociationClassCallExpCS ::= notReservedSimpleNameCS [ argumentsCS ERROR_TOKEN
			//
			case 226: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RBRACK);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 227:  PropertyCallExpCS ::= primaryExpCS . pathNameCS [ argumentsCS ERROR_TOKEN
			//
			case 227: {
				
				OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
				SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
				CallExpCS result = createFeatureCallExpCS(
						source,
						pathNameCS,
						simpleNameCS,
						(EList)dtParser.getSym(5),
						null
					);
				setOffsets(result, source, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 228:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS ERROR_TOKEN
			//
			case 228: {
				
				reportErrorTokenMessage(dtParser.getToken(7), OCLParserErrors.MISSING_ENDIF);
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						(OCLExpressionCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 229:  IfExpCS ::= if OclExpressionCS then OclExpressionCS ERROR_TOKEN
			//
			case 229: {
				
				reportErrorTokenMessage(dtParser.getToken(5), OCLParserErrors.MISSING_ELSE_ENDIF);
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(5)))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 230:  IfExpCS ::= if OclExpressionCS ERROR_TOKEN
			//
			case 230: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_THEN_ELSE_ENDIF);
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(3))),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(3)))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 231:  IfExpCS ::= if ERROR_TOKEN endif
			//
			case 231: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_THEN_ELSE);
				CSTNode result = createIfExpCS(
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(2))),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(2))),
						createInvalidLiteralExpCS(getTokenText(dtParser.getToken(2)))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 232:  primaryExpCS ::= ( OclExpressionCS ERROR_TOKEN
			//
			case 232: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_RPAREN);
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 233:  TopLevelCS ::= $Empty
			//
			case 233: {
				
				TopLevelCS result = QVTcCSTFactory.eINSTANCE.createTopLevelCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 234:  TopLevelCS ::= TopLevelCS MappingCS
			//
			case 234: {
				
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				MappingCS mappingCS = (MappingCS)dtParser.getSym(2);
				result.getMappings().add(mappingCS);
				setOffsets(result, result, mappingCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  TopLevelCS ::= TopLevelCS TransformationCS
			//
			case 235: {
				
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				TransformationCS transformationCS = (TransformationCS)dtParser.getSym(2);
				result.getTransformations().add(transformationCS);
				setOffsets(result, result, transformationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 236:  TopLevelCS ::= TopLevelCS QueryCS
			//
			case 236: {
				
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				QueryCS queryCS = (QueryCS)dtParser.getSym(2);
				result.getQueries().add(queryCS);
				setOffsets(result, result, queryCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 237:  TransformationCS_0_ ::= transformation TransformationNameCS {
			//
			case 237: {
				
				TransformationCS result = QVTcCSTFactory.eINSTANCE.createTransformationCS();
				result.setPathName((PathNameCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 238:  TransformationCS_0_ ::= TransformationCS_0_ DirectionCS ;
			//
			case 238: {
				
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				DirectionCS directionCS = (DirectionCS)dtParser.getSym(2);
				result.getDirections().add(directionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 239:  TransformationCS ::= TransformationCS_0_ }
			//
			case 239: {
				
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 240:  DirectionCS_0_ ::= DirectionNameCS
			//
			case 240: {
				
				IdentifierCS directionNameCS = (IdentifierCS)dtParser.getSym(1);
				DirectionCS result = QVTcCSTFactory.eINSTANCE.createDirectionCS();
				result.setIdentifier(directionNameCS);
				setOffsets(result, directionNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 243:  DirectionCS_2_ ::= DirectionCS_1_ PackageNameCS
			//
			case 243: {
				
				DirectionCS result = (DirectionCS)dtParser.getSym(1);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(2);
				result.getImports().add(pathNameCS);
				setOffsets(result, result, pathNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 248:  DirectionCS_5_ ::= DirectionCS_4_ DirectionNameCS
			//
			case 248: {
				
				DirectionCS result = (DirectionCS)dtParser.getSym(1);
				IdentifierCS directionNameCS = (IdentifierCS)dtParser.getSym(2);
				result.getUses().add(directionNameCS);
				setOffsets(result, result, directionNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 251:  MappingCS_1_ ::= map
			//
			case 251: {
				
				MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
//					IdentifierCS identifierCS = createUniqueIdentifierCS(dtParser.getToken(1));
//					result.setIdentifier(identifierCS);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 252:  MappingCS_1_ ::= map MappingNameCS
			//
			case 252: {
				
				MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(2);
				result.setIdentifier(identifierCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 254:  MappingCS_2_ ::= MappingCS_1_ in TransformationNameCS
			//
			case 254: {
				
				MappingCS result = (MappingCS)dtParser.getSym(1);
				PathNameCS identifierCS = (PathNameCS)dtParser.getSym(3);
				result.setIn(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 256:  MappingCS_3_ ::= MappingCS_2_ refines MappingNameCS
			//
			case 256: {
				
				MappingCS result = (MappingCS)dtParser.getSym(1);
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				result.getRefines().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 257:  MappingCS_3_ ::= MappingCS_3_ , MappingNameCS
			//
			case 257: {
				
				MappingCS result = (MappingCS)dtParser.getSym(1);
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				result.getRefines().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 259:  MappingCS_4_ ::= MappingCS_4_ DomainCS
			//
			case 259: {
				
				MappingCS result = (MappingCS)dtParser.getSym(1);
				DomainCS domainCS = (DomainCS)dtParser.getSym(2);
				result.getDomains().add(domainCS);
				setOffsets(result, result, domainCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 260:  MappingCS_8 ::= MappingCS_4_ where DomainCS_0_
			//
			case 260: {
				
				MappingCS result = (MappingCS)dtParser.getSym(1);
				IdentifierCS directionNameCS = QVTCSTFactory.eINSTANCE.createIdentifierCS();
				directionNameCS.setValue("");
				setOffsets(directionNameCS, getIToken(dtParser.getToken(2)));
				DomainCS domainCS = (DomainCS)dtParser.getSym(3);
				domainCS.setIdentifier(directionNameCS);
				setOffsets(domainCS, directionNameCS, domainCS);
				result.setMiddle(domainCS);
				setOffsets(result, result, domainCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 261:  MappingCS_8 ::= MappingCS_4_ where DirectionNameCS DomainCS_0_
			//
			case 261: {
				
				MappingCS result = (MappingCS)dtParser.getSym(1);
				IdentifierCS directionNameCS = (IdentifierCS)dtParser.getSym(3);
				setOffsets(directionNameCS, getIToken(dtParser.getToken(2)), directionNameCS);
				DomainCS domainCS = (DomainCS)dtParser.getSym(4);
				domainCS.setIdentifier(directionNameCS);
				setOffsets(domainCS, directionNameCS, domainCS);
				result.setMiddle(domainCS);
				setOffsets(result, result, domainCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 262:  MappingCS_8 ::= MappingCS_8 ComposedMappingCS
			//
			case 262: {
				
				MappingCS result = (MappingCS)dtParser.getSym(1);
				MappingCS composedMappingCS = (MappingCS)dtParser.getSym(2);
				result.getComposedMappings().add(composedMappingCS);
				setOffsets(result, result, composedMappingCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 263:  MappingCS ::= MappingCS_8 }
			//
			case 263: {
				
				MappingCS result = (MappingCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 264:  DomainCS_0_ ::= ( DomainGuardPatternCS ) { DomainBottomPatternCS }
			//
			case 264: {
				
				GuardPatternCS guardPatternCS = (GuardPatternCS)dtParser.getSym(2);
				BottomPatternCS bottomPatternCS = (BottomPatternCS)dtParser.getSym(5);
				DomainCS result = QVTcCSTFactory.eINSTANCE.createDomainCS();
				result.setGuardPattern(guardPatternCS);
				result.setBottomPattern(bottomPatternCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 265:  DomainCS_1_ ::= DirectionNameCS DomainCS_0_
			//
			case 265: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 267:  DomainCS_2_ ::= enforce DomainCS_1_
			//
			case 267: {
				
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setEnforce(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 269:  DomainCS ::= check DomainCS_2_
			//
			case 269: {
				
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setCheck(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 275:  GuardPatternCS_1_ ::= UnrealizedVariableCS
			//
			case 275: {
				
				GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)dtParser.getSym(1);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, unrealizedVariableCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 276:  GuardPatternCS_1_ ::= GuardPatternCS_1_ , UnrealizedVariableCS
			//
			case 276: {
				
				GuardPatternCS result = (GuardPatternCS)dtParser.getSym(1);
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)dtParser.getSym(3);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, result, unrealizedVariableCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 278:  GuardPatternCS_2_ ::= ConstraintCS ;
			//
			case 278: {
				
				GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
				OCLExpressionCS constraintCS = (OCLExpressionCS)dtParser.getSym(1);
				result.getConstraints().add(constraintCS);
				setOffsets(result, constraintCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 279:  GuardPatternCS_2_ ::= GuardPatternCS_2_ ConstraintCS ;
			//
			case 279: {
				
				GuardPatternCS result = (GuardPatternCS)dtParser.getSym(1);
				OCLExpressionCS constraintCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getConstraints().add(constraintCS);
				setOffsets(result, result, constraintCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 282:  GuardPatternCS ::= $Empty
			//
			case 282: {
				
				GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 283:  BottomPatternCS_1_ ::= UnrealizedVariableCS
			//
			case 283: {
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)dtParser.getSym(1);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, result, unrealizedVariableCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 284:  BottomPatternCS_1_ ::= BottomPatternCS_1_ , UnrealizedVariableCS
			//
			case 284: {
				
				BottomPatternCS result = (BottomPatternCS)dtParser.getSym(1);
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)dtParser.getSym(3);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, result, unrealizedVariableCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 285:  BottomPatternCS_1_ ::= RealizedVariableCS
			//
			case 285: {
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				RealizedVariableCS realizedVariableCS = (RealizedVariableCS)dtParser.getSym(1);
				result.getRealizedVariables().add(realizedVariableCS);
				setOffsets(result, realizedVariableCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 286:  BottomPatternCS_1_ ::= BottomPatternCS_1_ , RealizedVariableCS
			//
			case 286: {
				
				BottomPatternCS result = (BottomPatternCS)dtParser.getSym(1);
				RealizedVariableCS realizedVariableCS = (RealizedVariableCS)dtParser.getSym(3);
				result.getRealizedVariables().add(realizedVariableCS);
				setOffsets(result, realizedVariableCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 288:  BottomPatternCS_2_ ::= ConstraintCS ;
			//
			case 288: {
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				OCLExpressionCS constraintCS = (OCLExpressionCS)dtParser.getSym(1);
				result.getConstraints().add(constraintCS);
				setOffsets(result, constraintCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 289:  BottomPatternCS_2_ ::= EnforcementOperationCS
			//
			case 289: {
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)dtParser.getSym(1);
				result.getEnforcementOperations().add(enforcementOperationCS);
				setOffsets(result, enforcementOperationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 290:  BottomPatternCS_2_ ::= BottomPatternCS_2_ ConstraintCS ;
			//
			case 290: {
				
				BottomPatternCS result = (BottomPatternCS)dtParser.getSym(1);
				OCLExpressionCS constraintCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getConstraints().add(constraintCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 291:  BottomPatternCS_2_ ::= BottomPatternCS_2_ EnforcementOperationCS
			//
			case 291: {
				
				BottomPatternCS result = (BottomPatternCS)dtParser.getSym(1);
				EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)dtParser.getSym(2);
				result.getEnforcementOperations().add(enforcementOperationCS);
				setOffsets(result, result, enforcementOperationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 294:  BottomPatternCS ::= $Empty
			//
			case 294: {
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 295:  EnforcementOperationCS_1_ ::= primaryExpCS
			//
			case 295: {
				
				OperationCallExpCS operationCallCS = (OperationCallExpCS)dtParser.getSym(1);
				EnforcementOperationCS result = QVTcCSTFactory.eINSTANCE.createEnforcementOperationCS();
				result.setOperationCall(operationCallCS);
				setOffsets(result, operationCallCS, operationCallCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 296:  EnforcementOperationCS ::= creation EnforcementOperationCS_1_ ;
			//
			case 296: {
				
				EnforcementOperationCS result = (EnforcementOperationCS)dtParser.getSym(2);
				result.setDeletion(false);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 297:  EnforcementOperationCS ::= deletion EnforcementOperationCS_1_ ;
			//
			case 297: {
				
				EnforcementOperationCS result = (EnforcementOperationCS)dtParser.getSym(2);
				result.setDeletion(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 298:  UnrealizedVariableCS ::= VariableNameCS : typeCS
			//
			case 298: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				TypeCS type = (TypeCS)dtParser.getSym(3);
				UnrealizedVariableCS result = QVTcCSTFactory.eINSTANCE.createUnrealizedVariableCS();
				result.setIdentifier(identifierCS);
				result.setType(type);
				setOffsets(result, identifierCS, type);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 299:  RealizedVariableCS ::= realize VariableNameCS : typeCS
			//
			case 299: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(2);
				TypeCS type = (TypeCS)dtParser.getSym(4);
				RealizedVariableCS result = QVTcCSTFactory.eINSTANCE.createRealizedVariableCS();
				result.setIdentifier(identifierCS);
				result.setType(type);
				setOffsets(result, getIToken(dtParser.getToken(1)), type);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 303:  AssignmentCS_0_ ::= OclExpressionCS := OclExpressionCS
			//
			case 303: {
				
				OCLExpressionCS target = (OCLExpressionCS)dtParser.getSym(1);
				OCLExpressionCS initialiser = (OCLExpressionCS)dtParser.getSym(3);
				AssignmentCS result = QVTcCSTFactory.eINSTANCE.createAssignmentCS();
				result.setTarget(target);
				result.setInitialiser(initialiser);
				setOffsets(result, target, initialiser);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 305:  AssignmentCS ::= default AssignmentCS_0_
			//
			case 305: {
				
				AssignmentCS result = (AssignmentCS)dtParser.getSym(2);
				result.setDefault(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 314:  QueryCS_preParamDeclaration ::= query QueryNameCS (
			//
			case 314: {
				
				QueryCS result = QVTcCSTFactory.eINSTANCE.createQueryCS();
				result.setPathName((PathNameCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 316:  QueryCS_postParamDeclaration ::= QueryCS_preParamDeclaration paramDeclarationCS
			//
			case 316: {
				
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)dtParser.getSym(2);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.getInputParamDeclaration().add(paramDeclarationCS);
				setOffsets(result, result, paramDeclarationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 317:  QueryCS_postType ::= QueryCS_postParamDeclaration ) : typeCS
			//
			case 317: {
				
				TypeCS typeCS = (TypeCS)dtParser.getSym(4);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setType(typeCS);
				setOffsets(result, result, typeCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 318:  QueryCS ::= QueryCS_postType ;
			//
			case 318: {
				
				QueryCS result = (QueryCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 319:  QueryCS ::= QueryCS_postType { OclExpressionCS }
			//
			case 319: {
				
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setOclExpression((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 320:  paramDeclarationCS ::= ERROR_identifierCS : typeCS
			//
			case 320:
 
			//
			// Rule 321:  paramDeclarationCS ::= identifierCS : typeCS
			//
			case 321: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				TypeCS typeCS = (TypeCS)dtParser.getSym(3);
				ParamDeclarationCS result = QVTcCSTFactory.eINSTANCE.createParamDeclarationCS();
				result.setIdentifier(identifierCS);
				result.setType(typeCS);
				setOffsets(result, identifierCS, typeCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 322:  paramDeclarationCS ::= identifierCS ERROR_Colon
			//
			case 322: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				ParamDeclarationCS result = QVTcCSTFactory.eINSTANCE.createParamDeclarationCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 334:  ERROR_identifierCS ::= ERROR_TOKEN
			//
			case 334: {
				
				int token = dtParser.getToken(1);
				reportErrorTokenMessage(token, QVTcParserErrors.MISSING_IDENTIFIER);
				IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
				result.setValue(getTokenText(token));
				setOffsets(result, getIToken(token));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 335:  identifierCS ::= IDENTIFIER
			//
			case 335: {
				
				int token = dtParser.getToken(1);
				IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
				result.setValue(getTokenText(token));
				setOffsets(result, getIToken(token));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 336:  identifierCS ::= STRING_LITERAL
			//
			case 336: {
				
				int token = dtParser.getToken(1);
				IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
				String string = getTokenText(token);
				result.setValue(string.substring(1, string.length()-1));
				setOffsets(result, getIToken(token));
				dtParser.setSym1(result);
	  		  break;
			}
	
	
			default:
				break;
		}
		return;
	}
}

