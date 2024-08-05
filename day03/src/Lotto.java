//숫자 5개 입력시, 자동적으로 5개 랜덤 번호 생성
//1~40숫자중
//매 게임마다 당첨 금액 random
//등수1~4등

import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // 입력을 위한 스캐너

        System.out.println("안녕하십니까 로또게임입니다..");


        int[] lotto = new int[5]; //랜덤한 로또번호 생성 위한 변수
        int[] myLotto = new int[5];//내가 입력한 로또번호 index
        int[] money = new int[5];//무작위
        int count = 0; //맞춘개수를 알기 위한 count

        for (int i = 0; i < lotto.length; i++) { //다섯번 반복
            lotto[i] = (int) (Math.random() * 10) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) { //중복방지
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(i + 1 + "번쨰 로또 번호 입력 : ");
            myLotto[i] = scan.nextInt();
            if (myLotto[i] < 1 || myLotto[i] > 40) {
                System.out.println("로또번호는 1에서 40까지 입니다.");
                i--;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (myLotto[i] == myLotto[j]) {
                    System.out.println(" 로또번호는 중복될수 없습니다.");
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < myLotto.length; j++) {
                if (lotto[i] == myLotto[j]) {
                    count++;
                }
            }
        }
        int totalPrize = (int) (Math.random() * 201) + 100; // 100억 ~ 300억 사이의 금액 (단위: 억)
        int firstPrize = totalPrize * 75 / 100;
        int secondPrize = totalPrize * 24 / 100;
        int thirdPrize = totalPrize * 1 / 100;

        System.out.printf("이번주 로또번호 추첨: [%d] [%d] [%d] [%d] [%d] 입니다.\n",
                lotto[0], lotto[1], lotto[2], lotto[3], lotto[4]);
        System.out.printf("총 상금은 %d억 원입니다.\n", totalPrize);
        System.out.printf("로또번호 " + count + "개를 맞추셨습니다.\n");

        switch (count) {
            case 5:
                System.out.printf("1등 당첨!! %d억 원 축하드립니다~^^\n", firstPrize);
                break;
            case 4:
                System.out.printf("2등 당첨!! %d억 원 축하드립니다~^^\n", secondPrize);
                break;
            case 3:
                System.out.printf("3등 당첨!! %d억 원 축하드립니다~^^\n", thirdPrize);
                break;
            default:
                System.out.println("이번주는 꽝입니다...");
                break;
        }
    }
}