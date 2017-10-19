package com.lg.lucene.analysis.standard;

import com.lg.lucene.analysis.Tokenizer;

import java.io.IOException;
import java.io.Reader;


public class StandardTokenizer extends Tokenizer implements StandardTokenizerConstants{

    public StandardTokenizerTokenManager token_source;
    public Token token,jj_nt;
    private int jj_ntk;
    private int jj_gen;
    final private int[] jj_la1 = new int[1];
    static private int[] jj_la1_0;
    private java.util.Vector jj_expentries = new java.util.Vector();
    private int[] jj_expentry;
    private int jj_kind = -1;

    static {
        jj_la1_0();
    }

    private static void jj_la1_0(){
        jj_la1_0 = new int[]{0x10ff,}; //4351
    }

    public StandardTokenizer(Reader reader){
        this(new FastCharStream(reader));
        this.input = reader;
    }

    public StandardTokenizer(CharStream stream){
        token_source = new StandardTokenizerTokenManager(stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 1; i++) {
            jj_la1[i] = -1;
        }
    }

    public StandardTokenizer(StandardTokenizerTokenManager tm){
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 1; i++) {
            jj_la1[i] = -1;
        }
    }

    public void ReInit(CharStream stream){
        token_source.ReInit(stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 1; i++) {
            jj_la1[i] = -1;
        }
    }

    public void ReInit(StandardTokenizerTokenManager tm){
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 1; i++) {
            jj_la1[i] = -1;
        }
    }

    final private Token jj_consume_token(int kind) throws ParseException{
        Token oldToken;
        if((oldToken = token).next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        if(token.kind == kind){
            jj_gen++;
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }

    public ParseException generateParseException() {
        jj_expentries.removeAllElements();
        boolean[] la1tokens = new boolean[15];
        for (int i = 0; i < 15; i++) {
            la1tokens[i] = false;
        }
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 1; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1<<j)) != 0) {
                        la1tokens[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 15; i++) {
            if (la1tokens[i]) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.addElement(jj_expentry);
            }
        }
        int[][] exptokseq = new int[jj_expentries.size()][];
        for (int i = 0; i < jj_expentries.size(); i++) {
            exptokseq[i] = (int[])jj_expentries.elementAt(i);
        }
        return new ParseException(token, exptokseq, tokenImage);
    }

    final private int jj_ntk() {
        if ((jj_nt=token.next) == null)
            return (jj_ntk = (token.next=token_source.getNextToken()).kind);
        else
            return (jj_ntk = jj_nt.kind);
    }

    final public com.lg.lucene.analysis.Token next() throws ParseException, IOException {
        Token token = null;
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case ALPHANUM:
                token = jj_consume_token(ALPHANUM);
                break;
            case APOSTROPHE:
                token = jj_consume_token(APOSTROPHE);
                break;
            case ACRONYM:
                token = jj_consume_token(ACRONYM);
                break;
            case COMPANY:
                token = jj_consume_token(COMPANY);
                break;
            case EMAIL:
                token = jj_consume_token(EMAIL);
                break;
            case HOST:
                token = jj_consume_token(HOST);
                break;
            case NUM:
                token = jj_consume_token(NUM);
                break;
            case CJK:
                token = jj_consume_token(CJK);
                break;
            case 0:
                token = jj_consume_token(0);
                break;
            default:
                jj_la1[0] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        if (token.kind == EOF) {
            {if (true) return null;}
        } else {
            {if (true) return
                    new com.lg.lucene.analysis.Token(token.image,
                            token.beginColumn,token.endColumn,
                            tokenImage[token.kind]);}
        }
        throw new Error("Missing return statement in function");
    }

}
