package com.lg.lucene.analysis;

import com.lg.lucene.analysis.standard.StandardAnalyzer;
import junit.framework.TestCase;

import java.io.IOException;
import java.io.StringReader;

public class TestAnalyzers extends TestCase{

    public TestAnalyzers(String name){
        super(name);
    }

    public void assertAnalyzesTo(Analyzer a,String input,String[] output) throws IOException {
        TokenStream ts = a.tokenStream("dummy",new StringReader(input));
        for (int i = 0; i < output.length; i++) {
            Token t = ts.next();
            System.out.println(t.termText);
            assertNotNull(t);
            assertEquals(t.termText,output[i]);
        }

        assertNull(ts.next());
        ts.close();
    }

    public void testStandard() throws Exception{
        Analyzer a = new StandardAnalyzer();
        assertAnalyzesTo(a, "foo bar FOO BAR",
                new String[] { "foo", "bar", "foo", "bar" });
        System.out.println("*************************");
        assertAnalyzesTo(a, "foo      bar .  FOO <> BAR",
                new String[] { "foo", "bar", "foo", "bar" });
    }
}
