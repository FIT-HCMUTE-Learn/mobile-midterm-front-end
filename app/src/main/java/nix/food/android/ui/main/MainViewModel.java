package nix.food.android.ui.main;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import nix.food.android.MVVMApplication;
import nix.food.android.data.Repository;
import nix.food.android.data.model.api.request.login.LoginRequest;
import nix.food.android.data.model.api.response.category.CategoryResponse;
import nix.food.android.ui.base.activity.BaseViewModel;
import nix.food.android.utils.NetworkUtils;
import retrofit2.HttpException;
import timber.log.Timber;

public class MainViewModel extends BaseViewModel {

    public MainViewModel(Repository repository, MVVMApplication application) {
        super(repository, application);
    }
    public void getAllCategories(MainCalback<List<CategoryResponse>> callback){
        showLoading();
        compositeDisposable.add(repository.getApiService().getAllCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            if (response != null) {
                                callback.doSuccess(response);
                            } else {
                                hideLoading();
                                callback.doFail();
                            }
                        }, throwable -> {
                            Timber.e(throwable);
                            callback.doError(throwable);
                        }
                )
        );
    }
}
