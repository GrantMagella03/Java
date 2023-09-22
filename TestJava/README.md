# Readme for PrsTestServer

The PrsTestServer supports testing you Java project.

Prior to executing the test: 

In the SQL folder, there is a script
that will clear your tables and put the testing data in the database.
Just run the script from the Workbench.

To execute the test:

1) Press Win-R.
2) Type cmd in the textbox and press enter
3) Change directory to where the files have been extracted.
4) At the command prompt: TestPrsServer --lang java --port 8080

If all tests pass, you're done!