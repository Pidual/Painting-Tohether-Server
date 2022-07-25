import stuctures.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;

public class DataManagement {


    private BinaryTree<Coordinates> cordTree;

    public DataManagement(){
        cordTree = new BinaryTree<>((cord1,cord2)-> (cord1.getX()-cord2.getX()) - (cord1.getY()-cord2.getY()));
    }

    public void addDataToTree(String text) {
        String refinedText = text.replace("[","");
        refinedText = refinedText.replace("]","");
        refinedText = refinedText.replaceAll("\\s","");
        addToTree(refinedText.split(","));
        System.out.println(cordTree.inOrder());
    }

    private void addToTree(String[] list) {
        int x;
        int y;
        for (int i = 0; i < list.length; i+=2) {
            x = Integer.parseInt(list[i]);
            y = Integer.parseInt(list[i+1]);
            cordTree.add(new Coordinates(x,y));
        }
    }


    public String getData(){
        return cordTree.inOrder().replaceAll("\\s","");
    }
}
