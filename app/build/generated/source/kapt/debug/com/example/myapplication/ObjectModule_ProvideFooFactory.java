package com.example.myapplication;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ObjectModule_ProvideFooFactory implements Factory<String> {
  @Override
  public String get() {
    return provideFoo();
  }

  public static ObjectModule_ProvideFooFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provideFoo() {
    return Preconditions.checkNotNullFromProvides(ObjectModule.provideFoo());
  }

  private static final class InstanceHolder {
    private static final ObjectModule_ProvideFooFactory INSTANCE = new ObjectModule_ProvideFooFactory();
  }
}
