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
* $Id: QVTcParser.java,v 1.12 2009/11/10 06:07:00 ewillink Exp $
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
            // Rule 16:  conceptualOperationNameCS ::= conceptualOperationName
            //
            case 16: {
                
                IToken iToken = getIToken(dtParser.getToken(1));
                SimpleNameCS result = createConceptualOperationNameCS(iToken);
                setOffsets(result, iToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 28:  tupleKeywordCS ::= Tuple
            //
            case 28:
 
            //
            // Rule 29:  reservedKeywordCS ::= reservedKeyword
            //
            case 29: {
                
                IToken iToken = getIToken(dtParser.getToken(1));
                SimpleNameCS result = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            iToken
                        );
                setOffsets(result, iToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 33:  selfKeywordCS ::= self
            //
            case 33: {
                
                IToken iToken = getIToken(dtParser.getToken(1));
                CSTNode result = createSimpleNameCS(
                        SimpleTypeEnum.SELF_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 34:  simpleNameCS ::= IDENTIFIER
            //
            case 34: {
                
                IToken iToken = getIToken(dtParser.getToken(1));
                CSTNode result = createSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 37:  pathNameCS ::= simpleNameCS
            //
            case 37: {
                
                SimpleNameCS simpleName = (SimpleNameCS)dtParser.getSym(1);
                PathNameCS result = createPathNameCS(simpleName);
                setOffsets(result, simpleName);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 38:  pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
            //
            case 38: {
                
                PathNameCS result = (PathNameCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                result = extendPathNameCS(result, simpleNameCS);
                setOffsets(result, result, simpleNameCS);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 39:  primitiveTypeCS ::= Boolean
            //
            case 39: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.BOOLEAN_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 40:  primitiveTypeCS ::= Integer
            //
            case 40: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.INTEGER_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 41:  primitiveTypeCS ::= Real
            //
            case 41: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.REAL_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 42:  primitiveTypeCS ::= String
            //
            case 42: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.STRING_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 43:  primitiveTypeCS ::= UnlimitedNatural
            //
            case 43: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 44:  primitiveTypeCS ::= OclAny
            //
            case 44: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_ANY_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 45:  primitiveTypeCS ::= OclInvalid
            //
            case 45: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_INVALID_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 46:  primitiveTypeCS ::= OclVoid
            //
            case 46: {
                
                CSTNode result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_VOID_LITERAL,
                        getTokenText(dtParser.getToken(1))
                    );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 47:  CollectionTypeIdentifierCS ::= Set
            //
            case 47: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SET_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 48:  CollectionTypeIdentifierCS ::= Bag
            //
            case 48: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.BAG_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 49:  CollectionTypeIdentifierCS ::= Sequence
            //
            case 49: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 50:  CollectionTypeIdentifierCS ::= Collection
            //
            case 50: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 51:  CollectionTypeIdentifierCS ::= OrderedSet
            //
            case 51: {
                
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                            getTokenText(dtParser.getToken(1))
                        );
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 56:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
            //
            case 56: {
                
                CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1);
                result.setTypeCS((TypeCS)dtParser.getSym(3));
                setOffsets(result, result, getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 57:  tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
            //
            case 57: {
                
                CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 58:  tupleTypePartsCSopt ::= $Empty
            //
            case 58:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 60:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 60: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 61:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 61: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 62:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 62: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                CSTNode result = createVariableCS(name, null, null);
                setOffsets(result, name);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 63:  typedUninitializedVariableCS ::= simpleNameCS : typeCS
            //
            case 63: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                TypeCS type = (TypeCS)dtParser.getSym(3);
                CSTNode result = createVariableCS(name, type, null);
                setOffsets(result, name, type);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 64:  untypedInitializedVariableCS ::= simpleNameCS = OclExpressionCS
            //
            case 64: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(3);
                CSTNode result = createVariableCS(name, null, initExpression);
                setOffsets(result, name, initExpression);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 65:  typedInitializedVariableCS ::= simpleNameCS : typeCS = OclExpressionCS
            //
            case 65: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                TypeCS type = (TypeCS)dtParser.getSym(3);
                OCLExpressionCS initExpression = (OCLExpressionCS)dtParser.getSym(5);
                CSTNode result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 78:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 78: {
                
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
            // Rule 79:  CollectionLiteralExpCS ::= collectionTypeCS { CollectionLiteralPartsCSopt }
            //
            case 79: {
                
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
            // Rule 80:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 80:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 82:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 82: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 83:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 83: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 85:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 85: {
                
                CSTNode result = createCollectionLiteralPartCS(
                        (OCLExpressionCS)dtParser.getSym(1)
                    );
                setOffsets(result, (CSTNode)dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 86:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
            //
            case 86: {
                
                CSTNode result = createCollectionRangeCS(
                        (OCLExpressionCS)dtParser.getSym(1),
                        (OCLExpressionCS)dtParser.getSym(3)
                    );
                setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 94:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
            //
            case 94: {
                
                CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 95:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 95: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 96:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 96: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 97:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 97: {
                
                CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 98:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 98: {
                
                CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 99:  StringLiteralExpCS ::= STRING_LITERAL
            //
            case 99: {
                
                IToken literalToken = getIToken(dtParser.getToken(1));
                StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                setOffsets(result, literalToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 100:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
            //
            case 100: {
                
                StringLiteralExpCS string = (StringLiteralExpCS)dtParser.getSym(1);
                IToken literalToken = getIToken(dtParser.getToken(2));
                StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                setOffsets(result, string, literalToken);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 101:  BooleanLiteralExpCS ::= true
            //
            case 101: {
                
                CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 102:  BooleanLiteralExpCS ::= false
            //
            case 102: {
                
                CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 103:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 103: {
                
                CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 104:  InvalidLiteralExpCS ::= invalid
            //
            case 104: {
                
                CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 105:  NullLiteralExpCS ::= null
            //
            case 105: {
                
                CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 106:  TypeLiteralExpCS ::= primitiveTypeCS
            //
            case 106:
 
            //
            // Rule 107:  TypeLiteralExpCS ::= collectionTypeCS
            //
            case 107:
 
            //
            // Rule 108:  TypeLiteralExpCS ::= tupleTypeCS
            //
            case 108: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
                CSTNode result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 113:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS | OclExpressionCS )
            //
            case 113: {
                
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
            // Rule 114:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 114: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(5);
                VariableCS variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                CSTNode result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        variableCS,
                        (VariableCS)dtParser.getSym(7),
                        (OCLExpressionCS)dtParser.getSym(9)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(10)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 115:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( typedUninitializedVariableCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 115: {
                
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
            // Rule 116:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( typedInitializedVariableCS | OclExpressionCS )
            //
            case 116: {
                
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
            // Rule 117:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS ; typedInitializedVariableCS | OclExpressionCS )
            //
            case 117: {
                
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
            // Rule 121:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
            //
            case 121: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CSTNode result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)dtParser.getSym(3),
                        null,
                        new BasicEList()
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(5)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 122:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( OclExpressionCS )
            //
            case 122: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                OCLExpressionCS arg = (OCLExpressionCS)dtParser.getSym(5);
                CSTNode result;
                if (isIterator(simpleNameCS.getValue())) {
                    result = createIteratorExpCS(
                            source,
                            simpleNameCS,
                            null,
                            null,
                            arg
                        );
                }
                else {
                    EList args = new BasicEList();
                    args.add(arg);
                    result = createArrowOperationCallExpCS(
                            source,
                            simpleNameCS,
                            null,
                            args
                        );
                }
                setOffsets(result, source, getIToken(dtParser.getToken(6)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 123:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( notNameExpressionCS , argumentsCS )
            //
            case 123: {
                
                EList args = (EList)dtParser.getSym(7);
                args.add(0, dtParser.getSym(5));
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CSTNode result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)dtParser.getSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(8)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 124:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , argumentsCS )
            //
            case 124: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(5);
                OCLExpressionCS variableExpCS = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList(),
                        null
                    );
                setOffsets(variableExpCS, simpleNameCS);
                EList args = (EList)dtParser.getSym(7);
                args.add(0, variableExpCS);
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CSTNode result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)dtParser.getSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(8)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 125:  OperationCallExpCS ::= primaryExpCS . conceptualOperationNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 125:
 
            //
            // Rule 126:  OperationCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 126: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (IsMarkedPreCS)dtParser.getSym(4),
                        (EList)dtParser.getSym(6)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(7)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 127:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 127: {
                
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
            // Rule 128:  OperationCallExpCS ::= pathNameCS :: unreservedSimpleNameCS ( argumentsCSopt )
            //
            case 128: {
                
                PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        null,
                        (EList)dtParser.getSym(5)
                    );
                setOffsets(result, pathNameCS, getIToken(dtParser.getToken(6)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 129:  OperationCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 129: {
                
                PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(5);
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        (IsMarkedPreCS)dtParser.getSym(6),
                        (EList)dtParser.getSym(8)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(9)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 131:  PropertyCallExpCS ::= pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 131: {
                
                PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(4);
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
            // Rule 132:  PropertyCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 132: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(5);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(6);
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
            // Rule 133:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt
            //
            case 133: {
                
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
            // Rule 134:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 134: {
                
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(7);
                CSTNode result = createFeatureCallExpCS(
                        source,
                        null,
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
            // Rule 135:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 135: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
                CSTNode result = createVariableExpCS(
                        simpleNameCS,
                        (EList)dtParser.getSym(3),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, simpleNameCS, isMarkedPreCS);
                } else {
                    setOffsets(result, simpleNameCS, getIToken(dtParser.getToken(4)));
                }
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 136:  isMarkedPreCSopt ::= $Empty
            //
            case 136: {
                
                dtParser.setSym1(null);
              break;
            }
     
            //
            // Rule 137:  argumentsCSopt ::= $Empty
            //
            case 137:
                dtParser.setSym1(new BasicEList());
                break;
 
            //
            // Rule 139:  argumentsCS ::= OclExpressionCS
            //
            case 139: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 140:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 140: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 143:  VariableExpCS ::= selfKeywordCS
            //
            case 143: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
                CSTNode result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 144:  SimpleNameExpCS ::= simpleNameCS
            //
            case 144: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
                CSTNode result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 150:  impliesNotNameNotLetCS ::= impliesNotLetCS implies xorNotLetCS
            //
            case 150:
 
            //
            // Rule 152:  impliesWithLetCS ::= impliesNotLetCS implies xorWithLetCS
            //
            case 152:
 
            //
            // Rule 156:  xorNotNameNotLetCS ::= xorNotLetCS xor orNotLetCS
            //
            case 156:
 
            //
            // Rule 158:  xorWithLetCS ::= xorNotLetCS xor orWithLetCS
            //
            case 158:
 
            //
            // Rule 162:  orNotNameNotLetCS ::= orNotLetCS or andNotLetCS
            //
            case 162:
 
            //
            // Rule 164:  orWithLetCS ::= orNotLetCS or andWithLetCS
            //
            case 164:
 
            //
            // Rule 168:  andNotNameNotLetCS ::= andNotLetCS and equalityNotLetCS
            //
            case 168:
 
            //
            // Rule 170:  andWithLetCS ::= andNotLetCS and equalityWithLetCS
            //
            case 170:
 
            //
            // Rule 174:  equalityNotNameNotLetCS ::= equalityNotLetCS = relationalNotLetCS
            //
            case 174:
 
            //
            // Rule 175:  equalityNotNameNotLetCS ::= equalityNotLetCS <> relationalNotLetCS
            //
            case 175:
 
            //
            // Rule 177:  equalityWithLetCS ::= equalityNotLetCS = relationalWithLetCS
            //
            case 177:
 
            //
            // Rule 178:  equalityWithLetCS ::= equalityNotLetCS <> relationalWithLetCS
            //
            case 178:
 
            //
            // Rule 182:  relationalNotNameNotLetCS ::= relationalNotLetCS > additiveNotLetCS
            //
            case 182:
 
            //
            // Rule 183:  relationalNotNameNotLetCS ::= relationalNotLetCS < additiveNotLetCS
            //
            case 183:
 
            //
            // Rule 184:  relationalNotNameNotLetCS ::= relationalNotLetCS >= additiveNotLetCS
            //
            case 184:
 
            //
            // Rule 185:  relationalNotNameNotLetCS ::= relationalNotLetCS <= additiveNotLetCS
            //
            case 185:
 
            //
            // Rule 187:  relationalWithLetCS ::= relationalNotLetCS > additiveWithLetCS
            //
            case 187:
 
            //
            // Rule 188:  relationalWithLetCS ::= relationalNotLetCS < additiveWithLetCS
            //
            case 188:
 
            //
            // Rule 189:  relationalWithLetCS ::= relationalNotLetCS >= additiveWithLetCS
            //
            case 189:
 
            //
            // Rule 190:  relationalWithLetCS ::= relationalNotLetCS <= additiveWithLetCS
            //
            case 190:
 
            //
            // Rule 194:  additiveNotNameNotLetCS ::= additiveNotLetCS + multiplicativeNotLetCS
            //
            case 194:
 
            //
            // Rule 195:  additiveNotNameNotLetCS ::= additiveNotLetCS - multiplicativeNotLetCS
            //
            case 195:
 
            //
            // Rule 197:  additiveWithLetCS ::= additiveNotLetCS + multiplicativeWithLetCS
            //
            case 197:
 
            //
            // Rule 198:  additiveWithLetCS ::= additiveNotLetCS - multiplicativeWithLetCS
            //
            case 198:
 
            //
            // Rule 202:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS * unaryNotLetCS
            //
            case 202:
 
            //
            // Rule 203:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS / unaryNotLetCS
            //
            case 203:
 
            //
            // Rule 205:  multiplicativeWithLetCS ::= multiplicativeNotLetCS * unaryWithLetCS
            //
            case 205:
 
            //
            // Rule 206:  multiplicativeWithLetCS ::= multiplicativeNotLetCS / unaryWithLetCS
            //
            case 206: {
                
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getIToken(dtParser.getToken(2))
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
            // Rule 210:  unaryNotNameNotLetCS ::= - unaryNotLetCS
            //
            case 210:
 
            //
            // Rule 211:  unaryNotNameNotLetCS ::= not unaryNotLetCS
            //
            case 211:
 
            //
            // Rule 213:  unaryWithLetCS ::= - unaryWithLetCS
            //
            case 213:
 
            //
            // Rule 214:  unaryWithLetCS ::= not unaryWithLetCS
            //
            case 214: {
                
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getIToken(dtParser.getToken(1))
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
            // Rule 221:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 221: {
                
                CSTNode result = (CSTNode)dtParser.getSym(2);
                if (result instanceof OperationCallExpCS) {
                    ((OperationCallExpCS)result).setIsAtomic(true);
                }
                setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 222:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif
            //
            case 222: {
                
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
            // Rule 223:  LetExpCS ::= let letVariablesCS in OclExpressionCS
            //
            case 223: {
                
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
            // Rule 224:  letVariablesCS ::= typedInitializedVariableCS
            //
            case 224: {
                
                EList result = new BasicEList();
                result.add(dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 225:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 225: {
                
                EList result = (EList)dtParser.getSym(1);
                result.add(dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 226:  ERROR_Colon ::= ERROR_TOKEN
            //
            case 226: {
                
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_COLON);
	          break;
            }
	 
            //
            // Rule 227:  ERROR_Empty ::= ERROR_TOKEN
            //
            case 227: {
                
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.EXTRA_TOKENS);
	          break;
            }
	 
            //
            // Rule 228:  ERROR_SimpleNameCS ::= ERROR_TOKEN
            //
            case 228: {
                
				int token = dtParser.getToken(1);
				reportErrorTokenMessage(token, OCLParserErrors.MISSING_SIMPLE_NAME);
                IToken iToken = getIToken(token);
				SimpleNameCS result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						iToken
					);
				setOffsets(result, iToken);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 230:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS ERROR_TOKEN
            //
            case 230: {
                
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RPAREN);
				CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1); 
				result.setTypeCS((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 231:  TupleLiteralExpCS ::= Tuple ERROR_TOKEN
            //
            case 231: {
                
				reportErrorTokenMessage(dtParser.getToken(7), OCLParserErrors.MISSING_LBRACE);
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 232:  TupleLiteralPartsCS ::= ERROR_TOKEN
            //
            case 232: {
                
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_VARIABLES);
				EList result = new BasicEList();
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 233:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
            //
            case 233: {
                
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
            // Rule 234:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS ERROR_TOKEN
            //
            case 234: {
                
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
            // Rule 235:  IfExpCS ::= if OclExpressionCS then OclExpressionCS ERROR_TOKEN
            //
            case 235: {
                
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
            // Rule 236:  IfExpCS ::= if OclExpressionCS ERROR_TOKEN
            //
            case 236: {
                
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
            // Rule 237:  IfExpCS ::= if ERROR_TOKEN endif
            //
            case 237: {
                
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
            // Rule 238:  primaryExpCS ::= ( OclExpressionCS ERROR_TOKEN
            //
            case 238: {
                
				reportErrorTokenMessage(dtParser.getToken(3), OCLParserErrors.MISSING_RPAREN);
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 239:  TopLevelCS ::= $Empty
            //
            case 239: {
                
				TopLevelCS result = QVTcCSTFactory.eINSTANCE.createTopLevelCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 240:  TopLevelCS ::= TopLevelCS MappingCS
            //
            case 240: {
                
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				MappingCS mappingCS = (MappingCS)dtParser.getSym(2);
				result.getMappings().add(mappingCS);
				setOffsets(result, result, mappingCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 241:  TopLevelCS ::= TopLevelCS TransformationCS
            //
            case 241: {
                
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				TransformationCS transformationCS = (TransformationCS)dtParser.getSym(2);
				result.getTransformations().add(transformationCS);
				setOffsets(result, result, transformationCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 242:  TopLevelCS ::= TopLevelCS QueryCS
            //
            case 242: {
                
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				QueryCS queryCS = (QueryCS)dtParser.getSym(2);
				result.getQueries().add(queryCS);
				setOffsets(result, result, queryCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 243:  TransformationCS_0_ ::= transformation TransformationNameCS {
            //
            case 243: {
                
				TransformationCS result = QVTcCSTFactory.eINSTANCE.createTransformationCS();
				result.setPathName((PathNameCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 244:  TransformationCS_0_ ::= TransformationCS_0_ DirectionCS ;
            //
            case 244: {
                
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				DirectionCS directionCS = (DirectionCS)dtParser.getSym(2);
				result.getDirections().add(directionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 245:  TransformationCS ::= TransformationCS_0_ }
            //
            case 245: {
                
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 246:  DirectionCS_0_ ::= DirectionNameCS
            //
            case 246: {
                
				IdentifierCS directionNameCS = (IdentifierCS)dtParser.getSym(1);
				DirectionCS result = QVTcCSTFactory.eINSTANCE.createDirectionCS();
				result.setIdentifier(directionNameCS);
				setOffsets(result, directionNameCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 249:  DirectionCS_2_ ::= DirectionCS_1_ PackageNameCS
            //
            case 249: {
                
				DirectionCS result = (DirectionCS)dtParser.getSym(1);
				PathNameCS pathNameCS = (PathNameCS)dtParser.getSym(2);
				result.getImports().add(pathNameCS);
				setOffsets(result, result, pathNameCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 254:  DirectionCS_5_ ::= DirectionCS_4_ DirectionNameCS
            //
            case 254: {
                
				DirectionCS result = (DirectionCS)dtParser.getSym(1);
				IdentifierCS directionNameCS = (IdentifierCS)dtParser.getSym(2);
				result.getUses().add(directionNameCS);
				setOffsets(result, result, directionNameCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 257:  MappingCS_1_ ::= map
            //
            case 257: {
                
				MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
//					IdentifierCS identifierCS = createUniqueIdentifierCS(dtParser.getToken(1));
//					result.setIdentifier(identifierCS);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 258:  MappingCS_1_ ::= map MappingNameCS
            //
            case 258: {
                
				MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(2);
				result.setIdentifier(identifierCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 260:  MappingCS_2_ ::= MappingCS_1_ in TransformationNameCS
            //
            case 260: {
                
				MappingCS result = (MappingCS)dtParser.getSym(1);
				PathNameCS identifierCS = (PathNameCS)dtParser.getSym(3);
				result.setIn(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 262:  MappingCS_3_ ::= MappingCS_2_ refines MappingNameCS
            //
            case 262: {
                
				MappingCS result = (MappingCS)dtParser.getSym(1);
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				result.getRefines().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 263:  MappingCS_3_ ::= MappingCS_3_ , MappingNameCS
            //
            case 263: {
                
				MappingCS result = (MappingCS)dtParser.getSym(1);
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				result.getRefines().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 265:  MappingCS_4_ ::= MappingCS_4_ DomainCS
            //
            case 265: {
                
				MappingCS result = (MappingCS)dtParser.getSym(1);
				DomainCS domainCS = (DomainCS)dtParser.getSym(2);
				result.getDomains().add(domainCS);
				setOffsets(result, result, domainCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 266:  MappingCS_8 ::= MappingCS_4_ where DomainCS_0_
            //
            case 266: {
                
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
            // Rule 267:  MappingCS_8 ::= MappingCS_4_ where DirectionNameCS DomainCS_0_
            //
            case 267: {
                
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
            // Rule 268:  MappingCS_8 ::= MappingCS_8 ComposedMappingCS
            //
            case 268: {
                
				MappingCS result = (MappingCS)dtParser.getSym(1);
				MappingCS composedMappingCS = (MappingCS)dtParser.getSym(2);
				result.getComposedMappings().add(composedMappingCS);
				setOffsets(result, result, composedMappingCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 269:  MappingCS ::= MappingCS_8 }
            //
            case 269: {
                
				MappingCS result = (MappingCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 270:  DomainCS_0_ ::= ( DomainGuardPatternCS ) { DomainBottomPatternCS }
            //
            case 270: {
                
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
            // Rule 271:  DomainCS_1_ ::= DirectionNameCS DomainCS_0_
            //
            case 271: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, result);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 273:  DomainCS_2_ ::= enforce DomainCS_1_
            //
            case 273: {
                
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setEnforce(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 275:  DomainCS ::= check DomainCS_2_
            //
            case 275: {
                
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setCheck(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 281:  GuardPatternCS_1_ ::= UnrealizedVariableCS
            //
            case 281: {
                
				GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)dtParser.getSym(1);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, unrealizedVariableCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 282:  GuardPatternCS_1_ ::= GuardPatternCS_1_ , UnrealizedVariableCS
            //
            case 282: {
                
				GuardPatternCS result = (GuardPatternCS)dtParser.getSym(1);
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)dtParser.getSym(3);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, result, unrealizedVariableCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 284:  GuardPatternCS_2_ ::= ConstraintCS ;
            //
            case 284: {
                
				GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
				OCLExpressionCS constraintCS = (OCLExpressionCS)dtParser.getSym(1);
				result.getConstraints().add(constraintCS);
				setOffsets(result, constraintCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 285:  GuardPatternCS_2_ ::= GuardPatternCS_2_ ConstraintCS ;
            //
            case 285: {
                
				GuardPatternCS result = (GuardPatternCS)dtParser.getSym(1);
				OCLExpressionCS constraintCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getConstraints().add(constraintCS);
				setOffsets(result, result, constraintCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 288:  GuardPatternCS ::= $Empty
            //
            case 288: {
                
				GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 289:  BottomPatternCS_1_ ::= UnrealizedVariableCS
            //
            case 289: {
                
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)dtParser.getSym(1);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, result, unrealizedVariableCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 290:  BottomPatternCS_1_ ::= BottomPatternCS_1_ , UnrealizedVariableCS
            //
            case 290: {
                
				BottomPatternCS result = (BottomPatternCS)dtParser.getSym(1);
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)dtParser.getSym(3);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, result, unrealizedVariableCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 291:  BottomPatternCS_1_ ::= RealizedVariableCS
            //
            case 291: {
                
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				RealizedVariableCS realizedVariableCS = (RealizedVariableCS)dtParser.getSym(1);
				result.getRealizedVariables().add(realizedVariableCS);
				setOffsets(result, realizedVariableCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 292:  BottomPatternCS_1_ ::= BottomPatternCS_1_ , RealizedVariableCS
            //
            case 292: {
                
				BottomPatternCS result = (BottomPatternCS)dtParser.getSym(1);
				RealizedVariableCS realizedVariableCS = (RealizedVariableCS)dtParser.getSym(3);
				result.getRealizedVariables().add(realizedVariableCS);
				setOffsets(result, realizedVariableCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 294:  BottomPatternCS_2_ ::= ConstraintCS ;
            //
            case 294: {
                
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				OCLExpressionCS constraintCS = (OCLExpressionCS)dtParser.getSym(1);
				result.getConstraints().add(constraintCS);
				setOffsets(result, constraintCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 295:  BottomPatternCS_2_ ::= EnforcementOperationCS
            //
            case 295: {
                
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)dtParser.getSym(1);
				result.getEnforcementOperations().add(enforcementOperationCS);
				setOffsets(result, enforcementOperationCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 296:  BottomPatternCS_2_ ::= BottomPatternCS_2_ ConstraintCS ;
            //
            case 296: {
                
				BottomPatternCS result = (BottomPatternCS)dtParser.getSym(1);
				OCLExpressionCS constraintCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getConstraints().add(constraintCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 297:  BottomPatternCS_2_ ::= BottomPatternCS_2_ EnforcementOperationCS
            //
            case 297: {
                
				BottomPatternCS result = (BottomPatternCS)dtParser.getSym(1);
				EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)dtParser.getSym(2);
				result.getEnforcementOperations().add(enforcementOperationCS);
				setOffsets(result, result, enforcementOperationCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 300:  BottomPatternCS ::= $Empty
            //
            case 300: {
                
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 301:  EnforcementOperationCS_1_ ::= primaryExpCS
            //
            case 301: {
                
				OperationCallExpCS operationCallCS = (OperationCallExpCS)dtParser.getSym(1);
				EnforcementOperationCS result = QVTcCSTFactory.eINSTANCE.createEnforcementOperationCS();
				result.setOperationCall(operationCallCS);
				setOffsets(result, operationCallCS, operationCallCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 302:  EnforcementOperationCS ::= creation EnforcementOperationCS_1_ ;
            //
            case 302: {
                
				EnforcementOperationCS result = (EnforcementOperationCS)dtParser.getSym(2);
				result.setDeletion(false);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 303:  EnforcementOperationCS ::= deletion EnforcementOperationCS_1_ ;
            //
            case 303: {
                
				EnforcementOperationCS result = (EnforcementOperationCS)dtParser.getSym(2);
				result.setDeletion(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 304:  UnrealizedVariableCS ::= VariableNameCS : typeCS
            //
            case 304: {
                
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
            // Rule 305:  RealizedVariableCS ::= realize VariableNameCS : typeCS
            //
            case 305: {
                
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
            // Rule 309:  AssignmentCS_0_ ::= OclExpressionCS := OclExpressionCS
            //
            case 309: {
                
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
            // Rule 311:  AssignmentCS ::= default AssignmentCS_0_
            //
            case 311: {
                
				AssignmentCS result = (AssignmentCS)dtParser.getSym(2);
				result.setDefault(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 320:  QueryCS_preParamDeclaration ::= query QueryNameCS (
            //
            case 320: {
                
				QueryCS result = QVTcCSTFactory.eINSTANCE.createQueryCS();
				result.setPathName((PathNameCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 322:  QueryCS_postParamDeclaration ::= QueryCS_preParamDeclaration paramDeclarationCS
            //
            case 322: {
                
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)dtParser.getSym(2);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.getInputParamDeclaration().add(paramDeclarationCS);
				setOffsets(result, result, paramDeclarationCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 323:  QueryCS_postType ::= QueryCS_postParamDeclaration ) : typeCS
            //
            case 323: {
                
				TypeCS typeCS = (TypeCS)dtParser.getSym(4);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setType(typeCS);
				setOffsets(result, result, typeCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 324:  QueryCS ::= QueryCS_postType ;
            //
            case 324: {
                
				QueryCS result = (QueryCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 325:  QueryCS ::= QueryCS_postType { OclExpressionCS }
            //
            case 325: {
                
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setOclExpression((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 326:  paramDeclarationCS ::= ERROR_identifierCS : typeCS
            //
            case 326:
 
            //
            // Rule 327:  paramDeclarationCS ::= identifierCS : typeCS
            //
            case 327: {
                
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
            // Rule 328:  paramDeclarationCS ::= identifierCS ERROR_Colon
            //
            case 328: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				ParamDeclarationCS result = QVTcCSTFactory.eINSTANCE.createParamDeclarationCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 340:  ERROR_identifierCS ::= ERROR_TOKEN
            //
            case 340: {
                
				int token = dtParser.getToken(1);
				reportErrorTokenMessage(token, QVTcParserErrors.MISSING_IDENTIFIER);
				IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
				result.setValue(getTokenText(token));
				setOffsets(result, getIToken(token));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 341:  identifierCS ::= IDENTIFIER
            //
            case 341: {
                
				int token = dtParser.getToken(1);
				IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
				result.setValue(getTokenText(token));
				setOffsets(result, getIToken(token));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 342:  identifierCS ::= STRING_LITERAL
            //
            case 342: {
                
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

