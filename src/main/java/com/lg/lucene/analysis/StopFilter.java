package com.lg.lucene.analysis;

import java.io.IOException;
import java.util.Hashtable;

/**
 * 过滤掉暂停词
 */
public class StopFilter extends TokenFilter{

    private Hashtable table;

    public StopFilter(TokenStream in,String[] stopWords){
        input = in;
        table = makeStopTable(stopWords);
    }

    public StopFilter(TokenStream in,Hashtable stopTable){
        input = in;
        table = stopTable;
    }


    public final static Hashtable makeStopTable(String[] stopWords) {
        Hashtable stopTable = new Hashtable(stopWords.length);
        for (int i = 0; i < stopWords.length; i++) {
            stopTable.put(stopWords[i],stopWords[i]);
        }
        return stopTable;
    }

    public Token next() throws IOException {
        //返回找到的第一个非暂停词
        //int i=0;i<10;i++
        for(Token token = input.next(); token != null; token = input.next())
            if(table.get(token.termText) == null)
                return token;
        //到达流的末尾（EOS,end of stream）,返回null
        return null;
    }
}
