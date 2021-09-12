package com.example.usermanageapirest.application.user;

public interface Mapper<T,V> {

	V map(T input);

}
