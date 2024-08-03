import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class function {
    public static void q1() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a String:");
        String a = input.nextLine();
        StringBuilder input1 = new StringBuilder();
        input1.append(a);
        input1.reverse();
        if (a.contentEquals(input1)) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not a Palindrome");
        }
    }

    public static void q2(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a String:");
        String a = input.nextLine();
        Pattern pattren=Pattern.compile("([a-zA-Z]+\\d+|[a-zA-Z]+|[a-zA-Z]+.[a-zA-Z]+)@gmail.com");
        Matcher matcher=pattren.matcher(a);
        boolean b=matcher.matches();
        if(b){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
        }
    }

    public static void q3(){
        LocalDate today= LocalDate.now();
        System.out.println(today);
        System.out.println("New Format:");
        System.out.println(today.format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));
    }

    public static void q4(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Date(YYYY-MM-dd):");
        String a = input.nextLine();
        Pattern pattern=Pattern.compile("(\\d{4}-\\d{2}-\\d{2})");
        Matcher matcher=pattern.matcher(a);
        boolean b=matcher.matches();
        if(b){
            LocalDate date = LocalDate.parse(a);
            date = date.plusDays(30);
            System.out.println("New Date After 30 Days:");
            System.out.println(date.format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));
        }
        else{
            System.out.println("Invalid Date");
        }
    }

    public static void q5(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        String str = input.nextLine();
        int mInt = Integer.parseInt(str);
        String[] rnChars = { "M",  "CM", "D", "C",  "XC", "L",  "X", "IX", "V", "I" };
        int[] rnVals = {1000, 900, 500, 100, 90, 50, 10, 9, 5, 1 };
        String retVal = "";
        for (int i = 0; i < rnVals.length; i++) {
            int num = mInt / rnVals[i];
            if (num == 0) continue;
            retVal += (num == 4 && i > 0)? rnChars[i] + rnChars[i - 1]: rnChars[i];
            mInt = mInt % rnVals[i];
        }
        System.out.println("roman number = "+retVal);
    }

    public static void q6(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter brackets:");
        String str = input.nextLine();
        String regex = "\\(\\)|\\{}|\\[\\]";
        Pattern pattern = Pattern.compile(regex);
        String tempStr = str;
        while (pattern.matcher(tempStr).find()) {
            tempStr = tempStr.replaceAll(regex, "");
        }
        if (tempStr.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    public static void q7(){
        String[] strArr = {"dog", "racecar", "car"};
        if (strArr.length == 0) {
            System.out.println("String array is empty");
        } else if (strArr.length == 1) {
            System.out.println("Longest Common Prefix: " + strArr[0]);
        } else {
            String firstStr = strArr[0];
            for (int i = 1; i < strArr.length; i++) {
                String currStr = strArr[i];
                int j = 0;
                while (j < currStr.length() && j < firstStr.length() &&
                        currStr.charAt(j) == firstStr.charAt(j)) {
                    j++;
                }
                if (j == 0) {
                    System.out.println(" ");
                    return;
                }
                firstStr = firstStr.substring(0, j);
            }
            System.out.println("Longest Common Prefix: " + firstStr);
        }
    }

    public  static void q8(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = input.nextLine();
        boolean[] seen = new boolean[26];
        StringBuilder newStr = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!seen[ch - 'a']) {
                seen[ch - 'a'] = true;
                newStr.append(ch);
            }
        }
        char[] arr = newStr.toString().toCharArray();
        Arrays.sort(arr);
        String result = String.valueOf(arr);
        System.out.println("Result: " + result);
    }
}
