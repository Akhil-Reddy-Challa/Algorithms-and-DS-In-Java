public class ImplementAtoI3 {
    public static void main(String[] args) {
        String number = "  0000000000012345678";
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int length_of_number = number.length();
        int index_of_non_whitespace_char = get_index(number);
        char character = number.charAt(index_of_non_whitespace_char);
        boolean negative_number = false;int ascii_of_char=0;
        int converted_number=0;int count_of_integers=0;
        int position = index_of_non_whitespace_char;
        if( character == '-'){
            negative_number = true;position++;
        }
        else if( character == '+'){
            position++;
        }
        while (position < length_of_number) {
            ascii_of_char = (int)number.charAt(position);
            if(ascii_of_char>47 && ascii_of_char<58){
                converted_number *= 10;
                converted_number += ascii_of_char-48;
                if(ascii_of_char != 48 || converted_number != 0)
                    count_of_integers +=1;                
                //count_of_integers +=1;         
            }
            else{
                break;
            } 
            position++;
        }
        if(count_of_integers >9 && negative_number) converted_number = Integer.MIN_VALUE;
        else if(count_of_integers >9 && !negative_number) converted_number = Integer.MAX_VALUE;
        else if(count_of_integers <=9 && negative_number) converted_number = -converted_number;
        
       // if(negative_number && converted_number < Integer.MIN_VALUE) return converted_number;
        //else if(negative_number && converted_number >= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        //if(converted_number > )
        System.out.println(converted_number);
    }

    private static int get_index(String number) {
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)!=' ')
                return i;
        }
        return 0;
    }

}