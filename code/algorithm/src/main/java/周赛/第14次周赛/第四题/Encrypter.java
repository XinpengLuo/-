package 周赛.第14次周赛.第四题;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;

class Encrypter {
    HashMap<Character,Integer> keys = new HashMap<>();
    HashMap<String,Integer> res = new HashMap<>();
    String[] values;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            this.keys.put(keys[i],i);
        }
        this.values = values;
        for (String s : dictionary) {
            String temp = encrypt(s);
            res.put(temp,res.getOrDefault(temp,0) + 1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word1.length(); i++){
            char temp = word1.charAt(i);
            int index = keys.get(temp);
            sb.append(values[index]);
        }
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        return res.getOrDefault(word2,0);
    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c', 'z'};
        String[] b = {"aa","bb","cc","zz"};
        String[] c =  {"aa","aaa","aaaa","aaaaa","aaaaaaa"};
        Encrypter encrypter = new Encrypter(a,b,c);
        System.out.println(encrypter.decrypt("aa"));
        System.out.println(encrypter.decrypt("aa"));
    }
}