package com.company.interfaces;

import com.company.exceptions.EmptyStackException;

public interface IStack {
    public void RedPush(Object o);
    public void BlackPush(Object o);
    public Object RedPop() throws EmptyStackException;
    public Object BlackPop() throws EmptyStackException;
    public void PrintArray();
}
