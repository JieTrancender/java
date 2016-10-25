package cn.imust.library.java;

public class Test {
    public static void main(String[] args) {
//        System.out.println(Outer.Inner.m_static_field);
//        Outer.Inner.staticMethod();
        Outer.Inner inner = new Outer.Inner();
        inner.staticMethod();
        inner.nonStaticMethod();
    }
}

class Example08 {
    private int m_width;
    private int m_height;
    private boolean m_level_flag;
    private boolean m_vertical_flag;

    public Example08(int line_num) {
        m_width = m_height = line_num;
        m_level_flag = m_vertical_flag = false;
    }

    public Example08(int width, int height) {
        m_width = width;
        m_height = height;
        m_level_flag = m_vertical_flag = false;
    }

    public Example08(int width, int height, boolean level_flag, boolean vertical_flag) {
        m_width = width;
        m_height = height;
        m_level_flag = level_flag;
        m_vertical_flag = vertical_flag;
    }

    public void printGraph() {
        if (m_level_flag) {
            if (m_vertical_flag) {
                printRightUp();
            } else {
                printRightDown();
            }
        } else {
            if (m_vertical_flag) {
                printLeftUp();
            } else {
                printLeftDown();
            }
        }
    }

    private final void printOneLine(int space_num, int star_num) {
        for (int i = 0; i < space_num; ++i) {
            System.out.print(' ');
        }
        for (int i = 0; i < star_num; ++i) {
            System.out.print('*');
        }
        System.out.println(" ");
    }

    private final void printLeftUp() {
        int width = m_width;
        for (int i = 0; i < m_height; ++i) {
            printOneLine(0, --width);
        }
    }

    private final void printLeftDown() {
        int width = 0;
        for (int i = 0; i < m_height; ++i) {
            printOneLine(0, ++width);
        }
    }

    private final void printRightUp() {
        int width = m_width;
        for (int i = 0; i < m_height; ++i) {
            printOneLine(m_width - width, width--);
        }
    }

    private final void printRightDown() {
        int width = 0;
        for (int i = 0; i < m_height; ++i) {
            printOneLine(m_width - width - 1, ++width);
        }
    }
}

class Example09 {
    private char m_symbol;
    private int m_num_a;
    private int m_num_b;
    private String m_result;

    public Example09(int num_a, char symbol, int num_b) {
        m_num_a = num_a;
        m_num_b = num_b;
        m_symbol = symbol;
    }

    public String getResult() {
        calculateResult();
        return m_result;
    }

    private void calculateResult() {
        switch (m_symbol) {
            case '+':
                m_result = Integer.toString(m_num_a + m_num_b);
                break;
            case '-':
                m_result = Integer.toString(m_num_a - m_num_b);
                break;
            case '*':
                m_result = Integer.toString(m_num_a * m_num_b);
                break;
            case '/':
                if (0 == m_num_b)
                    m_result = "The value of third argument is invalid";
                else {
                    m_result = Integer.toString(m_num_a / m_num_b);
                }
                break;
            default:
                m_result = "The value of second argument is invalid";
        }
    }
}

class Example10 {
    private int m_row;
    private char m_symbol;

    public Example10() {
        m_row = 9;
        m_symbol = '+';
    }

    public Example10(char symbol) {
        m_row = 9;
        m_symbol = symbol;
    }

    public Example10(int row, char symbol) {
        m_row = row;
        m_symbol = symbol;
    }

    public void printTable() {
        for (int i = 1; i <= m_row; ++i) {
            for (int j = 1; j <= i; ++j) {
                if (i != j)
                    printCalculateMode(i, j, true);
                else
                    printCalculateMode(i, j, false);
            }
            System.out.println("");
        }
    }

    private final void printCalculateMode(int i, int j, boolean flag) {
        switch (m_symbol) {
            case '+':
                if (flag)
                    System.out.print(j + " " + m_symbol + " " + i + " = " + (j + i) + ' ');
                else
                    System.out.print(j + " " + m_symbol + " " + i + " = " + (j + i));
                break;
            case '-':
                if (flag)
                    System.out.print(j + " " + m_symbol + " " + i + " = " + (j - i) + ' ');
                else
                    System.out.print(j + " " + m_symbol + " " + i + " = " + (j - i));
                break;
            case '*':
                if (flag)
                    System.out.print(j + " " + m_symbol + " " + i + " = " + (j * i) + ' ');
                else
                    System.out.print(j + " " + m_symbol + " " + i + " = " + (j * i));
                break;
            case '/':
                if (flag)
                    System.out.print(j + " " + m_symbol + " " + i + " = " + (j / i) + ' ');
                else
                    System.out.print(j + " " + m_symbol + " " + i + " = " + (j / i));
                break;
        }
    }
}

class Example11 {
    private int[] m_array;

    public Example11(int[] array) {
        if (null == array) {
            System.out.println("The value of argument is invalid.");
            m_array = null;
            return;
        }
        int length = array.length;
        m_array = new int[length];
        System.arraycopy(array, 0, m_array, 0, length);
    }

    public void printArray() {
        for (int i = 0; i < m_array.length; ++i) {
            System.out.print(m_array[i]);
            if (i != m_array.length - 1) {
                System.out.print(',');
            }
        }
        System.out.println("");
    }

    public int getMinValue() {
        int min = m_array[0];
        for (int i = 1; i < m_array.length; ++i) {
            if (m_array[i] < min) {
                min = m_array[i];
            }
        }
        return min;
    }

    public void selectionSort() {
        for (int i = 0; i < m_array.length - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < m_array.length; ++j) {
                if (m_array[index] > m_array[j]) {
                    index = j;
                }
            }
            if (i != index) {
                int temp = m_array[index];
                m_array[index] = m_array[i];
                m_array[i] = temp;
            }
        }
    }
}

class Student {
    private String m_name;
    private int m_age;
    public static String m_class_name = "三年级二班";

    public Student() {
//        System.out.println("Now, In Student()");
        m_name = "";
        m_age = 0;
    }

    public Student(String name) {
        this();
//        System.out.println("Now, In Student(String name)");
        m_name = name;
        m_age = 0;
    }

    public Student(String name, int age) {
        this(name);
//        System.out.println("Now, In Student(String name, int age)");
        m_name = name;
        m_age = age;
    }

    public void speak() {
        System.out.println("The name is " + m_name + ", and age is " + m_age);
    }

    public void setName(String name) {
        m_name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age >= 200) {
            System.out.println("The value of argument is invalid.");
            return;
        }
        m_age = age;
    }

    public String getName() {
        return m_name;
    }

    public String getClassName() {
        return m_class_name;
    }

    public int getAge() {
        return m_age;
    }

    public void finalize() {
        System.out.println("Now, In finalize");
    }
}

class Example210 {

    public static void methodOne() {
        System.out.println("Now, in static method one.");
        //methodFour();
        methodTwo();
    }

    public static void methodTwo() {
        System.out.println("Now, in static method onw.");
    }

    public void methodThree() {
        System.out.println("Now, in non-static method three.");
        methodOne();
        //methodFour();
    }

    public void methodFour() {
        System.out.println("Now, in non-static method four.");
    }
}

class Example211{
    static {
        System.out.println("This is a static code block in Example211.");
    }

    {
        System.out.println("This is a construct code block in Example211.");
    }

    public Example211() {
        System.out.println("This is constructor in Example211.");
    }

    public void localBlock() {
        {
            System.out.println("This is a part code block in Example211.");
        }
    }
}

class Singleton {
    private static Singleton m_single = null;

    private Singleton() {
        System.out.println("This is private constructor in Singleton.");
    }

    //非线程安全
    public static Singleton getInstanceOne() {
        if (null == m_single) {
            m_single = new Singleton();
        }
        return m_single;
    }

    //同步锁实现，线程安全
    public static synchronized Singleton getInstanceTwo() {
        if (null == m_single) {
            m_single = new Singleton();
        }
        return m_single;
    }

    //双重检查锁定，垃圾设计
    public static Singleton getInstanceThree() {
        if (null == m_single) {
            synchronized (Singleton.class) {
                if (null == m_single) {
                    m_single = new Singleton();
                }
            }
        }
        return m_single;
    }

    //静态内部类,线程安全
    private static class InnerClass {
        private static final Singleton m_instance = new Singleton();
    }

    public static final Singleton getInstanceFour() {
        return InnerClass.m_instance;
    }

    //类初始化方式 - 饿汉式
    private static final Singleton m_single_test = new Singleton();
    public static Singleton getInstanceFive() {
        return m_single_test;
    }
}

class Outer {
    public static class Inner {
        public static String m_static_field = "静态内部类的静态变量";
        public String m_nonstatic_field = "静态内部类的非静态变量";

        public static void staticMethod() {
            System.out.println("静态内部类的静态方法。");
        }

        public void nonStaticMethod() {
            System.out.println("静态内部类的非静态方法。");
        }
    }
}