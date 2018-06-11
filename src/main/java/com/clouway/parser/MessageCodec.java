package com.clouway.parser;

import java.io.File;

public interface MessageCodec {

    Object parseFile(File file);
    File parseObject(Object object);

}
