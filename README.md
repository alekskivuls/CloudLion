Cloud Lion IDE
==============
### Vision ###
For software developers on the move and for groups that need uniform workspaces, CloudLion is a cloud based IDE that provides a fully featured collaborative development environment that gives access any time, anywhere, on any device with minimal setup. Unlike other cloud IDEs, our product gives users full control and source access of the cloud software letting users run it from their own servers with ease and allowing modifications to the IDE's code.

### Development Setup ###
Clone the repository locally.
Download Spring Tool Suite https://spring.io/tools
Run Spring Tool Suite and select a workspace.
Once in eclipse, go to File > Import > Maven > Existing Maven Projects
Click next. Click browse and go to local repository location.
Then click advanced and enter the project name in the Name Template.
Select pom.xml and click finish.

### Localhost Server ###
To run the project on localhost:8080 select the project and select run as: Spring boot app. You should see in the console the server starting and when its fully setup.

### Workflow ###
There is a master and develop branch and zero to many feature branches. If you are adding a new feature make a new feature branch by `git checkout -b BRANCH_NAME_HERE` This will make a new branch and check it out to your workspace. 
If you want to switch branches to an already existing branch use `git checkout BRANCH_NAME_HERE`. Then when you are done with your feature merge back into develop then once your code is tested and approved by someone else merge it into master. 
For more info on git commands get the documentation https://git-scm.com/doc or run git help <command name> in git bash to get to the man page for that command.

### Builds ###
Currently every time you make a commit to Github the project is built at cloudlion.alekskivuls.me:8080.

### Production ###
Broken - Every time you commit to the master branch the project will be built and pushed to cloudlion.alekskivuls.me