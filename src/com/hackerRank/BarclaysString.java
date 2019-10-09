package hackerRank;

public class BarclaysString {
    public static void main(String args[]){
        String a = "1234 a+bcd";
        String b = "2568 abc-d";
        String c = "9806 ab+cd";
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
    }

    public static int solution(String s) {
        int output = -1;
        char op = 0;
        int opLocation=0;
        String data[] = s.split(" ");
        String numbers = data[0];
        String equation = data[1];
        for(int i = 0; i < equation.length(); i++){
            char curr = equation.charAt(i);
            if(curr == '+' || curr == '-' || curr == '/' || curr == '*'){
                op = curr;
                opLocation = i;
                break;
            }
        }
        StringBuilder firstNumberString = new StringBuilder();
        for(int i = 0; i < opLocation; i++){
            firstNumberString.append(numbers.charAt(i));
        }
        int firstNumber = Integer.parseInt(firstNumberString.toString());
        int secondNumber = Integer.parseInt(numbers.substring(opLocation));
        switch (op){
            case '+':
                output = firstNumber + secondNumber;
                break;
            case '-':
                output = firstNumber - secondNumber;
                break;
            case '*':
                output = firstNumber * secondNumber;
                break;
            case '/':
                output = firstNumber / secondNumber;
                break;
            default:
               System.out.println("operation unavailable");

        }

        return output;
    }
}
