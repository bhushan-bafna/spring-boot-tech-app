#GIT Refernce Links

PAT(Peronal Access Token)

Process to generate PAT - https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token

------------------------------------------------------------------------------------------------------------------------------------
How to store my Git personal access token?
https://stackoverflow.com/questions/46645843/where-to-store-my-git-personal-access-token

Since a PAT can be used in place of a password when performing Git operations over HTTPS with Git on the command line or the API, you can use a git credential helper to cache it securely.
 On Windows, for instance, that would use the Windows Credential Manager, through the GCM -- Git Credential Manager -- for Windows, Mac or Linux:

	git config --global credential.helper manager-core
	 #Git 2.39+
	git config --global credential.helper manager
------------------------------------------------------------------------------------------------------------------------------------

How to remove cached credentials from Git?
https://stackoverflow.com/questions/44246876/how-to-remove-cached-credentials-from-git

Run the following command in the terminal to remove your credentials stored in the cache

	git config --global --unset credential.helper
------------------------------------------------------------------------------------------------------------------------------------


How do I resolve git saying "Commit your changes or stash them before you can merge"?
https://stackoverflow.com/questions/15745045/how-do-i-resolve-git-saying-commit-your-changes-or-stash-them-before-you-can-me


How Git works:
https://stackoverflow.com/questions/2745076/what-are-the-differences-between-git-commit-and-git-push/72992628#72992628

------------------------------------------------------------------------------------------------------------------------------------
code commit steps
 - [git status] (add ignore files in case if required)
 - [git add <file-name>] -> to add single file  OR  - [git add .] -> to add all the files
 - [git commit -m 'commit msg']
 - [git push]
