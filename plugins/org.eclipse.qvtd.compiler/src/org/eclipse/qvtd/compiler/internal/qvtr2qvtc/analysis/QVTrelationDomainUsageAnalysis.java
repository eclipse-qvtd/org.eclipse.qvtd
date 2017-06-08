package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

/**
 * A QVTrelationDomainUsageAnalysis identifies a constrained domain result from the DomainUsageAnalysis of a QVTr AST node.
 */
public class QVTrelationDomainUsageAnalysis extends RootDomainUsageAnalysis implements QVTrelationVisitor<@NonNull DomainUsage>
{
	public QVTrelationDomainUsageAnalysis(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @NonNull DomainUsage visitCollectionTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull CollectionTemplateExp object) {
		for (@NonNull OCLExpression member : QVTrelationUtil.getOwnedMembers(object)) {
			visit(member);
		}
		Variable rest = object.getRest();
		if (rest != null) {
			visit(rest);
		}
		return visitTemplateExp(object);
	}

	@Override
	public @NonNull DomainUsage visitDomainPattern(@NonNull DomainPattern object) {
		DomainUsage usage = getUsage(QVTrelationUtil.getTypedModel(QVTrelationUtil.getContainingDomain(object)));
		setUsage(object, usage);
		visit(QVTrelationUtil.getOwnedTemplateExpression(object));
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitKey(@NonNull Key object) {
		return getUsage(QVTrelationUtil.getIdentifies(object));
	}

	@Override
	public @NonNull DomainUsage visitObjectTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull ObjectTemplateExp object) {
		DomainUsage usage = visitTemplateExp(object);
		for (@NonNull PropertyTemplateItem part : QVTrelationUtil.getOwnedParts(object)) {
			visit(part);
		}
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitPattern(@NonNull Pattern object) {
		DomainUsage domainUsage = getDomainUsage(object);
		for (@NonNull Predicate predicate : QVTrelationUtil.getOwnedPredicates(object)) {
			visit(predicate);
		}
		return domainUsage;
	}

	@Override
	public @NonNull DomainUsage visitPropertyTemplateItem(org.eclipse.qvtd.pivot.qvttemplate.@NonNull PropertyTemplateItem object) {
		DomainUsage usage = visit(QVTrelationUtil.getReferredProperty(object));
		visit(QVTrelationUtil.getOwnedValue(object));
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitRelation(@NonNull Relation object) {
		DomainUsage usage = getRootAnalysis().getNoneUsage();
		setUsage(object, usage);
		for (@NonNull Domain domain : QVTrelationUtil.getOwnedDomains(object)) {
			visit(domain);
		}
		Pattern when = object.getWhen();
		if (when != null) {
			visit(when);
		}
		Pattern where = object.getWhere();
		if (where != null) {
			visit(where);
		}
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitRelationCallExp(@NonNull RelationCallExp object) {
		int i = 0;
		for (@NonNull OCLExpression argument : QVTrelationUtil.getOwnedArguments(object)) {
			if (argument instanceof VariableExp) {
				RelationDomain relationDomain = QVTrelationUtil.getRelationCallExpArgumentDomain(object, i);
				DomainUsage usage = getUsage(QVTrelationUtil.getTypedModel(relationDomain));
				setUsage(QVTrelationUtil.getReferredVariable((VariableExp)argument), usage);
			}
			visit(argument);
			i++;
		}
		return getRootAnalysis().getPrimitiveUsage();
	}

	@Override
	public @NonNull DomainUsage visitRelationDomain(@NonNull RelationDomain object) {
		DomainUsage usage = visit(object.getTypedModel());
		setUsage(object, usage);
		for (@NonNull DomainPattern domainPattern : QVTrelationUtil.getOwnedPatterns(object)) {
			visit(domainPattern);
		}
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitRelationDomainAssignment(@NonNull RelationDomainAssignment object) {
		return visitElement(object);	// FIXME
	}

	@Override
	public @NonNull DomainUsage visitRelationImplementation(@NonNull RelationImplementation object) {
		return visitElement(object);	// FIXME
	}

	@Override
	public @NonNull DomainUsage visitRelationModel(@NonNull RelationModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @NonNull DomainUsage visitRelationalTransformation(@NonNull RelationalTransformation object) {
		DomainUsage usage = getRootAnalysis().getNoneUsage();
		setUsage(object, usage);
		//
		//	Ensure all operations are analyzed even if not used.
		//
		for (Operation operation : object.getOwnedOperations()) {
			if (operation != null) {
				DomainUsageAnalysis operationAnalysis = getRootAnalysis().analyzeOperation(operation);
				setUsage(operation, operationAnalysis.getUsage(operation));
			}
		}
		for (@NonNull Key key : QVTrelationUtil.getOwnedKey(object)) {
			visit(key);
		}
		for (@NonNull Relation relation : QVTrelationUtil.getOwnedRelations(object)) {
			visit(relation);
		}
		visitTransformation(object);
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitSharedVariable(@NonNull SharedVariable object) {
		OCLExpression ownedInit = object.getOwnedInit();
		if (ownedInit != null) {
			visit(ownedInit);
		}
		return visitVariable(object);
	}

	@Override
	public @NonNull DomainUsage visitTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull TemplateExp object) {
		DomainUsage usage = getUsage(QVTrelationUtil.getTypedModel(QVTrelationUtil.getContainingDomain(object)));
		setUsage(object, usage);
		Variable bindsTo = QVTrelationUtil.getBindsTo(object);
		DomainUsage oldUsage = basicGetUsage(bindsTo);
		if (oldUsage != null) {
			usage = union(usage, oldUsage);
		}
		setUsage(QVTrelationUtil.getBindsTo(object), usage);
		OCLExpression where = object.getWhere();
		if (where != null) {
			visit(where);
		}
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitTemplateVariable(@NonNull TemplateVariable object) {
		return visitVariable(object);
	}
}
