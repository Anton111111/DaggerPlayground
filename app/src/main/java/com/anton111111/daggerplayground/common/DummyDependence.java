package com.anton111111.daggerplayground.common;

import java.io.Serializable;
import java.util.UUID;

public class DummyDependence implements Serializable {
    public String value = UUID.randomUUID().toString();
}
