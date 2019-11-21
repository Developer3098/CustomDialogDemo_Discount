package com.example.customdialogdemo_discount;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDiscount = findViewById(R.id.buttonDiscount);

        buttonDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
               /* AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                final View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.custom_dialog_sidebutton, viewGroup, false);
                builder.setView(dialogView);

                final AlertDialog alertDialog = builder.create();
                Button button = dialogView.findViewById(R.id.buttonCancel);
                Button buttonInvoiceDiscountCustom = dialogView.findViewById(R.id.buttonInvoiceDiscountCustom);
                buttonInvoiceDiscountCustom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "wefwef", Toast.LENGTH_SHORT).show();
                        // alertDialog.dismiss();
                    }
                });
                alertDialog.show();*/

            }
        });
    }

    private void showDialog() {
        View tipView = LayoutInflater.from(this).inflate(R.layout.custom_dialog_sidebutton, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(tipView);
        final Dialog tipDialog = builder.create();
//        tipDialog.setContentView(tipView);
        tipDialog.setCanceledOnTouchOutside(false);
        tipDialog.setCancelable(false);
        tipDialog.show();

        DisplayMetrics displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int displayWidth = displayMetrics.widthPixels;
        int displayHeight = displayMetrics.heightPixels;

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();

        layoutParams.copyFrom(tipDialog.getWindow().getAttributes());

        int dialogWindowWidth = (int) (displayWidth * 0.9f);
        int dialogWindowHeight = ViewGroup.LayoutParams.WRAP_CONTENT;

        layoutParams.width = dialogWindowWidth;
        layoutParams.height = dialogWindowHeight;

        tipDialog.getWindow().setAttributes(layoutParams);

       // Button buttonCancel = tipView.findViewById(R.id.buttonCancel);
        ImageView imageViewCancel=tipView.findViewById(R.id.imageViewCancel);
        Button buttonInvoiceDiscountCustom = tipView.findViewById(R.id.buttonInvoiceDiscountCustom);
        Button buttonInvoiceStandard = tipView.findViewById(R.id.buttonInvoiceStandard);
        Button buttonProcessCoupon = tipView.findViewById(R.id.buttonProcessCoupon);
        Button buttonMultiItemDiscount = tipView.findViewById(R.id.buttonMultiItemDiscount);

        imageViewCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipDialog.dismiss();
            }
        });
        buttonInvoiceDiscountCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Invoice Discount Custom", Toast.LENGTH_SHORT).show();
            }
        });
        buttonMultiItemDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Multi Item Discount", Toast.LENGTH_SHORT).show();
            }
        });
        buttonInvoiceStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Invoice Discount Standard", Toast.LENGTH_SHORT).show();
            }
        });
        buttonProcessCoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Process Coupon", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
