/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataminingapnea;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 import java.util.List;

/**
 *
 * @author EGC
 */
public class Knn implements Comparable<Knn> {
    Connection con=null;
    ResultSet rs;
   
        
       
    public double dd;

//    static java.util.List<Fruits1> callDistance() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    private int bp;
    private int su;
    private int knn;
    
    public  double distance;
    public static double result;
    public Knn(int bp,int su){
        
        this.bp=bp;
        this.su=su;
       
 
        
        
  }
    public void sqldata() {
        int bo=0,mo=0;
        try{
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apenadata","root","");
String sql = "SELECT * FROM minetable";
PreparedStatement pst = con.prepareStatement(sql);
 rs=pst.executeQuery();
while(rs.next()){
   
              int  id = rs.getInt("Sample_code_number");
                if (rs.getInt("bp") == 2) {
                   String cla = "Diease";
                    bo++;
                } else if (rs.getInt("age") == 3) {
                   String cla = "age";
                    mo++;
                }
                for (int z = 0; z < bo; z++) {
                  int aInt = rs.getInt("bp");
                }
}

}catch(Exception e){ System.out.println(e);} 
    }
   

    Knn() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getbp(){
        return bp;
    }
     public int getsu(){
        return su;
    }
     public void setbp(int bp){
         this.bp=bp;
         
     }
     public void setsu(int su){
         this.su=su;
     }
     public double getdistance(double distnace){
         
         return distance;
     }
     public void setdistance(double distance){
        this.distance=distance;
     }
     public static List callDistance(List<Knn>f1,Knn ts){
         for(Knn f:f1){
             double c=Math.pow(f.bp, f.su);
             double dist=Math.sqrt(c);
            f.setdistance(dist);
           
         }
        
        return f1;
         
     }
    @Override
     public String toString(){
         return "Disease [bp="+bp+"su="+su+"]";
         
     }
   
    @Override
    public int compareTo(Knn t) {
        return (int)((this.distance-t.distance)*2);
    }
    
}
