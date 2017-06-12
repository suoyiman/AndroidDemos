package com.chris.app7.component;

import com.chris.app7.AActivity;
import com.chris.app7.module.AModule;
import com.chris.app7.scope.AScope;

import dagger.Subcomponent;

/**
 * Email: suoyiman@163.coom
 */
@AScope
@Subcomponent(modules = AModule.class)
public interface AComponent {
    void inject(AActivity activity);
}
