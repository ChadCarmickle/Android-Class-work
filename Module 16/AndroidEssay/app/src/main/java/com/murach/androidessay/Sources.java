package com.murach.androidessay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Sources extends AppCompatActivity {
    private Button Next_Btn_Sources;
    private TextView Lbl_Sources;

    private ListView LV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sources);


        Lbl_Sources = findViewById(R.id.Lbl_Sources);
        LV = findViewById(R.id.ListView_Sources);
        Lbl_Sources.setText("Sources.");
        Next_Btn_Sources = findViewById(R.id.Next_Btn_Sources);


            // Sources.
        String[] list = {
            "1926, N. T.—i. (2015, June 15). Nikola Tesla described the modern smartphone — in 1926. Retrieved from bigthink: https://bigthink.com/words-of-wisdom/nikola-tesla-2\n",
            "ANDERSON, M. (2015, october 29). Technology Device Ownership: 2015. Retrieved from pewinternet: \n http://www.pewinternet.org/2015/10/29/technology-device-ownership-2015/\n",
            "Bart Pursel, P. (2018, September 13). Apple reveals its newest and most expensive iPhone yet. \n Retrieved from sites.psu: https://sites.psu.edu/ist110pursel/2018/09/13/apple-reveals-its-newest-and-most-expensive-iphone-yet/\n ",
            "Beckman, G. (2014, June 17). Crime and Punishment in the 1920's. Retrieved from prezi: \n https://prezi.com/fy0jngcyilac/crime-and-punishment-in-the-1920s/\n",
            "Biography.com Editors. (2014, April 2). Babe Ruth Biography. Retrieved from biography: \n https://www.biography.com/people/babe-ruth-9468009\n",
            "Callaham, J. (2018, July 3). The history of Android OS: its name, origin and more. \n Retrieved from androidauthority: https://www.androidauthority.com/history-android-os-name-789433/\n",
            "CAMP, J. V. (2019, march 5). THE 12 BEST ANDROID PHONES YOU CAN BUY IN 2019. Retrieved from wired: \n https://www.wired.com/gallery/best-android-phones/",
            "Charles, A., & Sammuel, G. (2014, March 25). HTC One was its best-selling phone - but will the M8 rise to similar heights? Retrieved from theguardian: \n https://www.theguardian.com/technology/2014/mar/25/htc-one-best-selling-phone-will-m8-match\n",
            "How Internet Works on Mobile Devices. (2019, March 19). Retrieved from engineersgarage: \nhttps://www.engineersgarage.com/mygarage/how-internet-works-on-mobile-devices\n",
            "Khamlichi, M. (2015, August 31). The History Of Android. Retrieved from unixmen: \nhttps://www.unixmen.com/the-history-of-android/\n",
            "Morris, I. (2017, April 21). Samsung Galaxy S8 Is Monstrously Expensive To Produce. Retrieved from forbes: \nhttps://www.forbes.com/sites/ianmorris/2017/04/21/samsung-galaxy-s8-is-monstrously-expensive-to-produce/\n",
            "Nick Sears. (2019, March 19). Retrieved from bigcareer: \n https://www.bigcareer.com/nick-sears.html\n",
            "Okoi, M. D. (2018, September 1). 25 Cool New Features in Android 9.0 Pie. Retrieved from fossmint: \nhttps://www.fossmint.com/android-9-0-pie-features/\n",
            "Rich co-founded Android and is a pioneer in the mobile space. (2019, March 19). Retrieved from gv: \nhttps://www.gv.com/team/rich-miner/\n",
            "The beginning of Mobile Computing . (n.d.). Retrieved from mobilecomputercomp1220uwi: \n http://mobilecomputercomp1220uwi.weebly.com/history.html\n",
            "Trueman, C. N. (2015, may 22). Prohibition and the Gangsters. Retrieved from historylearningsite: \n https://www.historylearningsite.co.uk/modern-world-history-1918-to-1980/america-1918-1939/prohibition-and-the-gangsters/\n",
            "Woodford, C. (2018, May 22). Wireless Internet. Retrieved from explainthatstuff: \nhttps://www.explainthatstuff.com/wirelessinternet.html\n",
            };

        ListAdapter MyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        LV.setAdapter(MyAdapter);


        Next_Btn_Sources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Moves to the next Page
                MovePage_Source_to_App_Creator();
            }
        });
    }


    // Moves forward to the page.
    public void MovePage_Source_to_App_Creator() {

        Intent Intent_MovePage_Intro_to_Mobile = new Intent(Sources.this, Creator.class);
        startActivity(Intent_MovePage_Intro_to_Mobile);
    }
}