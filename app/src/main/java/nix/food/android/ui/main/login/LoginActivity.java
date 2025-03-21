package nix.food.android.ui.main.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import eu.davidea.flexibleadapter.databinding.BR;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import nix.food.android.R;
import nix.food.android.data.model.api.request.login.LoginRequest;
import nix.food.android.databinding.ActivityLoginBinding;
import nix.food.android.di.component.ActivityComponent;
import nix.food.android.ui.base.activity.BaseActivity;
import nix.food.android.ui.main.MainActivity;
import timber.log.Timber;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding.setA(this);
        viewBinding.setVm(viewModel);
    }
    public void onLoginClick() {
        viewModel.showLoading();
        LoginRequest request = new LoginRequest();
        request.setUsername(viewBinding.userName.toString());
        request.setPassword(viewBinding.password.toString());

        viewModel.getCompositeDisposable().add(viewModel.getRepository().getApiService().login(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            viewModel.hideLoading();
                            viewModel.getRepository().getSharedPreferences().setToken(response.getAccessToken());
                            Intent it = new Intent(this, MainActivity.class);
                            startActivity(it);
                        }, throwable -> {
                            viewModel.hideLoading();
                            Timber.e(throwable);
                        }));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
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
