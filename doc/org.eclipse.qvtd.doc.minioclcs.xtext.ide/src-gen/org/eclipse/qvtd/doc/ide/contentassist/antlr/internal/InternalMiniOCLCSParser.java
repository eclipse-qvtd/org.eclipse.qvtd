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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Collection'", "'='", "'<>'", "'.'", "'->'", "'false'", "'import'", "';'", "':'", "'package'", "'{'", "'}'", "'class'", "'extends'", "'prop'", "'['", "']'", "'..'", "'op'", "'('", "')'", "','", "'context'", "'inv'", "'self'", "'collect'", "'|'", "'iterate'", "'null'", "'let'", "'in'", "'::'", "'?'", "'*'", "'true'"
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
    // InternalMiniOCLCS.g:63:1: ruleRootCS : ( ( rule__RootCS__Group__0 ) ) ;
    public final void ruleRootCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:67:2: ( ( ( rule__RootCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:68:2: ( ( rule__RootCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:68:2: ( ( rule__RootCS__Group__0 ) )
            // InternalMiniOCLCS.g:69:3: ( rule__RootCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:70:3: ( rule__RootCS__Group__0 )
            // InternalMiniOCLCS.g:70:4: rule__RootCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RootCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSAccess().getGroup()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleImportCS"
    // InternalMiniOCLCS.g:79:1: entryRuleImportCS : ruleImportCS EOF ;
    public final void entryRuleImportCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:80:1: ( ruleImportCS EOF )
            // InternalMiniOCLCS.g:81:1: ruleImportCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleImportCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSRule()); 
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
    // $ANTLR end "entryRuleImportCS"


    // $ANTLR start "ruleImportCS"
    // InternalMiniOCLCS.g:88:1: ruleImportCS : ( ( rule__ImportCS__Group__0 ) ) ;
    public final void ruleImportCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:92:2: ( ( ( rule__ImportCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:93:2: ( ( rule__ImportCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:93:2: ( ( rule__ImportCS__Group__0 ) )
            // InternalMiniOCLCS.g:94:3: ( rule__ImportCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:95:3: ( rule__ImportCS__Group__0 )
            // InternalMiniOCLCS.g:95:4: rule__ImportCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImportCS"


    // $ANTLR start "entryRulePackageCS"
    // InternalMiniOCLCS.g:104:1: entryRulePackageCS : rulePackageCS EOF ;
    public final void entryRulePackageCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:105:1: ( rulePackageCS EOF )
            // InternalMiniOCLCS.g:106:1: rulePackageCS EOF
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
    // InternalMiniOCLCS.g:113:1: rulePackageCS : ( ( rule__PackageCS__Group__0 ) ) ;
    public final void rulePackageCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:117:2: ( ( ( rule__PackageCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:118:2: ( ( rule__PackageCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:118:2: ( ( rule__PackageCS__Group__0 ) )
            // InternalMiniOCLCS.g:119:3: ( rule__PackageCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:120:3: ( rule__PackageCS__Group__0 )
            // InternalMiniOCLCS.g:120:4: rule__PackageCS__Group__0
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


    // $ANTLR start "entryRulePropertyCS"
    // InternalMiniOCLCS.g:154:1: entryRulePropertyCS : rulePropertyCS EOF ;
    public final void entryRulePropertyCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:155:1: ( rulePropertyCS EOF )
            // InternalMiniOCLCS.g:156:1: rulePropertyCS EOF
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
    // InternalMiniOCLCS.g:163:1: rulePropertyCS : ( ( rule__PropertyCS__Group__0 ) ) ;
    public final void rulePropertyCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:167:2: ( ( ( rule__PropertyCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:168:2: ( ( rule__PropertyCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:168:2: ( ( rule__PropertyCS__Group__0 ) )
            // InternalMiniOCLCS.g:169:3: ( rule__PropertyCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:170:3: ( rule__PropertyCS__Group__0 )
            // InternalMiniOCLCS.g:170:4: rule__PropertyCS__Group__0
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
    // InternalMiniOCLCS.g:179:1: entryRuleMultiplicityCS : ruleMultiplicityCS EOF ;
    public final void entryRuleMultiplicityCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:180:1: ( ruleMultiplicityCS EOF )
            // InternalMiniOCLCS.g:181:1: ruleMultiplicityCS EOF
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
    // InternalMiniOCLCS.g:188:1: ruleMultiplicityCS : ( ( rule__MultiplicityCS__Group__0 ) ) ;
    public final void ruleMultiplicityCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:192:2: ( ( ( rule__MultiplicityCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:193:2: ( ( rule__MultiplicityCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:193:2: ( ( rule__MultiplicityCS__Group__0 ) )
            // InternalMiniOCLCS.g:194:3: ( rule__MultiplicityCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:195:3: ( rule__MultiplicityCS__Group__0 )
            // InternalMiniOCLCS.g:195:4: rule__MultiplicityCS__Group__0
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
    // InternalMiniOCLCS.g:204:1: entryRuleOperationCS : ruleOperationCS EOF ;
    public final void entryRuleOperationCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:205:1: ( ruleOperationCS EOF )
            // InternalMiniOCLCS.g:206:1: ruleOperationCS EOF
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
    // InternalMiniOCLCS.g:213:1: ruleOperationCS : ( ( rule__OperationCS__Group__0 ) ) ;
    public final void ruleOperationCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:217:2: ( ( ( rule__OperationCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:218:2: ( ( rule__OperationCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:218:2: ( ( rule__OperationCS__Group__0 ) )
            // InternalMiniOCLCS.g:219:3: ( rule__OperationCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:220:3: ( rule__OperationCS__Group__0 )
            // InternalMiniOCLCS.g:220:4: rule__OperationCS__Group__0
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
    // InternalMiniOCLCS.g:229:1: entryRuleParameterCS : ruleParameterCS EOF ;
    public final void entryRuleParameterCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:230:1: ( ruleParameterCS EOF )
            // InternalMiniOCLCS.g:231:1: ruleParameterCS EOF
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
    // InternalMiniOCLCS.g:238:1: ruleParameterCS : ( ( rule__ParameterCS__Group__0 ) ) ;
    public final void ruleParameterCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:242:2: ( ( ( rule__ParameterCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:243:2: ( ( rule__ParameterCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:243:2: ( ( rule__ParameterCS__Group__0 ) )
            // InternalMiniOCLCS.g:244:3: ( rule__ParameterCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:245:3: ( rule__ParameterCS__Group__0 )
            // InternalMiniOCLCS.g:245:4: rule__ParameterCS__Group__0
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
    // InternalMiniOCLCS.g:254:1: entryRuleConstraintsDefCS : ruleConstraintsDefCS EOF ;
    public final void entryRuleConstraintsDefCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:255:1: ( ruleConstraintsDefCS EOF )
            // InternalMiniOCLCS.g:256:1: ruleConstraintsDefCS EOF
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
    // InternalMiniOCLCS.g:263:1: ruleConstraintsDefCS : ( ( rule__ConstraintsDefCS__Group__0 ) ) ;
    public final void ruleConstraintsDefCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:267:2: ( ( ( rule__ConstraintsDefCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:268:2: ( ( rule__ConstraintsDefCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:268:2: ( ( rule__ConstraintsDefCS__Group__0 ) )
            // InternalMiniOCLCS.g:269:3: ( rule__ConstraintsDefCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:270:3: ( rule__ConstraintsDefCS__Group__0 )
            // InternalMiniOCLCS.g:270:4: rule__ConstraintsDefCS__Group__0
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
    // InternalMiniOCLCS.g:279:1: entryRuleInvariantCS : ruleInvariantCS EOF ;
    public final void entryRuleInvariantCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:280:1: ( ruleInvariantCS EOF )
            // InternalMiniOCLCS.g:281:1: ruleInvariantCS EOF
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
    // InternalMiniOCLCS.g:288:1: ruleInvariantCS : ( ( rule__InvariantCS__Group__0 ) ) ;
    public final void ruleInvariantCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:292:2: ( ( ( rule__InvariantCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:293:2: ( ( rule__InvariantCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:293:2: ( ( rule__InvariantCS__Group__0 ) )
            // InternalMiniOCLCS.g:294:3: ( rule__InvariantCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:295:3: ( rule__InvariantCS__Group__0 )
            // InternalMiniOCLCS.g:295:4: rule__InvariantCS__Group__0
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
    // InternalMiniOCLCS.g:304:1: entryRuleExpCS : ruleExpCS EOF ;
    public final void entryRuleExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:305:1: ( ruleExpCS EOF )
            // InternalMiniOCLCS.g:306:1: ruleExpCS EOF
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
    // InternalMiniOCLCS.g:313:1: ruleExpCS : ( ruleEqualityExpCS ) ;
    public final void ruleExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:317:2: ( ( ruleEqualityExpCS ) )
            // InternalMiniOCLCS.g:318:2: ( ruleEqualityExpCS )
            {
            // InternalMiniOCLCS.g:318:2: ( ruleEqualityExpCS )
            // InternalMiniOCLCS.g:319:3: ruleEqualityExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getExpCSAccess().getEqualityExpCSParserRuleCall()); 
            }
            pushFollow(FOLLOW_2);
            ruleEqualityExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getExpCSAccess().getEqualityExpCSParserRuleCall()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleEqualityExpCS"
    // InternalMiniOCLCS.g:329:1: entryRuleEqualityExpCS : ruleEqualityExpCS EOF ;
    public final void entryRuleEqualityExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:330:1: ( ruleEqualityExpCS EOF )
            // InternalMiniOCLCS.g:331:1: ruleEqualityExpCS EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpCSRule()); 
            }
            pushFollow(FOLLOW_1);
            ruleEqualityExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpCSRule()); 
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
    // $ANTLR end "entryRuleEqualityExpCS"


    // $ANTLR start "ruleEqualityExpCS"
    // InternalMiniOCLCS.g:338:1: ruleEqualityExpCS : ( ( rule__EqualityExpCS__Group__0 ) ) ;
    public final void ruleEqualityExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:342:2: ( ( ( rule__EqualityExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:343:2: ( ( rule__EqualityExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:343:2: ( ( rule__EqualityExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:344:3: ( rule__EqualityExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:345:3: ( rule__EqualityExpCS__Group__0 )
            // InternalMiniOCLCS.g:345:4: rule__EqualityExpCS__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpCS__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpCSAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEqualityExpCS"


    // $ANTLR start "entryRuleCallExpCS"
    // InternalMiniOCLCS.g:354:1: entryRuleCallExpCS : ruleCallExpCS EOF ;
    public final void entryRuleCallExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:355:1: ( ruleCallExpCS EOF )
            // InternalMiniOCLCS.g:356:1: ruleCallExpCS EOF
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
    // InternalMiniOCLCS.g:363:1: ruleCallExpCS : ( ( rule__CallExpCS__Group__0 ) ) ;
    public final void ruleCallExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:367:2: ( ( ( rule__CallExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:368:2: ( ( rule__CallExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:368:2: ( ( rule__CallExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:369:3: ( rule__CallExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:370:3: ( rule__CallExpCS__Group__0 )
            // InternalMiniOCLCS.g:370:4: rule__CallExpCS__Group__0
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
    // InternalMiniOCLCS.g:379:1: entryRulePrimaryExpCS : rulePrimaryExpCS EOF ;
    public final void entryRulePrimaryExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:380:1: ( rulePrimaryExpCS EOF )
            // InternalMiniOCLCS.g:381:1: rulePrimaryExpCS EOF
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
    // InternalMiniOCLCS.g:388:1: rulePrimaryExpCS : ( ( rule__PrimaryExpCS__Alternatives ) ) ;
    public final void rulePrimaryExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:392:2: ( ( ( rule__PrimaryExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:393:2: ( ( rule__PrimaryExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:393:2: ( ( rule__PrimaryExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:394:3: ( rule__PrimaryExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimaryExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:395:3: ( rule__PrimaryExpCS__Alternatives )
            // InternalMiniOCLCS.g:395:4: rule__PrimaryExpCS__Alternatives
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
    // InternalMiniOCLCS.g:404:1: entryRuleSelfExpCS : ruleSelfExpCS EOF ;
    public final void entryRuleSelfExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:405:1: ( ruleSelfExpCS EOF )
            // InternalMiniOCLCS.g:406:1: ruleSelfExpCS EOF
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
    // InternalMiniOCLCS.g:413:1: ruleSelfExpCS : ( ( rule__SelfExpCS__Group__0 ) ) ;
    public final void ruleSelfExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:417:2: ( ( ( rule__SelfExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:418:2: ( ( rule__SelfExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:418:2: ( ( rule__SelfExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:419:3: ( rule__SelfExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:420:3: ( rule__SelfExpCS__Group__0 )
            // InternalMiniOCLCS.g:420:4: rule__SelfExpCS__Group__0
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
    // InternalMiniOCLCS.g:429:1: entryRuleNavigationExpCS : ruleNavigationExpCS EOF ;
    public final void entryRuleNavigationExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:430:1: ( ruleNavigationExpCS EOF )
            // InternalMiniOCLCS.g:431:1: ruleNavigationExpCS EOF
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
    // InternalMiniOCLCS.g:438:1: ruleNavigationExpCS : ( ( rule__NavigationExpCS__Alternatives ) ) ;
    public final void ruleNavigationExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:442:2: ( ( ( rule__NavigationExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:443:2: ( ( rule__NavigationExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:443:2: ( ( rule__NavigationExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:444:3: ( rule__NavigationExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNavigationExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:445:3: ( rule__NavigationExpCS__Alternatives )
            // InternalMiniOCLCS.g:445:4: rule__NavigationExpCS__Alternatives
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
    // InternalMiniOCLCS.g:454:1: entryRuleLoopExpCS : ruleLoopExpCS EOF ;
    public final void entryRuleLoopExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:455:1: ( ruleLoopExpCS EOF )
            // InternalMiniOCLCS.g:456:1: ruleLoopExpCS EOF
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
    // InternalMiniOCLCS.g:463:1: ruleLoopExpCS : ( ( rule__LoopExpCS__Alternatives ) ) ;
    public final void ruleLoopExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:467:2: ( ( ( rule__LoopExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:468:2: ( ( rule__LoopExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:468:2: ( ( rule__LoopExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:469:3: ( rule__LoopExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLoopExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:470:3: ( rule__LoopExpCS__Alternatives )
            // InternalMiniOCLCS.g:470:4: rule__LoopExpCS__Alternatives
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
    // InternalMiniOCLCS.g:479:1: entryRuleCollectExpCS : ruleCollectExpCS EOF ;
    public final void entryRuleCollectExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:480:1: ( ruleCollectExpCS EOF )
            // InternalMiniOCLCS.g:481:1: ruleCollectExpCS EOF
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
    // InternalMiniOCLCS.g:488:1: ruleCollectExpCS : ( ( rule__CollectExpCS__Group__0 ) ) ;
    public final void ruleCollectExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:492:2: ( ( ( rule__CollectExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:493:2: ( ( rule__CollectExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:493:2: ( ( rule__CollectExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:494:3: ( rule__CollectExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:495:3: ( rule__CollectExpCS__Group__0 )
            // InternalMiniOCLCS.g:495:4: rule__CollectExpCS__Group__0
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
    // InternalMiniOCLCS.g:504:1: entryRuleIteratorVarCS : ruleIteratorVarCS EOF ;
    public final void entryRuleIteratorVarCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:505:1: ( ruleIteratorVarCS EOF )
            // InternalMiniOCLCS.g:506:1: ruleIteratorVarCS EOF
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
    // InternalMiniOCLCS.g:513:1: ruleIteratorVarCS : ( ( rule__IteratorVarCS__Group__0 ) ) ;
    public final void ruleIteratorVarCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:517:2: ( ( ( rule__IteratorVarCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:518:2: ( ( rule__IteratorVarCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:518:2: ( ( rule__IteratorVarCS__Group__0 ) )
            // InternalMiniOCLCS.g:519:3: ( rule__IteratorVarCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:520:3: ( rule__IteratorVarCS__Group__0 )
            // InternalMiniOCLCS.g:520:4: rule__IteratorVarCS__Group__0
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
    // InternalMiniOCLCS.g:529:1: entryRuleIterateExpCS : ruleIterateExpCS EOF ;
    public final void entryRuleIterateExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:530:1: ( ruleIterateExpCS EOF )
            // InternalMiniOCLCS.g:531:1: ruleIterateExpCS EOF
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
    // InternalMiniOCLCS.g:538:1: ruleIterateExpCS : ( ( rule__IterateExpCS__Group__0 ) ) ;
    public final void ruleIterateExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:542:2: ( ( ( rule__IterateExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:543:2: ( ( rule__IterateExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:543:2: ( ( rule__IterateExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:544:3: ( rule__IterateExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:545:3: ( rule__IterateExpCS__Group__0 )
            // InternalMiniOCLCS.g:545:4: rule__IterateExpCS__Group__0
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
    // InternalMiniOCLCS.g:554:1: entryRuleAccVarCS : ruleAccVarCS EOF ;
    public final void entryRuleAccVarCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:555:1: ( ruleAccVarCS EOF )
            // InternalMiniOCLCS.g:556:1: ruleAccVarCS EOF
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
    // InternalMiniOCLCS.g:563:1: ruleAccVarCS : ( ( rule__AccVarCS__Group__0 ) ) ;
    public final void ruleAccVarCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:567:2: ( ( ( rule__AccVarCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:568:2: ( ( rule__AccVarCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:568:2: ( ( rule__AccVarCS__Group__0 ) )
            // InternalMiniOCLCS.g:569:3: ( rule__AccVarCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:570:3: ( rule__AccVarCS__Group__0 )
            // InternalMiniOCLCS.g:570:4: rule__AccVarCS__Group__0
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
    // InternalMiniOCLCS.g:579:1: entryRuleNameExpCS : ruleNameExpCS EOF ;
    public final void entryRuleNameExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:580:1: ( ruleNameExpCS EOF )
            // InternalMiniOCLCS.g:581:1: ruleNameExpCS EOF
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
    // InternalMiniOCLCS.g:588:1: ruleNameExpCS : ( ( rule__NameExpCS__Group__0 ) ) ;
    public final void ruleNameExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:592:2: ( ( ( rule__NameExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:593:2: ( ( rule__NameExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:593:2: ( ( rule__NameExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:594:3: ( rule__NameExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:595:3: ( rule__NameExpCS__Group__0 )
            // InternalMiniOCLCS.g:595:4: rule__NameExpCS__Group__0
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
    // InternalMiniOCLCS.g:604:1: entryRuleRoundedBracketClauseCS : ruleRoundedBracketClauseCS EOF ;
    public final void entryRuleRoundedBracketClauseCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:605:1: ( ruleRoundedBracketClauseCS EOF )
            // InternalMiniOCLCS.g:606:1: ruleRoundedBracketClauseCS EOF
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
    // InternalMiniOCLCS.g:613:1: ruleRoundedBracketClauseCS : ( ( rule__RoundedBracketClauseCS__Group__0 ) ) ;
    public final void ruleRoundedBracketClauseCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:617:2: ( ( ( rule__RoundedBracketClauseCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:618:2: ( ( rule__RoundedBracketClauseCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:618:2: ( ( rule__RoundedBracketClauseCS__Group__0 ) )
            // InternalMiniOCLCS.g:619:3: ( rule__RoundedBracketClauseCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:620:3: ( rule__RoundedBracketClauseCS__Group__0 )
            // InternalMiniOCLCS.g:620:4: rule__RoundedBracketClauseCS__Group__0
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
    // InternalMiniOCLCS.g:629:1: entryRuleLiteralExpCS : ruleLiteralExpCS EOF ;
    public final void entryRuleLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:630:1: ( ruleLiteralExpCS EOF )
            // InternalMiniOCLCS.g:631:1: ruleLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:638:1: ruleLiteralExpCS : ( ( rule__LiteralExpCS__Alternatives ) ) ;
    public final void ruleLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:642:2: ( ( ( rule__LiteralExpCS__Alternatives ) ) )
            // InternalMiniOCLCS.g:643:2: ( ( rule__LiteralExpCS__Alternatives ) )
            {
            // InternalMiniOCLCS.g:643:2: ( ( rule__LiteralExpCS__Alternatives ) )
            // InternalMiniOCLCS.g:644:3: ( rule__LiteralExpCS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLiteralExpCSAccess().getAlternatives()); 
            }
            // InternalMiniOCLCS.g:645:3: ( rule__LiteralExpCS__Alternatives )
            // InternalMiniOCLCS.g:645:4: rule__LiteralExpCS__Alternatives
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
    // InternalMiniOCLCS.g:654:1: entryRuleIntLiteralExpCS : ruleIntLiteralExpCS EOF ;
    public final void entryRuleIntLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:655:1: ( ruleIntLiteralExpCS EOF )
            // InternalMiniOCLCS.g:656:1: ruleIntLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:663:1: ruleIntLiteralExpCS : ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) ) ;
    public final void ruleIntLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:667:2: ( ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) ) )
            // InternalMiniOCLCS.g:668:2: ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) )
            {
            // InternalMiniOCLCS.g:668:2: ( ( rule__IntLiteralExpCS__IntSymbolAssignment ) )
            // InternalMiniOCLCS.g:669:3: ( rule__IntLiteralExpCS__IntSymbolAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIntLiteralExpCSAccess().getIntSymbolAssignment()); 
            }
            // InternalMiniOCLCS.g:670:3: ( rule__IntLiteralExpCS__IntSymbolAssignment )
            // InternalMiniOCLCS.g:670:4: rule__IntLiteralExpCS__IntSymbolAssignment
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
    // InternalMiniOCLCS.g:679:1: entryRuleBooleanLiteralExpCS : ruleBooleanLiteralExpCS EOF ;
    public final void entryRuleBooleanLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:680:1: ( ruleBooleanLiteralExpCS EOF )
            // InternalMiniOCLCS.g:681:1: ruleBooleanLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:688:1: ruleBooleanLiteralExpCS : ( ( rule__BooleanLiteralExpCS__Group__0 ) ) ;
    public final void ruleBooleanLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:692:2: ( ( ( rule__BooleanLiteralExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:693:2: ( ( rule__BooleanLiteralExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:693:2: ( ( rule__BooleanLiteralExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:694:3: ( rule__BooleanLiteralExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:695:3: ( rule__BooleanLiteralExpCS__Group__0 )
            // InternalMiniOCLCS.g:695:4: rule__BooleanLiteralExpCS__Group__0
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
    // InternalMiniOCLCS.g:704:1: entryRuleNullLiteralExpCS : ruleNullLiteralExpCS EOF ;
    public final void entryRuleNullLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:705:1: ( ruleNullLiteralExpCS EOF )
            // InternalMiniOCLCS.g:706:1: ruleNullLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:713:1: ruleNullLiteralExpCS : ( ( rule__NullLiteralExpCS__Group__0 ) ) ;
    public final void ruleNullLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:717:2: ( ( ( rule__NullLiteralExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:718:2: ( ( rule__NullLiteralExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:718:2: ( ( rule__NullLiteralExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:719:3: ( rule__NullLiteralExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullLiteralExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:720:3: ( rule__NullLiteralExpCS__Group__0 )
            // InternalMiniOCLCS.g:720:4: rule__NullLiteralExpCS__Group__0
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
    // InternalMiniOCLCS.g:729:1: entryRuleCollectionLiteralExpCS : ruleCollectionLiteralExpCS EOF ;
    public final void entryRuleCollectionLiteralExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:730:1: ( ruleCollectionLiteralExpCS EOF )
            // InternalMiniOCLCS.g:731:1: ruleCollectionLiteralExpCS EOF
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
    // InternalMiniOCLCS.g:738:1: ruleCollectionLiteralExpCS : ( ( rule__CollectionLiteralExpCS__Group__0 ) ) ;
    public final void ruleCollectionLiteralExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:742:2: ( ( ( rule__CollectionLiteralExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:743:2: ( ( rule__CollectionLiteralExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:743:2: ( ( rule__CollectionLiteralExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:744:3: ( rule__CollectionLiteralExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:745:3: ( rule__CollectionLiteralExpCS__Group__0 )
            // InternalMiniOCLCS.g:745:4: rule__CollectionLiteralExpCS__Group__0
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
    // InternalMiniOCLCS.g:754:1: entryRuleCollectionLiteralPartCS : ruleCollectionLiteralPartCS EOF ;
    public final void entryRuleCollectionLiteralPartCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:755:1: ( ruleCollectionLiteralPartCS EOF )
            // InternalMiniOCLCS.g:756:1: ruleCollectionLiteralPartCS EOF
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
    // InternalMiniOCLCS.g:763:1: ruleCollectionLiteralPartCS : ( ( rule__CollectionLiteralPartCS__Group__0 ) ) ;
    public final void ruleCollectionLiteralPartCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:767:2: ( ( ( rule__CollectionLiteralPartCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:768:2: ( ( rule__CollectionLiteralPartCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:768:2: ( ( rule__CollectionLiteralPartCS__Group__0 ) )
            // InternalMiniOCLCS.g:769:3: ( rule__CollectionLiteralPartCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:770:3: ( rule__CollectionLiteralPartCS__Group__0 )
            // InternalMiniOCLCS.g:770:4: rule__CollectionLiteralPartCS__Group__0
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
    // InternalMiniOCLCS.g:779:1: entryRuleLetExpCS : ruleLetExpCS EOF ;
    public final void entryRuleLetExpCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:780:1: ( ruleLetExpCS EOF )
            // InternalMiniOCLCS.g:781:1: ruleLetExpCS EOF
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
    // InternalMiniOCLCS.g:788:1: ruleLetExpCS : ( ( rule__LetExpCS__Group__0 ) ) ;
    public final void ruleLetExpCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:792:2: ( ( ( rule__LetExpCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:793:2: ( ( rule__LetExpCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:793:2: ( ( rule__LetExpCS__Group__0 ) )
            // InternalMiniOCLCS.g:794:3: ( rule__LetExpCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:795:3: ( rule__LetExpCS__Group__0 )
            // InternalMiniOCLCS.g:795:4: rule__LetExpCS__Group__0
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
    // InternalMiniOCLCS.g:804:1: entryRuleLetVarCS : ruleLetVarCS EOF ;
    public final void entryRuleLetVarCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:805:1: ( ruleLetVarCS EOF )
            // InternalMiniOCLCS.g:806:1: ruleLetVarCS EOF
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
    // InternalMiniOCLCS.g:813:1: ruleLetVarCS : ( ( rule__LetVarCS__Group__0 ) ) ;
    public final void ruleLetVarCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:817:2: ( ( ( rule__LetVarCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:818:2: ( ( rule__LetVarCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:818:2: ( ( rule__LetVarCS__Group__0 ) )
            // InternalMiniOCLCS.g:819:3: ( rule__LetVarCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:820:3: ( rule__LetVarCS__Group__0 )
            // InternalMiniOCLCS.g:820:4: rule__LetVarCS__Group__0
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
    // InternalMiniOCLCS.g:829:1: entryRulePathNameCS : rulePathNameCS EOF ;
    public final void entryRulePathNameCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:830:1: ( rulePathNameCS EOF )
            // InternalMiniOCLCS.g:831:1: rulePathNameCS EOF
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
    // InternalMiniOCLCS.g:838:1: rulePathNameCS : ( ( rule__PathNameCS__Group__0 ) ) ;
    public final void rulePathNameCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:842:2: ( ( ( rule__PathNameCS__Group__0 ) ) )
            // InternalMiniOCLCS.g:843:2: ( ( rule__PathNameCS__Group__0 ) )
            {
            // InternalMiniOCLCS.g:843:2: ( ( rule__PathNameCS__Group__0 ) )
            // InternalMiniOCLCS.g:844:3: ( rule__PathNameCS__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup()); 
            }
            // InternalMiniOCLCS.g:845:3: ( rule__PathNameCS__Group__0 )
            // InternalMiniOCLCS.g:845:4: rule__PathNameCS__Group__0
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
    // InternalMiniOCLCS.g:854:1: entryRulePathElementCS : rulePathElementCS EOF ;
    public final void entryRulePathElementCS() throws RecognitionException {
        try {
            // InternalMiniOCLCS.g:855:1: ( rulePathElementCS EOF )
            // InternalMiniOCLCS.g:856:1: rulePathElementCS EOF
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
    // InternalMiniOCLCS.g:863:1: rulePathElementCS : ( ( rule__PathElementCS__ElementNameAssignment ) ) ;
    public final void rulePathElementCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:867:2: ( ( ( rule__PathElementCS__ElementNameAssignment ) ) )
            // InternalMiniOCLCS.g:868:2: ( ( rule__PathElementCS__ElementNameAssignment ) )
            {
            // InternalMiniOCLCS.g:868:2: ( ( rule__PathElementCS__ElementNameAssignment ) )
            // InternalMiniOCLCS.g:869:3: ( rule__PathElementCS__ElementNameAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathElementCSAccess().getElementNameAssignment()); 
            }
            // InternalMiniOCLCS.g:870:3: ( rule__PathElementCS__ElementNameAssignment )
            // InternalMiniOCLCS.g:870:4: rule__PathElementCS__ElementNameAssignment
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
    // InternalMiniOCLCS.g:879:1: ruleCollectionKindCS : ( ( 'Collection' ) ) ;
    public final void ruleCollectionKindCS() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:883:1: ( ( ( 'Collection' ) ) )
            // InternalMiniOCLCS.g:884:2: ( ( 'Collection' ) )
            {
            // InternalMiniOCLCS.g:884:2: ( ( 'Collection' ) )
            // InternalMiniOCLCS.g:885:3: ( 'Collection' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionKindCSAccess().getCollectionEnumLiteralDeclaration()); 
            }
            // InternalMiniOCLCS.g:886:3: ( 'Collection' )
            // InternalMiniOCLCS.g:886:4: 'Collection'
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


    // $ANTLR start "rule__RootCS__Alternatives_1"
    // InternalMiniOCLCS.g:894:1: rule__RootCS__Alternatives_1 : ( ( ( rule__RootCS__PackagesAssignment_1_0 ) ) | ( ( rule__RootCS__ConstraintsAssignment_1_1 ) ) );
    public final void rule__RootCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:898:1: ( ( ( rule__RootCS__PackagesAssignment_1_0 ) ) | ( ( rule__RootCS__ConstraintsAssignment_1_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==20) ) {
                alt1=1;
            }
            else if ( (LA1_0==33) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalMiniOCLCS.g:899:2: ( ( rule__RootCS__PackagesAssignment_1_0 ) )
                    {
                    // InternalMiniOCLCS.g:899:2: ( ( rule__RootCS__PackagesAssignment_1_0 ) )
                    // InternalMiniOCLCS.g:900:3: ( rule__RootCS__PackagesAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRootCSAccess().getPackagesAssignment_1_0()); 
                    }
                    // InternalMiniOCLCS.g:901:3: ( rule__RootCS__PackagesAssignment_1_0 )
                    // InternalMiniOCLCS.g:901:4: rule__RootCS__PackagesAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RootCS__PackagesAssignment_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRootCSAccess().getPackagesAssignment_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:905:2: ( ( rule__RootCS__ConstraintsAssignment_1_1 ) )
                    {
                    // InternalMiniOCLCS.g:905:2: ( ( rule__RootCS__ConstraintsAssignment_1_1 ) )
                    // InternalMiniOCLCS.g:906:3: ( rule__RootCS__ConstraintsAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRootCSAccess().getConstraintsAssignment_1_1()); 
                    }
                    // InternalMiniOCLCS.g:907:3: ( rule__RootCS__ConstraintsAssignment_1_1 )
                    // InternalMiniOCLCS.g:907:4: rule__RootCS__ConstraintsAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__RootCS__ConstraintsAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRootCSAccess().getConstraintsAssignment_1_1()); 
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
    // $ANTLR end "rule__RootCS__Alternatives_1"


    // $ANTLR start "rule__PackageCS__Alternatives_3"
    // InternalMiniOCLCS.g:915:1: rule__PackageCS__Alternatives_3 : ( ( ( rule__PackageCS__PackagesAssignment_3_0 ) ) | ( ( rule__PackageCS__ClassesAssignment_3_1 ) ) );
    public final void rule__PackageCS__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:919:1: ( ( ( rule__PackageCS__PackagesAssignment_3_0 ) ) | ( ( rule__PackageCS__ClassesAssignment_3_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==20) ) {
                alt2=1;
            }
            else if ( (LA2_0==23) ) {
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
                    // InternalMiniOCLCS.g:920:2: ( ( rule__PackageCS__PackagesAssignment_3_0 ) )
                    {
                    // InternalMiniOCLCS.g:920:2: ( ( rule__PackageCS__PackagesAssignment_3_0 ) )
                    // InternalMiniOCLCS.g:921:3: ( rule__PackageCS__PackagesAssignment_3_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPackageCSAccess().getPackagesAssignment_3_0()); 
                    }
                    // InternalMiniOCLCS.g:922:3: ( rule__PackageCS__PackagesAssignment_3_0 )
                    // InternalMiniOCLCS.g:922:4: rule__PackageCS__PackagesAssignment_3_0
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
                    // InternalMiniOCLCS.g:926:2: ( ( rule__PackageCS__ClassesAssignment_3_1 ) )
                    {
                    // InternalMiniOCLCS.g:926:2: ( ( rule__PackageCS__ClassesAssignment_3_1 ) )
                    // InternalMiniOCLCS.g:927:3: ( rule__PackageCS__ClassesAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPackageCSAccess().getClassesAssignment_3_1()); 
                    }
                    // InternalMiniOCLCS.g:928:3: ( rule__PackageCS__ClassesAssignment_3_1 )
                    // InternalMiniOCLCS.g:928:4: rule__PackageCS__ClassesAssignment_3_1
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
    // InternalMiniOCLCS.g:936:1: rule__ClassCS__Alternatives_4 : ( ( ( rule__ClassCS__PropertiesAssignment_4_0 ) ) | ( ( rule__ClassCS__OperationsAssignment_4_1 ) ) );
    public final void rule__ClassCS__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:940:1: ( ( ( rule__ClassCS__PropertiesAssignment_4_0 ) ) | ( ( rule__ClassCS__OperationsAssignment_4_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==25) ) {
                alt3=1;
            }
            else if ( (LA3_0==29) ) {
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
                    // InternalMiniOCLCS.g:941:2: ( ( rule__ClassCS__PropertiesAssignment_4_0 ) )
                    {
                    // InternalMiniOCLCS.g:941:2: ( ( rule__ClassCS__PropertiesAssignment_4_0 ) )
                    // InternalMiniOCLCS.g:942:3: ( rule__ClassCS__PropertiesAssignment_4_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassCSAccess().getPropertiesAssignment_4_0()); 
                    }
                    // InternalMiniOCLCS.g:943:3: ( rule__ClassCS__PropertiesAssignment_4_0 )
                    // InternalMiniOCLCS.g:943:4: rule__ClassCS__PropertiesAssignment_4_0
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
                    // InternalMiniOCLCS.g:947:2: ( ( rule__ClassCS__OperationsAssignment_4_1 ) )
                    {
                    // InternalMiniOCLCS.g:947:2: ( ( rule__ClassCS__OperationsAssignment_4_1 ) )
                    // InternalMiniOCLCS.g:948:3: ( rule__ClassCS__OperationsAssignment_4_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getClassCSAccess().getOperationsAssignment_4_1()); 
                    }
                    // InternalMiniOCLCS.g:949:3: ( rule__ClassCS__OperationsAssignment_4_1 )
                    // InternalMiniOCLCS.g:949:4: rule__ClassCS__OperationsAssignment_4_1
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


    // $ANTLR start "rule__MultiplicityCS__Alternatives_1"
    // InternalMiniOCLCS.g:957:1: rule__MultiplicityCS__Alternatives_1 : ( ( ( rule__MultiplicityCS__OptAssignment_1_0 ) ) | ( ( rule__MultiplicityCS__MultAssignment_1_1 ) ) | ( ( rule__MultiplicityCS__MandatoryAssignment_1_2 ) ) | ( ( rule__MultiplicityCS__Group_1_3__0 ) ) );
    public final void rule__MultiplicityCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:961:1: ( ( ( rule__MultiplicityCS__OptAssignment_1_0 ) ) | ( ( rule__MultiplicityCS__MultAssignment_1_1 ) ) | ( ( rule__MultiplicityCS__MandatoryAssignment_1_2 ) ) | ( ( rule__MultiplicityCS__Group_1_3__0 ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt4=1;
                }
                break;
            case 44:
                {
                alt4=2;
                }
                break;
            case RULE_INT:
                {
                int LA4_3 = input.LA(2);

                if ( (LA4_3==27) ) {
                    alt4=3;
                }
                else if ( (LA4_3==28) ) {
                    alt4=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalMiniOCLCS.g:962:2: ( ( rule__MultiplicityCS__OptAssignment_1_0 ) )
                    {
                    // InternalMiniOCLCS.g:962:2: ( ( rule__MultiplicityCS__OptAssignment_1_0 ) )
                    // InternalMiniOCLCS.g:963:3: ( rule__MultiplicityCS__OptAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getOptAssignment_1_0()); 
                    }
                    // InternalMiniOCLCS.g:964:3: ( rule__MultiplicityCS__OptAssignment_1_0 )
                    // InternalMiniOCLCS.g:964:4: rule__MultiplicityCS__OptAssignment_1_0
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
                    // InternalMiniOCLCS.g:968:2: ( ( rule__MultiplicityCS__MultAssignment_1_1 ) )
                    {
                    // InternalMiniOCLCS.g:968:2: ( ( rule__MultiplicityCS__MultAssignment_1_1 ) )
                    // InternalMiniOCLCS.g:969:3: ( rule__MultiplicityCS__MultAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getMultAssignment_1_1()); 
                    }
                    // InternalMiniOCLCS.g:970:3: ( rule__MultiplicityCS__MultAssignment_1_1 )
                    // InternalMiniOCLCS.g:970:4: rule__MultiplicityCS__MultAssignment_1_1
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
                    // InternalMiniOCLCS.g:974:2: ( ( rule__MultiplicityCS__MandatoryAssignment_1_2 ) )
                    {
                    // InternalMiniOCLCS.g:974:2: ( ( rule__MultiplicityCS__MandatoryAssignment_1_2 ) )
                    // InternalMiniOCLCS.g:975:3: ( rule__MultiplicityCS__MandatoryAssignment_1_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getMandatoryAssignment_1_2()); 
                    }
                    // InternalMiniOCLCS.g:976:3: ( rule__MultiplicityCS__MandatoryAssignment_1_2 )
                    // InternalMiniOCLCS.g:976:4: rule__MultiplicityCS__MandatoryAssignment_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiplicityCS__MandatoryAssignment_1_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getMandatoryAssignment_1_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalMiniOCLCS.g:980:2: ( ( rule__MultiplicityCS__Group_1_3__0 ) )
                    {
                    // InternalMiniOCLCS.g:980:2: ( ( rule__MultiplicityCS__Group_1_3__0 ) )
                    // InternalMiniOCLCS.g:981:3: ( rule__MultiplicityCS__Group_1_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getGroup_1_3()); 
                    }
                    // InternalMiniOCLCS.g:982:3: ( rule__MultiplicityCS__Group_1_3__0 )
                    // InternalMiniOCLCS.g:982:4: rule__MultiplicityCS__Group_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiplicityCS__Group_1_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getGroup_1_3()); 
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


    // $ANTLR start "rule__MultiplicityCS__Alternatives_1_3_2"
    // InternalMiniOCLCS.g:990:1: rule__MultiplicityCS__Alternatives_1_3_2 : ( ( ( rule__MultiplicityCS__UpperIntAssignment_1_3_2_0 ) ) | ( ( rule__MultiplicityCS__UpperMultAssignment_1_3_2_1 ) ) );
    public final void rule__MultiplicityCS__Alternatives_1_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:994:1: ( ( ( rule__MultiplicityCS__UpperIntAssignment_1_3_2_0 ) ) | ( ( rule__MultiplicityCS__UpperMultAssignment_1_3_2_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            else if ( (LA5_0==44) ) {
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
                    // InternalMiniOCLCS.g:995:2: ( ( rule__MultiplicityCS__UpperIntAssignment_1_3_2_0 ) )
                    {
                    // InternalMiniOCLCS.g:995:2: ( ( rule__MultiplicityCS__UpperIntAssignment_1_3_2_0 ) )
                    // InternalMiniOCLCS.g:996:3: ( rule__MultiplicityCS__UpperIntAssignment_1_3_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getUpperIntAssignment_1_3_2_0()); 
                    }
                    // InternalMiniOCLCS.g:997:3: ( rule__MultiplicityCS__UpperIntAssignment_1_3_2_0 )
                    // InternalMiniOCLCS.g:997:4: rule__MultiplicityCS__UpperIntAssignment_1_3_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiplicityCS__UpperIntAssignment_1_3_2_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getUpperIntAssignment_1_3_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1001:2: ( ( rule__MultiplicityCS__UpperMultAssignment_1_3_2_1 ) )
                    {
                    // InternalMiniOCLCS.g:1001:2: ( ( rule__MultiplicityCS__UpperMultAssignment_1_3_2_1 ) )
                    // InternalMiniOCLCS.g:1002:3: ( rule__MultiplicityCS__UpperMultAssignment_1_3_2_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMultiplicityCSAccess().getUpperMultAssignment_1_3_2_1()); 
                    }
                    // InternalMiniOCLCS.g:1003:3: ( rule__MultiplicityCS__UpperMultAssignment_1_3_2_1 )
                    // InternalMiniOCLCS.g:1003:4: rule__MultiplicityCS__UpperMultAssignment_1_3_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiplicityCS__UpperMultAssignment_1_3_2_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMultiplicityCSAccess().getUpperMultAssignment_1_3_2_1()); 
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
    // $ANTLR end "rule__MultiplicityCS__Alternatives_1_3_2"


    // $ANTLR start "rule__EqualityExpCS__OpNameAlternatives_1_1_0"
    // InternalMiniOCLCS.g:1011:1: rule__EqualityExpCS__OpNameAlternatives_1_1_0 : ( ( '=' ) | ( '<>' ) );
    public final void rule__EqualityExpCS__OpNameAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1015:1: ( ( '=' ) | ( '<>' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==12) ) {
                alt6=1;
            }
            else if ( (LA6_0==13) ) {
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
                    // InternalMiniOCLCS.g:1016:2: ( '=' )
                    {
                    // InternalMiniOCLCS.g:1016:2: ( '=' )
                    // InternalMiniOCLCS.g:1017:3: '='
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEqualityExpCSAccess().getOpNameEqualsSignKeyword_1_1_0_0()); 
                    }
                    match(input,12,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEqualityExpCSAccess().getOpNameEqualsSignKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1022:2: ( '<>' )
                    {
                    // InternalMiniOCLCS.g:1022:2: ( '<>' )
                    // InternalMiniOCLCS.g:1023:3: '<>'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEqualityExpCSAccess().getOpNameLessThanSignGreaterThanSignKeyword_1_1_0_1()); 
                    }
                    match(input,13,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEqualityExpCSAccess().getOpNameLessThanSignGreaterThanSignKeyword_1_1_0_1()); 
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
    // $ANTLR end "rule__EqualityExpCS__OpNameAlternatives_1_1_0"


    // $ANTLR start "rule__CallExpCS__OpNameAlternatives_1_1_0"
    // InternalMiniOCLCS.g:1032:1: rule__CallExpCS__OpNameAlternatives_1_1_0 : ( ( '.' ) | ( '->' ) );
    public final void rule__CallExpCS__OpNameAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1036:1: ( ( '.' ) | ( '->' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            else if ( (LA7_0==15) ) {
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
                    // InternalMiniOCLCS.g:1037:2: ( '.' )
                    {
                    // InternalMiniOCLCS.g:1037:2: ( '.' )
                    // InternalMiniOCLCS.g:1038:3: '.'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpCSAccess().getOpNameFullStopKeyword_1_1_0_0()); 
                    }
                    match(input,14,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCallExpCSAccess().getOpNameFullStopKeyword_1_1_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalMiniOCLCS.g:1043:2: ( '->' )
                    {
                    // InternalMiniOCLCS.g:1043:2: ( '->' )
                    // InternalMiniOCLCS.g:1044:3: '->'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCallExpCSAccess().getOpNameHyphenMinusGreaterThanSignKeyword_1_1_0_1()); 
                    }
                    match(input,15,FOLLOW_2); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCallExpCSAccess().getOpNameHyphenMinusGreaterThanSignKeyword_1_1_0_1()); 
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
    // $ANTLR end "rule__CallExpCS__OpNameAlternatives_1_1_0"


    // $ANTLR start "rule__PrimaryExpCS__Alternatives"
    // InternalMiniOCLCS.g:1053:1: rule__PrimaryExpCS__Alternatives : ( ( ruleSelfExpCS ) | ( ruleNameExpCS ) | ( ruleLiteralExpCS ) | ( ruleLetExpCS ) );
    public final void rule__PrimaryExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1057:1: ( ( ruleSelfExpCS ) | ( ruleNameExpCS ) | ( ruleLiteralExpCS ) | ( ruleLetExpCS ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt8=1;
                }
                break;
            case RULE_ID:
                {
                alt8=2;
                }
                break;
            case RULE_INT:
            case 11:
            case 16:
            case 39:
            case 45:
                {
                alt8=3;
                }
                break;
            case 40:
                {
                alt8=4;
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
                    // InternalMiniOCLCS.g:1058:2: ( ruleSelfExpCS )
                    {
                    // InternalMiniOCLCS.g:1058:2: ( ruleSelfExpCS )
                    // InternalMiniOCLCS.g:1059:3: ruleSelfExpCS
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
                    // InternalMiniOCLCS.g:1064:2: ( ruleNameExpCS )
                    {
                    // InternalMiniOCLCS.g:1064:2: ( ruleNameExpCS )
                    // InternalMiniOCLCS.g:1065:3: ruleNameExpCS
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
                    // InternalMiniOCLCS.g:1070:2: ( ruleLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1070:2: ( ruleLiteralExpCS )
                    // InternalMiniOCLCS.g:1071:3: ruleLiteralExpCS
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
                    // InternalMiniOCLCS.g:1076:2: ( ruleLetExpCS )
                    {
                    // InternalMiniOCLCS.g:1076:2: ( ruleLetExpCS )
                    // InternalMiniOCLCS.g:1077:3: ruleLetExpCS
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
    // InternalMiniOCLCS.g:1086:1: rule__NavigationExpCS__Alternatives : ( ( ruleLoopExpCS ) | ( ruleNameExpCS ) );
    public final void rule__NavigationExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1090:1: ( ( ruleLoopExpCS ) | ( ruleNameExpCS ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==36||LA9_0==38) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
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
                    // InternalMiniOCLCS.g:1091:2: ( ruleLoopExpCS )
                    {
                    // InternalMiniOCLCS.g:1091:2: ( ruleLoopExpCS )
                    // InternalMiniOCLCS.g:1092:3: ruleLoopExpCS
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
                    // InternalMiniOCLCS.g:1097:2: ( ruleNameExpCS )
                    {
                    // InternalMiniOCLCS.g:1097:2: ( ruleNameExpCS )
                    // InternalMiniOCLCS.g:1098:3: ruleNameExpCS
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
    // InternalMiniOCLCS.g:1107:1: rule__LoopExpCS__Alternatives : ( ( ruleCollectExpCS ) | ( ruleIterateExpCS ) );
    public final void rule__LoopExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1111:1: ( ( ruleCollectExpCS ) | ( ruleIterateExpCS ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==36) ) {
                alt10=1;
            }
            else if ( (LA10_0==38) ) {
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
                    // InternalMiniOCLCS.g:1112:2: ( ruleCollectExpCS )
                    {
                    // InternalMiniOCLCS.g:1112:2: ( ruleCollectExpCS )
                    // InternalMiniOCLCS.g:1113:3: ruleCollectExpCS
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
                    // InternalMiniOCLCS.g:1118:2: ( ruleIterateExpCS )
                    {
                    // InternalMiniOCLCS.g:1118:2: ( ruleIterateExpCS )
                    // InternalMiniOCLCS.g:1119:3: ruleIterateExpCS
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
    // InternalMiniOCLCS.g:1128:1: rule__LiteralExpCS__Alternatives : ( ( ruleIntLiteralExpCS ) | ( ruleBooleanLiteralExpCS ) | ( ruleNullLiteralExpCS ) | ( ruleCollectionLiteralExpCS ) );
    public final void rule__LiteralExpCS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1132:1: ( ( ruleIntLiteralExpCS ) | ( ruleBooleanLiteralExpCS ) | ( ruleNullLiteralExpCS ) | ( ruleCollectionLiteralExpCS ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt11=1;
                }
                break;
            case 16:
            case 45:
                {
                alt11=2;
                }
                break;
            case 39:
                {
                alt11=3;
                }
                break;
            case 11:
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
                    // InternalMiniOCLCS.g:1133:2: ( ruleIntLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1133:2: ( ruleIntLiteralExpCS )
                    // InternalMiniOCLCS.g:1134:3: ruleIntLiteralExpCS
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
                    // InternalMiniOCLCS.g:1139:2: ( ruleBooleanLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1139:2: ( ruleBooleanLiteralExpCS )
                    // InternalMiniOCLCS.g:1140:3: ruleBooleanLiteralExpCS
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
                    // InternalMiniOCLCS.g:1145:2: ( ruleNullLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1145:2: ( ruleNullLiteralExpCS )
                    // InternalMiniOCLCS.g:1146:3: ruleNullLiteralExpCS
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
                    // InternalMiniOCLCS.g:1151:2: ( ruleCollectionLiteralExpCS )
                    {
                    // InternalMiniOCLCS.g:1151:2: ( ruleCollectionLiteralExpCS )
                    // InternalMiniOCLCS.g:1152:3: ruleCollectionLiteralExpCS
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
    // InternalMiniOCLCS.g:1161:1: rule__BooleanLiteralExpCS__Alternatives_1 : ( ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) ) | ( 'false' ) );
    public final void rule__BooleanLiteralExpCS__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1165:1: ( ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) ) | ( 'false' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==45) ) {
                alt12=1;
            }
            else if ( (LA12_0==16) ) {
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
                    // InternalMiniOCLCS.g:1166:2: ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) )
                    {
                    // InternalMiniOCLCS.g:1166:2: ( ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 ) )
                    // InternalMiniOCLCS.g:1167:3: ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolAssignment_1_0()); 
                    }
                    // InternalMiniOCLCS.g:1168:3: ( rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 )
                    // InternalMiniOCLCS.g:1168:4: rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0
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
                    // InternalMiniOCLCS.g:1172:2: ( 'false' )
                    {
                    // InternalMiniOCLCS.g:1172:2: ( 'false' )
                    // InternalMiniOCLCS.g:1173:3: 'false'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getBooleanLiteralExpCSAccess().getFalseKeyword_1_1()); 
                    }
                    match(input,16,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__RootCS__Group__0"
    // InternalMiniOCLCS.g:1182:1: rule__RootCS__Group__0 : rule__RootCS__Group__0__Impl rule__RootCS__Group__1 ;
    public final void rule__RootCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1186:1: ( rule__RootCS__Group__0__Impl rule__RootCS__Group__1 )
            // InternalMiniOCLCS.g:1187:2: rule__RootCS__Group__0__Impl rule__RootCS__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RootCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__RootCS__Group__1();

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
    // $ANTLR end "rule__RootCS__Group__0"


    // $ANTLR start "rule__RootCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1194:1: rule__RootCS__Group__0__Impl : ( ( rule__RootCS__ImportsAssignment_0 )* ) ;
    public final void rule__RootCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1198:1: ( ( ( rule__RootCS__ImportsAssignment_0 )* ) )
            // InternalMiniOCLCS.g:1199:1: ( ( rule__RootCS__ImportsAssignment_0 )* )
            {
            // InternalMiniOCLCS.g:1199:1: ( ( rule__RootCS__ImportsAssignment_0 )* )
            // InternalMiniOCLCS.g:1200:2: ( rule__RootCS__ImportsAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSAccess().getImportsAssignment_0()); 
            }
            // InternalMiniOCLCS.g:1201:2: ( rule__RootCS__ImportsAssignment_0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==17) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1201:3: rule__RootCS__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__RootCS__ImportsAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSAccess().getImportsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootCS__Group__0__Impl"


    // $ANTLR start "rule__RootCS__Group__1"
    // InternalMiniOCLCS.g:1209:1: rule__RootCS__Group__1 : rule__RootCS__Group__1__Impl ;
    public final void rule__RootCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1213:1: ( rule__RootCS__Group__1__Impl )
            // InternalMiniOCLCS.g:1214:2: rule__RootCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RootCS__Group__1__Impl();

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
    // $ANTLR end "rule__RootCS__Group__1"


    // $ANTLR start "rule__RootCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1220:1: rule__RootCS__Group__1__Impl : ( ( rule__RootCS__Alternatives_1 )* ) ;
    public final void rule__RootCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1224:1: ( ( ( rule__RootCS__Alternatives_1 )* ) )
            // InternalMiniOCLCS.g:1225:1: ( ( rule__RootCS__Alternatives_1 )* )
            {
            // InternalMiniOCLCS.g:1225:1: ( ( rule__RootCS__Alternatives_1 )* )
            // InternalMiniOCLCS.g:1226:2: ( rule__RootCS__Alternatives_1 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSAccess().getAlternatives_1()); 
            }
            // InternalMiniOCLCS.g:1227:2: ( rule__RootCS__Alternatives_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==20||LA14_0==33) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1227:3: rule__RootCS__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__RootCS__Alternatives_1();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootCS__Group__1__Impl"


    // $ANTLR start "rule__ImportCS__Group__0"
    // InternalMiniOCLCS.g:1236:1: rule__ImportCS__Group__0 : rule__ImportCS__Group__0__Impl rule__ImportCS__Group__1 ;
    public final void rule__ImportCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1240:1: ( rule__ImportCS__Group__0__Impl rule__ImportCS__Group__1 )
            // InternalMiniOCLCS.g:1241:2: rule__ImportCS__Group__0__Impl rule__ImportCS__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__ImportCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ImportCS__Group__1();

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
    // $ANTLR end "rule__ImportCS__Group__0"


    // $ANTLR start "rule__ImportCS__Group__0__Impl"
    // InternalMiniOCLCS.g:1248:1: rule__ImportCS__Group__0__Impl : ( 'import' ) ;
    public final void rule__ImportCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1252:1: ( ( 'import' ) )
            // InternalMiniOCLCS.g:1253:1: ( 'import' )
            {
            // InternalMiniOCLCS.g:1253:1: ( 'import' )
            // InternalMiniOCLCS.g:1254:2: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSAccess().getImportKeyword_0()); 
            }
            match(input,17,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSAccess().getImportKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportCS__Group__0__Impl"


    // $ANTLR start "rule__ImportCS__Group__1"
    // InternalMiniOCLCS.g:1263:1: rule__ImportCS__Group__1 : rule__ImportCS__Group__1__Impl rule__ImportCS__Group__2 ;
    public final void rule__ImportCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1267:1: ( rule__ImportCS__Group__1__Impl rule__ImportCS__Group__2 )
            // InternalMiniOCLCS.g:1268:2: rule__ImportCS__Group__1__Impl rule__ImportCS__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__ImportCS__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ImportCS__Group__2();

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
    // $ANTLR end "rule__ImportCS__Group__1"


    // $ANTLR start "rule__ImportCS__Group__1__Impl"
    // InternalMiniOCLCS.g:1275:1: rule__ImportCS__Group__1__Impl : ( ( rule__ImportCS__Group_1__0 ) ) ;
    public final void rule__ImportCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1279:1: ( ( ( rule__ImportCS__Group_1__0 ) ) )
            // InternalMiniOCLCS.g:1280:1: ( ( rule__ImportCS__Group_1__0 ) )
            {
            // InternalMiniOCLCS.g:1280:1: ( ( rule__ImportCS__Group_1__0 ) )
            // InternalMiniOCLCS.g:1281:2: ( rule__ImportCS__Group_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:1282:2: ( rule__ImportCS__Group_1__0 )
            // InternalMiniOCLCS.g:1282:3: rule__ImportCS__Group_1__0
            {
            pushFollow(FOLLOW_2);
            rule__ImportCS__Group_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportCS__Group__1__Impl"


    // $ANTLR start "rule__ImportCS__Group__2"
    // InternalMiniOCLCS.g:1290:1: rule__ImportCS__Group__2 : rule__ImportCS__Group__2__Impl rule__ImportCS__Group__3 ;
    public final void rule__ImportCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1294:1: ( rule__ImportCS__Group__2__Impl rule__ImportCS__Group__3 )
            // InternalMiniOCLCS.g:1295:2: rule__ImportCS__Group__2__Impl rule__ImportCS__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__ImportCS__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ImportCS__Group__3();

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
    // $ANTLR end "rule__ImportCS__Group__2"


    // $ANTLR start "rule__ImportCS__Group__2__Impl"
    // InternalMiniOCLCS.g:1302:1: rule__ImportCS__Group__2__Impl : ( ( rule__ImportCS__UriAssignment_2 ) ) ;
    public final void rule__ImportCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1306:1: ( ( ( rule__ImportCS__UriAssignment_2 ) ) )
            // InternalMiniOCLCS.g:1307:1: ( ( rule__ImportCS__UriAssignment_2 ) )
            {
            // InternalMiniOCLCS.g:1307:1: ( ( rule__ImportCS__UriAssignment_2 ) )
            // InternalMiniOCLCS.g:1308:2: ( rule__ImportCS__UriAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSAccess().getUriAssignment_2()); 
            }
            // InternalMiniOCLCS.g:1309:2: ( rule__ImportCS__UriAssignment_2 )
            // InternalMiniOCLCS.g:1309:3: rule__ImportCS__UriAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ImportCS__UriAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSAccess().getUriAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportCS__Group__2__Impl"


    // $ANTLR start "rule__ImportCS__Group__3"
    // InternalMiniOCLCS.g:1317:1: rule__ImportCS__Group__3 : rule__ImportCS__Group__3__Impl ;
    public final void rule__ImportCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1321:1: ( rule__ImportCS__Group__3__Impl )
            // InternalMiniOCLCS.g:1322:2: rule__ImportCS__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportCS__Group__3__Impl();

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
    // $ANTLR end "rule__ImportCS__Group__3"


    // $ANTLR start "rule__ImportCS__Group__3__Impl"
    // InternalMiniOCLCS.g:1328:1: rule__ImportCS__Group__3__Impl : ( ';' ) ;
    public final void rule__ImportCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1332:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:1333:1: ( ';' )
            {
            // InternalMiniOCLCS.g:1333:1: ( ';' )
            // InternalMiniOCLCS.g:1334:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSAccess().getSemicolonKeyword_3()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportCS__Group__3__Impl"


    // $ANTLR start "rule__ImportCS__Group_1__0"
    // InternalMiniOCLCS.g:1344:1: rule__ImportCS__Group_1__0 : rule__ImportCS__Group_1__0__Impl rule__ImportCS__Group_1__1 ;
    public final void rule__ImportCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1348:1: ( rule__ImportCS__Group_1__0__Impl rule__ImportCS__Group_1__1 )
            // InternalMiniOCLCS.g:1349:2: rule__ImportCS__Group_1__0__Impl rule__ImportCS__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__ImportCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__ImportCS__Group_1__1();

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
    // $ANTLR end "rule__ImportCS__Group_1__0"


    // $ANTLR start "rule__ImportCS__Group_1__0__Impl"
    // InternalMiniOCLCS.g:1356:1: rule__ImportCS__Group_1__0__Impl : ( ( rule__ImportCS__AliasAssignment_1_0 ) ) ;
    public final void rule__ImportCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1360:1: ( ( ( rule__ImportCS__AliasAssignment_1_0 ) ) )
            // InternalMiniOCLCS.g:1361:1: ( ( rule__ImportCS__AliasAssignment_1_0 ) )
            {
            // InternalMiniOCLCS.g:1361:1: ( ( rule__ImportCS__AliasAssignment_1_0 ) )
            // InternalMiniOCLCS.g:1362:2: ( rule__ImportCS__AliasAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSAccess().getAliasAssignment_1_0()); 
            }
            // InternalMiniOCLCS.g:1363:2: ( rule__ImportCS__AliasAssignment_1_0 )
            // InternalMiniOCLCS.g:1363:3: rule__ImportCS__AliasAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ImportCS__AliasAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSAccess().getAliasAssignment_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportCS__Group_1__0__Impl"


    // $ANTLR start "rule__ImportCS__Group_1__1"
    // InternalMiniOCLCS.g:1371:1: rule__ImportCS__Group_1__1 : rule__ImportCS__Group_1__1__Impl ;
    public final void rule__ImportCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1375:1: ( rule__ImportCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:1376:2: rule__ImportCS__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImportCS__Group_1__1__Impl();

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
    // $ANTLR end "rule__ImportCS__Group_1__1"


    // $ANTLR start "rule__ImportCS__Group_1__1__Impl"
    // InternalMiniOCLCS.g:1382:1: rule__ImportCS__Group_1__1__Impl : ( ':' ) ;
    public final void rule__ImportCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1386:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:1387:1: ( ':' )
            {
            // InternalMiniOCLCS.g:1387:1: ( ':' )
            // InternalMiniOCLCS.g:1388:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSAccess().getColonKeyword_1_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSAccess().getColonKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportCS__Group_1__1__Impl"


    // $ANTLR start "rule__PackageCS__Group__0"
    // InternalMiniOCLCS.g:1398:1: rule__PackageCS__Group__0 : rule__PackageCS__Group__0__Impl rule__PackageCS__Group__1 ;
    public final void rule__PackageCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1402:1: ( rule__PackageCS__Group__0__Impl rule__PackageCS__Group__1 )
            // InternalMiniOCLCS.g:1403:2: rule__PackageCS__Group__0__Impl rule__PackageCS__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:1410:1: rule__PackageCS__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1414:1: ( ( 'package' ) )
            // InternalMiniOCLCS.g:1415:1: ( 'package' )
            {
            // InternalMiniOCLCS.g:1415:1: ( 'package' )
            // InternalMiniOCLCS.g:1416:2: 'package'
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
    // InternalMiniOCLCS.g:1425:1: rule__PackageCS__Group__1 : rule__PackageCS__Group__1__Impl rule__PackageCS__Group__2 ;
    public final void rule__PackageCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1429:1: ( rule__PackageCS__Group__1__Impl rule__PackageCS__Group__2 )
            // InternalMiniOCLCS.g:1430:2: rule__PackageCS__Group__1__Impl rule__PackageCS__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalMiniOCLCS.g:1437:1: rule__PackageCS__Group__1__Impl : ( ( rule__PackageCS__NameAssignment_1 ) ) ;
    public final void rule__PackageCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1441:1: ( ( ( rule__PackageCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1442:1: ( ( rule__PackageCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1442:1: ( ( rule__PackageCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:1443:2: ( rule__PackageCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1444:2: ( rule__PackageCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:1444:3: rule__PackageCS__NameAssignment_1
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
    // InternalMiniOCLCS.g:1452:1: rule__PackageCS__Group__2 : rule__PackageCS__Group__2__Impl rule__PackageCS__Group__3 ;
    public final void rule__PackageCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1456:1: ( rule__PackageCS__Group__2__Impl rule__PackageCS__Group__3 )
            // InternalMiniOCLCS.g:1457:2: rule__PackageCS__Group__2__Impl rule__PackageCS__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalMiniOCLCS.g:1464:1: rule__PackageCS__Group__2__Impl : ( '{' ) ;
    public final void rule__PackageCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1468:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:1469:1: ( '{' )
            {
            // InternalMiniOCLCS.g:1469:1: ( '{' )
            // InternalMiniOCLCS.g:1470:2: '{'
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
    // InternalMiniOCLCS.g:1479:1: rule__PackageCS__Group__3 : rule__PackageCS__Group__3__Impl rule__PackageCS__Group__4 ;
    public final void rule__PackageCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1483:1: ( rule__PackageCS__Group__3__Impl rule__PackageCS__Group__4 )
            // InternalMiniOCLCS.g:1484:2: rule__PackageCS__Group__3__Impl rule__PackageCS__Group__4
            {
            pushFollow(FOLLOW_11);
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
    // InternalMiniOCLCS.g:1491:1: rule__PackageCS__Group__3__Impl : ( ( rule__PackageCS__Alternatives_3 )* ) ;
    public final void rule__PackageCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1495:1: ( ( ( rule__PackageCS__Alternatives_3 )* ) )
            // InternalMiniOCLCS.g:1496:1: ( ( rule__PackageCS__Alternatives_3 )* )
            {
            // InternalMiniOCLCS.g:1496:1: ( ( rule__PackageCS__Alternatives_3 )* )
            // InternalMiniOCLCS.g:1497:2: ( rule__PackageCS__Alternatives_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPackageCSAccess().getAlternatives_3()); 
            }
            // InternalMiniOCLCS.g:1498:2: ( rule__PackageCS__Alternatives_3 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==20||LA15_0==23) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1498:3: rule__PackageCS__Alternatives_3
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__PackageCS__Alternatives_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalMiniOCLCS.g:1506:1: rule__PackageCS__Group__4 : rule__PackageCS__Group__4__Impl ;
    public final void rule__PackageCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1510:1: ( rule__PackageCS__Group__4__Impl )
            // InternalMiniOCLCS.g:1511:2: rule__PackageCS__Group__4__Impl
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
    // InternalMiniOCLCS.g:1517:1: rule__PackageCS__Group__4__Impl : ( '}' ) ;
    public final void rule__PackageCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1521:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:1522:1: ( '}' )
            {
            // InternalMiniOCLCS.g:1522:1: ( '}' )
            // InternalMiniOCLCS.g:1523:2: '}'
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
    // InternalMiniOCLCS.g:1533:1: rule__ClassCS__Group__0 : rule__ClassCS__Group__0__Impl rule__ClassCS__Group__1 ;
    public final void rule__ClassCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1537:1: ( rule__ClassCS__Group__0__Impl rule__ClassCS__Group__1 )
            // InternalMiniOCLCS.g:1538:2: rule__ClassCS__Group__0__Impl rule__ClassCS__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:1545:1: rule__ClassCS__Group__0__Impl : ( 'class' ) ;
    public final void rule__ClassCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1549:1: ( ( 'class' ) )
            // InternalMiniOCLCS.g:1550:1: ( 'class' )
            {
            // InternalMiniOCLCS.g:1550:1: ( 'class' )
            // InternalMiniOCLCS.g:1551:2: 'class'
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
    // InternalMiniOCLCS.g:1560:1: rule__ClassCS__Group__1 : rule__ClassCS__Group__1__Impl rule__ClassCS__Group__2 ;
    public final void rule__ClassCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1564:1: ( rule__ClassCS__Group__1__Impl rule__ClassCS__Group__2 )
            // InternalMiniOCLCS.g:1565:2: rule__ClassCS__Group__1__Impl rule__ClassCS__Group__2
            {
            pushFollow(FOLLOW_13);
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
    // InternalMiniOCLCS.g:1572:1: rule__ClassCS__Group__1__Impl : ( ( rule__ClassCS__NameAssignment_1 ) ) ;
    public final void rule__ClassCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1576:1: ( ( ( rule__ClassCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1577:1: ( ( rule__ClassCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1577:1: ( ( rule__ClassCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:1578:2: ( rule__ClassCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1579:2: ( rule__ClassCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:1579:3: rule__ClassCS__NameAssignment_1
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
    // InternalMiniOCLCS.g:1587:1: rule__ClassCS__Group__2 : rule__ClassCS__Group__2__Impl rule__ClassCS__Group__3 ;
    public final void rule__ClassCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1591:1: ( rule__ClassCS__Group__2__Impl rule__ClassCS__Group__3 )
            // InternalMiniOCLCS.g:1592:2: rule__ClassCS__Group__2__Impl rule__ClassCS__Group__3
            {
            pushFollow(FOLLOW_13);
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
    // InternalMiniOCLCS.g:1599:1: rule__ClassCS__Group__2__Impl : ( ( rule__ClassCS__Group_2__0 )? ) ;
    public final void rule__ClassCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1603:1: ( ( ( rule__ClassCS__Group_2__0 )? ) )
            // InternalMiniOCLCS.g:1604:1: ( ( rule__ClassCS__Group_2__0 )? )
            {
            // InternalMiniOCLCS.g:1604:1: ( ( rule__ClassCS__Group_2__0 )? )
            // InternalMiniOCLCS.g:1605:2: ( rule__ClassCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:1606:2: ( rule__ClassCS__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMiniOCLCS.g:1606:3: rule__ClassCS__Group_2__0
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
    // InternalMiniOCLCS.g:1614:1: rule__ClassCS__Group__3 : rule__ClassCS__Group__3__Impl rule__ClassCS__Group__4 ;
    public final void rule__ClassCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1618:1: ( rule__ClassCS__Group__3__Impl rule__ClassCS__Group__4 )
            // InternalMiniOCLCS.g:1619:2: rule__ClassCS__Group__3__Impl rule__ClassCS__Group__4
            {
            pushFollow(FOLLOW_14);
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
    // InternalMiniOCLCS.g:1626:1: rule__ClassCS__Group__3__Impl : ( '{' ) ;
    public final void rule__ClassCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1630:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:1631:1: ( '{' )
            {
            // InternalMiniOCLCS.g:1631:1: ( '{' )
            // InternalMiniOCLCS.g:1632:2: '{'
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
    // InternalMiniOCLCS.g:1641:1: rule__ClassCS__Group__4 : rule__ClassCS__Group__4__Impl rule__ClassCS__Group__5 ;
    public final void rule__ClassCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1645:1: ( rule__ClassCS__Group__4__Impl rule__ClassCS__Group__5 )
            // InternalMiniOCLCS.g:1646:2: rule__ClassCS__Group__4__Impl rule__ClassCS__Group__5
            {
            pushFollow(FOLLOW_14);
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
    // InternalMiniOCLCS.g:1653:1: rule__ClassCS__Group__4__Impl : ( ( rule__ClassCS__Alternatives_4 )* ) ;
    public final void rule__ClassCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1657:1: ( ( ( rule__ClassCS__Alternatives_4 )* ) )
            // InternalMiniOCLCS.g:1658:1: ( ( rule__ClassCS__Alternatives_4 )* )
            {
            // InternalMiniOCLCS.g:1658:1: ( ( rule__ClassCS__Alternatives_4 )* )
            // InternalMiniOCLCS.g:1659:2: ( rule__ClassCS__Alternatives_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getAlternatives_4()); 
            }
            // InternalMiniOCLCS.g:1660:2: ( rule__ClassCS__Alternatives_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25||LA17_0==29) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMiniOCLCS.g:1660:3: rule__ClassCS__Alternatives_4
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__ClassCS__Alternatives_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalMiniOCLCS.g:1668:1: rule__ClassCS__Group__5 : rule__ClassCS__Group__5__Impl ;
    public final void rule__ClassCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1672:1: ( rule__ClassCS__Group__5__Impl )
            // InternalMiniOCLCS.g:1673:2: rule__ClassCS__Group__5__Impl
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
    // InternalMiniOCLCS.g:1679:1: rule__ClassCS__Group__5__Impl : ( '}' ) ;
    public final void rule__ClassCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1683:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:1684:1: ( '}' )
            {
            // InternalMiniOCLCS.g:1684:1: ( '}' )
            // InternalMiniOCLCS.g:1685:2: '}'
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
    // InternalMiniOCLCS.g:1695:1: rule__ClassCS__Group_2__0 : rule__ClassCS__Group_2__0__Impl rule__ClassCS__Group_2__1 ;
    public final void rule__ClassCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1699:1: ( rule__ClassCS__Group_2__0__Impl rule__ClassCS__Group_2__1 )
            // InternalMiniOCLCS.g:1700:2: rule__ClassCS__Group_2__0__Impl rule__ClassCS__Group_2__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:1707:1: rule__ClassCS__Group_2__0__Impl : ( 'extends' ) ;
    public final void rule__ClassCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1711:1: ( ( 'extends' ) )
            // InternalMiniOCLCS.g:1712:1: ( 'extends' )
            {
            // InternalMiniOCLCS.g:1712:1: ( 'extends' )
            // InternalMiniOCLCS.g:1713:2: 'extends'
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
    // InternalMiniOCLCS.g:1722:1: rule__ClassCS__Group_2__1 : rule__ClassCS__Group_2__1__Impl ;
    public final void rule__ClassCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1726:1: ( rule__ClassCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:1727:2: rule__ClassCS__Group_2__1__Impl
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
    // InternalMiniOCLCS.g:1733:1: rule__ClassCS__Group_2__1__Impl : ( ( rule__ClassCS__ExtendsAssignment_2_1 ) ) ;
    public final void rule__ClassCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1737:1: ( ( ( rule__ClassCS__ExtendsAssignment_2_1 ) ) )
            // InternalMiniOCLCS.g:1738:1: ( ( rule__ClassCS__ExtendsAssignment_2_1 ) )
            {
            // InternalMiniOCLCS.g:1738:1: ( ( rule__ClassCS__ExtendsAssignment_2_1 ) )
            // InternalMiniOCLCS.g:1739:2: ( rule__ClassCS__ExtendsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getClassCSAccess().getExtendsAssignment_2_1()); 
            }
            // InternalMiniOCLCS.g:1740:2: ( rule__ClassCS__ExtendsAssignment_2_1 )
            // InternalMiniOCLCS.g:1740:3: rule__ClassCS__ExtendsAssignment_2_1
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
    // InternalMiniOCLCS.g:1749:1: rule__PropertyCS__Group__0 : rule__PropertyCS__Group__0__Impl rule__PropertyCS__Group__1 ;
    public final void rule__PropertyCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1753:1: ( rule__PropertyCS__Group__0__Impl rule__PropertyCS__Group__1 )
            // InternalMiniOCLCS.g:1754:2: rule__PropertyCS__Group__0__Impl rule__PropertyCS__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:1761:1: rule__PropertyCS__Group__0__Impl : ( 'prop' ) ;
    public final void rule__PropertyCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1765:1: ( ( 'prop' ) )
            // InternalMiniOCLCS.g:1766:1: ( 'prop' )
            {
            // InternalMiniOCLCS.g:1766:1: ( 'prop' )
            // InternalMiniOCLCS.g:1767:2: 'prop'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getPropKeyword_0()); 
            }
            match(input,25,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1776:1: rule__PropertyCS__Group__1 : rule__PropertyCS__Group__1__Impl rule__PropertyCS__Group__2 ;
    public final void rule__PropertyCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1780:1: ( rule__PropertyCS__Group__1__Impl rule__PropertyCS__Group__2 )
            // InternalMiniOCLCS.g:1781:2: rule__PropertyCS__Group__1__Impl rule__PropertyCS__Group__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalMiniOCLCS.g:1788:1: rule__PropertyCS__Group__1__Impl : ( ( rule__PropertyCS__NameAssignment_1 ) ) ;
    public final void rule__PropertyCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1792:1: ( ( ( rule__PropertyCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:1793:1: ( ( rule__PropertyCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:1793:1: ( ( rule__PropertyCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:1794:2: ( rule__PropertyCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:1795:2: ( rule__PropertyCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:1795:3: rule__PropertyCS__NameAssignment_1
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
    // InternalMiniOCLCS.g:1803:1: rule__PropertyCS__Group__2 : rule__PropertyCS__Group__2__Impl rule__PropertyCS__Group__3 ;
    public final void rule__PropertyCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1807:1: ( rule__PropertyCS__Group__2__Impl rule__PropertyCS__Group__3 )
            // InternalMiniOCLCS.g:1808:2: rule__PropertyCS__Group__2__Impl rule__PropertyCS__Group__3
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:1815:1: rule__PropertyCS__Group__2__Impl : ( ':' ) ;
    public final void rule__PropertyCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1819:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:1820:1: ( ':' )
            {
            // InternalMiniOCLCS.g:1820:1: ( ':' )
            // InternalMiniOCLCS.g:1821:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getColonKeyword_2()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1830:1: rule__PropertyCS__Group__3 : rule__PropertyCS__Group__3__Impl rule__PropertyCS__Group__4 ;
    public final void rule__PropertyCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1834:1: ( rule__PropertyCS__Group__3__Impl rule__PropertyCS__Group__4 )
            // InternalMiniOCLCS.g:1835:2: rule__PropertyCS__Group__3__Impl rule__PropertyCS__Group__4
            {
            pushFollow(FOLLOW_16);
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
    // InternalMiniOCLCS.g:1842:1: rule__PropertyCS__Group__3__Impl : ( ( rule__PropertyCS__TypeRefAssignment_3 ) ) ;
    public final void rule__PropertyCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1846:1: ( ( ( rule__PropertyCS__TypeRefAssignment_3 ) ) )
            // InternalMiniOCLCS.g:1847:1: ( ( rule__PropertyCS__TypeRefAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:1847:1: ( ( rule__PropertyCS__TypeRefAssignment_3 ) )
            // InternalMiniOCLCS.g:1848:2: ( rule__PropertyCS__TypeRefAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getTypeRefAssignment_3()); 
            }
            // InternalMiniOCLCS.g:1849:2: ( rule__PropertyCS__TypeRefAssignment_3 )
            // InternalMiniOCLCS.g:1849:3: rule__PropertyCS__TypeRefAssignment_3
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
    // InternalMiniOCLCS.g:1857:1: rule__PropertyCS__Group__4 : rule__PropertyCS__Group__4__Impl rule__PropertyCS__Group__5 ;
    public final void rule__PropertyCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1861:1: ( rule__PropertyCS__Group__4__Impl rule__PropertyCS__Group__5 )
            // InternalMiniOCLCS.g:1862:2: rule__PropertyCS__Group__4__Impl rule__PropertyCS__Group__5
            {
            pushFollow(FOLLOW_16);
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
    // InternalMiniOCLCS.g:1869:1: rule__PropertyCS__Group__4__Impl : ( ( rule__PropertyCS__MultiplicityAssignment_4 )? ) ;
    public final void rule__PropertyCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1873:1: ( ( ( rule__PropertyCS__MultiplicityAssignment_4 )? ) )
            // InternalMiniOCLCS.g:1874:1: ( ( rule__PropertyCS__MultiplicityAssignment_4 )? )
            {
            // InternalMiniOCLCS.g:1874:1: ( ( rule__PropertyCS__MultiplicityAssignment_4 )? )
            // InternalMiniOCLCS.g:1875:2: ( rule__PropertyCS__MultiplicityAssignment_4 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getMultiplicityAssignment_4()); 
            }
            // InternalMiniOCLCS.g:1876:2: ( rule__PropertyCS__MultiplicityAssignment_4 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMiniOCLCS.g:1876:3: rule__PropertyCS__MultiplicityAssignment_4
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
    // InternalMiniOCLCS.g:1884:1: rule__PropertyCS__Group__5 : rule__PropertyCS__Group__5__Impl ;
    public final void rule__PropertyCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1888:1: ( rule__PropertyCS__Group__5__Impl )
            // InternalMiniOCLCS.g:1889:2: rule__PropertyCS__Group__5__Impl
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
    // InternalMiniOCLCS.g:1895:1: rule__PropertyCS__Group__5__Impl : ( ';' ) ;
    public final void rule__PropertyCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1899:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:1900:1: ( ';' )
            {
            // InternalMiniOCLCS.g:1900:1: ( ';' )
            // InternalMiniOCLCS.g:1901:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPropertyCSAccess().getSemicolonKeyword_5()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1911:1: rule__MultiplicityCS__Group__0 : rule__MultiplicityCS__Group__0__Impl rule__MultiplicityCS__Group__1 ;
    public final void rule__MultiplicityCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1915:1: ( rule__MultiplicityCS__Group__0__Impl rule__MultiplicityCS__Group__1 )
            // InternalMiniOCLCS.g:1916:2: rule__MultiplicityCS__Group__0__Impl rule__MultiplicityCS__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalMiniOCLCS.g:1923:1: rule__MultiplicityCS__Group__0__Impl : ( '[' ) ;
    public final void rule__MultiplicityCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1927:1: ( ( '[' ) )
            // InternalMiniOCLCS.g:1928:1: ( '[' )
            {
            // InternalMiniOCLCS.g:1928:1: ( '[' )
            // InternalMiniOCLCS.g:1929:2: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0()); 
            }
            match(input,26,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:1938:1: rule__MultiplicityCS__Group__1 : rule__MultiplicityCS__Group__1__Impl rule__MultiplicityCS__Group__2 ;
    public final void rule__MultiplicityCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1942:1: ( rule__MultiplicityCS__Group__1__Impl rule__MultiplicityCS__Group__2 )
            // InternalMiniOCLCS.g:1943:2: rule__MultiplicityCS__Group__1__Impl rule__MultiplicityCS__Group__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalMiniOCLCS.g:1950:1: rule__MultiplicityCS__Group__1__Impl : ( ( rule__MultiplicityCS__Alternatives_1 ) ) ;
    public final void rule__MultiplicityCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1954:1: ( ( ( rule__MultiplicityCS__Alternatives_1 ) ) )
            // InternalMiniOCLCS.g:1955:1: ( ( rule__MultiplicityCS__Alternatives_1 ) )
            {
            // InternalMiniOCLCS.g:1955:1: ( ( rule__MultiplicityCS__Alternatives_1 ) )
            // InternalMiniOCLCS.g:1956:2: ( rule__MultiplicityCS__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getAlternatives_1()); 
            }
            // InternalMiniOCLCS.g:1957:2: ( rule__MultiplicityCS__Alternatives_1 )
            // InternalMiniOCLCS.g:1957:3: rule__MultiplicityCS__Alternatives_1
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
    // InternalMiniOCLCS.g:1965:1: rule__MultiplicityCS__Group__2 : rule__MultiplicityCS__Group__2__Impl ;
    public final void rule__MultiplicityCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1969:1: ( rule__MultiplicityCS__Group__2__Impl )
            // InternalMiniOCLCS.g:1970:2: rule__MultiplicityCS__Group__2__Impl
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
    // InternalMiniOCLCS.g:1976:1: rule__MultiplicityCS__Group__2__Impl : ( ']' ) ;
    public final void rule__MultiplicityCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1980:1: ( ( ']' ) )
            // InternalMiniOCLCS.g:1981:1: ( ']' )
            {
            // InternalMiniOCLCS.g:1981:1: ( ']' )
            // InternalMiniOCLCS.g:1982:2: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_2()); 
            }
            match(input,27,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__MultiplicityCS__Group_1_3__0"
    // InternalMiniOCLCS.g:1992:1: rule__MultiplicityCS__Group_1_3__0 : rule__MultiplicityCS__Group_1_3__0__Impl rule__MultiplicityCS__Group_1_3__1 ;
    public final void rule__MultiplicityCS__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:1996:1: ( rule__MultiplicityCS__Group_1_3__0__Impl rule__MultiplicityCS__Group_1_3__1 )
            // InternalMiniOCLCS.g:1997:2: rule__MultiplicityCS__Group_1_3__0__Impl rule__MultiplicityCS__Group_1_3__1
            {
            pushFollow(FOLLOW_19);
            rule__MultiplicityCS__Group_1_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group_1_3__1();

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
    // $ANTLR end "rule__MultiplicityCS__Group_1_3__0"


    // $ANTLR start "rule__MultiplicityCS__Group_1_3__0__Impl"
    // InternalMiniOCLCS.g:2004:1: rule__MultiplicityCS__Group_1_3__0__Impl : ( ( rule__MultiplicityCS__LowerIntAssignment_1_3_0 ) ) ;
    public final void rule__MultiplicityCS__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2008:1: ( ( ( rule__MultiplicityCS__LowerIntAssignment_1_3_0 ) ) )
            // InternalMiniOCLCS.g:2009:1: ( ( rule__MultiplicityCS__LowerIntAssignment_1_3_0 ) )
            {
            // InternalMiniOCLCS.g:2009:1: ( ( rule__MultiplicityCS__LowerIntAssignment_1_3_0 ) )
            // InternalMiniOCLCS.g:2010:2: ( rule__MultiplicityCS__LowerIntAssignment_1_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getLowerIntAssignment_1_3_0()); 
            }
            // InternalMiniOCLCS.g:2011:2: ( rule__MultiplicityCS__LowerIntAssignment_1_3_0 )
            // InternalMiniOCLCS.g:2011:3: rule__MultiplicityCS__LowerIntAssignment_1_3_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__LowerIntAssignment_1_3_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getLowerIntAssignment_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group_1_3__0__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group_1_3__1"
    // InternalMiniOCLCS.g:2019:1: rule__MultiplicityCS__Group_1_3__1 : rule__MultiplicityCS__Group_1_3__1__Impl rule__MultiplicityCS__Group_1_3__2 ;
    public final void rule__MultiplicityCS__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2023:1: ( rule__MultiplicityCS__Group_1_3__1__Impl rule__MultiplicityCS__Group_1_3__2 )
            // InternalMiniOCLCS.g:2024:2: rule__MultiplicityCS__Group_1_3__1__Impl rule__MultiplicityCS__Group_1_3__2
            {
            pushFollow(FOLLOW_20);
            rule__MultiplicityCS__Group_1_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group_1_3__2();

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
    // $ANTLR end "rule__MultiplicityCS__Group_1_3__1"


    // $ANTLR start "rule__MultiplicityCS__Group_1_3__1__Impl"
    // InternalMiniOCLCS.g:2031:1: rule__MultiplicityCS__Group_1_3__1__Impl : ( '..' ) ;
    public final void rule__MultiplicityCS__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2035:1: ( ( '..' ) )
            // InternalMiniOCLCS.g:2036:1: ( '..' )
            {
            // InternalMiniOCLCS.g:2036:1: ( '..' )
            // InternalMiniOCLCS.g:2037:2: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getFullStopFullStopKeyword_1_3_1()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getFullStopFullStopKeyword_1_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group_1_3__1__Impl"


    // $ANTLR start "rule__MultiplicityCS__Group_1_3__2"
    // InternalMiniOCLCS.g:2046:1: rule__MultiplicityCS__Group_1_3__2 : rule__MultiplicityCS__Group_1_3__2__Impl ;
    public final void rule__MultiplicityCS__Group_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2050:1: ( rule__MultiplicityCS__Group_1_3__2__Impl )
            // InternalMiniOCLCS.g:2051:2: rule__MultiplicityCS__Group_1_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Group_1_3__2__Impl();

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
    // $ANTLR end "rule__MultiplicityCS__Group_1_3__2"


    // $ANTLR start "rule__MultiplicityCS__Group_1_3__2__Impl"
    // InternalMiniOCLCS.g:2057:1: rule__MultiplicityCS__Group_1_3__2__Impl : ( ( rule__MultiplicityCS__Alternatives_1_3_2 ) ) ;
    public final void rule__MultiplicityCS__Group_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2061:1: ( ( ( rule__MultiplicityCS__Alternatives_1_3_2 ) ) )
            // InternalMiniOCLCS.g:2062:1: ( ( rule__MultiplicityCS__Alternatives_1_3_2 ) )
            {
            // InternalMiniOCLCS.g:2062:1: ( ( rule__MultiplicityCS__Alternatives_1_3_2 ) )
            // InternalMiniOCLCS.g:2063:2: ( rule__MultiplicityCS__Alternatives_1_3_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getAlternatives_1_3_2()); 
            }
            // InternalMiniOCLCS.g:2064:2: ( rule__MultiplicityCS__Alternatives_1_3_2 )
            // InternalMiniOCLCS.g:2064:3: rule__MultiplicityCS__Alternatives_1_3_2
            {
            pushFollow(FOLLOW_2);
            rule__MultiplicityCS__Alternatives_1_3_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getAlternatives_1_3_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__Group_1_3__2__Impl"


    // $ANTLR start "rule__OperationCS__Group__0"
    // InternalMiniOCLCS.g:2073:1: rule__OperationCS__Group__0 : rule__OperationCS__Group__0__Impl rule__OperationCS__Group__1 ;
    public final void rule__OperationCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2077:1: ( rule__OperationCS__Group__0__Impl rule__OperationCS__Group__1 )
            // InternalMiniOCLCS.g:2078:2: rule__OperationCS__Group__0__Impl rule__OperationCS__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:2085:1: rule__OperationCS__Group__0__Impl : ( 'op' ) ;
    public final void rule__OperationCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2089:1: ( ( 'op' ) )
            // InternalMiniOCLCS.g:2090:1: ( 'op' )
            {
            // InternalMiniOCLCS.g:2090:1: ( 'op' )
            // InternalMiniOCLCS.g:2091:2: 'op'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getOpKeyword_0()); 
            }
            match(input,29,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2100:1: rule__OperationCS__Group__1 : rule__OperationCS__Group__1__Impl rule__OperationCS__Group__2 ;
    public final void rule__OperationCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2104:1: ( rule__OperationCS__Group__1__Impl rule__OperationCS__Group__2 )
            // InternalMiniOCLCS.g:2105:2: rule__OperationCS__Group__1__Impl rule__OperationCS__Group__2
            {
            pushFollow(FOLLOW_21);
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
    // InternalMiniOCLCS.g:2112:1: rule__OperationCS__Group__1__Impl : ( ( rule__OperationCS__NameAssignment_1 ) ) ;
    public final void rule__OperationCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2116:1: ( ( ( rule__OperationCS__NameAssignment_1 ) ) )
            // InternalMiniOCLCS.g:2117:1: ( ( rule__OperationCS__NameAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:2117:1: ( ( rule__OperationCS__NameAssignment_1 ) )
            // InternalMiniOCLCS.g:2118:2: ( rule__OperationCS__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getNameAssignment_1()); 
            }
            // InternalMiniOCLCS.g:2119:2: ( rule__OperationCS__NameAssignment_1 )
            // InternalMiniOCLCS.g:2119:3: rule__OperationCS__NameAssignment_1
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
    // InternalMiniOCLCS.g:2127:1: rule__OperationCS__Group__2 : rule__OperationCS__Group__2__Impl rule__OperationCS__Group__3 ;
    public final void rule__OperationCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2131:1: ( rule__OperationCS__Group__2__Impl rule__OperationCS__Group__3 )
            // InternalMiniOCLCS.g:2132:2: rule__OperationCS__Group__2__Impl rule__OperationCS__Group__3
            {
            pushFollow(FOLLOW_22);
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
    // InternalMiniOCLCS.g:2139:1: rule__OperationCS__Group__2__Impl : ( '(' ) ;
    public final void rule__OperationCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2143:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:2144:1: ( '(' )
            {
            // InternalMiniOCLCS.g:2144:1: ( '(' )
            // InternalMiniOCLCS.g:2145:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2154:1: rule__OperationCS__Group__3 : rule__OperationCS__Group__3__Impl rule__OperationCS__Group__4 ;
    public final void rule__OperationCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2158:1: ( rule__OperationCS__Group__3__Impl rule__OperationCS__Group__4 )
            // InternalMiniOCLCS.g:2159:2: rule__OperationCS__Group__3__Impl rule__OperationCS__Group__4
            {
            pushFollow(FOLLOW_22);
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
    // InternalMiniOCLCS.g:2166:1: rule__OperationCS__Group__3__Impl : ( ( rule__OperationCS__Group_3__0 )? ) ;
    public final void rule__OperationCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2170:1: ( ( ( rule__OperationCS__Group_3__0 )? ) )
            // InternalMiniOCLCS.g:2171:1: ( ( rule__OperationCS__Group_3__0 )? )
            {
            // InternalMiniOCLCS.g:2171:1: ( ( rule__OperationCS__Group_3__0 )? )
            // InternalMiniOCLCS.g:2172:2: ( rule__OperationCS__Group_3__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getGroup_3()); 
            }
            // InternalMiniOCLCS.g:2173:2: ( rule__OperationCS__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMiniOCLCS.g:2173:3: rule__OperationCS__Group_3__0
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
    // InternalMiniOCLCS.g:2181:1: rule__OperationCS__Group__4 : rule__OperationCS__Group__4__Impl rule__OperationCS__Group__5 ;
    public final void rule__OperationCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2185:1: ( rule__OperationCS__Group__4__Impl rule__OperationCS__Group__5 )
            // InternalMiniOCLCS.g:2186:2: rule__OperationCS__Group__4__Impl rule__OperationCS__Group__5
            {
            pushFollow(FOLLOW_9);
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
    // InternalMiniOCLCS.g:2193:1: rule__OperationCS__Group__4__Impl : ( ')' ) ;
    public final void rule__OperationCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2197:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:2198:1: ( ')' )
            {
            // InternalMiniOCLCS.g:2198:1: ( ')' )
            // InternalMiniOCLCS.g:2199:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2208:1: rule__OperationCS__Group__5 : rule__OperationCS__Group__5__Impl rule__OperationCS__Group__6 ;
    public final void rule__OperationCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2212:1: ( rule__OperationCS__Group__5__Impl rule__OperationCS__Group__6 )
            // InternalMiniOCLCS.g:2213:2: rule__OperationCS__Group__5__Impl rule__OperationCS__Group__6
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:2220:1: rule__OperationCS__Group__5__Impl : ( ':' ) ;
    public final void rule__OperationCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2224:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:2225:1: ( ':' )
            {
            // InternalMiniOCLCS.g:2225:1: ( ':' )
            // InternalMiniOCLCS.g:2226:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getColonKeyword_5()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2235:1: rule__OperationCS__Group__6 : rule__OperationCS__Group__6__Impl rule__OperationCS__Group__7 ;
    public final void rule__OperationCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2239:1: ( rule__OperationCS__Group__6__Impl rule__OperationCS__Group__7 )
            // InternalMiniOCLCS.g:2240:2: rule__OperationCS__Group__6__Impl rule__OperationCS__Group__7
            {
            pushFollow(FOLLOW_23);
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
    // InternalMiniOCLCS.g:2247:1: rule__OperationCS__Group__6__Impl : ( ( rule__OperationCS__ResultRefAssignment_6 ) ) ;
    public final void rule__OperationCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2251:1: ( ( ( rule__OperationCS__ResultRefAssignment_6 ) ) )
            // InternalMiniOCLCS.g:2252:1: ( ( rule__OperationCS__ResultRefAssignment_6 ) )
            {
            // InternalMiniOCLCS.g:2252:1: ( ( rule__OperationCS__ResultRefAssignment_6 ) )
            // InternalMiniOCLCS.g:2253:2: ( rule__OperationCS__ResultRefAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getResultRefAssignment_6()); 
            }
            // InternalMiniOCLCS.g:2254:2: ( rule__OperationCS__ResultRefAssignment_6 )
            // InternalMiniOCLCS.g:2254:3: rule__OperationCS__ResultRefAssignment_6
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
    // InternalMiniOCLCS.g:2262:1: rule__OperationCS__Group__7 : rule__OperationCS__Group__7__Impl rule__OperationCS__Group__8 ;
    public final void rule__OperationCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2266:1: ( rule__OperationCS__Group__7__Impl rule__OperationCS__Group__8 )
            // InternalMiniOCLCS.g:2267:2: rule__OperationCS__Group__7__Impl rule__OperationCS__Group__8
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:2274:1: rule__OperationCS__Group__7__Impl : ( '=' ) ;
    public final void rule__OperationCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2278:1: ( ( '=' ) )
            // InternalMiniOCLCS.g:2279:1: ( '=' )
            {
            // InternalMiniOCLCS.g:2279:1: ( '=' )
            // InternalMiniOCLCS.g:2280:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getEqualsSignKeyword_7()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2289:1: rule__OperationCS__Group__8 : rule__OperationCS__Group__8__Impl rule__OperationCS__Group__9 ;
    public final void rule__OperationCS__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2293:1: ( rule__OperationCS__Group__8__Impl rule__OperationCS__Group__9 )
            // InternalMiniOCLCS.g:2294:2: rule__OperationCS__Group__8__Impl rule__OperationCS__Group__9
            {
            pushFollow(FOLLOW_8);
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
    // InternalMiniOCLCS.g:2301:1: rule__OperationCS__Group__8__Impl : ( ( rule__OperationCS__BodyAssignment_8 ) ) ;
    public final void rule__OperationCS__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2305:1: ( ( ( rule__OperationCS__BodyAssignment_8 ) ) )
            // InternalMiniOCLCS.g:2306:1: ( ( rule__OperationCS__BodyAssignment_8 ) )
            {
            // InternalMiniOCLCS.g:2306:1: ( ( rule__OperationCS__BodyAssignment_8 ) )
            // InternalMiniOCLCS.g:2307:2: ( rule__OperationCS__BodyAssignment_8 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getBodyAssignment_8()); 
            }
            // InternalMiniOCLCS.g:2308:2: ( rule__OperationCS__BodyAssignment_8 )
            // InternalMiniOCLCS.g:2308:3: rule__OperationCS__BodyAssignment_8
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
    // InternalMiniOCLCS.g:2316:1: rule__OperationCS__Group__9 : rule__OperationCS__Group__9__Impl ;
    public final void rule__OperationCS__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2320:1: ( rule__OperationCS__Group__9__Impl )
            // InternalMiniOCLCS.g:2321:2: rule__OperationCS__Group__9__Impl
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
    // InternalMiniOCLCS.g:2327:1: rule__OperationCS__Group__9__Impl : ( ';' ) ;
    public final void rule__OperationCS__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2331:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:2332:1: ( ';' )
            {
            // InternalMiniOCLCS.g:2332:1: ( ';' )
            // InternalMiniOCLCS.g:2333:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getSemicolonKeyword_9()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2343:1: rule__OperationCS__Group_3__0 : rule__OperationCS__Group_3__0__Impl rule__OperationCS__Group_3__1 ;
    public final void rule__OperationCS__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2347:1: ( rule__OperationCS__Group_3__0__Impl rule__OperationCS__Group_3__1 )
            // InternalMiniOCLCS.g:2348:2: rule__OperationCS__Group_3__0__Impl rule__OperationCS__Group_3__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalMiniOCLCS.g:2355:1: rule__OperationCS__Group_3__0__Impl : ( ( rule__OperationCS__ParamsAssignment_3_0 ) ) ;
    public final void rule__OperationCS__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2359:1: ( ( ( rule__OperationCS__ParamsAssignment_3_0 ) ) )
            // InternalMiniOCLCS.g:2360:1: ( ( rule__OperationCS__ParamsAssignment_3_0 ) )
            {
            // InternalMiniOCLCS.g:2360:1: ( ( rule__OperationCS__ParamsAssignment_3_0 ) )
            // InternalMiniOCLCS.g:2361:2: ( rule__OperationCS__ParamsAssignment_3_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getParamsAssignment_3_0()); 
            }
            // InternalMiniOCLCS.g:2362:2: ( rule__OperationCS__ParamsAssignment_3_0 )
            // InternalMiniOCLCS.g:2362:3: rule__OperationCS__ParamsAssignment_3_0
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
    // InternalMiniOCLCS.g:2370:1: rule__OperationCS__Group_3__1 : rule__OperationCS__Group_3__1__Impl ;
    public final void rule__OperationCS__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2374:1: ( rule__OperationCS__Group_3__1__Impl )
            // InternalMiniOCLCS.g:2375:2: rule__OperationCS__Group_3__1__Impl
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
    // InternalMiniOCLCS.g:2381:1: rule__OperationCS__Group_3__1__Impl : ( ( rule__OperationCS__Group_3_1__0 )* ) ;
    public final void rule__OperationCS__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2385:1: ( ( ( rule__OperationCS__Group_3_1__0 )* ) )
            // InternalMiniOCLCS.g:2386:1: ( ( rule__OperationCS__Group_3_1__0 )* )
            {
            // InternalMiniOCLCS.g:2386:1: ( ( rule__OperationCS__Group_3_1__0 )* )
            // InternalMiniOCLCS.g:2387:2: ( rule__OperationCS__Group_3_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getGroup_3_1()); 
            }
            // InternalMiniOCLCS.g:2388:2: ( rule__OperationCS__Group_3_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==32) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2388:3: rule__OperationCS__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__OperationCS__Group_3_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalMiniOCLCS.g:2397:1: rule__OperationCS__Group_3_1__0 : rule__OperationCS__Group_3_1__0__Impl rule__OperationCS__Group_3_1__1 ;
    public final void rule__OperationCS__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2401:1: ( rule__OperationCS__Group_3_1__0__Impl rule__OperationCS__Group_3_1__1 )
            // InternalMiniOCLCS.g:2402:2: rule__OperationCS__Group_3_1__0__Impl rule__OperationCS__Group_3_1__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:2409:1: rule__OperationCS__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__OperationCS__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2413:1: ( ( ',' ) )
            // InternalMiniOCLCS.g:2414:1: ( ',' )
            {
            // InternalMiniOCLCS.g:2414:1: ( ',' )
            // InternalMiniOCLCS.g:2415:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getCommaKeyword_3_1_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2424:1: rule__OperationCS__Group_3_1__1 : rule__OperationCS__Group_3_1__1__Impl ;
    public final void rule__OperationCS__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2428:1: ( rule__OperationCS__Group_3_1__1__Impl )
            // InternalMiniOCLCS.g:2429:2: rule__OperationCS__Group_3_1__1__Impl
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
    // InternalMiniOCLCS.g:2435:1: rule__OperationCS__Group_3_1__1__Impl : ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) ) ;
    public final void rule__OperationCS__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2439:1: ( ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) ) )
            // InternalMiniOCLCS.g:2440:1: ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) )
            {
            // InternalMiniOCLCS.g:2440:1: ( ( rule__OperationCS__ParamsAssignment_3_1_1 ) )
            // InternalMiniOCLCS.g:2441:2: ( rule__OperationCS__ParamsAssignment_3_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getOperationCSAccess().getParamsAssignment_3_1_1()); 
            }
            // InternalMiniOCLCS.g:2442:2: ( rule__OperationCS__ParamsAssignment_3_1_1 )
            // InternalMiniOCLCS.g:2442:3: rule__OperationCS__ParamsAssignment_3_1_1
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
    // InternalMiniOCLCS.g:2451:1: rule__ParameterCS__Group__0 : rule__ParameterCS__Group__0__Impl rule__ParameterCS__Group__1 ;
    public final void rule__ParameterCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2455:1: ( rule__ParameterCS__Group__0__Impl rule__ParameterCS__Group__1 )
            // InternalMiniOCLCS.g:2456:2: rule__ParameterCS__Group__0__Impl rule__ParameterCS__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalMiniOCLCS.g:2463:1: rule__ParameterCS__Group__0__Impl : ( ( rule__ParameterCS__NameAssignment_0 ) ) ;
    public final void rule__ParameterCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2467:1: ( ( ( rule__ParameterCS__NameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:2468:1: ( ( rule__ParameterCS__NameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:2468:1: ( ( rule__ParameterCS__NameAssignment_0 ) )
            // InternalMiniOCLCS.g:2469:2: ( rule__ParameterCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:2470:2: ( rule__ParameterCS__NameAssignment_0 )
            // InternalMiniOCLCS.g:2470:3: rule__ParameterCS__NameAssignment_0
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
    // InternalMiniOCLCS.g:2478:1: rule__ParameterCS__Group__1 : rule__ParameterCS__Group__1__Impl rule__ParameterCS__Group__2 ;
    public final void rule__ParameterCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2482:1: ( rule__ParameterCS__Group__1__Impl rule__ParameterCS__Group__2 )
            // InternalMiniOCLCS.g:2483:2: rule__ParameterCS__Group__1__Impl rule__ParameterCS__Group__2
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:2490:1: rule__ParameterCS__Group__1__Impl : ( ':' ) ;
    public final void rule__ParameterCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2494:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:2495:1: ( ':' )
            {
            // InternalMiniOCLCS.g:2495:1: ( ':' )
            // InternalMiniOCLCS.g:2496:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getColonKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2505:1: rule__ParameterCS__Group__2 : rule__ParameterCS__Group__2__Impl ;
    public final void rule__ParameterCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2509:1: ( rule__ParameterCS__Group__2__Impl )
            // InternalMiniOCLCS.g:2510:2: rule__ParameterCS__Group__2__Impl
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
    // InternalMiniOCLCS.g:2516:1: rule__ParameterCS__Group__2__Impl : ( ( rule__ParameterCS__TypeRefAssignment_2 ) ) ;
    public final void rule__ParameterCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2520:1: ( ( ( rule__ParameterCS__TypeRefAssignment_2 ) ) )
            // InternalMiniOCLCS.g:2521:1: ( ( rule__ParameterCS__TypeRefAssignment_2 ) )
            {
            // InternalMiniOCLCS.g:2521:1: ( ( rule__ParameterCS__TypeRefAssignment_2 ) )
            // InternalMiniOCLCS.g:2522:2: ( rule__ParameterCS__TypeRefAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParameterCSAccess().getTypeRefAssignment_2()); 
            }
            // InternalMiniOCLCS.g:2523:2: ( rule__ParameterCS__TypeRefAssignment_2 )
            // InternalMiniOCLCS.g:2523:3: rule__ParameterCS__TypeRefAssignment_2
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
    // InternalMiniOCLCS.g:2532:1: rule__ConstraintsDefCS__Group__0 : rule__ConstraintsDefCS__Group__0__Impl rule__ConstraintsDefCS__Group__1 ;
    public final void rule__ConstraintsDefCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2536:1: ( rule__ConstraintsDefCS__Group__0__Impl rule__ConstraintsDefCS__Group__1 )
            // InternalMiniOCLCS.g:2537:2: rule__ConstraintsDefCS__Group__0__Impl rule__ConstraintsDefCS__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:2544:1: rule__ConstraintsDefCS__Group__0__Impl : ( 'context' ) ;
    public final void rule__ConstraintsDefCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2548:1: ( ( 'context' ) )
            // InternalMiniOCLCS.g:2549:1: ( 'context' )
            {
            // InternalMiniOCLCS.g:2549:1: ( 'context' )
            // InternalMiniOCLCS.g:2550:2: 'context'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getContextKeyword_0()); 
            }
            match(input,33,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2559:1: rule__ConstraintsDefCS__Group__1 : rule__ConstraintsDefCS__Group__1__Impl rule__ConstraintsDefCS__Group__2 ;
    public final void rule__ConstraintsDefCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2563:1: ( rule__ConstraintsDefCS__Group__1__Impl rule__ConstraintsDefCS__Group__2 )
            // InternalMiniOCLCS.g:2564:2: rule__ConstraintsDefCS__Group__1__Impl rule__ConstraintsDefCS__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalMiniOCLCS.g:2571:1: rule__ConstraintsDefCS__Group__1__Impl : ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) ) ;
    public final void rule__ConstraintsDefCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2575:1: ( ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) ) )
            // InternalMiniOCLCS.g:2576:1: ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:2576:1: ( ( rule__ConstraintsDefCS__TypeRefAssignment_1 ) )
            // InternalMiniOCLCS.g:2577:2: ( rule__ConstraintsDefCS__TypeRefAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getTypeRefAssignment_1()); 
            }
            // InternalMiniOCLCS.g:2578:2: ( rule__ConstraintsDefCS__TypeRefAssignment_1 )
            // InternalMiniOCLCS.g:2578:3: rule__ConstraintsDefCS__TypeRefAssignment_1
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
    // InternalMiniOCLCS.g:2586:1: rule__ConstraintsDefCS__Group__2 : rule__ConstraintsDefCS__Group__2__Impl rule__ConstraintsDefCS__Group__3 ;
    public final void rule__ConstraintsDefCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2590:1: ( rule__ConstraintsDefCS__Group__2__Impl rule__ConstraintsDefCS__Group__3 )
            // InternalMiniOCLCS.g:2591:2: rule__ConstraintsDefCS__Group__2__Impl rule__ConstraintsDefCS__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalMiniOCLCS.g:2598:1: rule__ConstraintsDefCS__Group__2__Impl : ( '{' ) ;
    public final void rule__ConstraintsDefCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2602:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:2603:1: ( '{' )
            {
            // InternalMiniOCLCS.g:2603:1: ( '{' )
            // InternalMiniOCLCS.g:2604:2: '{'
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
    // InternalMiniOCLCS.g:2613:1: rule__ConstraintsDefCS__Group__3 : rule__ConstraintsDefCS__Group__3__Impl rule__ConstraintsDefCS__Group__4 ;
    public final void rule__ConstraintsDefCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2617:1: ( rule__ConstraintsDefCS__Group__3__Impl rule__ConstraintsDefCS__Group__4 )
            // InternalMiniOCLCS.g:2618:2: rule__ConstraintsDefCS__Group__3__Impl rule__ConstraintsDefCS__Group__4
            {
            pushFollow(FOLLOW_27);
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
    // InternalMiniOCLCS.g:2625:1: rule__ConstraintsDefCS__Group__3__Impl : ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* ) ;
    public final void rule__ConstraintsDefCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2629:1: ( ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* ) )
            // InternalMiniOCLCS.g:2630:1: ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* )
            {
            // InternalMiniOCLCS.g:2630:1: ( ( rule__ConstraintsDefCS__InvariantsAssignment_3 )* )
            // InternalMiniOCLCS.g:2631:2: ( rule__ConstraintsDefCS__InvariantsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getConstraintsDefCSAccess().getInvariantsAssignment_3()); 
            }
            // InternalMiniOCLCS.g:2632:2: ( rule__ConstraintsDefCS__InvariantsAssignment_3 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==34) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2632:3: rule__ConstraintsDefCS__InvariantsAssignment_3
            	    {
            	    pushFollow(FOLLOW_28);
            	    rule__ConstraintsDefCS__InvariantsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalMiniOCLCS.g:2640:1: rule__ConstraintsDefCS__Group__4 : rule__ConstraintsDefCS__Group__4__Impl ;
    public final void rule__ConstraintsDefCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2644:1: ( rule__ConstraintsDefCS__Group__4__Impl )
            // InternalMiniOCLCS.g:2645:2: rule__ConstraintsDefCS__Group__4__Impl
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
    // InternalMiniOCLCS.g:2651:1: rule__ConstraintsDefCS__Group__4__Impl : ( '}' ) ;
    public final void rule__ConstraintsDefCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2655:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:2656:1: ( '}' )
            {
            // InternalMiniOCLCS.g:2656:1: ( '}' )
            // InternalMiniOCLCS.g:2657:2: '}'
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
    // InternalMiniOCLCS.g:2667:1: rule__InvariantCS__Group__0 : rule__InvariantCS__Group__0__Impl rule__InvariantCS__Group__1 ;
    public final void rule__InvariantCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2671:1: ( rule__InvariantCS__Group__0__Impl rule__InvariantCS__Group__1 )
            // InternalMiniOCLCS.g:2672:2: rule__InvariantCS__Group__0__Impl rule__InvariantCS__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalMiniOCLCS.g:2679:1: rule__InvariantCS__Group__0__Impl : ( 'inv' ) ;
    public final void rule__InvariantCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2683:1: ( ( 'inv' ) )
            // InternalMiniOCLCS.g:2684:1: ( 'inv' )
            {
            // InternalMiniOCLCS.g:2684:1: ( 'inv' )
            // InternalMiniOCLCS.g:2685:2: 'inv'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getInvKeyword_0()); 
            }
            match(input,34,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2694:1: rule__InvariantCS__Group__1 : rule__InvariantCS__Group__1__Impl rule__InvariantCS__Group__2 ;
    public final void rule__InvariantCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2698:1: ( rule__InvariantCS__Group__1__Impl rule__InvariantCS__Group__2 )
            // InternalMiniOCLCS.g:2699:2: rule__InvariantCS__Group__1__Impl rule__InvariantCS__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:2706:1: rule__InvariantCS__Group__1__Impl : ( ':' ) ;
    public final void rule__InvariantCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2710:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:2711:1: ( ':' )
            {
            // InternalMiniOCLCS.g:2711:1: ( ':' )
            // InternalMiniOCLCS.g:2712:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getColonKeyword_1()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:2721:1: rule__InvariantCS__Group__2 : rule__InvariantCS__Group__2__Impl rule__InvariantCS__Group__3 ;
    public final void rule__InvariantCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2725:1: ( rule__InvariantCS__Group__2__Impl rule__InvariantCS__Group__3 )
            // InternalMiniOCLCS.g:2726:2: rule__InvariantCS__Group__2__Impl rule__InvariantCS__Group__3
            {
            pushFollow(FOLLOW_8);
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
    // InternalMiniOCLCS.g:2733:1: rule__InvariantCS__Group__2__Impl : ( ( rule__InvariantCS__ExpAssignment_2 ) ) ;
    public final void rule__InvariantCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2737:1: ( ( ( rule__InvariantCS__ExpAssignment_2 ) ) )
            // InternalMiniOCLCS.g:2738:1: ( ( rule__InvariantCS__ExpAssignment_2 ) )
            {
            // InternalMiniOCLCS.g:2738:1: ( ( rule__InvariantCS__ExpAssignment_2 ) )
            // InternalMiniOCLCS.g:2739:2: ( rule__InvariantCS__ExpAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getExpAssignment_2()); 
            }
            // InternalMiniOCLCS.g:2740:2: ( rule__InvariantCS__ExpAssignment_2 )
            // InternalMiniOCLCS.g:2740:3: rule__InvariantCS__ExpAssignment_2
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
    // InternalMiniOCLCS.g:2748:1: rule__InvariantCS__Group__3 : rule__InvariantCS__Group__3__Impl ;
    public final void rule__InvariantCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2752:1: ( rule__InvariantCS__Group__3__Impl )
            // InternalMiniOCLCS.g:2753:2: rule__InvariantCS__Group__3__Impl
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
    // InternalMiniOCLCS.g:2759:1: rule__InvariantCS__Group__3__Impl : ( ';' ) ;
    public final void rule__InvariantCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2763:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:2764:1: ( ';' )
            {
            // InternalMiniOCLCS.g:2764:1: ( ';' )
            // InternalMiniOCLCS.g:2765:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getInvariantCSAccess().getSemicolonKeyword_3()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__EqualityExpCS__Group__0"
    // InternalMiniOCLCS.g:2775:1: rule__EqualityExpCS__Group__0 : rule__EqualityExpCS__Group__0__Impl rule__EqualityExpCS__Group__1 ;
    public final void rule__EqualityExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2779:1: ( rule__EqualityExpCS__Group__0__Impl rule__EqualityExpCS__Group__1 )
            // InternalMiniOCLCS.g:2780:2: rule__EqualityExpCS__Group__0__Impl rule__EqualityExpCS__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__EqualityExpCS__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EqualityExpCS__Group__1();

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
    // $ANTLR end "rule__EqualityExpCS__Group__0"


    // $ANTLR start "rule__EqualityExpCS__Group__0__Impl"
    // InternalMiniOCLCS.g:2787:1: rule__EqualityExpCS__Group__0__Impl : ( ruleCallExpCS ) ;
    public final void rule__EqualityExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2791:1: ( ( ruleCallExpCS ) )
            // InternalMiniOCLCS.g:2792:1: ( ruleCallExpCS )
            {
            // InternalMiniOCLCS.g:2792:1: ( ruleCallExpCS )
            // InternalMiniOCLCS.g:2793:2: ruleCallExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpCSAccess().getCallExpCSParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCallExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpCSAccess().getCallExpCSParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpCS__Group__0__Impl"


    // $ANTLR start "rule__EqualityExpCS__Group__1"
    // InternalMiniOCLCS.g:2802:1: rule__EqualityExpCS__Group__1 : rule__EqualityExpCS__Group__1__Impl ;
    public final void rule__EqualityExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2806:1: ( rule__EqualityExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:2807:2: rule__EqualityExpCS__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpCS__Group__1__Impl();

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
    // $ANTLR end "rule__EqualityExpCS__Group__1"


    // $ANTLR start "rule__EqualityExpCS__Group__1__Impl"
    // InternalMiniOCLCS.g:2813:1: rule__EqualityExpCS__Group__1__Impl : ( ( rule__EqualityExpCS__Group_1__0 )* ) ;
    public final void rule__EqualityExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2817:1: ( ( ( rule__EqualityExpCS__Group_1__0 )* ) )
            // InternalMiniOCLCS.g:2818:1: ( ( rule__EqualityExpCS__Group_1__0 )* )
            {
            // InternalMiniOCLCS.g:2818:1: ( ( rule__EqualityExpCS__Group_1__0 )* )
            // InternalMiniOCLCS.g:2819:2: ( rule__EqualityExpCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:2820:2: ( rule__EqualityExpCS__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==12) ) {
                    int LA22_2 = input.LA(2);

                    if ( (synpred28_InternalMiniOCLCS()) ) {
                        alt22=1;
                    }


                }
                else if ( (LA22_0==13) ) {
                    int LA22_3 = input.LA(2);

                    if ( (synpred28_InternalMiniOCLCS()) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2820:3: rule__EqualityExpCS__Group_1__0
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__EqualityExpCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpCSAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpCS__Group__1__Impl"


    // $ANTLR start "rule__EqualityExpCS__Group_1__0"
    // InternalMiniOCLCS.g:2829:1: rule__EqualityExpCS__Group_1__0 : rule__EqualityExpCS__Group_1__0__Impl rule__EqualityExpCS__Group_1__1 ;
    public final void rule__EqualityExpCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2833:1: ( rule__EqualityExpCS__Group_1__0__Impl rule__EqualityExpCS__Group_1__1 )
            // InternalMiniOCLCS.g:2834:2: rule__EqualityExpCS__Group_1__0__Impl rule__EqualityExpCS__Group_1__1
            {
            pushFollow(FOLLOW_29);
            rule__EqualityExpCS__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EqualityExpCS__Group_1__1();

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
    // $ANTLR end "rule__EqualityExpCS__Group_1__0"


    // $ANTLR start "rule__EqualityExpCS__Group_1__0__Impl"
    // InternalMiniOCLCS.g:2841:1: rule__EqualityExpCS__Group_1__0__Impl : ( () ) ;
    public final void rule__EqualityExpCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2845:1: ( ( () ) )
            // InternalMiniOCLCS.g:2846:1: ( () )
            {
            // InternalMiniOCLCS.g:2846:1: ( () )
            // InternalMiniOCLCS.g:2847:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpCSAccess().getEqualityExpCSLeftAction_1_0()); 
            }
            // InternalMiniOCLCS.g:2848:2: ()
            // InternalMiniOCLCS.g:2848:3: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpCSAccess().getEqualityExpCSLeftAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpCS__Group_1__0__Impl"


    // $ANTLR start "rule__EqualityExpCS__Group_1__1"
    // InternalMiniOCLCS.g:2856:1: rule__EqualityExpCS__Group_1__1 : rule__EqualityExpCS__Group_1__1__Impl rule__EqualityExpCS__Group_1__2 ;
    public final void rule__EqualityExpCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2860:1: ( rule__EqualityExpCS__Group_1__1__Impl rule__EqualityExpCS__Group_1__2 )
            // InternalMiniOCLCS.g:2861:2: rule__EqualityExpCS__Group_1__1__Impl rule__EqualityExpCS__Group_1__2
            {
            pushFollow(FOLLOW_24);
            rule__EqualityExpCS__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_2);
            rule__EqualityExpCS__Group_1__2();

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
    // $ANTLR end "rule__EqualityExpCS__Group_1__1"


    // $ANTLR start "rule__EqualityExpCS__Group_1__1__Impl"
    // InternalMiniOCLCS.g:2868:1: rule__EqualityExpCS__Group_1__1__Impl : ( ( rule__EqualityExpCS__OpNameAssignment_1_1 ) ) ;
    public final void rule__EqualityExpCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2872:1: ( ( ( rule__EqualityExpCS__OpNameAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:2873:1: ( ( rule__EqualityExpCS__OpNameAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:2873:1: ( ( rule__EqualityExpCS__OpNameAssignment_1_1 ) )
            // InternalMiniOCLCS.g:2874:2: ( rule__EqualityExpCS__OpNameAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpCSAccess().getOpNameAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:2875:2: ( rule__EqualityExpCS__OpNameAssignment_1_1 )
            // InternalMiniOCLCS.g:2875:3: rule__EqualityExpCS__OpNameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpCS__OpNameAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpCSAccess().getOpNameAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpCS__Group_1__1__Impl"


    // $ANTLR start "rule__EqualityExpCS__Group_1__2"
    // InternalMiniOCLCS.g:2883:1: rule__EqualityExpCS__Group_1__2 : rule__EqualityExpCS__Group_1__2__Impl ;
    public final void rule__EqualityExpCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2887:1: ( rule__EqualityExpCS__Group_1__2__Impl )
            // InternalMiniOCLCS.g:2888:2: rule__EqualityExpCS__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpCS__Group_1__2__Impl();

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
    // $ANTLR end "rule__EqualityExpCS__Group_1__2"


    // $ANTLR start "rule__EqualityExpCS__Group_1__2__Impl"
    // InternalMiniOCLCS.g:2894:1: rule__EqualityExpCS__Group_1__2__Impl : ( ( rule__EqualityExpCS__RightAssignment_1_2 ) ) ;
    public final void rule__EqualityExpCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2898:1: ( ( ( rule__EqualityExpCS__RightAssignment_1_2 ) ) )
            // InternalMiniOCLCS.g:2899:1: ( ( rule__EqualityExpCS__RightAssignment_1_2 ) )
            {
            // InternalMiniOCLCS.g:2899:1: ( ( rule__EqualityExpCS__RightAssignment_1_2 ) )
            // InternalMiniOCLCS.g:2900:2: ( rule__EqualityExpCS__RightAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpCSAccess().getRightAssignment_1_2()); 
            }
            // InternalMiniOCLCS.g:2901:2: ( rule__EqualityExpCS__RightAssignment_1_2 )
            // InternalMiniOCLCS.g:2901:3: rule__EqualityExpCS__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpCS__RightAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpCSAccess().getRightAssignment_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpCS__Group_1__2__Impl"


    // $ANTLR start "rule__CallExpCS__Group__0"
    // InternalMiniOCLCS.g:2910:1: rule__CallExpCS__Group__0 : rule__CallExpCS__Group__0__Impl rule__CallExpCS__Group__1 ;
    public final void rule__CallExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2914:1: ( rule__CallExpCS__Group__0__Impl rule__CallExpCS__Group__1 )
            // InternalMiniOCLCS.g:2915:2: rule__CallExpCS__Group__0__Impl rule__CallExpCS__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalMiniOCLCS.g:2922:1: rule__CallExpCS__Group__0__Impl : ( rulePrimaryExpCS ) ;
    public final void rule__CallExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2926:1: ( ( rulePrimaryExpCS ) )
            // InternalMiniOCLCS.g:2927:1: ( rulePrimaryExpCS )
            {
            // InternalMiniOCLCS.g:2927:1: ( rulePrimaryExpCS )
            // InternalMiniOCLCS.g:2928:2: rulePrimaryExpCS
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
    // InternalMiniOCLCS.g:2937:1: rule__CallExpCS__Group__1 : rule__CallExpCS__Group__1__Impl ;
    public final void rule__CallExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2941:1: ( rule__CallExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:2942:2: rule__CallExpCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:2948:1: rule__CallExpCS__Group__1__Impl : ( ( rule__CallExpCS__Group_1__0 )* ) ;
    public final void rule__CallExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2952:1: ( ( ( rule__CallExpCS__Group_1__0 )* ) )
            // InternalMiniOCLCS.g:2953:1: ( ( rule__CallExpCS__Group_1__0 )* )
            {
            // InternalMiniOCLCS.g:2953:1: ( ( rule__CallExpCS__Group_1__0 )* )
            // InternalMiniOCLCS.g:2954:2: ( rule__CallExpCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:2955:2: ( rule__CallExpCS__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==14) ) {
                    int LA23_2 = input.LA(2);

                    if ( (synpred29_InternalMiniOCLCS()) ) {
                        alt23=1;
                    }


                }
                else if ( (LA23_0==15) ) {
                    int LA23_3 = input.LA(2);

                    if ( (synpred29_InternalMiniOCLCS()) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // InternalMiniOCLCS.g:2955:3: rule__CallExpCS__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__CallExpCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalMiniOCLCS.g:2964:1: rule__CallExpCS__Group_1__0 : rule__CallExpCS__Group_1__0__Impl rule__CallExpCS__Group_1__1 ;
    public final void rule__CallExpCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2968:1: ( rule__CallExpCS__Group_1__0__Impl rule__CallExpCS__Group_1__1 )
            // InternalMiniOCLCS.g:2969:2: rule__CallExpCS__Group_1__0__Impl rule__CallExpCS__Group_1__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalMiniOCLCS.g:2976:1: rule__CallExpCS__Group_1__0__Impl : ( () ) ;
    public final void rule__CallExpCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2980:1: ( ( () ) )
            // InternalMiniOCLCS.g:2981:1: ( () )
            {
            // InternalMiniOCLCS.g:2981:1: ( () )
            // InternalMiniOCLCS.g:2982:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getCallExpCSSourceAction_1_0()); 
            }
            // InternalMiniOCLCS.g:2983:2: ()
            // InternalMiniOCLCS.g:2983:3: 
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
    // InternalMiniOCLCS.g:2991:1: rule__CallExpCS__Group_1__1 : rule__CallExpCS__Group_1__1__Impl rule__CallExpCS__Group_1__2 ;
    public final void rule__CallExpCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:2995:1: ( rule__CallExpCS__Group_1__1__Impl rule__CallExpCS__Group_1__2 )
            // InternalMiniOCLCS.g:2996:2: rule__CallExpCS__Group_1__1__Impl rule__CallExpCS__Group_1__2
            {
            pushFollow(FOLLOW_33);
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
    // InternalMiniOCLCS.g:3003:1: rule__CallExpCS__Group_1__1__Impl : ( ( rule__CallExpCS__OpNameAssignment_1_1 ) ) ;
    public final void rule__CallExpCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3007:1: ( ( ( rule__CallExpCS__OpNameAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:3008:1: ( ( rule__CallExpCS__OpNameAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:3008:1: ( ( rule__CallExpCS__OpNameAssignment_1_1 ) )
            // InternalMiniOCLCS.g:3009:2: ( rule__CallExpCS__OpNameAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getOpNameAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:3010:2: ( rule__CallExpCS__OpNameAssignment_1_1 )
            // InternalMiniOCLCS.g:3010:3: rule__CallExpCS__OpNameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CallExpCS__OpNameAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getOpNameAssignment_1_1()); 
            }

            }


            }

        }
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
    // InternalMiniOCLCS.g:3018:1: rule__CallExpCS__Group_1__2 : rule__CallExpCS__Group_1__2__Impl ;
    public final void rule__CallExpCS__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3022:1: ( rule__CallExpCS__Group_1__2__Impl )
            // InternalMiniOCLCS.g:3023:2: rule__CallExpCS__Group_1__2__Impl
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
    // InternalMiniOCLCS.g:3029:1: rule__CallExpCS__Group_1__2__Impl : ( ( rule__CallExpCS__NavExpAssignment_1_2 ) ) ;
    public final void rule__CallExpCS__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3033:1: ( ( ( rule__CallExpCS__NavExpAssignment_1_2 ) ) )
            // InternalMiniOCLCS.g:3034:1: ( ( rule__CallExpCS__NavExpAssignment_1_2 ) )
            {
            // InternalMiniOCLCS.g:3034:1: ( ( rule__CallExpCS__NavExpAssignment_1_2 ) )
            // InternalMiniOCLCS.g:3035:2: ( rule__CallExpCS__NavExpAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getNavExpAssignment_1_2()); 
            }
            // InternalMiniOCLCS.g:3036:2: ( rule__CallExpCS__NavExpAssignment_1_2 )
            // InternalMiniOCLCS.g:3036:3: rule__CallExpCS__NavExpAssignment_1_2
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
    // InternalMiniOCLCS.g:3045:1: rule__SelfExpCS__Group__0 : rule__SelfExpCS__Group__0__Impl rule__SelfExpCS__Group__1 ;
    public final void rule__SelfExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3049:1: ( rule__SelfExpCS__Group__0__Impl rule__SelfExpCS__Group__1 )
            // InternalMiniOCLCS.g:3050:2: rule__SelfExpCS__Group__0__Impl rule__SelfExpCS__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalMiniOCLCS.g:3057:1: rule__SelfExpCS__Group__0__Impl : ( () ) ;
    public final void rule__SelfExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3061:1: ( ( () ) )
            // InternalMiniOCLCS.g:3062:1: ( () )
            {
            // InternalMiniOCLCS.g:3062:1: ( () )
            // InternalMiniOCLCS.g:3063:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0()); 
            }
            // InternalMiniOCLCS.g:3064:2: ()
            // InternalMiniOCLCS.g:3064:3: 
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
    // InternalMiniOCLCS.g:3072:1: rule__SelfExpCS__Group__1 : rule__SelfExpCS__Group__1__Impl ;
    public final void rule__SelfExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3076:1: ( rule__SelfExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:3077:2: rule__SelfExpCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:3083:1: rule__SelfExpCS__Group__1__Impl : ( 'self' ) ;
    public final void rule__SelfExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3087:1: ( ( 'self' ) )
            // InternalMiniOCLCS.g:3088:1: ( 'self' )
            {
            // InternalMiniOCLCS.g:3088:1: ( 'self' )
            // InternalMiniOCLCS.g:3089:2: 'self'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getSelfExpCSAccess().getSelfKeyword_1()); 
            }
            match(input,35,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3099:1: rule__CollectExpCS__Group__0 : rule__CollectExpCS__Group__0__Impl rule__CollectExpCS__Group__1 ;
    public final void rule__CollectExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3103:1: ( rule__CollectExpCS__Group__0__Impl rule__CollectExpCS__Group__1 )
            // InternalMiniOCLCS.g:3104:2: rule__CollectExpCS__Group__0__Impl rule__CollectExpCS__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalMiniOCLCS.g:3111:1: rule__CollectExpCS__Group__0__Impl : ( 'collect' ) ;
    public final void rule__CollectExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3115:1: ( ( 'collect' ) )
            // InternalMiniOCLCS.g:3116:1: ( 'collect' )
            {
            // InternalMiniOCLCS.g:3116:1: ( 'collect' )
            // InternalMiniOCLCS.g:3117:2: 'collect'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getCollectKeyword_0()); 
            }
            match(input,36,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3126:1: rule__CollectExpCS__Group__1 : rule__CollectExpCS__Group__1__Impl rule__CollectExpCS__Group__2 ;
    public final void rule__CollectExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3130:1: ( rule__CollectExpCS__Group__1__Impl rule__CollectExpCS__Group__2 )
            // InternalMiniOCLCS.g:3131:2: rule__CollectExpCS__Group__1__Impl rule__CollectExpCS__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:3138:1: rule__CollectExpCS__Group__1__Impl : ( '(' ) ;
    public final void rule__CollectExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3142:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:3143:1: ( '(' )
            {
            // InternalMiniOCLCS.g:3143:1: ( '(' )
            // InternalMiniOCLCS.g:3144:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3153:1: rule__CollectExpCS__Group__2 : rule__CollectExpCS__Group__2__Impl rule__CollectExpCS__Group__3 ;
    public final void rule__CollectExpCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3157:1: ( rule__CollectExpCS__Group__2__Impl rule__CollectExpCS__Group__3 )
            // InternalMiniOCLCS.g:3158:2: rule__CollectExpCS__Group__2__Impl rule__CollectExpCS__Group__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:3165:1: rule__CollectExpCS__Group__2__Impl : ( ( rule__CollectExpCS__Group_2__0 )? ) ;
    public final void rule__CollectExpCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3169:1: ( ( ( rule__CollectExpCS__Group_2__0 )? ) )
            // InternalMiniOCLCS.g:3170:1: ( ( rule__CollectExpCS__Group_2__0 )? )
            {
            // InternalMiniOCLCS.g:3170:1: ( ( rule__CollectExpCS__Group_2__0 )? )
            // InternalMiniOCLCS.g:3171:2: ( rule__CollectExpCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:3172:2: ( rule__CollectExpCS__Group_2__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==19||LA24_1==37) ) {
                    alt24=1;
                }
            }
            switch (alt24) {
                case 1 :
                    // InternalMiniOCLCS.g:3172:3: rule__CollectExpCS__Group_2__0
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
    // InternalMiniOCLCS.g:3180:1: rule__CollectExpCS__Group__3 : rule__CollectExpCS__Group__3__Impl rule__CollectExpCS__Group__4 ;
    public final void rule__CollectExpCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3184:1: ( rule__CollectExpCS__Group__3__Impl rule__CollectExpCS__Group__4 )
            // InternalMiniOCLCS.g:3185:2: rule__CollectExpCS__Group__3__Impl rule__CollectExpCS__Group__4
            {
            pushFollow(FOLLOW_35);
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
    // InternalMiniOCLCS.g:3192:1: rule__CollectExpCS__Group__3__Impl : ( ( rule__CollectExpCS__ExpAssignment_3 ) ) ;
    public final void rule__CollectExpCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3196:1: ( ( ( rule__CollectExpCS__ExpAssignment_3 ) ) )
            // InternalMiniOCLCS.g:3197:1: ( ( rule__CollectExpCS__ExpAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:3197:1: ( ( rule__CollectExpCS__ExpAssignment_3 ) )
            // InternalMiniOCLCS.g:3198:2: ( rule__CollectExpCS__ExpAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getExpAssignment_3()); 
            }
            // InternalMiniOCLCS.g:3199:2: ( rule__CollectExpCS__ExpAssignment_3 )
            // InternalMiniOCLCS.g:3199:3: rule__CollectExpCS__ExpAssignment_3
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
    // InternalMiniOCLCS.g:3207:1: rule__CollectExpCS__Group__4 : rule__CollectExpCS__Group__4__Impl ;
    public final void rule__CollectExpCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3211:1: ( rule__CollectExpCS__Group__4__Impl )
            // InternalMiniOCLCS.g:3212:2: rule__CollectExpCS__Group__4__Impl
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
    // InternalMiniOCLCS.g:3218:1: rule__CollectExpCS__Group__4__Impl : ( ')' ) ;
    public final void rule__CollectExpCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3222:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:3223:1: ( ')' )
            {
            // InternalMiniOCLCS.g:3223:1: ( ')' )
            // InternalMiniOCLCS.g:3224:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3234:1: rule__CollectExpCS__Group_2__0 : rule__CollectExpCS__Group_2__0__Impl rule__CollectExpCS__Group_2__1 ;
    public final void rule__CollectExpCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3238:1: ( rule__CollectExpCS__Group_2__0__Impl rule__CollectExpCS__Group_2__1 )
            // InternalMiniOCLCS.g:3239:2: rule__CollectExpCS__Group_2__0__Impl rule__CollectExpCS__Group_2__1
            {
            pushFollow(FOLLOW_36);
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
    // InternalMiniOCLCS.g:3246:1: rule__CollectExpCS__Group_2__0__Impl : ( ( rule__CollectExpCS__ItVarAssignment_2_0 ) ) ;
    public final void rule__CollectExpCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3250:1: ( ( ( rule__CollectExpCS__ItVarAssignment_2_0 ) ) )
            // InternalMiniOCLCS.g:3251:1: ( ( rule__CollectExpCS__ItVarAssignment_2_0 ) )
            {
            // InternalMiniOCLCS.g:3251:1: ( ( rule__CollectExpCS__ItVarAssignment_2_0 ) )
            // InternalMiniOCLCS.g:3252:2: ( rule__CollectExpCS__ItVarAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getItVarAssignment_2_0()); 
            }
            // InternalMiniOCLCS.g:3253:2: ( rule__CollectExpCS__ItVarAssignment_2_0 )
            // InternalMiniOCLCS.g:3253:3: rule__CollectExpCS__ItVarAssignment_2_0
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
    // InternalMiniOCLCS.g:3261:1: rule__CollectExpCS__Group_2__1 : rule__CollectExpCS__Group_2__1__Impl ;
    public final void rule__CollectExpCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3265:1: ( rule__CollectExpCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:3266:2: rule__CollectExpCS__Group_2__1__Impl
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
    // InternalMiniOCLCS.g:3272:1: rule__CollectExpCS__Group_2__1__Impl : ( '|' ) ;
    public final void rule__CollectExpCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3276:1: ( ( '|' ) )
            // InternalMiniOCLCS.g:3277:1: ( '|' )
            {
            // InternalMiniOCLCS.g:3277:1: ( '|' )
            // InternalMiniOCLCS.g:3278:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectExpCSAccess().getVerticalLineKeyword_2_1()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3288:1: rule__IteratorVarCS__Group__0 : rule__IteratorVarCS__Group__0__Impl rule__IteratorVarCS__Group__1 ;
    public final void rule__IteratorVarCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3292:1: ( rule__IteratorVarCS__Group__0__Impl rule__IteratorVarCS__Group__1 )
            // InternalMiniOCLCS.g:3293:2: rule__IteratorVarCS__Group__0__Impl rule__IteratorVarCS__Group__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalMiniOCLCS.g:3300:1: rule__IteratorVarCS__Group__0__Impl : ( ( rule__IteratorVarCS__ItNameAssignment_0 ) ) ;
    public final void rule__IteratorVarCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3304:1: ( ( ( rule__IteratorVarCS__ItNameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:3305:1: ( ( rule__IteratorVarCS__ItNameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:3305:1: ( ( rule__IteratorVarCS__ItNameAssignment_0 ) )
            // InternalMiniOCLCS.g:3306:2: ( rule__IteratorVarCS__ItNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getItNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:3307:2: ( rule__IteratorVarCS__ItNameAssignment_0 )
            // InternalMiniOCLCS.g:3307:3: rule__IteratorVarCS__ItNameAssignment_0
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
    // InternalMiniOCLCS.g:3315:1: rule__IteratorVarCS__Group__1 : rule__IteratorVarCS__Group__1__Impl ;
    public final void rule__IteratorVarCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3319:1: ( rule__IteratorVarCS__Group__1__Impl )
            // InternalMiniOCLCS.g:3320:2: rule__IteratorVarCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:3326:1: rule__IteratorVarCS__Group__1__Impl : ( ( rule__IteratorVarCS__Group_1__0 )? ) ;
    public final void rule__IteratorVarCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3330:1: ( ( ( rule__IteratorVarCS__Group_1__0 )? ) )
            // InternalMiniOCLCS.g:3331:1: ( ( rule__IteratorVarCS__Group_1__0 )? )
            {
            // InternalMiniOCLCS.g:3331:1: ( ( rule__IteratorVarCS__Group_1__0 )? )
            // InternalMiniOCLCS.g:3332:2: ( rule__IteratorVarCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:3333:2: ( rule__IteratorVarCS__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==19) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMiniOCLCS.g:3333:3: rule__IteratorVarCS__Group_1__0
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
    // InternalMiniOCLCS.g:3342:1: rule__IteratorVarCS__Group_1__0 : rule__IteratorVarCS__Group_1__0__Impl rule__IteratorVarCS__Group_1__1 ;
    public final void rule__IteratorVarCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3346:1: ( rule__IteratorVarCS__Group_1__0__Impl rule__IteratorVarCS__Group_1__1 )
            // InternalMiniOCLCS.g:3347:2: rule__IteratorVarCS__Group_1__0__Impl rule__IteratorVarCS__Group_1__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:3354:1: rule__IteratorVarCS__Group_1__0__Impl : ( ':' ) ;
    public final void rule__IteratorVarCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3358:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:3359:1: ( ':' )
            {
            // InternalMiniOCLCS.g:3359:1: ( ':' )
            // InternalMiniOCLCS.g:3360:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getColonKeyword_1_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3369:1: rule__IteratorVarCS__Group_1__1 : rule__IteratorVarCS__Group_1__1__Impl ;
    public final void rule__IteratorVarCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3373:1: ( rule__IteratorVarCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:3374:2: rule__IteratorVarCS__Group_1__1__Impl
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
    // InternalMiniOCLCS.g:3380:1: rule__IteratorVarCS__Group_1__1__Impl : ( ( rule__IteratorVarCS__ItTypeAssignment_1_1 ) ) ;
    public final void rule__IteratorVarCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3384:1: ( ( ( rule__IteratorVarCS__ItTypeAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:3385:1: ( ( rule__IteratorVarCS__ItTypeAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:3385:1: ( ( rule__IteratorVarCS__ItTypeAssignment_1_1 ) )
            // InternalMiniOCLCS.g:3386:2: ( rule__IteratorVarCS__ItTypeAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIteratorVarCSAccess().getItTypeAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:3387:2: ( rule__IteratorVarCS__ItTypeAssignment_1_1 )
            // InternalMiniOCLCS.g:3387:3: rule__IteratorVarCS__ItTypeAssignment_1_1
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
    // InternalMiniOCLCS.g:3396:1: rule__IterateExpCS__Group__0 : rule__IterateExpCS__Group__0__Impl rule__IterateExpCS__Group__1 ;
    public final void rule__IterateExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3400:1: ( rule__IterateExpCS__Group__0__Impl rule__IterateExpCS__Group__1 )
            // InternalMiniOCLCS.g:3401:2: rule__IterateExpCS__Group__0__Impl rule__IterateExpCS__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalMiniOCLCS.g:3408:1: rule__IterateExpCS__Group__0__Impl : ( 'iterate' ) ;
    public final void rule__IterateExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3412:1: ( ( 'iterate' ) )
            // InternalMiniOCLCS.g:3413:1: ( 'iterate' )
            {
            // InternalMiniOCLCS.g:3413:1: ( 'iterate' )
            // InternalMiniOCLCS.g:3414:2: 'iterate'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getIterateKeyword_0()); 
            }
            match(input,38,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3423:1: rule__IterateExpCS__Group__1 : rule__IterateExpCS__Group__1__Impl rule__IterateExpCS__Group__2 ;
    public final void rule__IterateExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3427:1: ( rule__IterateExpCS__Group__1__Impl rule__IterateExpCS__Group__2 )
            // InternalMiniOCLCS.g:3428:2: rule__IterateExpCS__Group__1__Impl rule__IterateExpCS__Group__2
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:3435:1: rule__IterateExpCS__Group__1__Impl : ( '(' ) ;
    public final void rule__IterateExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3439:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:3440:1: ( '(' )
            {
            // InternalMiniOCLCS.g:3440:1: ( '(' )
            // InternalMiniOCLCS.g:3441:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3450:1: rule__IterateExpCS__Group__2 : rule__IterateExpCS__Group__2__Impl rule__IterateExpCS__Group__3 ;
    public final void rule__IterateExpCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3454:1: ( rule__IterateExpCS__Group__2__Impl rule__IterateExpCS__Group__3 )
            // InternalMiniOCLCS.g:3455:2: rule__IterateExpCS__Group__2__Impl rule__IterateExpCS__Group__3
            {
            pushFollow(FOLLOW_8);
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
    // InternalMiniOCLCS.g:3462:1: rule__IterateExpCS__Group__2__Impl : ( ( rule__IterateExpCS__ItVarAssignment_2 ) ) ;
    public final void rule__IterateExpCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3466:1: ( ( ( rule__IterateExpCS__ItVarAssignment_2 ) ) )
            // InternalMiniOCLCS.g:3467:1: ( ( rule__IterateExpCS__ItVarAssignment_2 ) )
            {
            // InternalMiniOCLCS.g:3467:1: ( ( rule__IterateExpCS__ItVarAssignment_2 ) )
            // InternalMiniOCLCS.g:3468:2: ( rule__IterateExpCS__ItVarAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getItVarAssignment_2()); 
            }
            // InternalMiniOCLCS.g:3469:2: ( rule__IterateExpCS__ItVarAssignment_2 )
            // InternalMiniOCLCS.g:3469:3: rule__IterateExpCS__ItVarAssignment_2
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
    // InternalMiniOCLCS.g:3477:1: rule__IterateExpCS__Group__3 : rule__IterateExpCS__Group__3__Impl rule__IterateExpCS__Group__4 ;
    public final void rule__IterateExpCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3481:1: ( rule__IterateExpCS__Group__3__Impl rule__IterateExpCS__Group__4 )
            // InternalMiniOCLCS.g:3482:2: rule__IterateExpCS__Group__3__Impl rule__IterateExpCS__Group__4
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:3489:1: rule__IterateExpCS__Group__3__Impl : ( ';' ) ;
    public final void rule__IterateExpCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3493:1: ( ( ';' ) )
            // InternalMiniOCLCS.g:3494:1: ( ';' )
            {
            // InternalMiniOCLCS.g:3494:1: ( ';' )
            // InternalMiniOCLCS.g:3495:2: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getSemicolonKeyword_3()); 
            }
            match(input,18,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3504:1: rule__IterateExpCS__Group__4 : rule__IterateExpCS__Group__4__Impl rule__IterateExpCS__Group__5 ;
    public final void rule__IterateExpCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3508:1: ( rule__IterateExpCS__Group__4__Impl rule__IterateExpCS__Group__5 )
            // InternalMiniOCLCS.g:3509:2: rule__IterateExpCS__Group__4__Impl rule__IterateExpCS__Group__5
            {
            pushFollow(FOLLOW_36);
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
    // InternalMiniOCLCS.g:3516:1: rule__IterateExpCS__Group__4__Impl : ( ( rule__IterateExpCS__AccVarAssignment_4 ) ) ;
    public final void rule__IterateExpCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3520:1: ( ( ( rule__IterateExpCS__AccVarAssignment_4 ) ) )
            // InternalMiniOCLCS.g:3521:1: ( ( rule__IterateExpCS__AccVarAssignment_4 ) )
            {
            // InternalMiniOCLCS.g:3521:1: ( ( rule__IterateExpCS__AccVarAssignment_4 ) )
            // InternalMiniOCLCS.g:3522:2: ( rule__IterateExpCS__AccVarAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getAccVarAssignment_4()); 
            }
            // InternalMiniOCLCS.g:3523:2: ( rule__IterateExpCS__AccVarAssignment_4 )
            // InternalMiniOCLCS.g:3523:3: rule__IterateExpCS__AccVarAssignment_4
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
    // InternalMiniOCLCS.g:3531:1: rule__IterateExpCS__Group__5 : rule__IterateExpCS__Group__5__Impl rule__IterateExpCS__Group__6 ;
    public final void rule__IterateExpCS__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3535:1: ( rule__IterateExpCS__Group__5__Impl rule__IterateExpCS__Group__6 )
            // InternalMiniOCLCS.g:3536:2: rule__IterateExpCS__Group__5__Impl rule__IterateExpCS__Group__6
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:3543:1: rule__IterateExpCS__Group__5__Impl : ( '|' ) ;
    public final void rule__IterateExpCS__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3547:1: ( ( '|' ) )
            // InternalMiniOCLCS.g:3548:1: ( '|' )
            {
            // InternalMiniOCLCS.g:3548:1: ( '|' )
            // InternalMiniOCLCS.g:3549:2: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getVerticalLineKeyword_5()); 
            }
            match(input,37,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3558:1: rule__IterateExpCS__Group__6 : rule__IterateExpCS__Group__6__Impl rule__IterateExpCS__Group__7 ;
    public final void rule__IterateExpCS__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3562:1: ( rule__IterateExpCS__Group__6__Impl rule__IterateExpCS__Group__7 )
            // InternalMiniOCLCS.g:3563:2: rule__IterateExpCS__Group__6__Impl rule__IterateExpCS__Group__7
            {
            pushFollow(FOLLOW_35);
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
    // InternalMiniOCLCS.g:3570:1: rule__IterateExpCS__Group__6__Impl : ( ( rule__IterateExpCS__ExpAssignment_6 ) ) ;
    public final void rule__IterateExpCS__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3574:1: ( ( ( rule__IterateExpCS__ExpAssignment_6 ) ) )
            // InternalMiniOCLCS.g:3575:1: ( ( rule__IterateExpCS__ExpAssignment_6 ) )
            {
            // InternalMiniOCLCS.g:3575:1: ( ( rule__IterateExpCS__ExpAssignment_6 ) )
            // InternalMiniOCLCS.g:3576:2: ( rule__IterateExpCS__ExpAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getExpAssignment_6()); 
            }
            // InternalMiniOCLCS.g:3577:2: ( rule__IterateExpCS__ExpAssignment_6 )
            // InternalMiniOCLCS.g:3577:3: rule__IterateExpCS__ExpAssignment_6
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
    // InternalMiniOCLCS.g:3585:1: rule__IterateExpCS__Group__7 : rule__IterateExpCS__Group__7__Impl ;
    public final void rule__IterateExpCS__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3589:1: ( rule__IterateExpCS__Group__7__Impl )
            // InternalMiniOCLCS.g:3590:2: rule__IterateExpCS__Group__7__Impl
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
    // InternalMiniOCLCS.g:3596:1: rule__IterateExpCS__Group__7__Impl : ( ')' ) ;
    public final void rule__IterateExpCS__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3600:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:3601:1: ( ')' )
            {
            // InternalMiniOCLCS.g:3601:1: ( ')' )
            // InternalMiniOCLCS.g:3602:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIterateExpCSAccess().getRightParenthesisKeyword_7()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3612:1: rule__AccVarCS__Group__0 : rule__AccVarCS__Group__0__Impl rule__AccVarCS__Group__1 ;
    public final void rule__AccVarCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3616:1: ( rule__AccVarCS__Group__0__Impl rule__AccVarCS__Group__1 )
            // InternalMiniOCLCS.g:3617:2: rule__AccVarCS__Group__0__Impl rule__AccVarCS__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalMiniOCLCS.g:3624:1: rule__AccVarCS__Group__0__Impl : ( ( rule__AccVarCS__AccNameAssignment_0 ) ) ;
    public final void rule__AccVarCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3628:1: ( ( ( rule__AccVarCS__AccNameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:3629:1: ( ( rule__AccVarCS__AccNameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:3629:1: ( ( rule__AccVarCS__AccNameAssignment_0 ) )
            // InternalMiniOCLCS.g:3630:2: ( rule__AccVarCS__AccNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getAccNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:3631:2: ( rule__AccVarCS__AccNameAssignment_0 )
            // InternalMiniOCLCS.g:3631:3: rule__AccVarCS__AccNameAssignment_0
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
    // InternalMiniOCLCS.g:3639:1: rule__AccVarCS__Group__1 : rule__AccVarCS__Group__1__Impl rule__AccVarCS__Group__2 ;
    public final void rule__AccVarCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3643:1: ( rule__AccVarCS__Group__1__Impl rule__AccVarCS__Group__2 )
            // InternalMiniOCLCS.g:3644:2: rule__AccVarCS__Group__1__Impl rule__AccVarCS__Group__2
            {
            pushFollow(FOLLOW_37);
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
    // InternalMiniOCLCS.g:3651:1: rule__AccVarCS__Group__1__Impl : ( ( rule__AccVarCS__Group_1__0 )? ) ;
    public final void rule__AccVarCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3655:1: ( ( ( rule__AccVarCS__Group_1__0 )? ) )
            // InternalMiniOCLCS.g:3656:1: ( ( rule__AccVarCS__Group_1__0 )? )
            {
            // InternalMiniOCLCS.g:3656:1: ( ( rule__AccVarCS__Group_1__0 )? )
            // InternalMiniOCLCS.g:3657:2: ( rule__AccVarCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:3658:2: ( rule__AccVarCS__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==19) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMiniOCLCS.g:3658:3: rule__AccVarCS__Group_1__0
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
    // InternalMiniOCLCS.g:3666:1: rule__AccVarCS__Group__2 : rule__AccVarCS__Group__2__Impl rule__AccVarCS__Group__3 ;
    public final void rule__AccVarCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3670:1: ( rule__AccVarCS__Group__2__Impl rule__AccVarCS__Group__3 )
            // InternalMiniOCLCS.g:3671:2: rule__AccVarCS__Group__2__Impl rule__AccVarCS__Group__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:3678:1: rule__AccVarCS__Group__2__Impl : ( '=' ) ;
    public final void rule__AccVarCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3682:1: ( ( '=' ) )
            // InternalMiniOCLCS.g:3683:1: ( '=' )
            {
            // InternalMiniOCLCS.g:3683:1: ( '=' )
            // InternalMiniOCLCS.g:3684:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getEqualsSignKeyword_2()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3693:1: rule__AccVarCS__Group__3 : rule__AccVarCS__Group__3__Impl ;
    public final void rule__AccVarCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3697:1: ( rule__AccVarCS__Group__3__Impl )
            // InternalMiniOCLCS.g:3698:2: rule__AccVarCS__Group__3__Impl
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
    // InternalMiniOCLCS.g:3704:1: rule__AccVarCS__Group__3__Impl : ( ( rule__AccVarCS__AccInitExpAssignment_3 ) ) ;
    public final void rule__AccVarCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3708:1: ( ( ( rule__AccVarCS__AccInitExpAssignment_3 ) ) )
            // InternalMiniOCLCS.g:3709:1: ( ( rule__AccVarCS__AccInitExpAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:3709:1: ( ( rule__AccVarCS__AccInitExpAssignment_3 ) )
            // InternalMiniOCLCS.g:3710:2: ( rule__AccVarCS__AccInitExpAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getAccInitExpAssignment_3()); 
            }
            // InternalMiniOCLCS.g:3711:2: ( rule__AccVarCS__AccInitExpAssignment_3 )
            // InternalMiniOCLCS.g:3711:3: rule__AccVarCS__AccInitExpAssignment_3
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
    // InternalMiniOCLCS.g:3720:1: rule__AccVarCS__Group_1__0 : rule__AccVarCS__Group_1__0__Impl rule__AccVarCS__Group_1__1 ;
    public final void rule__AccVarCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3724:1: ( rule__AccVarCS__Group_1__0__Impl rule__AccVarCS__Group_1__1 )
            // InternalMiniOCLCS.g:3725:2: rule__AccVarCS__Group_1__0__Impl rule__AccVarCS__Group_1__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:3732:1: rule__AccVarCS__Group_1__0__Impl : ( ':' ) ;
    public final void rule__AccVarCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3736:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:3737:1: ( ':' )
            {
            // InternalMiniOCLCS.g:3737:1: ( ':' )
            // InternalMiniOCLCS.g:3738:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getColonKeyword_1_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3747:1: rule__AccVarCS__Group_1__1 : rule__AccVarCS__Group_1__1__Impl ;
    public final void rule__AccVarCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3751:1: ( rule__AccVarCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:3752:2: rule__AccVarCS__Group_1__1__Impl
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
    // InternalMiniOCLCS.g:3758:1: rule__AccVarCS__Group_1__1__Impl : ( ( rule__AccVarCS__AccTypeAssignment_1_1 ) ) ;
    public final void rule__AccVarCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3762:1: ( ( ( rule__AccVarCS__AccTypeAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:3763:1: ( ( rule__AccVarCS__AccTypeAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:3763:1: ( ( rule__AccVarCS__AccTypeAssignment_1_1 ) )
            // InternalMiniOCLCS.g:3764:2: ( rule__AccVarCS__AccTypeAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAccVarCSAccess().getAccTypeAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:3765:2: ( rule__AccVarCS__AccTypeAssignment_1_1 )
            // InternalMiniOCLCS.g:3765:3: rule__AccVarCS__AccTypeAssignment_1_1
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
    // InternalMiniOCLCS.g:3774:1: rule__NameExpCS__Group__0 : rule__NameExpCS__Group__0__Impl rule__NameExpCS__Group__1 ;
    public final void rule__NameExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3778:1: ( rule__NameExpCS__Group__0__Impl rule__NameExpCS__Group__1 )
            // InternalMiniOCLCS.g:3779:2: rule__NameExpCS__Group__0__Impl rule__NameExpCS__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalMiniOCLCS.g:3786:1: rule__NameExpCS__Group__0__Impl : ( ( rule__NameExpCS__ExpNameAssignment_0 ) ) ;
    public final void rule__NameExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3790:1: ( ( ( rule__NameExpCS__ExpNameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:3791:1: ( ( rule__NameExpCS__ExpNameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:3791:1: ( ( rule__NameExpCS__ExpNameAssignment_0 ) )
            // InternalMiniOCLCS.g:3792:2: ( rule__NameExpCS__ExpNameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getExpNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:3793:2: ( rule__NameExpCS__ExpNameAssignment_0 )
            // InternalMiniOCLCS.g:3793:3: rule__NameExpCS__ExpNameAssignment_0
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
    // InternalMiniOCLCS.g:3801:1: rule__NameExpCS__Group__1 : rule__NameExpCS__Group__1__Impl ;
    public final void rule__NameExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3805:1: ( rule__NameExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:3806:2: rule__NameExpCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:3812:1: rule__NameExpCS__Group__1__Impl : ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? ) ;
    public final void rule__NameExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3816:1: ( ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? ) )
            // InternalMiniOCLCS.g:3817:1: ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? )
            {
            // InternalMiniOCLCS.g:3817:1: ( ( rule__NameExpCS__RoundedBracketsAssignment_1 )? )
            // InternalMiniOCLCS.g:3818:2: ( rule__NameExpCS__RoundedBracketsAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNameExpCSAccess().getRoundedBracketsAssignment_1()); 
            }
            // InternalMiniOCLCS.g:3819:2: ( rule__NameExpCS__RoundedBracketsAssignment_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==30) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMiniOCLCS.g:3819:3: rule__NameExpCS__RoundedBracketsAssignment_1
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
    // InternalMiniOCLCS.g:3828:1: rule__RoundedBracketClauseCS__Group__0 : rule__RoundedBracketClauseCS__Group__0__Impl rule__RoundedBracketClauseCS__Group__1 ;
    public final void rule__RoundedBracketClauseCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3832:1: ( rule__RoundedBracketClauseCS__Group__0__Impl rule__RoundedBracketClauseCS__Group__1 )
            // InternalMiniOCLCS.g:3833:2: rule__RoundedBracketClauseCS__Group__0__Impl rule__RoundedBracketClauseCS__Group__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalMiniOCLCS.g:3840:1: rule__RoundedBracketClauseCS__Group__0__Impl : ( () ) ;
    public final void rule__RoundedBracketClauseCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3844:1: ( ( () ) )
            // InternalMiniOCLCS.g:3845:1: ( () )
            {
            // InternalMiniOCLCS.g:3845:1: ( () )
            // InternalMiniOCLCS.g:3846:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getRoundedBracketClauseCSAction_0()); 
            }
            // InternalMiniOCLCS.g:3847:2: ()
            // InternalMiniOCLCS.g:3847:3: 
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
    // InternalMiniOCLCS.g:3855:1: rule__RoundedBracketClauseCS__Group__1 : rule__RoundedBracketClauseCS__Group__1__Impl rule__RoundedBracketClauseCS__Group__2 ;
    public final void rule__RoundedBracketClauseCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3859:1: ( rule__RoundedBracketClauseCS__Group__1__Impl rule__RoundedBracketClauseCS__Group__2 )
            // InternalMiniOCLCS.g:3860:2: rule__RoundedBracketClauseCS__Group__1__Impl rule__RoundedBracketClauseCS__Group__2
            {
            pushFollow(FOLLOW_38);
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
    // InternalMiniOCLCS.g:3867:1: rule__RoundedBracketClauseCS__Group__1__Impl : ( '(' ) ;
    public final void rule__RoundedBracketClauseCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3871:1: ( ( '(' ) )
            // InternalMiniOCLCS.g:3872:1: ( '(' )
            {
            // InternalMiniOCLCS.g:3872:1: ( '(' )
            // InternalMiniOCLCS.g:3873:2: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,30,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3882:1: rule__RoundedBracketClauseCS__Group__2 : rule__RoundedBracketClauseCS__Group__2__Impl rule__RoundedBracketClauseCS__Group__3 ;
    public final void rule__RoundedBracketClauseCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3886:1: ( rule__RoundedBracketClauseCS__Group__2__Impl rule__RoundedBracketClauseCS__Group__3 )
            // InternalMiniOCLCS.g:3887:2: rule__RoundedBracketClauseCS__Group__2__Impl rule__RoundedBracketClauseCS__Group__3
            {
            pushFollow(FOLLOW_38);
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
    // InternalMiniOCLCS.g:3894:1: rule__RoundedBracketClauseCS__Group__2__Impl : ( ( rule__RoundedBracketClauseCS__Group_2__0 )? ) ;
    public final void rule__RoundedBracketClauseCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3898:1: ( ( ( rule__RoundedBracketClauseCS__Group_2__0 )? ) )
            // InternalMiniOCLCS.g:3899:1: ( ( rule__RoundedBracketClauseCS__Group_2__0 )? )
            {
            // InternalMiniOCLCS.g:3899:1: ( ( rule__RoundedBracketClauseCS__Group_2__0 )? )
            // InternalMiniOCLCS.g:3900:2: ( rule__RoundedBracketClauseCS__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:3901:2: ( rule__RoundedBracketClauseCS__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID||LA28_0==RULE_INT||LA28_0==11||LA28_0==16||LA28_0==35||(LA28_0>=39 && LA28_0<=40)||LA28_0==45) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMiniOCLCS.g:3901:3: rule__RoundedBracketClauseCS__Group_2__0
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
    // InternalMiniOCLCS.g:3909:1: rule__RoundedBracketClauseCS__Group__3 : rule__RoundedBracketClauseCS__Group__3__Impl ;
    public final void rule__RoundedBracketClauseCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3913:1: ( rule__RoundedBracketClauseCS__Group__3__Impl )
            // InternalMiniOCLCS.g:3914:2: rule__RoundedBracketClauseCS__Group__3__Impl
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
    // InternalMiniOCLCS.g:3920:1: rule__RoundedBracketClauseCS__Group__3__Impl : ( ')' ) ;
    public final void rule__RoundedBracketClauseCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3924:1: ( ( ')' ) )
            // InternalMiniOCLCS.g:3925:1: ( ')' )
            {
            // InternalMiniOCLCS.g:3925:1: ( ')' )
            // InternalMiniOCLCS.g:3926:2: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,31,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:3936:1: rule__RoundedBracketClauseCS__Group_2__0 : rule__RoundedBracketClauseCS__Group_2__0__Impl rule__RoundedBracketClauseCS__Group_2__1 ;
    public final void rule__RoundedBracketClauseCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3940:1: ( rule__RoundedBracketClauseCS__Group_2__0__Impl rule__RoundedBracketClauseCS__Group_2__1 )
            // InternalMiniOCLCS.g:3941:2: rule__RoundedBracketClauseCS__Group_2__0__Impl rule__RoundedBracketClauseCS__Group_2__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalMiniOCLCS.g:3948:1: rule__RoundedBracketClauseCS__Group_2__0__Impl : ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) ) ;
    public final void rule__RoundedBracketClauseCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3952:1: ( ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) ) )
            // InternalMiniOCLCS.g:3953:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) )
            {
            // InternalMiniOCLCS.g:3953:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 ) )
            // InternalMiniOCLCS.g:3954:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getArgsAssignment_2_0()); 
            }
            // InternalMiniOCLCS.g:3955:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_0 )
            // InternalMiniOCLCS.g:3955:3: rule__RoundedBracketClauseCS__ArgsAssignment_2_0
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
    // InternalMiniOCLCS.g:3963:1: rule__RoundedBracketClauseCS__Group_2__1 : rule__RoundedBracketClauseCS__Group_2__1__Impl ;
    public final void rule__RoundedBracketClauseCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3967:1: ( rule__RoundedBracketClauseCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:3968:2: rule__RoundedBracketClauseCS__Group_2__1__Impl
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
    // InternalMiniOCLCS.g:3974:1: rule__RoundedBracketClauseCS__Group_2__1__Impl : ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* ) ;
    public final void rule__RoundedBracketClauseCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3978:1: ( ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* ) )
            // InternalMiniOCLCS.g:3979:1: ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* )
            {
            // InternalMiniOCLCS.g:3979:1: ( ( rule__RoundedBracketClauseCS__Group_2_1__0 )* )
            // InternalMiniOCLCS.g:3980:2: ( rule__RoundedBracketClauseCS__Group_2_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getGroup_2_1()); 
            }
            // InternalMiniOCLCS.g:3981:2: ( rule__RoundedBracketClauseCS__Group_2_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==32) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalMiniOCLCS.g:3981:3: rule__RoundedBracketClauseCS__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__RoundedBracketClauseCS__Group_2_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalMiniOCLCS.g:3990:1: rule__RoundedBracketClauseCS__Group_2_1__0 : rule__RoundedBracketClauseCS__Group_2_1__0__Impl rule__RoundedBracketClauseCS__Group_2_1__1 ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:3994:1: ( rule__RoundedBracketClauseCS__Group_2_1__0__Impl rule__RoundedBracketClauseCS__Group_2_1__1 )
            // InternalMiniOCLCS.g:3995:2: rule__RoundedBracketClauseCS__Group_2_1__0__Impl rule__RoundedBracketClauseCS__Group_2_1__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:4002:1: rule__RoundedBracketClauseCS__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4006:1: ( ( ',' ) )
            // InternalMiniOCLCS.g:4007:1: ( ',' )
            {
            // InternalMiniOCLCS.g:4007:1: ( ',' )
            // InternalMiniOCLCS.g:4008:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getCommaKeyword_2_1_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4017:1: rule__RoundedBracketClauseCS__Group_2_1__1 : rule__RoundedBracketClauseCS__Group_2_1__1__Impl ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4021:1: ( rule__RoundedBracketClauseCS__Group_2_1__1__Impl )
            // InternalMiniOCLCS.g:4022:2: rule__RoundedBracketClauseCS__Group_2_1__1__Impl
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
    // InternalMiniOCLCS.g:4028:1: rule__RoundedBracketClauseCS__Group_2_1__1__Impl : ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) ) ;
    public final void rule__RoundedBracketClauseCS__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4032:1: ( ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) ) )
            // InternalMiniOCLCS.g:4033:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) )
            {
            // InternalMiniOCLCS.g:4033:1: ( ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 ) )
            // InternalMiniOCLCS.g:4034:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRoundedBracketClauseCSAccess().getArgsAssignment_2_1_1()); 
            }
            // InternalMiniOCLCS.g:4035:2: ( rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 )
            // InternalMiniOCLCS.g:4035:3: rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1
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
    // InternalMiniOCLCS.g:4044:1: rule__BooleanLiteralExpCS__Group__0 : rule__BooleanLiteralExpCS__Group__0__Impl rule__BooleanLiteralExpCS__Group__1 ;
    public final void rule__BooleanLiteralExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4048:1: ( rule__BooleanLiteralExpCS__Group__0__Impl rule__BooleanLiteralExpCS__Group__1 )
            // InternalMiniOCLCS.g:4049:2: rule__BooleanLiteralExpCS__Group__0__Impl rule__BooleanLiteralExpCS__Group__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalMiniOCLCS.g:4056:1: rule__BooleanLiteralExpCS__Group__0__Impl : ( () ) ;
    public final void rule__BooleanLiteralExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4060:1: ( ( () ) )
            // InternalMiniOCLCS.g:4061:1: ( () )
            {
            // InternalMiniOCLCS.g:4061:1: ( () )
            // InternalMiniOCLCS.g:4062:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getBooleanExpCSAction_0()); 
            }
            // InternalMiniOCLCS.g:4063:2: ()
            // InternalMiniOCLCS.g:4063:3: 
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
    // InternalMiniOCLCS.g:4071:1: rule__BooleanLiteralExpCS__Group__1 : rule__BooleanLiteralExpCS__Group__1__Impl ;
    public final void rule__BooleanLiteralExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4075:1: ( rule__BooleanLiteralExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:4076:2: rule__BooleanLiteralExpCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:4082:1: rule__BooleanLiteralExpCS__Group__1__Impl : ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) ) ;
    public final void rule__BooleanLiteralExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4086:1: ( ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) ) )
            // InternalMiniOCLCS.g:4087:1: ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) )
            {
            // InternalMiniOCLCS.g:4087:1: ( ( rule__BooleanLiteralExpCS__Alternatives_1 ) )
            // InternalMiniOCLCS.g:4088:2: ( rule__BooleanLiteralExpCS__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getAlternatives_1()); 
            }
            // InternalMiniOCLCS.g:4089:2: ( rule__BooleanLiteralExpCS__Alternatives_1 )
            // InternalMiniOCLCS.g:4089:3: rule__BooleanLiteralExpCS__Alternatives_1
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
    // InternalMiniOCLCS.g:4098:1: rule__NullLiteralExpCS__Group__0 : rule__NullLiteralExpCS__Group__0__Impl rule__NullLiteralExpCS__Group__1 ;
    public final void rule__NullLiteralExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4102:1: ( rule__NullLiteralExpCS__Group__0__Impl rule__NullLiteralExpCS__Group__1 )
            // InternalMiniOCLCS.g:4103:2: rule__NullLiteralExpCS__Group__0__Impl rule__NullLiteralExpCS__Group__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalMiniOCLCS.g:4110:1: rule__NullLiteralExpCS__Group__0__Impl : ( () ) ;
    public final void rule__NullLiteralExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4114:1: ( ( () ) )
            // InternalMiniOCLCS.g:4115:1: ( () )
            {
            // InternalMiniOCLCS.g:4115:1: ( () )
            // InternalMiniOCLCS.g:4116:2: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0()); 
            }
            // InternalMiniOCLCS.g:4117:2: ()
            // InternalMiniOCLCS.g:4117:3: 
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
    // InternalMiniOCLCS.g:4125:1: rule__NullLiteralExpCS__Group__1 : rule__NullLiteralExpCS__Group__1__Impl ;
    public final void rule__NullLiteralExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4129:1: ( rule__NullLiteralExpCS__Group__1__Impl )
            // InternalMiniOCLCS.g:4130:2: rule__NullLiteralExpCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:4136:1: rule__NullLiteralExpCS__Group__1__Impl : ( 'null' ) ;
    public final void rule__NullLiteralExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4140:1: ( ( 'null' ) )
            // InternalMiniOCLCS.g:4141:1: ( 'null' )
            {
            // InternalMiniOCLCS.g:4141:1: ( 'null' )
            // InternalMiniOCLCS.g:4142:2: 'null'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1()); 
            }
            match(input,39,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4152:1: rule__CollectionLiteralExpCS__Group__0 : rule__CollectionLiteralExpCS__Group__0__Impl rule__CollectionLiteralExpCS__Group__1 ;
    public final void rule__CollectionLiteralExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4156:1: ( rule__CollectionLiteralExpCS__Group__0__Impl rule__CollectionLiteralExpCS__Group__1 )
            // InternalMiniOCLCS.g:4157:2: rule__CollectionLiteralExpCS__Group__0__Impl rule__CollectionLiteralExpCS__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalMiniOCLCS.g:4164:1: rule__CollectionLiteralExpCS__Group__0__Impl : ( ( rule__CollectionLiteralExpCS__KindAssignment_0 ) ) ;
    public final void rule__CollectionLiteralExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4168:1: ( ( ( rule__CollectionLiteralExpCS__KindAssignment_0 ) ) )
            // InternalMiniOCLCS.g:4169:1: ( ( rule__CollectionLiteralExpCS__KindAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:4169:1: ( ( rule__CollectionLiteralExpCS__KindAssignment_0 ) )
            // InternalMiniOCLCS.g:4170:2: ( rule__CollectionLiteralExpCS__KindAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getKindAssignment_0()); 
            }
            // InternalMiniOCLCS.g:4171:2: ( rule__CollectionLiteralExpCS__KindAssignment_0 )
            // InternalMiniOCLCS.g:4171:3: rule__CollectionLiteralExpCS__KindAssignment_0
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
    // InternalMiniOCLCS.g:4179:1: rule__CollectionLiteralExpCS__Group__1 : rule__CollectionLiteralExpCS__Group__1__Impl rule__CollectionLiteralExpCS__Group__2 ;
    public final void rule__CollectionLiteralExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4183:1: ( rule__CollectionLiteralExpCS__Group__1__Impl rule__CollectionLiteralExpCS__Group__2 )
            // InternalMiniOCLCS.g:4184:2: rule__CollectionLiteralExpCS__Group__1__Impl rule__CollectionLiteralExpCS__Group__2
            {
            pushFollow(FOLLOW_41);
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
    // InternalMiniOCLCS.g:4191:1: rule__CollectionLiteralExpCS__Group__1__Impl : ( '{' ) ;
    public final void rule__CollectionLiteralExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4195:1: ( ( '{' ) )
            // InternalMiniOCLCS.g:4196:1: ( '{' )
            {
            // InternalMiniOCLCS.g:4196:1: ( '{' )
            // InternalMiniOCLCS.g:4197:2: '{'
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
    // InternalMiniOCLCS.g:4206:1: rule__CollectionLiteralExpCS__Group__2 : rule__CollectionLiteralExpCS__Group__2__Impl rule__CollectionLiteralExpCS__Group__3 ;
    public final void rule__CollectionLiteralExpCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4210:1: ( rule__CollectionLiteralExpCS__Group__2__Impl rule__CollectionLiteralExpCS__Group__3 )
            // InternalMiniOCLCS.g:4211:2: rule__CollectionLiteralExpCS__Group__2__Impl rule__CollectionLiteralExpCS__Group__3
            {
            pushFollow(FOLLOW_41);
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
    // InternalMiniOCLCS.g:4218:1: rule__CollectionLiteralExpCS__Group__2__Impl : ( ( rule__CollectionLiteralExpCS__PartsAssignment_2 )* ) ;
    public final void rule__CollectionLiteralExpCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4222:1: ( ( ( rule__CollectionLiteralExpCS__PartsAssignment_2 )* ) )
            // InternalMiniOCLCS.g:4223:1: ( ( rule__CollectionLiteralExpCS__PartsAssignment_2 )* )
            {
            // InternalMiniOCLCS.g:4223:1: ( ( rule__CollectionLiteralExpCS__PartsAssignment_2 )* )
            // InternalMiniOCLCS.g:4224:2: ( rule__CollectionLiteralExpCS__PartsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralExpCSAccess().getPartsAssignment_2()); 
            }
            // InternalMiniOCLCS.g:4225:2: ( rule__CollectionLiteralExpCS__PartsAssignment_2 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID||LA30_0==RULE_INT||LA30_0==11||LA30_0==16||LA30_0==35||(LA30_0>=39 && LA30_0<=40)||LA30_0==45) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalMiniOCLCS.g:4225:3: rule__CollectionLiteralExpCS__PartsAssignment_2
            	    {
            	    pushFollow(FOLLOW_42);
            	    rule__CollectionLiteralExpCS__PartsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalMiniOCLCS.g:4233:1: rule__CollectionLiteralExpCS__Group__3 : rule__CollectionLiteralExpCS__Group__3__Impl ;
    public final void rule__CollectionLiteralExpCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4237:1: ( rule__CollectionLiteralExpCS__Group__3__Impl )
            // InternalMiniOCLCS.g:4238:2: rule__CollectionLiteralExpCS__Group__3__Impl
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
    // InternalMiniOCLCS.g:4244:1: rule__CollectionLiteralExpCS__Group__3__Impl : ( '}' ) ;
    public final void rule__CollectionLiteralExpCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4248:1: ( ( '}' ) )
            // InternalMiniOCLCS.g:4249:1: ( '}' )
            {
            // InternalMiniOCLCS.g:4249:1: ( '}' )
            // InternalMiniOCLCS.g:4250:2: '}'
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
    // InternalMiniOCLCS.g:4260:1: rule__CollectionLiteralPartCS__Group__0 : rule__CollectionLiteralPartCS__Group__0__Impl rule__CollectionLiteralPartCS__Group__1 ;
    public final void rule__CollectionLiteralPartCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4264:1: ( rule__CollectionLiteralPartCS__Group__0__Impl rule__CollectionLiteralPartCS__Group__1 )
            // InternalMiniOCLCS.g:4265:2: rule__CollectionLiteralPartCS__Group__0__Impl rule__CollectionLiteralPartCS__Group__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalMiniOCLCS.g:4272:1: rule__CollectionLiteralPartCS__Group__0__Impl : ( ( rule__CollectionLiteralPartCS__FirstAssignment_0 ) ) ;
    public final void rule__CollectionLiteralPartCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4276:1: ( ( ( rule__CollectionLiteralPartCS__FirstAssignment_0 ) ) )
            // InternalMiniOCLCS.g:4277:1: ( ( rule__CollectionLiteralPartCS__FirstAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:4277:1: ( ( rule__CollectionLiteralPartCS__FirstAssignment_0 ) )
            // InternalMiniOCLCS.g:4278:2: ( rule__CollectionLiteralPartCS__FirstAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getFirstAssignment_0()); 
            }
            // InternalMiniOCLCS.g:4279:2: ( rule__CollectionLiteralPartCS__FirstAssignment_0 )
            // InternalMiniOCLCS.g:4279:3: rule__CollectionLiteralPartCS__FirstAssignment_0
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
    // InternalMiniOCLCS.g:4287:1: rule__CollectionLiteralPartCS__Group__1 : rule__CollectionLiteralPartCS__Group__1__Impl ;
    public final void rule__CollectionLiteralPartCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4291:1: ( rule__CollectionLiteralPartCS__Group__1__Impl )
            // InternalMiniOCLCS.g:4292:2: rule__CollectionLiteralPartCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:4298:1: rule__CollectionLiteralPartCS__Group__1__Impl : ( ( rule__CollectionLiteralPartCS__Group_1__0 )? ) ;
    public final void rule__CollectionLiteralPartCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4302:1: ( ( ( rule__CollectionLiteralPartCS__Group_1__0 )? ) )
            // InternalMiniOCLCS.g:4303:1: ( ( rule__CollectionLiteralPartCS__Group_1__0 )? )
            {
            // InternalMiniOCLCS.g:4303:1: ( ( rule__CollectionLiteralPartCS__Group_1__0 )? )
            // InternalMiniOCLCS.g:4304:2: ( rule__CollectionLiteralPartCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:4305:2: ( rule__CollectionLiteralPartCS__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==28) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMiniOCLCS.g:4305:3: rule__CollectionLiteralPartCS__Group_1__0
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
    // InternalMiniOCLCS.g:4314:1: rule__CollectionLiteralPartCS__Group_1__0 : rule__CollectionLiteralPartCS__Group_1__0__Impl rule__CollectionLiteralPartCS__Group_1__1 ;
    public final void rule__CollectionLiteralPartCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4318:1: ( rule__CollectionLiteralPartCS__Group_1__0__Impl rule__CollectionLiteralPartCS__Group_1__1 )
            // InternalMiniOCLCS.g:4319:2: rule__CollectionLiteralPartCS__Group_1__0__Impl rule__CollectionLiteralPartCS__Group_1__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:4326:1: rule__CollectionLiteralPartCS__Group_1__0__Impl : ( '..' ) ;
    public final void rule__CollectionLiteralPartCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4330:1: ( ( '..' ) )
            // InternalMiniOCLCS.g:4331:1: ( '..' )
            {
            // InternalMiniOCLCS.g:4331:1: ( '..' )
            // InternalMiniOCLCS.g:4332:2: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0()); 
            }
            match(input,28,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4341:1: rule__CollectionLiteralPartCS__Group_1__1 : rule__CollectionLiteralPartCS__Group_1__1__Impl ;
    public final void rule__CollectionLiteralPartCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4345:1: ( rule__CollectionLiteralPartCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:4346:2: rule__CollectionLiteralPartCS__Group_1__1__Impl
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
    // InternalMiniOCLCS.g:4352:1: rule__CollectionLiteralPartCS__Group_1__1__Impl : ( ( rule__CollectionLiteralPartCS__LastAssignment_1_1 ) ) ;
    public final void rule__CollectionLiteralPartCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4356:1: ( ( ( rule__CollectionLiteralPartCS__LastAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:4357:1: ( ( rule__CollectionLiteralPartCS__LastAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:4357:1: ( ( rule__CollectionLiteralPartCS__LastAssignment_1_1 ) )
            // InternalMiniOCLCS.g:4358:2: ( rule__CollectionLiteralPartCS__LastAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionLiteralPartCSAccess().getLastAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:4359:2: ( rule__CollectionLiteralPartCS__LastAssignment_1_1 )
            // InternalMiniOCLCS.g:4359:3: rule__CollectionLiteralPartCS__LastAssignment_1_1
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
    // InternalMiniOCLCS.g:4368:1: rule__LetExpCS__Group__0 : rule__LetExpCS__Group__0__Impl rule__LetExpCS__Group__1 ;
    public final void rule__LetExpCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4372:1: ( rule__LetExpCS__Group__0__Impl rule__LetExpCS__Group__1 )
            // InternalMiniOCLCS.g:4373:2: rule__LetExpCS__Group__0__Impl rule__LetExpCS__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:4380:1: rule__LetExpCS__Group__0__Impl : ( 'let' ) ;
    public final void rule__LetExpCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4384:1: ( ( 'let' ) )
            // InternalMiniOCLCS.g:4385:1: ( 'let' )
            {
            // InternalMiniOCLCS.g:4385:1: ( 'let' )
            // InternalMiniOCLCS.g:4386:2: 'let'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getLetKeyword_0()); 
            }
            match(input,40,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4395:1: rule__LetExpCS__Group__1 : rule__LetExpCS__Group__1__Impl rule__LetExpCS__Group__2 ;
    public final void rule__LetExpCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4399:1: ( rule__LetExpCS__Group__1__Impl rule__LetExpCS__Group__2 )
            // InternalMiniOCLCS.g:4400:2: rule__LetExpCS__Group__1__Impl rule__LetExpCS__Group__2
            {
            pushFollow(FOLLOW_43);
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
    // InternalMiniOCLCS.g:4407:1: rule__LetExpCS__Group__1__Impl : ( ( rule__LetExpCS__LetVarsAssignment_1 ) ) ;
    public final void rule__LetExpCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4411:1: ( ( ( rule__LetExpCS__LetVarsAssignment_1 ) ) )
            // InternalMiniOCLCS.g:4412:1: ( ( rule__LetExpCS__LetVarsAssignment_1 ) )
            {
            // InternalMiniOCLCS.g:4412:1: ( ( rule__LetExpCS__LetVarsAssignment_1 ) )
            // InternalMiniOCLCS.g:4413:2: ( rule__LetExpCS__LetVarsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getLetVarsAssignment_1()); 
            }
            // InternalMiniOCLCS.g:4414:2: ( rule__LetExpCS__LetVarsAssignment_1 )
            // InternalMiniOCLCS.g:4414:3: rule__LetExpCS__LetVarsAssignment_1
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
    // InternalMiniOCLCS.g:4422:1: rule__LetExpCS__Group__2 : rule__LetExpCS__Group__2__Impl rule__LetExpCS__Group__3 ;
    public final void rule__LetExpCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4426:1: ( rule__LetExpCS__Group__2__Impl rule__LetExpCS__Group__3 )
            // InternalMiniOCLCS.g:4427:2: rule__LetExpCS__Group__2__Impl rule__LetExpCS__Group__3
            {
            pushFollow(FOLLOW_43);
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
    // InternalMiniOCLCS.g:4434:1: rule__LetExpCS__Group__2__Impl : ( ( rule__LetExpCS__Group_2__0 )* ) ;
    public final void rule__LetExpCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4438:1: ( ( ( rule__LetExpCS__Group_2__0 )* ) )
            // InternalMiniOCLCS.g:4439:1: ( ( rule__LetExpCS__Group_2__0 )* )
            {
            // InternalMiniOCLCS.g:4439:1: ( ( rule__LetExpCS__Group_2__0 )* )
            // InternalMiniOCLCS.g:4440:2: ( rule__LetExpCS__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getGroup_2()); 
            }
            // InternalMiniOCLCS.g:4441:2: ( rule__LetExpCS__Group_2__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==32) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalMiniOCLCS.g:4441:3: rule__LetExpCS__Group_2__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__LetExpCS__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalMiniOCLCS.g:4449:1: rule__LetExpCS__Group__3 : rule__LetExpCS__Group__3__Impl rule__LetExpCS__Group__4 ;
    public final void rule__LetExpCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4453:1: ( rule__LetExpCS__Group__3__Impl rule__LetExpCS__Group__4 )
            // InternalMiniOCLCS.g:4454:2: rule__LetExpCS__Group__3__Impl rule__LetExpCS__Group__4
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:4461:1: rule__LetExpCS__Group__3__Impl : ( 'in' ) ;
    public final void rule__LetExpCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4465:1: ( ( 'in' ) )
            // InternalMiniOCLCS.g:4466:1: ( 'in' )
            {
            // InternalMiniOCLCS.g:4466:1: ( 'in' )
            // InternalMiniOCLCS.g:4467:2: 'in'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getInKeyword_3()); 
            }
            match(input,41,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4476:1: rule__LetExpCS__Group__4 : rule__LetExpCS__Group__4__Impl ;
    public final void rule__LetExpCS__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4480:1: ( rule__LetExpCS__Group__4__Impl )
            // InternalMiniOCLCS.g:4481:2: rule__LetExpCS__Group__4__Impl
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
    // InternalMiniOCLCS.g:4487:1: rule__LetExpCS__Group__4__Impl : ( ( rule__LetExpCS__InExpAssignment_4 ) ) ;
    public final void rule__LetExpCS__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4491:1: ( ( ( rule__LetExpCS__InExpAssignment_4 ) ) )
            // InternalMiniOCLCS.g:4492:1: ( ( rule__LetExpCS__InExpAssignment_4 ) )
            {
            // InternalMiniOCLCS.g:4492:1: ( ( rule__LetExpCS__InExpAssignment_4 ) )
            // InternalMiniOCLCS.g:4493:2: ( rule__LetExpCS__InExpAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getInExpAssignment_4()); 
            }
            // InternalMiniOCLCS.g:4494:2: ( rule__LetExpCS__InExpAssignment_4 )
            // InternalMiniOCLCS.g:4494:3: rule__LetExpCS__InExpAssignment_4
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
    // InternalMiniOCLCS.g:4503:1: rule__LetExpCS__Group_2__0 : rule__LetExpCS__Group_2__0__Impl rule__LetExpCS__Group_2__1 ;
    public final void rule__LetExpCS__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4507:1: ( rule__LetExpCS__Group_2__0__Impl rule__LetExpCS__Group_2__1 )
            // InternalMiniOCLCS.g:4508:2: rule__LetExpCS__Group_2__0__Impl rule__LetExpCS__Group_2__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:4515:1: rule__LetExpCS__Group_2__0__Impl : ( ',' ) ;
    public final void rule__LetExpCS__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4519:1: ( ( ',' ) )
            // InternalMiniOCLCS.g:4520:1: ( ',' )
            {
            // InternalMiniOCLCS.g:4520:1: ( ',' )
            // InternalMiniOCLCS.g:4521:2: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0()); 
            }
            match(input,32,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4530:1: rule__LetExpCS__Group_2__1 : rule__LetExpCS__Group_2__1__Impl ;
    public final void rule__LetExpCS__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4534:1: ( rule__LetExpCS__Group_2__1__Impl )
            // InternalMiniOCLCS.g:4535:2: rule__LetExpCS__Group_2__1__Impl
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
    // InternalMiniOCLCS.g:4541:1: rule__LetExpCS__Group_2__1__Impl : ( ( rule__LetExpCS__LetVarsAssignment_2_1 ) ) ;
    public final void rule__LetExpCS__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4545:1: ( ( ( rule__LetExpCS__LetVarsAssignment_2_1 ) ) )
            // InternalMiniOCLCS.g:4546:1: ( ( rule__LetExpCS__LetVarsAssignment_2_1 ) )
            {
            // InternalMiniOCLCS.g:4546:1: ( ( rule__LetExpCS__LetVarsAssignment_2_1 ) )
            // InternalMiniOCLCS.g:4547:2: ( rule__LetExpCS__LetVarsAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetExpCSAccess().getLetVarsAssignment_2_1()); 
            }
            // InternalMiniOCLCS.g:4548:2: ( rule__LetExpCS__LetVarsAssignment_2_1 )
            // InternalMiniOCLCS.g:4548:3: rule__LetExpCS__LetVarsAssignment_2_1
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
    // InternalMiniOCLCS.g:4557:1: rule__LetVarCS__Group__0 : rule__LetVarCS__Group__0__Impl rule__LetVarCS__Group__1 ;
    public final void rule__LetVarCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4561:1: ( rule__LetVarCS__Group__0__Impl rule__LetVarCS__Group__1 )
            // InternalMiniOCLCS.g:4562:2: rule__LetVarCS__Group__0__Impl rule__LetVarCS__Group__1
            {
            pushFollow(FOLLOW_37);
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
    // InternalMiniOCLCS.g:4569:1: rule__LetVarCS__Group__0__Impl : ( ( rule__LetVarCS__NameAssignment_0 ) ) ;
    public final void rule__LetVarCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4573:1: ( ( ( rule__LetVarCS__NameAssignment_0 ) ) )
            // InternalMiniOCLCS.g:4574:1: ( ( rule__LetVarCS__NameAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:4574:1: ( ( rule__LetVarCS__NameAssignment_0 ) )
            // InternalMiniOCLCS.g:4575:2: ( rule__LetVarCS__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getNameAssignment_0()); 
            }
            // InternalMiniOCLCS.g:4576:2: ( rule__LetVarCS__NameAssignment_0 )
            // InternalMiniOCLCS.g:4576:3: rule__LetVarCS__NameAssignment_0
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
    // InternalMiniOCLCS.g:4584:1: rule__LetVarCS__Group__1 : rule__LetVarCS__Group__1__Impl rule__LetVarCS__Group__2 ;
    public final void rule__LetVarCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4588:1: ( rule__LetVarCS__Group__1__Impl rule__LetVarCS__Group__2 )
            // InternalMiniOCLCS.g:4589:2: rule__LetVarCS__Group__1__Impl rule__LetVarCS__Group__2
            {
            pushFollow(FOLLOW_37);
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
    // InternalMiniOCLCS.g:4596:1: rule__LetVarCS__Group__1__Impl : ( ( rule__LetVarCS__Group_1__0 )? ) ;
    public final void rule__LetVarCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4600:1: ( ( ( rule__LetVarCS__Group_1__0 )? ) )
            // InternalMiniOCLCS.g:4601:1: ( ( rule__LetVarCS__Group_1__0 )? )
            {
            // InternalMiniOCLCS.g:4601:1: ( ( rule__LetVarCS__Group_1__0 )? )
            // InternalMiniOCLCS.g:4602:2: ( rule__LetVarCS__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:4603:2: ( rule__LetVarCS__Group_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==19) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMiniOCLCS.g:4603:3: rule__LetVarCS__Group_1__0
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
    // InternalMiniOCLCS.g:4611:1: rule__LetVarCS__Group__2 : rule__LetVarCS__Group__2__Impl rule__LetVarCS__Group__3 ;
    public final void rule__LetVarCS__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4615:1: ( rule__LetVarCS__Group__2__Impl rule__LetVarCS__Group__3 )
            // InternalMiniOCLCS.g:4616:2: rule__LetVarCS__Group__2__Impl rule__LetVarCS__Group__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalMiniOCLCS.g:4623:1: rule__LetVarCS__Group__2__Impl : ( '=' ) ;
    public final void rule__LetVarCS__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4627:1: ( ( '=' ) )
            // InternalMiniOCLCS.g:4628:1: ( '=' )
            {
            // InternalMiniOCLCS.g:4628:1: ( '=' )
            // InternalMiniOCLCS.g:4629:2: '='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getEqualsSignKeyword_2()); 
            }
            match(input,12,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4638:1: rule__LetVarCS__Group__3 : rule__LetVarCS__Group__3__Impl ;
    public final void rule__LetVarCS__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4642:1: ( rule__LetVarCS__Group__3__Impl )
            // InternalMiniOCLCS.g:4643:2: rule__LetVarCS__Group__3__Impl
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
    // InternalMiniOCLCS.g:4649:1: rule__LetVarCS__Group__3__Impl : ( ( rule__LetVarCS__InitExpAssignment_3 ) ) ;
    public final void rule__LetVarCS__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4653:1: ( ( ( rule__LetVarCS__InitExpAssignment_3 ) ) )
            // InternalMiniOCLCS.g:4654:1: ( ( rule__LetVarCS__InitExpAssignment_3 ) )
            {
            // InternalMiniOCLCS.g:4654:1: ( ( rule__LetVarCS__InitExpAssignment_3 ) )
            // InternalMiniOCLCS.g:4655:2: ( rule__LetVarCS__InitExpAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getInitExpAssignment_3()); 
            }
            // InternalMiniOCLCS.g:4656:2: ( rule__LetVarCS__InitExpAssignment_3 )
            // InternalMiniOCLCS.g:4656:3: rule__LetVarCS__InitExpAssignment_3
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
    // InternalMiniOCLCS.g:4665:1: rule__LetVarCS__Group_1__0 : rule__LetVarCS__Group_1__0__Impl rule__LetVarCS__Group_1__1 ;
    public final void rule__LetVarCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4669:1: ( rule__LetVarCS__Group_1__0__Impl rule__LetVarCS__Group_1__1 )
            // InternalMiniOCLCS.g:4670:2: rule__LetVarCS__Group_1__0__Impl rule__LetVarCS__Group_1__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:4677:1: rule__LetVarCS__Group_1__0__Impl : ( ':' ) ;
    public final void rule__LetVarCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4681:1: ( ( ':' ) )
            // InternalMiniOCLCS.g:4682:1: ( ':' )
            {
            // InternalMiniOCLCS.g:4682:1: ( ':' )
            // InternalMiniOCLCS.g:4683:2: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getColonKeyword_1_0()); 
            }
            match(input,19,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4692:1: rule__LetVarCS__Group_1__1 : rule__LetVarCS__Group_1__1__Impl ;
    public final void rule__LetVarCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4696:1: ( rule__LetVarCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:4697:2: rule__LetVarCS__Group_1__1__Impl
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
    // InternalMiniOCLCS.g:4703:1: rule__LetVarCS__Group_1__1__Impl : ( ( rule__LetVarCS__TypeRefAssignment_1_1 ) ) ;
    public final void rule__LetVarCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4707:1: ( ( ( rule__LetVarCS__TypeRefAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:4708:1: ( ( rule__LetVarCS__TypeRefAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:4708:1: ( ( rule__LetVarCS__TypeRefAssignment_1_1 ) )
            // InternalMiniOCLCS.g:4709:2: ( rule__LetVarCS__TypeRefAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getLetVarCSAccess().getTypeRefAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:4710:2: ( rule__LetVarCS__TypeRefAssignment_1_1 )
            // InternalMiniOCLCS.g:4710:3: rule__LetVarCS__TypeRefAssignment_1_1
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
    // InternalMiniOCLCS.g:4719:1: rule__PathNameCS__Group__0 : rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 ;
    public final void rule__PathNameCS__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4723:1: ( rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1 )
            // InternalMiniOCLCS.g:4724:2: rule__PathNameCS__Group__0__Impl rule__PathNameCS__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalMiniOCLCS.g:4731:1: rule__PathNameCS__Group__0__Impl : ( ( rule__PathNameCS__PathElementsAssignment_0 ) ) ;
    public final void rule__PathNameCS__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4735:1: ( ( ( rule__PathNameCS__PathElementsAssignment_0 ) ) )
            // InternalMiniOCLCS.g:4736:1: ( ( rule__PathNameCS__PathElementsAssignment_0 ) )
            {
            // InternalMiniOCLCS.g:4736:1: ( ( rule__PathNameCS__PathElementsAssignment_0 ) )
            // InternalMiniOCLCS.g:4737:2: ( rule__PathNameCS__PathElementsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getPathElementsAssignment_0()); 
            }
            // InternalMiniOCLCS.g:4738:2: ( rule__PathNameCS__PathElementsAssignment_0 )
            // InternalMiniOCLCS.g:4738:3: rule__PathNameCS__PathElementsAssignment_0
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
    // InternalMiniOCLCS.g:4746:1: rule__PathNameCS__Group__1 : rule__PathNameCS__Group__1__Impl ;
    public final void rule__PathNameCS__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4750:1: ( rule__PathNameCS__Group__1__Impl )
            // InternalMiniOCLCS.g:4751:2: rule__PathNameCS__Group__1__Impl
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
    // InternalMiniOCLCS.g:4757:1: rule__PathNameCS__Group__1__Impl : ( ( rule__PathNameCS__Group_1__0 )* ) ;
    public final void rule__PathNameCS__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4761:1: ( ( ( rule__PathNameCS__Group_1__0 )* ) )
            // InternalMiniOCLCS.g:4762:1: ( ( rule__PathNameCS__Group_1__0 )* )
            {
            // InternalMiniOCLCS.g:4762:1: ( ( rule__PathNameCS__Group_1__0 )* )
            // InternalMiniOCLCS.g:4763:2: ( rule__PathNameCS__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getGroup_1()); 
            }
            // InternalMiniOCLCS.g:4764:2: ( rule__PathNameCS__Group_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==42) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalMiniOCLCS.g:4764:3: rule__PathNameCS__Group_1__0
            	    {
            	    pushFollow(FOLLOW_45);
            	    rule__PathNameCS__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalMiniOCLCS.g:4773:1: rule__PathNameCS__Group_1__0 : rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 ;
    public final void rule__PathNameCS__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4777:1: ( rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1 )
            // InternalMiniOCLCS.g:4778:2: rule__PathNameCS__Group_1__0__Impl rule__PathNameCS__Group_1__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalMiniOCLCS.g:4785:1: rule__PathNameCS__Group_1__0__Impl : ( '::' ) ;
    public final void rule__PathNameCS__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4789:1: ( ( '::' ) )
            // InternalMiniOCLCS.g:4790:1: ( '::' )
            {
            // InternalMiniOCLCS.g:4790:1: ( '::' )
            // InternalMiniOCLCS.g:4791:2: '::'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0()); 
            }
            match(input,42,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:4800:1: rule__PathNameCS__Group_1__1 : rule__PathNameCS__Group_1__1__Impl ;
    public final void rule__PathNameCS__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4804:1: ( rule__PathNameCS__Group_1__1__Impl )
            // InternalMiniOCLCS.g:4805:2: rule__PathNameCS__Group_1__1__Impl
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
    // InternalMiniOCLCS.g:4811:1: rule__PathNameCS__Group_1__1__Impl : ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) ) ;
    public final void rule__PathNameCS__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4815:1: ( ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) ) )
            // InternalMiniOCLCS.g:4816:1: ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) )
            {
            // InternalMiniOCLCS.g:4816:1: ( ( rule__PathNameCS__PathElementsAssignment_1_1 ) )
            // InternalMiniOCLCS.g:4817:2: ( rule__PathNameCS__PathElementsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPathNameCSAccess().getPathElementsAssignment_1_1()); 
            }
            // InternalMiniOCLCS.g:4818:2: ( rule__PathNameCS__PathElementsAssignment_1_1 )
            // InternalMiniOCLCS.g:4818:3: rule__PathNameCS__PathElementsAssignment_1_1
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


    // $ANTLR start "rule__RootCS__ImportsAssignment_0"
    // InternalMiniOCLCS.g:4827:1: rule__RootCS__ImportsAssignment_0 : ( ruleImportCS ) ;
    public final void rule__RootCS__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4831:1: ( ( ruleImportCS ) )
            // InternalMiniOCLCS.g:4832:2: ( ruleImportCS )
            {
            // InternalMiniOCLCS.g:4832:2: ( ruleImportCS )
            // InternalMiniOCLCS.g:4833:3: ruleImportCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSAccess().getImportsImportCSParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleImportCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSAccess().getImportsImportCSParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootCS__ImportsAssignment_0"


    // $ANTLR start "rule__RootCS__PackagesAssignment_1_0"
    // InternalMiniOCLCS.g:4842:1: rule__RootCS__PackagesAssignment_1_0 : ( rulePackageCS ) ;
    public final void rule__RootCS__PackagesAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4846:1: ( ( rulePackageCS ) )
            // InternalMiniOCLCS.g:4847:2: ( rulePackageCS )
            {
            // InternalMiniOCLCS.g:4847:2: ( rulePackageCS )
            // InternalMiniOCLCS.g:4848:3: rulePackageCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSAccess().getPackagesPackageCSParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_2);
            rulePackageCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSAccess().getPackagesPackageCSParserRuleCall_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootCS__PackagesAssignment_1_0"


    // $ANTLR start "rule__RootCS__ConstraintsAssignment_1_1"
    // InternalMiniOCLCS.g:4857:1: rule__RootCS__ConstraintsAssignment_1_1 : ( ruleConstraintsDefCS ) ;
    public final void rule__RootCS__ConstraintsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4861:1: ( ( ruleConstraintsDefCS ) )
            // InternalMiniOCLCS.g:4862:2: ( ruleConstraintsDefCS )
            {
            // InternalMiniOCLCS.g:4862:2: ( ruleConstraintsDefCS )
            // InternalMiniOCLCS.g:4863:3: ruleConstraintsDefCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRootCSAccess().getConstraintsConstraintsDefCSParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleConstraintsDefCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRootCSAccess().getConstraintsConstraintsDefCSParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RootCS__ConstraintsAssignment_1_1"


    // $ANTLR start "rule__ImportCS__AliasAssignment_1_0"
    // InternalMiniOCLCS.g:4872:1: rule__ImportCS__AliasAssignment_1_0 : ( RULE_ID ) ;
    public final void rule__ImportCS__AliasAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4876:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:4877:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:4877:2: ( RULE_ID )
            // InternalMiniOCLCS.g:4878:3: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSAccess().getAliasIDTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSAccess().getAliasIDTerminalRuleCall_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportCS__AliasAssignment_1_0"


    // $ANTLR start "rule__ImportCS__UriAssignment_2"
    // InternalMiniOCLCS.g:4887:1: rule__ImportCS__UriAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ImportCS__UriAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4891:1: ( ( RULE_STRING ) )
            // InternalMiniOCLCS.g:4892:2: ( RULE_STRING )
            {
            // InternalMiniOCLCS.g:4892:2: ( RULE_STRING )
            // InternalMiniOCLCS.g:4893:3: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getImportCSAccess().getUriSTRINGTerminalRuleCall_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getImportCSAccess().getUriSTRINGTerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImportCS__UriAssignment_2"


    // $ANTLR start "rule__PackageCS__NameAssignment_1"
    // InternalMiniOCLCS.g:4902:1: rule__PackageCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PackageCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4906:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:4907:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:4907:2: ( RULE_ID )
            // InternalMiniOCLCS.g:4908:3: RULE_ID
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
    // InternalMiniOCLCS.g:4917:1: rule__PackageCS__PackagesAssignment_3_0 : ( rulePackageCS ) ;
    public final void rule__PackageCS__PackagesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4921:1: ( ( rulePackageCS ) )
            // InternalMiniOCLCS.g:4922:2: ( rulePackageCS )
            {
            // InternalMiniOCLCS.g:4922:2: ( rulePackageCS )
            // InternalMiniOCLCS.g:4923:3: rulePackageCS
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
    // InternalMiniOCLCS.g:4932:1: rule__PackageCS__ClassesAssignment_3_1 : ( ruleClassCS ) ;
    public final void rule__PackageCS__ClassesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4936:1: ( ( ruleClassCS ) )
            // InternalMiniOCLCS.g:4937:2: ( ruleClassCS )
            {
            // InternalMiniOCLCS.g:4937:2: ( ruleClassCS )
            // InternalMiniOCLCS.g:4938:3: ruleClassCS
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
    // InternalMiniOCLCS.g:4947:1: rule__ClassCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ClassCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4951:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:4952:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:4952:2: ( RULE_ID )
            // InternalMiniOCLCS.g:4953:3: RULE_ID
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
    // InternalMiniOCLCS.g:4962:1: rule__ClassCS__ExtendsAssignment_2_1 : ( rulePathNameCS ) ;
    public final void rule__ClassCS__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4966:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:4967:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:4967:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:4968:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:4977:1: rule__ClassCS__PropertiesAssignment_4_0 : ( rulePropertyCS ) ;
    public final void rule__ClassCS__PropertiesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4981:1: ( ( rulePropertyCS ) )
            // InternalMiniOCLCS.g:4982:2: ( rulePropertyCS )
            {
            // InternalMiniOCLCS.g:4982:2: ( rulePropertyCS )
            // InternalMiniOCLCS.g:4983:3: rulePropertyCS
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
    // InternalMiniOCLCS.g:4992:1: rule__ClassCS__OperationsAssignment_4_1 : ( ruleOperationCS ) ;
    public final void rule__ClassCS__OperationsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:4996:1: ( ( ruleOperationCS ) )
            // InternalMiniOCLCS.g:4997:2: ( ruleOperationCS )
            {
            // InternalMiniOCLCS.g:4997:2: ( ruleOperationCS )
            // InternalMiniOCLCS.g:4998:3: ruleOperationCS
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
    // InternalMiniOCLCS.g:5007:1: rule__PropertyCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PropertyCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5011:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5012:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5012:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5013:3: RULE_ID
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
    // InternalMiniOCLCS.g:5022:1: rule__PropertyCS__TypeRefAssignment_3 : ( rulePathNameCS ) ;
    public final void rule__PropertyCS__TypeRefAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5026:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5027:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5027:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5028:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5037:1: rule__PropertyCS__MultiplicityAssignment_4 : ( ruleMultiplicityCS ) ;
    public final void rule__PropertyCS__MultiplicityAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5041:1: ( ( ruleMultiplicityCS ) )
            // InternalMiniOCLCS.g:5042:2: ( ruleMultiplicityCS )
            {
            // InternalMiniOCLCS.g:5042:2: ( ruleMultiplicityCS )
            // InternalMiniOCLCS.g:5043:3: ruleMultiplicityCS
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
    // InternalMiniOCLCS.g:5052:1: rule__MultiplicityCS__OptAssignment_1_0 : ( ( '?' ) ) ;
    public final void rule__MultiplicityCS__OptAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5056:1: ( ( ( '?' ) ) )
            // InternalMiniOCLCS.g:5057:2: ( ( '?' ) )
            {
            // InternalMiniOCLCS.g:5057:2: ( ( '?' ) )
            // InternalMiniOCLCS.g:5058:3: ( '?' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getOptQuestionMarkKeyword_1_0_0()); 
            }
            // InternalMiniOCLCS.g:5059:3: ( '?' )
            // InternalMiniOCLCS.g:5060:4: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getOptQuestionMarkKeyword_1_0_0()); 
            }
            match(input,43,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:5071:1: rule__MultiplicityCS__MultAssignment_1_1 : ( ( '*' ) ) ;
    public final void rule__MultiplicityCS__MultAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5075:1: ( ( ( '*' ) ) )
            // InternalMiniOCLCS.g:5076:2: ( ( '*' ) )
            {
            // InternalMiniOCLCS.g:5076:2: ( ( '*' ) )
            // InternalMiniOCLCS.g:5077:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getMultAsteriskKeyword_1_1_0()); 
            }
            // InternalMiniOCLCS.g:5078:3: ( '*' )
            // InternalMiniOCLCS.g:5079:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getMultAsteriskKeyword_1_1_0()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
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


    // $ANTLR start "rule__MultiplicityCS__MandatoryAssignment_1_2"
    // InternalMiniOCLCS.g:5090:1: rule__MultiplicityCS__MandatoryAssignment_1_2 : ( RULE_INT ) ;
    public final void rule__MultiplicityCS__MandatoryAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5094:1: ( ( RULE_INT ) )
            // InternalMiniOCLCS.g:5095:2: ( RULE_INT )
            {
            // InternalMiniOCLCS.g:5095:2: ( RULE_INT )
            // InternalMiniOCLCS.g:5096:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getMandatoryINTTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getMandatoryINTTerminalRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__MandatoryAssignment_1_2"


    // $ANTLR start "rule__MultiplicityCS__LowerIntAssignment_1_3_0"
    // InternalMiniOCLCS.g:5105:1: rule__MultiplicityCS__LowerIntAssignment_1_3_0 : ( RULE_INT ) ;
    public final void rule__MultiplicityCS__LowerIntAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5109:1: ( ( RULE_INT ) )
            // InternalMiniOCLCS.g:5110:2: ( RULE_INT )
            {
            // InternalMiniOCLCS.g:5110:2: ( RULE_INT )
            // InternalMiniOCLCS.g:5111:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getLowerIntINTTerminalRuleCall_1_3_0_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getLowerIntINTTerminalRuleCall_1_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__LowerIntAssignment_1_3_0"


    // $ANTLR start "rule__MultiplicityCS__UpperIntAssignment_1_3_2_0"
    // InternalMiniOCLCS.g:5120:1: rule__MultiplicityCS__UpperIntAssignment_1_3_2_0 : ( RULE_INT ) ;
    public final void rule__MultiplicityCS__UpperIntAssignment_1_3_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5124:1: ( ( RULE_INT ) )
            // InternalMiniOCLCS.g:5125:2: ( RULE_INT )
            {
            // InternalMiniOCLCS.g:5125:2: ( RULE_INT )
            // InternalMiniOCLCS.g:5126:3: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getUpperIntINTTerminalRuleCall_1_3_2_0_0()); 
            }
            match(input,RULE_INT,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getUpperIntINTTerminalRuleCall_1_3_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__UpperIntAssignment_1_3_2_0"


    // $ANTLR start "rule__MultiplicityCS__UpperMultAssignment_1_3_2_1"
    // InternalMiniOCLCS.g:5135:1: rule__MultiplicityCS__UpperMultAssignment_1_3_2_1 : ( ( '*' ) ) ;
    public final void rule__MultiplicityCS__UpperMultAssignment_1_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5139:1: ( ( ( '*' ) ) )
            // InternalMiniOCLCS.g:5140:2: ( ( '*' ) )
            {
            // InternalMiniOCLCS.g:5140:2: ( ( '*' ) )
            // InternalMiniOCLCS.g:5141:3: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_3_2_1_0()); 
            }
            // InternalMiniOCLCS.g:5142:3: ( '*' )
            // InternalMiniOCLCS.g:5143:4: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_3_2_1_0()); 
            }
            match(input,44,FOLLOW_2); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_3_2_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMultiplicityCSAccess().getUpperMultAsteriskKeyword_1_3_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiplicityCS__UpperMultAssignment_1_3_2_1"


    // $ANTLR start "rule__OperationCS__NameAssignment_1"
    // InternalMiniOCLCS.g:5154:1: rule__OperationCS__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OperationCS__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5158:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5159:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5159:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5160:3: RULE_ID
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
    // InternalMiniOCLCS.g:5169:1: rule__OperationCS__ParamsAssignment_3_0 : ( ruleParameterCS ) ;
    public final void rule__OperationCS__ParamsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5173:1: ( ( ruleParameterCS ) )
            // InternalMiniOCLCS.g:5174:2: ( ruleParameterCS )
            {
            // InternalMiniOCLCS.g:5174:2: ( ruleParameterCS )
            // InternalMiniOCLCS.g:5175:3: ruleParameterCS
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
    // InternalMiniOCLCS.g:5184:1: rule__OperationCS__ParamsAssignment_3_1_1 : ( ruleParameterCS ) ;
    public final void rule__OperationCS__ParamsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5188:1: ( ( ruleParameterCS ) )
            // InternalMiniOCLCS.g:5189:2: ( ruleParameterCS )
            {
            // InternalMiniOCLCS.g:5189:2: ( ruleParameterCS )
            // InternalMiniOCLCS.g:5190:3: ruleParameterCS
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
    // InternalMiniOCLCS.g:5199:1: rule__OperationCS__ResultRefAssignment_6 : ( rulePathNameCS ) ;
    public final void rule__OperationCS__ResultRefAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5203:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5204:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5204:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5205:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5214:1: rule__OperationCS__BodyAssignment_8 : ( ruleExpCS ) ;
    public final void rule__OperationCS__BodyAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5218:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5219:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5219:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5220:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5229:1: rule__ParameterCS__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ParameterCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5233:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5234:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5234:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5235:3: RULE_ID
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
    // InternalMiniOCLCS.g:5244:1: rule__ParameterCS__TypeRefAssignment_2 : ( rulePathNameCS ) ;
    public final void rule__ParameterCS__TypeRefAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5248:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5249:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5249:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5250:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5259:1: rule__ConstraintsDefCS__TypeRefAssignment_1 : ( rulePathNameCS ) ;
    public final void rule__ConstraintsDefCS__TypeRefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5263:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5264:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5264:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5265:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5274:1: rule__ConstraintsDefCS__InvariantsAssignment_3 : ( ruleInvariantCS ) ;
    public final void rule__ConstraintsDefCS__InvariantsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5278:1: ( ( ruleInvariantCS ) )
            // InternalMiniOCLCS.g:5279:2: ( ruleInvariantCS )
            {
            // InternalMiniOCLCS.g:5279:2: ( ruleInvariantCS )
            // InternalMiniOCLCS.g:5280:3: ruleInvariantCS
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
    // InternalMiniOCLCS.g:5289:1: rule__InvariantCS__ExpAssignment_2 : ( ruleExpCS ) ;
    public final void rule__InvariantCS__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5293:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5294:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5294:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5295:3: ruleExpCS
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


    // $ANTLR start "rule__EqualityExpCS__OpNameAssignment_1_1"
    // InternalMiniOCLCS.g:5304:1: rule__EqualityExpCS__OpNameAssignment_1_1 : ( ( rule__EqualityExpCS__OpNameAlternatives_1_1_0 ) ) ;
    public final void rule__EqualityExpCS__OpNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5308:1: ( ( ( rule__EqualityExpCS__OpNameAlternatives_1_1_0 ) ) )
            // InternalMiniOCLCS.g:5309:2: ( ( rule__EqualityExpCS__OpNameAlternatives_1_1_0 ) )
            {
            // InternalMiniOCLCS.g:5309:2: ( ( rule__EqualityExpCS__OpNameAlternatives_1_1_0 ) )
            // InternalMiniOCLCS.g:5310:3: ( rule__EqualityExpCS__OpNameAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpCSAccess().getOpNameAlternatives_1_1_0()); 
            }
            // InternalMiniOCLCS.g:5311:3: ( rule__EqualityExpCS__OpNameAlternatives_1_1_0 )
            // InternalMiniOCLCS.g:5311:4: rule__EqualityExpCS__OpNameAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__EqualityExpCS__OpNameAlternatives_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpCSAccess().getOpNameAlternatives_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpCS__OpNameAssignment_1_1"


    // $ANTLR start "rule__EqualityExpCS__RightAssignment_1_2"
    // InternalMiniOCLCS.g:5319:1: rule__EqualityExpCS__RightAssignment_1_2 : ( ruleCallExpCS ) ;
    public final void rule__EqualityExpCS__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5323:1: ( ( ruleCallExpCS ) )
            // InternalMiniOCLCS.g:5324:2: ( ruleCallExpCS )
            {
            // InternalMiniOCLCS.g:5324:2: ( ruleCallExpCS )
            // InternalMiniOCLCS.g:5325:3: ruleCallExpCS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEqualityExpCSAccess().getRightCallExpCSParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_2);
            ruleCallExpCS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEqualityExpCSAccess().getRightCallExpCSParserRuleCall_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqualityExpCS__RightAssignment_1_2"


    // $ANTLR start "rule__CallExpCS__OpNameAssignment_1_1"
    // InternalMiniOCLCS.g:5334:1: rule__CallExpCS__OpNameAssignment_1_1 : ( ( rule__CallExpCS__OpNameAlternatives_1_1_0 ) ) ;
    public final void rule__CallExpCS__OpNameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5338:1: ( ( ( rule__CallExpCS__OpNameAlternatives_1_1_0 ) ) )
            // InternalMiniOCLCS.g:5339:2: ( ( rule__CallExpCS__OpNameAlternatives_1_1_0 ) )
            {
            // InternalMiniOCLCS.g:5339:2: ( ( rule__CallExpCS__OpNameAlternatives_1_1_0 ) )
            // InternalMiniOCLCS.g:5340:3: ( rule__CallExpCS__OpNameAlternatives_1_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCallExpCSAccess().getOpNameAlternatives_1_1_0()); 
            }
            // InternalMiniOCLCS.g:5341:3: ( rule__CallExpCS__OpNameAlternatives_1_1_0 )
            // InternalMiniOCLCS.g:5341:4: rule__CallExpCS__OpNameAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__CallExpCS__OpNameAlternatives_1_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCallExpCSAccess().getOpNameAlternatives_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallExpCS__OpNameAssignment_1_1"


    // $ANTLR start "rule__CallExpCS__NavExpAssignment_1_2"
    // InternalMiniOCLCS.g:5349:1: rule__CallExpCS__NavExpAssignment_1_2 : ( ruleNavigationExpCS ) ;
    public final void rule__CallExpCS__NavExpAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5353:1: ( ( ruleNavigationExpCS ) )
            // InternalMiniOCLCS.g:5354:2: ( ruleNavigationExpCS )
            {
            // InternalMiniOCLCS.g:5354:2: ( ruleNavigationExpCS )
            // InternalMiniOCLCS.g:5355:3: ruleNavigationExpCS
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
    // InternalMiniOCLCS.g:5364:1: rule__CollectExpCS__ItVarAssignment_2_0 : ( ruleIteratorVarCS ) ;
    public final void rule__CollectExpCS__ItVarAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5368:1: ( ( ruleIteratorVarCS ) )
            // InternalMiniOCLCS.g:5369:2: ( ruleIteratorVarCS )
            {
            // InternalMiniOCLCS.g:5369:2: ( ruleIteratorVarCS )
            // InternalMiniOCLCS.g:5370:3: ruleIteratorVarCS
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
    // InternalMiniOCLCS.g:5379:1: rule__CollectExpCS__ExpAssignment_3 : ( ruleExpCS ) ;
    public final void rule__CollectExpCS__ExpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5383:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5384:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5384:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5385:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5394:1: rule__IteratorVarCS__ItNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__IteratorVarCS__ItNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5398:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5399:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5399:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5400:3: RULE_ID
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
    // InternalMiniOCLCS.g:5409:1: rule__IteratorVarCS__ItTypeAssignment_1_1 : ( rulePathNameCS ) ;
    public final void rule__IteratorVarCS__ItTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5413:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5414:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5414:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5415:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5424:1: rule__IterateExpCS__ItVarAssignment_2 : ( ruleIteratorVarCS ) ;
    public final void rule__IterateExpCS__ItVarAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5428:1: ( ( ruleIteratorVarCS ) )
            // InternalMiniOCLCS.g:5429:2: ( ruleIteratorVarCS )
            {
            // InternalMiniOCLCS.g:5429:2: ( ruleIteratorVarCS )
            // InternalMiniOCLCS.g:5430:3: ruleIteratorVarCS
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
    // InternalMiniOCLCS.g:5439:1: rule__IterateExpCS__AccVarAssignment_4 : ( ruleAccVarCS ) ;
    public final void rule__IterateExpCS__AccVarAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5443:1: ( ( ruleAccVarCS ) )
            // InternalMiniOCLCS.g:5444:2: ( ruleAccVarCS )
            {
            // InternalMiniOCLCS.g:5444:2: ( ruleAccVarCS )
            // InternalMiniOCLCS.g:5445:3: ruleAccVarCS
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
    // InternalMiniOCLCS.g:5454:1: rule__IterateExpCS__ExpAssignment_6 : ( ruleExpCS ) ;
    public final void rule__IterateExpCS__ExpAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5458:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5459:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5459:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5460:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5469:1: rule__AccVarCS__AccNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__AccVarCS__AccNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5473:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5474:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5474:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5475:3: RULE_ID
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
    // InternalMiniOCLCS.g:5484:1: rule__AccVarCS__AccTypeAssignment_1_1 : ( rulePathNameCS ) ;
    public final void rule__AccVarCS__AccTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5488:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5489:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5489:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5490:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5499:1: rule__AccVarCS__AccInitExpAssignment_3 : ( ruleExpCS ) ;
    public final void rule__AccVarCS__AccInitExpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5503:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5504:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5504:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5505:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5514:1: rule__NameExpCS__ExpNameAssignment_0 : ( rulePathNameCS ) ;
    public final void rule__NameExpCS__ExpNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5518:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5519:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5519:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5520:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5529:1: rule__NameExpCS__RoundedBracketsAssignment_1 : ( ruleRoundedBracketClauseCS ) ;
    public final void rule__NameExpCS__RoundedBracketsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5533:1: ( ( ruleRoundedBracketClauseCS ) )
            // InternalMiniOCLCS.g:5534:2: ( ruleRoundedBracketClauseCS )
            {
            // InternalMiniOCLCS.g:5534:2: ( ruleRoundedBracketClauseCS )
            // InternalMiniOCLCS.g:5535:3: ruleRoundedBracketClauseCS
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
    // InternalMiniOCLCS.g:5544:1: rule__RoundedBracketClauseCS__ArgsAssignment_2_0 : ( ruleExpCS ) ;
    public final void rule__RoundedBracketClauseCS__ArgsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5548:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5549:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5549:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5550:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5559:1: rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1 : ( ruleExpCS ) ;
    public final void rule__RoundedBracketClauseCS__ArgsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5563:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5564:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5564:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5565:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5574:1: rule__IntLiteralExpCS__IntSymbolAssignment : ( RULE_INT ) ;
    public final void rule__IntLiteralExpCS__IntSymbolAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5578:1: ( ( RULE_INT ) )
            // InternalMiniOCLCS.g:5579:2: ( RULE_INT )
            {
            // InternalMiniOCLCS.g:5579:2: ( RULE_INT )
            // InternalMiniOCLCS.g:5580:3: RULE_INT
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
    // InternalMiniOCLCS.g:5589:1: rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralExpCS__BoolSymbolAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5593:1: ( ( ( 'true' ) ) )
            // InternalMiniOCLCS.g:5594:2: ( ( 'true' ) )
            {
            // InternalMiniOCLCS.g:5594:2: ( ( 'true' ) )
            // InternalMiniOCLCS.g:5595:3: ( 'true' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0()); 
            }
            // InternalMiniOCLCS.g:5596:3: ( 'true' )
            // InternalMiniOCLCS.g:5597:4: 'true'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getBooleanLiteralExpCSAccess().getBoolSymbolTrueKeyword_1_0_0()); 
            }
            match(input,45,FOLLOW_2); if (state.failed) return ;
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
    // InternalMiniOCLCS.g:5608:1: rule__CollectionLiteralExpCS__KindAssignment_0 : ( ruleCollectionKindCS ) ;
    public final void rule__CollectionLiteralExpCS__KindAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5612:1: ( ( ruleCollectionKindCS ) )
            // InternalMiniOCLCS.g:5613:2: ( ruleCollectionKindCS )
            {
            // InternalMiniOCLCS.g:5613:2: ( ruleCollectionKindCS )
            // InternalMiniOCLCS.g:5614:3: ruleCollectionKindCS
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
    // InternalMiniOCLCS.g:5623:1: rule__CollectionLiteralExpCS__PartsAssignment_2 : ( ruleCollectionLiteralPartCS ) ;
    public final void rule__CollectionLiteralExpCS__PartsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5627:1: ( ( ruleCollectionLiteralPartCS ) )
            // InternalMiniOCLCS.g:5628:2: ( ruleCollectionLiteralPartCS )
            {
            // InternalMiniOCLCS.g:5628:2: ( ruleCollectionLiteralPartCS )
            // InternalMiniOCLCS.g:5629:3: ruleCollectionLiteralPartCS
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
    // InternalMiniOCLCS.g:5638:1: rule__CollectionLiteralPartCS__FirstAssignment_0 : ( ruleExpCS ) ;
    public final void rule__CollectionLiteralPartCS__FirstAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5642:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5643:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5643:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5644:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5653:1: rule__CollectionLiteralPartCS__LastAssignment_1_1 : ( ruleExpCS ) ;
    public final void rule__CollectionLiteralPartCS__LastAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5657:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5658:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5658:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5659:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5668:1: rule__LetExpCS__LetVarsAssignment_1 : ( ruleLetVarCS ) ;
    public final void rule__LetExpCS__LetVarsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5672:1: ( ( ruleLetVarCS ) )
            // InternalMiniOCLCS.g:5673:2: ( ruleLetVarCS )
            {
            // InternalMiniOCLCS.g:5673:2: ( ruleLetVarCS )
            // InternalMiniOCLCS.g:5674:3: ruleLetVarCS
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
    // InternalMiniOCLCS.g:5683:1: rule__LetExpCS__LetVarsAssignment_2_1 : ( ruleLetVarCS ) ;
    public final void rule__LetExpCS__LetVarsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5687:1: ( ( ruleLetVarCS ) )
            // InternalMiniOCLCS.g:5688:2: ( ruleLetVarCS )
            {
            // InternalMiniOCLCS.g:5688:2: ( ruleLetVarCS )
            // InternalMiniOCLCS.g:5689:3: ruleLetVarCS
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
    // InternalMiniOCLCS.g:5698:1: rule__LetExpCS__InExpAssignment_4 : ( ruleExpCS ) ;
    public final void rule__LetExpCS__InExpAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5702:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5703:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5703:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5704:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5713:1: rule__LetVarCS__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__LetVarCS__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5717:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5718:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5718:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5719:3: RULE_ID
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
    // InternalMiniOCLCS.g:5728:1: rule__LetVarCS__TypeRefAssignment_1_1 : ( rulePathNameCS ) ;
    public final void rule__LetVarCS__TypeRefAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5732:1: ( ( rulePathNameCS ) )
            // InternalMiniOCLCS.g:5733:2: ( rulePathNameCS )
            {
            // InternalMiniOCLCS.g:5733:2: ( rulePathNameCS )
            // InternalMiniOCLCS.g:5734:3: rulePathNameCS
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
    // InternalMiniOCLCS.g:5743:1: rule__LetVarCS__InitExpAssignment_3 : ( ruleExpCS ) ;
    public final void rule__LetVarCS__InitExpAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5747:1: ( ( ruleExpCS ) )
            // InternalMiniOCLCS.g:5748:2: ( ruleExpCS )
            {
            // InternalMiniOCLCS.g:5748:2: ( ruleExpCS )
            // InternalMiniOCLCS.g:5749:3: ruleExpCS
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
    // InternalMiniOCLCS.g:5758:1: rule__PathNameCS__PathElementsAssignment_0 : ( rulePathElementCS ) ;
    public final void rule__PathNameCS__PathElementsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5762:1: ( ( rulePathElementCS ) )
            // InternalMiniOCLCS.g:5763:2: ( rulePathElementCS )
            {
            // InternalMiniOCLCS.g:5763:2: ( rulePathElementCS )
            // InternalMiniOCLCS.g:5764:3: rulePathElementCS
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
    // InternalMiniOCLCS.g:5773:1: rule__PathNameCS__PathElementsAssignment_1_1 : ( rulePathElementCS ) ;
    public final void rule__PathNameCS__PathElementsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5777:1: ( ( rulePathElementCS ) )
            // InternalMiniOCLCS.g:5778:2: ( rulePathElementCS )
            {
            // InternalMiniOCLCS.g:5778:2: ( rulePathElementCS )
            // InternalMiniOCLCS.g:5779:3: rulePathElementCS
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
    // InternalMiniOCLCS.g:5788:1: rule__PathElementCS__ElementNameAssignment : ( RULE_ID ) ;
    public final void rule__PathElementCS__ElementNameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMiniOCLCS.g:5792:1: ( ( RULE_ID ) )
            // InternalMiniOCLCS.g:5793:2: ( RULE_ID )
            {
            // InternalMiniOCLCS.g:5793:2: ( RULE_ID )
            // InternalMiniOCLCS.g:5794:3: RULE_ID
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

    // $ANTLR start synpred28_InternalMiniOCLCS
    public final void synpred28_InternalMiniOCLCS_fragment() throws RecognitionException {   
        // InternalMiniOCLCS.g:2820:3: ( rule__EqualityExpCS__Group_1__0 )
        // InternalMiniOCLCS.g:2820:3: rule__EqualityExpCS__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__EqualityExpCS__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalMiniOCLCS

    // $ANTLR start synpred29_InternalMiniOCLCS
    public final void synpred29_InternalMiniOCLCS_fragment() throws RecognitionException {   
        // InternalMiniOCLCS.g:2955:3: ( rule__CallExpCS__Group_1__0 )
        // InternalMiniOCLCS.g:2955:3: rule__CallExpCS__Group_1__0
        {
        pushFollow(FOLLOW_2);
        rule__CallExpCS__Group_1__0();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalMiniOCLCS

    // Delegated rules

    public final boolean synpred28_InternalMiniOCLCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalMiniOCLCS_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000200100002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000D00000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000900002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000022400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000022000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004040000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000180000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000100000000040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000218800010850L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000005000000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000081000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000218880010850L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000200000010000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000218800410850L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000218800010852L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020100000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000040000000002L});

}