package com.lg.lucene.analysis;

import java.io.IOException;

public class LowerCaseFilter  extends TokenFilter{
    public LowerCaseFilter(TokenStream in){
        input = in;
    }

    public final Token next() throws IOException {
        Token t = input.next();

        if(t == null)
            return null;

        t.termText = t.termText.toLowerCase();

        return t;
    }
}
