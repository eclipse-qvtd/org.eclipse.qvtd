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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   E.D.Willink - Extended API and implementation for QVTr
*
* </copyright>
*
* $Id: QVTrParser.java,v 1.16 2010/01/05 11:42:03 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;


import org.eclipse.qvt.declarative.parser.qvt.cst.*;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.*;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.parser.AbstractOCLParser;
import org.eclipse.ocl.parser.backtracking.OCLParserErrors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;

import lpg.runtime.BadParseException;
import lpg.runtime.BadParseSymFileException;
import lpg.runtime.BacktrackingParser;
import lpg.runtime.DiagnoseParser;
import lpg.runtime.IToken;
import lpg.runtime.Monitor;
import lpg.runtime.NotBacktrackParseTableException;
import lpg.runtime.ParseTable;
import lpg.runtime.RuleAction;

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
            if (error_repair_count > 0)                
            	return (CSTNode) dtParser.parse(error_repair_count);
            else
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
                SimpleNameCS result = createSimpleNameCS(
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
                SimpleNameCS result = createSimpleNameCS(
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
                
                PrimitiveTypeCS result = createPrimitiveTypeCS(
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
                
                PrimitiveTypeCS result = createPrimitiveTypeCS(
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
                
                PrimitiveTypeCS result = createPrimitiveTypeCS(
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
                
                PrimitiveTypeCS result = createPrimitiveTypeCS(
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
                
                PrimitiveTypeCS result = createPrimitiveTypeCS(
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
                
                PrimitiveTypeCS result = createPrimitiveTypeCS(
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
                
                PrimitiveTypeCS result = createPrimitiveTypeCS(
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
                
                PrimitiveTypeCS result = createPrimitiveTypeCS(
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
                
                 TupleTypeCS result = createTupleTypeCS((EList<VariableCS>)dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 58:  tupleTypePartsCSopt ::= $Empty
            //
            case 58: {
                
                dtParser.setSym1(new BasicEList<VariableCS>());
              break;
            }
     
            //
            // Rule 60:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 60: {
                
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 61:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 61: {
                
                EList<VariableCS> result = (EList<VariableCS>)dtParser.getSym(1);
                result.add((VariableCS)dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 62:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 62: {
                
                SimpleNameCS name = (SimpleNameCS)dtParser.getSym(1);
                VariableCS result = createVariableCS(name, null, null);
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
                VariableCS result = createVariableCS(name, type, null);
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
                VariableCS result = createVariableCS(name, null, initExpression);
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
                VariableCS result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 78:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 78: {
                
                CollectionTypeCS typeCS = (CollectionTypeCS)dtParser.getSym(1);
                CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList<CollectionLiteralPartCS>)dtParser.getSym(3)
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
                CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList<CollectionLiteralPartCS>)dtParser.getSym(3)
                    );
                setOffsets(result, typeCS, getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 80:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 80: {
                
                dtParser.setSym1(new BasicEList<CollectionLiteralPartCS>());
              break;
            }
     
            //
            // Rule 82:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 82: {
                
                EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
                result.add((CollectionLiteralPartCS)dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 83:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 83: {
                
                EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>)dtParser.getSym(1);
                result.add((CollectionLiteralPartCS)dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 85:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 85: {
                
                CollectionLiteralPartCS result = createCollectionLiteralPartCS(
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
                
                CollectionLiteralPartCS result = createCollectionRangeCS(
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
                
                TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)dtParser.getSym(3));
                setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 95:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 95: {
                
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 96:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 96: {
                
                EList<VariableCS> result = (EList<VariableCS>)dtParser.getSym(1);
                result.add((VariableCS)dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 97:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 97: {
                
                IntegerLiteralExpCS result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 98:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 98: {
                
                RealLiteralExpCS result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
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
                
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 102:  BooleanLiteralExpCS ::= false
            //
            case 102: {
                
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 103:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 103: {
                
                UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 104:  InvalidLiteralExpCS ::= invalid
            //
            case 104: {
                
                InvalidLiteralExpCS result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
                setOffsets(result, getIToken(dtParser.getToken(1)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 105:  NullLiteralExpCS ::= null
            //
            case 105: {
                
                NullLiteralExpCS result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
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
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
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
                IteratorExpCS result = createIteratorExpCS(
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
                IteratorExpCS result = createIteratorExpCS(
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
                IteratorExpCS result = createIteratorExpCS(
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
                IterateExpCS result = createIterateExpCS(
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
                IterateExpCS result = createIterateExpCS(
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
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)dtParser.getSym(3),
                        null,
                        new BasicEList<OCLExpressionCS>()
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
                OCLExpressionCS result;
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
                    EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
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
                
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)dtParser.getSym(7);
                args.add(0, (OCLExpressionCS)dtParser.getSym(5));
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
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
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(variableExpCS, simpleNameCS);
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)dtParser.getSym(7);
                args.add(0, variableExpCS);
                OCLExpressionCS source = (OCLExpressionCS)dtParser.getSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
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
                        (EList<OCLExpressionCS>)dtParser.getSym(6)
                    );
                setOffsets(result, source, getIToken(dtParser.getToken(7)));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 127:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 127: {
                
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        null,
                        (SimpleNameCS)dtParser.getSym(1),
                        (IsMarkedPreCS)dtParser.getSym(2),
                        (EList<OCLExpressionCS>)dtParser.getSym(4)
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
                        (EList<OCLExpressionCS>)dtParser.getSym(5)
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
                        (EList<OCLExpressionCS>)dtParser.getSym(8)
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
                FeatureCallExpCS result = createFeatureCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
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
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
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
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
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
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (EList<OCLExpressionCS>)dtParser.getSym(5),
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
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        (EList<OCLExpressionCS>)dtParser.getSym(3),
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
            case 137: {
                
                dtParser.setSym1(new BasicEList<OCLExpressionCS>());
              break;
            }
     
            //
            // Rule 139:  argumentsCS ::= OclExpressionCS
            //
            case 139: {
                
                EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
                result.add((OCLExpressionCS)dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 140:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 140: {
                
                EList<OCLExpressionCS> result = (EList<OCLExpressionCS>)dtParser.getSym(1);
                result.add((OCLExpressionCS)dtParser.getSym(3));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 143:  VariableExpCS ::= selfKeywordCS
            //
            case 143: {
                
                SimpleNameCS simpleNameCS = (SimpleNameCS)dtParser.getSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
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
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
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
                EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                args.add(right);
                OperationCallExpCS result = createOperationCallExpCS(
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
                OperationCallExpCS result = createOperationCallExpCS(
                        expr,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, simpleNameCS, expr);
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 221:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 221: {
                
                OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(2);
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
                
                IfExpCS result = createIfExpCS(
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
                LetExpCS result = createLetExpCS(
                        (EList<VariableCS>)dtParser.getSym(2),
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
                
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)dtParser.getSym(1));
                dtParser.setSym1(result);
              break;
            }
     
            //
            // Rule 225:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 225: {
                
                EList<VariableCS> result = (EList<VariableCS>)dtParser.getSym(1);
                result.add((VariableCS)dtParser.getSym(3));
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
				TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 232:  TupleLiteralPartsCS ::= ERROR_TOKEN
            //
            case 232: {
                
				reportErrorTokenMessage(dtParser.getToken(1), OCLParserErrors.MISSING_VARIABLES);
				EList<VariableCS> result = new BasicEList<VariableCS>();
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 233:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
            //
            case 233: {
                
				reportErrorTokenMessage(dtParser.getToken(4), OCLParserErrors.MISSING_RBRACK);
				VariableExpCS result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList<OCLExpressionCS>)dtParser.getSym(3),
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
				IfExpCS result = createIfExpCS(
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
				IfExpCS result = createIfExpCS(
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
				IfExpCS result = createIfExpCS(
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
				IfExpCS result = createIfExpCS(
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
				OCLExpressionCS result = (OCLExpressionCS)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 239:  topLevelCS_0_ ::= $Empty
            //
            case 239: {
                
				TopLevelCS result = QVTrCSTFactory.eINSTANCE.createTopLevelCS();
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 240:  topLevelCS_0_ ::= topLevelCS_0_ import unitCS ;
            //
            case 240: {
                
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				result.getImportClause().add((UnitCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 241:  topLevelCS_0_ ::= topLevelCS_0_ ERROR_TOKEN
            //
            case 241: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_TOPLEVEL);
	          break;
            }
	 
            //
            // Rule 242:  topLevelCS_1_ ::= topLevelCS transformationCS
            //
            case 242: {
                
				TransformationCS transformationCS = (TransformationCS)dtParser.getSym(2);
				TopLevelCS result = (TopLevelCS)dtParser.getSym(1);
				result.getTransformation().add(transformationCS);
				setOffsets(result, result, transformationCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 243:  topLevelCS_1_ ::= topLevelCS_1_ ERROR_TOKEN
            //
            case 243: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION);
	          break;
            }
	 
            //
            // Rule 246:  unitCS ::= identifierCS
            //
            case 246: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				UnitCS result = QVTrCSTFactory.eINSTANCE.createUnitCS();
				result.getIdentifier().add(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 247:  unitCS ::= unitCS . identifierCS
            //
            case 247: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				UnitCS result = (UnitCS)dtParser.getSym(1);
				result.getIdentifier().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 248:  transformationCS_0_ ::= transformation identifierCS ( modelDeclCS
            //
            case 248: {
                
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
            // Rule 249:  transformationCS_0_ ::= transformationCS_0_ , modelDeclCS
            //
            case 249: {
                
				ModelDeclCS modelDeclCS = (ModelDeclCS)dtParser.getSym(3);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getModelDecl().add(modelDeclCS);
				setOffsets(result, result, modelDeclCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 250:  transformationCS_0_ ::= transformationCS_0_ ERROR_TOKEN
            //
            case 250: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL);
	          break;
            }
	 
            //
            // Rule 251:  transformationCS_1_ ::= transformationCS_0_ )
            //
            case 251: {
                
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 253:  transformationCS_2_ ::= transformationCS_1_ extends identifierCS
            //
            case 253: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.setExtends(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 255:  transformationCS_3_ ::= transformationCS_3_ keyDeclCS
            //
            case 255: {
                
				KeyDeclCS keyDeclCS = (KeyDeclCS)dtParser.getSym(2);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getKeyDecl().add(keyDeclCS);
				setOffsets(result, result, keyDeclCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 257:  transformationCS_4_ ::= transformationCS_4_ queryCS
            //
            case 257: {
                
				QueryCS queryCS =(QueryCS)dtParser.getSym(2);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getQuery().add(queryCS);
				setOffsets(result, result, queryCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 258:  transformationCS_4_ ::= transformationCS_4_ relationCS
            //
            case 258: {
                
				RelationCS relationCS = (RelationCS)dtParser.getSym(2);
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				result.getRelation().add(relationCS);
				setOffsets(result, result, relationCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 259:  transformationCS_4_ ::= transformationCS_4_ ERROR_TOKEN
            //
            case 259: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION_ELEMENT);
	          break;
            }
	 
            //
            // Rule 260:  transformationCS ::= transformationCS_4_ }
            //
            case 260: {
                
				TransformationCS result = (TransformationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 261:  modelDeclCS_0_ ::= modelIdCS :
            //
            case 261: {
                
				IdentifierCS modelIdCS = (IdentifierCS)dtParser.getSym(1);
				ModelDeclCS result = QVTrCSTFactory.eINSTANCE.createModelDeclCS();
				result.setModelId(modelIdCS);
				setOffsets(result, modelIdCS, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 264:  modelDeclCS_2_ ::= modelDeclCS_1_ metaModelIdCS
            //
            case 264: 
 
            //
            // Rule 265:  modelDeclCS ::= modelDeclCS_0_ metaModelIdCS
            //
            case 265: {
                
				IdentifierCS metaModelIdCS = (IdentifierCS)dtParser.getSym(2);
				ModelDeclCS result = (ModelDeclCS)dtParser.getSym(1);
				result.getMetaModelId().add(metaModelIdCS);
				setOffsets(result, result, metaModelIdCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 266:  modelDeclCS_2_ ::= modelDeclCS_1_ ERROR_TOKEN
            //
            case 266: 
 
            //
            // Rule 267:  modelDeclCS ::= modelDeclCS_0_ ERROR_TOKEN
            //
            case 267: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_MODELDECL_ELEMENT);
	          break;
            }
	 
            //
            // Rule 268:  modelDeclCS ::= modelDeclCS_2_ }
            //
            case 268: {
                
				ModelDeclCS result = (ModelDeclCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 271:  keyDeclCS_0_ ::= key classIdCS {
            //
            case 271: {
                
				PathNameCS classIdCS = (PathNameCS)dtParser.getSym(2);
				KeyDeclCS result = QVTrCSTFactory.eINSTANCE.createKeyDeclCS();
				result.setClassId(classIdCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 273:  keyDeclCS_1_ ::= keyDeclCS_0_ propertyIdCS
            //
            case 273: {
                
				IdentifiedCS propertyIdCS = (IdentifiedCS)dtParser.getSym(2);
				KeyDeclCS result = (KeyDeclCS)dtParser.getSym(1);
				result.getPropertyId().add(propertyIdCS);
				setOffsets(result, result, propertyIdCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 274:  keyDeclCS_1_ ::= keyDeclCS_0_ ERROR_TOKEN
            //
            case 274: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_KEYDECL_ELEMENT);
	          break;
            }
	 
            //
            // Rule 275:  keyDeclCS ::= keyDeclCS_1_ } ;
            //
            case 275: {
                
				KeyDeclCS result = (KeyDeclCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 277:  propertyIdCS ::= identifierCS
            //
            case 277: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 278:  relationCS_withName ::= relation identifierCS
            //
            case 278: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(2);
				RelationCS result = QVTrCSTFactory.eINSTANCE.createRelationCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, getIToken(dtParser.getToken(1)), identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 280:  relationCS_postName ::= top relationCS_withName
            //
            case 280: {
                
				RelationCS result = (RelationCS)dtParser.getSym(2);
				result.setTop(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 282:  relationCS_postOverrides ::= relationCS_postName overrides identifierCS
            //
            case 282: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				RelationCS result = (RelationCS)dtParser.getSym(1);
				result.setOverrides(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 284:  relationCS_postVariable ::= relationCS_postVariable varDeclarationCS
            //
            case 284: {
                
				VarDeclarationCS varDeclarationCS = (VarDeclarationCS)dtParser.getSym(2);
				RelationCS result = (RelationCS)dtParser.getSym(1);
				result.getVarDeclaration().add(varDeclarationCS);
				setOffsets(result, result, varDeclarationCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 285:  relationCS_postDomain ::= relationCS_postVariable domainCS
            //
            case 285: 
 
            //
            // Rule 286:  relationCS_postDomain ::= relationCS_postDomain domainCS
            //
            case 286: {
                
				AbstractDomainCS domainCS = (AbstractDomainCS)dtParser.getSym(2);
				RelationCS result = (RelationCS)dtParser.getSym(1);
				result.getDomain().add(domainCS);
				setOffsets(result, result, domainCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 288:  relationCS_postWhen ::= relationCS_postDomain whenCS
            //
            case 288: {
                
				RelationCS result = (RelationCS)dtParser.getSym(1);
				WhenCS whenCS = (WhenCS)dtParser.getSym(2);
				result.setWhen(whenCS);
				setOffsets(result, result, whenCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 290:  relationCS_postWhere ::= relationCS_postWhen whereCS
            //
            case 290: {
                
				RelationCS result = (RelationCS)dtParser.getSym(1);
				WhereCS whereCS = (WhereCS)dtParser.getSym(2);
				result.setWhere(whereCS);
				setOffsets(result, result, whereCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 291:  relationCS ::= relationCS_postWhere }
            //
            case 291: {
                
				RelationCS result = (RelationCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 292:  whenCS_0 ::= when {
            //
            case 292: {
                
				WhenCS result = QVTrCSTFactory.eINSTANCE.createWhenCS();
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 293:  whenCS_0 ::= when ERROR_TOKEN
            //
            case 293: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_WHEN);
	          break;
            }
	 
            //
            // Rule 295:  whenCS_1 ::= whenCS_1 OclExpressionCS ;
            //
            case 295: {
                
				WhenCS result = (WhenCS)dtParser.getSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getExpr().add(OclExpressionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 296:  whenCS ::= whenCS_1 }
            //
            case 296: {
                
				WhenCS result = (WhenCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 297:  whereCS_0 ::= where {
            //
            case 297: {
                
				WhereCS result = QVTrCSTFactory.eINSTANCE.createWhereCS();
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 298:  whereCS_0 ::= where ERROR_TOKEN
            //
            case 298: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_WHERE);
	          break;
            }
	 
            //
            // Rule 300:  whereCS_1 ::= whereCS_1 OclExpressionCS ;
            //
            case 300: {
                
				WhereCS result = (WhereCS)dtParser.getSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)dtParser.getSym(2);
				result.getExpr().add(OclExpressionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 301:  whereCS ::= whereCS_1 }
            //
            case 301: {
                
				WhereCS result = (WhereCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 302:  varDeclarationCS_0 ::= identifierCS
            //
            case 302: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				VarDeclarationCS result = QVTrCSTFactory.eINSTANCE.createVarDeclarationCS();
				result.getVarDeclarationId().add(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 303:  varDeclarationCS_0 ::= varDeclarationCS_0 , identifierCS
            //
            case 303: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(3);
				VarDeclarationCS result = (VarDeclarationCS)dtParser.getSym(1);
				result.getVarDeclarationId().add(identifierCS);
				setOffsets(result, result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 304:  varDeclarationCS ::= varDeclarationCS_0 : typeCS ;
            //
            case 304: {
                
				VarDeclarationCS result = (VarDeclarationCS)dtParser.getSym(1);
				result.setType((TypeCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 305:  domainCS_0_ ::= domain modelIdCS templateCS
            //
            case 305: {
                
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
            // Rule 307:  domainCS_1_ ::= checkonly domainCS_0_
            //
            case 307: {
                
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setCheckonly(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 308:  domainCS_1_ ::= enforce domainCS_0_
            //
            case 308: {
                
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setEnforce(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 309:  domainCS_1_ ::= replace domainCS_0_
            //
            case 309: {
                
				DomainCS result = (DomainCS)dtParser.getSym(2);
				result.setReplace(true);
				setOffsets(result, getIToken(dtParser.getToken(1)), result);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 311:  domainCS_postImplementedby ::= domainCS_1_ implementedby OperationCallExpCS
            //
            case 311: {
                
				DomainCS result = (DomainCS)dtParser.getSym(1);
				OperationCallExpCS operationCallExpCS =(OperationCallExpCS)dtParser.getSym(3);
				result.setImplementedBy(operationCallExpCS);
				setOffsets(result, result, operationCallExpCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 313:  domainCS_preDefaultValue ::= domainCS_preDefaultValue defaultValueCS
            //
            case 313: {
                
				DomainCS result = (DomainCS)dtParser.getSym(1);
				DefaultValueCS defaultValueCS = (DefaultValueCS)dtParser.getSym(2);
				result.getDefaultValue().add(defaultValueCS);
				setOffsets(result, result, defaultValueCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 315:  domainCS_postDefaultValues ::= domainCS_preDefaultValue }
            //
            case 315: {
                
				DomainCS result = (DomainCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 316:  domainCS ::= domainCS_postDefaultValues ;
            //
            case 316: {
                
				DomainCS result = (DomainCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 317:  domainCS ::= primitive domain identifierCS : typeCS ;
            //
            case 317: {
                
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
            // Rule 321:  templateCS ::= templateCS_0_ { OclExpressionCS }
            //
            case 321: {
                
				TemplateCS result = (TemplateCS)dtParser.getSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)dtParser.getSym(3);
				result.setGuardExpression(OclExpressionCS);
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 325:  objectTemplateCS_prePropertyTemplates ::= simpleNameCS : notCollectionTypeCS {
            //
            case 325: {
                
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
            // Rule 326:  objectTemplateCS_prePropertyTemplates ::= : pathNameCS {
            //
            case 326: {
                
				ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
				result.setIdentifier(createUniqueIdentifierCS(dtParser.getToken(1)));
				result.setType((TypeCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 329:  objectTemplateCS_postPropertyTemplate ::= objectTemplateCS_prePropertyTemplate propertyTemplateCS
            //
            case 329: {
                
				ObjectTemplateCS result = (ObjectTemplateCS)dtParser.getSym(1);
				PropertyTemplateCS propertyTemplateCS = (PropertyTemplateCS)dtParser.getSym(2);
				result.getPropertyTemplate().add(propertyTemplateCS);
				setOffsets(result, result, propertyTemplateCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 330:  objectTemplateCS ::= objectTemplateCS_prePropertyTemplates }
            //
            case 330:
 
            //
            // Rule 331:  objectTemplateCS ::= objectTemplateCS_postPropertyTemplate }
            //
            case 331: {
                
				ObjectTemplateCS result = (ObjectTemplateCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 332:  propertyTemplateCS ::= propertyIdCS = OclExpressionCS
            //
            case 332: {
                
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
            // Rule 333:  collectionTemplateCS_1_ ::= : collectionTypeCS
            //
            case 333: {
                
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)dtParser.getSym(2);
				CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
				result.setType(collectionTypeCS);
				result.setIdentifier(createUniqueIdentifierCS(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)), collectionTypeCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 334:  collectionTemplateCS_1_ ::= simpleNameCS : collectionTypeCS
            //
            case 334: {
                
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
            // Rule 338:  collectionTemplateCS_postMemberSelection ::= collectionTemplateCS_preMemberSelection memberSelectorCS
            //
            case 338: {
                
				IdentifiedCS memberSelectorCS = (IdentifiedCS)dtParser.getSym(2);
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				result.getMemberIdentifier().add(memberSelectorCS);
				setOffsets(result, result, memberSelectorCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 339:  collectionTemplateCS ::= collectionTemplateCS_postMemberSelection PLUS_PLUS identifierCS }
            //
            case 339: {
                
				IdentifierCS restIdentifier = (IdentifierCS)dtParser.getSym(3);
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				result.setRestIdentifier(restIdentifier);
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 340:  collectionTemplateCS ::= collectionTemplateCS_postMemberSelection ERROR_TOKEN }
            //
            case 340: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_REST);
				IdentifierCS restIdentifier = createUniqueIdentifierCS(dtParser.getToken(2));
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				result.setRestIdentifier(restIdentifier);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 341:  collectionTemplateCS ::= collectionTemplateCS_preMemberSelections }
            //
            case 341: {
                
				CollectionTemplateCS result = (CollectionTemplateCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(2)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 342:  memberSelectorCS ::= identifierCS
            //
            case 342: {
                
				IdentifierCS identifierCS = (IdentifierCS)dtParser.getSym(1);
				IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 344:  defaultValueCS ::= identifierCS = OclExpressionCS ;
            //
            case 344: {
                
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
            // Rule 345:  queryCS_preParamDeclaration ::= query pathNameCS (
            //
            case 345: {
                
				QueryCS result = QVTrCSTFactory.eINSTANCE.createQueryCS();
				result.setPathName((PathNameCS)dtParser.getSym(2));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 347:  queryCS_postParamDeclaration ::= queryCS_preParamDeclaration paramDeclarationCS
            //
            case 347: {
                
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)dtParser.getSym(2);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.getInputParamDeclaration().add(paramDeclarationCS);
				setOffsets(result, result, paramDeclarationCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 348:  queryCS_postType ::= queryCS_postParamDeclaration ) : typeCS
            //
            case 348: {
                
				TypeCS typeCS = (TypeCS)dtParser.getSym(4);
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setType(typeCS);
				setOffsets(result, result, typeCS);
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 349:  queryCS ::= queryCS_postType ;
            //
            case 349: {
                
				QueryCS result = (QueryCS)dtParser.getSym(1);
				setOffsets(result, result, getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 350:  queryCS ::= queryCS_postType { OclExpressionCS }
            //
            case 350: {
                
				QueryCS result = (QueryCS)dtParser.getSym(1);
				result.setOclExpression((OCLExpressionCS)dtParser.getSym(3));
				setOffsets(result, result, getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	          break;
            }
	 
            //
            // Rule 351:  paramDeclarationCS ::= identifierCS : typeCS
            //
            case 351: {
                
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
            // Rule 352:  paramDeclarationCS ::= identifierCS ERROR_TOKEN
            //
            case 352: {
                
				reportErrorTokenMessage(dtParser.getToken(2), QVTrParserErrors.INCOMPLETE_PARAM_DECLARATION);
	          break;
            }
	 
            //
            // Rule 372:  identifierCS ::= IDENTIFIER
            //
            case 372: 
 
            //
            // Rule 373:  identifierCS ::= relationIdentifier
            //
            case 373: 
 
            //
            // Rule 374:  identifierCS ::= self
            //
            case 374: {
                
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

