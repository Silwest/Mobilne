package lab02.database;

/**
 * Created by Silwest on 09.04.14.
 */
public class Tasks {
    private int id;
    private String text;

    public int getID(){
        return id;
    }
    public String getText(){
        return text;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setText(String text){
        this.text = text;
    }
}
