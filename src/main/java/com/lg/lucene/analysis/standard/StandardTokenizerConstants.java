package com.lg.lucene.analysis.standard;

/**
 * Created by sclg1 on 2017/10/18.
 */
public interface StandardTokenizerConstants {
    int EOF = 0;
    int ALPHANUM = 1;
    int APOSTROPHE = 2;
    int ACRONYM = 3;
    int COMPANY = 4;
    int EMAIL = 5;
    int HOST = 6;
    int NUM = 7;
    int P = 8;
    int HAS_DIGIT = 9;
    int ALPHA = 10;
    int LETTER = 11;
    int CJK = 12;
    int DIGIT = 13;
    int NOISE = 14;

    int DEFAULT = 0;

    String[] tokenImage = {
            "<EOF>",
            "<ALPHANUM>",
            "<APOSTROPHE>",
            "<ACRONYM>",
            "<COMPANY>",
            "<EMAIL>",
            "<HOST>",
            "<NUM>",
            "<P>",
            "<HAS_DIGIT>",
            "<ALPHA>",
            "<LETTER>",
            "<CJK>",
            "<DIGIT>",
            "<NOISE>",
    };
}
