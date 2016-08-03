package org.eclipse.qvtd.doc.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.qvtd.doc.services.MiniOCLCSGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMiniOCLCSParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'='", "'<>'", "'.'", "'->'", "'false'", "'package'", "'{'", "'}'", "'class'", "'extends'", "'prop'", "':'", "';'", "'op'", "'('", "')'", "','", "'context'", "'inv'", "'::'", "'true'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMiniOCLCSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMiniOCLCSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMiniOCLCSParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMiniOCLCS.g"; }


    	private MiniOCLCSGrammarAccess grammarAccess;

    	public void setGrammarAccess(MiniOCLCSGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleRootCS"
    // InternalMiniOCLCS.g:54:1: entryRuleRootCS : ruleRootCS EOF ;
    public final void entryRuleRootCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:55:1: ( ruleRootCS EOF )
            // InternalMiniOCLCS.g:56:1: ruleRootCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRootCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRootCS"


    // $ANTLR start "ruleRootCS"
    // InternalMiniOCLCS.g:63:1: ruleRootCS : ( ( rule__RootCS__Alternatives )* ) ;
    public final void ruleRootCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:67:2: ( ( ( rule__RootCS__Alternatives )* ) )
            // InternalMiniOCLCS.g:68:2: ( ( rule__RootCS__Alternatives )* )
            {
            // InternalMiniOCLCS.g:68:2: ( ( rule__RootCS__Alternatives )* )
            // InternalMiniOCLCS.g:69:3: ( rule__RootCS__Alternatives )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:70:3: ( rule__RootCS__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16||LA1_0==28) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMiniOCLCS.g:70:4: rule__RootCS__Alternatives
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__RootCS__Alternatives();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRootCS"


    // $ANTLR start "entryRulePackageCS"
    // InternalMiniOCLCS.g:79:1: entryRulePackageCS : rulePackageCS EOF ;
    public final void entryRulePackageCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:80:1: ( rulePackageCS EOF )
            // InternalMiniOCLCS.g:81:1: rulePackageCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePackageCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageCS"


    // $ANTLR start "rulePackageCS"
    // InternalMiniOCLCS.g:88:1: rulePackageCS : ( ( rule__PackageCS__Group__0 ) ) ;
    public final void rulePackageCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:92:2: ( ( ( rule__PackageCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:93:2: ( ( rule__PackageCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:93:2: ( ( rule__PackageCS__Group__0 ) )
            // InternalMiniOCLCS.g:94:3: ( rule__PackageCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:95:3: ( rule__PackageCS__Group__0 )
            // InternalMiniOCLCS.g:95:4: rule__PackageCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PackageCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageCS"


    // $ANTLR start "entryRuleClassCS"
    // InternalMiniOCLCS.g:104:1: entryRuleClassCS : ruleClassCS EOF ;
    public final void entryRuleClassCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:105:1: ( ruleClassCS EOF )
            // InternalMiniOCLCS.g:106:1: ruleClassCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleClassCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClassCS"


    // $ANTLR start "ruleClassCS"
    // InternalMiniOCLCS.g:113:1: ruleClassCS : ( ( rule__ClassCS__Group__0 ) ) ;
    public final void ruleClassCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:117:2: ( ( ( rule__ClassCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:118:2: ( ( rule__ClassCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:118:2: ( ( rule__ClassCS__Group__0 ) )
            // InternalMiniOCLCS.g:119:3: ( rule__ClassCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:120:3: ( rule__ClassCS__Group__0 )
            // InternalMiniOCLCS.g:120:4: rule__ClassCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ClassCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClassCS"


    // $ANTLR start "entryRulePropertyCS"
    // InternalMiniOCLCS.g:129:1: entryRulePropertyCS : rulePropertyCS EOF ;
    public final void entryRulePropertyCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:130:1: ( rulePropertyCS EOF )
            // InternalMiniOCLCS.g:131:1: rulePropertyCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePropertyCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePropertyCS"


    // $ANTLR start "rulePropertyCS"
    // InternalMiniOCLCS.g:138:1: rulePropertyCS : ( ( rule__PropertyCS__Group__0 ) ) ;
    public final void rulePropertyCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:142:2: ( ( ( rule__PropertyCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:143:2: ( ( rule__PropertyCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:143:2: ( ( rule__PropertyCS__Group__0 ) )
            // InternalMiniOCLCS.g:144:3: ( rule__PropertyCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:145:3: ( rule__PropertyCS__Group__0 )
            // InternalMiniOCLCS.g:145:4: rule__PropertyCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PropertyCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyCS"


    // $ANTLR start "entryRuleOperationCS"
    // InternalMiniOCLCS.g:154:1: entryRuleOperationCS : ruleOperationCS EOF ;
    public final void entryRuleOperationCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:155:1: ( ruleOperationCS EOF )
            // InternalMiniOCLCS.g:156:1: ruleOperationCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleOperationCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperationCS"


    // $ANTLR start "ruleOperationCS"
    // InternalMiniOCLCS.g:163:1: ruleOperationCS : ( ( rule__OperationCS__Group__0 ) ) ;
    public final void ruleOperationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:167:2: ( ( ( rule__OperationCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:168:2: ( ( rule__OperationCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:168:2: ( ( rule__OperationCS__Group__0 ) )
            // InternalMiniOCLCS.g:169:3: ( rule__OperationCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:170:3: ( rule__OperationCS__Group__0 )
            // InternalMiniOCLCS.g:170:4: rule__OperationCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperationCS"


    // $ANTLR start "entryRuleParameterCS"
    // InternalMiniOCLCS.g:179:1: entryRuleParameterCS : ruleParameterCS EOF ;
    public final void entryRuleParameterCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:180:1: ( ruleParameterCS EOF )
            // InternalMiniOCLCS.g:181:1: ruleParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleParameterCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterCS"


    // $ANTLR start "ruleParameterCS"
    // InternalMiniOCLCS.g:188:1: ruleParameterCS : ( ( rule__ParameterCS__Group__0 ) ) ;
    public final void ruleParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:192:2: ( ( ( rule__ParameterCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:193:2: ( ( rule__ParameterCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:193:2: ( ( rule__ParameterCS__Group__0 ) )
            // InternalMiniOCLCS.g:194:3: ( rule__ParameterCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:195:3: ( rule__ParameterCS__Group__0 )
            // InternalMiniOCLCS.g:195:4: rule__ParameterCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterCS"


    // $ANTLR start "entryRuleConstraintsDefCS"
    // InternalMiniOCLCS.g:204:1: entryRuleConstraintsDefCS : ruleConstraintsDefCS EOF ;
    public final void entryRuleConstraintsDefCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:205:1: ( ruleConstraintsDefCS EOF )
            // InternalMiniOCLCS.g:206:1: ruleConstraintsDefCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleConstraintsDefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintsDefCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraintsDefCS"


    // $ANTLR start "ruleConstraintsDefCS"
    // InternalMiniOCLCS.g:213:1: ruleConstraintsDefCS : ( ( rule__ConstraintsDefCS__Group__0 ) ) ;
    public final void ruleConstraintsDefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:217:2: ( ( ( rule__ConstraintsDefCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:218:2: ( ( rule__ConstraintsDefCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:218:2: ( ( rule__ConstraintsDefCS__Group__0 ) )
            // InternalMiniOCLCS.g:219:3: ( rule__ConstraintsDefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:220:3: ( rule__ConstraintsDefCS__Group__0 )
            // InternalMiniOCLCS.g:220:4: rule__ConstraintsDefCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintsDefCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintsDefCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraintsDefCS"


    // $ANTLR start "entryRuleInvariantCS"
    // InternalMiniOCLCS.g:229:1: entryRuleInvariantCS : ruleInvariantCS EOF ;
    public final void entryRuleInvariantCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:230:1: ( ruleInvariantCS EOF )
            // InternalMiniOCLCS.g:231:1: ruleInvariantCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleInvariantCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInvariantCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInvariantCS"


    // $ANTLR start "ruleInvariantCS"
    // InternalMiniOCLCS.g:238:1: ruleInvariantCS : ( ( rule__InvariantCS__Group__0 ) ) ;
    public final void ruleInvariantCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:242:2: ( ( ( rule__InvariantCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:243:2: ( ( rule__InvariantCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:243:2: ( ( rule__InvariantCS__Group__0 ) )
            // InternalMiniOCLCS.g:244:3: ( rule__InvariantCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:245:3: ( rule__InvariantCS__Group__0 )
            // InternalMiniOCLCS.g:245:4: rule__InvariantCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InvariantCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInvariantCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInvariantCS"


    // $ANTLR start "entryRuleExpCS"
    // InternalMiniOCLCS.g:254:1: entryRuleExpCS : ruleExpCS EOF ;
    public final void entryRuleExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:255:1: ( ruleExpCS EOF )
            // InternalMiniOCLCS.g:256:1: ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpCS"


    // $ANTLR start "ruleExpCS"
    // InternalMiniOCLCS.g:263:1: ruleExpCS : ( ruleLogicExpCS ) ;
    public final void ruleExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:267:2: ( ( ruleLogicExpCS ) )
            // InternalMiniOCLCS.g:268:2: ( ruleLogicExpCS )
            {
            // InternalMiniOCLCS.g:268:2: ( ruleLogicExpCS )
            // InternalMiniOCLCS.g:269:3: ruleLogicExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpCSAccess().getLogicExpCSParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            ruleLogicExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpCSAccess().getLogicExpCSParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpCS"


    // $ANTLR start "entryRuleLogicExpCS"
    // InternalMiniOCLCS.g:279:1: entryRuleLogicExpCS : ruleLogicExpCS EOF ;
    public final void entryRuleLogicExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:280:1: ( ruleLogicExpCS EOF )
            // InternalMiniOCLCS.g:281:1: ruleLogicExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLogicExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicExpCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLogicExpCS"


    // $ANTLR start "ruleLogicExpCS"
    // InternalMiniOCLCS.g:288:1: ruleLogicExpCS : ( ( rule__LogicExpCS__Group__0 ) ) ;
    public final void ruleLogicExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:292:2: ( ( ( rule__LogicExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:293:2: ( ( rule__LogicExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:293:2: ( ( rule__LogicExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:294:3: ( rule__LogicExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:295:3: ( rule__LogicExpCS__Group__0 )
            // InternalMiniOCLCS.g:295:4: rule__LogicExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LogicExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicExpCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogicExpCS"


    // $ANTLR start "entryRuleCallExpCS"
    // InternalMiniOCLCS.g:304:1: entryRuleCallExpCS : ruleCallExpCS EOF ;
    public final void entryRuleCallExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:305:1: ( ruleCallExpCS EOF )
            // InternalMiniOCLCS.g:306:1: ruleCallExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCallExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCallExpCS"


    // $ANTLR start "ruleCallExpCS"
    // InternalMiniOCLCS.g:313:1: ruleCallExpCS : ( ( rule__CallExpCS__Group__0 ) ) ;
    public final void ruleCallExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:317:2: ( ( ( rule__CallExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:318:2: ( ( rule__CallExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:318:2: ( ( rule__CallExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:319:3: ( rule__CallExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:320:3: ( rule__CallExpCS__Group__0 )
            // InternalMiniOCLCS.g:320:4: rule__CallExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CallExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCallExpCS"


    // $ANTLR start "entryRulePrimaryExpCS"
    // InternalMiniOCLCS.g:329:1: entryRulePrimaryExpCS : rulePrimaryExpCS EOF ;
    public final void entryRulePrimaryExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:330:1: ( rulePrimaryExpCS EOF )
            // InternalMiniOCLCS.g:331:1: rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryExpCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExpCS"


    // $ANTLR start "rulePrimaryExpCS"
    // InternalMiniOCLCS.g:338:1: rulePrimaryExpCS : ( ( rule__PrimaryExpCS__Alternatives ) ) ;
    public final void rulePrimaryExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:342:2: ( ( ( rule__PrimaryExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:343:2: ( ( rule__PrimaryExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:343:2: ( ( rule__PrimaryExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:344:3: ( rule__PrimaryExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:345:3: ( rule__PrimaryExpCS__Alternatives )
            // InternalMiniOCLCS.g:345:4: rule__PrimaryExpCS__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExpCS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimaryExpCSAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpCS"


    // $ANTLR start "entryRuleNameExpCS"
    // InternalMiniOCLCS.g:354:1: entryRuleNameExpCS : ruleNameExpCS EOF ;
    public final void entryRuleNameExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:355:1: ( ruleNameExpCS EOF )
            // InternalMiniOCLCS.g:356:1: ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNameExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNameExpCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNameExpCS"


    // $ANTLR start "ruleNameExpCS"
    // InternalMiniOCLCS.g:363:1: ruleNameExpCS : ( ( rule__NameExpCS__Group__0 ) ) ;
    public final void ruleNameExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:367:2: ( ( ( rule__NameExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:368:2: ( ( rule__NameExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:368:2: ( ( rule__NameExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:369:3: ( rule__NameExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:370:3: ( rule__NameExpCS__Group__0 )
            // InternalMiniOCLCS.g:370:4: rule__NameExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NameExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNameExpCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNameExpCS"


    // $ANTLR start "entryRuleRoundedBracketClauseCS"
    // InternalMiniOCLCS.g:379:1: entryRuleRoundedBracketClauseCS : ruleRoundedBracketClauseCS EOF ;
    public final void entryRuleRoundedBracketClauseCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:380:1: ( ruleRoundedBracketClauseCS EOF )
            // InternalMiniOCLCS.g:381:1: ruleRoundedBracketClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleRoundedBracketClauseCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRoundedBracketClauseCS"


    // $ANTLR start "ruleRoundedBracketClauseCS"
    // InternalMiniOCLCS.g:388:1: ruleRoundedBracketClauseCS : ( ( rule__RoundedBracketClauseCS__Group__0 ) ) ;
    public final void ruleRoundedBracketClauseCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:392:2: ( ( ( rule__RoundedBracketClauseCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:393:2: ( ( rule__RoundedBracketClauseCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:393:2: ( ( rule__RoundedBracketClauseCS__Group__0 ) )
            // InternalMiniOCLCS.g:394:3: ( rule__RoundedBracketClauseCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:395:3: ( rule__RoundedBracketClauseCS__Group__0 )
            // InternalMiniOCLCS.g:395:4: rule__RoundedBracketClauseCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRoundedBracketClauseCS"


    // $ANTLR start "entryRuleLiteralExpCS"
    // InternalMiniOCLCS.g:404:1: entryRuleLiteralExpCS : ruleLiteralExpCS EOF ;
    public final void entryRuleLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:405:1: ( ruleLiteralExpCS EOF )
            // InternalMiniOCLCS.g:406:1: ruleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLiteralExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralExpCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralExpCS"


    // $ANTLR start "ruleLiteralExpCS"
    // InternalMiniOCLCS.g:413:1: ruleLiteralExpCS : ( ( rule__LiteralExpCS__Alternatives ) ) ;
    public final void ruleLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:417:2: ( ( ( rule__LiteralExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:418:2: ( ( rule__LiteralExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:418:2: ( ( rule__LiteralExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:419:3: ( rule__LiteralExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:420:3: ( rule__LiteralExpCS__Alternatives )
            // InternalMiniOCLCS.g:420:4: rule__LiteralExpCS__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LiteralExpCS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLiteralExpCSAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralExpCS"


    // $ANTLR start "entryRuleIntLiteralExpCS"
    // InternalMiniOCLCS.g:429:1: entryRuleIntLiteralExpCS : ruleIntLiteralExpCS EOF ;
    public final void entryRuleIntLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:430:1: ( ruleIntLiteralExpCS EOF )
            // InternalMiniOCLCS.g:431:1: ruleIntLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIntLiteralExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralExpCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntLiteralExpCS"


    // $ANTLR start "ruleIntLiteralExpCS"
    // InternalMiniOCLCS.g:438:1: ruleIntLiteralExpCS : ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) ) ;
    public final void ruleIntLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:442:2: ( ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) ) )
            // InternalMiniOCLCS.g:443:2: ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) )
            {
            // InternalMiniOCLCS.g:443:2: ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) )
            // InternalMiniOCLCS.g:444:3: ( rule__IntLiteralExpCS__IntSymbolAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralExpCSAccess().getIntSymbolAssignment()); 
            }
            // InternalMiniOCLCS.g:445:3: ( rule__IntLiteralExpCS__IntSymbolAssignment )
            // InternalMiniOCLCS.g:445:4: rule__IntLiteralExpCS__IntSymbolAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IntLiteralExpCS__IntSymbolAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralExpCSAccess().getIntSymbolAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntLiteralExpCS"


    // $ANTLR start "entryRuleStringLiteralExpCS"
    // InternalMiniOCLCS.g:454:1: entryRuleStringLiteralExpCS : ruleStringLiteralExpCS EOF ;
    public final void entryRuleStringLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:455:1: ( ruleStringLiteralExpCS EOF )
            // InternalMiniOCLCS.g:456:1: ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralExpCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringLiteralExpCS"


    // $ANTLR start "ruleStringLiteralExpCS"
    // InternalMiniOCLCS.g:463:1: ruleStringLiteralExpCS : ( ( rule__StringLiteralExpCS__StringSymbolAssignment ) ) ;
    public final void ruleStringLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:467:2: ( ( ( rule__StringLiteralExpCS__StringSymbolAssignment ) ) )
            // InternalMiniOCLCS.g:468:2: ( ( rule__StringLiteralExpCS__StringSymbolAssignment ) )
            {
            // InternalMiniOCLCS.g:468:2: ( ( rule__StringLiteralExpCS__StringSymbolAssignment ) )
            // InternalMiniOCLCS.g:469:3: ( rule__StringLiteralExpCS__StringSymbolAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralExpCSAccess().getStringSymbolAssignment()); 
            }
            // InternalMiniOCLCS.g:470:3: ( rule__StringLiteralExpCS__StringSymbolAssignment )
            // InternalMiniOCLCS.g:470:4: rule__StringLiteralExpCS__StringSymbolAssignment
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteralExpCS__StringSymbolAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralExpCSAccess().getStringSymbolAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringLiteralExpCS"


    // $ANTLR start "entryRuleBooleanLiteralExpCS"
    // InternalMiniOCLCS.g:479:1: entryRuleBooleanLiteralExpCS : ruleBooleanLiteralExpCS EOF ;
    public final void entryRuleBooleanLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:480:1: ( ruleBooleanLiteralExpCS EOF )
            // InternalMiniOCLCS.g:481:1: ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanLiteralExpCS"


    // $ANTLR start "ruleBooleanLiteralExpCS"
    // InternalMiniOCLCS.g:488:1: ruleBooleanLiteralExpCS : ( ( rule__BooleanLiteralExpCS__Group__0 ) ) ;
    public final void ruleBooleanLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:492:2: ( ( ( rule__BooleanLiteralExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:493:2: ( ( rule__BooleanLiteralExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:493:2: ( ( rule__BooleanLiteralExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:494:3: ( rule__BooleanLiteralExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:495:3: ( rule__BooleanLiteralExpCS__Group__0 )
            // InternalMiniOCLCS.g:495:4: rule__BooleanLiteralExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralExpCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanLiteralExpCS"


    // $ANTLR start "entryRulePathNameCS"
    // InternalMiniOCLCS.g:504:1: entryRulePathNameCS : rulePathNameCS EOF ;
    public final void entryRulePathNameCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:505:1: ( rulePathNameCS EOF )
            // InternalMiniOCLCS.g:506:1: rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePathNameCS"


    // $ANTLR start "rulePathNameCS"
    // InternalMiniOCLCS.g:513:1: rulePathNameCS : ( ( rule__PathNameCS__Group__0 ) ) ;
    public final void rulePathNameCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:517:2: ( ( ( rule__PathNameCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:518:2: ( ( rule__PathNameCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:518:2: ( ( rule__PathNameCS__Group__0 ) )
            // InternalMiniOCLCS.g:519:3: ( rule__PathNameCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:520:3: ( rule__PathNameCS__Group__0 )
            // InternalMiniOCLCS.g:520:4: rule__PathNameCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PathNameCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePathNameCS"


    // $ANTLR start "entryRulePathElementCS"
    // InternalMiniOCLCS.g:529:1: entryRulePathElementCS : rulePathElementCS EOF ;
    public final void entryRulePathElementCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:530:1: ( rulePathElementCS EOF )
            // InternalMiniOCLCS.g:531:1: rulePathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathElementCSRule()); 
            }
            pushFollow(FOLLOW_1);
            rulePathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathElementCSRule()); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePathElementCS"


    // $ANTLR start "rulePathElementCS"
    // InternalMiniOCLCS.g:538:1: rulePathElementCS : ( ( rule__PathElementCS__ElementNameAssignment ) ) ;
    public final void rulePathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:542:2: ( ( ( rule__PathElementCS__ElementNameAssignment ) ) )
            // InternalMiniOCLCS.g:543:2: ( ( rule__PathElementCS__ElementNameAssignment ) )
            {
            // InternalMiniOCLCS.g:543:2: ( ( rule__PathElementCS__ElementNameAssignment ) )
            // InternalMiniOCLCS.g:544:3: ( rule__PathElementCS__ElementNameAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathElementCSAccess().getElementNameAssignment()); 
            }
            // InternalMiniOCLCS.g:545:3: ( rule__PathElementCS__ElementNameAssignment )
            // InternalMiniOCLCS.g:545:4: rule__PathElementCS__ElementNameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PathElementCS__ElementNameAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathElementCSAccess().getElementNameAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePathElementCS"


    // $ANTLR start "rule__RootCS__Alternatives"
    // InternalMiniOCLCS.g:553:1: rule__RootCS__Alternatives : ( ( ( rule__RootCS__PackagesAssignment_0 ) ) | ( ( rule__RootCS__ContraintsAssignment_1 ) ) );
    public final void rule__RootCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:557:1: ( ( ( rule__RootCS__PackagesAssignment_0 ) ) | ( ( rule__RootCS__ContraintsAssignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            else if ( (LA2_0==28) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMiniOCLCS.g:558:2: ( ( rule__RootCS__PackagesAssignment_0 ) )
                    {
                    // InternalMiniOCLCS.g:558:2: ( ( rule__RootCS__PackagesAssignment_0 ) )
                    // InternalMiniOCLCS.g:559:3: ( rule__RootCS__PackagesAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRootCSAccess().getPackagesAssignment_0()); 
                    }
                    // InternalMiniOCLCS.g:560:3: ( rule__RootCS__PackagesAssignment_0 )
                    // InternalMiniOCLCS.g:560:4: rule__RootCS__PackagesAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RootCS__PackagesAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRootCSAccess().getPackagesAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:564:2: ( ( rule__RootCS__ContraintsAssignment_1 ) )
                    {
                    // InternalMiniOCLCS.g:564:2: ( ( rule__RootCS__ContraintsAssignment_1 ) )
                    // InternalMiniOCLCS.g:565:3: ( rule__RootCS__ContraintsAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRootCSAccess().getContraintsAssignment_1()); 
                    }
                    // InternalMiniOCLCS.g:566:3: ( rule__RootCS__ContraintsAssignment_1 )
                    // InternalMiniOCLCS.g:566:4: rule__RootCS__ContraintsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__RootCS__ContraintsAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRootCSAccess().getContraintsAssignment_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootCS__Alternatives"


    // $ANTLR start "rule__PackageCS__Alternatives_3"
    // InternalMiniOCLCS.g:574:1: rule__PackageCS__Alternatives_3 : ( ( ( rule__PackageCS__PackagesAssignment_3_0 ) ) | ( ( rule__PackageCS__ClassesAssignment_3_1 ) ) );
    public final void rule__PackageCS__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:578:1: ( ( ( rule__PackageCS__PackagesAssignment_3_0 ) ) | ( ( rule__PackageCS__ClassesAssignment_3_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMiniOCLCS.g:579:2: ( ( rule__PackageCS__PackagesAssignment_3_0 ) )
                    {
                    // InternalMiniOCLCS.g:579:2: ( ( rule__PackageCS__PackagesAssignment_3_0 ) )
                    // InternalMiniOCLCS.g:580:3: ( rule__PackageCS__PackagesAssignment_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPackageCSAccess().getPackagesAssignment_3_0()); 
                    }
                    // InternalMiniOCLCS.g:581:3: ( rule__PackageCS__PackagesAssignment_3_0 )
                    // InternalMiniOCLCS.g:581:4: rule__PackageCS__PackagesAssignment_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PackageCS__PackagesAssignment_3_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPackageCSAccess().getPackagesAssignment_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:585:2: ( ( rule__PackageCS__ClassesAssignment_3_1 ) )
                    {
                    // InternalMiniOCLCS.g:585:2: ( ( rule__PackageCS__ClassesAssignment_3_1 ) )
                    // InternalMiniOCLCS.g:586:3: ( rule__PackageCS__ClassesAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPackageCSAccess().getClassesAssignment_3_1()); 
                    }
                    // InternalMiniOCLCS.g:587:3: ( rule__PackageCS__ClassesAssignment_3_1 )
                    // InternalMiniOCLCS.g:587:4: rule__PackageCS__ClassesAssignment_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__PackageCS__ClassesAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPackageCSAccess().getClassesAssignment_3_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Alternatives_3"


    // $ANTLR start "rule__ClassCS__Alternatives_4"
    // InternalMiniOCLCS.g:595:1: rule__ClassCS__Alternatives_4 : ( ( ( rule__ClassCS__PropertiesAssignment_4_0 ) ) | ( ( rule__ClassCS__OperationsAssignment_4_1 ) ) );
    public final void rule__ClassCS__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:599:1: ( ( ( rule__ClassCS__PropertiesAssignment_4_0 ) ) | ( ( rule__ClassCS__OperationsAssignment_4_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            else if ( (LA4_0==24) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMiniOCLCS.g:600:2: ( ( rule__ClassCS__PropertiesAssignment_4_0 ) )
                    {
                    // InternalMiniOCLCS.g:600:2: ( ( rule__ClassCS__PropertiesAssignment_4_0 ) )
                    // InternalMiniOCLCS.g:601:3: ( rule__ClassCS__PropertiesAssignment_4_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassCSAccess().getPropertiesAssignment_4_0()); 
                    }
                    // InternalMiniOCLCS.g:602:3: ( rule__ClassCS__PropertiesAssignment_4_0 )
                    // InternalMiniOCLCS.g:602:4: rule__ClassCS__PropertiesAssignment_4_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassCS__PropertiesAssignment_4_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassCSAccess().getPropertiesAssignment_4_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:606:2: ( ( rule__ClassCS__OperationsAssignment_4_1 ) )
                    {
                    // InternalMiniOCLCS.g:606:2: ( ( rule__ClassCS__OperationsAssignment_4_1 ) )
                    // InternalMiniOCLCS.g:607:3: ( rule__ClassCS__OperationsAssignment_4_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassCSAccess().getOperationsAssignment_4_1()); 
                    }
                    // InternalMiniOCLCS.g:608:3: ( rule__ClassCS__OperationsAssignment_4_1 )
                    // InternalMiniOCLCS.g:608:4: rule__ClassCS__OperationsAssignment_4_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassCS__OperationsAssignment_4_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassCSAccess().getOperationsAssignment_4_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Alternatives_4"


    // $ANTLR start "rule__LogicExpCS__OpAlternatives_1_1_0"
    // InternalMiniOCLCS.g:616:1: rule__LogicExpCS__OpAlternatives_1_1_0 : ( ( '=' ) | ( '<>' ) );
    public final void rule__LogicExpCS__OpAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:620:1: ( ( '=' ) | ( '<>' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            else if ( (LA5_0==12) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalMiniOCLCS.g:621:2: ( '=' )
                    {
                    // InternalMiniOCLCS.g:621:2: ( '=' )
                    // InternalMiniOCLCS.g:622:3: '='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLogicExpCSAccess().getOpEqualsSignKeyword_1_1_0_0()); 
                    }
                    match(input,11,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLogicExpCSAccess().getOpEqualsSignKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:627:2: ( '<>' )
                    {
                    // InternalMiniOCLCS.g:627:2: ( '<>' )
                    // InternalMiniOCLCS.g:628:3: '<>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLogicExpCSAccess().getOpLessThanSignGreaterThanSignKeyword_1_1_0_1()); 
                    }
                    match(input,12,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLogicExpCSAccess().getOpLessThanSignGreaterThanSignKeyword_1_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__OpAlternatives_1_1_0"


    // $ANTLR start "rule__CallExpCS__OpAlternatives_1_1_0"
    // InternalMiniOCLCS.g:637:1: rule__CallExpCS__OpAlternatives_1_1_0 : ( ( '.' ) | ( '->' ) );
    public final void rule__CallExpCS__OpAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:641:1: ( ( '.' ) | ( '->' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                alt6=1;
            }
            else if ( (LA6_0==14) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMiniOCLCS.g:642:2: ( '.' )
                    {
                    // InternalMiniOCLCS.g:642:2: ( '.' )
                    // InternalMiniOCLCS.g:643:3: '.'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpCSAccess().getOpFullStopKeyword_1_1_0_0()); 
                    }
                    match(input,13,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCallExpCSAccess().getOpFullStopKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:648:2: ( '->' )
                    {
                    // InternalMiniOCLCS.g:648:2: ( '->' )
                    // InternalMiniOCLCS.g:649:3: '->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpCSAccess().getOpHyphenMinusGreaterThanSignKeyword_1_1_0_1()); 
                    }
                    match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCallExpCSAccess().getOpHyphenMinusGreaterThanSignKeyword_1_1_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__OpAlternatives_1_1_0"


    // $ANTLR start "rule__PrimaryExpCS__Alternatives"
    // InternalMiniOCLCS.g:658:1: rule__PrimaryExpCS__Alternatives : ( ( ruleNameExpCS ) | ( ruleLiteralExpCS ) );
    public final void rule__PrimaryExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:662:1: ( ( ruleNameExpCS ) | ( ruleLiteralExpCS ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=RULE_INT && LA7_0<=RULE_STRING)||LA7_0==15||LA7_0==31) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMiniOCLCS.g:663:2: ( ruleNameExpCS )
                    {
                    // InternalMiniOCLCS.g:663:2: ( ruleNameExpCS )
                    // InternalMiniOCLCS.g:664:3: ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:669:2: ( ruleLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:669:2: ( ruleLiteralExpCS )
                    // InternalMiniOCLCS.g:670:3: ruleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExpCS__Alternatives"


    // $ANTLR start "rule__LiteralExpCS__Alternatives"
    // InternalMiniOCLCS.g:679:1: rule__LiteralExpCS__Alternatives : ( ( ruleIntLiteralExpCS ) | ( ruleStringLiteralExpCS ) | ( ruleBooleanLiteralExpCS ) );
    public final void rule__LiteralExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:683:1: ( ( ruleIntLiteralExpCS ) | ( ruleStringLiteralExpCS ) | ( ruleBooleanLiteralExpCS ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt8=1;
                }
                break;
            case RULE_STRING:
                {
                alt8=2;
                }
                break;
            case 15:
            case 31:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalMiniOCLCS.g:684:2: ( ruleIntLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:684:2: ( ruleIntLiteralExpCS )
                    // InternalMiniOCLCS.g:685:3: ruleIntLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralExpCSAccess().getIntLiteralExpCSParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIntLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralExpCSAccess().getIntLiteralExpCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:690:2: ( ruleStringLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:690:2: ( ruleStringLiteralExpCS )
                    // InternalMiniOCLCS.g:691:3: ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleStringLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniOCLCS.g:696:2: ( ruleBooleanLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:696:2: ( ruleBooleanLiteralExpCS )
                    // InternalMiniOCLCS.g:697:3: ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBooleanLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpCS__Alternatives"


    // $ANTLR start "rule__BooleanLiteralExpCS__Alternatives_1"
    // InternalMiniOCLCS.g:706:1: rule__BooleanLiteralExpCS__Alternatives_1 : ( ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralExpCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:710:1: ( ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) ) | ( 'false' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==31) ) {
                alt9=1;
            }
            else if ( (LA9_0==15) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalMiniOCLCS.g:711:2: ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) )
                    {
                    // InternalMiniOCLCS.g:711:2: ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) )
                    // InternalMiniOCLCS.g:712:3: ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolAssignment_1_0()); 
                    }
                    // InternalMiniOCLCS.g:713:3: ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 )
                    // InternalMiniOCLCS.g:713:4: rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolAssignment_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:717:2: ( 'false' )
                    {
                    // InternalMiniOCLCS.g:717:2: ( 'false' )
                    // InternalMiniOCLCS.g:718:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralExpCSAccess().getFalseKeyword_1_1()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getBooleanLiteralExpCSAccess().getFalseKeyword_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralExpCS__Alternatives_1"


    // $ANTLR start "rule__PackageCS__Group__0"
    // InternalMiniOCLCS.g:727:1: rule__PackageCS__Group__0 : rule__PackageCS__Group__0__Impl rule__PackageCS__Group__1 ;
    public final void rule__PackageCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:731:1: ( rule__PackageCS__Group__0__Impl rule__PackageCS__Group__1 )
            // InternalMiniOCLCS.g:732:2: rule__PackageCS__Group__0__Impl rule__PackageCS__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__PackageCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PackageCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__0"


    // $ANTLR start "rule__PackageCS__Group__0__Impl"
    // InternalMiniOCLCS.g:739:1: rule__PackageCS__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:743:1: ( ( 'package' ) )
            // InternalMiniOCLCS.g:744:1: ( 'package' )
            {
            // InternalMiniOCLCS.g:744:1: ( 'package' )
            // InternalMiniOCLCS.g:745:2: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getPackageKeyword_0()); 
            }
            match(input,16,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getPackageKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__0__Impl"


    // $ANTLR start "rule__PackageCS__Group__1"
    // InternalMiniOCLCS.g:754:1: rule__PackageCS__Group__1 : rule__PackageCS__Group__1__Impl rule__PackageCS__Group__2 ;
    public final void rule__PackageCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:758:1: ( rule__PackageCS__Group__1__Impl rule__PackageCS__Group__2 )
            // InternalMiniOCLCS.g:759:2: rule__PackageCS__Group__1__Impl rule__PackageCS__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__PackageCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PackageCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__1"


    // $ANTLR start "rule__PackageCS__Group__1__Impl"
    // InternalMiniOCLCS.g:766:1: rule__PackageCS__Group__1__Impl : ( ( rule__PackageCS__NameAssignment_1 ) ) ;
    public final void rule__PackageCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:770:1: ( ( ( rule__PackageCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:771:1: ( ( rule__PackageCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:771:1: ( ( rule__PackageCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:772:2: ( rule__PackageCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:773:2: ( rule__PackageCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:773:3: rule__PackageCS__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PackageCS__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__1__Impl"


    // $ANTLR start "rule__PackageCS__Group__2"
    // InternalMiniOCLCS.g:781:1: rule__PackageCS__Group__2 : rule__PackageCS__Group__2__Impl rule__PackageCS__Group__3 ;
    public final void rule__PackageCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:785:1: ( rule__PackageCS__Group__2__Impl rule__PackageCS__Group__3 )
            // InternalMiniOCLCS.g:786:2: rule__PackageCS__Group__2__Impl rule__PackageCS__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__PackageCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PackageCS__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__2"


    // $ANTLR start "rule__PackageCS__Group__2__Impl"
    // InternalMiniOCLCS.g:793:1: rule__PackageCS__Group__2__Impl : ( '{' ) ;
    public final void rule__PackageCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:797:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:798:1: ( '{' )
            {
            // InternalMiniOCLCS.g:798:1: ( '{' )
            // InternalMiniOCLCS.g:799:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__2__Impl"


    // $ANTLR start "rule__PackageCS__Group__3"
    // InternalMiniOCLCS.g:808:1: rule__PackageCS__Group__3 : rule__PackageCS__Group__3__Impl rule__PackageCS__Group__4 ;
    public final void rule__PackageCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:812:1: ( rule__PackageCS__Group__3__Impl rule__PackageCS__Group__4 )
            // InternalMiniOCLCS.g:813:2: rule__PackageCS__Group__3__Impl rule__PackageCS__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__PackageCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PackageCS__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__3"


    // $ANTLR start "rule__PackageCS__Group__3__Impl"
    // InternalMiniOCLCS.g:820:1: rule__PackageCS__Group__3__Impl : ( ( rule__PackageCS__Alternatives_3 )* ) ;
    public final void rule__PackageCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:824:1: ( ( ( rule__PackageCS__Alternatives_3 )* ) )
            // InternalMiniOCLCS.g:825:1: ( ( rule__PackageCS__Alternatives_3 )* )
            {
            // InternalMiniOCLCS.g:825:1: ( ( rule__PackageCS__Alternatives_3 )* )
            // InternalMiniOCLCS.g:826:2: ( rule__PackageCS__Alternatives_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getAlternatives_3()); 
            }
            // InternalMiniOCLCS.g:827:2: ( rule__PackageCS__Alternatives_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==16||LA10_0==19) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMiniOCLCS.g:827:3: rule__PackageCS__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__PackageCS__Alternatives_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getAlternatives_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__3__Impl"


    // $ANTLR start "rule__PackageCS__Group__4"
    // InternalMiniOCLCS.g:835:1: rule__PackageCS__Group__4 : rule__PackageCS__Group__4__Impl ;
    public final void rule__PackageCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:839:1: ( rule__PackageCS__Group__4__Impl )
            // InternalMiniOCLCS.g:840:2: rule__PackageCS__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PackageCS__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__4"


    // $ANTLR start "rule__PackageCS__Group__4__Impl"
    // InternalMiniOCLCS.g:846:1: rule__PackageCS__Group__4__Impl : ( '}' ) ;
    public final void rule__PackageCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:850:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:851:1: ( '}' )
            {
            // InternalMiniOCLCS.g:851:1: ( '}' )
            // InternalMiniOCLCS.g:852:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__Group__4__Impl"


    // $ANTLR start "rule__ClassCS__Group__0"
    // InternalMiniOCLCS.g:862:1: rule__ClassCS__Group__0 : rule__ClassCS__Group__0__Impl rule__ClassCS__Group__1 ;
    public final void rule__ClassCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:866:1: ( rule__ClassCS__Group__0__Impl rule__ClassCS__Group__1 )
            // InternalMiniOCLCS.g:867:2: rule__ClassCS__Group__0__Impl rule__ClassCS__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ClassCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__0"


    // $ANTLR start "rule__ClassCS__Group__0__Impl"
    // InternalMiniOCLCS.g:874:1: rule__ClassCS__Group__0__Impl : ( 'class' ) ;
    public final void rule__ClassCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:878:1: ( ( 'class' ) )
            // InternalMiniOCLCS.g:879:1: ( 'class' )
            {
            // InternalMiniOCLCS.g:879:1: ( 'class' )
            // InternalMiniOCLCS.g:880:2: 'class'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getClassKeyword_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getClassKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__0__Impl"


    // $ANTLR start "rule__ClassCS__Group__1"
    // InternalMiniOCLCS.g:889:1: rule__ClassCS__Group__1 : rule__ClassCS__Group__1__Impl rule__ClassCS__Group__2 ;
    public final void rule__ClassCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:893:1: ( rule__ClassCS__Group__1__Impl rule__ClassCS__Group__2 )
            // InternalMiniOCLCS.g:894:2: rule__ClassCS__Group__1__Impl rule__ClassCS__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__ClassCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__1"


    // $ANTLR start "rule__ClassCS__Group__1__Impl"
    // InternalMiniOCLCS.g:901:1: rule__ClassCS__Group__1__Impl : ( ( rule__ClassCS__NameAssignment_1 ) ) ;
    public final void rule__ClassCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:905:1: ( ( ( rule__ClassCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:906:1: ( ( rule__ClassCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:906:1: ( ( rule__ClassCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:907:2: ( rule__ClassCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:908:2: ( rule__ClassCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:908:3: rule__ClassCS__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassCS__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__1__Impl"


    // $ANTLR start "rule__ClassCS__Group__2"
    // InternalMiniOCLCS.g:916:1: rule__ClassCS__Group__2 : rule__ClassCS__Group__2__Impl rule__ClassCS__Group__3 ;
    public final void rule__ClassCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:920:1: ( rule__ClassCS__Group__2__Impl rule__ClassCS__Group__3 )
            // InternalMiniOCLCS.g:921:2: rule__ClassCS__Group__2__Impl rule__ClassCS__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__ClassCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassCS__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__2"


    // $ANTLR start "rule__ClassCS__Group__2__Impl"
    // InternalMiniOCLCS.g:928:1: rule__ClassCS__Group__2__Impl : ( ( rule__ClassCS__Group_2__0 )? ) ;
    public final void rule__ClassCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:932:1: ( ( ( rule__ClassCS__Group_2__0 )? ) )
            // InternalMiniOCLCS.g:933:1: ( ( rule__ClassCS__Group_2__0 )? )
            {
            // InternalMiniOCLCS.g:933:1: ( ( rule__ClassCS__Group_2__0 )? )
            // InternalMiniOCLCS.g:934:2: ( rule__ClassCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:935:2: ( rule__ClassCS__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMiniOCLCS.g:935:3: rule__ClassCS__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ClassCS__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__2__Impl"


    // $ANTLR start "rule__ClassCS__Group__3"
    // InternalMiniOCLCS.g:943:1: rule__ClassCS__Group__3 : rule__ClassCS__Group__3__Impl rule__ClassCS__Group__4 ;
    public final void rule__ClassCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:947:1: ( rule__ClassCS__Group__3__Impl rule__ClassCS__Group__4 )
            // InternalMiniOCLCS.g:948:2: rule__ClassCS__Group__3__Impl rule__ClassCS__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__ClassCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassCS__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__3"


    // $ANTLR start "rule__ClassCS__Group__3__Impl"
    // InternalMiniOCLCS.g:955:1: rule__ClassCS__Group__3__Impl : ( '{' ) ;
    public final void rule__ClassCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:959:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:960:1: ( '{' )
            {
            // InternalMiniOCLCS.g:960:1: ( '{' )
            // InternalMiniOCLCS.g:961:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getLeftCurlyBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__3__Impl"


    // $ANTLR start "rule__ClassCS__Group__4"
    // InternalMiniOCLCS.g:970:1: rule__ClassCS__Group__4 : rule__ClassCS__Group__4__Impl rule__ClassCS__Group__5 ;
    public final void rule__ClassCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:974:1: ( rule__ClassCS__Group__4__Impl rule__ClassCS__Group__5 )
            // InternalMiniOCLCS.g:975:2: rule__ClassCS__Group__4__Impl rule__ClassCS__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__ClassCS__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassCS__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__4"


    // $ANTLR start "rule__ClassCS__Group__4__Impl"
    // InternalMiniOCLCS.g:982:1: rule__ClassCS__Group__4__Impl : ( ( rule__ClassCS__Alternatives_4 )* ) ;
    public final void rule__ClassCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:986:1: ( ( ( rule__ClassCS__Alternatives_4 )* ) )
            // InternalMiniOCLCS.g:987:1: ( ( rule__ClassCS__Alternatives_4 )* )
            {
            // InternalMiniOCLCS.g:987:1: ( ( rule__ClassCS__Alternatives_4 )* )
            // InternalMiniOCLCS.g:988:2: ( rule__ClassCS__Alternatives_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getAlternatives_4()); 
            }
            // InternalMiniOCLCS.g:989:2: ( rule__ClassCS__Alternatives_4 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21||LA12_0==24) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMiniOCLCS.g:989:3: rule__ClassCS__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__ClassCS__Alternatives_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getAlternatives_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__4__Impl"


    // $ANTLR start "rule__ClassCS__Group__5"
    // InternalMiniOCLCS.g:997:1: rule__ClassCS__Group__5 : rule__ClassCS__Group__5__Impl ;
    public final void rule__ClassCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1001:1: ( rule__ClassCS__Group__5__Impl )
            // InternalMiniOCLCS.g:1002:2: rule__ClassCS__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassCS__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__5"


    // $ANTLR start "rule__ClassCS__Group__5__Impl"
    // InternalMiniOCLCS.g:1008:1: rule__ClassCS__Group__5__Impl : ( '}' ) ;
    public final void rule__ClassCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1012:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:1013:1: ( '}' )
            {
            // InternalMiniOCLCS.g:1013:1: ( '}' )
            // InternalMiniOCLCS.g:1014:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group__5__Impl"


    // $ANTLR start "rule__ClassCS__Group_2__0"
    // InternalMiniOCLCS.g:1024:1: rule__ClassCS__Group_2__0 : rule__ClassCS__Group_2__0__Impl rule__ClassCS__Group_2__1 ;
    public final void rule__ClassCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1028:1: ( rule__ClassCS__Group_2__0__Impl rule__ClassCS__Group_2__1 )
            // InternalMiniOCLCS.g:1029:2: rule__ClassCS__Group_2__0__Impl rule__ClassCS__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__ClassCS__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ClassCS__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group_2__0"


    // $ANTLR start "rule__ClassCS__Group_2__0__Impl"
    // InternalMiniOCLCS.g:1036:1: rule__ClassCS__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__ClassCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1040:1: ( ( 'extends' ) )
            // InternalMiniOCLCS.g:1041:1: ( 'extends' )
            {
            // InternalMiniOCLCS.g:1041:1: ( 'extends' )
            // InternalMiniOCLCS.g:1042:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getExtendsKeyword_2_0()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getExtendsKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group_2__0__Impl"


    // $ANTLR start "rule__ClassCS__Group_2__1"
    // InternalMiniOCLCS.g:1051:1: rule__ClassCS__Group_2__1 : rule__ClassCS__Group_2__1__Impl ;
    public final void rule__ClassCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1055:1: ( rule__ClassCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:1056:2: rule__ClassCS__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ClassCS__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group_2__1"


    // $ANTLR start "rule__ClassCS__Group_2__1__Impl"
    // InternalMiniOCLCS.g:1062:1: rule__ClassCS__Group_2__1__Impl : ( ( rule__ClassCS__ExtendsAssignment_2_1 ) ) ;
    public final void rule__ClassCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1066:1: ( ( ( rule__ClassCS__ExtendsAssignment_2_1 ) ) )
            // InternalMiniOCLCS.g:1067:1: ( ( rule__ClassCS__ExtendsAssignment_2_1 ) )
            {
            // InternalMiniOCLCS.g:1067:1: ( ( rule__ClassCS__ExtendsAssignment_2_1 ) )
            // InternalMiniOCLCS.g:1068:2: ( rule__ClassCS__ExtendsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getExtendsAssignment_2_1()); 
            }
            // InternalMiniOCLCS.g:1069:2: ( rule__ClassCS__ExtendsAssignment_2_1 )
            // InternalMiniOCLCS.g:1069:3: rule__ClassCS__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ClassCS__ExtendsAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getExtendsAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__Group_2__1__Impl"


    // $ANTLR start "rule__PropertyCS__Group__0"
    // InternalMiniOCLCS.g:1078:1: rule__PropertyCS__Group__0 : rule__PropertyCS__Group__0__Impl rule__PropertyCS__Group__1 ;
    public final void rule__PropertyCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1082:1: ( rule__PropertyCS__Group__0__Impl rule__PropertyCS__Group__1 )
            // InternalMiniOCLCS.g:1083:2: rule__PropertyCS__Group__0__Impl rule__PropertyCS__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__PropertyCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PropertyCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__0"


    // $ANTLR start "rule__PropertyCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1090:1: rule__PropertyCS__Group__0__Impl : ( 'prop' ) ;
    public final void rule__PropertyCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1094:1: ( ( 'prop' ) )
            // InternalMiniOCLCS.g:1095:1: ( 'prop' )
            {
            // InternalMiniOCLCS.g:1095:1: ( 'prop' )
            // InternalMiniOCLCS.g:1096:2: 'prop'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getPropKeyword_0()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getPropKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__0__Impl"


    // $ANTLR start "rule__PropertyCS__Group__1"
    // InternalMiniOCLCS.g:1105:1: rule__PropertyCS__Group__1 : rule__PropertyCS__Group__1__Impl rule__PropertyCS__Group__2 ;
    public final void rule__PropertyCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1109:1: ( rule__PropertyCS__Group__1__Impl rule__PropertyCS__Group__2 )
            // InternalMiniOCLCS.g:1110:2: rule__PropertyCS__Group__1__Impl rule__PropertyCS__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__PropertyCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PropertyCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__1"


    // $ANTLR start "rule__PropertyCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1117:1: rule__PropertyCS__Group__1__Impl : ( ( rule__PropertyCS__NameAssignment_1 ) ) ;
    public final void rule__PropertyCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1121:1: ( ( ( rule__PropertyCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1122:1: ( ( rule__PropertyCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1122:1: ( ( rule__PropertyCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:1123:2: ( rule__PropertyCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1124:2: ( rule__PropertyCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:1124:3: rule__PropertyCS__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PropertyCS__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__1__Impl"


    // $ANTLR start "rule__PropertyCS__Group__2"
    // InternalMiniOCLCS.g:1132:1: rule__PropertyCS__Group__2 : rule__PropertyCS__Group__2__Impl rule__PropertyCS__Group__3 ;
    public final void rule__PropertyCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1136:1: ( rule__PropertyCS__Group__2__Impl rule__PropertyCS__Group__3 )
            // InternalMiniOCLCS.g:1137:2: rule__PropertyCS__Group__2__Impl rule__PropertyCS__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__PropertyCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PropertyCS__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__2"


    // $ANTLR start "rule__PropertyCS__Group__2__Impl"
    // InternalMiniOCLCS.g:1144:1: rule__PropertyCS__Group__2__Impl : ( ':' ) ;
    public final void rule__PropertyCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1148:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:1149:1: ( ':' )
            {
            // InternalMiniOCLCS.g:1149:1: ( ':' )
            // InternalMiniOCLCS.g:1150:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getColonKeyword_2()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getColonKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__2__Impl"


    // $ANTLR start "rule__PropertyCS__Group__3"
    // InternalMiniOCLCS.g:1159:1: rule__PropertyCS__Group__3 : rule__PropertyCS__Group__3__Impl rule__PropertyCS__Group__4 ;
    public final void rule__PropertyCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1163:1: ( rule__PropertyCS__Group__3__Impl rule__PropertyCS__Group__4 )
            // InternalMiniOCLCS.g:1164:2: rule__PropertyCS__Group__3__Impl rule__PropertyCS__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__PropertyCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PropertyCS__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__3"


    // $ANTLR start "rule__PropertyCS__Group__3__Impl"
    // InternalMiniOCLCS.g:1171:1: rule__PropertyCS__Group__3__Impl : ( ( rule__PropertyCS__TypeRefAssignment_3 ) ) ;
    public final void rule__PropertyCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1175:1: ( ( ( rule__PropertyCS__TypeRefAssignment_3 ) ) )
            // InternalMiniOCLCS.g:1176:1: ( ( rule__PropertyCS__TypeRefAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:1176:1: ( ( rule__PropertyCS__TypeRefAssignment_3 ) )
            // InternalMiniOCLCS.g:1177:2: ( rule__PropertyCS__TypeRefAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getTypeRefAssignment_3()); 
            }
            // InternalMiniOCLCS.g:1178:2: ( rule__PropertyCS__TypeRefAssignment_3 )
            // InternalMiniOCLCS.g:1178:3: rule__PropertyCS__TypeRefAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__PropertyCS__TypeRefAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getTypeRefAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__3__Impl"


    // $ANTLR start "rule__PropertyCS__Group__4"
    // InternalMiniOCLCS.g:1186:1: rule__PropertyCS__Group__4 : rule__PropertyCS__Group__4__Impl ;
    public final void rule__PropertyCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1190:1: ( rule__PropertyCS__Group__4__Impl )
            // InternalMiniOCLCS.g:1191:2: rule__PropertyCS__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PropertyCS__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__4"


    // $ANTLR start "rule__PropertyCS__Group__4__Impl"
    // InternalMiniOCLCS.g:1197:1: rule__PropertyCS__Group__4__Impl : ( ';' ) ;
    public final void rule__PropertyCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1201:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:1202:1: ( ';' )
            {
            // InternalMiniOCLCS.g:1202:1: ( ';' )
            // InternalMiniOCLCS.g:1203:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getSemicolonKeyword_4()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getSemicolonKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__Group__4__Impl"


    // $ANTLR start "rule__OperationCS__Group__0"
    // InternalMiniOCLCS.g:1213:1: rule__OperationCS__Group__0 : rule__OperationCS__Group__0__Impl rule__OperationCS__Group__1 ;
    public final void rule__OperationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1217:1: ( rule__OperationCS__Group__0__Impl rule__OperationCS__Group__1 )
            // InternalMiniOCLCS.g:1218:2: rule__OperationCS__Group__0__Impl rule__OperationCS__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__OperationCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__0"


    // $ANTLR start "rule__OperationCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1225:1: rule__OperationCS__Group__0__Impl : ( 'op' ) ;
    public final void rule__OperationCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1229:1: ( ( 'op' ) )
            // InternalMiniOCLCS.g:1230:1: ( 'op' )
            {
            // InternalMiniOCLCS.g:1230:1: ( 'op' )
            // InternalMiniOCLCS.g:1231:2: 'op'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getOpKeyword_0()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getOpKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__0__Impl"


    // $ANTLR start "rule__OperationCS__Group__1"
    // InternalMiniOCLCS.g:1240:1: rule__OperationCS__Group__1 : rule__OperationCS__Group__1__Impl rule__OperationCS__Group__2 ;
    public final void rule__OperationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1244:1: ( rule__OperationCS__Group__1__Impl rule__OperationCS__Group__2 )
            // InternalMiniOCLCS.g:1245:2: rule__OperationCS__Group__1__Impl rule__OperationCS__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__OperationCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__1"


    // $ANTLR start "rule__OperationCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1252:1: rule__OperationCS__Group__1__Impl : ( ( rule__OperationCS__NameAssignment_1 ) ) ;
    public final void rule__OperationCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1256:1: ( ( ( rule__OperationCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1257:1: ( ( rule__OperationCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1257:1: ( ( rule__OperationCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:1258:2: ( rule__OperationCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1259:2: ( rule__OperationCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:1259:3: rule__OperationCS__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__OperationCS__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getNameAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__1__Impl"


    // $ANTLR start "rule__OperationCS__Group__2"
    // InternalMiniOCLCS.g:1267:1: rule__OperationCS__Group__2 : rule__OperationCS__Group__2__Impl rule__OperationCS__Group__3 ;
    public final void rule__OperationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1271:1: ( rule__OperationCS__Group__2__Impl rule__OperationCS__Group__3 )
            // InternalMiniOCLCS.g:1272:2: rule__OperationCS__Group__2__Impl rule__OperationCS__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__OperationCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__2"


    // $ANTLR start "rule__OperationCS__Group__2__Impl"
    // InternalMiniOCLCS.g:1279:1: rule__OperationCS__Group__2__Impl : ( '(' ) ;
    public final void rule__OperationCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1283:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:1284:1: ( '(' )
            {
            // InternalMiniOCLCS.g:1284:1: ( '(' )
            // InternalMiniOCLCS.g:1285:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__2__Impl"


    // $ANTLR start "rule__OperationCS__Group__3"
    // InternalMiniOCLCS.g:1294:1: rule__OperationCS__Group__3 : rule__OperationCS__Group__3__Impl rule__OperationCS__Group__4 ;
    public final void rule__OperationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1298:1: ( rule__OperationCS__Group__3__Impl rule__OperationCS__Group__4 )
            // InternalMiniOCLCS.g:1299:2: rule__OperationCS__Group__3__Impl rule__OperationCS__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__OperationCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__3"


    // $ANTLR start "rule__OperationCS__Group__3__Impl"
    // InternalMiniOCLCS.g:1306:1: rule__OperationCS__Group__3__Impl : ( ( rule__OperationCS__Group_3__0 )? ) ;
    public final void rule__OperationCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1310:1: ( ( ( rule__OperationCS__Group_3__0 )? ) )
            // InternalMiniOCLCS.g:1311:1: ( ( rule__OperationCS__Group_3__0 )? )
            {
            // InternalMiniOCLCS.g:1311:1: ( ( rule__OperationCS__Group_3__0 )? )
            // InternalMiniOCLCS.g:1312:2: ( rule__OperationCS__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getGroup_3()); 
            }
            // InternalMiniOCLCS.g:1313:2: ( rule__OperationCS__Group_3__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMiniOCLCS.g:1313:3: rule__OperationCS__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OperationCS__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__3__Impl"


    // $ANTLR start "rule__OperationCS__Group__4"
    // InternalMiniOCLCS.g:1321:1: rule__OperationCS__Group__4 : rule__OperationCS__Group__4__Impl rule__OperationCS__Group__5 ;
    public final void rule__OperationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1325:1: ( rule__OperationCS__Group__4__Impl rule__OperationCS__Group__5 )
            // InternalMiniOCLCS.g:1326:2: rule__OperationCS__Group__4__Impl rule__OperationCS__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__OperationCS__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__4"


    // $ANTLR start "rule__OperationCS__Group__4__Impl"
    // InternalMiniOCLCS.g:1333:1: rule__OperationCS__Group__4__Impl : ( ')' ) ;
    public final void rule__OperationCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1337:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:1338:1: ( ')' )
            {
            // InternalMiniOCLCS.g:1338:1: ( ')' )
            // InternalMiniOCLCS.g:1339:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__4__Impl"


    // $ANTLR start "rule__OperationCS__Group__5"
    // InternalMiniOCLCS.g:1348:1: rule__OperationCS__Group__5 : rule__OperationCS__Group__5__Impl rule__OperationCS__Group__6 ;
    public final void rule__OperationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1352:1: ( rule__OperationCS__Group__5__Impl rule__OperationCS__Group__6 )
            // InternalMiniOCLCS.g:1353:2: rule__OperationCS__Group__5__Impl rule__OperationCS__Group__6
            {
            pushFollow(FOLLOW_4);
            rule__OperationCS__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__5"


    // $ANTLR start "rule__OperationCS__Group__5__Impl"
    // InternalMiniOCLCS.g:1360:1: rule__OperationCS__Group__5__Impl : ( ':' ) ;
    public final void rule__OperationCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1364:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:1365:1: ( ':' )
            {
            // InternalMiniOCLCS.g:1365:1: ( ':' )
            // InternalMiniOCLCS.g:1366:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getColonKeyword_5()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getColonKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__5__Impl"


    // $ANTLR start "rule__OperationCS__Group__6"
    // InternalMiniOCLCS.g:1375:1: rule__OperationCS__Group__6 : rule__OperationCS__Group__6__Impl rule__OperationCS__Group__7 ;
    public final void rule__OperationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1379:1: ( rule__OperationCS__Group__6__Impl rule__OperationCS__Group__7 )
            // InternalMiniOCLCS.g:1380:2: rule__OperationCS__Group__6__Impl rule__OperationCS__Group__7
            {
            pushFollow(FOLLOW_15);
            rule__OperationCS__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__6"


    // $ANTLR start "rule__OperationCS__Group__6__Impl"
    // InternalMiniOCLCS.g:1387:1: rule__OperationCS__Group__6__Impl : ( ( rule__OperationCS__ResultRefAssignment_6 ) ) ;
    public final void rule__OperationCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1391:1: ( ( ( rule__OperationCS__ResultRefAssignment_6 ) ) )
            // InternalMiniOCLCS.g:1392:1: ( ( rule__OperationCS__ResultRefAssignment_6 ) )
            {
            // InternalMiniOCLCS.g:1392:1: ( ( rule__OperationCS__ResultRefAssignment_6 ) )
            // InternalMiniOCLCS.g:1393:2: ( rule__OperationCS__ResultRefAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getResultRefAssignment_6()); 
            }
            // InternalMiniOCLCS.g:1394:2: ( rule__OperationCS__ResultRefAssignment_6 )
            // InternalMiniOCLCS.g:1394:3: rule__OperationCS__ResultRefAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__OperationCS__ResultRefAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getResultRefAssignment_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__6__Impl"


    // $ANTLR start "rule__OperationCS__Group__7"
    // InternalMiniOCLCS.g:1402:1: rule__OperationCS__Group__7 : rule__OperationCS__Group__7__Impl rule__OperationCS__Group__8 ;
    public final void rule__OperationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1406:1: ( rule__OperationCS__Group__7__Impl rule__OperationCS__Group__8 )
            // InternalMiniOCLCS.g:1407:2: rule__OperationCS__Group__7__Impl rule__OperationCS__Group__8
            {
            pushFollow(FOLLOW_16);
            rule__OperationCS__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__7"


    // $ANTLR start "rule__OperationCS__Group__7__Impl"
    // InternalMiniOCLCS.g:1414:1: rule__OperationCS__Group__7__Impl : ( '=' ) ;
    public final void rule__OperationCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1418:1: ( ( '=' ) )
            // InternalMiniOCLCS.g:1419:1: ( '=' )
            {
            // InternalMiniOCLCS.g:1419:1: ( '=' )
            // InternalMiniOCLCS.g:1420:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getEqualsSignKeyword_7()); 
            }
            match(input,11,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getEqualsSignKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__7__Impl"


    // $ANTLR start "rule__OperationCS__Group__8"
    // InternalMiniOCLCS.g:1429:1: rule__OperationCS__Group__8 : rule__OperationCS__Group__8__Impl rule__OperationCS__Group__9 ;
    public final void rule__OperationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1433:1: ( rule__OperationCS__Group__8__Impl rule__OperationCS__Group__9 )
            // InternalMiniOCLCS.g:1434:2: rule__OperationCS__Group__8__Impl rule__OperationCS__Group__9
            {
            pushFollow(FOLLOW_12);
            rule__OperationCS__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__9();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__8"


    // $ANTLR start "rule__OperationCS__Group__8__Impl"
    // InternalMiniOCLCS.g:1441:1: rule__OperationCS__Group__8__Impl : ( ( rule__OperationCS__BodyAssignment_8 ) ) ;
    public final void rule__OperationCS__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1445:1: ( ( ( rule__OperationCS__BodyAssignment_8 ) ) )
            // InternalMiniOCLCS.g:1446:1: ( ( rule__OperationCS__BodyAssignment_8 ) )
            {
            // InternalMiniOCLCS.g:1446:1: ( ( rule__OperationCS__BodyAssignment_8 ) )
            // InternalMiniOCLCS.g:1447:2: ( rule__OperationCS__BodyAssignment_8 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getBodyAssignment_8()); 
            }
            // InternalMiniOCLCS.g:1448:2: ( rule__OperationCS__BodyAssignment_8 )
            // InternalMiniOCLCS.g:1448:3: rule__OperationCS__BodyAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__OperationCS__BodyAssignment_8();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getBodyAssignment_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__8__Impl"


    // $ANTLR start "rule__OperationCS__Group__9"
    // InternalMiniOCLCS.g:1456:1: rule__OperationCS__Group__9 : rule__OperationCS__Group__9__Impl ;
    public final void rule__OperationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1460:1: ( rule__OperationCS__Group__9__Impl )
            // InternalMiniOCLCS.g:1461:2: rule__OperationCS__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__9"


    // $ANTLR start "rule__OperationCS__Group__9__Impl"
    // InternalMiniOCLCS.g:1467:1: rule__OperationCS__Group__9__Impl : ( ';' ) ;
    public final void rule__OperationCS__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1471:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:1472:1: ( ';' )
            {
            // InternalMiniOCLCS.g:1472:1: ( ';' )
            // InternalMiniOCLCS.g:1473:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getSemicolonKeyword_9()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getSemicolonKeyword_9()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group__9__Impl"


    // $ANTLR start "rule__OperationCS__Group_3__0"
    // InternalMiniOCLCS.g:1483:1: rule__OperationCS__Group_3__0 : rule__OperationCS__Group_3__0__Impl rule__OperationCS__Group_3__1 ;
    public final void rule__OperationCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1487:1: ( rule__OperationCS__Group_3__0__Impl rule__OperationCS__Group_3__1 )
            // InternalMiniOCLCS.g:1488:2: rule__OperationCS__Group_3__0__Impl rule__OperationCS__Group_3__1
            {
            pushFollow(FOLLOW_17);
            rule__OperationCS__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group_3__0"


    // $ANTLR start "rule__OperationCS__Group_3__0__Impl"
    // InternalMiniOCLCS.g:1495:1: rule__OperationCS__Group_3__0__Impl : ( ( rule__OperationCS__ParamsAssignment_3_0 ) ) ;
    public final void rule__OperationCS__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1499:1: ( ( ( rule__OperationCS__ParamsAssignment_3_0 ) ) )
            // InternalMiniOCLCS.g:1500:1: ( ( rule__OperationCS__ParamsAssignment_3_0 ) )
            {
            // InternalMiniOCLCS.g:1500:1: ( ( rule__OperationCS__ParamsAssignment_3_0 ) )
            // InternalMiniOCLCS.g:1501:2: ( rule__OperationCS__ParamsAssignment_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getParamsAssignment_3_0()); 
            }
            // InternalMiniOCLCS.g:1502:2: ( rule__OperationCS__ParamsAssignment_3_0 )
            // InternalMiniOCLCS.g:1502:3: rule__OperationCS__ParamsAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__OperationCS__ParamsAssignment_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getParamsAssignment_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group_3__0__Impl"


    // $ANTLR start "rule__OperationCS__Group_3__1"
    // InternalMiniOCLCS.g:1510:1: rule__OperationCS__Group_3__1 : rule__OperationCS__Group_3__1__Impl ;
    public final void rule__OperationCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1514:1: ( rule__OperationCS__Group_3__1__Impl )
            // InternalMiniOCLCS.g:1515:2: rule__OperationCS__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group_3__1"


    // $ANTLR start "rule__OperationCS__Group_3__1__Impl"
    // InternalMiniOCLCS.g:1521:1: rule__OperationCS__Group_3__1__Impl : ( ( rule__OperationCS__Group_3_1__0 )* ) ;
    public final void rule__OperationCS__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1525:1: ( ( ( rule__OperationCS__Group_3_1__0 )* ) )
            // InternalMiniOCLCS.g:1526:1: ( ( rule__OperationCS__Group_3_1__0 )* )
            {
            // InternalMiniOCLCS.g:1526:1: ( ( rule__OperationCS__Group_3_1__0 )* )
            // InternalMiniOCLCS.g:1527:2: ( rule__OperationCS__Group_3_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getGroup_3_1()); 
            }
            // InternalMiniOCLCS.g:1528:2: ( rule__OperationCS__Group_3_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==27) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1528:3: rule__OperationCS__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__OperationCS__Group_3_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getGroup_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group_3__1__Impl"


    // $ANTLR start "rule__OperationCS__Group_3_1__0"
    // InternalMiniOCLCS.g:1537:1: rule__OperationCS__Group_3_1__0 : rule__OperationCS__Group_3_1__0__Impl rule__OperationCS__Group_3_1__1 ;
    public final void rule__OperationCS__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1541:1: ( rule__OperationCS__Group_3_1__0__Impl rule__OperationCS__Group_3_1__1 )
            // InternalMiniOCLCS.g:1542:2: rule__OperationCS__Group_3_1__0__Impl rule__OperationCS__Group_3_1__1
            {
            pushFollow(FOLLOW_4);
            rule__OperationCS__Group_3_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group_3_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group_3_1__0"


    // $ANTLR start "rule__OperationCS__Group_3_1__0__Impl"
    // InternalMiniOCLCS.g:1549:1: rule__OperationCS__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__OperationCS__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1553:1: ( ( ',' ) )
            // InternalMiniOCLCS.g:1554:1: ( ',' )
            {
            // InternalMiniOCLCS.g:1554:1: ( ',' )
            // InternalMiniOCLCS.g:1555:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getCommaKeyword_3_1_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getCommaKeyword_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group_3_1__0__Impl"


    // $ANTLR start "rule__OperationCS__Group_3_1__1"
    // InternalMiniOCLCS.g:1564:1: rule__OperationCS__Group_3_1__1 : rule__OperationCS__Group_3_1__1__Impl ;
    public final void rule__OperationCS__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1568:1: ( rule__OperationCS__Group_3_1__1__Impl )
            // InternalMiniOCLCS.g:1569:2: rule__OperationCS__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationCS__Group_3_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group_3_1__1"


    // $ANTLR start "rule__OperationCS__Group_3_1__1__Impl"
    // InternalMiniOCLCS.g:1575:1: rule__OperationCS__Group_3_1__1__Impl : ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) ) ;
    public final void rule__OperationCS__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1579:1: ( ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) ) )
            // InternalMiniOCLCS.g:1580:1: ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) )
            {
            // InternalMiniOCLCS.g:1580:1: ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) )
            // InternalMiniOCLCS.g:1581:2: ( rule__OperationCS__ParamsAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getParamsAssignment_3_1_1()); 
            }
            // InternalMiniOCLCS.g:1582:2: ( rule__OperationCS__ParamsAssignment_3_1_1 )
            // InternalMiniOCLCS.g:1582:3: rule__OperationCS__ParamsAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__OperationCS__ParamsAssignment_3_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getParamsAssignment_3_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__Group_3_1__1__Impl"


    // $ANTLR start "rule__ParameterCS__Group__0"
    // InternalMiniOCLCS.g:1591:1: rule__ParameterCS__Group__0 : rule__ParameterCS__Group__0__Impl rule__ParameterCS__Group__1 ;
    public final void rule__ParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1595:1: ( rule__ParameterCS__Group__0__Impl rule__ParameterCS__Group__1 )
            // InternalMiniOCLCS.g:1596:2: rule__ParameterCS__Group__0__Impl rule__ParameterCS__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__ParameterCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ParameterCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterCS__Group__0"


    // $ANTLR start "rule__ParameterCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1603:1: rule__ParameterCS__Group__0__Impl : ( ( rule__ParameterCS__NameAssignment_0 ) ) ;
    public final void rule__ParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1607:1: ( ( ( rule__ParameterCS__NameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:1608:1: ( ( rule__ParameterCS__NameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:1608:1: ( ( rule__ParameterCS__NameAssignment_0 ) )
            // InternalMiniOCLCS.g:1609:2: ( rule__ParameterCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:1610:2: ( rule__ParameterCS__NameAssignment_0 )
            // InternalMiniOCLCS.g:1610:3: rule__ParameterCS__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterCS__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterCSAccess().getNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterCS__Group__0__Impl"


    // $ANTLR start "rule__ParameterCS__Group__1"
    // InternalMiniOCLCS.g:1618:1: rule__ParameterCS__Group__1 : rule__ParameterCS__Group__1__Impl rule__ParameterCS__Group__2 ;
    public final void rule__ParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1622:1: ( rule__ParameterCS__Group__1__Impl rule__ParameterCS__Group__2 )
            // InternalMiniOCLCS.g:1623:2: rule__ParameterCS__Group__1__Impl rule__ParameterCS__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__ParameterCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ParameterCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterCS__Group__1"


    // $ANTLR start "rule__ParameterCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1630:1: rule__ParameterCS__Group__1__Impl : ( ':' ) ;
    public final void rule__ParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1634:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:1635:1: ( ':' )
            {
            // InternalMiniOCLCS.g:1635:1: ( ':' )
            // InternalMiniOCLCS.g:1636:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getColonKeyword_1()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterCSAccess().getColonKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterCS__Group__1__Impl"


    // $ANTLR start "rule__ParameterCS__Group__2"
    // InternalMiniOCLCS.g:1645:1: rule__ParameterCS__Group__2 : rule__ParameterCS__Group__2__Impl ;
    public final void rule__ParameterCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1649:1: ( rule__ParameterCS__Group__2__Impl )
            // InternalMiniOCLCS.g:1650:2: rule__ParameterCS__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterCS__Group__2"


    // $ANTLR start "rule__ParameterCS__Group__2__Impl"
    // InternalMiniOCLCS.g:1656:1: rule__ParameterCS__Group__2__Impl : ( ( rule__ParameterCS__TypeRefAssignment_2 ) ) ;
    public final void rule__ParameterCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1660:1: ( ( ( rule__ParameterCS__TypeRefAssignment_2 ) ) )
            // InternalMiniOCLCS.g:1661:1: ( ( rule__ParameterCS__TypeRefAssignment_2 ) )
            {
            // InternalMiniOCLCS.g:1661:1: ( ( rule__ParameterCS__TypeRefAssignment_2 ) )
            // InternalMiniOCLCS.g:1662:2: ( rule__ParameterCS__TypeRefAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getTypeRefAssignment_2()); 
            }
            // InternalMiniOCLCS.g:1663:2: ( rule__ParameterCS__TypeRefAssignment_2 )
            // InternalMiniOCLCS.g:1663:3: rule__ParameterCS__TypeRefAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ParameterCS__TypeRefAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterCSAccess().getTypeRefAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterCS__Group__2__Impl"


    // $ANTLR start "rule__ConstraintsDefCS__Group__0"
    // InternalMiniOCLCS.g:1672:1: rule__ConstraintsDefCS__Group__0 : rule__ConstraintsDefCS__Group__0__Impl rule__ConstraintsDefCS__Group__1 ;
    public final void rule__ConstraintsDefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1676:1: ( rule__ConstraintsDefCS__Group__0__Impl rule__ConstraintsDefCS__Group__1 )
            // InternalMiniOCLCS.g:1677:2: rule__ConstraintsDefCS__Group__0__Impl rule__ConstraintsDefCS__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ConstraintsDefCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstraintsDefCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__0"


    // $ANTLR start "rule__ConstraintsDefCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1684:1: rule__ConstraintsDefCS__Group__0__Impl : ( 'context' ) ;
    public final void rule__ConstraintsDefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1688:1: ( ( 'context' ) )
            // InternalMiniOCLCS.g:1689:1: ( 'context' )
            {
            // InternalMiniOCLCS.g:1689:1: ( 'context' )
            // InternalMiniOCLCS.g:1690:2: 'context'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getContextKeyword_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintsDefCSAccess().getContextKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__0__Impl"


    // $ANTLR start "rule__ConstraintsDefCS__Group__1"
    // InternalMiniOCLCS.g:1699:1: rule__ConstraintsDefCS__Group__1 : rule__ConstraintsDefCS__Group__1__Impl rule__ConstraintsDefCS__Group__2 ;
    public final void rule__ConstraintsDefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1703:1: ( rule__ConstraintsDefCS__Group__1__Impl rule__ConstraintsDefCS__Group__2 )
            // InternalMiniOCLCS.g:1704:2: rule__ConstraintsDefCS__Group__1__Impl rule__ConstraintsDefCS__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__ConstraintsDefCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstraintsDefCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__1"


    // $ANTLR start "rule__ConstraintsDefCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1711:1: rule__ConstraintsDefCS__Group__1__Impl : ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) ) ;
    public final void rule__ConstraintsDefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1715:1: ( ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1716:1: ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1716:1: ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) )
            // InternalMiniOCLCS.g:1717:2: ( rule__ConstraintsDefCS__TypeRefAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getTypeRefAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1718:2: ( rule__ConstraintsDefCS__TypeRefAssignment_1 )
            // InternalMiniOCLCS.g:1718:3: rule__ConstraintsDefCS__TypeRefAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintsDefCS__TypeRefAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintsDefCSAccess().getTypeRefAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__1__Impl"


    // $ANTLR start "rule__ConstraintsDefCS__Group__2"
    // InternalMiniOCLCS.g:1726:1: rule__ConstraintsDefCS__Group__2 : rule__ConstraintsDefCS__Group__2__Impl rule__ConstraintsDefCS__Group__3 ;
    public final void rule__ConstraintsDefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1730:1: ( rule__ConstraintsDefCS__Group__2__Impl rule__ConstraintsDefCS__Group__3 )
            // InternalMiniOCLCS.g:1731:2: rule__ConstraintsDefCS__Group__2__Impl rule__ConstraintsDefCS__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__ConstraintsDefCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstraintsDefCS__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__2"


    // $ANTLR start "rule__ConstraintsDefCS__Group__2__Impl"
    // InternalMiniOCLCS.g:1738:1: rule__ConstraintsDefCS__Group__2__Impl : ( '{' ) ;
    public final void rule__ConstraintsDefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1742:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:1743:1: ( '{' )
            {
            // InternalMiniOCLCS.g:1743:1: ( '{' )
            // InternalMiniOCLCS.g:1744:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintsDefCSAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__2__Impl"


    // $ANTLR start "rule__ConstraintsDefCS__Group__3"
    // InternalMiniOCLCS.g:1753:1: rule__ConstraintsDefCS__Group__3 : rule__ConstraintsDefCS__Group__3__Impl rule__ConstraintsDefCS__Group__4 ;
    public final void rule__ConstraintsDefCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1757:1: ( rule__ConstraintsDefCS__Group__3__Impl rule__ConstraintsDefCS__Group__4 )
            // InternalMiniOCLCS.g:1758:2: rule__ConstraintsDefCS__Group__3__Impl rule__ConstraintsDefCS__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__ConstraintsDefCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ConstraintsDefCS__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__3"


    // $ANTLR start "rule__ConstraintsDefCS__Group__3__Impl"
    // InternalMiniOCLCS.g:1765:1: rule__ConstraintsDefCS__Group__3__Impl : ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* ) ;
    public final void rule__ConstraintsDefCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1769:1: ( ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* ) )
            // InternalMiniOCLCS.g:1770:1: ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* )
            {
            // InternalMiniOCLCS.g:1770:1: ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* )
            // InternalMiniOCLCS.g:1771:2: ( rule__ConstraintsDefCS__InvariantsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getInvariantsAssignment_3()); 
            }
            // InternalMiniOCLCS.g:1772:2: ( rule__ConstraintsDefCS__InvariantsAssignment_3 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==29) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1772:3: rule__ConstraintsDefCS__InvariantsAssignment_3
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__ConstraintsDefCS__InvariantsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintsDefCSAccess().getInvariantsAssignment_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__3__Impl"


    // $ANTLR start "rule__ConstraintsDefCS__Group__4"
    // InternalMiniOCLCS.g:1780:1: rule__ConstraintsDefCS__Group__4 : rule__ConstraintsDefCS__Group__4__Impl ;
    public final void rule__ConstraintsDefCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1784:1: ( rule__ConstraintsDefCS__Group__4__Impl )
            // InternalMiniOCLCS.g:1785:2: rule__ConstraintsDefCS__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConstraintsDefCS__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__4"


    // $ANTLR start "rule__ConstraintsDefCS__Group__4__Impl"
    // InternalMiniOCLCS.g:1791:1: rule__ConstraintsDefCS__Group__4__Impl : ( '}' ) ;
    public final void rule__ConstraintsDefCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1795:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:1796:1: ( '}' )
            {
            // InternalMiniOCLCS.g:1796:1: ( '}' )
            // InternalMiniOCLCS.g:1797:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintsDefCSAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__Group__4__Impl"


    // $ANTLR start "rule__InvariantCS__Group__0"
    // InternalMiniOCLCS.g:1807:1: rule__InvariantCS__Group__0 : rule__InvariantCS__Group__0__Impl rule__InvariantCS__Group__1 ;
    public final void rule__InvariantCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1811:1: ( rule__InvariantCS__Group__0__Impl rule__InvariantCS__Group__1 )
            // InternalMiniOCLCS.g:1812:2: rule__InvariantCS__Group__0__Impl rule__InvariantCS__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__InvariantCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InvariantCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvariantCS__Group__0"


    // $ANTLR start "rule__InvariantCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1819:1: rule__InvariantCS__Group__0__Impl : ( 'inv' ) ;
    public final void rule__InvariantCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1823:1: ( ( 'inv' ) )
            // InternalMiniOCLCS.g:1824:1: ( 'inv' )
            {
            // InternalMiniOCLCS.g:1824:1: ( 'inv' )
            // InternalMiniOCLCS.g:1825:2: 'inv'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getInvKeyword_0()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInvariantCSAccess().getInvKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvariantCS__Group__0__Impl"


    // $ANTLR start "rule__InvariantCS__Group__1"
    // InternalMiniOCLCS.g:1834:1: rule__InvariantCS__Group__1 : rule__InvariantCS__Group__1__Impl rule__InvariantCS__Group__2 ;
    public final void rule__InvariantCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1838:1: ( rule__InvariantCS__Group__1__Impl rule__InvariantCS__Group__2 )
            // InternalMiniOCLCS.g:1839:2: rule__InvariantCS__Group__1__Impl rule__InvariantCS__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__InvariantCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InvariantCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvariantCS__Group__1"


    // $ANTLR start "rule__InvariantCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1846:1: rule__InvariantCS__Group__1__Impl : ( ':' ) ;
    public final void rule__InvariantCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1850:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:1851:1: ( ':' )
            {
            // InternalMiniOCLCS.g:1851:1: ( ':' )
            // InternalMiniOCLCS.g:1852:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getColonKeyword_1()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInvariantCSAccess().getColonKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvariantCS__Group__1__Impl"


    // $ANTLR start "rule__InvariantCS__Group__2"
    // InternalMiniOCLCS.g:1861:1: rule__InvariantCS__Group__2 : rule__InvariantCS__Group__2__Impl rule__InvariantCS__Group__3 ;
    public final void rule__InvariantCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1865:1: ( rule__InvariantCS__Group__2__Impl rule__InvariantCS__Group__3 )
            // InternalMiniOCLCS.g:1866:2: rule__InvariantCS__Group__2__Impl rule__InvariantCS__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__InvariantCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__InvariantCS__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvariantCS__Group__2"


    // $ANTLR start "rule__InvariantCS__Group__2__Impl"
    // InternalMiniOCLCS.g:1873:1: rule__InvariantCS__Group__2__Impl : ( ( rule__InvariantCS__ExpAssignment_2 ) ) ;
    public final void rule__InvariantCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1877:1: ( ( ( rule__InvariantCS__ExpAssignment_2 ) ) )
            // InternalMiniOCLCS.g:1878:1: ( ( rule__InvariantCS__ExpAssignment_2 ) )
            {
            // InternalMiniOCLCS.g:1878:1: ( ( rule__InvariantCS__ExpAssignment_2 ) )
            // InternalMiniOCLCS.g:1879:2: ( rule__InvariantCS__ExpAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getExpAssignment_2()); 
            }
            // InternalMiniOCLCS.g:1880:2: ( rule__InvariantCS__ExpAssignment_2 )
            // InternalMiniOCLCS.g:1880:3: rule__InvariantCS__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__InvariantCS__ExpAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getInvariantCSAccess().getExpAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvariantCS__Group__2__Impl"


    // $ANTLR start "rule__InvariantCS__Group__3"
    // InternalMiniOCLCS.g:1888:1: rule__InvariantCS__Group__3 : rule__InvariantCS__Group__3__Impl ;
    public final void rule__InvariantCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1892:1: ( rule__InvariantCS__Group__3__Impl )
            // InternalMiniOCLCS.g:1893:2: rule__InvariantCS__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InvariantCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvariantCS__Group__3"


    // $ANTLR start "rule__InvariantCS__Group__3__Impl"
    // InternalMiniOCLCS.g:1899:1: rule__InvariantCS__Group__3__Impl : ( ';' ) ;
    public final void rule__InvariantCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1903:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:1904:1: ( ';' )
            {
            // InternalMiniOCLCS.g:1904:1: ( ';' )
            // InternalMiniOCLCS.g:1905:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getSemicolonKeyword_3()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInvariantCSAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvariantCS__Group__3__Impl"


    // $ANTLR start "rule__LogicExpCS__Group__0"
    // InternalMiniOCLCS.g:1915:1: rule__LogicExpCS__Group__0 : rule__LogicExpCS__Group__0__Impl rule__LogicExpCS__Group__1 ;
    public final void rule__LogicExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1919:1: ( rule__LogicExpCS__Group__0__Impl rule__LogicExpCS__Group__1 )
            // InternalMiniOCLCS.g:1920:2: rule__LogicExpCS__Group__0__Impl rule__LogicExpCS__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__LogicExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LogicExpCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group__0"


    // $ANTLR start "rule__LogicExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1927:1: rule__LogicExpCS__Group__0__Impl : ( ruleCallExpCS ) ;
    public final void rule__LogicExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1931:1: ( ( ruleCallExpCS ) )
            // InternalMiniOCLCS.g:1932:1: ( ruleCallExpCS )
            {
            // InternalMiniOCLCS.g:1932:1: ( ruleCallExpCS )
            // InternalMiniOCLCS.g:1933:2: ruleCallExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getCallExpCSParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCallExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicExpCSAccess().getCallExpCSParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group__0__Impl"


    // $ANTLR start "rule__LogicExpCS__Group__1"
    // InternalMiniOCLCS.g:1942:1: rule__LogicExpCS__Group__1 : rule__LogicExpCS__Group__1__Impl ;
    public final void rule__LogicExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1946:1: ( rule__LogicExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:1947:2: rule__LogicExpCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LogicExpCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group__1"


    // $ANTLR start "rule__LogicExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1953:1: rule__LogicExpCS__Group__1__Impl : ( ( rule__LogicExpCS__Group_1__0 )* ) ;
    public final void rule__LogicExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1957:1: ( ( ( rule__LogicExpCS__Group_1__0 )* ) )
            // InternalMiniOCLCS.g:1958:1: ( ( rule__LogicExpCS__Group_1__0 )* )
            {
            // InternalMiniOCLCS.g:1958:1: ( ( rule__LogicExpCS__Group_1__0 )* )
            // InternalMiniOCLCS.g:1959:2: ( rule__LogicExpCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:1960:2: ( rule__LogicExpCS__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=11 && LA16_0<=12)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1960:3: rule__LogicExpCS__Group_1__0
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__LogicExpCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicExpCSAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group__1__Impl"


    // $ANTLR start "rule__LogicExpCS__Group_1__0"
    // InternalMiniOCLCS.g:1969:1: rule__LogicExpCS__Group_1__0 : rule__LogicExpCS__Group_1__0__Impl rule__LogicExpCS__Group_1__1 ;
    public final void rule__LogicExpCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1973:1: ( rule__LogicExpCS__Group_1__0__Impl rule__LogicExpCS__Group_1__1 )
            // InternalMiniOCLCS.g:1974:2: rule__LogicExpCS__Group_1__0__Impl rule__LogicExpCS__Group_1__1
            {
            pushFollow(FOLLOW_21);
            rule__LogicExpCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LogicExpCS__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group_1__0"


    // $ANTLR start "rule__LogicExpCS__Group_1__0__Impl"
    // InternalMiniOCLCS.g:1981:1: rule__LogicExpCS__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicExpCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1985:1: ( ( () ) )
            // InternalMiniOCLCS.g:1986:1: ( () )
            {
            // InternalMiniOCLCS.g:1986:1: ( () )
            // InternalMiniOCLCS.g:1987:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getLogicExpCSLeftAction_1_0()); 
            }
            // InternalMiniOCLCS.g:1988:2: ()
            // InternalMiniOCLCS.g:1988:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicExpCSAccess().getLogicExpCSLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group_1__0__Impl"


    // $ANTLR start "rule__LogicExpCS__Group_1__1"
    // InternalMiniOCLCS.g:1996:1: rule__LogicExpCS__Group_1__1 : rule__LogicExpCS__Group_1__1__Impl rule__LogicExpCS__Group_1__2 ;
    public final void rule__LogicExpCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2000:1: ( rule__LogicExpCS__Group_1__1__Impl rule__LogicExpCS__Group_1__2 )
            // InternalMiniOCLCS.g:2001:2: rule__LogicExpCS__Group_1__1__Impl rule__LogicExpCS__Group_1__2
            {
            pushFollow(FOLLOW_16);
            rule__LogicExpCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LogicExpCS__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group_1__1"


    // $ANTLR start "rule__LogicExpCS__Group_1__1__Impl"
    // InternalMiniOCLCS.g:2008:1: rule__LogicExpCS__Group_1__1__Impl : ( ( rule__LogicExpCS__OpAssignment_1_1 ) ) ;
    public final void rule__LogicExpCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2012:1: ( ( ( rule__LogicExpCS__OpAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:2013:1: ( ( rule__LogicExpCS__OpAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:2013:1: ( ( rule__LogicExpCS__OpAssignment_1_1 ) )
            // InternalMiniOCLCS.g:2014:2: ( rule__LogicExpCS__OpAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getOpAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:2015:2: ( rule__LogicExpCS__OpAssignment_1_1 )
            // InternalMiniOCLCS.g:2015:3: rule__LogicExpCS__OpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__LogicExpCS__OpAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicExpCSAccess().getOpAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group_1__1__Impl"


    // $ANTLR start "rule__LogicExpCS__Group_1__2"
    // InternalMiniOCLCS.g:2023:1: rule__LogicExpCS__Group_1__2 : rule__LogicExpCS__Group_1__2__Impl ;
    public final void rule__LogicExpCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2027:1: ( rule__LogicExpCS__Group_1__2__Impl )
            // InternalMiniOCLCS.g:2028:2: rule__LogicExpCS__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LogicExpCS__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group_1__2"


    // $ANTLR start "rule__LogicExpCS__Group_1__2__Impl"
    // InternalMiniOCLCS.g:2034:1: rule__LogicExpCS__Group_1__2__Impl : ( ( rule__LogicExpCS__RightAssignment_1_2 ) ) ;
    public final void rule__LogicExpCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2038:1: ( ( ( rule__LogicExpCS__RightAssignment_1_2 ) ) )
            // InternalMiniOCLCS.g:2039:1: ( ( rule__LogicExpCS__RightAssignment_1_2 ) )
            {
            // InternalMiniOCLCS.g:2039:1: ( ( rule__LogicExpCS__RightAssignment_1_2 ) )
            // InternalMiniOCLCS.g:2040:2: ( rule__LogicExpCS__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getRightAssignment_1_2()); 
            }
            // InternalMiniOCLCS.g:2041:2: ( rule__LogicExpCS__RightAssignment_1_2 )
            // InternalMiniOCLCS.g:2041:3: rule__LogicExpCS__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__LogicExpCS__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicExpCSAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__Group_1__2__Impl"


    // $ANTLR start "rule__CallExpCS__Group__0"
    // InternalMiniOCLCS.g:2050:1: rule__CallExpCS__Group__0 : rule__CallExpCS__Group__0__Impl rule__CallExpCS__Group__1 ;
    public final void rule__CallExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2054:1: ( rule__CallExpCS__Group__0__Impl rule__CallExpCS__Group__1 )
            // InternalMiniOCLCS.g:2055:2: rule__CallExpCS__Group__0__Impl rule__CallExpCS__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__CallExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExpCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group__0"


    // $ANTLR start "rule__CallExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:2062:1: rule__CallExpCS__Group__0__Impl : ( rulePrimaryExpCS ) ;
    public final void rule__CallExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2066:1: ( ( rulePrimaryExpCS ) )
            // InternalMiniOCLCS.g:2067:1: ( rulePrimaryExpCS )
            {
            // InternalMiniOCLCS.g:2067:1: ( rulePrimaryExpCS )
            // InternalMiniOCLCS.g:2068:2: rulePrimaryExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getPrimaryExpCSParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getPrimaryExpCSParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group__0__Impl"


    // $ANTLR start "rule__CallExpCS__Group__1"
    // InternalMiniOCLCS.g:2077:1: rule__CallExpCS__Group__1 : rule__CallExpCS__Group__1__Impl ;
    public final void rule__CallExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2081:1: ( rule__CallExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:2082:2: rule__CallExpCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallExpCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group__1"


    // $ANTLR start "rule__CallExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:2088:1: rule__CallExpCS__Group__1__Impl : ( ( rule__CallExpCS__Group_1__0 )* ) ;
    public final void rule__CallExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2092:1: ( ( ( rule__CallExpCS__Group_1__0 )* ) )
            // InternalMiniOCLCS.g:2093:1: ( ( rule__CallExpCS__Group_1__0 )* )
            {
            // InternalMiniOCLCS.g:2093:1: ( ( rule__CallExpCS__Group_1__0 )* )
            // InternalMiniOCLCS.g:2094:2: ( rule__CallExpCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:2095:2: ( rule__CallExpCS__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=13 && LA17_0<=14)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2095:3: rule__CallExpCS__Group_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__CallExpCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group__1__Impl"


    // $ANTLR start "rule__CallExpCS__Group_1__0"
    // InternalMiniOCLCS.g:2104:1: rule__CallExpCS__Group_1__0 : rule__CallExpCS__Group_1__0__Impl rule__CallExpCS__Group_1__1 ;
    public final void rule__CallExpCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2108:1: ( rule__CallExpCS__Group_1__0__Impl rule__CallExpCS__Group_1__1 )
            // InternalMiniOCLCS.g:2109:2: rule__CallExpCS__Group_1__0__Impl rule__CallExpCS__Group_1__1
            {
            pushFollow(FOLLOW_23);
            rule__CallExpCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExpCS__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group_1__0"


    // $ANTLR start "rule__CallExpCS__Group_1__0__Impl"
    // InternalMiniOCLCS.g:2116:1: rule__CallExpCS__Group_1__0__Impl : ( () ) ;
    public final void rule__CallExpCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2120:1: ( ( () ) )
            // InternalMiniOCLCS.g:2121:1: ( () )
            {
            // InternalMiniOCLCS.g:2121:1: ( () )
            // InternalMiniOCLCS.g:2122:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getCallExpCSSourceAction_1_0()); 
            }
            // InternalMiniOCLCS.g:2123:2: ()
            // InternalMiniOCLCS.g:2123:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getCallExpCSSourceAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group_1__0__Impl"


    // $ANTLR start "rule__CallExpCS__Group_1__1"
    // InternalMiniOCLCS.g:2131:1: rule__CallExpCS__Group_1__1 : rule__CallExpCS__Group_1__1__Impl rule__CallExpCS__Group_1__2 ;
    public final void rule__CallExpCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2135:1: ( rule__CallExpCS__Group_1__1__Impl rule__CallExpCS__Group_1__2 )
            // InternalMiniOCLCS.g:2136:2: rule__CallExpCS__Group_1__1__Impl rule__CallExpCS__Group_1__2
            {
            pushFollow(FOLLOW_4);
            rule__CallExpCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CallExpCS__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group_1__1"


    // $ANTLR start "rule__CallExpCS__Group_1__1__Impl"
    // InternalMiniOCLCS.g:2143:1: rule__CallExpCS__Group_1__1__Impl : ( ( rule__CallExpCS__OpAssignment_1_1 ) ) ;
    public final void rule__CallExpCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2147:1: ( ( ( rule__CallExpCS__OpAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:2148:1: ( ( rule__CallExpCS__OpAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:2148:1: ( ( rule__CallExpCS__OpAssignment_1_1 ) )
            // InternalMiniOCLCS.g:2149:2: ( rule__CallExpCS__OpAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getOpAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:2150:2: ( rule__CallExpCS__OpAssignment_1_1 )
            // InternalMiniOCLCS.g:2150:3: rule__CallExpCS__OpAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CallExpCS__OpAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getOpAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group_1__1__Impl"


    // $ANTLR start "rule__CallExpCS__Group_1__2"
    // InternalMiniOCLCS.g:2158:1: rule__CallExpCS__Group_1__2 : rule__CallExpCS__Group_1__2__Impl ;
    public final void rule__CallExpCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2162:1: ( rule__CallExpCS__Group_1__2__Impl )
            // InternalMiniOCLCS.g:2163:2: rule__CallExpCS__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CallExpCS__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group_1__2"


    // $ANTLR start "rule__CallExpCS__Group_1__2__Impl"
    // InternalMiniOCLCS.g:2169:1: rule__CallExpCS__Group_1__2__Impl : ( ( rule__CallExpCS__NameExpAssignment_1_2 ) ) ;
    public final void rule__CallExpCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2173:1: ( ( ( rule__CallExpCS__NameExpAssignment_1_2 ) ) )
            // InternalMiniOCLCS.g:2174:1: ( ( rule__CallExpCS__NameExpAssignment_1_2 ) )
            {
            // InternalMiniOCLCS.g:2174:1: ( ( rule__CallExpCS__NameExpAssignment_1_2 ) )
            // InternalMiniOCLCS.g:2175:2: ( rule__CallExpCS__NameExpAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getNameExpAssignment_1_2()); 
            }
            // InternalMiniOCLCS.g:2176:2: ( rule__CallExpCS__NameExpAssignment_1_2 )
            // InternalMiniOCLCS.g:2176:3: rule__CallExpCS__NameExpAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__CallExpCS__NameExpAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getNameExpAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__Group_1__2__Impl"


    // $ANTLR start "rule__NameExpCS__Group__0"
    // InternalMiniOCLCS.g:2185:1: rule__NameExpCS__Group__0 : rule__NameExpCS__Group__0__Impl rule__NameExpCS__Group__1 ;
    public final void rule__NameExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2189:1: ( rule__NameExpCS__Group__0__Impl rule__NameExpCS__Group__1 )
            // InternalMiniOCLCS.g:2190:2: rule__NameExpCS__Group__0__Impl rule__NameExpCS__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__NameExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NameExpCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameExpCS__Group__0"


    // $ANTLR start "rule__NameExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:2197:1: rule__NameExpCS__Group__0__Impl : ( ( rule__NameExpCS__ExpNameAssignment_0 ) ) ;
    public final void rule__NameExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2201:1: ( ( ( rule__NameExpCS__ExpNameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:2202:1: ( ( rule__NameExpCS__ExpNameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:2202:1: ( ( rule__NameExpCS__ExpNameAssignment_0 ) )
            // InternalMiniOCLCS.g:2203:2: ( rule__NameExpCS__ExpNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getExpNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:2204:2: ( rule__NameExpCS__ExpNameAssignment_0 )
            // InternalMiniOCLCS.g:2204:3: rule__NameExpCS__ExpNameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__NameExpCS__ExpNameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNameExpCSAccess().getExpNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameExpCS__Group__0__Impl"


    // $ANTLR start "rule__NameExpCS__Group__1"
    // InternalMiniOCLCS.g:2212:1: rule__NameExpCS__Group__1 : rule__NameExpCS__Group__1__Impl ;
    public final void rule__NameExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2216:1: ( rule__NameExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:2217:2: rule__NameExpCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NameExpCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameExpCS__Group__1"


    // $ANTLR start "rule__NameExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:2223:1: rule__NameExpCS__Group__1__Impl : ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? ) ;
    public final void rule__NameExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2227:1: ( ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? ) )
            // InternalMiniOCLCS.g:2228:1: ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? )
            {
            // InternalMiniOCLCS.g:2228:1: ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? )
            // InternalMiniOCLCS.g:2229:2: ( rule__NameExpCS__RoundedBracketsAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getRoundedBracketsAssignment_1()); 
            }
            // InternalMiniOCLCS.g:2230:2: ( rule__NameExpCS__RoundedBracketsAssignment_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==25) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMiniOCLCS.g:2230:3: rule__NameExpCS__RoundedBracketsAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__NameExpCS__RoundedBracketsAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNameExpCSAccess().getRoundedBracketsAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameExpCS__Group__1__Impl"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group__0"
    // InternalMiniOCLCS.g:2239:1: rule__RoundedBracketClauseCS__Group__0 : rule__RoundedBracketClauseCS__Group__0__Impl rule__RoundedBracketClauseCS__Group__1 ;
    public final void rule__RoundedBracketClauseCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2243:1: ( rule__RoundedBracketClauseCS__Group__0__Impl rule__RoundedBracketClauseCS__Group__1 )
            // InternalMiniOCLCS.g:2244:2: rule__RoundedBracketClauseCS__Group__0__Impl rule__RoundedBracketClauseCS__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__RoundedBracketClauseCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group__0"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group__0__Impl"
    // InternalMiniOCLCS.g:2251:1: rule__RoundedBracketClauseCS__Group__0__Impl : ( () ) ;
    public final void rule__RoundedBracketClauseCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2255:1: ( ( () ) )
            // InternalMiniOCLCS.g:2256:1: ( () )
            {
            // InternalMiniOCLCS.g:2256:1: ( () )
            // InternalMiniOCLCS.g:2257:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getRoundedBracketClauseCSAction_0()); 
            }
            // InternalMiniOCLCS.g:2258:2: ()
            // InternalMiniOCLCS.g:2258:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getRoundedBracketClauseCSAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group__0__Impl"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group__1"
    // InternalMiniOCLCS.g:2266:1: rule__RoundedBracketClauseCS__Group__1 : rule__RoundedBracketClauseCS__Group__1__Impl rule__RoundedBracketClauseCS__Group__2 ;
    public final void rule__RoundedBracketClauseCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2270:1: ( rule__RoundedBracketClauseCS__Group__1__Impl rule__RoundedBracketClauseCS__Group__2 )
            // InternalMiniOCLCS.g:2271:2: rule__RoundedBracketClauseCS__Group__1__Impl rule__RoundedBracketClauseCS__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__RoundedBracketClauseCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group__1"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group__1__Impl"
    // InternalMiniOCLCS.g:2278:1: rule__RoundedBracketClauseCS__Group__1__Impl : ( '(' ) ;
    public final void rule__RoundedBracketClauseCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2282:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:2283:1: ( '(' )
            {
            // InternalMiniOCLCS.g:2283:1: ( '(' )
            // InternalMiniOCLCS.g:2284:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group__1__Impl"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group__2"
    // InternalMiniOCLCS.g:2293:1: rule__RoundedBracketClauseCS__Group__2 : rule__RoundedBracketClauseCS__Group__2__Impl rule__RoundedBracketClauseCS__Group__3 ;
    public final void rule__RoundedBracketClauseCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2297:1: ( rule__RoundedBracketClauseCS__Group__2__Impl rule__RoundedBracketClauseCS__Group__3 )
            // InternalMiniOCLCS.g:2298:2: rule__RoundedBracketClauseCS__Group__2__Impl rule__RoundedBracketClauseCS__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__RoundedBracketClauseCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group__2"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group__2__Impl"
    // InternalMiniOCLCS.g:2305:1: rule__RoundedBracketClauseCS__Group__2__Impl : ( ( rule__RoundedBracketClauseCS__Group_2__0 )? ) ;
    public final void rule__RoundedBracketClauseCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2309:1: ( ( ( rule__RoundedBracketClauseCS__Group_2__0 )? ) )
            // InternalMiniOCLCS.g:2310:1: ( ( rule__RoundedBracketClauseCS__Group_2__0 )? )
            {
            // InternalMiniOCLCS.g:2310:1: ( ( rule__RoundedBracketClauseCS__Group_2__0 )? )
            // InternalMiniOCLCS.g:2311:2: ( rule__RoundedBracketClauseCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:2312:2: ( rule__RoundedBracketClauseCS__Group_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_STRING)||LA19_0==15||LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMiniOCLCS.g:2312:3: rule__RoundedBracketClauseCS__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RoundedBracketClauseCS__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group__2__Impl"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group__3"
    // InternalMiniOCLCS.g:2320:1: rule__RoundedBracketClauseCS__Group__3 : rule__RoundedBracketClauseCS__Group__3__Impl ;
    public final void rule__RoundedBracketClauseCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2324:1: ( rule__RoundedBracketClauseCS__Group__3__Impl )
            // InternalMiniOCLCS.g:2325:2: rule__RoundedBracketClauseCS__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group__3"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group__3__Impl"
    // InternalMiniOCLCS.g:2331:1: rule__RoundedBracketClauseCS__Group__3__Impl : ( ')' ) ;
    public final void rule__RoundedBracketClauseCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2335:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:2336:1: ( ')' )
            {
            // InternalMiniOCLCS.g:2336:1: ( ')' )
            // InternalMiniOCLCS.g:2337:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group__3__Impl"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group_2__0"
    // InternalMiniOCLCS.g:2347:1: rule__RoundedBracketClauseCS__Group_2__0 : rule__RoundedBracketClauseCS__Group_2__0__Impl rule__RoundedBracketClauseCS__Group_2__1 ;
    public final void rule__RoundedBracketClauseCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2351:1: ( rule__RoundedBracketClauseCS__Group_2__0__Impl rule__RoundedBracketClauseCS__Group_2__1 )
            // InternalMiniOCLCS.g:2352:2: rule__RoundedBracketClauseCS__Group_2__0__Impl rule__RoundedBracketClauseCS__Group_2__1
            {
            pushFollow(FOLLOW_17);
            rule__RoundedBracketClauseCS__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group_2__0"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group_2__0__Impl"
    // InternalMiniOCLCS.g:2359:1: rule__RoundedBracketClauseCS__Group_2__0__Impl : ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) ) ;
    public final void rule__RoundedBracketClauseCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2363:1: ( ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) ) )
            // InternalMiniOCLCS.g:2364:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) )
            {
            // InternalMiniOCLCS.g:2364:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) )
            // InternalMiniOCLCS.g:2365:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getArgsAssignment_2_0()); 
            }
            // InternalMiniOCLCS.g:2366:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 )
            // InternalMiniOCLCS.g:2366:3: rule__RoundedBracketClauseCS__ArgsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__ArgsAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getArgsAssignment_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group_2__0__Impl"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group_2__1"
    // InternalMiniOCLCS.g:2374:1: rule__RoundedBracketClauseCS__Group_2__1 : rule__RoundedBracketClauseCS__Group_2__1__Impl ;
    public final void rule__RoundedBracketClauseCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2378:1: ( rule__RoundedBracketClauseCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:2379:2: rule__RoundedBracketClauseCS__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group_2__1"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group_2__1__Impl"
    // InternalMiniOCLCS.g:2385:1: rule__RoundedBracketClauseCS__Group_2__1__Impl : ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* ) ;
    public final void rule__RoundedBracketClauseCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2389:1: ( ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* ) )
            // InternalMiniOCLCS.g:2390:1: ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* )
            {
            // InternalMiniOCLCS.g:2390:1: ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* )
            // InternalMiniOCLCS.g:2391:2: ( rule__RoundedBracketClauseCS__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getGroup_2_1()); 
            }
            // InternalMiniOCLCS.g:2392:2: ( rule__RoundedBracketClauseCS__Group_2_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==27) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2392:3: rule__RoundedBracketClauseCS__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__RoundedBracketClauseCS__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getGroup_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group_2__1__Impl"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group_2_1__0"
    // InternalMiniOCLCS.g:2401:1: rule__RoundedBracketClauseCS__Group_2_1__0 : rule__RoundedBracketClauseCS__Group_2_1__0__Impl rule__RoundedBracketClauseCS__Group_2_1__1 ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2405:1: ( rule__RoundedBracketClauseCS__Group_2_1__0__Impl rule__RoundedBracketClauseCS__Group_2_1__1 )
            // InternalMiniOCLCS.g:2406:2: rule__RoundedBracketClauseCS__Group_2_1__0__Impl rule__RoundedBracketClauseCS__Group_2_1__1
            {
            pushFollow(FOLLOW_16);
            rule__RoundedBracketClauseCS__Group_2_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__Group_2_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group_2_1__0"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group_2_1__0__Impl"
    // InternalMiniOCLCS.g:2413:1: rule__RoundedBracketClauseCS__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2417:1: ( ( ',' ) )
            // InternalMiniOCLCS.g:2418:1: ( ',' )
            {
            // InternalMiniOCLCS.g:2418:1: ( ',' )
            // InternalMiniOCLCS.g:2419:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getCommaKeyword_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group_2_1__0__Impl"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group_2_1__1"
    // InternalMiniOCLCS.g:2428:1: rule__RoundedBracketClauseCS__Group_2_1__1 : rule__RoundedBracketClauseCS__Group_2_1__1__Impl ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2432:1: ( rule__RoundedBracketClauseCS__Group_2_1__1__Impl )
            // InternalMiniOCLCS.g:2433:2: rule__RoundedBracketClauseCS__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__Group_2_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group_2_1__1"


    // $ANTLR start "rule__RoundedBracketClauseCS__Group_2_1__1__Impl"
    // InternalMiniOCLCS.g:2439:1: rule__RoundedBracketClauseCS__Group_2_1__1__Impl : ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) ) ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2443:1: ( ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) ) )
            // InternalMiniOCLCS.g:2444:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) )
            {
            // InternalMiniOCLCS.g:2444:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) )
            // InternalMiniOCLCS.g:2445:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getArgsAssignment_2_1_1()); 
            }
            // InternalMiniOCLCS.g:2446:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 )
            // InternalMiniOCLCS.g:2446:3: rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getArgsAssignment_2_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__Group_2_1__1__Impl"


    // $ANTLR start "rule__BooleanLiteralExpCS__Group__0"
    // InternalMiniOCLCS.g:2455:1: rule__BooleanLiteralExpCS__Group__0 : rule__BooleanLiteralExpCS__Group__0__Impl rule__BooleanLiteralExpCS__Group__1 ;
    public final void rule__BooleanLiteralExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2459:1: ( rule__BooleanLiteralExpCS__Group__0__Impl rule__BooleanLiteralExpCS__Group__1 )
            // InternalMiniOCLCS.g:2460:2: rule__BooleanLiteralExpCS__Group__0__Impl rule__BooleanLiteralExpCS__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__BooleanLiteralExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralExpCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralExpCS__Group__0"


    // $ANTLR start "rule__BooleanLiteralExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:2467:1: rule__BooleanLiteralExpCS__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2471:1: ( ( () ) )
            // InternalMiniOCLCS.g:2472:1: ( () )
            {
            // InternalMiniOCLCS.g:2472:1: ( () )
            // InternalMiniOCLCS.g:2473:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getBooleanExpCSAction_0()); 
            }
            // InternalMiniOCLCS.g:2474:2: ()
            // InternalMiniOCLCS.g:2474:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralExpCSAccess().getBooleanExpCSAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralExpCS__Group__0__Impl"


    // $ANTLR start "rule__BooleanLiteralExpCS__Group__1"
    // InternalMiniOCLCS.g:2482:1: rule__BooleanLiteralExpCS__Group__1 : rule__BooleanLiteralExpCS__Group__1__Impl ;
    public final void rule__BooleanLiteralExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2486:1: ( rule__BooleanLiteralExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:2487:2: rule__BooleanLiteralExpCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralExpCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralExpCS__Group__1"


    // $ANTLR start "rule__BooleanLiteralExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:2493:1: rule__BooleanLiteralExpCS__Group__1__Impl : ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2497:1: ( ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) ) )
            // InternalMiniOCLCS.g:2498:1: ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) )
            {
            // InternalMiniOCLCS.g:2498:1: ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) )
            // InternalMiniOCLCS.g:2499:2: ( rule__BooleanLiteralExpCS__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives_1()); 
            }
            // InternalMiniOCLCS.g:2500:2: ( rule__BooleanLiteralExpCS__Alternatives_1 )
            // InternalMiniOCLCS.g:2500:3: rule__BooleanLiteralExpCS__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralExpCS__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralExpCS__Group__1__Impl"


    // $ANTLR start "rule__PathNameCS__Group__0"
    // InternalMiniOCLCS.g:2509:1: rule__PathNameCS__Group__0 : rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 ;
    public final void rule__PathNameCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2513:1: ( rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 )
            // InternalMiniOCLCS.g:2514:2: rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__PathNameCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PathNameCS__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group__0"


    // $ANTLR start "rule__PathNameCS__Group__0__Impl"
    // InternalMiniOCLCS.g:2521:1: rule__PathNameCS__Group__0__Impl : ( ( rule__PathNameCS__PathAssignment_0 ) ) ;
    public final void rule__PathNameCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2525:1: ( ( ( rule__PathNameCS__PathAssignment_0 ) ) )
            // InternalMiniOCLCS.g:2526:1: ( ( rule__PathNameCS__PathAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:2526:1: ( ( rule__PathNameCS__PathAssignment_0 ) )
            // InternalMiniOCLCS.g:2527:2: ( rule__PathNameCS__PathAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getPathAssignment_0()); 
            }
            // InternalMiniOCLCS.g:2528:2: ( rule__PathNameCS__PathAssignment_0 )
            // InternalMiniOCLCS.g:2528:3: rule__PathNameCS__PathAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PathNameCS__PathAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getPathAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group__0__Impl"


    // $ANTLR start "rule__PathNameCS__Group__1"
    // InternalMiniOCLCS.g:2536:1: rule__PathNameCS__Group__1 : rule__PathNameCS__Group__1__Impl ;
    public final void rule__PathNameCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2540:1: ( rule__PathNameCS__Group__1__Impl )
            // InternalMiniOCLCS.g:2541:2: rule__PathNameCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PathNameCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group__1"


    // $ANTLR start "rule__PathNameCS__Group__1__Impl"
    // InternalMiniOCLCS.g:2547:1: rule__PathNameCS__Group__1__Impl : ( ( rule__PathNameCS__Group_1__0 )* ) ;
    public final void rule__PathNameCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2551:1: ( ( ( rule__PathNameCS__Group_1__0 )* ) )
            // InternalMiniOCLCS.g:2552:1: ( ( rule__PathNameCS__Group_1__0 )* )
            {
            // InternalMiniOCLCS.g:2552:1: ( ( rule__PathNameCS__Group_1__0 )* )
            // InternalMiniOCLCS.g:2553:2: ( rule__PathNameCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:2554:2: ( rule__PathNameCS__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==30) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2554:3: rule__PathNameCS__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__PathNameCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group__1__Impl"


    // $ANTLR start "rule__PathNameCS__Group_1__0"
    // InternalMiniOCLCS.g:2563:1: rule__PathNameCS__Group_1__0 : rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 ;
    public final void rule__PathNameCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2567:1: ( rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 )
            // InternalMiniOCLCS.g:2568:2: rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__PathNameCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PathNameCS__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group_1__0"


    // $ANTLR start "rule__PathNameCS__Group_1__0__Impl"
    // InternalMiniOCLCS.g:2575:1: rule__PathNameCS__Group_1__0__Impl : ( '::' ) ;
    public final void rule__PathNameCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2579:1: ( ( '::' ) )
            // InternalMiniOCLCS.g:2580:1: ( '::' )
            {
            // InternalMiniOCLCS.g:2580:1: ( '::' )
            // InternalMiniOCLCS.g:2581:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group_1__0__Impl"


    // $ANTLR start "rule__PathNameCS__Group_1__1"
    // InternalMiniOCLCS.g:2590:1: rule__PathNameCS__Group_1__1 : rule__PathNameCS__Group_1__1__Impl ;
    public final void rule__PathNameCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2594:1: ( rule__PathNameCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:2595:2: rule__PathNameCS__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PathNameCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group_1__1"


    // $ANTLR start "rule__PathNameCS__Group_1__1__Impl"
    // InternalMiniOCLCS.g:2601:1: rule__PathNameCS__Group_1__1__Impl : ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) ) ;
    public final void rule__PathNameCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2605:1: ( ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:2606:1: ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:2606:1: ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) )
            // InternalMiniOCLCS.g:2607:2: ( rule__PathNameCS__PathElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getPathElementsAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:2608:2: ( rule__PathNameCS__PathElementsAssignment_1_1 )
            // InternalMiniOCLCS.g:2608:3: rule__PathNameCS__PathElementsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PathNameCS__PathElementsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getPathElementsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__Group_1__1__Impl"


    // $ANTLR start "rule__RootCS__PackagesAssignment_0"
    // InternalMiniOCLCS.g:2617:1: rule__RootCS__PackagesAssignment_0 : ( rulePackageCS ) ;
    public final void rule__RootCS__PackagesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2621:1: ( ( rulePackageCS ) )
            // InternalMiniOCLCS.g:2622:2: ( rulePackageCS )
            {
            // InternalMiniOCLCS.g:2622:2: ( rulePackageCS )
            // InternalMiniOCLCS.g:2623:3: rulePackageCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSAccess().getPackagesPackageCSParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePackageCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSAccess().getPackagesPackageCSParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootCS__PackagesAssignment_0"


    // $ANTLR start "rule__RootCS__ContraintsAssignment_1"
    // InternalMiniOCLCS.g:2632:1: rule__RootCS__ContraintsAssignment_1 : ( ruleConstraintsDefCS ) ;
    public final void rule__RootCS__ContraintsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2636:1: ( ( ruleConstraintsDefCS ) )
            // InternalMiniOCLCS.g:2637:2: ( ruleConstraintsDefCS )
            {
            // InternalMiniOCLCS.g:2637:2: ( ruleConstraintsDefCS )
            // InternalMiniOCLCS.g:2638:3: ruleConstraintsDefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSAccess().getContraintsConstraintsDefCSParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintsDefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSAccess().getContraintsConstraintsDefCSParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootCS__ContraintsAssignment_1"


    // $ANTLR start "rule__PackageCS__NameAssignment_1"
    // InternalMiniOCLCS.g:2647:1: rule__PackageCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PackageCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2651:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:2652:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:2652:2: ( RULE_ID )
            // InternalMiniOCLCS.g:2653:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__NameAssignment_1"


    // $ANTLR start "rule__PackageCS__PackagesAssignment_3_0"
    // InternalMiniOCLCS.g:2662:1: rule__PackageCS__PackagesAssignment_3_0 : ( rulePackageCS ) ;
    public final void rule__PackageCS__PackagesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2666:1: ( ( rulePackageCS ) )
            // InternalMiniOCLCS.g:2667:2: ( rulePackageCS )
            {
            // InternalMiniOCLCS.g:2667:2: ( rulePackageCS )
            // InternalMiniOCLCS.g:2668:3: rulePackageCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getPackagesPackageCSParserRuleCall_3_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePackageCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getPackagesPackageCSParserRuleCall_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__PackagesAssignment_3_0"


    // $ANTLR start "rule__PackageCS__ClassesAssignment_3_1"
    // InternalMiniOCLCS.g:2677:1: rule__PackageCS__ClassesAssignment_3_1 : ( ruleClassCS ) ;
    public final void rule__PackageCS__ClassesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2681:1: ( ( ruleClassCS ) )
            // InternalMiniOCLCS.g:2682:2: ( ruleClassCS )
            {
            // InternalMiniOCLCS.g:2682:2: ( ruleClassCS )
            // InternalMiniOCLCS.g:2683:3: ruleClassCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getClassesClassCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleClassCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getClassesClassCSParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageCS__ClassesAssignment_3_1"


    // $ANTLR start "rule__ClassCS__NameAssignment_1"
    // InternalMiniOCLCS.g:2692:1: rule__ClassCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ClassCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2696:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:2697:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:2697:2: ( RULE_ID )
            // InternalMiniOCLCS.g:2698:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__NameAssignment_1"


    // $ANTLR start "rule__ClassCS__ExtendsAssignment_2_1"
    // InternalMiniOCLCS.g:2707:1: rule__ClassCS__ExtendsAssignment_2_1 : ( rulePathNameCS ) ;
    public final void rule__ClassCS__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2711:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:2712:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:2712:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:2713:3: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getExtendsPathNameCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getExtendsPathNameCSParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__ExtendsAssignment_2_1"


    // $ANTLR start "rule__ClassCS__PropertiesAssignment_4_0"
    // InternalMiniOCLCS.g:2722:1: rule__ClassCS__PropertiesAssignment_4_0 : ( rulePropertyCS ) ;
    public final void rule__ClassCS__PropertiesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2726:1: ( ( rulePropertyCS ) )
            // InternalMiniOCLCS.g:2727:2: ( rulePropertyCS )
            {
            // InternalMiniOCLCS.g:2727:2: ( rulePropertyCS )
            // InternalMiniOCLCS.g:2728:3: rulePropertyCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getPropertiesPropertyCSParserRuleCall_4_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePropertyCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getPropertiesPropertyCSParserRuleCall_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__PropertiesAssignment_4_0"


    // $ANTLR start "rule__ClassCS__OperationsAssignment_4_1"
    // InternalMiniOCLCS.g:2737:1: rule__ClassCS__OperationsAssignment_4_1 : ( ruleOperationCS ) ;
    public final void rule__ClassCS__OperationsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2741:1: ( ( ruleOperationCS ) )
            // InternalMiniOCLCS.g:2742:2: ( ruleOperationCS )
            {
            // InternalMiniOCLCS.g:2742:2: ( ruleOperationCS )
            // InternalMiniOCLCS.g:2743:3: ruleOperationCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getOperationsOperationCSParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleOperationCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassCSAccess().getOperationsOperationCSParserRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ClassCS__OperationsAssignment_4_1"


    // $ANTLR start "rule__PropertyCS__NameAssignment_1"
    // InternalMiniOCLCS.g:2752:1: rule__PropertyCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PropertyCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2756:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:2757:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:2757:2: ( RULE_ID )
            // InternalMiniOCLCS.g:2758:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__NameAssignment_1"


    // $ANTLR start "rule__PropertyCS__TypeRefAssignment_3"
    // InternalMiniOCLCS.g:2767:1: rule__PropertyCS__TypeRefAssignment_3 : ( rulePathNameCS ) ;
    public final void rule__PropertyCS__TypeRefAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2771:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:2772:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:2772:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:2773:3: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getTypeRefPathNameCSParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getTypeRefPathNameCSParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyCS__TypeRefAssignment_3"


    // $ANTLR start "rule__OperationCS__NameAssignment_1"
    // InternalMiniOCLCS.g:2782:1: rule__OperationCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OperationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2786:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:2787:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:2787:2: ( RULE_ID )
            // InternalMiniOCLCS.g:2788:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getNameIDTerminalRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__NameAssignment_1"


    // $ANTLR start "rule__OperationCS__ParamsAssignment_3_0"
    // InternalMiniOCLCS.g:2797:1: rule__OperationCS__ParamsAssignment_3_0 : ( ruleParameterCS ) ;
    public final void rule__OperationCS__ParamsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2801:1: ( ( ruleParameterCS ) )
            // InternalMiniOCLCS.g:2802:2: ( ruleParameterCS )
            {
            // InternalMiniOCLCS.g:2802:2: ( ruleParameterCS )
            // InternalMiniOCLCS.g:2803:3: ruleParameterCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getParamsParameterCSParserRuleCall_3_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleParameterCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getParamsParameterCSParserRuleCall_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__ParamsAssignment_3_0"


    // $ANTLR start "rule__OperationCS__ParamsAssignment_3_1_1"
    // InternalMiniOCLCS.g:2812:1: rule__OperationCS__ParamsAssignment_3_1_1 : ( ruleParameterCS ) ;
    public final void rule__OperationCS__ParamsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2816:1: ( ( ruleParameterCS ) )
            // InternalMiniOCLCS.g:2817:2: ( ruleParameterCS )
            {
            // InternalMiniOCLCS.g:2817:2: ( ruleParameterCS )
            // InternalMiniOCLCS.g:2818:3: ruleParameterCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getParamsParameterCSParserRuleCall_3_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleParameterCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getParamsParameterCSParserRuleCall_3_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__ParamsAssignment_3_1_1"


    // $ANTLR start "rule__OperationCS__ResultRefAssignment_6"
    // InternalMiniOCLCS.g:2827:1: rule__OperationCS__ResultRefAssignment_6 : ( rulePathNameCS ) ;
    public final void rule__OperationCS__ResultRefAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2831:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:2832:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:2832:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:2833:3: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getResultRefPathNameCSParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getResultRefPathNameCSParserRuleCall_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__ResultRefAssignment_6"


    // $ANTLR start "rule__OperationCS__BodyAssignment_8"
    // InternalMiniOCLCS.g:2842:1: rule__OperationCS__BodyAssignment_8 : ( ruleExpCS ) ;
    public final void rule__OperationCS__BodyAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2846:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:2847:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:2847:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:2848:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getBodyExpCSParserRuleCall_8_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getOperationCSAccess().getBodyExpCSParserRuleCall_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCS__BodyAssignment_8"


    // $ANTLR start "rule__ParameterCS__NameAssignment_0"
    // InternalMiniOCLCS.g:2857:1: rule__ParameterCS__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2861:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:2862:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:2862:2: ( RULE_ID )
            // InternalMiniOCLCS.g:2863:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterCSAccess().getNameIDTerminalRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterCS__NameAssignment_0"


    // $ANTLR start "rule__ParameterCS__TypeRefAssignment_2"
    // InternalMiniOCLCS.g:2872:1: rule__ParameterCS__TypeRefAssignment_2 : ( rulePathNameCS ) ;
    public final void rule__ParameterCS__TypeRefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2876:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:2877:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:2877:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:2878:3: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getTypeRefPathNameCSParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParameterCSAccess().getTypeRefPathNameCSParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterCS__TypeRefAssignment_2"


    // $ANTLR start "rule__ConstraintsDefCS__TypeRefAssignment_1"
    // InternalMiniOCLCS.g:2887:1: rule__ConstraintsDefCS__TypeRefAssignment_1 : ( rulePathNameCS ) ;
    public final void rule__ConstraintsDefCS__TypeRefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2891:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:2892:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:2892:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:2893:3: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getTypeRefPathNameCSParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintsDefCSAccess().getTypeRefPathNameCSParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__TypeRefAssignment_1"


    // $ANTLR start "rule__ConstraintsDefCS__InvariantsAssignment_3"
    // InternalMiniOCLCS.g:2902:1: rule__ConstraintsDefCS__InvariantsAssignment_3 : ( ruleInvariantCS ) ;
    public final void rule__ConstraintsDefCS__InvariantsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2906:1: ( ( ruleInvariantCS ) )
            // InternalMiniOCLCS.g:2907:2: ( ruleInvariantCS )
            {
            // InternalMiniOCLCS.g:2907:2: ( ruleInvariantCS )
            // InternalMiniOCLCS.g:2908:3: ruleInvariantCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getInvariantsInvariantCSParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleInvariantCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getConstraintsDefCSAccess().getInvariantsInvariantCSParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstraintsDefCS__InvariantsAssignment_3"


    // $ANTLR start "rule__InvariantCS__ExpAssignment_2"
    // InternalMiniOCLCS.g:2917:1: rule__InvariantCS__ExpAssignment_2 : ( ruleExpCS ) ;
    public final void rule__InvariantCS__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2921:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:2922:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:2922:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:2923:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getExpExpCSParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getInvariantCSAccess().getExpExpCSParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvariantCS__ExpAssignment_2"


    // $ANTLR start "rule__LogicExpCS__OpAssignment_1_1"
    // InternalMiniOCLCS.g:2932:1: rule__LogicExpCS__OpAssignment_1_1 : ( ( rule__LogicExpCS__OpAlternatives_1_1_0 ) ) ;
    public final void rule__LogicExpCS__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2936:1: ( ( ( rule__LogicExpCS__OpAlternatives_1_1_0 ) ) )
            // InternalMiniOCLCS.g:2937:2: ( ( rule__LogicExpCS__OpAlternatives_1_1_0 ) )
            {
            // InternalMiniOCLCS.g:2937:2: ( ( rule__LogicExpCS__OpAlternatives_1_1_0 ) )
            // InternalMiniOCLCS.g:2938:3: ( rule__LogicExpCS__OpAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getOpAlternatives_1_1_0()); 
            }
            // InternalMiniOCLCS.g:2939:3: ( rule__LogicExpCS__OpAlternatives_1_1_0 )
            // InternalMiniOCLCS.g:2939:4: rule__LogicExpCS__OpAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__LogicExpCS__OpAlternatives_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicExpCSAccess().getOpAlternatives_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__OpAssignment_1_1"


    // $ANTLR start "rule__LogicExpCS__RightAssignment_1_2"
    // InternalMiniOCLCS.g:2947:1: rule__LogicExpCS__RightAssignment_1_2 : ( ruleCallExpCS ) ;
    public final void rule__LogicExpCS__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2951:1: ( ( ruleCallExpCS ) )
            // InternalMiniOCLCS.g:2952:2: ( ruleCallExpCS )
            {
            // InternalMiniOCLCS.g:2952:2: ( ruleCallExpCS )
            // InternalMiniOCLCS.g:2953:3: ruleCallExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getRightCallExpCSParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCallExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLogicExpCSAccess().getRightCallExpCSParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LogicExpCS__RightAssignment_1_2"


    // $ANTLR start "rule__CallExpCS__OpAssignment_1_1"
    // InternalMiniOCLCS.g:2962:1: rule__CallExpCS__OpAssignment_1_1 : ( ( rule__CallExpCS__OpAlternatives_1_1_0 ) ) ;
    public final void rule__CallExpCS__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2966:1: ( ( ( rule__CallExpCS__OpAlternatives_1_1_0 ) ) )
            // InternalMiniOCLCS.g:2967:2: ( ( rule__CallExpCS__OpAlternatives_1_1_0 ) )
            {
            // InternalMiniOCLCS.g:2967:2: ( ( rule__CallExpCS__OpAlternatives_1_1_0 ) )
            // InternalMiniOCLCS.g:2968:3: ( rule__CallExpCS__OpAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getOpAlternatives_1_1_0()); 
            }
            // InternalMiniOCLCS.g:2969:3: ( rule__CallExpCS__OpAlternatives_1_1_0 )
            // InternalMiniOCLCS.g:2969:4: rule__CallExpCS__OpAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__CallExpCS__OpAlternatives_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getOpAlternatives_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__OpAssignment_1_1"


    // $ANTLR start "rule__CallExpCS__NameExpAssignment_1_2"
    // InternalMiniOCLCS.g:2977:1: rule__CallExpCS__NameExpAssignment_1_2 : ( ruleNameExpCS ) ;
    public final void rule__CallExpCS__NameExpAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2981:1: ( ( ruleNameExpCS ) )
            // InternalMiniOCLCS.g:2982:2: ( ruleNameExpCS )
            {
            // InternalMiniOCLCS.g:2982:2: ( ruleNameExpCS )
            // InternalMiniOCLCS.g:2983:3: ruleNameExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getNameExpNameExpCSParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNameExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getNameExpNameExpCSParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__NameExpAssignment_1_2"


    // $ANTLR start "rule__NameExpCS__ExpNameAssignment_0"
    // InternalMiniOCLCS.g:2992:1: rule__NameExpCS__ExpNameAssignment_0 : ( rulePathNameCS ) ;
    public final void rule__NameExpCS__ExpNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2996:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:2997:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:2997:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:2998:3: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getExpNamePathNameCSParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNameExpCSAccess().getExpNamePathNameCSParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameExpCS__ExpNameAssignment_0"


    // $ANTLR start "rule__NameExpCS__RoundedBracketsAssignment_1"
    // InternalMiniOCLCS.g:3007:1: rule__NameExpCS__RoundedBracketsAssignment_1 : ( ruleRoundedBracketClauseCS ) ;
    public final void rule__NameExpCS__RoundedBracketsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3011:1: ( ( ruleRoundedBracketClauseCS ) )
            // InternalMiniOCLCS.g:3012:2: ( ruleRoundedBracketClauseCS )
            {
            // InternalMiniOCLCS.g:3012:2: ( ruleRoundedBracketClauseCS )
            // InternalMiniOCLCS.g:3013:3: ruleRoundedBracketClauseCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getRoundedBracketsRoundedBracketClauseCSParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleRoundedBracketClauseCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNameExpCSAccess().getRoundedBracketsRoundedBracketClauseCSParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NameExpCS__RoundedBracketsAssignment_1"


    // $ANTLR start "rule__RoundedBracketClauseCS__ArgsAssignment_2_0"
    // InternalMiniOCLCS.g:3022:1: rule__RoundedBracketClauseCS__ArgsAssignment_2_0 : ( ruleExpCS ) ;
    public final void rule__RoundedBracketClauseCS__ArgsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3026:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:3027:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:3027:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:3028:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__ArgsAssignment_2_0"


    // $ANTLR start "rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1"
    // InternalMiniOCLCS.g:3037:1: rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 : ( ruleExpCS ) ;
    public final void rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3041:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:3042:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:3042:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:3043:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRoundedBracketClauseCSAccess().getArgsExpCSParserRuleCall_2_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1"


    // $ANTLR start "rule__IntLiteralExpCS__IntSymbolAssignment"
    // InternalMiniOCLCS.g:3052:1: rule__IntLiteralExpCS__IntSymbolAssignment : ( RULE_INT ) ;
    public final void rule__IntLiteralExpCS__IntSymbolAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3056:1: ( ( RULE_INT ) )
            // InternalMiniOCLCS.g:3057:2: ( RULE_INT )
            {
            // InternalMiniOCLCS.g:3057:2: ( RULE_INT )
            // InternalMiniOCLCS.g:3058:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralExpCSAccess().getIntSymbolINTTerminalRuleCall_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIntLiteralExpCSAccess().getIntSymbolINTTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteralExpCS__IntSymbolAssignment"


    // $ANTLR start "rule__StringLiteralExpCS__StringSymbolAssignment"
    // InternalMiniOCLCS.g:3067:1: rule__StringLiteralExpCS__StringSymbolAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralExpCS__StringSymbolAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3071:1: ( ( RULE_STRING ) )
            // InternalMiniOCLCS.g:3072:2: ( RULE_STRING )
            {
            // InternalMiniOCLCS.g:3072:2: ( RULE_STRING )
            // InternalMiniOCLCS.g:3073:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getStringLiteralExpCSAccess().getStringSymbolSTRINGTerminalRuleCall_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getStringLiteralExpCSAccess().getStringSymbolSTRINGTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteralExpCS__StringSymbolAssignment"


    // $ANTLR start "rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0"
    // InternalMiniOCLCS.g:3082:1: rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3086:1: ( ( ( 'true' ) ) )
            // InternalMiniOCLCS.g:3087:2: ( ( 'true' ) )
            {
            // InternalMiniOCLCS.g:3087:2: ( ( 'true' ) )
            // InternalMiniOCLCS.g:3088:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0()); 
            }
            // InternalMiniOCLCS.g:3089:3: ( 'true' )
            // InternalMiniOCLCS.g:3090:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0"


    // $ANTLR start "rule__PathNameCS__PathAssignment_0"
    // InternalMiniOCLCS.g:3101:1: rule__PathNameCS__PathAssignment_0 : ( rulePathElementCS ) ;
    public final void rule__PathNameCS__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3105:1: ( ( rulePathElementCS ) )
            // InternalMiniOCLCS.g:3106:2: ( rulePathElementCS )
            {
            // InternalMiniOCLCS.g:3106:2: ( rulePathElementCS )
            // InternalMiniOCLCS.g:3107:3: rulePathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getPathPathElementCSParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getPathPathElementCSParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__PathAssignment_0"


    // $ANTLR start "rule__PathNameCS__PathElementsAssignment_1_1"
    // InternalMiniOCLCS.g:3116:1: rule__PathNameCS__PathElementsAssignment_1_1 : ( rulePathElementCS ) ;
    public final void rule__PathNameCS__PathElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3120:1: ( ( rulePathElementCS ) )
            // InternalMiniOCLCS.g:3121:2: ( rulePathElementCS )
            {
            // InternalMiniOCLCS.g:3121:2: ( rulePathElementCS )
            // InternalMiniOCLCS.g:3122:3: rulePathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getPathElementsPathElementCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getPathElementsPathElementCSParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathNameCS__PathElementsAssignment_1_1"


    // $ANTLR start "rule__PathElementCS__ElementNameAssignment"
    // InternalMiniOCLCS.g:3131:1: rule__PathElementCS__ElementNameAssignment : ( RULE_ID ) ;
    public final void rule__PathElementCS__ElementNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3135:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:3136:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:3136:2: ( RULE_ID )
            // InternalMiniOCLCS.g:3137:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathElementCSAccess().getElementNameIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathElementCSAccess().getElementNameIDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PathElementCS__ElementNameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000010010002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000000D0000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000090002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001240000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001200002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000080008070L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020040000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000084008070L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000002L});

}