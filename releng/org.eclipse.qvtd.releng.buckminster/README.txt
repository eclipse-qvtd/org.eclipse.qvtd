The Buckminster build automatically promotes downloads and updates, so no cron job help is necessary.

The updates can be checked by looking for the new entry on http://www.eclipse.org/mmt/downloads/?project=qvtd
or installing new software from e.g. http://download.eclipse.org/mmt/qvtd/updates/milestones/0.13.0/S201408191819

However operations on composite repositories are not automated, partly because they are sufficiently important to deserve manual attention. 

A new milestone build can be added to the composite repository by:

logon to build.eclipse.org
cd downloads/mmt/qvtd/updates/milestones/0.13.0
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=S201408191819 -Dcomposite.name="QVTd 0.13.0 milestones"

(This can be checked by installing new software from e.g. http://download.eclipse.org/mmt/qvtd/updates/milestones/0.13.0)

The Neon aggregator is configured by GIT\org.eclipse.simrel.build\qvtd.b3aggrcon to use an explicit milestone entry

So edit qvtd.b3aggrcon to update 
location="http://download.eclipse.org/mmt/qvtd/updates/milestones/0.13.0/S201408191819"
push to upstream master and start a new build at https://hudson.eclipse.org/hudson/job/simrel.neon.runaggregator/

Once a release has been promoted update qvtd.b3aggrcon to the final release
location="http://download.eclipse.org/mmt/qvtd/updates/releases/0.13.0"

After each first repo contribution, remember to update the aggregates e.g.
cd downloads/mmt/qvtd/updates/milestones
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=0.13.0

