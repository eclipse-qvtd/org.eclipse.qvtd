package org.eclipse.qvtd.xtext.qvtimperative.serializer;

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
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.serializer.QVTcoreBaseSemanticSequencer;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperative.services.QVTimperativeGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public abstract class AbstractQVTimperativeSemanticSequencer extends QVTcoreBaseSemanticSequencer {

	@Inject
	private QVTimperativeGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == BaseCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case BaseCSPackage.IMPORT_CS:
				if(context == grammarAccess.getImportCSRule()) {
					sequence_ImportCS(context, (ImportCS) semanticObject); 
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
				else if(context == grammarAccess.getScopeNameCSRule()) {
					sequence_ScopeNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getURIPathNameCSRule()) {
					sequence_URIPathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else break;
			case BaseCSPackage.PRIMITIVE_TYPE_REF_CS:
				if(context == grammarAccess.getPrimitiveTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule()) {
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
				   context == grammarAccess.getTypeLiteralCSRule()) {
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
				   context == grammarAccess.getNavigatingArgExpCSRule()) {
					sequence_ExpCS(context, (InfixExpCS) semanticObject); 
					return; 
				}
				else break;
			case EssentialOCLCSPackage.INVALID_LITERAL_EXP_CS:
				if(context == grammarAccess.getExpCSRule() ||
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
			case EssentialOCLCSPackage.VARIABLE_CS:
				if(context == grammarAccess.getMappingIteratorCSRule()) {
					sequence_MappingIteratorCS(context, (VariableCS) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == QVTcoreBaseCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case QVTcoreBaseCSPackage.ASSIGNMENT_CS:
				if(context == grammarAccess.getAssignmentCSRule()) {
					sequence_AssignmentCS(context, (AssignmentCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS:
				if(context == grammarAccess.getBottomPatternCSRule()) {
					sequence_BottomPatternCS(context, (BottomPatternCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMiddleBottomPatternCSRule()) {
					sequence_MiddleBottomPatternCS(context, (BottomPatternCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSourceBottomPatternCSRule()) {
					sequence_SourceBottomPatternCS(context, (BottomPatternCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTargetBottomPatternCSRule()) {
					sequence_TargetBottomPatternCS(context, (BottomPatternCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.DIRECTION_CS:
				if(context == grammarAccess.getDirectionCSRule()) {
					sequence_DirectionCS(context, (DirectionCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.DOMAIN_CS:
				if(context == grammarAccess.getMiddleDomainCSRule()) {
					sequence_MiddleDomainCS(context, (DomainCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNamedDomainCSRule()) {
					sequence_NamedDomainCS(context, (DomainCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSourceDomainCSRule()) {
					sequence_SourceDomainCS(context, (DomainCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTargetDomainCSRule()) {
					sequence_TargetDomainCS(context, (DomainCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnnamedDomainCSRule()) {
					sequence_UnnamedDomainCS(context, (DomainCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.GUARD_PATTERN_CS:
				if(context == grammarAccess.getGuardPatternCSRule()) {
					sequence_GuardPatternCS(context, (GuardPatternCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getMiddleGuardPatternCSRule()) {
					sequence_MiddleGuardPatternCS(context, (GuardPatternCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSourceGuardPatternCSRule()) {
					sequence_SourceGuardPatternCS(context, (GuardPatternCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTargetGuardPatternCSRule()) {
					sequence_TargetGuardPatternCS(context, (GuardPatternCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.PARAM_DECLARATION_CS:
				if(context == grammarAccess.getParamDeclarationCSRule()) {
					sequence_ParamDeclarationCS(context, (ParamDeclarationCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.QUERY_CS:
				if(context == grammarAccess.getQueryCSRule()) {
					sequence_QueryCS(context, (QueryCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.REALIZED_VARIABLE_CS:
				if(context == grammarAccess.getRealizedVariableCSRule()) {
					sequence_RealizedVariableCS(context, (RealizedVariableCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.TRANSFORMATION_CS:
				if(context == grammarAccess.getTransformationCSRule()) {
					sequence_TransformationCS(context, (TransformationCS) semanticObject); 
					return; 
				}
				else break;
			case QVTcoreBaseCSPackage.UNREALIZED_VARIABLE_CS:
				if(context == grammarAccess.getUnrealizedVariableCSRule()) {
					sequence_UnrealizedVariableCS(context, (UnrealizedVariableCS) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == QVTimperativeCSPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case QVTimperativeCSPackage.MAPPING_CS:
				if(context == grammarAccess.getMappingCSRule()) {
					sequence_MappingCS(context, (MappingCS) semanticObject); 
					return; 
				}
				else break;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS:
				if(context == grammarAccess.getMappingCallBindingCSRule()) {
					sequence_MappingCallBindingCS(context, (MappingCallBindingCS) semanticObject); 
					return; 
				}
				else break;
			case QVTimperativeCSPackage.MAPPING_CALL_CS:
				if(context == grammarAccess.getMappingCallCSRule() ||
				   context == grammarAccess.getMappingStatementCSRule()) {
					sequence_MappingCallCS(context, (MappingCallCS) semanticObject); 
					return; 
				}
				else break;
			case QVTimperativeCSPackage.MAPPING_LOOP_CS:
				if(context == grammarAccess.getMappingLoopCSRule() ||
				   context == grammarAccess.getMappingStatementCSRule()) {
					sequence_MappingLoopCS(context, (MappingLoopCS) semanticObject); 
					return; 
				}
				else break;
			case QVTimperativeCSPackage.MAPPING_SEQUENCE_CS:
				if(context == grammarAccess.getMappingSequenceCSRule()) {
					sequence_MappingSequenceCS(context, (MappingSequenceCS) semanticObject); 
					return; 
				}
				else break;
			case QVTimperativeCSPackage.TOP_LEVEL_CS:
				if(context == grammarAccess.getTopLevelCSRule()) {
					sequence_TopLevelCS(context, (TopLevelCS) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         (imports+=[Package|UnrestrictedName] imports+=[Package|UnrestrictedName]*)? 
	 *         (uses+=[CoreDomain|UnrestrictedName] uses+=[CoreDomain|UnrestrictedName]*)?
	 *     )
	 */
	protected void sequence_DirectionCS(EObject context, DirectionCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=UnrestrictedName 
	 *         in=[Transformation|UnrestrictedName]? 
	 *         (domains+=SourceDomainCS | domains+=TargetDomainCS)* 
	 *         middle=MiddleDomainCS? 
	 *         mappingSequence=MappingSequenceCS?
	 *     )
	 */
	protected void sequence_MappingCS(EObject context, MappingCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (referredVariable=[Variable|UnrestrictedName] value=ExpCS)
	 */
	protected void sequence_MappingCallBindingCS(EObject context, MappingCallBindingCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (referredMapping=[Mapping|UnrestrictedName] bindings+=MappingCallBindingCS*)
	 */
	protected void sequence_MappingCallCS(EObject context, MappingCallCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS?)
	 */
	protected void sequence_MappingIteratorCS(EObject context, VariableCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedIterator=MappingIteratorCS inExpression=ExpCS mappingSequence=MappingSequenceCS)
	 */
	protected void sequence_MappingLoopCS(EObject context, MappingLoopCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     mappingStatements+=MappingStatementCS+
	 */
	protected void sequence_MappingSequenceCS(EObject context, MappingSequenceCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (constraints+=AssignmentCS*)
	 */
	protected void sequence_MiddleBottomPatternCS(EObject context, BottomPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (guardPattern=MiddleGuardPatternCS bottomPattern=MiddleBottomPatternCS)
	 */
	protected void sequence_MiddleDomainCS(EObject context, DomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (constraints+=AssignmentCS*)
	 */
	protected void sequence_MiddleGuardPatternCS(EObject context, GuardPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {BottomPatternCS}
	 */
	protected void sequence_SourceBottomPatternCS(EObject context, BottomPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (check?='check' direction=[TypedModel|UnrestrictedName] guardPattern=SourceGuardPatternCS bottomPattern=SourceBottomPatternCS)
	 */
	protected void sequence_SourceDomainCS(EObject context, DomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((unrealizedVariables+=UnrealizedVariableCS unrealizedVariables+=UnrealizedVariableCS*)?)
	 */
	protected void sequence_SourceGuardPatternCS(EObject context, GuardPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (unrealizedVariables+=UnrealizedVariableCS | realizedVariables+=RealizedVariableCS) 
	 *             (unrealizedVariables+=UnrealizedVariableCS | realizedVariables+=RealizedVariableCS)*
	 *         )?
	 *     )
	 */
	protected void sequence_TargetBottomPatternCS(EObject context, BottomPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (enforce?='enforce' direction=[TypedModel|UnrestrictedName] guardPattern=TargetGuardPatternCS bottomPattern=TargetBottomPatternCS)
	 */
	protected void sequence_TargetDomainCS(EObject context, DomainCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((unrealizedVariables+=UnrealizedVariableCS unrealizedVariables+=UnrealizedVariableCS*)?)
	 */
	protected void sequence_TargetGuardPatternCS(EObject context, GuardPatternCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((ownedImports+=ImportCS | ownedLibraries+=LibraryCS)* (transformations+=TransformationCS | mappings+=MappingCS | queries+=QueryCS)*)
	 */
	protected void sequence_TopLevelCS(EObject context, TopLevelCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
