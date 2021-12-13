import java.io.*;
import java.util.ArrayList;
import java.lang.Math;

public class OxygenCO2{
  public static void main(String[] args){
    ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> curLine = new ArrayList<Integer>();

    ArrayList<ArrayList<Integer>> oxygen;
    ArrayList<ArrayList<Integer>> co2;

    int curInt;
    char curChar;

    int[] totals = new int[12];

    FileInputStream in;

    try{
      in = new FileInputStream("../input.txt");

      while((curInt = in.read()) != -1){
        curChar = (char)curInt;

        if(curChar != '\n'){
          curLine.add(curChar - 48);
        }else{
          lines.add(curLine);
          curLine = new ArrayList<Integer>();
        }
      }
    }catch (IOException e){
      e.printStackTrace();
    }

    oxygen = new ArrayList<ArrayList<Integer>>(lines);
    co2 = new ArrayList<ArrayList<Integer>>(lines);

    for(int i = 0; oxygen.size() > 1; i ++){
      for(int j = 0; j < oxygen.size(); j ++){
        totals[i] += oxygen.get(j).get(i);
      }

      float size = oxygen.size();
      int most_common_bit = (((float)totals[i] >= (size / 2)) ? 1 : 0);

      for(int j = 0; j < oxygen.size(); j ++){
        if(oxygen.get(j).get(i) != most_common_bit){
          oxygen.remove(j);
          j --;
        }
      }
    }

    totals = new int[12];

    for(int i = 0; co2.size() > 1; i ++){
      for(int j = 0; j < co2.size(); j ++){
        totals[i] += co2.get(j).get(i);
      }

      float size = co2.size();
      int least_common_bit = (((float)totals[i] < (size / 2)) ? 1 : 0);

      for(int j = 0; j < co2.size(); j ++){
        if(co2.get(j).get(i) != least_common_bit){
          co2.remove(j);
          j --;
        }
      }
    }

    System.out.println(convertArrayList(oxygen.get(0)) * convertArrayList(co2.get(0)));
  }

  public static int convertArrayList(ArrayList<Integer> binary){
    int result = 0;

    for(int i = 0; i < binary.size(); i ++){
      result += binary.get(binary.size() - 1 - i) * Math.pow(2, i);
    }

    return result;
  }

  public static int convertBinary(int[] binary){
    int result = 0;

    for(int i = 0; i < binary.length; i ++){
      result += binary[binary.length - 1 - i] * Math.pow(2, i);
    }

    return result;
  }
}
