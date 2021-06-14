package com.company;

import com.company.exceptions.EmptyStackException;
import com.company.resources.Stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(2);

        try {
            //Insere alguns elementos na pilha
            stack.BlackPush("BLACK1");
            stack.RedPush("RED1");
            stack.RedPush("RED2");
            stack.BlackPush("BLACK2");
            stack.BlackPush("BLACK3");

            //Imprime a pilha
            stack.PrintArray();

            //Remove um elemento vermelho da pilha
            stack.RedPop();

            //Imprime a pilha
            stack.PrintArray();

            //Remove um elemento preto da pilha
            stack.BlackPop();

            //Imprime a pilha
            stack.PrintArray();

            //Remove dois elementos pretos da pilha, deixando a pilha preta vazia
            stack.BlackPop();
            stack.BlackPop();

            //Imprime a pilha
            stack.PrintArray();

            //Tenta remover um elemento preto da pilha, porem, será lançada uma exceção pois a pilha preta está vazia
            stack.BlackPop();
        } catch (EmptyStackException error) {
            System.out.println(error);
        }

        try {
            //Insere um elemento na pilha preta
            stack.BlackPush("BLACK4");

            //Imprime a pilha
            stack.PrintArray();
        } catch (EmptyStackException error) {
            System.out.println(error);
        }
    }
}
