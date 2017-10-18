package com.lg.lucene.analysis;

public class Token {
    String termText; //该术语的文本
    int startOffset; //源文本的开始
    int endOffset;//源文本的结束
    String type = "word"; //词法类型

    public Token(String text, int start, int end) {
        this.termText = text;
        this.startOffset = start;
        this.endOffset = end;
    }

    public Token(String text, int start, int end,String type) {
        this.termText = text;
        this.startOffset = start;
        this.endOffset = end;
        this.type = type;
    }

    public final String termText(){
        return termText;
    }

    public final int startOffset() { return startOffset; }

    /** Returns this Token's ending offset, one greater than the position of the
     last character corresponding to this token in the source text. */
    public final int endOffset() { return endOffset; }

    /** Returns this Token's lexical type.  Defaults to "word". */
    public final String type() { return type; }




}
