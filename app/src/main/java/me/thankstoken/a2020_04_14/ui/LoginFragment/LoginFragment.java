package me.thankstoken.a2020_04_14.ui.LoginFragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import me.thankstoken.a2020_04_14.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private LoginViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        View root = view.getRootView();

        Button loginButton = root.findViewById(R.id.login_button);
        loginButton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.login_button:
                Toast.makeText(getContext(), "Login button selected", Toast.LENGTH_LONG).show();
                break;
            default:
                Log.d("PGB",Integer.toString(v.getId()));
                Toast.makeText(getContext(), "Something else selected", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
    }


}
