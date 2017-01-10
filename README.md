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

<br/>
###컴퓨터의 역사

- 진공관
- 트랜지스터
- 집적회로(IC)

<br/>

###컴퓨터의 구성

- 하드웨어

  입출력장치, 출력장치, 기억장치, 연산장치, 제어장치
  
- 소프트웨어

  시스템 소프트웨어, 응용소프트웨어
  

###컴퓨터 구조
##### 폰 노이만 구조
명령어와 데이터가 동일한 물리 메모리에 저장되어 있고 CPU로 명령어와 데이터를 동일한 인터페이스로 받아들인다.  (명령어와 데이터를 특별히 구분하지 않는다.)


##### 하버드 구조
명령어와 데이터 메모리가 다른 물리 공간에 저장되어 있고 CPU의 제어부로 명령어가 전달되고 연산부쪽으로 데이터가 전달된다.(명령어와 데이터가 명확히 구분된다.) 

#### 데이터의 표현
- 정수
- 실수
- 문자


#### 논리연산
- AND
- OR
- NOT
- XOR
- NOR
- NAND


   
