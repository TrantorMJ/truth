/**
 * author xiumj
 * create 2018-08-13 16:22
 * desc 测试
 */
public class Test {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        if ((i = j) == 3) {
            System.out.println("in if i = " + i);
        } else {
            System.out.println("in else i = " + i);
        }
    }
}
