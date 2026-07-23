import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        experiment1();
        experiment2();
    }

    public static void experiment2() {
        System.out.println("안녕하세요");

        PrintStream originalOut = System.out;   //모니터

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();   //배열
        PrintStream printStream = new PrintStream(outputStream);    //배열로 가는 통로

        System.setOut(printStream); //목적지를 배열로

        System.out.print("하하하");  //콘솔에 출력x

        String outStr = outputStream.toString();    //배열에 저장된 값 저장
        System.setOut(originalOut); //원래 모니터로 돌리기
        printStream.close();

        if(outStr.equals("하하하")) {
            System.out.println("출력 결과가 일치합니다.");
        } else {
            System.out.println("출력 결과가 일치하지 않습니다.");
        }

        System.out.println(outStr);


    }

    public static void experiment1() {

        String input = """
                등록
                너 자신을 알라
                """;
        Scanner sc = new Scanner(input);
        String cmd = sc.nextLine();
        String saying = sc.nextLine();
        System.out.println("입력한 명령어: " + cmd);
        System.out.println("입력한 명언: " + saying);

    }

}