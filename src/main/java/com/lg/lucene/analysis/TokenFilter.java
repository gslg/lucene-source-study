package com.lg.lucene.analysis;

import java.io.IOException;

abstract class TokenFilter extends TokenStream {
    /** The source of tokens for this filter. */
    protected TokenStream input;

    /** Close the input TokenStream. */
    public void close() throws IOException {
        input.close();
    }
}
