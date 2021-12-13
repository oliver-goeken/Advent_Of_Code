import java.io.*;
import java.util.ArrayList;

public class PosAndDepth{
  public static void main(String[] args){
    FileInputStream in = null;

    ArrayList<String> lines = new ArrayList<String>();

    int posx = 0;
    int posy = 0;

    char current;
    int temp;
    String curLine = "";

    try{
      in = new FileInputStream("../input.txt");

      while((temp = in.read()) != -1){
        current = (char)temp;
        if(current != '\n'){
          curLine += current;
        }else{
          lines.add(curLine);
          curLine = "";
        }
      }
    }catch (IOException e){
      e.printStackTrace();
    }

    for(String line : lines){
      if(!line.equals(
        line = line.replace("forward ", ""))){
        posx += Integer.parseInt(line);
      }else if(!line.equals(
        line = line.replace("up ", ""))){
        posy -= Integer.parseInt(line);
      }else if(!line.equals(
        line = line.replace("down ", ""))){
        posy += Integer.parseInt(line);
      }
    }

    System.out.println(posx * posy);

    try{
      in.close();
    }catch (IOException e){
      e.printStackTrace();
    }
  }
}
