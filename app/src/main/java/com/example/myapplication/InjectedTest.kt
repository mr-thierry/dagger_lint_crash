package com.example.myapplication

import dagger.Module
import dagger.Provides

@Module
object ObjectModule {
    // This should fail because it uses `@JvmStatic`
    @JvmStatic
    @Provides
    fun provideFoo(): String {
        return "Foo"
    }
}

