package com.company;

import java.util.Scanner;

public class ColLesson01{
    public static void main(String[] args){
        Word[] words = new Word[10];

        System.out.println("わからなかった単語とその意味をスペースで区切って入力してください。");
        Scanner br = new Scanner(System.in);
        String input = br.nextLine();

        int index=0;
        while (!input.equals("e")){
            String[] tmp = new String[2];
            tmp = input.split(" ");
            try {
                Word wd = new Word(tmp[0], tmp[1]);
                words[index] = wd;
                index++;
            }catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("登録できなかったようなので、もう一度入力お願いいたします。");
            }
            System.out.println("次の単語と意味を入力してください。'e'で終了します。");
            input = br.nextLine();
        }

        for (int j =1; j < index; j++) {
            System.out.println("単語:" + words[j].getWord() + "意味:" + words[j].getMeaning());
        }

        System.out.println( index  + "件、登録しました。");
    }
}