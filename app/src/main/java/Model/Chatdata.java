package Model;

public class Chatdata {
    private String chatmessage;
    private String sendnickname;
    private int chatnumber;
    public void setChatmessage(String chatmessage){this.chatmessage = chatmessage;}
    public String getChatmessage(){return chatmessage;}
    public void setSendnickname(String sendnickname){this.sendnickname = sendnickname;}
    public String getSendnickname(){return sendnickname;}
    public void setChatnumber(int chatnumber){this.chatnumber = chatnumber;}
    public int getChatnumber(){return chatnumber;}

    public Chatdata(){
        chatmessage = "";
        sendnickname = "";
        chatnumber = 0;
    }

    public Chatdata(String chatmessage,String sendnickname,int chatnumber){
        this.chatnumber = chatnumber;
        this.sendnickname = sendnickname;
        this.chatmessage = chatmessage;
    }

    public void reset(){
        chatmessage = "";
        sendnickname = "";
        chatnumber = 0;
    }


}
