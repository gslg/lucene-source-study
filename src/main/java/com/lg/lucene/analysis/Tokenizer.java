package com.lg.lucene.analysis;

import java.io.IOException;
import java.io.Reader;

/**
 *Tokenizer是一个TokenStream,他的输入是Reader输入流
 */
public abstract class Tokenizer extends TokenStream {
    //Tokenizer的文本来源
    protected Reader input;

    public void close() throws IOException{
        input.close();
    }


}
