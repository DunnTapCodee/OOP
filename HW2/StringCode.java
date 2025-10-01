import static java.lang.Math.max;

public class StringCode {
    public String blowup(String str){
        StringBuilder res = new StringBuilder();
        boolean intergerNumber = false;
        int Number = str.charAt(0) - '0';
        int length = str.length();
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') intergerNumber = true;
        if (!intergerNumber) res.append(str.charAt(0));
        for (int i = 1; i < length; i++) {
            if (intergerNumber && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                Number = str.charAt(i) - '0';
                intergerNumber = true;
                res.append(str.charAt(i));
            }
            else if (intergerNumber && (str.charAt(i) < '0' || str.charAt(i) > '9')) {
                for (int j = 0; j < Number; j++) {
                    res.append(str.charAt(i));
                }
                res.append(str.charAt(i));
                intergerNumber = false;
            }
            else if (!intergerNumber && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                Number = str.charAt(i) - '0';
                intergerNumber = true;
            }
            else if (!intergerNumber && (str.charAt(i) < '0' || str.charAt(i) > '9')){
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public int maxRun(String str){
        int count = 1;
        int max_= 1;
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) == str.charAt(i-1)) count++;
            else{
                max_ = max(max_, count);
                count = 1;
            }
        }
        max_ = max(max_, count);
        return  max_;
    }

    public boolean stringIntersect(String a, String b, int len){
        for (int i = 0 ; i <= a.length() - len; i++)
        {
            String sub = a.substring(i, i + len);
            if (b.contains(sub)) return true;
        }
        return false;
    }

    public static void main(String[] args){
        StringCode test = new StringCode();
        String s = "a3tx2z";
        System.out.println(test.blowup(s));
        String s2 = "abasdasjdaaadhhhhhadddddd";
        System.out.println(test.maxRun(s2));
        System.out.println(test.stringIntersect("abce", "xyd", 1));
    }
}
