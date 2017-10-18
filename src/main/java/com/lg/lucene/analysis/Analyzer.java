package com.lg.lucene.analysis;

import java.io.Reader;

public abstract class Analyzer {

    public TokenStream tokenStream(String fieldName, Reader reader){
        // implemented for backward compatibility
        return tokenStream(reader);
    }

    public TokenStream tokenStream(Reader reader){
        return tokenStream(null, reader);
    }
}
