package Model;

public class Finddata {
    private String findid;
    private String findpassword;
    public void setFindid(String findid) {this.findid = findid;}
    public String getFindid(){return findid;}
    public void setFindpassword(String findpassword){this.findpassword = findpassword;}
    public String getFindpassword(){return findpassword;}

    public Finddata(){
        findid = "";
        findpassword = "";
    }
    public Finddata(String findid,String findpassword){
        this.findid = findid;
        this.findpassword = findpassword;
    }
    public void Reset(){
        findid = "";
        findpassword = "";
    }

}
