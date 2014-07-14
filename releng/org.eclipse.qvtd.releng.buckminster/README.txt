The Buckminster build automatically promotes downloads and updates, so no cron job help is necessary.

The updates can be checked by looking for the new entry on http://www.eclipse.org/mmt/downloads/?project=qvtd
or installing new software from e.g. http://download.eclipse.org/mmt/qvtd/updates/milestones/0.12.0/S201311111636

However operations on composite repositories are not automated, partly because they are sufficiently important to deserve manual attention. 

A new milestone build can be added to the composite repository by:

logon to build.eclipse.org
cd downloads/mmt/qvtd/updates/milestones/0.12.0
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=S201210020848

(This can be checked by installing new software from e.g. http://download.eclipse.org/mmt/qvtd/updates/milestones/0.12.0)

##The Luna aggregator is configured by GIT\org.eclipse.simrel.build\mdt-ocl.b3aggrcon to use an explicit milestone entry

##So edit mdt-ocl.b3aggrcon to update 
##location="http://download.eclipse.org/modeling/mdt/ocl/updates/milestones/4.2.0/S201311111636"
##push to upstream master and start a new build at https://hudson.eclipse.org/hudson/job/simrel.luna.runaggregator/