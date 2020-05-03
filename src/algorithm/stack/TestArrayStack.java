package algorithm.stack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description:
 * @Author: VictorDan
 * @Date: 20-5-3 下午7:04
 * @Version: 1.0
 */
public class TestArrayStack {
    public static void main(String[] args) {
        //测试ArrayStack
        //1、先创建一个ArrayStack对象表示栈
        ArrayStack stack = new ArrayStack(5);
        String key = "";
        //控制是否退出菜单
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：表示入栈");
            System.out.println("pop：表示出栈");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    try {
                        stack.show();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.printf("出站的数据是%d\n", pop);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}

/**
 * 定义一个ArrayStack表示栈
 */
class ArrayStack {
    //栈的大小
    private int maxSize;
    //数组，模拟栈，数据就放在该数据中
    private int[] stack;
    //top表示栈顶，初始化为-1
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
        } else {
            top++;
            stack[top] = value;
        }
    }

    //出栈
    public int pop() {
        //先判断栈是否空
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        } else {
            int data = stack[top];
            top--;
            return data;
        }
    }

    //遍历栈,遍历时，需要从栈顶开始显示数据
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i,stack[i]);
        }
    }
}
