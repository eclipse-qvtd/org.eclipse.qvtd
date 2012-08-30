The crontab.txt file contains the commands that must be daily executed (via cron) to promote our last successful build.

This is a release engineer task. To configure that:
1. Connect to build.eclipse.org via an ssh connection.
2. Create a "logs" folder in your home directory (if you haven't done it, yet).
3. Type "crontab -e" and copy-paste the contents of the aforementioned file.