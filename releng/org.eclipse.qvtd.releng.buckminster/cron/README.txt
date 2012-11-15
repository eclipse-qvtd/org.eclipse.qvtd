The crontab.txt file contains the commands that must be daily executed (via cron) to promote our last successful build.

(Alternatively a single promotion can be done by just pasting the ant command to the build.eclipse.org console.)

This is a release engineer task. To configure that:
1. Connect to build.eclipse.org via an ssh connection.
2. Create a "logs" folder in your home directory (if you haven't done it, yet).
3. Type "crontab -e" and copy-paste the contents of the aforementioned file.

A new milestone build may be explitly promoted by:

logon to build.eclipse.org
ant -f /shared/jobs/buckminster-mmt-qvtd-kepler/lastSuccessful/archive/publishroot/publisher.ant -Dbuild.archives=/shared/jobs/buckminster-mmt-qvtd-kepler/lastSuccessful/archive &> logs/mmt-qvtd-publishing-kepler.log 

A new milestone build can be added to the composite repository by:

logon to build.eclipse.org
cd downloads/mmt/qvtd/updates/milestones/0.10.0
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=S201210020848

[Not yet on Simultaneous Release -- The Kepler aggregator is configured by GIT\org.eclipse.simrel.build\mmt-qvtd.b3aggrcon to use the milestones repo
so no further action is needed there.]