package com.soiadmahedi.uchcharon;

import android.os.*;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.soiadmahedi.uchcharon.databinding.*;
import com.soiadmahedi.uchcharonbd.BanglaToEnglishUchcharon;
import com.soiadmahedi.uchcharonbd.BanglaToSylhetiUchcharon;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
	
	private MainBinding binding;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		binding = MainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		setSupportActionBar(binding.toolbar);
		Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		
		binding.materialbuttonBnEn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String banglaText = binding.edittextBnEn.getText().toString();
				binding.textviewViewBnEn.setText(BanglaToEnglishUchcharon.transliterate(banglaText));
			}
		});
		
		binding.materialbuttonBnSyl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String banglaText = binding.edittextBnSyl.getText().toString();
				binding.textviewViewBnSyl.setText(BanglaToSylhetiUchcharon.convertToNagri(banglaText));
			}
		});
	}
	
	private void initializeLogic() {

	}
	
}
