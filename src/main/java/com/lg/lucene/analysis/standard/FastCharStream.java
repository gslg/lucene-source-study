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
        int newPosition = bufferLength - tokenStart;

        if(tokenStart == 0){
            if(buffer == null){
                buffer = new char[2048];
            }else if(bufferLength == buffer.length){
                //扩容
                char[] newBuffer = new char[buffer.length * 2];
                System.arraycopy(buffer,0,newBuffer,0,bufferLength);
            }
        }else {
            System.arraycopy(buffer,tokenStart,buffer,0,newPosition);
        }

        bufferLength = newPosition;
        bufferPosition = newPosition;
        bufferStart += tokenStart;
        tokenStart = 0;

        int charsRead = input.read(buffer,newPosition,buffer.length-newPosition);

        if(charsRead == -1)
            throw new IOException("read past eof");
        else
            bufferLength += charsRead;

    }

    public final char readChar() throws IOException {
        if(bufferPosition >= bufferLength)
            refill();
        return buffer[bufferPosition++];
    }

    public int getColumn() {
        return bufferStart + bufferPosition;
    }

    public int getLine() {
        return 1;
    }

    public int getEndColumn() {
        return bufferStart + bufferPosition;
    }

    public int getEndLine() {
        return 1;
    }

    public int getBeginColumn() {
        return bufferStart + tokenStart;
    }

    public int getBeginLine() {
        return 1;
    }

    public void backup(int amount) {
        bufferPosition -= amount;
    }

    public char BeginToken() throws IOException {
        tokenStart = bufferPosition;
        return readChar();
    }

    public String GetImage() {
        return new String(buffer,tokenStart,bufferPosition - tokenStart);
    }

    public char[] GetSuffix(int len) {
        char[] value = new char[len];
        System.arraycopy(buffer,bufferPosition-len,value,0,len);
        return value;
    }

    public void Done() {
        try {
            input.close();
        } catch (IOException e) {
            System.err.println("Caught: " + e + "; ignoring.");
        }
    }
}
