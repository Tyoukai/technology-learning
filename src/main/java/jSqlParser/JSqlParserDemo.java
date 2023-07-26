package jSqlParser;


import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;

/**
 * @Author: Tyoukai
 * @Date: 2023/7/4 10:56
 */
public class JSqlParserDemo {

    public static void main(String[] args) throws JSQLParserException {
        String sql = "SELECT * FROM history_uint WHERE itemid='104913'";
        Select select = (Select) CCJSqlParserUtil.parse(sql);
        SelectBody selectBody = select.getSelectBody();
        List<SelectItem> items = ((PlainSelect) selectBody).getSelectItems();
        for (SelectItem item : items) {
            System.out.println(item.toString());
        }
        SelectItem item = items.get(0);
        item.accept(new SelectItemVisitorAdapter() {
            @Override
            public void visit(SelectExpressionItem item1) {
                System.out.println("item alias:" + item1.getAlias().getName());
            }
        });
//        System.out.println(selectBody);
    }
}
