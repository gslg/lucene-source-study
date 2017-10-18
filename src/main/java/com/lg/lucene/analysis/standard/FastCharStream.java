package com.lg.lucene.analysis.standard;

import java.io.IOException;
import java.io.Reader;

/**
 * JavaCC CharStream接口的一个高效实现.
 * 注意这个不会做行数的计算，相反的它跟踪input中token的字符位置.
 */
public final class FastCharStream implements CharStream {

    char[] buffer = null;

    int bufferLength = 0;
    int bufferPosition = 0;

    int tokenStart = 0;
    int bufferStart = 0;

    Reader input;

    public FastCharStream(Reader r){
        input = r;
    }

    private final void refill() throws IOException{

    }

    public final char readChar() throws IOException {
        return 0;
    }

    public int getColumn() {
        return 0;
    }

    public int getLine() {
        return 0;
    }

    public int getEndColumn() {
        return 0;
    }

    public int getEndLine() {
        return 0;
    }

    public int getBeginColumn() {
        return 0;
    }

    public int getBeginLine() {
        return 0;
    }

    public void backup(int amount) {

    }

    public char BeginToken() throws IOException {
        return 0;
    }

    public String GetImage() {
        return null;
    }

    public char[] GetSuffix(int len) {
        return new char[0];
    }

    public void Done() {

    }
}
