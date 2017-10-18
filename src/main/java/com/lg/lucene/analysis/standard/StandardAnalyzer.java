package com.lg.lucene.analysis.standard;

import com.lg.lucene.analysis.Analyzer;

import java.util.Hashtable;

public class StandardAnalyzer extends Analyzer {
    private Hashtable stopTable;

    public static final String[] STOP_WORDS = {
            "a", "and", "are", "as", "at", "be", "but", "by",
            "for", "if", "in", "into", "is", "it",
            "no", "not", "of", "on", "or", "s", "such",
            "t", "that", "the", "their", "then", "there", "these",
            "they", "this", "to", "was", "will", "with"
    };

    public StandardAnalyzer(String[] topWords){

    }
}
