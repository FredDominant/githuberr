#!/bin/sh
#
# To skip running tests, run the --no-verify argument.
#       i.e   git commit --no-verify
#
## Run checkstyle to check the code quality.

echo "Running style checks..."

./gradlew app:checkstyle --daemon

#store last check result in a variable

checkResult=$?

#perform style check
if [ $checkResult -ne 0 ]
then
    echo "Code violations were found. Fix them to proceed with commit"
    exit 1
fi


echo "Running Lint checks..."

./gradlew app:lint --daemon

#store last check result in a variable

lintResult=$?

#perform lint check
if [ lintResult -ne 0 ]
then
    echo "Code violations were found. Fix them to proceed with commit"
    exit 1
fi


echo "Running PMD checks..."

./gradlew app:pmd --daemon

#store last check result in a variable

pmdResults=$?

#perform pmd check
if [ pmdResults -ne 0 ]
then
    echo "Code violations were found. Fix them to proceed with commit"
    exit 1
fi


echo "Running FindBugs checks..."

./gradlew app:findbugs --daemon

#store last check result in a variable

findBugsResult=$?

#perform findBug check
if [ findBugsResult -ne 0 ]
then
    echo "Code violations were found. Fix them to proceed with commit"
    exit 1
fi

#safe to commit
exit 0


