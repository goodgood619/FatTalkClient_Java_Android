package Model;

public class Frienddata {
    private String fnickname;
    public void setFnickname(String fnickname){this.fnickname = fnickname;}
    public String getFnickname(){return fnickname;}

    public Frienddata(){
        fnickname = "";
    }
    public Frienddata(String fnickname){
        this.fnickname = fnickname ;
    }
    public void Reset(){
        fnickname = "";
    }

}
