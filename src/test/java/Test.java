/**
 * author xiumj
 * create 2018-08-13 16:22
 * desc 测试
 */
public class Test {

    public void test() {
        int i = 1;
        int j = 2;
        if ((i = j) == 3) {
            System.out.println("in if i = " + i);
        } else {
            System.out.println("in else i = " + i);
        }
    }

    public static void raise(int i) {
        i++;
    }

    public static void swap(String str1, String str2) {
        String swap = str1;
        str1 = str2;
        str2 = swap;
    }

    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "b";
        System.out.println("方法执行之前：a = " + str1 + ", b = "+str2);
        swap(str1,str2);
        System.out.println("方法执行之前：a = " + str1 + ", b = "+str2);
    }
}
