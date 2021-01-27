package mypackage;



public class TestClass {


    public static void main(String[] args) {


        String s = "Hello,World";

        System.out.println();
        String[] array = s.split(",");
        System.out.println(array[0] + " !" + array[1] + "!");

        System.out.println(array[0]);
        System.out.println(array[1]);

        String str = "My name is %s! I'm %d years old!";
        int age = 30;
        String name = "Ivan";
        System.out.println(String.format(str, name, age));
        System.out.println(String.format(str, "Vasja", 10));

        System.out.println();
        String age2 = "10";
        int a = Integer.parseInt(age2);
        System.out.println(a*3);

        s = "Hello, world!";
        System.out.println(s.substring(7));
        System.out.println(s.substring(7, s.length()- 2));

        String s1 = "Hello ";
        String s2 = "world";
        String s3 = "!";
        String res;
        res= s1+s2+s3;
        System.out.println(res);
        res= s1.concat(s2).concat(s3);
        System.out.println(res);

    }

}
