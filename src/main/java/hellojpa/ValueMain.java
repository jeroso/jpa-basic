package hellojpa;

public class ValueMain {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println("a == b: " + (a == b));

        Address address1 = new Address("city", "street", "10000");
        Address address2 = new Address("city", "street", "10000");

        System.out.println(address1 == address2);
        //기본 equals의 비교는 == 그래서 equals / hashcode 를 override 해서 사용 해야 함.
        System.out.println(address1.equals(address2));

    }
}
