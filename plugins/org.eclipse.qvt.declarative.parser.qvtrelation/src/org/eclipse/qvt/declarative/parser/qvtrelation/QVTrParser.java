/**
* <copyright>
*
* Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 225493, 243976
*   Zeligsoft - Bug 243976
*   E.D.Willink - Extended API and implementation for QVTr
*
* </copyright>
*
* $Id: QVTrParser.java,v 1.10 2008/12/30 12:54:05 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

import org.eclipse.qvt.declarative.parser.qvt.cst.*;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.*;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.parser.AbstractOCLParser;
import org.eclipse.ocl.parser.backtracking.OCLParserErrors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StateExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

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
			// Rule 46:  binaryName ::= binaryIdentifier
			//
			case 46:
 
			//
			// Rule 47:  keywordAsName ::= keywordAsIdentifier
			//
			case 47:
 
			//
			// Rule 48:  keywordAsName1 ::= keywordAsIdentifier1
			//
			case 48:
 
			//
			// Rule 49:  unaryName ::= unaryIdentifier
			//
			case 49: {
				
				SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 50:  iterateName ::= iterate
			//
			case 50:
 
			//
			// Rule 51:  iteratorName ::= iteratorIdentifier
			//
			case 51:
 
			//
			// Rule 52:  oclIsInStateName ::= oclIsInState
			//
			case 52: {
				
				SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 55:  operationCS1 ::= IDENTIFIER ( parametersCSopt ) : typeCSopt
			//
			case 55: {
				
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						(EList)dtParser.getSym(3),
						(TypeCS)dtParser.getSym(6)
					);
				if (dtParser.getSym(6) != null) {
					setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(6));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 56:  operationCS2 ::= pathNameCS :: simpleNameCS ( parametersCSopt ) : typeCSopt
			//
			case 56: {
				
				CSTNode result = createOperationCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5),
						(TypeCS)dtParser.getSym(8)
					);
				if (dtParser.getSym(8) != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(8));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(7)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 57:  parametersCSopt ::= $Empty
			//
			case 57:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 59:  parametersCS ::= variableCS
			//
			case 59: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 60:  parametersCS ::= parametersCS , variableCS
			//
			case 60: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 61:  simpleNameCSopt ::= $Empty
			//
			case 61:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 67:  impliesExpCS ::= impliesExpCS implies andOrXorExpCS
			//
			case 67:
 
			//
			// Rule 68:  impliesWithLet ::= impliesExpCS implies andOrXorWithLet
			//
			case 68:
 
			//
			// Rule 71:  andOrXorExpCS ::= andOrXorExpCS and equalityExpCS
			//
			case 71:
 
			//
			// Rule 72:  andOrXorExpCS ::= andOrXorExpCS or equalityExpCS
			//
			case 72:
 
			//
			// Rule 73:  andOrXorExpCS ::= andOrXorExpCS xor equalityExpCS
			//
			case 73:
 
			//
			// Rule 74:  andOrXorWithLet ::= andOrXorExpCS and equalityWithLet
			//
			case 74:
 
			//
			// Rule 75:  andOrXorWithLet ::= andOrXorExpCS or equalityWithLet
			//
			case 75:
 
			//
			// Rule 76:  andOrXorWithLet ::= andOrXorExpCS xor equalityWithLet
			//
			case 76: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(2))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 79:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 79:
 
			//
			// Rule 80:  equalityWithLet ::= equalityExpCS = relationalWithLet
			//
			case 80: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 81:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 81:
 
			//
			// Rule 82:  equalityWithLet ::= equalityExpCS <> relationalWithLet
			//
			case 82: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 85:  relationalExpCS ::= relationalExpCS > ifExpCSPrec
			//
			case 85:
 
			//
			// Rule 86:  relationalWithLet ::= relationalExpCS > additiveWithLet
			//
			case 86: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 87:  relationalExpCS ::= relationalExpCS < ifExpCSPrec
			//
			case 87:
 
			//
			// Rule 88:  relationalWithLet ::= relationalExpCS < additiveWithLet
			//
			case 88: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 89:  relationalExpCS ::= relationalExpCS >= ifExpCSPrec
			//
			case 89:
 
			//
			// Rule 90:  relationalWithLet ::= relationalExpCS >= additiveWithLet
			//
			case 90: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 91:  relationalExpCS ::= relationalExpCS <= ifExpCSPrec
			//
			case 91:
 
			//
			// Rule 92:  relationalWithLet ::= relationalExpCS <= additiveWithLet
			//
			case 92: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 97:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 97:
 
			//
			// Rule 98:  additiveWithLet ::= additiveExpCS + multiplicativeWithLet
			//
			case 98: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.PLUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 99:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 99:
 
			//
			// Rule 100:  additiveWithLet ::= additiveExpCS - multiplicativeWithLet
			//
			case 100: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 103:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 103:
 
			//
			// Rule 104:  multiplicativeWithLet ::= multiplicativeExpCS * unaryWithLet
			//
			case 104: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.TIMES)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 105:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 105:
 
			//
			// Rule 106:  multiplicativeWithLet ::= multiplicativeExpCS / unaryWithLet
			//
			case 106: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.DIVIDE)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 109:  unaryExpCS ::= - unaryExpCS
			//
			case 109: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 110:  unaryExpCS ::= not unaryExpCS
			//
			case 110: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 112:  dotArrowExpCS ::= dotArrowExpCS callExpCS
			//
			case 112: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 113:  dotArrowExpCS ::= dotArrowExpCS messageExpCS
			//
			case 113: {
				
				MessageExpCS result = (MessageExpCS)dtParser.getSym(2);
				result.setTarget((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 114:  dotArrowExpCS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 114: {
				
				// NUMERIC_OPERATION -> Integer '.' Identifier
				String text = getTokenText(dtParser.getToken(1));
				int index = text.indexOf('.');
				String integer = text.substring(0, index);
				String simpleName = text.substring(index + 1);

				// create the IntegerLiteralExpCS
				IToken numericToken = getIToken(dtParser.getToken(1));
				int startOffset = numericToken.getStartOffset();
				int endOffset = startOffset + integer.length() - 1; // inclusive

				IntegerLiteralExpCS integerLiteralExpCS = createIntegerLiteralExpCS(integer);
				integerLiteralExpCS.setStartOffset(startOffset);
				integerLiteralExpCS.setEndOffset(endOffset);
				integerLiteralExpCS.setStartToken(numericToken);
				integerLiteralExpCS.setEndToken(numericToken);

				startOffset = endOffset + 2; // end of integerLiteral + 1('.') + 1(start of simpleName)
				endOffset = getIToken(dtParser.getToken(1)).getEndOffset();

				// create the SimpleNameCS
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							simpleName
						);
				simpleNameCS.setStartOffset(startOffset);
				simpleNameCS.setEndOffset(endOffset);
				simpleNameCS.setStartToken(numericToken);
				simpleNameCS.setEndToken(numericToken);

				// create the OperationCallExpCS
				CSTNode result = createOperationCallExpCS(
						integerLiteralExpCS,
						simpleNameCS,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 115:  dotArrowExpCS ::= pathNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 115: {
				
				OperationCallExpCS result = createOperationCallExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(6)));
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 120:  oclExpCS ::= ( oclExpressionCS )
			//
			case 120: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 121:  variableExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 121:
 
			//
			// Rule 122:  variableExpCS ::= keywordAsName1 isMarkedPreCS
			//
			case 122: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 123:  variableExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 123:
 
			//
			// Rule 124:  variableExpCS ::= keywordAsName1 [ argumentsCS ] isMarkedPreCS
			//
			case 124: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 126:  simpleNameCS ::= self
			//
			case 126: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 127:  simpleNameCS ::= IDENTIFIER
			//
			case 127: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 128:  primitiveTypeCS ::= Integer
			//
			case 128: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 129:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 129: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 130:  primitiveTypeCS ::= String
			//
			case 130: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 131:  primitiveTypeCS ::= Real
			//
			case 131: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 132:  primitiveTypeCS ::= Boolean
			//
			case 132: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 133:  primitiveTypeCS ::= OclAny
			//
			case 133: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  primitiveTypeCS ::= OclVoid
			//
			case 134: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 135:  primitiveTypeCS ::= Invalid
			//
			case 135: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 136:  primitiveTypeCS ::= OclMessage
			//
			case 136: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 137:  pathNameCS ::= IDENTIFIER
			//
			case 137: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 138:  pathNameCS ::= pathNameCS :: simpleNameCS
			//
			case 138: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 139:  pathNameCSOpt ::= $Empty
			//
			case 139: {
				
				CSTNode result = createPathNameCS();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 147:  enumLiteralExpCS ::= pathNameCS :: keywordAsName
			//
			case 147:
 
			//
			// Rule 148:  enumLiteralExpCS ::= pathNameCS :: simpleNameCS
			//
			case 148: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 149:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 149: {
				
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionLiteralExpCS(
						(CollectionTypeIdentifierEnum)objs[1],
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 150:  collectionTypeIdentifierCS ::= Set
			//
			case 150: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 151:  collectionTypeIdentifierCS ::= Bag
			//
			case 151: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 152:  collectionTypeIdentifierCS ::= Sequence
			//
			case 152: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 153:  collectionTypeIdentifierCS ::= Collection
			//
			case 153: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 154:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 154: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 155:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 155:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 157:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 157: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 158:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 158: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 160:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 160: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 161:  collectionRangeCS ::= - INTEGER_RANGE_START oclExpressionCS
			//
			case 161: {
				
				OCLExpressionCS rangeStart = createRangeStart(
						getTokenText(dtParser.getToken(2)), true);
				CSTNode result = createCollectionRangeCS(
						rangeStart,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, rangeStart, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 162:  collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
			//
			case 162: {
				
				OCLExpressionCS rangeStart = createRangeStart(
						getTokenText(dtParser.getToken(1)), false);
				CSTNode result = createCollectionRangeCS(
						rangeStart,
						(OCLExpressionCS)dtParser.getSym(2)
					);
				setOffsets(result, rangeStart, (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 163:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 163: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 169:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 169: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 170:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 170: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 171:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 171: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 172:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 172: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 173:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 173: {
				
				CSTNode result = createStringLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 174:  booleanLiteralExpCS ::= true
			//
			case 174: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 175:  booleanLiteralExpCS ::= false
			//
			case 175: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 176:  nullLiteralExpCS ::= null
			//
			case 176: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 177:  invalidLiteralExpCS ::= OclInvalid
			//
			case 177: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 178:  callExpCS ::= -> featureCallExpCS
			//
			case 178:
 
			//
			// Rule 179:  callExpCS ::= -> loopExpCS
			//
			case 179: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 180:  callExpCS ::= . keywordOperationCallExpCS
			//
			case 180:
 
			//
			// Rule 181:  callExpCS ::= . featureCallExpCS
			//
			case 181: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 184:  iteratorExpCS ::= iteratorName ( oclExpressionCS )
			//
			case 184: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						null,
						null,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 185:  iteratorExpCS ::= iteratorName ( variableCS | oclExpressionCS )
			//
			case 185: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 186:  iteratorExpCS ::= iteratorName ( variableCS , variableCS | oclExpressionCS )
			//
			case 186: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						(VariableCS)dtParser.getSym(5),
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 187:  iterateExpCS ::= iterateName ( variableCS | oclExpressionCS )
			//
			case 187: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 188:  iterateExpCS ::= iterateName ( variableCS ; variableCS | oclExpressionCS )
			//
			case 188: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						(VariableCS)dtParser.getSym(5),
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 189:  variableCS ::= IDENTIFIER
			//
			case 189: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 190:  typedVariableCS ::= IDENTIFIER : typeCS
			//
			case 190: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 192:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 192: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 193:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 193: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 194:  typeCSopt ::= $Empty
			//
			case 194:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 200:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 200: {
				
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionTypeCS(
						(CollectionTypeIdentifierEnum)objs[1],
						(TypeCS)dtParser.getSym(3)
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 201:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 201: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 202:  variableListCSopt ::= $Empty
			//
			case 202:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 204:  variableListCS ::= variableCS
			//
			case 204: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 205:  variableListCS ::= variableListCS , variableCS
			//
			case 205: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 206:  variableListCS2 ::= variableCS2
			//
			case 206:
 
			//
			// Rule 207:  variableListCS2 ::= variableCS
			//
			case 207: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 208:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 208:
 
			//
			// Rule 209:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 209: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 212:  featureCallExpCS ::= unaryName isMarkedPreCS ( argumentsCSopt )
			//
			case 212:
 
			//
			// Rule 213:  operationCallExpCS ::= binaryName isMarkedPreCS ( argumentsCSopt )
			//
			case 213:
 
			//
			// Rule 214:  keywordOperationCallExpCS ::= keywordAsName isMarkedPreCS ( argumentsCSopt )
			//
			case 214: {
				
				CSTNode result = createOperationCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 215:  stateExpCS ::= pathNameCSOpt
			//
			case 215: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				StateExpCS result = createStateExpCS(pathNameCS);
				setOffsets(result, pathNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 216:  operationCallExpCS ::= oclIsInStateName isMarkedPreCS ( stateExpCS )
			//
			case 216: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(StateExpCS)dtParser.getSym(4)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 217:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 217:
 
			//
			// Rule 218:  attrOrNavCallExpCS ::= keywordAsName isMarkedPreCS
			//
			case 218: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 219:  attrOrNavCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 219: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 220:  isMarkedPreCS ::= $Empty
			//
			case 220: {
				
				CSTNode result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 221:  isMarkedPreCS ::= @pre
			//
			case 221: {
				
				CSTNode result = createIsMarkedPreCS(true);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 222:  argumentsCSopt ::= $Empty
			//
			case 222:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 224:  argumentsCS ::= oclExpressionCS
			//
			case 224: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 225:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 225: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 226:  letExpCS ::= let variableListCS in oclExpressionCS
			//
			case 226: {
				
				CSTNode result = createLetExpCS(
						(EList)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(4));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 227:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS endif
			//
			case 227: {
				
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
			// Rule 228:  messageExpCS ::= ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 228:
 
			//
			// Rule 229:  messageExpCS ::= ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 229: {
				
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == QVTrParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(2),
						(EList<OCLMessageArgCS>)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 230:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 230:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 232:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 232: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 233:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 233: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 234:  oclMessageArgCS ::= oclExpressionCS
			//
			case 234: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 235:  oclMessageArgCS ::= ?
			//
			case 235: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 236:  oclMessageArgCS ::= ? : typeCS
			//
			case 236: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 237:  ERROR_Colon ::= ERROR_TOKEN
			//
			case 237: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_COLON);
	  		  break;
			}
	 
			//
			// Rule 238:  ERROR_Empty ::= ERROR_TOKEN
			//
			case 238: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.EXTRA_TOKENS);
	  		  break;
			}
	 
			//
			// Rule 239:  ERROR_IsMarkedPreCS ::= ERROR_TOKEN
			//
			case 239: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_AT_PRE);
				IsMarkedPreCS result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 240:  ERROR_PathNameCS ::= ERROR_TOKEN
			//
			case 240: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_PATH_NAME);
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 241:  ERROR_SimpleNameCS ::= ERROR_TOKEN
			//
			case 241: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_SIMPLE_NAME);
				SimpleNameCS result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 242:  attrOrNavCallExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
			//
			case 242: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RBRACK);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						createIsMarkedPreCS(false)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 243:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS ERROR_TOKEN
			//
			case 243: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RPAREN);
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionTypeCS(
						(CollectionTypeIdentifierEnum)objs[1],
						(TypeCS)dtParser.getSym(3)
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 244:  collectionTypeCS ::= collectionTypeIdentifierCS ERROR_TOKEN
			//
			case 244: {
				
				reportErrorTokenMessage(dtParser.getToken(2), OCLParserErrors.MISSING_LPAREN);
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionTypeCS(
						(CollectionTypeIdentifierEnum)objs[1],
						null
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 245:  dotArrowExpCS ::= pathNameCS :: ERROR_SimpleNameCS ( argumentsCSopt )
			//
			case 245: {
				
				OperationCallExpCS result = createOperationCallExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(6)));
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 246:  enumLiteralExpCS ::= pathNameCS :: ERROR_SimpleNameCS
			//
			case 246: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createEnumLiteralExpCS(
						pathNameCS,
						simpleNameCS
					);
				setOffsets(result, pathNameCS, simpleNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 247:  featureCallExpCS ::= unaryName ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 247:
 
			//
			// Rule 248:  keywordOperationCallExpCS ::= keywordAsName ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 248:
 
			//
			// Rule 249:  operationCallExpCS ::= binaryName ERROR_IsMarkedPreCS ( argumentsCSopt )
			//
			case 249: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 250:  operationCallExpCS ::= oclIsInStateName ERROR_IsMarkedPreCS ( stateExpCS )
			//
			case 250: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(StateExpCS)dtParser.getSym(4)
					);
				setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 251:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS ERROR_TOKEN
			//
			case 251: {
				
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
			// Rule 252:  ifExpCS ::= if oclExpressionCS then oclExpressionCS ERROR_TOKEN
			//
			case 252: {
				
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
			// Rule 253:  ifExpCS ::= if oclExpressionCS ERROR_TOKEN
			//
			case 253: {
				
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
			// Rule 254:  ifExpCS ::= if ERROR_TOKEN endif
			//
			case 254: {
				
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
			// Rule 255:  messageExpCS ::= ^ simpleNameCS ERROR_TOKEN
			//
			case 255:
 
			//
			// Rule 256:  messageExpCS ::= ^^ simpleNameCS ERROR_TOKEN
			//
			case 256: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_MESSAGE_ARGUMENTS);
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == QVTrParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(2),
						new BasicEList<OCLMessageArgCS>()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 257:  messageExpCS ::= ^ ERROR_SimpleNameCS
			//
			case 257:
 
			//
			// Rule 258:  messageExpCS ::= ^^ ERROR_SimpleNameCS
			//
			case 258: {
				
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(2);
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == QVTrParsersym.TK_CARET,
						simpleNameCS,
						new BasicEList<OCLMessageArgCS>()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), simpleNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 259:  oclExpCS ::= ERROR_TOKEN
			//
			case 259: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_EXPR);
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 260:  oclExpCS ::= ( oclExpressionCS ERROR_TOKEN
			//
			case 260: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_RPAREN);
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 261:  operationCS1 ::= IDENTIFIER ( parametersCSopt ) ERROR_Colon
			//
			case 261: {
				
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 262:  operationCS1 ::= IDENTIFIER ( parametersCSopt ERROR_TOKEN
			//
			case 262: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RPAREN);
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						(EList)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 263:  operationCS1 ::= IDENTIFIER ERROR_TOKEN
			//
			case 263: {
				
				reportErrorTokenMessage(dtParser.getToken(2), OCLParserErrors.MISSING_LPAREN);
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 264:  operationCS1 ::= ERROR_TOKEN
			//
			case 264: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_IDENTIFIER);
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						new BasicEList(),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 265:  operationCS2 ::= pathNameCS :: simpleNameCS ( parametersCSopt ) ERROR_Colon
			//
			case 265: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCS(
						pathNameCS,
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5),
						(TypeCS)dtParser.getSym(8)
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 266:  operationCS2 ::= pathNameCS :: simpleNameCS ( parametersCSopt ERROR_TOKEN
			//
			case 266: {
				
				reportErrorTokenMessage(dtParser.getToken(6), OCLParserErrors.MISSING_RPAREN);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCS(
						pathNameCS,
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5),
						null
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 267:  operationCS2 ::= pathNameCS :: simpleNameCS ERROR_TOKEN
			//
			case 267: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_LPAREN);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				CSTNode result = createOperationCS(
						pathNameCS,
						(SimpleNameCS)dtParser.getSym(3),
						new BasicEList(),
						null
					);
				setOffsets(result, pathNameCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 268:  operationCS2 ::= pathNameCS :: ERROR_SimpleNameCS
			//
			case 268: {
				
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
				CSTNode result = createOperationCS(
						pathNameCS,
						simpleNameCS,
						new BasicEList(),
						null
					);
				setOffsets(result, pathNameCS, simpleNameCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 269:  parametersCS ::= ERROR_TOKEN
			//
			case 269: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_PARAMETERS);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 270:  parametersCS ::= parametersCS , ERROR_TOKEN
			//
			case 270: {
				
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_PARAMETER);
	  		  break;
			}
	 
			//
			// Rule 273:  tupleLiteralExpCS ::= Tuple ERROR_TOKEN
			//
			case 273: {
				
				reportErrorTokenMessage(dtParser.getToken(7), OCLParserErrors.MISSING_LBRACE);
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 274:  variableCS ::= IDENTIFIER ERROR_TOKEN
			//
			case 274: {
				
				reportErrorTokenMessage(dtParser.getToken(2), OCLParserErrors.MISSING_VARIABLE_TYPE);
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 275:  variableExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
			//
			case 275:
 
			//
			// Rule 276:  variableExpCS ::= keywordAsName1 [ argumentsCS ERROR_TOKEN
			//
			case 276: {
				
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RBRACK);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						createIsMarkedPreCS(false)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 277:  variableListCS ::= ERROR_TOKEN
			//
			case 277:
 
			//
			// Rule 278:  variableListCS2 ::= ERROR_TOKEN
			//
			case 278: {
				
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_VARIABLES);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 279:  topLevelCS_0_ ::= $Empty
			//
			case 279: {
				
				TopLevelCS result = QVTrCSTFactory.eINSTANCE.createTopLevelCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 280:  topLevelCS_0_ ::= topLevelCS_0_ import unitCS ;
			//
			case 280: {
				
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				result.getImportClause().add((UnitCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 281:  topLevelCS_0_ ::= topLevelCS_0_ ERROR_TOKEN
			//
			case 281: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_TOPLEVEL);
	  		  break;
			}
	 
			//
			// Rule 282:  topLevelCS_1_ ::= topLevelCS transformationCS
			//
			case 282: {
				
				TransformationCS transformationCS = (TransformationCS)dtParser.getSym(2);
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				result.getTransformation().add(transformationCS);
				setOffsets(result, result, transformationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 283:  topLevelCS_1_ ::= topLevelCS_1_ ERROR_TOKEN
			//
			case 283: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION);
	  		  break;
			}
	 
			//
			// Rule 286:  unitCS ::= identifierCS
			//
			case 286: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				UnitCS result = QVTrCSTFactory.eINSTANCE.createUnitCS();
				result.getIdentifier().add(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 287:  unitCS ::= unitCS . identifierCS
			//
			case 287: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				UnitCS result = (UnitCS)dtParser.getSym(1);
				result.getIdentifier().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 288:  transformationCS_0_ ::= transformation identifierCS ( modelDeclCS
			//
			case 288: {
				
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
			// Rule 289:  transformationCS_0_ ::= transformationCS_0_ , modelDeclCS
			//
			case 289: {
				
				ModelDeclCS modelDeclCS = (ModelDeclCS)dtParser.getSym(3);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getModelDecl().add(modelDeclCS);
				setOffsets(result, result, modelDeclCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 290:  transformationCS_0_ ::= transformationCS_0_ ERROR_TOKEN
			//
			case 290: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL);
	  		  break;
			}
	 
			//
			// Rule 291:  transformationCS_1_ ::= transformationCS_0_ )
			//
			case 291: {
				
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 293:  transformationCS_2_ ::= transformationCS_1_ extends identifierCS
			//
			case 293: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.setExtends(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 295:  transformationCS_3_ ::= transformationCS_3_ keyDeclCS
			//
			case 295: {
				
				KeyDeclCS keyDeclCS = (KeyDeclCS)dtParser.getSym(2);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getKeyDecl().add(keyDeclCS);
				setOffsets(result, result, keyDeclCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 297:  transformationCS_4_ ::= transformationCS_4_ queryCS
			//
			case 297: {
				
				QueryCS queryCS =(QueryCS)dtParser.getSym(2);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getQuery().add(queryCS);
				setOffsets(result, result, queryCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 298:  transformationCS_4_ ::= transformationCS_4_ relationCS
			//
			case 298: {
				
				RelationCS relationCS = (RelationCS)dtParser.getSym(2);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getRelation().add(relationCS);
				setOffsets(result, result, relationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 299:  transformationCS_4_ ::= transformationCS_4_ ERROR_TOKEN
			//
			case 299: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION_ELEMENT);
	  		  break;
			}
	 
			//
			// Rule 300:  transformationCS ::= transformationCS_4_ }
			//
			case 300: {
				
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 301:  modelDeclCS_0_ ::= modelIdCS :
			//
			case 301: {
				
				IdentifierCS modelIdCS = (IdentifierCS)dtParser.getSym(1);
				ModelDeclCS result = QVTrCSTFactory.eINSTANCE.createModelDeclCS();
				result.setModelId(modelIdCS);
				setOffsets(result, modelIdCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 304:  modelDeclCS_2_ ::= modelDeclCS_1_ metaModelIdCS
			//
			case 304: 
 
			//
			// Rule 305:  modelDeclCS ::= modelDeclCS_0_ metaModelIdCS
			//
			case 305: {
				
				IdentifierCS metaModelIdCS = (IdentifierCS)dtParser.getSym(2);
				ModelDeclCS result = (ModelDeclCS)dtParser.getSym(1);
				result.getMetaModelId().add(metaModelIdCS);
				setOffsets(result, result, metaModelIdCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 306:  modelDeclCS_2_ ::= modelDeclCS_1_ ERROR_TOKEN
			//
			case 306: 
 
			//
			// Rule 307:  modelDeclCS ::= modelDeclCS_0_ ERROR_TOKEN
			//
			case 307: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL_ELEMENT);
	  		  break;
			}
	 
			//
			// Rule 308:  modelDeclCS ::= modelDeclCS_2_ }
			//
			case 308: {
				
				ModelDeclCS result = (ModelDeclCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 311:  keyDeclCS_0_ ::= key classIdCS {
			//
			case 311: {
				
				PathNameCS classIdCS = (PathNameCS)dtParser.getSym(2);
				KeyDeclCS result = QVTrCSTFactory.eINSTANCE.createKeyDeclCS();
				result.setClassId(classIdCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 313:  keyDeclCS_1_ ::= keyDeclCS_0_ propertyIdCS
			//
			case 313: {
				
				IdentifiedCS propertyIdCS = (IdentifiedCS)dtParser.getSym(2);
				KeyDeclCS result = (KeyDeclCS)dtParser.getSym(1);
				result.getPropertyId().add(propertyIdCS);
				setOffsets(result, result, propertyIdCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 314:  keyDeclCS_1_ ::= keyDeclCS_0_ ERROR_TOKEN
			//
			case 314: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_KEYDECL_ELEMENT);
	  		  break;
			}
	 
			//
			// Rule 315:  keyDeclCS ::= keyDeclCS_1_ } ;
			//
			case 315: {
				
				KeyDeclCS result = (KeyDeclCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 317:  propertyIdCS ::= identifierCS
			//
			case 317: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 318:  relationCS_0_ ::= relation identifierCS
			//
			case 318: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(2);
				RelationCS result = QVTrCSTFactory.eINSTANCE.createRelationCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 320:  relationCS_1_ ::= top relationCS_0_
			//
			case 320: {
				
				RelationCS result = (RelationCS)dtParser.getSym(2);
				result.setTop(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 322:  relationCS_2_ ::= relationCS_1_ overrides identifierCS
			//
			case 322: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				RelationCS result = (RelationCS)dtParser.getSym(1);
				result.setOverrides(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 324:  relationCS_3_ ::= relationCS_3_ varDeclarationCS
			//
			case 324: {
				
				VarDeclarationCS varDeclarationCS = (VarDeclarationCS)dtParser.getSym(2);
				RelationCS result = (RelationCS)dtParser.getSym(1);
				result.getVarDeclaration().add(varDeclarationCS);
				setOffsets(result, result, varDeclarationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 327:  relationCS_postDomain ::= relationCS_preDomain domainCS
			//
			case 327: 
 
			//
			// Rule 328:  relationCS_postDomain ::= relationCS_preDomain primitiveTypeDomainCS
			//
			case 328: {
				
				AbstractDomainCS domainCS = (AbstractDomainCS)dtParser.getSym(2);
				RelationCS result = (RelationCS)dtParser.getSym(1);
				result.getDomain().add(domainCS);
				setOffsets(result, result, domainCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 330:  relationCS_postWhen ::= relationCS_postDomain whenCS
			//
			case 330: {
				
				RelationCS result = (RelationCS)dtParser.getSym(1);
				WhenCS whenCS = (WhenCS)dtParser.getSym(2);
				result.setWhen(whenCS);
				setOffsets(result, result, whenCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 332:  relationCS_postWhere ::= relationCS_postWhen whereCS
			//
			case 332: {
				
				RelationCS result = (RelationCS)dtParser.getSym(1);
				WhereCS whereCS = (WhereCS)dtParser.getSym(2);
				result.setWhere(whereCS);
				setOffsets(result, result, whereCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 333:  relationCS ::= relationCS_postWhere }
			//
			case 333: {
				
				RelationCS result = (RelationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 334:  whenCS_0 ::= when {
			//
			case 334: {
				
				WhenCS result = QVTrCSTFactory.eINSTANCE.createWhenCS();
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 335:  whenCS_0 ::= when ERROR_TOKEN
			//
			case 335: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_WHEN);
	  		  break;
			}
	 
			//
			// Rule 337:  whenCS_1 ::= whenCS_1 oclExpressionCS ;
			//
			case 337: {
				
				WhenCS result = (WhenCS)dtParser.getSym(1);
				OCLExpressionCS oclExpressionCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getExpr().add(oclExpressionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 338:  whenCS ::= whenCS_1 }
			//
			case 338: {
				
				WhenCS result = (WhenCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 339:  whereCS_0 ::= where {
			//
			case 339: {
				
				WhereCS result = QVTrCSTFactory.eINSTANCE.createWhereCS();
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 340:  whereCS_0 ::= where ERROR_TOKEN
			//
			case 340: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_WHERE);
	  		  break;
			}
	 
			//
			// Rule 342:  whereCS_1 ::= whereCS_1 oclExpressionCS ;
			//
			case 342: {
				
				WhereCS result = (WhereCS)dtParser.getSym(1);
				OCLExpressionCS oclExpressionCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getExpr().add(oclExpressionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 343:  whereCS ::= whereCS_1 }
			//
			case 343: {
				
				WhereCS result = (WhereCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 344:  varDeclarationCS_0 ::= identifierCS
			//
			case 344: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				VarDeclarationCS result = QVTrCSTFactory.eINSTANCE.createVarDeclarationCS();
				result.getVarDeclarationId().add(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 345:  varDeclarationCS_0 ::= varDeclarationCS_0 , identifierCS
			//
			case 345: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				VarDeclarationCS result = (VarDeclarationCS)dtParser.getSym(1);
				result.getVarDeclarationId().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 346:  varDeclarationCS ::= varDeclarationCS_0 : typeCS ;
			//
			case 346: {
				
				VarDeclarationCS result = (VarDeclarationCS)dtParser.getSym(1);
				result.setType((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 347:  domainCS_0_ ::= domain modelIdCS templateCS
			//
			case 347: {
				
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
			// Rule 349:  domainCS_1_ ::= checkonly domainCS_0_
			//
			case 349: {
				
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setCheckonly(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 350:  domainCS_1_ ::= enforce domainCS_0_
			//
			case 350: {
				
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setEnforce(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 351:  domainCS_1_ ::= replace domainCS_0_
			//
			case 351: {
				
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setReplace(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 353:  domainCS_postImplementedby ::= domainCS_1_ implementedby operationCallExpCS
			//
			case 353: {
				
				DomainCS result = (DomainCS)dtParser.getSym(1);
				OperationCallExpCS operationCallExpCS =(OperationCallExpCS)dtParser.getSym(3);
				result.setImplementedBy(operationCallExpCS);
				setOffsets(result, result, operationCallExpCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 355:  domainCS_preDefaultValue ::= domainCS_preDefaultValue defaultValueCS
			//
			case 355: {
				
				DomainCS result = (DomainCS)dtParser.getSym(1);
				DefaultValueCS defaultValueCS = (DefaultValueCS)dtParser.getSym(2);
				result.getDefaultValue().add(defaultValueCS);
				setOffsets(result, result, defaultValueCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 357:  domainCS_postDefaultValues ::= domainCS_preDefaultValue }
			//
			case 357: {
				
				DomainCS result = (DomainCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 358:  domainCS ::= domainCS_postDefaultValues ;
			//
			case 358: {
				
				DomainCS result = (DomainCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 359:  primitiveTypeDomainCS ::= primitive domain identifierCS : typeCS ;
			//
			case 359: {
				
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
			// Rule 363:  templateCS ::= templateCS_0_ { oclExpressionCS }
			//
			case 363: {
				
				TemplateCS result = (TemplateCS)dtParser.getSym(1);
				OCLExpressionCS oclExpressionCS = (OCLExpressionCS)dtParser.getSym(3);
				result.setGuardExpression(oclExpressionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 364:  objectTemplateCS_prePropertyTemplates ::= IDENTIFIER : pathNameCS {
			//
			case 364:
 
			//
			// Rule 365:  objectTemplateCS_prePropertyTemplates ::= relationIdentifier : pathNameCS {
			//
			case 365:
 
			//
			// Rule 366:  objectTemplateCS_prePropertyTemplates ::= self : pathNameCS {
			//
			case 366: {
				
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
			// Rule 367:  objectTemplateCS_prePropertyTemplates ::= : pathNameCS {
			//
			case 367: {
				
				ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
				result.setIdentifier(createUniqueIdentifierCS(dtParser.getToken(1)));
				result.setType((TypeCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 370:  objectTemplateCS_postPropertyTemplate ::= objectTemplateCS_prePropertyTemplate propertyTemplateCS
			//
			case 370: {
				
				ObjectTemplateCS result = (ObjectTemplateCS)dtParser.getSym(1);
				PropertyTemplateCS propertyTemplateCS = (PropertyTemplateCS)dtParser.getSym(2);
				result.getPropertyTemplate().add(propertyTemplateCS);
				setOffsets(result, result, propertyTemplateCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 371:  objectTemplateCS ::= objectTemplateCS_prePropertyTemplates }
			//
			case 371:
 
			//
			// Rule 372:  objectTemplateCS ::= objectTemplateCS_postPropertyTemplate }
			//
			case 372: {
				
				ObjectTemplateCS result = (ObjectTemplateCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 373:  propertyTemplateCS ::= propertyIdCS = oclExpressionCS
			//
			case 373: {
				
				IdentifiedCS propertyIdCS = (IdentifiedCS)dtParser.getSym(1);
				PropertyTemplateCS result = QVTrCSTFactory.eINSTANCE.createPropertyTemplateCS();
				OCLExpressionCS oclExpressionCS = (OCLExpressionCS)dtParser.getSym(3);
				result.setPropertyId(propertyIdCS);
				result.setOclExpression(oclExpressionCS);
				setOffsets(result, propertyIdCS, oclExpressionCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 374:  collectionTemplateCS_1_ ::= : collectionTypeCS
			//
			case 374: {
				
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)dtParser.getSym(2);
				CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
				result.setType(collectionTypeCS);
				result.setIdentifier(createUniqueIdentifierCS(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)), collectionTypeCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 375:  collectionTemplateCS_1_ ::= IDENTIFIER : collectionTypeCS
			//
			case 375:
 
			//
			// Rule 376:  collectionTemplateCS_1_ ::= relationIdentifier : collectionTypeCS
			//
			case 376:
 
			//
			// Rule 377:  collectionTemplateCS_1_ ::= self : collectionTypeCS
			//
			case 377: {
				
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
			// Rule 381:  collectionTemplateCS_postMemberSelection ::= collectionTemplateCS_preMemberSelection memberSelectorCS
			//
			case 381: {
				
				IdentifiedCS memberSelectorCS = (IdentifiedCS)dtParser.getSym(2);
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				result.getMemberIdentifier().add(memberSelectorCS);
				setOffsets(result, result, memberSelectorCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 382:  collectionTemplateCS ::= collectionTemplateCS_postMemberSelection PLUS_PLUS identifierCS }
			//
			case 382: {
				
				IdentifierCS restIdentifier = (IdentifierCS)dtParser.getSym(3);
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				result.setRestIdentifier(restIdentifier);
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 383:  collectionTemplateCS ::= collectionTemplateCS_postMemberSelection ERROR_TOKEN }
			//
			case 383: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_REST);
				IdentifierCS restIdentifier = createUniqueIdentifierCS(dtParser.getToken(2));
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				result.setRestIdentifier(restIdentifier);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 384:  collectionTemplateCS ::= collectionTemplateCS_preMemberSelections }
			//
			case 384: {
				
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 385:  memberSelectorCS ::= identifierCS
			//
			case 385: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 387:  defaultValueCS ::= identifierCS = oclExpressionCS ;
			//
			case 387: {
				
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				OCLExpressionCS oclExpressionCS = (OCLExpressionCS)dtParser.getSym(3);
				DefaultValueCS result = QVTrCSTFactory.eINSTANCE.createDefaultValueCS();
				result.setIdentifier(identifierCS);
				result.setInitialiser(oclExpressionCS);
				setOffsets(result, identifierCS, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 388:  queryCS_preParamDeclaration ::= query pathNameCS (
			//
			case 388: {
				
				QueryCS result = QVTrCSTFactory.eINSTANCE.createQueryCS();
				result.setPathName((PathNameCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 390:  queryCS_postParamDeclaration ::= queryCS_preParamDeclaration paramDeclarationCS
			//
			case 390: {
				
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)dtParser.getSym(2);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.getInputParamDeclaration().add(paramDeclarationCS);
				setOffsets(result, result, paramDeclarationCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 391:  queryCS_postType ::= queryCS_postParamDeclaration ) : typeCS
			//
			case 391: {
				
				TypeCS typeCS = (TypeCS)dtParser.getSym(4);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setType(typeCS);
				setOffsets(result, result, typeCS);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 392:  queryCS ::= queryCS_postType ;
			//
			case 392: {
				
				QueryCS result = (QueryCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 393:  queryCS ::= queryCS_postType { oclExpressionCS }
			//
			case 393: {
				
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setOclExpression((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 394:  paramDeclarationCS ::= identifierCS : typeCS
			//
			case 394: {
				
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
			// Rule 395:  paramDeclarationCS ::= identifierCS ERROR_TOKEN
			//
			case 395: {
				
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_PARAM_DECLARATION);
	  		  break;
			}
	 
			//
			// Rule 419:  pathNameCS ::= relationIdentifier
			//
			case 419: {
				
				PathNameCS result = createPathNameCS();
				result.getSequenceOfNames().add(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 420:  simpleNameCS ::= relationIdentifier
			//
			case 420: {
				
				SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 421:  identifierCS ::= IDENTIFIER
			//
			case 421: 
 
			//
			// Rule 422:  identifierCS ::= relationIdentifier
			//
			case 422: 
 
			//
			// Rule 423:  identifierCS ::= self
			//
			case 423: {
				
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

