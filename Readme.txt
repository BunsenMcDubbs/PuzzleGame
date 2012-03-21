Setup:

1)Download this: http://db.tt/tE3SUOcG and extract (if at school, you have to use IE and save
it to the local disk on the desktop.

2)Open Github\PortableGit\git-bash.vbs

3)In the prompt, enter "git gui".  The GUI will pop up.

4)Go to Help -> Show SSH Key.  Hit Generate Key.  If it asks for a
passcode, just leave that empty.

5)Now make your account on Github.com.  Once that's done, on github.com,
go to account settings in the top right.  Go to SSH Keys, click Add SSH Key,
title it whatever, and copy and paste the key from the computer into the box on github.com.

6)Now close Git and open SmartGit.  In setup, make sure to choose Non-commercial use only,
point the Git Executable to *wherever*\Github\PortableGit\bin\git.exe, use
SmartGit as SSH client, use GitHub as your main hosting provider, type in your
login, and the SmartGit will open.

7)In the Welcome to SmartGit window, choose Clone Existing Repository.  In the
first box, type in git@github.com:quickgiant/Puzzle-Project.git, and hit next.
Since we already generated a key, it should show up automatically.  If not, it should
be somewhere in your home folder in *YourName*\.ssh\id_rsa (At school, its at H:\\.ssh . 
Again, leave the passcode blank. Choose a place to sync the code, open in a new project,
and finish.

8)Now it should sync.  After it's done, you can import it into Eclipse using
File -> Import... and use General -> Existing Projects into Workspace.

9)Yay!  It's all set up now!  When you want to commit any changes, go into SmartGit, 
click Commit, choose what you want to upload, write a comment, and hit Commit & Push.