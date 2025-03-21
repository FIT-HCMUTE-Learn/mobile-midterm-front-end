package nix.food.android.ui.main.login;

import nix.food.android.MVVMApplication;
import nix.food.android.data.Repository;
import nix.food.android.ui.base.activity.BaseViewModel;

public class LoginViewModel extends BaseViewModel {
    public LoginViewModel(Repository repository, MVVMApplication application) {
        super(repository, application);
    }

//    public void doLogin(LoginRequest request, Context mContext){
//        showLoading();
//        compositeDisposable.add(repository.getApiService().login(request)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .retryWhen(throwable ->
//                        throwable.flatMap((Function<Throwable, ObservableSource<?>>) throwable1 -> {
//                            if (NetworkUtils.checkNetworkError(throwable1)) {
//                                hideLoading();
//                                return application.showDialogNoInternetAccess();
//                            }else{
//                                return Observable.error(throwable1);
//                            }
//                        })
//                )
//                .subscribe(
//                        response -> {
//                            hideLoading();
//                            repository.getSharedPreferences().setToken(response.getAccessToken());
//                            showSuccessMessage("Login success");
//                            Intent it = new Intent(mContext, MainActivity.class);
//                            startActivity(it);
//                        }, throwable -> {
//                            hideLoading();
//                            Timber.e(throwable);
//                            if (throwable instanceof HttpException && ((HttpException) throwable).code() == 400){
//                                HttpException httpException = (HttpException) throwable;
//                                if (httpException.code() == 400) {
//                                }
//                                showErrorMessage("Login failed");
//                            } else{
//                                showErrorMessage("Login failed");
//                            }
//                        }));
//    }
}
