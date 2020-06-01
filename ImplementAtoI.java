public class ImplementAtoI {
    public static void main(String[] args) {
        String number = "-912834723";
        int converted_number=0;
        int ascii_of_char=0;
        boolean first_non_whitespace_character = false;
        int count_of_integers=0;
        boolean negative_number = false;
        boolean from_now_on_only_numbers = false;
        for(var character : number.toCharArray()){
            if(character != ' '){
                first_non_whitespace_character = true;;
            ascii_of_char = (int)character;
            if(ascii_of_char>47 && ascii_of_char<58){
                converted_number *= 10;
                converted_number += ascii_of_char-48;
                count_of_integers +=1;
            }
            else if(character == '-'){
                negative_number = true;
                from_now_on_only_numbers = true;
            }
            else break;
         }
         else if(first_non_whitespace_character) break;
        }
        if(count_of_integers >9 && negative_number) converted_number = Integer.MIN_VALUE;
        else if(count_of_integers >9 && !negative_number) converted_number = Integer.MAX_VALUE;
        else if(count_of_integers <=9 && negative_number) converted_number = -converted_number;
        System.out.println(converted_number);
    }
}