/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacaoteste;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class AplicacaoTeste {

    public static void main(String args[]) {
        
        try {
            JSONArray json = readJsonFromUrl("https://jsonplaceholder.typicode.com/users");
            int i = 0;
            int x = 0;
            for(x=0;x<=9;x++){
                
            JSONObject obj2 = (JSONObject)json.get(x);            
            
            
            
            String nome1 = "Samantha";
            String usernome = (String) obj2.get("username");
            
            if(usernome.equals(nome1)){
             System.out.println("!--------------------------------------!");   
             System.out.println("E-MAIL DA USERNAME SAMANTHA: "+obj2.get("email"));
             System.out.println("!--------------------------------------!");
             System.out.println("--------------------------------------");
               
            }
            else{
                
            }
            System.out.println("NOME:");
            System.out.println(obj2.get("name"));
            System.out.println("WEBSITE:");
            System.out.println(obj2.get("website"));
            JSONObject address = obj2.getJSONObject("address");
            JSONObject geo = address.getJSONObject("geo");

            Double lat2 =   geo.getDouble("lat");
            //Double lng2 =   geo.getDouble("lng");
            
           if(lat2 <=0.0 ){
               
               //System.out.println("-Mora no Hemisferio Sul-");
               System.out.println("--------------------------------------");
               
               i++;
            }
            else{
              // System.out.println ("-NÃO Mora no Hemisferio Sul-");
               System.out.println("--------------------------------------");
           }
            
            }
            System.out.println("------------------------------------------------------");
            System.out.println("Total de pessoas que moram no hemisferio Sul: "+i);
            System.out.println("------------------------------------------------------");
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException {
     
        InputStream is = new URL(url).openStream();
        JSONArray json = null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            json = new JSONArray(jsonText);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }
        return json;
    }
}
