/**
* Essential OCL Grammar
* <copyright>
*
* Copyright (c) 2005, 2010 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112, 295166
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: QVTcParser.java,v 1.17 2010/07/10 09:34:36 ewillink Exp $
*/

package org.eclipse.qvt.declarative.parser.qvtcore;

import lpg.runtime.*;

import org.eclipse.qvt.declarative.parser.qvt.cst.*;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.*;
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

public class QVTcParser extends AbstractOCLParser implements RuleAction
{
    private DerivedPrsStream prsStream = null;
    
    private boolean unimplementedSymbolsWarning = false;

    private static ParseTable prsTable = new QVTcParserprs();
    @Override
    public ParseTable getParseTable() { return prsTable; }

    private BacktrackingParser btParser = null;
    public BacktrackingParser getParser() { return btParser; }

    @Override
    protected void setResult(Object object) { btParser.setSym1(object); }
    @Override
    protected Object getRhsSym(int i) { return btParser.getSym(i); }

    @Override
    protected int getRhsTokenIndex(int i) { return btParser.getToken(i); }
    @Override
    protected IToken getRhsIToken(int i) { return prsStream.getIToken(getRhsTokenIndex(i)); }
    
    @Override
    protected int getRhsFirstTokenIndex(int i) { return btParser.getFirstToken(i); }
    @Override
    protected IToken getRhsFirstIToken(int i) { return prsStream.getIToken(getRhsFirstTokenIndex(i)); }

    @Override
    protected int getRhsLastTokenIndex(int i) { return btParser.getLastToken(i); }
    @Override
    protected IToken getRhsLastIToken(int i) { return prsStream.getIToken(getRhsLastTokenIndex(i)); }

    @Override
    protected int getLeftSpan() { return btParser.getFirstToken(); }
    @Override
    protected IToken getLeftIToken()  { return prsStream.getIToken(getLeftSpan()); }

    @Override
    protected int getRightSpan() { return btParser.getLastToken(); }
    @Override
    protected IToken getRightIToken() { return prsStream.getIToken(getRightSpan()); }

    @Override
    protected int getRhsErrorTokenIndex(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    @Override
    protected ErrorToken getRhsErrorIToken(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

	@SuppressWarnings("nls")
    @Override
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
                    System.out.println("    " + QVTcParsersym.orderedTerminalSymbols[id.intValue()]);               
                }
                System.out.println();
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 QVTcParsersym.orderedTerminalSymbols[prsTable.getEoftSymbol()]));
        } 
    }
    
    @SuppressWarnings("nls")
    public QVTcParser(QVTcLexer lexer)        
    {
    		super(lexer);
        try
        {
            btParser = new BacktrackingParser(prsStream, prsTable, this);
        }
        catch (NotBacktrackParseTableException e)
        {
            throw new Error(new NotBacktrackParseTableException
                                ("Regenerate QVTcParserprs.java with -BACKTRACK option"));
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- QVTcParsersym.java"));
        }
        
        ILexStream lexStream = lexer.getILexStream();
        if (lexStream != null) {
        	reset(lexStream);
        }
    }
    
    @Override
    public int numTokenKinds() { return QVTcParsersym.numTokenKinds; }
    @Override
    public String[] orderedTerminalSymbols() { return QVTcParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return QVTcParsersym.orderedTerminalSymbols[kind]; }
    public int getEOFTokenKind() { return prsTable.getEoftSymbol(); }
    @Override
    public DerivedPrsStream getIPrsStream() { return prsStream; }

    @Override
    public CSTNode parser()
    {
        return parser(null, getDefaultRepairCount());
    }
    
    @Override
    public CSTNode parser(Monitor monitor)
    {
        return parser(monitor, getDefaultRepairCount());
    }
    
    @Override
    public CSTNode parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }

    @Override
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
public QVTcLexer getLexer() {
	return (QVTcLexer) super.getLexer();
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
*/
@Deprecated
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
*/
@Deprecated
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

	@SuppressWarnings("unchecked")
    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {

            //
            // Rule 16:  conceptualOperationNameCS ::= conceptualOperationName
            //
            case 16: {
               //#line 296 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
               //#line 319 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
               //#line 338 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
               //#line 350 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 36:  QuotedSimpleNameCS ::= QUOTED_IDENTIFIER
            //
            case 36: {
               //#line 362 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createQuotedSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 37:  QuotedSimpleNameCS ::= QuotedSimpleNameCS STRING_LITERAL
            //
            case 37: {
               //#line 373 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS string = (SimpleNameCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                SimpleNameCS result = extendQuotedSimpleNameCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 40:  pathNameCS ::= simpleNameCS
            //
            case 40: {
               //#line 386 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS simpleName = (SimpleNameCS)getRhsSym(1);
                PathNameCS result = createPathNameCS(simpleName);
                setOffsets(result, simpleName);
                setResult(result);
                      break;
            }
    
            //
            // Rule 41:  pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
            //
            case 41: {
               //#line 394 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PathNameCS result = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                result = extendPathNameCS(result, simpleNameCS);
                setOffsets(result, result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 42:  primitiveTypeCS ::= Boolean
            //
            case 42: {
               //#line 407 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.BOOLEAN_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 43:  primitiveTypeCS ::= Integer
            //
            case 43: {
               //#line 417 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.INTEGER_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 44:  primitiveTypeCS ::= Real
            //
            case 44: {
               //#line 427 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.REAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 45:  primitiveTypeCS ::= String
            //
            case 45: {
               //#line 437 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.STRING_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 46:  primitiveTypeCS ::= UnlimitedNatural
            //
            case 46: {
               //#line 447 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 47:  primitiveTypeCS ::= OclAny
            //
            case 47: {
               //#line 458 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_ANY_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 48:  primitiveTypeCS ::= OclInvalid
            //
            case 48: {
               //#line 468 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_INVALID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 49:  primitiveTypeCS ::= OclVoid
            //
            case 49: {
               //#line 478 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_VOID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 50:  CollectionTypeIdentifierCS ::= Set
            //
            case 50: {
               //#line 489 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 51:  CollectionTypeIdentifierCS ::= Bag
            //
            case 51: {
               //#line 499 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.BAG_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 52:  CollectionTypeIdentifierCS ::= Sequence
            //
            case 52: {
               //#line 509 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 53:  CollectionTypeIdentifierCS ::= Collection
            //
            case 53: {
               //#line 519 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 54:  CollectionTypeIdentifierCS ::= OrderedSet
            //
            case 54: {
               //#line 529 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 59:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
            //
            case 59: {
               //#line 545 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1);
                result.setTypeCS((TypeCS)getRhsSym(3));
                setOffsets(result, result, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 60:  tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
            //
            case 60: {
               //#line 554 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                 TupleTypeCS result = createTupleTypeCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 61:  tupleTypePartsCSopt ::= $Empty
            //
            case 61: {
               //#line 562 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<VariableCS>());
                      break;
            }
    
            //
            // Rule 63:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 63: {
               //#line 569 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 64:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 64: {
               //#line 576 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 65:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 65: {
               //#line 587 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                VariableCS result = createVariableCS(name, null, null);
                setOffsets(result, name);
                setResult(result);
                      break;
            }
    
            //
            // Rule 66:  typedUninitializedVariableCS ::= simpleNameCS : typeCS
            //
            case 66: {
               //#line 596 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, type, null);
                setOffsets(result, name, type);
                setResult(result);
                      break;
            }
    
            //
            // Rule 67:  untypedInitializedVariableCS ::= simpleNameCS = OclExpressionCS
            //
            case 67: {
               //#line 606 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, null, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 68:  typedInitializedVariableCS ::= simpleNameCS : typeCS = OclExpressionCS
            //
            case 68: {
               //#line 616 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(5);
                VariableCS result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 81:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 81: {
               //#line 649 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 82:  CollectionLiteralExpCS ::= collectionTypeCS { CollectionLiteralPartsCSopt }
            //
            case 82: {
               //#line 660 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 83:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 83: {
               //#line 672 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<CollectionLiteralPartCS>());
                      break;
            }
    
            //
            // Rule 85:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 85: {
               //#line 679 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
                result.add((CollectionLiteralPartCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 86:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 86: {
               //#line 686 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>)getRhsSym(1);
                result.add((CollectionLiteralPartCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 88:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 88: {
               //#line 695 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                CollectionLiteralPartCS result = createCollectionLiteralPartCS(
                        (OCLExpressionCS)getRhsSym(1)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 89:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
            //
            case 89: {
               //#line 705 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                CollectionLiteralPartCS result = createCollectionRangeCS(
                        (OCLExpressionCS)getRhsSym(1),
                        (OCLExpressionCS)getRhsSym(3)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 97:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
            //
            case 97: {
               //#line 724 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 98:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 98: {
               //#line 732 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 99:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 99: {
               //#line 739 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 100:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 100: {
               //#line 747 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IntegerLiteralExpCS result = createIntegerLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 101:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 101: {
               //#line 755 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                RealLiteralExpCS result = createRealLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 102:  StringLiteralExpCS ::= STRING_LITERAL
            //
            case 102: {
               //#line 763 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                IToken literalToken = getRhsIToken(1);
                StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                setOffsets(result, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 103:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
            //
            case 103: {
               //#line 771 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                StringLiteralExpCS string = (StringLiteralExpCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 104:  BooleanLiteralExpCS ::= true
            //
            case 104: {
               //#line 781 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 105:  BooleanLiteralExpCS ::= false
            //
            case 105: {
               //#line 788 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 106:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 106: {
               //#line 796 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 107:  InvalidLiteralExpCS ::= invalid
            //
            case 107: {
               //#line 804 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                InvalidLiteralExpCS result = createInvalidLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 108:  NullLiteralExpCS ::= null
            //
            case 108: {
               //#line 812 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                NullLiteralExpCS result = createNullLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
     
            //
            // Rule 109:  TypeLiteralExpCS ::= primitiveTypeCS
            //
            
            case 109:
 
            //
            // Rule 110:  TypeLiteralExpCS ::= collectionTypeCS
            //
            
            case 110:

            //
            // Rule 111:  TypeLiteralExpCS ::= tupleTypeCS
            //
            case 111: {
               //#line 826 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 116:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS | OclExpressionCS )
            //
            case 116: {
               //#line 851 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 117:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 117: {
               //#line 868 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 118:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( typedUninitializedVariableCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 118: {
               //#line 888 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 119:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( typedInitializedVariableCS | OclExpressionCS )
            //
            case 119: {
               //#line 909 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 120:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS ; typedInitializedVariableCS | OclExpressionCS )
            //
            case 120: {
               //#line 925 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 124:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
            //
            case 124: {
               //#line 947 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 125:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( OclExpressionCS )
            //
            case 125: {
               //#line 961 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 126:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( notNameExpressionCS , argumentsCS )
            //
            case 126: {
               //#line 991 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 127:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , argumentsCS )
            //
            case 127: {
               //#line 1007 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 128:  OperationCallExpCS ::= primaryExpCS . conceptualOperationNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            
            case 128:

            //
            // Rule 129:  OperationCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 129: {
               //#line 1033 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 130:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 130: {
               //#line 1049 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 131:  OperationCallExpCS ::= pathNameCS :: unreservedSimpleNameCS ( argumentsCSopt )
            //
            case 131: {
               //#line 1063 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 132:  OperationCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 132: {
               //#line 1081 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 134:  PropertyCallExpCS ::= pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 134: {
               //#line 1105 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 135:  PropertyCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 135: {
               //#line 1126 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 136:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt
            //
            case 136: {
               //#line 1149 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 137:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 137: {
               //#line 1170 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 138:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCSopt
            //
            case 138: {
               //#line 1193 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 139:  isMarkedPreCSopt ::= $Empty
            //
            case 139: {
               //#line 1211 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                setResult(null);
                      break;
            }
    
            //
            // Rule 140:  argumentsCSopt ::= $Empty
            //
            case 140: {
               //#line 1217 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                setResult(new BasicEList<OCLExpressionCS>());
                      break;
            }
    
            //
            // Rule 142:  argumentsCS ::= OclExpressionCS
            //
            case 142: {
               //#line 1224 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
                result.add((OCLExpressionCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 143:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 143: {
               //#line 1231 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<OCLExpressionCS> result = (EList<OCLExpressionCS>)getRhsSym(1);
                result.add((OCLExpressionCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 146:  VariableExpCS ::= selfKeywordCS
            //
            case 146: {
               //#line 1256 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 147:  SimpleNameExpCS ::= simpleNameCS
            //
            case 147: {
               //#line 1271 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 153:  impliesNotNameNotLetCS ::= impliesNotLetCS implies xorNotLetCS
            //
            
            case 153:
 
            //
            // Rule 155:  impliesWithLetCS ::= impliesNotLetCS implies xorWithLetCS
            //
            
            case 155:
 
            //
            // Rule 159:  xorNotNameNotLetCS ::= xorNotLetCS xor orNotLetCS
            //
            
            case 159:
 
            //
            // Rule 161:  xorWithLetCS ::= xorNotLetCS xor orWithLetCS
            //
            
            case 161:
 
            //
            // Rule 165:  orNotNameNotLetCS ::= orNotLetCS or andNotLetCS
            //
            
            case 165:
 
            //
            // Rule 167:  orWithLetCS ::= orNotLetCS or andWithLetCS
            //
            
            case 167:
 
            //
            // Rule 171:  andNotNameNotLetCS ::= andNotLetCS and equalityNotLetCS
            //
            
            case 171:
 
            //
            // Rule 173:  andWithLetCS ::= andNotLetCS and equalityWithLetCS
            //
            
            case 173:
 
            //
            // Rule 177:  equalityNotNameNotLetCS ::= equalityNotLetCS = relationalNotLetCS
            //
            
            case 177:
 
            //
            // Rule 178:  equalityNotNameNotLetCS ::= equalityNotLetCS <> relationalNotLetCS
            //
            
            case 178:
 
            //
            // Rule 180:  equalityWithLetCS ::= equalityNotLetCS = relationalWithLetCS
            //
            
            case 180:
 
            //
            // Rule 181:  equalityWithLetCS ::= equalityNotLetCS <> relationalWithLetCS
            //
            
            case 181:
 
            //
            // Rule 185:  relationalNotNameNotLetCS ::= relationalNotLetCS > additiveNotLetCS
            //
            
            case 185:
 
            //
            // Rule 186:  relationalNotNameNotLetCS ::= relationalNotLetCS < additiveNotLetCS
            //
            
            case 186:
 
            //
            // Rule 187:  relationalNotNameNotLetCS ::= relationalNotLetCS >= additiveNotLetCS
            //
            
            case 187:
 
            //
            // Rule 188:  relationalNotNameNotLetCS ::= relationalNotLetCS <= additiveNotLetCS
            //
            
            case 188:
 
            //
            // Rule 190:  relationalWithLetCS ::= relationalNotLetCS > additiveWithLetCS
            //
            
            case 190:
 
            //
            // Rule 191:  relationalWithLetCS ::= relationalNotLetCS < additiveWithLetCS
            //
            
            case 191:
 
            //
            // Rule 192:  relationalWithLetCS ::= relationalNotLetCS >= additiveWithLetCS
            //
            
            case 192:
 
            //
            // Rule 193:  relationalWithLetCS ::= relationalNotLetCS <= additiveWithLetCS
            //
            
            case 193:
 
            //
            // Rule 197:  additiveNotNameNotLetCS ::= additiveNotLetCS + multiplicativeNotLetCS
            //
            
            case 197:
 
            //
            // Rule 198:  additiveNotNameNotLetCS ::= additiveNotLetCS - multiplicativeNotLetCS
            //
            
            case 198:
 
            //
            // Rule 200:  additiveWithLetCS ::= additiveNotLetCS + multiplicativeWithLetCS
            //
            
            case 200:
 
            //
            // Rule 201:  additiveWithLetCS ::= additiveNotLetCS - multiplicativeWithLetCS
            //
            
            case 201:
 
            //
            // Rule 205:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS * unaryNotLetCS
            //
            
            case 205:
 
            //
            // Rule 206:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS / unaryNotLetCS
            //
            
            case 206:
 
            //
            // Rule 208:  multiplicativeWithLetCS ::= multiplicativeNotLetCS * unaryWithLetCS
            //
            
            case 208:

            //
            // Rule 209:  multiplicativeWithLetCS ::= multiplicativeNotLetCS / unaryWithLetCS
            //
            case 209: {
               //#line 1380 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 213:  unaryNotNameNotLetCS ::= - unaryNotLetCS
            //
            
            case 213:
 
            //
            // Rule 214:  unaryNotNameNotLetCS ::= not unaryNotLetCS
            //
            
            case 214:
 
            //
            // Rule 216:  unaryWithLetCS ::= - unaryWithLetCS
            //
            
            case 216:

            //
            // Rule 217:  unaryWithLetCS ::= not unaryWithLetCS
            //
            case 217: {
               //#line 1411 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 224:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 224: {
               //#line 1437 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
                if (result instanceof OperationCallExpCS) {
                    ((OperationCallExpCS)result).setIsAtomic(true);
                }
                setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 225:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif
            //
            case 225: {
               //#line 1448 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 226:  LetExpCS ::= let letVariablesCS in OclExpressionCS
            //
            case 226: {
               //#line 1460 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
            // Rule 227:  letVariablesCS ::= typedInitializedVariableCS
            //
            case 227: {
               //#line 1472 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 228:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 228: {
               //#line 1479 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 229:  ERROR_Colon ::= ERROR_TOKEN
            //
            case 229: {
               //#line 48 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_COLON);
	                  break;
            }
	
            //
            // Rule 230:  ERROR_Empty ::= ERROR_TOKEN
            //
            case 230: {
               //#line 53 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.EXTRA_TOKENS);
	                  break;
            }
	
            //
            // Rule 231:  ERROR_SimpleNameCS ::= ERROR_TOKEN
            //
            case 231: {
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
            // Rule 233:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS ERROR_TOKEN
            //
            case 233: {
               //#line 82 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(4), OCLParserErrors.MISSING_RPAREN);
				CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1); 
				result.setTypeCS((TypeCS)getRhsSym(3));
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 234:  TupleLiteralExpCS ::= Tuple ERROR_TOKEN
            //
            case 234: {
               //#line 116 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(2), OCLParserErrors.MISSING_LBRACE);
				TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 235:  TupleLiteralPartsCS ::= ERROR_TOKEN
            //
            case 235: {
               //#line 125 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_VARIABLES);
				EList<VariableCS> result = new BasicEList<VariableCS>();
				setResult(result);
	                  break;
            }
	
            //
            // Rule 236:  AssociationClassCallExpCS ::= simpleNameCS [ argumentsCS ERROR_TOKEN
            //
            case 236: {
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
            // Rule 237:  IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS ERROR_TOKEN
            //
            case 237: {
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
            // Rule 238:  IfExpCS ::= if OclExpressionCS then OclExpressionCS ERROR_TOKEN
            //
            case 238: {
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
            // Rule 239:  IfExpCS ::= if OclExpressionCS ERROR_TOKEN
            //
            case 239: {
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
            // Rule 240:  IfExpCS ::= if ERROR_TOKEN endif
            //
            case 240: {
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
            // Rule 241:  primaryExpCS ::= ( OclExpressionCS ERROR_TOKEN
            //
            case 241: {
               //#line 201 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_RPAREN);
				OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 242:  TopLevelCS ::= $Empty
            //
            case 242: {
               //#line 105 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TopLevelCS result = QVTcCSTFactory.eINSTANCE.createTopLevelCS();
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 243:  TopLevelCS ::= TopLevelCS MappingCS
            //
            case 243: {
               //#line 112 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TopLevelCS result = (TopLevelCS)getRhsSym(1);
				MappingCS mappingCS = (MappingCS)getRhsSym(2);
				result.getMappings().add(mappingCS);
				setOffsets(result, result, mappingCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 244:  TopLevelCS ::= TopLevelCS TransformationCS
            //
            case 244: {
               //#line 121 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TopLevelCS result = (TopLevelCS)getRhsSym(1);
				TransformationCS transformationCS = (TransformationCS)getRhsSym(2);
				result.getTransformations().add(transformationCS);
				setOffsets(result, result, transformationCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 245:  TopLevelCS ::= TopLevelCS QueryCS
            //
            case 245: {
               //#line 130 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TopLevelCS result = (TopLevelCS)getRhsSym(1);
				QueryCS queryCS = (QueryCS)getRhsSym(2);
				result.getQueries().add(queryCS);
				setOffsets(result, result, queryCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 246:  TransformationCS_0_ ::= transformation TransformationNameCS {
            //
            case 246: {
               //#line 144 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TransformationCS result = QVTcCSTFactory.eINSTANCE.createTransformationCS();
				result.setPathName((PathNameCS)getRhsSym(2));
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 247:  TransformationCS_0_ ::= TransformationCS_0_ DirectionCS ;
            //
            case 247: {
               //#line 152 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TransformationCS result = (TransformationCS)getRhsSym(1);
				DirectionCS directionCS = (DirectionCS)getRhsSym(2);
				result.getDirections().add(directionCS);
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 248:  TransformationCS ::= TransformationCS_0_ }
            //
            case 248: {
               //#line 161 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TransformationCS result = (TransformationCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 249:  DirectionCS_0_ ::= DirectionNameCS
            //
            case 249: {
               //#line 171 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS directionNameCS = (IdentifierCS)getRhsSym(1);
				DirectionCS result = QVTcCSTFactory.eINSTANCE.createDirectionCS();
				result.setIdentifier(directionNameCS);
				setOffsets(result, directionNameCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 252:  DirectionCS_2_ ::= DirectionCS_1_ PackageNameCS
            //
            case 252: {
               //#line 182 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DirectionCS result = (DirectionCS)getRhsSym(1);
				PathNameCS pathNameCS = (PathNameCS)getRhsSym(2);
				result.getImports().add(pathNameCS);
				setOffsets(result, result, pathNameCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 257:  DirectionCS_5_ ::= DirectionCS_4_ DirectionNameCS
            //
            case 257: {
               //#line 195 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DirectionCS result = (DirectionCS)getRhsSym(1);
				IdentifierCS directionNameCS = (IdentifierCS)getRhsSym(2);
				result.getUses().add(directionNameCS);
				setOffsets(result, result, directionNameCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 260:  MappingCS_1_ ::= map
            //
            case 260: {
               //#line 211 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
//					IdentifierCS identifierCS = createUniqueIdentifierCS(getRhsTokenIndex(1));
//					result.setIdentifier(identifierCS);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 261:  MappingCS_1_ ::= map MappingNameCS
            //
            case 261: {
               //#line 220 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				MappingCS result = QVTcCSTFactory.eINSTANCE.createMappingCS();
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
				result.setIdentifier(identifierCS);
				setOffsets(result, getRhsIToken(1), identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 263:  MappingCS_2_ ::= MappingCS_1_ in TransformationNameCS
            //
            case 263: {
               //#line 230 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				MappingCS result = (MappingCS)getRhsSym(1);
				PathNameCS identifierCS = (PathNameCS)getRhsSym(3);
				result.setIn(identifierCS);
				setOffsets(result, result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 265:  MappingCS_3_ ::= MappingCS_2_ refines MappingNameCS
            //
            case 265: {
               //#line 240 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				MappingCS result = (MappingCS)getRhsSym(1);
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
				result.getRefines().add(identifierCS);
				setOffsets(result, result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 266:  MappingCS_3_ ::= MappingCS_3_ , MappingNameCS
            //
            case 266: {
               //#line 249 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				MappingCS result = (MappingCS)getRhsSym(1);
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(3);
				result.getRefines().add(identifierCS);
				setOffsets(result, result, identifierCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 268:  MappingCS_4_ ::= MappingCS_4_ DomainCS
            //
            case 268: {
               //#line 259 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				MappingCS result = (MappingCS)getRhsSym(1);
				DomainCS domainCS = (DomainCS)getRhsSym(2);
				result.getDomains().add(domainCS);
				setOffsets(result, result, domainCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 269:  MappingCS_8 ::= MappingCS_4_ where DomainCS_0_
            //
            case 269: {
               //#line 268 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
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
	                  break;
            }
	
            //
            // Rule 270:  MappingCS_8 ::= MappingCS_4_ where DirectionNameCS DomainCS_0_
            //
            case 270: {
               //#line 282 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				MappingCS result = (MappingCS)getRhsSym(1);
				IdentifierCS directionNameCS = (IdentifierCS)getRhsSym(3);
				setOffsets(directionNameCS, getRhsIToken(2), directionNameCS);
				DomainCS domainCS = (DomainCS)getRhsSym(4);
				domainCS.setIdentifier(directionNameCS);
				setOffsets(domainCS, directionNameCS, domainCS);
				result.setMiddle(domainCS);
				setOffsets(result, result, domainCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 271:  MappingCS_8 ::= MappingCS_8 ComposedMappingCS
            //
            case 271: {
               //#line 295 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				MappingCS result = (MappingCS)getRhsSym(1);
				MappingCS composedMappingCS = (MappingCS)getRhsSym(2);
				result.getComposedMappings().add(composedMappingCS);
				setOffsets(result, result, composedMappingCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 272:  MappingCS ::= MappingCS_8 }
            //
            case 272: {
               //#line 304 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				MappingCS result = (MappingCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 273:  DomainCS_0_ ::= ( DomainGuardPatternCS ) { DomainBottomPatternCS }
            //
            case 273: {
               //#line 312 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				GuardPatternCS guardPatternCS = (GuardPatternCS)getRhsSym(2);
				BottomPatternCS bottomPatternCS = (BottomPatternCS)getRhsSym(5);
				DomainCS result = QVTcCSTFactory.eINSTANCE.createDomainCS();
				result.setGuardPattern(guardPatternCS);
				result.setBottomPattern(bottomPatternCS);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 274:  DomainCS_1_ ::= DirectionNameCS DomainCS_0_
            //
            case 274: {
               //#line 323 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				DomainCS result = (DomainCS)getRhsSym(2);
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, result);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 276:  DomainCS_2_ ::= enforce DomainCS_1_
            //
            case 276: {
               //#line 333 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DomainCS result = (DomainCS)getRhsSym(2);
				result.setEnforce(true);
				setOffsets(result, getRhsIToken(1), result);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 278:  DomainCS ::= check DomainCS_2_
            //
            case 278: {
               //#line 342 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				DomainCS result = (DomainCS)getRhsSym(2);
				result.setCheck(true);
				setOffsets(result, getRhsIToken(1), result);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 284:  GuardPatternCS_1_ ::= UnrealizedVariableCS
            //
            case 284: {
               //#line 363 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)getRhsSym(1);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, unrealizedVariableCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 285:  GuardPatternCS_1_ ::= GuardPatternCS_1_ , UnrealizedVariableCS
            //
            case 285: {
               //#line 372 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				GuardPatternCS result = (GuardPatternCS)getRhsSym(1);
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)getRhsSym(3);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, result, unrealizedVariableCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 287:  GuardPatternCS_2_ ::= ConstraintCS ;
            //
            case 287: {
               //#line 382 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
				OCLExpressionCS constraintCS = (OCLExpressionCS)getRhsSym(1);
				result.getConstraints().add(constraintCS);
				setOffsets(result, constraintCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 288:  GuardPatternCS_2_ ::= GuardPatternCS_2_ ConstraintCS ;
            //
            case 288: {
               //#line 391 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				GuardPatternCS result = (GuardPatternCS)getRhsSym(1);
				OCLExpressionCS constraintCS = (OCLExpressionCS)getRhsSym(2);
				result.getConstraints().add(constraintCS);
				setOffsets(result, result, constraintCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 291:  GuardPatternCS ::= $Empty
            //
            case 291: {
               //#line 402 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				GuardPatternCS result = QVTcCSTFactory.eINSTANCE.createGuardPatternCS();
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 292:  BottomPatternCS_1_ ::= UnrealizedVariableCS
            //
            case 292: {
               //#line 411 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)getRhsSym(1);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, result, unrealizedVariableCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 293:  BottomPatternCS_1_ ::= BottomPatternCS_1_ , UnrealizedVariableCS
            //
            case 293: {
               //#line 420 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				BottomPatternCS result = (BottomPatternCS)getRhsSym(1);
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)getRhsSym(3);
				result.getUnrealizedVariables().add(unrealizedVariableCS);
				setOffsets(result, result, unrealizedVariableCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 294:  BottomPatternCS_1_ ::= RealizedVariableCS
            //
            case 294: {
               //#line 429 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				RealizedVariableCS realizedVariableCS = (RealizedVariableCS)getRhsSym(1);
				result.getRealizedVariables().add(realizedVariableCS);
				setOffsets(result, realizedVariableCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 295:  BottomPatternCS_1_ ::= BottomPatternCS_1_ , RealizedVariableCS
            //
            case 295: {
               //#line 438 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				BottomPatternCS result = (BottomPatternCS)getRhsSym(1);
				RealizedVariableCS realizedVariableCS = (RealizedVariableCS)getRhsSym(3);
				result.getRealizedVariables().add(realizedVariableCS);
				setOffsets(result, realizedVariableCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 297:  BottomPatternCS_2_ ::= ConstraintCS ;
            //
            case 297: {
               //#line 448 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				OCLExpressionCS constraintCS = (OCLExpressionCS)getRhsSym(1);
				result.getConstraints().add(constraintCS);
				setOffsets(result, constraintCS, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 298:  BottomPatternCS_2_ ::= EnforcementOperationCS
            //
            case 298: {
               //#line 457 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)getRhsSym(1);
				result.getEnforcementOperations().add(enforcementOperationCS);
				setOffsets(result, enforcementOperationCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 299:  BottomPatternCS_2_ ::= BottomPatternCS_2_ ConstraintCS ;
            //
            case 299: {
               //#line 466 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				BottomPatternCS result = (BottomPatternCS)getRhsSym(1);
				OCLExpressionCS constraintCS = (OCLExpressionCS)getRhsSym(2);
				result.getConstraints().add(constraintCS);
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 300:  BottomPatternCS_2_ ::= BottomPatternCS_2_ EnforcementOperationCS
            //
            case 300: {
               //#line 475 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				BottomPatternCS result = (BottomPatternCS)getRhsSym(1);
				EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)getRhsSym(2);
				result.getEnforcementOperations().add(enforcementOperationCS);
				setOffsets(result, result, enforcementOperationCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 303:  BottomPatternCS ::= $Empty
            //
            case 303: {
               //#line 486 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				BottomPatternCS result = QVTcCSTFactory.eINSTANCE.createBottomPatternCS();
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 304:  EnforcementOperationCS_1_ ::= primaryExpCS
            //
            case 304: {
               //#line 494 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				OperationCallExpCS operationCallCS = (OperationCallExpCS)getRhsSym(1);
				EnforcementOperationCS result = QVTcCSTFactory.eINSTANCE.createEnforcementOperationCS();
				result.setOperationCall(operationCallCS);
				setOffsets(result, operationCallCS, operationCallCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 305:  EnforcementOperationCS ::= creation EnforcementOperationCS_1_ ;
            //
            case 305: {
               //#line 503 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				EnforcementOperationCS result = (EnforcementOperationCS)getRhsSym(2);
				result.setDeletion(false);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 306:  EnforcementOperationCS ::= deletion EnforcementOperationCS_1_ ;
            //
            case 306: {
               //#line 511 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				EnforcementOperationCS result = (EnforcementOperationCS)getRhsSym(2);
				result.setDeletion(true);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 307:  UnrealizedVariableCS ::= VariableNameCS : typeCS
            //
            case 307: {
               //#line 521 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				TypeCS type = (TypeCS)getRhsSym(3);
				UnrealizedVariableCS result = QVTcCSTFactory.eINSTANCE.createUnrealizedVariableCS();
				result.setIdentifier(identifierCS);
				result.setType(type);
				setOffsets(result, identifierCS, type);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 308:  RealizedVariableCS ::= realize VariableNameCS : typeCS
            //
            case 308: {
               //#line 534 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(2);
				TypeCS type = (TypeCS)getRhsSym(4);
				RealizedVariableCS result = QVTcCSTFactory.eINSTANCE.createRealizedVariableCS();
				result.setIdentifier(identifierCS);
				result.setType(type);
				setOffsets(result, getRhsIToken(1), type);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 312:  AssignmentCS_0_ ::= OclExpressionCS := OclExpressionCS
            //
            case 312: {
               //#line 554 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				OCLExpressionCS target = (OCLExpressionCS)getRhsSym(1);
				OCLExpressionCS initialiser = (OCLExpressionCS)getRhsSym(3);
				AssignmentCS result = QVTcCSTFactory.eINSTANCE.createAssignmentCS();
				result.setTarget(target);
				result.setInitialiser(initialiser);
				setOffsets(result, target, initialiser);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 314:  AssignmentCS ::= default AssignmentCS_0_
            //
            case 314: {
               //#line 566 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				AssignmentCS result = (AssignmentCS)getRhsSym(2);
				result.setDefault(true);
				setOffsets(result, getRhsIToken(1), result);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 323:  QueryCS_preParamDeclaration ::= query QueryNameCS (
            //
            case 323: {
               //#line 589 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				QueryCS result = QVTcCSTFactory.eINSTANCE.createQueryCS();
				result.setPathName((PathNameCS)getRhsSym(2));
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 325:  QueryCS_postParamDeclaration ::= QueryCS_preParamDeclaration paramDeclarationCS
            //
            case 325: {
               //#line 598 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)getRhsSym(2);
				QueryCS result = (QueryCS)getRhsSym(1);
				result.getInputParamDeclaration().add(paramDeclarationCS);
				setOffsets(result, result, paramDeclarationCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 326:  QueryCS_postType ::= QueryCS_postParamDeclaration ) : typeCS
            //
            case 326: {
               //#line 607 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				TypeCS typeCS = (TypeCS)getRhsSym(4);
				QueryCS result = (QueryCS)getRhsSym(1);
				result.setType(typeCS);
				setOffsets(result, result, typeCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 327:  QueryCS ::= QueryCS_postType ;
            //
            case 327: {
               //#line 616 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				QueryCS result = (QueryCS)getRhsSym(1);
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 328:  QueryCS ::= QueryCS_postType { OclExpressionCS }
            //
            case 328: {
               //#line 623 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				QueryCS result = (QueryCS)getRhsSym(1);
				result.setOclExpression((OCLExpressionCS)getRhsSym(3));
				setOffsets(result, result, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 329:  paramDeclarationCS ::= ERROR_identifierCS : typeCS
            //
            
            case 329:

            //
            // Rule 330:  paramDeclarationCS ::= identifierCS : typeCS
            //
            case 330: {
               //#line 635 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				TypeCS typeCS = (TypeCS)getRhsSym(3);
				ParamDeclarationCS result = QVTcCSTFactory.eINSTANCE.createParamDeclarationCS();
				result.setIdentifier(identifierCS);
				result.setType(typeCS);
				setOffsets(result, identifierCS, typeCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 331:  paramDeclarationCS ::= identifierCS ERROR_Colon
            //
            case 331: {
               //#line 646 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS identifierCS = (IdentifierCS)getRhsSym(1);
				ParamDeclarationCS result = QVTcCSTFactory.eINSTANCE.createParamDeclarationCS();
				result.setIdentifier(identifierCS);
				setOffsets(result, identifierCS, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 343:  ERROR_identifierCS ::= ERROR_TOKEN
            //
            case 343: {
               //#line 672 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				reportErrorTokenMessage(getRhsTokenIndex(1), QVTcParserErrors.MISSING_IDENTIFIER);
				IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
				result.setValue(getRhsTokenText(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 344:  identifierCS ::= IDENTIFIER
            //
            case 344: {
               //#line 681 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
				result.setValue(getRhsTokenText(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 345:  identifierCS ::= STRING_LITERAL
            //
            case 345: {
               //#line 689 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS result = QVTCSTFactory.eINSTANCE.createIdentifierCS();
				String string = getRhsTokenText(1);
				result.setValue(string.substring(1, string.length()-1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 346:  identifierCS ::= QuotedSimpleNameCS
            //
            case 346: {
               //#line 698 "../../../../../../../../org.eclipse.ocl/src/org/eclipse/ocl/lpg/btParserTemplateF.gi"
				
				IdentifierCS result = createIdentifierCS((SimpleNameCS)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
    
            default:
                break;
        }
        return;
    }
}

