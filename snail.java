package com.venture;

import java.util.InputMismatchException;
import java.util.Scanner;

public class snail {
    public static void main(String[] args){
    	// 달팽이의 차수 입력 
    	Scanner scan = new Scanner(System.in);
    	int size;
    	while(true){
	    	System.out.print("달팽이의 차수를 입력하세요 : ");
	    	try{
	    		size = scan.nextInt();
	    		break;
	    	}catch(InputMismatchException e){
	    		System.out.println("숫자만 입력해야 합니다.");
	    	}
    	}
    	scan.close();
    	
    	// 동작중에 size는 계속 감소하므로 차수를 저장 
    	int printSize=size;
    	
    	// 시작 좌표는 0,1이다.
        int row=0, col=-1;
        
        // 시작시에 진행방향은 +이다.
        int sign=1;
        
        // 배열의 선언 
        int snail[][]= new int[size][size];
        
        // 배열에 입력되는 값 
        int numData=1;
       
        while(true){
        	// x축의 방향 
        	for(int cnt=0;cnt<size;cnt++){
        		col=col+sign;
        		snail[row][col]=numData++;
        	}
        	// size를 감소시켜준다.
        	size=size-1;
        	if(size==0)
        	break;   
        	
        	// y축의 방향 
        	for(int cnt=0;cnt<size;cnt++){
        		row=row+sign;
        		snail[row][col]=numData++;
        	}
        	// 증감값의 부호를 바꿔준다. 
        	sign=sign*(-1);
        }
        
        //출력
        for(row=0;row<printSize;row++){
            for(col=0;col<printSize;col++){
                System.out.printf("%3d",snail[row][col]);
            }
            System.out.println();
        }
    }
}
