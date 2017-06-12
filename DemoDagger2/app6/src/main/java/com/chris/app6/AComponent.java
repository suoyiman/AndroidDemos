package com.chris.app6;

import dagger.Subcomponent;

/**
 * Email: suoyiman@163.coom
 */
@AScope
@Subcomponent(modules = AModule.class)
public interface AComponent {
    void inject(AActivity activity);
}
