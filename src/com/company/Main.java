package com.company;

import com.company.resources.Stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(2);

        stack.BlackPush(10);
        stack.RedPush(1);
        stack.RedPush(2);
        stack.BlackPush(9);
        stack.BlackPush(8);

        stack.PrintArray();

        stack.RedPop();

        stack.PrintArray();

        stack.BlackPop();

        stack.PrintArray();

        stack.BlackPop();
        stack.BlackPop();

        stack.PrintArray();

        stack.BlackPop();

        stack.BlackPush(11);

        stack.PrintArray();
    }
}
