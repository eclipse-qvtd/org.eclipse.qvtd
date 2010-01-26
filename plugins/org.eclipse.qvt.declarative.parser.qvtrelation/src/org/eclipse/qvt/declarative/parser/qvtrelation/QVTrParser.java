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
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: QVTrParser.java,v 1.17 2010/01/26 22:03:22 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtrelation;

import lpg.runtime.*;

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
import org.eclipse.ocl.lpg.DerivedPrsStream;

import lpg.runtime.BadParseException;
import lpg.runtime.BadParseSymFileException;
import lpg.runtime.DiagnoseParser;
import lpg.runtime.ErrorToken;
import lpg.runtime.IToken;
import lpg.runtime.ILexStream;
import lpg.runtime.Monitor;
import lpg.runtime.NullExportedSymbolsException;
import lpg.runtime.NullTerminalSymbolsException;
import lpg.runtime.ParseTable;
import lpg.runtime.RuleAction;
import lpg.runtime.UndefinedEofSymbolException;
import lpg.runtime.UnimplementedTerminalsException;	

public class QVTrParser extends AbstractOCLParser implements RuleAction
{
    private DerivedPrsStream prsStream = null;
    
    private boolean unimplementedSymbolsWarning = false;

    private static ParseTable prsTable = new QVTrParserprs();
    public ParseTable getParseTable() { return prsTable; }

    private BacktrackingParser btParser = null;
    public BacktrackingParser getParser() { return btParser; }

    protected void setResult(Object object) { btParser.setSym1(object); }
    protected Object getRhsSym(int i) { return btParser.getSym(i); }

    protected int getRhsTokenIndex(int i) { return btParser.getToken(i); }
    protected IToken getRhsIToken(int i) { return prsStream.getIToken(getRhsTokenIndex(i)); }
    
    protected int getRhsFirstTokenIndex(int i) { return btParser.getFirstToken(i); }
    protected IToken getRhsFirstIToken(int i) { return prsStream.getIToken(getRhsFirstTokenIndex(i)); }

    protected int getRhsLastTokenIndex(int i) { return btParser.getLastToken(i); }
    protected IToken getRhsLastIToken(int i) { return prsStream.getIToken(getRhsLastTokenIndex(i)); }

    protected int getLeftSpan() { return btParser.getFirstToken(); }
    protected IToken getLeftIToken()  { return prsStream.getIToken(getLeftSpan()); }

    protected int getRightSpan() { return btParser.getLastToken(); }
    protected IToken getRightIToken() { return prsStream.getIToken(getRightSpan()); }

    protected int getRhsErrorTokenIndex(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    protected ErrorToken getRhsErrorIToken(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

	@SuppressWarnings("nls")
    public void reset(ILexStream lexStream)
    {
        prsStream = new DerivedPrsStream(getEnvironment(), lexStream);
        btParser.reset(prsStream);

        try
        {
            prsStream.remapTerminalSymbols(orderedTerminalSymbols(), prsTable.getEoftSymbol());
        }
        catch(NullExportedSymbolsException e) {
        }
        catch(NullTerminalSymbolsException e) {
        }
        catch(UnimplementedTerminalsException e)
        {
            if (unimplementedSymbolsWarning) {
                java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
                System.out.println("The Lexer will not scan the following token(s):");
                for (int i = 0; i < unimplemented_symbols.size(); i++)
                {
                    Integer id = (Integer) unimplemented_symbols.get(i);
                    System.out.println("    " + QVTrParsersym.orderedTerminalSymbols[id.intValue()]);               
                }
                System.out.println();
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 QVTrParsersym.orderedTerminalSymbols[prsTable.getEoftSymbol()]));
        } 
    }
    
    @SuppressWarnings("nls")
    public QVTrParser(QVTrLexer lexer)        
    {
    		super(lexer);
        try
        {
            btParser = new BacktrackingParser(prsStream, prsTable, this);
        }
        catch (NotBacktrackParseTableException e)
        {
            throw new Error(new NotBacktrackParseTableException
                                ("Regenerate QVTrParserprs.java with -BACKTRACK option"));
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- QVTrParsersym.java"));
        }
        
        ILexStream lexStream = lexer.getILexStream();
        if (lexStream != null) {
        	reset(lexStream);
        }
    }
    
    public int numTokenKinds() { return QVTrParsersym.numTokenKinds; }
    public String[] orderedTerminalSymbols() { return QVTrParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return QVTrParsersym.orderedTerminalSymbols[kind]; }
    public int getEOFTokenKind() { return prsTable.getEoftSymbol(); }
    public DerivedPrsStream getIPrsStream() { return prsStream; }

    public CSTNode parser()
    {
        return parser(null, getDefaultRepairCount());
    }
    
    public CSTNode parser(Monitor monitor)
    {
        return parser(monitor, getDefaultRepairCount());
    }
    
    public CSTNode parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }

    public CSTNode parser(Monitor monitor, int error_repair_count)
    {
        btParser.setMonitor(monitor);
        
        try
        {
        	if (error_repair_count > 0)
            	return (CSTNode) btParser.fuzzyParse(error_repair_count);
            else
            	return (CSTNode) btParser.parse(error_repair_count);
        }
        catch (BadParseException e)
        {
            prsStream.reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }

    //
    // Additional entry points, if any
    //
    


public ICSTFileEnvironment getOCLEnvironment() {
	return getLexer().getOCLEnvironment();
}
	
@Override
public QVTrLexer getLexer() {
	return (QVTrLexer) super.getLexer();
}



// Some methods for backwards compatibility 
/**
* <p>
* Before 3.0, this method was used with the now-deprecated  "dollar"getToken macro (which
* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
* right hand side token in the said rule. In 3.0 a convenience method has been introduced
* in order to directly return the IToken, given the index of the right hand side token in the rule.
* </p> 
*
* <p>
* In an action-block of a rule, instead of doing <code>getIToken("dollar"getToken(i))</code> 
* you should do <code>getRhsTokenText(i)</code>
* </p>
* @param i the right hand side token index
* @return the correspondent IToken.
*
* @since 3.0	
* @deprecated
*/
protected IToken getIToken(int i) {
	return prsStream.getIToken(i);
}

/**
* <p>
* Before 3.0, this method was used with the now-deprecated "dollar"getToken macro (which
* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
* right hand side token in the said rule. In 3.0 a convenience method has been introduced
* in order to directly return the IToken, given the index of the right hand side token in the rule.
* </p> 
* 
* <p>
* In an action-block of a rule, instead of doing <code>getTokenText("dollar"getToken(i))</code> 
* you should do <code>getRhsTokenText(i)</code>
* </p>
* @param i the right hand side token index
* @result the text of the correspondent right hand side IToken.
*
* @deprecated 
*/
protected String getTokenText(int i) {
	return prsStream.getTokenText(i);
}

/**
* A convenience method to obtain the text of a right hand side IToken.
*  
* @param i the right hand side token index
* @result the text of the correspondent right hand side IToken.
*
* @since 3.0
*/
protected String getRhsTokenText(int i) { 
	return prsStream.getTokenText(getRhsTokenIndex(i));
}

// Some methods for backwards compatibility

/**
 * Report error message for given error_token.
 * 
 * @param error_token
 *            the error taken index
 * @param msg
 *            the message to report
 * 
 * @since 1.3
 */
protected final void reportErrorTokenMessage(int error_token, String msg) {
	getIPrsStream().reportErrorTokenMessage(error_token, msg); 
}
			
	protected IdentifierCS createIdentifierCS(int argumentNumber) {
		IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
		result.setValue(getRhsTokenText(argumentNumber));
		setOffsets(result, getRhsIToken(argumentNumber));
		return result;
	}

	private int _uniqueNameCount = 0;

	protected IdentifierCS createUniqueIdentifierCS(int argumentNumber) {
		IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
		result.setValue("_unique" + _uniqueNameCount++);
		setOffsets(result, getRhsIToken(argumentNumber));
		return result;
	}

	@SuppressWarnings("unchecked")
    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {

            //
            // Rule 16:  conceptualOperationNameCS ::= conceptualOperationName
            //
            case 16: {
               //#line 297 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createConceptualOperationNameCS(iToken);
                setOffsets(result, iToken);
                setResult(result);
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
               //#line 320 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            iToken
                        );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 33:  selfKeywordCS ::= self
            //
            case 33: {
               //#line 339 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.SELF_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 34:  simpleNameCS ::= IDENTIFIER
            //
            case 34: {
               //#line 351 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 37:  pathNameCS ::= simpleNameCS
            //
            case 37: {
               //#line 366 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleName = (SimpleNameCS)getRhsSym(1);
                PathNameCS result = createPathNameCS(simpleName);
                setOffsets(result, simpleName);
                setResult(result);
                      break;
            }
    
            //
            // Rule 38:  pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
            //
            case 38: {
               //#line 374 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PathNameCS result = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                result = extendPathNameCS(result, simpleNameCS);
                setOffsets(result, result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 39:  primitiveTypeCS ::= Boolean
            //
            case 39: {
               //#line 387 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.BOOLEAN_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 40:  primitiveTypeCS ::= Integer
            //
            case 40: {
               //#line 397 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.INTEGER_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 41:  primitiveTypeCS ::= Real
            //
            case 41: {
               //#line 407 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.REAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 42:  primitiveTypeCS ::= String
            //
            case 42: {
               //#line 417 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.STRING_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 43:  primitiveTypeCS ::= UnlimitedNatural
            //
            case 43: {
               //#line 427 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 44:  primitiveTypeCS ::= OclAny
            //
            case 44: {
               //#line 438 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_ANY_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 45:  primitiveTypeCS ::= OclInvalid
            //
            case 45: {
               //#line 448 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_INVALID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 46:  primitiveTypeCS ::= OclVoid
            //
            case 46: {
               //#line 458 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_VOID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 47:  CollectionTypeIdentifierCS ::= Set
            //
            case 47: {
               //#line 469 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 48:  CollectionTypeIdentifierCS ::= Bag
            //
            case 48: {
               //#line 479 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.BAG_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 49:  CollectionTypeIdentifierCS ::= Sequence
            //
            case 49: {
               //#line 489 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 50:  CollectionTypeIdentifierCS ::= Collection
            //
            case 50: {
               //#line 499 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 51:  CollectionTypeIdentifierCS ::= OrderedSet
            //
            case 51: {
               //#line 509 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 56:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
            //
            case 56: {
               //#line 525 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1);
                result.setTypeCS((TypeCS)getRhsSym(3));
                setOffsets(result, result, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 57:  tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
            //
            case 57: {
               //#line 534 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                 TupleTypeCS result = createTupleTypeCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 58:  tupleTypePartsCSopt ::= $Empty
            //
            case 58: {
               //#line 542 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<VariableCS>());
                      break;
            }
    
            //
            // Rule 60:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 60: {
               //#line 549 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 61:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 61: {
               //#line 556 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 62:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 62: {
               //#line 567 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                VariableCS result = createVariableCS(name, null, null);
                setOffsets(result, name);
                setResult(result);
                      break;
            }
    
            //
            // Rule 63:  typedUninitializedVariableCS ::= simpleNameCS : typeCS
            //
            case 63: {
               //#line 576 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, type, null);
                setOffsets(result, name, type);
                setResult(result);
                      break;
            }
    
            //
            // Rule 64:  untypedInitializedVariableCS ::= simpleNameCS = OclExpressionCS
            //
            case 64: {
               //#line 586 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, null, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 65:  typedInitializedVariableCS ::= simpleNameCS : typeCS = OclExpressionCS
            //
            case 65: {
               //#line 596 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(5);
                VariableCS result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 78:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 78: {
               //#line 629 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                CollectionTypeCS typeCS = (CollectionTypeCS)getRhsSym(1);
                CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList<CollectionLiteralPartCS>)getRhsSym(3)
                    );
                setOffsets(result, typeCS, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 79:  CollectionLiteralExpCS ::= collectionTypeCS { CollectionLiteralPartsCSopt }
            //
            case 79: {
               //#line 640 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                CollectionTypeCS typeCS = (CollectionTypeCS)getRhsSym(1);
                CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList<CollectionLiteralPartCS>)getRhsSym(3)
                    );
                setOffsets(result, typeCS, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 80:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 80: {
               //#line 652 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<CollectionLiteralPartCS>());
                      break;
            }
    
            //
            // Rule 82:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 82: {
               //#line 659 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
                result.add((CollectionLiteralPartCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 83:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 83: {
               //#line 666 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>)getRhsSym(1);
                result.add((CollectionLiteralPartCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 85:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 85: {
               //#line 675 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                CollectionLiteralPartCS result = createCollectionLiteralPartCS(
                        (OCLExpressionCS)getRhsSym(1)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 86:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
            //
            case 86: {
               //#line 685 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                CollectionLiteralPartCS result = createCollectionRangeCS(
                        (OCLExpressionCS)getRhsSym(1),
                        (OCLExpressionCS)getRhsSym(3)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 94:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
            //
            case 94: {
               //#line 704 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 95:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 95: {
               //#line 712 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 96:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 96: {
               //#line 719 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 97:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 97: {
               //#line 727 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IntegerLiteralExpCS result = createIntegerLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 98:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 98: {
               //#line 735 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                RealLiteralExpCS result = createRealLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 99:  StringLiteralExpCS ::= STRING_LITERAL
            //
            case 99: {
               //#line 743 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IToken literalToken = getRhsIToken(1);
                StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                setOffsets(result, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 100:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
            //
            case 100: {
               //#line 751 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                StringLiteralExpCS string = (StringLiteralExpCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 101:  BooleanLiteralExpCS ::= true
            //
            case 101: {
               //#line 761 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 102:  BooleanLiteralExpCS ::= false
            //
            case 102: {
               //#line 768 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 103:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 103: {
               //#line 776 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 104:  InvalidLiteralExpCS ::= invalid
            //
            case 104: {
               //#line 784 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                InvalidLiteralExpCS result = createInvalidLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 105:  NullLiteralExpCS ::= null
            //
            case 105: {
               //#line 792 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                NullLiteralExpCS result = createNullLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
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
               //#line 806 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 113:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS | OclExpressionCS )
            //
            case 113: {
               //#line 831 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        null,
                        (OCLExpressionCS)getRhsSym(7)
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 114:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 114: {
               //#line 848 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(5);
                VariableCS variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        variableCS,
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 115:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( typedUninitializedVariableCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 115: {
               //#line 868 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 116:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( typedInitializedVariableCS | OclExpressionCS )
            //
            case 116: {
               //#line 889 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        null,
                        (OCLExpressionCS)getRhsSym(7)
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 117:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS ; typedInitializedVariableCS | OclExpressionCS )
            //
            case 117: {
               //#line 905 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 121:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
            //
            case 121: {
               //#line 927 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, source, getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 122:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( OclExpressionCS )
            //
            case 122: {
               //#line 941 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OCLExpressionCS arg = (OCLExpressionCS)getRhsSym(5);
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
                setOffsets(result, source, getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 123:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( notNameExpressionCS , argumentsCS )
            //
            case 123: {
               //#line 971 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                args.add(0, (OCLExpressionCS)getRhsSym(5));
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 124:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , argumentsCS )
            //
            case 124: {
               //#line 987 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                OCLExpressionCS variableExpCS = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(variableExpCS, simpleNameCS);
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                args.add(0, variableExpCS);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
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
               //#line 1013 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (IsMarkedPreCS)getRhsSym(4),
                        (EList<OCLExpressionCS>)getRhsSym(6)
                    );
                setOffsets(result, source, getRhsIToken(7));
                setResult(result);
                      break;
            }
    
            //
            // Rule 127:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 127: {
               //#line 1029 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        null,
                        (SimpleNameCS)getRhsSym(1),
                        (IsMarkedPreCS)getRhsSym(2),
                        (EList<OCLExpressionCS>)getRhsSym(4)
                    );
                setOffsets(result, getRhsIToken(1), getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 128:  OperationCallExpCS ::= pathNameCS :: unreservedSimpleNameCS ( argumentsCSopt )
            //
            case 128: {
               //#line 1043 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        null,
                        (EList<OCLExpressionCS>)getRhsSym(5)
                    );
                setOffsets(result, pathNameCS, getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 129:  OperationCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 129: {
               //#line 1061 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        (IsMarkedPreCS)getRhsSym(6),
                        (EList<OCLExpressionCS>)getRhsSym(8)
                    );
                setOffsets(result, source, getRhsIToken(9));
                setResult(result);
                      break;
            }
    
            //
            // Rule 131:  PropertyCallExpCS ::= pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 131: {
               //#line 1085 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
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
                setResult(result);
                      break;
            }
    
            //
            // Rule 132:  PropertyCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 132: {
               //#line 1106 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(6);
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
                setResult(result);
                      break;
            }
    
            //
            // Rule 133:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt
            //
            case 133: {
               //#line 1129 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
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
                setResult(result);
                      break;
            }
    
            //
            // Rule 134:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 134: {
               //#line 1150 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(7);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (EList<OCLExpressionCS>)getRhsSym(5),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, getRhsIToken(6));
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 135:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 135: {
               //#line 1173 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(5);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        (EList<OCLExpressionCS>)getRhsSym(3),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, simpleNameCS, isMarkedPreCS);
                } else {
                    setOffsets(result, simpleNameCS, getRhsIToken(4));
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 136:  isMarkedPreCSopt ::= $Empty
            //
            case 136: {
               //#line 1191 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                setResult(null);
                      break;
            }
    
            //
            // Rule 137:  argumentsCSopt ::= $Empty
            //
            case 137: {
               //#line 1197 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<OCLExpressionCS>());
                      break;
            }
    
            //
            // Rule 139:  argumentsCS ::= OclExpressionCS
            //
            case 139: {
               //#line 1204 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
                result.add((OCLExpressionCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 140:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 140: {
               //#line 1211 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> result = (EList<OCLExpressionCS>)getRhsSym(1);
                result.add((OCLExpressionCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 143:  VariableExpCS ::= selfKeywordCS
            //
            case 143: {
               //#line 1236 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 144:  SimpleNameExpCS ::= simpleNameCS
            //
            case 144: {
               //#line 1251 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
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
               //#line 1360 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getRhsIToken(2)
                        );
                setOffsets(simpleNameCS, getRhsIToken(2));
                OCLExpressionCS left = (OCLExpressionCS)getRhsSym(1);
                OCLExpressionCS right = (OCLExpressionCS)getRhsSym(3);
                EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                args.add(right);
                OperationCallExpCS result = createOperationCallExpCS(
                        left,
                        simpleNameCS,
                        args
                    );
                setOffsets(result, left, right);
                setResult(result);
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
               //#line 1391 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getRhsIToken(1)
                        );
                setOffsets(simpleNameCS, getRhsIToken(1));
                OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(2);
                OperationCallExpCS result = createOperationCallExpCS(
                        expr,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, simpleNameCS, expr);
                setResult(result);
                      break;
            }
    
            //
            // Rule 221:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 221: {
               //#line 1417 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
                if (result instanceof OperationCallExpCS) {
                    ((OperationCallExpCS)result).setIsAtomic(true);
                }
                setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 222:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif
            //
            case 222: {
               //#line 1428 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IfExpCS result = createIfExpCS(
                        (OCLExpressionCS)getRhsSym(2),
                        (OCLExpressionCS)getRhsSym(4),
                        (OCLExpressionCS)getRhsSym(6)
                    );
                setOffsets(result, getRhsIToken(1), getRhsIToken(7));
                setResult(result);
                      break;
            }
    
            //
            // Rule 223:  LetExpCS ::= let letVariablesCS in OclExpressionCS
            //
            case 223: {
               //#line 1440 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(4);
                LetExpCS result = createLetExpCS(
                        (EList<VariableCS>)getRhsSym(2),
                        expr
                    );
                setOffsets(result, getRhsIToken(1), expr);
                setResult(result);
                      break;
            }
    
            //
            // Rule 224:  letVariablesCS ::= typedInitializedVariableCS
            //
            case 224: {
               //#line 1452 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 225:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 225: {
               //#line 1459 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 226:  ERROR_Colon ::= ERROR_TOKEN
            //
            case 226: {
               //#line 48 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_COLON);
	                  break;
            }
	
            //
            // Rule 227:  ERROR_Empty ::= ERROR_TOKEN
            //
            case 227: {
               //#line 53 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.EXTRA_TOKENS);
	                  break;
            }
	
            //
            // Rule 228:  ERROR_SimpleNameCS ::= ERROR_TOKEN
            //
            case 228: {
               //#line 63 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
									
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_SIMPLE_NAME);
                IToken iToken = getRhsIToken(1);
				SimpleNameCS result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						iToken
					);
				setOffsets(result, iToken);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 230:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS ERROR_TOKEN
            //
            case 230: {
               //#line 82 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(4), OCLParserErrors.MISSING_RPAREN);
				CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1); 
				result.setTypeCS((TypeCS)getRhsSym(3));
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 231:  TupleLiteralExpCS ::= Tuple ERROR_TOKEN
            //
            case 231: {
               //#line 116 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), OCLParserErrors.MISSING_LBRACE);
				TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 232:  TupleLiteralPartsCS ::= ERROR_TOKEN
            //
            case 232: {
               //#line 125 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_VARIABLES);
				EList<VariableCS> result = new BasicEList<VariableCS>();
				setResult(result);
	                  break;
            }
	
            //
            // Rule 233:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
            //
            case 233: {
               //#line 136 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(4), OCLParserErrors.MISSING_RBRACK);
				VariableExpCS result = createVariableExpCS(
						(SimpleNameCS)getRhsSym(1),
						(EList<OCLExpressionCS>)getRhsSym(3),
						null
					);
				setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 234:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS ERROR_TOKEN
            //
            case 234: {
               //#line 152 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(7), OCLParserErrors.MISSING_ENDIF);
				IfExpCS result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						(OCLExpressionCS)getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 235:  IfExpCS ::= if OclExpressionCS then OclExpressionCS ERROR_TOKEN
            //
            case 235: {
               //#line 164 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(5), OCLParserErrors.MISSING_ELSE_ENDIF);
				IfExpCS result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						createInvalidLiteralExpCS(getRhsTokenText(5))
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 236:  IfExpCS ::= if OclExpressionCS ERROR_TOKEN
            //
            case 236: {
               //#line 176 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_THEN_ELSE_ENDIF);
				IfExpCS result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						createInvalidLiteralExpCS(getRhsTokenText(3)),
						createInvalidLiteralExpCS(getRhsTokenText(3))
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 237:  IfExpCS ::= if ERROR_TOKEN endif
            //
            case 237: {
               //#line 188 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_THEN_ELSE);
				IfExpCS result = createIfExpCS(
						createInvalidLiteralExpCS(getRhsTokenText(2)),
						createInvalidLiteralExpCS(getRhsTokenText(2)),
						createInvalidLiteralExpCS(getRhsTokenText(2))
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 238:  primaryExpCS ::= ( OclExpressionCS ERROR_TOKEN
            //
            case 238: {
               //#line 201 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_RPAREN);
				OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 239:  topLevelCS_0_ ::= $Empty
            //
            case 239: {
               //#line 106 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TopLevelCS result = QVTrCSTFactory.eINSTANCE.createTopLevelCS();
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 240:  topLevelCS_0_ ::= topLevelCS_0_ import unitCS ;
            //
            case 240: {
               //#line 113 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TopLevelCS result = (TopLevelCS)getRhsSym(1);
				result.getImportClause().add((UnitCS)getRhsSym(3));
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 241:  topLevelCS_0_ ::= topLevelCS_0_ ERROR_TOKEN
            //
            case 241: {
               //#line 121 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_TOPLEVEL);
	                  break;
            }
	
            //
            // Rule 242:  topLevelCS_1_ ::= topLevelCS transformationCS
            //
            case 242: {
               //#line 126 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TransformationCS transformationCS = (TransformationCS)getRhsSym(2);
				TopLevelCS result = (TopLevelCS)getRhsSym(1);
				result.getTransformation().add(transformationCS);
				setOffsets(result, result, transformationCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 243:  topLevelCS_1_ ::= topLevelCS_1_ ERROR_TOKEN
            //
            case 243: {
               //#line 135 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION);
	                  break;
            }
	
            //
            // Rule 246:  unitCS ::= identifierCS
            //
            case 246: {
               //#line 144 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				UnitCS result = QVTrCSTFactory.eINSTANCE.createUnitCS();
				result.getIdentifier().add(identifierCS);
				setOffsets(result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 247:  unitCS ::= unitCS . identifierCS
            //
            case 247: {
               //#line 153 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
				UnitCS result = (UnitCS)getRhsSym(1);
				result.getIdentifier().add(identifierCS);
				setOffsets(result, result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 248:  transformationCS_0_ ::= transformation identifierCS ( modelDeclCS
            //
            case 248: {
               //#line 167 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
				ModelDeclCS modelDeclCS = (ModelDeclCS)getRhsSym(4);
				TransformationCS result = QVTrCSTFactory.eINSTANCE.createTransformationCS();
				result.setIdentifier(identifierCS);
				result.getModelDecl().add(modelDeclCS);
				setOffsets(result, getRhsIToken(1), modelDeclCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 249:  transformationCS_0_ ::= transformationCS_0_ , modelDeclCS
            //
            case 249: {
               //#line 178 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				ModelDeclCS modelDeclCS = (ModelDeclCS)getRhsSym(3);
				TransformationCS result = (TransformationCS)getRhsSym(1);
				result.getModelDecl().add(modelDeclCS);
				setOffsets(result, result, modelDeclCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 250:  transformationCS_0_ ::= transformationCS_0_ ERROR_TOKEN
            //
            case 250: {
               //#line 187 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_MODELDECL);
	                  break;
            }
	
            //
            // Rule 251:  transformationCS_1_ ::= transformationCS_0_ )
            //
            case 251: {
               //#line 192 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TransformationCS result = (TransformationCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 253:  transformationCS_2_ ::= transformationCS_1_ extends identifierCS
            //
            case 253: {
               //#line 200 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
				TransformationCS result = (TransformationCS)getRhsSym(1);
				result.setExtends(identifierCS);
				setOffsets(result, result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 255:  transformationCS_3_ ::= transformationCS_3_ keyDeclCS
            //
            case 255: {
               //#line 210 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				KeyDeclCS keyDeclCS = (KeyDeclCS)getRhsSym(2);
				TransformationCS result = (TransformationCS)getRhsSym(1);
				result.getKeyDecl().add(keyDeclCS);
				setOffsets(result, result, keyDeclCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 257:  transformationCS_4_ ::= transformationCS_4_ queryCS
            //
            case 257: {
               //#line 220 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				QueryCS queryCS =(QueryCS)getRhsSym(2);
				TransformationCS result = (TransformationCS)getRhsSym(1);
				result.getQuery().add(queryCS);
				setOffsets(result, result, queryCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 258:  transformationCS_4_ ::= transformationCS_4_ relationCS
            //
            case 258: {
               //#line 229 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				RelationCS relationCS = (RelationCS)getRhsSym(2);
				TransformationCS result = (TransformationCS)getRhsSym(1);
				result.getRelation().add(relationCS);
				setOffsets(result, result, relationCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 259:  transformationCS_4_ ::= transformationCS_4_ ERROR_TOKEN
            //
            case 259: {
               //#line 238 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_TRANSFORMATION_ELEMENT);
	                  break;
            }
	
            //
            // Rule 260:  transformationCS ::= transformationCS_4_ }
            //
            case 260: {
               //#line 243 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TransformationCS result = (TransformationCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 261:  modelDeclCS_0_ ::= modelIdCS :
            //
            case 261: {
               //#line 253 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS modelIdCS = (IdentifierCS)getRhsSym(1);
				ModelDeclCS result = QVTrCSTFactory.eINSTANCE.createModelDeclCS();
				result.setModelId(modelIdCS);
				setOffsets(result, modelIdCS, getRhsIToken(2));
				setResult(result);
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
               //#line 266 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS metaModelIdCS = (IdentifierCS)getRhsSym(2);
				ModelDeclCS result = (ModelDeclCS)getRhsSym(1);
				result.getMetaModelId().add(metaModelIdCS);
				setOffsets(result, result, metaModelIdCS);
				setResult(result);
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
               //#line 277 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_MODELDECL_ELEMENT);
	                  break;
            }
	
            //
            // Rule 268:  modelDeclCS ::= modelDeclCS_2_ }
            //
            case 268: {
               //#line 282 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				ModelDeclCS result = (ModelDeclCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 271:  keyDeclCS_0_ ::= key classIdCS {
            //
            case 271: {
               //#line 297 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				PathNameCS classIdCS = (PathNameCS)getRhsSym(2);
				KeyDeclCS result = QVTrCSTFactory.eINSTANCE.createKeyDeclCS();
				result.setClassId(classIdCS);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 273:  keyDeclCS_1_ ::= keyDeclCS_0_ propertyIdCS
            //
            case 273: {
               //#line 307 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifiedCS propertyIdCS = (IdentifiedCS)getRhsSym(2);
				KeyDeclCS result = (KeyDeclCS)getRhsSym(1);
				result.getPropertyId().add(propertyIdCS);
				setOffsets(result, result, propertyIdCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 274:  keyDeclCS_1_ ::= keyDeclCS_0_ ERROR_TOKEN
            //
            case 274: {
               //#line 316 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_KEYDECL_ELEMENT);
	                  break;
            }
	
            //
            // Rule 275:  keyDeclCS ::= keyDeclCS_1_ } ;
            //
            case 275: {
               //#line 321 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				KeyDeclCS result = (KeyDeclCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 277:  propertyIdCS ::= identifierCS
            //
            case 277: {
               //#line 333 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 278:  relationCS_withName ::= relation identifierCS
            //
            case 278: {
               //#line 352 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
				RelationCS result = QVTrCSTFactory.eINSTANCE.createRelationCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, getRhsIToken(1), identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 280:  relationCS_postName ::= top relationCS_withName
            //
            case 280: {
               //#line 362 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				RelationCS result = (RelationCS)getRhsSym(2);
				result.setTop(true);
				setOffsets(result, getRhsIToken(1), result);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 282:  relationCS_postOverrides ::= relationCS_postName overrides identifierCS
            //
            case 282: {
               //#line 371 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
				RelationCS result = (RelationCS)getRhsSym(1);
				result.setOverrides(identifierCS);
				setOffsets(result, result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 284:  relationCS_postVariable ::= relationCS_postVariable varDeclarationCS
            //
            case 284: {
               //#line 381 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				VarDeclarationCS varDeclarationCS = (VarDeclarationCS)getRhsSym(2);
				RelationCS result = (RelationCS)getRhsSym(1);
				result.getVarDeclaration().add(varDeclarationCS);
				setOffsets(result, result, varDeclarationCS);
				setResult(result);
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
               //#line 392 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				AbstractDomainCS domainCS = (AbstractDomainCS)getRhsSym(2);
				RelationCS result = (RelationCS)getRhsSym(1);
				result.getDomain().add(domainCS);
				setOffsets(result, result, domainCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 288:  relationCS_postWhen ::= relationCS_postDomain whenCS
            //
            case 288: {
               //#line 402 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				RelationCS result = (RelationCS)getRhsSym(1);
				WhenCS whenCS = (WhenCS)getRhsSym(2);
				result.setWhen(whenCS);
				setOffsets(result, result, whenCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 290:  relationCS_postWhere ::= relationCS_postWhen whereCS
            //
            case 290: {
               //#line 412 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				RelationCS result = (RelationCS)getRhsSym(1);
				WhereCS whereCS = (WhereCS)getRhsSym(2);
				result.setWhere(whereCS);
				setOffsets(result, result, whereCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 291:  relationCS ::= relationCS_postWhere }
            //
            case 291: {
               //#line 421 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				RelationCS result = (RelationCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 292:  whenCS_0 ::= when {
            //
            case 292: {
               //#line 429 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				WhenCS result = QVTrCSTFactory.eINSTANCE.createWhenCS();
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 293:  whenCS_0 ::= when ERROR_TOKEN
            //
            case 293: {
               //#line 436 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_WHEN);
	                  break;
            }
	
            //
            // Rule 295:  whenCS_1 ::= whenCS_1 OclExpressionCS ;
            //
            case 295: {
               //#line 442 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				WhenCS result = (WhenCS)getRhsSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(2);
				result.getExpr().add(OclExpressionCS);
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 296:  whenCS ::= whenCS_1 }
            //
            case 296: {
               //#line 451 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				WhenCS result = (WhenCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 297:  whereCS_0 ::= where {
            //
            case 297: {
               //#line 460 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				WhereCS result = QVTrCSTFactory.eINSTANCE.createWhereCS();
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 298:  whereCS_0 ::= where ERROR_TOKEN
            //
            case 298: {
               //#line 467 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_WHERE);
	                  break;
            }
	
            //
            // Rule 300:  whereCS_1 ::= whereCS_1 OclExpressionCS ;
            //
            case 300: {
               //#line 473 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				WhereCS result = (WhereCS)getRhsSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(2);
				result.getExpr().add(OclExpressionCS);
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 301:  whereCS ::= whereCS_1 }
            //
            case 301: {
               //#line 482 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				WhereCS result = (WhereCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 302:  varDeclarationCS_0 ::= identifierCS
            //
            case 302: {
               //#line 492 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				VarDeclarationCS result = QVTrCSTFactory.eINSTANCE.createVarDeclarationCS();
				result.getVarDeclarationId().add(identifierCS);
				setOffsets(result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 303:  varDeclarationCS_0 ::= varDeclarationCS_0 , identifierCS
            //
            case 303: {
               //#line 501 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
				VarDeclarationCS result = (VarDeclarationCS)getRhsSym(1);
				result.getVarDeclarationId().add(identifierCS);
				setOffsets(result, result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 304:  varDeclarationCS ::= varDeclarationCS_0 : typeCS ;
            //
            case 304: {
               //#line 510 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				VarDeclarationCS result = (VarDeclarationCS)getRhsSym(1);
				result.setType((TypeCS)getRhsSym(3));
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 305:  domainCS_0_ ::= domain modelIdCS templateCS
            //
            case 305: {
               //#line 524 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
				TemplateCS templateCS = (TemplateCS)getRhsSym(3);
				DomainCS result = QVTrCSTFactory.eINSTANCE.createDomainCS();
				result.setModelId(identifierCS);
				result.setTemplate(templateCS);
				setOffsets(result, getRhsIToken(1), templateCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 307:  domainCS_1_ ::= checkonly domainCS_0_
            //
            case 307: {
               //#line 536 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DomainCS result = (DomainCS)getRhsSym(2);
				result.setCheckonly(true);
				setOffsets(result, getRhsIToken(1), result);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 308:  domainCS_1_ ::= enforce domainCS_0_
            //
            case 308: {
               //#line 544 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DomainCS result = (DomainCS)getRhsSym(2);
				result.setEnforce(true);
				setOffsets(result, getRhsIToken(1), result);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 309:  domainCS_1_ ::= replace domainCS_0_
            //
            case 309: {
               //#line 552 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DomainCS result = (DomainCS)getRhsSym(2);
				result.setReplace(true);
				setOffsets(result, getRhsIToken(1), result);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 311:  domainCS_postImplementedby ::= domainCS_1_ implementedby OperationCallExpCS
            //
            case 311: {
               //#line 561 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DomainCS result = (DomainCS)getRhsSym(1);
				OperationCallExpCS operationCallExpCS =(OperationCallExpCS)getRhsSym(3);
				result.setImplementedBy(operationCallExpCS);
				setOffsets(result, result, operationCallExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 313:  domainCS_preDefaultValue ::= domainCS_preDefaultValue defaultValueCS
            //
            case 313: {
               //#line 571 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DomainCS result = (DomainCS)getRhsSym(1);
				DefaultValueCS defaultValueCS = (DefaultValueCS)getRhsSym(2);
				result.getDefaultValue().add(defaultValueCS);
				setOffsets(result, result, defaultValueCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 315:  domainCS_postDefaultValues ::= domainCS_preDefaultValue }
            //
            case 315: {
               //#line 581 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DomainCS result = (DomainCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 316:  domainCS ::= domainCS_postDefaultValues ;
            //
            case 316: {
               //#line 588 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DomainCS result = (DomainCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 317:  domainCS ::= primitive domain identifierCS : typeCS ;
            //
            case 317: {
               //#line 597 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
				TypeCS typeCS = (TypeCS)getRhsSym(5);
				PrimitiveTypeDomainCS result = QVTrCSTFactory.eINSTANCE.createPrimitiveTypeDomainCS();
				result.setIdentifier(identifierCS);
				result.setType(typeCS);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 321:  templateCS ::= templateCS_0_ { OclExpressionCS }
            //
            case 321: {
               //#line 614 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TemplateCS result = (TemplateCS)getRhsSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(3);
				result.setGuardExpression(OclExpressionCS);
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 325:  objectTemplateCS_prePropertyTemplates ::= simpleNameCS : notCollectionTypeCS {
            //
            case 325: {
               //#line 647 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = createIdentifierCS(1);
				TypeCS typeCS = (TypeCS)getRhsSym(3);
				ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
				result.setType(typeCS);
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 326:  objectTemplateCS_prePropertyTemplates ::= : pathNameCS {
            //
            case 326: {
               //#line 658 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				ObjectTemplateCS result = QVTrCSTFactory.eINSTANCE.createObjectTemplateCS();
				result.setIdentifier(createUniqueIdentifierCS(1));
				result.setType((TypeCS)getRhsSym(2));
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 329:  objectTemplateCS_postPropertyTemplate ::= objectTemplateCS_prePropertyTemplate propertyTemplateCS
            //
            case 329: {
               //#line 669 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				ObjectTemplateCS result = (ObjectTemplateCS)getRhsSym(1);
				PropertyTemplateCS propertyTemplateCS = (PropertyTemplateCS)getRhsSym(2);
				result.getPropertyTemplate().add(propertyTemplateCS);
				setOffsets(result, result, propertyTemplateCS);
				setResult(result);
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
               //#line 680 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				ObjectTemplateCS result = (ObjectTemplateCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 332:  propertyTemplateCS ::= propertyIdCS = OclExpressionCS
            //
            case 332: {
               //#line 689 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifiedCS propertyIdCS = (IdentifiedCS)getRhsSym(1);
				PropertyTemplateCS result = QVTrCSTFactory.eINSTANCE.createPropertyTemplateCS();
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(3);
				result.setPropertyId(propertyIdCS);
				result.setOclExpression(OclExpressionCS);
				setOffsets(result, propertyIdCS, OclExpressionCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 333:  collectionTemplateCS_1_ ::= : collectionTypeCS
            //
            case 333: {
               //#line 707 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)getRhsSym(2);
				CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
				result.setType(collectionTypeCS);
				result.setIdentifier(createUniqueIdentifierCS(1));
				setOffsets(result, getRhsIToken(1), collectionTypeCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 334:  collectionTemplateCS_1_ ::= simpleNameCS : collectionTypeCS
            //
            case 334: {
               //#line 723 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = createIdentifierCS(1);
				CollectionTypeCS collectionTypeCS = (CollectionTypeCS)getRhsSym(3);
				CollectionTemplateCS result = QVTrCSTFactory.eINSTANCE.createCollectionTemplateCS();
				result.setType(collectionTypeCS);
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, collectionTypeCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 338:  collectionTemplateCS_postMemberSelection ::= collectionTemplateCS_preMemberSelection memberSelectorCS
            //
            case 338: {
               //#line 737 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifiedCS memberSelectorCS = (IdentifiedCS)getRhsSym(2);
				CollectionTemplateCS result = (CollectionTemplateCS)getRhsSym(1);
				result.getMemberIdentifier().add(memberSelectorCS);
				setOffsets(result, result, memberSelectorCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 339:  collectionTemplateCS ::= collectionTemplateCS_postMemberSelection PLUS_PLUS identifierCS }
            //
            case 339: {
               //#line 746 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS restIdentifier = (IdentifierCS)getRhsSym(3);
				CollectionTemplateCS result = (CollectionTemplateCS)getRhsSym(1);
				result.setRestIdentifier(restIdentifier);
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 340:  collectionTemplateCS ::= collectionTemplateCS_postMemberSelection ERROR_TOKEN }
            //
            case 340: {
               //#line 755 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_REST);
				IdentifierCS restIdentifier = createUniqueIdentifierCS(2);
				CollectionTemplateCS result = (CollectionTemplateCS)getRhsSym(1);
				result.setRestIdentifier(restIdentifier);
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 341:  collectionTemplateCS ::= collectionTemplateCS_preMemberSelections }
            //
            case 341: {
               //#line 765 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				CollectionTemplateCS result = (CollectionTemplateCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 342:  memberSelectorCS ::= identifierCS
            //
            case 342: {
               //#line 774 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				IdentifiedCS result = QVTCSTFactory.eINSTANCE.createIdentifiedCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 344:  defaultValueCS ::= identifierCS = OclExpressionCS ;
            //
            case 344: {
               //#line 786 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				OCLExpressionCS OclExpressionCS = (OCLExpressionCS)getRhsSym(3);
				DefaultValueCS result = QVTrCSTFactory.eINSTANCE.createDefaultValueCS();
				result.setIdentifier(identifierCS);
				result.setInitialiser(OclExpressionCS);
				setOffsets(result, identifierCS, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 345:  queryCS_preParamDeclaration ::= query pathNameCS (
            //
            case 345: {
               //#line 802 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				QueryCS result = QVTrCSTFactory.eINSTANCE.createQueryCS();
				result.setPathName((PathNameCS)getRhsSym(2));
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 347:  queryCS_postParamDeclaration ::= queryCS_preParamDeclaration paramDeclarationCS
            //
            case 347: {
               //#line 811 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)getRhsSym(2);
				QueryCS result = (QueryCS)getRhsSym(1);
				result.getInputParamDeclaration().add(paramDeclarationCS);
				setOffsets(result, result, paramDeclarationCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 348:  queryCS_postType ::= queryCS_postParamDeclaration ) : typeCS
            //
            case 348: {
               //#line 820 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TypeCS typeCS = (TypeCS)getRhsSym(4);
				QueryCS result = (QueryCS)getRhsSym(1);
				result.setType(typeCS);
				setOffsets(result, result, typeCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 349:  queryCS ::= queryCS_postType ;
            //
            case 349: {
               //#line 829 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				QueryCS result = (QueryCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 350:  queryCS ::= queryCS_postType { OclExpressionCS }
            //
            case 350: {
               //#line 836 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				QueryCS result = (QueryCS)getRhsSym(1);
				result.setOclExpression((OCLExpressionCS)getRhsSym(3));
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 351:  paramDeclarationCS ::= identifierCS : typeCS
            //
            case 351: {
               //#line 846 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				TypeCS typeCS = (TypeCS)getRhsSym(3);
				ParamDeclarationCS result = QVTrCSTFactory.eINSTANCE.createParamDeclarationCS();
				result.setIdentifier(identifierCS);
				result.setType(typeCS);
				setOffsets(result, identifierCS, typeCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 352:  paramDeclarationCS ::= identifierCS ERROR_TOKEN
            //
            case 352: {
               //#line 857 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), QVTrParserErrors.INCOMPLETE_PARAM_DECLARATION);
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
               //#line 897 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS result = createIdentifierCS(1);
				setResult(result);
	                  break;
            }
	
    
            default:
                break;
        }
        return;
    }
}

