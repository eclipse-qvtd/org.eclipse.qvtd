The Buckminster build automatically promotes downloads and updates, so no cron job help is necessary.

The updates can be checked by looking for the new entry on http://www.eclipse.org/mmt/downloads/?project=qvtd
or installing new software from e.g. http://download.eclipse.org/mmt/qvtd/updates/milestones/1.0.0/S201408191819

However operations on composite repositories are not automated, partly because they are sufficiently important to deserve manual attention. 

A new milestone build can be added to the composite repository by:

logon to build.eclipse.org
cd downloads/mmt/qvtd/updates/milestones/1.0.0
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=S201408191819 -Dcomposite.name="QVTd 1.0.0 milestones"

(This can be checked by installing new software from e.g. http://download.eclipse.org/mmt/qvtd/updates/milestones/1.0.0)

The Neon aggregator is configured by GIT\org.eclipse.simrel.build\qvtd.b3aggrcon to use an explicit milestone entry

So edit qvtd.b3aggrcon to update 
location="http://download.eclipse.org/mmt/qvtd/updates/milestones/1.0.0/S201408191819"
push to upstream master and start a new build at https://hudson.eclipse.org/hudson/job/simrel.neon.runaggregator/

Once a release has been promoted update qvtd.b3aggrcon to the final release
location="http://download.eclipse.org/mmt/qvtd/updates/releases/1.0.0"

After each first repo contribution, remember to update the aggregates e.g.
cd downloads/mmt/qvtd/updates/milestones
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=1.0.0

--------

GIT repo: git://git.eclipse.org/gitroot/mmt/org.eclipse.qvtd.git

Poll SCM schedule: 0 */6 * * *

Run XVNC during build

Pre Buckminster shell:

# window manager for UI tests
icewm --replace --sm-disable &

chmod +x ${WORKSPACE}/org.eclipse.qvtd.git/releng/org.eclipse.qvtd.releng.buckminster/scripts/qvtd-pre-buckminster.sh
${WORKSPACE}/org.eclipse.qvtd.git/releng/org.eclipse.qvtd.releng.buckminster/scripts/qvtd-pre-buckminster.sh
# NB: This script contains some shell commands which prepare the build.properties file used by buckminster.
# It will be called before buckminster commands execution. You may check its content at the following URL:
# https://hudson.eclipse.org/ocl/job/qvtd-oxygen-master/ws/org.eclipse.qvtd.git/releng/org.eclipse.qvtd.releng.buckminster/scripts/qvtd-pre-buckminster.sh/*view*/

Buckminster job (4.5):

${WORKSPACE}/org.eclipse.qvtd.git/releng/org.eclipse.qvtd.releng.buckminster/scripts/qvtd-buckminster.script

Advanced change workspace: ${WORKSPACE}/buildroot/buckminster.workspace

Advanced JVM arguments:

-Dcheckout.location=${WORKSPACE}
-Dreference.repository=https://hudson.eclipse.org/ocl/job/${JOB_NAME}/lastSuccessfulBuild/artifact/QVTd.p2.repository/
-Xmx2g
-noverify

Post Buckminster shell:

chmod +x ${WORKSPACE}/org.eclipse.qvtd.git/releng/org.eclipse.qvtd.releng.buckminster/scripts/qvtd-post-buckminster.sh
${WORKSPACE}/org.eclipse.qvtd.git/releng/org.eclipse.qvtd.releng.buckminster/scripts/qvtd-post-buckminster.sh
# NB: This script contains some shell commands which will be extecuted prior to archive artifacts.
# It will be called after buckminster commands execution. You may check its content at the following URL:
# https://hudson.eclipse.org/ocl/job/qvtd-oxygen-master/ws/org.eclipse.qvtd.git/releng/org.eclipse.qvtd.releng.buckminster/scripts/qvtd-post-buckminster.sh/*view*/

Publish JUnit test report: QVTd.test.results/**

Archive the artefacts: QVTd.*/**, publishroot/**, promote.properties