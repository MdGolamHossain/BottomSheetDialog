package ;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.teenxappbd.teenxapp.R;
import com.teenxappbd.teenxapp.databinding.ActivityForgetPasswordBinding;

public class ForgetPasswordActivity extends AppCompatActivity {


    ActivityForgetPasswordBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityForgetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        binding.backImg.setOnClickListener(view -> {
           onBackPressed();
            finish();
        });

      // Main Code for BottomSheetDialog =========================================================================

        binding.signUpBtn.setOnClickListener(view -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);

            View sheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

            // LayoutParams দিয়ে exact height set
            sheetView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    (int) getResources().getDimension(R.dimen.bottom_sheet_height) // তোমার 400dp dimen
            ));


            bottomSheetDialog.setContentView(sheetView);

            // Dialog show হওয়ার পরে background remove
            bottomSheetDialog.setOnShowListener(dialog -> {
                FrameLayout bottomSheet = bottomSheetDialog.findViewById(
                        com.google.android.material.R.id.design_bottom_sheet
                );
                if (bottomSheet != null) {
                    bottomSheet.setBackgroundColor(Color.TRANSPARENT);

                    // BottomSheetBehavior নিয়ন্ত্রণ
                    BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(bottomSheet);
                    behavior.setPeekHeight((int) getResources().getDimension(R.dimen.bottom_sheet_height));
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            });

            bottomSheetDialog.show();
        });


       // end Main Code for BottomSheetDialog =========================================================================



        

    }//OnCreate bundle end here
}
