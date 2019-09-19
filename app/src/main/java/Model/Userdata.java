package Model;

import android.provider.ContactsContract;

public class Userdata {
    private int Usernumber;
    private String id;
    private String nickname;
    public void setId(String id){this.id  = id;}
    public String getId(){return id;}
    public void setNickname(String nickname){this.nickname = nickname;}
    public String getNickname(){return nickname;}
    public void setUsernumber(int Usernumber){this.Usernumber = Usernumber;}
    public int getUsernumber(){return Usernumber;}

    public Userdata(){
        Usernumber = 0;
        id = "";
        nickname ="";
    }
    public Userdata(String id,String nickname,int Usernumber){
        this.id = id;
        this.nickname = nickname;
        this.Usernumber = Usernumber;
    }
    public void Reset(){
        id = "";
        nickname = "";
        Usernumber = 0;
    }

}
