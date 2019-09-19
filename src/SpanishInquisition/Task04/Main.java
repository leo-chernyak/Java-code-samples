package SpanishInquisition.Task04;

public class Main {
    public static void main(String[] args) {
        String test2 = "max(max(5,min(1,0)),min(10,15))";
        System.out.println(calculate(test2));
    }

    private static int calculate(String str) {
        if ( frequency(str, '(') == 0 )
            return Integer.parseInt(str);

        String res = str;

        if ( frequency(res, '(') > 1 ) {
            int first = str.indexOf('(');
            int second = str.indexOf(',', findLastNeed(str));

            String lhs = str.substring(first + 1,second);
            String rhs = str.substring(second + 1, str.lastIndexOf(')'));

            res = "";
            res += str.substring(0, first);
            res += "(";
            res += calculate(lhs);
            res += ",";
            res += calculate(rhs);
            res += ")";
        }

        int lhs = Integer.parseInt(res.substring(res.indexOf('(')+1, res.indexOf(',')));
        int rhs = Integer.parseInt(res.substring(res.indexOf(',')+1, res.lastIndexOf(')')));

        if (res.contains("min"))
            return Math.min(lhs, rhs);
        else if (res.contains("max"))
            return Math.max(lhs,rhs);
        else
            throw new IllegalArgumentException();
    }

    private static int frequency(String string, char ch) {
        int count = 0;
        for (char c : string.toCharArray()) {
            if ( c == ch ) {
                count++;
            }
        }
        return count;
    }

    private static int findLastNeed(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (count == 1 && ch == ',')
                return count;
            if ( ch == '(' )
                count++;
            else if ( ch == ')' ) {
                count--;
                if (count == 1)
                    return i;
            }
        }
        return string.length();
    }
}
