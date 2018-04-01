package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ColLesson04 {
    public static void main(String[] args) {
        ArrayList<Word> words = new ArrayList<>();

        System.out.println("わからなかった単語とその意味をスペースで区切って入力してください。");
        Scanner sc =new Scanner(System.in);
        String input =sc.nextLine();

        int index = 0;
        while(!input.equals("e")){
            String[] tmp = input.split(" ");
            Word wd = new Word(tmp[0],tmp[1]);
            words.add(wd);
            index++;
            System.out.println("次の単語と意味を入力してください。'e'で終了します。");
            input = sc.nextLine();
        }
        for(int i=0;i<index;i++){
            System.out.println(words.get(i));
        }
        System.out.println(words.size() +"件、登録しました。");
    }
}
