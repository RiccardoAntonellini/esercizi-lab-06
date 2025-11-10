# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
   git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test cartella
      Cloning into 'cartella'...
      remote: Enumerating objects: 12, done.
      remote: Counting objects: 100% (4/4), done.
      remote: Compressing objects: 100% (3/3), done.
      remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8 (from 1)
      Receiving objects: 100% (12/12), done.
      Resolving deltas: 100% (2/2), done.

2. Ci si assicuri di avere localmente entrambi i branch remoti

   git remote -v
      origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
      origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.git (push)

   git fetch origin
      From https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test
      * [new branch]      feature    -> origin/feature
      * [new branch]      master     -> origin/master

   git branch -a
      * master
      remotes/origin/HEAD -> origin/master
      remotes/origin/feature
      remotes/origin/master

   git checkout -b feature origin/feature
      branch 'feature' set up to track 'origin/feature'.
      Switched to a new branch 'feature'

   git branch
      * feature
      master

   git checkout master
      Switched to branch 'master'

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

   git merge feature
      Auto-merging HelloWorld.java
      CONFLICT (content): Merge conflict in HelloWorld.java
      Automatic merge failed; fix conflicts and then commit the result.

4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

   // MODIFICA DEL FILE .java CON IL CONFLITTO

   git status
      On branch master
      You have unmerged paths.
      (fix conflicts and run "git commit")
      (use "git merge --abort" to abort the merge)

      Unmerged paths:
      (use "git add <file>..." to mark resolution)
            both modified:   HelloWorld.java

      no changes added to commit (use "git add" and/or "git commit -a")

6. Si crei un nuovo repository nel proprio github personale
   //creato

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
   git remote remove origin

   git remote add origin https://github.com/RiccardoAntonellini/esercizio-6.1-lab-06.git

8. Si faccia push del branch `master` sul proprio repository
   git push origin master
      Enumerating objects: 15, done.
      Counting objects: 100% (15/15), done.
      Delta compression using up to 16 threads
      Compressing objects: 100% (11/11), done.
      Writing objects: 100% (15/15), 1.56 KiB | 398.00 KiB/s, done.
      Total 15 (delta 4), reused 10 (delta 2), pack-reused 0 (from 0)
      remote: Resolving deltas: 100% (4/4), done.
      To https://github.com/RiccardoAntonellini/esercizio-6.1-lab-06.git
      * [new branch]      master -> master

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
    git push -u origin master
      branch 'master' set up to track 'origin/master'.
      Everything up-to-date

   git branch -vv
      feature bed943f Print author information
      * master  9b1d2b4 [origin/master] corretto merge helloworld
