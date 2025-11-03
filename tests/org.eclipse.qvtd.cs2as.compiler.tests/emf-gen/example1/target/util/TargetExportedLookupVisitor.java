/*******************************************************************************
 * «codeGenHelper.getCopyright(' * ')»
 *
 * This code is 100% auto-generated
 * using: org.eclipse.ocl.examples.autogen.lookup.LookupExportedVisitorCodeGenerator
 *
 * Do not edit it.
 ********************************************************************************/

package example1.target.util;

import example1.target.TargetPackage;
import example1.target.lookup.EnvironmentPackage;
import example1.target.lookup.LookupEnvironment;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;

public class TargetExportedLookupVisitor
extends AbstractTargetCommonLookupVisitor
{
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/env/1.0", "lookup", EnvironmentPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_LookupEnvironment = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_env_s_1_0.getClassId("LookupEnvironment", 0);
	public static final /*@NonInvalid*/ @NonNull RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ @NonNull NsURIPackageId PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0 = IdManager.getNsURIPackageId("http://cs2as/tests/example1/targetMM/1.0", "target", TargetPackage.eINSTANCE);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_Executor = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("Executor", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_IdResolver = PACKid_http_c_s_s_cs2as_s_tests_s_example1_s_targetMM_s_1_0.getClassId("IdResolver", 0);
	public static final /*@NonInvalid*/ @NonNull ClassId CLSSid_OclElement = PACKid_$metamodel$.getClassId("OclElement", 0);

	protected final /*@Thrown*/ @NonNull Executor executor;
	protected final /*@Thrown*/ @NonNull IdResolver idResolver;
	protected final /*@Thrown*/ @NonNull Object importer_0;

	public TargetExportedLookupVisitor(@NonNull LookupEnvironment context, @NonNull Object importer) {
		super(context);
		this.executor = ClassUtil.requireNonNull(context.getExecutor());
		this.idResolver = executor.getIdResolver();
		this.importer_0 = importer;
	}

	@Override
	protected @Nullable LookupEnvironment doVisiting(@NonNull Visitable visitable) {
		return context;
	}
}
