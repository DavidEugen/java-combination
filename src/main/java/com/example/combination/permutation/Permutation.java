package com.example.combination.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    static int n, r, totalCnt;    // 전역변수 n(숫자 전체 개수), r(택하는 수), 카운트 갯수 선언
    static int[] nums;            // 뽑은 숫자들을 저장할 배열
    static int[] inputArr;        // 전체 숫자가 저장된 배열
    static boolean[] isSelect;    // 뽑현던 숫자를 다시 뽑지 않게 하기 위한 숫자 체크

    public static void main(String[] args) {
        System.out.println("n과 r을 입력하세요 (ex=>4 2)");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        totalCnt = 0;

        nums = new int[r];  // 택하는 숫자만큼 배열 생성 (뽑은 숫자를 저장할 배열)
        isSelect = new boolean[n+1]; // 숫자체크 배열 생성
        inputArr = new int[n]; // 사용자가 입력하여 저장할 수 배열

        // 전체 숫자가 저장된 배열에 값 입력
        for(int i = 0; i < n; i++) {
            inputArr[i] = sc.nextInt();
        }

        permutation(0);
        System.out.println("순열의 총 경우의 수 = " + totalCnt);
    }


    public static void permutation(int cnt) {
        // 카운트 숫자를 매개변수로 주어 뽑으려는 수까지 cnt를 세게되면 메서드 종료
        if(cnt == r) {
            totalCnt++;
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 시도하는 수가 선택되었는지 판단한다.
            if(isSelect[i]) continue;
            // 체크되어 있지 않았다면(선택되지않은 수) 뽑으려는 배열에 값 저장
            nums[cnt] = inputArr[i];
            isSelect[i] = true; // 숫자를 뽑았다면 true (체크됨)
            permutation(cnt+1); // 다음 숫자 뽑으러 가기
            isSelect[i] = false; // 사용한 수를 다시 되돌림
        }
    }
}
