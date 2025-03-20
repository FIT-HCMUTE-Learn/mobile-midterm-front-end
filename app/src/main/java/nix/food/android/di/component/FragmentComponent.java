package nix.food.android.di.component;


import nix.food.android.di.module.FragmentModule;
import nix.food.android.di.scope.FragmentScope;

import dagger.Component;

@FragmentScope
@Component(modules = {FragmentModule.class},dependencies = AppComponent.class)
public interface FragmentComponent {

}
