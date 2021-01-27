package logic;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BattleSummary {

    public String gemTid;
    public static BattleSummary instance = new BattleSummary();
    public StringBuilder kampRapportSB = new StringBuilder();


    @Override
    public String toString() {
        return kampRapportSB.toString();
    }

    public void skrivTilSB(String string){

        kampRapportSB.append(String.valueOf(timeStamp()) +" -->" +string+ " \n");
        System.out.println(kampRapportSB);

    }
    public String timeStamp(){
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//yyyy-MM-dd
        gemTid = formatter.format(ts);
        return gemTid;
    }

    public void clearRapport(){
        instance.kampRapportSB.delete(0,instance.kampRapportSB.length());
    }
}
