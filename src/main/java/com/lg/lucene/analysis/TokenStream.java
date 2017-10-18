package com.lg.lucene.analysis;

import java.io.IOException;

public abstract class TokenStream {

    /**
     * 返回stream中下一个的Token,或者null在遇到EOS
     * @return
     * @throws IOException
     */
    public abstract Token next() throws IOException;
    /**关闭这个流关联的资源*/
    public void close() throws IOException{}
}
