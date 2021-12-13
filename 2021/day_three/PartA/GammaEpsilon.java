import java.io.*;
import java.util.ArrayList;
import java.lang.Math;

public class GammaEpsilon{
  public static void main(String[] args){
    ArrayList<ArrayList<Character>> lines = new ArrayList<ArrayList<Character>>();
    ArrayList<Character> curLine = new ArrayList<Character>();
    int curInt;
    char curChar;

    int[] totals = new int[12];

    int[] gamma = new int[12];
    int[] epsilon = new int[12];

    FileInputStream in;

    int a = 0;

    try{
      in = new FileInputStream("../input.txt");

      while((curInt = in.read()) != -1){
        curChar = (char)curInt;

        if(curChar != '\n'){
          curLine.add(curChar);
        }else{
          lines.add(curLine);
          curLine = new ArrayList<Character>();
        }
      }
    }catch (IOException e){
      e.printStackTrace();
    }

    for(ArrayList<Character> line : lines){
      for(int i = 0; i < line.size(); i ++){
        totals[i] += (line.get(i) - 48);
      }
    }

    for(int i = 0; i < totals.length; i ++){
      gamma[i] = (totals[i] > (lines.size() / 2)) ? 1 : 0;
      epsilon[i] = (gamma[i] == 0 ) ? 1 : 0;
    }

    System.out.println(convertBinary(gamma) * convertBinary(epsilon));
  }

  public static int convertBinary(int[] binary){
    int result = 0;

    for(int i = 0; i < binary.length; i ++){
      result += binary[binary.length - 1 - i] * Math.pow(2, i);
    }

    return result;
  }
}
