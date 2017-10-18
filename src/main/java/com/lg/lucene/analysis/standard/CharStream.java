package com.lg.lucene.analysis.standard;

import java.io.IOException;

/**
 * 该接口表示了一个包括行数和列数描述字符位置的字符流.同时也具有一定程度备份流的能力.
 *
 * 除了备份以外，其他的所有方法都可以以任何方式实现.
 * 备份正确的实现需要词法分析器(lexer)正确的操作.
 * 其余的方法都是用来获取信息，像行数，列数以及构成标识符不会被词法分析器（lexer）
 * 使用的字符串.
 * 因此他们的实现不会影响一般此法分析器的操作.
 *
 */
public interface CharStream {

    /**
     * 从选择的input中返回下一个字符.
     * 选择input的方法是该接口实现类的责任.
     * @return
     * @throws IOException
     */
    char readChar() throws IOException;

    /**
     * 返回最后读到的字符的列位置
     * @return
     */
    int getColumn();

    /**
     * 返回组后读到字符的航位置
     * @return
     */
    int getLine();

    /**
     * 返回当前Token的最后一个字符的列数（对应最后一次调用BeginToken）
     * @return
     */
    int getEndColumn();

    /**
     * 返回当前Token的最后一个字符的行数
     * @return
     */

    int getEndLine();

    int getBeginColumn();

    int getBeginLine();


    /**
     * 按数量步骤备份输入流.Lexer会调用这个方法，如果Lexer已经读取了一些字符，但是还不能用来陪陪
     * token(因为太长了).因此，他们可能再次使用它作为下一个token的前缀.因此应该由实现类来正确实现该方法.
     * @param amount
     */
    void backup(int amount);

    /**
     * 返回标志下一个标记开始的下一个字符。
     * 在这个方法的两次连续调用中，所有字符必须保持在缓冲区中，以便正确地实现备份
     * @return
     * @throws IOException
     */
    char BeginToken() throws IOException;

    /**
     * 返回由标志标记开始的字符到当前缓冲区位置的字符串。
     * 实现可以选择返回任何想返回的字符串.例如为了效率，返回一个null也是合法的实现
     * @return
     */
    String GetImage();
    /**
     * Returns an array of characters that make up the suffix of length 'len' for
     * the currently matched token. This is used to build up the matched string
     * for use in actions in the case of MORE. A simple and inefficient
     * implementation of this is as follows :
     *
     *   {
     *      String t = GetImage();
     *      return t.substring(t.length() - len, t.length()).toCharArray();
     *   }
     */
    char[] GetSuffix(int len);

    /**
     * The lexer calls this function to indicate that it is done with the stream
     * and hence implementations can free any resources held by this class.
     * Again, the body of this function can be just empty and it will not
     * affect the lexer's operation.
     */
    void Done();

}
