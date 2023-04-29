//22120205067 ALPER AKPINAR
import java.io.*;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {

        ArrayList<String> content = fileToArrayList("test_arazi.txt");
        ArrayList<String> bug = fileToArrayList("böcek.txt");
        int bugCount = 0;
        boolean breakCondition;

        while(true){
            breakCondition = true;

            for (int i=0 ; i < content.size() ; i++) {
                if(content.get(i).contains(bug.get(0))){
                    int headIndex = content.get(i).indexOf(bug.get(0));
                    content.set(i, content.get(i).substring(0, headIndex) + "  " + content.get(i).substring(headIndex+1));
                    if(content.get(i+1).contains(bug.get(1)) && content.get(i+1).indexOf(bug.get(1)) == headIndex){
                        content.set(i+1, content.get(i+1).substring(0, headIndex) + "XX" + content.get(i+1).substring(headIndex+1));
                        if(content.get(i+2).contains(bug.get(2)) && content.get(i+2).indexOf(bug.get(2)) == headIndex){
                            content.set(i+2, content.get(i+2).substring(0, headIndex) + "  " + content.get(i+2).substring(headIndex+1));
                            bugCount++;
                            breakCondition = false;
                        }
                    }
                }
            }

            if(breakCondition){
                break;
            }
        }

        System.out.println(bugCount + " ADET BÖCEK BULUNMUŞTUR.");
        //printList(content);
    }

    public static ArrayList<String> fileToArrayList(String fileNameParam){
        String fileName = fileNameParam;
        String line = null;
        ArrayList<String> lines = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            bufferedReader.close();
            return lines;
        } catch(FileNotFoundException ex) {
            System.out.println("Dosya '" + fileName + "' bulunamadı.");
        } catch(IOException ex) {
            System.out.println("Hata dosya okunurken '" + fileName + "'");
        }
        return null;
    }

    /*
    public static void printList(ArrayList<String> contents){
        for (String line:
             contents) {
            System.out.println(line);
        }
    }
    */
}