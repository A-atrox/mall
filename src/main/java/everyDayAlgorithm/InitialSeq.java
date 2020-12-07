package everyDayAlgorithm;

/**
 * @author guoyf
 * @date 2020/12/3 17:04
 */
public class InitialSeq {
    private static String str1 = "100qaq";
    private Long l1;
    static{
        System.out.println(str1);
    }
    {
        System.out.println(l1);
    }
    InitialSeq(int marker){
        System.out.println("InitialSeq: "+marker);
    }
    void f1(int marker){
        System.out.println("f1: "+marker);
    }
}
