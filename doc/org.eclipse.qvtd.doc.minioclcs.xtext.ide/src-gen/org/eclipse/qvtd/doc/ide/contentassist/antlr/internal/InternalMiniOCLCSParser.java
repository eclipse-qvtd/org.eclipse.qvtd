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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Collection'", "'attribute'", "'containment'", "'cross_reference'", "'='", "'<>'", "'.'", "'->'", "'false'", "'package'", "'{'", "'}'", "'class'", "'extends'", "'datatype'", "':'", "';'", "'['", "']'", "'..'", "'op'", "'('", "')'", "','", "'context'", "'inv'", "'self'", "'collect'", "'|'", "'iterate'", "'null'", "'let'", "'in'", "'::'", "'?'", "'*'", "'true'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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

                if ( (LA1_0==20||LA1_0==35) ) {
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


    // $ANTLR start "entryRuleClassifierCS"
    // InternalMiniOCLCS.g:104:1: entryRuleClassifierCS : ruleClassifierCS EOF ;
    public final void entryRuleClassifierCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:105:1: ( ruleClassifierCS EOF )
            // InternalMiniOCLCS.g:106:1: ruleClassifierCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleClassifierCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierCSRule()); 
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
    // $ANTLR end "entryRuleClassifierCS"


    // $ANTLR start "ruleClassifierCS"
    // InternalMiniOCLCS.g:113:1: ruleClassifierCS : ( ( rule__ClassifierCS__Alternatives ) ) ;
    public final void ruleClassifierCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:117:2: ( ( ( rule__ClassifierCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:118:2: ( ( rule__ClassifierCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:118:2: ( ( rule__ClassifierCS__Alternatives ) )
            // InternalMiniOCLCS.g:119:3: ( rule__ClassifierCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassifierCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:120:3: ( rule__ClassifierCS__Alternatives )
            // InternalMiniOCLCS.g:120:4: rule__ClassifierCS__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ClassifierCS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getClassifierCSAccess().getAlternatives()); 
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
    // $ANTLR end "ruleClassifierCS"


    // $ANTLR start "entryRuleClassCS"
    // InternalMiniOCLCS.g:129:1: entryRuleClassCS : ruleClassCS EOF ;
    public final void entryRuleClassCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:130:1: ( ruleClassCS EOF )
            // InternalMiniOCLCS.g:131:1: ruleClassCS EOF
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
    // InternalMiniOCLCS.g:138:1: ruleClassCS : ( ( rule__ClassCS__Group__0 ) ) ;
    public final void ruleClassCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:142:2: ( ( ( rule__ClassCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:143:2: ( ( rule__ClassCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:143:2: ( ( rule__ClassCS__Group__0 ) )
            // InternalMiniOCLCS.g:144:3: ( rule__ClassCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:145:3: ( rule__ClassCS__Group__0 )
            // InternalMiniOCLCS.g:145:4: rule__ClassCS__Group__0
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


    // $ANTLR start "entryRuleDatatypeCS"
    // InternalMiniOCLCS.g:154:1: entryRuleDatatypeCS : ruleDatatypeCS EOF ;
    public final void entryRuleDatatypeCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:155:1: ( ruleDatatypeCS EOF )
            // InternalMiniOCLCS.g:156:1: ruleDatatypeCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleDatatypeCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeCSRule()); 
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
    // $ANTLR end "entryRuleDatatypeCS"


    // $ANTLR start "ruleDatatypeCS"
    // InternalMiniOCLCS.g:163:1: ruleDatatypeCS : ( ( rule__DatatypeCS__Group__0 ) ) ;
    public final void ruleDatatypeCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:167:2: ( ( ( rule__DatatypeCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:168:2: ( ( rule__DatatypeCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:168:2: ( ( rule__DatatypeCS__Group__0 ) )
            // InternalMiniOCLCS.g:169:3: ( rule__DatatypeCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:170:3: ( rule__DatatypeCS__Group__0 )
            // InternalMiniOCLCS.g:170:4: rule__DatatypeCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DatatypeCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeCSAccess().getGroup()); 
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
    // $ANTLR end "ruleDatatypeCS"


    // $ANTLR start "entryRulePropertyCS"
    // InternalMiniOCLCS.g:179:1: entryRulePropertyCS : rulePropertyCS EOF ;
    public final void entryRulePropertyCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:180:1: ( rulePropertyCS EOF )
            // InternalMiniOCLCS.g:181:1: rulePropertyCS EOF
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
    // InternalMiniOCLCS.g:188:1: rulePropertyCS : ( ( rule__PropertyCS__Group__0 ) ) ;
    public final void rulePropertyCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:192:2: ( ( ( rule__PropertyCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:193:2: ( ( rule__PropertyCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:193:2: ( ( rule__PropertyCS__Group__0 ) )
            // InternalMiniOCLCS.g:194:3: ( rule__PropertyCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:195:3: ( rule__PropertyCS__Group__0 )
            // InternalMiniOCLCS.g:195:4: rule__PropertyCS__Group__0
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


    // $ANTLR start "entryRuleMultiplicityCS"
    // InternalMiniOCLCS.g:204:1: entryRuleMultiplicityCS : ruleMultiplicityCS EOF ;
    public final void entryRuleMultiplicityCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:205:1: ( ruleMultiplicityCS EOF )
            // InternalMiniOCLCS.g:206:1: ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSRule()); 
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
    // $ANTLR end "entryRuleMultiplicityCS"


    // $ANTLR start "ruleMultiplicityCS"
    // InternalMiniOCLCS.g:213:1: ruleMultiplicityCS : ( ( rule__MultiplicityCS__Group__0 ) ) ;
    public final void ruleMultiplicityCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:217:2: ( ( ( rule__MultiplicityCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:218:2: ( ( rule__MultiplicityCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:218:2: ( ( rule__MultiplicityCS__Group__0 ) )
            // InternalMiniOCLCS.g:219:3: ( rule__MultiplicityCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:220:3: ( rule__MultiplicityCS__Group__0 )
            // InternalMiniOCLCS.g:220:4: rule__MultiplicityCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getGroup()); 
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
    // $ANTLR end "ruleMultiplicityCS"


    // $ANTLR start "entryRuleOperationCS"
    // InternalMiniOCLCS.g:229:1: entryRuleOperationCS : ruleOperationCS EOF ;
    public final void entryRuleOperationCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:230:1: ( ruleOperationCS EOF )
            // InternalMiniOCLCS.g:231:1: ruleOperationCS EOF
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
    // InternalMiniOCLCS.g:238:1: ruleOperationCS : ( ( rule__OperationCS__Group__0 ) ) ;
    public final void ruleOperationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:242:2: ( ( ( rule__OperationCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:243:2: ( ( rule__OperationCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:243:2: ( ( rule__OperationCS__Group__0 ) )
            // InternalMiniOCLCS.g:244:3: ( rule__OperationCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:245:3: ( rule__OperationCS__Group__0 )
            // InternalMiniOCLCS.g:245:4: rule__OperationCS__Group__0
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
    // InternalMiniOCLCS.g:254:1: entryRuleParameterCS : ruleParameterCS EOF ;
    public final void entryRuleParameterCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:255:1: ( ruleParameterCS EOF )
            // InternalMiniOCLCS.g:256:1: ruleParameterCS EOF
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
    // InternalMiniOCLCS.g:263:1: ruleParameterCS : ( ( rule__ParameterCS__Group__0 ) ) ;
    public final void ruleParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:267:2: ( ( ( rule__ParameterCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:268:2: ( ( rule__ParameterCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:268:2: ( ( rule__ParameterCS__Group__0 ) )
            // InternalMiniOCLCS.g:269:3: ( rule__ParameterCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:270:3: ( rule__ParameterCS__Group__0 )
            // InternalMiniOCLCS.g:270:4: rule__ParameterCS__Group__0
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
    // InternalMiniOCLCS.g:279:1: entryRuleConstraintsDefCS : ruleConstraintsDefCS EOF ;
    public final void entryRuleConstraintsDefCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:280:1: ( ruleConstraintsDefCS EOF )
            // InternalMiniOCLCS.g:281:1: ruleConstraintsDefCS EOF
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
    // InternalMiniOCLCS.g:288:1: ruleConstraintsDefCS : ( ( rule__ConstraintsDefCS__Group__0 ) ) ;
    public final void ruleConstraintsDefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:292:2: ( ( ( rule__ConstraintsDefCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:293:2: ( ( rule__ConstraintsDefCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:293:2: ( ( rule__ConstraintsDefCS__Group__0 ) )
            // InternalMiniOCLCS.g:294:3: ( rule__ConstraintsDefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:295:3: ( rule__ConstraintsDefCS__Group__0 )
            // InternalMiniOCLCS.g:295:4: rule__ConstraintsDefCS__Group__0
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
    // InternalMiniOCLCS.g:304:1: entryRuleInvariantCS : ruleInvariantCS EOF ;
    public final void entryRuleInvariantCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:305:1: ( ruleInvariantCS EOF )
            // InternalMiniOCLCS.g:306:1: ruleInvariantCS EOF
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
    // InternalMiniOCLCS.g:313:1: ruleInvariantCS : ( ( rule__InvariantCS__Group__0 ) ) ;
    public final void ruleInvariantCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:317:2: ( ( ( rule__InvariantCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:318:2: ( ( rule__InvariantCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:318:2: ( ( rule__InvariantCS__Group__0 ) )
            // InternalMiniOCLCS.g:319:3: ( rule__InvariantCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:320:3: ( rule__InvariantCS__Group__0 )
            // InternalMiniOCLCS.g:320:4: rule__InvariantCS__Group__0
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
    // InternalMiniOCLCS.g:329:1: entryRuleExpCS : ruleExpCS EOF ;
    public final void entryRuleExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:330:1: ( ruleExpCS EOF )
            // InternalMiniOCLCS.g:331:1: ruleExpCS EOF
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
    // InternalMiniOCLCS.g:338:1: ruleExpCS : ( ruleLogicExpCS ) ;
    public final void ruleExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:342:2: ( ( ruleLogicExpCS ) )
            // InternalMiniOCLCS.g:343:2: ( ruleLogicExpCS )
            {
            // InternalMiniOCLCS.g:343:2: ( ruleLogicExpCS )
            // InternalMiniOCLCS.g:344:3: ruleLogicExpCS
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
    // InternalMiniOCLCS.g:354:1: entryRuleLogicExpCS : ruleLogicExpCS EOF ;
    public final void entryRuleLogicExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:355:1: ( ruleLogicExpCS EOF )
            // InternalMiniOCLCS.g:356:1: ruleLogicExpCS EOF
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
    // InternalMiniOCLCS.g:363:1: ruleLogicExpCS : ( ( rule__LogicExpCS__Group__0 ) ) ;
    public final void ruleLogicExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:367:2: ( ( ( rule__LogicExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:368:2: ( ( rule__LogicExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:368:2: ( ( rule__LogicExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:369:3: ( rule__LogicExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:370:3: ( rule__LogicExpCS__Group__0 )
            // InternalMiniOCLCS.g:370:4: rule__LogicExpCS__Group__0
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
    // InternalMiniOCLCS.g:379:1: entryRuleCallExpCS : ruleCallExpCS EOF ;
    public final void entryRuleCallExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:380:1: ( ruleCallExpCS EOF )
            // InternalMiniOCLCS.g:381:1: ruleCallExpCS EOF
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
    // InternalMiniOCLCS.g:388:1: ruleCallExpCS : ( ( rule__CallExpCS__Group__0 ) ) ;
    public final void ruleCallExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:392:2: ( ( ( rule__CallExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:393:2: ( ( rule__CallExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:393:2: ( ( rule__CallExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:394:3: ( rule__CallExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:395:3: ( rule__CallExpCS__Group__0 )
            // InternalMiniOCLCS.g:395:4: rule__CallExpCS__Group__0
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
    // InternalMiniOCLCS.g:404:1: entryRulePrimaryExpCS : rulePrimaryExpCS EOF ;
    public final void entryRulePrimaryExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:405:1: ( rulePrimaryExpCS EOF )
            // InternalMiniOCLCS.g:406:1: rulePrimaryExpCS EOF
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
    // InternalMiniOCLCS.g:413:1: rulePrimaryExpCS : ( ( rule__PrimaryExpCS__Alternatives ) ) ;
    public final void rulePrimaryExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:417:2: ( ( ( rule__PrimaryExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:418:2: ( ( rule__PrimaryExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:418:2: ( ( rule__PrimaryExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:419:3: ( rule__PrimaryExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:420:3: ( rule__PrimaryExpCS__Alternatives )
            // InternalMiniOCLCS.g:420:4: rule__PrimaryExpCS__Alternatives
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


    // $ANTLR start "entryRuleSelfExpCS"
    // InternalMiniOCLCS.g:429:1: entryRuleSelfExpCS : ruleSelfExpCS EOF ;
    public final void entryRuleSelfExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:430:1: ( ruleSelfExpCS EOF )
            // InternalMiniOCLCS.g:431:1: ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfExpCSRule()); 
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
    // $ANTLR end "entryRuleSelfExpCS"


    // $ANTLR start "ruleSelfExpCS"
    // InternalMiniOCLCS.g:438:1: ruleSelfExpCS : ( ( rule__SelfExpCS__Group__0 ) ) ;
    public final void ruleSelfExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:442:2: ( ( ( rule__SelfExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:443:2: ( ( rule__SelfExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:443:2: ( ( rule__SelfExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:444:3: ( rule__SelfExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:445:3: ( rule__SelfExpCS__Group__0 )
            // InternalMiniOCLCS.g:445:4: rule__SelfExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SelfExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfExpCSAccess().getGroup()); 
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
    // $ANTLR end "ruleSelfExpCS"


    // $ANTLR start "entryRuleNavigationExpCS"
    // InternalMiniOCLCS.g:454:1: entryRuleNavigationExpCS : ruleNavigationExpCS EOF ;
    public final void entryRuleNavigationExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:455:1: ( ruleNavigationExpCS EOF )
            // InternalMiniOCLCS.g:456:1: ruleNavigationExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNavigationExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationExpCSRule()); 
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
    // $ANTLR end "entryRuleNavigationExpCS"


    // $ANTLR start "ruleNavigationExpCS"
    // InternalMiniOCLCS.g:463:1: ruleNavigationExpCS : ( ( rule__NavigationExpCS__Alternatives ) ) ;
    public final void ruleNavigationExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:467:2: ( ( ( rule__NavigationExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:468:2: ( ( rule__NavigationExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:468:2: ( ( rule__NavigationExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:469:3: ( rule__NavigationExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:470:3: ( rule__NavigationExpCS__Alternatives )
            // InternalMiniOCLCS.g:470:4: rule__NavigationExpCS__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NavigationExpCS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNavigationExpCSAccess().getAlternatives()); 
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
    // $ANTLR end "ruleNavigationExpCS"


    // $ANTLR start "entryRuleLoopExpCS"
    // InternalMiniOCLCS.g:479:1: entryRuleLoopExpCS : ruleLoopExpCS EOF ;
    public final void entryRuleLoopExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:480:1: ( ruleLoopExpCS EOF )
            // InternalMiniOCLCS.g:481:1: ruleLoopExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLoopExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopExpCSRule()); 
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
    // $ANTLR end "entryRuleLoopExpCS"


    // $ANTLR start "ruleLoopExpCS"
    // InternalMiniOCLCS.g:488:1: ruleLoopExpCS : ( ( rule__LoopExpCS__Alternatives ) ) ;
    public final void ruleLoopExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:492:2: ( ( ( rule__LoopExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:493:2: ( ( rule__LoopExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:493:2: ( ( rule__LoopExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:494:3: ( rule__LoopExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:495:3: ( rule__LoopExpCS__Alternatives )
            // InternalMiniOCLCS.g:495:4: rule__LoopExpCS__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LoopExpCS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLoopExpCSAccess().getAlternatives()); 
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
    // $ANTLR end "ruleLoopExpCS"


    // $ANTLR start "entryRuleCollectExpCS"
    // InternalMiniOCLCS.g:504:1: entryRuleCollectExpCS : ruleCollectExpCS EOF ;
    public final void entryRuleCollectExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:505:1: ( ruleCollectExpCS EOF )
            // InternalMiniOCLCS.g:506:1: ruleCollectExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCollectExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSRule()); 
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
    // $ANTLR end "entryRuleCollectExpCS"


    // $ANTLR start "ruleCollectExpCS"
    // InternalMiniOCLCS.g:513:1: ruleCollectExpCS : ( ( rule__CollectExpCS__Group__0 ) ) ;
    public final void ruleCollectExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:517:2: ( ( ( rule__CollectExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:518:2: ( ( rule__CollectExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:518:2: ( ( rule__CollectExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:519:3: ( rule__CollectExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:520:3: ( rule__CollectExpCS__Group__0 )
            // InternalMiniOCLCS.g:520:4: rule__CollectExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getGroup()); 
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
    // $ANTLR end "ruleCollectExpCS"


    // $ANTLR start "entryRuleIteratorVarCS"
    // InternalMiniOCLCS.g:529:1: entryRuleIteratorVarCS : ruleIteratorVarCS EOF ;
    public final void entryRuleIteratorVarCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:530:1: ( ruleIteratorVarCS EOF )
            // InternalMiniOCLCS.g:531:1: ruleIteratorVarCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIteratorVarCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIteratorVarCSRule()); 
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
    // $ANTLR end "entryRuleIteratorVarCS"


    // $ANTLR start "ruleIteratorVarCS"
    // InternalMiniOCLCS.g:538:1: ruleIteratorVarCS : ( ( rule__IteratorVarCS__Group__0 ) ) ;
    public final void ruleIteratorVarCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:542:2: ( ( ( rule__IteratorVarCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:543:2: ( ( rule__IteratorVarCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:543:2: ( ( rule__IteratorVarCS__Group__0 ) )
            // InternalMiniOCLCS.g:544:3: ( rule__IteratorVarCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:545:3: ( rule__IteratorVarCS__Group__0 )
            // InternalMiniOCLCS.g:545:4: rule__IteratorVarCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IteratorVarCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIteratorVarCSAccess().getGroup()); 
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
    // $ANTLR end "ruleIteratorVarCS"


    // $ANTLR start "entryRuleIterateExpCS"
    // InternalMiniOCLCS.g:554:1: entryRuleIterateExpCS : ruleIterateExpCS EOF ;
    public final void entryRuleIterateExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:555:1: ( ruleIterateExpCS EOF )
            // InternalMiniOCLCS.g:556:1: ruleIterateExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleIterateExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSRule()); 
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
    // $ANTLR end "entryRuleIterateExpCS"


    // $ANTLR start "ruleIterateExpCS"
    // InternalMiniOCLCS.g:563:1: ruleIterateExpCS : ( ( rule__IterateExpCS__Group__0 ) ) ;
    public final void ruleIterateExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:567:2: ( ( ( rule__IterateExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:568:2: ( ( rule__IterateExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:568:2: ( ( rule__IterateExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:569:3: ( rule__IterateExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:570:3: ( rule__IterateExpCS__Group__0 )
            // InternalMiniOCLCS.g:570:4: rule__IterateExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getGroup()); 
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
    // $ANTLR end "ruleIterateExpCS"


    // $ANTLR start "entryRuleAccVarCS"
    // InternalMiniOCLCS.g:579:1: entryRuleAccVarCS : ruleAccVarCS EOF ;
    public final void entryRuleAccVarCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:580:1: ( ruleAccVarCS EOF )
            // InternalMiniOCLCS.g:581:1: ruleAccVarCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleAccVarCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSRule()); 
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
    // $ANTLR end "entryRuleAccVarCS"


    // $ANTLR start "ruleAccVarCS"
    // InternalMiniOCLCS.g:588:1: ruleAccVarCS : ( ( rule__AccVarCS__Group__0 ) ) ;
    public final void ruleAccVarCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:592:2: ( ( ( rule__AccVarCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:593:2: ( ( rule__AccVarCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:593:2: ( ( rule__AccVarCS__Group__0 ) )
            // InternalMiniOCLCS.g:594:3: ( rule__AccVarCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:595:3: ( rule__AccVarCS__Group__0 )
            // InternalMiniOCLCS.g:595:4: rule__AccVarCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AccVarCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getGroup()); 
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
    // $ANTLR end "ruleAccVarCS"


    // $ANTLR start "entryRuleNameExpCS"
    // InternalMiniOCLCS.g:604:1: entryRuleNameExpCS : ruleNameExpCS EOF ;
    public final void entryRuleNameExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:605:1: ( ruleNameExpCS EOF )
            // InternalMiniOCLCS.g:606:1: ruleNameExpCS EOF
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
    // InternalMiniOCLCS.g:613:1: ruleNameExpCS : ( ( rule__NameExpCS__Group__0 ) ) ;
    public final void ruleNameExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:617:2: ( ( ( rule__NameExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:618:2: ( ( rule__NameExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:618:2: ( ( rule__NameExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:619:3: ( rule__NameExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:620:3: ( rule__NameExpCS__Group__0 )
            // InternalMiniOCLCS.g:620:4: rule__NameExpCS__Group__0
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
    // InternalMiniOCLCS.g:629:1: entryRuleRoundedBracketClauseCS : ruleRoundedBracketClauseCS EOF ;
    public final void entryRuleRoundedBracketClauseCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:630:1: ( ruleRoundedBracketClauseCS EOF )
            // InternalMiniOCLCS.g:631:1: ruleRoundedBracketClauseCS EOF
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
    // InternalMiniOCLCS.g:638:1: ruleRoundedBracketClauseCS : ( ( rule__RoundedBracketClauseCS__Group__0 ) ) ;
    public final void ruleRoundedBracketClauseCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:642:2: ( ( ( rule__RoundedBracketClauseCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:643:2: ( ( rule__RoundedBracketClauseCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:643:2: ( ( rule__RoundedBracketClauseCS__Group__0 ) )
            // InternalMiniOCLCS.g:644:3: ( rule__RoundedBracketClauseCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:645:3: ( rule__RoundedBracketClauseCS__Group__0 )
            // InternalMiniOCLCS.g:645:4: rule__RoundedBracketClauseCS__Group__0
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
    // InternalMiniOCLCS.g:654:1: entryRuleLiteralExpCS : ruleLiteralExpCS EOF ;
    public final void entryRuleLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:655:1: ( ruleLiteralExpCS EOF )
            // InternalMiniOCLCS.g:656:1: ruleLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:663:1: ruleLiteralExpCS : ( ( rule__LiteralExpCS__Alternatives ) ) ;
    public final void ruleLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:667:2: ( ( ( rule__LiteralExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:668:2: ( ( rule__LiteralExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:668:2: ( ( rule__LiteralExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:669:3: ( rule__LiteralExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:670:3: ( rule__LiteralExpCS__Alternatives )
            // InternalMiniOCLCS.g:670:4: rule__LiteralExpCS__Alternatives
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
    // InternalMiniOCLCS.g:679:1: entryRuleIntLiteralExpCS : ruleIntLiteralExpCS EOF ;
    public final void entryRuleIntLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:680:1: ( ruleIntLiteralExpCS EOF )
            // InternalMiniOCLCS.g:681:1: ruleIntLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:688:1: ruleIntLiteralExpCS : ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) ) ;
    public final void ruleIntLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:692:2: ( ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) ) )
            // InternalMiniOCLCS.g:693:2: ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) )
            {
            // InternalMiniOCLCS.g:693:2: ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) )
            // InternalMiniOCLCS.g:694:3: ( rule__IntLiteralExpCS__IntSymbolAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralExpCSAccess().getIntSymbolAssignment()); 
            }
            // InternalMiniOCLCS.g:695:3: ( rule__IntLiteralExpCS__IntSymbolAssignment )
            // InternalMiniOCLCS.g:695:4: rule__IntLiteralExpCS__IntSymbolAssignment
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


    // $ANTLR start "entryRuleBooleanLiteralExpCS"
    // InternalMiniOCLCS.g:704:1: entryRuleBooleanLiteralExpCS : ruleBooleanLiteralExpCS EOF ;
    public final void entryRuleBooleanLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:705:1: ( ruleBooleanLiteralExpCS EOF )
            // InternalMiniOCLCS.g:706:1: ruleBooleanLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:713:1: ruleBooleanLiteralExpCS : ( ( rule__BooleanLiteralExpCS__Group__0 ) ) ;
    public final void ruleBooleanLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:717:2: ( ( ( rule__BooleanLiteralExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:718:2: ( ( rule__BooleanLiteralExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:718:2: ( ( rule__BooleanLiteralExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:719:3: ( rule__BooleanLiteralExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:720:3: ( rule__BooleanLiteralExpCS__Group__0 )
            // InternalMiniOCLCS.g:720:4: rule__BooleanLiteralExpCS__Group__0
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


    // $ANTLR start "entryRuleNullLiteralExpCS"
    // InternalMiniOCLCS.g:729:1: entryRuleNullLiteralExpCS : ruleNullLiteralExpCS EOF ;
    public final void entryRuleNullLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:730:1: ( ruleNullLiteralExpCS EOF )
            // InternalMiniOCLCS.g:731:1: ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullLiteralExpCSRule()); 
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
    // $ANTLR end "entryRuleNullLiteralExpCS"


    // $ANTLR start "ruleNullLiteralExpCS"
    // InternalMiniOCLCS.g:738:1: ruleNullLiteralExpCS : ( ( rule__NullLiteralExpCS__Group__0 ) ) ;
    public final void ruleNullLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:742:2: ( ( ( rule__NullLiteralExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:743:2: ( ( rule__NullLiteralExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:743:2: ( ( rule__NullLiteralExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:744:3: ( rule__NullLiteralExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullLiteralExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:745:3: ( rule__NullLiteralExpCS__Group__0 )
            // InternalMiniOCLCS.g:745:4: rule__NullLiteralExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NullLiteralExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullLiteralExpCSAccess().getGroup()); 
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
    // $ANTLR end "ruleNullLiteralExpCS"


    // $ANTLR start "entryRuleCollectionLiteralExpCS"
    // InternalMiniOCLCS.g:754:1: entryRuleCollectionLiteralExpCS : ruleCollectionLiteralExpCS EOF ;
    public final void entryRuleCollectionLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:755:1: ( ruleCollectionLiteralExpCS EOF )
            // InternalMiniOCLCS.g:756:1: ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralExpCSRule()); 
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
    // $ANTLR end "entryRuleCollectionLiteralExpCS"


    // $ANTLR start "ruleCollectionLiteralExpCS"
    // InternalMiniOCLCS.g:763:1: ruleCollectionLiteralExpCS : ( ( rule__CollectionLiteralExpCS__Group__0 ) ) ;
    public final void ruleCollectionLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:767:2: ( ( ( rule__CollectionLiteralExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:768:2: ( ( rule__CollectionLiteralExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:768:2: ( ( rule__CollectionLiteralExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:769:3: ( rule__CollectionLiteralExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:770:3: ( rule__CollectionLiteralExpCS__Group__0 )
            // InternalMiniOCLCS.g:770:4: rule__CollectionLiteralExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralExpCSAccess().getGroup()); 
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
    // $ANTLR end "ruleCollectionLiteralExpCS"


    // $ANTLR start "entryRuleCollectionLiteralPartCS"
    // InternalMiniOCLCS.g:779:1: entryRuleCollectionLiteralPartCS : ruleCollectionLiteralPartCS EOF ;
    public final void entryRuleCollectionLiteralPartCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:780:1: ( ruleCollectionLiteralPartCS EOF )
            // InternalMiniOCLCS.g:781:1: ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralPartCSRule()); 
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
    // $ANTLR end "entryRuleCollectionLiteralPartCS"


    // $ANTLR start "ruleCollectionLiteralPartCS"
    // InternalMiniOCLCS.g:788:1: ruleCollectionLiteralPartCS : ( ( rule__CollectionLiteralPartCS__Group__0 ) ) ;
    public final void ruleCollectionLiteralPartCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:792:2: ( ( ( rule__CollectionLiteralPartCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:793:2: ( ( rule__CollectionLiteralPartCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:793:2: ( ( rule__CollectionLiteralPartCS__Group__0 ) )
            // InternalMiniOCLCS.g:794:3: ( rule__CollectionLiteralPartCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:795:3: ( rule__CollectionLiteralPartCS__Group__0 )
            // InternalMiniOCLCS.g:795:4: rule__CollectionLiteralPartCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralPartCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralPartCSAccess().getGroup()); 
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
    // $ANTLR end "ruleCollectionLiteralPartCS"


    // $ANTLR start "entryRuleLetExpCS"
    // InternalMiniOCLCS.g:804:1: entryRuleLetExpCS : ruleLetExpCS EOF ;
    public final void entryRuleLetExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:805:1: ( ruleLetExpCS EOF )
            // InternalMiniOCLCS.g:806:1: ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLetExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSRule()); 
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
    // $ANTLR end "entryRuleLetExpCS"


    // $ANTLR start "ruleLetExpCS"
    // InternalMiniOCLCS.g:813:1: ruleLetExpCS : ( ( rule__LetExpCS__Group__0 ) ) ;
    public final void ruleLetExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:817:2: ( ( ( rule__LetExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:818:2: ( ( rule__LetExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:818:2: ( ( rule__LetExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:819:3: ( rule__LetExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:820:3: ( rule__LetExpCS__Group__0 )
            // InternalMiniOCLCS.g:820:4: rule__LetExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LetExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getGroup()); 
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
    // $ANTLR end "ruleLetExpCS"


    // $ANTLR start "entryRuleLetVarCS"
    // InternalMiniOCLCS.g:829:1: entryRuleLetVarCS : ruleLetVarCS EOF ;
    public final void entryRuleLetVarCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:830:1: ( ruleLetVarCS EOF )
            // InternalMiniOCLCS.g:831:1: ruleLetVarCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleLetVarCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSRule()); 
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
    // $ANTLR end "entryRuleLetVarCS"


    // $ANTLR start "ruleLetVarCS"
    // InternalMiniOCLCS.g:838:1: ruleLetVarCS : ( ( rule__LetVarCS__Group__0 ) ) ;
    public final void ruleLetVarCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:842:2: ( ( ( rule__LetVarCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:843:2: ( ( rule__LetVarCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:843:2: ( ( rule__LetVarCS__Group__0 ) )
            // InternalMiniOCLCS.g:844:3: ( rule__LetVarCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:845:3: ( rule__LetVarCS__Group__0 )
            // InternalMiniOCLCS.g:845:4: rule__LetVarCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LetVarCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getGroup()); 
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
    // $ANTLR end "ruleLetVarCS"


    // $ANTLR start "entryRulePathNameCS"
    // InternalMiniOCLCS.g:854:1: entryRulePathNameCS : rulePathNameCS EOF ;
    public final void entryRulePathNameCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:855:1: ( rulePathNameCS EOF )
            // InternalMiniOCLCS.g:856:1: rulePathNameCS EOF
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
    // InternalMiniOCLCS.g:863:1: rulePathNameCS : ( ( rule__PathNameCS__Group__0 ) ) ;
    public final void rulePathNameCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:867:2: ( ( ( rule__PathNameCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:868:2: ( ( rule__PathNameCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:868:2: ( ( rule__PathNameCS__Group__0 ) )
            // InternalMiniOCLCS.g:869:3: ( rule__PathNameCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:870:3: ( rule__PathNameCS__Group__0 )
            // InternalMiniOCLCS.g:870:4: rule__PathNameCS__Group__0
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
    // InternalMiniOCLCS.g:879:1: entryRulePathElementCS : rulePathElementCS EOF ;
    public final void entryRulePathElementCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:880:1: ( rulePathElementCS EOF )
            // InternalMiniOCLCS.g:881:1: rulePathElementCS EOF
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
    // InternalMiniOCLCS.g:888:1: rulePathElementCS : ( ( rule__PathElementCS__ElementNameAssignment ) ) ;
    public final void rulePathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:892:2: ( ( ( rule__PathElementCS__ElementNameAssignment ) ) )
            // InternalMiniOCLCS.g:893:2: ( ( rule__PathElementCS__ElementNameAssignment ) )
            {
            // InternalMiniOCLCS.g:893:2: ( ( rule__PathElementCS__ElementNameAssignment ) )
            // InternalMiniOCLCS.g:894:3: ( rule__PathElementCS__ElementNameAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathElementCSAccess().getElementNameAssignment()); 
            }
            // InternalMiniOCLCS.g:895:3: ( rule__PathElementCS__ElementNameAssignment )
            // InternalMiniOCLCS.g:895:4: rule__PathElementCS__ElementNameAssignment
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


    // $ANTLR start "ruleCollectionKindCS"
    // InternalMiniOCLCS.g:904:1: ruleCollectionKindCS : ( ( 'Collection' ) ) ;
    public final void ruleCollectionKindCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:908:1: ( ( ( 'Collection' ) ) )
            // InternalMiniOCLCS.g:909:2: ( ( 'Collection' ) )
            {
            // InternalMiniOCLCS.g:909:2: ( ( 'Collection' ) )
            // InternalMiniOCLCS.g:910:3: ( 'Collection' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionKindCSAccess().getCollectionEnumLiteralDeclaration()); 
            }
            // InternalMiniOCLCS.g:911:3: ( 'Collection' )
            // InternalMiniOCLCS.g:911:4: 'Collection'
            {
            match(input,11,FOLLOW_2); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionKindCSAccess().getCollectionEnumLiteralDeclaration()); 
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
    // $ANTLR end "ruleCollectionKindCS"


    // $ANTLR start "rule__RootCS__Alternatives"
    // InternalMiniOCLCS.g:919:1: rule__RootCS__Alternatives : ( ( ( rule__RootCS__PackagesAssignment_0 ) ) | ( ( rule__RootCS__ContraintsAssignment_1 ) ) );
    public final void rule__RootCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:923:1: ( ( ( rule__RootCS__PackagesAssignment_0 ) ) | ( ( rule__RootCS__ContraintsAssignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==20) ) {
                alt2=1;
            }
            else if ( (LA2_0==35) ) {
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
                    // InternalMiniOCLCS.g:924:2: ( ( rule__RootCS__PackagesAssignment_0 ) )
                    {
                    // InternalMiniOCLCS.g:924:2: ( ( rule__RootCS__PackagesAssignment_0 ) )
                    // InternalMiniOCLCS.g:925:3: ( rule__RootCS__PackagesAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRootCSAccess().getPackagesAssignment_0()); 
                    }
                    // InternalMiniOCLCS.g:926:3: ( rule__RootCS__PackagesAssignment_0 )
                    // InternalMiniOCLCS.g:926:4: rule__RootCS__PackagesAssignment_0
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
                    // InternalMiniOCLCS.g:930:2: ( ( rule__RootCS__ContraintsAssignment_1 ) )
                    {
                    // InternalMiniOCLCS.g:930:2: ( ( rule__RootCS__ContraintsAssignment_1 ) )
                    // InternalMiniOCLCS.g:931:3: ( rule__RootCS__ContraintsAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRootCSAccess().getContraintsAssignment_1()); 
                    }
                    // InternalMiniOCLCS.g:932:3: ( rule__RootCS__ContraintsAssignment_1 )
                    // InternalMiniOCLCS.g:932:4: rule__RootCS__ContraintsAssignment_1
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
    // InternalMiniOCLCS.g:940:1: rule__PackageCS__Alternatives_3 : ( ( ( rule__PackageCS__PackagesAssignment_3_0 ) ) | ( ( rule__PackageCS__ClassifiersAssignment_3_1 ) ) );
    public final void rule__PackageCS__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:944:1: ( ( ( rule__PackageCS__PackagesAssignment_3_0 ) ) | ( ( rule__PackageCS__ClassifiersAssignment_3_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==20) ) {
                alt3=1;
            }
            else if ( (LA3_0==23||LA3_0==25) ) {
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
                    // InternalMiniOCLCS.g:945:2: ( ( rule__PackageCS__PackagesAssignment_3_0 ) )
                    {
                    // InternalMiniOCLCS.g:945:2: ( ( rule__PackageCS__PackagesAssignment_3_0 ) )
                    // InternalMiniOCLCS.g:946:3: ( rule__PackageCS__PackagesAssignment_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPackageCSAccess().getPackagesAssignment_3_0()); 
                    }
                    // InternalMiniOCLCS.g:947:3: ( rule__PackageCS__PackagesAssignment_3_0 )
                    // InternalMiniOCLCS.g:947:4: rule__PackageCS__PackagesAssignment_3_0
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
                    // InternalMiniOCLCS.g:951:2: ( ( rule__PackageCS__ClassifiersAssignment_3_1 ) )
                    {
                    // InternalMiniOCLCS.g:951:2: ( ( rule__PackageCS__ClassifiersAssignment_3_1 ) )
                    // InternalMiniOCLCS.g:952:3: ( rule__PackageCS__ClassifiersAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPackageCSAccess().getClassifiersAssignment_3_1()); 
                    }
                    // InternalMiniOCLCS.g:953:3: ( rule__PackageCS__ClassifiersAssignment_3_1 )
                    // InternalMiniOCLCS.g:953:4: rule__PackageCS__ClassifiersAssignment_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__PackageCS__ClassifiersAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPackageCSAccess().getClassifiersAssignment_3_1()); 
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


    // $ANTLR start "rule__ClassifierCS__Alternatives"
    // InternalMiniOCLCS.g:961:1: rule__ClassifierCS__Alternatives : ( ( ruleClassCS ) | ( ruleDatatypeCS ) );
    public final void rule__ClassifierCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:965:1: ( ( ruleClassCS ) | ( ruleDatatypeCS ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            else if ( (LA4_0==25) ) {
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
                    // InternalMiniOCLCS.g:966:2: ( ruleClassCS )
                    {
                    // InternalMiniOCLCS.g:966:2: ( ruleClassCS )
                    // InternalMiniOCLCS.g:967:3: ruleClassCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassifierCSAccess().getClassCSParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleClassCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassifierCSAccess().getClassCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:972:2: ( ruleDatatypeCS )
                    {
                    // InternalMiniOCLCS.g:972:2: ( ruleDatatypeCS )
                    // InternalMiniOCLCS.g:973:3: ruleDatatypeCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassifierCSAccess().getDatatypeCSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleDatatypeCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getClassifierCSAccess().getDatatypeCSParserRuleCall_1()); 
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
    // $ANTLR end "rule__ClassifierCS__Alternatives"


    // $ANTLR start "rule__ClassCS__Alternatives_4"
    // InternalMiniOCLCS.g:982:1: rule__ClassCS__Alternatives_4 : ( ( ( rule__ClassCS__PropertiesAssignment_4_0 ) ) | ( ( rule__ClassCS__OperationsAssignment_4_1 ) ) );
    public final void rule__ClassCS__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:986:1: ( ( ( rule__ClassCS__PropertiesAssignment_4_0 ) ) | ( ( rule__ClassCS__OperationsAssignment_4_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=12 && LA5_0<=14)) ) {
                alt5=1;
            }
            else if ( (LA5_0==31) ) {
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
                    // InternalMiniOCLCS.g:987:2: ( ( rule__ClassCS__PropertiesAssignment_4_0 ) )
                    {
                    // InternalMiniOCLCS.g:987:2: ( ( rule__ClassCS__PropertiesAssignment_4_0 ) )
                    // InternalMiniOCLCS.g:988:3: ( rule__ClassCS__PropertiesAssignment_4_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassCSAccess().getPropertiesAssignment_4_0()); 
                    }
                    // InternalMiniOCLCS.g:989:3: ( rule__ClassCS__PropertiesAssignment_4_0 )
                    // InternalMiniOCLCS.g:989:4: rule__ClassCS__PropertiesAssignment_4_0
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
                    // InternalMiniOCLCS.g:993:2: ( ( rule__ClassCS__OperationsAssignment_4_1 ) )
                    {
                    // InternalMiniOCLCS.g:993:2: ( ( rule__ClassCS__OperationsAssignment_4_1 ) )
                    // InternalMiniOCLCS.g:994:3: ( rule__ClassCS__OperationsAssignment_4_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassCSAccess().getOperationsAssignment_4_1()); 
                    }
                    // InternalMiniOCLCS.g:995:3: ( rule__ClassCS__OperationsAssignment_4_1 )
                    // InternalMiniOCLCS.g:995:4: rule__ClassCS__OperationsAssignment_4_1
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


    // $ANTLR start "rule__PropertyCS__Alternatives_0"
    // InternalMiniOCLCS.g:1003:1: rule__PropertyCS__Alternatives_0 : ( ( 'attribute' ) | ( 'containment' ) | ( 'cross_reference' ) );
    public final void rule__PropertyCS__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1007:1: ( ( 'attribute' ) | ( 'containment' ) | ( 'cross_reference' ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt6=1;
                }
                break;
            case 13:
                {
                alt6=2;
                }
                break;
            case 14:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalMiniOCLCS.g:1008:2: ( 'attribute' )
                    {
                    // InternalMiniOCLCS.g:1008:2: ( 'attribute' )
                    // InternalMiniOCLCS.g:1009:3: 'attribute'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPropertyCSAccess().getAttributeKeyword_0_0()); 
                    }
                    match(input,12,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPropertyCSAccess().getAttributeKeyword_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1014:2: ( 'containment' )
                    {
                    // InternalMiniOCLCS.g:1014:2: ( 'containment' )
                    // InternalMiniOCLCS.g:1015:3: 'containment'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPropertyCSAccess().getContainmentKeyword_0_1()); 
                    }
                    match(input,13,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPropertyCSAccess().getContainmentKeyword_0_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniOCLCS.g:1020:2: ( 'cross_reference' )
                    {
                    // InternalMiniOCLCS.g:1020:2: ( 'cross_reference' )
                    // InternalMiniOCLCS.g:1021:3: 'cross_reference'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPropertyCSAccess().getCross_referenceKeyword_0_2()); 
                    }
                    match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPropertyCSAccess().getCross_referenceKeyword_0_2()); 
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
    // $ANTLR end "rule__PropertyCS__Alternatives_0"


    // $ANTLR start "rule__MultiplicityCS__Alternatives_1"
    // InternalMiniOCLCS.g:1030:1: rule__MultiplicityCS__Alternatives_1 : ( ( ( rule__MultiplicityCS__OptAssignment_1_0 ) ) | ( ( rule__MultiplicityCS__MultAssignment_1_1 ) ) | ( ( rule__MultiplicityCS__Group_1_2__0 ) ) );
    public final void rule__MultiplicityCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1034:1: ( ( ( rule__MultiplicityCS__OptAssignment_1_0 ) ) | ( ( rule__MultiplicityCS__MultAssignment_1_1 ) ) | ( ( rule__MultiplicityCS__Group_1_2__0 ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt7=1;
                }
                break;
            case 46:
                {
                alt7=2;
                }
                break;
            case RULE_INT:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalMiniOCLCS.g:1035:2: ( ( rule__MultiplicityCS__OptAssignment_1_0 ) )
                    {
                    // InternalMiniOCLCS.g:1035:2: ( ( rule__MultiplicityCS__OptAssignment_1_0 ) )
                    // InternalMiniOCLCS.g:1036:3: ( rule__MultiplicityCS__OptAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getOptAssignment_1_0()); 
                    }
                    // InternalMiniOCLCS.g:1037:3: ( rule__MultiplicityCS__OptAssignment_1_0 )
                    // InternalMiniOCLCS.g:1037:4: rule__MultiplicityCS__OptAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiplicityCS__OptAssignment_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getOptAssignment_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1041:2: ( ( rule__MultiplicityCS__MultAssignment_1_1 ) )
                    {
                    // InternalMiniOCLCS.g:1041:2: ( ( rule__MultiplicityCS__MultAssignment_1_1 ) )
                    // InternalMiniOCLCS.g:1042:3: ( rule__MultiplicityCS__MultAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getMultAssignment_1_1()); 
                    }
                    // InternalMiniOCLCS.g:1043:3: ( rule__MultiplicityCS__MultAssignment_1_1 )
                    // InternalMiniOCLCS.g:1043:4: rule__MultiplicityCS__MultAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiplicityCS__MultAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getMultAssignment_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniOCLCS.g:1047:2: ( ( rule__MultiplicityCS__Group_1_2__0 ) )
                    {
                    // InternalMiniOCLCS.g:1047:2: ( ( rule__MultiplicityCS__Group_1_2__0 ) )
                    // InternalMiniOCLCS.g:1048:3: ( rule__MultiplicityCS__Group_1_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getGroup_1_2()); 
                    }
                    // InternalMiniOCLCS.g:1049:3: ( rule__MultiplicityCS__Group_1_2__0 )
                    // InternalMiniOCLCS.g:1049:4: rule__MultiplicityCS__Group_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiplicityCS__Group_1_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getGroup_1_2()); 
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
    // $ANTLR end "rule__MultiplicityCS__Alternatives_1"


    // $ANTLR start "rule__MultiplicityCS__Alternatives_1_2_2"
    // InternalMiniOCLCS.g:1057:1: rule__MultiplicityCS__Alternatives_1_2_2 : ( ( ( rule__MultiplicityCS__UpperIntAssignment_1_2_2_0 ) ) | ( ( rule__MultiplicityCS__UpperMultAssignment_1_2_2_1 ) ) );
    public final void rule__MultiplicityCS__Alternatives_1_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1061:1: ( ( ( rule__MultiplicityCS__UpperIntAssignment_1_2_2_0 ) ) | ( ( rule__MultiplicityCS__UpperMultAssignment_1_2_2_1 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT) ) {
                alt8=1;
            }
            else if ( (LA8_0==46) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalMiniOCLCS.g:1062:2: ( ( rule__MultiplicityCS__UpperIntAssignment_1_2_2_0 ) )
                    {
                    // InternalMiniOCLCS.g:1062:2: ( ( rule__MultiplicityCS__UpperIntAssignment_1_2_2_0 ) )
                    // InternalMiniOCLCS.g:1063:3: ( rule__MultiplicityCS__UpperIntAssignment_1_2_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getUpperIntAssignment_1_2_2_0()); 
                    }
                    // InternalMiniOCLCS.g:1064:3: ( rule__MultiplicityCS__UpperIntAssignment_1_2_2_0 )
                    // InternalMiniOCLCS.g:1064:4: rule__MultiplicityCS__UpperIntAssignment_1_2_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiplicityCS__UpperIntAssignment_1_2_2_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getUpperIntAssignment_1_2_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1068:2: ( ( rule__MultiplicityCS__UpperMultAssignment_1_2_2_1 ) )
                    {
                    // InternalMiniOCLCS.g:1068:2: ( ( rule__MultiplicityCS__UpperMultAssignment_1_2_2_1 ) )
                    // InternalMiniOCLCS.g:1069:3: ( rule__MultiplicityCS__UpperMultAssignment_1_2_2_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getUpperMultAssignment_1_2_2_1()); 
                    }
                    // InternalMiniOCLCS.g:1070:3: ( rule__MultiplicityCS__UpperMultAssignment_1_2_2_1 )
                    // InternalMiniOCLCS.g:1070:4: rule__MultiplicityCS__UpperMultAssignment_1_2_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiplicityCS__UpperMultAssignment_1_2_2_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getUpperMultAssignment_1_2_2_1()); 
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
    // $ANTLR end "rule__MultiplicityCS__Alternatives_1_2_2"


    // $ANTLR start "rule__LogicExpCS__OpAlternatives_1_1_0"
    // InternalMiniOCLCS.g:1078:1: rule__LogicExpCS__OpAlternatives_1_1_0 : ( ( '=' ) | ( '<>' ) );
    public final void rule__LogicExpCS__OpAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1082:1: ( ( '=' ) | ( '<>' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            else if ( (LA9_0==16) ) {
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
                    // InternalMiniOCLCS.g:1083:2: ( '=' )
                    {
                    // InternalMiniOCLCS.g:1083:2: ( '=' )
                    // InternalMiniOCLCS.g:1084:3: '='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLogicExpCSAccess().getOpEqualsSignKeyword_1_1_0_0()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLogicExpCSAccess().getOpEqualsSignKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1089:2: ( '<>' )
                    {
                    // InternalMiniOCLCS.g:1089:2: ( '<>' )
                    // InternalMiniOCLCS.g:1090:3: '<>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLogicExpCSAccess().getOpLessThanSignGreaterThanSignKeyword_1_1_0_1()); 
                    }
                    match(input,16,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1099:1: rule__CallExpCS__OpAlternatives_1_1_0 : ( ( '.' ) | ( '->' ) );
    public final void rule__CallExpCS__OpAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1103:1: ( ( '.' ) | ( '->' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            else if ( (LA10_0==18) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalMiniOCLCS.g:1104:2: ( '.' )
                    {
                    // InternalMiniOCLCS.g:1104:2: ( '.' )
                    // InternalMiniOCLCS.g:1105:3: '.'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpCSAccess().getOpFullStopKeyword_1_1_0_0()); 
                    }
                    match(input,17,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCallExpCSAccess().getOpFullStopKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1110:2: ( '->' )
                    {
                    // InternalMiniOCLCS.g:1110:2: ( '->' )
                    // InternalMiniOCLCS.g:1111:3: '->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpCSAccess().getOpHyphenMinusGreaterThanSignKeyword_1_1_0_1()); 
                    }
                    match(input,18,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1120:1: rule__PrimaryExpCS__Alternatives : ( ( ruleSelfExpCS ) | ( ruleNameExpCS ) | ( ruleLiteralExpCS ) | ( ruleLetExpCS ) );
    public final void rule__PrimaryExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1124:1: ( ( ruleSelfExpCS ) | ( ruleNameExpCS ) | ( ruleLiteralExpCS ) | ( ruleLetExpCS ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt11=1;
                }
                break;
            case RULE_ID:
                {
                alt11=2;
                }
                break;
            case RULE_INT:
            case 11:
            case 19:
            case 41:
            case 47:
                {
                alt11=3;
                }
                break;
            case 42:
                {
                alt11=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalMiniOCLCS.g:1125:2: ( ruleSelfExpCS )
                    {
                    // InternalMiniOCLCS.g:1125:2: ( ruleSelfExpCS )
                    // InternalMiniOCLCS.g:1126:3: ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleSelfExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1131:2: ( ruleNameExpCS )
                    {
                    // InternalMiniOCLCS.g:1131:2: ( ruleNameExpCS )
                    // InternalMiniOCLCS.g:1132:3: ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniOCLCS.g:1137:2: ( ruleLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1137:2: ( ruleLiteralExpCS )
                    // InternalMiniOCLCS.g:1138:3: ruleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpCSAccess().getLiteralExpCSParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMiniOCLCS.g:1143:2: ( ruleLetExpCS )
                    {
                    // InternalMiniOCLCS.g:1143:2: ( ruleLetExpCS )
                    // InternalMiniOCLCS.g:1144:3: ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimaryExpCSAccess().getLetExpCSParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLetExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimaryExpCSAccess().getLetExpCSParserRuleCall_3()); 
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


    // $ANTLR start "rule__NavigationExpCS__Alternatives"
    // InternalMiniOCLCS.g:1153:1: rule__NavigationExpCS__Alternatives : ( ( ruleLoopExpCS ) | ( ruleNameExpCS ) );
    public final void rule__NavigationExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1157:1: ( ( ruleLoopExpCS ) | ( ruleNameExpCS ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==38||LA12_0==40) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalMiniOCLCS.g:1158:2: ( ruleLoopExpCS )
                    {
                    // InternalMiniOCLCS.g:1158:2: ( ruleLoopExpCS )
                    // InternalMiniOCLCS.g:1159:3: ruleLoopExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationExpCSAccess().getLoopExpCSParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleLoopExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNavigationExpCSAccess().getLoopExpCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1164:2: ( ruleNameExpCS )
                    {
                    // InternalMiniOCLCS.g:1164:2: ( ruleNameExpCS )
                    // InternalMiniOCLCS.g:1165:3: ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getNavigationExpCSAccess().getNameExpCSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getNavigationExpCSAccess().getNameExpCSParserRuleCall_1()); 
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
    // $ANTLR end "rule__NavigationExpCS__Alternatives"


    // $ANTLR start "rule__LoopExpCS__Alternatives"
    // InternalMiniOCLCS.g:1174:1: rule__LoopExpCS__Alternatives : ( ( ruleCollectExpCS ) | ( ruleIterateExpCS ) );
    public final void rule__LoopExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1178:1: ( ( ruleCollectExpCS ) | ( ruleIterateExpCS ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            else if ( (LA13_0==40) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalMiniOCLCS.g:1179:2: ( ruleCollectExpCS )
                    {
                    // InternalMiniOCLCS.g:1179:2: ( ruleCollectExpCS )
                    // InternalMiniOCLCS.g:1180:3: ruleCollectExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopExpCSAccess().getCollectExpCSParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCollectExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopExpCSAccess().getCollectExpCSParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1185:2: ( ruleIterateExpCS )
                    {
                    // InternalMiniOCLCS.g:1185:2: ( ruleIterateExpCS )
                    // InternalMiniOCLCS.g:1186:3: ruleIterateExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLoopExpCSAccess().getIterateExpCSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleIterateExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLoopExpCSAccess().getIterateExpCSParserRuleCall_1()); 
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
    // $ANTLR end "rule__LoopExpCS__Alternatives"


    // $ANTLR start "rule__LiteralExpCS__Alternatives"
    // InternalMiniOCLCS.g:1195:1: rule__LiteralExpCS__Alternatives : ( ( ruleIntLiteralExpCS ) | ( ruleBooleanLiteralExpCS ) | ( ruleNullLiteralExpCS ) | ( ruleCollectionLiteralExpCS ) );
    public final void rule__LiteralExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1199:1: ( ( ruleIntLiteralExpCS ) | ( ruleBooleanLiteralExpCS ) | ( ruleNullLiteralExpCS ) | ( ruleCollectionLiteralExpCS ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt14=1;
                }
                break;
            case 19:
            case 47:
                {
                alt14=2;
                }
                break;
            case 41:
                {
                alt14=3;
                }
                break;
            case 11:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalMiniOCLCS.g:1200:2: ( ruleIntLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1200:2: ( ruleIntLiteralExpCS )
                    // InternalMiniOCLCS.g:1201:3: ruleIntLiteralExpCS
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
                    // InternalMiniOCLCS.g:1206:2: ( ruleBooleanLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1206:2: ( ruleBooleanLiteralExpCS )
                    // InternalMiniOCLCS.g:1207:3: ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleBooleanLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalMiniOCLCS.g:1212:2: ( ruleNullLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1212:2: ( ruleNullLiteralExpCS )
                    // InternalMiniOCLCS.g:1213:3: ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleNullLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMiniOCLCS.g:1218:2: ( ruleCollectionLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1218:2: ( ruleCollectionLiteralExpCS )
                    // InternalMiniOCLCS.g:1219:3: ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getLiteralExpCSAccess().getCollectionLiteralExpCSParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_2);
                    ruleCollectionLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getLiteralExpCSAccess().getCollectionLiteralExpCSParserRuleCall_3()); 
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
    // InternalMiniOCLCS.g:1228:1: rule__BooleanLiteralExpCS__Alternatives_1 : ( ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralExpCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1232:1: ( ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) ) | ( 'false' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==47) ) {
                alt15=1;
            }
            else if ( (LA15_0==19) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalMiniOCLCS.g:1233:2: ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) )
                    {
                    // InternalMiniOCLCS.g:1233:2: ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) )
                    // InternalMiniOCLCS.g:1234:3: ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolAssignment_1_0()); 
                    }
                    // InternalMiniOCLCS.g:1235:3: ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 )
                    // InternalMiniOCLCS.g:1235:4: rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0
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
                    // InternalMiniOCLCS.g:1239:2: ( 'false' )
                    {
                    // InternalMiniOCLCS.g:1239:2: ( 'false' )
                    // InternalMiniOCLCS.g:1240:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralExpCSAccess().getFalseKeyword_1_1()); 
                    }
                    match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1249:1: rule__PackageCS__Group__0 : rule__PackageCS__Group__0__Impl rule__PackageCS__Group__1 ;
    public final void rule__PackageCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1253:1: ( rule__PackageCS__Group__0__Impl rule__PackageCS__Group__1 )
            // InternalMiniOCLCS.g:1254:2: rule__PackageCS__Group__0__Impl rule__PackageCS__Group__1
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
    // InternalMiniOCLCS.g:1261:1: rule__PackageCS__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1265:1: ( ( 'package' ) )
            // InternalMiniOCLCS.g:1266:1: ( 'package' )
            {
            // InternalMiniOCLCS.g:1266:1: ( 'package' )
            // InternalMiniOCLCS.g:1267:2: 'package'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getPackageKeyword_0()); 
            }
            match(input,20,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1276:1: rule__PackageCS__Group__1 : rule__PackageCS__Group__1__Impl rule__PackageCS__Group__2 ;
    public final void rule__PackageCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1280:1: ( rule__PackageCS__Group__1__Impl rule__PackageCS__Group__2 )
            // InternalMiniOCLCS.g:1281:2: rule__PackageCS__Group__1__Impl rule__PackageCS__Group__2
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
    // InternalMiniOCLCS.g:1288:1: rule__PackageCS__Group__1__Impl : ( ( rule__PackageCS__NameAssignment_1 ) ) ;
    public final void rule__PackageCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1292:1: ( ( ( rule__PackageCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1293:1: ( ( rule__PackageCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1293:1: ( ( rule__PackageCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:1294:2: ( rule__PackageCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1295:2: ( rule__PackageCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:1295:3: rule__PackageCS__NameAssignment_1
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
    // InternalMiniOCLCS.g:1303:1: rule__PackageCS__Group__2 : rule__PackageCS__Group__2__Impl rule__PackageCS__Group__3 ;
    public final void rule__PackageCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1307:1: ( rule__PackageCS__Group__2__Impl rule__PackageCS__Group__3 )
            // InternalMiniOCLCS.g:1308:2: rule__PackageCS__Group__2__Impl rule__PackageCS__Group__3
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
    // InternalMiniOCLCS.g:1315:1: rule__PackageCS__Group__2__Impl : ( '{' ) ;
    public final void rule__PackageCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1319:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:1320:1: ( '{' )
            {
            // InternalMiniOCLCS.g:1320:1: ( '{' )
            // InternalMiniOCLCS.g:1321:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1330:1: rule__PackageCS__Group__3 : rule__PackageCS__Group__3__Impl rule__PackageCS__Group__4 ;
    public final void rule__PackageCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1334:1: ( rule__PackageCS__Group__3__Impl rule__PackageCS__Group__4 )
            // InternalMiniOCLCS.g:1335:2: rule__PackageCS__Group__3__Impl rule__PackageCS__Group__4
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
    // InternalMiniOCLCS.g:1342:1: rule__PackageCS__Group__3__Impl : ( ( rule__PackageCS__Alternatives_3 )* ) ;
    public final void rule__PackageCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1346:1: ( ( ( rule__PackageCS__Alternatives_3 )* ) )
            // InternalMiniOCLCS.g:1347:1: ( ( rule__PackageCS__Alternatives_3 )* )
            {
            // InternalMiniOCLCS.g:1347:1: ( ( rule__PackageCS__Alternatives_3 )* )
            // InternalMiniOCLCS.g:1348:2: ( rule__PackageCS__Alternatives_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getAlternatives_3()); 
            }
            // InternalMiniOCLCS.g:1349:2: ( rule__PackageCS__Alternatives_3 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==20||LA16_0==23||LA16_0==25) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1349:3: rule__PackageCS__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__PackageCS__Alternatives_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalMiniOCLCS.g:1357:1: rule__PackageCS__Group__4 : rule__PackageCS__Group__4__Impl ;
    public final void rule__PackageCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1361:1: ( rule__PackageCS__Group__4__Impl )
            // InternalMiniOCLCS.g:1362:2: rule__PackageCS__Group__4__Impl
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
    // InternalMiniOCLCS.g:1368:1: rule__PackageCS__Group__4__Impl : ( '}' ) ;
    public final void rule__PackageCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1372:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:1373:1: ( '}' )
            {
            // InternalMiniOCLCS.g:1373:1: ( '}' )
            // InternalMiniOCLCS.g:1374:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1384:1: rule__ClassCS__Group__0 : rule__ClassCS__Group__0__Impl rule__ClassCS__Group__1 ;
    public final void rule__ClassCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1388:1: ( rule__ClassCS__Group__0__Impl rule__ClassCS__Group__1 )
            // InternalMiniOCLCS.g:1389:2: rule__ClassCS__Group__0__Impl rule__ClassCS__Group__1
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
    // InternalMiniOCLCS.g:1396:1: rule__ClassCS__Group__0__Impl : ( 'class' ) ;
    public final void rule__ClassCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1400:1: ( ( 'class' ) )
            // InternalMiniOCLCS.g:1401:1: ( 'class' )
            {
            // InternalMiniOCLCS.g:1401:1: ( 'class' )
            // InternalMiniOCLCS.g:1402:2: 'class'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getClassKeyword_0()); 
            }
            match(input,23,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1411:1: rule__ClassCS__Group__1 : rule__ClassCS__Group__1__Impl rule__ClassCS__Group__2 ;
    public final void rule__ClassCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1415:1: ( rule__ClassCS__Group__1__Impl rule__ClassCS__Group__2 )
            // InternalMiniOCLCS.g:1416:2: rule__ClassCS__Group__1__Impl rule__ClassCS__Group__2
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
    // InternalMiniOCLCS.g:1423:1: rule__ClassCS__Group__1__Impl : ( ( rule__ClassCS__NameAssignment_1 ) ) ;
    public final void rule__ClassCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1427:1: ( ( ( rule__ClassCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1428:1: ( ( rule__ClassCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1428:1: ( ( rule__ClassCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:1429:2: ( rule__ClassCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1430:2: ( rule__ClassCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:1430:3: rule__ClassCS__NameAssignment_1
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
    // InternalMiniOCLCS.g:1438:1: rule__ClassCS__Group__2 : rule__ClassCS__Group__2__Impl rule__ClassCS__Group__3 ;
    public final void rule__ClassCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1442:1: ( rule__ClassCS__Group__2__Impl rule__ClassCS__Group__3 )
            // InternalMiniOCLCS.g:1443:2: rule__ClassCS__Group__2__Impl rule__ClassCS__Group__3
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
    // InternalMiniOCLCS.g:1450:1: rule__ClassCS__Group__2__Impl : ( ( rule__ClassCS__Group_2__0 )? ) ;
    public final void rule__ClassCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1454:1: ( ( ( rule__ClassCS__Group_2__0 )? ) )
            // InternalMiniOCLCS.g:1455:1: ( ( rule__ClassCS__Group_2__0 )? )
            {
            // InternalMiniOCLCS.g:1455:1: ( ( rule__ClassCS__Group_2__0 )? )
            // InternalMiniOCLCS.g:1456:2: ( rule__ClassCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:1457:2: ( rule__ClassCS__Group_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMiniOCLCS.g:1457:3: rule__ClassCS__Group_2__0
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
    // InternalMiniOCLCS.g:1465:1: rule__ClassCS__Group__3 : rule__ClassCS__Group__3__Impl rule__ClassCS__Group__4 ;
    public final void rule__ClassCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1469:1: ( rule__ClassCS__Group__3__Impl rule__ClassCS__Group__4 )
            // InternalMiniOCLCS.g:1470:2: rule__ClassCS__Group__3__Impl rule__ClassCS__Group__4
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
    // InternalMiniOCLCS.g:1477:1: rule__ClassCS__Group__3__Impl : ( '{' ) ;
    public final void rule__ClassCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1481:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:1482:1: ( '{' )
            {
            // InternalMiniOCLCS.g:1482:1: ( '{' )
            // InternalMiniOCLCS.g:1483:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1492:1: rule__ClassCS__Group__4 : rule__ClassCS__Group__4__Impl rule__ClassCS__Group__5 ;
    public final void rule__ClassCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1496:1: ( rule__ClassCS__Group__4__Impl rule__ClassCS__Group__5 )
            // InternalMiniOCLCS.g:1497:2: rule__ClassCS__Group__4__Impl rule__ClassCS__Group__5
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
    // InternalMiniOCLCS.g:1504:1: rule__ClassCS__Group__4__Impl : ( ( rule__ClassCS__Alternatives_4 )* ) ;
    public final void rule__ClassCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1508:1: ( ( ( rule__ClassCS__Alternatives_4 )* ) )
            // InternalMiniOCLCS.g:1509:1: ( ( rule__ClassCS__Alternatives_4 )* )
            {
            // InternalMiniOCLCS.g:1509:1: ( ( rule__ClassCS__Alternatives_4 )* )
            // InternalMiniOCLCS.g:1510:2: ( rule__ClassCS__Alternatives_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getAlternatives_4()); 
            }
            // InternalMiniOCLCS.g:1511:2: ( rule__ClassCS__Alternatives_4 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=12 && LA18_0<=14)||LA18_0==31) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1511:3: rule__ClassCS__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__ClassCS__Alternatives_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalMiniOCLCS.g:1519:1: rule__ClassCS__Group__5 : rule__ClassCS__Group__5__Impl ;
    public final void rule__ClassCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1523:1: ( rule__ClassCS__Group__5__Impl )
            // InternalMiniOCLCS.g:1524:2: rule__ClassCS__Group__5__Impl
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
    // InternalMiniOCLCS.g:1530:1: rule__ClassCS__Group__5__Impl : ( '}' ) ;
    public final void rule__ClassCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1534:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:1535:1: ( '}' )
            {
            // InternalMiniOCLCS.g:1535:1: ( '}' )
            // InternalMiniOCLCS.g:1536:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1546:1: rule__ClassCS__Group_2__0 : rule__ClassCS__Group_2__0__Impl rule__ClassCS__Group_2__1 ;
    public final void rule__ClassCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1550:1: ( rule__ClassCS__Group_2__0__Impl rule__ClassCS__Group_2__1 )
            // InternalMiniOCLCS.g:1551:2: rule__ClassCS__Group_2__0__Impl rule__ClassCS__Group_2__1
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
    // InternalMiniOCLCS.g:1558:1: rule__ClassCS__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__ClassCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1562:1: ( ( 'extends' ) )
            // InternalMiniOCLCS.g:1563:1: ( 'extends' )
            {
            // InternalMiniOCLCS.g:1563:1: ( 'extends' )
            // InternalMiniOCLCS.g:1564:2: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getExtendsKeyword_2_0()); 
            }
            match(input,24,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1573:1: rule__ClassCS__Group_2__1 : rule__ClassCS__Group_2__1__Impl ;
    public final void rule__ClassCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1577:1: ( rule__ClassCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:1578:2: rule__ClassCS__Group_2__1__Impl
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
    // InternalMiniOCLCS.g:1584:1: rule__ClassCS__Group_2__1__Impl : ( ( rule__ClassCS__ExtendsAssignment_2_1 ) ) ;
    public final void rule__ClassCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1588:1: ( ( ( rule__ClassCS__ExtendsAssignment_2_1 ) ) )
            // InternalMiniOCLCS.g:1589:1: ( ( rule__ClassCS__ExtendsAssignment_2_1 ) )
            {
            // InternalMiniOCLCS.g:1589:1: ( ( rule__ClassCS__ExtendsAssignment_2_1 ) )
            // InternalMiniOCLCS.g:1590:2: ( rule__ClassCS__ExtendsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getExtendsAssignment_2_1()); 
            }
            // InternalMiniOCLCS.g:1591:2: ( rule__ClassCS__ExtendsAssignment_2_1 )
            // InternalMiniOCLCS.g:1591:3: rule__ClassCS__ExtendsAssignment_2_1
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


    // $ANTLR start "rule__DatatypeCS__Group__0"
    // InternalMiniOCLCS.g:1600:1: rule__DatatypeCS__Group__0 : rule__DatatypeCS__Group__0__Impl rule__DatatypeCS__Group__1 ;
    public final void rule__DatatypeCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1604:1: ( rule__DatatypeCS__Group__0__Impl rule__DatatypeCS__Group__1 )
            // InternalMiniOCLCS.g:1605:2: rule__DatatypeCS__Group__0__Impl rule__DatatypeCS__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__DatatypeCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DatatypeCS__Group__1();

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
    // $ANTLR end "rule__DatatypeCS__Group__0"


    // $ANTLR start "rule__DatatypeCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1612:1: rule__DatatypeCS__Group__0__Impl : ( 'datatype' ) ;
    public final void rule__DatatypeCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1616:1: ( ( 'datatype' ) )
            // InternalMiniOCLCS.g:1617:1: ( 'datatype' )
            {
            // InternalMiniOCLCS.g:1617:1: ( 'datatype' )
            // InternalMiniOCLCS.g:1618:2: 'datatype'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeCSAccess().getDatatypeKeyword_0()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeCSAccess().getDatatypeKeyword_0()); 
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
    // $ANTLR end "rule__DatatypeCS__Group__0__Impl"


    // $ANTLR start "rule__DatatypeCS__Group__1"
    // InternalMiniOCLCS.g:1627:1: rule__DatatypeCS__Group__1 : rule__DatatypeCS__Group__1__Impl rule__DatatypeCS__Group__2 ;
    public final void rule__DatatypeCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1631:1: ( rule__DatatypeCS__Group__1__Impl rule__DatatypeCS__Group__2 )
            // InternalMiniOCLCS.g:1632:2: rule__DatatypeCS__Group__1__Impl rule__DatatypeCS__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__DatatypeCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DatatypeCS__Group__2();

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
    // $ANTLR end "rule__DatatypeCS__Group__1"


    // $ANTLR start "rule__DatatypeCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1639:1: rule__DatatypeCS__Group__1__Impl : ( ( rule__DatatypeCS__NameAssignment_1 ) ) ;
    public final void rule__DatatypeCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1643:1: ( ( ( rule__DatatypeCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1644:1: ( ( rule__DatatypeCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1644:1: ( ( rule__DatatypeCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:1645:2: ( rule__DatatypeCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1646:2: ( rule__DatatypeCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:1646:3: rule__DatatypeCS__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DatatypeCS__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeCSAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__DatatypeCS__Group__1__Impl"


    // $ANTLR start "rule__DatatypeCS__Group__2"
    // InternalMiniOCLCS.g:1654:1: rule__DatatypeCS__Group__2 : rule__DatatypeCS__Group__2__Impl rule__DatatypeCS__Group__3 ;
    public final void rule__DatatypeCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1658:1: ( rule__DatatypeCS__Group__2__Impl rule__DatatypeCS__Group__3 )
            // InternalMiniOCLCS.g:1659:2: rule__DatatypeCS__Group__2__Impl rule__DatatypeCS__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__DatatypeCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DatatypeCS__Group__3();

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
    // $ANTLR end "rule__DatatypeCS__Group__2"


    // $ANTLR start "rule__DatatypeCS__Group__2__Impl"
    // InternalMiniOCLCS.g:1666:1: rule__DatatypeCS__Group__2__Impl : ( ':' ) ;
    public final void rule__DatatypeCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1670:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:1671:1: ( ':' )
            {
            // InternalMiniOCLCS.g:1671:1: ( ':' )
            // InternalMiniOCLCS.g:1672:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeCSAccess().getColonKeyword_2()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeCSAccess().getColonKeyword_2()); 
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
    // $ANTLR end "rule__DatatypeCS__Group__2__Impl"


    // $ANTLR start "rule__DatatypeCS__Group__3"
    // InternalMiniOCLCS.g:1681:1: rule__DatatypeCS__Group__3 : rule__DatatypeCS__Group__3__Impl rule__DatatypeCS__Group__4 ;
    public final void rule__DatatypeCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1685:1: ( rule__DatatypeCS__Group__3__Impl rule__DatatypeCS__Group__4 )
            // InternalMiniOCLCS.g:1686:2: rule__DatatypeCS__Group__3__Impl rule__DatatypeCS__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__DatatypeCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__DatatypeCS__Group__4();

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
    // $ANTLR end "rule__DatatypeCS__Group__3"


    // $ANTLR start "rule__DatatypeCS__Group__3__Impl"
    // InternalMiniOCLCS.g:1693:1: rule__DatatypeCS__Group__3__Impl : ( ( rule__DatatypeCS__TypeNameAssignment_3 ) ) ;
    public final void rule__DatatypeCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1697:1: ( ( ( rule__DatatypeCS__TypeNameAssignment_3 ) ) )
            // InternalMiniOCLCS.g:1698:1: ( ( rule__DatatypeCS__TypeNameAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:1698:1: ( ( rule__DatatypeCS__TypeNameAssignment_3 ) )
            // InternalMiniOCLCS.g:1699:2: ( rule__DatatypeCS__TypeNameAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeCSAccess().getTypeNameAssignment_3()); 
            }
            // InternalMiniOCLCS.g:1700:2: ( rule__DatatypeCS__TypeNameAssignment_3 )
            // InternalMiniOCLCS.g:1700:3: rule__DatatypeCS__TypeNameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DatatypeCS__TypeNameAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeCSAccess().getTypeNameAssignment_3()); 
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
    // $ANTLR end "rule__DatatypeCS__Group__3__Impl"


    // $ANTLR start "rule__DatatypeCS__Group__4"
    // InternalMiniOCLCS.g:1708:1: rule__DatatypeCS__Group__4 : rule__DatatypeCS__Group__4__Impl ;
    public final void rule__DatatypeCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1712:1: ( rule__DatatypeCS__Group__4__Impl )
            // InternalMiniOCLCS.g:1713:2: rule__DatatypeCS__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DatatypeCS__Group__4__Impl();

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
    // $ANTLR end "rule__DatatypeCS__Group__4"


    // $ANTLR start "rule__DatatypeCS__Group__4__Impl"
    // InternalMiniOCLCS.g:1719:1: rule__DatatypeCS__Group__4__Impl : ( ';' ) ;
    public final void rule__DatatypeCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1723:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:1724:1: ( ';' )
            {
            // InternalMiniOCLCS.g:1724:1: ( ';' )
            // InternalMiniOCLCS.g:1725:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeCSAccess().getSemicolonKeyword_4()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeCSAccess().getSemicolonKeyword_4()); 
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
    // $ANTLR end "rule__DatatypeCS__Group__4__Impl"


    // $ANTLR start "rule__PropertyCS__Group__0"
    // InternalMiniOCLCS.g:1735:1: rule__PropertyCS__Group__0 : rule__PropertyCS__Group__0__Impl rule__PropertyCS__Group__1 ;
    public final void rule__PropertyCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1739:1: ( rule__PropertyCS__Group__0__Impl rule__PropertyCS__Group__1 )
            // InternalMiniOCLCS.g:1740:2: rule__PropertyCS__Group__0__Impl rule__PropertyCS__Group__1
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
    // InternalMiniOCLCS.g:1747:1: rule__PropertyCS__Group__0__Impl : ( ( rule__PropertyCS__Alternatives_0 ) ) ;
    public final void rule__PropertyCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1751:1: ( ( ( rule__PropertyCS__Alternatives_0 ) ) )
            // InternalMiniOCLCS.g:1752:1: ( ( rule__PropertyCS__Alternatives_0 ) )
            {
            // InternalMiniOCLCS.g:1752:1: ( ( rule__PropertyCS__Alternatives_0 ) )
            // InternalMiniOCLCS.g:1753:2: ( rule__PropertyCS__Alternatives_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getAlternatives_0()); 
            }
            // InternalMiniOCLCS.g:1754:2: ( rule__PropertyCS__Alternatives_0 )
            // InternalMiniOCLCS.g:1754:3: rule__PropertyCS__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__PropertyCS__Alternatives_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getAlternatives_0()); 
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
    // InternalMiniOCLCS.g:1762:1: rule__PropertyCS__Group__1 : rule__PropertyCS__Group__1__Impl rule__PropertyCS__Group__2 ;
    public final void rule__PropertyCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1766:1: ( rule__PropertyCS__Group__1__Impl rule__PropertyCS__Group__2 )
            // InternalMiniOCLCS.g:1767:2: rule__PropertyCS__Group__1__Impl rule__PropertyCS__Group__2
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
    // InternalMiniOCLCS.g:1774:1: rule__PropertyCS__Group__1__Impl : ( ( rule__PropertyCS__NameAssignment_1 ) ) ;
    public final void rule__PropertyCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1778:1: ( ( ( rule__PropertyCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1779:1: ( ( rule__PropertyCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1779:1: ( ( rule__PropertyCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:1780:2: ( rule__PropertyCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1781:2: ( rule__PropertyCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:1781:3: rule__PropertyCS__NameAssignment_1
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
    // InternalMiniOCLCS.g:1789:1: rule__PropertyCS__Group__2 : rule__PropertyCS__Group__2__Impl rule__PropertyCS__Group__3 ;
    public final void rule__PropertyCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1793:1: ( rule__PropertyCS__Group__2__Impl rule__PropertyCS__Group__3 )
            // InternalMiniOCLCS.g:1794:2: rule__PropertyCS__Group__2__Impl rule__PropertyCS__Group__3
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
    // InternalMiniOCLCS.g:1801:1: rule__PropertyCS__Group__2__Impl : ( ':' ) ;
    public final void rule__PropertyCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1805:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:1806:1: ( ':' )
            {
            // InternalMiniOCLCS.g:1806:1: ( ':' )
            // InternalMiniOCLCS.g:1807:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getColonKeyword_2()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1816:1: rule__PropertyCS__Group__3 : rule__PropertyCS__Group__3__Impl rule__PropertyCS__Group__4 ;
    public final void rule__PropertyCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1820:1: ( rule__PropertyCS__Group__3__Impl rule__PropertyCS__Group__4 )
            // InternalMiniOCLCS.g:1821:2: rule__PropertyCS__Group__3__Impl rule__PropertyCS__Group__4
            {
            pushFollow(FOLLOW_14);
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
    // InternalMiniOCLCS.g:1828:1: rule__PropertyCS__Group__3__Impl : ( ( rule__PropertyCS__TypeRefAssignment_3 ) ) ;
    public final void rule__PropertyCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1832:1: ( ( ( rule__PropertyCS__TypeRefAssignment_3 ) ) )
            // InternalMiniOCLCS.g:1833:1: ( ( rule__PropertyCS__TypeRefAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:1833:1: ( ( rule__PropertyCS__TypeRefAssignment_3 ) )
            // InternalMiniOCLCS.g:1834:2: ( rule__PropertyCS__TypeRefAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getTypeRefAssignment_3()); 
            }
            // InternalMiniOCLCS.g:1835:2: ( rule__PropertyCS__TypeRefAssignment_3 )
            // InternalMiniOCLCS.g:1835:3: rule__PropertyCS__TypeRefAssignment_3
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
    // InternalMiniOCLCS.g:1843:1: rule__PropertyCS__Group__4 : rule__PropertyCS__Group__4__Impl rule__PropertyCS__Group__5 ;
    public final void rule__PropertyCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1847:1: ( rule__PropertyCS__Group__4__Impl rule__PropertyCS__Group__5 )
            // InternalMiniOCLCS.g:1848:2: rule__PropertyCS__Group__4__Impl rule__PropertyCS__Group__5
            {
            pushFollow(FOLLOW_14);
            rule__PropertyCS__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__PropertyCS__Group__5();

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
    // InternalMiniOCLCS.g:1855:1: rule__PropertyCS__Group__4__Impl : ( ( rule__PropertyCS__MultiplicityAssignment_4 )? ) ;
    public final void rule__PropertyCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1859:1: ( ( ( rule__PropertyCS__MultiplicityAssignment_4 )? ) )
            // InternalMiniOCLCS.g:1860:1: ( ( rule__PropertyCS__MultiplicityAssignment_4 )? )
            {
            // InternalMiniOCLCS.g:1860:1: ( ( rule__PropertyCS__MultiplicityAssignment_4 )? )
            // InternalMiniOCLCS.g:1861:2: ( rule__PropertyCS__MultiplicityAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getMultiplicityAssignment_4()); 
            }
            // InternalMiniOCLCS.g:1862:2: ( rule__PropertyCS__MultiplicityAssignment_4 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMiniOCLCS.g:1862:3: rule__PropertyCS__MultiplicityAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__PropertyCS__MultiplicityAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getMultiplicityAssignment_4()); 
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


    // $ANTLR start "rule__PropertyCS__Group__5"
    // InternalMiniOCLCS.g:1870:1: rule__PropertyCS__Group__5 : rule__PropertyCS__Group__5__Impl ;
    public final void rule__PropertyCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1874:1: ( rule__PropertyCS__Group__5__Impl )
            // InternalMiniOCLCS.g:1875:2: rule__PropertyCS__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PropertyCS__Group__5__Impl();

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
    // $ANTLR end "rule__PropertyCS__Group__5"


    // $ANTLR start "rule__PropertyCS__Group__5__Impl"
    // InternalMiniOCLCS.g:1881:1: rule__PropertyCS__Group__5__Impl : ( ';' ) ;
    public final void rule__PropertyCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1885:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:1886:1: ( ';' )
            {
            // InternalMiniOCLCS.g:1886:1: ( ';' )
            // InternalMiniOCLCS.g:1887:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getSemicolonKeyword_5()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getSemicolonKeyword_5()); 
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
    // $ANTLR end "rule__PropertyCS__Group__5__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group__0"
    // InternalMiniOCLCS.g:1897:1: rule__MultiplicityCS__Group__0 : rule__MultiplicityCS__Group__0__Impl rule__MultiplicityCS__Group__1 ;
    public final void rule__MultiplicityCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1901:1: ( rule__MultiplicityCS__Group__0__Impl rule__MultiplicityCS__Group__1 )
            // InternalMiniOCLCS.g:1902:2: rule__MultiplicityCS__Group__0__Impl rule__MultiplicityCS__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__MultiplicityCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group__1();

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
    // $ANTLR end "rule__MultiplicityCS__Group__0"


    // $ANTLR start "rule__MultiplicityCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1909:1: rule__MultiplicityCS__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1913:1: ( ( '[' ) )
            // InternalMiniOCLCS.g:1914:1: ( '[' )
            {
            // InternalMiniOCLCS.g:1914:1: ( '[' )
            // InternalMiniOCLCS.g:1915:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0()); 
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
    // $ANTLR end "rule__MultiplicityCS__Group__0__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group__1"
    // InternalMiniOCLCS.g:1924:1: rule__MultiplicityCS__Group__1 : rule__MultiplicityCS__Group__1__Impl rule__MultiplicityCS__Group__2 ;
    public final void rule__MultiplicityCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1928:1: ( rule__MultiplicityCS__Group__1__Impl rule__MultiplicityCS__Group__2 )
            // InternalMiniOCLCS.g:1929:2: rule__MultiplicityCS__Group__1__Impl rule__MultiplicityCS__Group__2
            {
            pushFollow(FOLLOW_16);
            rule__MultiplicityCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group__2();

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
    // $ANTLR end "rule__MultiplicityCS__Group__1"


    // $ANTLR start "rule__MultiplicityCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1936:1: rule__MultiplicityCS__Group__1__Impl : ( ( rule__MultiplicityCS__Alternatives_1 ) ) ;
    public final void rule__MultiplicityCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1940:1: ( ( ( rule__MultiplicityCS__Alternatives_1 ) ) )
            // InternalMiniOCLCS.g:1941:1: ( ( rule__MultiplicityCS__Alternatives_1 ) )
            {
            // InternalMiniOCLCS.g:1941:1: ( ( rule__MultiplicityCS__Alternatives_1 ) )
            // InternalMiniOCLCS.g:1942:2: ( rule__MultiplicityCS__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getAlternatives_1()); 
            }
            // InternalMiniOCLCS.g:1943:2: ( rule__MultiplicityCS__Alternatives_1 )
            // InternalMiniOCLCS.g:1943:3: rule__MultiplicityCS__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getAlternatives_1()); 
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
    // $ANTLR end "rule__MultiplicityCS__Group__1__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group__2"
    // InternalMiniOCLCS.g:1951:1: rule__MultiplicityCS__Group__2 : rule__MultiplicityCS__Group__2__Impl ;
    public final void rule__MultiplicityCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1955:1: ( rule__MultiplicityCS__Group__2__Impl )
            // InternalMiniOCLCS.g:1956:2: rule__MultiplicityCS__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group__2__Impl();

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
    // $ANTLR end "rule__MultiplicityCS__Group__2"


    // $ANTLR start "rule__MultiplicityCS__Group__2__Impl"
    // InternalMiniOCLCS.g:1962:1: rule__MultiplicityCS__Group__2__Impl : ( ']' ) ;
    public final void rule__MultiplicityCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1966:1: ( ( ']' ) )
            // InternalMiniOCLCS.g:1967:1: ( ']' )
            {
            // InternalMiniOCLCS.g:1967:1: ( ']' )
            // InternalMiniOCLCS.g:1968:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_2()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_2()); 
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
    // $ANTLR end "rule__MultiplicityCS__Group__2__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group_1_2__0"
    // InternalMiniOCLCS.g:1978:1: rule__MultiplicityCS__Group_1_2__0 : rule__MultiplicityCS__Group_1_2__0__Impl rule__MultiplicityCS__Group_1_2__1 ;
    public final void rule__MultiplicityCS__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1982:1: ( rule__MultiplicityCS__Group_1_2__0__Impl rule__MultiplicityCS__Group_1_2__1 )
            // InternalMiniOCLCS.g:1983:2: rule__MultiplicityCS__Group_1_2__0__Impl rule__MultiplicityCS__Group_1_2__1
            {
            pushFollow(FOLLOW_17);
            rule__MultiplicityCS__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group_1_2__1();

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
    // $ANTLR end "rule__MultiplicityCS__Group_1_2__0"


    // $ANTLR start "rule__MultiplicityCS__Group_1_2__0__Impl"
    // InternalMiniOCLCS.g:1990:1: rule__MultiplicityCS__Group_1_2__0__Impl : ( ( rule__MultiplicityCS__LowerAssignment_1_2_0 ) ) ;
    public final void rule__MultiplicityCS__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1994:1: ( ( ( rule__MultiplicityCS__LowerAssignment_1_2_0 ) ) )
            // InternalMiniOCLCS.g:1995:1: ( ( rule__MultiplicityCS__LowerAssignment_1_2_0 ) )
            {
            // InternalMiniOCLCS.g:1995:1: ( ( rule__MultiplicityCS__LowerAssignment_1_2_0 ) )
            // InternalMiniOCLCS.g:1996:2: ( rule__MultiplicityCS__LowerAssignment_1_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getLowerAssignment_1_2_0()); 
            }
            // InternalMiniOCLCS.g:1997:2: ( rule__MultiplicityCS__LowerAssignment_1_2_0 )
            // InternalMiniOCLCS.g:1997:3: rule__MultiplicityCS__LowerAssignment_1_2_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__LowerAssignment_1_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getLowerAssignment_1_2_0()); 
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
    // $ANTLR end "rule__MultiplicityCS__Group_1_2__0__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group_1_2__1"
    // InternalMiniOCLCS.g:2005:1: rule__MultiplicityCS__Group_1_2__1 : rule__MultiplicityCS__Group_1_2__1__Impl rule__MultiplicityCS__Group_1_2__2 ;
    public final void rule__MultiplicityCS__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2009:1: ( rule__MultiplicityCS__Group_1_2__1__Impl rule__MultiplicityCS__Group_1_2__2 )
            // InternalMiniOCLCS.g:2010:2: rule__MultiplicityCS__Group_1_2__1__Impl rule__MultiplicityCS__Group_1_2__2
            {
            pushFollow(FOLLOW_18);
            rule__MultiplicityCS__Group_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group_1_2__2();

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
    // $ANTLR end "rule__MultiplicityCS__Group_1_2__1"


    // $ANTLR start "rule__MultiplicityCS__Group_1_2__1__Impl"
    // InternalMiniOCLCS.g:2017:1: rule__MultiplicityCS__Group_1_2__1__Impl : ( '..' ) ;
    public final void rule__MultiplicityCS__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2021:1: ( ( '..' ) )
            // InternalMiniOCLCS.g:2022:1: ( '..' )
            {
            // InternalMiniOCLCS.g:2022:1: ( '..' )
            // InternalMiniOCLCS.g:2023:2: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getFullStopFullStopKeyword_1_2_1()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getFullStopFullStopKeyword_1_2_1()); 
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
    // $ANTLR end "rule__MultiplicityCS__Group_1_2__1__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group_1_2__2"
    // InternalMiniOCLCS.g:2032:1: rule__MultiplicityCS__Group_1_2__2 : rule__MultiplicityCS__Group_1_2__2__Impl ;
    public final void rule__MultiplicityCS__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2036:1: ( rule__MultiplicityCS__Group_1_2__2__Impl )
            // InternalMiniOCLCS.g:2037:2: rule__MultiplicityCS__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group_1_2__2__Impl();

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
    // $ANTLR end "rule__MultiplicityCS__Group_1_2__2"


    // $ANTLR start "rule__MultiplicityCS__Group_1_2__2__Impl"
    // InternalMiniOCLCS.g:2043:1: rule__MultiplicityCS__Group_1_2__2__Impl : ( ( rule__MultiplicityCS__Alternatives_1_2_2 ) ) ;
    public final void rule__MultiplicityCS__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2047:1: ( ( ( rule__MultiplicityCS__Alternatives_1_2_2 ) ) )
            // InternalMiniOCLCS.g:2048:1: ( ( rule__MultiplicityCS__Alternatives_1_2_2 ) )
            {
            // InternalMiniOCLCS.g:2048:1: ( ( rule__MultiplicityCS__Alternatives_1_2_2 ) )
            // InternalMiniOCLCS.g:2049:2: ( rule__MultiplicityCS__Alternatives_1_2_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getAlternatives_1_2_2()); 
            }
            // InternalMiniOCLCS.g:2050:2: ( rule__MultiplicityCS__Alternatives_1_2_2 )
            // InternalMiniOCLCS.g:2050:3: rule__MultiplicityCS__Alternatives_1_2_2
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Alternatives_1_2_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getAlternatives_1_2_2()); 
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
    // $ANTLR end "rule__MultiplicityCS__Group_1_2__2__Impl"


    // $ANTLR start "rule__OperationCS__Group__0"
    // InternalMiniOCLCS.g:2059:1: rule__OperationCS__Group__0 : rule__OperationCS__Group__0__Impl rule__OperationCS__Group__1 ;
    public final void rule__OperationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2063:1: ( rule__OperationCS__Group__0__Impl rule__OperationCS__Group__1 )
            // InternalMiniOCLCS.g:2064:2: rule__OperationCS__Group__0__Impl rule__OperationCS__Group__1
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
    // InternalMiniOCLCS.g:2071:1: rule__OperationCS__Group__0__Impl : ( 'op' ) ;
    public final void rule__OperationCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2075:1: ( ( 'op' ) )
            // InternalMiniOCLCS.g:2076:1: ( 'op' )
            {
            // InternalMiniOCLCS.g:2076:1: ( 'op' )
            // InternalMiniOCLCS.g:2077:2: 'op'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getOpKeyword_0()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2086:1: rule__OperationCS__Group__1 : rule__OperationCS__Group__1__Impl rule__OperationCS__Group__2 ;
    public final void rule__OperationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2090:1: ( rule__OperationCS__Group__1__Impl rule__OperationCS__Group__2 )
            // InternalMiniOCLCS.g:2091:2: rule__OperationCS__Group__1__Impl rule__OperationCS__Group__2
            {
            pushFollow(FOLLOW_19);
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
    // InternalMiniOCLCS.g:2098:1: rule__OperationCS__Group__1__Impl : ( ( rule__OperationCS__NameAssignment_1 ) ) ;
    public final void rule__OperationCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2102:1: ( ( ( rule__OperationCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:2103:1: ( ( rule__OperationCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:2103:1: ( ( rule__OperationCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:2104:2: ( rule__OperationCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:2105:2: ( rule__OperationCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:2105:3: rule__OperationCS__NameAssignment_1
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
    // InternalMiniOCLCS.g:2113:1: rule__OperationCS__Group__2 : rule__OperationCS__Group__2__Impl rule__OperationCS__Group__3 ;
    public final void rule__OperationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2117:1: ( rule__OperationCS__Group__2__Impl rule__OperationCS__Group__3 )
            // InternalMiniOCLCS.g:2118:2: rule__OperationCS__Group__2__Impl rule__OperationCS__Group__3
            {
            pushFollow(FOLLOW_20);
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
    // InternalMiniOCLCS.g:2125:1: rule__OperationCS__Group__2__Impl : ( '(' ) ;
    public final void rule__OperationCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2129:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:2130:1: ( '(' )
            {
            // InternalMiniOCLCS.g:2130:1: ( '(' )
            // InternalMiniOCLCS.g:2131:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2140:1: rule__OperationCS__Group__3 : rule__OperationCS__Group__3__Impl rule__OperationCS__Group__4 ;
    public final void rule__OperationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2144:1: ( rule__OperationCS__Group__3__Impl rule__OperationCS__Group__4 )
            // InternalMiniOCLCS.g:2145:2: rule__OperationCS__Group__3__Impl rule__OperationCS__Group__4
            {
            pushFollow(FOLLOW_20);
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
    // InternalMiniOCLCS.g:2152:1: rule__OperationCS__Group__3__Impl : ( ( rule__OperationCS__Group_3__0 )? ) ;
    public final void rule__OperationCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2156:1: ( ( ( rule__OperationCS__Group_3__0 )? ) )
            // InternalMiniOCLCS.g:2157:1: ( ( rule__OperationCS__Group_3__0 )? )
            {
            // InternalMiniOCLCS.g:2157:1: ( ( rule__OperationCS__Group_3__0 )? )
            // InternalMiniOCLCS.g:2158:2: ( rule__OperationCS__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getGroup_3()); 
            }
            // InternalMiniOCLCS.g:2159:2: ( rule__OperationCS__Group_3__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMiniOCLCS.g:2159:3: rule__OperationCS__Group_3__0
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
    // InternalMiniOCLCS.g:2167:1: rule__OperationCS__Group__4 : rule__OperationCS__Group__4__Impl rule__OperationCS__Group__5 ;
    public final void rule__OperationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2171:1: ( rule__OperationCS__Group__4__Impl rule__OperationCS__Group__5 )
            // InternalMiniOCLCS.g:2172:2: rule__OperationCS__Group__4__Impl rule__OperationCS__Group__5
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
    // InternalMiniOCLCS.g:2179:1: rule__OperationCS__Group__4__Impl : ( ')' ) ;
    public final void rule__OperationCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2183:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:2184:1: ( ')' )
            {
            // InternalMiniOCLCS.g:2184:1: ( ')' )
            // InternalMiniOCLCS.g:2185:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2194:1: rule__OperationCS__Group__5 : rule__OperationCS__Group__5__Impl rule__OperationCS__Group__6 ;
    public final void rule__OperationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2198:1: ( rule__OperationCS__Group__5__Impl rule__OperationCS__Group__6 )
            // InternalMiniOCLCS.g:2199:2: rule__OperationCS__Group__5__Impl rule__OperationCS__Group__6
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
    // InternalMiniOCLCS.g:2206:1: rule__OperationCS__Group__5__Impl : ( ':' ) ;
    public final void rule__OperationCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2210:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:2211:1: ( ':' )
            {
            // InternalMiniOCLCS.g:2211:1: ( ':' )
            // InternalMiniOCLCS.g:2212:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getColonKeyword_5()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2221:1: rule__OperationCS__Group__6 : rule__OperationCS__Group__6__Impl rule__OperationCS__Group__7 ;
    public final void rule__OperationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2225:1: ( rule__OperationCS__Group__6__Impl rule__OperationCS__Group__7 )
            // InternalMiniOCLCS.g:2226:2: rule__OperationCS__Group__6__Impl rule__OperationCS__Group__7
            {
            pushFollow(FOLLOW_21);
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
    // InternalMiniOCLCS.g:2233:1: rule__OperationCS__Group__6__Impl : ( ( rule__OperationCS__ResultRefAssignment_6 ) ) ;
    public final void rule__OperationCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2237:1: ( ( ( rule__OperationCS__ResultRefAssignment_6 ) ) )
            // InternalMiniOCLCS.g:2238:1: ( ( rule__OperationCS__ResultRefAssignment_6 ) )
            {
            // InternalMiniOCLCS.g:2238:1: ( ( rule__OperationCS__ResultRefAssignment_6 ) )
            // InternalMiniOCLCS.g:2239:2: ( rule__OperationCS__ResultRefAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getResultRefAssignment_6()); 
            }
            // InternalMiniOCLCS.g:2240:2: ( rule__OperationCS__ResultRefAssignment_6 )
            // InternalMiniOCLCS.g:2240:3: rule__OperationCS__ResultRefAssignment_6
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
    // InternalMiniOCLCS.g:2248:1: rule__OperationCS__Group__7 : rule__OperationCS__Group__7__Impl rule__OperationCS__Group__8 ;
    public final void rule__OperationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2252:1: ( rule__OperationCS__Group__7__Impl rule__OperationCS__Group__8 )
            // InternalMiniOCLCS.g:2253:2: rule__OperationCS__Group__7__Impl rule__OperationCS__Group__8
            {
            pushFollow(FOLLOW_22);
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
    // InternalMiniOCLCS.g:2260:1: rule__OperationCS__Group__7__Impl : ( '=' ) ;
    public final void rule__OperationCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2264:1: ( ( '=' ) )
            // InternalMiniOCLCS.g:2265:1: ( '=' )
            {
            // InternalMiniOCLCS.g:2265:1: ( '=' )
            // InternalMiniOCLCS.g:2266:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getEqualsSignKeyword_7()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2275:1: rule__OperationCS__Group__8 : rule__OperationCS__Group__8__Impl rule__OperationCS__Group__9 ;
    public final void rule__OperationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2279:1: ( rule__OperationCS__Group__8__Impl rule__OperationCS__Group__9 )
            // InternalMiniOCLCS.g:2280:2: rule__OperationCS__Group__8__Impl rule__OperationCS__Group__9
            {
            pushFollow(FOLLOW_13);
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
    // InternalMiniOCLCS.g:2287:1: rule__OperationCS__Group__8__Impl : ( ( rule__OperationCS__BodyAssignment_8 ) ) ;
    public final void rule__OperationCS__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2291:1: ( ( ( rule__OperationCS__BodyAssignment_8 ) ) )
            // InternalMiniOCLCS.g:2292:1: ( ( rule__OperationCS__BodyAssignment_8 ) )
            {
            // InternalMiniOCLCS.g:2292:1: ( ( rule__OperationCS__BodyAssignment_8 ) )
            // InternalMiniOCLCS.g:2293:2: ( rule__OperationCS__BodyAssignment_8 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getBodyAssignment_8()); 
            }
            // InternalMiniOCLCS.g:2294:2: ( rule__OperationCS__BodyAssignment_8 )
            // InternalMiniOCLCS.g:2294:3: rule__OperationCS__BodyAssignment_8
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
    // InternalMiniOCLCS.g:2302:1: rule__OperationCS__Group__9 : rule__OperationCS__Group__9__Impl ;
    public final void rule__OperationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2306:1: ( rule__OperationCS__Group__9__Impl )
            // InternalMiniOCLCS.g:2307:2: rule__OperationCS__Group__9__Impl
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
    // InternalMiniOCLCS.g:2313:1: rule__OperationCS__Group__9__Impl : ( ';' ) ;
    public final void rule__OperationCS__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2317:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:2318:1: ( ';' )
            {
            // InternalMiniOCLCS.g:2318:1: ( ';' )
            // InternalMiniOCLCS.g:2319:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getSemicolonKeyword_9()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2329:1: rule__OperationCS__Group_3__0 : rule__OperationCS__Group_3__0__Impl rule__OperationCS__Group_3__1 ;
    public final void rule__OperationCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2333:1: ( rule__OperationCS__Group_3__0__Impl rule__OperationCS__Group_3__1 )
            // InternalMiniOCLCS.g:2334:2: rule__OperationCS__Group_3__0__Impl rule__OperationCS__Group_3__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalMiniOCLCS.g:2341:1: rule__OperationCS__Group_3__0__Impl : ( ( rule__OperationCS__ParamsAssignment_3_0 ) ) ;
    public final void rule__OperationCS__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2345:1: ( ( ( rule__OperationCS__ParamsAssignment_3_0 ) ) )
            // InternalMiniOCLCS.g:2346:1: ( ( rule__OperationCS__ParamsAssignment_3_0 ) )
            {
            // InternalMiniOCLCS.g:2346:1: ( ( rule__OperationCS__ParamsAssignment_3_0 ) )
            // InternalMiniOCLCS.g:2347:2: ( rule__OperationCS__ParamsAssignment_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getParamsAssignment_3_0()); 
            }
            // InternalMiniOCLCS.g:2348:2: ( rule__OperationCS__ParamsAssignment_3_0 )
            // InternalMiniOCLCS.g:2348:3: rule__OperationCS__ParamsAssignment_3_0
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
    // InternalMiniOCLCS.g:2356:1: rule__OperationCS__Group_3__1 : rule__OperationCS__Group_3__1__Impl ;
    public final void rule__OperationCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2360:1: ( rule__OperationCS__Group_3__1__Impl )
            // InternalMiniOCLCS.g:2361:2: rule__OperationCS__Group_3__1__Impl
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
    // InternalMiniOCLCS.g:2367:1: rule__OperationCS__Group_3__1__Impl : ( ( rule__OperationCS__Group_3_1__0 )* ) ;
    public final void rule__OperationCS__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2371:1: ( ( ( rule__OperationCS__Group_3_1__0 )* ) )
            // InternalMiniOCLCS.g:2372:1: ( ( rule__OperationCS__Group_3_1__0 )* )
            {
            // InternalMiniOCLCS.g:2372:1: ( ( rule__OperationCS__Group_3_1__0 )* )
            // InternalMiniOCLCS.g:2373:2: ( rule__OperationCS__Group_3_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getGroup_3_1()); 
            }
            // InternalMiniOCLCS.g:2374:2: ( rule__OperationCS__Group_3_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==34) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2374:3: rule__OperationCS__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__OperationCS__Group_3_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalMiniOCLCS.g:2383:1: rule__OperationCS__Group_3_1__0 : rule__OperationCS__Group_3_1__0__Impl rule__OperationCS__Group_3_1__1 ;
    public final void rule__OperationCS__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2387:1: ( rule__OperationCS__Group_3_1__0__Impl rule__OperationCS__Group_3_1__1 )
            // InternalMiniOCLCS.g:2388:2: rule__OperationCS__Group_3_1__0__Impl rule__OperationCS__Group_3_1__1
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
    // InternalMiniOCLCS.g:2395:1: rule__OperationCS__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__OperationCS__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2399:1: ( ( ',' ) )
            // InternalMiniOCLCS.g:2400:1: ( ',' )
            {
            // InternalMiniOCLCS.g:2400:1: ( ',' )
            // InternalMiniOCLCS.g:2401:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getCommaKeyword_3_1_0()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2410:1: rule__OperationCS__Group_3_1__1 : rule__OperationCS__Group_3_1__1__Impl ;
    public final void rule__OperationCS__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2414:1: ( rule__OperationCS__Group_3_1__1__Impl )
            // InternalMiniOCLCS.g:2415:2: rule__OperationCS__Group_3_1__1__Impl
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
    // InternalMiniOCLCS.g:2421:1: rule__OperationCS__Group_3_1__1__Impl : ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) ) ;
    public final void rule__OperationCS__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2425:1: ( ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) ) )
            // InternalMiniOCLCS.g:2426:1: ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) )
            {
            // InternalMiniOCLCS.g:2426:1: ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) )
            // InternalMiniOCLCS.g:2427:2: ( rule__OperationCS__ParamsAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getParamsAssignment_3_1_1()); 
            }
            // InternalMiniOCLCS.g:2428:2: ( rule__OperationCS__ParamsAssignment_3_1_1 )
            // InternalMiniOCLCS.g:2428:3: rule__OperationCS__ParamsAssignment_3_1_1
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
    // InternalMiniOCLCS.g:2437:1: rule__ParameterCS__Group__0 : rule__ParameterCS__Group__0__Impl rule__ParameterCS__Group__1 ;
    public final void rule__ParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2441:1: ( rule__ParameterCS__Group__0__Impl rule__ParameterCS__Group__1 )
            // InternalMiniOCLCS.g:2442:2: rule__ParameterCS__Group__0__Impl rule__ParameterCS__Group__1
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
    // InternalMiniOCLCS.g:2449:1: rule__ParameterCS__Group__0__Impl : ( ( rule__ParameterCS__NameAssignment_0 ) ) ;
    public final void rule__ParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2453:1: ( ( ( rule__ParameterCS__NameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:2454:1: ( ( rule__ParameterCS__NameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:2454:1: ( ( rule__ParameterCS__NameAssignment_0 ) )
            // InternalMiniOCLCS.g:2455:2: ( rule__ParameterCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:2456:2: ( rule__ParameterCS__NameAssignment_0 )
            // InternalMiniOCLCS.g:2456:3: rule__ParameterCS__NameAssignment_0
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
    // InternalMiniOCLCS.g:2464:1: rule__ParameterCS__Group__1 : rule__ParameterCS__Group__1__Impl rule__ParameterCS__Group__2 ;
    public final void rule__ParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2468:1: ( rule__ParameterCS__Group__1__Impl rule__ParameterCS__Group__2 )
            // InternalMiniOCLCS.g:2469:2: rule__ParameterCS__Group__1__Impl rule__ParameterCS__Group__2
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
    // InternalMiniOCLCS.g:2476:1: rule__ParameterCS__Group__1__Impl : ( ':' ) ;
    public final void rule__ParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2480:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:2481:1: ( ':' )
            {
            // InternalMiniOCLCS.g:2481:1: ( ':' )
            // InternalMiniOCLCS.g:2482:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getColonKeyword_1()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2491:1: rule__ParameterCS__Group__2 : rule__ParameterCS__Group__2__Impl ;
    public final void rule__ParameterCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2495:1: ( rule__ParameterCS__Group__2__Impl )
            // InternalMiniOCLCS.g:2496:2: rule__ParameterCS__Group__2__Impl
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
    // InternalMiniOCLCS.g:2502:1: rule__ParameterCS__Group__2__Impl : ( ( rule__ParameterCS__TypeRefAssignment_2 ) ) ;
    public final void rule__ParameterCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2506:1: ( ( ( rule__ParameterCS__TypeRefAssignment_2 ) ) )
            // InternalMiniOCLCS.g:2507:1: ( ( rule__ParameterCS__TypeRefAssignment_2 ) )
            {
            // InternalMiniOCLCS.g:2507:1: ( ( rule__ParameterCS__TypeRefAssignment_2 ) )
            // InternalMiniOCLCS.g:2508:2: ( rule__ParameterCS__TypeRefAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getTypeRefAssignment_2()); 
            }
            // InternalMiniOCLCS.g:2509:2: ( rule__ParameterCS__TypeRefAssignment_2 )
            // InternalMiniOCLCS.g:2509:3: rule__ParameterCS__TypeRefAssignment_2
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
    // InternalMiniOCLCS.g:2518:1: rule__ConstraintsDefCS__Group__0 : rule__ConstraintsDefCS__Group__0__Impl rule__ConstraintsDefCS__Group__1 ;
    public final void rule__ConstraintsDefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2522:1: ( rule__ConstraintsDefCS__Group__0__Impl rule__ConstraintsDefCS__Group__1 )
            // InternalMiniOCLCS.g:2523:2: rule__ConstraintsDefCS__Group__0__Impl rule__ConstraintsDefCS__Group__1
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
    // InternalMiniOCLCS.g:2530:1: rule__ConstraintsDefCS__Group__0__Impl : ( 'context' ) ;
    public final void rule__ConstraintsDefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2534:1: ( ( 'context' ) )
            // InternalMiniOCLCS.g:2535:1: ( 'context' )
            {
            // InternalMiniOCLCS.g:2535:1: ( 'context' )
            // InternalMiniOCLCS.g:2536:2: 'context'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getContextKeyword_0()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2545:1: rule__ConstraintsDefCS__Group__1 : rule__ConstraintsDefCS__Group__1__Impl rule__ConstraintsDefCS__Group__2 ;
    public final void rule__ConstraintsDefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2549:1: ( rule__ConstraintsDefCS__Group__1__Impl rule__ConstraintsDefCS__Group__2 )
            // InternalMiniOCLCS.g:2550:2: rule__ConstraintsDefCS__Group__1__Impl rule__ConstraintsDefCS__Group__2
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
    // InternalMiniOCLCS.g:2557:1: rule__ConstraintsDefCS__Group__1__Impl : ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) ) ;
    public final void rule__ConstraintsDefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2561:1: ( ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) ) )
            // InternalMiniOCLCS.g:2562:1: ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:2562:1: ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) )
            // InternalMiniOCLCS.g:2563:2: ( rule__ConstraintsDefCS__TypeRefAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getTypeRefAssignment_1()); 
            }
            // InternalMiniOCLCS.g:2564:2: ( rule__ConstraintsDefCS__TypeRefAssignment_1 )
            // InternalMiniOCLCS.g:2564:3: rule__ConstraintsDefCS__TypeRefAssignment_1
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
    // InternalMiniOCLCS.g:2572:1: rule__ConstraintsDefCS__Group__2 : rule__ConstraintsDefCS__Group__2__Impl rule__ConstraintsDefCS__Group__3 ;
    public final void rule__ConstraintsDefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2576:1: ( rule__ConstraintsDefCS__Group__2__Impl rule__ConstraintsDefCS__Group__3 )
            // InternalMiniOCLCS.g:2577:2: rule__ConstraintsDefCS__Group__2__Impl rule__ConstraintsDefCS__Group__3
            {
            pushFollow(FOLLOW_25);
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
    // InternalMiniOCLCS.g:2584:1: rule__ConstraintsDefCS__Group__2__Impl : ( '{' ) ;
    public final void rule__ConstraintsDefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2588:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:2589:1: ( '{' )
            {
            // InternalMiniOCLCS.g:2589:1: ( '{' )
            // InternalMiniOCLCS.g:2590:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2599:1: rule__ConstraintsDefCS__Group__3 : rule__ConstraintsDefCS__Group__3__Impl rule__ConstraintsDefCS__Group__4 ;
    public final void rule__ConstraintsDefCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2603:1: ( rule__ConstraintsDefCS__Group__3__Impl rule__ConstraintsDefCS__Group__4 )
            // InternalMiniOCLCS.g:2604:2: rule__ConstraintsDefCS__Group__3__Impl rule__ConstraintsDefCS__Group__4
            {
            pushFollow(FOLLOW_25);
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
    // InternalMiniOCLCS.g:2611:1: rule__ConstraintsDefCS__Group__3__Impl : ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* ) ;
    public final void rule__ConstraintsDefCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2615:1: ( ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* ) )
            // InternalMiniOCLCS.g:2616:1: ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* )
            {
            // InternalMiniOCLCS.g:2616:1: ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* )
            // InternalMiniOCLCS.g:2617:2: ( rule__ConstraintsDefCS__InvariantsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getInvariantsAssignment_3()); 
            }
            // InternalMiniOCLCS.g:2618:2: ( rule__ConstraintsDefCS__InvariantsAssignment_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==36) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2618:3: rule__ConstraintsDefCS__InvariantsAssignment_3
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__ConstraintsDefCS__InvariantsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalMiniOCLCS.g:2626:1: rule__ConstraintsDefCS__Group__4 : rule__ConstraintsDefCS__Group__4__Impl ;
    public final void rule__ConstraintsDefCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2630:1: ( rule__ConstraintsDefCS__Group__4__Impl )
            // InternalMiniOCLCS.g:2631:2: rule__ConstraintsDefCS__Group__4__Impl
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
    // InternalMiniOCLCS.g:2637:1: rule__ConstraintsDefCS__Group__4__Impl : ( '}' ) ;
    public final void rule__ConstraintsDefCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2641:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:2642:1: ( '}' )
            {
            // InternalMiniOCLCS.g:2642:1: ( '}' )
            // InternalMiniOCLCS.g:2643:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2653:1: rule__InvariantCS__Group__0 : rule__InvariantCS__Group__0__Impl rule__InvariantCS__Group__1 ;
    public final void rule__InvariantCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2657:1: ( rule__InvariantCS__Group__0__Impl rule__InvariantCS__Group__1 )
            // InternalMiniOCLCS.g:2658:2: rule__InvariantCS__Group__0__Impl rule__InvariantCS__Group__1
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
    // InternalMiniOCLCS.g:2665:1: rule__InvariantCS__Group__0__Impl : ( 'inv' ) ;
    public final void rule__InvariantCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2669:1: ( ( 'inv' ) )
            // InternalMiniOCLCS.g:2670:1: ( 'inv' )
            {
            // InternalMiniOCLCS.g:2670:1: ( 'inv' )
            // InternalMiniOCLCS.g:2671:2: 'inv'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getInvKeyword_0()); 
            }
            match(input,36,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2680:1: rule__InvariantCS__Group__1 : rule__InvariantCS__Group__1__Impl rule__InvariantCS__Group__2 ;
    public final void rule__InvariantCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2684:1: ( rule__InvariantCS__Group__1__Impl rule__InvariantCS__Group__2 )
            // InternalMiniOCLCS.g:2685:2: rule__InvariantCS__Group__1__Impl rule__InvariantCS__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalMiniOCLCS.g:2692:1: rule__InvariantCS__Group__1__Impl : ( ':' ) ;
    public final void rule__InvariantCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2696:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:2697:1: ( ':' )
            {
            // InternalMiniOCLCS.g:2697:1: ( ':' )
            // InternalMiniOCLCS.g:2698:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getColonKeyword_1()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2707:1: rule__InvariantCS__Group__2 : rule__InvariantCS__Group__2__Impl rule__InvariantCS__Group__3 ;
    public final void rule__InvariantCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2711:1: ( rule__InvariantCS__Group__2__Impl rule__InvariantCS__Group__3 )
            // InternalMiniOCLCS.g:2712:2: rule__InvariantCS__Group__2__Impl rule__InvariantCS__Group__3
            {
            pushFollow(FOLLOW_13);
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
    // InternalMiniOCLCS.g:2719:1: rule__InvariantCS__Group__2__Impl : ( ( rule__InvariantCS__ExpAssignment_2 ) ) ;
    public final void rule__InvariantCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2723:1: ( ( ( rule__InvariantCS__ExpAssignment_2 ) ) )
            // InternalMiniOCLCS.g:2724:1: ( ( rule__InvariantCS__ExpAssignment_2 ) )
            {
            // InternalMiniOCLCS.g:2724:1: ( ( rule__InvariantCS__ExpAssignment_2 ) )
            // InternalMiniOCLCS.g:2725:2: ( rule__InvariantCS__ExpAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getExpAssignment_2()); 
            }
            // InternalMiniOCLCS.g:2726:2: ( rule__InvariantCS__ExpAssignment_2 )
            // InternalMiniOCLCS.g:2726:3: rule__InvariantCS__ExpAssignment_2
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
    // InternalMiniOCLCS.g:2734:1: rule__InvariantCS__Group__3 : rule__InvariantCS__Group__3__Impl ;
    public final void rule__InvariantCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2738:1: ( rule__InvariantCS__Group__3__Impl )
            // InternalMiniOCLCS.g:2739:2: rule__InvariantCS__Group__3__Impl
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
    // InternalMiniOCLCS.g:2745:1: rule__InvariantCS__Group__3__Impl : ( ';' ) ;
    public final void rule__InvariantCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2749:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:2750:1: ( ';' )
            {
            // InternalMiniOCLCS.g:2750:1: ( ';' )
            // InternalMiniOCLCS.g:2751:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getSemicolonKeyword_3()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2761:1: rule__LogicExpCS__Group__0 : rule__LogicExpCS__Group__0__Impl rule__LogicExpCS__Group__1 ;
    public final void rule__LogicExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2765:1: ( rule__LogicExpCS__Group__0__Impl rule__LogicExpCS__Group__1 )
            // InternalMiniOCLCS.g:2766:2: rule__LogicExpCS__Group__0__Impl rule__LogicExpCS__Group__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalMiniOCLCS.g:2773:1: rule__LogicExpCS__Group__0__Impl : ( ruleCallExpCS ) ;
    public final void rule__LogicExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2777:1: ( ( ruleCallExpCS ) )
            // InternalMiniOCLCS.g:2778:1: ( ruleCallExpCS )
            {
            // InternalMiniOCLCS.g:2778:1: ( ruleCallExpCS )
            // InternalMiniOCLCS.g:2779:2: ruleCallExpCS
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
    // InternalMiniOCLCS.g:2788:1: rule__LogicExpCS__Group__1 : rule__LogicExpCS__Group__1__Impl ;
    public final void rule__LogicExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2792:1: ( rule__LogicExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:2793:2: rule__LogicExpCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:2799:1: rule__LogicExpCS__Group__1__Impl : ( ( rule__LogicExpCS__Group_1__0 )* ) ;
    public final void rule__LogicExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2803:1: ( ( ( rule__LogicExpCS__Group_1__0 )* ) )
            // InternalMiniOCLCS.g:2804:1: ( ( rule__LogicExpCS__Group_1__0 )* )
            {
            // InternalMiniOCLCS.g:2804:1: ( ( rule__LogicExpCS__Group_1__0 )* )
            // InternalMiniOCLCS.g:2805:2: ( rule__LogicExpCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:2806:2: ( rule__LogicExpCS__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==15) ) {
                    int LA23_2 = input.LA(2);

                    if ( (synpred29_InternalMiniOCLCS()) ) {
                        alt23=1;
                    }


                }
                else if ( (LA23_0==16) ) {
                    int LA23_3 = input.LA(2);

                    if ( (synpred29_InternalMiniOCLCS()) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2806:3: rule__LogicExpCS__Group_1__0
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__LogicExpCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalMiniOCLCS.g:2815:1: rule__LogicExpCS__Group_1__0 : rule__LogicExpCS__Group_1__0__Impl rule__LogicExpCS__Group_1__1 ;
    public final void rule__LogicExpCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2819:1: ( rule__LogicExpCS__Group_1__0__Impl rule__LogicExpCS__Group_1__1 )
            // InternalMiniOCLCS.g:2820:2: rule__LogicExpCS__Group_1__0__Impl rule__LogicExpCS__Group_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalMiniOCLCS.g:2827:1: rule__LogicExpCS__Group_1__0__Impl : ( () ) ;
    public final void rule__LogicExpCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2831:1: ( ( () ) )
            // InternalMiniOCLCS.g:2832:1: ( () )
            {
            // InternalMiniOCLCS.g:2832:1: ( () )
            // InternalMiniOCLCS.g:2833:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getLogicExpCSLeftAction_1_0()); 
            }
            // InternalMiniOCLCS.g:2834:2: ()
            // InternalMiniOCLCS.g:2834:3: 
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
    // InternalMiniOCLCS.g:2842:1: rule__LogicExpCS__Group_1__1 : rule__LogicExpCS__Group_1__1__Impl rule__LogicExpCS__Group_1__2 ;
    public final void rule__LogicExpCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2846:1: ( rule__LogicExpCS__Group_1__1__Impl rule__LogicExpCS__Group_1__2 )
            // InternalMiniOCLCS.g:2847:2: rule__LogicExpCS__Group_1__1__Impl rule__LogicExpCS__Group_1__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalMiniOCLCS.g:2854:1: rule__LogicExpCS__Group_1__1__Impl : ( ( rule__LogicExpCS__OpAssignment_1_1 ) ) ;
    public final void rule__LogicExpCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2858:1: ( ( ( rule__LogicExpCS__OpAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:2859:1: ( ( rule__LogicExpCS__OpAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:2859:1: ( ( rule__LogicExpCS__OpAssignment_1_1 ) )
            // InternalMiniOCLCS.g:2860:2: ( rule__LogicExpCS__OpAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getOpAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:2861:2: ( rule__LogicExpCS__OpAssignment_1_1 )
            // InternalMiniOCLCS.g:2861:3: rule__LogicExpCS__OpAssignment_1_1
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
    // InternalMiniOCLCS.g:2869:1: rule__LogicExpCS__Group_1__2 : rule__LogicExpCS__Group_1__2__Impl ;
    public final void rule__LogicExpCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2873:1: ( rule__LogicExpCS__Group_1__2__Impl )
            // InternalMiniOCLCS.g:2874:2: rule__LogicExpCS__Group_1__2__Impl
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
    // InternalMiniOCLCS.g:2880:1: rule__LogicExpCS__Group_1__2__Impl : ( ( rule__LogicExpCS__RightAssignment_1_2 ) ) ;
    public final void rule__LogicExpCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2884:1: ( ( ( rule__LogicExpCS__RightAssignment_1_2 ) ) )
            // InternalMiniOCLCS.g:2885:1: ( ( rule__LogicExpCS__RightAssignment_1_2 ) )
            {
            // InternalMiniOCLCS.g:2885:1: ( ( rule__LogicExpCS__RightAssignment_1_2 ) )
            // InternalMiniOCLCS.g:2886:2: ( rule__LogicExpCS__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getRightAssignment_1_2()); 
            }
            // InternalMiniOCLCS.g:2887:2: ( rule__LogicExpCS__RightAssignment_1_2 )
            // InternalMiniOCLCS.g:2887:3: rule__LogicExpCS__RightAssignment_1_2
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
    // InternalMiniOCLCS.g:2896:1: rule__CallExpCS__Group__0 : rule__CallExpCS__Group__0__Impl rule__CallExpCS__Group__1 ;
    public final void rule__CallExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2900:1: ( rule__CallExpCS__Group__0__Impl rule__CallExpCS__Group__1 )
            // InternalMiniOCLCS.g:2901:2: rule__CallExpCS__Group__0__Impl rule__CallExpCS__Group__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalMiniOCLCS.g:2908:1: rule__CallExpCS__Group__0__Impl : ( rulePrimaryExpCS ) ;
    public final void rule__CallExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2912:1: ( ( rulePrimaryExpCS ) )
            // InternalMiniOCLCS.g:2913:1: ( rulePrimaryExpCS )
            {
            // InternalMiniOCLCS.g:2913:1: ( rulePrimaryExpCS )
            // InternalMiniOCLCS.g:2914:2: rulePrimaryExpCS
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
    // InternalMiniOCLCS.g:2923:1: rule__CallExpCS__Group__1 : rule__CallExpCS__Group__1__Impl ;
    public final void rule__CallExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2927:1: ( rule__CallExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:2928:2: rule__CallExpCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:2934:1: rule__CallExpCS__Group__1__Impl : ( ( rule__CallExpCS__Group_1__0 )* ) ;
    public final void rule__CallExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2938:1: ( ( ( rule__CallExpCS__Group_1__0 )* ) )
            // InternalMiniOCLCS.g:2939:1: ( ( rule__CallExpCS__Group_1__0 )* )
            {
            // InternalMiniOCLCS.g:2939:1: ( ( rule__CallExpCS__Group_1__0 )* )
            // InternalMiniOCLCS.g:2940:2: ( rule__CallExpCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:2941:2: ( rule__CallExpCS__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==17) ) {
                    int LA24_2 = input.LA(2);

                    if ( (synpred30_InternalMiniOCLCS()) ) {
                        alt24=1;
                    }


                }
                else if ( (LA24_0==18) ) {
                    int LA24_3 = input.LA(2);

                    if ( (synpred30_InternalMiniOCLCS()) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2941:3: rule__CallExpCS__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__CallExpCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalMiniOCLCS.g:2950:1: rule__CallExpCS__Group_1__0 : rule__CallExpCS__Group_1__0__Impl rule__CallExpCS__Group_1__1 ;
    public final void rule__CallExpCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2954:1: ( rule__CallExpCS__Group_1__0__Impl rule__CallExpCS__Group_1__1 )
            // InternalMiniOCLCS.g:2955:2: rule__CallExpCS__Group_1__0__Impl rule__CallExpCS__Group_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalMiniOCLCS.g:2962:1: rule__CallExpCS__Group_1__0__Impl : ( () ) ;
    public final void rule__CallExpCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2966:1: ( ( () ) )
            // InternalMiniOCLCS.g:2967:1: ( () )
            {
            // InternalMiniOCLCS.g:2967:1: ( () )
            // InternalMiniOCLCS.g:2968:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getCallExpCSSourceAction_1_0()); 
            }
            // InternalMiniOCLCS.g:2969:2: ()
            // InternalMiniOCLCS.g:2969:3: 
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
    // InternalMiniOCLCS.g:2977:1: rule__CallExpCS__Group_1__1 : rule__CallExpCS__Group_1__1__Impl rule__CallExpCS__Group_1__2 ;
    public final void rule__CallExpCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2981:1: ( rule__CallExpCS__Group_1__1__Impl rule__CallExpCS__Group_1__2 )
            // InternalMiniOCLCS.g:2982:2: rule__CallExpCS__Group_1__1__Impl rule__CallExpCS__Group_1__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalMiniOCLCS.g:2989:1: rule__CallExpCS__Group_1__1__Impl : ( ( rule__CallExpCS__OpAssignment_1_1 ) ) ;
    public final void rule__CallExpCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2993:1: ( ( ( rule__CallExpCS__OpAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:2994:1: ( ( rule__CallExpCS__OpAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:2994:1: ( ( rule__CallExpCS__OpAssignment_1_1 ) )
            // InternalMiniOCLCS.g:2995:2: ( rule__CallExpCS__OpAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getOpAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:2996:2: ( rule__CallExpCS__OpAssignment_1_1 )
            // InternalMiniOCLCS.g:2996:3: rule__CallExpCS__OpAssignment_1_1
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
    // InternalMiniOCLCS.g:3004:1: rule__CallExpCS__Group_1__2 : rule__CallExpCS__Group_1__2__Impl ;
    public final void rule__CallExpCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3008:1: ( rule__CallExpCS__Group_1__2__Impl )
            // InternalMiniOCLCS.g:3009:2: rule__CallExpCS__Group_1__2__Impl
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
    // InternalMiniOCLCS.g:3015:1: rule__CallExpCS__Group_1__2__Impl : ( ( rule__CallExpCS__NavExpAssignment_1_2 ) ) ;
    public final void rule__CallExpCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3019:1: ( ( ( rule__CallExpCS__NavExpAssignment_1_2 ) ) )
            // InternalMiniOCLCS.g:3020:1: ( ( rule__CallExpCS__NavExpAssignment_1_2 ) )
            {
            // InternalMiniOCLCS.g:3020:1: ( ( rule__CallExpCS__NavExpAssignment_1_2 ) )
            // InternalMiniOCLCS.g:3021:2: ( rule__CallExpCS__NavExpAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getNavExpAssignment_1_2()); 
            }
            // InternalMiniOCLCS.g:3022:2: ( rule__CallExpCS__NavExpAssignment_1_2 )
            // InternalMiniOCLCS.g:3022:3: rule__CallExpCS__NavExpAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__CallExpCS__NavExpAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getNavExpAssignment_1_2()); 
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


    // $ANTLR start "rule__SelfExpCS__Group__0"
    // InternalMiniOCLCS.g:3031:1: rule__SelfExpCS__Group__0 : rule__SelfExpCS__Group__0__Impl rule__SelfExpCS__Group__1 ;
    public final void rule__SelfExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3035:1: ( rule__SelfExpCS__Group__0__Impl rule__SelfExpCS__Group__1 )
            // InternalMiniOCLCS.g:3036:2: rule__SelfExpCS__Group__0__Impl rule__SelfExpCS__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__SelfExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__SelfExpCS__Group__1();

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
    // $ANTLR end "rule__SelfExpCS__Group__0"


    // $ANTLR start "rule__SelfExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:3043:1: rule__SelfExpCS__Group__0__Impl : ( () ) ;
    public final void rule__SelfExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3047:1: ( ( () ) )
            // InternalMiniOCLCS.g:3048:1: ( () )
            {
            // InternalMiniOCLCS.g:3048:1: ( () )
            // InternalMiniOCLCS.g:3049:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0()); 
            }
            // InternalMiniOCLCS.g:3050:2: ()
            // InternalMiniOCLCS.g:3050:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfExpCS__Group__0__Impl"


    // $ANTLR start "rule__SelfExpCS__Group__1"
    // InternalMiniOCLCS.g:3058:1: rule__SelfExpCS__Group__1 : rule__SelfExpCS__Group__1__Impl ;
    public final void rule__SelfExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3062:1: ( rule__SelfExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:3063:2: rule__SelfExpCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelfExpCS__Group__1__Impl();

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
    // $ANTLR end "rule__SelfExpCS__Group__1"


    // $ANTLR start "rule__SelfExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:3069:1: rule__SelfExpCS__Group__1__Impl : ( 'self' ) ;
    public final void rule__SelfExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3073:1: ( ( 'self' ) )
            // InternalMiniOCLCS.g:3074:1: ( 'self' )
            {
            // InternalMiniOCLCS.g:3074:1: ( 'self' )
            // InternalMiniOCLCS.g:3075:2: 'self'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfExpCSAccess().getSelfKeyword_1()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getSelfExpCSAccess().getSelfKeyword_1()); 
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
    // $ANTLR end "rule__SelfExpCS__Group__1__Impl"


    // $ANTLR start "rule__CollectExpCS__Group__0"
    // InternalMiniOCLCS.g:3085:1: rule__CollectExpCS__Group__0 : rule__CollectExpCS__Group__0__Impl rule__CollectExpCS__Group__1 ;
    public final void rule__CollectExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3089:1: ( rule__CollectExpCS__Group__0__Impl rule__CollectExpCS__Group__1 )
            // InternalMiniOCLCS.g:3090:2: rule__CollectExpCS__Group__0__Impl rule__CollectExpCS__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__CollectExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__Group__1();

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
    // $ANTLR end "rule__CollectExpCS__Group__0"


    // $ANTLR start "rule__CollectExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:3097:1: rule__CollectExpCS__Group__0__Impl : ( 'collect' ) ;
    public final void rule__CollectExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3101:1: ( ( 'collect' ) )
            // InternalMiniOCLCS.g:3102:1: ( 'collect' )
            {
            // InternalMiniOCLCS.g:3102:1: ( 'collect' )
            // InternalMiniOCLCS.g:3103:2: 'collect'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getCollectKeyword_0()); 
            }
            match(input,38,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getCollectKeyword_0()); 
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
    // $ANTLR end "rule__CollectExpCS__Group__0__Impl"


    // $ANTLR start "rule__CollectExpCS__Group__1"
    // InternalMiniOCLCS.g:3112:1: rule__CollectExpCS__Group__1 : rule__CollectExpCS__Group__1__Impl rule__CollectExpCS__Group__2 ;
    public final void rule__CollectExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3116:1: ( rule__CollectExpCS__Group__1__Impl rule__CollectExpCS__Group__2 )
            // InternalMiniOCLCS.g:3117:2: rule__CollectExpCS__Group__1__Impl rule__CollectExpCS__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__CollectExpCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__Group__2();

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
    // $ANTLR end "rule__CollectExpCS__Group__1"


    // $ANTLR start "rule__CollectExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:3124:1: rule__CollectExpCS__Group__1__Impl : ( '(' ) ;
    public final void rule__CollectExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3128:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:3129:1: ( '(' )
            {
            // InternalMiniOCLCS.g:3129:1: ( '(' )
            // InternalMiniOCLCS.g:3130:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getLeftParenthesisKeyword_1()); 
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
    // $ANTLR end "rule__CollectExpCS__Group__1__Impl"


    // $ANTLR start "rule__CollectExpCS__Group__2"
    // InternalMiniOCLCS.g:3139:1: rule__CollectExpCS__Group__2 : rule__CollectExpCS__Group__2__Impl rule__CollectExpCS__Group__3 ;
    public final void rule__CollectExpCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3143:1: ( rule__CollectExpCS__Group__2__Impl rule__CollectExpCS__Group__3 )
            // InternalMiniOCLCS.g:3144:2: rule__CollectExpCS__Group__2__Impl rule__CollectExpCS__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__CollectExpCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__Group__3();

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
    // $ANTLR end "rule__CollectExpCS__Group__2"


    // $ANTLR start "rule__CollectExpCS__Group__2__Impl"
    // InternalMiniOCLCS.g:3151:1: rule__CollectExpCS__Group__2__Impl : ( ( rule__CollectExpCS__Group_2__0 )? ) ;
    public final void rule__CollectExpCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3155:1: ( ( ( rule__CollectExpCS__Group_2__0 )? ) )
            // InternalMiniOCLCS.g:3156:1: ( ( rule__CollectExpCS__Group_2__0 )? )
            {
            // InternalMiniOCLCS.g:3156:1: ( ( rule__CollectExpCS__Group_2__0 )? )
            // InternalMiniOCLCS.g:3157:2: ( rule__CollectExpCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:3158:2: ( rule__CollectExpCS__Group_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==26||LA25_1==39) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalMiniOCLCS.g:3158:3: rule__CollectExpCS__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CollectExpCS__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getGroup_2()); 
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
    // $ANTLR end "rule__CollectExpCS__Group__2__Impl"


    // $ANTLR start "rule__CollectExpCS__Group__3"
    // InternalMiniOCLCS.g:3166:1: rule__CollectExpCS__Group__3 : rule__CollectExpCS__Group__3__Impl rule__CollectExpCS__Group__4 ;
    public final void rule__CollectExpCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3170:1: ( rule__CollectExpCS__Group__3__Impl rule__CollectExpCS__Group__4 )
            // InternalMiniOCLCS.g:3171:2: rule__CollectExpCS__Group__3__Impl rule__CollectExpCS__Group__4
            {
            pushFollow(FOLLOW_33);
            rule__CollectExpCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__Group__4();

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
    // $ANTLR end "rule__CollectExpCS__Group__3"


    // $ANTLR start "rule__CollectExpCS__Group__3__Impl"
    // InternalMiniOCLCS.g:3178:1: rule__CollectExpCS__Group__3__Impl : ( ( rule__CollectExpCS__ExpAssignment_3 ) ) ;
    public final void rule__CollectExpCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3182:1: ( ( ( rule__CollectExpCS__ExpAssignment_3 ) ) )
            // InternalMiniOCLCS.g:3183:1: ( ( rule__CollectExpCS__ExpAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:3183:1: ( ( rule__CollectExpCS__ExpAssignment_3 ) )
            // InternalMiniOCLCS.g:3184:2: ( rule__CollectExpCS__ExpAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getExpAssignment_3()); 
            }
            // InternalMiniOCLCS.g:3185:2: ( rule__CollectExpCS__ExpAssignment_3 )
            // InternalMiniOCLCS.g:3185:3: rule__CollectExpCS__ExpAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__ExpAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getExpAssignment_3()); 
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
    // $ANTLR end "rule__CollectExpCS__Group__3__Impl"


    // $ANTLR start "rule__CollectExpCS__Group__4"
    // InternalMiniOCLCS.g:3193:1: rule__CollectExpCS__Group__4 : rule__CollectExpCS__Group__4__Impl ;
    public final void rule__CollectExpCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3197:1: ( rule__CollectExpCS__Group__4__Impl )
            // InternalMiniOCLCS.g:3198:2: rule__CollectExpCS__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__Group__4__Impl();

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
    // $ANTLR end "rule__CollectExpCS__Group__4"


    // $ANTLR start "rule__CollectExpCS__Group__4__Impl"
    // InternalMiniOCLCS.g:3204:1: rule__CollectExpCS__Group__4__Impl : ( ')' ) ;
    public final void rule__CollectExpCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3208:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:3209:1: ( ')' )
            {
            // InternalMiniOCLCS.g:3209:1: ( ')' )
            // InternalMiniOCLCS.g:3210:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getRightParenthesisKeyword_4()); 
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
    // $ANTLR end "rule__CollectExpCS__Group__4__Impl"


    // $ANTLR start "rule__CollectExpCS__Group_2__0"
    // InternalMiniOCLCS.g:3220:1: rule__CollectExpCS__Group_2__0 : rule__CollectExpCS__Group_2__0__Impl rule__CollectExpCS__Group_2__1 ;
    public final void rule__CollectExpCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3224:1: ( rule__CollectExpCS__Group_2__0__Impl rule__CollectExpCS__Group_2__1 )
            // InternalMiniOCLCS.g:3225:2: rule__CollectExpCS__Group_2__0__Impl rule__CollectExpCS__Group_2__1
            {
            pushFollow(FOLLOW_34);
            rule__CollectExpCS__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__Group_2__1();

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
    // $ANTLR end "rule__CollectExpCS__Group_2__0"


    // $ANTLR start "rule__CollectExpCS__Group_2__0__Impl"
    // InternalMiniOCLCS.g:3232:1: rule__CollectExpCS__Group_2__0__Impl : ( ( rule__CollectExpCS__ItVarAssignment_2_0 ) ) ;
    public final void rule__CollectExpCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3236:1: ( ( ( rule__CollectExpCS__ItVarAssignment_2_0 ) ) )
            // InternalMiniOCLCS.g:3237:1: ( ( rule__CollectExpCS__ItVarAssignment_2_0 ) )
            {
            // InternalMiniOCLCS.g:3237:1: ( ( rule__CollectExpCS__ItVarAssignment_2_0 ) )
            // InternalMiniOCLCS.g:3238:2: ( rule__CollectExpCS__ItVarAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getItVarAssignment_2_0()); 
            }
            // InternalMiniOCLCS.g:3239:2: ( rule__CollectExpCS__ItVarAssignment_2_0 )
            // InternalMiniOCLCS.g:3239:3: rule__CollectExpCS__ItVarAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__ItVarAssignment_2_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getItVarAssignment_2_0()); 
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
    // $ANTLR end "rule__CollectExpCS__Group_2__0__Impl"


    // $ANTLR start "rule__CollectExpCS__Group_2__1"
    // InternalMiniOCLCS.g:3247:1: rule__CollectExpCS__Group_2__1 : rule__CollectExpCS__Group_2__1__Impl ;
    public final void rule__CollectExpCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3251:1: ( rule__CollectExpCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:3252:2: rule__CollectExpCS__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectExpCS__Group_2__1__Impl();

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
    // $ANTLR end "rule__CollectExpCS__Group_2__1"


    // $ANTLR start "rule__CollectExpCS__Group_2__1__Impl"
    // InternalMiniOCLCS.g:3258:1: rule__CollectExpCS__Group_2__1__Impl : ( '|' ) ;
    public final void rule__CollectExpCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3262:1: ( ( '|' ) )
            // InternalMiniOCLCS.g:3263:1: ( '|' )
            {
            // InternalMiniOCLCS.g:3263:1: ( '|' )
            // InternalMiniOCLCS.g:3264:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getVerticalLineKeyword_2_1()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getVerticalLineKeyword_2_1()); 
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
    // $ANTLR end "rule__CollectExpCS__Group_2__1__Impl"


    // $ANTLR start "rule__IteratorVarCS__Group__0"
    // InternalMiniOCLCS.g:3274:1: rule__IteratorVarCS__Group__0 : rule__IteratorVarCS__Group__0__Impl rule__IteratorVarCS__Group__1 ;
    public final void rule__IteratorVarCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3278:1: ( rule__IteratorVarCS__Group__0__Impl rule__IteratorVarCS__Group__1 )
            // InternalMiniOCLCS.g:3279:2: rule__IteratorVarCS__Group__0__Impl rule__IteratorVarCS__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__IteratorVarCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IteratorVarCS__Group__1();

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
    // $ANTLR end "rule__IteratorVarCS__Group__0"


    // $ANTLR start "rule__IteratorVarCS__Group__0__Impl"
    // InternalMiniOCLCS.g:3286:1: rule__IteratorVarCS__Group__0__Impl : ( ( rule__IteratorVarCS__ItNameAssignment_0 ) ) ;
    public final void rule__IteratorVarCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3290:1: ( ( ( rule__IteratorVarCS__ItNameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:3291:1: ( ( rule__IteratorVarCS__ItNameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:3291:1: ( ( rule__IteratorVarCS__ItNameAssignment_0 ) )
            // InternalMiniOCLCS.g:3292:2: ( rule__IteratorVarCS__ItNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getItNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:3293:2: ( rule__IteratorVarCS__ItNameAssignment_0 )
            // InternalMiniOCLCS.g:3293:3: rule__IteratorVarCS__ItNameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__IteratorVarCS__ItNameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIteratorVarCSAccess().getItNameAssignment_0()); 
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
    // $ANTLR end "rule__IteratorVarCS__Group__0__Impl"


    // $ANTLR start "rule__IteratorVarCS__Group__1"
    // InternalMiniOCLCS.g:3301:1: rule__IteratorVarCS__Group__1 : rule__IteratorVarCS__Group__1__Impl ;
    public final void rule__IteratorVarCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3305:1: ( rule__IteratorVarCS__Group__1__Impl )
            // InternalMiniOCLCS.g:3306:2: rule__IteratorVarCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IteratorVarCS__Group__1__Impl();

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
    // $ANTLR end "rule__IteratorVarCS__Group__1"


    // $ANTLR start "rule__IteratorVarCS__Group__1__Impl"
    // InternalMiniOCLCS.g:3312:1: rule__IteratorVarCS__Group__1__Impl : ( ( rule__IteratorVarCS__Group_1__0 )? ) ;
    public final void rule__IteratorVarCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3316:1: ( ( ( rule__IteratorVarCS__Group_1__0 )? ) )
            // InternalMiniOCLCS.g:3317:1: ( ( rule__IteratorVarCS__Group_1__0 )? )
            {
            // InternalMiniOCLCS.g:3317:1: ( ( rule__IteratorVarCS__Group_1__0 )? )
            // InternalMiniOCLCS.g:3318:2: ( rule__IteratorVarCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:3319:2: ( rule__IteratorVarCS__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==26) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMiniOCLCS.g:3319:3: rule__IteratorVarCS__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IteratorVarCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIteratorVarCSAccess().getGroup_1()); 
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
    // $ANTLR end "rule__IteratorVarCS__Group__1__Impl"


    // $ANTLR start "rule__IteratorVarCS__Group_1__0"
    // InternalMiniOCLCS.g:3328:1: rule__IteratorVarCS__Group_1__0 : rule__IteratorVarCS__Group_1__0__Impl rule__IteratorVarCS__Group_1__1 ;
    public final void rule__IteratorVarCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3332:1: ( rule__IteratorVarCS__Group_1__0__Impl rule__IteratorVarCS__Group_1__1 )
            // InternalMiniOCLCS.g:3333:2: rule__IteratorVarCS__Group_1__0__Impl rule__IteratorVarCS__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__IteratorVarCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IteratorVarCS__Group_1__1();

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
    // $ANTLR end "rule__IteratorVarCS__Group_1__0"


    // $ANTLR start "rule__IteratorVarCS__Group_1__0__Impl"
    // InternalMiniOCLCS.g:3340:1: rule__IteratorVarCS__Group_1__0__Impl : ( ':' ) ;
    public final void rule__IteratorVarCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3344:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:3345:1: ( ':' )
            {
            // InternalMiniOCLCS.g:3345:1: ( ':' )
            // InternalMiniOCLCS.g:3346:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getColonKeyword_1_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIteratorVarCSAccess().getColonKeyword_1_0()); 
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
    // $ANTLR end "rule__IteratorVarCS__Group_1__0__Impl"


    // $ANTLR start "rule__IteratorVarCS__Group_1__1"
    // InternalMiniOCLCS.g:3355:1: rule__IteratorVarCS__Group_1__1 : rule__IteratorVarCS__Group_1__1__Impl ;
    public final void rule__IteratorVarCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3359:1: ( rule__IteratorVarCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:3360:2: rule__IteratorVarCS__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IteratorVarCS__Group_1__1__Impl();

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
    // $ANTLR end "rule__IteratorVarCS__Group_1__1"


    // $ANTLR start "rule__IteratorVarCS__Group_1__1__Impl"
    // InternalMiniOCLCS.g:3366:1: rule__IteratorVarCS__Group_1__1__Impl : ( ( rule__IteratorVarCS__ItTypeAssignment_1_1 ) ) ;
    public final void rule__IteratorVarCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3370:1: ( ( ( rule__IteratorVarCS__ItTypeAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:3371:1: ( ( rule__IteratorVarCS__ItTypeAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:3371:1: ( ( rule__IteratorVarCS__ItTypeAssignment_1_1 ) )
            // InternalMiniOCLCS.g:3372:2: ( rule__IteratorVarCS__ItTypeAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getItTypeAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:3373:2: ( rule__IteratorVarCS__ItTypeAssignment_1_1 )
            // InternalMiniOCLCS.g:3373:3: rule__IteratorVarCS__ItTypeAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__IteratorVarCS__ItTypeAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIteratorVarCSAccess().getItTypeAssignment_1_1()); 
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
    // $ANTLR end "rule__IteratorVarCS__Group_1__1__Impl"


    // $ANTLR start "rule__IterateExpCS__Group__0"
    // InternalMiniOCLCS.g:3382:1: rule__IterateExpCS__Group__0 : rule__IterateExpCS__Group__0__Impl rule__IterateExpCS__Group__1 ;
    public final void rule__IterateExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3386:1: ( rule__IterateExpCS__Group__0__Impl rule__IterateExpCS__Group__1 )
            // InternalMiniOCLCS.g:3387:2: rule__IterateExpCS__Group__0__Impl rule__IterateExpCS__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__IterateExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__Group__1();

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
    // $ANTLR end "rule__IterateExpCS__Group__0"


    // $ANTLR start "rule__IterateExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:3394:1: rule__IterateExpCS__Group__0__Impl : ( 'iterate' ) ;
    public final void rule__IterateExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3398:1: ( ( 'iterate' ) )
            // InternalMiniOCLCS.g:3399:1: ( 'iterate' )
            {
            // InternalMiniOCLCS.g:3399:1: ( 'iterate' )
            // InternalMiniOCLCS.g:3400:2: 'iterate'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getIterateKeyword_0()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getIterateKeyword_0()); 
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
    // $ANTLR end "rule__IterateExpCS__Group__0__Impl"


    // $ANTLR start "rule__IterateExpCS__Group__1"
    // InternalMiniOCLCS.g:3409:1: rule__IterateExpCS__Group__1 : rule__IterateExpCS__Group__1__Impl rule__IterateExpCS__Group__2 ;
    public final void rule__IterateExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3413:1: ( rule__IterateExpCS__Group__1__Impl rule__IterateExpCS__Group__2 )
            // InternalMiniOCLCS.g:3414:2: rule__IterateExpCS__Group__1__Impl rule__IterateExpCS__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__IterateExpCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__Group__2();

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
    // $ANTLR end "rule__IterateExpCS__Group__1"


    // $ANTLR start "rule__IterateExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:3421:1: rule__IterateExpCS__Group__1__Impl : ( '(' ) ;
    public final void rule__IterateExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3425:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:3426:1: ( '(' )
            {
            // InternalMiniOCLCS.g:3426:1: ( '(' )
            // InternalMiniOCLCS.g:3427:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getLeftParenthesisKeyword_1()); 
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
    // $ANTLR end "rule__IterateExpCS__Group__1__Impl"


    // $ANTLR start "rule__IterateExpCS__Group__2"
    // InternalMiniOCLCS.g:3436:1: rule__IterateExpCS__Group__2 : rule__IterateExpCS__Group__2__Impl rule__IterateExpCS__Group__3 ;
    public final void rule__IterateExpCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3440:1: ( rule__IterateExpCS__Group__2__Impl rule__IterateExpCS__Group__3 )
            // InternalMiniOCLCS.g:3441:2: rule__IterateExpCS__Group__2__Impl rule__IterateExpCS__Group__3
            {
            pushFollow(FOLLOW_13);
            rule__IterateExpCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__Group__3();

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
    // $ANTLR end "rule__IterateExpCS__Group__2"


    // $ANTLR start "rule__IterateExpCS__Group__2__Impl"
    // InternalMiniOCLCS.g:3448:1: rule__IterateExpCS__Group__2__Impl : ( ( rule__IterateExpCS__ItVarAssignment_2 ) ) ;
    public final void rule__IterateExpCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3452:1: ( ( ( rule__IterateExpCS__ItVarAssignment_2 ) ) )
            // InternalMiniOCLCS.g:3453:1: ( ( rule__IterateExpCS__ItVarAssignment_2 ) )
            {
            // InternalMiniOCLCS.g:3453:1: ( ( rule__IterateExpCS__ItVarAssignment_2 ) )
            // InternalMiniOCLCS.g:3454:2: ( rule__IterateExpCS__ItVarAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getItVarAssignment_2()); 
            }
            // InternalMiniOCLCS.g:3455:2: ( rule__IterateExpCS__ItVarAssignment_2 )
            // InternalMiniOCLCS.g:3455:3: rule__IterateExpCS__ItVarAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__ItVarAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getItVarAssignment_2()); 
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
    // $ANTLR end "rule__IterateExpCS__Group__2__Impl"


    // $ANTLR start "rule__IterateExpCS__Group__3"
    // InternalMiniOCLCS.g:3463:1: rule__IterateExpCS__Group__3 : rule__IterateExpCS__Group__3__Impl rule__IterateExpCS__Group__4 ;
    public final void rule__IterateExpCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3467:1: ( rule__IterateExpCS__Group__3__Impl rule__IterateExpCS__Group__4 )
            // InternalMiniOCLCS.g:3468:2: rule__IterateExpCS__Group__3__Impl rule__IterateExpCS__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__IterateExpCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__Group__4();

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
    // $ANTLR end "rule__IterateExpCS__Group__3"


    // $ANTLR start "rule__IterateExpCS__Group__3__Impl"
    // InternalMiniOCLCS.g:3475:1: rule__IterateExpCS__Group__3__Impl : ( ';' ) ;
    public final void rule__IterateExpCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3479:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:3480:1: ( ';' )
            {
            // InternalMiniOCLCS.g:3480:1: ( ';' )
            // InternalMiniOCLCS.g:3481:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getSemicolonKeyword_3()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getSemicolonKeyword_3()); 
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
    // $ANTLR end "rule__IterateExpCS__Group__3__Impl"


    // $ANTLR start "rule__IterateExpCS__Group__4"
    // InternalMiniOCLCS.g:3490:1: rule__IterateExpCS__Group__4 : rule__IterateExpCS__Group__4__Impl rule__IterateExpCS__Group__5 ;
    public final void rule__IterateExpCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3494:1: ( rule__IterateExpCS__Group__4__Impl rule__IterateExpCS__Group__5 )
            // InternalMiniOCLCS.g:3495:2: rule__IterateExpCS__Group__4__Impl rule__IterateExpCS__Group__5
            {
            pushFollow(FOLLOW_34);
            rule__IterateExpCS__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__Group__5();

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
    // $ANTLR end "rule__IterateExpCS__Group__4"


    // $ANTLR start "rule__IterateExpCS__Group__4__Impl"
    // InternalMiniOCLCS.g:3502:1: rule__IterateExpCS__Group__4__Impl : ( ( rule__IterateExpCS__AccVarAssignment_4 ) ) ;
    public final void rule__IterateExpCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3506:1: ( ( ( rule__IterateExpCS__AccVarAssignment_4 ) ) )
            // InternalMiniOCLCS.g:3507:1: ( ( rule__IterateExpCS__AccVarAssignment_4 ) )
            {
            // InternalMiniOCLCS.g:3507:1: ( ( rule__IterateExpCS__AccVarAssignment_4 ) )
            // InternalMiniOCLCS.g:3508:2: ( rule__IterateExpCS__AccVarAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getAccVarAssignment_4()); 
            }
            // InternalMiniOCLCS.g:3509:2: ( rule__IterateExpCS__AccVarAssignment_4 )
            // InternalMiniOCLCS.g:3509:3: rule__IterateExpCS__AccVarAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__AccVarAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getAccVarAssignment_4()); 
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
    // $ANTLR end "rule__IterateExpCS__Group__4__Impl"


    // $ANTLR start "rule__IterateExpCS__Group__5"
    // InternalMiniOCLCS.g:3517:1: rule__IterateExpCS__Group__5 : rule__IterateExpCS__Group__5__Impl rule__IterateExpCS__Group__6 ;
    public final void rule__IterateExpCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3521:1: ( rule__IterateExpCS__Group__5__Impl rule__IterateExpCS__Group__6 )
            // InternalMiniOCLCS.g:3522:2: rule__IterateExpCS__Group__5__Impl rule__IterateExpCS__Group__6
            {
            pushFollow(FOLLOW_22);
            rule__IterateExpCS__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__Group__6();

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
    // $ANTLR end "rule__IterateExpCS__Group__5"


    // $ANTLR start "rule__IterateExpCS__Group__5__Impl"
    // InternalMiniOCLCS.g:3529:1: rule__IterateExpCS__Group__5__Impl : ( '|' ) ;
    public final void rule__IterateExpCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3533:1: ( ( '|' ) )
            // InternalMiniOCLCS.g:3534:1: ( '|' )
            {
            // InternalMiniOCLCS.g:3534:1: ( '|' )
            // InternalMiniOCLCS.g:3535:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getVerticalLineKeyword_5()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getVerticalLineKeyword_5()); 
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
    // $ANTLR end "rule__IterateExpCS__Group__5__Impl"


    // $ANTLR start "rule__IterateExpCS__Group__6"
    // InternalMiniOCLCS.g:3544:1: rule__IterateExpCS__Group__6 : rule__IterateExpCS__Group__6__Impl rule__IterateExpCS__Group__7 ;
    public final void rule__IterateExpCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3548:1: ( rule__IterateExpCS__Group__6__Impl rule__IterateExpCS__Group__7 )
            // InternalMiniOCLCS.g:3549:2: rule__IterateExpCS__Group__6__Impl rule__IterateExpCS__Group__7
            {
            pushFollow(FOLLOW_33);
            rule__IterateExpCS__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__Group__7();

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
    // $ANTLR end "rule__IterateExpCS__Group__6"


    // $ANTLR start "rule__IterateExpCS__Group__6__Impl"
    // InternalMiniOCLCS.g:3556:1: rule__IterateExpCS__Group__6__Impl : ( ( rule__IterateExpCS__ExpAssignment_6 ) ) ;
    public final void rule__IterateExpCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3560:1: ( ( ( rule__IterateExpCS__ExpAssignment_6 ) ) )
            // InternalMiniOCLCS.g:3561:1: ( ( rule__IterateExpCS__ExpAssignment_6 ) )
            {
            // InternalMiniOCLCS.g:3561:1: ( ( rule__IterateExpCS__ExpAssignment_6 ) )
            // InternalMiniOCLCS.g:3562:2: ( rule__IterateExpCS__ExpAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getExpAssignment_6()); 
            }
            // InternalMiniOCLCS.g:3563:2: ( rule__IterateExpCS__ExpAssignment_6 )
            // InternalMiniOCLCS.g:3563:3: rule__IterateExpCS__ExpAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__ExpAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getExpAssignment_6()); 
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
    // $ANTLR end "rule__IterateExpCS__Group__6__Impl"


    // $ANTLR start "rule__IterateExpCS__Group__7"
    // InternalMiniOCLCS.g:3571:1: rule__IterateExpCS__Group__7 : rule__IterateExpCS__Group__7__Impl ;
    public final void rule__IterateExpCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3575:1: ( rule__IterateExpCS__Group__7__Impl )
            // InternalMiniOCLCS.g:3576:2: rule__IterateExpCS__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IterateExpCS__Group__7__Impl();

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
    // $ANTLR end "rule__IterateExpCS__Group__7"


    // $ANTLR start "rule__IterateExpCS__Group__7__Impl"
    // InternalMiniOCLCS.g:3582:1: rule__IterateExpCS__Group__7__Impl : ( ')' ) ;
    public final void rule__IterateExpCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3586:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:3587:1: ( ')' )
            {
            // InternalMiniOCLCS.g:3587:1: ( ')' )
            // InternalMiniOCLCS.g:3588:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getRightParenthesisKeyword_7()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getRightParenthesisKeyword_7()); 
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
    // $ANTLR end "rule__IterateExpCS__Group__7__Impl"


    // $ANTLR start "rule__AccVarCS__Group__0"
    // InternalMiniOCLCS.g:3598:1: rule__AccVarCS__Group__0 : rule__AccVarCS__Group__0__Impl rule__AccVarCS__Group__1 ;
    public final void rule__AccVarCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3602:1: ( rule__AccVarCS__Group__0__Impl rule__AccVarCS__Group__1 )
            // InternalMiniOCLCS.g:3603:2: rule__AccVarCS__Group__0__Impl rule__AccVarCS__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__AccVarCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AccVarCS__Group__1();

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
    // $ANTLR end "rule__AccVarCS__Group__0"


    // $ANTLR start "rule__AccVarCS__Group__0__Impl"
    // InternalMiniOCLCS.g:3610:1: rule__AccVarCS__Group__0__Impl : ( ( rule__AccVarCS__AccNameAssignment_0 ) ) ;
    public final void rule__AccVarCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3614:1: ( ( ( rule__AccVarCS__AccNameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:3615:1: ( ( rule__AccVarCS__AccNameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:3615:1: ( ( rule__AccVarCS__AccNameAssignment_0 ) )
            // InternalMiniOCLCS.g:3616:2: ( rule__AccVarCS__AccNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getAccNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:3617:2: ( rule__AccVarCS__AccNameAssignment_0 )
            // InternalMiniOCLCS.g:3617:3: rule__AccVarCS__AccNameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AccVarCS__AccNameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getAccNameAssignment_0()); 
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
    // $ANTLR end "rule__AccVarCS__Group__0__Impl"


    // $ANTLR start "rule__AccVarCS__Group__1"
    // InternalMiniOCLCS.g:3625:1: rule__AccVarCS__Group__1 : rule__AccVarCS__Group__1__Impl rule__AccVarCS__Group__2 ;
    public final void rule__AccVarCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3629:1: ( rule__AccVarCS__Group__1__Impl rule__AccVarCS__Group__2 )
            // InternalMiniOCLCS.g:3630:2: rule__AccVarCS__Group__1__Impl rule__AccVarCS__Group__2
            {
            pushFollow(FOLLOW_35);
            rule__AccVarCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AccVarCS__Group__2();

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
    // $ANTLR end "rule__AccVarCS__Group__1"


    // $ANTLR start "rule__AccVarCS__Group__1__Impl"
    // InternalMiniOCLCS.g:3637:1: rule__AccVarCS__Group__1__Impl : ( ( rule__AccVarCS__Group_1__0 )? ) ;
    public final void rule__AccVarCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3641:1: ( ( ( rule__AccVarCS__Group_1__0 )? ) )
            // InternalMiniOCLCS.g:3642:1: ( ( rule__AccVarCS__Group_1__0 )? )
            {
            // InternalMiniOCLCS.g:3642:1: ( ( rule__AccVarCS__Group_1__0 )? )
            // InternalMiniOCLCS.g:3643:2: ( rule__AccVarCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:3644:2: ( rule__AccVarCS__Group_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==26) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMiniOCLCS.g:3644:3: rule__AccVarCS__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AccVarCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getGroup_1()); 
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
    // $ANTLR end "rule__AccVarCS__Group__1__Impl"


    // $ANTLR start "rule__AccVarCS__Group__2"
    // InternalMiniOCLCS.g:3652:1: rule__AccVarCS__Group__2 : rule__AccVarCS__Group__2__Impl rule__AccVarCS__Group__3 ;
    public final void rule__AccVarCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3656:1: ( rule__AccVarCS__Group__2__Impl rule__AccVarCS__Group__3 )
            // InternalMiniOCLCS.g:3657:2: rule__AccVarCS__Group__2__Impl rule__AccVarCS__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__AccVarCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AccVarCS__Group__3();

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
    // $ANTLR end "rule__AccVarCS__Group__2"


    // $ANTLR start "rule__AccVarCS__Group__2__Impl"
    // InternalMiniOCLCS.g:3664:1: rule__AccVarCS__Group__2__Impl : ( '=' ) ;
    public final void rule__AccVarCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3668:1: ( ( '=' ) )
            // InternalMiniOCLCS.g:3669:1: ( '=' )
            {
            // InternalMiniOCLCS.g:3669:1: ( '=' )
            // InternalMiniOCLCS.g:3670:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getEqualsSignKeyword_2()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getEqualsSignKeyword_2()); 
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
    // $ANTLR end "rule__AccVarCS__Group__2__Impl"


    // $ANTLR start "rule__AccVarCS__Group__3"
    // InternalMiniOCLCS.g:3679:1: rule__AccVarCS__Group__3 : rule__AccVarCS__Group__3__Impl ;
    public final void rule__AccVarCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3683:1: ( rule__AccVarCS__Group__3__Impl )
            // InternalMiniOCLCS.g:3684:2: rule__AccVarCS__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AccVarCS__Group__3__Impl();

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
    // $ANTLR end "rule__AccVarCS__Group__3"


    // $ANTLR start "rule__AccVarCS__Group__3__Impl"
    // InternalMiniOCLCS.g:3690:1: rule__AccVarCS__Group__3__Impl : ( ( rule__AccVarCS__AccInitExpAssignment_3 ) ) ;
    public final void rule__AccVarCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3694:1: ( ( ( rule__AccVarCS__AccInitExpAssignment_3 ) ) )
            // InternalMiniOCLCS.g:3695:1: ( ( rule__AccVarCS__AccInitExpAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:3695:1: ( ( rule__AccVarCS__AccInitExpAssignment_3 ) )
            // InternalMiniOCLCS.g:3696:2: ( rule__AccVarCS__AccInitExpAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getAccInitExpAssignment_3()); 
            }
            // InternalMiniOCLCS.g:3697:2: ( rule__AccVarCS__AccInitExpAssignment_3 )
            // InternalMiniOCLCS.g:3697:3: rule__AccVarCS__AccInitExpAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__AccVarCS__AccInitExpAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getAccInitExpAssignment_3()); 
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
    // $ANTLR end "rule__AccVarCS__Group__3__Impl"


    // $ANTLR start "rule__AccVarCS__Group_1__0"
    // InternalMiniOCLCS.g:3706:1: rule__AccVarCS__Group_1__0 : rule__AccVarCS__Group_1__0__Impl rule__AccVarCS__Group_1__1 ;
    public final void rule__AccVarCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3710:1: ( rule__AccVarCS__Group_1__0__Impl rule__AccVarCS__Group_1__1 )
            // InternalMiniOCLCS.g:3711:2: rule__AccVarCS__Group_1__0__Impl rule__AccVarCS__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__AccVarCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__AccVarCS__Group_1__1();

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
    // $ANTLR end "rule__AccVarCS__Group_1__0"


    // $ANTLR start "rule__AccVarCS__Group_1__0__Impl"
    // InternalMiniOCLCS.g:3718:1: rule__AccVarCS__Group_1__0__Impl : ( ':' ) ;
    public final void rule__AccVarCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3722:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:3723:1: ( ':' )
            {
            // InternalMiniOCLCS.g:3723:1: ( ':' )
            // InternalMiniOCLCS.g:3724:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getColonKeyword_1_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getColonKeyword_1_0()); 
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
    // $ANTLR end "rule__AccVarCS__Group_1__0__Impl"


    // $ANTLR start "rule__AccVarCS__Group_1__1"
    // InternalMiniOCLCS.g:3733:1: rule__AccVarCS__Group_1__1 : rule__AccVarCS__Group_1__1__Impl ;
    public final void rule__AccVarCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3737:1: ( rule__AccVarCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:3738:2: rule__AccVarCS__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AccVarCS__Group_1__1__Impl();

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
    // $ANTLR end "rule__AccVarCS__Group_1__1"


    // $ANTLR start "rule__AccVarCS__Group_1__1__Impl"
    // InternalMiniOCLCS.g:3744:1: rule__AccVarCS__Group_1__1__Impl : ( ( rule__AccVarCS__AccTypeAssignment_1_1 ) ) ;
    public final void rule__AccVarCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3748:1: ( ( ( rule__AccVarCS__AccTypeAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:3749:1: ( ( rule__AccVarCS__AccTypeAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:3749:1: ( ( rule__AccVarCS__AccTypeAssignment_1_1 ) )
            // InternalMiniOCLCS.g:3750:2: ( rule__AccVarCS__AccTypeAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getAccTypeAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:3751:2: ( rule__AccVarCS__AccTypeAssignment_1_1 )
            // InternalMiniOCLCS.g:3751:3: rule__AccVarCS__AccTypeAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AccVarCS__AccTypeAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getAccTypeAssignment_1_1()); 
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
    // $ANTLR end "rule__AccVarCS__Group_1__1__Impl"


    // $ANTLR start "rule__NameExpCS__Group__0"
    // InternalMiniOCLCS.g:3760:1: rule__NameExpCS__Group__0 : rule__NameExpCS__Group__0__Impl rule__NameExpCS__Group__1 ;
    public final void rule__NameExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3764:1: ( rule__NameExpCS__Group__0__Impl rule__NameExpCS__Group__1 )
            // InternalMiniOCLCS.g:3765:2: rule__NameExpCS__Group__0__Impl rule__NameExpCS__Group__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalMiniOCLCS.g:3772:1: rule__NameExpCS__Group__0__Impl : ( ( rule__NameExpCS__ExpNameAssignment_0 ) ) ;
    public final void rule__NameExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3776:1: ( ( ( rule__NameExpCS__ExpNameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:3777:1: ( ( rule__NameExpCS__ExpNameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:3777:1: ( ( rule__NameExpCS__ExpNameAssignment_0 ) )
            // InternalMiniOCLCS.g:3778:2: ( rule__NameExpCS__ExpNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getExpNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:3779:2: ( rule__NameExpCS__ExpNameAssignment_0 )
            // InternalMiniOCLCS.g:3779:3: rule__NameExpCS__ExpNameAssignment_0
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
    // InternalMiniOCLCS.g:3787:1: rule__NameExpCS__Group__1 : rule__NameExpCS__Group__1__Impl ;
    public final void rule__NameExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3791:1: ( rule__NameExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:3792:2: rule__NameExpCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:3798:1: rule__NameExpCS__Group__1__Impl : ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? ) ;
    public final void rule__NameExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3802:1: ( ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? ) )
            // InternalMiniOCLCS.g:3803:1: ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? )
            {
            // InternalMiniOCLCS.g:3803:1: ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? )
            // InternalMiniOCLCS.g:3804:2: ( rule__NameExpCS__RoundedBracketsAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getRoundedBracketsAssignment_1()); 
            }
            // InternalMiniOCLCS.g:3805:2: ( rule__NameExpCS__RoundedBracketsAssignment_1 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==32) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMiniOCLCS.g:3805:3: rule__NameExpCS__RoundedBracketsAssignment_1
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
    // InternalMiniOCLCS.g:3814:1: rule__RoundedBracketClauseCS__Group__0 : rule__RoundedBracketClauseCS__Group__0__Impl rule__RoundedBracketClauseCS__Group__1 ;
    public final void rule__RoundedBracketClauseCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3818:1: ( rule__RoundedBracketClauseCS__Group__0__Impl rule__RoundedBracketClauseCS__Group__1 )
            // InternalMiniOCLCS.g:3819:2: rule__RoundedBracketClauseCS__Group__0__Impl rule__RoundedBracketClauseCS__Group__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalMiniOCLCS.g:3826:1: rule__RoundedBracketClauseCS__Group__0__Impl : ( () ) ;
    public final void rule__RoundedBracketClauseCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3830:1: ( ( () ) )
            // InternalMiniOCLCS.g:3831:1: ( () )
            {
            // InternalMiniOCLCS.g:3831:1: ( () )
            // InternalMiniOCLCS.g:3832:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getRoundedBracketClauseCSAction_0()); 
            }
            // InternalMiniOCLCS.g:3833:2: ()
            // InternalMiniOCLCS.g:3833:3: 
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
    // InternalMiniOCLCS.g:3841:1: rule__RoundedBracketClauseCS__Group__1 : rule__RoundedBracketClauseCS__Group__1__Impl rule__RoundedBracketClauseCS__Group__2 ;
    public final void rule__RoundedBracketClauseCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3845:1: ( rule__RoundedBracketClauseCS__Group__1__Impl rule__RoundedBracketClauseCS__Group__2 )
            // InternalMiniOCLCS.g:3846:2: rule__RoundedBracketClauseCS__Group__1__Impl rule__RoundedBracketClauseCS__Group__2
            {
            pushFollow(FOLLOW_36);
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
    // InternalMiniOCLCS.g:3853:1: rule__RoundedBracketClauseCS__Group__1__Impl : ( '(' ) ;
    public final void rule__RoundedBracketClauseCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3857:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:3858:1: ( '(' )
            {
            // InternalMiniOCLCS.g:3858:1: ( '(' )
            // InternalMiniOCLCS.g:3859:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3868:1: rule__RoundedBracketClauseCS__Group__2 : rule__RoundedBracketClauseCS__Group__2__Impl rule__RoundedBracketClauseCS__Group__3 ;
    public final void rule__RoundedBracketClauseCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3872:1: ( rule__RoundedBracketClauseCS__Group__2__Impl rule__RoundedBracketClauseCS__Group__3 )
            // InternalMiniOCLCS.g:3873:2: rule__RoundedBracketClauseCS__Group__2__Impl rule__RoundedBracketClauseCS__Group__3
            {
            pushFollow(FOLLOW_36);
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
    // InternalMiniOCLCS.g:3880:1: rule__RoundedBracketClauseCS__Group__2__Impl : ( ( rule__RoundedBracketClauseCS__Group_2__0 )? ) ;
    public final void rule__RoundedBracketClauseCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3884:1: ( ( ( rule__RoundedBracketClauseCS__Group_2__0 )? ) )
            // InternalMiniOCLCS.g:3885:1: ( ( rule__RoundedBracketClauseCS__Group_2__0 )? )
            {
            // InternalMiniOCLCS.g:3885:1: ( ( rule__RoundedBracketClauseCS__Group_2__0 )? )
            // InternalMiniOCLCS.g:3886:2: ( rule__RoundedBracketClauseCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:3887:2: ( rule__RoundedBracketClauseCS__Group_2__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID||LA29_0==RULE_INT||LA29_0==11||LA29_0==19||LA29_0==37||(LA29_0>=41 && LA29_0<=42)||LA29_0==47) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMiniOCLCS.g:3887:3: rule__RoundedBracketClauseCS__Group_2__0
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
    // InternalMiniOCLCS.g:3895:1: rule__RoundedBracketClauseCS__Group__3 : rule__RoundedBracketClauseCS__Group__3__Impl ;
    public final void rule__RoundedBracketClauseCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3899:1: ( rule__RoundedBracketClauseCS__Group__3__Impl )
            // InternalMiniOCLCS.g:3900:2: rule__RoundedBracketClauseCS__Group__3__Impl
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
    // InternalMiniOCLCS.g:3906:1: rule__RoundedBracketClauseCS__Group__3__Impl : ( ')' ) ;
    public final void rule__RoundedBracketClauseCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3910:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:3911:1: ( ')' )
            {
            // InternalMiniOCLCS.g:3911:1: ( ')' )
            // InternalMiniOCLCS.g:3912:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3922:1: rule__RoundedBracketClauseCS__Group_2__0 : rule__RoundedBracketClauseCS__Group_2__0__Impl rule__RoundedBracketClauseCS__Group_2__1 ;
    public final void rule__RoundedBracketClauseCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3926:1: ( rule__RoundedBracketClauseCS__Group_2__0__Impl rule__RoundedBracketClauseCS__Group_2__1 )
            // InternalMiniOCLCS.g:3927:2: rule__RoundedBracketClauseCS__Group_2__0__Impl rule__RoundedBracketClauseCS__Group_2__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalMiniOCLCS.g:3934:1: rule__RoundedBracketClauseCS__Group_2__0__Impl : ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) ) ;
    public final void rule__RoundedBracketClauseCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3938:1: ( ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) ) )
            // InternalMiniOCLCS.g:3939:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) )
            {
            // InternalMiniOCLCS.g:3939:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) )
            // InternalMiniOCLCS.g:3940:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getArgsAssignment_2_0()); 
            }
            // InternalMiniOCLCS.g:3941:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 )
            // InternalMiniOCLCS.g:3941:3: rule__RoundedBracketClauseCS__ArgsAssignment_2_0
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
    // InternalMiniOCLCS.g:3949:1: rule__RoundedBracketClauseCS__Group_2__1 : rule__RoundedBracketClauseCS__Group_2__1__Impl ;
    public final void rule__RoundedBracketClauseCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3953:1: ( rule__RoundedBracketClauseCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:3954:2: rule__RoundedBracketClauseCS__Group_2__1__Impl
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
    // InternalMiniOCLCS.g:3960:1: rule__RoundedBracketClauseCS__Group_2__1__Impl : ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* ) ;
    public final void rule__RoundedBracketClauseCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3964:1: ( ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* ) )
            // InternalMiniOCLCS.g:3965:1: ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* )
            {
            // InternalMiniOCLCS.g:3965:1: ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* )
            // InternalMiniOCLCS.g:3966:2: ( rule__RoundedBracketClauseCS__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getGroup_2_1()); 
            }
            // InternalMiniOCLCS.g:3967:2: ( rule__RoundedBracketClauseCS__Group_2_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==34) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalMiniOCLCS.g:3967:3: rule__RoundedBracketClauseCS__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__RoundedBracketClauseCS__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalMiniOCLCS.g:3976:1: rule__RoundedBracketClauseCS__Group_2_1__0 : rule__RoundedBracketClauseCS__Group_2_1__0__Impl rule__RoundedBracketClauseCS__Group_2_1__1 ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3980:1: ( rule__RoundedBracketClauseCS__Group_2_1__0__Impl rule__RoundedBracketClauseCS__Group_2_1__1 )
            // InternalMiniOCLCS.g:3981:2: rule__RoundedBracketClauseCS__Group_2_1__0__Impl rule__RoundedBracketClauseCS__Group_2_1__1
            {
            pushFollow(FOLLOW_22);
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
    // InternalMiniOCLCS.g:3988:1: rule__RoundedBracketClauseCS__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3992:1: ( ( ',' ) )
            // InternalMiniOCLCS.g:3993:1: ( ',' )
            {
            // InternalMiniOCLCS.g:3993:1: ( ',' )
            // InternalMiniOCLCS.g:3994:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4003:1: rule__RoundedBracketClauseCS__Group_2_1__1 : rule__RoundedBracketClauseCS__Group_2_1__1__Impl ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4007:1: ( rule__RoundedBracketClauseCS__Group_2_1__1__Impl )
            // InternalMiniOCLCS.g:4008:2: rule__RoundedBracketClauseCS__Group_2_1__1__Impl
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
    // InternalMiniOCLCS.g:4014:1: rule__RoundedBracketClauseCS__Group_2_1__1__Impl : ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) ) ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4018:1: ( ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) ) )
            // InternalMiniOCLCS.g:4019:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) )
            {
            // InternalMiniOCLCS.g:4019:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) )
            // InternalMiniOCLCS.g:4020:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getArgsAssignment_2_1_1()); 
            }
            // InternalMiniOCLCS.g:4021:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 )
            // InternalMiniOCLCS.g:4021:3: rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1
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
    // InternalMiniOCLCS.g:4030:1: rule__BooleanLiteralExpCS__Group__0 : rule__BooleanLiteralExpCS__Group__0__Impl rule__BooleanLiteralExpCS__Group__1 ;
    public final void rule__BooleanLiteralExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4034:1: ( rule__BooleanLiteralExpCS__Group__0__Impl rule__BooleanLiteralExpCS__Group__1 )
            // InternalMiniOCLCS.g:4035:2: rule__BooleanLiteralExpCS__Group__0__Impl rule__BooleanLiteralExpCS__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalMiniOCLCS.g:4042:1: rule__BooleanLiteralExpCS__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4046:1: ( ( () ) )
            // InternalMiniOCLCS.g:4047:1: ( () )
            {
            // InternalMiniOCLCS.g:4047:1: ( () )
            // InternalMiniOCLCS.g:4048:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getBooleanExpCSAction_0()); 
            }
            // InternalMiniOCLCS.g:4049:2: ()
            // InternalMiniOCLCS.g:4049:3: 
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
    // InternalMiniOCLCS.g:4057:1: rule__BooleanLiteralExpCS__Group__1 : rule__BooleanLiteralExpCS__Group__1__Impl ;
    public final void rule__BooleanLiteralExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4061:1: ( rule__BooleanLiteralExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:4062:2: rule__BooleanLiteralExpCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:4068:1: rule__BooleanLiteralExpCS__Group__1__Impl : ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4072:1: ( ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) ) )
            // InternalMiniOCLCS.g:4073:1: ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) )
            {
            // InternalMiniOCLCS.g:4073:1: ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) )
            // InternalMiniOCLCS.g:4074:2: ( rule__BooleanLiteralExpCS__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives_1()); 
            }
            // InternalMiniOCLCS.g:4075:2: ( rule__BooleanLiteralExpCS__Alternatives_1 )
            // InternalMiniOCLCS.g:4075:3: rule__BooleanLiteralExpCS__Alternatives_1
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


    // $ANTLR start "rule__NullLiteralExpCS__Group__0"
    // InternalMiniOCLCS.g:4084:1: rule__NullLiteralExpCS__Group__0 : rule__NullLiteralExpCS__Group__0__Impl rule__NullLiteralExpCS__Group__1 ;
    public final void rule__NullLiteralExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4088:1: ( rule__NullLiteralExpCS__Group__0__Impl rule__NullLiteralExpCS__Group__1 )
            // InternalMiniOCLCS.g:4089:2: rule__NullLiteralExpCS__Group__0__Impl rule__NullLiteralExpCS__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__NullLiteralExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__NullLiteralExpCS__Group__1();

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
    // $ANTLR end "rule__NullLiteralExpCS__Group__0"


    // $ANTLR start "rule__NullLiteralExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:4096:1: rule__NullLiteralExpCS__Group__0__Impl : ( () ) ;
    public final void rule__NullLiteralExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4100:1: ( ( () ) )
            // InternalMiniOCLCS.g:4101:1: ( () )
            {
            // InternalMiniOCLCS.g:4101:1: ( () )
            // InternalMiniOCLCS.g:4102:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0()); 
            }
            // InternalMiniOCLCS.g:4103:2: ()
            // InternalMiniOCLCS.g:4103:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullLiteralExpCS__Group__0__Impl"


    // $ANTLR start "rule__NullLiteralExpCS__Group__1"
    // InternalMiniOCLCS.g:4111:1: rule__NullLiteralExpCS__Group__1 : rule__NullLiteralExpCS__Group__1__Impl ;
    public final void rule__NullLiteralExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4115:1: ( rule__NullLiteralExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:4116:2: rule__NullLiteralExpCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NullLiteralExpCS__Group__1__Impl();

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
    // $ANTLR end "rule__NullLiteralExpCS__Group__1"


    // $ANTLR start "rule__NullLiteralExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:4122:1: rule__NullLiteralExpCS__Group__1__Impl : ( 'null' ) ;
    public final void rule__NullLiteralExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4126:1: ( ( 'null' ) )
            // InternalMiniOCLCS.g:4127:1: ( 'null' )
            {
            // InternalMiniOCLCS.g:4127:1: ( 'null' )
            // InternalMiniOCLCS.g:4128:2: 'null'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1()); 
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
    // $ANTLR end "rule__NullLiteralExpCS__Group__1__Impl"


    // $ANTLR start "rule__CollectionLiteralExpCS__Group__0"
    // InternalMiniOCLCS.g:4138:1: rule__CollectionLiteralExpCS__Group__0 : rule__CollectionLiteralExpCS__Group__0__Impl rule__CollectionLiteralExpCS__Group__1 ;
    public final void rule__CollectionLiteralExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4142:1: ( rule__CollectionLiteralExpCS__Group__0__Impl rule__CollectionLiteralExpCS__Group__1 )
            // InternalMiniOCLCS.g:4143:2: rule__CollectionLiteralExpCS__Group__0__Impl rule__CollectionLiteralExpCS__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__CollectionLiteralExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralExpCS__Group__1();

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
    // $ANTLR end "rule__CollectionLiteralExpCS__Group__0"


    // $ANTLR start "rule__CollectionLiteralExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:4150:1: rule__CollectionLiteralExpCS__Group__0__Impl : ( ( rule__CollectionLiteralExpCS__KindAssignment_0 ) ) ;
    public final void rule__CollectionLiteralExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4154:1: ( ( ( rule__CollectionLiteralExpCS__KindAssignment_0 ) ) )
            // InternalMiniOCLCS.g:4155:1: ( ( rule__CollectionLiteralExpCS__KindAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:4155:1: ( ( rule__CollectionLiteralExpCS__KindAssignment_0 ) )
            // InternalMiniOCLCS.g:4156:2: ( rule__CollectionLiteralExpCS__KindAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getKindAssignment_0()); 
            }
            // InternalMiniOCLCS.g:4157:2: ( rule__CollectionLiteralExpCS__KindAssignment_0 )
            // InternalMiniOCLCS.g:4157:3: rule__CollectionLiteralExpCS__KindAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralExpCS__KindAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralExpCSAccess().getKindAssignment_0()); 
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
    // $ANTLR end "rule__CollectionLiteralExpCS__Group__0__Impl"


    // $ANTLR start "rule__CollectionLiteralExpCS__Group__1"
    // InternalMiniOCLCS.g:4165:1: rule__CollectionLiteralExpCS__Group__1 : rule__CollectionLiteralExpCS__Group__1__Impl rule__CollectionLiteralExpCS__Group__2 ;
    public final void rule__CollectionLiteralExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4169:1: ( rule__CollectionLiteralExpCS__Group__1__Impl rule__CollectionLiteralExpCS__Group__2 )
            // InternalMiniOCLCS.g:4170:2: rule__CollectionLiteralExpCS__Group__1__Impl rule__CollectionLiteralExpCS__Group__2
            {
            pushFollow(FOLLOW_39);
            rule__CollectionLiteralExpCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralExpCS__Group__2();

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
    // $ANTLR end "rule__CollectionLiteralExpCS__Group__1"


    // $ANTLR start "rule__CollectionLiteralExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:4177:1: rule__CollectionLiteralExpCS__Group__1__Impl : ( '{' ) ;
    public final void rule__CollectionLiteralExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4181:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:4182:1: ( '{' )
            {
            // InternalMiniOCLCS.g:4182:1: ( '{' )
            // InternalMiniOCLCS.g:4183:2: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,21,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1()); 
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
    // $ANTLR end "rule__CollectionLiteralExpCS__Group__1__Impl"


    // $ANTLR start "rule__CollectionLiteralExpCS__Group__2"
    // InternalMiniOCLCS.g:4192:1: rule__CollectionLiteralExpCS__Group__2 : rule__CollectionLiteralExpCS__Group__2__Impl rule__CollectionLiteralExpCS__Group__3 ;
    public final void rule__CollectionLiteralExpCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4196:1: ( rule__CollectionLiteralExpCS__Group__2__Impl rule__CollectionLiteralExpCS__Group__3 )
            // InternalMiniOCLCS.g:4197:2: rule__CollectionLiteralExpCS__Group__2__Impl rule__CollectionLiteralExpCS__Group__3
            {
            pushFollow(FOLLOW_39);
            rule__CollectionLiteralExpCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralExpCS__Group__3();

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
    // $ANTLR end "rule__CollectionLiteralExpCS__Group__2"


    // $ANTLR start "rule__CollectionLiteralExpCS__Group__2__Impl"
    // InternalMiniOCLCS.g:4204:1: rule__CollectionLiteralExpCS__Group__2__Impl : ( ( rule__CollectionLiteralExpCS__PartsAssignment_2 )* ) ;
    public final void rule__CollectionLiteralExpCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4208:1: ( ( ( rule__CollectionLiteralExpCS__PartsAssignment_2 )* ) )
            // InternalMiniOCLCS.g:4209:1: ( ( rule__CollectionLiteralExpCS__PartsAssignment_2 )* )
            {
            // InternalMiniOCLCS.g:4209:1: ( ( rule__CollectionLiteralExpCS__PartsAssignment_2 )* )
            // InternalMiniOCLCS.g:4210:2: ( rule__CollectionLiteralExpCS__PartsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getPartsAssignment_2()); 
            }
            // InternalMiniOCLCS.g:4211:2: ( rule__CollectionLiteralExpCS__PartsAssignment_2 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID||LA31_0==RULE_INT||LA31_0==11||LA31_0==19||LA31_0==37||(LA31_0>=41 && LA31_0<=42)||LA31_0==47) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMiniOCLCS.g:4211:3: rule__CollectionLiteralExpCS__PartsAssignment_2
            	    {
            	    pushFollow(FOLLOW_40);
            	    rule__CollectionLiteralExpCS__PartsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralExpCSAccess().getPartsAssignment_2()); 
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
    // $ANTLR end "rule__CollectionLiteralExpCS__Group__2__Impl"


    // $ANTLR start "rule__CollectionLiteralExpCS__Group__3"
    // InternalMiniOCLCS.g:4219:1: rule__CollectionLiteralExpCS__Group__3 : rule__CollectionLiteralExpCS__Group__3__Impl ;
    public final void rule__CollectionLiteralExpCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4223:1: ( rule__CollectionLiteralExpCS__Group__3__Impl )
            // InternalMiniOCLCS.g:4224:2: rule__CollectionLiteralExpCS__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralExpCS__Group__3__Impl();

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
    // $ANTLR end "rule__CollectionLiteralExpCS__Group__3"


    // $ANTLR start "rule__CollectionLiteralExpCS__Group__3__Impl"
    // InternalMiniOCLCS.g:4230:1: rule__CollectionLiteralExpCS__Group__3__Impl : ( '}' ) ;
    public final void rule__CollectionLiteralExpCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4234:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:4235:1: ( '}' )
            {
            // InternalMiniOCLCS.g:4235:1: ( '}' )
            // InternalMiniOCLCS.g:4236:2: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,22,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__CollectionLiteralExpCS__Group__3__Impl"


    // $ANTLR start "rule__CollectionLiteralPartCS__Group__0"
    // InternalMiniOCLCS.g:4246:1: rule__CollectionLiteralPartCS__Group__0 : rule__CollectionLiteralPartCS__Group__0__Impl rule__CollectionLiteralPartCS__Group__1 ;
    public final void rule__CollectionLiteralPartCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4250:1: ( rule__CollectionLiteralPartCS__Group__0__Impl rule__CollectionLiteralPartCS__Group__1 )
            // InternalMiniOCLCS.g:4251:2: rule__CollectionLiteralPartCS__Group__0__Impl rule__CollectionLiteralPartCS__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__CollectionLiteralPartCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralPartCS__Group__1();

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
    // $ANTLR end "rule__CollectionLiteralPartCS__Group__0"


    // $ANTLR start "rule__CollectionLiteralPartCS__Group__0__Impl"
    // InternalMiniOCLCS.g:4258:1: rule__CollectionLiteralPartCS__Group__0__Impl : ( ( rule__CollectionLiteralPartCS__FirstAssignment_0 ) ) ;
    public final void rule__CollectionLiteralPartCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4262:1: ( ( ( rule__CollectionLiteralPartCS__FirstAssignment_0 ) ) )
            // InternalMiniOCLCS.g:4263:1: ( ( rule__CollectionLiteralPartCS__FirstAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:4263:1: ( ( rule__CollectionLiteralPartCS__FirstAssignment_0 ) )
            // InternalMiniOCLCS.g:4264:2: ( rule__CollectionLiteralPartCS__FirstAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getFirstAssignment_0()); 
            }
            // InternalMiniOCLCS.g:4265:2: ( rule__CollectionLiteralPartCS__FirstAssignment_0 )
            // InternalMiniOCLCS.g:4265:3: rule__CollectionLiteralPartCS__FirstAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralPartCS__FirstAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralPartCSAccess().getFirstAssignment_0()); 
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
    // $ANTLR end "rule__CollectionLiteralPartCS__Group__0__Impl"


    // $ANTLR start "rule__CollectionLiteralPartCS__Group__1"
    // InternalMiniOCLCS.g:4273:1: rule__CollectionLiteralPartCS__Group__1 : rule__CollectionLiteralPartCS__Group__1__Impl ;
    public final void rule__CollectionLiteralPartCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4277:1: ( rule__CollectionLiteralPartCS__Group__1__Impl )
            // InternalMiniOCLCS.g:4278:2: rule__CollectionLiteralPartCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralPartCS__Group__1__Impl();

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
    // $ANTLR end "rule__CollectionLiteralPartCS__Group__1"


    // $ANTLR start "rule__CollectionLiteralPartCS__Group__1__Impl"
    // InternalMiniOCLCS.g:4284:1: rule__CollectionLiteralPartCS__Group__1__Impl : ( ( rule__CollectionLiteralPartCS__Group_1__0 )? ) ;
    public final void rule__CollectionLiteralPartCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4288:1: ( ( ( rule__CollectionLiteralPartCS__Group_1__0 )? ) )
            // InternalMiniOCLCS.g:4289:1: ( ( rule__CollectionLiteralPartCS__Group_1__0 )? )
            {
            // InternalMiniOCLCS.g:4289:1: ( ( rule__CollectionLiteralPartCS__Group_1__0 )? )
            // InternalMiniOCLCS.g:4290:2: ( rule__CollectionLiteralPartCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:4291:2: ( rule__CollectionLiteralPartCS__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==30) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMiniOCLCS.g:4291:3: rule__CollectionLiteralPartCS__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CollectionLiteralPartCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_1()); 
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
    // $ANTLR end "rule__CollectionLiteralPartCS__Group__1__Impl"


    // $ANTLR start "rule__CollectionLiteralPartCS__Group_1__0"
    // InternalMiniOCLCS.g:4300:1: rule__CollectionLiteralPartCS__Group_1__0 : rule__CollectionLiteralPartCS__Group_1__0__Impl rule__CollectionLiteralPartCS__Group_1__1 ;
    public final void rule__CollectionLiteralPartCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4304:1: ( rule__CollectionLiteralPartCS__Group_1__0__Impl rule__CollectionLiteralPartCS__Group_1__1 )
            // InternalMiniOCLCS.g:4305:2: rule__CollectionLiteralPartCS__Group_1__0__Impl rule__CollectionLiteralPartCS__Group_1__1
            {
            pushFollow(FOLLOW_22);
            rule__CollectionLiteralPartCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralPartCS__Group_1__1();

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
    // $ANTLR end "rule__CollectionLiteralPartCS__Group_1__0"


    // $ANTLR start "rule__CollectionLiteralPartCS__Group_1__0__Impl"
    // InternalMiniOCLCS.g:4312:1: rule__CollectionLiteralPartCS__Group_1__0__Impl : ( '..' ) ;
    public final void rule__CollectionLiteralPartCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4316:1: ( ( '..' ) )
            // InternalMiniOCLCS.g:4317:1: ( '..' )
            {
            // InternalMiniOCLCS.g:4317:1: ( '..' )
            // InternalMiniOCLCS.g:4318:2: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0()); 
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
    // $ANTLR end "rule__CollectionLiteralPartCS__Group_1__0__Impl"


    // $ANTLR start "rule__CollectionLiteralPartCS__Group_1__1"
    // InternalMiniOCLCS.g:4327:1: rule__CollectionLiteralPartCS__Group_1__1 : rule__CollectionLiteralPartCS__Group_1__1__Impl ;
    public final void rule__CollectionLiteralPartCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4331:1: ( rule__CollectionLiteralPartCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:4332:2: rule__CollectionLiteralPartCS__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralPartCS__Group_1__1__Impl();

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
    // $ANTLR end "rule__CollectionLiteralPartCS__Group_1__1"


    // $ANTLR start "rule__CollectionLiteralPartCS__Group_1__1__Impl"
    // InternalMiniOCLCS.g:4338:1: rule__CollectionLiteralPartCS__Group_1__1__Impl : ( ( rule__CollectionLiteralPartCS__LastAssignment_1_1 ) ) ;
    public final void rule__CollectionLiteralPartCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4342:1: ( ( ( rule__CollectionLiteralPartCS__LastAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:4343:1: ( ( rule__CollectionLiteralPartCS__LastAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:4343:1: ( ( rule__CollectionLiteralPartCS__LastAssignment_1_1 ) )
            // InternalMiniOCLCS.g:4344:2: ( rule__CollectionLiteralPartCS__LastAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getLastAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:4345:2: ( rule__CollectionLiteralPartCS__LastAssignment_1_1 )
            // InternalMiniOCLCS.g:4345:3: rule__CollectionLiteralPartCS__LastAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CollectionLiteralPartCS__LastAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralPartCSAccess().getLastAssignment_1_1()); 
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
    // $ANTLR end "rule__CollectionLiteralPartCS__Group_1__1__Impl"


    // $ANTLR start "rule__LetExpCS__Group__0"
    // InternalMiniOCLCS.g:4354:1: rule__LetExpCS__Group__0 : rule__LetExpCS__Group__0__Impl rule__LetExpCS__Group__1 ;
    public final void rule__LetExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4358:1: ( rule__LetExpCS__Group__0__Impl rule__LetExpCS__Group__1 )
            // InternalMiniOCLCS.g:4359:2: rule__LetExpCS__Group__0__Impl rule__LetExpCS__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__LetExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LetExpCS__Group__1();

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
    // $ANTLR end "rule__LetExpCS__Group__0"


    // $ANTLR start "rule__LetExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:4366:1: rule__LetExpCS__Group__0__Impl : ( 'let' ) ;
    public final void rule__LetExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4370:1: ( ( 'let' ) )
            // InternalMiniOCLCS.g:4371:1: ( 'let' )
            {
            // InternalMiniOCLCS.g:4371:1: ( 'let' )
            // InternalMiniOCLCS.g:4372:2: 'let'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getLetKeyword_0()); 
            }
            match(input,42,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getLetKeyword_0()); 
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
    // $ANTLR end "rule__LetExpCS__Group__0__Impl"


    // $ANTLR start "rule__LetExpCS__Group__1"
    // InternalMiniOCLCS.g:4381:1: rule__LetExpCS__Group__1 : rule__LetExpCS__Group__1__Impl rule__LetExpCS__Group__2 ;
    public final void rule__LetExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4385:1: ( rule__LetExpCS__Group__1__Impl rule__LetExpCS__Group__2 )
            // InternalMiniOCLCS.g:4386:2: rule__LetExpCS__Group__1__Impl rule__LetExpCS__Group__2
            {
            pushFollow(FOLLOW_41);
            rule__LetExpCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LetExpCS__Group__2();

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
    // $ANTLR end "rule__LetExpCS__Group__1"


    // $ANTLR start "rule__LetExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:4393:1: rule__LetExpCS__Group__1__Impl : ( ( rule__LetExpCS__LetVarsAssignment_1 ) ) ;
    public final void rule__LetExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4397:1: ( ( ( rule__LetExpCS__LetVarsAssignment_1 ) ) )
            // InternalMiniOCLCS.g:4398:1: ( ( rule__LetExpCS__LetVarsAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:4398:1: ( ( rule__LetExpCS__LetVarsAssignment_1 ) )
            // InternalMiniOCLCS.g:4399:2: ( rule__LetExpCS__LetVarsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getLetVarsAssignment_1()); 
            }
            // InternalMiniOCLCS.g:4400:2: ( rule__LetExpCS__LetVarsAssignment_1 )
            // InternalMiniOCLCS.g:4400:3: rule__LetExpCS__LetVarsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__LetExpCS__LetVarsAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getLetVarsAssignment_1()); 
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
    // $ANTLR end "rule__LetExpCS__Group__1__Impl"


    // $ANTLR start "rule__LetExpCS__Group__2"
    // InternalMiniOCLCS.g:4408:1: rule__LetExpCS__Group__2 : rule__LetExpCS__Group__2__Impl rule__LetExpCS__Group__3 ;
    public final void rule__LetExpCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4412:1: ( rule__LetExpCS__Group__2__Impl rule__LetExpCS__Group__3 )
            // InternalMiniOCLCS.g:4413:2: rule__LetExpCS__Group__2__Impl rule__LetExpCS__Group__3
            {
            pushFollow(FOLLOW_41);
            rule__LetExpCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LetExpCS__Group__3();

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
    // $ANTLR end "rule__LetExpCS__Group__2"


    // $ANTLR start "rule__LetExpCS__Group__2__Impl"
    // InternalMiniOCLCS.g:4420:1: rule__LetExpCS__Group__2__Impl : ( ( rule__LetExpCS__Group_2__0 )* ) ;
    public final void rule__LetExpCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4424:1: ( ( ( rule__LetExpCS__Group_2__0 )* ) )
            // InternalMiniOCLCS.g:4425:1: ( ( rule__LetExpCS__Group_2__0 )* )
            {
            // InternalMiniOCLCS.g:4425:1: ( ( rule__LetExpCS__Group_2__0 )* )
            // InternalMiniOCLCS.g:4426:2: ( rule__LetExpCS__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:4427:2: ( rule__LetExpCS__Group_2__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==34) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalMiniOCLCS.g:4427:3: rule__LetExpCS__Group_2__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__LetExpCS__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getGroup_2()); 
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
    // $ANTLR end "rule__LetExpCS__Group__2__Impl"


    // $ANTLR start "rule__LetExpCS__Group__3"
    // InternalMiniOCLCS.g:4435:1: rule__LetExpCS__Group__3 : rule__LetExpCS__Group__3__Impl rule__LetExpCS__Group__4 ;
    public final void rule__LetExpCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4439:1: ( rule__LetExpCS__Group__3__Impl rule__LetExpCS__Group__4 )
            // InternalMiniOCLCS.g:4440:2: rule__LetExpCS__Group__3__Impl rule__LetExpCS__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__LetExpCS__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LetExpCS__Group__4();

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
    // $ANTLR end "rule__LetExpCS__Group__3"


    // $ANTLR start "rule__LetExpCS__Group__3__Impl"
    // InternalMiniOCLCS.g:4447:1: rule__LetExpCS__Group__3__Impl : ( 'in' ) ;
    public final void rule__LetExpCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4451:1: ( ( 'in' ) )
            // InternalMiniOCLCS.g:4452:1: ( 'in' )
            {
            // InternalMiniOCLCS.g:4452:1: ( 'in' )
            // InternalMiniOCLCS.g:4453:2: 'in'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getInKeyword_3()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getInKeyword_3()); 
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
    // $ANTLR end "rule__LetExpCS__Group__3__Impl"


    // $ANTLR start "rule__LetExpCS__Group__4"
    // InternalMiniOCLCS.g:4462:1: rule__LetExpCS__Group__4 : rule__LetExpCS__Group__4__Impl ;
    public final void rule__LetExpCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4466:1: ( rule__LetExpCS__Group__4__Impl )
            // InternalMiniOCLCS.g:4467:2: rule__LetExpCS__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LetExpCS__Group__4__Impl();

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
    // $ANTLR end "rule__LetExpCS__Group__4"


    // $ANTLR start "rule__LetExpCS__Group__4__Impl"
    // InternalMiniOCLCS.g:4473:1: rule__LetExpCS__Group__4__Impl : ( ( rule__LetExpCS__InExpAssignment_4 ) ) ;
    public final void rule__LetExpCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4477:1: ( ( ( rule__LetExpCS__InExpAssignment_4 ) ) )
            // InternalMiniOCLCS.g:4478:1: ( ( rule__LetExpCS__InExpAssignment_4 ) )
            {
            // InternalMiniOCLCS.g:4478:1: ( ( rule__LetExpCS__InExpAssignment_4 ) )
            // InternalMiniOCLCS.g:4479:2: ( rule__LetExpCS__InExpAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getInExpAssignment_4()); 
            }
            // InternalMiniOCLCS.g:4480:2: ( rule__LetExpCS__InExpAssignment_4 )
            // InternalMiniOCLCS.g:4480:3: rule__LetExpCS__InExpAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__LetExpCS__InExpAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getInExpAssignment_4()); 
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
    // $ANTLR end "rule__LetExpCS__Group__4__Impl"


    // $ANTLR start "rule__LetExpCS__Group_2__0"
    // InternalMiniOCLCS.g:4489:1: rule__LetExpCS__Group_2__0 : rule__LetExpCS__Group_2__0__Impl rule__LetExpCS__Group_2__1 ;
    public final void rule__LetExpCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4493:1: ( rule__LetExpCS__Group_2__0__Impl rule__LetExpCS__Group_2__1 )
            // InternalMiniOCLCS.g:4494:2: rule__LetExpCS__Group_2__0__Impl rule__LetExpCS__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__LetExpCS__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LetExpCS__Group_2__1();

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
    // $ANTLR end "rule__LetExpCS__Group_2__0"


    // $ANTLR start "rule__LetExpCS__Group_2__0__Impl"
    // InternalMiniOCLCS.g:4501:1: rule__LetExpCS__Group_2__0__Impl : ( ',' ) ;
    public final void rule__LetExpCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4505:1: ( ( ',' ) )
            // InternalMiniOCLCS.g:4506:1: ( ',' )
            {
            // InternalMiniOCLCS.g:4506:1: ( ',' )
            // InternalMiniOCLCS.g:4507:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0()); 
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
    // $ANTLR end "rule__LetExpCS__Group_2__0__Impl"


    // $ANTLR start "rule__LetExpCS__Group_2__1"
    // InternalMiniOCLCS.g:4516:1: rule__LetExpCS__Group_2__1 : rule__LetExpCS__Group_2__1__Impl ;
    public final void rule__LetExpCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4520:1: ( rule__LetExpCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:4521:2: rule__LetExpCS__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LetExpCS__Group_2__1__Impl();

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
    // $ANTLR end "rule__LetExpCS__Group_2__1"


    // $ANTLR start "rule__LetExpCS__Group_2__1__Impl"
    // InternalMiniOCLCS.g:4527:1: rule__LetExpCS__Group_2__1__Impl : ( ( rule__LetExpCS__LetVarsAssignment_2_1 ) ) ;
    public final void rule__LetExpCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4531:1: ( ( ( rule__LetExpCS__LetVarsAssignment_2_1 ) ) )
            // InternalMiniOCLCS.g:4532:1: ( ( rule__LetExpCS__LetVarsAssignment_2_1 ) )
            {
            // InternalMiniOCLCS.g:4532:1: ( ( rule__LetExpCS__LetVarsAssignment_2_1 ) )
            // InternalMiniOCLCS.g:4533:2: ( rule__LetExpCS__LetVarsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getLetVarsAssignment_2_1()); 
            }
            // InternalMiniOCLCS.g:4534:2: ( rule__LetExpCS__LetVarsAssignment_2_1 )
            // InternalMiniOCLCS.g:4534:3: rule__LetExpCS__LetVarsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__LetExpCS__LetVarsAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getLetVarsAssignment_2_1()); 
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
    // $ANTLR end "rule__LetExpCS__Group_2__1__Impl"


    // $ANTLR start "rule__LetVarCS__Group__0"
    // InternalMiniOCLCS.g:4543:1: rule__LetVarCS__Group__0 : rule__LetVarCS__Group__0__Impl rule__LetVarCS__Group__1 ;
    public final void rule__LetVarCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4547:1: ( rule__LetVarCS__Group__0__Impl rule__LetVarCS__Group__1 )
            // InternalMiniOCLCS.g:4548:2: rule__LetVarCS__Group__0__Impl rule__LetVarCS__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__LetVarCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LetVarCS__Group__1();

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
    // $ANTLR end "rule__LetVarCS__Group__0"


    // $ANTLR start "rule__LetVarCS__Group__0__Impl"
    // InternalMiniOCLCS.g:4555:1: rule__LetVarCS__Group__0__Impl : ( ( rule__LetVarCS__NameAssignment_0 ) ) ;
    public final void rule__LetVarCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4559:1: ( ( ( rule__LetVarCS__NameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:4560:1: ( ( rule__LetVarCS__NameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:4560:1: ( ( rule__LetVarCS__NameAssignment_0 ) )
            // InternalMiniOCLCS.g:4561:2: ( rule__LetVarCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:4562:2: ( rule__LetVarCS__NameAssignment_0 )
            // InternalMiniOCLCS.g:4562:3: rule__LetVarCS__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LetVarCS__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__LetVarCS__Group__0__Impl"


    // $ANTLR start "rule__LetVarCS__Group__1"
    // InternalMiniOCLCS.g:4570:1: rule__LetVarCS__Group__1 : rule__LetVarCS__Group__1__Impl rule__LetVarCS__Group__2 ;
    public final void rule__LetVarCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4574:1: ( rule__LetVarCS__Group__1__Impl rule__LetVarCS__Group__2 )
            // InternalMiniOCLCS.g:4575:2: rule__LetVarCS__Group__1__Impl rule__LetVarCS__Group__2
            {
            pushFollow(FOLLOW_35);
            rule__LetVarCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LetVarCS__Group__2();

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
    // $ANTLR end "rule__LetVarCS__Group__1"


    // $ANTLR start "rule__LetVarCS__Group__1__Impl"
    // InternalMiniOCLCS.g:4582:1: rule__LetVarCS__Group__1__Impl : ( ( rule__LetVarCS__Group_1__0 )? ) ;
    public final void rule__LetVarCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4586:1: ( ( ( rule__LetVarCS__Group_1__0 )? ) )
            // InternalMiniOCLCS.g:4587:1: ( ( rule__LetVarCS__Group_1__0 )? )
            {
            // InternalMiniOCLCS.g:4587:1: ( ( rule__LetVarCS__Group_1__0 )? )
            // InternalMiniOCLCS.g:4588:2: ( rule__LetVarCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:4589:2: ( rule__LetVarCS__Group_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==26) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalMiniOCLCS.g:4589:3: rule__LetVarCS__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__LetVarCS__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getGroup_1()); 
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
    // $ANTLR end "rule__LetVarCS__Group__1__Impl"


    // $ANTLR start "rule__LetVarCS__Group__2"
    // InternalMiniOCLCS.g:4597:1: rule__LetVarCS__Group__2 : rule__LetVarCS__Group__2__Impl rule__LetVarCS__Group__3 ;
    public final void rule__LetVarCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4601:1: ( rule__LetVarCS__Group__2__Impl rule__LetVarCS__Group__3 )
            // InternalMiniOCLCS.g:4602:2: rule__LetVarCS__Group__2__Impl rule__LetVarCS__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__LetVarCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LetVarCS__Group__3();

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
    // $ANTLR end "rule__LetVarCS__Group__2"


    // $ANTLR start "rule__LetVarCS__Group__2__Impl"
    // InternalMiniOCLCS.g:4609:1: rule__LetVarCS__Group__2__Impl : ( '=' ) ;
    public final void rule__LetVarCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4613:1: ( ( '=' ) )
            // InternalMiniOCLCS.g:4614:1: ( '=' )
            {
            // InternalMiniOCLCS.g:4614:1: ( '=' )
            // InternalMiniOCLCS.g:4615:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getEqualsSignKeyword_2()); 
            }
            match(input,15,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getEqualsSignKeyword_2()); 
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
    // $ANTLR end "rule__LetVarCS__Group__2__Impl"


    // $ANTLR start "rule__LetVarCS__Group__3"
    // InternalMiniOCLCS.g:4624:1: rule__LetVarCS__Group__3 : rule__LetVarCS__Group__3__Impl ;
    public final void rule__LetVarCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4628:1: ( rule__LetVarCS__Group__3__Impl )
            // InternalMiniOCLCS.g:4629:2: rule__LetVarCS__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LetVarCS__Group__3__Impl();

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
    // $ANTLR end "rule__LetVarCS__Group__3"


    // $ANTLR start "rule__LetVarCS__Group__3__Impl"
    // InternalMiniOCLCS.g:4635:1: rule__LetVarCS__Group__3__Impl : ( ( rule__LetVarCS__InitExpAssignment_3 ) ) ;
    public final void rule__LetVarCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4639:1: ( ( ( rule__LetVarCS__InitExpAssignment_3 ) ) )
            // InternalMiniOCLCS.g:4640:1: ( ( rule__LetVarCS__InitExpAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:4640:1: ( ( rule__LetVarCS__InitExpAssignment_3 ) )
            // InternalMiniOCLCS.g:4641:2: ( rule__LetVarCS__InitExpAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getInitExpAssignment_3()); 
            }
            // InternalMiniOCLCS.g:4642:2: ( rule__LetVarCS__InitExpAssignment_3 )
            // InternalMiniOCLCS.g:4642:3: rule__LetVarCS__InitExpAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__LetVarCS__InitExpAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getInitExpAssignment_3()); 
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
    // $ANTLR end "rule__LetVarCS__Group__3__Impl"


    // $ANTLR start "rule__LetVarCS__Group_1__0"
    // InternalMiniOCLCS.g:4651:1: rule__LetVarCS__Group_1__0 : rule__LetVarCS__Group_1__0__Impl rule__LetVarCS__Group_1__1 ;
    public final void rule__LetVarCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4655:1: ( rule__LetVarCS__Group_1__0__Impl rule__LetVarCS__Group_1__1 )
            // InternalMiniOCLCS.g:4656:2: rule__LetVarCS__Group_1__0__Impl rule__LetVarCS__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__LetVarCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__LetVarCS__Group_1__1();

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
    // $ANTLR end "rule__LetVarCS__Group_1__0"


    // $ANTLR start "rule__LetVarCS__Group_1__0__Impl"
    // InternalMiniOCLCS.g:4663:1: rule__LetVarCS__Group_1__0__Impl : ( ':' ) ;
    public final void rule__LetVarCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4667:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:4668:1: ( ':' )
            {
            // InternalMiniOCLCS.g:4668:1: ( ':' )
            // InternalMiniOCLCS.g:4669:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getColonKeyword_1_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getColonKeyword_1_0()); 
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
    // $ANTLR end "rule__LetVarCS__Group_1__0__Impl"


    // $ANTLR start "rule__LetVarCS__Group_1__1"
    // InternalMiniOCLCS.g:4678:1: rule__LetVarCS__Group_1__1 : rule__LetVarCS__Group_1__1__Impl ;
    public final void rule__LetVarCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4682:1: ( rule__LetVarCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:4683:2: rule__LetVarCS__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LetVarCS__Group_1__1__Impl();

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
    // $ANTLR end "rule__LetVarCS__Group_1__1"


    // $ANTLR start "rule__LetVarCS__Group_1__1__Impl"
    // InternalMiniOCLCS.g:4689:1: rule__LetVarCS__Group_1__1__Impl : ( ( rule__LetVarCS__TypeRefAssignment_1_1 ) ) ;
    public final void rule__LetVarCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4693:1: ( ( ( rule__LetVarCS__TypeRefAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:4694:1: ( ( rule__LetVarCS__TypeRefAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:4694:1: ( ( rule__LetVarCS__TypeRefAssignment_1_1 ) )
            // InternalMiniOCLCS.g:4695:2: ( rule__LetVarCS__TypeRefAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getTypeRefAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:4696:2: ( rule__LetVarCS__TypeRefAssignment_1_1 )
            // InternalMiniOCLCS.g:4696:3: rule__LetVarCS__TypeRefAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__LetVarCS__TypeRefAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getTypeRefAssignment_1_1()); 
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
    // $ANTLR end "rule__LetVarCS__Group_1__1__Impl"


    // $ANTLR start "rule__PathNameCS__Group__0"
    // InternalMiniOCLCS.g:4705:1: rule__PathNameCS__Group__0 : rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 ;
    public final void rule__PathNameCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4709:1: ( rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 )
            // InternalMiniOCLCS.g:4710:2: rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1
            {
            pushFollow(FOLLOW_42);
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
    // InternalMiniOCLCS.g:4717:1: rule__PathNameCS__Group__0__Impl : ( ( rule__PathNameCS__PathElementsAssignment_0 ) ) ;
    public final void rule__PathNameCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4721:1: ( ( ( rule__PathNameCS__PathElementsAssignment_0 ) ) )
            // InternalMiniOCLCS.g:4722:1: ( ( rule__PathNameCS__PathElementsAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:4722:1: ( ( rule__PathNameCS__PathElementsAssignment_0 ) )
            // InternalMiniOCLCS.g:4723:2: ( rule__PathNameCS__PathElementsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getPathElementsAssignment_0()); 
            }
            // InternalMiniOCLCS.g:4724:2: ( rule__PathNameCS__PathElementsAssignment_0 )
            // InternalMiniOCLCS.g:4724:3: rule__PathNameCS__PathElementsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PathNameCS__PathElementsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getPathElementsAssignment_0()); 
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
    // InternalMiniOCLCS.g:4732:1: rule__PathNameCS__Group__1 : rule__PathNameCS__Group__1__Impl ;
    public final void rule__PathNameCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4736:1: ( rule__PathNameCS__Group__1__Impl )
            // InternalMiniOCLCS.g:4737:2: rule__PathNameCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:4743:1: rule__PathNameCS__Group__1__Impl : ( ( rule__PathNameCS__Group_1__0 )* ) ;
    public final void rule__PathNameCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4747:1: ( ( ( rule__PathNameCS__Group_1__0 )* ) )
            // InternalMiniOCLCS.g:4748:1: ( ( rule__PathNameCS__Group_1__0 )* )
            {
            // InternalMiniOCLCS.g:4748:1: ( ( rule__PathNameCS__Group_1__0 )* )
            // InternalMiniOCLCS.g:4749:2: ( rule__PathNameCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:4750:2: ( rule__PathNameCS__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==44) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalMiniOCLCS.g:4750:3: rule__PathNameCS__Group_1__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__PathNameCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalMiniOCLCS.g:4759:1: rule__PathNameCS__Group_1__0 : rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 ;
    public final void rule__PathNameCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4763:1: ( rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 )
            // InternalMiniOCLCS.g:4764:2: rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1
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
    // InternalMiniOCLCS.g:4771:1: rule__PathNameCS__Group_1__0__Impl : ( '::' ) ;
    public final void rule__PathNameCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4775:1: ( ( '::' ) )
            // InternalMiniOCLCS.g:4776:1: ( '::' )
            {
            // InternalMiniOCLCS.g:4776:1: ( '::' )
            // InternalMiniOCLCS.g:4777:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4786:1: rule__PathNameCS__Group_1__1 : rule__PathNameCS__Group_1__1__Impl ;
    public final void rule__PathNameCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4790:1: ( rule__PathNameCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:4791:2: rule__PathNameCS__Group_1__1__Impl
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
    // InternalMiniOCLCS.g:4797:1: rule__PathNameCS__Group_1__1__Impl : ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) ) ;
    public final void rule__PathNameCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4801:1: ( ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:4802:1: ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:4802:1: ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) )
            // InternalMiniOCLCS.g:4803:2: ( rule__PathNameCS__PathElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getPathElementsAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:4804:2: ( rule__PathNameCS__PathElementsAssignment_1_1 )
            // InternalMiniOCLCS.g:4804:3: rule__PathNameCS__PathElementsAssignment_1_1
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
    // InternalMiniOCLCS.g:4813:1: rule__RootCS__PackagesAssignment_0 : ( rulePackageCS ) ;
    public final void rule__RootCS__PackagesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4817:1: ( ( rulePackageCS ) )
            // InternalMiniOCLCS.g:4818:2: ( rulePackageCS )
            {
            // InternalMiniOCLCS.g:4818:2: ( rulePackageCS )
            // InternalMiniOCLCS.g:4819:3: rulePackageCS
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
    // InternalMiniOCLCS.g:4828:1: rule__RootCS__ContraintsAssignment_1 : ( ruleConstraintsDefCS ) ;
    public final void rule__RootCS__ContraintsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4832:1: ( ( ruleConstraintsDefCS ) )
            // InternalMiniOCLCS.g:4833:2: ( ruleConstraintsDefCS )
            {
            // InternalMiniOCLCS.g:4833:2: ( ruleConstraintsDefCS )
            // InternalMiniOCLCS.g:4834:3: ruleConstraintsDefCS
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
    // InternalMiniOCLCS.g:4843:1: rule__PackageCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PackageCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4847:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:4848:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:4848:2: ( RULE_ID )
            // InternalMiniOCLCS.g:4849:3: RULE_ID
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
    // InternalMiniOCLCS.g:4858:1: rule__PackageCS__PackagesAssignment_3_0 : ( rulePackageCS ) ;
    public final void rule__PackageCS__PackagesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4862:1: ( ( rulePackageCS ) )
            // InternalMiniOCLCS.g:4863:2: ( rulePackageCS )
            {
            // InternalMiniOCLCS.g:4863:2: ( rulePackageCS )
            // InternalMiniOCLCS.g:4864:3: rulePackageCS
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


    // $ANTLR start "rule__PackageCS__ClassifiersAssignment_3_1"
    // InternalMiniOCLCS.g:4873:1: rule__PackageCS__ClassifiersAssignment_3_1 : ( ruleClassifierCS ) ;
    public final void rule__PackageCS__ClassifiersAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4877:1: ( ( ruleClassifierCS ) )
            // InternalMiniOCLCS.g:4878:2: ( ruleClassifierCS )
            {
            // InternalMiniOCLCS.g:4878:2: ( ruleClassifierCS )
            // InternalMiniOCLCS.g:4879:3: ruleClassifierCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getClassifiersClassifierCSParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleClassifierCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPackageCSAccess().getClassifiersClassifierCSParserRuleCall_3_1_0()); 
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
    // $ANTLR end "rule__PackageCS__ClassifiersAssignment_3_1"


    // $ANTLR start "rule__ClassCS__NameAssignment_1"
    // InternalMiniOCLCS.g:4888:1: rule__ClassCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ClassCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4892:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:4893:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:4893:2: ( RULE_ID )
            // InternalMiniOCLCS.g:4894:3: RULE_ID
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
    // InternalMiniOCLCS.g:4903:1: rule__ClassCS__ExtendsAssignment_2_1 : ( rulePathNameCS ) ;
    public final void rule__ClassCS__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4907:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:4908:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:4908:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:4909:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:4918:1: rule__ClassCS__PropertiesAssignment_4_0 : ( rulePropertyCS ) ;
    public final void rule__ClassCS__PropertiesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4922:1: ( ( rulePropertyCS ) )
            // InternalMiniOCLCS.g:4923:2: ( rulePropertyCS )
            {
            // InternalMiniOCLCS.g:4923:2: ( rulePropertyCS )
            // InternalMiniOCLCS.g:4924:3: rulePropertyCS
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
    // InternalMiniOCLCS.g:4933:1: rule__ClassCS__OperationsAssignment_4_1 : ( ruleOperationCS ) ;
    public final void rule__ClassCS__OperationsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4937:1: ( ( ruleOperationCS ) )
            // InternalMiniOCLCS.g:4938:2: ( ruleOperationCS )
            {
            // InternalMiniOCLCS.g:4938:2: ( ruleOperationCS )
            // InternalMiniOCLCS.g:4939:3: ruleOperationCS
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


    // $ANTLR start "rule__DatatypeCS__NameAssignment_1"
    // InternalMiniOCLCS.g:4948:1: rule__DatatypeCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DatatypeCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4952:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:4953:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:4953:2: ( RULE_ID )
            // InternalMiniOCLCS.g:4954:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeCSAccess().getNameIDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeCSAccess().getNameIDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__DatatypeCS__NameAssignment_1"


    // $ANTLR start "rule__DatatypeCS__TypeNameAssignment_3"
    // InternalMiniOCLCS.g:4963:1: rule__DatatypeCS__TypeNameAssignment_3 : ( RULE_STRING ) ;
    public final void rule__DatatypeCS__TypeNameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4967:1: ( ( RULE_STRING ) )
            // InternalMiniOCLCS.g:4968:2: ( RULE_STRING )
            {
            // InternalMiniOCLCS.g:4968:2: ( RULE_STRING )
            // InternalMiniOCLCS.g:4969:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getDatatypeCSAccess().getTypeNameSTRINGTerminalRuleCall_3_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getDatatypeCSAccess().getTypeNameSTRINGTerminalRuleCall_3_0()); 
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
    // $ANTLR end "rule__DatatypeCS__TypeNameAssignment_3"


    // $ANTLR start "rule__PropertyCS__NameAssignment_1"
    // InternalMiniOCLCS.g:4978:1: rule__PropertyCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PropertyCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4982:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:4983:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:4983:2: ( RULE_ID )
            // InternalMiniOCLCS.g:4984:3: RULE_ID
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
    // InternalMiniOCLCS.g:4993:1: rule__PropertyCS__TypeRefAssignment_3 : ( rulePathNameCS ) ;
    public final void rule__PropertyCS__TypeRefAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4997:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:4998:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:4998:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:4999:3: rulePathNameCS
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


    // $ANTLR start "rule__PropertyCS__MultiplicityAssignment_4"
    // InternalMiniOCLCS.g:5008:1: rule__PropertyCS__MultiplicityAssignment_4 : ( ruleMultiplicityCS ) ;
    public final void rule__PropertyCS__MultiplicityAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5012:1: ( ( ruleMultiplicityCS ) )
            // InternalMiniOCLCS.g:5013:2: ( ruleMultiplicityCS )
            {
            // InternalMiniOCLCS.g:5013:2: ( ruleMultiplicityCS )
            // InternalMiniOCLCS.g:5014:3: ruleMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getMultiplicityMultiplicityCSParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPropertyCSAccess().getMultiplicityMultiplicityCSParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__PropertyCS__MultiplicityAssignment_4"


    // $ANTLR start "rule__MultiplicityCS__OptAssignment_1_0"
    // InternalMiniOCLCS.g:5023:1: rule__MultiplicityCS__OptAssignment_1_0 : ( ( '?' ) ) ;
    public final void rule__MultiplicityCS__OptAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5027:1: ( ( ( '?' ) ) )
            // InternalMiniOCLCS.g:5028:2: ( ( '?' ) )
            {
            // InternalMiniOCLCS.g:5028:2: ( ( '?' ) )
            // InternalMiniOCLCS.g:5029:3: ( '?' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getOptQuestionMarkKeyword_1_0_0()); 
            }
            // InternalMiniOCLCS.g:5030:3: ( '?' )
            // InternalMiniOCLCS.g:5031:4: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getOptQuestionMarkKeyword_1_0_0()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getOptQuestionMarkKeyword_1_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getOptQuestionMarkKeyword_1_0_0()); 
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
    // $ANTLR end "rule__MultiplicityCS__OptAssignment_1_0"


    // $ANTLR start "rule__MultiplicityCS__MultAssignment_1_1"
    // InternalMiniOCLCS.g:5042:1: rule__MultiplicityCS__MultAssignment_1_1 : ( ( '*' ) ) ;
    public final void rule__MultiplicityCS__MultAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5046:1: ( ( ( '*' ) ) )
            // InternalMiniOCLCS.g:5047:2: ( ( '*' ) )
            {
            // InternalMiniOCLCS.g:5047:2: ( ( '*' ) )
            // InternalMiniOCLCS.g:5048:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getMultAsteriskKeyword_1_1_0()); 
            }
            // InternalMiniOCLCS.g:5049:3: ( '*' )
            // InternalMiniOCLCS.g:5050:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getMultAsteriskKeyword_1_1_0()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getMultAsteriskKeyword_1_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getMultAsteriskKeyword_1_1_0()); 
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
    // $ANTLR end "rule__MultiplicityCS__MultAssignment_1_1"


    // $ANTLR start "rule__MultiplicityCS__LowerAssignment_1_2_0"
    // InternalMiniOCLCS.g:5061:1: rule__MultiplicityCS__LowerAssignment_1_2_0 : ( RULE_INT ) ;
    public final void rule__MultiplicityCS__LowerAssignment_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5065:1: ( ( RULE_INT ) )
            // InternalMiniOCLCS.g:5066:2: ( RULE_INT )
            {
            // InternalMiniOCLCS.g:5066:2: ( RULE_INT )
            // InternalMiniOCLCS.g:5067:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getLowerINTTerminalRuleCall_1_2_0_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getLowerINTTerminalRuleCall_1_2_0_0()); 
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
    // $ANTLR end "rule__MultiplicityCS__LowerAssignment_1_2_0"


    // $ANTLR start "rule__MultiplicityCS__UpperIntAssignment_1_2_2_0"
    // InternalMiniOCLCS.g:5076:1: rule__MultiplicityCS__UpperIntAssignment_1_2_2_0 : ( RULE_INT ) ;
    public final void rule__MultiplicityCS__UpperIntAssignment_1_2_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5080:1: ( ( RULE_INT ) )
            // InternalMiniOCLCS.g:5081:2: ( RULE_INT )
            {
            // InternalMiniOCLCS.g:5081:2: ( RULE_INT )
            // InternalMiniOCLCS.g:5082:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getUpperIntINTTerminalRuleCall_1_2_2_0_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getUpperIntINTTerminalRuleCall_1_2_2_0_0()); 
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
    // $ANTLR end "rule__MultiplicityCS__UpperIntAssignment_1_2_2_0"


    // $ANTLR start "rule__MultiplicityCS__UpperMultAssignment_1_2_2_1"
    // InternalMiniOCLCS.g:5091:1: rule__MultiplicityCS__UpperMultAssignment_1_2_2_1 : ( ( '*' ) ) ;
    public final void rule__MultiplicityCS__UpperMultAssignment_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5095:1: ( ( ( '*' ) ) )
            // InternalMiniOCLCS.g:5096:2: ( ( '*' ) )
            {
            // InternalMiniOCLCS.g:5096:2: ( ( '*' ) )
            // InternalMiniOCLCS.g:5097:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_2_2_1_0()); 
            }
            // InternalMiniOCLCS.g:5098:3: ( '*' )
            // InternalMiniOCLCS.g:5099:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_2_2_1_0()); 
            }
            match(input,46,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_2_2_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_2_2_1_0()); 
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
    // $ANTLR end "rule__MultiplicityCS__UpperMultAssignment_1_2_2_1"


    // $ANTLR start "rule__OperationCS__NameAssignment_1"
    // InternalMiniOCLCS.g:5110:1: rule__OperationCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OperationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5114:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5115:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5115:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5116:3: RULE_ID
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
    // InternalMiniOCLCS.g:5125:1: rule__OperationCS__ParamsAssignment_3_0 : ( ruleParameterCS ) ;
    public final void rule__OperationCS__ParamsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5129:1: ( ( ruleParameterCS ) )
            // InternalMiniOCLCS.g:5130:2: ( ruleParameterCS )
            {
            // InternalMiniOCLCS.g:5130:2: ( ruleParameterCS )
            // InternalMiniOCLCS.g:5131:3: ruleParameterCS
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
    // InternalMiniOCLCS.g:5140:1: rule__OperationCS__ParamsAssignment_3_1_1 : ( ruleParameterCS ) ;
    public final void rule__OperationCS__ParamsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5144:1: ( ( ruleParameterCS ) )
            // InternalMiniOCLCS.g:5145:2: ( ruleParameterCS )
            {
            // InternalMiniOCLCS.g:5145:2: ( ruleParameterCS )
            // InternalMiniOCLCS.g:5146:3: ruleParameterCS
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
    // InternalMiniOCLCS.g:5155:1: rule__OperationCS__ResultRefAssignment_6 : ( rulePathNameCS ) ;
    public final void rule__OperationCS__ResultRefAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5159:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5160:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5160:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5161:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5170:1: rule__OperationCS__BodyAssignment_8 : ( ruleExpCS ) ;
    public final void rule__OperationCS__BodyAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5174:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5175:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5175:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5176:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5185:1: rule__ParameterCS__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5189:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5190:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5190:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5191:3: RULE_ID
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
    // InternalMiniOCLCS.g:5200:1: rule__ParameterCS__TypeRefAssignment_2 : ( rulePathNameCS ) ;
    public final void rule__ParameterCS__TypeRefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5204:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5205:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5205:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5206:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5215:1: rule__ConstraintsDefCS__TypeRefAssignment_1 : ( rulePathNameCS ) ;
    public final void rule__ConstraintsDefCS__TypeRefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5219:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5220:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5220:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5221:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5230:1: rule__ConstraintsDefCS__InvariantsAssignment_3 : ( ruleInvariantCS ) ;
    public final void rule__ConstraintsDefCS__InvariantsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5234:1: ( ( ruleInvariantCS ) )
            // InternalMiniOCLCS.g:5235:2: ( ruleInvariantCS )
            {
            // InternalMiniOCLCS.g:5235:2: ( ruleInvariantCS )
            // InternalMiniOCLCS.g:5236:3: ruleInvariantCS
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
    // InternalMiniOCLCS.g:5245:1: rule__InvariantCS__ExpAssignment_2 : ( ruleExpCS ) ;
    public final void rule__InvariantCS__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5249:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5250:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5250:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5251:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5260:1: rule__LogicExpCS__OpAssignment_1_1 : ( ( rule__LogicExpCS__OpAlternatives_1_1_0 ) ) ;
    public final void rule__LogicExpCS__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5264:1: ( ( ( rule__LogicExpCS__OpAlternatives_1_1_0 ) ) )
            // InternalMiniOCLCS.g:5265:2: ( ( rule__LogicExpCS__OpAlternatives_1_1_0 ) )
            {
            // InternalMiniOCLCS.g:5265:2: ( ( rule__LogicExpCS__OpAlternatives_1_1_0 ) )
            // InternalMiniOCLCS.g:5266:3: ( rule__LogicExpCS__OpAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLogicExpCSAccess().getOpAlternatives_1_1_0()); 
            }
            // InternalMiniOCLCS.g:5267:3: ( rule__LogicExpCS__OpAlternatives_1_1_0 )
            // InternalMiniOCLCS.g:5267:4: rule__LogicExpCS__OpAlternatives_1_1_0
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
    // InternalMiniOCLCS.g:5275:1: rule__LogicExpCS__RightAssignment_1_2 : ( ruleCallExpCS ) ;
    public final void rule__LogicExpCS__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5279:1: ( ( ruleCallExpCS ) )
            // InternalMiniOCLCS.g:5280:2: ( ruleCallExpCS )
            {
            // InternalMiniOCLCS.g:5280:2: ( ruleCallExpCS )
            // InternalMiniOCLCS.g:5281:3: ruleCallExpCS
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
    // InternalMiniOCLCS.g:5290:1: rule__CallExpCS__OpAssignment_1_1 : ( ( rule__CallExpCS__OpAlternatives_1_1_0 ) ) ;
    public final void rule__CallExpCS__OpAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5294:1: ( ( ( rule__CallExpCS__OpAlternatives_1_1_0 ) ) )
            // InternalMiniOCLCS.g:5295:2: ( ( rule__CallExpCS__OpAlternatives_1_1_0 ) )
            {
            // InternalMiniOCLCS.g:5295:2: ( ( rule__CallExpCS__OpAlternatives_1_1_0 ) )
            // InternalMiniOCLCS.g:5296:3: ( rule__CallExpCS__OpAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getOpAlternatives_1_1_0()); 
            }
            // InternalMiniOCLCS.g:5297:3: ( rule__CallExpCS__OpAlternatives_1_1_0 )
            // InternalMiniOCLCS.g:5297:4: rule__CallExpCS__OpAlternatives_1_1_0
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


    // $ANTLR start "rule__CallExpCS__NavExpAssignment_1_2"
    // InternalMiniOCLCS.g:5305:1: rule__CallExpCS__NavExpAssignment_1_2 : ( ruleNavigationExpCS ) ;
    public final void rule__CallExpCS__NavExpAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5309:1: ( ( ruleNavigationExpCS ) )
            // InternalMiniOCLCS.g:5310:2: ( ruleNavigationExpCS )
            {
            // InternalMiniOCLCS.g:5310:2: ( ruleNavigationExpCS )
            // InternalMiniOCLCS.g:5311:3: ruleNavigationExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getNavExpNavigationExpCSParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleNavigationExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getNavExpNavigationExpCSParserRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__CallExpCS__NavExpAssignment_1_2"


    // $ANTLR start "rule__CollectExpCS__ItVarAssignment_2_0"
    // InternalMiniOCLCS.g:5320:1: rule__CollectExpCS__ItVarAssignment_2_0 : ( ruleIteratorVarCS ) ;
    public final void rule__CollectExpCS__ItVarAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5324:1: ( ( ruleIteratorVarCS ) )
            // InternalMiniOCLCS.g:5325:2: ( ruleIteratorVarCS )
            {
            // InternalMiniOCLCS.g:5325:2: ( ruleIteratorVarCS )
            // InternalMiniOCLCS.g:5326:3: ruleIteratorVarCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleIteratorVarCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0_0()); 
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
    // $ANTLR end "rule__CollectExpCS__ItVarAssignment_2_0"


    // $ANTLR start "rule__CollectExpCS__ExpAssignment_3"
    // InternalMiniOCLCS.g:5335:1: rule__CollectExpCS__ExpAssignment_3 : ( ruleExpCS ) ;
    public final void rule__CollectExpCS__ExpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5339:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5340:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5340:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5341:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getExpExpCSParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectExpCSAccess().getExpExpCSParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__CollectExpCS__ExpAssignment_3"


    // $ANTLR start "rule__IteratorVarCS__ItNameAssignment_0"
    // InternalMiniOCLCS.g:5350:1: rule__IteratorVarCS__ItNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__IteratorVarCS__ItNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5354:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5355:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5355:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5356:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getItNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIteratorVarCSAccess().getItNameIDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__IteratorVarCS__ItNameAssignment_0"


    // $ANTLR start "rule__IteratorVarCS__ItTypeAssignment_1_1"
    // InternalMiniOCLCS.g:5365:1: rule__IteratorVarCS__ItTypeAssignment_1_1 : ( rulePathNameCS ) ;
    public final void rule__IteratorVarCS__ItTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5369:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5370:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5370:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5371:3: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getItTypePathNameCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIteratorVarCSAccess().getItTypePathNameCSParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__IteratorVarCS__ItTypeAssignment_1_1"


    // $ANTLR start "rule__IterateExpCS__ItVarAssignment_2"
    // InternalMiniOCLCS.g:5380:1: rule__IterateExpCS__ItVarAssignment_2 : ( ruleIteratorVarCS ) ;
    public final void rule__IterateExpCS__ItVarAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5384:1: ( ( ruleIteratorVarCS ) )
            // InternalMiniOCLCS.g:5385:2: ( ruleIteratorVarCS )
            {
            // InternalMiniOCLCS.g:5385:2: ( ruleIteratorVarCS )
            // InternalMiniOCLCS.g:5386:3: ruleIteratorVarCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleIteratorVarCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getItVarIteratorVarCSParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__IterateExpCS__ItVarAssignment_2"


    // $ANTLR start "rule__IterateExpCS__AccVarAssignment_4"
    // InternalMiniOCLCS.g:5395:1: rule__IterateExpCS__AccVarAssignment_4 : ( ruleAccVarCS ) ;
    public final void rule__IterateExpCS__AccVarAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5399:1: ( ( ruleAccVarCS ) )
            // InternalMiniOCLCS.g:5400:2: ( ruleAccVarCS )
            {
            // InternalMiniOCLCS.g:5400:2: ( ruleAccVarCS )
            // InternalMiniOCLCS.g:5401:3: ruleAccVarCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getAccVarAccVarCSParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleAccVarCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getAccVarAccVarCSParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__IterateExpCS__AccVarAssignment_4"


    // $ANTLR start "rule__IterateExpCS__ExpAssignment_6"
    // InternalMiniOCLCS.g:5410:1: rule__IterateExpCS__ExpAssignment_6 : ( ruleExpCS ) ;
    public final void rule__IterateExpCS__ExpAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5414:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5415:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5415:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5416:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getExpExpCSParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIterateExpCSAccess().getExpExpCSParserRuleCall_6_0()); 
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
    // $ANTLR end "rule__IterateExpCS__ExpAssignment_6"


    // $ANTLR start "rule__AccVarCS__AccNameAssignment_0"
    // InternalMiniOCLCS.g:5425:1: rule__AccVarCS__AccNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AccVarCS__AccNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5429:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5430:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5430:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5431:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getAccNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getAccNameIDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__AccVarCS__AccNameAssignment_0"


    // $ANTLR start "rule__AccVarCS__AccTypeAssignment_1_1"
    // InternalMiniOCLCS.g:5440:1: rule__AccVarCS__AccTypeAssignment_1_1 : ( rulePathNameCS ) ;
    public final void rule__AccVarCS__AccTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5444:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5445:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5445:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5446:3: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getAccTypePathNameCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getAccTypePathNameCSParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__AccVarCS__AccTypeAssignment_1_1"


    // $ANTLR start "rule__AccVarCS__AccInitExpAssignment_3"
    // InternalMiniOCLCS.g:5455:1: rule__AccVarCS__AccInitExpAssignment_3 : ( ruleExpCS ) ;
    public final void rule__AccVarCS__AccInitExpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5459:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5460:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5460:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5461:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getAccInitExpExpCSParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAccVarCSAccess().getAccInitExpExpCSParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__AccVarCS__AccInitExpAssignment_3"


    // $ANTLR start "rule__NameExpCS__ExpNameAssignment_0"
    // InternalMiniOCLCS.g:5470:1: rule__NameExpCS__ExpNameAssignment_0 : ( rulePathNameCS ) ;
    public final void rule__NameExpCS__ExpNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5474:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5475:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5475:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5476:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5485:1: rule__NameExpCS__RoundedBracketsAssignment_1 : ( ruleRoundedBracketClauseCS ) ;
    public final void rule__NameExpCS__RoundedBracketsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5489:1: ( ( ruleRoundedBracketClauseCS ) )
            // InternalMiniOCLCS.g:5490:2: ( ruleRoundedBracketClauseCS )
            {
            // InternalMiniOCLCS.g:5490:2: ( ruleRoundedBracketClauseCS )
            // InternalMiniOCLCS.g:5491:3: ruleRoundedBracketClauseCS
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
    // InternalMiniOCLCS.g:5500:1: rule__RoundedBracketClauseCS__ArgsAssignment_2_0 : ( ruleExpCS ) ;
    public final void rule__RoundedBracketClauseCS__ArgsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5504:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5505:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5505:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5506:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5515:1: rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 : ( ruleExpCS ) ;
    public final void rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5519:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5520:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5520:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5521:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5530:1: rule__IntLiteralExpCS__IntSymbolAssignment : ( RULE_INT ) ;
    public final void rule__IntLiteralExpCS__IntSymbolAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5534:1: ( ( RULE_INT ) )
            // InternalMiniOCLCS.g:5535:2: ( RULE_INT )
            {
            // InternalMiniOCLCS.g:5535:2: ( RULE_INT )
            // InternalMiniOCLCS.g:5536:3: RULE_INT
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


    // $ANTLR start "rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0"
    // InternalMiniOCLCS.g:5545:1: rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5549:1: ( ( ( 'true' ) ) )
            // InternalMiniOCLCS.g:5550:2: ( ( 'true' ) )
            {
            // InternalMiniOCLCS.g:5550:2: ( ( 'true' ) )
            // InternalMiniOCLCS.g:5551:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0()); 
            }
            // InternalMiniOCLCS.g:5552:3: ( 'true' )
            // InternalMiniOCLCS.g:5553:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0()); 
            }
            match(input,47,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__CollectionLiteralExpCS__KindAssignment_0"
    // InternalMiniOCLCS.g:5564:1: rule__CollectionLiteralExpCS__KindAssignment_0 : ( ruleCollectionKindCS ) ;
    public final void rule__CollectionLiteralExpCS__KindAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5568:1: ( ( ruleCollectionKindCS ) )
            // InternalMiniOCLCS.g:5569:2: ( ruleCollectionKindCS )
            {
            // InternalMiniOCLCS.g:5569:2: ( ruleCollectionKindCS )
            // InternalMiniOCLCS.g:5570:3: ruleCollectionKindCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getKindCollectionKindCSEnumRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCollectionKindCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralExpCSAccess().getKindCollectionKindCSEnumRuleCall_0_0()); 
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
    // $ANTLR end "rule__CollectionLiteralExpCS__KindAssignment_0"


    // $ANTLR start "rule__CollectionLiteralExpCS__PartsAssignment_2"
    // InternalMiniOCLCS.g:5579:1: rule__CollectionLiteralExpCS__PartsAssignment_2 : ( ruleCollectionLiteralPartCS ) ;
    public final void rule__CollectionLiteralExpCS__PartsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5583:1: ( ( ruleCollectionLiteralPartCS ) )
            // InternalMiniOCLCS.g:5584:2: ( ruleCollectionLiteralPartCS )
            {
            // InternalMiniOCLCS.g:5584:2: ( ruleCollectionLiteralPartCS )
            // InternalMiniOCLCS.g:5585:3: ruleCollectionLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getPartsCollectionLiteralPartCSParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralExpCSAccess().getPartsCollectionLiteralPartCSParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__CollectionLiteralExpCS__PartsAssignment_2"


    // $ANTLR start "rule__CollectionLiteralPartCS__FirstAssignment_0"
    // InternalMiniOCLCS.g:5594:1: rule__CollectionLiteralPartCS__FirstAssignment_0 : ( ruleExpCS ) ;
    public final void rule__CollectionLiteralPartCS__FirstAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5598:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5599:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5599:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5600:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getFirstExpCSParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralPartCSAccess().getFirstExpCSParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__CollectionLiteralPartCS__FirstAssignment_0"


    // $ANTLR start "rule__CollectionLiteralPartCS__LastAssignment_1_1"
    // InternalMiniOCLCS.g:5609:1: rule__CollectionLiteralPartCS__LastAssignment_1_1 : ( ruleExpCS ) ;
    public final void rule__CollectionLiteralPartCS__LastAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5613:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5614:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5614:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5615:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpCSParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__CollectionLiteralPartCS__LastAssignment_1_1"


    // $ANTLR start "rule__LetExpCS__LetVarsAssignment_1"
    // InternalMiniOCLCS.g:5624:1: rule__LetExpCS__LetVarsAssignment_1 : ( ruleLetVarCS ) ;
    public final void rule__LetExpCS__LetVarsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5628:1: ( ( ruleLetVarCS ) )
            // InternalMiniOCLCS.g:5629:2: ( ruleLetVarCS )
            {
            // InternalMiniOCLCS.g:5629:2: ( ruleLetVarCS )
            // InternalMiniOCLCS.g:5630:3: ruleLetVarCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getLetVarsLetVarCSParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLetVarCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getLetVarsLetVarCSParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__LetExpCS__LetVarsAssignment_1"


    // $ANTLR start "rule__LetExpCS__LetVarsAssignment_2_1"
    // InternalMiniOCLCS.g:5639:1: rule__LetExpCS__LetVarsAssignment_2_1 : ( ruleLetVarCS ) ;
    public final void rule__LetExpCS__LetVarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5643:1: ( ( ruleLetVarCS ) )
            // InternalMiniOCLCS.g:5644:2: ( ruleLetVarCS )
            {
            // InternalMiniOCLCS.g:5644:2: ( ruleLetVarCS )
            // InternalMiniOCLCS.g:5645:3: ruleLetVarCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getLetVarsLetVarCSParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleLetVarCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getLetVarsLetVarCSParserRuleCall_2_1_0()); 
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
    // $ANTLR end "rule__LetExpCS__LetVarsAssignment_2_1"


    // $ANTLR start "rule__LetExpCS__InExpAssignment_4"
    // InternalMiniOCLCS.g:5654:1: rule__LetExpCS__InExpAssignment_4 : ( ruleExpCS ) ;
    public final void rule__LetExpCS__InExpAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5658:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5659:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5659:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5660:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getInExpExpCSParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetExpCSAccess().getInExpExpCSParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__LetExpCS__InExpAssignment_4"


    // $ANTLR start "rule__LetVarCS__NameAssignment_0"
    // InternalMiniOCLCS.g:5669:1: rule__LetVarCS__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__LetVarCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5673:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5674:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5674:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5675:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getNameIDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getNameIDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__LetVarCS__NameAssignment_0"


    // $ANTLR start "rule__LetVarCS__TypeRefAssignment_1_1"
    // InternalMiniOCLCS.g:5684:1: rule__LetVarCS__TypeRefAssignment_1_1 : ( rulePathNameCS ) ;
    public final void rule__LetVarCS__TypeRefAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5688:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5689:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5689:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5690:3: rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getTypeRefPathNameCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathNameCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getTypeRefPathNameCSParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__LetVarCS__TypeRefAssignment_1_1"


    // $ANTLR start "rule__LetVarCS__InitExpAssignment_3"
    // InternalMiniOCLCS.g:5699:1: rule__LetVarCS__InitExpAssignment_3 : ( ruleExpCS ) ;
    public final void rule__LetVarCS__InitExpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5703:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5704:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5704:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5705:3: ruleExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getInitExpExpCSParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getLetVarCSAccess().getInitExpExpCSParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__LetVarCS__InitExpAssignment_3"


    // $ANTLR start "rule__PathNameCS__PathElementsAssignment_0"
    // InternalMiniOCLCS.g:5714:1: rule__PathNameCS__PathElementsAssignment_0 : ( rulePathElementCS ) ;
    public final void rule__PathNameCS__PathElementsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5718:1: ( ( rulePathElementCS ) )
            // InternalMiniOCLCS.g:5719:2: ( rulePathElementCS )
            {
            // InternalMiniOCLCS.g:5719:2: ( rulePathElementCS )
            // InternalMiniOCLCS.g:5720:3: rulePathElementCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getPathElementsPathElementCSParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePathElementCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPathNameCSAccess().getPathElementsPathElementCSParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__PathNameCS__PathElementsAssignment_0"


    // $ANTLR start "rule__PathNameCS__PathElementsAssignment_1_1"
    // InternalMiniOCLCS.g:5729:1: rule__PathNameCS__PathElementsAssignment_1_1 : ( rulePathElementCS ) ;
    public final void rule__PathNameCS__PathElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5733:1: ( ( rulePathElementCS ) )
            // InternalMiniOCLCS.g:5734:2: ( rulePathElementCS )
            {
            // InternalMiniOCLCS.g:5734:2: ( rulePathElementCS )
            // InternalMiniOCLCS.g:5735:3: rulePathElementCS
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
    // InternalMiniOCLCS.g:5744:1: rule__PathElementCS__ElementNameAssignment : ( RULE_ID ) ;
    public final void rule__PathElementCS__ElementNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5748:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5749:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5749:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5750:3: RULE_ID
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

    // $ANTLR start synpred29_InternalMiniOCLCS
    public final void synpred29_InternalMiniOCLCS_fragment() throws RecognitionException {   
        // InternalMiniOCLCS.g:2806:3: ( rule__LogicExpCS__Group_1__0 )
        // InternalMiniOCLCS.g:2806:3: rule__LogicExpCS__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__LogicExpCS__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalMiniOCLCS

    // $ANTLR start synpred30_InternalMiniOCLCS
    public final void synpred30_InternalMiniOCLCS_fragment() throws RecognitionException {   
        // InternalMiniOCLCS.g:2941:3: ( rule__CallExpCS__Group_1__0 )
        // InternalMiniOCLCS.g:2941:3: rule__CallExpCS__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__CallExpCS__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalMiniOCLCS

    // Delegated rules

    public final boolean synpred30_InternalMiniOCLCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalMiniOCLCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalMiniOCLCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalMiniOCLCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000800100002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000002D00000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002900002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000080407000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000080007002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000600000000040L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000862000080850L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000001000400000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000014000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000004008000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000862200080850L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000800000080000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000862000480850L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000862000080852L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000080400000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000100000000002L});

}