package com.example.smartapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBross extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] ListAct = new String[] {
                "Call Center", "SMS Center", "Driving Direction", "Website", "Info Di Google", "Exit"
        };
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListAct));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try{
            Intent a = null;
            if (pilihan.equals("Call Center")) {
               String nomortelp = "telp : 02123415346";
               a = new Intent(Intent.ACTION_DIAL,Uri.parse(nomortelp));
            }else if(pilihan.equals("SMS Center")) {
                String smstext = "Alif Alfarabi.B H/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("SMS:08237829192"));
                a.putExtra("sms_body",smstext);
            }else if (pilihan.equals("Driving Direction")) {
                String lokasirs = "https://goo.gl/maps/GXv1bFBbAxibQhDR8";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));
            }else if (pilihan.equals("Website")){
                String website = "http://awalbros.com/branch/panam/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            }else if (pilihan.equals("Info Di Google")){
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Rumah Sakit Awal Bross");
            }else if (pilihan.equals("Exit")){

            }
            startActivity(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
