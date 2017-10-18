package com.lg.lucene.analysis.standard;

import com.lg.lucene.analysis.Token;
import com.lg.lucene.analysis.Tokenizer;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by sclg1 on 2017/10/18.
 */
public class StandardTokenizer extends Tokenizer implements StandardTokenizerConstants{
    public StandardTokenizer(Reader reader){

    }

    public Token next() throws IOException {
        return null;
    }
}
