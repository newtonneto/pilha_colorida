package com.company.resources;

import com.company.exceptions.EmptyStackException;
import com.company.interfaces.IStack;

public class Stack implements IStack {
    private int capacity;
    private int quantityControllerRed;
    private int quantityControllerBlack;
    private Object[] arrayStack;

    public Stack(int capacity) {
        this.quantityControllerRed = 0;
        this.quantityControllerBlack = 0;
        this.capacity = capacity;
        this.arrayStack = new Object[capacity];
    }

    public void RedPush (Object element) {
        if ((this.quantityControllerBlack + this.quantityControllerRed) >= this.capacity) {
            this.Realloc();
        }

        this.arrayStack[this.quantityControllerRed] = element;
        this.quantityControllerRed++;
    }

    public void BlackPush (Object element) {
        if ((this.quantityControllerBlack + this.quantityControllerRed) >= this.capacity) {
            this.Realloc();
        }

        int index = (this.capacity - 1) - this.quantityControllerBlack;
        this.arrayStack[index] = element;
        this.quantityControllerBlack++;
    }

    public Object RedPop () throws EmptyStackException {
        if (quantityControllerRed == 0) {
            throw new EmptyStackException("Red stack is empty");
        }

        Object element = this.arrayStack[quantityControllerRed - 1];
        this.arrayStack[quantityControllerRed - 1] = null;
        this.quantityControllerRed--;

        return element;
    }

    public Object BlackPop () throws EmptyStackException {
        if (quantityControllerBlack == 0) {
            throw new EmptyStackException("Black stack is empty");
        }

        int index = (this.capacity) - this.quantityControllerBlack;
        Object element = this.arrayStack[index];
        this.arrayStack[index] = null;
        this.quantityControllerBlack--;

        return element;
    }

    public void Realloc () {
        Object[] newArrayStack = new Object[this.capacity * 2];

        for (int index = 0; index < this.quantityControllerRed; index++) {
            newArrayStack[index] = this.arrayStack[index];
        }

        int pointerArray = this.capacity - 1;
        int pointerNewArray = (this.capacity * 2) - 1;
        for (int index = 0; index < this.quantityControllerBlack ; index++) {
            newArrayStack[pointerNewArray - index] = this.arrayStack[pointerArray - index];
        }

        this.arrayStack = newArrayStack;
        this.capacity = this.capacity * 2;
    }

    public void PrintArray () {
        for (int index = 0; index <= this.capacity - 1; index++) {
            if (this.arrayStack[index] == null) {
                System.out.print(" - ");
            } else {
                System.out.print(" " + this.arrayStack[index] + " ");
            }
        }

        System.out.println("\n");
    }
}
