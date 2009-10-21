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
*   E.D.Willink - Extended API and implementation for QVTr
*
* </copyright>
*
* $Id: QVTrParser.java,v 1.13 2009/10/21 07:49:03 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

import org.eclipse.qvt.declarative.parser.qvt.cst.*;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.*;
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

public class QVTrParser extends AbstractOCLParser implements RuleAction
{
	protected static ParseTable prs = new QVTrParserprs();
	private BacktrackingParser dtParser;

	public QVTrParser(QVTrLexer lexer) {
		super(lexer);
	}

	public int getEOFTokenKind() { return QVTrParserprs.EOFT_SYMBOL; }

	public ICSTFileEnvironment getOCLEnvironment() {
		return getLexer().getOCLEnvironment();
	}
	
	@Override 
	public QVTrLexer getLexer() {
		return (QVTrLexer)super.getLexer();
	}

	public String getTokenKindName(int kind) { return QVTrParsersym.orderedTerminalSymbols[kind]; }			

	@Override
	public String[] orderedTerminalSymbols() { return QVTrParsersym.orderedTerminalSymbols; }
		
	@SuppressWarnings("nls")
	@Override
	public CSTNode parseTokensToCST(Monitor monitor, int error_repair_count) {
		ParseTable prsTable = new QVTrParserprs();

		try {
			dtParser = new BacktrackingParser(monitor, this, prsTable, this);
		}
		catch (NotBacktrackParseTableException e) {
            throw new RuntimeException("****Error: Regenerate QVTrParserprs.java with -BACKTRACK option");
		}
		catch (BadParseSymFileException e) {
			throw new RuntimeException("****Error: Bad Parser Symbol File -- QVTrParsersym.java. Regenerate QVTrParserprs.java");
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
			// Rule 233:  topLevelCS_0_ ::= $Empty
			//
			case 233: {
				
				TopLevelCS result = QVTrCSTFactory.eINSTANCE.createTopLevelCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 234:  topLevelCS_0_ ::= topLevelCS_0_ import unitCS ;
			//
			case 234: {
				
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				result.getImportClause().add((UnitCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  topLevelCS_0_ ::= topLevelCS_0_ ERROR_TOKEN
			//
			case 235: {
				
				// TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_TOPLEVEL);
	  		  break;
			}
	 
			//
			// Rule 236:  topLevelCS_1_ ::= topLevelCS transformationCS
			//
			case 236: {
				
				TransformationCS transformationCS = (TransformationCS)dtParser.getSym(2);
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				result.getTransformation().add(transformationCS);
				setOffsets(result, result, transformationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 237:  topLevelCS_1_ ::= topLevelCS_1_ ERROR_TOKEN
			//
			case 237: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION);
	  		  break;
			}
	 
			//
			// Rule 240:  unitCS ::= identifierCS
			//
			case 240: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				UnitCS result = QVTrCSTFactory.eINSTANCE.createUnitCS();
				result.getIdentifier().add(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 241:  unitCS ::= unitCS . identifierCS
			//
			case 241: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				UnitCS result = (UnitCS)dtParser.getSym(1);
				result.getIdentifier().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 242:  transformationCS_0_ ::= transformation identifierCS ( modelDeclCS
			//
			case 242: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(2);
				ModelDeclCS modelDeclCS = (ModelDeclCS)dtParser.getSym(4);
				TransformationCS result = QVTrCSTFactory.eINSTANCE.createTransformationCS();
				result.setIdentifier(identifierCS);
				result.getModelDecl().add(modelDeclCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), modelDeclCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 243:  transformationCS_0_ ::= transformationCS_0_ , modelDeclCS
			//
			case 243: {
				
				ModelDeclCS modelDeclCS = (ModelDeclCS)dtParser.getSym(3);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getModelDecl().add(modelDeclCS);
				setOffsets(result, result, modelDeclCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 244:  transformationCS_0_ ::= transformationCS_0_ ERROR_TOKEN
			//
			case 244: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL);
	  		  break;
			}
	 
			//
			// Rule 245:  transformationCS_1_ ::= transformationCS_0_ )
			//
			case 245: {
				
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 247:  transformationCS_2_ ::= transformationCS_1_ extends identifierCS
			//
			case 247: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.setExtends(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 249:  transformationCS_3_ ::= transformationCS_3_ keyDeclCS
			//
			case 249: {
				
				KeyDeclCS keyDeclCS = (KeyDeclCS)dtParser.getSym(2);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getKeyDecl().add(keyDeclCS);
				setOffsets(result, result, keyDeclCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 251:  transformationCS_4_ ::= transformationCS_4_ queryCS
			//
			case 251: {
				
				QueryCS queryCS =(QueryCS)dtParser.getSym(2);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getQuery().add(queryCS);
				setOffsets(result, result, queryCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 252:  transformationCS_4_ ::= transformationCS_4_ relationCS
			//
			case 252: {
				
				RelationCS relationCS = (RelationCS)dtParser.getSym(2);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getRelation().add(relationCS);
				setOffsets(result, result, relationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 253:  transformationCS_4_ ::= transformationCS_4_ ERROR_TOKEN
			//
			case 253: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION_ELEMENT);
	  		  break;
			}
	 
			//
			// Rule 254:  transformationCS ::= transformationCS_4_ }
			//
			case 254: {
				
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 255:  modelDeclCS_0_ ::= modelIdCS :
			//
			case 255: {
				
				IdentifierCS modelIdCS = (IdentifierCS)dtParser.getSym(1);
				ModelDeclCS result = QVTrCSTFactory.eINSTANCE.createModelDeclCS();
				result.setModelId(modelIdCS);
				setOffsets(result, modelIdCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 258:  modelDeclCS_2_ ::= modelDeclCS_1_ metaModelIdCS
			//
			case 258: 
 
			//
			// Rule 259:  modelDeclCS ::= modelDeclCS_0_ metaModelIdCS
			//
			case 259: {
				
				IdentifierCS metaModelIdCS = (IdentifierCS)dtParser.getSym(2);
				ModelDeclCS result = (ModelDeclCS)dtParser.getSym(1);
				result.getMetaModelId().add(metaModelIdCS);
				setOffsets(result, result, metaModelIdCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 260:  modelDeclCS_2_ ::= modelDeclCS_1_ ERROR_TOKEN
			//
			case 260: 
 
			//
			// Rule 261:  modelDeclCS ::= modelDeclCS_0_ ERROR_TOKEN
			//
			case 261: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL_ELEMENT);
	  		  break;
			}
	 
			//
			// Rule 262:  modelDeclCS ::= modelDeclCS_2_ }
			//
			case 262: {
				
				ModelDeclCS result = (ModelDeclCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 265:  keyDeclCS_0_ ::= key classIdCS {
			//
			case 265: {
				
				PathNameCS classIdCS = (PathNameCS)dtParser.getSym(2);
				KeyDeclCS result = QVTrCSTFactory.eINSTANCE.createKeyDeclCS();
				result.setClassId(classIdCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 267:  keyDeclCS_1_ ::= keyDeclCS_0_ propertyIdCS
			//
			case 267: {
				
				IdentifiedCS propertyIdCS = (IdentifiedCS)dtParser.getSym(2);
				KeyDeclCS result = (KeyDeclCS)dtParser.getSym(1);
				result.getPropertyId().add(propertyIdCS);
				setOffsets(result, result, propertyIdCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 268:  keyDeclCS_1_ ::= keyDeclCS_0_ ERROR_TOKEN
			//
			case 268: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_KEYDECL_ELEMENT);
	  		  break;
			}
	 
			//
			// Rule 269:  keyDeclCS ::= keyDeclCS_1_ } ;
			//
			case 269: {
				
				KeyDeclCS result = (KeyDeclCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 271:  propertyIdCS ::= identifierCS
			//
			case 271: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 272:  relationCS_withName ::= relation identifierCS
			//
			case 272: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(2);
				RelationCS result = QVTrCSTFactory.eINSTANCE.createRelationCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 274:  relationCS_postName ::= top relationCS_withName
			//
			case 274: {
				
				RelationCS result = (RelationCS)dtParser.getSym(2);
				result.setTop(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 276:  relationCS_postOverrides ::= relationCS_postName overrides identifierCS
			//
			case 276: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				RelationCS result = (RelationCS)dtParser.getSym(1);
				result.setOverrides(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 278:  relationCS_postVariable ::= relationCS_postVariable varDeclarationCS
			//
			case 278: {
				
				VarDeclarationCS varDeclarationCS = (VarDeclarationCS)dtParser.getSym(2);
				RelationCS result = (RelationCS)dtParser.getSym(1);
				result.getVarDeclaration().add(varDeclarationCS);
				setOffsets(result, result, varDeclarationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 279:  relationCS_postDomain ::= relationCS_postVariable domainCS
			//
			case 279: 
 
			//
			// Rule 280:  relationCS_postDomain ::= relationCS_postDomain domainCS
			//
			case 280: {
				
				AbstractDomainCS domainCS = (AbstractDomainCS)dtParser.getSym(2);
				RelationCS result = (RelationCS)dtParser.getSym(1);
				result.getDomain().add(domainCS);
				setOffsets(result, result, domainCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 282:  relationCS_postWhen ::= relationCS_postDomain whenCS
			//
			case 282: {
				
				RelationCS result = (RelationCS)dtParser.getSym(1);
				WhenCS whenCS = (WhenCS)dtParser.getSym(2);
				result.setWhen(whenCS);
				setOffsets(result, result, whenCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 284:  relationCS_postWhere ::= relationCS_postWhen whereCS
			//
			case 284: {
				
				RelationCS result = (RelationCS)dtParser.getSym(1);
				WhereCS whereCS = (WhereCS)dtParser.getSym(2);
				result.setWhere(whereCS);
				setOffsets(result, result, whereCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 285:  relationCS ::= relationCS_postWhere }
			//
			case 285: {
				
				RelationCS result = (RelationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 286:  whenCS_0 ::= when {
			//
			case 286: {
				
				WhenCS result = QVTrCSTFactory.eINSTANCE.createWhenCS();
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 287:  whenCS_0 ::= when ERROR_TOKEN
			//
			case 287: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_WHEN);
	  		  break;
			}
	 
			//
			// Rule 289:  whenCS_1 ::= whenCS_1 OclExpressionCS ;
			//
			case 289: {
				
				WhenCS result = (WhenCS)dtParser.getSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getExpr().add(OclExpressionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 290:  whenCS ::= whenCS_1 }
			//
			case 290: {
				
				WhenCS result = (WhenCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 291:  whereCS_0 ::= where {
			//
			case 291: {
				
				WhereCS result = QVTrCSTFactory.eINSTANCE.createWhereCS();
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 292:  whereCS_0 ::= where ERROR_TOKEN
			//
			case 292: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_WHERE);
	  		  break;
			}
	 
			//
			// Rule 294:  whereCS_1 ::= whereCS_1 OclExpressionCS ;
			//
			case 294: {
				
				WhereCS result = (WhereCS)dtParser.getSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getExpr().add(OclExpressionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 295:  whereCS ::= whereCS_1 }
			//
			case 295: {
				
				WhereCS result = (WhereCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 296:  varDeclarationCS_0 ::= identifierCS
			//
			case 296: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				VarDeclarationCS result = QVTrCSTFactory.eINSTANCE.createVarDeclarationCS();
				result.getVarDeclarationId().add(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 297:  varDeclarationCS_0 ::= varDeclarationCS_0 , identifierCS
			//
			case 297: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				VarDeclarationCS result = (VarDeclarationCS)dtParser.getSym(1);
				result.getVarDeclarationId().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 298:  varDeclarationCS ::= varDeclarationCS_0 : typeCS ;
			//
			case 298: {
				
				VarDeclarationCS result = (VarDeclarationCS)dtParser.getSym(1);
				result.setType((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 299:  domainCS_0_ ::= domain modelIdCS templateCS
			//
			case 299: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(2);
				TemplateCS templateCS = (TemplateCS)dtParser.getSym(3);
				DomainCS result = QVTrCSTFactory.eINSTANCE.createDomainCS();
				result.setModelId(identifierCS);
				result.setTemplate(templateCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), templateCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 301:  domainCS_1_ ::= checkonly domainCS_0_
			//
			case 301: {
				
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setCheckonly(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 302:  domainCS_1_ ::= enforce domainCS_0_
			//
			case 302: {
				
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setEnforce(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 303:  domainCS_1_ ::= replace domainCS_0_
			//
			case 303: {
				
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setReplace(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 305:  domainCS_postImplementedby ::= domainCS_1_ implementedby OperationCallExpCS
			//
			case 305: {
				
				DomainCS result = (DomainCS)dtParser.getSym(1);
				OperationCallExpCS operationCallExpCS =(OperationCallExpCS)dtParser.getSym(3);
				result.setImplementedBy(operationCallExpCS);
				setOffsets(result, result, operationCallExpCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 307:  domainCS_preDefaultValue ::= domainCS_preDefaultValue defaultValueCS
			//
			case 307: {
				
				DomainCS result = (DomainCS)dtParser.getSym(1);
				DefaultValueCS defaultValueCS = (DefaultValueCS)dtParser.getSym(2);
				result.getDefaultValue().add(defaultValueCS);
				setOffsets(result, result, defaultValueCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 309:  domainCS_postDefaultValues ::= domainCS_preDefaultValue }
			//
			case 309: {
				
				DomainCS result = (DomainCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 310:  domainCS ::= domainCS_postDefaultValues ;
			//
			case 310: {
				
				DomainCS result = (DomainCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 311:  domainCS ::= primitive domain identifierCS : typeCS ;
			//
			case 311: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				TypeCS typeCS = (TypeCS)dtParser.getSym(5);
				PrimitiveTypeDomainCS result = QVTrCSTFactory.eINSTANCE.createPrimitiveTypeDomainCS();
				result.setIdentifier(identifierCS);
				result.setType(typeCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 315:  templateCS ::= templateCS_0_ { OclExpressionCS }
			//
			case 315: {
				
				TemplateCS result = (TemplateCS)dtParser.getSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)dtParser.getSym(3);
				result.setGuardExpression(OclExpressionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 318:  notCollectionTypeCS ::= notReservedSimpleNameCS
			//
			case 318: {
				
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
			// Rule 319:  objectTemplateCS_prePropertyTemplates ::= notLiteralNorReservedSimpleNameCS : notCollectionTypeCS {
			//
			case 319: {
				
				IdentifierCS identifierCS = createIdentifierCS(dtParser.getToken(1));
				TypeCS typeCS = (TypeCS)dtParser.getSym(3);
				ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
				result.setType(typeCS);
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 320:  objectTemplateCS_prePropertyTemplates ::= : pathNameCS {
			//
			case 320: {
				
				ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
				result.setIdentifier(createUniqueIdentifierCS(dtParser.getToken(1)));
				result.setType((TypeCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 323:  objectTemplateCS_postPropertyTemplate ::= objectTemplateCS_prePropertyTemplate propertyTemplateCS
			//
			case 323: {
				
				ObjectTemplateCS result = (ObjectTemplateCS)dtParser.getSym(1);
				PropertyTemplateCS propertyTemplateCS = (PropertyTemplateCS)dtParser.getSym(2);
				result.getPropertyTemplate().add(propertyTemplateCS);
				setOffsets(result, result, propertyTemplateCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 324:  objectTemplateCS ::= objectTemplateCS_prePropertyTemplates }
			//
			case 324:
 
			//
			// Rule 325:  objectTemplateCS ::= objectTemplateCS_postPropertyTemplate }
			//
			case 325: {
				
				ObjectTemplateCS result = (ObjectTemplateCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 326:  propertyTemplateCS ::= propertyIdCS = OclExpressionCS
			//
			case 326: {
				
				IdentifiedCS propertyIdCS = (IdentifiedCS)dtParser.getSym(1);
				PropertyTemplateCS result = QVTrCSTFactory.eINSTANCE.createPropertyTemplateCS();
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)dtParser.getSym(3);
				result.setPropertyId(propertyIdCS);
				result.setOclExpression(OclExpressionCS);
				setOffsets(result, propertyIdCS, OclExpressionCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 327:  collectionTemplateCS_1_ ::= : collectionTypeCS
			//
			case 327: {
				
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)dtParser.getSym(2);
				CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
				result.setType(collectionTypeCS);
				result.setIdentifier(createUniqueIdentifierCS(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)), collectionTypeCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 328:  collectionTemplateCS_1_ ::= notLiteralNorReservedSimpleNameCS : collectionTypeCS
			//
			case 328: {
				
				IdentifierCS identifierCS = createIdentifierCS(dtParser.getToken(1));
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)dtParser.getSym(3);
				CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
				result.setType(collectionTypeCS);
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, collectionTypeCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 332:  collectionTemplateCS_postMemberSelection ::= collectionTemplateCS_preMemberSelection memberSelectorCS
			//
			case 332: {
				
				IdentifiedCS memberSelectorCS = (IdentifiedCS)dtParser.getSym(2);
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				result.getMemberIdentifier().add(memberSelectorCS);
				setOffsets(result, result, memberSelectorCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 333:  collectionTemplateCS ::= collectionTemplateCS_postMemberSelection PLUS_PLUS identifierCS }
			//
			case 333: {
				
				IdentifierCS restIdentifier = (IdentifierCS)dtParser.getSym(3);
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				result.setRestIdentifier(restIdentifier);
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 334:  collectionTemplateCS ::= collectionTemplateCS_postMemberSelection ERROR_TOKEN }
			//
			case 334: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_REST);
				IdentifierCS restIdentifier = createUniqueIdentifierCS(dtParser.getToken(2));
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				result.setRestIdentifier(restIdentifier);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 335:  collectionTemplateCS ::= collectionTemplateCS_preMemberSelections }
			//
			case 335: {
				
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 336:  memberSelectorCS ::= identifierCS
			//
			case 336: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 338:  defaultValueCS ::= identifierCS = OclExpressionCS ;
			//
			case 338: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)dtParser.getSym(3);
				DefaultValueCS result = QVTrCSTFactory.eINSTANCE.createDefaultValueCS();
				result.setIdentifier(identifierCS);
				result.setInitialiser(OclExpressionCS);
				setOffsets(result, identifierCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 339:  queryCS_preParamDeclaration ::= query pathNameCS (
			//
			case 339: {
				
				QueryCS result = QVTrCSTFactory.eINSTANCE.createQueryCS();
				result.setPathName((PathNameCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 341:  queryCS_postParamDeclaration ::= queryCS_preParamDeclaration paramDeclarationCS
			//
			case 341: {
				
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)dtParser.getSym(2);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.getInputParamDeclaration().add(paramDeclarationCS);
				setOffsets(result, result, paramDeclarationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 342:  queryCS_postType ::= queryCS_postParamDeclaration ) : typeCS
			//
			case 342: {
				
				TypeCS typeCS = (TypeCS)dtParser.getSym(4);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setType(typeCS);
				setOffsets(result, result, typeCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 343:  queryCS ::= queryCS_postType ;
			//
			case 343: {
				
				QueryCS result = (QueryCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 344:  queryCS ::= queryCS_postType { OclExpressionCS }
			//
			case 344: {
				
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setOclExpression((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 345:  paramDeclarationCS ::= identifierCS : typeCS
			//
			case 345: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				TypeCS typeCS = (TypeCS)dtParser.getSym(3);
				ParamDeclarationCS result = QVTrCSTFactory.eINSTANCE.createParamDeclarationCS();
				result.setIdentifier(identifierCS);
				result.setType(typeCS);
				setOffsets(result, identifierCS, typeCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 346:  paramDeclarationCS ::= identifierCS ERROR_TOKEN
			//
			case 346: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_PARAM_DECLARATION);
	  		  break;
			}
	 
			//
			// Rule 366:  identifierCS ::= IDENTIFIER
			//
			case 366: 
 
			//
			// Rule 367:  identifierCS ::= relationIdentifier
			//
			case 367: 
 
			//
			// Rule 368:  identifierCS ::= self
			//
			case 368: {
				
				IdentifierCS result = createIdentifierCS(dtParser.getToken(1));
				dtParser.setSym1(result);
	  		  break;
			}
	
	
			default:
				break;
		}
		return;
	}
}

