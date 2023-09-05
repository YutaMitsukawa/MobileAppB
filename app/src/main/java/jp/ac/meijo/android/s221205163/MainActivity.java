package jp.ac.meijo.android.s221205163;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import jp.ac.meijo.android.s221205163.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefDataStore = PrefDataStore.getInstance(this);

        prefDataStore.getString("name")
                .ifPresent(name -> binding.text.setText(name));

//        binding.saveButton.setOnClickListener(view -> {
//            var text = binding.editTextText.getText().toString();
//            binding.text.setText(text);
//        });

        binding.saveButton.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            prefDataStore.setString("name", text);
        });

        binding.changeButton.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            binding.text.setText(text);
        });

//    protected void onStart() {
//        super.onStart();
//        prefDataStore.getString("name")
//                .ifPresent(name -> binding.text.setText(name));
//    }


//        binding.editTextText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                binding.text.setText(editable.toString());
//            }
//        });


    }
}