package bank.util;

public class KeyGen {

    private final int SIZE = 5;
    private String key;

    public KeyGen(){
        char[] keyArray = new char[SIZE];
    /*
        Figuring out the ranges:
        97-122 && 48 - 57
        int a = 'a';
        int z = 'z';
        int nine = '9';
        int zero = '0';
        System.out.println(a + " " + z + " " + nine + " " + zero);
    */

        RandomInRanges rir = new RandomInRanges(48,57);
        rir.addRange(97,122);

        for(int i = 0; i < SIZE; i++){
            keyArray[i] =(char) rir.getRandom();
        }
        key = new String(keyArray);
    }

    public String getKey(){
        return this.key;
    }

    public static void main(String[] args){
        KeyGen k = new KeyGen();
        System.out.println(k.getKey());
    }

}
