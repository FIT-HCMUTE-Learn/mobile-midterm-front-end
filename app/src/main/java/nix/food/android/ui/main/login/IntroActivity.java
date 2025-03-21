package nix.food.android.ui.main.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.Objects;

import eu.davidea.flexibleadapter.databinding.BR;
import nix.food.android.R;
import nix.food.android.databinding.ActivityIntroBinding;
import nix.food.android.di.component.ActivityComponent;
import nix.food.android.ui.base.activity.BaseActivity;
import nix.food.android.ui.main.MainActivity;

public class IntroActivity extends BaseActivity<ActivityIntroBinding, IntroViewModel> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding.setA(this);
        viewBinding.setVm(viewModel);
    }
    public void onStartClick() {
        if(!Objects.equals(viewModel.getRepository().getSharedPreferences().getToken(), "null")) {
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
        } else {
            Intent it = new Intent(this, LoginActivity.class);
            startActivity(it);
        }
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_intro;
    }

    @Override
    public int getBindingVariable() {
        return BR.vm;
    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {
        buildComponent.inject(this);
    }

}
