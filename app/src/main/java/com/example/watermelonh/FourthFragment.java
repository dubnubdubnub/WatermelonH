package com.example.watermelonh;

import static com.example.watermelonh.Constants.imageBitmap;
import static com.example.watermelonh.Constants.imageBitmapFront;
import static com.example.watermelonh.Constants.module;
import static com.example.watermelonh.Constants.result;
import static com.example.watermelonh.Constants.resultFront;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.watermelonh.databinding.FragmentSecondBinding;

public class FourthFragment extends Fragment {

    private FragmentSecondBinding binding;
    private MainActivity mainActivity = new MainActivity();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = (ImageView) view.findViewById(R.id.watermelon_front1);

        resultFront = mainActivity.pytorchTensor(imageBitmapFront,module);

        imageView.setImageBitmap(imageBitmapFront);

        binding.declineImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FourthFragment.this)
                        .navigate(R.id.action_fourthFragment_to_ThirdFragment);

            }
        });

        binding.confirmImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FourthFragment.this)
                        .navigate(R.id.action_fourthFragment_to_endFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
