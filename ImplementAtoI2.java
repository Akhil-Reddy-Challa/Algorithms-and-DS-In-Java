public class ImplementAtoI2 {
    public static void main(String[] args) {
        System.out.println(Get_Value_from_string("+-2"));
    }
    public static int Get_Value_from_string(String number){
        //String number = "4193";
        int converted_number=0;
        int ascii_of_char=0;
        boolean negative_number = false;
        boolean from_now_on_only_numbers = true;boolean sign_retrieved=false;
        int count_of_integers = 0;
        for(var character : number.toCharArray()){
            if(character != ' '){
                ascii_of_char = (int)character;
                if((character == '+' || character == '-') && !sign_retrieved){
                    if(character=='-') negative_number =true;
                    from_now_on_only_numbers = true;sign_retrieved = true;
                }
                else if(ascii_of_char>47 && ascii_of_char<58){
                    converted_number *= 10;
                    converted_number += ascii_of_char-48;
                    
                    if(ascii_of_char != 48 || converted_number != 0){
                        count_of_integers++;
                        System.out.println("I am updated for ascii: "+(ascii_of_char-48));
                    }
                    }           
                else if(from_now_on_only_numbers) break;
            }        
        }
        //if(negative_number) converted_number = -converted_number;
        if(count_of_integers>9){
            if(negative_number) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        else if(negative_number) return (-1*converted_number);
        return converted_number;        
    }
}