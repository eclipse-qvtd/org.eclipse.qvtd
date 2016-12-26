package org.eclipse.qvtd.cs2as.compiler.tests.models.companies.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvtd.cs2as.compiler.tests.models.companies.services.CompaniesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCompaniesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_FLOAT", "RULE_WS", "'company'", "'{'", "'}'", "'department'", "'manager'", "'employee'", "'address'", "'salary'", "'mentor'"
    };
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;
    public static final int RULE_WS=6;
    public static final int RULE_STRING=4;
    public static final int T__15=15;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int RULE_FLOAT=5;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__10=10;

    // delegates
    // delegators


        public InternalCompaniesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCompaniesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCompaniesParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCompanies.g"; }



     	private CompaniesGrammarAccess grammarAccess;

        public InternalCompaniesParser(TokenStream input, CompaniesGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "company";
       	}

       	@Override
       	protected CompaniesGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulecompany"
    // InternalCompanies.g:64:1: entryRulecompany returns [EObject current=null] : iv_rulecompany= rulecompany EOF ;
    public final EObject entryRulecompany() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecompany = null;


        try {
            // InternalCompanies.g:64:48: (iv_rulecompany= rulecompany EOF )
            // InternalCompanies.g:65:2: iv_rulecompany= rulecompany EOF
            {
             newCompositeNode(grammarAccess.getCompanyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulecompany=rulecompany();

            state._fsp--;

             current =iv_rulecompany; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecompany"


    // $ANTLR start "rulecompany"
    // InternalCompanies.g:71:1: rulecompany returns [EObject current=null] : (otherlv_0= 'company' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_deparment_3_0= ruledepartment ) )* otherlv_4= '}' ) ;
    public final EObject rulecompany() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_deparment_3_0 = null;



        	enterRule();

        try {
            // InternalCompanies.g:77:2: ( (otherlv_0= 'company' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_deparment_3_0= ruledepartment ) )* otherlv_4= '}' ) )
            // InternalCompanies.g:78:2: (otherlv_0= 'company' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_deparment_3_0= ruledepartment ) )* otherlv_4= '}' )
            {
            // InternalCompanies.g:78:2: (otherlv_0= 'company' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_deparment_3_0= ruledepartment ) )* otherlv_4= '}' )
            // InternalCompanies.g:79:3: otherlv_0= 'company' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_deparment_3_0= ruledepartment ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,7,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCompanyAccess().getCompanyKeyword_0());
            		
            // InternalCompanies.g:83:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalCompanies.g:84:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalCompanies.g:84:4: (lv_name_1_0= RULE_STRING )
            // InternalCompanies.g:85:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCompanyAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCompanyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,8,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getCompanyAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalCompanies.g:105:3: ( (lv_deparment_3_0= ruledepartment ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==10) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCompanies.g:106:4: (lv_deparment_3_0= ruledepartment )
            	    {
            	    // InternalCompanies.g:106:4: (lv_deparment_3_0= ruledepartment )
            	    // InternalCompanies.g:107:5: lv_deparment_3_0= ruledepartment
            	    {

            	    					newCompositeNode(grammarAccess.getCompanyAccess().getDeparmentDepartmentParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_deparment_3_0=ruledepartment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCompanyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"deparment",
            	    						lv_deparment_3_0,
            	    						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.department");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_4=(Token)match(input,9,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getCompanyAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecompany"


    // $ANTLR start "entryRuledepartment"
    // InternalCompanies.g:132:1: entryRuledepartment returns [EObject current=null] : iv_ruledepartment= ruledepartment EOF ;
    public final EObject entryRuledepartment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruledepartment = null;


        try {
            // InternalCompanies.g:132:51: (iv_ruledepartment= ruledepartment EOF )
            // InternalCompanies.g:133:2: iv_ruledepartment= ruledepartment EOF
            {
             newCompositeNode(grammarAccess.getDepartmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruledepartment=ruledepartment();

            state._fsp--;

             current =iv_ruledepartment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuledepartment"


    // $ANTLR start "ruledepartment"
    // InternalCompanies.g:139:1: ruledepartment returns [EObject current=null] : (otherlv_0= 'department' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_department_manager_3_0= ruledepartment_manager ) ) ( (lv_department_employees_4_0= ruledepartment_employees ) ) ( (lv_deparment_5_0= ruledepartment ) )* otherlv_6= '}' ) ;
    public final EObject ruledepartment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_department_manager_3_0 = null;

        EObject lv_department_employees_4_0 = null;

        EObject lv_deparment_5_0 = null;



        	enterRule();

        try {
            // InternalCompanies.g:145:2: ( (otherlv_0= 'department' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_department_manager_3_0= ruledepartment_manager ) ) ( (lv_department_employees_4_0= ruledepartment_employees ) ) ( (lv_deparment_5_0= ruledepartment ) )* otherlv_6= '}' ) )
            // InternalCompanies.g:146:2: (otherlv_0= 'department' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_department_manager_3_0= ruledepartment_manager ) ) ( (lv_department_employees_4_0= ruledepartment_employees ) ) ( (lv_deparment_5_0= ruledepartment ) )* otherlv_6= '}' )
            {
            // InternalCompanies.g:146:2: (otherlv_0= 'department' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_department_manager_3_0= ruledepartment_manager ) ) ( (lv_department_employees_4_0= ruledepartment_employees ) ) ( (lv_deparment_5_0= ruledepartment ) )* otherlv_6= '}' )
            // InternalCompanies.g:147:3: otherlv_0= 'department' ( (lv_name_1_0= RULE_STRING ) ) otherlv_2= '{' ( (lv_department_manager_3_0= ruledepartment_manager ) ) ( (lv_department_employees_4_0= ruledepartment_employees ) ) ( (lv_deparment_5_0= ruledepartment ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,10,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDepartmentAccess().getDepartmentKeyword_0());
            		
            // InternalCompanies.g:151:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalCompanies.g:152:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalCompanies.g:152:4: (lv_name_1_0= RULE_STRING )
            // InternalCompanies.g:153:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDepartmentAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDepartmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,8,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getDepartmentAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalCompanies.g:173:3: ( (lv_department_manager_3_0= ruledepartment_manager ) )
            // InternalCompanies.g:174:4: (lv_department_manager_3_0= ruledepartment_manager )
            {
            // InternalCompanies.g:174:4: (lv_department_manager_3_0= ruledepartment_manager )
            // InternalCompanies.g:175:5: lv_department_manager_3_0= ruledepartment_manager
            {

            					newCompositeNode(grammarAccess.getDepartmentAccess().getDepartment_managerDepartment_managerParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_department_manager_3_0=ruledepartment_manager();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDepartmentRule());
            					}
            					set(
            						current,
            						"department_manager",
            						lv_department_manager_3_0,
            						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.department_manager");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalCompanies.g:192:3: ( (lv_department_employees_4_0= ruledepartment_employees ) )
            // InternalCompanies.g:193:4: (lv_department_employees_4_0= ruledepartment_employees )
            {
            // InternalCompanies.g:193:4: (lv_department_employees_4_0= ruledepartment_employees )
            // InternalCompanies.g:194:5: lv_department_employees_4_0= ruledepartment_employees
            {

            					newCompositeNode(grammarAccess.getDepartmentAccess().getDepartment_employeesDepartment_employeesParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_5);
            lv_department_employees_4_0=ruledepartment_employees();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDepartmentRule());
            					}
            					set(
            						current,
            						"department_employees",
            						lv_department_employees_4_0,
            						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.department_employees");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalCompanies.g:211:3: ( (lv_deparment_5_0= ruledepartment ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==10) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCompanies.g:212:4: (lv_deparment_5_0= ruledepartment )
            	    {
            	    // InternalCompanies.g:212:4: (lv_deparment_5_0= ruledepartment )
            	    // InternalCompanies.g:213:5: lv_deparment_5_0= ruledepartment
            	    {

            	    					newCompositeNode(grammarAccess.getDepartmentAccess().getDeparmentDepartmentParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_deparment_5_0=ruledepartment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDepartmentRule());
            	    					}
            	    					add(
            	    						current,
            	    						"deparment",
            	    						lv_deparment_5_0,
            	    						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.department");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_6=(Token)match(input,9,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getDepartmentAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruledepartment"


    // $ANTLR start "entryRuledepartment_manager"
    // InternalCompanies.g:238:1: entryRuledepartment_manager returns [EObject current=null] : iv_ruledepartment_manager= ruledepartment_manager EOF ;
    public final EObject entryRuledepartment_manager() throws RecognitionException {
        EObject current = null;

        EObject iv_ruledepartment_manager = null;


        try {
            // InternalCompanies.g:238:59: (iv_ruledepartment_manager= ruledepartment_manager EOF )
            // InternalCompanies.g:239:2: iv_ruledepartment_manager= ruledepartment_manager EOF
            {
             newCompositeNode(grammarAccess.getDepartment_managerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruledepartment_manager=ruledepartment_manager();

            state._fsp--;

             current =iv_ruledepartment_manager; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuledepartment_manager"


    // $ANTLR start "ruledepartment_manager"
    // InternalCompanies.g:245:1: ruledepartment_manager returns [EObject current=null] : (otherlv_0= 'manager' ( (lv_employee_1_0= ruleemployee ) ) ) ;
    public final EObject ruledepartment_manager() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_employee_1_0 = null;



        	enterRule();

        try {
            // InternalCompanies.g:251:2: ( (otherlv_0= 'manager' ( (lv_employee_1_0= ruleemployee ) ) ) )
            // InternalCompanies.g:252:2: (otherlv_0= 'manager' ( (lv_employee_1_0= ruleemployee ) ) )
            {
            // InternalCompanies.g:252:2: (otherlv_0= 'manager' ( (lv_employee_1_0= ruleemployee ) ) )
            // InternalCompanies.g:253:3: otherlv_0= 'manager' ( (lv_employee_1_0= ruleemployee ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getDepartment_managerAccess().getManagerKeyword_0());
            		
            // InternalCompanies.g:257:3: ( (lv_employee_1_0= ruleemployee ) )
            // InternalCompanies.g:258:4: (lv_employee_1_0= ruleemployee )
            {
            // InternalCompanies.g:258:4: (lv_employee_1_0= ruleemployee )
            // InternalCompanies.g:259:5: lv_employee_1_0= ruleemployee
            {

            					newCompositeNode(grammarAccess.getDepartment_managerAccess().getEmployeeEmployeeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_employee_1_0=ruleemployee();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDepartment_managerRule());
            					}
            					set(
            						current,
            						"employee",
            						lv_employee_1_0,
            						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.employee");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruledepartment_manager"


    // $ANTLR start "entryRuledepartment_employees"
    // InternalCompanies.g:280:1: entryRuledepartment_employees returns [EObject current=null] : iv_ruledepartment_employees= ruledepartment_employees EOF ;
    public final EObject entryRuledepartment_employees() throws RecognitionException {
        EObject current = null;

        EObject iv_ruledepartment_employees = null;


        try {
            // InternalCompanies.g:280:61: (iv_ruledepartment_employees= ruledepartment_employees EOF )
            // InternalCompanies.g:281:2: iv_ruledepartment_employees= ruledepartment_employees EOF
            {
             newCompositeNode(grammarAccess.getDepartment_employeesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruledepartment_employees=ruledepartment_employees();

            state._fsp--;

             current =iv_ruledepartment_employees; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuledepartment_employees"


    // $ANTLR start "ruledepartment_employees"
    // InternalCompanies.g:287:1: ruledepartment_employees returns [EObject current=null] : ( () (otherlv_1= 'employee' ( (lv_employee_2_0= ruleemployee ) ) )* ) ;
    public final EObject ruledepartment_employees() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_employee_2_0 = null;



        	enterRule();

        try {
            // InternalCompanies.g:293:2: ( ( () (otherlv_1= 'employee' ( (lv_employee_2_0= ruleemployee ) ) )* ) )
            // InternalCompanies.g:294:2: ( () (otherlv_1= 'employee' ( (lv_employee_2_0= ruleemployee ) ) )* )
            {
            // InternalCompanies.g:294:2: ( () (otherlv_1= 'employee' ( (lv_employee_2_0= ruleemployee ) ) )* )
            // InternalCompanies.g:295:3: () (otherlv_1= 'employee' ( (lv_employee_2_0= ruleemployee ) ) )*
            {
            // InternalCompanies.g:295:3: ()
            // InternalCompanies.g:296:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDepartment_employeesAccess().getDepartment_employeesAction_0(),
            					current);
            			

            }

            // InternalCompanies.g:302:3: (otherlv_1= 'employee' ( (lv_employee_2_0= ruleemployee ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCompanies.g:303:4: otherlv_1= 'employee' ( (lv_employee_2_0= ruleemployee ) )
            	    {
            	    otherlv_1=(Token)match(input,12,FOLLOW_3); 

            	    				newLeafNode(otherlv_1, grammarAccess.getDepartment_employeesAccess().getEmployeeKeyword_1_0());
            	    			
            	    // InternalCompanies.g:307:4: ( (lv_employee_2_0= ruleemployee ) )
            	    // InternalCompanies.g:308:5: (lv_employee_2_0= ruleemployee )
            	    {
            	    // InternalCompanies.g:308:5: (lv_employee_2_0= ruleemployee )
            	    // InternalCompanies.g:309:6: lv_employee_2_0= ruleemployee
            	    {

            	    						newCompositeNode(grammarAccess.getDepartment_employeesAccess().getEmployeeEmployeeParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_8);
            	    lv_employee_2_0=ruleemployee();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDepartment_employeesRule());
            	    						}
            	    						add(
            	    							current,
            	    							"employee",
            	    							lv_employee_2_0,
            	    							"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.employee");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruledepartment_employees"


    // $ANTLR start "entryRuleemployee"
    // InternalCompanies.g:331:1: entryRuleemployee returns [EObject current=null] : iv_ruleemployee= ruleemployee EOF ;
    public final EObject entryRuleemployee() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleemployee = null;


        try {
            // InternalCompanies.g:331:49: (iv_ruleemployee= ruleemployee EOF )
            // InternalCompanies.g:332:2: iv_ruleemployee= ruleemployee EOF
            {
             newCompositeNode(grammarAccess.getEmployeeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleemployee=ruleemployee();

            state._fsp--;

             current =iv_ruleemployee; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleemployee"


    // $ANTLR start "ruleemployee"
    // InternalCompanies.g:338:1: ruleemployee returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= '{' otherlv_2= 'address' ( (lv_address_3_0= RULE_STRING ) ) otherlv_4= 'salary' ( (lv_salary_5_0= RULE_FLOAT ) ) (otherlv_6= 'mentor' ( (lv_mentor_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleemployee() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_address_3_0=null;
        Token otherlv_4=null;
        Token lv_salary_5_0=null;
        Token otherlv_6=null;
        Token lv_mentor_7_0=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalCompanies.g:344:2: ( ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= '{' otherlv_2= 'address' ( (lv_address_3_0= RULE_STRING ) ) otherlv_4= 'salary' ( (lv_salary_5_0= RULE_FLOAT ) ) (otherlv_6= 'mentor' ( (lv_mentor_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // InternalCompanies.g:345:2: ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= '{' otherlv_2= 'address' ( (lv_address_3_0= RULE_STRING ) ) otherlv_4= 'salary' ( (lv_salary_5_0= RULE_FLOAT ) ) (otherlv_6= 'mentor' ( (lv_mentor_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // InternalCompanies.g:345:2: ( ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= '{' otherlv_2= 'address' ( (lv_address_3_0= RULE_STRING ) ) otherlv_4= 'salary' ( (lv_salary_5_0= RULE_FLOAT ) ) (otherlv_6= 'mentor' ( (lv_mentor_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // InternalCompanies.g:346:3: ( (lv_name_0_0= RULE_STRING ) ) otherlv_1= '{' otherlv_2= 'address' ( (lv_address_3_0= RULE_STRING ) ) otherlv_4= 'salary' ( (lv_salary_5_0= RULE_FLOAT ) ) (otherlv_6= 'mentor' ( (lv_mentor_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            // InternalCompanies.g:346:3: ( (lv_name_0_0= RULE_STRING ) )
            // InternalCompanies.g:347:4: (lv_name_0_0= RULE_STRING )
            {
            // InternalCompanies.g:347:4: (lv_name_0_0= RULE_STRING )
            // InternalCompanies.g:348:5: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEmployeeAccess().getNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEmployeeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.STRING");
            				

            }


            }

            otherlv_1=(Token)match(input,8,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getEmployeeAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getEmployeeAccess().getAddressKeyword_2());
            		
            // InternalCompanies.g:372:3: ( (lv_address_3_0= RULE_STRING ) )
            // InternalCompanies.g:373:4: (lv_address_3_0= RULE_STRING )
            {
            // InternalCompanies.g:373:4: (lv_address_3_0= RULE_STRING )
            // InternalCompanies.g:374:5: lv_address_3_0= RULE_STRING
            {
            lv_address_3_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_address_3_0, grammarAccess.getEmployeeAccess().getAddressSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEmployeeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"address",
            						lv_address_3_0,
            						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getEmployeeAccess().getSalaryKeyword_4());
            		
            // InternalCompanies.g:394:3: ( (lv_salary_5_0= RULE_FLOAT ) )
            // InternalCompanies.g:395:4: (lv_salary_5_0= RULE_FLOAT )
            {
            // InternalCompanies.g:395:4: (lv_salary_5_0= RULE_FLOAT )
            // InternalCompanies.g:396:5: lv_salary_5_0= RULE_FLOAT
            {
            lv_salary_5_0=(Token)match(input,RULE_FLOAT,FOLLOW_12); 

            					newLeafNode(lv_salary_5_0, grammarAccess.getEmployeeAccess().getSalaryFLOATTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEmployeeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"salary",
            						lv_salary_5_0,
            						"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.FLOAT");
            				

            }


            }

            // InternalCompanies.g:412:3: (otherlv_6= 'mentor' ( (lv_mentor_7_0= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalCompanies.g:413:4: otherlv_6= 'mentor' ( (lv_mentor_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getEmployeeAccess().getMentorKeyword_6_0());
                    			
                    // InternalCompanies.g:417:4: ( (lv_mentor_7_0= RULE_STRING ) )
                    // InternalCompanies.g:418:5: (lv_mentor_7_0= RULE_STRING )
                    {
                    // InternalCompanies.g:418:5: (lv_mentor_7_0= RULE_STRING )
                    // InternalCompanies.g:419:6: lv_mentor_7_0= RULE_STRING
                    {
                    lv_mentor_7_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

                    						newLeafNode(lv_mentor_7_0, grammarAccess.getEmployeeAccess().getMentorSTRINGTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEmployeeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"mentor",
                    							lv_mentor_7_0,
                    							"org.eclipse.qvtd.cs2as.compiler.tests.models.companies.Companies.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,9,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getEmployeeAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleemployee"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001600L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000200L});

}