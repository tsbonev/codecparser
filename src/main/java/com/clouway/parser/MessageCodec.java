package com.clouway.parser;

import java.io.File;

public interface MessageCodec<T> {

    T parseFile(File file);
    File parseObject(T object);

}
