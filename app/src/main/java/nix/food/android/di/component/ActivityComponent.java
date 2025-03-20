package nix.food.android.di.component;

import nix.food.android.di.module.ActivityModule;
import nix.food.android.di.scope.ActivityScope;
import nix.food.android.ui.main.MainActivity;

import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
}

