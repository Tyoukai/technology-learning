package jSqlParser;


import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SelectItem;

import java.util.List;

/**
 * @Author: Tyoukai
 * @Date: 2023/7/4 10:56
 */
public class JSqlParserDemo {

    public static void main(String[] args) throws JSQLParserException {
        String sql = "select fund_account_id, count(1) num from t_report group by fund_account_id";
        Select select = (Select) CCJSqlParserUtil.parse(sql);
        SelectBody selectBody = select.getSelectBody();
        List<SelectItem> items = ((PlainSelect) selectBody).getSelectItems();
        System.out.println(selectBody);
    }
}
