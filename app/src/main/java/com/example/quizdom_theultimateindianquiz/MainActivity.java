package com.example.quizdom_theultimateindianquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   public static ArrayList<ModelClass> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionList = new ArrayList<>();

        questionList.add(new ModelClass("What is the capital of India?", "New Delhi", "Mumbai", "Kolkata", "Chennai", "New Delhi"));
        questionList.add(new ModelClass("What is the capital of Maharashtra?", "Mumbai", "Pune", "Nagpur", "Nashik", "Mumbai"));
        questionList.add(new ModelClass("What is the capital of West Bengal?", "Kolkata", "Siliguri", "Durgapur", "Asansol", "Kolkata"));
        questionList.add(new ModelClass("What is the capital of Tamil Nadu?", "Chennai", "Coimbatore", "Madurai", "Tiruchirappalli", "Chennai"));
        questionList.add(new ModelClass("What is the capital of Uttar Pradesh?", "Lucknow", "Kanpur", "Agra", "Varanasi", "Lucknow"));
        questionList.add(new ModelClass("What is the capital of Gujarat?", "Gandhinagar", "Ahmedabad", "Surat", "Vadodara", "Gandhinagar"));
        questionList.add(new ModelClass("What is the capital of Rajasthan?", "Jaipur", "Jodhpur", "Udaipur", "Kota", "Jaipur"));
        questionList.add(new ModelClass("What is the capital of Madhya Pradesh?", "Bhopal", "Indore", "Gwalior", "Jabalpur", "Bhopal"));
        questionList.add(new ModelClass("What is the capital of Karnataka?", "Bengaluru", "Mysuru", "Hubli", "Mangaluru", "Bengaluru"));
        questionList.add(new ModelClass("What is the capital of Andhra Pradesh?", "Amaravati", "Visakhapatnam", "Vijayawada", "Tirupati", "Amaravati"));
        questionList.add(new ModelClass("What is the capital of Telangana?", "Hyderabad", "Warangal", "Karimnagar", "Nizamabad", "Hyderabad"));
        questionList.add(new ModelClass("What is the capital of Kerala?", "Thiruvananthapuram", "Kochi", "Kozhikode", "Thrissur", "Thiruvananthapuram"));
        questionList.add(new ModelClass("What is the capital of Odisha?", "Bhubaneswar", "Cuttack", "Rourkela", "Puri", "Bhubaneswar"));
        questionList.add(new ModelClass("What is the capital of Chhattisgarh?", "Raipur", "Bhilai", "Bilaspur", "Korba", "Raipur"));
        questionList.add(new ModelClass("What is the capital of Punjab?", "Chandigarh", "Ludhiana", "Amritsar", "Jalandhar", "Chandigarh"));
        questionList.add(new ModelClass("What is the capital of Haryana?", "Chandigarh", "Faridabad", "Gurugram", "Panipat", "Chandigarh"));
        questionList.add(new ModelClass("What is the capital of Jharkhand?", "Ranchi", "Jamshedpur", "Dhanbad", "Bokaro", "Ranchi"));
        questionList.add(new ModelClass("What is the capital of Assam?", "Dispur", "Guwahati", "Silchar", "Dibrugarh", "Dispur"));
        questionList.add(new ModelClass("What is the capital of Uttarakhand?", "Dehradun", "Haridwar", "Roorkee", "Haldwani", "Dehradun"));
        questionList.add(new ModelClass("What is the capital of Himachal Pradesh?", "Shimla", "Mandi", "Solan", "Dharamshala", "Shimla"));
        questionList.add(new ModelClass("What is the capital of Goa?", "Panaji", "Vasco da Gama", "Margao", "Mapusa", "Panaji"));
        questionList.add(new ModelClass("What is the capital of Bihar?", "Patna", "Gaya", "Bhagalpur", "Muzaffarpur", "Patna"));
        questionList.add(new ModelClass("What is the capital of Jammu and Kashmir?", "Srinagar", "Jammu", "Anantnag", "Baramulla", "Srinagar"));
        questionList.add(new ModelClass("What is the capital of Tripura?", "Agartala", "Dharmanagar", "Udaipur", "Kailashahar", "Agartala"));
        questionList.add(new ModelClass("What is the capital of Meghalaya?", "Shillong", "Tura", "Jowai", "Nongpoh", "Shillong"));
        questionList.add(new ModelClass("What is the capital of Manipur?", "Imphal", "Thoubal", "Churachandpur", "Bishnupur", "Imphal"));







        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                        finish();
                    }
                }, 2000);
    }


}