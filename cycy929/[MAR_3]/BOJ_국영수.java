package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0314_국영수 {
    static class Student {
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();
            studentList.add(new Student(name, kor, eng, math));
        }

        // 람다식 활용한 정렬
        studentList.sort((s1, s2) -> 
            s1.kor != s2.kor ? Integer.compare(s2.kor, s1.kor) : // 국어 내림차순
            s1.eng != s2.eng ? Integer.compare(s1.eng, s2.eng) : // 영어 오름차순
            s1.math != s2.math ? Integer.compare(s2.math, s1.math) : // 수학 내림차순
            s1.name.compareTo(s2.name) // 이름 사전순
        );

        StringBuilder sb = new StringBuilder();
        for (Student student : studentList) {
            sb.append(student.name).append('\n');
        }

        System.out.println(sb);
    }
}
