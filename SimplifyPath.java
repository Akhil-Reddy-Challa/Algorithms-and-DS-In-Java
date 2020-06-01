/*import java.util.Stack;
public class SimplifyPath {
      
        String string = "/home/folder1";
        String[] parts = string.split("/");

        Stack<String> stack = new Stack<>();
        stack.push("/");
        String name_of_folder = "";
        for(int i=0;i<parts.length;i++){
            if(!parts[i].isEmpty()){
                name_of_folder = parts[i];
            //System.out.println("Folder is: "+name_of_folder);
            if(name_of_folder.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();              
                //System.out.println("After POP stack is "+stack);
            }
            else if(!name_of_folder.equals(".")) 
                {
                    
                    stack.push(name_of_folder+"/");
                }

            }
        }
        String short_path = "";
        if(stack.isEmpty()){
            stack.push("/");
            short_path = "/";
        }
        else{
        if(stack.get(0)!="/")
            short_path="/";            
        for(int i=0;i< stack.size();i++)
            short_path += stack.get(i);
        if(short_path.length()>1 && short_path.charAt(short_path.length()-1) == '/')
            short_path = short_path.substring(0, short_path.length() - 1);    
        if(short_path.length()==1 && short_path.charAt(0)!='/')
            short_path = "/"+short_path;
        }
        System.out.println(short_path);
    
    }
}
*/