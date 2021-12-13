import java.io.*;
import java.util.ArrayList;

public class DepthIncrease{
  public static void main(String[] args){
    FileInputStream in = null;

    int temp = 0;
    char character;
    int line = 0;

    ArrayList<Integer> lines = new ArrayList<Integer>();

    int increasing = 0;

    try {
      in = new FileInputStream("input.txt");

      while((temp = in.read()) != -1){
        character = (char)temp;
        if(character != '\n'){
          line *= 10;
          line += (int)character - 48;
        }else{
          lines.add(line);
          line = 0;
        }
      }

      if(in != null){
        in.close();
      }

      for(int i = 1; i < lines.size(); i ++){
        if(lines.get(i) > lines.get(i - 1)){
          increasing ++;
        }
      }
    }
    catch(IOException e){
      e.printStackTrace();
    }

    System.out.println(increasing);
  }
}
