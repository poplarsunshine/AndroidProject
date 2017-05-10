import java.io.*;

public class EmployeeTest{
  public static void main(String[] args) {
    /* 使用构造器创建两个对象 */
    Employee empOne = new Employee("HLJ Android Developer 1");
    Employee empTwo = new Employee("HLJ Android Developer 2");

    // 调用这两个对象的成员方法
    empOne.empAge(25);
    empOne.empDesignation("高级程序员");
    empOne.empSalary(10000);
    empOne.printEmployee();

    empTwo.empAge(20);
    empTwo.empDesignation("程序员");
    empTwo.empSalary(1000);
    empTwo.printEmployee();

    double PI = 3.1415926;
    float f = 3.1415f;
    int pi = (int) PI;
    long l = 1002L;
    byte a = 127;
    byte b = -128;
    char c = 'A';
    int decimal = 100;
    int octal = 0144;
    int hexa = 0x64;
    char cu = '\u0001';
    // String su = "\u0001";

    System.out.println("PI=" + PI);
    System.out.println("pi=" + pi);
    System.out.printf("f=%.3f\n", f);
    System.out.println("l=" + l);
    System.out.println("a=" + a);
    System.out.println("b=" + b);
    System.out.println("c=" + c);
    System.out.println("decimal=" + decimal);
    System.out.println("octal=" + octal);
    System.out.println("hexa=" + hexa);
    System.out.println("cu=" + cu + "=");
    // System.out.println("su=" + su + "=");

    boolean result = empOne instanceof Employee;
    System.out.println("result=" + result);
  }
}
