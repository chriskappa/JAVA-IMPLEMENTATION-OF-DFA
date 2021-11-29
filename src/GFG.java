
import java.util.ArrayList;

/* Implementation of DFA that accepts 
    Language={W:Starts with (E || L || O || X) has subword GGLE and ends with (E || G || L || O || X)}
    Accepted Words: GGLE , GOOGLE , XXGOGOOOGLEGLXX
    Rejected Words: GLE , GOOGLLE , OGGL
*/

class GFG {
 
   
    static int dfa = 0; // DFA shows the pressent state we are currently (eg. 4 means thats the final state)
 
//    Start method is the start state of the DFA
    static void start(char c)
    {
//        State transition (if character is E,L,O,X it stays in the same state (loop))
        if (c == 'E' || c == 'L' || c == 'O' || c == 'X') {
            dfa = 0;
        }
        else if (c == 'G') {
            dfa = 1;
        }
 
//        This part is to catch invalid user input
        else {
            dfa = -1;
        }
    }
 
 

    static void node1(char c)
    {
        if (c == 'O') {
            dfa = 1;
        }
        else if(c == 'G'){
            dfa = 2;
        }
        else if (c == 'X' || c == 'L' || c == 'E') {
            dfa = 0;
        }
        else {
            dfa = -1;
        }
    }
 
 
    static void node2(char c)
    {
        if (c == 'G') {
            dfa = 2;
        }
      else if (c == 'X' || c == 'E') {
            dfa = 0;
        }
      else if(c == 'O'){
          dfa = 1;
      }
      else if(c == 'L'){
          dfa=3;
      }
        else {
            dfa = -1;
        }
    }
 
    static void node3(char c)
    {
        if (c == 'G') {
            dfa = 1;
        }
         else if (c == 'L' || c == 'O' || c == 'X') {
            dfa = 0;
        }
         else if(c == 'E'){
            dfa=4;
         }
        else {
            dfa = -1;
        }
    }
 
    static void node4(char c)
    {
        if (c == 'E' || c == 'G' || c == 'L' || c == 'O' || c == 'X') {
            dfa = 4;
        }
        else {
            dfa = -1;
        }
    }
 
   
 
    static int isAccepted(char str[])
    {
        int i = str.length; // Getting i length
        int len = str.length; // Getting length from the given string
 
        for (i = 0; i < len; i++) {
            if (dfa == 0)
                start(str[i]);
 
            else if (dfa == 1)
                node1(str[i]);
 
            else if (dfa == 2)
                node2(str[i]);
 
            else if (dfa == 3)
                node3(str[i]);
 
            else if (dfa == 4)
                node4(str[i]);
 
 
 
            else
                return 0;
        }
        if (dfa == 4)
            /* IF THE LOOP IS FINISHED AND THE DFA VALUE IS 4 MEANS ITS ON FINAL STATE AND THE WORD IS ACCEPTED */
            return 1;
        else
            /* IF THE LOOP IS FINISHED AND THE DFA VALUE IS != 4 MEANS THE STATE IS NOT FINAL AND THE WORD IS REJECTED */
            return 0;
    }
 

    public static void main(String[] args)
    {
        String[] list = {"GLE","GOOGLLE","GGLE","XXGOGOOOGLEGLXX","XXOOOOOXXGLLLELGGLOXGLEOXXX","OLEGLGLXXGLEXOOOOO","GLGEGLEX"};
        for(String word :list){
        char str[] = word.toCharArray();
        if (isAccepted(str) == 1)
            System.out.println("word ("+word+") IS ACCEPTED");
        else
            System.out.println("word "+word+" NOT ACCEPTED");
    }
        
        }
        
}