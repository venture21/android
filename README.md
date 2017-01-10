#git 터미널에서 작업하기

\> git init
README.md파일 생성후

\> git status

```
On branch master

Initial commit

Untracked files:
  (use "git add <file>..." to include in what will be committed)
	README.md

nothing added to commit but untracked files present (use "git add" to track)
```

\> git add README.md


\> git commit


위의 명령을 실행하면 vi 창이 뜨며 제목과 변경된 내용의 comment를 적고 저장후 종료하면 아래와 같은 메세지가 나타난다.

```
[master (root-commit) 3e883dd] 첫번째 커밋 제목입니다. -------- 첫번째 커밋 --------
 1 file changed, 2 insertions(+)
 create mode 100644 README.md
```

github에서 create repository를 한 후에

\> git remote add origin https://github.com/venture21/second_git

\> git push -u origin master

```
Username for 'https://github.com': venture21
Password for 'https://venture21@github.com': 
Counting objects: 7, done.
Delta compression using up to 8 threads.
Compressing objects: 100% (3/3), done.
Writing objects: 100% (7/7), 641 bytes | 0 bytes/s, done.
Total 7 (delta 0), reused 0 (delta 0)
To https://github.com/venture21/second_git
 * [new branch]      master -> master
Branch master set up to track remote branch master from origin.
```

github의 id와 password를 입력한후에(로그인) push작업이 진행된다.


github에서 clone으로 소스를 받아오기
\> git clone https://github.com/venture21/second_git

\> git remote -v

```
origin	https://github.com/venture21/second_git (fetch)

origin	https://github.com/venture21/second_git (push)
```