package org.mybatis.ext.template;

import java.util.List;

import org.mybatis.ext.data.ResultMap;

public class ViewAddTemplate {

    private String viewAddString;

    public ViewAddTemplate(List<ResultMap> resultMaps,String postUrl){
        setViewAddString(buildViewList(resultMaps,postUrl));
    }

    private String buildViewList(List<ResultMap> resultMaps,String postUrl) {
        if (resultMaps == null || resultMaps.size() == 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("<div>\n");
        buffer.append("  <form action=\""+postUrl+"\" method=\"post\">\n");
        buffer.append("    <table>\n");
        buffer.append("      <tr>\n");
        for (ResultMap obj : resultMaps) {
            buffer.append("        <td><input type=\"text\" name=\""+obj.getProp()+"\" value=\"$!{model."+obj.getProp()+"}\" placeholder=\""+obj.getProp()+"\"></td>\n");
        }
        buffer.append("        <td><input type=\"submit\" value=\"添加\"></td>\n");
        buffer.append("      </tr>\n");
        buffer.append("    </table>\n");
        buffer.append("  </form>\n");
        buffer.append("</div>\n");

      

        return buffer.toString();
    }

    public String getViewAddString() {
        return viewAddString;
    }

    public void setViewAddString(String viewListString) {
        this.viewAddString = viewListString;
    }
}
