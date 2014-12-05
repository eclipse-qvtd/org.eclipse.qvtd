package org.eclipse.qvtd.xtext.qvtrelation.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.LibraryCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityBoundsCS;
import org.eclipse.ocl.xtext.basecs.MultiplicityStringCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.PrimitiveTypeRefCS;
import org.eclipse.ocl.xtext.basecs.TemplateBindingCS;
import org.eclipse.ocl.xtext.basecs.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.xtext.basecs.TemplateSignatureCS;
import org.eclipse.ocl.xtext.basecs.TuplePartCS;
import org.eclipse.ocl.xtext.basecs.TupleTypeCS;
import org.eclipse.ocl.xtext.basecs.TypeParameterCS;
import org.eclipse.ocl.xtext.basecs.TypedTypeRefCS;
import org.eclipse.ocl.xtext.basecs.WildcardTypeRefCS;
import org.eclipse.ocl.xtext.essentialocl.serializer.EssentialOCLSemanticSequencer;
import org.eclipse.ocl.xtext.essentialoclcs.BooleanLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionPatternCS;
import org.eclipse.ocl.xtext.essentialoclcs.CollectionTypeCS;
import org.eclipse.ocl.xtext.essentialoclcs.ConstructorPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.ContextCS;
import org.eclipse.ocl.xtext.essentialoclcs.CurlyBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.IfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.IfThenExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InfixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.InvalidLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LambdaLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.LetVariableCS;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NavigatingArgCS;
import org.eclipse.ocl.xtext.essentialoclcs.NestedExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NullLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.NumberLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PatternExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.PrefixExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.RoundBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.SelfExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.SquareBracketedClauseCS;
import org.eclipse.ocl.xtext.essentialoclcs.StringLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TupleLiteralPartCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeLiteralExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.TypeNameExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.UnlimitedNaturalLiteralExpCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.VarDeclarationIdCS;
import org.eclipse.qvtd.xtext.qvtrelation.services.QVTrelationGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public abstract class AbstractQVTrelationSemanticSequencer extends EssentialOCLSemanticSequencer {

	@Inject
	private QVTrelationGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == BaseCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case BaseCSPackage.IMPORT_CS:
				if(context == grammarAccess.getUnitCSRule()) {
					sequence_UnitCS(context, (ImportCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.LIBRARY_CS:
				if(context == grammarAccess.getLibraryCSRule()) {
					sequence_LibraryCS(context, (LibraryCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.MULTIPLICITY_BOUNDS_CS:
				if(context == grammarAccess.getMultiplicityBoundsCSRule() ||
				   context == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityBoundsCS(context, (MultiplicityBoundsCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.MULTIPLICITY_STRING_CS:
				if(context == grammarAccess.getMultiplicityCSRule() ||
				   context == grammarAccess.getMultiplicityStringCSRule()) {
					sequence_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_CS:
				if(context == grammarAccess.getFirstPathElementCSRule()) {
					sequence_FirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNextPathElementCSRule()) {
					sequence_NextPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getURIFirstPathElementCSRule()) {
					sequence_URIFirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_ELEMENT_WITH_URICS:
				if(context == grammarAccess.getURIFirstPathElementCSRule()) {
					sequence_URIFirstPathElementCS(context, (PathElementWithURICS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PATH_NAME_CS:
				if(context == grammarAccess.getPathNameCSRule()) {
					sequence_PathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getURIPathNameCSRule()) {
					sequence_URIPathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PRIMITIVE_TYPE_REF_CS:
				if(context == grammarAccess.getPrimitiveTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule() ||
				   context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule()) {
					sequence_PrimitiveTypeCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_PrimitiveTypeCS_TypeExpCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(context, (PrimitiveTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TEMPLATE_BINDING_CS:
				if(context == grammarAccess.getTemplateBindingCSRule()) {
					sequence_TemplateBindingCS(context, (TemplateBindingCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS:
				if(context == grammarAccess.getTemplateParameterSubstitutionCSRule()) {
					sequence_TemplateParameterSubstitutionCS(context, (TemplateParameterSubstitutionCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TEMPLATE_SIGNATURE_CS:
				if(context == grammarAccess.getTemplateSignatureCSRule()) {
					sequence_TemplateSignatureCS(context, (TemplateSignatureCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TUPLE_PART_CS:
				if(context == grammarAccess.getTuplePartCSRule()) {
					sequence_TuplePartCS(context, (TuplePartCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TUPLE_TYPE_CS:
				if(context == grammarAccess.getTupleTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule()) {
					sequence_TupleTypeCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_TupleTypeCS_TypeExpCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TYPE_PARAMETER_CS:
				if(context == grammarAccess.getTypeParameterCSRule()) {
					sequence_TypeParameterCS(context, (TypeParameterCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.TYPED_TYPE_REF_CS:
				if(context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule() ||
				   context == grammarAccess.getTypedTypeRefCSRule()) {
					sequence_TypedTypeRefCS(context, (TypedTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.WILDCARD_TYPE_REF_CS:
				if(context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getWildcardTypeRefCSRule()) {
					sequence_WildcardTypeRefCS(context, (WildcardTypeRefCS) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == EssentialOCLCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EssentialOCLCSPackage.BOOLEAN_LITERAL_EXP_CS:
				if(context == grammarAccess.getBooleanLiteralExpCSRule() ||
				   context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_BooleanLiteralExpCS(context, (BooleanLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_LITERAL_EXP_CS:
				if(context == grammarAccess.getCollectionLiteralExpCSRule() ||
				   context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_CollectionLiteralExpCS(context, (CollectionLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_LITERAL_PART_CS:
				if(context == grammarAccess.getCollectionLiteralPartCSRule()) {
					sequence_CollectionLiteralPartCS(context, (CollectionLiteralPartCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_PATTERN_CS:
				if(context == grammarAccess.getCollectionPatternCSRule()) {
					sequence_CollectionPatternCS(context, (CollectionPatternCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionPatternCS_TypeExpCS(context, (CollectionPatternCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.COLLECTION_TYPE_CS:
				if(context == grammarAccess.getCollectionTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule() ||
				   context == grammarAccess.getTypeRefCSRule() ||
				   context == grammarAccess.getTypedRefCSRule()) {
					sequence_CollectionTypeCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_CollectionTypeCS_TypeExpCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.CONSTRUCTOR_PART_CS:
				if(context == grammarAccess.getConstructorPartCSRule()) {
					sequence_ConstructorPartCS(context, (ConstructorPartCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.CONTEXT_CS:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (ContextCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.CURLY_BRACKETED_CLAUSE_CS:
				if(context == grammarAccess.getCurlyBracketedClauseCSRule()) {
					sequence_CurlyBracketedClauseCS(context, (CurlyBracketedClauseCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.IF_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getIfExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_IfExpCS(context, (IfExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.IF_THEN_EXP_CS:
				if(context == grammarAccess.getElseIfThenExpCSRule()) {
					sequence_ElseIfThenExpCS(context, (IfThenExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.INFIX_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_ExpCS(context, (InfixExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.INVALID_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getInvalidLiteralExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_InvalidLiteralExpCS(context, (InvalidLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.LAMBDA_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getLambdaLiteralExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_LambdaLiteralExpCS(context, (LambdaLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.LET_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getLetExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedLetExpCSRule()) {
					sequence_LetExpCS(context, (LetExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.LET_VARIABLE_CS:
				if(context == grammarAccess.getLetVariableCSRule()) {
					sequence_LetVariableCS(context, (LetVariableCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NAME_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNameExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_NameExpCS(context, (NameExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NAVIGATING_ARG_CS:
				if(context == grammarAccess.getNavigatingArgCSRule()) {
					sequence_NavigatingArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingBarArgCSRule()) {
					sequence_NavigatingBarArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingCommaArgCSRule()) {
					sequence_NavigatingCommaArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingSemiArgCSRule()) {
					sequence_NavigatingSemiArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NESTED_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getNestedExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_NestedExpCS(context, (NestedExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NULL_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getNullLiteralExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_NullLiteralExpCS(context, (NullLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.NUMBER_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getNumberLiteralExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_NumberLiteralExpCS(context, (NumberLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.PATTERN_EXP_CS:
				if(context == grammarAccess.getPatternExpCSRule()) {
					sequence_PatternExpCS(context, (PatternExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.PREFIX_EXP_CS:
				if(context == grammarAccess.getPrefixedLetExpCSRule()) {
					sequence_PrefixedLetExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_PrefixedLetExpCS_PrefixedPrimaryExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule()) {
					sequence_PrefixedPrimaryExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.ROUND_BRACKETED_CLAUSE_CS:
				if(context == grammarAccess.getRoundBracketedClauseCSRule()) {
					sequence_RoundBracketedClauseCS(context, (RoundBracketedClauseCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.SELF_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getSelfExpCSRule()) {
					sequence_SelfExpCS(context, (SelfExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.SQUARE_BRACKETED_CLAUSE_CS:
				if(context == grammarAccess.getSquareBracketedClauseCSRule()) {
					sequence_SquareBracketedClauseCS(context, (SquareBracketedClauseCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.STRING_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule() ||
				   context == grammarAccess.getStringLiteralExpCSRule()) {
					sequence_StringLiteralExpCS(context, (StringLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.TUPLE_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getTupleLiteralExpCSRule()) {
					sequence_TupleLiteralExpCS(context, (TupleLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.TUPLE_LITERAL_PART_CS:
				if(context == grammarAccess.getTupleLiteralPartCSRule()) {
					sequence_TupleLiteralPartCS(context, (TupleLiteralPartCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.TYPE_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getTypeLiteralExpCSRule()) {
					sequence_TypeLiteralExpCS(context, (TypeLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.TYPE_NAME_EXP_CS:
				if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_TypeExpCS_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeNameExpCSRule()) {
					sequence_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
				   context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule() ||
				   context == grammarAccess.getUnlimitedNaturalLiteralExpCSRule()) {
					sequence_UnlimitedNaturalLiteralExpCS(context, (UnlimitedNaturalLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == QVTrelationCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case QVTrelationCSPackage.COLLECTION_TEMPLATE_CS:
				if(context == grammarAccess.getCollectionTemplateCSRule()) {
					sequence_CollectionTemplateCS(context, (CollectionTemplateCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getTemplateCSRule()) {
					sequence_CollectionTemplateCS_TemplateCS(context, (CollectionTemplateCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.DEFAULT_VALUE_CS:
				if(context == grammarAccess.getDefaultValueCSRule()) {
					sequence_DefaultValueCS(context, (DefaultValueCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.DOMAIN_CS:
				if(context == grammarAccess.getDomainCSRule()) {
					sequence_DomainCS(context, (DomainCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.DOMAIN_PATTERN_CS:
				if(context == grammarAccess.getDomainPatternCSRule()) {
					sequence_DomainPatternCS(context, (DomainPatternCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.ELEMENT_TEMPLATE_CS:
				if(context == grammarAccess.getElementTemplateCSRule()) {
					sequence_ElementTemplateCS(context, (ElementTemplateCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.KEY_DECL_CS:
				if(context == grammarAccess.getKeyDeclCSRule()) {
					sequence_KeyDeclCS(context, (KeyDeclCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.MODEL_DECL_CS:
				if(context == grammarAccess.getModelDeclCSRule()) {
					sequence_ModelDeclCS(context, (ModelDeclCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.OBJECT_TEMPLATE_CS:
				if(context == grammarAccess.getObjectTemplateCSRule()) {
					sequence_ObjectTemplateCS(context, (ObjectTemplateCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getExpCSOrTemplateCSRule() ||
				   context == grammarAccess.getTemplateCSRule()) {
					sequence_ObjectTemplateCS_TemplateCS(context, (ObjectTemplateCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.PARAM_DECLARATION_CS:
				if(context == grammarAccess.getParamDeclarationCSRule()) {
					sequence_ParamDeclarationCS(context, (ParamDeclarationCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.PATTERN_CS:
				if(context == grammarAccess.getWhenCSRule()) {
					sequence_WhenCS(context, (PatternCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getWhereCSRule()) {
					sequence_WhereCS(context, (PatternCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.PREDICATE_CS:
				if(context == grammarAccess.getPredicateCSRule()) {
					sequence_PredicateCS(context, (PredicateCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.PRIMITIVE_TYPE_DOMAIN_CS:
				if(context == grammarAccess.getPrimitiveTypeDomainCSRule()) {
					sequence_PrimitiveTypeDomainCS(context, (PrimitiveTypeDomainCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.PROPERTY_TEMPLATE_CS:
				if(context == grammarAccess.getPropertyTemplateCSRule()) {
					sequence_PropertyTemplateCS(context, (PropertyTemplateCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.QUERY_CS:
				if(context == grammarAccess.getQueryCSRule()) {
					sequence_QueryCS(context, (QueryCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.RELATION_CS:
				if(context == grammarAccess.getRelationCSRule()) {
					sequence_RelationCS(context, (RelationCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.TOP_LEVEL_CS:
				if(context == grammarAccess.getTopLevelCSRule()) {
					sequence_TopLevelCS(context, (TopLevelCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.TRANSFORMATION_CS:
				if(context == grammarAccess.getTransformationCSRule()) {
					sequence_TransformationCS(context, (TransformationCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.VAR_DECLARATION_CS:
				if(context == grammarAccess.getVarDeclarationCSRule()) {
					sequence_VarDeclarationCS(context, (VarDeclarationCS) semanticObject); 
					return; 
				}
				else break;
			case QVTrelationCSPackage.VAR_DECLARATION_ID_CS:
				if(context == grammarAccess.getVarDeclarationIdCSRule()) {
					sequence_VarDeclarationIdCS(context, (VarDeclarationIdCS) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName? 
	 *         type=CollectionTypeCS 
	 *         (
	 *             (memberIdentifiers+=TemplateCS | memberIdentifiers+=ElementTemplateCS) 
	 *             (memberIdentifiers+=TemplateCS | memberIdentifiers+=ElementTemplateCS)* 
	 *             restIdentifier=[Variable|UnrestrictedName]?
	 *         )?
	 *     )
	 */
	protected void sequence_CollectionTemplateCS(EObject context, CollectionTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName? 
	 *         type=CollectionTypeCS 
	 *         (
	 *             (memberIdentifiers+=TemplateCS | memberIdentifiers+=ElementTemplateCS) 
	 *             (memberIdentifiers+=TemplateCS | memberIdentifiers+=ElementTemplateCS)* 
	 *             restIdentifier=[Variable|UnrestrictedName]?
	 *         )? 
	 *         guardExpression=ExpCS?
	 *     )
	 */
	protected void sequence_CollectionTemplateCS_TemplateCS(EObject context, CollectionTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (propertyId=[Variable|UnrestrictedName] initialiser=ExpCS)
	 */
	protected void sequence_DefaultValueCS(EObject context, DefaultValueCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (checkonly?='checkonly' | enforce?='enforce')? 
	 *         modelId=[TypedModel|UnrestrictedName] 
	 *         pattern=DomainPatternCS 
	 *         implementedBy=ExpCS? 
	 *         defaultValues+=DefaultValueCS*
	 *     )
	 */
	protected void sequence_DomainCS(EObject context, DomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     template=TemplateCS
	 */
	protected void sequence_DomainPatternCS(EObject context, DomainPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ElementTemplateCS}
	 */
	protected void sequence_ElementTemplateCS(EObject context, ElementTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         pathName=PathNameCS 
	 *         (propertyIds+=[Property|UnrestrictedName] | oppositePropertyIds+=PathNameCS) 
	 *         (propertyIds+=[Property|UnrestrictedName] | oppositePropertyIds+=PathNameCS)*
	 *     )
	 */
	protected void sequence_KeyDeclCS(EObject context, KeyDeclCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     referredPackage=[Package|URI]
	 */
	protected void sequence_LibraryCS(EObject context, LibraryCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         (metaModelIds+=[Namespace|UnrestrictedName] | (metaModelIds+=[Namespace|UnrestrictedName] metaModelIds+=[Namespace|UnrestrictedName]*))
	 *     )
	 */
	protected void sequence_ModelDeclCS(EObject context, ModelDeclCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName? type=TypedRefCS (propertyTemplates+=PropertyTemplateCS propertyTemplates+=PropertyTemplateCS*)?)
	 */
	protected void sequence_ObjectTemplateCS(EObject context, ObjectTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName? type=TypedRefCS (propertyTemplates+=PropertyTemplateCS propertyTemplates+=PropertyTemplateCS*)? guardExpression=ExpCS?)
	 */
	protected void sequence_ObjectTemplateCS_TemplateCS(EObject context, ObjectTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypedRefCS)
	 */
	protected void sequence_ParamDeclarationCS(EObject context, ParamDeclarationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expr=ExpCS
	 */
	protected void sequence_PredicateCS(EObject context, PredicateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName type=TypedRefCS)
	 */
	protected void sequence_PrimitiveTypeDomainCS(EObject context, PrimitiveTypeDomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((propertyId=[Property|UnrestrictedName] | oppositePropertyId=PathNameCS) expression=ExpCSOrTemplateCS)
	 */
	protected void sequence_PropertyTemplateCS(EObject context, PropertyTemplateCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         (inputParamDeclarations+=ParamDeclarationCS inputParamDeclarations+=ParamDeclarationCS*)? 
	 *         ownedType=TypedRefCS 
	 *         expression=ExpCS?
	 *     )
	 */
	protected void sequence_QueryCS(EObject context, QueryCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         top?='top'? 
	 *         name=UnrestrictedName 
	 *         overrides=[Relation|UnrestrictedName]? 
	 *         varDeclarations+=VarDeclarationCS* 
	 *         (domains+=DomainCS | domains+=PrimitiveTypeDomainCS)+ 
	 *         when=WhenCS? 
	 *         where=WhereCS?
	 *     )
	 */
	protected void sequence_RelationCS(EObject context, RelationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((ownedImports+=UnitCS | ownedLibraries+=LibraryCS)* transformations+=TransformationCS*)
	 */
	protected void sequence_TopLevelCS(EObject context, TopLevelCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         modelDecls+=ModelDeclCS 
	 *         modelDecls+=ModelDeclCS* 
	 *         (extends+=[Transformation|UnrestrictedName] extends+=[Transformation|UnrestrictedName]*)? 
	 *         keyDecls+=KeyDeclCS* 
	 *         (relation+=RelationCS | queries+=QueryCS)*
	 *     )
	 */
	protected void sequence_TransformationCS(EObject context, TransformationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedPathName=PathNameCS
	 */
	protected void sequence_TypedTypeRefCS(EObject context, TypedTypeRefCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName? ownedPathName=URIPathNameCS isAll?='*'?)
	 */
	protected void sequence_UnitCS(EObject context, ImportCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (varDeclarationIds+=VarDeclarationIdCS varDeclarationIds+=VarDeclarationIdCS* type=TypedRefCS)
	 */
	protected void sequence_VarDeclarationCS(EObject context, VarDeclarationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=UnrestrictedName
	 */
	protected void sequence_VarDeclarationIdCS(EObject context, VarDeclarationIdCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (predicates+=PredicateCS*)
	 */
	protected void sequence_WhenCS(EObject context, PatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (predicates+=PredicateCS*)
	 */
	protected void sequence_WhereCS(EObject context, PatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
